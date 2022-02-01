package com.tencent.mm.pluginsdk.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class d
  implements AbsListView.OnScrollListener
{
  private AbsListView.OnScrollListener BUD;
  private ArrayList<WeakReference<a>> BUE;
  
  public d()
  {
    this(null);
  }
  
  public d(AbsListView.OnScrollListener paramOnScrollListener)
  {
    AppMethodBeat.i(152123);
    this.BUE = new ArrayList();
    this.BUD = paramOnScrollListener;
    AppMethodBeat.o(152123);
  }
  
  private void tV(boolean paramBoolean)
  {
    AppMethodBeat.i(152127);
    int i = 0;
    if (i < this.BUE.size())
    {
      Object localObject = (WeakReference)this.BUE.get(i);
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
        this.BUE.remove(i);
        continue;
        this.BUE.remove(i);
      }
    }
    AppMethodBeat.o(152127);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(152126);
    this.BUE.add(new WeakReference(parama));
    AppMethodBeat.o(152126);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(152124);
    if (this.BUD != null) {
      this.BUD.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(152124);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(152125);
    if (paramInt == 2) {
      tV(true);
    }
    for (;;)
    {
      if (this.BUD != null) {
        this.BUD.onScrollStateChanged(paramAbsListView, paramInt);
      }
      AppMethodBeat.o(152125);
      return;
      tV(false);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onScrollStateChanged(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d
 * JD-Core Version:    0.7.0.1
 */