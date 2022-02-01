package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.ui.r;

public abstract class a<T>
  extends r<T>
  implements AbsListView.OnScrollListener
{
  private static final String TAG = "MicroMsg." + a.class.getName();
  protected boolean grY;
  
  public a(Context paramContext, T paramT)
  {
    super(paramContext, paramT);
    xk(true);
  }
  
  public abstract boolean bXb();
  
  public abstract int bXc();
  
  public abstract int getShowCount();
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.grY = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.a
 * JD-Core Version:    0.7.0.1
 */