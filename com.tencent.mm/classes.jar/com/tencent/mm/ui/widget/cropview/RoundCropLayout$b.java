package com.tencent.mm.ui.widget.cropview;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/cropview/RoundCropLayout$SimpleTouchListener;", "Landroid/view/View$OnTouchListener;", "(Lcom/tencent/mm/ui/widget/cropview/RoundCropLayout;)V", "isScale", "", "onTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
final class RoundCropLayout$b
  implements View.OnTouchListener
{
  private boolean mVA;
  
  public RoundCropLayout$b()
  {
    AppMethodBeat.i(252517);
    AppMethodBeat.o(252517);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164457);
    if (paramMotionEvent == null)
    {
      paramView = null;
      Log.d(RoundCropLayout.a(this.agdN), s.X("action ", paramView));
      if (paramView != null) {
        break label141;
      }
      label31:
      if (paramView != null) {
        break label156;
      }
    }
    for (;;)
    {
      RoundCropLayout.b(this.agdN).onTouchEvent(paramMotionEvent);
      if (!this.mVA)
      {
        paramView = RoundCropLayout.c(this.agdN);
        paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b(paramView, paramMotionEvent.aYi(), "com/tencent/mm/ui/widget/cropview/RoundCropLayout$SimpleTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.sb(0)), "com/tencent/mm/ui/widget/cropview/RoundCropLayout$SimpleTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      }
      AppMethodBeat.o(164457);
      return true;
      paramView = Integer.valueOf(paramMotionEvent.getActionMasked());
      break;
      label141:
      if (paramView.intValue() != 0) {
        break label31;
      }
      this.mVA = false;
      continue;
      label156:
      if ((paramView.intValue() == 5) && (paramMotionEvent.getPointerCount() == 2)) {
        this.mVA = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.RoundCropLayout.b
 * JD-Core Version:    0.7.0.1
 */