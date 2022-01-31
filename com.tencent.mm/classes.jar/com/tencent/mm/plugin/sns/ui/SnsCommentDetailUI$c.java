package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class SnsCommentDetailUI$c
  implements Runnable
{
  int KY = -1;
  int itemHeight;
  private int offset = 0;
  private int rPV = -1;
  private int rPW = 10;
  
  SnsCommentDetailUI$c(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(38833);
    this.rPW = 10;
    SnsCommentDetailUI.b(this.rPu);
    this.rPV = SnsCommentDetailUI.c(this.rPu).getTop();
    int i = this.rPV - this.itemHeight;
    ab.i("MicroMsg.SnsCommentDetailUI", "list.bottom: %d, listOriginalBottom: %d, footerTop: %d, commentFooter.getTop: %d, topSelection: %d", new Object[] { Integer.valueOf(SnsCommentDetailUI.a(this.rPu).getBottom()), Integer.valueOf(SnsCommentDetailUI.d(this.rPu)), Integer.valueOf(this.rPV), Integer.valueOf(SnsCommentDetailUI.c(this.rPu).getTop()), Integer.valueOf(i) });
    if (i == this.offset)
    {
      SnsCommentDetailUI.a(this.rPu).setSelectionFromTop(SnsCommentDetailUI.a(this.rPu).getHeaderViewsCount() + this.KY, i);
      this.rPW = 0;
      this.offset = 0;
      AppMethodBeat.o(38833);
      return;
    }
    int j = this.rPW;
    this.rPW = (j - 1);
    if (j > 0)
    {
      new ak().postDelayed(this, 100L);
      this.offset = i;
      AppMethodBeat.o(38833);
      return;
    }
    this.offset = 0;
    this.rPW = 0;
    AppMethodBeat.o(38833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.c
 * JD-Core Version:    0.7.0.1
 */