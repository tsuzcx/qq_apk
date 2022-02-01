package com.tencent.tav.core;

import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.CodecHelper;
import com.tencent.tav.decoder.EncoderWriter.OutputConfig;
import com.tencent.tav.decoder.logger.Logger;

public class ExportConfig
  implements Cloneable
{
  private static final String TAG = "ExportConfig";
  private int audioAacProfile = 2;
  private int audioBitRate = 128000;
  private int audioChannelCount = 1;
  private boolean audioEncodeNeedCodecSpecificData = true;
  private MediaFormat audioFormat;
  private int audioSampleRateHz = 44100;
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
    AppMethodBeat.i(217903);
    if ((paramMediaFormat != null) && (paramMediaFormat.containsKey(paramString)))
    {
      paramInt = paramMediaFormat.getInteger(paramString);
      AppMethodBeat.o(217903);
      return paramInt;
    }
    AppMethodBeat.o(217903);
    return paramInt;
  }
  
  private int findVideoFormatValue(String paramString, int paramInt)
  {
    AppMethodBeat.i(217902);
    paramInt = findFormatValue(paramString, paramInt, this.videoFormat);
    AppMethodBeat.o(217902);
    return paramInt;
  }
  
  private void initAudioChannelCount()
  {
    AppMethodBeat.i(217892);
    setToAudioFormat("channel-count", this.audioChannelCount);
    AppMethodBeat.o(217892);
  }
  
  private void initAudioSampleRate()
  {
    AppMethodBeat.i(217897);
    setToAudioFormat("sample-rate", this.audioSampleRateHz);
    AppMethodBeat.o(217897);
  }
  
  private void initFrameRate()
  {
    AppMethodBeat.i(217895);
    setToVideoFormat("frame-rate", this.videoFrameRate);
    AppMethodBeat.o(217895);
  }
  
  private void initHighProfile()
  {
    AppMethodBeat.i(217893);
    if ((this.highProfile) && (this.videoMimeType.equalsIgnoreCase("video/avc"))) {
      CodecHelper.selectProfileAndLevel(this.videoFormat);
    }
    AppMethodBeat.o(217893);
  }
  
  private void initIFrameInterval()
  {
    AppMethodBeat.i(217894);
    setToVideoFormat("i-frame-interval", this.videoIFrameInterval);
    AppMethodBeat.o(217894);
  }
  
  private void initOutputSize()
  {
    AppMethodBeat.i(217898);
    CGSize localCGSize = CodecHelper.correctSupportSize(getOutputSize(), "video/avc");
    setToVideoFormat("width", (int)localCGSize.width);
    setToVideoFormat("height", (int)localCGSize.height);
    AppMethodBeat.o(217898);
  }
  
  private void initVideoBitrate()
  {
    AppMethodBeat.i(217896);
    setToVideoFormat("bitrate", this.videoBitRate);
    AppMethodBeat.o(217896);
  }
  
  private void setToAudioFormat(String paramString, int paramInt)
  {
    AppMethodBeat.i(217900);
    if (this.audioFormat == null) {
      getAudioFormat();
    }
    setToFormat(paramString, paramInt, this.audioFormat);
    AppMethodBeat.o(217900);
  }
  
  private void setToFormat(String paramString, int paramInt, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(217901);
    if (paramMediaFormat == null)
    {
      AppMethodBeat.o(217901);
      return;
    }
    paramMediaFormat.setInteger(paramString, paramInt);
    AppMethodBeat.o(217901);
  }
  
  private void setToVideoFormat(String paramString, int paramInt)
  {
    AppMethodBeat.i(217899);
    if (this.videoFormat == null) {
      getVideoFormat();
    }
    setToFormat(paramString, paramInt, this.videoFormat);
    AppMethodBeat.o(217899);
  }
  
  public boolean available()
  {
    AppMethodBeat.i(217882);
    if ((getOutputWidth() > 0) && (getOutputHeight() > 0))
    {
      AppMethodBeat.o(217882);
      return true;
    }
    AppMethodBeat.o(217882);
    return false;
  }
  
  public ExportConfig clone()
  {
    AppMethodBeat.i(217904);
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
    AppMethodBeat.o(217904);
    return localExportConfig;
  }
  
  public int getAudioChannelCount()
  {
    AppMethodBeat.i(217888);
    int i = findFormatValue("channel-count", this.audioChannelCount, this.audioFormat);
    AppMethodBeat.o(217888);
    return i;
  }
  
  public MediaFormat getAudioFormat()
  {
    AppMethodBeat.i(217891);
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
    AppMethodBeat.o(217891);
    return localMediaFormat;
  }
  
  public int getAudioSampleRateHz()
  {
    AppMethodBeat.i(217889);
    int i = findFormatValue("sample-rate", this.audioSampleRateHz, this.audioFormat);
    AppMethodBeat.o(217889);
    return i;
  }
  
  public String getOutputFilePath()
  {
    return this.outputFilePath;
  }
  
  public int getOutputHeight()
  {
    AppMethodBeat.i(217884);
    int i = findVideoFormatValue("height", this.outputHeight);
    AppMethodBeat.o(217884);
    return i;
  }
  
  public CGSize getOutputSize()
  {
    AppMethodBeat.i(217885);
    CGSize localCGSize = new CGSize(getOutputWidth(), getOutputHeight());
    AppMethodBeat.o(217885);
    return localCGSize;
  }
  
  public int getOutputWidth()
  {
    AppMethodBeat.i(217883);
    int i = findVideoFormatValue("width", this.outputWidth);
    AppMethodBeat.o(217883);
    return i;
  }
  
  public int getVideoBitRate()
  {
    AppMethodBeat.i(217886);
    int i = findVideoFormatValue("bitrate", this.videoBitRate);
    AppMethodBeat.o(217886);
    return i;
  }
  
  public MediaFormat getVideoFormat()
  {
    AppMethodBeat.i(217890);
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
    }
    MediaFormat localMediaFormat = this.videoFormat;
    AppMethodBeat.o(217890);
    return localMediaFormat;
  }
  
  public int getVideoFrameRate()
  {
    AppMethodBeat.i(217887);
    int i = findVideoFormatValue("frame-rate", this.videoFrameRate);
    AppMethodBeat.o(217887);
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
    AppMethodBeat.i(217879);
    this.audioChannelCount = paramInt;
    initAudioChannelCount();
    AppMethodBeat.o(217879);
  }
  
  public void setAudioEncodeNeedCodecSpecificData(boolean paramBoolean)
  {
    AppMethodBeat.i(217881);
    Logger.i("ExportConfig", "setAudioEncodeNeedCodecSpecificData:".concat(String.valueOf(paramBoolean)));
    this.audioEncodeNeedCodecSpecificData = paramBoolean;
    AppMethodBeat.o(217881);
  }
  
  public void setAudioSampleRateHz(int paramInt)
  {
    AppMethodBeat.i(217880);
    this.audioSampleRateHz = paramInt;
    initAudioSampleRate();
    AppMethodBeat.o(217880);
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
  
  public void setHighProfile(boolean paramBoolean)
  {
    AppMethodBeat.i(217878);
    this.highProfile = paramBoolean;
    initHighProfile();
    AppMethodBeat.o(217878);
  }
  
  public void setOutputFilePath(String paramString)
  {
    this.outputFilePath = paramString;
  }
  
  public void setOutputSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(217874);
    this.outputWidth = paramInt1;
    this.outputHeight = paramInt2;
    initOutputSize();
    AppMethodBeat.o(217874);
  }
  
  public void setVideoBitRate(int paramInt)
  {
    AppMethodBeat.i(217875);
    this.videoBitRate = paramInt;
    initVideoBitrate();
    AppMethodBeat.o(217875);
  }
  
  public void setVideoFrameRate(int paramInt)
  {
    AppMethodBeat.i(217876);
    this.videoFrameRate = paramInt;
    initFrameRate();
    AppMethodBeat.o(217876);
  }
  
  public void setVideoIFrameInterval(int paramInt)
  {
    AppMethodBeat.i(217877);
    this.videoIFrameInterval = paramInt;
    initIFrameInterval();
    AppMethodBeat.o(217877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.core.ExportConfig
 * JD-Core Version:    0.7.0.1
 */