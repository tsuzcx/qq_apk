package com.tencent.mm.plugin.sns.data;

public final class q
{
  public int DEA;
  public int DEB;
  public String DEC = "";
  public String DED = "";
  public String DEE = "";
  public boolean DEF = false;
  public int DEz = 0;
  public String desc = "";
  public int ecf;
  public int fileSize = 0;
  public int height = -1;
  public String path = "";
  public String thumbPath = "";
  public int type;
  public int width = -1;
  
  public q() {}
  
  public q(int paramInt1, int paramInt2)
  {
    this.ecf = paramInt1;
    this.type = paramInt2;
    this.path = "";
  }
  
  public q(String paramString, int paramInt)
  {
    this.path = paramString;
    this.type = paramInt;
    this.ecf = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.q
 * JD-Core Version:    0.7.0.1
 */