package com.tencent.mm.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/TouchableLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "Companion", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public class TouchableLayout
  extends FrameLayout
{
  public static final TouchableLayout.a agKp;
  private static int qjs;
  private static int qjt;
  
  static
  {
    AppMethodBeat.i(164649);
    agKp = new TouchableLayout.a((byte)0);
    AppMethodBeat.o(164649);
  }
  
  public TouchableLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(234608);
    AppMethodBeat.o(234608);
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
    s.u(paramMotionEvent, "ev");
    if (paramMotionEvent.getAction() == 0)
    {
      qjs = (int)paramMotionEvent.getRawX();
      qjt = (int)paramMotionEvent.getRawY();
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(164646);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.TouchableLayout
 * JD-Core Version:    0.7.0.1
 */