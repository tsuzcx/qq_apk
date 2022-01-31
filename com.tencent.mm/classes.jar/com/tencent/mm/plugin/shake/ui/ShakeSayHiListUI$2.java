package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.d;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.n.d;

final class ShakeSayHiListUI$2
  implements n.d
{
  ShakeSayHiListUI$2(ShakeSayHiListUI paramShakeSayHiListUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(24874);
    d.alk().Te(String.valueOf(ShakeSayHiListUI.g(this.qRC)));
    ShakeSayHiListUI.b(this.qRC).a(null, null);
    AppMethodBeat.o(24874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI.2
 * JD-Core Version:    0.7.0.1
 */