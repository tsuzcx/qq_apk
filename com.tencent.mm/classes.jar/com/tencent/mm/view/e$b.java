package com.tencent.mm.view;

import android.view.View;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "", "()V", "getExposedId", "", "view", "Landroid/view/View;", "onViewExposed", "", "oldExposedId", "newExposedId", "isExposed", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class e$b
{
  public abstract void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean);
  
  public long fq(View paramView)
  {
    s.u(paramView, "view");
    return paramView.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.e.b
 * JD-Core Version:    0.7.0.1
 */