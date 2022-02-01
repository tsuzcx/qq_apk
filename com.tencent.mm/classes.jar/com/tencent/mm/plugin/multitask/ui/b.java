package com.tencent.mm.plugin.multitask.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.multitask.c.d;
import com.tencent.mm.plugin.multitask.f;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallContainer;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "displayHeight", "", "lastOrientation", "multiTaskFloatBallView", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallView;", "parent", "Landroid/view/ViewGroup;", "addFloatBallViewListener", "", "listener", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBViewListener;", "attachFloatBallViewToWindow", "attachToView", "canNotShowFloatBall", "", "detachFloatBallViewFromWindow", "detachFromWindow", "detachFromWindowInternal", "hide", "withTransAnimation", "withAlphaAnimation", "animatorListenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "initFloatBallView", "isAnimating", "markWechatInForeground", "inForeground", "onFloatBallInfoChanged", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "removeFloatBallViewListener", "resume", "withAnimation", "checkVisible", "setNeedTranslateAnimation", "needTranslateAnimation", "whenOrientationChange", "newOrientation", "Companion", "plugin-multitask_release"})
public final class b
{
  public static final b.a FIc;
  public MultiTaskFloatBallView FIb;
  private int displayHeight;
  private int lastOrientation;
  private ViewGroup parent;
  
  static
  {
    AppMethodBeat.i(248506);
    FIc = new b.a((byte)0);
    AppMethodBeat.o(248506);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(248503);
    this.lastOrientation = 1;
    this.displayHeight = a.ks(paramContext);
    this.FIb = new MultiTaskFloatBallView(paramContext, null, 6, (byte)0);
    paramContext = this.FIb;
    if (paramContext != null)
    {
      paramContext.a((d)new c(this));
      AppMethodBeat.o(248503);
      return;
    }
    AppMethodBeat.o(248503);
  }
  
  public final void H(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(248495);
    Object localObject = this.FIb;
    if (localObject != null) {
      ((MultiTaskFloatBallView)localObject).setVisibility(8);
    }
    this.parent = paramViewGroup;
    if (paramViewGroup != null)
    {
      localObject = new ViewGroup.MarginLayoutParams(-2, -2);
      ((ViewGroup.MarginLayoutParams)localObject).leftMargin = (0 - f.FEU);
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = (f.saX - f.FEV);
      Log.i("MicroMsg.FloatBallContainer", "attachFloatBallViewToWindow success, topMargin:" + ((ViewGroup.MarginLayoutParams)localObject).topMargin);
      if (((ViewGroup.MarginLayoutParams)localObject).topMargin > 0) {
        ((ViewGroup.MarginLayoutParams)localObject).topMargin -= f.FEV;
      }
      MultiTaskFloatBallView localMultiTaskFloatBallView = this.FIb;
      if (localMultiTaskFloatBallView != null) {
        localMultiTaskFloatBallView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      try
      {
        paramViewGroup.addView((View)this.FIb, paramViewGroup.getChildCount());
        Log.i("MicroMsg.FloatBallContainer", "attachFloatBallViewToWindow success");
        AppMethodBeat.o(248495);
        return;
      }
      catch (Exception paramViewGroup)
      {
        Log.printErrStackTrace("MicroMsg.FloatBallContainer", (Throwable)paramViewGroup, "attachFloatBallViewToWindow fail", new Object[0]);
        AppMethodBeat.o(248495);
        return;
      }
    }
    Log.e("MicroMsg.FloatBallContainer", "attachFloatBallViewToWindow, window manager is null");
    AppMethodBeat.o(248495);
  }
  
  public final void a(MultiTaskInfo paramMultiTaskInfo, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(248493);
    Object localObject;
    if (paramMultiTaskInfo != null)
    {
      localObject = this.FIb;
      if (localObject != null)
      {
        localObject = Boolean.valueOf(((MultiTaskFloatBallView)localObject).sak);
        Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, show FloatBallView %b", new Object[] { localObject });
        localObject = this.FIb;
        if ((localObject != null) && (!((MultiTaskFloatBallView)localObject).sak))
        {
          localObject = this.FIb;
          if (localObject != null)
          {
            ((MultiTaskFloatBallView)localObject).getVisibility();
            Log.i("MicroMsg.FloatBallView", "show without animation");
            ((MultiTaskFloatBallView)localObject).setVisibility(0);
          }
        }
      }
    }
    for (;;)
    {
      if (this.FIb == null) {
        break label158;
      }
      localObject = this.FIb;
      if (localObject == null) {
        break label158;
      }
      ((MultiTaskFloatBallView)localObject).a(paramMultiTaskInfo, paramAnimatorListenerAdapter);
      AppMethodBeat.o(248493);
      return;
      localObject = null;
      break;
      localObject = this.FIb;
      if ((localObject != null) && (((MultiTaskFloatBallView)localObject).getVisibility() == 0))
      {
        Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide FloatBallView");
        localObject = this.FIb;
        if (localObject != null) {
          ((MultiTaskFloatBallView)localObject).d(false, false, paramAnimatorListenerAdapter);
        }
      }
    }
    label158:
    AppMethodBeat.o(248493);
  }
  
  final void cwo()
  {
    AppMethodBeat.i(248501);
    try
    {
      if (this.parent != null)
      {
        ViewGroup localViewGroup = this.parent;
        if (localViewGroup != null) {
          localViewGroup.removeView((View)this.FIb);
        }
        Log.i("MicroMsg.FloatBallContainer", "detachFromWindowInternal, detach all views");
        AppMethodBeat.o(248501);
        return;
      }
      Log.e("MicroMsg.FloatBallContainer", "detachFromWindowInternal, window manager is null");
      AppMethodBeat.o(248501);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FloatBallContainer", (Throwable)localException, "detachFromWindowInternal exception", new Object[0]);
      AppMethodBeat.o(248501);
    }
  }
  
  public final void setNeedTranslateAnimation(boolean paramBoolean)
  {
    AppMethodBeat.i(248498);
    if (this.FIb != null)
    {
      MultiTaskFloatBallView localMultiTaskFloatBallView = this.FIb;
      if (localMultiTaskFloatBallView != null)
      {
        localMultiTaskFloatBallView.setNeedTranslateAnimation(paramBoolean);
        AppMethodBeat.o(248498);
        return;
      }
    }
    AppMethodBeat.o(248498);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallContainer$detachFloatBallViewFromWindow$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-multitask_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(248480);
      p.k(paramAnimator, "animation");
      b.a(this.FId);
      AppMethodBeat.o(248480);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallContainer$initFloatBallView$1", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBViewListener;", "onMultiTaskPanelClicked", "", "onMultiTaskPanelDelete", "onMultiTaskPanelHide", "onMultiTaskPanelShow", "anim", "", "onOrientationChange", "orientation", "", "setTransformationListener", "listener", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "plugin-multitask_release"})
  public static final class c
    implements d
  {
    public final void onOrientationChange(int paramInt)
    {
      AppMethodBeat.i(248031);
      b.a(this.FId, paramInt);
      AppMethodBeat.o(248031);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.b
 * JD-Core Version:    0.7.0.1
 */