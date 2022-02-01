package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u
{
  public String QVA;
  public int QVB;
  private int QVx;
  public String QVy;
  public String QVz;
  public String productId;
  
  u(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    this.QVx = paramInt1;
    this.productId = paramString1;
    this.QVy = paramString2;
    this.QVB = paramInt2;
    this.QVz = paramString3;
    this.QVA = paramString4;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151646);
    String str = "id:" + this.QVx + ";productId:" + this.productId + ";full:" + this.QVy + ";productState:" + this.QVB + ";priceCurrencyCode:" + this.QVz + ";priceAmountMicros:" + this.QVA;
    AppMethodBeat.o(151646);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.u
 * JD-Core Version:    0.7.0.1
 */