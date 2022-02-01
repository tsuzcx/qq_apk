package com.tencent.rtmp.sharp.jni;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.nio.ByteBuffer;

public class AudioDecoder
{
  private static final String TAG = "AudioDecoder";
  boolean IsTenFramesReady = false;
  int channels = 0;
  private boolean codeOver = true;
  private RingBuffer decRingBuffer = null;
  private MediaCodec.BufferInfo decodeBufferInfo = null;
  private ByteBuffer[] decodeInputBuffers = null;
  private ByteBuffer[] decodeOutputBuffers = null;
  private long fileTotalMs = 0L;
  int m_nIndex = 0;
  private MediaCodec mediaDecode = null;
  private MediaExtractor mediaExtractor = null;
  int nFirstThreeFrameInfo = 3;
  int nFrameSize = 3840;
  private OnCompleteListener onCompleteListener = null;
  private OnProgressListener onProgressListener = null;
  int sampleRate = 0;
  private String srcPath;
  
  private int initMediaDecode(int paramInt)
  {
    AppMethodBeat.i(13905);
    try
    {
      this.mediaExtractor = new MediaExtractor();
      this.mediaExtractor.setDataSource(this.srcPath);
      if (this.mediaExtractor.getTrackCount() > 1)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "m_nIndex: " + this.m_nIndex + " initMediaDecode mediaExtractor container video, getTrackCount: " + this.mediaExtractor.getTrackCount());
        }
        this.codeOver = true;
        AppMethodBeat.o(13905);
        return -2;
      }
      int i = 0;
      for (;;)
      {
        if (i < this.mediaExtractor.getTrackCount())
        {
          MediaFormat localMediaFormat = this.mediaExtractor.getTrackFormat(i);
          String str = localMediaFormat.getString("mime");
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "m_nIndex: " + this.m_nIndex + " initMediaDecode mediaExtractor audio type:" + str);
          }
          if (!str.startsWith("audio/mpeg")) {
            break label399;
          }
          this.mediaExtractor.selectTrack(i);
          this.mediaDecode = MediaCodec.createDecoderByType(str);
          this.mediaDecode.configure(localMediaFormat, null, null, 0);
          this.sampleRate = localMediaFormat.getInteger("sample-rate");
          this.channels = localMediaFormat.getInteger("channel-count");
          this.fileTotalMs = (localMediaFormat.getLong("durationUs") / 1000L);
          this.nFrameSize = (this.sampleRate * this.channels * 2 * 20 / 1000);
          this.decRingBuffer = new RingBuffer(this.nFrameSize * paramInt);
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "m_nIndex: " + this.m_nIndex + " initMediaDecode open succeed, mp3 format:(" + this.sampleRate + "," + this.channels + "), fileTotalMs:" + this.fileTotalMs + "ms RingBufferFrame:" + paramInt);
          }
        }
        if (this.mediaDecode != null) {
          break;
        }
        new StringBuilder("m_nIndex: ").append(this.m_nIndex).append(" initMediaDecode create mediaDecode failed");
        this.codeOver = true;
        AppMethodBeat.o(13905);
        return -1;
        label399:
        i += 1;
      }
      if (this.decRingBuffer != null) {
        break label470;
      }
    }
    catch (IOException localIOException)
    {
      TXCLog.e("AudioDecoder", "init media decode failed.", localIOException);
      this.codeOver = true;
      AppMethodBeat.o(13905);
      return -1;
    }
    new StringBuilder("m_nIndex: ").append(this.m_nIndex).append(" initMediaDecode create decRingBuffer failed");
    this.codeOver = true;
    AppMethodBeat.o(13905);
    return -1;
    label470:
    this.mediaDecode.start();
    this.decodeInputBuffers = this.mediaDecode.getInputBuffers();
    this.decodeOutputBuffers = this.mediaDecode.getOutputBuffers();
    this.decodeBufferInfo = new MediaCodec.BufferInfo();
    this.codeOver = false;
    this.IsTenFramesReady = false;
    this.nFirstThreeFrameInfo = 3;
    AppMethodBeat.o(13905);
    return 0;
  }
  
  private void showLog(String paramString) {}
  
  private void srcAudioFormatToPCM()
  {
    AppMethodBeat.i(13906);
    if (this.decodeInputBuffers.length <= 1)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "m_nIndex: " + this.m_nIndex + " srcAudioFormatToPCM decodeInputBuffers.length to small," + this.decodeInputBuffers.length);
      }
      this.codeOver = true;
      AppMethodBeat.o(13906);
      return;
    }
    int i = this.mediaDecode.dequeueInputBuffer(-1L);
    if (i < 0)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "m_nIndex: " + this.m_nIndex + " srcAudioFormatToPCM decodeInputBuffers.inputIndex <0");
      }
      this.codeOver = true;
      AppMethodBeat.o(13906);
      return;
    }
    int j = Build.VERSION.SDK_INT;
    int k;
    if (j >= 21)
    {
      localByteBuffer = this.mediaDecode.getInputBuffer(i);
      localByteBuffer.clear();
      k = this.mediaExtractor.readSampleData(localByteBuffer, 0);
      if (k >= 0) {
        break label442;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "m_nIndex: " + this.m_nIndex + " srcAudioFormatToPCM readSampleData over,end");
      }
      this.codeOver = true;
      label217:
      i = this.mediaDecode.dequeueOutputBuffer(this.decodeBufferInfo, 10000L);
      if (i < 0) {
        break label531;
      }
      if (j < 21) {
        break label465;
      }
    }
    for (ByteBuffer localByteBuffer = this.mediaDecode.getOutputBuffer(i);; localByteBuffer = this.decodeOutputBuffers[i])
    {
      for (;;)
      {
        byte[] arrayOfByte = new byte[this.decodeBufferInfo.size];
        try
        {
          localByteBuffer.get(arrayOfByte);
          localByteBuffer.clear();
          if ((this.decRingBuffer != null) && (this.decodeBufferInfo.size > 0))
          {
            this.decRingBuffer.Push(arrayOfByte, this.decodeBufferInfo.size);
            k = this.nFirstThreeFrameInfo;
            this.nFirstThreeFrameInfo = (k - 1);
            if ((k > 0) && (QLog.isColorLevel())) {
              QLog.w("TRAE", 2, "m_nIndex: " + this.m_nIndex + " DecodeOneFrame size: " + this.decodeBufferInfo.size + " Remain: " + this.decRingBuffer.RemainRead() / this.nFrameSize);
            }
          }
          this.mediaDecode.releaseOutputBuffer(i, false);
          if (this.decodeBufferInfo.size > 0) {
            break;
          }
          i = this.mediaDecode.dequeueOutputBuffer(this.decodeBufferInfo, 10000L);
        }
        catch (Exception localException)
        {
          label442:
          label465:
          if (!QLog.isColorLevel()) {
            break label519;
          }
          QLog.w("TRAE", 2, "m_nIndex: " + this.m_nIndex + " srcAudioFormatToPCM wrong outputIndex: " + i);
          this.codeOver = true;
          AppMethodBeat.o(13906);
          return;
        }
      }
      localByteBuffer = this.decodeInputBuffers[i];
      break;
      this.mediaDecode.queueInputBuffer(i, 0, k, 0L, 0);
      this.mediaExtractor.advance();
      break label217;
    }
    label519:
    label531:
    AppMethodBeat.o(13906);
  }
  
  public int ReadOneFrame(byte[] paramArrayOfByte, int paramInt)
  {
    int j = 20;
    AppMethodBeat.i(13908);
    int i = j;
    if (!this.IsTenFramesReady)
    {
      i = 20;
      while ((this.decRingBuffer.RemainRead() / this.nFrameSize < 10) && (i > 0) && (!this.codeOver))
      {
        srcAudioFormatToPCM();
        i -= 1;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "m_nIndex: " + this.m_nIndex + " 10 FramesReady Remain frame: " + this.decRingBuffer.RemainRead() / this.nFrameSize);
      }
      this.IsTenFramesReady = true;
      i = j;
    }
    while ((!this.codeOver) && (this.decRingBuffer.RemainRead() / this.nFrameSize < 10) && (i > 0))
    {
      srcAudioFormatToPCM();
      i -= 1;
    }
    if (this.decRingBuffer.RemainRead() >= paramInt) {
      this.decRingBuffer.Pop(paramArrayOfByte, paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(13908);
      return paramInt;
      paramInt = -1;
    }
  }
  
  public int SeekTo(int paramInt)
  {
    AppMethodBeat.i(13907);
    if (this.mediaExtractor != null)
    {
      long l1 = this.mediaExtractor.getSampleTime();
      paramInt = this.decRingBuffer.RemainRead() * 20 / this.nFrameSize + paramInt;
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "m_nIndex: " + this.m_nIndex + " current PlayMs: " + l1 / 1000L + " SeekTo: " + paramInt);
      }
      this.mediaExtractor.seekTo(paramInt * 1000, 2);
      long l2 = this.mediaExtractor.getSampleTime();
      paramInt = (int)((l2 - l1) / 1000L);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "m_nIndex: " + this.m_nIndex + " total SeekTo time: " + paramInt + " t2:" + l2 / 1000L);
      }
      AppMethodBeat.o(13907);
      return paramInt;
    }
    AppMethodBeat.o(13907);
    return 0;
  }
  
  public int getChannels()
  {
    return this.channels;
  }
  
  public long getFileTotalMs()
  {
    return this.fileTotalMs;
  }
  
  public int getFrameSize()
  {
    return this.nFrameSize;
  }
  
  public int getSampleRate()
  {
    return this.sampleRate;
  }
  
  public int prepare(int paramInt)
  {
    AppMethodBeat.i(13904);
    if (this.srcPath == null)
    {
      AppMethodBeat.o(13904);
      return -1;
    }
    paramInt = initMediaDecode(paramInt);
    AppMethodBeat.o(13904);
    return paramInt;
  }
  
  public void release()
  {
    AppMethodBeat.i(13909);
    if (this.mediaDecode != null)
    {
      this.mediaDecode.stop();
      this.mediaDecode.release();
      this.mediaDecode = null;
    }
    if (this.mediaExtractor != null)
    {
      this.mediaExtractor.release();
      this.mediaExtractor = null;
    }
    if (this.onCompleteListener != null) {
      this.onCompleteListener = null;
    }
    if (this.onProgressListener != null) {
      this.onProgressListener = null;
    }
    showLog("release");
    AppMethodBeat.o(13909);
  }
  
  public void setIOPath(String paramString)
  {
    this.srcPath = paramString;
  }
  
  public void setIndex(int paramInt)
  {
    this.m_nIndex = paramInt;
  }
  
  public void setOnCompleteListener(OnCompleteListener paramOnCompleteListener)
  {
    this.onCompleteListener = paramOnCompleteListener;
  }
  
  public void setOnProgressListener(OnProgressListener paramOnProgressListener)
  {
    this.onProgressListener = paramOnProgressListener;
  }
  
  public static abstract interface OnCompleteListener
  {
    public abstract void completed();
  }
  
  public static abstract interface OnProgressListener
  {
    public abstract void progress();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.AudioDecoder
 * JD-Core Version:    0.7.0.1
 */