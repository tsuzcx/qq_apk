package com.tencent.mm.plugin.product.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class e
{
  int vGo;
  int vGp;
  
  public e(int paramInt1, int paramInt2)
  {
    this.vGp = paramInt1;
    this.vGo = paramInt2;
  }
  
  public final boolean dpp()
  {
    AppMethodBeat.i(66959);
    if ((this.vGp & 0x1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.MallProductConfig", "isFreePost, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(66959);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.e
 * JD-Core Version:    0.7.0.1
 */