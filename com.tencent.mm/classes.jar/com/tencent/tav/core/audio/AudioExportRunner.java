package com.tencent.tav.core.audio;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.logger.Logger;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

public class AudioExportRunner
  implements Runnable
{
  static final int EDGE_DURATION_MS = 200;
  private static final int MAX_INPUT_SIZE = 8192;
  private static String MIME = "audio/mp4a-latm";
  static final int PACKET_FPS = 44;
  public static final String TAG = "AudioEncoder";
  private static final long WAIT_TRANSIENT_MS = 20L;
  private boolean enOfAudioInputStream;
  IAudioSource<? extends IDecoderTrack> mAudioAsset;
  IDecoderTrack mAudioDecoder;
  private MediaCodec mAudioEncoder;
  private ExportCallback mCallback;
  private boolean mCancel;
  private int mChannelCount;
  private FileOutputStream mFos;
  private String mMime;
  private int mRate;
  private int mSampleRate;
  private String mSavePath;
  CMTimeRange mSelectedTimeRange;
  private int mStatus;
  private AtomicBoolean mStop;
  private Thread mThread;
  
  AudioExportRunner(IAudioSource<? extends IDecoderTrack> paramIAudioSource, CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(215470);
    this.mMime = MIME;
    this.mRate = 128000;
    this.mSampleRate = 44100;
    this.mChannelCount = 1;
    this.mStatus = 0;
    this.mStop = new AtomicBoolean(false);
    this.mCancel = false;
    this.enOfAudioInputStream = false;
    this.mAudioAsset = paramIAudioSource;
    if (paramCMTimeRange == null)
    {
      this.mSelectedTimeRange = new CMTimeRange(CMTime.CMTimeZero, paramIAudioSource.getDuration());
      AppMethodBeat.o(215470);
      return;
    }
    this.mSelectedTimeRange = paramCMTimeRange;
    AppMethodBeat.o(215470);
  }
  
  private int dequeueInputBuffer(MediaCodec paramMediaCodec)
  {
    AppMethodBeat.i(215515);
    try
    {
      int i = paramMediaCodec.dequeueInputBuffer(1000L);
      AppMethodBeat.o(215515);
      return i;
    }
    catch (Exception localException)
    {
      do
      {
        Logger.e("AudioEncoder", "dequeueInputBuffer e = ", localException);
        if ((21 > Build.VERSION.SDK_INT) || (!(localException instanceof MediaCodec.CodecException))) {
          break;
        }
        if (23 <= Build.VERSION.SDK_INT) {
          Logger.e("AudioEncoder", "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
      } while (((MediaCodec.CodecException)localException).isTransient());
      AppMethodBeat.o(215515);
      throw localException;
    }
    catch (Error localError)
    {
      label21:
      break label21;
    }
  }
  
  private ByteBuffer getInputBuffer(int paramInt)
  {
    AppMethodBeat.i(215499);
    if (Build.VERSION.SDK_INT >= 21)
    {
      localByteBuffer = this.mAudioEncoder.getInputBuffer(paramInt);
      AppMethodBeat.o(215499);
      return localByteBuffer;
    }
    ByteBuffer localByteBuffer = this.mAudioEncoder.getInputBuffers()[paramInt];
    AppMethodBeat.o(215499);
    return localByteBuffer;
  }
  
  private ByteBuffer getOutputBuffer(int paramInt)
  {
    AppMethodBeat.i(215506);
    if (Build.VERSION.SDK_INT >= 21)
    {
      localByteBuffer = this.mAudioEncoder.getOutputBuffer(paramInt);
      AppMethodBeat.o(215506);
      return localByteBuffer;
    }
    ByteBuffer localByteBuffer = this.mAudioEncoder.getOutputBuffers()[paramInt];
    AppMethodBeat.o(215506);
    return localByteBuffer;
  }
  
  private void initAudioDecoder()
  {
    AppMethodBeat.i(215482);
    try
    {
      this.mAudioDecoder = this.mAudioAsset.getSourceAudioDecoder(this.mSelectedTimeRange);
      this.mAudioDecoder.start();
      CMTime localCMTime = this.mSelectedTimeRange.getStart();
      IDecoderTrack localIDecoderTrack = this.mAudioDecoder;
      if (localCMTime.bigThan(CMTime.CMTimeZero)) {}
      for (localCMTime = localCMTime.sub(CMTime.fromMs(200L));; localCMTime = CMTime.CMTimeZero)
      {
        localIDecoderTrack.seekTo(localCMTime, false, false);
        return;
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(215482);
    }
  }
  
  private void initAudioEncoder()
  {
    AppMethodBeat.i(215489);
    MediaFormat localMediaFormat = MediaFormat.createAudioFormat(MIME, this.mSampleRate, this.mChannelCount);
    localMediaFormat.setInteger("aac-profile", 2);
    localMediaFormat.setInteger("bitrate", this.mRate);
    localMediaFormat.setInteger("max-input-size", 8192);
    this.mAudioEncoder = MediaCodec.createEncoderByType(this.mMime);
    this.mAudioEncoder.configure(localMediaFormat, null, null, 1);
    AppMethodBeat.o(215489);
  }
  
  private boolean isFinish(MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(215582);
    if (paramBufferInfo.presentationTimeUs >= this.mSelectedTimeRange.getEndUs())
    {
      AppMethodBeat.o(215582);
      return true;
    }
    AppMethodBeat.o(215582);
    return false;
  }
  
  private boolean isValidBuffer(MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(215588);
    if ((paramBufferInfo.size > 0) && (paramBufferInfo.presentationTimeUs >= this.mSelectedTimeRange.getStartUs()) && (paramBufferInfo.presentationTimeUs <= this.mSelectedTimeRange.getEndUs()) && ((paramBufferInfo.flags & 0x2) == 0))
    {
      AppMethodBeat.o(215588);
      return true;
    }
    AppMethodBeat.o(215588);
    return false;
  }
  
  private void notifyProgressUpdate(long paramLong)
  {
    AppMethodBeat.i(215596);
    if ((this.mCallback != null) && (this.mSelectedTimeRange != null))
    {
      long l = this.mSelectedTimeRange.getStartUs();
      this.mCallback.onProgress(this.mStatus, (float)(paramLong - l) * 1.0F / (float)this.mSelectedTimeRange.getDurationUs());
    }
    AppMethodBeat.o(215596);
  }
  
  private void queueInputBuffer(MediaCodec paramMediaCodec, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    AppMethodBeat.i(215527);
    try
    {
      paramMediaCodec.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
      AppMethodBeat.o(215527);
      return;
    }
    catch (Exception localException)
    {
      Logger.e("AudioEncoder", "queueInputBuffer", localException);
      if ((Build.VERSION.SDK_INT >= 21) && ((localException instanceof MediaCodec.CodecException)))
      {
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e("AudioEncoder", "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (((MediaCodec.CodecException)localException).isTransient())
        {
          waitTime(20L);
          queueInputBuffer(paramMediaCodec, paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
        }
      }
      AppMethodBeat.o(215527);
      throw localException;
    }
    catch (Error localError)
    {
      label27:
      break label27;
    }
  }
  
  private void readNextSample()
  {
    AppMethodBeat.i(215539);
    Object localObject = this.mAudioDecoder.readSample();
    CMTime localCMTime = ((CMSampleBuffer)localObject).getTime();
    if ((localCMTime.value > 0L) && (localCMTime.getTimeUs() <= this.mSelectedTimeRange.getEndUs()))
    {
      localObject = ((CMSampleBuffer)localObject).getSampleByteBuffer();
      i = ((ByteBuffer)localObject).limit() - ((ByteBuffer)localObject).position();
      byte[] arrayOfByte = new byte[i];
      ((ByteBuffer)localObject).get(arrayOfByte);
      writeAudioSample(localCMTime, i, arrayOfByte);
      AppMethodBeat.o(215539);
      return;
    }
    long l = ((CMSampleBuffer)localObject).getState().getStateCode();
    if ((l >= -1L) && (!this.enOfAudioInputStream))
    {
      signalEndOfAudioStream();
      this.enOfAudioInputStream = true;
    }
    if (l < -1L) {}
    for (int i = 255;; i = this.mStatus)
    {
      this.mStatus = i;
      AppMethodBeat.o(215539);
      return;
    }
  }
  
  private void signalEndOfAudioStream()
  {
    AppMethodBeat.i(215532);
    try
    {
      Logger.d("AudioEncoder", "signalEndOfAudioStream: ");
      int i = dequeueInputBuffer(this.mAudioEncoder);
      if (i >= 0) {
        queueInputBuffer(this.mAudioEncoder, i, 0, 0, 0L, 4);
      }
      AppMethodBeat.o(215532);
      return;
    }
    finally
    {
      Logger.e("AudioEncoder", "signalEndOfAudioStream failed", localThrowable);
      AppMethodBeat.o(215532);
    }
  }
  
  /* Error */
  private void stop()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 373
    //   5: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 85	com/tencent/tav/core/audio/AudioExportRunner:mStop	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   12: invokevirtual 375	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   15: ifne +48 -> 63
    //   18: aload_0
    //   19: getfield 85	com/tencent/tav/core/audio/AudioExportRunner:mStop	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   22: iconst_1
    //   23: invokevirtual 378	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   26: aload_0
    //   27: getfield 209	com/tencent/tav/core/audio/AudioExportRunner:mAudioDecoder	Lcom/tencent/tav/decoder/IDecoderTrack;
    //   30: invokeinterface 381 1 0
    //   35: aload_0
    //   36: getfield 188	com/tencent/tav/core/audio/AudioExportRunner:mAudioEncoder	Landroid/media/MediaCodec;
    //   39: invokevirtual 383	android/media/MediaCodec:stop	()V
    //   42: aload_0
    //   43: getfield 188	com/tencent/tav/core/audio/AudioExportRunner:mAudioEncoder	Landroid/media/MediaCodec;
    //   46: invokevirtual 384	android/media/MediaCodec:release	()V
    //   49: aload_0
    //   50: getfield 386	com/tencent/tav/core/audio/AudioExportRunner:mFos	Ljava/io/FileOutputStream;
    //   53: invokevirtual 391	java/io/FileOutputStream:flush	()V
    //   56: aload_0
    //   57: getfield 386	com/tencent/tav/core/audio/AudioExportRunner:mFos	Ljava/io/FileOutputStream;
    //   60: invokevirtual 394	java/io/FileOutputStream:close	()V
    //   63: aload_0
    //   64: aload_0
    //   65: getfield 110	com/tencent/tav/core/audio/AudioExportRunner:mSelectedTimeRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   68: invokevirtual 273	com/tencent/tav/coremedia/CMTimeRange:getEndUs	()J
    //   71: invokespecial 396	com/tencent/tav/core/audio/AudioExportRunner:notifyProgressUpdate	(J)V
    //   74: aload_0
    //   75: iconst_0
    //   76: putfield 87	com/tencent/tav/core/audio/AudioExportRunner:mCancel	Z
    //   79: ldc_w 373
    //   82: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aload_0
    //   86: monitorexit
    //   87: return
    //   88: astore_1
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: athrow
    //   93: astore_1
    //   94: goto -31 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	AudioExportRunner
    //   88	4	1	localObject	Object
    //   93	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	26	88	finally
    //   26	63	88	finally
    //   63	85	88	finally
    //   26	63	93	java/lang/Exception
  }
  
  private void waitTime(long paramLong)
  {
    AppMethodBeat.i(215522);
    try
    {
      wait(paramLong);
      AppMethodBeat.o(215522);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      AppMethodBeat.o(215522);
    }
  }
  
  private void write(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215572);
    if (this.mFos == null) {
      this.mFos = new FileOutputStream(this.mSavePath);
    }
    this.mFos.write(paramArrayOfByte);
    AppMethodBeat.o(215572);
  }
  
  private void writeAudioSample()
  {
    AppMethodBeat.i(215563);
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    for (;;)
    {
      int i = this.mAudioEncoder.dequeueOutputBuffer(localBufferInfo, 0L);
      if ((i >= 0) && (isValidBuffer(localBufferInfo)) && (this.mStatus != 2))
      {
        if ((localBufferInfo.flags & 0x4) != 0)
        {
          Logger.d("AudioEncoder", "writeAudioFrame: BUFFER_FLAG_END_OF_STREAM ");
          this.mStatus = 2;
        }
        ByteBuffer localByteBuffer = getOutputBuffer(i);
        localByteBuffer.position(localBufferInfo.offset);
        byte[] arrayOfByte = new byte[localBufferInfo.size + 7];
        localByteBuffer.get(arrayOfByte, 7, localBufferInfo.size);
        EncoderUtils.addADTStoPacket(arrayOfByte, this.mChannelCount);
        Logger.v("AudioEncoder", "dequeue finish - " + localBufferInfo.presentationTimeUs + "--" + localBufferInfo.flags + " -- " + localBufferInfo.size + "  -  " + i + " endUs = " + this.mSelectedTimeRange.getEndUs());
        write(arrayOfByte);
        this.mAudioEncoder.releaseOutputBuffer(i, false);
        if (this.mStatus != 2) {
          notifyProgressUpdate(localBufferInfo.presentationTimeUs);
        }
      }
      while (i < 0)
      {
        AppMethodBeat.o(215563);
        return;
        notifyProgressUpdate(this.mSelectedTimeRange.getEndUs());
        continue;
        if (isFinish(localBufferInfo))
        {
          this.mStatus = 2;
        }
        else if ((i != -1) && (i != -2))
        {
          if ((localBufferInfo.flags & 0x4) != 0)
          {
            Logger.d("AudioEncoder", "writeAudioFrame: BUFFER_FLAG_END_OF_STREAM " + localBufferInfo.size + "/" + localBufferInfo.presentationTimeUs);
            this.mStatus = 2;
          }
          this.mAudioEncoder.releaseOutputBuffer(i, false);
        }
      }
    }
  }
  
  private void writeAudioSample(CMTime paramCMTime, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215550);
    int i = 0;
    while (paramInt - i > 0)
    {
      int j = this.mAudioEncoder.dequeueInputBuffer(-1L);
      if (j >= 0)
      {
        ByteBuffer localByteBuffer = getInputBuffer(j);
        localByteBuffer.clear();
        int k = Math.min(localByteBuffer.capacity(), paramInt);
        localByteBuffer.put(paramArrayOfByte, i, k);
        this.mAudioEncoder.queueInputBuffer(j, 0, k, paramCMTime.getTimeUs(), 1);
        i += k;
      }
    }
    AppMethodBeat.o(215550);
  }
  
  public void cancel()
  {
    try
    {
      this.mCancel = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getRate()
  {
    return this.mRate;
  }
  
  public int getSampleRate()
  {
    return this.mSampleRate;
  }
  
  public String getSavePath()
  {
    return this.mSavePath;
  }
  
  public CMTimeRange getSelectedTimeRange()
  {
    return this.mSelectedTimeRange;
  }
  
  public void prepare()
  {
    AppMethodBeat.i(215651);
    initAudioDecoder();
    initAudioEncoder();
    AppMethodBeat.o(215651);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc_w 493
    //   3: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 18
    //   8: ldc_w 495
    //   11: aload_0
    //   12: invokestatic 501	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   15: invokevirtual 505	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokestatic 367	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: getfield 78	com/tencent/tav/core/audio/AudioExportRunner:mStatus	I
    //   25: iconst_1
    //   26: if_icmpgt +32 -> 58
    //   29: aload_0
    //   30: getfield 87	com/tencent/tav/core/audio/AudioExportRunner:mCancel	Z
    //   33: ifne +25 -> 58
    //   36: aload_0
    //   37: invokespecial 507	com/tencent/tav/core/audio/AudioExportRunner:readNextSample	()V
    //   40: aload_0
    //   41: invokespecial 509	com/tencent/tav/core/audio/AudioExportRunner:writeAudioSample	()V
    //   44: goto -23 -> 21
    //   47: astore_1
    //   48: aload_0
    //   49: sipush 255
    //   52: putfield 78	com/tencent/tav/core/audio/AudioExportRunner:mStatus	I
    //   55: goto -34 -> 21
    //   58: aload_0
    //   59: getfield 87	com/tencent/tav/core/audio/AudioExportRunner:mCancel	Z
    //   62: ifeq +8 -> 70
    //   65: aload_0
    //   66: iconst_4
    //   67: putfield 78	com/tencent/tav/core/audio/AudioExportRunner:mStatus	I
    //   70: ldc 18
    //   72: new 146	java/lang/StringBuilder
    //   75: dup
    //   76: ldc_w 511
    //   79: invokespecial 151	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   82: aload_0
    //   83: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   86: ldc_w 516
    //   89: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_0
    //   93: getfield 78	com/tencent/tav/core/audio/AudioExportRunner:mStatus	I
    //   96: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 367	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload_0
    //   106: invokespecial 517	com/tencent/tav/core/audio/AudioExportRunner:stop	()V
    //   109: ldc_w 493
    //   112: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	AudioExportRunner
    //   47	1	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   36	44	47	finally
  }
  
  public void setAsset(IAudioSource<? extends IDecoderTrack> paramIAudioSource)
  {
    this.mAudioAsset = paramIAudioSource;
  }
  
  public void setCallback(ExportCallback paramExportCallback)
  {
    this.mCallback = paramExportCallback;
  }
  
  public void setMime(String paramString)
  {
    this.mMime = paramString;
  }
  
  public void setRate(int paramInt)
  {
    this.mRate = paramInt;
  }
  
  public void setSampleRate(int paramInt)
  {
    this.mSampleRate = paramInt;
  }
  
  public void setSavePath(String paramString)
  {
    this.mSavePath = paramString;
  }
  
  public void setSelectedTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.mSelectedTimeRange = paramCMTimeRange;
  }
  
  public void start()
  {
    try
    {
      AppMethodBeat.i(215657);
      if (this.mThread == null)
      {
        this.mAudioEncoder.start();
        this.mThread = new Thread(this);
        this.mThread.start();
        this.mStop.set(false);
        this.mCancel = false;
        this.enOfAudioInputStream = false;
        this.mStatus = 1;
      }
      AppMethodBeat.o(215657);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.audio.AudioExportRunner
 * JD-Core Version:    0.7.0.1
 */