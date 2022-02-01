package com.tencent.mm.plugin.scanner.util;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.e.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/util/ScanViewShowAnimationTask;", "", "()V", "animationDuration", "", "isTimerCancelled", "", "showDuration", "targetView", "Landroid/view/View;", "taskFuture", "Lcom/tencent/threadpool/runnable/FutureEx;", "taskListener", "Lcom/tencent/mm/plugin/scanner/util/ScanViewShowAnimationTask$ScanViewAnimationTaskListener;", "cancel", "", "cancelShowAnimation", "cancelTaskTimer", "setShowAnimationDuration", "setTaskListener", "listener", "duration", "startAnimationTask", "withShowAnimation", "startShowAnimation", "show", "startTaskTimer", "view", "Companion", "ScanViewAnimationTaskListener", "scan-sdk_release"})
public final class m
{
  public static final m.a IZN;
  private long IZI;
  private long IZJ;
  public b IZK;
  private d<?> IZL;
  private boolean IZM;
  private View kJL;
  
  static
  {
    AppMethodBeat.i(193132);
    IZN = new m.a((byte)0);
    AppMethodBeat.o(193132);
  }
  
  private final void fEZ()
  {
    AppMethodBeat.i(193120);
    Log.d("MicroMsg.ScanViewAnimationTask", "alvinluo startTaskTimer");
    fFa();
    this.IZL = h.ZvG.n((Runnable)new d(this), this.IZI);
    this.IZM = false;
    AppMethodBeat.o(193120);
  }
  
  private final void fFa()
  {
    AppMethodBeat.i(193124);
    Log.d("MicroMsg.ScanViewAnimationTask", "alvinluo cancelTaskTimer");
    this.IZM = true;
    d locald = this.IZL;
    if (locald != null)
    {
      locald.cancel(false);
      AppMethodBeat.o(193124);
      return;
    }
    AppMethodBeat.o(193124);
  }
  
  private final void fFb()
  {
    AppMethodBeat.i(193130);
    Object localObject = this.kJL;
    if (localObject != null)
    {
      localObject = ((View)localObject).animate();
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).setListener(null);
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).setUpdateListener(null);
          if (localObject != null)
          {
            ((ViewPropertyAnimator)localObject).cancel();
            AppMethodBeat.o(193130);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(193130);
  }
  
  private final void xK(final boolean paramBoolean)
  {
    float f2 = 1.0F;
    AppMethodBeat.i(193128);
    Log.v("MicroMsg.ScanViewAnimationTask", "alvinluo startShowAnimation show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject = this.kJL;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.IZK;
    if (localObject != null) {
      ((b)localObject).fEH();
    }
    localObject = this.kJL;
    float f1;
    if (paramBoolean)
    {
      f1 = 0.0F;
      if (!paramBoolean) {
        break label109;
      }
    }
    for (;;)
    {
      n.a((View)localObject, f1, f2, 200L, (Animator.AnimatorListener)new c(this, paramBoolean));
      AppMethodBeat.o(193128);
      return;
      f1 = 1.0F;
      break;
      label109:
      f2 = 0.0F;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(193116);
    fFa();
    fFb();
    AppMethodBeat.o(193116);
  }
  
  public final m fEX()
  {
    this.IZI = 2000L;
    return this;
  }
  
  public final m fEY()
  {
    this.IZJ = 150L;
    return this;
  }
  
  public final m fZ(View paramView)
  {
    AppMethodBeat.i(193094);
    p.k(paramView, "view");
    this.kJL = paramView;
    AppMethodBeat.o(193094);
    return this;
  }
  
  public final void xJ(boolean paramBoolean)
  {
    AppMethodBeat.i(193112);
    Log.d("MicroMsg.ScanViewAnimationTask", "alvinluo startAnimationTask view: %s, withShowAnimation: %b", new Object[] { this.kJL, Boolean.valueOf(paramBoolean) });
    Object localObject = this.IZK;
    if (localObject != null) {
      ((b)localObject).fEI();
    }
    if (paramBoolean)
    {
      xK(true);
      AppMethodBeat.o(193112);
      return;
    }
    localObject = this.kJL;
    if (localObject != null)
    {
      ((View)localObject).setVisibility(0);
      ((View)localObject).setAlpha(1.0F);
    }
    fEZ();
    AppMethodBeat.o(193112);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/util/ScanViewShowAnimationTask$ScanViewAnimationTaskListener;", "", "onShowAnimationEnd", "", "show", "", "onShowAnimationStart", "onShowTaskEnd", "onShowTaskStart", "withShowAnimation", "scan-sdk_release"})
  public static abstract interface b
  {
    public abstract void fEH();
    
    public abstract void fEI();
    
    public abstract void fEJ();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/util/ScanViewShowAnimationTask$startShowAnimation$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "scan-sdk_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(boolean paramBoolean) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(193733);
      super.onAnimationEnd(paramAnimator);
      Log.d("MicroMsg.ScanViewAnimationTask", "alvinluo onShowAnimationEnd show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      m.d(this.IZO);
      if (paramBoolean)
      {
        m.e(this.IZO);
        AppMethodBeat.o(193733);
        return;
      }
      paramAnimator = m.d(this.IZO);
      if (paramAnimator != null)
      {
        paramAnimator.fEJ();
        AppMethodBeat.o(193733);
        return;
      }
      AppMethodBeat.o(193733);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(m paramm) {}
    
    public final void run()
    {
      AppMethodBeat.i(193706);
      if (m.b(this.IZO))
      {
        AppMethodBeat.o(193706);
        return;
      }
      m.c(this.IZO);
      AppMethodBeat.o(193706);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.m
 * JD-Core Version:    0.7.0.1
 */