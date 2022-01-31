package com.tencent.mm.ui.base;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class MMLoadMoreListView$1
  implements AbsListView.OnScrollListener
{
  MMLoadMoreListView$1(MMLoadMoreListView paramMMLoadMoreListView) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(106687);
    if ((paramInt1 == 0) && (this.zkV.getChildAt(0) != null) && (this.zkV.getChildAt(0).getTop() == this.zkV.getPaddingTop())) {
      MMLoadMoreListView.a(this.zkV, true);
    }
    for (;;)
    {
      ab.d("MMLoadMoreListView", "newpoi scroll2Top %s", new Object[] { MMLoadMoreListView.b(this.zkV) });
      AppMethodBeat.o(106687);
      return;
      MMLoadMoreListView.a(this.zkV, false);
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(106686);
    if ((paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (MMLoadMoreListView.a(this.zkV) != null)) {
      MMLoadMoreListView.a(this.zkV).Kt();
    }
    AppMethodBeat.o(106686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMLoadMoreListView.1
 * JD-Core Version:    0.7.0.1
 */