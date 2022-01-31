package com.tencent.mm.plugin.setting.ui.setting;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.mm.plugin.setting.a.i;
import java.util.HashSet;

final class UnfamiliarContactDetailUI$1
  implements MenuItem.OnMenuItemClickListener
{
  UnfamiliarContactDetailUI$1(UnfamiliarContactDetailUI paramUnfamiliarContactDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = this.nWX;
    boolean bool;
    if (!UnfamiliarContactDetailUI.a(this.nWX))
    {
      bool = true;
      UnfamiliarContactDetailUI.a(paramMenuItem, bool);
      UnfamiliarContactDetailUI.b(this.nWX).clear();
      UnfamiliarContactDetailUI.b(this.nWX, UnfamiliarContactDetailUI.a(this.nWX));
      if (!UnfamiliarContactDetailUI.a(this.nWX)) {
        break label127;
      }
      UnfamiliarContactDetailUI.c(this.nWX).setEnabled(false);
      UnfamiliarContactDetailUI.d(this.nWX).setEnabled(false);
      this.nWX.updateOptionMenuText(1, this.nWX.getString(a.i.unfamiliar_cancel_contact_member_multi_select));
    }
    for (;;)
    {
      if (UnfamiliarContactDetailUI.e(this.nWX) != null) {
        UnfamiliarContactDetailUI.e(this.nWX).agL.notifyChanged();
      }
      return true;
      bool = false;
      break;
      label127:
      this.nWX.updateOptionMenuText(1, this.nWX.getString(a.i.unfamiliar_contact_member_multi_select));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.1
 * JD-Core Version:    0.7.0.1
 */