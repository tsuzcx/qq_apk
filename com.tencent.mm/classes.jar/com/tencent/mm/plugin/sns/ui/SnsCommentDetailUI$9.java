package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.y;

final class SnsCommentDetailUI$9
  implements Runnable
{
  SnsCommentDetailUI$9(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void run()
  {
    SnsCommentDetailUI.a(this.oWW, SnsCommentDetailUI.c(this.oWW).getBottom());
    y.d("MicroMsg.SnsCommentDetailUI", "listOriginalBottom: " + SnsCommentDetailUI.d(this.oWW));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.9
 * JD-Core Version:    0.7.0.1
 */