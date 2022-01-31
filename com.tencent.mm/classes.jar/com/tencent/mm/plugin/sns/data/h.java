package com.tencent.mm.plugin.sns.data;

public final class h
{
  public int cIp;
  public String desc = "";
  public int fileSize = 0;
  public int filterId = 0;
  public int height = -1;
  public String path = "";
  public int rbq;
  public int rbr;
  public String rbs = "";
  public String rbt = "";
  public String rbu = "";
  public boolean rbv = false;
  public String thumbPath = "";
  public int type;
  public int width = -1;
  
  public h() {}
  
  public h(int paramInt1, int paramInt2)
  {
    this.cIp = paramInt1;
    this.type = paramInt2;
    this.path = "";
  }
  
  public h(String paramString, int paramInt)
  {
    this.path = paramString;
    this.type = paramInt;
    this.cIp = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.h
 * JD-Core Version:    0.7.0.1
 */