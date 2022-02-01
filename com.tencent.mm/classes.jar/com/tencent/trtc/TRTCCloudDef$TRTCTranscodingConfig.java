package com.tencent.trtc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class TRTCCloudDef$TRTCTranscodingConfig
{
  public int appId;
  public int audioBitrate = 64;
  public int audioChannels = 1;
  public int audioSampleRate = 48000;
  public int backgroundColor = 0;
  public int bizId;
  public ArrayList<TRTCCloudDef.TRTCMixUser> mixUsers;
  public int mode = 0;
  public int videoBitrate = 0;
  public int videoFramerate = 15;
  public int videoGOP = 2;
  public int videoHeight = 0;
  public int videoWidth = 0;
  
  public String toString()
  {
    AppMethodBeat.i(182442);
    String str = "TRTCTranscodingConfig{appId=" + this.appId + ", bizId=" + this.bizId + ", mode=" + this.mode + ", videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", videoBitrate=" + this.videoBitrate + ", videoFramerate=" + this.videoFramerate + ", videoGOP=" + this.videoGOP + ", backgroundColor=" + this.backgroundColor + ", audioSampleRate=" + this.audioSampleRate + ", audioBitrate=" + this.audioBitrate + ", audioChannels=" + this.audioChannels + ", mixUsers=" + this.mixUsers + '}';
    AppMethodBeat.o(182442);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.trtc.TRTCCloudDef.TRTCTranscodingConfig
 * JD-Core Version:    0.7.0.1
 */