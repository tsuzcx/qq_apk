package com.tencent.mm.plugin.setting.ui.qrcode;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.ui.base.h;

final class ShowQRCodeStep1UI$2
  implements MenuItem.OnMenuItemClickListener
{
  ShowQRCodeStep1UI$2(ShowQRCodeStep1UI paramShowQRCodeStep1UI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = this.nRH;
    String str1 = paramMenuItem.getString(a.i.self_qrcode_change);
    String str2 = paramMenuItem.getString(a.i.self_qrcode_save);
    ShowQRCodeStep1UI.4 local4 = new ShowQRCodeStep1UI.4(paramMenuItem);
    h.a(paramMenuItem, "", new String[] { str1, str2 }, "", false, local4);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.ShowQRCodeStep1UI.2
 * JD-Core Version:    0.7.0.1
 */