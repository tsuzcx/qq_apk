package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.y;

final class SnsStrangerCommentDetailUI$3
  implements SnsCommentFooter.c
{
  SnsStrangerCommentDetailUI$3(SnsStrangerCommentDetailUI paramSnsStrangerCommentDetailUI) {}
  
  public final void OZ(String paramString)
  {
    y.v("MicroMsg.SnsStrangerCommentDetailUI", "comment send requested");
    SnsStrangerCommentDetailUI.a(this.pdJ, true);
    SnsStrangerCommentDetailUI.a(this.pdJ, SnsStrangerCommentDetailUI.k(this.pdJ), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.3
 * JD-Core Version:    0.7.0.1
 */