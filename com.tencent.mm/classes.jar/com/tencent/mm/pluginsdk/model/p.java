package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
{
  private int ELX;
  public String ELY;
  public String ELZ;
  public String EMa;
  public int EMb;
  public String dok;
  
  p(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    this.ELX = paramInt1;
    this.dok = paramString1;
    this.ELY = paramString2;
    this.EMb = paramInt2;
    this.ELZ = paramString3;
    this.EMa = paramString4;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151646);
    String str = "id:" + this.ELX + ";productId:" + this.dok + ";full:" + this.ELY + ";productState:" + this.EMb + ";priceCurrencyCode:" + this.ELZ + ";priceAmountMicros:" + this.EMa;
    AppMethodBeat.o(151646);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.p
 * JD-Core Version:    0.7.0.1
 */