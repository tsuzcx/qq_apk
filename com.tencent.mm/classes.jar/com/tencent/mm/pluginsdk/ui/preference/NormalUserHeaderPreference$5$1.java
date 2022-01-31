package com.tencent.mm.pluginsdk.ui.preference;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.MMActivity;

final class NormalUserHeaderPreference$5$1
  implements View.OnCreateContextMenuListener
{
  NormalUserHeaderPreference$5$1(NormalUserHeaderPreference.5 param5) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramContextMenu.add(NormalUserHeaderPreference.a(this.sja.siZ).getString(R.l.app_copy));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference.5.1
 * JD-Core Version:    0.7.0.1
 */