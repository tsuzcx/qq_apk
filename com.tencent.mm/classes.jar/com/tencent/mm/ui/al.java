package com.tencent.mm.ui;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/TouchDelegateWrapper;", "Landroid/view/TouchDelegate;", "bounds", "Landroid/graphics/Rect;", "delegateView", "Landroid/view/View;", "(Landroid/graphics/Rect;Landroid/view/View;)V", "getBounds", "()Landroid/graphics/Rect;", "setBounds", "(Landroid/graphics/Rect;)V", "getDelegateView", "()Landroid/view/View;", "setDelegateView", "(Landroid/view/View;)V", "getTouchEventDistance", "", "event", "Landroid/view/MotionEvent;", "libmmui_release"})
public final class al
  extends TouchDelegate
{
  View OLE;
  private Rect hN;
  
  public al(Rect paramRect, View paramView)
  {
    super(paramRect, paramView);
    AppMethodBeat.i(204791);
    this.OLE = paramView;
    this.hN = paramRect;
    AppMethodBeat.o(204791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.al
 * JD-Core Version:    0.7.0.1
 */