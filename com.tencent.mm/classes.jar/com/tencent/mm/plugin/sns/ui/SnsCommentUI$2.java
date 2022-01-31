package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.m.b;
import com.tencent.mm.ui.tools.a.c;

final class SnsCommentUI$2
  implements MenuItem.OnMenuItemClickListener
{
  SnsCommentUI$2(SnsCommentUI paramSnsCommentUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (SnsCommentUI.a(this.oXZ) == 0) {
      b.Ad();
    }
    if (SnsCommentUI.a(this.oXZ) == 2) {}
    for (int i = 200;; i = b.Ac())
    {
      paramMenuItem = c.d(SnsCommentUI.b(this.oXZ)).Ig(i);
      paramMenuItem.wfM = true;
      paramMenuItem.a(new SnsCommentUI.2.1(this));
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentUI.2
 * JD-Core Version:    0.7.0.1
 */