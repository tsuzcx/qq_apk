package com.tencent.mm.ui.applet;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements AbsListView.OnScrollListener
{
  private AbsListView.OnScrollListener XXV = null;
  
  public a()
  {
    this((byte)0);
  }
  
  private a(byte paramByte) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(141581);
    if (this.XXV != null) {
      this.XXV.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(141581);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(141582);
    if (this.XXV != null) {
      this.XXV.onScrollStateChanged(paramAbsListView, paramInt);
    }
    AppMethodBeat.o(141582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.applet.a
 * JD-Core Version:    0.7.0.1
 */