package com.tencent.mm.plugin.sns.data;

public final class s
{
  public boolean JRA = false;
  public int JRu = 0;
  public int JRv;
  public int JRw;
  public String JRx = "";
  public String JRy = "";
  public String JRz = "";
  public String desc = "";
  public int fWh;
  public int fileSize = 0;
  public int height = -1;
  public String path = "";
  public String thumbPath = "";
  public int type;
  public int width = -1;
  
  public s() {}
  
  public s(int paramInt1, int paramInt2)
  {
    this.fWh = paramInt1;
    this.type = paramInt2;
    this.path = "";
  }
  
  public s(String paramString, int paramInt)
  {
    this.path = paramString;
    this.type = paramInt;
    this.fWh = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.s
 * JD-Core Version:    0.7.0.1
 */