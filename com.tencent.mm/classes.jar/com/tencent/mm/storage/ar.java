package com.tencent.mm.storage;

public final class ar
{
  public String bJd;
  public String jfG;
  public int uAM;
  private boolean uAN = false;
  public int uAO;
  public int uAP;
  public String uAQ;
  
  public ar()
  {
    this.uAM = -1;
  }
  
  public ar(String paramString)
  {
    this.bJd = paramString;
    this.uAM = -1;
  }
  
  public final void Fo(int paramInt)
  {
    if ((this.uAM != -1) && (this.uAM != paramInt) && (paramInt == 7)) {
      this.uAN = true;
    }
    this.uAM = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storage.ar
 * JD-Core Version:    0.7.0.1
 */