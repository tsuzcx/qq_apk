package com.tencent.mm.plugin.product.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.sdk.platformtools.bo;

final class MallProductUI$2
  implements MenuItem.OnMenuItemClickListener
{
  MallProductUI$2(MallProductUI paramMallProductUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(44158);
    paramMenuItem = MallProductUI.e(this.pxl);
    if (!bo.isNullOrNil(paramMenuItem.pvR.ptW))
    {
      g.RM();
      g.RK().eHt.a(new com.tencent.mm.plugin.product.b.f(paramMenuItem.pvR.cbj(), paramMenuItem.pvR.ptW), 0);
    }
    paramMenuItem.pvR.clear();
    this.pxl.finish();
    AppMethodBeat.o(44158);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductUI.2
 * JD-Core Version:    0.7.0.1
 */