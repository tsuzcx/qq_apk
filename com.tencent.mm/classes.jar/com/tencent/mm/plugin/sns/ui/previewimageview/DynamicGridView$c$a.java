package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

final class DynamicGridView$c$a
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int ahA;
  private final int pqT;
  
  static
  {
    if (!DynamicGridView.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  DynamicGridView$c$a(DynamicGridView.c paramc, int paramInt1, int paramInt2)
  {
    this.pqT = paramInt1;
    this.ahA = paramInt2;
  }
  
  public final boolean onPreDraw()
  {
    this.pqV.pqL.getViewTreeObserver().removeOnPreDrawListener(this);
    DynamicGridView.a(this.pqV.pqL, DynamicGridView.e(this.pqV.pqL) + this.pqV.qQ);
    DynamicGridView.b(this.pqV.pqL, DynamicGridView.f(this.pqV.pqL) + this.pqV.qP);
    DynamicGridView.a(this.pqV.pqL, this.pqT, this.ahA);
    new StringBuilder("id ").append(this.pqV.pqL.gC(DynamicGridView.h(this.pqV.pqL)));
    if (DynamicGridView.g(this.pqV.pqL) == null) {}
    do
    {
      do
      {
        return true;
      } while (DynamicGridView.g(this.pqV.pqL) == null);
      assert (DynamicGridView.g(this.pqV.pqL) != null);
      DynamicGridView.g(this.pqV.pqL).setVisibility(0);
      DynamicGridView.b(this.pqV.pqL, this.pqV.pqL.gD(DynamicGridView.h(this.pqV.pqL)));
    } while (DynamicGridView.g(this.pqV.pqL) == null);
    assert (DynamicGridView.g(this.pqV.pqL) != null);
    DynamicGridView.g(this.pqV.pqL).setVisibility(4);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.c.a
 * JD-Core Version:    0.7.0.1
 */