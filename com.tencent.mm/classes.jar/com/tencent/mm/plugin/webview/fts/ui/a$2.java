package com.tencent.mm.plugin.webview.fts.ui;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

final class a$2
  extends GestureDetector.SimpleOnGestureListener
{
  a$2(a parama) {}
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    this.rau.gES.removeCallbacks(this.rau.gEZ);
    this.rau.rat.akm();
    return true;
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
      return true;
    }
    if (this.rau.ras == a.a.rav)
    {
      if (Math.abs(paramFloat1) <= Math.abs(paramFloat2)) {
        break label142;
      }
      this.rau.ras = a.a.ray;
    }
    float f3;
    for (;;)
    {
      paramFloat1 = paramMotionEvent2.getX();
      paramFloat2 = paramMotionEvent1.getX();
      f3 = paramMotionEvent2.getY() - paramMotionEvent1.getY();
      paramMotionEvent1 = this.rau;
      if (paramMotionEvent1.ras != a.a.ray) {
        break;
      }
      if (paramMotionEvent1.gEX == -1)
      {
        paramMotionEvent1.rat.akn();
        paramMotionEvent1.gEX = paramMotionEvent1.rat.getCurrentPosition();
      }
      paramMotionEvent1.gEY = paramMotionEvent1.rat.f(paramMotionEvent1.gEX, paramFloat1 - paramFloat2);
      return true;
      label142:
      if (paramMotionEvent1.getX() < this.rau.gES.getMeasuredWidth() / 2) {
        this.rau.ras = a.a.rax;
      } else {
        this.rau.ras = a.a.raw;
      }
    }
    if (paramMotionEvent1.ras == a.a.rax)
    {
      paramFloat1 = f3 * -1.0F / paramMotionEvent1.gES.getMeasuredHeight() * 1.2F + paramMotionEvent1.gCn;
      if (paramFloat1 < 0.0F) {
        paramFloat1 = f2;
      }
    }
    label307:
    label487:
    label490:
    for (;;)
    {
      paramMotionEvent2 = paramMotionEvent1.mContext;
      if ((paramMotionEvent2 instanceof Activity))
      {
        if (paramFloat1 >= 0.01F) {
          break label307;
        }
        paramFloat2 = 0.01F;
      }
      for (;;)
      {
        paramMotionEvent2 = (Activity)paramMotionEvent2;
        WindowManager.LayoutParams localLayoutParams = paramMotionEvent2.getWindow().getAttributes();
        localLayoutParams.screenBrightness = paramFloat2;
        paramMotionEvent2.getWindow().setAttributes(localLayoutParams);
        paramMotionEvent1.rat.ai(paramFloat1);
        return true;
        if (paramFloat1 <= 1.0F) {
          break label490;
        }
        paramFloat1 = 1.0F;
        break;
        paramFloat2 = f1;
        if (paramFloat1 <= 1.0F) {
          paramFloat2 = paramFloat1;
        }
      }
      if (paramMotionEvent1.ras != a.a.raw) {
        break;
      }
      paramFloat1 = f3 * -1.0F;
      paramFloat2 = paramFloat1 / paramMotionEvent1.gES.getMeasuredHeight();
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
        int k = i + paramMotionEvent1.Cv;
        if (k < 0) {
          i = 0;
        }
        for (;;)
        {
          paramMotionEvent2.setStreamVolume(3, i, 0);
          paramFloat1 = i / j;
          paramMotionEvent1.rat.ah(paramFloat1);
          return true;
          if (paramFloat1 >= 0.0F) {
            break label487;
          }
          i = -1;
          break;
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
    this.rau.gES.postDelayed(this.rau.gEZ, 200L);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.a.2
 * JD-Core Version:    0.7.0.1
 */