package com.tencent.mm.storage;

public final class ar
{
  public String cqx;
  public String loz;
  public int yMV;
  private boolean yMW = false;
  public int yMX;
  public int yMY;
  public String yMZ;
  public String yNa;
  public String yNb;
  
  public ar()
  {
    this.yMV = -1;
  }
  
  public ar(String paramString)
  {
    this.cqx = paramString;
    this.yMV = -1;
  }
  
  public final void Nu(int paramInt)
  {
    if ((this.yMV != -1) && (this.yMV != paramInt) && (paramInt == 7)) {
      this.yMW = true;
    }
    this.yMV = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storage.ar
 * JD-Core Version:    0.7.0.1
 */