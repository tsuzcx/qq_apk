package com.tencent.mm.plugin.profile.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class SayHiWithSnsPermissionUI$7
  implements MenuItem.OnMenuItemClickListener
{
  SayHiWithSnsPermissionUI$7(SayHiWithSnsPermissionUI paramSayHiWithSnsPermissionUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (SayHiWithSnsPermissionUI.k(this.mZo)) {
      SayHiWithSnsPermissionUI.l(this.mZo)[1] = 1;
    }
    this.mZo.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.7
 * JD-Core Version:    0.7.0.1
 */