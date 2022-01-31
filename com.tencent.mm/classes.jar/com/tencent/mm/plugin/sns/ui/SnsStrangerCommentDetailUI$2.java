package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class SnsStrangerCommentDetailUI$2
  implements Runnable
{
  int rPV = -1;
  int rPW = 10;
  
  SnsStrangerCommentDetailUI$2(SnsStrangerCommentDetailUI paramSnsStrangerCommentDetailUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(39312);
    if (!SnsStrangerCommentDetailUI.h(this.rWw)) {
      this.rPW = 10;
    }
    SnsStrangerCommentDetailUI.i(this.rWw);
    ab.e("MicroMsg.SnsStrangerCommentDetailUI", "list.bottom:" + SnsStrangerCommentDetailUI.a(this.rWw).getBottom() + " footer.top" + SnsStrangerCommentDetailUI.a(this.rWw).getTop());
    int i = SnsStrangerCommentDetailUI.j(this.rWw).getTop();
    int j = this.rPW;
    this.rPW = (j - 1);
    if ((j > 0) && ((this.rPV != i) || (SnsStrangerCommentDetailUI.a(this.rWw).getBottom() == SnsStrangerCommentDetailUI.g(this.rWw)))) {
      new ak().postDelayed(this, 30L);
    }
    this.rPV = i;
    BackwardSupportUtil.c.b(SnsStrangerCommentDetailUI.a(this.rWw), SnsStrangerCommentDetailUI.a(this.rWw).getCount() - 1);
    AppMethodBeat.o(39312);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.2
 * JD-Core Version:    0.7.0.1
 */