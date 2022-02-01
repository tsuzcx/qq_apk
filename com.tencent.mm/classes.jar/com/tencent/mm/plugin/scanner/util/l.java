package com.tencent.mm.plugin.scanner.util;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/util/ScanViewShowAnimationTask;", "", "()V", "animationDuration", "", "isTimerCancelled", "", "showDuration", "targetView", "Landroid/view/View;", "taskListener", "Lcom/tencent/mm/plugin/scanner/util/ScanViewShowAnimationTask$ScanViewAnimationTaskListener;", "taskTimer", "Ljava/util/Timer;", "cancel", "", "cancelShowAnimation", "cancelTaskTimer", "setShowAnimationDuration", "setTaskListener", "listener", "duration", "startAnimationTask", "withShowAnimation", "startShowAnimation", "show", "startTaskTimer", "view", "Companion", "ScanViewAnimationTaskListener", "scan-sdk_release"})
public final class l
{
  public static final l.a CUs;
  private long CUn;
  private long CUo;
  public b CUp;
  private Timer CUq;
  private boolean CUr;
  private View targetView;
  
  static
  {
    AppMethodBeat.i(194790);
    CUs = new l.a((byte)0);
    AppMethodBeat.o(194790);
  }
  
  private final void eSa()
  {
    AppMethodBeat.i(194786);
    Log.d("MicroMsg.ScanViewAnimationTask", "alvinluo startTaskTimer");
    eSb();
    this.CUq = new Timer();
    Timer localTimer = this.CUq;
    if (localTimer != null) {
      localTimer.schedule((TimerTask)new d(this), this.CUn);
    }
    this.CUr = false;
    AppMethodBeat.o(194786);
  }
  
  private final void eSb()
  {
    AppMethodBeat.i(194787);
    Log.d("MicroMsg.ScanViewAnimationTask", "alvinluo cancelTaskTimer");
    this.CUr = true;
    Timer localTimer = this.CUq;
    if (localTimer != null)
    {
      localTimer.cancel();
      AppMethodBeat.o(194787);
      return;
    }
    AppMethodBeat.o(194787);
  }
  
  private final void eSc()
  {
    AppMethodBeat.i(194789);
    Object localObject = this.targetView;
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
            AppMethodBeat.o(194789);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(194789);
  }
  
  private final void um(final boolean paramBoolean)
  {
    float f2 = 1.0F;
    AppMethodBeat.i(194788);
    Log.v("MicroMsg.ScanViewAnimationTask", "alvinluo startShowAnimation show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject = this.targetView;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.CUp;
    if (localObject != null) {
      ((b)localObject).eRI();
    }
    localObject = this.targetView;
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
      m.a((View)localObject, f1, f2, 200L, (Animator.AnimatorListener)new c(this, paramBoolean));
      AppMethodBeat.o(194788);
      return;
      f1 = 1.0F;
      break;
      label109:
      f2 = 0.0F;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(194785);
    eSb();
    eSc();
    AppMethodBeat.o(194785);
  }
  
  public final l eRY()
  {
    this.CUn = 2000L;
    return this;
  }
  
  public final l eRZ()
  {
    this.CUo = 150L;
    return this;
  }
  
  public final l eV(View paramView)
  {
    AppMethodBeat.i(194782);
    p.h(paramView, "view");
    this.targetView = paramView;
    AppMethodBeat.o(194782);
    return this;
  }
  
  public final void ul(boolean paramBoolean)
  {
    AppMethodBeat.i(194783);
    Log.d("MicroMsg.ScanViewAnimationTask", "alvinluo startAnimationTask view: %s, withShowAnimation: %b", new Object[] { this.targetView, Boolean.valueOf(paramBoolean) });
    Object localObject = this.CUp;
    if (localObject != null) {
      ((b)localObject).eRJ();
    }
    if (paramBoolean)
    {
      um(true);
      AppMethodBeat.o(194783);
      return;
    }
    localObject = this.targetView;
    if (localObject != null)
    {
      ((View)localObject).setVisibility(0);
      ((View)localObject).setAlpha(1.0F);
    }
    eSa();
    AppMethodBeat.o(194783);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/util/ScanViewShowAnimationTask$ScanViewAnimationTaskListener;", "", "onShowAnimationEnd", "", "show", "", "onShowAnimationStart", "onShowTaskEnd", "onShowTaskStart", "withShowAnimation", "scan-sdk_release"})
  public static abstract interface b
  {
    public abstract void eRI();
    
    public abstract void eRJ();
    
    public abstract void eRK();
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/util/ScanViewShowAnimationTask$startShowAnimation$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "scan-sdk_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(boolean paramBoolean) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(194779);
      super.onAnimationEnd(paramAnimator);
      Log.d("MicroMsg.ScanViewAnimationTask", "alvinluo onShowAnimationEnd show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      l.d(this.CUt);
      if (paramBoolean)
      {
        l.e(this.CUt);
        AppMethodBeat.o(194779);
        return;
      }
      paramAnimator = l.d(this.CUt);
      if (paramAnimator != null)
      {
        paramAnimator.eRK();
        AppMethodBeat.o(194779);
        return;
      }
      AppMethodBeat.o(194779);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/util/ScanViewShowAnimationTask$startTaskTimer$1", "Ljava/util/TimerTask;", "run", "", "scan-sdk_release"})
  public static final class d
    extends TimerTask
  {
    public final void run()
    {
      AppMethodBeat.i(194781);
      h.RTc.aV((Runnable)new a(this));
      AppMethodBeat.o(194781);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(l.d paramd) {}
      
      public final void run()
      {
        AppMethodBeat.i(194780);
        if (l.b(this.CUu.CUt))
        {
          AppMethodBeat.o(194780);
          return;
        }
        l.c(this.CUu.CUt);
        AppMethodBeat.o(194780);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.l
 * JD-Core Version:    0.7.0.1
 */