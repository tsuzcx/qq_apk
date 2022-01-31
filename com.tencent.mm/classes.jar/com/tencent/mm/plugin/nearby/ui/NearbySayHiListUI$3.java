package com.tencent.mm.plugin.nearby.ui;

import android.view.MenuItem;
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
    g.DN().CX();
    ((j)g.r(j.class)).bhL().Hs(String.valueOf(NearbySayHiListUI.h(this.mDP)));
    NearbySayHiListUI.b(this.mDP).a(null, null);
    if (NearbySayHiListUI.c(this.mDP) > 0) {
      NearbySayHiListUI.i(this.mDP);
    }
    NearbySayHiListUI.j(this.mDP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.3
 * JD-Core Version:    0.7.0.1
 */