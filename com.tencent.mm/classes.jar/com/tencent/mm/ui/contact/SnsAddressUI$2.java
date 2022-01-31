package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class SnsAddressUI$2
  implements MenuItem.OnMenuItemClickListener
{
  SnsAddressUI$2(SnsAddressUI paramSnsAddressUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    this.vNN.finish();
    if (!this.vNN.getIntent().getBooleanExtra("stay_in_wechat", true)) {
      this.vNN.moveTaskToBack(true);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsAddressUI.2
 * JD-Core Version:    0.7.0.1
 */