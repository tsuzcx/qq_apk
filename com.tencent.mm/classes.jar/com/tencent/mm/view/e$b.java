package com.tencent.mm.view;

import android.view.View;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "", "()V", "getExposedId", "", "view", "Landroid/view/View;", "onViewExposed", "", "oldExposedId", "newExposedId", "isExposed", "", "libmmui_release"})
public abstract class e$b
{
  public long er(View paramView)
  {
    p.k(paramView, "view");
    return paramView.hashCode();
  }
  
  public abstract void p(View paramView, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.e.b
 * JD-Core Version:    0.7.0.1
 */