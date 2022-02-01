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
    AppMethodBeat.i(214571);
    if ((paramMediaFormat != null) && (paramMediaFormat.containsKey(paramString)))
    {
      paramInt = paramMediaFormat.getInteger(paramString);
      AppMethodBeat.o(214571);
      return paramInt;
    }
    AppMethodBeat.o(214571);
    return paramInt;
  }
  
  private int findVideoFormatValue(String paramString, int paramInt)
  {
    AppMethodBeat.i(214570);
    paramInt = findFormatValue(paramString, paramInt, this.videoFormat);
    AppMethodBeat.o(214570);
    return paramInt;
  }
  
  private void initAudioChannelCount()
  {
    AppMethodBeat.i(214560);
    setToAudioFormat("channel-count", this.audioChannelCount);
    AppMethodBeat.o(214560);
  }
  
  private void initAudioSampleRate()
  {
    AppMethodBeat.i(214565);
    setToAudioFormat("sample-rate", this.audioSampleRateHz);
    AppMethodBeat.o(214565);
  }
  
  private void initFrameRate()
  {
    AppMethodBeat.i(214563);
    setToVideoFormat("frame-rate", this.videoFrameRate);
    AppMethodBeat.o(214563);
  }
  
  private void initHighProfile()
  {
    AppMethodBeat.i(214561);
    if (this.highProfile) {
      CodecHelper.selectProfileAndLevel(this.videoFormat);
    }
    AppMethodBeat.o(214561);
  }
  
  private void initIFrameInterval()
  {
    AppMethodBeat.i(214562);
    setToVideoFormat("i-frame-interval", this.videoIFrameInterval);
    AppMethodBeat.o(214562);
  }
  
  private void initOutputSize()
  {
    AppMethodBeat.i(214566);
    CGSize localCGSize = CodecHelper.correctSupportSize(getOutputSize(), "video/avc");
    setToVideoFormat("width", (int)localCGSize.width);
    setToVideoFormat("height", (int)localCGSize.height);
    AppMethodBeat.o(214566);
  }
  
  private void initVideoBitrate()
  {
    AppMethodBeat.i(214564);
    setToVideoFormat("bitrate", this.videoBitRate);
    AppMethodBeat.o(214564);
  }
  
  private void setToAudioFormat(String paramString, int paramInt)
  {
    AppMethodBeat.i(214568);
    if (this.audioFormat == null) {
      getAudioFormat();
    }
    setToFormat(paramString, paramInt, this.audioFormat);
    AppMethodBeat.o(214568);
  }
  
  private void setToFormat(String paramString, int paramInt, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(214569);
    if (paramMediaFormat == null)
    {
      AppMethodBeat.o(214569);
      return;
    }
    paramMediaFormat.setInteger(paramString, paramInt);
    AppMethodBeat.o(214569);
  }
  
  private void setToVideoFormat(String paramString, int paramInt)
  {
    AppMethodBeat.i(214567);
    if (this.videoFormat == null) {
      getVideoFormat();
    }
    setToFormat(paramString, paramInt, this.videoFormat);
    AppMethodBeat.o(214567);
  }
  
  public boolean available()
  {
    AppMethodBeat.i(214550);
    if ((getOutputWidth() > 0) && (getOutputHeight() > 0))
    {
      AppMethodBeat.o(214550);
      return true;
    }
    AppMethodBeat.o(214550);
    return false;
  }
  
  public ExportConfig clone()
  {
    AppMethodBeat.i(214572);
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
    AppMethodBeat.o(214572);
    return localExportConfig;
  }
  
  public int getAudioChannelCount()
  {
    AppMethodBeat.i(214556);
    int i = findFormatValue("channel-count", this.audioChannelCount, this.audioFormat);
    AppMethodBeat.o(214556);
    return i;
  }
  
  public MediaFormat getAudioFormat()
  {
    AppMethodBeat.i(214559);
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
    AppMethodBeat.o(214559);
    return localMediaFormat;
  }
  
  public int getAudioSampleRateHz()
  {
    AppMethodBeat.i(214557);
    int i = findFormatValue("sample-rate", this.audioSampleRateHz, this.audioFormat);
    AppMethodBeat.o(214557);
    return i;
  }
  
  public String getOutputFilePath()
  {
    return this.outputFilePath;
  }
  
  public int getOutputHeight()
  {
    AppMethodBeat.i(214552);
    int i = findVideoFormatValue("height", this.outputHeight);
    AppMethodBeat.o(214552);
    return i;
  }
  
  public CGSize getOutputSize()
  {
    AppMethodBeat.i(214553);
    CGSize localCGSize = new CGSize(getOutputWidth(), getOutputHeight());
    AppMethodBeat.o(214553);
    return localCGSize;
  }
  
  public int getOutputWidth()
  {
    AppMethodBeat.i(214551);
    int i = findVideoFormatValue("width", this.outputWidth);
    AppMethodBeat.o(214551);
    return i;
  }
  
  public int getVideoBitRate()
  {
    AppMethodBeat.i(214554);
    int i = findVideoFormatValue("bitrate", this.videoBitRate);
    AppMethodBeat.o(214554);
    return i;
  }
  
  public MediaFormat getVideoFormat()
  {
    AppMethodBeat.i(214558);
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
    AppMethodBeat.o(214558);
    return localMediaFormat;
  }
  
  public int getVideoFrameRate()
  {
    AppMethodBeat.i(214555);
    int i = findVideoFormatValue("frame-rate", this.videoFrameRate);
    AppMethodBeat.o(214555);
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
    AppMethodBeat.i(214547);
    this.audioChannelCount = paramInt;
    initAudioChannelCount();
    AppMethodBeat.o(214547);
  }
  
  public void setAudioEncodeNeedCodecSpecificData(boolean paramBoolean)
  {
    AppMethodBeat.i(214549);
    Logger.i("ExportConfig", "setAudioEncodeNeedCodecSpecificData:".concat(String.valueOf(paramBoolean)));
    this.audioEncodeNeedCodecSpecificData = paramBoolean;
    AppMethodBeat.o(214549);
  }
  
  public void setAudioSampleRateHz(int paramInt)
  {
    AppMethodBeat.i(214548);
    this.audioSampleRateHz = paramInt;
    initAudioSampleRate();
    AppMethodBeat.o(214548);
  }
  
  public void setHighProfile(boolean paramBoolean)
  {
    AppMethodBeat.i(214546);
    this.highProfile = paramBoolean;
    initHighProfile();
    AppMethodBeat.o(214546);
  }
  
  public void setOutputFilePath(String paramString)
  {
    this.outputFilePath = paramString;
  }
  
  public void setOutputSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(214542);
    this.outputWidth = paramInt1;
    this.outputHeight = paramInt2;
    initOutputSize();
    AppMethodBeat.o(214542);
  }
  
  public void setVideoBitRate(int paramInt)
  {
    AppMethodBeat.i(214543);
    this.videoBitRate = paramInt;
    initVideoBitrate();
    AppMethodBeat.o(214543);
  }
  
  public void setVideoFrameRate(int paramInt)
  {
    AppMethodBeat.i(214544);
    this.videoFrameRate = paramInt;
    initFrameRate();
    AppMethodBeat.o(214544);
  }
  
  public void setVideoIFrameInterval(int paramInt)
  {
    AppMethodBeat.i(214545);
    this.videoIFrameInterval = paramInt;
    initIFrameInterval();
    AppMethodBeat.o(214545);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.core.ExportConfig
 * JD-Core Version:    0.7.0.1
 */