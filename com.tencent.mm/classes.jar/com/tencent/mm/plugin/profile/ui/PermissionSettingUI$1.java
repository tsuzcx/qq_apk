package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class PermissionSettingUI$1
  implements MenuItem.OnMenuItemClickListener
{
  PermissionSettingUI$1(PermissionSettingUI paramPermissionSettingUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(27363);
    this.MZW.hideVKB();
    this.MZW.setResult(-1, new Intent());
    this.MZW.finish();
    AppMethodBeat.o(27363);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.PermissionSettingUI.1
 * JD-Core Version:    0.7.0.1
 */