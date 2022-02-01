package com.tencent.mm.plugin.sns.data;

public final class p
{
  public String desc = "";
  public int dwR;
  public int fileSize = 0;
  public int height = -1;
  public String path = "";
  public String thumbPath = "";
  public int type;
  public int width = -1;
  public int xNF = 0;
  public int xNG;
  public int xNH;
  public String xNI = "";
  public String xNJ = "";
  public String xNK = "";
  public boolean xNL = false;
  
  public p() {}
  
  public p(int paramInt1, int paramInt2)
  {
    this.dwR = paramInt1;
    this.type = paramInt2;
    this.path = "";
  }
  
  public p(String paramString, int paramInt)
  {
    this.path = paramString;
    this.type = paramInt;
    this.dwR = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.p
 * JD-Core Version:    0.7.0.1
 */