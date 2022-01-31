package com.tencent.mm.plugin.product.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MallProductSelectSkuUI$3
  implements MallProductSelectAmountView.a
{
  MallProductSelectSkuUI$3(MallProductSelectSkuUI paramMallProductSelectSkuUI) {}
  
  public final void fi(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44108);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(44108);
      return;
      MallProductSelectSkuUI.c(this.pwB).setText(2131301478);
      MallProductSelectSkuUI.c(this.pwB).setVisibility(0);
      AppMethodBeat.o(44108);
      return;
      MallProductSelectSkuUI.c(this.pwB).setText(this.pwB.getString(2131301479, new Object[] { Integer.valueOf(paramInt1) }));
      MallProductSelectSkuUI.c(this.pwB).setVisibility(0);
    }
  }
  
  public final void gz(int paramInt)
  {
    AppMethodBeat.i(44107);
    MallProductSelectSkuUI.b(this.pwB).mCount = paramInt;
    MallProductSelectSkuUI.c(this.pwB).setVisibility(8);
    AppMethodBeat.o(44107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSelectSkuUI.3
 * JD-Core Version:    0.7.0.1
 */