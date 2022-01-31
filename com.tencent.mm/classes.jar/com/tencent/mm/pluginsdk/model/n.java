package com.tencent.mm.pluginsdk.model;

public final class n
{
  public String bJd;
  public String rTA;
  public String rTB;
  public int rTC;
  private int rTy;
  public String rTz;
  
  n(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    this.rTy = paramInt1;
    this.bJd = paramString1;
    this.rTz = paramString2;
    this.rTC = paramInt2;
    this.rTA = paramString3;
    this.rTB = paramString4;
  }
  
  public final String toString()
  {
    return "id:" + this.rTy + ";productId:" + this.bJd + ";full:" + this.rTz + ";productState:" + this.rTC + ";priceCurrencyCode:" + this.rTA + ";priceAmountMicros:" + this.rTB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.n
 * JD-Core Version:    0.7.0.1
 */