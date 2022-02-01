package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class PermissionSettingUI2$1
  implements MenuItem.OnMenuItemClickListener
{
  PermissionSettingUI2$1(PermissionSettingUI2 paramPermissionSettingUI2) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(179654);
    this.Bib.hideVKB();
    this.Bib.setResult(-1, new Intent());
    this.Bib.finish();
    AppMethodBeat.o(179654);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.PermissionSettingUI2.1
 * JD-Core Version:    0.7.0.1
 */