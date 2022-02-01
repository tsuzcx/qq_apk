package com.tencent.mm.pluginsdk.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class e
  implements AbsListView.OnScrollListener
{
  private AbsListView.OnScrollListener ERY;
  private ArrayList<WeakReference<a>> ERZ;
  
  public e()
  {
    this(null);
  }
  
  public e(AbsListView.OnScrollListener paramOnScrollListener)
  {
    AppMethodBeat.i(152123);
    this.ERZ = new ArrayList();
    this.ERY = paramOnScrollListener;
    AppMethodBeat.o(152123);
  }
  
  private void vH(boolean paramBoolean)
  {
    AppMethodBeat.i(152127);
    int i = 0;
    if (i < this.ERZ.size())
    {
      Object localObject = (WeakReference)this.ERZ.get(i);
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
        this.ERZ.remove(i);
        continue;
        this.ERZ.remove(i);
      }
    }
    AppMethodBeat.o(152127);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(152126);
    this.ERZ.add(new WeakReference(parama));
    AppMethodBeat.o(152126);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(152124);
    if (this.ERY != null) {
      this.ERY.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(152124);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(152125);
    if (paramInt == 2) {
      vH(true);
    }
    for (;;)
    {
      if (this.ERY != null) {
        this.ERY.onScrollStateChanged(paramAbsListView, paramInt);
      }
      AppMethodBeat.o(152125);
      return;
      vH(false);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onScrollStateChanged(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.e
 * JD-Core Version:    0.7.0.1
 */