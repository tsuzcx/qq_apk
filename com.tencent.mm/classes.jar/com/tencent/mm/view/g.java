package com.tencent.mm.view;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/ExposedData;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "attachStateChangeListener", "Landroid/view/View$OnAttachStateChangeListener;", "getAttachStateChangeListener", "()Landroid/view/View$OnAttachStateChangeListener;", "setAttachStateChangeListener", "(Landroid/view/View$OnAttachStateChangeListener;)V", "exposedChildKey", "", "getExposedChildKey", "()J", "setExposedChildKey", "(J)V", "exposedKey", "getExposedKey", "setExposedKey", "getView", "()Landroid/view/View;", "setView", "viewExposeListener", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "getViewExposeListener", "()Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "setViewExposeListener", "(Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;)V", "viewGroupChildExposeListener", "Lcom/tencent/mm/view/ExposeElves$OnViewGroupChildExposedListener;", "getViewGroupChildExposeListener", "()Lcom/tencent/mm/view/ExposeElves$OnViewGroupChildExposedListener;", "setViewGroupChildExposeListener", "(Lcom/tencent/mm/view/ExposeElves$OnViewGroupChildExposedListener;)V", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "libmmui_release"})
public final class g
{
  long Rja;
  View.OnAttachStateChangeListener Rjb;
  e.b Rjc;
  e.c Rjd;
  long Rje;
  View view;
  
  public g(View paramView)
  {
    AppMethodBeat.i(204945);
    this.view = paramView;
    this.Rja = -1L;
    AppMethodBeat.o(204945);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(204948);
    if (this != paramObject)
    {
      if ((paramObject instanceof g))
      {
        paramObject = (g)paramObject;
        if (!p.j(this.view, paramObject.view)) {}
      }
    }
    else
    {
      AppMethodBeat.o(204948);
      return true;
    }
    AppMethodBeat.o(204948);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(204947);
    View localView = this.view;
    if (localView != null)
    {
      int i = localView.hashCode();
      AppMethodBeat.o(204947);
      return i;
    }
    AppMethodBeat.o(204947);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204946);
    String str = "ExposedData(view=" + this.view + ")";
    AppMethodBeat.o(204946);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.g
 * JD-Core Version:    0.7.0.1
 */