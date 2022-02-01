package com.tencent.trtc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class TRTCCloudDef$TRTCTranscodingConfig
{
  public int appId;
  public int audioBitrate;
  public int audioChannels;
  public int audioSampleRate;
  public int backgroundColor;
  public String backgroundImage;
  public int bizId;
  public ArrayList<TRTCCloudDef.TRTCMixUser> mixUsers;
  public int mode;
  public String streamId;
  public int videoBitrate;
  public int videoFramerate;
  public int videoGOP;
  public int videoHeight;
  public int videoWidth;
  
  public TRTCCloudDef$TRTCTranscodingConfig()
  {
    this.mode = 0;
    this.videoWidth = 0;
    this.videoHeight = 0;
    this.videoBitrate = 0;
    this.videoFramerate = 15;
    this.videoGOP = 2;
    this.backgroundColor = 0;
    this.audioSampleRate = 48000;
    this.audioBitrate = 64;
    this.audioChannels = 1;
    this.streamId = null;
  }
  
  public TRTCCloudDef$TRTCTranscodingConfig(TRTCTranscodingConfig paramTRTCTranscodingConfig)
  {
    AppMethodBeat.i(211259);
    this.appId = paramTRTCTranscodingConfig.appId;
    this.bizId = paramTRTCTranscodingConfig.bizId;
    this.mode = paramTRTCTranscodingConfig.mode;
    this.videoWidth = paramTRTCTranscodingConfig.videoWidth;
    this.videoHeight = paramTRTCTranscodingConfig.videoHeight;
    this.videoBitrate = paramTRTCTranscodingConfig.videoBitrate;
    this.videoFramerate = paramTRTCTranscodingConfig.videoFramerate;
    this.videoGOP = paramTRTCTranscodingConfig.videoGOP;
    this.backgroundColor = paramTRTCTranscodingConfig.backgroundColor;
    this.backgroundImage = paramTRTCTranscodingConfig.backgroundImage;
    this.audioSampleRate = paramTRTCTranscodingConfig.audioSampleRate;
    this.audioBitrate = paramTRTCTranscodingConfig.audioBitrate;
    this.audioChannels = paramTRTCTranscodingConfig.audioChannels;
    this.streamId = paramTRTCTranscodingConfig.streamId;
    this.mixUsers = new ArrayList(paramTRTCTranscodingConfig.mixUsers);
    AppMethodBeat.o(211259);
  }
  
  public String toString()
  {
    AppMethodBeat.i(182442);
    String str = "appId=" + this.appId + ", bizId=" + this.bizId + ", mode=" + this.mode + ", videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", videoBitrate=" + this.videoBitrate + ", videoFramerate=" + this.videoFramerate + ", videoGOP=" + this.videoGOP + ", backgroundColor=" + this.backgroundColor + ", backgroundImage=" + this.backgroundImage + ", audioSampleRate=" + this.audioSampleRate + ", audioBitrate=" + this.audioBitrate + ", audioChannels=" + this.audioChannels + ", streamId=" + this.streamId + ", mixUsers=" + this.mixUsers;
    AppMethodBeat.o(182442);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.trtc.TRTCCloudDef.TRTCTranscodingConfig
 * JD-Core Version:    0.7.0.1
 */