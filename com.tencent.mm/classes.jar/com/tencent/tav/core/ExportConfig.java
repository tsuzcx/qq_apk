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
    AppMethodBeat.i(217932);
    if ((paramMediaFormat != null) && (paramMediaFormat.containsKey(paramString)))
    {
      paramInt = paramMediaFormat.getInteger(paramString);
      AppMethodBeat.o(217932);
      return paramInt;
    }
    AppMethodBeat.o(217932);
    return paramInt;
  }
  
  private int findVideoFormatValue(String paramString, int paramInt)
  {
    AppMethodBeat.i(217931);
    paramInt = findFormatValue(paramString, paramInt, this.videoFormat);
    AppMethodBeat.o(217931);
    return paramInt;
  }
  
  private void initAudioChannelCount()
  {
    AppMethodBeat.i(217921);
    setToAudioFormat("channel-count", this.audioChannelCount);
    AppMethodBeat.o(217921);
  }
  
  private void initAudioSampleRate()
  {
    AppMethodBeat.i(217926);
    setToAudioFormat("sample-rate", this.audioSampleRateHz);
    AppMethodBeat.o(217926);
  }
  
  private void initFrameRate()
  {
    AppMethodBeat.i(217924);
    setToVideoFormat("frame-rate", this.videoFrameRate);
    AppMethodBeat.o(217924);
  }
  
  private void initHighProfile()
  {
    AppMethodBeat.i(217922);
    if (this.highProfile) {
      CodecHelper.selectProfileAndLevel(this.videoFormat);
    }
    AppMethodBeat.o(217922);
  }
  
  private void initIFrameInterval()
  {
    AppMethodBeat.i(217923);
    setToVideoFormat("i-frame-interval", this.videoIFrameInterval);
    AppMethodBeat.o(217923);
  }
  
  private void initOutputSize()
  {
    AppMethodBeat.i(217927);
    CGSize localCGSize = CodecHelper.correctSupportSize(getOutputSize(), "video/avc");
    setToVideoFormat("width", (int)localCGSize.width);
    setToVideoFormat("height", (int)localCGSize.height);
    AppMethodBeat.o(217927);
  }
  
  private void initVideoBitrate()
  {
    AppMethodBeat.i(217925);
    setToVideoFormat("bitrate", this.videoBitRate);
    AppMethodBeat.o(217925);
  }
  
  private void setToAudioFormat(String paramString, int paramInt)
  {
    AppMethodBeat.i(217929);
    if (this.audioFormat == null) {
      getAudioFormat();
    }
    setToFormat(paramString, paramInt, this.audioFormat);
    AppMethodBeat.o(217929);
  }
  
  private void setToFormat(String paramString, int paramInt, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(217930);
    if (paramMediaFormat == null)
    {
      AppMethodBeat.o(217930);
      return;
    }
    paramMediaFormat.setInteger(paramString, paramInt);
    AppMethodBeat.o(217930);
  }
  
  private void setToVideoFormat(String paramString, int paramInt)
  {
    AppMethodBeat.i(217928);
    if (this.videoFormat == null) {
      getVideoFormat();
    }
    setToFormat(paramString, paramInt, this.videoFormat);
    AppMethodBeat.o(217928);
  }
  
  public boolean available()
  {
    AppMethodBeat.i(217911);
    if ((getOutputWidth() > 0) && (getOutputHeight() > 0))
    {
      AppMethodBeat.o(217911);
      return true;
    }
    AppMethodBeat.o(217911);
    return false;
  }
  
  public ExportConfig clone()
  {
    AppMethodBeat.i(217933);
    ExportConfig localExportConfig = new ExportConfig(this.outputWidth, this.outputHeight);
    localExportConfig.videoBitRate = this.videoBitRate;
    localExportConfig.videoFrameRate = this.videoFrameRate;
    localExportConfig.videoIFrameInterval = this.videoIFrameInterval;
    localExportConfig.outputWidth = this.outputWidth;
    localExportConfig.outputHeight = this.outputHeight;
    localExportConfig.highProfile = this.highProfile;
    localExportConfig.audioBitRate = this.audioBitRate;
    localExportConfig.audioAacProfile = this.audioAacProfile;
    localExportConfig.audioChannelCount = this.audioChannelCount;
    localExportConfig.audioSampleRateHz = this.audioSampleRateHz;
    localExportConfig.audioEncodeNeedCodecSpecificData = this.audioEncodeNeedCodecSpecificData;
    AppMethodBeat.o(217933);
    return localExportConfig;
  }
  
  public int getAudioChannelCount()
  {
    AppMethodBeat.i(217917);
    int i = findFormatValue("channel-count", this.audioChannelCount, this.audioFormat);
    AppMethodBeat.o(217917);
    return i;
  }
  
  public MediaFormat getAudioFormat()
  {
    AppMethodBeat.i(217920);
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
    AppMethodBeat.o(217920);
    return localMediaFormat;
  }
  
  public int getAudioSampleRateHz()
  {
    AppMethodBeat.i(217918);
    int i = findFormatValue("sample-rate", this.audioSampleRateHz, this.audioFormat);
    AppMethodBeat.o(217918);
    return i;
  }
  
  public String getOutputFilePath()
  {
    return this.outputFilePath;
  }
  
  public int getOutputHeight()
  {
    AppMethodBeat.i(217913);
    int i = findVideoFormatValue("height", this.outputHeight);
    AppMethodBeat.o(217913);
    return i;
  }
  
  public CGSize getOutputSize()
  {
    AppMethodBeat.i(217914);
    CGSize localCGSize = new CGSize(getOutputWidth(), getOutputHeight());
    AppMethodBeat.o(217914);
    return localCGSize;
  }
  
  public int getOutputWidth()
  {
    AppMethodBeat.i(217912);
    int i = findVideoFormatValue("width", this.outputWidth);
    AppMethodBeat.o(217912);
    return i;
  }
  
  public int getVideoBitRate()
  {
    AppMethodBeat.i(217915);
    int i = findVideoFormatValue("bitrate", this.videoBitRate);
    AppMethodBeat.o(217915);
    return i;
  }
  
  public MediaFormat getVideoFormat()
  {
    AppMethodBeat.i(217919);
    if (this.videoFormat == null)
    {
      this.videoFormat = new MediaFormat();
      this.videoFormat.setString("mime", "video/avc");
      this.videoFormat.setInteger("color-format", 2130708361);
      initOutputSize();
      initVideoBitrate();
      initFrameRate();
      initIFrameInterval();
      initHighProfile();
    }
    MediaFormat localMediaFormat = this.videoFormat;
    AppMethodBeat.o(217919);
    return localMediaFormat;
  }
  
  public int getVideoFrameRate()
  {
    AppMethodBeat.i(217916);
    int i = findVideoFormatValue("frame-rate", this.videoFrameRate);
    AppMethodBeat.o(217916);
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
    AppMethodBeat.i(217909);
    this.audioChannelCount = paramInt;
    initAudioChannelCount();
    AppMethodBeat.o(217909);
  }
  
  public void setAudioEncodeNeedCodecSpecificData(boolean paramBoolean)
  {
    AppMethodBeat.i(221610);
    Logger.i("ExportConfig", "setAudioEncodeNeedCodecSpecificData:".concat(String.valueOf(paramBoolean)));
    this.audioEncodeNeedCodecSpecificData = paramBoolean;
    AppMethodBeat.o(221610);
  }
  
  public void setAudioSampleRateHz(int paramInt)
  {
    AppMethodBeat.i(217910);
    this.audioSampleRateHz = paramInt;
    initAudioSampleRate();
    AppMethodBeat.o(217910);
  }
  
  public void setHighProfile(boolean paramBoolean)
  {
    AppMethodBeat.i(217908);
    this.highProfile = paramBoolean;
    initHighProfile();
    AppMethodBeat.o(217908);
  }
  
  public void setOutputFilePath(String paramString)
  {
    this.outputFilePath = paramString;
  }
  
  public void setOutputSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(217904);
    this.outputWidth = paramInt1;
    this.outputHeight = paramInt2;
    initOutputSize();
    AppMethodBeat.o(217904);
  }
  
  public void setVideoBitRate(int paramInt)
  {
    AppMethodBeat.i(217905);
    this.videoBitRate = paramInt;
    initVideoBitrate();
    AppMethodBeat.o(217905);
  }
  
  public void setVideoFrameRate(int paramInt)
  {
    AppMethodBeat.i(217906);
    this.videoFrameRate = paramInt;
    initFrameRate();
    AppMethodBeat.o(217906);
  }
  
  public void setVideoIFrameInterval(int paramInt)
  {
    AppMethodBeat.i(217907);
    this.videoIFrameInterval = paramInt;
    initIFrameInterval();
    AppMethodBeat.o(217907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.core.ExportConfig
 * JD-Core Version:    0.7.0.1
 */