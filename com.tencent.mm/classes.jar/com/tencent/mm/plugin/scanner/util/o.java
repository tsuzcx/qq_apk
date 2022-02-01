package com.tencent.mm.plugin.scanner.util;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import com.tencent.threadpool.i.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/util/ScanViewShowAnimationTask;", "", "()V", "animationDuration", "", "isTimerCancelled", "", "showDuration", "targetView", "Landroid/view/View;", "taskFuture", "Lcom/tencent/threadpool/runnable/FutureEx;", "taskListener", "Lcom/tencent/mm/plugin/scanner/util/ScanViewShowAnimationTask$ScanViewAnimationTaskListener;", "cancel", "", "cancelShowAnimation", "cancelTaskTimer", "setShowAnimationDuration", "setTaskListener", "listener", "duration", "startAnimationTask", "withShowAnimation", "startShowAnimation", "show", "startTaskTimer", "view", "Companion", "ScanViewAnimationTaskListener", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  public static final o.a PjB;
  private long EHU;
  private long PjC;
  public b PjD;
  private d<?> PjE;
  private boolean PjF;
  private View nmf;
  
  static
  {
    AppMethodBeat.i(314163);
    PjB = new o.a((byte)0);
    AppMethodBeat.o(314163);
  }
  
  private final void CA(boolean paramBoolean)
  {
    float f2 = 1.0F;
    AppMethodBeat.i(314143);
    Log.v("MicroMsg.ScanViewAnimationTask", "alvinluo startShowAnimation show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject = this.nmf;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.PjD;
    if (localObject != null) {
      ((b)localObject).gTB();
    }
    localObject = this.nmf;
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
      p.a((View)localObject, f1, f2, 200L, (Animator.AnimatorListener)new c(paramBoolean, this));
      AppMethodBeat.o(314143);
      return;
      f1 = 1.0F;
      break;
      label109:
      f2 = 0.0F;
    }
  }
  
  private static final void b(o paramo)
  {
    AppMethodBeat.i(314151);
    s.u(paramo, "this$0");
    if (paramo.PjF)
    {
      AppMethodBeat.o(314151);
      return;
    }
    paramo.CA(false);
    AppMethodBeat.o(314151);
  }
  
  private final void gUj()
  {
    AppMethodBeat.i(314138);
    Log.d("MicroMsg.ScanViewAnimationTask", "alvinluo startTaskTimer");
    gUk();
    this.PjE = h.ahAA.o(new o..ExternalSyntheticLambda0(this), this.PjC);
    this.PjF = false;
    AppMethodBeat.o(314138);
  }
  
  private final void gUk()
  {
    AppMethodBeat.i(314139);
    Log.d("MicroMsg.ScanViewAnimationTask", "alvinluo cancelTaskTimer");
    this.PjF = true;
    d locald = this.PjE;
    if (locald != null) {
      locald.cancel(false);
    }
    AppMethodBeat.o(314139);
  }
  
  private final void gUl()
  {
    AppMethodBeat.i(314148);
    Object localObject = this.nmf;
    if (localObject != null)
    {
      localObject = ((View)localObject).animate();
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).setListener(null);
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).setUpdateListener(null);
          if (localObject != null) {
            ((ViewPropertyAnimator)localObject).cancel();
          }
        }
      }
    }
    AppMethodBeat.o(314148);
  }
  
  public final void Cz(boolean paramBoolean)
  {
    AppMethodBeat.i(314193);
    Log.d("MicroMsg.ScanViewAnimationTask", "alvinluo startAnimationTask view: %s, withShowAnimation: %b", new Object[] { this.nmf, Boolean.valueOf(paramBoolean) });
    Object localObject = this.PjD;
    if (localObject != null) {
      ((b)localObject).gTC();
    }
    if (paramBoolean)
    {
      CA(true);
      AppMethodBeat.o(314193);
      return;
    }
    localObject = this.nmf;
    if (localObject != null)
    {
      ((View)localObject).setVisibility(0);
      ((View)localObject).setAlpha(1.0F);
    }
    gUj();
    AppMethodBeat.o(314193);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(314198);
    gUk();
    gUl();
    AppMethodBeat.o(314198);
  }
  
  public final o gUh()
  {
    this.PjC = 2000L;
    return this;
  }
  
  public final o gUi()
  {
    this.EHU = 150L;
    return this;
  }
  
  public final o ja(View paramView)
  {
    AppMethodBeat.i(314176);
    s.u(paramView, "view");
    this.nmf = paramView;
    AppMethodBeat.o(314176);
    return this;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/util/ScanViewShowAnimationTask$ScanViewAnimationTaskListener;", "", "onShowAnimationEnd", "", "show", "", "onShowAnimationStart", "onShowTaskEnd", "onShowTaskStart", "withShowAnimation", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void gTB();
    
    public abstract void gTC();
    
    public abstract void gTD();
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/util/ScanViewShowAnimationTask$startShowAnimation$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(boolean paramBoolean, o paramo) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(314127);
      super.onAnimationEnd(paramAnimator);
      Log.d("MicroMsg.ScanViewAnimationTask", "alvinluo onShowAnimationEnd show: %b", new Object[] { Boolean.valueOf(this.obi) });
      o.c(jdField_this);
      if (this.obi)
      {
        o.d(jdField_this);
        AppMethodBeat.o(314127);
        return;
      }
      paramAnimator = o.c(jdField_this);
      if (paramAnimator != null) {
        paramAnimator.gTD();
      }
      AppMethodBeat.o(314127);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.o
 * JD-Core Version:    0.7.0.1
 */