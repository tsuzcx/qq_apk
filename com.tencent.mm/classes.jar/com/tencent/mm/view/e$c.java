package com.tencent.mm.view;

import android.view.View;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/ExposeElves$OnViewGroupChildExposedListener;", "", "()V", "canStartExpose", "", "view", "Landroid/view/View;", "getExposedId", "", "ignoreExposeChanged", "onChildExposeChanged", "", "parent", "exposedChildren", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class e$c
{
  public abstract void b(View paramView, List<? extends View> paramList);
  
  public long fq(View paramView)
  {
    s.u(paramView, "view");
    return paramView.hashCode();
  }
  
  public boolean jMl()
  {
    return false;
  }
  
  public boolean mx(View paramView)
  {
    s.u(paramView, "view");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.e.c
 * JD-Core Version:    0.7.0.1
 */