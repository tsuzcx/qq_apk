package com.tencent.mm.plugin.product.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
{
  int MSl;
  int MSm;
  
  public e(int paramInt1, int paramInt2)
  {
    this.MSm = paramInt1;
    this.MSl = paramInt2;
  }
  
  public final boolean gAx()
  {
    AppMethodBeat.i(66959);
    if ((this.MSm & 0x1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.MallProductConfig", "isFreePost, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(66959);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.e
 * JD-Core Version:    0.7.0.1
 */