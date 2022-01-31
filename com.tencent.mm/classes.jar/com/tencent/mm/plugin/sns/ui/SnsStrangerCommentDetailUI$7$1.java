package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class SnsStrangerCommentDetailUI$7$1
  implements Runnable
{
  SnsStrangerCommentDetailUI$7$1(SnsStrangerCommentDetailUI.7 param7) {}
  
  public final void run()
  {
    y.v("MicroMsg.SnsStrangerCommentDetailUI", "comment notify");
    SnsStrangerCommentDetailUI.d(this.pdK.pdJ).a(null, null);
    if (SnsStrangerCommentDetailUI.e(this.pdK.pdJ))
    {
      SnsStrangerCommentDetailUI.a(this.pdK.pdJ, false);
      SnsStrangerCommentDetailUI localSnsStrangerCommentDetailUI = this.pdK.pdJ;
      af.aXq().postDelayed(new SnsStrangerCommentDetailUI.8(localSnsStrangerCommentDetailUI), 10L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.7.1
 * JD-Core Version:    0.7.0.1
 */