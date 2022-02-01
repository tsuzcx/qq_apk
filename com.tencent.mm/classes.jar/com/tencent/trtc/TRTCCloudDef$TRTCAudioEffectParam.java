package com.tencent.trtc;

public class TRTCCloudDef$TRTCAudioEffectParam
{
  public int effectId;
  public int loopCount;
  public String path;
  public boolean publish;
  public int volume;
  
  public TRTCCloudDef$TRTCAudioEffectParam(int paramInt, String paramString)
  {
    this.path = paramString;
    this.effectId = paramInt;
    this.loopCount = 0;
    this.publish = false;
    this.volume = 100;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.trtc.TRTCCloudDef.TRTCAudioEffectParam
 * JD-Core Version:    0.7.0.1
 */