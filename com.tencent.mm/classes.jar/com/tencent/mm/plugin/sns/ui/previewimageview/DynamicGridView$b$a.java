package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

final class DynamicGridView$b$a
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int ahA;
  private final View pqS;
  private final int pqT;
  
  DynamicGridView$b$a(DynamicGridView.b paramb, View paramView, int paramInt1, int paramInt2)
  {
    this.pqS = paramView;
    this.pqT = paramInt1;
    this.ahA = paramInt2;
  }
  
  public final boolean onPreDraw()
  {
    this.pqU.pqL.getViewTreeObserver().removeOnPreDrawListener(this);
    DynamicGridView.a(this.pqU.pqL, DynamicGridView.e(this.pqU.pqL) + DynamicGridView.b.a(this.pqU));
    DynamicGridView.b(this.pqU.pqL, DynamicGridView.f(this.pqU.pqL) + DynamicGridView.b.b(this.pqU));
    DynamicGridView.a(this.pqU.pqL, this.pqT, this.ahA);
    this.pqS.setVisibility(0);
    if (DynamicGridView.g(this.pqU.pqL) != null) {
      DynamicGridView.g(this.pqU.pqL).setVisibility(4);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.b.a
 * JD-Core Version:    0.7.0.1
 */