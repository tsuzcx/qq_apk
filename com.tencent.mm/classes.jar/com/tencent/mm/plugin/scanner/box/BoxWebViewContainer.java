package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/box/BoxWebViewContainer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "enableScroll", "", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "setEnableScroll", "", "plugin-scan_release"})
public final class BoxWebViewContainer
  extends RelativeLayout
{
  private boolean nRP;
  
  public BoxWebViewContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(189526);
    AppMethodBeat.o(189526);
  }
  
  public BoxWebViewContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(189527);
    this.nRP = true;
    AppMethodBeat.o(189527);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(189525);
    if ((!this.nRP) && (paramMotionEvent != null) && (paramMotionEvent.getAction() == 2))
    {
      AppMethodBeat.o(189525);
      return true;
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(189525);
    return bool;
  }
  
  public final void setEnableScroll(boolean paramBoolean)
  {
    this.nRP = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.BoxWebViewContainer
 * JD-Core Version:    0.7.0.1
 */