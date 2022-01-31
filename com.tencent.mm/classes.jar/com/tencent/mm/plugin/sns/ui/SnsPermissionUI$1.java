package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class SnsPermissionUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SnsPermissionUI$1(SnsPermissionUI paramSnsPermissionUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    this.pbB.XM();
    this.pbB.setResult(-1, new Intent());
    this.pbB.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsPermissionUI.1
 * JD-Core Version:    0.7.0.1
 */