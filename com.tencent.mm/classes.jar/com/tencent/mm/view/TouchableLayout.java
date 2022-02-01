package com.tencent.mm.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/TouchableLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "Companion", "libmmui_release"})
public class TouchableLayout
  extends FrameLayout
{
  public static final a YOD;
  private static int nmj;
  private static int nmk;
  
  static
  {
    AppMethodBeat.i(164649);
    YOD = new a((byte)0);
    AppMethodBeat.o(164649);
  }
  
  public TouchableLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(207249);
    AppMethodBeat.o(207249);
  }
  
  public TouchableLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164647);
    AppMethodBeat.o(164647);
  }
  
  public TouchableLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164648);
    AppMethodBeat.o(164648);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164646);
    p.k(paramMotionEvent, "ev");
    if (paramMotionEvent.getAction() == 0)
    {
      nmj = (int)paramMotionEvent.getRawX();
      nmk = (int)paramMotionEvent.getRawY();
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(164646);
    return bool;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/TouchableLayout$Companion;", "", "()V", "downX", "", "getDownX", "()I", "setDownX", "(I)V", "downY", "getDownY", "setDownY", "libmmui_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.TouchableLayout
 * JD-Core Version:    0.7.0.1
 */