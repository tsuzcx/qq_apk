package com.tencent.mm.view;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/ExposedData;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "attachStateChangeListener", "Landroid/view/View$OnAttachStateChangeListener;", "getAttachStateChangeListener", "()Landroid/view/View$OnAttachStateChangeListener;", "setAttachStateChangeListener", "(Landroid/view/View$OnAttachStateChangeListener;)V", "checkDestroyTimeMs", "", "getCheckDestroyTimeMs", "()J", "setCheckDestroyTimeMs", "(J)V", "exposedChildKey", "getExposedChildKey", "setExposedChildKey", "exposedKey", "getExposedKey", "setExposedKey", "isLeak", "", "()Z", "setLeak", "(Z)V", "getView", "()Landroid/view/View;", "setView", "viewExposeListener", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "getViewExposeListener", "()Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "setViewExposeListener", "(Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;)V", "viewGroupChildExposeListener", "Lcom/tencent/mm/view/ExposeElves$OnViewGroupChildExposedListener;", "getViewGroupChildExposeListener", "()Lcom/tencent/mm/view/ExposeElves$OnViewGroupChildExposedListener;", "setViewGroupChildExposeListener", "(Lcom/tencent/mm/view/ExposeElves$OnViewGroupChildExposedListener;)V", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "libmmui_release"})
public final class g
{
  long YKN;
  View.OnAttachStateChangeListener YKO;
  e.b YKP;
  e.c YKQ;
  long YKR;
  long YKS;
  boolean YKT;
  View view;
  
  public g(View paramView)
  {
    AppMethodBeat.i(196651);
    this.view = paramView;
    this.YKN = -1L;
    AppMethodBeat.o(196651);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(196654);
    if (this != paramObject)
    {
      if ((paramObject instanceof g))
      {
        paramObject = (g)paramObject;
        if (!p.h(this.view, paramObject.view)) {}
      }
    }
    else
    {
      AppMethodBeat.o(196654);
      return true;
    }
    AppMethodBeat.o(196654);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(196653);
    View localView = this.view;
    if (localView != null)
    {
      int i = localView.hashCode();
      AppMethodBeat.o(196653);
      return i;
    }
    AppMethodBeat.o(196653);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(196652);
    String str = "ExposedData(view=" + this.view + ")";
    AppMethodBeat.o(196652);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.view.g
 * JD-Core Version:    0.7.0.1
 */