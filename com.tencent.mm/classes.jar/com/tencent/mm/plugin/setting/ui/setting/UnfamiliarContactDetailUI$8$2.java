package com.tencent.mm.plugin.setting.ui.setting;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.ui.base.n.d;

final class UnfamiliarContactDetailUI$8$2
  implements n.d
{
  UnfamiliarContactDetailUI$8$2(UnfamiliarContactDetailUI.8 param8) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(127643);
    g.RM();
    g.RK().eHt.b(681, UnfamiliarContactDetailUI.h(this.qLm.qLi));
    UnfamiliarContactDetailUI.a(this.qLm.qLi, UnfamiliarContactDetailUI.b(this.qLm.qLi), paramInt);
    UnfamiliarContactDetailUI.b(this.qLm.qLi, false);
    if (UnfamiliarContactDetailUI.e(this.qLm.qLi) != null) {
      UnfamiliarContactDetailUI.e(this.qLm.qLi).ajb.notifyChanged();
    }
    AppMethodBeat.o(127643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.8.2
 * JD-Core Version:    0.7.0.1
 */