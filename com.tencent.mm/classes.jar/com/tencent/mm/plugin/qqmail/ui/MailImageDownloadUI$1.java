package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;

final class MailImageDownloadUI$1
  implements MenuItem.OnMenuItemClickListener
{
  MailImageDownloadUI$1(MailImageDownloadUI paramMailImageDownloadUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    g.DO().dJT.c(MailImageDownloadUI.a(this.niP));
    this.niP.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailImageDownloadUI.1
 * JD-Core Version:    0.7.0.1
 */