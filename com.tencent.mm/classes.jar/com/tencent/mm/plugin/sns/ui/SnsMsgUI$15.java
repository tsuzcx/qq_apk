package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.r.a;

final class SnsMsgUI$15
  implements r.a
{
  SnsMsgUI$15(SnsMsgUI paramSnsMsgUI) {}
  
  public final void Wp()
  {
    y.v("MicroMsg.SnsMsgUI", "total count:" + SnsMsgUI.e(this.paq).dsw + " unread:" + af.bDK().aAo() + "  showcount:" + SnsMsgUI.e(this.paq).iwi);
    if (SnsMsgUI.e(this.paq).getCount() == 0)
    {
      SnsMsgUI.c(this.paq).setVisibility(8);
      SnsMsgUI.d(this.paq).setVisibility(0);
      this.paq.enableOptionMenu(false);
    }
    for (;;)
    {
      if (((SnsMsgUI.e(this.paq).aCc()) && (af.bDK().aAo() == 0)) || (af.bDK().aAo() == af.bDK().bGq())) {
        SnsMsgUI.f(this.paq).setVisibility(8);
      }
      return;
      SnsMsgUI.c(this.paq).setVisibility(0);
      SnsMsgUI.d(this.paq).setVisibility(8);
      this.paq.enableOptionMenu(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.15
 * JD-Core Version:    0.7.0.1
 */