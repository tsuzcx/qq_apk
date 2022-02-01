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
import com.tencent.mm.plugin.multitask.j.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorController;", "", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "swipeToMultiTaskListener", "Lcom/tencent/mm/plugin/multitask/listener/OnSwipeAheadToMultiTaskListener;", "(Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;Lcom/tencent/mm/plugin/multitask/listener/OnSwipeAheadToMultiTaskListener;)V", "<set-?>", "Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorView;", "floatIndicatorView", "getFloatIndicatorView", "()Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorView;", "indicatorBottomMargin", "", "indicatorLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "indicatorRightMargin", "isIndicatorHit", "", "isIndicatorShowing", "isLandscape", "isWillSwipedBack", "lastPosXWhenSwipeReleased", "", "swipeStartTime", "", "attachFloatIndicatorView", "", "calculateIndicatorBottomMargin", "checkShowIndicator", "scrollPercent", "createFloatIndicator", "detachFloatIndicatorView", "hideIndicator", "markIsIndicatorHitByTouchEvent", "event", "Landroid/view/MotionEvent;", "showIndicator", "start", "stop", "updateLayoutMargins", "updateOrientation", "Companion", "plugin-multitask_release"})
public final class b
{
  public static final b.a FGd;
  public FloatMultiTaskIndicatorView FFZ;
  private float FGa;
  public final com.tencent.mm.plugin.multitask.a.a FGb;
  private final e FGc;
  private boolean lft;
  private boolean saA;
  private boolean saB;
  private long saC;
  private int saw;
  private int sax;
  private FrameLayout.LayoutParams say;
  private boolean saz;
  
  static
  {
    AppMethodBeat.i(247907);
    FGd = new b.a((byte)0);
    AppMethodBeat.o(247907);
  }
  
  public b(com.tencent.mm.plugin.multitask.a.a parama, e parame)
  {
    AppMethodBeat.i(247906);
    this.FGb = parama;
    this.FGc = parame;
    this.saC = -1L;
    this.FFZ = new FloatMultiTaskIndicatorView((Context)this.FGb.getActivity(), null, 6, (byte)0);
    parama = this.FFZ;
    if (parama != null) {
      parama.setOnOrientationChangedListener((FloatMultiTaskIndicatorView.b)new b(this));
    }
    boolean bool;
    if (com.tencent.mm.ci.a.kr(MMApplicationContext.getContext()) > com.tencent.mm.ci.a.ks(MMApplicationContext.getContext()))
    {
      bool = true;
      li(bool);
      this.say = new FrameLayout.LayoutParams(-2, -2);
      parama = this.say;
      if (parama != null) {
        parama.gravity = 8388693;
      }
      parama = this.say;
      if (parama != null) {
        parama.bottomMargin = this.sax;
      }
      parama = this.say;
      if (parama != null) {
        parama.rightMargin = this.saw;
      }
      parama = this.FFZ;
      if (parama != null) {
        parama.setLayoutParams((ViewGroup.LayoutParams)this.say);
      }
      parama = this.say;
      if (parama == null) {
        break label262;
      }
    }
    label262:
    for (parama = Integer.valueOf(parama.rightMargin);; parama = null)
    {
      FrameLayout.LayoutParams localLayoutParams = this.say;
      parame = localObject;
      if (localLayoutParams != null) {
        parame = Integer.valueOf(localLayoutParams.bottomMargin);
      }
      Log.i("MicroMsg.FloatMultiTaskIndicatorController", "createFloatIndicator layoutParams, right:%s, bottom:%s", new Object[] { parama, parame });
      AppMethodBeat.o(247906);
      return;
      bool = false;
      break;
    }
  }
  
  private final void bWU()
  {
    AppMethodBeat.i(247902);
    Activity localActivity = this.FGb.getActivity();
    if (localActivity != null) {
      f.eJ((Context)localActivity);
    }
    if (this.lft)
    {
      this.sax = (-f.saQ);
      this.saw = (cwu() - f.saQ);
      AppMethodBeat.o(247902);
      return;
    }
    this.saw = (-f.saQ);
    this.sax = (cwu() - f.saQ);
    AppMethodBeat.o(247902);
  }
  
  private final int cwu()
  {
    AppMethodBeat.i(247903);
    if (this.FGb.cuS() >= 0)
    {
      i = this.FGb.cuS();
      AppMethodBeat.o(247903);
      return i;
    }
    int i = f.saV;
    AppMethodBeat.o(247903);
    return i;
  }
  
