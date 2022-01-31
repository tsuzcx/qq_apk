package com.tencent.mm.ui.conversation;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.ch.d;

final class l$1
  implements AbsListView.OnScrollListener
{
  l$1(l paraml) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 2) {
      d.cxA().dA(k.class.getName() + ".Listview", 4);
    }
    if (paramInt == 0)
    {
      if (this.vTN.vPc == null) {
        return;
      }
      l.a(this.vTN, -1);
      return;
    }
    this.vTN.cIs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.l.1
 * JD-Core Version:    0.7.0.1
 */