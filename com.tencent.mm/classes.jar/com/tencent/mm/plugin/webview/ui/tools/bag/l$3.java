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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class l$3
  implements WebViewBag.a
{
  l$3(l paraml) {}
  
  public final void gP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(8211);
    l.a(this.viG, 19);
    l.c(this.viG).viI = paramInt1;
    l.c(this.viG).viH = paramInt2;
    l.c(this.viG).save();
    AppMethodBeat.o(8211);
  }
  
  public final void onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(8212);
    a locala;
    float f1;
    float f2;
    if (l.d(this.viG) != null)
    {
      locala = l.d(this.viG);
      f1 = paramMotionEvent.getRawX();
      f2 = paramMotionEvent.getRawY();
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      AppMethodBeat.o(8212);
      return;
    case 0: 
      locala.vhj.x = f1;
      locala.vhj.y = f2;
    }
    for (;;)
    {
      locala.vhi = false;
      locala.vhk = false;
      break;
      boolean bool;
      label178:
      Object localObject1;
      Object localObject2;
      if (locala.vhi)
      {
        bool = true;
        if (!bool) {
          break;
        }
        if (!locala.mIsShowing)
        {
          b.fy(ah.getContext());
          locala.mIsShowing = true;
          locala.mScreenWidth = com.tencent.mm.cb.a.gw(ah.getContext());
          locala.mScreenHeight = com.tencent.mm.cb.a.gx(ah.getContext());
          if (locala.mScreenWidth <= locala.mScreenHeight) {
            break label483;
          }
          bool = true;
          locala.vhl = bool;
          ab.i("MicroMsg.BagCancelController", "updateOrientation mIsLandScape:%b", new Object[] { Boolean.valueOf(locala.vhl) });
          localObject1 = locala.vhg;
          ((a.a)localObject1).setVisibility(0);
          localObject2 = new TranslateAnimation(b.vhw, 0.0F, b.vhw, 0.0F);
          ((TranslateAnimation)localObject2).setFillAfter(true);
          ((TranslateAnimation)localObject2).setDuration(200L);
          ((a.a)localObject1).lNK.startAnimation((Animation)localObject2);
          ((a.a)localObject1).Qz.startAnimation((Animation)localObject2);
        }
        bool = locala.vhk;
        if (!locala.vhl) {
          break label489;
        }
        f1 = locala.mScreenWidth - paramMotionEvent.getRawX() - b.vhn;
        f2 = locala.mScreenHeight - paramMotionEvent.getRawY();
        label317:
        if (f1 * f1 + f2 * f2 >= a.vhf) {
          break label521;
        }
      }
      label521:
      for (locala.vhk = true; locala.vhk != bool; locala.vhk = false)
      {
        paramMotionEvent = locala.vhg;
        if (!locala.vhk) {
          break label530;
        }
        paramMotionEvent.ak(1.0F, b.vhx);
        if (paramMotionEvent.jbU != null) {
          paramMotionEvent.jbU.vibrate(10L);
        }
        AppMethodBeat.o(8212);
        return;
        float f3 = locala.vhj.x;
        float f4 = locala.vhj.x;
        float f5 = locala.vhj.y;
        if ((f1 - f4) * (f1 - f3) + (f2 - locala.vhj.y) * (f2 - f5) - 900.0F > 0.0F) {}
        for (bool = true;; bool = false)
        {
          locala.vhi = bool;
          bool = locala.vhi;
          break;
        }
        label483:
        bool = false;
        break label178;
        label489:
        f1 = locala.mScreenWidth - paramMotionEvent.getRawX();
        f2 = locala.mScreenHeight - paramMotionEvent.getRawY() - b.vhn;
        break label317;
      }
      label530:
      paramMotionEvent.ak(b.vhx, 1.0F);
      AppMethodBeat.o(8212);
      return;
      if (locala.vhk)
      {
        locala.vhh.dfb();
      }
      else if (locala.mIsShowing)
      {
        locala.mIsShowing = false;
        paramMotionEvent = locala.vhg;
        localObject1 = new TranslateAnimation(0.0F, b.vhw, 0.0F, b.vhw);
        localObject2 = new AlphaAnimation(1.0F, 0.0F);
        AnimationSet localAnimationSet = new AnimationSet(true);
        localAnimationSet.addAnimation((Animation)localObject2);
        localAnimationSet.addAnimation((Animation)localObject1);
        localAnimationSet.setDuration(300L);
        localAnimationSet.setAnimationListener(new a.a.1(paramMotionEvent));
        paramMotionEvent.lNK.startAnimation(localAnimationSet);
        paramMotionEvent.Qz.startAnimation(localAnimationSet);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.l.3
 * JD-Core Version:    0.7.0.1
 */