package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
{
  private int Dhn;
  public String Dho;
  public String Dhp;
  public String Dhq;
  public int Dhr;
  public String dcO;
  
  p(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    this.Dhn = paramInt1;
    this.dcO = paramString1;
    this.Dho = paramString2;
    this.Dhr = paramInt2;
    this.Dhp = paramString3;
    this.Dhq = paramString4;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151646);
    String str = "id:" + this.Dhn + ";productId:" + this.dcO + ";full:" + this.Dho + ";productState:" + this.Dhr + ";priceCurrencyCode:" + this.Dhp + ";priceAmountMicros:" + this.Dhq;
    AppMethodBeat.o(151646);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.p
 * JD-Core Version:    0.7.0.1
 */