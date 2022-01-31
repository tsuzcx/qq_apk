package com.tencent.mm.pluginsdk.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class d
  implements AbsListView.OnScrollListener
{
  private AbsListView.OnScrollListener vPV;
  private ArrayList<WeakReference<d.a>> vPW;
  
  public d()
  {
    this(null);
  }
  
  public d(AbsListView.OnScrollListener paramOnScrollListener)
  {
    AppMethodBeat.i(79676);
    this.vPW = new ArrayList();
    this.vPV = paramOnScrollListener;
    AppMethodBeat.o(79676);
  }
  
  private void pa(boolean paramBoolean)
  {
    AppMethodBeat.i(79680);
    int i = 0;
    if (i < this.vPW.size())
    {
      Object localObject = (WeakReference)this.vPW.get(i);
      if (localObject != null)
      {
        localObject = (d.a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((d.a)localObject).onScrollStateChanged(paramBoolean);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        this.vPW.remove(i);
        continue;
        this.vPW.remove(i);
      }
    }
    AppMethodBeat.o(79680);
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(79679);
    this.vPW.add(new WeakReference(parama));
    AppMethodBeat.o(79679);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(79677);
    if (this.vPV != null) {
      this.vPV.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(79677);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(79678);
    if (paramInt == 2) {
      pa(true);
    }
    for (;;)
    {
      if (this.vPV != null) {
        this.vPV.onScrollStateChanged(paramAbsListView, paramInt);
      }
      AppMethodBeat.o(79678);
      return;
      pa(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d
 * JD-Core Version:    0.7.0.1
 */