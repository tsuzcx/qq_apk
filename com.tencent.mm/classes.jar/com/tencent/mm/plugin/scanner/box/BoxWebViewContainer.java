package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/BoxWebViewContainer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "enableScroll", "", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "setEnableScroll", "", "plugin-scan_release"})
public final class BoxWebViewContainer
  extends RelativeLayout
{
  private boolean pcF;
  
  public BoxWebViewContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(240242);
    AppMethodBeat.o(240242);
  }
  
  public BoxWebViewContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(240243);
    this.pcF = true;
    AppMethodBeat.o(240243);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(240241);
    if ((!this.pcF) && (paramMotionEvent != null) && (paramMotionEvent.getAction() == 2))
    {
      AppMethodBeat.o(240241);
      return true;
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(240241);
    return bool;
  }
  
  public final void setEnableScroll(boolean paramBoolean)
  {
    this.pcF = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.BoxWebViewContainer
 * JD-Core Version:    0.7.0.1
 */