package com.tencent.tav.decoder;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.codec.MediaCodecAnalyse;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tav.core.ExportRuntimeException;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import java.nio.ByteBuffer;

public class MediaCodecAudioEncoder
  implements AssetWriterAudioEncoder
{
  public static final String OUTPUT_AUDIO_MIME_TYPE = "audio/mp4a-latm";
  public static final String SCENE = "audio-encode";
  private static final String TAG = "MediaCodecAudioEncoder";
  private static final long WAIT_TRANSIENT_MS = 20L;
  public static final long WRITER_FINISH = -1L;
  private volatile MediaCodec.BufferInfo audioBufferInfo;
  private volatile MediaFormat audioEncodeFormat;
  private MediaCodecAnalyse audioEncoder;
  private long audioPresentationTimeUs;
  private ExportConfig encodeOption;
  private boolean isEncodeToEndOfStream;
  private IMediaMuxer muxer;
  
  public MediaCodecAudioEncoder()
  {
    AppMethodBeat.i(216045);
    this.audioEncodeFormat = null;
    this.audioBufferInfo = new MediaCodec.BufferInfo();
    this.isEncodeToEndOfStream = false;
    AppMethodBeat.o(216045);
  }
  
  private int dequeueInputBuffer(MediaCodecAnalyse paramMediaCodecAnalyse)
  {
    AppMethodBeat.i(216076);
    try
    {
      int i = paramMediaCodecAnalyse.dequeueInputBuffer(1000L);
      AppMethodBeat.o(216076);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e("MediaCodecAudioEncoder", "dequeueInputBuffer e = ", localException);
        if ((21 > Build.VERSION.SDK_INT) || (!(localException instanceof MediaCodec.CodecException))) {
          break;
        }
        if (23 <= Build.VERSION.SDK_INT) {
          Logger.e("MediaCodecAudioEncoder", "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (!((MediaCodec.CodecException)localException).isTransient()) {
          break;
        }
        waitTime(20L);
      }
      AppMethodBeat.o(216076);
      throw localException;
    }
    catch (Error localError)
    {
      label21:
      break label21;
    }
  }
  
  private int dequeueOutputBuffer(MediaCodecAnalyse paramMediaCodecAnalyse, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(216069);
    try
    {
      int i = paramMediaCodecAnalyse.dequeueOutputBuffer(paramBufferInfo, 1000L);
      AppMethodBeat.o(216069);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e("MediaCodecAudioEncoder", "dequeueOutputBuffer e = ", localException);
        if ((Build.VERSION.SDK_INT < 21) || (!(localException instanceof MediaCodec.CodecException))) {
          break;
        }
        if (23 <= Build.VERSION.SDK_INT) {
          Logger.e("MediaCodecAudioEncoder", "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (!((MediaCodec.CodecException)localException).isTransient()) {
          break;
        }
        waitTime(20L);
      }
      AppMethodBeat.o(216069);
      throw localException;
    }
  }
  
  private ByteBuffer getInputBuffer(MediaCodecAnalyse paramMediaCodecAnalyse, int paramInt)
  {
    AppMethodBeat.i(216086);
    try
    {
      ByteBuffer localByteBuffer = DecoderUtils.getInputBuffer(paramMediaCodecAnalyse, paramInt);
      AppMethodBeat.o(216086);
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e("MediaCodecAudioEncoder", "getInputBuffer", localException);
        if ((Build.VERSION.SDK_INT < 21) || (!(localException instanceof MediaCodec.CodecException))) {
          break;
        }
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e("MediaCodecAudioEncoder", "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (!((MediaCodec.CodecException)localException).isTransient()) {
          break;
        }
        waitTime(20L);
      }
      AppMethodBeat.o(216086);
      throw localException;
    }
    catch (Error localError)
    {
      label19:
      break label19;
    }
  }
  
  private ByteBuffer getOutputBuffer(MediaCodecAnalyse paramMediaCodecAnalyse, int paramInt)
  {
    AppMethodBeat.i(216094);
    try
    {
      ByteBuffer localByteBuffer = DecoderUtils.getOutputBuffer(paramMediaCodecAnalyse, paramInt);
      AppMethodBeat.o(216094);
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e("MediaCodecAudioEncoder", "getOutputBuffer", localException);
        if ((Build.VERSION.SDK_INT < 21) || (!(localException instanceof MediaCodec.CodecException))) {
          break;
        }
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e("MediaCodecAudioEncoder", "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (!((MediaCodec.CodecException)localException).isTransient()) {
          break;
        }
        waitTime(20L);
      }
      AppMethodBeat.o(216094);
      throw localException;
    }
    catch (Error localError)
    {
      label19:
      break label19;
    }
  }
  
  private void queueInputBuffer(MediaCodecAnalyse paramMediaCodecAnalyse, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    AppMethodBeat.i(216116);
    try
    {
      paramMediaCodecAnalyse.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
      AppMethodBeat.o(216116);
      return;
    }
    catch (Exception localException)
    {
      Logger.e("MediaCodecAudioEncoder", "queueInputBuffer", localException);
      if ((Build.VERSION.SDK_INT >= 21) && ((localException instanceof MediaCodec.CodecException)))
      {
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e("MediaCodecAudioEncoder", "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (((MediaCodec.CodecException)localException).isTransient())
        {
          waitTime(20L);
          queueInputBuffer(paramMediaCodecAnalyse, paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
        }
      }
      AppMethodBeat.o(216116);
      throw localException;
    }
    catch (Error localError)
    {
      label25:
      break label25;
    }
  }
  
  private void releaseOutputBuffer(MediaCodecAnalyse paramMediaCodecAnalyse, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(216104);
    try
    {
      paramMediaCodecAnalyse.releaseOutputBuffer(paramInt, paramBoolean);
      AppMethodBeat.o(216104);
      return;
    }
    catch (Exception localException)
    {
      Logger.e("MediaCodecAudioEncoder", "releaseOutputBuffer", localException);
      if ((Build.VERSION.SDK_INT >= 21) && ((localException instanceof MediaCodec.CodecException)))
      {
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e("MediaCodecAudioEncoder", "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (((MediaCodec.CodecException)localException).isTransient())
        {
          waitTime(20L);
          releaseOutputBuffer(paramMediaCodecAnalyse, paramInt, paramBoolean);
        }
      }
      AppMethodBeat.o(216104);
      throw localException;
    }
    catch (Error localError)
    {
      label19:
      break label19;
    }
  }
  
  private boolean validAndCorrectBufferInfo(MediaCodec.BufferInfo paramBufferInfo)
  {
    return (paramBufferInfo.size > 0) && ((paramBufferInfo.flags & 0x4) == 0);
  }
  
  private void waitTime(long paramLong)
  {
    AppMethodBeat.i(216121);
    try
    {
      wait(paramLong);
      AppMethodBeat.o(216121);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      AppMethodBeat.o(216121);
    }
  }
  
  public boolean endWriteAudioSample()
  {
    AppMethodBeat.i(216151);
    try
    {
      int i = dequeueInputBuffer(this.audioEncoder);
      if (i >= 0)
      {
        queueInputBuffer(this.audioEncoder, i, 0, 0, 0L, 4);
        AppMethodBeat.o(216151);
        return true;
      }
    }
    finally
    {
      Logger.e("MediaCodecAudioEncoder", "endWriteAudioSample failed", localThrowable);
      AppMethodBeat.o(216151);
    }
    return false;
  }
  
  public MediaFormat getEncodeFormat()
  {
    return this.audioEncodeFormat;
  }
  
  public long getEncodePresentationTimeUs()
  {
    return this.audioPresentationTimeUs;
  }
  
  public boolean isEncodeToEndOfStream()
  {
    return this.isEncodeToEndOfStream;
  }
  
  public boolean prepare(ExportConfig paramExportConfig, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(216129);
    this.encodeOption = paramExportConfig;
    try
    {
      Logger.i("MediaCodecAudioEncoder", "prepareAudioEncoder: format = ".concat(String.valueOf(paramMediaFormat)));
      this.audioEncoder = MediaCodecAnalyse.createEncoderByType("audio/mp4a-latm", "audio-encode");
      this.audioEncoder.configure(paramMediaFormat, null, null, 1);
      AppMethodBeat.o(216129);
      return true;
    }
    catch (Exception paramExportConfig)
    {
      paramExportConfig = new ExportRuntimeException(new ExportErrorStatus(-104, paramExportConfig, paramMediaFormat.toString()));
      AppMethodBeat.o(216129);
      throw paramExportConfig;
    }
  }
  
  public void release()
  {
    AppMethodBeat.i(216207);
    if (this.audioEncoder != null) {
      this.audioEncoder.release();
    }
    AppMethodBeat.o(216207);
  }
  
  public void setMediaMuxer(IMediaMuxer paramIMediaMuxer)
  {
    this.muxer = paramIMediaMuxer;
  }
  
  public boolean start()
  {
    AppMethodBeat.i(216143);
    this.audioEncoder.start();
    AppMethodBeat.o(216143);
    return true;
  }
  
  public void stop()
  {
    AppMethodBeat.i(216198);
    if (this.audioEncoder != null) {
      this.audioEncoder.stop();
    }
    AppMethodBeat.o(216198);
  }
  
  public boolean writeAudioFrame(boolean paramBoolean)
  {
    boolean bool3 = false;
    AppMethodBeat.i(216175);
    if (this.muxer != null) {}
    for (boolean bool2 = this.muxer.isMuxerStarted();; bool2 = false)
    {
      int i;
      boolean bool1;
      if ((bool2) || (this.audioEncodeFormat == null))
      {
        i = dequeueOutputBuffer(this.audioEncoder, this.audioBufferInfo);
        if (i == -1)
        {
          bool1 = bool3;
          if (!paramBoolean) {
            bool1 = true;
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(216175);
        return bool1;
        if (i == -2)
        {
          this.audioEncodeFormat = this.audioEncoder.getOutputFormat();
          Logger.i("MediaCodecAudioEncoder", "audio format changed " + this.audioEncodeFormat);
          bool1 = bool3;
        }
        else
        {
          bool1 = bool3;
          if (i >= 0)
          {
            ByteBuffer localByteBuffer = getOutputBuffer(this.audioEncoder, i);
            if ((this.audioBufferInfo.flags & 0x2) != 0) {
              this.audioBufferInfo.size = 0;
            }
            if (Build.VERSION.SDK_INT >= 19)
            {
              localByteBuffer.position(this.audioBufferInfo.offset);
              localByteBuffer.limit(this.audioBufferInfo.offset + this.audioBufferInfo.size);
            }
            if ((validAndCorrectBufferInfo(this.audioBufferInfo)) && (bool2)) {}
            try
            {
              MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
              localBufferInfo.set(this.audioBufferInfo.offset, this.audioBufferInfo.size, this.audioBufferInfo.presentationTimeUs, this.audioBufferInfo.flags);
              if (this.audioBufferInfo.presentationTimeUs >= 0L) {
                this.muxer.writeSampleDataTime(false, CMTime.fromSeconds((float)this.audioBufferInfo.presentationTimeUs));
              }
              this.muxer.writeSampleData(this.muxer.audioTrackIndex(), localByteBuffer, localBufferInfo);
              Logger.v("MediaCodecAudioEncoder", "writeAudioFrame:  " + this.audioBufferInfo.presentationTimeUs);
              this.audioPresentationTimeUs = this.audioBufferInfo.presentationTimeUs;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                Logger.e("MediaCodecAudioEncoder", "writeAudioFrame: ", localException);
              }
            }
            releaseOutputBuffer(this.audioEncoder, i, false);
            bool1 = bool3;
            if ((this.audioBufferInfo.flags & 0x4) != 0)
            {
              Logger.i("MediaCodecAudioEncoder", "writeAudioFrame: BUFFER_FLAG_END_OF_STREAM");
              this.audioPresentationTimeUs = -1L;
              this.isEncodeToEndOfStream = true;
              bool1 = true;
              continue;
              bool1 = bool3;
              if (!paramBoolean) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
  }
  
  public long writeAudioSample(long paramLong, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(216161);
    int i = paramByteBuffer.position();
    int k = paramByteBuffer.limit();
    int j = dequeueInputBuffer(this.audioEncoder);
    if (j >= 0)
    {
      ByteBuffer localByteBuffer = getInputBuffer(this.audioEncoder, j);
      k = Math.min(k - i, localByteBuffer.capacity());
      paramByteBuffer.limit(i + k);
      paramByteBuffer.position(i);
      localByteBuffer.put(paramByteBuffer);
      queueInputBuffer(this.audioEncoder, j, 0, k, paramLong, 0);
      paramByteBuffer.position(i + k);
      paramLong = DecoderUtils.getAudioDuration(k, this.encodeOption.getAudioChannelCount(), this.encodeOption.getAudioSampleRateHz());
      AppMethodBeat.o(216161);
      return paramLong;
    }
    AppMethodBeat.o(216161);
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.MediaCodecAudioEncoder
 * JD-Core Version:    0.7.0.1
 */