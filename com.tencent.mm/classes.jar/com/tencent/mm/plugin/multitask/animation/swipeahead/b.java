package com.tencent.mm.plugin.multitask.animation.swipeahead;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.a.a.a;
import com.tencent.mm.plugin.multitask.c.e;
import com.tencent.mm.plugin.multitask.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorController;", "", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "swipeToMultiTaskListener", "Lcom/tencent/mm/plugin/multitask/listener/OnSwipeAheadToMultiTaskListener;", "(Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;Lcom/tencent/mm/plugin/multitask/listener/OnSwipeAheadToMultiTaskListener;)V", "<set-?>", "Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorView;", "floatIndicatorView", "getFloatIndicatorView", "()Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorView;", "indicatorBottomMargin", "", "indicatorLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "indicatorRightMargin", "isIndicatorHit", "", "isIndicatorShowing", "isLandscape", "isWillSwipedBack", "lastPosXWhenSwipeReleased", "", "swipeStartTime", "", "attachFloatIndicatorView", "", "calculateIndicatorBottomMargin", "checkShowIndicator", "scrollPercent", "createFloatIndicator", "detachFloatIndicatorView", "hideIndicator", "markIsIndicatorHitByTouchEvent", "event", "Landroid/view/MotionEvent;", "showIndicator", "start", "stop", "updateLayoutMargins", "updateOrientation", "Companion", "plugin-multitask_release"})
public final class b
{
  public static final b.a Aam;
  public FloatMultiTaskIndicatorView Aaj;
  public final com.tencent.mm.plugin.multitask.a.a Aak;
  private final e Aal;
  private boolean iqo;
  private float oXQ;
  private boolean oYA;
  private long oYB;
  private int oYv;
  private int oYw;
  private FrameLayout.LayoutParams oYx;
  private boolean oYy;
  private boolean oYz;
  
  static
  {
    AppMethodBeat.i(200441);
    Aam = new b.a((byte)0);
    AppMethodBeat.o(200441);
  }
  
  public b(com.tencent.mm.plugin.multitask.a.a parama, e parame)
  {
    AppMethodBeat.i(200440);
    this.Aak = parama;
    this.Aal = parame;
    this.oYB = -1L;
    this.Aaj = new FloatMultiTaskIndicatorView((Context)this.Aak.getActivity(), null, 6, (byte)0);
    parama = this.Aaj;
    if (parama != null) {
      parama.setOnOrientationChangedListener((FloatMultiTaskIndicatorView.b)new b(this));
    }
    boolean bool;
    if (com.tencent.mm.cb.a.jn(MMApplicationContext.getContext()) > com.tencent.mm.cb.a.jo(MMApplicationContext.getContext()))
    {
      bool = true;
      jX(bool);
      this.oYx = new FrameLayout.LayoutParams(-2, -2);
      parama = this.oYx;
      if (parama != null) {
        parama.gravity = 8388693;
      }
      parama = this.oYx;
      if (parama != null) {
        parama.bottomMargin = this.oYw;
      }
      parama = this.oYx;
      if (parama != null) {
        parama.rightMargin = this.oYv;
      }
      parama = this.Aaj;
      if (parama != null) {
        parama.setLayoutParams((ViewGroup.LayoutParams)this.oYx);
      }
      parama = this.oYx;
      if (parama == null) {
        break label262;
      }
    }
    label262:
    for (parama = Integer.valueOf(parama.rightMargin);; parama = null)
    {
      FrameLayout.LayoutParams localLayoutParams = this.oYx;
      parame = localObject;
      if (localLayoutParams != null) {
        parame = Integer.valueOf(localLayoutParams.bottomMargin);
      }
      Log.i("MicroMsg.FloatMultiTaskIndicatorController", "createFloatIndicator layoutParams, right:%s, bottom:%s", new Object[] { parama, parame });
      AppMethodBeat.o(200440);
      return;
      bool = false;
      break;
    }
  }
  
  private final void bKU()
  {
    AppMethodBeat.i(200436);
    Activity localActivity = this.Aak.getActivity();
    if (localActivity != null) {
      f.eG((Context)localActivity);
    }
    if (this.iqo)
    {
      this.oYw = (-f.oYP);
      this.oYv = (cjc() - f.oYP);
      AppMethodBeat.o(200436);
      return;
    }
    this.oYv = (-f.oYP);
    this.oYw = (cjc() - f.oYP);
    AppMethodBeat.o(200436);
  }
  
  private final int cjc()
  {
    AppMethodBeat.i(200437);
    if (this.Aak.chH() >= 0)
    {
      i = this.Aak.chH();
      AppMethodBeat.o(200437);
      return i;
    }
    int i = f.oYU;
    AppMethodBeat.o(200437);
    return i;
  }
  
