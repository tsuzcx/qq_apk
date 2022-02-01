package com.tencent.mm.ui.base;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.sdk.platformtools.Log;

final class WxImageView$1
  implements View.OnTouchListener
{
  WxImageView$1(WxImageView paramWxImageView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(205274);
    if (paramMotionEvent.getAction() == 0)
    {
      paramView = ad.aVe().G("basescanui@datacenter", true);
      Log.i("MicroMsg.WxImageView", "alvinluo WxImageView get touchCoordinate touch x: %s, y: %s", new Object[] { Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()) });
      paramMotionEvent = WxImageView.a(this.OWZ, paramMotionEvent.getRawX(), paramMotionEvent.getRawY());
      if (paramMotionEvent == null) {
        break label108;
      }
      paramView.l("key_basescanui_touch_normalize_x", Float.valueOf(paramMotionEvent.x));
      paramView.l("key_basescanui_touch_normalize_y", Float.valueOf(paramMotionEvent.y));
    }
    for (;;)
    {
      AppMethodBeat.o(205274);
      return false;
      label108:
      Log.e("MicroMsg.WxImageView", "alvinluo get touchCoordinate is invalid");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.WxImageView.1
 * JD-Core Version:    0.7.0.1
 */