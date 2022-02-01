package com.tencent.mm.plugin.sns.data;

public final class s
{
  public int Qof = 0;
  public int Qog;
  public int Qoh;
  public String Qoi = "";
  public String Qoj = "";
  public String Qok = "";
  public boolean Qol = false;
  public String desc = "";
  public int fileSize = 0;
  public int height = -1;
  public int icg;
  public String path = "";
  public String thumbPath = "";
  public int type;
  public int width = -1;
  
  public s() {}
  
  public s(int paramInt1, int paramInt2)
  {
    this.icg = paramInt1;
    this.type = paramInt2;
    this.path = "";
  }
  
  public s(String paramString, int paramInt)
  {
    this.path = paramString;
    this.type = paramInt;
    this.icg = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.s
 * JD-Core Version:    0.7.0.1
 */