  private final void cjd()
  {
    AppMethodBeat.i(200439);
    if (!this.oYz)
    {
      AppMethodBeat.o(200439);
      return;
    }
    if (this.Aaj != null)
    {
      FloatMultiTaskIndicatorView localFloatMultiTaskIndicatorView = this.Aaj;
      if (localFloatMultiTaskIndicatorView != null) {
        localFloatMultiTaskIndicatorView.setVisibility(8);
      }
      this.oYz = false;
    }
    AppMethodBeat.o(200439);
  }
  
  private final void jX(boolean paramBoolean)
  {
    AppMethodBeat.i(200435);
    Log.i("MicroMsg.FloatMultiTaskIndicatorController", "updateOrientation, isLandscape:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.iqo = paramBoolean;
    bKU();
    AppMethodBeat.o(200435);
  }
  
  public final void start()
  {
    AppMethodBeat.i(200438);
    Log.i("MicroMsg.FloatMultiTaskIndicatorController", "start FloatIndicatorController");
    cjd();
    this.oYB = -1L;
    this.oYy = false;
    this.oYz = false;
    this.oYA = false;
    if (!this.Aak.bPp())
    {
      AppMethodBeat.o(200438);
      return;
    }
    this.Aak.a((a.a)new d(this));
    Object localObject1;
    ViewGroup localViewGroup;
    if (this.Aaj != null)
    {
      localObject1 = this.Aaj;
      if (localObject1 != null) {
        ((FloatMultiTaskIndicatorView)localObject1).setVisibility(8);
      }
      localViewGroup = this.Aak.chG();
    }
    label257:
    label260:
    for (;;)
    {
      int j;
      try
      {
        localObject1 = this.Aaj;
        if (localObject1 == null) {
          break label239;
        }
        localObject1 = ((FloatMultiTaskIndicatorView)localObject1).getParent();
        if (localObject1 != null) {
          break label270;
        }
        if (localViewGroup == null) {
          break label245;
        }
        i = localViewGroup.getChildCount();
        if (localViewGroup == null) {
          break label260;
        }
        int k = localViewGroup.getChildCount();
        j = 0;
        if (j >= k) {
          break label257;
        }
        if (!(localViewGroup.getChildAt(j) instanceof SwipeBackLayout)) {
          break label250;
        }
        i = j + 1;
        if (localViewGroup == null) {
          break;
        }
        localViewGroup.addView((View)this.Aaj, i);
        AppMethodBeat.o(200438);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.FloatMultiTaskIndicatorController", (Throwable)localException, "attachFloatIndicatorView exception:%s", new Object[] { localException });
      }
      AppMethodBeat.o(200438);
      return;
      label239:
      Object localObject2 = null;
      continue;
      label245:
      int i = 0;
      continue;
      label250:
      j += 1;
      continue;
    }
    AppMethodBeat.o(200438);
    return;
    label270:
    Log.w("MicroMsg.FloatMultiTaskIndicatorController", "attachFloatIndicatorView, already attached");
    AppMethodBeat.o(200438);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorController$createFloatIndicator$1", "Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorView$OnOrientationChangedListener;", "onOrientationChanged", "", "isLandscape", "", "plugin-multitask_release"})
  public static final class b
    implements FloatMultiTaskIndicatorView.b
  {
    public final void jY(boolean paramBoolean)
    {
      Integer localInteger = null;
      AppMethodBeat.i(200428);
      Log.i("MicroMsg.FloatMultiTaskIndicatorController", "onOrientationChanged, isLandscape:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      b.a(this.Aan, paramBoolean);
      Object localObject = b.a(this.Aan);
      if (localObject != null) {
        ((FrameLayout.LayoutParams)localObject).bottomMargin = b.b(this.Aan);
      }
      localObject = b.a(this.Aan);
      if (localObject != null) {
        ((FrameLayout.LayoutParams)localObject).rightMargin = b.c(this.Aan);
      }
      localObject = this.Aan.Aaj;
      if (localObject != null) {
        ((FloatMultiTaskIndicatorView)localObject).setLayoutParams((ViewGroup.LayoutParams)b.a(this.Aan));
      }
      localObject = b.a(this.Aan);
      if (localObject != null) {}
      for (localObject = Integer.valueOf(((FrameLayout.LayoutParams)localObject).rightMargin);; localObject = null)
      {
        FrameLayout.LayoutParams localLayoutParams = b.a(this.Aan);
        if (localLayoutParams != null) {
          localInteger = Integer.valueOf(localLayoutParams.bottomMargin);
        }
        Log.i("MicroMsg.FloatMultiTaskIndicatorController", "onOrientationChanged layoutParams, right:%s, bottom:%s", new Object[] { localObject, localInteger });
        AppMethodBeat.o(200428);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorController$start$1", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;", "canInterceptTouchEvent", "", "enableSwipeBack", "getSwipeBackTouchState", "", "onDispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onEdgeDragStarted", "edgeFlags", "pointerId", "onPositionChange", "scrollPercent", "", "onSwipeReleased", "willSwipeBack", "shouldInterceptTouchEvent", "ev", "plugin-multitask_release"})
  public static final class d
    implements a.a
  {
    public final void RF(int paramInt)
    {
      AppMethodBeat.i(200434);
      if (paramInt == 1)
      {
        e locale = b.o(this.Aan);
        if (locale != null)
        {
          locale.erf();
          AppMethodBeat.o(200434);
          return;
        }
      }
      AppMethodBeat.o(200434);
    }
    
    public final void aY(float paramFloat)
    {
      float f1 = 1.0F;
      float f2 = 0.0F;
      AppMethodBeat.i(200430);
      if (b.d(this.Aan))
      {
        AppMethodBeat.o(200430);
        return;
      }
      if (b.e(this.Aan) < 0L) {
        b.a(this.Aan, Util.nowMilliSecond());
      }
      if (b.a(this.Aan, paramFloat))
      {
        if (!b.f(this.Aan)) {
          b.g(this.Aan);
        }
        label109:
        int i;
        if (!b.h(this.Aan))
        {
          paramFloat = (paramFloat - 0.1F) / 0.3F;
          if (paramFloat >= 0.0F) {
            break label257;
          }
          paramFloat = f2;
          if (paramFloat <= 1.0F) {
            break label260;
          }
          paramFloat = f1;
          i = (int)(paramFloat * f.oYP);
          if (!b.j(this.Aan)) {
            break label263;
          }
          b.a(this.Aan, -f.oYP + i);
          b.b(this.Aan, i + (b.k(this.Aan) - f.oYP));
        }
        for (;;)
        {
          Object localObject = b.a(this.Aan);
          if (localObject != null) {
            ((FrameLayout.LayoutParams)localObject).bottomMargin = b.b(this.Aan);
          }
          localObject = b.a(this.Aan);
          if (localObject != null) {
            ((FrameLayout.LayoutParams)localObject).rightMargin = b.c(this.Aan);
          }
          localObject = this.Aan.Aaj;
          if (localObject != null) {
            ((FloatMultiTaskIndicatorView)localObject).setLayoutParams((ViewGroup.LayoutParams)b.a(this.Aan));
          }
          b.l(this.Aan);
          AppMethodBeat.o(200430);
          return;
          label257:
          break;
          label260:
          break label109;
          label263:
          b.b(this.Aan, -f.oYP + i);
          b.a(this.Aan, i + (b.k(this.Aan) - f.oYP));
        }
      }
      b.m(this.Aan);
      AppMethodBeat.o(200430);
    }
    
    public final boolean eqD()
    {
      return false;
    }
    
    public final int eqE()
    {
      return 0;
    }
    
    public final boolean eqF()
    {
      return true;
    }
    
    public final boolean j(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(200433);
      p.h(paramMotionEvent, "ev");
      AppMethodBeat.o(200433);
      return false;
    }
    
    public final int jJ(boolean paramBoolean)
    {
      AppMethodBeat.i(200432);
      Log.i("MicroMsg.FloatMultiTaskIndicatorController", "onSwipeReleased, willSwipeBack:%s, isIndicatorHit:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(b.h(this.Aan)) });
      b.a(this.Aan, -1L);
      b.b(this.Aan, paramBoolean);
      b.m(this.Aan);
      if (!paramBoolean)
      {
        b.i(this.Aan);
        AppMethodBeat.o(200432);
        return 1;
      }
      if (b.h(this.Aan))
      {
        b.i(this.Aan);
        Log.i("MicroMsg.FloatMultiTaskIndicatorController", "onSwipeReleased, swipe to float ball");
        Object localObject = b.o(this.Aan);
        if (localObject != null) {
          localObject = Integer.valueOf(((e)localObject).bz(b.n(this.Aan)));
        }
        while (localObject != null)
        {
          int i = ((Number)localObject).intValue();
          if (i == 2)
          {
            b.b(this.Aan, false);
            AppMethodBeat.o(200432);
            return 2;
            localObject = null;
          }
          else
          {
            AppMethodBeat.o(200432);
            return i;
          }
        }
      }
      AppMethodBeat.o(200432);
      return 1;
    }
    
    public final void n(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(200431);
      p.h(paramMotionEvent, "event");
      boolean bool = b.h(this.Aan);
      b.a(this.Aan, paramMotionEvent);
      Object localObject1;
      Object localObject2;
      if ((b.f(this.Aan)) && (b.h(this.Aan) != bool))
      {
        if (b.h(this.Aan))
        {
          localObject1 = b.a(this.Aan);
          if (localObject1 != null) {
            ((FrameLayout.LayoutParams)localObject1).bottomMargin = b.b(this.Aan);
          }
          localObject1 = b.a(this.Aan);
          if (localObject1 != null) {
            ((FrameLayout.LayoutParams)localObject1).rightMargin = b.c(this.Aan);
          }
          localObject1 = this.Aan.Aaj;
          if (localObject1 != null) {
            ((FloatMultiTaskIndicatorView)localObject1).setLayoutParams((ViewGroup.LayoutParams)b.a(this.Aan));
          }
        }
        localObject1 = this.Aan.Aaj;
        if (localObject1 != null)
        {
          if (!b.h(this.Aan)) {
            break label417;
          }
          if (((FloatMultiTaskIndicatorView)localObject1).paT != null)
          {
            if (!((FloatMultiTaskIndicatorView)localObject1).pcn) {
              break label366;
            }
            localObject2 = ((FloatMultiTaskIndicatorView)localObject1).paT;
            if (localObject2 != null) {
              ((Vibrator)localObject2).vibrate(new long[] { 0L, 10L, 100L, 10L }, -1);
            }
          }
          if (!((FloatMultiTaskIndicatorView)localObject1).pcn) {
            break label388;
          }
          localObject2 = ((FloatMultiTaskIndicatorView)localObject1).pch;
          if (localObject2 != null) {
            ((ImageView)localObject2).setImageDrawable(com.tencent.mm.svg.a.a.h(((FloatMultiTaskIndicatorView)localObject1).getResources(), 2131691195));
          }
        }
      }
      for (;;)
      {
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).pck;
        if ((localObject2 != null) && (((Animator)localObject2).isRunning() == true))
        {
          localObject2 = ((FloatMultiTaskIndicatorView)localObject1).pck;
          if (localObject2 != null) {
            ((Animator)localObject2).cancel();
          }
        }
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).pcg;
        if (localObject2 != null) {
          ((ImageView)localObject2).setScaleX(f.oYQ);
        }
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).pcg;
        if (localObject2 != null) {
          ((ImageView)localObject2).setScaleY(f.oYQ);
        }
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).pch;
        if (localObject2 != null) {
          ((ImageView)localObject2).setScaleX(f.oYQ);
        }
        localObject1 = ((FloatMultiTaskIndicatorView)localObject1).pch;
        if (localObject1 != null) {
          ((ImageView)localObject1).setScaleY(f.oYQ);
        }
        b.b(this.Aan, paramMotionEvent.getRawX());
        AppMethodBeat.o(200431);
        return;
        label366:
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).paT;
        if (localObject2 == null) {
          break;
        }
        ((Vibrator)localObject2).vibrate(10L);
        break;
        label388:
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).pch;
        if (localObject2 != null) {
          ((ImageView)localObject2).setImageDrawable(com.tencent.mm.svg.a.a.h(((FloatMultiTaskIndicatorView)localObject1).getResources(), 2131691197));
        }
      }
      label417:
      if (((FloatMultiTaskIndicatorView)localObject1).pcn)
      {
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).pch;
        if (localObject2 != null) {
          ((ImageView)localObject2).setImageDrawable(com.tencent.mm.svg.a.a.h(((FloatMultiTaskIndicatorView)localObject1).getResources(), 2131691194));
        }
      }
      for (;;)
      {
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).pcl;
        if ((localObject2 != null) && (((Animator)localObject2).isRunning() == true))
        {
          localObject2 = ((FloatMultiTaskIndicatorView)localObject1).pcl;
          if (localObject2 != null) {
            ((Animator)localObject2).cancel();
          }
        }
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).pcg;
        if (localObject2 != null) {
          ((ImageView)localObject2).setScaleX(1.0F);
        }
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).pcg;
        if (localObject2 != null) {
          ((ImageView)localObject2).setScaleY(1.0F);
        }
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).pch;
        if (localObject2 != null) {
          ((ImageView)localObject2).setScaleX(1.0F);
        }
        localObject1 = ((FloatMultiTaskIndicatorView)localObject1).pch;
        if (localObject1 == null) {
          break;
        }
        ((ImageView)localObject1).setScaleY(1.0F);
        break;
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).pch;
        if (localObject2 != null) {
          ((ImageView)localObject2).setImageDrawable(com.tencent.mm.svg.a.a.h(((FloatMultiTaskIndicatorView)localObject1).getResources(), 2131691196));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.swipeahead.b
 * JD-Core Version:    0.7.0.1
 */