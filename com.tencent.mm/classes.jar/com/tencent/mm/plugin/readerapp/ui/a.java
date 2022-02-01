package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.ui.s;

public abstract class a<T>
  extends s<T>
  implements AbsListView.OnScrollListener
{
  private static final String TAG = "MicroMsg." + a.class.getName();
  protected boolean hho;
  
  public a(Context paramContext, T paramT)
  {
    super(paramContext, paramT);
    Bh(true);
  }
  
  public abstract boolean cwg();
  
  public abstract int cwh();
  
  public abstract int getShowCount();
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.hho = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.a
 * JD-Core Version:    0.7.0.1
 */