  private final void cwv()
  {
    AppMethodBeat.i(247905);
    if (!this.saA)
    {
      AppMethodBeat.o(247905);
      return;
    }
    if (this.FFZ != null)
    {
      FloatMultiTaskIndicatorView localFloatMultiTaskIndicatorView = this.FFZ;
      if (localFloatMultiTaskIndicatorView != null) {
        localFloatMultiTaskIndicatorView.setVisibility(8);
      }
      this.saA = false;
    }
    AppMethodBeat.o(247905);
  }
  
  private final void li(boolean paramBoolean)
  {
    AppMethodBeat.i(247901);
    Log.i("MicroMsg.FloatMultiTaskIndicatorController", "updateOrientation, isLandscape:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lft = paramBoolean;
    bWU();
    AppMethodBeat.o(247901);
  }
  
  public final void start()
  {
    AppMethodBeat.i(247904);
    Log.i("MicroMsg.FloatMultiTaskIndicatorController", "start FloatIndicatorController");
    cwv();
    this.saC = -1L;
    this.saz = false;
    this.saA = false;
    this.saB = false;
    if (!this.FGb.cbG())
    {
      AppMethodBeat.o(247904);
      return;
    }
    this.FGb.a((a.a)new d(this));
    Object localObject1;
    ViewGroup localViewGroup;
    if (this.FFZ != null)
    {
      localObject1 = this.FFZ;
      if (localObject1 != null) {
        ((FloatMultiTaskIndicatorView)localObject1).setVisibility(8);
      }
      localViewGroup = this.FGb.cuR();
    }
    label257:
    label260:
    for (;;)
    {
      int j;
      try
      {
        localObject1 = this.FFZ;
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
        localViewGroup.addView((View)this.FFZ, i);
        AppMethodBeat.o(247904);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.FloatMultiTaskIndicatorController", (Throwable)localException, "attachFloatIndicatorView exception:%s", new Object[] { localException });
      }
      AppMethodBeat.o(247904);
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
    AppMethodBeat.o(247904);
    return;
    label270:
    Log.w("MicroMsg.FloatMultiTaskIndicatorController", "attachFloatIndicatorView, already attached");
    AppMethodBeat.o(247904);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorController$createFloatIndicator$1", "Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorView$OnOrientationChangedListener;", "onOrientationChanged", "", "isLandscape", "", "plugin-multitask_release"})
  public static final class b
    implements FloatMultiTaskIndicatorView.b
  {
    public final void lj(boolean paramBoolean)
    {
      Integer localInteger = null;
      AppMethodBeat.i(248516);
      Log.i("MicroMsg.FloatMultiTaskIndicatorController", "onOrientationChanged, isLandscape:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      b.a(this.FGe, paramBoolean);
      Object localObject = b.a(this.FGe);
      if (localObject != null) {
        ((FrameLayout.LayoutParams)localObject).bottomMargin = b.b(this.FGe);
      }
      localObject = b.a(this.FGe);
      if (localObject != null) {
        ((FrameLayout.LayoutParams)localObject).rightMargin = b.c(this.FGe);
      }
      localObject = this.FGe.FFZ;
      if (localObject != null) {
        ((FloatMultiTaskIndicatorView)localObject).setLayoutParams((ViewGroup.LayoutParams)b.a(this.FGe));
      }
      localObject = b.a(this.FGe);
      if (localObject != null) {}
      for (localObject = Integer.valueOf(((FrameLayout.LayoutParams)localObject).rightMargin);; localObject = null)
      {
        FrameLayout.LayoutParams localLayoutParams = b.a(this.FGe);
        if (localLayoutParams != null) {
          localInteger = Integer.valueOf(localLayoutParams.bottomMargin);
        }
        Log.i("MicroMsg.FloatMultiTaskIndicatorController", "onOrientationChanged layoutParams, right:%s, bottom:%s", new Object[] { localObject, localInteger });
        AppMethodBeat.o(248516);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorController$start$1", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;", "canInterceptTouchEvent", "", "enableSwipeBack", "getSwipeBackTouchState", "", "onDispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onEdgeDragStarted", "edgeFlags", "pointerId", "onPositionChange", "scrollPercent", "", "onSwipeReleased", "willSwipeBack", "shouldInterceptTouchEvent", "ev", "plugin-multitask_release"})
  public static final class d
    implements a.a
  {
    public final void XV(int paramInt)
    {
      AppMethodBeat.i(248562);
      if (paramInt == 1)
      {
        e locale = b.o(this.FGe);
        if (locale != null)
        {
          locale.fba();
          AppMethodBeat.o(248562);
          return;
        }
      }
      AppMethodBeat.o(248562);
    }
    
    public final void by(float paramFloat)
    {
      float f1 = 1.0F;
      float f2 = 0.0F;
      AppMethodBeat.i(248553);
      if (b.d(this.FGe))
      {
        AppMethodBeat.o(248553);
        return;
      }
      if (b.e(this.FGe) < 0L) {
        b.a(this.FGe, Util.nowMilliSecond());
      }
      if (b.a(this.FGe, paramFloat))
      {
        if (!b.f(this.FGe)) {
          b.g(this.FGe);
        }
        label109:
        int i;
        if (!b.h(this.FGe))
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
          i = (int)(paramFloat * f.saQ);
          if (!b.j(this.FGe)) {
            break label263;
          }
          b.a(this.FGe, -f.saQ + i);
          b.b(this.FGe, i + (b.k(this.FGe) - f.saQ));
        }
        for (;;)
        {
          Object localObject = b.a(this.FGe);
          if (localObject != null) {
            ((FrameLayout.LayoutParams)localObject).bottomMargin = b.b(this.FGe);
          }
          localObject = b.a(this.FGe);
          if (localObject != null) {
            ((FrameLayout.LayoutParams)localObject).rightMargin = b.c(this.FGe);
          }
          localObject = this.FGe.FFZ;
          if (localObject != null) {
            ((FloatMultiTaskIndicatorView)localObject).setLayoutParams((ViewGroup.LayoutParams)b.a(this.FGe));
          }
          b.l(this.FGe);
          AppMethodBeat.o(248553);
          return;
          label257:
          break;
          label260:
          break label109;
          label263:
          b.b(this.FGe, -f.saQ + i);
          b.a(this.FGe, i + (b.k(this.FGe) - f.saQ));
        }
      }
      b.m(this.FGe);
      AppMethodBeat.o(248553);
    }
    
    public final boolean fat()
    {
      return false;
    }
    
    public final int fau()
    {
      return 0;
    }
    
    public final boolean fav()
    {
      return true;
    }
    
    public final boolean i(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(248561);
      p.k(paramMotionEvent, "ev");
      AppMethodBeat.o(248561);
      return false;
    }
    
    public final void n(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(248557);
      p.k(paramMotionEvent, "event");
      boolean bool = b.h(this.FGe);
      b.a(this.FGe, paramMotionEvent);
      Object localObject1;
      Object localObject2;
      if ((b.f(this.FGe)) && (b.h(this.FGe) != bool))
      {
        if (b.h(this.FGe))
        {
          localObject1 = b.a(this.FGe);
          if (localObject1 != null) {
            ((FrameLayout.LayoutParams)localObject1).bottomMargin = b.b(this.FGe);
          }
          localObject1 = b.a(this.FGe);
          if (localObject1 != null) {
            ((FrameLayout.LayoutParams)localObject1).rightMargin = b.c(this.FGe);
          }
          localObject1 = this.FGe.FFZ;
          if (localObject1 != null) {
            ((FloatMultiTaskIndicatorView)localObject1).setLayoutParams((ViewGroup.LayoutParams)b.a(this.FGe));
          }
        }
        localObject1 = this.FGe.FFZ;
        if (localObject1 != null)
        {
          if (!b.h(this.FGe)) {
            break label418;
          }
          if (((FloatMultiTaskIndicatorView)localObject1).rqC != null)
          {
            if (!((FloatMultiTaskIndicatorView)localObject1).sen) {
              break label367;
            }
            localObject2 = ((FloatMultiTaskIndicatorView)localObject1).rqC;
            if (localObject2 != null) {
              ((Vibrator)localObject2).vibrate(new long[] { 0L, 10L, 100L, 10L }, -1);
            }
          }
          if (!((FloatMultiTaskIndicatorView)localObject1).sen) {
            break label389;
          }
          localObject2 = ((FloatMultiTaskIndicatorView)localObject1).seh;
          if (localObject2 != null) {
            ((ImageView)localObject2).setImageDrawable(com.tencent.mm.svg.a.a.h(((FloatMultiTaskIndicatorView)localObject1).getResources(), j.g.multitask_indicator_full_scale_icon));
          }
        }
      }
      for (;;)
      {
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).sek;
        if ((localObject2 != null) && (((Animator)localObject2).isRunning() == true))
        {
          localObject2 = ((FloatMultiTaskIndicatorView)localObject1).sek;
          if (localObject2 != null) {
            ((Animator)localObject2).cancel();
          }
        }
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).seg;
        if (localObject2 != null) {
          ((ImageView)localObject2).setScaleX(f.saR);
        }
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).seg;
        if (localObject2 != null) {
          ((ImageView)localObject2).setScaleY(f.saR);
        }
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).seh;
        if (localObject2 != null) {
          ((ImageView)localObject2).setScaleX(f.saR);
        }
        localObject1 = ((FloatMultiTaskIndicatorView)localObject1).seh;
        if (localObject1 != null) {
          ((ImageView)localObject1).setScaleY(f.saR);
        }
        b.b(this.FGe, paramMotionEvent.getRawX());
        AppMethodBeat.o(248557);
        return;
        label367:
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).rqC;
        if (localObject2 == null) {
          break;
        }
        ((Vibrator)localObject2).vibrate(10L);
        break;
        label389:
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).seh;
        if (localObject2 != null) {
          ((ImageView)localObject2).setImageDrawable(com.tencent.mm.svg.a.a.h(((FloatMultiTaskIndicatorView)localObject1).getResources(), j.g.multitask_indicator_scale_icon));
        }
      }
      label418:
      if (((FloatMultiTaskIndicatorView)localObject1).sen)
      {
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).seh;
        if (localObject2 != null) {
          ((ImageView)localObject2).setImageDrawable(com.tencent.mm.svg.a.a.h(((FloatMultiTaskIndicatorView)localObject1).getResources(), j.g.multitask_indicator_full_icon));
        }
      }
      for (;;)
      {
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).sel;
        if ((localObject2 != null) && (((Animator)localObject2).isRunning() == true))
        {
          localObject2 = ((FloatMultiTaskIndicatorView)localObject1).sel;
          if (localObject2 != null) {
            ((Animator)localObject2).cancel();
          }
        }
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).seg;
        if (localObject2 != null) {
          ((ImageView)localObject2).setScaleX(1.0F);
        }
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).seg;
        if (localObject2 != null) {
          ((ImageView)localObject2).setScaleY(1.0F);
        }
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).seh;
        if (localObject2 != null) {
          ((ImageView)localObject2).setScaleX(1.0F);
        }
        localObject1 = ((FloatMultiTaskIndicatorView)localObject1).seh;
        if (localObject1 == null) {
          break;
        }
        ((ImageView)localObject1).setScaleY(1.0F);
        break;
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).seh;
        if (localObject2 != null) {
          ((ImageView)localObject2).setImageDrawable(com.tencent.mm.svg.a.a.h(((FloatMultiTaskIndicatorView)localObject1).getResources(), j.g.multitask_indicator_icon));
        }
      }
    }
    
    public final int vm(boolean paramBoolean)
    {
      AppMethodBeat.i(248559);
      Log.i("MicroMsg.FloatMultiTaskIndicatorController", "onSwipeReleased, willSwipeBack:%s, isIndicatorHit:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(b.h(this.FGe)) });
      b.a(this.FGe, -1L);
      b.b(this.FGe, paramBoolean);
      b.m(this.FGe);
      if (!paramBoolean)
      {
        b.i(this.FGe);
        AppMethodBeat.o(248559);
        return 1;
      }
      if (b.h(this.FGe))
      {
        b.i(this.FGe);
        Log.i("MicroMsg.FloatMultiTaskIndicatorController", "onSwipeReleased, swipe to float ball");
        Object localObject = b.o(this.FGe);
        if (localObject != null) {
          localObject = Integer.valueOf(((e)localObject).bC(b.n(this.FGe)));
        }
        while (localObject != null)
        {
          int i = ((Number)localObject).intValue();
          if (i == 2)
          {
            b.b(this.FGe, false);
            AppMethodBeat.o(248559);
            return 2;
            localObject = null;
          }
          else
          {
            AppMethodBeat.o(248559);
            return i;
          }
        }
      }
      AppMethodBeat.o(248559);
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.swipeahead.b
 * JD-Core Version:    0.7.0.1
 */