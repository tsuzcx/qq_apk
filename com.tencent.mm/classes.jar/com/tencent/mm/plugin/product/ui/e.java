package com.tencent.mm.plugin.product.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class e
{
  int xdj;
  int xdk;
  
  public e(int paramInt1, int paramInt2)
  {
    this.xdk = paramInt1;
    this.xdj = paramInt2;
  }
  
  public final boolean dDi()
  {
    AppMethodBeat.i(66959);
    if ((this.xdk & 0x1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.MallProductConfig", "isFreePost, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(66959);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.e
 * JD-Core Version:    0.7.0.1
 */