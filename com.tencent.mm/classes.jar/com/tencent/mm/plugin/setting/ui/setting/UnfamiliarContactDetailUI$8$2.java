package com.tencent.mm.plugin.setting.ui.setting;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.MenuItem;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.ui.base.n.d;

final class UnfamiliarContactDetailUI$8$2
  implements n.d
{
  UnfamiliarContactDetailUI$8$2(UnfamiliarContactDetailUI.8 param8) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    g.DQ();
    g.DO().dJT.b(681, UnfamiliarContactDetailUI.h(this.nXb.nWX));
    UnfamiliarContactDetailUI.a(this.nXb.nWX, UnfamiliarContactDetailUI.b(this.nXb.nWX), paramInt);
    UnfamiliarContactDetailUI.b(this.nXb.nWX, false);
    if (UnfamiliarContactDetailUI.e(this.nXb.nWX) != null) {
      UnfamiliarContactDetailUI.e(this.nXb.nWX).agL.notifyChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.8.2
 * JD-Core Version:    0.7.0.1
 */