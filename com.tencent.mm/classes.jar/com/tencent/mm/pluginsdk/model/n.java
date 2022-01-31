package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
{
  public String cqx;
  private int vKv;
  public String vKw;
  public String vKx;
  public String vKy;
  public int vKz;
  
  n(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    this.vKv = paramInt1;
    this.cqx = paramString1;
    this.vKw = paramString2;
    this.vKz = paramInt2;
    this.vKx = paramString3;
    this.vKy = paramString4;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(79224);
    String str = "id:" + this.vKv + ";productId:" + this.cqx + ";full:" + this.vKw + ";productState:" + this.vKz + ";priceCurrencyCode:" + this.vKx + ";priceAmountMicros:" + this.vKy;
    AppMethodBeat.o(79224);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.n
 * JD-Core Version:    0.7.0.1
 */