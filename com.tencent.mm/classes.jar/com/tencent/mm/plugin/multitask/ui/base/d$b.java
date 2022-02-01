package com.tencent.mm.plugin.multitask.ui.base;

import android.content.Context;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/ui/base/MultiTaskWrapper$addMultiTaskWrapper$1", "Landroid/widget/FrameLayout;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "plugin-multitask_release"})
public final class d$b
  extends FrameLayout
{
  public d$b(View paramView, z.f paramf, Context paramContext)
  {
    super(localContext);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Float localFloat2 = null;
    AppMethodBeat.i(200766);
    if (paramMotionEvent != null) {}
    for (Float localFloat1 = Float.valueOf(paramMotionEvent.getRawX());; localFloat1 = null)
    {
      if (paramMotionEvent != null) {
        localFloat2 = Float.valueOf(paramMotionEvent.getRawY());
      }
      Object localObject = this.Adw;
      p.h(localObject, "view");
      int[] arrayOfInt = new int[2];
      ((View)localObject).getLocationOnScreen(arrayOfInt);
      float f1 = arrayOfInt[0];
      float f2 = arrayOfInt[1];
      float f3 = arrayOfInt[0] + ((View)localObject).getWidth();
      int i = arrayOfInt[1];
      localObject = new RectF(f1, f2, f3, ((View)localObject).getHeight() + i);
      if ((localFloat1 == null) || (localFloat2 == null)) {
        break;
      }
      f1 = ((Number)localFloat2).floatValue();
      if (!((RectF)localObject).contains(((Number)localFloat1).floatValue(), f1)) {
        break;
      }
      AppMethodBeat.o(200766);
      return true;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(200766);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.base.d.b
 * JD-Core Version:    0.7.0.1
 */