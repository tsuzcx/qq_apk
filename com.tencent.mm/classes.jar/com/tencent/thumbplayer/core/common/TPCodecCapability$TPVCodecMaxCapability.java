package com.tencent.thumbplayer.core.common;

import java.io.Serializable;

public class TPCodecCapability$TPVCodecMaxCapability
  implements Serializable
{
  public int maxFramerateFormaxLumaSamples;
  public int maxLevel;
  public int maxLumaSamples;
  public int maxProfile;
  
  @Deprecated
  TPCodecCapability$TPVCodecMaxCapability(int paramInt1, int paramInt2, int paramInt3)
  {
    this.maxLumaSamples = paramInt1;
    this.maxProfile = paramInt2;
    this.maxLevel = paramInt3;
    this.maxFramerateFormaxLumaSamples = 30;
  }
  
  TPCodecCapability$TPVCodecMaxCapability(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.maxLumaSamples = paramInt1;
    this.maxProfile = paramInt2;
    this.maxLevel = paramInt3;
    this.maxFramerateFormaxLumaSamples = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPCodecCapability.TPVCodecMaxCapability
 * JD-Core Version:    0.7.0.1
 */