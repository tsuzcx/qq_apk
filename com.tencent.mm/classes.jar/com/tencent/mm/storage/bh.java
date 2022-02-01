package com.tencent.mm.storage;

public final class bh
{
  public String OpA;
  public String OpB;
  public int Opv;
  private boolean Opw = false;
  public int Opx;
  public int Opy;
  public String Opz;
  public String productId;
  public String rjt;
  
  public bh()
  {
    this.Opv = -1;
  }
  
  public bh(String paramString)
  {
    this.productId = paramString;
    this.Opv = -1;
  }
  
  public final void akj(int paramInt)
  {
    if ((this.Opv != -1) && (this.Opv != paramInt) && (paramInt == 7)) {
      this.Opw = true;
    }
    this.Opv = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.bh
 * JD-Core Version:    0.7.0.1
 */