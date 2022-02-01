package com.tencent.tav.decoder;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Trace;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.codec.MediaCodecAnalyse;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tav.core.ExportRuntimeException;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import java.nio.ByteBuffer;

public class MediaCodecAssetWriterVideoEncoder
  implements AssetWriterVideoEncoder
{
  public static final String SCENE = "tav-encoder-assetwriter";
  private static final long WAIT_TRANSIENT_MS = 20L;
  private final String TAG;
  private ExportConfig encodeOption;
  private CGSize encodeSize;
  private Surface inputSurface;
  private boolean isEncodeToEndOfStream;
  private MediaFormat mediaFormat;
  private IMediaMuxer muxer;
  private int outHeight;
  private int outWidth;
  private volatile MediaCodec.BufferInfo videoBufferInfo;
  private volatile MediaFormat videoEncodeFormat;
  private MediaCodecAnalyse videoEncoder;
  private long videoPresentationTimeUs;
  
  public MediaCodecAssetWriterVideoEncoder()
  {
    AppMethodBeat.i(216182);
    this.TAG = ("MediaCodecAssetWriterVideoEncoder@" + hashCode());
    this.videoBufferInfo = new MediaCodec.BufferInfo();
    this.videoEncodeFormat = null;
    this.videoPresentationTimeUs = 0L;
    this.isEncodeToEndOfStream = false;
    AppMethodBeat.o(216182);
  }
  
  private int dequeueOutputBuffer(MediaCodecAnalyse paramMediaCodecAnalyse, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(216191);
    try
    {
      int i = paramMediaCodecAnalyse.dequeueOutputBuffer(paramBufferInfo, 1000L);
      AppMethodBeat.o(216191);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e(this.TAG, "dequeueOutputBuffer e = ", localException);
        if ((Build.VERSION.SDK_INT < 21) || (!(localException instanceof MediaCodec.CodecException))) {
          break;
        }
        if (23 <= Build.VERSION.SDK_INT) {
          Logger.e(this.TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (!((MediaCodec.CodecException)localException).isTransient()) {
          break;
        }
        waitTime(20L);
      }
      AppMethodBeat.o(216191);
      throw localException;
    }
  }
  
  private ByteBuffer getOutputBuffer(MediaCodecAnalyse paramMediaCodecAnalyse, int paramInt)
  {
    AppMethodBeat.i(216220);
    try
    {
      ByteBuffer localByteBuffer = DecoderUtils.getOutputBuffer(paramMediaCodecAnalyse, paramInt);
      AppMethodBeat.o(216220);
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e(this.TAG, "getOutputBuffer", localException);
        if ((Build.VERSION.SDK_INT < 21) || (!(localException instanceof MediaCodec.CodecException))) {
          break;
        }
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e(this.TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (!((MediaCodec.CodecException)localException).isTransient()) {
          break;
        }
        waitTime(20L);
      }
      AppMethodBeat.o(216220);
      throw localException;
    }
    catch (Error localError)
    {
      label19:
      break label19;
    }
  }
  
  private void releaseOutputBuffer(MediaCodecAnalyse paramMediaCodecAnalyse, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(216202);
    try
    {
      paramMediaCodecAnalyse.releaseOutputBuffer(paramInt, paramBoolean);
      AppMethodBeat.o(216202);
      return;
    }
    catch (Exception localException)
    {
      Logger.e(this.TAG, "releaseOutputBuffer", localException);
      if ((Build.VERSION.SDK_INT >= 21) && ((localException instanceof MediaCodec.CodecException)))
      {
        if (Build.VERSION.SDK_INT >= 23) {
          Logger.e(this.TAG, "CodecException - isTransient = " + ((MediaCodec.CodecException)localException).isTransient() + " , isRecoverable = " + ((MediaCodec.CodecException)localException).isRecoverable() + " , errorCode = " + ((MediaCodec.CodecException)localException).getErrorCode());
        }
        if (((MediaCodec.CodecException)localException).isTransient())
        {
          waitTime(20L);
          releaseOutputBuffer(paramMediaCodecAnalyse, paramInt, paramBoolean);
        }
      }
      AppMethodBeat.o(216202);
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
    AppMethodBeat.i(216230);
    try
    {
      wait(paramLong);
      AppMethodBeat.o(216230);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      AppMethodBeat.o(216230);
    }
  }
  
  public Surface createInputSurface()
  {
    AppMethodBeat.i(216238);
    if ((this.videoEncoder != null) && (this.inputSurface == null))
    {
      Logger.i(this.TAG, "createInputSurface");
      this.inputSurface = this.videoEncoder.createInputSurface();
    }
    Surface localSurface = this.inputSurface;
    AppMethodBeat.o(216238);
    return localSurface;
  }
  
  public void flush()
  {
    AppMethodBeat.i(216286);
    if (this.videoEncoder != null)
    {
      this.isEncodeToEndOfStream = false;
      this.videoEncoder.flush();
    }
    AppMethodBeat.o(216286);
  }
  
  public MediaFormat getEncodeFormat()
  {
    return this.videoEncodeFormat;
  }
  
  public long getEncodePresentationTimeUs()
  {
    return this.videoPresentationTimeUs;
  }
  
  public CGSize getEncodeSize()
  {
    return this.encodeSize;
  }
  
  public boolean isEncodeToEndOfStream()
  {
    return this.isEncodeToEndOfStream;
  }
  
  public boolean isNeedVideoOutputTexture()
  {
    return false;
  }
  
  public boolean prepare(ExportConfig paramExportConfig, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(216254);
    CGSize localCGSize = CodecHelper.correctSupportSize(paramExportConfig.getOutputSize(), "video/avc");
    this.outHeight = ((int)localCGSize.height);
    this.outWidth = ((int)localCGSize.width);
    this.encodeSize = new CGSize(this.outWidth, this.outHeight);
    this.encodeOption = paramExportConfig;
    this.mediaFormat = paramMediaFormat;
    try
    {
      Logger.i(this.TAG, "prepareVideoEncoder: format = ".concat(String.valueOf(paramMediaFormat)));
      paramExportConfig = "video/avc";
      if (paramMediaFormat.containsKey("mime")) {
        paramExportConfig = paramMediaFormat.getString("mime");
      }
      this.videoEncoder = MediaCodecAnalyse.createEncoderByType(paramExportConfig, "tav-encoder-assetwriter");
      this.videoEncoder.configure(paramMediaFormat, null, null, 1);
      AppMethodBeat.o(216254);
      return true;
    }
    catch (Exception paramExportConfig)
    {
      Logger.e(this.TAG, "prepareVideoEncoder: 失败，准备重试。format = ".concat(String.valueOf(paramMediaFormat)), paramExportConfig);
      paramMediaFormat.setInteger("profile", 0);
      paramMediaFormat.setInteger("level", 0);
      try
      {
        this.videoEncoder = MediaCodecAnalyse.createEncoderByType("video/avc", "tav-encoder-assetwriter");
        this.videoEncoder.configure(paramMediaFormat, null, null, 1);
        AppMethodBeat.o(216254);
        return true;
      }
      catch (Exception paramExportConfig)
      {
        Logger.e(this.TAG, "prepareVideoEncoder: retry 失败 format = ".concat(String.valueOf(paramMediaFormat)), paramExportConfig);
        paramExportConfig = new ExportRuntimeException(new ExportErrorStatus(-103, paramExportConfig, paramMediaFormat.toString()));
        AppMethodBeat.o(216254);
        throw paramExportConfig;
      }
    }
  }
  
  public void processVideoTexture(TextureInfo paramTextureInfo, CMTime paramCMTime) {}
  
  public void release()
  {
    AppMethodBeat.i(216342);
    if (this.videoEncoder != null) {
      this.videoEncoder.release();
    }
    AppMethodBeat.o(216342);
  }
  
  public void reset()
  {
    AppMethodBeat.i(216349);
    if (this.videoEncoder != null)
    {
      this.isEncodeToEndOfStream = false;
      this.videoEncoder.reset();
      this.videoEncoder.configure(this.mediaFormat, null, null, 1);
      this.inputSurface = null;
      this.videoEncoder.start();
    }
    AppMethodBeat.o(216349);
  }
  
  public void setMediaMuxer(IMediaMuxer paramIMediaMuxer)
  {
    this.muxer = paramIMediaMuxer;
  }
  
  public void setVideoSampleRenderContext(RenderContext paramRenderContext) {}
  
  public void signalEndOfInputStream()
  {
    AppMethodBeat.i(216297);
    if (this.videoEncoder != null) {
      this.videoEncoder.signalEndOfInputStream();
    }
    AppMethodBeat.o(216297);
  }
  
  public boolean start()
  {
    AppMethodBeat.i(216278);
    if (this.videoEncoder != null)
    {
      this.videoEncoder.start();
      AppMethodBeat.o(216278);
      return true;
    }
    AppMethodBeat.o(216278);
    return false;
  }
  
  public void stop()
  {
    AppMethodBeat.i(216336);
    if (this.videoEncoder != null) {
      this.videoEncoder.stop();
    }
    AppMethodBeat.o(216336);
  }
  
  public boolean writeVideoSample(CMSampleBuffer paramCMSampleBuffer, boolean paramBoolean)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    AppMethodBeat.i(216309);
    if (this.muxer != null) {}
    for (boolean bool2 = this.muxer.isMuxerStarted();; bool2 = false)
    {
      System.currentTimeMillis();
      int i;
      if ((bool2) || (this.videoEncodeFormat == null))
      {
        Trace.beginSection("encode-dequeue");
        i = dequeueOutputBuffer(this.videoEncoder, this.videoBufferInfo);
        Trace.endSection();
        if (i == -1) {
          if (!paramBoolean) {
            bool1 = true;
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(216309);
        return bool1;
        if (i == -2)
        {
          this.videoEncodeFormat = this.videoEncoder.getOutputFormat();
          Logger.i(this.TAG, "encoder output format changed:" + this.videoEncodeFormat);
        }
        else if (i >= 0)
        {
          Trace.beginSection("has-data");
          paramCMSampleBuffer = getOutputBuffer(this.videoEncoder, i);
          if (((this.videoBufferInfo.flags & 0x2) != 0) && (this.muxer.ignoreHeader())) {
            this.videoBufferInfo.size = 0;
          }
          if ((bool2) && (validAndCorrectBufferInfo(this.videoBufferInfo))) {}
          try
          {
            MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
            localBufferInfo.set(this.videoBufferInfo.offset, this.videoBufferInfo.size, this.videoBufferInfo.presentationTimeUs, this.videoBufferInfo.flags);
            this.muxer.writeSampleData(this.muxer.videoTrackIndex(), paramCMSampleBuffer, localBufferInfo);
            this.videoPresentationTimeUs = this.videoBufferInfo.presentationTimeUs;
            releaseOutputBuffer(this.videoEncoder, i, false);
            bool1 = bool3;
            if ((this.videoBufferInfo.flags & 0x4) != 0)
            {
              Logger.i(this.TAG, "writeVideoFrame: BUFFER_FLAG_END_OF_STREAM");
              this.videoPresentationTimeUs = -1L;
              this.isEncodeToEndOfStream = true;
              bool1 = true;
            }
            Trace.endSection();
          }
          catch (Exception paramCMSampleBuffer)
          {
            for (;;)
            {
              Logger.e(this.TAG, "writeVideoFrame: ", paramCMSampleBuffer);
            }
          }
          if (!paramBoolean) {
            bool1 = true;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.MediaCodecAssetWriterVideoEncoder
 * JD-Core Version:    0.7.0.1
 */