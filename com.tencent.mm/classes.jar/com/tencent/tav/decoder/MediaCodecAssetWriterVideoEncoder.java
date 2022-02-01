package com.tencent.tav.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tav.core.ExportRuntimeException;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import java.nio.ByteBuffer;

public class MediaCodecAssetWriterVideoEncoder
  implements AssetWriterVideoEncoder
{
  private static final long WAIT_TRANSIENT_MS = 20L;
  private final String TAG;
  private ExportConfig encodeOption;
  private CGSize encodeSize;
  private Surface inputSurface;
  private boolean isEncodeToEndOfStream;
  private IMediaMuxer muxer;
  private int outHeight;
  private int outWidth;
  private volatile MediaCodec.BufferInfo videoBufferInfo;
  private volatile MediaFormat videoEncodeFormat;
  private MediaCodec videoEncoder;
  private long videoPresentationTimeUs;
  
  public MediaCodecAssetWriterVideoEncoder()
  {
    AppMethodBeat.i(218228);
    this.TAG = ("MediaCodecAssetWriterVideoEncoder@" + hashCode());
    this.videoBufferInfo = new MediaCodec.BufferInfo();
    this.videoEncodeFormat = null;
    this.videoPresentationTimeUs = 0L;
    this.isEncodeToEndOfStream = false;
    AppMethodBeat.o(218228);
  }
  
  private int dequeueOutputBuffer(MediaCodec paramMediaCodec, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(218234);
    try
    {
      int i = paramMediaCodec.dequeueOutputBuffer(paramBufferInfo, 1000L);
      AppMethodBeat.o(218234);
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
      AppMethodBeat.o(218234);
      throw localException;
    }
  }
  
  private ByteBuffer getOutputBuffer(MediaCodec paramMediaCodec, int paramInt)
  {
    AppMethodBeat.i(218238);
    try
    {
      ByteBuffer localByteBuffer = DecoderUtils.getOutputBuffer(paramMediaCodec, paramInt);
      AppMethodBeat.o(218238);
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
      AppMethodBeat.o(218238);
      throw localException;
    }
    catch (Error localError)
    {
      label19:
      break label19;
    }
  }
  
  private void releaseOutputBuffer(MediaCodec paramMediaCodec, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(218235);
    try
    {
      paramMediaCodec.releaseOutputBuffer(paramInt, paramBoolean);
      AppMethodBeat.o(218235);
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
          releaseOutputBuffer(paramMediaCodec, paramInt, paramBoolean);
        }
      }
      AppMethodBeat.o(218235);
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
    AppMethodBeat.i(218239);
    try
    {
      wait(paramLong);
      AppMethodBeat.o(218239);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      AppMethodBeat.o(218239);
    }
  }
  
  public Surface createInputSurface()
  {
    AppMethodBeat.i(218229);
    if ((this.videoEncoder != null) && (this.inputSurface == null))
    {
      Logger.i(this.TAG, "createInputSurface");
      this.inputSurface = this.videoEncoder.createInputSurface();
    }
    Surface localSurface = this.inputSurface;
    AppMethodBeat.o(218229);
    return localSurface;
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
  
  public void inputVideoTexture(TextureInfo paramTextureInfo) {}
  
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
    AppMethodBeat.i(218230);
    CGSize localCGSize = CodecHelper.correctSupportSize(paramExportConfig.getOutputSize(), "video/avc");
    this.outHeight = ((int)localCGSize.height);
    this.outWidth = ((int)localCGSize.width);
    this.encodeSize = new CGSize(this.outWidth, this.outHeight);
    this.encodeOption = paramExportConfig;
    try
    {
      Logger.i(this.TAG, "prepareVideoEncoder: format = ".concat(String.valueOf(paramMediaFormat)));
      paramExportConfig = "video/avc";
      if (paramMediaFormat.containsKey("mime")) {
        paramExportConfig = paramMediaFormat.getString("mime");
      }
      this.videoEncoder = MediaCodec.createEncoderByType(paramExportConfig);
      this.videoEncoder.configure(paramMediaFormat, null, null, 1);
      AppMethodBeat.o(218230);
      return true;
    }
    catch (Exception paramExportConfig)
    {
      Logger.e(this.TAG, "prepareVideoEncoder: 失败，准备重试。format = ".concat(String.valueOf(paramMediaFormat)), paramExportConfig);
      paramMediaFormat.setInteger("profile", 0);
      paramMediaFormat.setInteger("level", 0);
      try
      {
        this.videoEncoder = MediaCodec.createEncoderByType("video/avc");
        this.videoEncoder.configure(paramMediaFormat, null, null, 1);
        AppMethodBeat.o(218230);
        return true;
      }
      catch (Exception paramExportConfig)
      {
        Logger.e(this.TAG, "prepareVideoEncoder: retry 失败 format = ".concat(String.valueOf(paramMediaFormat)), paramExportConfig);
        paramExportConfig = new ExportRuntimeException(new ExportErrorStatus(-103, paramExportConfig, paramMediaFormat.toString()));
        AppMethodBeat.o(218230);
        throw paramExportConfig;
      }
    }
  }
  
  public void release()
  {
    AppMethodBeat.i(218237);
    if (this.videoEncoder != null) {
      this.videoEncoder.release();
    }
    AppMethodBeat.o(218237);
  }
  
  public void setMediaMuxer(IMediaMuxer paramIMediaMuxer)
  {
    this.muxer = paramIMediaMuxer;
  }
  
  public void setVideoSampleRenderContext(RenderContext paramRenderContext) {}
  
  public void signalEndOfInputStream()
  {
    AppMethodBeat.i(218232);
    if (this.videoEncoder != null) {
      this.videoEncoder.signalEndOfInputStream();
    }
    AppMethodBeat.o(218232);
  }
  
  public boolean start()
  {
    AppMethodBeat.i(218231);
    if (this.videoEncoder != null)
    {
      this.videoEncoder.start();
      AppMethodBeat.o(218231);
      return true;
    }
    AppMethodBeat.o(218231);
    return false;
  }
  
  public void stop()
  {
    AppMethodBeat.i(218236);
    if (this.videoEncoder != null) {
      this.videoEncoder.stop();
    }
    AppMethodBeat.o(218236);
  }
  
  public boolean writeVideoSample(CMSampleBuffer paramCMSampleBuffer, boolean paramBoolean)
  {
    boolean bool3 = false;
    AppMethodBeat.i(218233);
    if (this.muxer != null) {}
    for (boolean bool2 = this.muxer.isMuxerStarted();; bool2 = false)
    {
      int i;
      boolean bool1;
      if ((bool2) || (this.videoEncodeFormat == null))
      {
        i = dequeueOutputBuffer(this.videoEncoder, this.videoBufferInfo);
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
        AppMethodBeat.o(218233);
        return bool1;
        if (i == -2)
        {
          this.videoEncodeFormat = this.videoEncoder.getOutputFormat();
          bool1 = bool3;
        }
        else
        {
          bool1 = bool3;
          if (i >= 0)
          {
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
              if ((this.videoBufferInfo.flags & 0x4) == 0) {
                continue;
              }
              Logger.i(this.TAG, "writeVideoFrame: BUFFER_FLAG_END_OF_STREAM");
              this.videoPresentationTimeUs = -1L;
              this.isEncodeToEndOfStream = true;
              bool1 = true;
            }
            catch (Exception paramCMSampleBuffer)
            {
              for (;;)
              {
                Logger.e(this.TAG, "writeVideoFrame: ", paramCMSampleBuffer);
              }
            }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.decoder.MediaCodecAssetWriterVideoEncoder
 * JD-Core Version:    0.7.0.1
 */