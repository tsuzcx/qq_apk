package com.tencent.mm.plugin.sns.data;

public final class p
{
  public int dJd;
  public String desc = "";
  public int fileSize = 0;
  public int height = -1;
  public String path = "";
  public String thumbPath = "";
  public int type;
  public int width = -1;
  public int zdA;
  public int zdB;
  public String zdC = "";
  public String zdD = "";
  public String zdE = "";
  public boolean zdF = false;
  public int zdz = 0;
  
  public p() {}
  
  public p(int paramInt1, int paramInt2)
  {
    this.dJd = paramInt1;
    this.type = paramInt2;
    this.path = "";
  }
  
  public p(String paramString, int paramInt)
  {
    this.path = paramString;
    this.type = paramInt;
    this.dJd = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.p
 * JD-Core Version:    0.7.0.1
 */