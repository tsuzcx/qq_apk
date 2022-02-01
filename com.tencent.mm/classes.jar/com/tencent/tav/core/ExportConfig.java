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
  private int suggestParallelCount = -1;
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
    AppMethodBeat.i(215414);
    if ((paramMediaFormat != null) && (paramMediaFormat.containsKey(paramString)))
    {
      paramInt = paramMediaFormat.getInteger(paramString);
      AppMethodBeat.o(215414);
      return paramInt;
    }
    AppMethodBeat.o(215414);
    return paramInt;
  }
  
  private int findVideoFormatValue(String paramString, int paramInt)
  {
    AppMethodBeat.i(215407);
    paramInt = findFormatValue(paramString, paramInt, this.videoFormat);
    AppMethodBeat.o(215407);
    return paramInt;
  }
  
  private void initAudioChannelCount()
  {
    AppMethodBeat.i(215285);
    setToAudioFormat("channel-count", this.audioChannelCount);
    AppMethodBeat.o(215285);
  }
  
  private void initAudioSampleRate()
  {
    AppMethodBeat.i(215322);
    setToAudioFormat("sample-rate", this.audioSampleRateHz);
    AppMethodBeat.o(215322);
  }
  
  private void initColorSpace()
  {
    AppMethodBeat.i(215336);
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
    AppMethodBeat.o(215336);
  }
  
  private void initFrameRate()
  {
    AppMethodBeat.i(215311);
    setToVideoFormat("frame-rate", this.videoFrameRate);
    AppMethodBeat.o(215311);
  }
  
  private void initHdrInfo()
  {
    AppMethodBeat.i(215349);
    if ((Build.VERSION.SDK_INT >= 24) && (this.hdrStaticInfo != null)) {
      setToVideoFormat("hdr-static-info", this.hdrStaticInfo);
    }
    AppMethodBeat.o(215349);
  }
  
  private void initHighProfile()
  {
    AppMethodBeat.i(215293);
    if ((this.highProfile) && (this.videoMimeType.equalsIgnoreCase("video/avc"))) {
      CodecHelper.selectProfileAndLevel(this.videoFormat);
    }
    AppMethodBeat.o(215293);
  }
  
  private void initIFrameInterval()
  {
    AppMethodBeat.i(215301);
    setToVideoFormat("i-frame-interval", this.videoIFrameInterval);
    AppMethodBeat.o(215301);
  }
  
  private void initOutputSize()
  {
    AppMethodBeat.i(215329);
    Logger.i("ExportConfig", "initOutputSize, correctSizeByCodecCapabilities:" + this.correctSizeByCodecCapabilities);
    if (this.correctSizeByCodecCapabilities)
    {
      CGSize localCGSize = CodecHelper.correctSupportSize(getOutputSize(), "video/avc");
      setToVideoFormat("width", (int)localCGSize.width);
      setToVideoFormat("height", (int)localCGSize.height);
      AppMethodBeat.o(215329);
      return;
    }
    setToVideoFormat("width", (int)getOutputSize().width);
    setToVideoFormat("height", (int)getOutputSize().height);
    AppMethodBeat.o(215329);
  }
  
  private void initVideoBitrate()
  {
    AppMethodBeat.i(215316);
    setToVideoFormat("bitrate", this.videoBitRate);
    AppMethodBeat.o(215316);
  }
  
  private void setToAudioFormat(String paramString, int paramInt)
  {
    AppMethodBeat.i(215378);
    if (this.audioFormat == null) {
      getAudioFormat();
    }
    setToFormat(paramString, paramInt, this.audioFormat);
    AppMethodBeat.o(215378);
  }
  
  private void setToFormat(String paramString, int paramInt, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(215383);
    if (paramMediaFormat == null)
    {
      AppMethodBeat.o(215383);
      return;
    }
    paramMediaFormat.setInteger(paramString, paramInt);
    AppMethodBeat.o(215383);
  }
  
  private void setToFormat(String paramString, ByteBuffer paramByteBuffer, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(215397);
    if (paramMediaFormat == null)
    {
      AppMethodBeat.o(215397);
      return;
    }
    paramMediaFormat.setByteBuffer(paramString, paramByteBuffer);
    AppMethodBeat.o(215397);
  }
  
  private void setToVideoFormat(String paramString, int paramInt)
  {
    AppMethodBeat.i(215356);
    if (this.videoFormat == null) {
      getVideoFormat();
    }
    setToFormat(paramString, paramInt, this.videoFormat);
    AppMethodBeat.o(215356);
  }
  
  private void setToVideoFormat(String paramString, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(215366);
    if (this.videoFormat == null) {
      getVideoFormat();
    }
    setToFormat(paramString, paramByteBuffer, this.videoFormat);
    AppMethodBeat.o(215366);
  }
  
  public boolean available()
  {
    AppMethodBeat.i(215523);
    if ((getOutputWidth() > 0) && (getOutputHeight() > 0))
    {
      AppMethodBeat.o(215523);
      return true;
    }
    AppMethodBeat.o(215523);
    return false;
  }
  
  public ExportConfig clone()
  {
    AppMethodBeat.i(215605);
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
    localExportConfig.suggestParallelCount = this.suggestParallelCount;
    AppMethodBeat.o(215605);
    return localExportConfig;
  }
  
  public int getAudioChannelCount()
  {
    AppMethodBeat.i(215557);
    int i = findFormatValue("channel-count", this.audioChannelCount, this.audioFormat);
    AppMethodBeat.o(215557);
    return i;
  }
  
  public MediaFormat getAudioFormat()
  {
    AppMethodBeat.i(215583);
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
    AppMethodBeat.o(215583);
    return localMediaFormat;
  }
  
  public int getAudioSampleRateHz()
  {
    AppMethodBeat.i(215566);
    int i = findFormatValue("sample-rate", this.audioSampleRateHz, this.audioFormat);
    AppMethodBeat.o(215566);
    return i;
  }
  
  public String getOutputFilePath()
  {
    return this.outputFilePath;
  }
  
  public int getOutputHeight()
  {
    AppMethodBeat.i(215529);
    int i = findVideoFormatValue("height", this.outputHeight);
    AppMethodBeat.o(215529);
    return i;
  }
  
  public CGSize getOutputSize()
  {
    AppMethodBeat.i(215535);
    CGSize localCGSize = new CGSize(getOutputWidth(), getOutputHeight());
    AppMethodBeat.o(215535);
    return localCGSize;
  }
  
  public int getOutputWidth()
  {
    AppMethodBeat.i(215526);
    int i = findVideoFormatValue("width", this.outputWidth);
    AppMethodBeat.o(215526);
    return i;
  }
  
  public int getSuggestParallelCount()
  {
    return this.suggestParallelCount;
  }
  
  public int getVideoBitRate()
  {
    AppMethodBeat.i(215542);
    int i = findVideoFormatValue("bitrate", this.videoBitRate);
    AppMethodBeat.o(215542);
    return i;
  }
  
  public MediaFormat getVideoFormat()
  {
    AppMethodBeat.i(215574);
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
    AppMethodBeat.o(215574);
    return localMediaFormat;
  }
  
  public int getVideoFrameRate()
  {
    AppMethodBeat.i(215547);
    int i = findVideoFormatValue("frame-rate", this.videoFrameRate);
    AppMethodBeat.o(215547);
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
    AppMethodBeat.i(215471);
    this.audioChannelCount = paramInt;
    initAudioChannelCount();
    AppMethodBeat.o(215471);
  }
  
  public void setAudioEncodeNeedCodecSpecificData(boolean paramBoolean)
  {
    AppMethodBeat.i(215488);
    Logger.i("ExportConfig", "setAudioEncodeNeedCodecSpecificData:".concat(String.valueOf(paramBoolean)));
    this.audioEncodeNeedCodecSpecificData = paramBoolean;
    AppMethodBeat.o(215488);
  }
  
  public void setAudioSampleRateHz(int paramInt)
  {
    AppMethodBeat.i(215479);
    this.audioSampleRateHz = paramInt;
    initAudioSampleRate();
    AppMethodBeat.o(215479);
  }
  
  public void setColorSpace(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(215458);
    this.colorRange = paramInt1;
    this.colorStandard = paramInt2;
    this.colorTransfer = paramInt3;
    initColorSpace();
    AppMethodBeat.o(215458);
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
    AppMethodBeat.i(215464);
    this.hdrStaticInfo = paramByteBuffer;
    initHdrInfo();
    AppMethodBeat.o(215464);
  }
  
  public void setHighProfile(boolean paramBoolean)
  {
    AppMethodBeat.i(215448);
    this.highProfile = paramBoolean;
    initHighProfile();
    AppMethodBeat.o(215448);
  }
  
  public void setNeedCorrectSizeByCodecCapabilities(boolean paramBoolean)
  {
    AppMethodBeat.i(215496);
    Logger.i("ExportConfig", "setNeedCorrectSizeByCodecCapabilities:".concat(String.valueOf(paramBoolean)));
    this.correctSizeByCodecCapabilities = paramBoolean;
    AppMethodBeat.o(215496);
  }
  
  public void setOutputFilePath(String paramString)
  {
    this.outputFilePath = paramString;
  }
  
  public void setOutputSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(215428);
    this.outputWidth = paramInt1;
    this.outputHeight = paramInt2;
    initOutputSize();
    AppMethodBeat.o(215428);
  }
  
  public void setSuggestParallelCount(int paramInt)
  {
    this.suggestParallelCount = paramInt;
  }
  
  public void setVideoBitRate(int paramInt)
  {
    AppMethodBeat.i(215434);
    this.videoBitRate = paramInt;
    initVideoBitrate();
    AppMethodBeat.o(215434);
  }
  
  public void setVideoFrameRate(int paramInt)
  {
    AppMethodBeat.i(215439);
    this.videoFrameRate = paramInt;
    initFrameRate();
    AppMethodBeat.o(215439);
  }
  
  public void setVideoIFrameInterval(int paramInt)
  {
    AppMethodBeat.i(215444);
    this.videoIFrameInterval = paramInt;
    initIFrameInterval();
    AppMethodBeat.o(215444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.ExportConfig
 * JD-Core Version:    0.7.0.1
 */