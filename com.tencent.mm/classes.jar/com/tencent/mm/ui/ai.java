package com.tencent.mm.ui;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/TouchDelegateWrapper;", "Landroid/view/TouchDelegate;", "bounds", "Landroid/graphics/Rect;", "delegateView", "Landroid/view/View;", "(Landroid/graphics/Rect;Landroid/view/View;)V", "getBounds", "()Landroid/graphics/Rect;", "setBounds", "(Landroid/graphics/Rect;)V", "getDelegateView", "()Landroid/view/View;", "setDelegateView", "(Landroid/view/View;)V", "getTouchEventDistance", "", "event", "Landroid/view/MotionEvent;", "libmmui_release"})
public final class ai
  extends TouchDelegate
{
  View Jgo;
  private Rect hL;
  
  public ai(Rect paramRect, View paramView)
  {
    super(paramRect, paramView);
    AppMethodBeat.i(186568);
    this.Jgo = paramView;
    this.hL = paramRect;
    AppMethodBeat.o(186568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.ai
 * JD-Core Version:    0.7.0.1
 */