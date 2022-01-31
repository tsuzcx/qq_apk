package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class SnsCommentDetailUI$18
  implements MenuItem.OnMenuItemClickListener
{
  SnsCommentDetailUI$18(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (SnsCommentDetailUI.b(this.oWW) != null) {
      SnsCommentDetailUI.b(this.oWW).jw(false);
    }
    this.oWW.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.18
 * JD-Core Version:    0.7.0.1
 */