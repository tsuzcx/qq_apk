package com.tencent.mm.plugin.product.ui;

import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MallProductUI$1
  implements f.a
{
  MallProductUI$1(MallProductUI paramMallProductUI) {}
  
  public final void w(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(44157);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.pxl.bJ();
      if (MallProductUI.a(this.pxl) != null)
      {
        MallProductUI.a(this.pxl).postDelayed(new MallProductUI.1.1(this), 200L);
        AppMethodBeat.o(44157);
      }
    }
    else
    {
      if (paramInt2 == -10010003)
      {
        this.pxl.setContentViewVisibility(0);
        MallProductUI.b(this.pxl).setVisibility(8);
        MallProductUI.c(this.pxl).setVisibility(0);
        MallProductUI.d(this.pxl);
        AppMethodBeat.o(44157);
        return;
      }
      this.pxl.WW(paramString);
    }
    AppMethodBeat.o(44157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductUI.1
 * JD-Core Version:    0.7.0.1
 */