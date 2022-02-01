package com.tencent.tav.core;

import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.CodecHelper;
import com.tencent.tav.decoder.EncoderWriter.OutputConfig;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;

public class ExportConfig
  implements Cloneable
{
  private static final String TAG = "ExportConfig";
  private static final int UNKNOWN_PARAM_VALUE = 0;
  private int audioAacProfile = 2;
  private int audioBitRate = 128000;
  private int audioChannelCount = 1;
  private boolean audioEncodeNeedCodecSpecificData = true;
  private MediaFormat audioFormat;
  private int audioSampleRateHz = 44100;
  private int colorRange = 0;
  private int colorStandard = 0;
  private int colorTransfer = 0;
  private boolean correctSizeByCodecCapabilities = true;
  private ByteBuffer hdrStaticInfo = null;
  private boolean highProfile = false;
  private String outputFilePath;
  private int outputHeight;
  private int outputWidth;
  private int videoBitRate = 8000000;
  private MediaFormat videoFormat;
  private int videoFrameRate = 30;
  private int videoIFrameInterval = 1;
  private String videoMimeType = "video/avc";
  
  public ExportConfig(int paramInt1, int paramInt2)
  {
    this.outputWidth = paramInt1;
    this.outputHeight = paramInt2;
  }
  
  @Deprecated
  public ExportConfig(EncoderWriter.OutputConfig paramOutputConfig)
  {
    this.outputWidth = paramOutputConfig.VIDEO_TARGET_WIDTH;
    this.outputHeight = paramOutputConfig.VIDEO_TARGET_HEIGHT;
    this.videoIFrameInterval = paramOutputConfig.VIDEO_IFRAME_INTERVAL;
    this.videoBitRate = paramOutputConfig.VIDEO_BIT_RATE;
    this.videoFrameRate = paramOutputConfig.VIDEO_FRAME_RATE;
    this.highProfile = paramOutputConfig.HIGH_PROFILE;
    this.audioChannelCount = paramOutputConfig.AUDIO_CHANNEL_COUNT;
    this.audioBitRate = paramOutputConfig.AUDIO_BIT_RATE;
    this.audioAacProfile = paramOutputConfig.AUDIO_AAC_PROFILE;
  }
  
  private int findFormatValue(String paramString, int paramInt, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(189218);
    if ((paramMediaFormat != null) && (paramMediaFormat.containsKey(paramString)))
    {
      paramInt = paramMediaFormat.getInteger(paramString);
      AppMethodBeat.o(189218);
      return paramInt;
    }
    AppMethodBeat.o(189218);
    return paramInt;
  }
  
  private int findVideoFormatValue(String paramString, int paramInt)
  {
    AppMethodBeat.i(189216);
    paramInt = findFormatValue(paramString, paramInt, this.videoFormat);
    AppMethodBeat.o(189216);
    return paramInt;
  }
  
  private void initAudioChannelCount()
  {
    AppMethodBeat.i(189198);
    setToAudioFormat("channel-count", this.audioChannelCount);
    AppMethodBeat.o(189198);
  }
  
  private void initAudioSampleRate()
  {
    AppMethodBeat.i(189206);
    setToAudioFormat("sample-rate", this.audioSampleRateHz);
    AppMethodBeat.o(189206);
  }
  
  private void initColorSpace()
  {
    AppMethodBeat.i(189208);
    if (Build.VERSION.SDK_INT >= 24)
    {
      if (this.colorRange != 0) {
        setToVideoFormat("color-range", this.colorRange);
      }
      if (this.colorTransfer != 0) {
        setToVideoFormat("color-transfer", this.colorTransfer);
      }
      if (this.colorStandard != 0) {
        setToVideoFormat("color-standard", this.colorStandard);
      }
      if (this.hdrStaticInfo != null) {
        setToVideoFormat("hdr-static-info", this.hdrStaticInfo);
      }
    }
    AppMethodBeat.o(189208);
  }
  
  private void initFrameRate()
  {
    AppMethodBeat.i(189204);
    setToVideoFormat("frame-rate", this.videoFrameRate);
    AppMethodBeat.o(189204);
  }
  
  private void initHdrInfo()
  {
    AppMethodBeat.i(189209);
    if ((Build.VERSION.SDK_INT >= 24) && (this.hdrStaticInfo != null)) {
      setToVideoFormat("hdr-static-info", this.hdrStaticInfo);
    }
    AppMethodBeat.o(189209);
  }
  
  private void initHighProfile()
  {
    AppMethodBeat.i(189200);
    if ((this.highProfile) && (this.videoMimeType.equalsIgnoreCase("video/avc"))) {
      CodecHelper.selectProfileAndLevel(this.videoFormat);
    }
    AppMethodBeat.o(189200);
  }
  
  private void initIFrameInterval()
  {
    AppMethodBeat.i(189201);
    setToVideoFormat("i-frame-interval", this.videoIFrameInterval);
    AppMethodBeat.o(189201);
  }
  
  private void initOutputSize()
  {
    AppMethodBeat.i(189207);
    Logger.i("ExportConfig", "initOutputSize, correctSizeByCodecCapabilities:" + this.correctSizeByCodecCapabilities);
    if (this.correctSizeByCodecCapabilities)
    {
      CGSize localCGSize = CodecHelper.correctSupportSize(getOutputSize(), "video/avc");
      setToVideoFormat("width", (int)localCGSize.width);
      setToVideoFormat("height", (int)localCGSize.height);
      AppMethodBeat.o(189207);
      return;
    }
    setToVideoFormat("width", (int)getOutputSize().width);
    setToVideoFormat("height", (int)getOutputSize().height);
    AppMethodBeat.o(189207);
  }
  
  private void initVideoBitrate()
  {
    AppMethodBeat.i(189205);
    setToVideoFormat("bitrate", this.videoBitRate);
    AppMethodBeat.o(189205);
  }
  
  private void setToAudioFormat(String paramString, int paramInt)
  {
    AppMethodBeat.i(189212);
    if (this.audioFormat == null) {
      getAudioFormat();
    }
    setToFormat(paramString, paramInt, this.audioFormat);
    AppMethodBeat.o(189212);
  }
  
  private void setToFormat(String paramString, int paramInt, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(189213);
    if (paramMediaFormat == null)
    {
      AppMethodBeat.o(189213);
      return;
    }
    paramMediaFormat.setInteger(paramString, paramInt);
    AppMethodBeat.o(189213);
  }
  
  private void setToFormat(String paramString, ByteBuffer paramByteBuffer, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(189215);
    if (paramMediaFormat == null)
    {
      AppMethodBeat.o(189215);
      return;
    }
    paramMediaFormat.setByteBuffer(paramString, paramByteBuffer);
    AppMethodBeat.o(189215);
  }
  
  private void setToVideoFormat(String paramString, int paramInt)
  {
    AppMethodBeat.i(189210);
    if (this.videoFormat == null) {
      getVideoFormat();
    }
    setToFormat(paramString, paramInt, this.videoFormat);
    AppMethodBeat.o(189210);
  }
  
  private void setToVideoFormat(String paramString, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(189211);
    if (this.videoFormat == null) {
      getVideoFormat();
    }
    setToFormat(paramString, paramByteBuffer, this.videoFormat);
    AppMethodBeat.o(189211);
  }
  
  public boolean available()
  {
    AppMethodBeat.i(189180);
    if ((getOutputWidth() > 0) && (getOutputHeight() > 0))
    {
      AppMethodBeat.o(189180);
      return true;
    }
    AppMethodBeat.o(189180);
    return false;
  }
  
  public ExportConfig clone()
  {
    AppMethodBeat.i(189219);
    ExportConfig localExportConfig = new ExportConfig(this.outputWidth, this.outputHeight);
    localExportConfig.videoBitRate = this.videoBitRate;
    localExportConfig.videoFrameRate = this.videoFrameRate;
    localExportConfig.videoIFrameInterval = this.videoIFrameInterval;
    localExportConfig.outputWidth = this.outputWidth;
    localExportConfig.outputHeight = this.outputHeight;
    localExportConfig.highProfile = this.highProfile;
    localExportConfig.videoMimeType = this.videoMimeType;
    localExportConfig.audioBitRate = this.audioBitRate;
    localExportConfig.audioAacProfile = this.audioAacProfile;
    localExportConfig.audioChannelCount = this.audioChannelCount;
    localExportConfig.audioSampleRateHz = this.audioSampleRateHz;
    localExportConfig.audioEncodeNeedCodecSpecificData = this.audioEncodeNeedCodecSpecificData;
    localExportConfig.colorRange = this.colorRange;
    localExportConfig.colorStandard = this.colorStandard;
    localExportConfig.colorTransfer = this.colorTransfer;
    localExportConfig.hdrStaticInfo = this.hdrStaticInfo;
    localExportConfig.correctSizeByCodecCapabilities = this.correctSizeByCodecCapabilities;
    AppMethodBeat.o(189219);
    return localExportConfig;
  }
  
  public int getAudioChannelCount()
  {
    AppMethodBeat.i(189190);
    int i = findFormatValue("channel-count", this.audioChannelCount, this.audioFormat);
    AppMethodBeat.o(189190);
    return i;
  }
  
  public MediaFormat getAudioFormat()
  {
    AppMethodBeat.i(189196);
    if (this.audioFormat == null)
    {
      this.audioFormat = new MediaFormat();
      this.audioFormat.setString("mime", "audio/mp4a-latm");
      this.audioFormat.setInteger("sample-rate", this.audioSampleRateHz);
      initAudioChannelCount();
      this.audioFormat.setInteger("bitrate", this.audioBitRate);
      this.audioFormat.setInteger("aac-profile", this.audioAacProfile);
    }
    Logger.i("ExportConfig", "getAudioFormat:" + this.audioFormat);
    MediaFormat localMediaFormat = this.audioFormat;
    AppMethodBeat.o(189196);
    return localMediaFormat;
  }
  
  public int getAudioSampleRateHz()
  {
    AppMethodBeat.i(189192);
    int i = findFormatValue("sample-rate", this.audioSampleRateHz, this.audioFormat);
    AppMethodBeat.o(189192);
    return i;
  }
  
  public String getOutputFilePath()
  {
    return this.outputFilePath;
  }
  
  public int getOutputHeight()
  {
    AppMethodBeat.i(189182);
    int i = findVideoFormatValue("height", this.outputHeight);
    AppMethodBeat.o(189182);
    return i;
  }
  
  public CGSize getOutputSize()
  {
    AppMethodBeat.i(189186);
    CGSize localCGSize = new CGSize(getOutputWidth(), getOutputHeight());
    AppMethodBeat.o(189186);
    return localCGSize;
  }
  
  public int getOutputWidth()
  {
    AppMethodBeat.i(189181);
    int i = findVideoFormatValue("width", this.outputWidth);
    AppMethodBeat.o(189181);
    return i;
  }
  
  public int getVideoBitRate()
  {
    AppMethodBeat.i(189188);
    int i = findVideoFormatValue("bitrate", this.videoBitRate);
    AppMethodBeat.o(189188);
    return i;
  }
  
  public MediaFormat getVideoFormat()
  {
    AppMethodBeat.i(189194);
    if (this.videoFormat == null)
    {
      this.videoFormat = new MediaFormat();
      this.videoFormat.setString("mime", this.videoMimeType);
      this.videoFormat.setInteger("color-format", 2130708361);
      initOutputSize();
      initVideoBitrate();
      initFrameRate();
      initIFrameInterval();
      initHighProfile();
      initColorSpace();
      initHdrInfo();
    }
    MediaFormat localMediaFormat = this.videoFormat;
    AppMethodBeat.o(189194);
    return localMediaFormat;
  }
  
  public int getVideoFrameRate()
  {
    AppMethodBeat.i(189189);
    int i = findVideoFormatValue("frame-rate", this.videoFrameRate);
    AppMethodBeat.o(189189);
    return i;
  }
  
  public boolean isAudioEncodeNeedCodecSpecificData()
  {
    return this.audioEncodeNeedCodecSpecificData;
  }
  
  public void setAudioBitRate(int paramInt)
  {
    this.audioBitRate = paramInt;
  }
  
  public void setAudioChannelCount(int paramInt)
  {
    AppMethodBeat.i(189173);
    this.audioChannelCount = paramInt;
    initAudioChannelCount();
    AppMethodBeat.o(189173);
  }
  
  public void setAudioEncodeNeedCodecSpecificData(boolean paramBoolean)
  {
    AppMethodBeat.i(189177);
    Logger.i("ExportConfig", "setAudioEncodeNeedCodecSpecificData:".concat(String.valueOf(paramBoolean)));
    this.audioEncodeNeedCodecSpecificData = paramBoolean;
    AppMethodBeat.o(189177);
  }
  
  public void setAudioSampleRateHz(int paramInt)
  {
    AppMethodBeat.i(189175);
    this.audioSampleRateHz = paramInt;
    initAudioSampleRate();
    AppMethodBeat.o(189175);
  }
  
  public void setColorSpace(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(189169);
    this.colorRange = paramInt1;
    this.colorStandard = paramInt2;
    this.colorTransfer = paramInt3;
    initColorSpace();
    AppMethodBeat.o(189169);
  }
  
  public void setEncodeHevc(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.videoMimeType = "video/hevc";
      return;
    }
    this.videoMimeType = "video/avc";
  }
  
  public void setHdrStaticInfo(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(189171);
    this.hdrStaticInfo = paramByteBuffer;
    initHdrInfo();
    AppMethodBeat.o(189171);
  }
  
  public void setHighProfile(boolean paramBoolean)
  {
    AppMethodBeat.i(189165);
    this.highProfile = paramBoolean;
    initHighProfile();
    AppMethodBeat.o(189165);
  }
  
  public void setNeedCorrectSizeByCodecCapabilities(boolean paramBoolean)
  {
    AppMethodBeat.i(189179);
    Logger.i("ExportConfig", "setNeedCorrectSizeByCodecCapabilities:".concat(String.valueOf(paramBoolean)));
    this.correctSizeByCodecCapabilities = paramBoolean;
    AppMethodBeat.o(189179);
  }
  
  public void setOutputFilePath(String paramString)
  {
    this.outputFilePath = paramString;
  }
  
  public void setOutputSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189157);
    this.outputWidth = paramInt1;
    this.outputHeight = paramInt2;
    initOutputSize();
    AppMethodBeat.o(189157);
  }
  
  public void setVideoBitRate(int paramInt)
  {
    AppMethodBeat.i(189160);
    this.videoBitRate = paramInt;
    initVideoBitrate();
    AppMethodBeat.o(189160);
  }
  
  public void setVideoFrameRate(int paramInt)
  {
    AppMethodBeat.i(189161);
    this.videoFrameRate = paramInt;
    initFrameRate();
    AppMethodBeat.o(189161);
  }
  
  public void setVideoIFrameInterval(int paramInt)
  {
    AppMethodBeat.i(189163);
    this.videoIFrameInterval = paramInt;
    initIFrameInterval();
    AppMethodBeat.o(189163);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tav.core.ExportConfig
 * JD-Core Version:    0.7.0.1
 */