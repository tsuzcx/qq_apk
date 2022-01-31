package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;

final class SnsCommentDetailUI$15
  implements SnsCommentFooter.b
{
  SnsCommentDetailUI$15(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void bIH()
  {
    SnsCommentDetailUI.z(this.oWW);
    if ((SnsCommentDetailUI.c(this.oWW).getFirstVisiblePosition() > 1) || (SnsCommentDetailUI.c(this.oWW).getLastVisiblePosition() <= 0)) {
      BackwardSupportUtil.c.b(SnsCommentDetailUI.c(this.oWW), 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.15
 * JD-Core Version:    0.7.0.1
 */