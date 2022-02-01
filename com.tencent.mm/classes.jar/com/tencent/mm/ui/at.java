package com.tencent.mm.ui;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/TouchDelegateWrapper;", "Landroid/view/TouchDelegate;", "bounds", "Landroid/graphics/Rect;", "delegateView", "Landroid/view/View;", "(Landroid/graphics/Rect;Landroid/view/View;)V", "getBounds", "()Landroid/graphics/Rect;", "setBounds", "(Landroid/graphics/Rect;)V", "getDelegateView", "()Landroid/view/View;", "setDelegateView", "(Landroid/view/View;)V", "getTouchEventDistance", "", "event", "Landroid/view/MotionEvent;", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class at
  extends TouchDelegate
{
  View adKL;
  private Rect bounds;
  
  public at(Rect paramRect, View paramView)
  {
    super(paramRect, paramView);
    AppMethodBeat.i(249337);
    this.adKL = paramView;
    this.bounds = paramRect;
    AppMethodBeat.o(249337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.at
 * JD-Core Version:    0.7.0.1
 */