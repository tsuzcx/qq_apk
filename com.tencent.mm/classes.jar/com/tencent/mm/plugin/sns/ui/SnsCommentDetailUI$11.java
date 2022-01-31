package com.tencent.mm.plugin.sns.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.ui.c.a.a;

final class SnsCommentDetailUI$11
  implements AbsListView.OnScrollListener
{
  SnsCommentDetailUI$11(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38788);
    if (paramInt2 > 0) {
      if ((paramInt1 == 0) && (!SnsCommentDetailUI.t(this.rPu)))
      {
        SnsCommentDetailUI.a(this.rPu, true);
        if (SnsCommentDetailUI.u(this.rPu) != null)
        {
          SnsCommentDetailUI.u(this.rPu).refreshView();
          AppMethodBeat.o(38788);
          return;
        }
        if (SnsCommentDetailUI.v(this.rPu) != null)
        {
          this.rPu.cuW();
          AppMethodBeat.o(38788);
        }
      }
      else if (paramInt1 > 0)
      {
        SnsCommentDetailUI.a(this.rPu, false);
      }
    }
    AppMethodBeat.o(38788);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(38789);
    if (paramInt == 1)
    {
      this.rPu.hideVKB();
      SnsCommentDetailUI.w(this.rPu);
    }
    if ((paramInt == 0) && (SnsCommentDetailUI.x(this.rPu) != null)) {
      SnsCommentDetailUI.x(this.rPu).kZ(true);
    }
    AppMethodBeat.o(38789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.11
 * JD-Core Version:    0.7.0.1
 */