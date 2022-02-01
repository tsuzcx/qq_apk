package com.tencent.mm.pluginsdk.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class e
  implements AbsListView.OnScrollListener
{
  private AbsListView.OnScrollListener Fkt;
  private ArrayList<WeakReference<a>> Fku;
  
  public e()
  {
    this(null);
  }
  
  public e(AbsListView.OnScrollListener paramOnScrollListener)
  {
    AppMethodBeat.i(152123);
    this.Fku = new ArrayList();
    this.Fkt = paramOnScrollListener;
    AppMethodBeat.o(152123);
  }
  
  private void vP(boolean paramBoolean)
  {
    AppMethodBeat.i(152127);
    int i = 0;
    if (i < this.Fku.size())
    {
      Object localObject = (WeakReference)this.Fku.get(i);
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
        this.Fku.remove(i);
        continue;
        this.Fku.remove(i);
      }
    }
    AppMethodBeat.o(152127);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(152126);
    this.Fku.add(new WeakReference(parama));
    AppMethodBeat.o(152126);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(152124);
    if (this.Fkt != null) {
      this.Fkt.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(152124);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(152125);
    if (paramInt == 2) {
      vP(true);
    }
    for (;;)
    {
      if (this.Fkt != null) {
        this.Fkt.onScrollStateChanged(paramAbsListView, paramInt);
      }
      AppMethodBeat.o(152125);
      return;
      vP(false);
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