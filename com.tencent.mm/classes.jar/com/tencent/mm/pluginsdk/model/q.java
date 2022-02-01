package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
{
  private int JVm;
  public String JVn;
  public String JVo;
  public String JVp;
  public int JVq;
  public String productId;
  
  q(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    this.JVm = paramInt1;
    this.productId = paramString1;
    this.JVn = paramString2;
    this.JVq = paramInt2;
    this.JVo = paramString3;
    this.JVp = paramString4;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151646);
    String str = "id:" + this.JVm + ";productId:" + this.productId + ";full:" + this.JVn + ";productState:" + this.JVq + ";priceCurrencyCode:" + this.JVo + ";priceAmountMicros:" + this.JVp;
    AppMethodBeat.o(151646);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.q
 * JD-Core Version:    0.7.0.1
 */