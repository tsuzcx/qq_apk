package com.tencent.mm.plugin.multitask.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.a.a;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIManager;", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBInfoChangedListener;", "()V", "adapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "forceHideAllFloatBall", "", "isFloatBallContainerExisted", "()Z", "multiTaskFloatBallContainer", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallContainer;", "needTranslateAnimation", "addFloatBallViewListener", "", "listener", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBViewListener;", "attachFloatBallContainer", "attachPageAdapter", "detachFloatBallContainer", "doOnFloatBallInfoChanged", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animatorListenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "hideFloatBallContainer", "withTransAnimation", "withAlphaAnimation", "isAnimating", "onFloatBallInfoChanged", "removeFloatBallViewListener", "updateMultiTaskFBInfoList", "updateNeedTranslateAnimation", "Companion", "plugin-multitask_release"})
public final class d
  implements com.tencent.mm.plugin.multitask.c.b
{
  public static final d.a FIr;
  public b FIp;
  public a FIq;
  private boolean sak;
  
  static
  {
    AppMethodBeat.i(247660);
    FIr = new d.a((byte)0);
    AppMethodBeat.o(247660);
  }
  
  private final void b(MultiTaskInfo paramMultiTaskInfo, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(247653);
    try
    {
      this.sak = false;
      if (paramMultiTaskInfo != null)
      {
        if (!cwq())
        {
          Log.i("MicroMsg.MultiTaskUIManager", "float ball did not create");
          cws();
          c(paramMultiTaskInfo, paramAnimatorListenerAdapter);
          AppMethodBeat.o(247653);
          return;
        }
        Log.i("MicroMsg.MultiTaskUIManager", "float ball already created");
        c(paramMultiTaskInfo, paramAnimatorListenerAdapter);
        AppMethodBeat.o(247653);
        return;
      }
    }
    catch (Exception paramMultiTaskInfo)
    {
      Log.e("MicroMsg.MultiTaskUIManager", "doOnFloatBallInfoChanged exp:%s", new Object[] { paramMultiTaskInfo });
      if (paramAnimatorListenerAdapter != null)
      {
        paramAnimatorListenerAdapter.onAnimationCancel(null);
        AppMethodBeat.o(247653);
        return;
        Log.i("MicroMsg.MultiTaskUIManager", "empty ball info list");
        cwr();
        if (paramAnimatorListenerAdapter != null)
        {
          paramAnimatorListenerAdapter.onAnimationCancel(null);
          AppMethodBeat.o(247653);
          return;
        }
        AppMethodBeat.o(247653);
        return;
      }
      AppMethodBeat.o(247653);
    }
  }
  
  private final void c(MultiTaskInfo paramMultiTaskInfo, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(247657);
    if (cwq())
    {
      b localb = this.FIp;
      if (localb != null)
      {
        localb.a(paramMultiTaskInfo, paramAnimatorListenerAdapter);
        AppMethodBeat.o(247657);
        return;
      }
    }
    AppMethodBeat.o(247657);
  }
  
  private void cwr()
  {
    AppMethodBeat.i(247649);
    MMHandlerThread.postToMainThread((Runnable)new b(this));
    AppMethodBeat.o(247649);
  }
  
  private final void cws()
  {
    AppMethodBeat.i(247655);
    Object localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    this.FIp = new b((Context)localObject);
    b localb = this.FIp;
    if (localb != null)
    {
      localObject = this.FIq;
      if (localObject == null) {
        break label67;
      }
    }
    label67:
    for (localObject = ((a)localObject).cuR();; localObject = null)
    {
      localb.H((ViewGroup)localObject);
      cwt();
      AppMethodBeat.o(247655);
      return;
    }
  }
  
  private final void cwt()
  {
    AppMethodBeat.i(247658);
    if (this.sak)
    {
      b localb = this.FIp;
      if (localb != null) {
        localb.setNeedTranslateAnimation(this.sak);
      }
      this.sak = false;
    }
    AppMethodBeat.o(247658);
  }
  
  public final void a(final MultiTaskInfo paramMultiTaskInfo, final AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(247651);
    Log.d("MicroMsg.MultiTaskUIManager", "onFloatBallInfoChanged");
    if (p.h(Looper.getMainLooper(), Looper.myLooper()))
    {
      b(paramMultiTaskInfo, paramAnimatorListenerAdapter);
      AppMethodBeat.o(247651);
      return;
    }
    MMHandlerThread.postToMainThread((Runnable)new d(this, paramMultiTaskInfo, paramAnimatorListenerAdapter));
    AppMethodBeat.o(247651);
  }
  
  public final boolean cwq()
  {
    return this.FIp != null;
  }
  
  public final void e(final boolean paramBoolean1, final boolean paramBoolean2, final AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(247647);
    MMHandlerThread.postToMainThread((Runnable)new c(this, paramBoolean1, paramBoolean2, paramAnimatorListenerAdapter));
    AppMethodBeat.o(247647);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(249066);
      Object localObject2;
      Object localObject1;
      if (this.FIs.cwq())
      {
        d.c(this.FIs);
        localObject2 = d.a(this.FIs);
        if (localObject2 != null)
        {
          localObject1 = ((b)localObject2).FIb;
          if ((localObject1 == null) || (((MultiTaskFloatBallView)localObject1).getVisibility() != 0)) {
            break label407;
          }
          localObject1 = ((b)localObject2).FIb;
          if ((localObject1 != null) && (((MultiTaskFloatBallView)localObject1).getVisibility() == 0))
          {
            localObject1 = ((b)localObject2).FIb;
            if (localObject1 == null) {
              break label178;
            }
            localObject1 = Boolean.valueOf(((MultiTaskFloatBallView)localObject1).sak);
            Log.i("MicroMsg.FloatBallContainer", "detachFromWindow, hide floatBallView, needTranslateAnimation: %b", new Object[] { localObject1 });
            if (!p.h(localObject1, Boolean.TRUE)) {
              break label382;
            }
            localObject1 = ((b)localObject2).FIb;
            if (localObject1 != null)
            {
              localObject2 = (AnimatorListenerAdapter)new b.b((b)localObject2);
              Log.i("MicroMsg.FloatBallView", "alvinluo hideByTranslation");
              ((MultiTaskFloatBallView)localObject1).setNeedTranslateAnimation(false);
              if (((MultiTaskFloatBallView)localObject1).getVisibility() != 8) {
                break label183;
              }
              Log.i("MicroMsg.FloatBallView", "hideByTranslation float ball already hide");
            }
          }
        }
      }
      label407:
      for (;;)
      {
        d.b(this.FIs);
        AppMethodBeat.o(249066);
        return;
        label178:
        localObject1 = null;
        break;
        label183:
        if (((MultiTaskFloatBallView)localObject1).FIe != null)
        {
          Object localObject3 = ((MultiTaskFloatBallView)localObject1).getLayoutParams();
          if (localObject3 == null)
          {
            localObject1 = new t("null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
            AppMethodBeat.o(249066);
            throw ((Throwable)localObject1);
          }
          boolean bool = ((MultiTaskFloatBallView)localObject1).Fu(((WindowManager.LayoutParams)localObject3).x);
          localObject3 = ((MultiTaskFloatBallView)localObject1).FIe;
          if (localObject3 != null)
          {
            int i = ((MultiTaskFloatBallView)localObject1).getCurrentStateWidth();
            if (((com.tencent.mm.plugin.multitask.animation.b.b)localObject3).kJL != null) {
              if (((com.tencent.mm.plugin.multitask.animation.b.b)localObject3).cuU())
              {
                Log.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingHide");
              }
              else
              {
                if (((com.tencent.mm.plugin.multitask.animation.b.b)localObject3).cuT())
                {
                  Log.i("MicroMsg.FloatBallViewAnimationHandler", "cancel show animator");
                  localObject1 = ((com.tencent.mm.plugin.multitask.animation.b.b)localObject3).rYg;
                  if (localObject1 != null) {
                    ((Animator)localObject1).cancel();
                  }
                }
                Log.v("MicroMsg.FloatBallViewAnimationHandler", "playHideTranslateAnimation, view:%s, width: %d, isDockLeft: %b", new Object[] { ((com.tencent.mm.plugin.multitask.animation.b.b)localObject3).kJL, Integer.valueOf(i), Boolean.valueOf(bool) });
                ((com.tencent.mm.plugin.multitask.animation.b.b)localObject3).rYh = ((com.tencent.mm.plugin.multitask.animation.b.b)localObject3).a(false, i, bool, (AnimatorListenerAdapter)new com.tencent.mm.plugin.multitask.animation.b.b.b(((com.tencent.mm.plugin.multitask.animation.b.b)localObject3).kJL, (AnimatorListenerAdapter)localObject2));
                localObject1 = ((com.tencent.mm.plugin.multitask.animation.b.b)localObject3).rYh;
                if (localObject1 != null)
                {
                  ((Animator)localObject1).start();
                  continue;
                  label382:
                  localObject1 = ((b)localObject2).FIb;
                  if (localObject1 != null) {
                    ((MultiTaskFloatBallView)localObject1).d(false, false, null);
                  }
                  ((b)localObject2).cwo();
                  continue;
                  ((b)localObject2).cwo();
                }
              }
            }
          }
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(d paramd, boolean paramBoolean1, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter) {}
    
    public final void run()
    {
      AppMethodBeat.i(247786);
      if (this.FIs.cwq())
      {
        Object localObject = d.a(this.FIs);
        if (localObject != null)
        {
          boolean bool1 = paramBoolean1;
          boolean bool2 = paramBoolean2;
          localAnimatorListenerAdapter = paramAnimatorListenerAdapter;
          if (((b)localObject).FIb != null)
          {
            Log.i("MicroMsg.FloatBallContainer", "hide MultiTaskFloatBallView, transAnim:" + bool1 + ", alphaAnim:" + bool2);
            localObject = ((b)localObject).FIb;
            if (localObject != null)
            {
              ((MultiTaskFloatBallView)localObject).d(bool1, bool2, localAnimatorListenerAdapter);
              AppMethodBeat.o(247786);
              return;
            }
            AppMethodBeat.o(247786);
            return;
          }
          if (localAnimatorListenerAdapter != null)
          {
            localAnimatorListenerAdapter.onAnimationCancel(null);
            AppMethodBeat.o(247786);
            return;
          }
          AppMethodBeat.o(247786);
          return;
        }
        AppMethodBeat.o(247786);
        return;
      }
      AnimatorListenerAdapter localAnimatorListenerAdapter = paramAnimatorListenerAdapter;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationCancel(null);
        AppMethodBeat.o(247786);
        return;
      }
      AppMethodBeat.o(247786);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(d paramd, MultiTaskInfo paramMultiTaskInfo, AnimatorListenerAdapter paramAnimatorListenerAdapter) {}
    
    public final void run()
    {
      AppMethodBeat.i(248870);
      d.a(this.FIs, paramMultiTaskInfo, paramAnimatorListenerAdapter);
      AppMethodBeat.o(248870);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.d
 * JD-Core Version:    0.7.0.1
 */