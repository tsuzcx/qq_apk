package com.tencent.mm.plugin.product.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
{
  int GUJ;
  int GUK;
  
  public e(int paramInt1, int paramInt2)
  {
    this.GUK = paramInt1;
    this.GUJ = paramInt2;
  }
  
  public final boolean fpt()
  {
    AppMethodBeat.i(66959);
    if ((this.GUK & 0x1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.MallProductConfig", "isFreePost, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(66959);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.e
 * JD-Core Version:    0.7.0.1
 */