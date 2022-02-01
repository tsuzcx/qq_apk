package com.tencent.thumbplayer.core.common;

import java.io.Serializable;

public class TPCodecCapability$TPVCodecPropertyRange
  implements Serializable
{
  public int level;
  public int lowerboundHeight;
  public int lowerboundWidth;
  public int profile;
  public int upperboundHeight;
  public int upperboundWidth;
  
  public void set(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.upperboundWidth = paramInt1;
    this.upperboundHeight = paramInt2;
    this.lowerboundWidth = paramInt3;
    this.lowerboundHeight = paramInt4;
    this.profile = paramInt5;
    this.level = paramInt6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPCodecCapability.TPVCodecPropertyRange
 * JD-Core Version:    0.7.0.1
 */