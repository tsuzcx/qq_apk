package com.tencent.mm.plugin.multitask.ui.base;

import android.content.Context;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper$addMultiTaskWrapper$1", "Landroid/widget/FrameLayout;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$b
  extends FrameLayout
{
  public c$b(c paramc, View paramView, Context paramContext)
  {
    super(paramContext);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Float localFloat2 = null;
    AppMethodBeat.i(304583);
    Float localFloat1;
    if (paramMotionEvent == null)
    {
      localFloat1 = null;
      if (paramMotionEvent != null) {
        break label152;
      }
    }
    for (;;)
    {
      Object localObject = this.LFr;
      s.u(localObject, "view");
      int[] arrayOfInt = new int[2];
      ((View)localObject).getLocationOnScreen(arrayOfInt);
      float f1 = arrayOfInt[0];
      float f2 = arrayOfInt[1];
      float f3 = arrayOfInt[0] + ((View)localObject).getWidth();
      int i = arrayOfInt[1];
      localObject = new RectF(f1, f2, f3, ((View)localObject).getHeight() + i);
      if ((localFloat1 == null) || (localFloat2 == null)) {
        break label164;
      }
      f1 = ((Number)localFloat2).floatValue();
      if (!((RectF)localObject).contains(((Number)localFloat1).floatValue(), f1)) {
        break label164;
      }
      AppMethodBeat.o(304583);
      return true;
      localFloat1 = Float.valueOf(paramMotionEvent.getRawX());
      break;
      label152:
      localFloat2 = Float.valueOf(paramMotionEvent.getRawY());
    }
    label164:
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(304583);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.base.c.b
 * JD-Core Version:    0.7.0.1
 */