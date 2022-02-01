package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w
{
  private int XRu;
  public String XRv;
  public String XRw;
  public String XRx;
  public int XRy;
  public String productId;
  
  w(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    this.XRu = paramInt1;
    this.productId = paramString1;
    this.XRv = paramString2;
    this.XRy = paramInt2;
    this.XRw = paramString3;
    this.XRx = paramString4;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151646);
    String str = "id:" + this.XRu + ";productId:" + this.productId + ";full:" + this.XRv + ";productState:" + this.XRy + ";priceCurrencyCode:" + this.XRw + ";priceAmountMicros:" + this.XRx;
    AppMethodBeat.o(151646);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.w
 * JD-Core Version:    0.7.0.1
 */