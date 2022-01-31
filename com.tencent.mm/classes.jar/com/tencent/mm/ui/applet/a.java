package com.tencent.mm.ui.applet;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

public final class a
  implements AbsListView.OnScrollListener
{
  private AbsListView.OnScrollListener rZe = null;
  
  public a()
  {
    this((byte)0);
  }
  
  private a(byte paramByte) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.rZe != null) {
      this.rZe.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.rZe != null) {
      this.rZe.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.applet.a
 * JD-Core Version:    0.7.0.1
 */