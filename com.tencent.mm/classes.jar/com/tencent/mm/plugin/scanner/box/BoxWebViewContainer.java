package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/BoxWebViewContainer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "enableScroll", "", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "setEnableScroll", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BoxWebViewContainer
  extends RelativeLayout
{
  private boolean vqv;
  
  public BoxWebViewContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(313693);
    AppMethodBeat.o(313693);
  }
  
  public BoxWebViewContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(313700);
    this.vqv = true;
    AppMethodBeat.o(313700);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(313708);
    if (!this.vqv)
    {
      if ((paramMotionEvent != null) && (paramMotionEvent.getAction() == 2)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(313708);
        return true;
      }
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(313708);
    return bool;
  }
  
  public final void setEnableScroll(boolean paramBoolean)
  {
    this.vqv = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.BoxWebViewContainer
 * JD-Core Version:    0.7.0.1
 */