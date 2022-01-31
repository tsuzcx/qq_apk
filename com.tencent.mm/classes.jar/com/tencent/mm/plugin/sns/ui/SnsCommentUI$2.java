package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.b;
import com.tencent.mm.ui.tools.b.c;

final class SnsCommentUI$2
  implements MenuItem.OnMenuItemClickListener
{
  SnsCommentUI$2(SnsCommentUI paramSnsCommentUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(38917);
    if (SnsCommentUI.a(this.rQs) == 0) {
      b.MS();
    }
    if (SnsCommentUI.a(this.rQs) == 2) {}
    for (int i = 200;; i = b.MR())
    {
      paramMenuItem = c.d(SnsCommentUI.b(this.rQs)).QS(i);
      paramMenuItem.AyD = true;
      paramMenuItem.a(new SnsCommentUI.2.1(this));
      AppMethodBeat.o(38917);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentUI.2
 * JD-Core Version:    0.7.0.1
 */