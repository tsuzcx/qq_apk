package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DynamicGridView$c$a
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int ajQ;
  private final int slL;
  
  static
  {
    AppMethodBeat.i(40363);
    if (!DynamicGridView.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(40363);
      return;
    }
  }
  
  DynamicGridView$c$a(DynamicGridView.c paramc, int paramInt1, int paramInt2)
  {
    this.slL = paramInt1;
    this.ajQ = paramInt2;
  }
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(40362);
    this.slN.slD.getViewTreeObserver().removeOnPreDrawListener(this);
    DynamicGridView.a(this.slN.slD, DynamicGridView.e(this.slN.slD) + this.slN.rN);
    DynamicGridView.b(this.slN.slD, DynamicGridView.f(this.slN.slD) + this.slN.rM);
    DynamicGridView.a(this.slN.slD, this.slL, this.ajQ);
    new StringBuilder("id ").append(this.slN.slD.mk(DynamicGridView.h(this.slN.slD)));
    if (DynamicGridView.g(this.slN.slD) == null)
    {
      AppMethodBeat.o(40362);
      return true;
    }
    if (DynamicGridView.g(this.slN.slD) == null)
    {
      AppMethodBeat.o(40362);
      return true;
    }
    AssertionError localAssertionError;
    if ((!$assertionsDisabled) && (DynamicGridView.g(this.slN.slD) == null))
    {
      localAssertionError = new AssertionError();
      AppMethodBeat.o(40362);
      throw localAssertionError;
    }
    DynamicGridView.g(this.slN.slD).setVisibility(0);
    DynamicGridView.b(this.slN.slD, this.slN.slD.ml(DynamicGridView.h(this.slN.slD)));
    if (DynamicGridView.g(this.slN.slD) == null)
    {
      AppMethodBeat.o(40362);
      return true;
    }
    if ((!$assertionsDisabled) && (DynamicGridView.g(this.slN.slD) == null))
    {
      localAssertionError = new AssertionError();
      AppMethodBeat.o(40362);
      throw localAssertionError;
    }
    DynamicGridView.g(this.slN.slD).setVisibility(4);
    AppMethodBeat.o(40362);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.c.a
 * JD-Core Version:    0.7.0.1
 */