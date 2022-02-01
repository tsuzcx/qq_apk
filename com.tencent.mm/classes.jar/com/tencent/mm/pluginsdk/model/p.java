package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
{
  private int BOZ;
  public String BPa;
  public String BPb;
  public String BPc;
  public int BPd;
  public String dft;
  
  p(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    this.BOZ = paramInt1;
    this.dft = paramString1;
    this.BPa = paramString2;
    this.BPd = paramInt2;
    this.BPb = paramString3;
    this.BPc = paramString4;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151646);
    String str = "id:" + this.BOZ + ";productId:" + this.dft + ";full:" + this.BPa + ";productState:" + this.BPd + ";priceCurrencyCode:" + this.BPb + ";priceAmountMicros:" + this.BPc;
    AppMethodBeat.o(151646);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.p
 * JD-Core Version:    0.7.0.1
 */