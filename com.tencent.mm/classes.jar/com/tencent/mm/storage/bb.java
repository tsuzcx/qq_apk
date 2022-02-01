package com.tencent.mm.storage;

public final class bb
{
  public int IKV;
  private boolean IKW = false;
  public int IKX;
  public int IKY;
  public String IKZ;
  public String ILa;
  public String ILb;
  public String dok;
  public String pLO;
  
  public bb()
  {
    this.IKV = -1;
  }
  
  public bb(String paramString)
  {
    this.dok = paramString;
    this.IKV = -1;
  }
  
  public final void aaT(int paramInt)
  {
    if ((this.IKV != -1) && (this.IKV != paramInt) && (paramInt == 7)) {
      this.IKW = true;
    }
    this.IKV = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.bb
 * JD-Core Version:    0.7.0.1
 */