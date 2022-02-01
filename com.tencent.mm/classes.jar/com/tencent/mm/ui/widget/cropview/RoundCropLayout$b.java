package com.tencent.mm.ui.widget.cropview;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/widget/cropview/RoundCropLayout$SimpleTouchListener;", "Landroid/view/View$OnTouchListener;", "(Lcom/tencent/mm/ui/widget/cropview/RoundCropLayout;)V", "isScale", "", "onTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "libmmui_release"})
final class RoundCropLayout$b
  implements View.OnTouchListener
{
  private boolean gLe;
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164457);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/cropview/RoundCropLayout$SimpleTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    if (paramMotionEvent != null)
    {
      paramView = Integer.valueOf(paramMotionEvent.getActionMasked());
      ad.d(RoundCropLayout.a(this.KVR), "action ".concat(String.valueOf(paramView)));
      if (paramView != null) {
        break label191;
      }
      label74:
      if (paramView != null) {
        break label206;
      }
    }
    for (;;)
    {
      RoundCropLayout.b(this.KVR).onTouchEvent(paramMotionEvent);
      if (!this.gLe)
      {
        paramView = RoundCropLayout.c(this.KVR);
        paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(paramView, paramMotionEvent.ahp(), "com/tencent/mm/ui/widget/cropview/RoundCropLayout$SimpleTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.mq(0)), "com/tencent/mm/ui/widget/cropview/RoundCropLayout$SimpleTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/cropview/RoundCropLayout$SimpleTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(164457);
      return true;
      paramView = null;
      break;
      label191:
      if (paramView.intValue() != 0) {
        break label74;
      }
      this.gLe = false;
      continue;
      label206:
      if ((paramView.intValue() == 5) && (paramMotionEvent.getPointerCount() == 2)) {
        this.gLe = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.RoundCropLayout.b
 * JD-Core Version:    0.7.0.1
 */