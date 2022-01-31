package com.tencent.mm.ui.base;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMListPopupWindow$d
  implements AbsListView.OnScrollListener
{
  private MMListPopupWindow$d(MMListPopupWindow paramMMListPopupWindow) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(112516);
    if ((MMListPopupWindow.a(this.zkQ) != null) && (MMListPopupWindow.e(this.zkQ) != null) && (MMListPopupWindow.f(this.zkQ) != null) && (MMListPopupWindow.a(this.zkQ) != null))
    {
      if ((MMListPopupWindow.a(this.zkQ).getLastVisiblePosition() == MMListPopupWindow.f(this.zkQ).getCount() - 1) && (MMListPopupWindow.a(this.zkQ).getChildAt(MMListPopupWindow.a(this.zkQ).getChildCount() - 1) != null) && (MMListPopupWindow.a(this.zkQ).getChildAt(MMListPopupWindow.a(this.zkQ).getChildCount() - 1).getBottom() <= MMListPopupWindow.a(this.zkQ).getHeight()))
      {
        MMListPopupWindow.e(this.zkQ).setVisibility(8);
        AppMethodBeat.o(112516);
        return;
      }
      MMListPopupWindow.e(this.zkQ).setVisibility(0);
    }
    AppMethodBeat.o(112516);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(112517);
    if ((paramInt == 1) && (!this.zkQ.isInputMethodNotNeeded()) && (MMListPopupWindow.b(this.zkQ).getContentView() != null))
    {
      MMListPopupWindow.d(this.zkQ).removeCallbacks(MMListPopupWindow.c(this.zkQ));
      MMListPopupWindow.c(this.zkQ).run();
    }
    AppMethodBeat.o(112517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMListPopupWindow.d
 * JD-Core Version:    0.7.0.1
 */