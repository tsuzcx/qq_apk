package com.tencent.mm.plugin.product.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class MallProductSelectSkuUI$1
  implements f.a
{
  MallProductSelectSkuUI$1(MallProductSelectSkuUI paramMallProductSelectSkuUI) {}
  
  public final void w(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(44105);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      MallProductSelectSkuUI.a(this.pwB);
      AppMethodBeat.o(44105);
      return;
    }
    this.pwB.WW(paramString);
    AppMethodBeat.o(44105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSelectSkuUI.1
 * JD-Core Version:    0.7.0.1
 */