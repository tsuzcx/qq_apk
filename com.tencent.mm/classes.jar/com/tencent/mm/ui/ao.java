package com.tencent.mm.ui;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/TouchDelegateWrapper;", "Landroid/view/TouchDelegate;", "bounds", "Landroid/graphics/Rect;", "delegateView", "Landroid/view/View;", "(Landroid/graphics/Rect;Landroid/view/View;)V", "getBounds", "()Landroid/graphics/Rect;", "setBounds", "(Landroid/graphics/Rect;)V", "getDelegateView", "()Landroid/view/View;", "setDelegateView", "(Landroid/view/View;)V", "getTouchEventDistance", "", "event", "Landroid/view/MotionEvent;", "libmmui_release"})
public final class ao
  extends TouchDelegate
{
  View Wfd;
  private Rect byi;
  
  public ao(Rect paramRect, View paramView)
  {
    super(paramRect, paramView);
    AppMethodBeat.i(217187);
    this.Wfd = paramView;
    this.byi = paramRect;
    AppMethodBeat.o(217187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.ao
 * JD-Core Version:    0.7.0.1
 */