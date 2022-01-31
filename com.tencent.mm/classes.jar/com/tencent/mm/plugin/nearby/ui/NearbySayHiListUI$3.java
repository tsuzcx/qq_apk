package com.tencent.mm.plugin.nearby.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.ui.base.n.d;

final class NearbySayHiListUI$3
  implements n.d
{
  NearbySayHiListUI$3(NearbySayHiListUI paramNearbySayHiListUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(55495);
    g.RJ().QQ();
    ((j)g.E(j.class)).bPN().Te(String.valueOf(NearbySayHiListUI.h(this.pdR)));
    NearbySayHiListUI.b(this.pdR).a(null, null);
    if (NearbySayHiListUI.c(this.pdR) > 0) {
      NearbySayHiListUI.i(this.pdR);
    }
    NearbySayHiListUI.j(this.pdR);
    AppMethodBeat.o(55495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.3
 * JD-Core Version:    0.7.0.1
 */