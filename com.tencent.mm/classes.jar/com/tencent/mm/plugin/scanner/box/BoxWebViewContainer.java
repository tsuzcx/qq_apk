package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/box/BoxWebViewContainer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "enableScroll", "", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "setEnableScroll", "", "plugin-scan_release"})
public final class BoxWebViewContainer
  extends RelativeLayout
{
  private boolean nlD;
  
  public BoxWebViewContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(199567);
    AppMethodBeat.o(199567);
  }
  
  public BoxWebViewContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(199568);
    this.nlD = true;
    AppMethodBeat.o(199568);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(199566);
    if ((!this.nlD) && (paramMotionEvent != null) && (paramMotionEvent.getAction() == 2))
    {
      AppMethodBeat.o(199566);
      return true;
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(199566);
    return bool;
  }
  
  public final void setEnableScroll(boolean paramBoolean)
  {
    this.nlD = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.BoxWebViewContainer
 * JD-Core Version:    0.7.0.1
 */