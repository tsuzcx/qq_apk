package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
{
  private int Fev;
  public String Few;
  public String Fex;
  public String Fey;
  public int Fez;
  public String dpp;
  
  p(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    this.Fev = paramInt1;
    this.dpp = paramString1;
    this.Few = paramString2;
    this.Fez = paramInt2;
    this.Fex = paramString3;
    this.Fey = paramString4;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151646);
    String str = "id:" + this.Fev + ";productId:" + this.dpp + ";full:" + this.Few + ";productState:" + this.Fez + ";priceCurrencyCode:" + this.Fex + ";priceAmountMicros:" + this.Fey;
    AppMethodBeat.o(151646);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.p
 * JD-Core Version:    0.7.0.1
 */