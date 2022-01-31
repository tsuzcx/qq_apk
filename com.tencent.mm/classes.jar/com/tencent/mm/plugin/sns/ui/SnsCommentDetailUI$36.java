package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class SnsCommentDetailUI$36
  implements View.OnClickListener
{
  SnsCommentDetailUI$36(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void onClick(View paramView)
  {
    y.e("MicroMsg.SnsCommentDetailUI", "scrollTopClickListener");
    SnsCommentDetailUI.g(this.oWW);
    if (!SnsCommentDetailUI.h(this.oWW)) {
      return;
    }
    SnsCommentDetailUI.i(this.oWW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.36
 * JD-Core Version:    0.7.0.1
 */