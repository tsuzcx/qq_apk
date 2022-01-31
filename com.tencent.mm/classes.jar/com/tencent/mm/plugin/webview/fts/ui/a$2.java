package com.tencent.mm.plugin.webview.fts.ui;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$2
  extends GestureDetector.SimpleOnGestureListener
{
  a$2(a parama) {}
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(5817);
    this.uQb.idW.removeCallbacks(this.uQb.ied);
    this.uQb.uQa.aEY();
    AppMethodBeat.o(5817);
    return true;
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    AppMethodBeat.i(5818);
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null))
    {
      AppMethodBeat.o(5818);
      return true;
    }
    if (this.uQb.uPZ == a.a.uQc)
    {
      if (Math.abs(paramFloat1) <= Math.abs(paramFloat2)) {
        break label160;
      }
      this.uQb.uPZ = a.a.uQf;
    }
    float f3;
    for (;;)
    {
      paramFloat1 = paramMotionEvent2.getX();
      paramFloat2 = paramMotionEvent1.getX();
      f3 = paramMotionEvent2.getY() - paramMotionEvent1.getY();
      paramMotionEvent1 = this.uQb;
      if (paramMotionEvent1.uPZ != a.a.uQf) {
        break;
      }
      if (paramMotionEvent1.ieb == -1)
      {
        paramMotionEvent1.uQa.aEZ();
        paramMotionEvent1.ieb = paramMotionEvent1.uQa.getCurrentPosition();
      }
      paramMotionEvent1.iec = paramMotionEvent1.uQa.h(paramMotionEvent1.ieb, paramFloat1 - paramFloat2);
      AppMethodBeat.o(5818);
      return true;
      label160:
      if (paramMotionEvent1.getX() < this.uQb.idW.getMeasuredWidth() / 2) {
        this.uQb.uPZ = a.a.uQe;
      } else {
        this.uQb.uPZ = a.a.uQd;
      }
    }
    if (paramMotionEvent1.uPZ == a.a.uQe)
    {
      paramFloat1 = f3 * -1.0F / paramMotionEvent1.idW.getMeasuredHeight() * 1.2F + paramMotionEvent1.iaW;
      if (paramFloat1 < 0.0F) {
        paramFloat1 = f2;
      }
    }
    label249:
    label506:
    label509:
    for (;;)
    {
      paramMotionEvent2 = paramMotionEvent1.mContext;
      if ((paramMotionEvent2 instanceof Activity))
      {
        if (paramFloat1 >= 0.01F) {
          break label326;
        }
        paramFloat2 = 0.01F;
      }
      for (;;)
      {
        paramMotionEvent2 = (Activity)paramMotionEvent2;
        WindowManager.LayoutParams localLayoutParams = paramMotionEvent2.getWindow().getAttributes();
        localLayoutParams.screenBrightness = paramFloat2;
        paramMotionEvent2.getWindow().setAttributes(localLayoutParams);
        paramMotionEvent1.uQa.ax(paramFloat1);
        break;
        if (paramFloat1 <= 1.0F) {
          break label509;
        }
        paramFloat1 = 1.0F;
        break label249;
        paramFloat2 = f1;
        if (paramFloat1 <= 1.0F) {
          paramFloat2 = paramFloat1;
        }
      }
      if (paramMotionEvent1.uPZ != a.a.uQd) {
        break;
      }
      paramFloat1 = f3 * -1.0F;
      paramFloat2 = paramFloat1 / paramMotionEvent1.idW.getMeasuredHeight();
      paramMotionEvent2 = (AudioManager)paramMotionEvent1.mContext.getSystemService("audio");
      int j = paramMotionEvent2.getStreamMaxVolume(3);
      paramFloat2 = 1.2F * (paramFloat2 * j);
      int i = (int)paramFloat2;
      if ((i == 0) && (Math.abs(paramFloat2) > 0.2F)) {
        if (paramFloat1 > 0.0F) {
          i = 1;
        }
      }
      for (;;)
      {
        int k = i + paramMotionEvent1.De;
        if (k < 0) {
          i = 0;
        }
        for (;;)
        {
          com.tencent.mm.compatible.b.a.b(paramMotionEvent2, 3, i);
          paramFloat1 = i / j;
          paramMotionEvent1.uQa.aw(paramFloat1);
          break;
          if (paramFloat1 >= 0.0F) {
            break label506;
          }
          i = -1;
          break label431;
          i = k;
          if (k >= j) {
            i = j;
          }
        }
      }
    }
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(5816);
    this.uQb.idW.postDelayed(this.uQb.ied, 200L);
    AppMethodBeat.o(5816);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.a.2
 * JD-Core Version:    0.7.0.1
 */