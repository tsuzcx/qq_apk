package com.tencent.mm.plugin.setting.ui.setting;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

final class UnfamiliarContactDetailUI$1
  implements MenuItem.OnMenuItemClickListener
{
  UnfamiliarContactDetailUI$1(UnfamiliarContactDetailUI paramUnfamiliarContactDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127632);
    paramMenuItem = this.qLi;
    boolean bool;
    if (!UnfamiliarContactDetailUI.a(this.qLi))
    {
      bool = true;
      UnfamiliarContactDetailUI.a(paramMenuItem, bool);
      UnfamiliarContactDetailUI.b(this.qLi).clear();
      UnfamiliarContactDetailUI.b(this.qLi, UnfamiliarContactDetailUI.a(this.qLi));
      if (!UnfamiliarContactDetailUI.a(this.qLi)) {
        break label136;
      }
      UnfamiliarContactDetailUI.c(this.qLi).setEnabled(false);
      UnfamiliarContactDetailUI.d(this.qLi).setEnabled(false);
      this.qLi.updateOptionMenuText(1, this.qLi.getString(2131304409));
    }
    for (;;)
    {
      if (UnfamiliarContactDetailUI.e(this.qLi) != null) {
        UnfamiliarContactDetailUI.e(this.qLi).ajb.notifyChanged();
      }
      AppMethodBeat.o(127632);
      return true;
      bool = false;
      break;
      label136:
      this.qLi.updateOptionMenuText(1, this.qLi.getString(2131304415));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.1
 * JD-Core Version:    0.7.0.1
 */