package com.tencent.mm.pluginsdk.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class d
  implements AbsListView.OnScrollListener
{
  private AbsListView.OnScrollListener rZe;
  private ArrayList<WeakReference<a>> rZf = new ArrayList();
  
  public d()
  {
    this(null);
  }
  
  public d(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.rZe = paramOnScrollListener;
  }
  
  private void lO(boolean paramBoolean)
  {
    int i = 0;
    if (i < this.rZf.size())
    {
      Object localObject = (WeakReference)this.rZf.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).onScrollStateChanged(paramBoolean);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        this.rZf.remove(i);
        continue;
        this.rZf.remove(i);
      }
    }
  }
  
  public final void a(a parama)
  {
    this.rZf.add(new WeakReference(parama));
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.rZe != null) {
      this.rZe.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 2) {
      lO(true);
    }
    for (;;)
    {
      if (this.rZe != null) {
        this.rZe.onScrollStateChanged(paramAbsListView, paramInt);
      }
      return;
      lO(false);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onScrollStateChanged(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d
 * JD-Core Version:    0.7.0.1
 */