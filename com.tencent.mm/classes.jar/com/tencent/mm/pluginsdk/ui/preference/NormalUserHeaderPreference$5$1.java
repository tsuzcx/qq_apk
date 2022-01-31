package com.tencent.mm.pluginsdk.ui.preference;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

final class NormalUserHeaderPreference$5$1
  implements View.OnCreateContextMenuListener
{
  NormalUserHeaderPreference$5$1(NormalUserHeaderPreference.5 param5) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(28075);
    paramContextMenu.add(NormalUserHeaderPreference.b(this.wbB.wbA).getString(2131296895));
    AppMethodBeat.o(28075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference.5.1
 * JD-Core Version:    0.7.0.1
 */