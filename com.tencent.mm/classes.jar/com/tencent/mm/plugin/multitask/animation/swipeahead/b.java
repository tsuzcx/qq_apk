package com.tencent.mm.plugin.multitask.animation.swipeahead;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.a.a.a;
import com.tencent.mm.plugin.multitask.c.e;
import com.tencent.mm.plugin.multitask.f;
import com.tencent.mm.plugin.multitask.j.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorController;", "", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "swipeToMultiTaskListener", "Lcom/tencent/mm/plugin/multitask/listener/OnSwipeAheadToMultiTaskListener;", "(Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;Lcom/tencent/mm/plugin/multitask/listener/OnSwipeAheadToMultiTaskListener;)V", "<set-?>", "Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorView;", "floatIndicatorView", "getFloatIndicatorView", "()Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorView;", "indicatorBottomMargin", "", "indicatorLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "indicatorRightMargin", "isIndicatorHit", "", "isIndicatorShowing", "isLandscape", "isWillSwipedBack", "lastPosXWhenSwipeReleased", "", "swipeStartTime", "", "attachFloatIndicatorView", "", "calculateIndicatorBottomMargin", "checkShowIndicator", "scrollPercent", "createFloatIndicator", "detachFloatIndicatorView", "hideIndicator", "markIsIndicatorHitByTouchEvent", "event", "Landroid/view/MotionEvent;", "showIndicator", "start", "stop", "updateLayoutMargins", "updateOrientation", "Companion", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a LBT;
  private final com.tencent.mm.plugin.multitask.a.a LBU;
  private final e LBV;
  public FloatMultiTaskIndicatorView LBW;
  private float LBX;
  private boolean nKe;
  private int vlN;
  private int vlO;
  private FrameLayout.LayoutParams vlP;
  private boolean vlQ;
  private boolean vlR;
  private boolean vlS;
  private long vlT;
  
  static
  {
    AppMethodBeat.i(304075);
    LBT = new b.a((byte)0);
    AppMethodBeat.o(304075);
  }
  
  public b(com.tencent.mm.plugin.multitask.a.a parama, e parame)
  {
    AppMethodBeat.i(303906);
    this.LBU = parama;
    this.LBV = parame;
    this.vlT = -1L;
    this.LBW = new FloatMultiTaskIndicatorView((Context)this.LBU.getActivity(), null, 6, (byte)0);
    parama = this.LBW;
    if (parama != null) {
      parama.setOnOrientationChangedListener((FloatMultiTaskIndicatorView.b)new b(this));
    }
    boolean bool;
    if (com.tencent.mm.cd.a.ms(MMApplicationContext.getContext()) > com.tencent.mm.cd.a.mt(MMApplicationContext.getContext()))
    {
      bool = true;
      mv(bool);
      this.vlP = new FrameLayout.LayoutParams(-2, -2);
      parama = this.vlP;
      if (parama != null) {
        parama.gravity = 8388693;
      }
      parama = this.vlP;
      if (parama != null) {
        parama.bottomMargin = this.vlO;
      }
      parama = this.vlP;
      if (parama != null) {
        parama.rightMargin = this.vlN;
      }
      parama = this.LBW;
      if (parama != null) {
        parama.setLayoutParams((ViewGroup.LayoutParams)this.vlP);
      }
      parama = this.vlP;
      if (parama != null) {
        break label245;
      }
      parama = null;
      label203:
      parame = this.vlP;
      if (parame != null) {
        break label256;
      }
    }
    label256:
    for (parame = localObject;; parame = Integer.valueOf(parame.bottomMargin))
    {
      Log.i("MicroMsg.FloatMultiTaskIndicatorController", "createFloatIndicator layoutParams, right:%s, bottom:%s", new Object[] { parama, parame });
      AppMethodBeat.o(303906);
      return;
      bool = false;
      break;
      label245:
      parama = Integer.valueOf(parama.rightMargin);
      break label203;
    }
  }
  
  private static final void a(b paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(303938);
    s.u(paramb, "this$0");
    if (paramb.LBW != null) {}
    Object localObject1;
    for (;;)
    {
      try
      {
        localObject1 = paramb.LBW;
        if (localObject1 != null) {
          break label93;
        }
        localObject1 = null;
        if (localObject1 != null)
        {
          localObject1 = paramb.LBW;
          if (localObject1 != null) {
            break label101;
          }
          localObject1 = localObject2;
          if (localObject1 != null) {
            break;
          }
          paramb = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(303938);
          throw paramb;
        }
      }
      catch (Exception paramb)
      {
        Log.printErrStackTrace("MicroMsg.FloatMultiTaskIndicatorController", (Throwable)paramb, "detachFloatIndicatorView exception:%s", new Object[] { paramb });
      }
      AppMethodBeat.o(303938);
      return;
      label93:
      localObject1 = ((FloatMultiTaskIndicatorView)localObject1).getParent();
      continue;
      label101:
      localObject1 = ((FloatMultiTaskIndicatorView)localObject1).getParent();
    }
    ((ViewGroup)localObject1).removeView((View)paramb.LBW);
    AppMethodBeat.o(303938);
  }
  
  private final int cZe()
  {
    AppMethodBeat.i(303921);
    if (this.LBU.cXC() >= 0)
    {
      i = this.LBU.cXC();
      AppMethodBeat.o(303921);
      return i;
    }
    int i = f.vmn;
    AppMethodBeat.o(303921);
    return i;
  }
  
  private final void cZf()
  {
    AppMethodBeat.i(303932);
    if (!this.vlR)
    {
      AppMethodBeat.o(303932);
      return;
    }
    if (this.LBW != null)
    {
      FloatMultiTaskIndicatorView localFloatMultiTaskIndicatorView = this.LBW;
      if (localFloatMultiTaskIndicatorView != null) {
        localFloatMultiTaskIndicatorView.setVisibility(8);
      }
      this.vlR = false;
    }
    AppMethodBeat.o(303932);
  }
  
  private final void cxh()
  {
    AppMethodBeat.i(303913);
    Activity localActivity = this.LBU.getActivity();
    if (localActivity != null) {
      f.fE((Context)localActivity);
    }
    if (this.nKe)
    {
      this.vlO = (-f.vmi);
      this.vlN = (cZe() - f.vmi);
      AppMethodBeat.o(303913);
      return;
    }
    this.vlN = (-f.vmi);
    this.vlO = (cZe() - f.vmi);
    AppMethodBeat.o(303913);
  }
  
  private final void mv(boolean paramBoolean)
  {
    AppMethodBeat.i(303911);
    Log.i("MicroMsg.FloatMultiTaskIndicatorController", "updateOrientation, isLandscape:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.nKe = paramBoolean;
    cxh();
    AppMethodBeat.o(303911);
  }
  
  public final void start()
  {
    AppMethodBeat.i(304092);
    Log.i("MicroMsg.FloatMultiTaskIndicatorController", "start FloatIndicatorController");
    cZf();
    this.vlT = -1L;
    this.vlQ = false;
    this.vlR = false;
    this.vlS = false;
    if (!this.LBU.cBZ())
    {
      AppMethodBeat.o(304092);
      return;
    }
    this.LBU.a((a.a)new c(this));
    ViewGroup localViewGroup;
    int m;
    int j;
    label151:
    int k;
    int i;
    if (this.LBW != null)
    {
      FloatMultiTaskIndicatorView localFloatMultiTaskIndicatorView = this.LBW;
      if (localFloatMultiTaskIndicatorView != null) {
        localFloatMultiTaskIndicatorView.setVisibility(8);
      }
      localViewGroup = this.LBU.cXB();
      try
      {
        localFloatMultiTaskIndicatorView = this.LBW;
        if (localFloatMultiTaskIndicatorView != null) {
          break label227;
        }
        localFloatMultiTaskIndicatorView = null;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.FloatMultiTaskIndicatorController", (Throwable)localException, "attachFloatIndicatorView exception:%s", new Object[] { localException });
      }
      if (localViewGroup == null) {
        break label287;
      }
      m = localViewGroup.getChildCount();
      if (m <= 0) {
        break label287;
      }
      j = 0;
      k = j + 1;
      if (!(localViewGroup.getChildAt(j) instanceof SwipeBackLayout)) {
        break label281;
      }
      i = j + 1;
    }
    label266:
    label281:
    label287:
    for (;;)
    {
      if (localViewGroup != null)
      {
        localViewGroup.addView((View)this.LBW, i);
        AppMethodBeat.o(304092);
        return;
      }
      AppMethodBeat.o(304092);
      return;
      label227:
      ViewParent localViewParent = localException.getParent();
      break label266;
      label237:
      i = localViewGroup.getChildCount();
      break;
      label246:
      Log.w("MicroMsg.FloatMultiTaskIndicatorController", "attachFloatIndicatorView, already attached");
      AppMethodBeat.o(304092);
      return;
      do
      {
        j = k;
        break label151;
        if (localViewParent != null) {
          break label246;
        }
        if (localViewGroup != null) {
          break label237;
        }
        i = 0;
        break;
      } while (k < m);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(304102);
    Log.i("MicroMsg.FloatMultiTaskIndicatorController", "stop FloatIndicatorController");
    MMHandlerThread.postToMainThread(new b..ExternalSyntheticLambda0(this));
    this.LBU.a(null);
    AppMethodBeat.o(304102);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorController$createFloatIndicator$1", "Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorView$OnOrientationChangedListener;", "onOrientationChanged", "", "isLandscape", "", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements FloatMultiTaskIndicatorView.b
  {
    b(b paramb) {}
    
    public final void mw(boolean paramBoolean)
    {
      Integer localInteger = null;
      AppMethodBeat.i(303902);
      Log.i("MicroMsg.FloatMultiTaskIndicatorController", "onOrientationChanged, isLandscape:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      b.a(this.LBY, paramBoolean);
      Object localObject = b.b(this.LBY);
      if (localObject != null) {
        ((FrameLayout.LayoutParams)localObject).bottomMargin = b.c(this.LBY);
      }
      localObject = b.b(this.LBY);
      if (localObject != null) {
        ((FrameLayout.LayoutParams)localObject).rightMargin = b.d(this.LBY);
      }
      localObject = this.LBY.LBW;
      if (localObject != null) {
        ((FloatMultiTaskIndicatorView)localObject).setLayoutParams((ViewGroup.LayoutParams)b.b(this.LBY));
      }
      localObject = b.b(this.LBY);
      FrameLayout.LayoutParams localLayoutParams;
      if (localObject == null)
      {
        localObject = null;
        localLayoutParams = b.b(this.LBY);
        if (localLayoutParams != null) {
          break label169;
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.FloatMultiTaskIndicatorController", "onOrientationChanged layoutParams, right:%s, bottom:%s", new Object[] { localObject, localInteger });
        AppMethodBeat.o(303902);
        return;
        localObject = Integer.valueOf(((FrameLayout.LayoutParams)localObject).rightMargin);
        break;
        label169:
        localInteger = Integer.valueOf(localLayoutParams.bottomMargin);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorController$start$1", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;", "canInterceptTouchEvent", "", "enableSwipeBack", "getSwipeBackTouchState", "", "onDispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onEdgeDragStarted", "edgeFlags", "pointerId", "onPositionChange", "scrollPercent", "", "onSwipeReleased", "willSwipeBack", "shouldInterceptTouchEvent", "ev", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements a.a
  {
    c(b paramb) {}
    
    public final void aci(int paramInt)
    {
      AppMethodBeat.i(303954);
      if (paramInt == 1)
      {
        e locale = b.o(this.LBY);
        if (locale != null) {
          locale.gkf();
        }
      }
      AppMethodBeat.o(303954);
    }
    
    public final void cC(float paramFloat)
    {
      float f1 = 1.0F;
      float f2 = 0.0F;
      AppMethodBeat.i(303905);
      if (b.e(this.LBY))
      {
        AppMethodBeat.o(303905);
        return;
      }
      if (b.f(this.LBY) < 0L) {
        b.a(this.LBY, Util.nowMilliSecond());
      }
      if (b.a(this.LBY, paramFloat))
      {
        if (!b.g(this.LBY)) {
          b.h(this.LBY);
        }
        label109:
        int i;
        if (!b.i(this.LBY))
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
          i = (int)(paramFloat * f.vmi);
          if (!b.j(this.LBY)) {
            break label263;
          }
          b.a(this.LBY, -f.vmi + i);
          b.b(this.LBY, i + (b.k(this.LBY) - f.vmi));
        }
        for (;;)
        {
          Object localObject = b.b(this.LBY);
          if (localObject != null) {
            ((FrameLayout.LayoutParams)localObject).bottomMargin = b.c(this.LBY);
          }
          localObject = b.b(this.LBY);
          if (localObject != null) {
            ((FrameLayout.LayoutParams)localObject).rightMargin = b.d(this.LBY);
          }
          localObject = this.LBY.LBW;
          if (localObject != null) {
            ((FloatMultiTaskIndicatorView)localObject).setLayoutParams((ViewGroup.LayoutParams)b.b(this.LBY));
          }
          b.l(this.LBY);
          AppMethodBeat.o(303905);
          return;
          label257:
          break;
          label260:
          break label109;
          label263:
          b.b(this.LBY, -f.vmi + i);
          b.a(this.LBY, i + (b.k(this.LBY) - f.vmi));
        }
      }
      b.m(this.LBY);
      AppMethodBeat.o(303905);
    }
    
    public final boolean gjA()
    {
      return true;
    }
    
    public final boolean gjy()
    {
      return false;
    }
    
    public final int gjz()
    {
      return 0;
    }
    
    public final boolean i(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(303939);
      s.u(paramMotionEvent, "ev");
      AppMethodBeat.o(303939);
      return false;
    }
    
    public final void n(MotionEvent paramMotionEvent)
    {
      int i = 1;
      AppMethodBeat.i(303914);
      s.u(paramMotionEvent, "event");
      boolean bool = b.i(this.LBY);
      b.a(this.LBY, paramMotionEvent);
      Object localObject1;
      Object localObject2;
      if ((b.g(this.LBY)) && (b.i(this.LBY) != bool))
      {
        if (b.i(this.LBY))
        {
          localObject1 = b.b(this.LBY);
          if (localObject1 != null) {
            ((FrameLayout.LayoutParams)localObject1).bottomMargin = b.c(this.LBY);
          }
          localObject1 = b.b(this.LBY);
          if (localObject1 != null) {
            ((FrameLayout.LayoutParams)localObject1).rightMargin = b.d(this.LBY);
          }
          localObject1 = this.LBY.LBW;
          if (localObject1 != null) {
            ((FloatMultiTaskIndicatorView)localObject1).setLayoutParams((ViewGroup.LayoutParams)b.b(this.LBY));
          }
        }
        localObject1 = this.LBY.LBW;
        if (localObject1 != null)
        {
          if (!b.i(this.LBY)) {
            break label458;
          }
          if (((FloatMultiTaskIndicatorView)localObject1).uAL != null)
          {
            if (!((FloatMultiTaskIndicatorView)localObject1).vqd) {
              break label399;
            }
            localObject2 = ((FloatMultiTaskIndicatorView)localObject1).uAL;
            if (localObject2 != null) {
              ((Vibrator)localObject2).vibrate(new long[] { 0L, 10L, 100L, 10L }, -1);
            }
          }
          if (!((FloatMultiTaskIndicatorView)localObject1).vqd) {
            break label422;
          }
          localObject2 = ((FloatMultiTaskIndicatorView)localObject1).vpX;
          if (localObject2 != null) {
            ((ImageView)localObject2).setImageDrawable(com.tencent.mm.svg.a.a.i(((FloatMultiTaskIndicatorView)localObject1).getResources(), j.g.multitask_indicator_full_scale_icon));
          }
          label260:
          localObject2 = ((FloatMultiTaskIndicatorView)localObject1).vqa;
          if ((localObject2 == null) || (((Animator)localObject2).isRunning() != true)) {
            break label453;
          }
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          localObject2 = ((FloatMultiTaskIndicatorView)localObject1).vqa;
          if (localObject2 != null) {
            ((Animator)localObject2).cancel();
          }
        }
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).vpW;
        if (localObject2 != null) {
          ((ImageView)localObject2).setScaleX(f.vmj);
        }
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).vpW;
        if (localObject2 != null) {
          ((ImageView)localObject2).setScaleY(f.vmj);
        }
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).vpX;
        if (localObject2 != null) {
          ((ImageView)localObject2).setScaleX(f.vmj);
        }
        localObject1 = ((FloatMultiTaskIndicatorView)localObject1).vpX;
        if (localObject1 != null) {
          ((ImageView)localObject1).setScaleY(f.vmj);
        }
        b.b(this.LBY, paramMotionEvent.getRawX());
        AppMethodBeat.o(303914);
        return;
        label399:
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).uAL;
        if (localObject2 == null) {
          break;
        }
        ((Vibrator)localObject2).vibrate(10L);
        break;
        label422:
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).vpX;
        if (localObject2 == null) {
          break label260;
        }
        ((ImageView)localObject2).setImageDrawable(com.tencent.mm.svg.a.a.i(((FloatMultiTaskIndicatorView)localObject1).getResources(), j.g.multitask_indicator_scale_icon));
        break label260;
        label453:
        i = 0;
      }
      label458:
      if (((FloatMultiTaskIndicatorView)localObject1).vqd)
      {
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).vpX;
        if (localObject2 != null) {
          ((ImageView)localObject2).setImageDrawable(com.tencent.mm.svg.a.a.i(((FloatMultiTaskIndicatorView)localObject1).getResources(), j.g.multitask_indicator_full_icon));
        }
        label494:
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).vqb;
        if ((localObject2 == null) || (((Animator)localObject2).isRunning() != true)) {
          break label644;
        }
      }
      label644:
      for (i = 1;; i = 0)
      {
        if (i != 0)
        {
          localObject2 = ((FloatMultiTaskIndicatorView)localObject1).vqb;
          if (localObject2 != null) {
            ((Animator)localObject2).cancel();
          }
        }
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).vpW;
        if (localObject2 != null) {
          ((ImageView)localObject2).setScaleX(1.0F);
        }
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).vpW;
        if (localObject2 != null) {
          ((ImageView)localObject2).setScaleY(1.0F);
        }
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).vpX;
        if (localObject2 != null) {
          ((ImageView)localObject2).setScaleX(1.0F);
        }
        localObject1 = ((FloatMultiTaskIndicatorView)localObject1).vpX;
        if (localObject1 == null) {
          break;
        }
        ((ImageView)localObject1).setScaleY(1.0F);
        break;
        localObject2 = ((FloatMultiTaskIndicatorView)localObject1).vpX;
        if (localObject2 == null) {
          break label494;
        }
        ((ImageView)localObject2).setImageDrawable(com.tencent.mm.svg.a.a.i(((FloatMultiTaskIndicatorView)localObject1).getResources(), j.g.multitask_indicator_icon));
        break label494;
      }
    }
    
    public final int zE(boolean paramBoolean)
    {
      AppMethodBeat.i(303926);
      Log.i("MicroMsg.FloatMultiTaskIndicatorController", "onSwipeReleased, willSwipeBack:%s, isIndicatorHit:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(b.i(this.LBY)) });
      b.a(this.LBY, -1L);
      b.b(this.LBY, paramBoolean);
      b.m(this.LBY);
      if (!paramBoolean)
      {
        b.n(this.LBY);
        AppMethodBeat.o(303926);
        return 1;
      }
      if (b.i(this.LBY))
      {
        b.n(this.LBY);
        Log.i("MicroMsg.FloatMultiTaskIndicatorController", "onSwipeReleased, swipe to float ball");
        Object localObject = b.o(this.LBY);
        if (localObject == null) {
          localObject = null;
        }
        while (localObject != null)
        {
          b localb = this.LBY;
          int i = ((Number)localObject).intValue();
          if (i == 2)
          {
            b.b(localb, false);
            AppMethodBeat.o(303926);
            return 2;
            localObject = Integer.valueOf(((e)localObject).cG(b.p(this.LBY)));
          }
          else
          {
            AppMethodBeat.o(303926);
            return i;
          }
        }
      }
      AppMethodBeat.o(303926);
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.swipeahead.b
 * JD-Core Version:    0.7.0.1
 */