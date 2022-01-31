package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import com.tencent.mm.ui.base.n.d;

final class SnsMsgUI$5
  implements n.d
{
  SnsMsgUI$5(SnsMsgUI paramSnsMsgUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 0: 
      SnsMsgUI.a(this.paq, this.paq.oLo);
      return;
    case 1: 
      SnsMsgUI.n(this.paq);
      return;
    }
    SnsMsgUI.a(this.paq, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.5
 * JD-Core Version:    0.7.0.1
 */