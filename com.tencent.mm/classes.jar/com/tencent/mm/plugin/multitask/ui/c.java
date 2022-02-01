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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIManager;", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBInfoChangedListener;", "()V", "adapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "forceHideAllFloatBall", "", "isFloatBallContainerExisted", "()Z", "multiTaskFloatBallContainer", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallContainer;", "needTranslateAnimation", "addFloatBallViewListener", "", "listener", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBViewListener;", "attachFloatBallContainer", "attachPageAdapter", "detachFloatBallContainer", "doOnFloatBallInfoChanged", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animatorListenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "hideFloatBallContainer", "withTransAnimation", "withAlphaAnimation", "isAnimating", "onFloatBallInfoChanged", "removeFloatBallViewListener", "updateMultiTaskFBInfoList", "updateNeedTranslateAnimation", "Companion", "plugin-multitask_release"})
public final class c
  implements com.tencent.mm.plugin.multitask.c.b
{
  public static final c.a AcB;
  public a AcA;
  public b Acz;
  private boolean oYj;
  
  static
  {
    AppMethodBeat.i(200702);
    AcB = new c.a((byte)0);
    AppMethodBeat.o(200702);
  }
  
  private final void b(MultiTaskInfo paramMultiTaskInfo, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(200698);
    try
    {
      this.oYj = false;
      if (paramMultiTaskInfo != null)
      {
        if (!ciY())
        {
          Log.i("MicroMsg.MultiTaskUIManager", "float ball did not create");
          cja();
          c(paramMultiTaskInfo, paramAnimatorListenerAdapter);
          AppMethodBeat.o(200698);
          return;
        }
        Log.i("MicroMsg.MultiTaskUIManager", "float ball already created");
        c(paramMultiTaskInfo, paramAnimatorListenerAdapter);
        AppMethodBeat.o(200698);
        return;
      }
    }
    catch (Exception paramMultiTaskInfo)
    {
      Log.e("MicroMsg.MultiTaskUIManager", "doOnFloatBallInfoChanged exp:%s", new Object[] { paramMultiTaskInfo });
      if (paramAnimatorListenerAdapter != null)
      {
        paramAnimatorListenerAdapter.onAnimationCancel(null);
        AppMethodBeat.o(200698);
        return;
        Log.i("MicroMsg.MultiTaskUIManager", "empty ball info list");
        ciZ();
        if (paramAnimatorListenerAdapter != null)
        {
          paramAnimatorListenerAdapter.onAnimationCancel(null);
          AppMethodBeat.o(200698);
          return;
        }
        AppMethodBeat.o(200698);
        return;
      }
      AppMethodBeat.o(200698);
    }
  }
  
  private final void c(MultiTaskInfo paramMultiTaskInfo, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(200700);
    if (ciY())
    {
      b localb = this.Acz;
      if (localb != null)
      {
        localb.a(paramMultiTaskInfo, paramAnimatorListenerAdapter);
        AppMethodBeat.o(200700);
        return;
      }
    }
    AppMethodBeat.o(200700);
  }
  
  private void ciZ()
  {
    AppMethodBeat.i(200696);
    MMHandlerThread.postToMainThread((Runnable)new b(this));
    AppMethodBeat.o(200696);
  }
  
  private final void cja()
  {
    AppMethodBeat.i(200699);
    Object localObject = MMApplicationContext.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    this.Acz = new b((Context)localObject);
    b localb = this.Acz;
    if (localb != null)
    {
      localObject = this.AcA;
      if (localObject == null) {
        break label67;
      }
    }
    label67:
    for (localObject = ((a)localObject).chG();; localObject = null)
    {
      localb.B((ViewGroup)localObject);
      cjb();
      AppMethodBeat.o(200699);
      return;
    }
  }
  
  private final void cjb()
  {
    AppMethodBeat.i(200701);
    if (this.oYj)
    {
      b localb = this.Acz;
      if (localb != null) {
        localb.setNeedTranslateAnimation(this.oYj);
      }
      this.oYj = false;
    }
    AppMethodBeat.o(200701);
  }
  
  public final void a(final MultiTaskInfo paramMultiTaskInfo, final AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(200697);
    Log.d("MicroMsg.MultiTaskUIManager", "onFloatBallInfoChanged");
    if (p.j(Looper.getMainLooper(), Looper.myLooper()))
    {
      b(paramMultiTaskInfo, paramAnimatorListenerAdapter);
      AppMethodBeat.o(200697);
      return;
    }
    MMHandlerThread.postToMainThread((Runnable)new d(this, paramMultiTaskInfo, paramAnimatorListenerAdapter));
    AppMethodBeat.o(200697);
  }
  
  public final boolean ciY()
  {
    return this.Acz != null;
  }
  
  public final void e(final boolean paramBoolean1, final boolean paramBoolean2, final AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(200695);
    MMHandlerThread.postToMainThread((Runnable)new c(this, paramBoolean1, paramBoolean2, paramAnimatorListenerAdapter));
    AppMethodBeat.o(200695);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(200692);
      Object localObject2;
      Object localObject1;
      if (this.AcC.ciY())
      {
        c.c(this.AcC);
        localObject2 = c.a(this.AcC);
        if (localObject2 != null)
        {
          localObject1 = ((b)localObject2).Acl;
          if ((localObject1 == null) || (((MultiTaskFloatBallView)localObject1).getVisibility() != 0)) {
            break label407;
          }
          localObject1 = ((b)localObject2).Acl;
          if ((localObject1 != null) && (((MultiTaskFloatBallView)localObject1).getVisibility() == 0))
          {
            localObject1 = ((b)localObject2).Acl;
            if (localObject1 == null) {
              break label178;
            }
            localObject1 = Boolean.valueOf(((MultiTaskFloatBallView)localObject1).oYj);
            Log.i("MicroMsg.FloatBallContainer", "detachFromWindow, hide floatBallView, needTranslateAnimation: %b", new Object[] { localObject1 });
            if (!p.j(localObject1, Boolean.TRUE)) {
              break label382;
            }
            localObject1 = ((b)localObject2).Acl;
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
        c.b(this.AcC);
        AppMethodBeat.o(200692);
        return;
        label178:
        localObject1 = null;
        break;
        label183:
        if (((MultiTaskFloatBallView)localObject1).Aco != null)
        {
          Object localObject3 = ((MultiTaskFloatBallView)localObject1).getLayoutParams();
          if (localObject3 == null)
          {
            localObject1 = new t("null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
            AppMethodBeat.o(200692);
            throw ((Throwable)localObject1);
          }
          boolean bool = ((MultiTaskFloatBallView)localObject1).BT(((WindowManager.LayoutParams)localObject3).x);
          localObject3 = ((MultiTaskFloatBallView)localObject1).Aco;
          if (localObject3 != null)
          {
            int i = ((MultiTaskFloatBallView)localObject1).getCurrentStateWidth();
            if (((com.tencent.mm.plugin.multitask.animation.b.b)localObject3).targetView != null) {
              if (((com.tencent.mm.plugin.multitask.animation.b.b)localObject3).chJ())
              {
                Log.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingHide");
              }
              else
              {
                if (((com.tencent.mm.plugin.multitask.animation.b.b)localObject3).chI())
                {
                  Log.i("MicroMsg.FloatBallViewAnimationHandler", "cancel show animator");
                  localObject1 = ((com.tencent.mm.plugin.multitask.animation.b.b)localObject3).oWg;
                  if (localObject1 != null) {
                    ((Animator)localObject1).cancel();
                  }
                }
                Log.v("MicroMsg.FloatBallViewAnimationHandler", "playHideTranslateAnimation, view:%s, width: %d, isDockLeft: %b", new Object[] { ((com.tencent.mm.plugin.multitask.animation.b.b)localObject3).targetView, Integer.valueOf(i), Boolean.valueOf(bool) });
                ((com.tencent.mm.plugin.multitask.animation.b.b)localObject3).oWh = ((com.tencent.mm.plugin.multitask.animation.b.b)localObject3).a(false, i, bool, (AnimatorListenerAdapter)new com.tencent.mm.plugin.multitask.animation.b.b.b(((com.tencent.mm.plugin.multitask.animation.b.b)localObject3).targetView, (AnimatorListenerAdapter)localObject2));
                localObject1 = ((com.tencent.mm.plugin.multitask.animation.b.b)localObject3).oWh;
                if (localObject1 != null)
                {
                  ((Animator)localObject1).start();
                  continue;
                  label382:
                  localObject1 = ((b)localObject2).Acl;
                  if (localObject1 != null) {
                    ((MultiTaskFloatBallView)localObject1).d(false, false, null);
                  }
                  ((b)localObject2).ciW();
                  continue;
                  ((b)localObject2).ciW();
                }
              }
            }
          }
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc, boolean paramBoolean1, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter) {}
    
    public final void run()
    {
      AppMethodBeat.i(200693);
      if (this.AcC.ciY())
      {
        Object localObject = c.a(this.AcC);
        if (localObject != null)
        {
          boolean bool1 = paramBoolean1;
          boolean bool2 = paramBoolean2;
          localAnimatorListenerAdapter = paramAnimatorListenerAdapter;
          if (((b)localObject).Acl != null)
          {
            Log.i("MicroMsg.FloatBallContainer", "hide MultiTaskFloatBallView, transAnim:" + bool1 + ", alphaAnim:" + bool2);
            localObject = ((b)localObject).Acl;
            if (localObject != null)
            {
              ((MultiTaskFloatBallView)localObject).d(bool1, bool2, localAnimatorListenerAdapter);
              AppMethodBeat.o(200693);
              return;
            }
            AppMethodBeat.o(200693);
            return;
          }
          if (localAnimatorListenerAdapter != null)
          {
            localAnimatorListenerAdapter.onAnimationCancel(null);
            AppMethodBeat.o(200693);
            return;
          }
          AppMethodBeat.o(200693);
          return;
        }
        AppMethodBeat.o(200693);
        return;
      }
      AnimatorListenerAdapter localAnimatorListenerAdapter = paramAnimatorListenerAdapter;
      if (localAnimatorListenerAdapter != null)
      {
        localAnimatorListenerAdapter.onAnimationCancel(null);
        AppMethodBeat.o(200693);
        return;
      }
      AppMethodBeat.o(200693);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(c paramc, MultiTaskInfo paramMultiTaskInfo, AnimatorListenerAdapter paramAnimatorListenerAdapter) {}
    
    public final void run()
    {
      AppMethodBeat.i(200694);
      c.a(this.AcC, paramMultiTaskInfo, paramAnimatorListenerAdapter);
      AppMethodBeat.o(200694);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.c
 * JD-Core Version:    0.7.0.1
 */