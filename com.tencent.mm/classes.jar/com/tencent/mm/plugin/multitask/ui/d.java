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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIManager;", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBInfoChangedListener;", "()V", "adapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "forceHideAllFloatBall", "", "isFloatBallContainerExisted", "()Z", "multiTaskFloatBallContainer", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallContainer;", "needTranslateAnimation", "addFloatBallViewListener", "", "listener", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBViewListener;", "attachFloatBallContainer", "attachPageAdapter", "detachFloatBallContainer", "doOnFloatBallInfoChanged", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animatorListenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "hideFloatBallContainer", "withTransAnimation", "withAlphaAnimation", "isAnimating", "onFloatBallInfoChanged", "removeFloatBallViewListener", "updateMultiTaskFBInfoList", "updateNeedTranslateAnimation", "Companion", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements com.tencent.mm.plugin.multitask.c.b
{
  public static final d.a LDD;
  public b LDE;
  public a LDF;
  private boolean vlB;
  
  static
  {
    AppMethodBeat.i(304209);
    LDD = new d.a((byte)0);
    AppMethodBeat.o(304209);
  }
  
  private static final void a(d paramd)
  {
    AppMethodBeat.i(304198);
    s.u(paramd, "this$0");
    Object localObject2;
    Object localObject1;
    int i;
    if (paramd.cZa())
    {
      paramd.cZd();
      localObject2 = paramd.LDE;
      if (localObject2 != null)
      {
        localObject1 = ((b)localObject2).LDv;
        if ((localObject1 == null) || (((MultiTaskFloatBallView)localObject1).getVisibility() != 0)) {
          break label179;
        }
        i = 1;
        if (i == 0) {
          break label424;
        }
        localObject1 = ((b)localObject2).LDv;
        if ((localObject1 == null) || (((MultiTaskFloatBallView)localObject1).getVisibility() != 0)) {
          break label184;
        }
        i = 1;
        label75:
        if (i != 0)
        {
          localObject1 = ((b)localObject2).LDv;
          if (localObject1 != null) {
            break label189;
          }
          localObject1 = null;
          label91:
          Log.i("MicroMsg.FloatBallContainer", "detachFromWindow, hide floatBallView, needTranslateAnimation: %b", new Object[] { localObject1 });
          if (!s.p(localObject1, Boolean.TRUE)) {
            break label399;
          }
          localObject1 = ((b)localObject2).LDv;
          if (localObject1 != null)
          {
            localObject2 = (AnimatorListenerAdapter)new b.b((b)localObject2);
            Log.i("MicroMsg.FloatBallView", "alvinluo hideByTranslation");
            ((MultiTaskFloatBallView)localObject1).setNeedTranslateAnimation(false);
            if (((MultiTaskFloatBallView)localObject1).getVisibility() != 8) {
              break label200;
            }
            Log.i("MicroMsg.FloatBallView", "hideByTranslation float ball already hide");
          }
        }
      }
    }
    label399:
    label424:
    for (;;)
    {
      paramd.LDE = null;
      AppMethodBeat.o(304198);
      return;
      label179:
      i = 0;
      break;
      label184:
      i = 0;
      break label75;
      label189:
      localObject1 = Boolean.valueOf(((MultiTaskFloatBallView)localObject1).vlB);
      break label91;
      label200:
      if (((MultiTaskFloatBallView)localObject1).LDy != null)
      {
        Object localObject3 = ((MultiTaskFloatBallView)localObject1).getLayoutParams();
        if (localObject3 == null)
        {
          paramd = new NullPointerException("null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
          AppMethodBeat.o(304198);
          throw paramd;
        }
        boolean bool = ((MultiTaskFloatBallView)localObject1).FT(((WindowManager.LayoutParams)localObject3).x);
        localObject3 = ((MultiTaskFloatBallView)localObject1).LDy;
        if (localObject3 != null)
        {
          i = ((MultiTaskFloatBallView)localObject1).getCurrentStateWidth();
          if (((com.tencent.mm.plugin.multitask.animation.b.b)localObject3).nmf != null) {
            if (((com.tencent.mm.plugin.multitask.animation.b.b)localObject3).cXE())
            {
              Log.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingHide");
            }
            else
            {
              if (((com.tencent.mm.plugin.multitask.animation.b.b)localObject3).cXD())
              {
                Log.i("MicroMsg.FloatBallViewAnimationHandler", "cancel show animator");
                localObject1 = ((com.tencent.mm.plugin.multitask.animation.b.b)localObject3).vjw;
                if (localObject1 != null) {
                  ((Animator)localObject1).cancel();
                }
              }
              Log.v("MicroMsg.FloatBallViewAnimationHandler", "playHideTranslateAnimation, view:%s, width: %d, isDockLeft: %b", new Object[] { ((com.tencent.mm.plugin.multitask.animation.b.b)localObject3).nmf, Integer.valueOf(i), Boolean.valueOf(bool) });
              ((com.tencent.mm.plugin.multitask.animation.b.b)localObject3).vjx = ((com.tencent.mm.plugin.multitask.animation.b.b)localObject3).a(false, i, bool, (AnimatorListenerAdapter)new com.tencent.mm.plugin.multitask.animation.b.b.b(((com.tencent.mm.plugin.multitask.animation.b.b)localObject3).nmf, (AnimatorListenerAdapter)localObject2));
              localObject1 = ((com.tencent.mm.plugin.multitask.animation.b.b)localObject3).vjx;
              if (localObject1 != null)
              {
                ((Animator)localObject1).start();
                continue;
                localObject1 = ((b)localObject2).LDv;
                if (localObject1 != null) {
                  ((MultiTaskFloatBallView)localObject1).d(false, false, null);
                }
                ((b)localObject2).cYY();
                continue;
                ((b)localObject2).cYY();
              }
            }
          }
        }
      }
    }
  }
  
  private static final void a(d paramd, MultiTaskInfo paramMultiTaskInfo, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(304204);
    s.u(paramd, "this$0");
    paramd.b(paramMultiTaskInfo, paramAnimatorListenerAdapter);
    AppMethodBeat.o(304204);
  }
  
  private static final void a(d paramd, boolean paramBoolean1, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(304187);
    s.u(paramd, "this$0");
    if (paramd.cZa())
    {
      paramd = paramd.LDE;
      if (paramd != null)
      {
        if (paramd.LDv != null)
        {
          Log.i("MicroMsg.FloatBallContainer", "hide MultiTaskFloatBallView, transAnim:" + paramBoolean1 + ", alphaAnim:" + paramBoolean2);
          paramd = paramd.LDv;
          if (paramd != null)
          {
            paramd.d(paramBoolean1, paramBoolean2, paramAnimatorListenerAdapter);
            AppMethodBeat.o(304187);
          }
        }
        else if (paramAnimatorListenerAdapter != null)
        {
          paramAnimatorListenerAdapter.onAnimationCancel(null);
        }
        AppMethodBeat.o(304187);
      }
    }
    else if (paramAnimatorListenerAdapter != null)
    {
      paramAnimatorListenerAdapter.onAnimationCancel(null);
    }
    AppMethodBeat.o(304187);
  }
  
  private final void b(MultiTaskInfo paramMultiTaskInfo, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(304155);
    do
    {
      try
      {
        this.vlB = false;
        if (paramMultiTaskInfo != null)
        {
          if (!cZa())
          {
            Log.i("MicroMsg.MultiTaskUIManager", "float ball did not create");
            cZc();
            c(paramMultiTaskInfo, paramAnimatorListenerAdapter);
            AppMethodBeat.o(304155);
            return;
          }
          Log.i("MicroMsg.MultiTaskUIManager", "float ball already created");
          c(paramMultiTaskInfo, paramAnimatorListenerAdapter);
          AppMethodBeat.o(304155);
          return;
        }
      }
      catch (Exception paramMultiTaskInfo)
      {
        Log.e("MicroMsg.MultiTaskUIManager", "doOnFloatBallInfoChanged exp:%s", new Object[] { paramMultiTaskInfo });
        if (paramAnimatorListenerAdapter != null) {
          paramAnimatorListenerAdapter.onAnimationCancel(null);
        }
        AppMethodBeat.o(304155);
        return;
      }
      Log.i("MicroMsg.MultiTaskUIManager", "empty ball info list");
      cZb();
    } while (paramAnimatorListenerAdapter == null);
    paramAnimatorListenerAdapter.onAnimationCancel(null);
    AppMethodBeat.o(304155);
  }
  
  private final void c(MultiTaskInfo paramMultiTaskInfo, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(304168);
    if (cZa())
    {
      b localb = this.LDE;
      if (localb != null) {
        localb.a(paramMultiTaskInfo, paramAnimatorListenerAdapter);
      }
    }
    AppMethodBeat.o(304168);
  }
  
  private void cZb()
  {
    AppMethodBeat.i(304143);
    MMHandlerThread.postToMainThread(new d..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(304143);
  }
  
  private final void cZc()
  {
    AppMethodBeat.i(304161);
    Object localObject = MMApplicationContext.getContext();
    s.s(localObject, "getContext()");
    this.LDE = new b((Context)localObject);
    b localb = this.LDE;
    if (localb != null)
    {
      localObject = this.LDF;
      if (localObject != null) {
        break label65;
      }
    }
    label65:
    for (localObject = null;; localObject = ((a)localObject).cXB())
    {
      localb.R((ViewGroup)localObject);
      cZd();
      AppMethodBeat.o(304161);
      return;
    }
  }
  
  private final void cZd()
  {
    AppMethodBeat.i(304175);
    if (this.vlB)
    {
      b localb = this.LDE;
      if (localb != null) {
        localb.setNeedTranslateAnimation(this.vlB);
      }
      this.vlB = false;
    }
    AppMethodBeat.o(304175);
  }
  
  public final void a(MultiTaskInfo paramMultiTaskInfo, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(304248);
    Log.d("MicroMsg.MultiTaskUIManager", "onFloatBallInfoChanged");
    if (s.p(Looper.getMainLooper(), Looper.myLooper()))
    {
      b(paramMultiTaskInfo, paramAnimatorListenerAdapter);
      AppMethodBeat.o(304248);
      return;
    }
    MMHandlerThread.postToMainThread(new d..ExternalSyntheticLambda1(this, paramMultiTaskInfo, paramAnimatorListenerAdapter));
    AppMethodBeat.o(304248);
  }
  
  public final boolean cZa()
  {
    return this.LDE != null;
  }
  
  public final void e(boolean paramBoolean1, boolean paramBoolean2, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(304240);
    MMHandlerThread.postToMainThread(new d..ExternalSyntheticLambda2(this, paramBoolean1, paramBoolean2, paramAnimatorListenerAdapter));
    AppMethodBeat.o(304240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.d
 * JD-Core Version:    0.7.0.1
 */