package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsCommentDetailUI$18
  implements MenuItem.OnMenuItemClickListener
{
  SnsCommentDetailUI$18(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(38797);
    if (SnsCommentDetailUI.c(this.rPu) != null) {
      SnsCommentDetailUI.c(this.rPu).lC(false);
    }
    this.rPu.finish();
    AppMethodBeat.o(38797);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.18
 * JD-Core Version:    0.7.0.1
 */