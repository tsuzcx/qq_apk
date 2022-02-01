package com.tencent.mm.plugin.sns.data;

public final class p
{
  public String desc = "";
  public int dzf;
  public int fileSize = 0;
  public int height = -1;
  public String path = "";
  public String thumbPath = "";
  public int type;
  public int wBk = 0;
  public int wBl;
  public int wBm;
  public String wBn = "";
  public String wBo = "";
  public String wBp = "";
  public boolean wBq = false;
  public int width = -1;
  
  public p() {}
  
  public p(int paramInt1, int paramInt2)
  {
    this.dzf = paramInt1;
    this.type = paramInt2;
    this.path = "";
  }
  
  public p(String paramString, int paramInt)
  {
    this.path = paramString;
    this.type = paramInt;
    this.dzf = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.p
 * JD-Core Version:    0.7.0.1
 */