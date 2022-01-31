package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.graphics.PointF;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class l$3
  implements WebViewBag.a
{
  l$3(l paraml) {}
  
  public final void eK(int paramInt1, int paramInt2)
  {
    l.a(this.rsA, 19);
    l.c(this.rsA).rsC = paramInt1;
    l.c(this.rsA).rsB = paramInt2;
    l.c(this.rsA).save();
  }
  
  public final void onTouchEvent(MotionEvent paramMotionEvent)
  {
    a locala;
    float f1;
    float f2;
    if (l.d(this.rsA) != null)
    {
      locala = l.d(this.rsA);
      f1 = paramMotionEvent.getRawX();
      f2 = paramMotionEvent.getRawY();
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      return;
    case 0: 
      locala.rre.x = f1;
      locala.rre.y = f2;
    }
    for (;;)
    {
      locala.rrd = false;
      locala.rrf = false;
      return;
      boolean bool;
      label163:
      Object localObject1;
      Object localObject2;
      if (locala.rrd)
      {
        bool = true;
        if (!bool) {
          break;
        }
        if (!locala.mIsShowing)
        {
          b.ceU();
          locala.mIsShowing = true;
          locala.mScreenWidth = com.tencent.mm.cb.a.fj(ae.getContext());
          locala.mScreenHeight = com.tencent.mm.cb.a.fk(ae.getContext());
          if (locala.mScreenWidth <= locala.mScreenHeight) {
            break label462;
          }
          bool = true;
          locala.rrg = bool;
          y.i("MicroMsg.BagCancelController", "updateOrientation mIsLandScape:%b", new Object[] { Boolean.valueOf(locala.rrg) });
          localObject1 = locala.rrb;
          ((a.a)localObject1).setVisibility(0);
          localObject2 = new TranslateAnimation(b.rrr, 0.0F, b.rrr, 0.0F);
          ((TranslateAnimation)localObject2).setFillAfter(true);
          ((TranslateAnimation)localObject2).setDuration(200L);
          ((a.a)localObject1).jEm.startAnimation((Animation)localObject2);
          ((a.a)localObject1).QR.startAnimation((Animation)localObject2);
        }
        bool = locala.rrf;
        if (!locala.rrg) {
          break label468;
        }
        f1 = locala.mScreenWidth - paramMotionEvent.getRawX() - b.rri;
        f2 = locala.mScreenHeight - paramMotionEvent.getRawY();
        label302:
        if (f1 * f1 + f2 * f2 >= a.rra) {
          break label500;
        }
      }
      label462:
      label468:
      label500:
      for (locala.rrf = true; locala.rrf != bool; locala.rrf = false)
      {
        paramMotionEvent = locala.rrb;
        if (!locala.rrf) {
          break label509;
        }
        paramMotionEvent.aa(1.0F, b.rrs);
        if (paramMotionEvent.hpm == null) {
          break;
        }
        paramMotionEvent.hpm.vibrate(10L);
        return;
        float f3 = locala.rre.x;
        float f4 = locala.rre.x;
        float f5 = locala.rre.y;
        if ((f1 - f4) * (f1 - f3) + (f2 - locala.rre.y) * (f2 - f5) - 900.0F > 0.0F) {}
        for (bool = true;; bool = false)
        {
          locala.rrd = bool;
          bool = locala.rrd;
          break;
        }
        bool = false;
        break label163;
        f1 = locala.mScreenWidth - paramMotionEvent.getRawX();
        f2 = locala.mScreenHeight - paramMotionEvent.getRawY() - b.rri;
        break label302;
      }
      label509:
      paramMotionEvent.aa(b.rrs, 1.0F);
      return;
      if (locala.rrf)
      {
        locala.rrc.ceS();
      }
      else if (locala.mIsShowing)
      {
        locala.mIsShowing = false;
        paramMotionEvent = locala.rrb;
        localObject1 = new TranslateAnimation(0.0F, b.rrr, 0.0F, b.rrr);
        localObject2 = new AlphaAnimation(1.0F, 0.0F);
        AnimationSet localAnimationSet = new AnimationSet(true);
        localAnimationSet.addAnimation((Animation)localObject2);
        localAnimationSet.addAnimation((Animation)localObject1);
        localAnimationSet.setDuration(300L);
        localAnimationSet.setAnimationListener(new a.a.1(paramMotionEvent));
        paramMotionEvent.jEm.startAnimation(localAnimationSet);
        paramMotionEvent.QR.startAnimation(localAnimationSet);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.l.3
 * JD-Core Version:    0.7.0.1
 */