package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.ui.base.n.d;

final class ShakeItemListUI$8
  implements n.d
{
  ShakeItemListUI$8(ShakeItemListUI paramShakeItemListUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(24727);
    m.cln().Di(ShakeItemListUI.f(this.qPL));
    AppMethodBeat.o(24727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeItemListUI.8
 * JD-Core Version:    0.7.0.1
 */