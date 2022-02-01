package com.tencent.mm.plugin.multitask.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.multitask.c.d;
import com.tencent.mm.plugin.multitask.f;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallContainer;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "displayHeight", "", "lastOrientation", "multiTaskFloatBallView", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallView;", "parent", "Landroid/view/ViewGroup;", "addFloatBallViewListener", "", "listener", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBViewListener;", "attachFloatBallViewToWindow", "attachToView", "canNotShowFloatBall", "", "detachFloatBallViewFromWindow", "detachFromWindow", "detachFromWindowInternal", "hide", "withTransAnimation", "withAlphaAnimation", "animatorListenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "initFloatBallView", "isAnimating", "markWechatInForeground", "inForeground", "onFloatBallInfoChanged", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "removeFloatBallViewListener", "resume", "withAnimation", "checkVisible", "setNeedTranslateAnimation", "needTranslateAnimation", "whenOrientationChange", "newOrientation", "Companion", "plugin-multitask_release"})
public final class b
{
  public static final b.a Acm;
  public MultiTaskFloatBallView Acl;
  private int displayHeight;
  private int lastOrientation;
  private ViewGroup parent;
  
  static
  {
    AppMethodBeat.i(200655);
    Acm = new b.a((byte)0);
    AppMethodBeat.o(200655);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(200654);
    this.lastOrientation = 1;
    this.displayHeight = a.jo(paramContext);
    this.Acl = new MultiTaskFloatBallView(paramContext, null, 6, (byte)0);
    paramContext = this.Acl;
    if (paramContext != null)
    {
      paramContext.a((d)new c(this));
      AppMethodBeat.o(200654);
      return;
    }
    AppMethodBeat.o(200654);
  }
  
  public final void B(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(200651);
    Object localObject = this.Acl;
    if (localObject != null) {
      ((MultiTaskFloatBallView)localObject).setVisibility(8);
    }
    this.parent = paramViewGroup;
    if (paramViewGroup != null)
    {
      localObject = new ViewGroup.MarginLayoutParams(-2, -2);
      ((ViewGroup.MarginLayoutParams)localObject).leftMargin = (0 - f.Iaf);
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = (f.oYW - f.Iag);
      Log.i("MicroMsg.FloatBallContainer", "attachFloatBallViewToWindow success, topMargin:" + ((ViewGroup.MarginLayoutParams)localObject).topMargin);
      if (((ViewGroup.MarginLayoutParams)localObject).topMargin > 0) {
        ((ViewGroup.MarginLayoutParams)localObject).topMargin -= f.Iag;
      }
      MultiTaskFloatBallView localMultiTaskFloatBallView = this.Acl;
      if (localMultiTaskFloatBallView != null) {
        localMultiTaskFloatBallView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      try
      {
        paramViewGroup.addView((View)this.Acl, paramViewGroup.getChildCount());
        Log.i("MicroMsg.FloatBallContainer", "attachFloatBallViewToWindow success");
        AppMethodBeat.o(200651);
        return;
      }
      catch (Exception paramViewGroup)
      {
        Log.printErrStackTrace("MicroMsg.FloatBallContainer", (Throwable)paramViewGroup, "attachFloatBallViewToWindow fail", new Object[0]);
        AppMethodBeat.o(200651);
        return;
      }
    }
    Log.e("MicroMsg.FloatBallContainer", "attachFloatBallViewToWindow, window manager is null");
    AppMethodBeat.o(200651);
  }
  
  public final void a(MultiTaskInfo paramMultiTaskInfo, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(200650);
    Object localObject;
    if (paramMultiTaskInfo != null)
    {
      localObject = this.Acl;
      if (localObject != null)
      {
        localObject = Boolean.valueOf(((MultiTaskFloatBallView)localObject).oYj);
        Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, show FloatBallView %b", new Object[] { localObject });
        localObject = this.Acl;
        if ((localObject != null) && (!((MultiTaskFloatBallView)localObject).oYj))
        {
          localObject = this.Acl;
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
      if (this.Acl == null) {
        break label158;
      }
      localObject = this.Acl;
      if (localObject == null) {
        break label158;
      }
      ((MultiTaskFloatBallView)localObject).a(paramMultiTaskInfo, paramAnimatorListenerAdapter);
      AppMethodBeat.o(200650);
      return;
      localObject = null;
      break;
      localObject = this.Acl;
      if ((localObject != null) && (((MultiTaskFloatBallView)localObject).getVisibility() == 0))
      {
        Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide FloatBallView");
        localObject = this.Acl;
        if (localObject != null) {
          ((MultiTaskFloatBallView)localObject).d(false, false, paramAnimatorListenerAdapter);
        }
      }
    }
    label158:
    AppMethodBeat.o(200650);
  }
  
  final void ciW()
  {
    AppMethodBeat.i(200653);
    try
    {
      if (this.parent != null)
      {
        ViewGroup localViewGroup = this.parent;
        if (localViewGroup != null) {
          localViewGroup.removeView((View)this.Acl);
        }
        Log.i("MicroMsg.FloatBallContainer", "detachFromWindowInternal, detach all views");
        AppMethodBeat.o(200653);
        return;
      }
      Log.e("MicroMsg.FloatBallContainer", "detachFromWindowInternal, window manager is null");
      AppMethodBeat.o(200653);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FloatBallContainer", (Throwable)localException, "detachFromWindowInternal exception", new Object[0]);
      AppMethodBeat.o(200653);
    }
  }
  
  public final void setNeedTranslateAnimation(boolean paramBoolean)
  {
    AppMethodBeat.i(200652);
    if (this.Acl != null)
    {
      MultiTaskFloatBallView localMultiTaskFloatBallView = this.Acl;
      if (localMultiTaskFloatBallView != null)
      {
        localMultiTaskFloatBallView.setNeedTranslateAnimation(paramBoolean);
        AppMethodBeat.o(200652);
        return;
      }
    }
    AppMethodBeat.o(200652);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallContainer$detachFloatBallViewFromWindow$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-multitask_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(200648);
      p.h(paramAnimator, "animation");
      b.a(this.Acn);
      AppMethodBeat.o(200648);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallContainer$initFloatBallView$1", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBViewListener;", "onMultiTaskPanelClicked", "", "onMultiTaskPanelDelete", "onMultiTaskPanelHide", "onMultiTaskPanelShow", "anim", "", "onOrientationChange", "orientation", "", "setTransformationListener", "listener", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "plugin-multitask_release"})
  public static final class c
    implements d
  {
    public final void onOrientationChange(int paramInt)
    {
      AppMethodBeat.i(200649);
      b.a(this.Acn, paramInt);
      AppMethodBeat.o(200649);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.b
 * JD-Core Version:    0.7.0.1
 */