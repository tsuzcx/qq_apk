package com.tencent.mm.ui.widget.cropview;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/widget/cropview/RoundCropLayout$SimpleTouchListener;", "Landroid/view/View$OnTouchListener;", "(Lcom/tencent/mm/ui/widget/cropview/RoundCropLayout;)V", "isScale", "", "onTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "libmmui_release"})
final class RoundCropLayout$b
  implements View.OnTouchListener
{
  private boolean HEo;
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164457);
    if (paramMotionEvent != null)
    {
      paramView = Integer.valueOf(paramMotionEvent.getActionMasked());
      ad.d(RoundCropLayout.a(this.HEn), "action ".concat(String.valueOf(paramView)));
      if (paramView != null) {
        break label87;
      }
      label40:
      if (paramView != null) {
        break label102;
      }
    }
    for (;;)
    {
      RoundCropLayout.b(this.HEn).onTouchEvent(paramMotionEvent);
      if (!this.HEo) {
        RoundCropLayout.c(this.HEn).onTouchEvent(paramMotionEvent);
      }
      AppMethodBeat.o(164457);
      return true;
      paramView = null;
      break;
      label87:
      if (paramView.intValue() != 0) {
        break label40;
      }
      this.HEo = false;
      continue;
      label102:
      if ((paramView.intValue() == 5) && (paramMotionEvent.getPointerCount() == 2)) {
        this.HEo = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.RoundCropLayout.b
 * JD-Core Version:    0.7.0.1
 */