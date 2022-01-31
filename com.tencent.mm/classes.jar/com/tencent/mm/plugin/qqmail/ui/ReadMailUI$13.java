package com.tencent.mm.plugin.qqmail.ui;

import android.content.res.Resources;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.qqmail.b.b;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.ui.base.h;

final class ReadMailUI$13
  implements MenuItem.OnMenuItemClickListener
{
  ReadMailUI$13(ReadMailUI paramReadMailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = this.njK.getResources().getStringArray(b.b.mail_reply);
    h.a(this.njK, null, paramMenuItem, this.njK.getResources().getString(b.j.readmail_delete), false, new ReadMailUI.13.1(this));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.13
 * JD-Core Version:    0.7.0.1
 */