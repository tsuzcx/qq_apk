package com.tencent.mm.plugin.multitask.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.multitask.c.d;
import com.tencent.mm.plugin.multitask.f;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallContainer;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "displayHeight", "", "lastOrientation", "multiTaskFloatBallView", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallView;", "parent", "Landroid/view/ViewGroup;", "addFloatBallViewListener", "", "listener", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBViewListener;", "attachFloatBallViewToWindow", "attachToView", "canNotShowFloatBall", "", "detachFloatBallViewFromWindow", "detachFromWindow", "detachFromWindowInternal", "hide", "withTransAnimation", "withAlphaAnimation", "animatorListenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "initFloatBallView", "isAnimating", "markWechatInForeground", "inForeground", "onFloatBallInfoChanged", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "removeFloatBallViewListener", "resume", "withAnimation", "checkVisible", "setNeedTranslateAnimation", "needTranslateAnimation", "whenOrientationChange", "newOrientation", "Companion", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a LDu;
  public MultiTaskFloatBallView LDv;
  private int displayHeight;
  private int lastOrientation;
  private ViewGroup parent;
  
  static
  {
    AppMethodBeat.i(304152);
    LDu = new b.a((byte)0);
    AppMethodBeat.o(304152);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(304131);
    this.lastOrientation = 1;
    this.displayHeight = a.mt(paramContext);
    this.LDv = new MultiTaskFloatBallView(paramContext, null, 6, (byte)0);
    paramContext = this.LDv;
    if (paramContext != null) {
      paramContext.a((d)new c(this));
    }
    AppMethodBeat.o(304131);
  }
  
  public final void R(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(304172);
    Object localObject = this.LDv;
    if (localObject != null) {
      ((MultiTaskFloatBallView)localObject).setVisibility(8);
    }
    this.parent = paramViewGroup;
    if (paramViewGroup != null)
    {
      localObject = new ViewGroup.MarginLayoutParams(-2, -2);
      ((ViewGroup.MarginLayoutParams)localObject).leftMargin = (0 - f.LAY);
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = (f.vmp - f.LAZ);
      Log.i("MicroMsg.FloatBallContainer", s.X("attachFloatBallViewToWindow success, topMargin:", Integer.valueOf(((ViewGroup.MarginLayoutParams)localObject).topMargin)));
      if (((ViewGroup.MarginLayoutParams)localObject).topMargin > 0) {
        ((ViewGroup.MarginLayoutParams)localObject).topMargin -= f.LAZ;
      }
      MultiTaskFloatBallView localMultiTaskFloatBallView = this.LDv;
      if (localMultiTaskFloatBallView != null) {
        localMultiTaskFloatBallView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      try
      {
        paramViewGroup.addView((View)this.LDv, paramViewGroup.getChildCount());
        Log.i("MicroMsg.FloatBallContainer", "attachFloatBallViewToWindow success");
        AppMethodBeat.o(304172);
        return;
      }
      catch (Exception paramViewGroup)
      {
        Log.printErrStackTrace("MicroMsg.FloatBallContainer", (Throwable)paramViewGroup, "attachFloatBallViewToWindow fail", new Object[0]);
        AppMethodBeat.o(304172);
        return;
      }
    }
    Log.e("MicroMsg.FloatBallContainer", "attachFloatBallViewToWindow, window manager is null");
    AppMethodBeat.o(304172);
  }
  
  public final void a(MultiTaskInfo paramMultiTaskInfo, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    int i = 1;
    AppMethodBeat.i(304160);
    Object localObject;
    if (paramMultiTaskInfo != null)
    {
      localObject = this.LDv;
      if (localObject == null)
      {
        localObject = null;
        Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, show FloatBallView %b", new Object[] { localObject });
        localObject = this.LDv;
        if ((localObject != null) && (!((MultiTaskFloatBallView)localObject).vlB))
        {
          localObject = this.LDv;
          if (localObject != null)
          {
            ((MultiTaskFloatBallView)localObject).getVisibility();
            Log.i("MicroMsg.FloatBallView", "show without animation");
            ((MultiTaskFloatBallView)localObject).setVisibility(0);
          }
        }
      }
    }
    label189:
    for (;;)
    {
      if (this.LDv != null)
      {
        localObject = this.LDv;
        if (localObject != null) {
          ((MultiTaskFloatBallView)localObject).a(paramMultiTaskInfo, paramAnimatorListenerAdapter);
        }
      }
      AppMethodBeat.o(304160);
      return;
      localObject = Boolean.valueOf(((MultiTaskFloatBallView)localObject).vlB);
      break;
      localObject = this.LDv;
      if ((localObject != null) && (((MultiTaskFloatBallView)localObject).getVisibility() == 0)) {}
      for (;;)
      {
        if (i == 0) {
          break label189;
        }
        Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide FloatBallView");
        localObject = this.LDv;
        if (localObject == null) {
          break;
        }
        ((MultiTaskFloatBallView)localObject).d(false, false, paramAnimatorListenerAdapter);
        break;
        i = 0;
      }
    }
  }
  
  final void cYY()
  {
    AppMethodBeat.i(304193);
    try
    {
      if (this.parent != null)
      {
        ViewGroup localViewGroup = this.parent;
        if (localViewGroup != null) {
          localViewGroup.removeView((View)this.LDv);
        }
        Log.i("MicroMsg.FloatBallContainer", "detachFromWindowInternal, detach all views");
        AppMethodBeat.o(304193);
        return;
      }
      Log.e("MicroMsg.FloatBallContainer", "detachFromWindowInternal, window manager is null");
      AppMethodBeat.o(304193);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FloatBallContainer", (Throwable)localException, "detachFromWindowInternal exception", new Object[0]);
      AppMethodBeat.o(304193);
    }
  }
  
  public final void setNeedTranslateAnimation(boolean paramBoolean)
  {
    AppMethodBeat.i(304178);
    if (this.LDv != null)
    {
      MultiTaskFloatBallView localMultiTaskFloatBallView = this.LDv;
      if (localMultiTaskFloatBallView != null) {
        localMultiTaskFloatBallView.setNeedTranslateAnimation(paramBoolean);
      }
    }
    AppMethodBeat.o(304178);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallContainer$detachFloatBallViewFromWindow$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(b paramb) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(304199);
      s.u(paramAnimator, "animation");
      b.a(this.LDw);
      AppMethodBeat.o(304199);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallContainer$initFloatBallView$1", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBViewListener;", "onMultiTaskPanelClicked", "", "onMultiTaskPanelDelete", "onMultiTaskPanelHide", "onMultiTaskPanelShow", "anim", "", "onOrientationChange", "orientation", "", "setTransformationListener", "listener", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements d
  {
    c(b paramb) {}
    
    public final void onOrientationChange(int paramInt)
    {
      AppMethodBeat.i(304205);
      b.a(this.LDw, paramInt);
      AppMethodBeat.o(304205);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.b
 * JD-Core Version:    0.7.0.1
 */