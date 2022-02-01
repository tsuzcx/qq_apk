package com.tencent.mm.view;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/ExposedData;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "attachStateChangeListener", "Landroid/view/View$OnAttachStateChangeListener;", "getAttachStateChangeListener", "()Landroid/view/View$OnAttachStateChangeListener;", "setAttachStateChangeListener", "(Landroid/view/View$OnAttachStateChangeListener;)V", "checkDestroyTimeMs", "", "getCheckDestroyTimeMs", "()J", "setCheckDestroyTimeMs", "(J)V", "exposedChildKey", "getExposedChildKey", "setExposedChildKey", "exposedKey", "getExposedKey", "setExposedKey", "isLeak", "", "()Z", "setLeak", "(Z)V", "isWillRemove", "setWillRemove", "getView", "()Landroid/view/View;", "setView", "viewExposeListener", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "getViewExposeListener", "()Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "setViewExposeListener", "(Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;)V", "viewGroupChildExposeListener", "Lcom/tencent/mm/view/ExposeElves$OnViewGroupChildExposedListener;", "getViewGroupChildExposeListener", "()Lcom/tencent/mm/view/ExposeElves$OnViewGroupChildExposedListener;", "setViewGroupChildExposeListener", "(Lcom/tencent/mm/view/ExposeElves$OnViewGroupChildExposedListener;)V", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  long agGC;
  View.OnAttachStateChangeListener agGD;
  e.b agGE;
  e.c agGF;
  long agGG;
  long agGH;
  boolean agGI;
  boolean agGJ;
  View view;
  
  public g(View paramView)
  {
    AppMethodBeat.i(234681);
    this.view = paramView;
    this.agGC = -1L;
    AppMethodBeat.o(234681);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(234691);
    if (this == paramObject)
    {
      AppMethodBeat.o(234691);
      return true;
    }
    if (!(paramObject instanceof g))
    {
      AppMethodBeat.o(234691);
      return false;
    }
    paramObject = (g)paramObject;
    if (!s.p(this.view, paramObject.view))
    {
      AppMethodBeat.o(234691);
      return false;
    }
    AppMethodBeat.o(234691);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(234688);
    int i = this.view.hashCode();
    AppMethodBeat.o(234688);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(234685);
    String str = "ExposedData(view=" + this.view + ')';
    AppMethodBeat.o(234685);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.view.g
 * JD-Core Version:    0.7.0.1
 */