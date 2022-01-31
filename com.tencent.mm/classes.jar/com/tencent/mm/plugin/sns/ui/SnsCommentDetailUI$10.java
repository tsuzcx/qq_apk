package com.tencent.mm.plugin.sns.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.plugin.sns.ui.b.a.a;

final class SnsCommentDetailUI$10
  implements AbsListView.OnScrollListener
{
  SnsCommentDetailUI$10(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 > 0)
    {
      if ((paramInt1 != 0) || (SnsCommentDetailUI.t(this.oWW))) {
        break label67;
      }
      SnsCommentDetailUI.a(this.oWW, true);
      if (SnsCommentDetailUI.u(this.oWW) == null) {
        break label48;
      }
      SnsCommentDetailUI.u(this.oWW).aqU();
    }
    label48:
    label67:
    while (paramInt1 <= 0)
    {
      do
      {
        return;
      } while (SnsCommentDetailUI.v(this.oWW) == null);
      this.oWW.bIB();
      return;
    }
    SnsCommentDetailUI.a(this.oWW, false);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 1)
    {
      this.oWW.XM();
      SnsCommentDetailUI.w(this.oWW);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.10
 * JD-Core Version:    0.7.0.1
 */