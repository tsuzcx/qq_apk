package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.ai;

final class SelectContactUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SelectContactUI$1(SelectContactUI paramSelectContactUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    this.vNB.XM();
    this.vNB.finish();
    if (!this.vNB.getIntent().getBooleanExtra("stay_in_wechat", true)) {
      ai.l(new SelectContactUI.1.1(this), 80L);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.1
 * JD-Core Version:    0.7.0.1
 */