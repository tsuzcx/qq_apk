package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class NormalProfileHeaderPreference$2
  implements View.OnCreateContextMenuListener
{
  NormalProfileHeaderPreference$2(NormalProfileHeaderPreference paramNormalProfileHeaderPreference) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(156691);
    paramContextMenu.add(NormalProfileHeaderPreference.c(this.pBf).getString(2131296895));
    AppMethodBeat.o(156691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference.2
 * JD-Core Version:    0.7.0.1
 */