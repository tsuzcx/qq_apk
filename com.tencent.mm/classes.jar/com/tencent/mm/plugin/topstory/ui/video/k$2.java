package com.tencent.mm.plugin.topstory.ui.video;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.a;

final class k$2
  extends GestureDetector.SimpleOnGestureListener
{
  k$2(k paramk) {}
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(1734);
    this.tje.idW.removeCallbacks(this.tje.ied);
    this.tje.tjb.aEY();
    AppMethodBeat.o(1734);
    return true;
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    AppMethodBeat.i(1735);
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null))
    {
      AppMethodBeat.o(1735);
      return true;
    }
    if (this.tje.tja == k.a.tjf)
    {
      if (Math.abs(paramFloat1) <= Math.abs(paramFloat2)) {
        break label156;
      }
      this.tje.tja = k.a.tji;
    }
    float f3;
    for (;;)
    {
      paramFloat1 = paramMotionEvent2.getX();
      paramFloat2 = paramMotionEvent1.getX();
      f3 = paramMotionEvent2.getY() - paramMotionEvent1.getY();
      paramMotionEvent1 = this.tje;
      if (paramMotionEvent1.tja != k.a.tji) {
        break;
      }
      if (paramMotionEvent1.ieb == -1)
      {
        paramMotionEvent1.tjb.aEZ();
        paramMotionEvent1.ieb = paramMotionEvent1.tjb.getCurrentPosition();
      }
      paramMotionEvent1.iec = paramMotionEvent1.tjb.bj(paramFloat1 - paramFloat2);
      AppMethodBeat.o(1735);
      return true;
      label156:
      if (paramMotionEvent1.getX() < this.tje.idW.getMeasuredWidth() / 2) {
        this.tje.tja = k.a.tjh;
      } else {
        this.tje.tja = k.a.tjg;
      }
    }
    if ((paramMotionEvent1.tja == k.a.tjh) && (paramMotionEvent1.tjd))
    {
      paramFloat1 = f3 * -1.0F / paramMotionEvent1.idW.getMeasuredHeight() * 1.2F + paramMotionEvent1.iaW;
      if (paramFloat1 < 0.0F) {
        paramFloat1 = f2;
      }
    }
    label321:
    label490:
    label493:
    for (;;)
    {
      paramMotionEvent1 = paramMotionEvent1.mContext;
      if ((paramMotionEvent1 instanceof Activity))
      {
        if (paramFloat1 >= 0.01F) {
          break label321;
        }
        paramFloat2 = 0.01F;
      }
      for (;;)
      {
        paramMotionEvent1 = (Activity)paramMotionEvent1;
        paramMotionEvent2 = paramMotionEvent1.getWindow().getAttributes();
        paramMotionEvent2.screenBrightness = paramFloat2;
        paramMotionEvent1.getWindow().setAttributes(paramMotionEvent2);
        AppMethodBeat.o(1735);
        return true;
        if (paramFloat1 <= 1.0F) {
          break label493;
        }
        paramFloat1 = 1.0F;
        break;
        paramFloat2 = f1;
        if (paramFloat1 <= 1.0F) {
          paramFloat2 = paramFloat1;
        }
      }
      if ((paramMotionEvent1.tja != k.a.tjg) || (!paramMotionEvent1.tjc)) {
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
          a.b(paramMotionEvent2, 3, i);
          break;
          if (paramFloat1 >= 0.0F) {
            break label490;
          }
          i = -1;
          break label433;
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
    AppMethodBeat.i(1733);
    this.tje.idW.postDelayed(this.tje.ied, 200L);
    AppMethodBeat.o(1733);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.k.2
 * JD-Core Version:    0.7.0.1
 */