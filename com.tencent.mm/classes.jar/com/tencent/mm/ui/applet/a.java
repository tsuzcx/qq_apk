package com.tencent.mm.ui.applet;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements AbsListView.OnScrollListener
{
  private AbsListView.OnScrollListener vPV = null;
  
  public a()
  {
    this((byte)0);
  }
  
  private a(byte paramByte) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(106221);
    if (this.vPV != null) {
      this.vPV.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(106221);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(106222);
    if (this.vPV != null) {
      this.vPV.onScrollStateChanged(paramAbsListView, paramInt);
    }
    AppMethodBeat.o(106222);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.applet.a
 * JD-Core Version:    0.7.0.1
 */