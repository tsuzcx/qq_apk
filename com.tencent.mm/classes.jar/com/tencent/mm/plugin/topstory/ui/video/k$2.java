package com.tencent.mm.plugin.topstory.ui.video;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

final class k$2
  extends GestureDetector.SimpleOnGestureListener
{
  k$2(k paramk) {}
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    this.pFF.gES.removeCallbacks(this.pFF.gEZ);
    this.pFF.pFC.akm();
    return true;
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
      return true;
    }
    if (this.pFF.pFB == k.a.pFG)
    {
      if (Math.abs(paramFloat1) <= Math.abs(paramFloat2)) {
        break label138;
      }
      this.pFF.pFB = k.a.pFJ;
    }
    float f3;
    for (;;)
    {
      paramFloat1 = paramMotionEvent2.getX();
      paramFloat2 = paramMotionEvent1.getX();
      f3 = paramMotionEvent2.getY() - paramMotionEvent1.getY();
      paramMotionEvent1 = this.pFF;
      if (paramMotionEvent1.pFB != k.a.pFJ) {
        break;
      }
      if (paramMotionEvent1.gEX == -1)
      {
        paramMotionEvent1.pFC.akn();
        paramMotionEvent1.gEX = paramMotionEvent1.pFC.getCurrentPosition();
      }
      paramMotionEvent1.gEY = paramMotionEvent1.pFC.aG(paramFloat1 - paramFloat2);
      return true;
      label138:
      if (paramMotionEvent1.getX() < this.pFF.gES.getMeasuredWidth() / 2) {
        this.pFF.pFB = k.a.pFI;
      } else {
        this.pFF.pFB = k.a.pFH;
      }
    }
    if ((paramMotionEvent1.pFB == k.a.pFI) && (paramMotionEvent1.pFE))
    {
      paramFloat1 = f3 * -1.0F / paramMotionEvent1.gES.getMeasuredHeight() * 1.2F + paramMotionEvent1.gCn;
      if (paramFloat1 < 0.0F) {
        paramFloat1 = f2;
      }
    }
    label466:
    label469:
    for (;;)
    {
      paramMotionEvent1 = paramMotionEvent1.mContext;
      if (!(paramMotionEvent1 instanceof Activity)) {
        break;
      }
      if (paramFloat1 < 0.01F) {
        paramFloat2 = 0.01F;
      }
      for (;;)
      {
        paramMotionEvent1 = (Activity)paramMotionEvent1;
        paramMotionEvent2 = paramMotionEvent1.getWindow().getAttributes();
        paramMotionEvent2.screenBrightness = paramFloat2;
        paramMotionEvent1.getWindow().setAttributes(paramMotionEvent2);
        return true;
        if (paramFloat1 <= 1.0F) {
          break label469;
        }
        paramFloat1 = 1.0F;
        break;
        paramFloat2 = f1;
        if (paramFloat1 <= 1.0F) {
          paramFloat2 = paramFloat1;
        }
      }
      if ((paramMotionEvent1.pFB != k.a.pFH) || (!paramMotionEvent1.pFD)) {
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
          return true;
          if (paramFloat1 >= 0.0F) {
            break label466;
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
    this.pFF.gES.postDelayed(this.pFF.gEZ, 200L);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.k.2
 * JD-Core Version:    0.7.0.1
 */