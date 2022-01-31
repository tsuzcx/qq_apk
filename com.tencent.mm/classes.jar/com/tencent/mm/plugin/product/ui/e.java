package com.tencent.mm.plugin.product.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class e
{
  int pvN;
  int pvO;
  
  public e(int paramInt1, int paramInt2)
  {
    this.pvO = paramInt1;
    this.pvN = paramInt2;
  }
  
  public final boolean cbs()
  {
    AppMethodBeat.i(44052);
    if ((this.pvO & 0x1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.MallProductConfig", "isFreePost, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(44052);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.e
 * JD-Core Version:    0.7.0.1
 */