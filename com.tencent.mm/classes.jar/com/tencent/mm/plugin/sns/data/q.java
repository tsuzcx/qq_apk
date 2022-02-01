package com.tencent.mm.plugin.sns.data;

public final class q
{
  public int dKr;
  public String desc = "";
  public int fileSize = 0;
  public int height = -1;
  public String path = "";
  public String thumbPath = "";
  public int type;
  public int width = -1;
  public int zup = 0;
  public int zuq;
  public int zur;
  public String zus = "";
  public String zut = "";
  public String zuu = "";
  public boolean zuv = false;
  
  public q() {}
  
  public q(int paramInt1, int paramInt2)
  {
    this.dKr = paramInt1;
    this.type = paramInt2;
    this.path = "";
  }
  
  public q(String paramString, int paramInt)
  {
    this.path = paramString;
    this.type = paramInt;
    this.dKr = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.q
 * JD-Core Version:    0.7.0.1
 */