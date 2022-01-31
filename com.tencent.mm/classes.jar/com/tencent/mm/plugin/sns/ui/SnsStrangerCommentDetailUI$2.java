package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class SnsStrangerCommentDetailUI$2
  implements Runnable
{
  int oXx = -1;
  int oXy = 10;
  
  SnsStrangerCommentDetailUI$2(SnsStrangerCommentDetailUI paramSnsStrangerCommentDetailUI) {}
  
  public final void run()
  {
    if (!SnsStrangerCommentDetailUI.h(this.pdJ)) {
      this.oXy = 10;
    }
    SnsStrangerCommentDetailUI.i(this.pdJ);
    y.e("MicroMsg.SnsStrangerCommentDetailUI", "list.bottom:" + SnsStrangerCommentDetailUI.a(this.pdJ).getBottom() + " footer.top" + SnsStrangerCommentDetailUI.a(this.pdJ).getTop());
    int i = SnsStrangerCommentDetailUI.j(this.pdJ).getTop();
    int j = this.oXy;
    this.oXy = (j - 1);
    if ((j > 0) && ((this.oXx != i) || (SnsStrangerCommentDetailUI.a(this.pdJ).getBottom() == SnsStrangerCommentDetailUI.g(this.pdJ)))) {
      new ah().postDelayed(this, 30L);
    }
    this.oXx = i;
    BackwardSupportUtil.c.b(SnsStrangerCommentDetailUI.a(this.pdJ), SnsStrangerCommentDetailUI.a(this.pdJ).getCount() - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.2
 * JD-Core Version:    0.7.0.1
 */