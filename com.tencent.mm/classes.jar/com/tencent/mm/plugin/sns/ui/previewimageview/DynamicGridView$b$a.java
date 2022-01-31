package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DynamicGridView$b$a
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int ajQ;
  private final View slK;
  private final int slL;
  
  DynamicGridView$b$a(DynamicGridView.b paramb, View paramView, int paramInt1, int paramInt2)
  {
    this.slK = paramView;
    this.slL = paramInt1;
    this.ajQ = paramInt2;
  }
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(40359);
    this.slM.slD.getViewTreeObserver().removeOnPreDrawListener(this);
    DynamicGridView.a(this.slM.slD, DynamicGridView.e(this.slM.slD) + DynamicGridView.b.a(this.slM));
    DynamicGridView.b(this.slM.slD, DynamicGridView.f(this.slM.slD) + DynamicGridView.b.b(this.slM));
    DynamicGridView.a(this.slM.slD, this.slL, this.ajQ);
    this.slK.setVisibility(0);
    if (DynamicGridView.g(this.slM.slD) != null) {
      DynamicGridView.g(this.slM.slD).setVisibility(4);
    }
    AppMethodBeat.o(40359);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.b.a
 * JD-Core Version:    0.7.0.1
 */