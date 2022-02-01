package com.tencent.mm.plugin.product.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
{
  int uxv;
  int uxw;
  
  public e(int paramInt1, int paramInt2)
  {
    this.uxw = paramInt1;
    this.uxv = paramInt2;
  }
  
  public final boolean dbH()
  {
    AppMethodBeat.i(66959);
    if ((this.uxw & 0x1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.MallProductConfig", "isFreePost, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(66959);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.e
 * JD-Core Version:    0.7.0.1
 */