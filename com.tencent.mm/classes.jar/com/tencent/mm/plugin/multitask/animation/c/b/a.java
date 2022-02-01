package com.tencent.mm.plugin.multitask.animation.c.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.animation.c.a.c.a;
import com.tencent.mm.protocal.protobuf.dap;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.k;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/animation/swipeback/multiscene/MultiTaskSwipeBackAnimWrapperMS;", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/BaseMultiTaskSwipeBackAnimWrapper;", "()V", "enableSwipeback", "", "getEnableSwipeback", "()Z", "setEnableSwipeback", "(Z)V", "isExitAnimating", "setExitAnimating", "mDragHelper", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "getMDragHelper", "()Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "setMDragHelper", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;)V", "mListener", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "getMListener", "()Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "setMListener", "(Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;)V", "multiTaskHelper", "Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "getMultiTaskHelper", "()Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "setMultiTaskHelper", "(Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;)V", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "getPageAdapter", "()Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "setPageAdapter", "(Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "swipeBackFlag", "", "getSwipeBackFlag", "()J", "setSwipeBackFlag", "(J)V", "swipeView", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/TransformSwipeBackToMultiTaskView;", "getSwipeView", "()Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/TransformSwipeBackToMultiTaskView;", "setSwipeView", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/TransformSwipeBackToMultiTaskView;)V", "doPrepareTransform", "", "way", "", "anim", "delay", "init", "initMaskView", "listener", "onCreate", "refreshPosition", "startSwipeAnim", "Companion", "ViewDragCallback", "plugin-multitask_release"})
public final class a
  extends com.tencent.mm.plugin.multitask.animation.c.a.a
{
  public static final a.a FGB;
  boolean FGA;
  protected com.tencent.mm.plugin.multitask.a.a FGb;
  com.tencent.mm.plugin.multitask.b.b FGu;
  com.tencent.mm.plugin.multitask.animation.c.a.b FGv;
  com.tencent.mm.plugin.multitask.animation.c.a.c FGw;
  com.tencent.mm.plugin.multitask.c.c FGx;
  long FGy = -1L;
  boolean FGz = true;
  
  static
  {
    AppMethodBeat.i(248018);
    FGB = new a.a((byte)0);
    AppMethodBeat.o(248018);
  }
  
  private final void XZ(int paramInt)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    AppMethodBeat.i(248013);
    Object localObject1 = this.FGu;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.multitask.b.b)localObject1).Ya(paramInt);
      if (Util.isNullOrNil((String)localObject1)) {
        break label138;
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        try
        {
          localObject1 = (CharSequence)localObject1;
          localObject1 = ((Collection)new k(",").u((CharSequence)localObject1, 0)).toArray(new String[0]);
          if (localObject1 != null) {
            break label197;
          }
          localObject1 = new t("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(248013);
          throw ((Throwable)localObject1);
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "refreshPosition, get pos failed, %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(248013);
          return;
        }
        Object localObject2 = null;
        break;
        label138:
        if (paramInt == 4)
        {
          localObject4 = this.FGu;
          localObject2 = localObject3;
          if (localObject4 != null) {
            localObject2 = ((com.tencent.mm.plugin.multitask.b.b)localObject4).faK();
          }
        }
        else
        {
          localObject3 = this.FGu;
          localObject2 = localObject4;
          if (localObject3 != null) {
            localObject2 = ((com.tencent.mm.plugin.multitask.b.b)localObject3).getPosition();
          }
          continue;
          label197:
          localObject3 = (String[])localObject2;
          if ((localObject3 != null) && (localObject3.length == 4))
          {
            localObject2 = this.FGv;
            if (localObject2 != null)
            {
              localObject4 = Integer.valueOf(localObject3[0]);
              p.j(localObject4, "Integer.valueOf(posVec[0])");
              paramInt = ((Integer)localObject4).intValue();
              localObject4 = Integer.valueOf(localObject3[1]);
              p.j(localObject4, "Integer.valueOf(posVec[1])");
              int i = ((Integer)localObject4).intValue();
              localObject4 = Integer.valueOf(localObject3[2]);
              p.j(localObject4, "Integer.valueOf(posVec[2])");
              int j = ((Integer)localObject4).intValue();
              localObject3 = Integer.valueOf(localObject3[3]);
              p.j(localObject3, "Integer.valueOf(posVec[3])");
              ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject2).t(new Rect(paramInt, i, j, ((Integer)localObject3).intValue()));
              AppMethodBeat.o(248013);
              return;
            }
          }
          AppMethodBeat.o(248013);
          return;
        }
      }
    }
    AppMethodBeat.o(248013);
  }
  
  private final void a(final int paramInt, final boolean paramBoolean, final com.tencent.mm.plugin.multitask.c.c paramc)
  {
    AppMethodBeat.i(248017);
    Log.i("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "initMaskView, way:%d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject1 = this.FGb;
    if (localObject1 == null) {
      p.bGy("pageAdapter");
    }
    if (((com.tencent.mm.plugin.multitask.a.a)localObject1).getMaskView() == null)
    {
      Log.w("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "doMaskAnimation, page mask view is null");
      if (paramc != null)
      {
        paramc.Yb(paramInt);
        AppMethodBeat.o(248017);
        return;
      }
      AppMethodBeat.o(248017);
      return;
    }
    localObject1 = this.FGb;
    if (localObject1 == null) {
      p.bGy("pageAdapter");
    }
    if (((com.tencent.mm.plugin.multitask.a.a)localObject1).getContentView() == null)
    {
      Log.w("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "doMaskAnimation, page content view is null");
      if (paramc != null)
      {
        paramc.Yb(paramInt);
        AppMethodBeat.o(248017);
        return;
      }
      AppMethodBeat.o(248017);
      return;
    }
    localObject1 = this.FGb;
    if (localObject1 == null) {
      p.bGy("pageAdapter");
    }
    if (((com.tencent.mm.plugin.multitask.a.a)localObject1).cuR() == null)
    {
      Log.w("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "doMaskAnimation, page root view is null");
      if (paramc != null)
      {
        paramc.Yb(paramInt);
        AppMethodBeat.o(248017);
        return;
      }
      AppMethodBeat.o(248017);
      return;
    }
    if (this.FGA)
    {
      Log.w("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "isExitAnimating now!");
      AppMethodBeat.o(248017);
      return;
    }
    if (this.FGb == null) {
      p.bGy("pageAdapter");
    }
    localObject1 = this.FGb;
    if (localObject1 == null) {
      p.bGy("pageAdapter");
    }
    final Bitmap localBitmap = ((com.tencent.mm.plugin.multitask.a.a)localObject1).getBitmap();
    if ((localBitmap == null) || (localBitmap.isRecycled()) || (localBitmap.getWidth() == 0) || (localBitmap.getHeight() == 0))
    {
      Log.w("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "doMaskAnimation, page get bitmap is null");
      if (paramc != null)
      {
        paramc.Yb(paramInt);
        AppMethodBeat.o(248017);
        return;
      }
      AppMethodBeat.o(248017);
      return;
    }
    if (this.FGw != null)
    {
      localObject1 = this.FGw;
      if (localObject1 == null) {
        break label877;
      }
      localObject1 = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).getParent();
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = this.FGb;
      if (localObject1 == null) {
        p.bGy("pageAdapter");
      }
      this.FGw = new com.tencent.mm.plugin.multitask.animation.c.a.c((Context)((com.tencent.mm.plugin.multitask.a.a)localObject1).getActivity(), localBitmap);
      localObject1 = this.FGw;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      }
      localObject1 = this.FGb;
      if (localObject1 == null) {
        p.bGy("pageAdapter");
      }
      localObject1 = ((com.tencent.mm.plugin.multitask.a.a)localObject1).cuR();
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setBackgroundColor(0);
      }
      if (localObject1 != null) {
        ((ViewGroup)localObject1).addView((View)this.FGw, ((ViewGroup)localObject1).getChildCount());
      }
    }
    XZ(paramInt);
    localObject1 = this.FGb;
    if (localObject1 == null) {
      p.bGy("pageAdapter");
    }
    localObject1 = ((com.tencent.mm.plugin.multitask.a.a)localObject1).getContentView();
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(8);
    }
    if (paramBoolean)
    {
      localObject1 = this.FGu;
      label537:
      final int i;
      label545:
      final int j;
      final int k;
      Rect localRect;
      Object localObject2;
      final int m;
      final int n;
      final float f1;
      if (localObject1 != null)
      {
        paramBoolean = ((com.tencent.mm.plugin.multitask.b.b)localObject1).faI();
        if (!paramBoolean) {
          break label888;
        }
        i = 90;
        this.FGA = true;
        j = (int)(localBitmap.getWidth() * 1.25F);
        k = (int)(localBitmap.getHeight() * 1.25F);
        localRect = new Rect(0, 0, j, k);
        localObject1 = this.FGv;
        if (localObject1 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject1).FGo;
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = new Rect();
        }
        m = ((Rect)localObject1).left + ((Rect)localObject1).width() / 2;
        n = ((Rect)localObject1).top + ((Rect)localObject1).height() / 2;
        if (!paramBoolean) {
          break label894;
        }
        f1 = ((Rect)localObject1).height() / k;
        label673:
        if (!paramBoolean) {
          break label909;
        }
        ((Rect)localObject1).width();
      }
      for (;;)
      {
        float f2 = m - (localRect.left + localRect.width() / 2);
        int i1 = localRect.top;
        float f3 = n - (localRect.height() / 2 + i1);
        if (paramBoolean)
        {
          localObject2 = this.FGw;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject2).setGradientOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
          }
        }
        com.tencent.mm.ui.c.a.a.hF((View)this.FGw).cF(f2 * f1).cG(f3 * f1).cH(f1).cI(f1).a((com.tencent.mm.ui.c.a.b.a)new e(this, paramBoolean, j, k, f1, (Rect)localObject1, m, n, i)).c((Interpolator)new AccelerateInterpolator()).aQ((Runnable)new f(this, paramc, localBitmap, paramInt)).aP((Runnable)new g(this, paramc, localBitmap, paramInt)).Vw(250L).start();
        AppMethodBeat.o(248017);
        return;
        label877:
        localObject1 = null;
        break;
        paramBoolean = false;
        break label537;
        label888:
        i = 0;
        break label545;
        label894:
        f1 = ((Rect)localObject1).width() / j;
        break label673;
        label909:
        ((Rect)localObject1).width();
      }
    }
    if (paramc != null)
    {
      localObject1 = this.FGw;
      if (localObject1 != null) {}
      for (localObject1 = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).getContentBitmap();; localObject1 = null)
      {
        paramc.a((Bitmap)localObject1, true, paramInt);
        AppMethodBeat.o(248017);
        return;
      }
    }
    AppMethodBeat.o(248017);
  }
  
  private final void j(final int paramInt, final boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(248015);
    Object localObject = this.FGb;
    if (localObject == null) {
      p.bGy("pageAdapter");
    }
    if (((com.tencent.mm.plugin.multitask.a.a)localObject).bOd())
    {
      if (MMHandlerThread.isMainThread())
      {
        localObject = this.FGb;
        if (localObject == null) {
          p.bGy("pageAdapter");
        }
        ((com.tencent.mm.plugin.multitask.a.a)localObject).a((com.tencent.mm.plugin.multitask.a.a.b)new c(this));
        if (paramBoolean2)
        {
          MMHandlerThread.postToMainThread((Runnable)new d(this, paramInt, paramBoolean1));
          AppMethodBeat.o(248015);
          return;
        }
        localObject = this.FGv;
        if (localObject != null) {}
        for (localObject = ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).FGo; localObject != null; localObject = null)
        {
          a(paramInt, paramBoolean1, this.FGx);
          AppMethodBeat.o(248015);
          return;
        }
        if (this.FGx != null)
        {
          localObject = this.FGx;
          if (localObject != null)
          {
            ((com.tencent.mm.plugin.multitask.c.c)localObject).Yb(paramInt);
            AppMethodBeat.o(248015);
            return;
          }
        }
        AppMethodBeat.o(248015);
        return;
      }
      if (this.FGx != null)
      {
        localObject = this.FGx;
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.multitask.c.c)localObject).Yb(paramInt);
          AppMethodBeat.o(248015);
          return;
        }
      }
      AppMethodBeat.o(248015);
      return;
    }
    if (this.FGx != null)
    {
      localObject = this.FGx;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.multitask.c.c)localObject).Yb(paramInt);
        AppMethodBeat.o(248015);
        return;
      }
    }
    AppMethodBeat.o(248015);
  }
  
  public final void XW(int paramInt)
  {
    AppMethodBeat.i(248011);
    j(paramInt, true, true);
    AppMethodBeat.o(248011);
  }
  
  public final void a(com.tencent.mm.plugin.multitask.a.a parama, final com.tencent.mm.plugin.multitask.b.b paramb, com.tencent.mm.plugin.multitask.c.c paramc)
  {
    AppMethodBeat.i(248010);
    p.k(parama, "pageAdapter");
    p.k(paramb, "multiTaskHelper");
    this.FGb = parama;
    this.FGu = paramb;
    this.FGx = paramc;
    parama = this.FGb;
    if (parama == null) {
      p.bGy("pageAdapter");
    }
    parama.a((com.tencent.mm.plugin.multitask.a.a.a)new h(this, paramb));
    parama = this.FGb;
    if (parama == null) {
      p.bGy("pageAdapter");
    }
    parama = AnimationUtils.loadInterpolator((Context)parama.getActivity(), com.tencent.mm.ah.a.a.mm_decelerate_interpolator);
    paramb = this.FGb;
    if (paramb == null) {
      p.bGy("pageAdapter");
    }
    paramb = paramb.cuR();
    if (paramb != null)
    {
      paramc = com.tencent.mm.plugin.multitask.animation.c.a.b.FGp;
      paramc = (com.tencent.mm.plugin.multitask.animation.c.a.b.a)new b();
      p.j(parama, "interpolator");
      this.FGv = com.tencent.mm.plugin.multitask.animation.c.a.b.b.a(paramb, paramc, parama);
    }
    parama = this.FGv;
    if (parama != null) {
      parama.Rt = 1;
    }
    parama = this.FGb;
    if (parama == null) {
      p.bGy("pageAdapter");
    }
    parama = parama.getActivity();
    if (parama != null)
    {
      parama = parama.getResources();
      if (parama != null)
      {
        parama = parama.getDisplayMetrics();
        if (parama == null) {}
      }
    }
    for (float f = parama.density;; f = com.tencent.mm.ci.a.getDensity((Context)parama.getActivity()))
    {
      parama = this.FGv;
      if (parama != null) {
        parama.FGk = (100.0F * f);
      }
      parama = this.FGv;
      if (parama == null) {
        break;
      }
      parama.rti = (f * 300.0F);
      AppMethodBeat.o(248010);
      return;
      parama = this.FGb;
      if (parama == null) {
        p.bGy("pageAdapter");
      }
    }
    AppMethodBeat.o(248010);
  }
  
  protected final com.tencent.mm.plugin.multitask.a.a faC()
  {
    AppMethodBeat.i(248009);
    com.tencent.mm.plugin.multitask.a.a locala = this.FGb;
    if (locala == null) {
      p.bGy("pageAdapter");
    }
    AppMethodBeat.o(248009);
    return locala;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/animation/swipeback/multiscene/MultiTaskSwipeBackAnimWrapperMS$ViewDragCallback;", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Callback;", "Lcom/tencent/mm/ui/base/ActivityUtil$IConvertActivityTranslucentCallback;", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/multiscene/MultiTaskSwipeBackAnimWrapperMS;)V", "CONSTANT_X_VELOCITY", "", "getCONSTANT_X_VELOCITY", "()I", "isFinish", "", "()Z", "setFinish", "(Z)V", "mFractor", "", "getMFractor", "()F", "setMFractor", "(F)V", "mStartTransX", "getMStartTransX", "setMStartTransX", "(I)V", "mStartTransY", "getMStartTransY", "setMStartTransY", "mStartViewPosition", "Landroid/graphics/Rect;", "getMStartViewPosition", "()Landroid/graphics/Rect;", "setMStartViewPosition", "(Landroid/graphics/Rect;)V", "autoHide", "firstValue", "clampViewPositionHorizontal", "child", "Landroid/view/View;", "left", "dx", "getViewHorizontalDragRange", "onComplete", "", "drawComplete", "onViewCaptured", "capturedChild", "activePointerId", "onViewDragStateChanged", "state", "onViewPositionChanged", "changedView", "top", "dy", "onViewReleased", "releasedChild", "xvel", "yvel", "onViewTouchPositionChanged", "touchX", "touchY", "adx", "ady", "tryCaptureView", "view", "i", "plugin-multitask_release"})
  final class b
    extends com.tencent.mm.plugin.multitask.animation.c.a.b.a
    implements com.tencent.mm.ui.base.b.b
  {
    private int FGC = -1;
    private int FGD = -1;
    private float FGE;
    private Rect FGF;
    private final int FGG = 400;
    private boolean lwF;
    
    private final boolean bA(final float paramFloat)
    {
      AppMethodBeat.i(248349);
      final com.tencent.mm.plugin.multitask.animation.c.a.c localc = this.FGH.FGw;
      Object localObject1 = this.FGH.FGw;
      Object localObject2;
      boolean bool;
      label68:
      final int j;
      final int k;
      final int m;
      final int n;
      final float f1;
      label192:
      final float f2;
      label208:
      float f3;
      float f4;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).getContentBitmap();
        if ((localc == null) || (localObject1 == null)) {
          break label429;
        }
        localObject2 = this.FGH.FGu;
        if (localObject2 == null) {
          break label389;
        }
        bool = ((com.tencent.mm.plugin.multitask.b.b)localObject2).faI();
        j = (int)(((Bitmap)localObject1).getWidth() * 1.25F);
        k = (int)(((Bitmap)localObject1).getHeight() * 1.25F);
        Rect localRect2 = new Rect(0, 0, j, k);
        localObject2 = this.FGH.FGv;
        if (localObject2 != null)
        {
          Rect localRect1 = ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject2).FGo;
          localObject2 = localRect1;
          if (localRect1 != null) {}
        }
        else
        {
          localObject2 = new Rect();
        }
        m = ((Rect)localObject2).left + ((Rect)localObject2).width() / 2;
        n = ((Rect)localObject2).top + ((Rect)localObject2).height() / 2;
        if (!bool) {
          break label395;
        }
        f1 = ((Rect)localObject2).width() / k;
        if (!bool) {
          break label409;
        }
        f2 = ((Rect)localObject2).height() / j;
        f3 = m - (localRect2.left + localRect2.width() / 2);
        i = localRect2.top;
        f4 = n - (localRect2.height() / 2 + i);
        if (!bool) {
          break label423;
        }
      }
      label389:
      label395:
      label409:
      label423:
      for (final int i = 90;; i = 0)
      {
        if (bool) {
          localc.setGradientOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        com.tencent.mm.ui.c.a.a.hF((View)localc).a((com.tencent.mm.ui.c.a.b.a)new a(bool, j, k, f1, (Rect)localObject2, f2, localc, m, n, i, this, paramFloat)).aP((Runnable)new b(localc, (Bitmap)localObject1, this, paramFloat)).cH(f1).cI(f1).cF(f3 * f1).cG(f4 * f1).c((Interpolator)new AccelerateInterpolator()).Vw(250L).start();
        AppMethodBeat.o(248349);
        return true;
        localObject1 = null;
        break;
        bool = false;
        break label68;
        f1 = ((Rect)localObject2).width() / j;
        break label192;
        f2 = ((Rect)localObject2).width() / j;
        break label208;
      }
      label429:
      AppMethodBeat.o(248349);
      return false;
    }
    
    public final void G(int paramInt)
    {
      AppMethodBeat.i(248353);
      Log.d("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "onViewDragStateChanged, state:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(248353);
    }
    
    public final int XY(int paramInt)
    {
      return 0;
    }
    
    public final void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(248357);
      if (this.FGH.FGw != null)
      {
        localObject = this.FGH.FGw;
        if ((localObject == null) || (((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).getWidth() != 0))
        {
          localObject = this.FGH.FGv;
          if (localObject == null) {
            break label71;
          }
        }
      }
      label71:
      for (Object localObject = ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).FGo; localObject == null; localObject = null)
      {
        AppMethodBeat.o(248357);
        return;
      }
      localObject = this.FGH.FGw;
      label118:
      Rect localRect;
      label180:
      label208:
      float f2;
      int i;
      int j;
      label311:
      label328:
      float f1;
      label347:
      label370:
      float f3;
      label388:
      float f4;
      if (localObject != null)
      {
        paramInt1 = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).getWidth();
        localObject = this.FGH.FGw;
        if (localObject == null) {
          break label522;
        }
        paramInt2 = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).getHeight();
        if (this.FGF == null) {
          this.FGF = com.tencent.mm.plugin.multitask.f.c.fA((View)this.FGH.FGw);
        }
        if ((this.FGC == -1) && (this.FGD == -1))
        {
          localObject = this.FGH.FGw;
          if (localObject == null) {
            break label528;
          }
          paramInt3 = (int)((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).getTranslationX();
          this.FGC = paramInt3;
          localObject = this.FGH.FGw;
          if (localObject == null) {
            break label534;
          }
          paramInt3 = (int)((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).getTranslationY();
          this.FGD = paramInt3;
        }
        paramFloat2 = paramFloat1 / paramInt1 / 3.0F;
        localObject = this.FGH.FGv;
        if (localObject != null)
        {
          localRect = ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).FGo;
          localObject = localRect;
          if (localRect != null) {}
        }
        else
        {
          localObject = new Rect();
        }
        f2 = ((Rect)localObject).width() / paramInt1;
        i = ((Rect)localObject).left + ((Rect)localObject).width() / 2;
        j = ((Rect)localObject).top + ((Rect)localObject).height() / 2;
        if (paramFloat2 <= 1.0F) {
          break label540;
        }
        paramFloat1 = 1.0F;
        paramFloat1 = 1.0F - paramFloat1 * (1.0F - f2);
        if (paramFloat1 <= 1.0F) {
          break label553;
        }
        paramFloat1 = 1.0F;
        f1 = (1.0F - paramFloat1) / (1.0F - f2);
        if (f1 <= 1.0F) {
          break label567;
        }
        paramFloat2 = 1.0F;
        f1 = i;
        localRect = this.FGF;
        if (localRect == null) {
          break label582;
        }
        paramInt3 = localRect.left;
        localRect = this.FGF;
        if (localRect == null) {
          break label588;
        }
        paramInt4 = localRect.width();
        f3 = paramInt3 + paramInt4 / 2;
        f4 = j;
        localRect = this.FGF;
        if (localRect == null) {
          break label594;
        }
        paramInt3 = localRect.top;
        label421:
        localRect = this.FGF;
        if (localRect == null) {
          break label600;
        }
      }
      float f5;
      float f6;
      float f7;
      label522:
      label528:
      label534:
      label540:
      label553:
      label567:
      label582:
      label588:
      label594:
      label600:
      for (paramInt4 = localRect.height();; paramInt4 = 0)
      {
        f5 = paramInt3 + paramInt4 / 2;
        f6 = this.FGC;
        f7 = this.FGD;
        this.FGE = paramFloat2;
        if ((paramFloat2 < 0.16F) || (this.lwF)) {
          break label606;
        }
        this.lwF = true;
        if (!bA(paramFloat2)) {
          MMHandlerThread.postToMainThread((Runnable)new d(this));
        }
        AppMethodBeat.o(248357);
        return;
        paramInt1 = 0;
        break;
        paramInt2 = 0;
        break label118;
        paramInt3 = 0;
        break label180;
        paramInt3 = 0;
        break label208;
        paramFloat1 = paramFloat2;
        if (paramFloat2 >= 0.0F) {
          break label311;
        }
        paramFloat1 = 0.0F;
        break label311;
        if (paramFloat1 < 0.0F)
        {
          paramFloat1 = 0.0F;
          break label328;
        }
        break label328;
        paramFloat2 = f1;
        if (f1 >= 0.0F) {
          break label347;
        }
        paramFloat2 = 0.0F;
        break label347;
        paramInt3 = 0;
        break label370;
        paramInt4 = 0;
        break label388;
        paramInt3 = 0;
        break label421;
      }
      label606:
      float f8 = paramInt1;
      float f9 = (paramInt2 * f2 - ((Rect)localObject).height()) / 2.0F * paramFloat2 * (1.0F / f2);
      float f10 = paramInt2;
      localObject = this.FGH.FGw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).setMaskAlpha((int)(255.0F * paramFloat2));
      }
      localObject = this.FGH.FGw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).p(0.0F, f9, f8, f10 - f9);
      }
      localObject = com.tencent.mm.plugin.multitask.animation.c.a.c.FGt;
      f8 = com.tencent.mm.plugin.multitask.animation.c.a.c.faB() * paramFloat2 / paramFloat1;
      localObject = this.FGH.FGw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).a(f8, f8, f8, f8, f8, f8, f8, f8);
      }
      localObject = this.FGH.FGw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).setPivotX(i);
      }
      localObject = this.FGH.FGw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).setPivotY(j);
      }
      localObject = this.FGH.FGw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).setTranslationX(f6 + (f1 - f3) * f2 * paramFloat2);
      }
      localObject = this.FGH.FGw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).setTranslationY(f7 + (f4 - f5) * f2 * paramFloat2);
      }
      localObject = this.FGH.FGw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).setScaleX(paramFloat1);
      }
      localObject = this.FGH.FGw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).setScaleY(paramFloat1);
      }
      localObject = this.FGH.FGw;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).postInvalidate();
        AppMethodBeat.o(248357);
        return;
      }
      AppMethodBeat.o(248357);
    }
    
    public final int aEe()
    {
      return 1;
    }
    
    public final boolean b(View paramView, int paramInt)
    {
      AppMethodBeat.i(248344);
      paramView = this.FGH.FGv;
      if (paramView != null)
      {
        boolean bool = paramView.XX(paramInt);
        AppMethodBeat.o(248344);
        return bool;
      }
      AppMethodBeat.o(248344);
      return false;
    }
    
    public final void c(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(248350);
      Log.d("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "onViewReleased, xvel: %f, yvel: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
      if (this.lwF)
      {
        Log.i("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "onViewReleased, isFinish!");
        AppMethodBeat.o(248350);
        return;
      }
      if ((Math.abs(paramFloat1) > this.FGG) && (bA(this.FGE)))
      {
        this.lwF = true;
        Log.i("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "onViewReleased, auto add multitask!");
        AppMethodBeat.o(248350);
        return;
      }
      MMHandlerThread.postToMainThread((Runnable)new c(this));
      this.FGH.FGy = -1L;
      paramView = this.FGH.faC().getContentView();
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      this.FGH.faC();
      this.FGH.faC().vl(true);
      AppMethodBeat.o(248350);
    }
    
    public final void eG(boolean paramBoolean)
    {
      AppMethodBeat.i(248354);
      Log.d("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "onComplete");
      AppMethodBeat.o(248354);
    }
    
    public final void faA()
    {
      AppMethodBeat.i(248355);
      Log.i("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "onViewCaptured");
      if (this.lwF)
      {
        Log.i("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "onViewCaptured, isFinish!");
        AppMethodBeat.o(248355);
        return;
      }
      a.a(this.FGH);
      this.FGC = -1;
      this.FGD = -1;
      AppMethodBeat.o(248355);
    }
    
    public final void l(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "value", "", "onUpdate", "com/tencent/mm/plugin/multitask/animation/swipeback/multiscene/MultiTaskSwipeBackAnimWrapperMS$ViewDragCallback$autoHide$1$1"})
    static final class a
      implements com.tencent.mm.ui.c.a.b.a
    {
      a(boolean paramBoolean, int paramInt1, int paramInt2, float paramFloat1, Rect paramRect, float paramFloat2, com.tencent.mm.plugin.multitask.animation.c.a.c paramc, int paramInt3, int paramInt4, int paramInt5, a.b paramb, float paramFloat3) {}
      
      public final void bB(float paramFloat)
      {
        AppMethodBeat.i(247805);
        float f5 = paramFloat + (1.0F - paramFloat) * paramFloat;
        float f3;
        float f1;
        float f2;
        float f4;
        if (!this.FGI)
        {
          f3 = j;
          f1 = (k * f1 - this.FGJ.height()) / 2.0F;
          f2 = 1.0F / f1 * (f1 * f5);
          f1 = k - f2;
          f4 = 0.0F;
        }
        for (;;)
        {
          localc.setPivotX(m);
          localc.setPivotY(n);
          localc.setMaskAlpha((int)(255.0F * f5));
          localc.p(f4, f2, f3, f1);
          c.a locala = com.tencent.mm.plugin.multitask.animation.c.a.c.FGt;
          f1 = com.tencent.mm.plugin.multitask.animation.c.a.c.faB() * f5 / f1;
          localc.a(f1, f1, f1, f1, f1, f1, f1, f1);
          localc.setRotate(i * paramFloat);
          localc.postInvalidate();
          AppMethodBeat.o(247805);
          return;
          f1 = k;
          f4 = (j * f1 - this.FGJ.height()) / 2.0F * f5 * (1.0F / f2);
          f3 = j - f4;
          f2 = 0.0F;
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/multitask/animation/swipeback/multiscene/MultiTaskSwipeBackAnimWrapperMS$ViewDragCallback$autoHide$1$2"})
    static final class b
      implements Runnable
    {
      b(com.tencent.mm.plugin.multitask.animation.c.a.c paramc, Bitmap paramBitmap, a.b paramb, float paramFloat) {}
      
      public final void run()
      {
        AppMethodBeat.i(247728);
        this.FGL.setVisibility(8);
        MMHandlerThread.postToMainThread((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(248791);
            com.tencent.mm.plugin.multitask.c.c localc = this.FGR.FGP.FGH.FGx;
            if (localc != null)
            {
              localc.h(this.FGR.cLr, 3);
              AppMethodBeat.o(248791);
              return;
            }
            AppMethodBeat.o(248791);
          }
        });
        AppMethodBeat.o(247728);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class c
      implements Runnable
    {
      c(a.b paramb) {}
      
      public final void run()
      {
        Object localObject2 = null;
        AppMethodBeat.i(248150);
        if (this.FGP.FGH.FGw != null)
        {
          Object localObject1 = this.FGP.FGH.FGw;
          if (localObject1 != null) {
            localObject1 = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).getParent();
          }
          while (localObject1 != null)
          {
            com.tencent.mm.plugin.multitask.animation.c.a.c localc = this.FGP.FGH.FGw;
            localObject1 = localObject2;
            if (localc != null) {
              localObject1 = localc.getParent();
            }
            if (localObject1 == null)
            {
              localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
              AppMethodBeat.o(248150);
              throw ((Throwable)localObject1);
              localObject1 = null;
            }
            else
            {
              ((ViewGroup)localObject1).removeView((View)this.FGP.FGH.FGw);
            }
          }
        }
        AppMethodBeat.o(248150);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class d
      implements Runnable
    {
      d(a.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(248514);
        com.tencent.mm.plugin.multitask.c.c localc = this.FGP.FGH.FGx;
        if (localc != null)
        {
          Object localObject = this.FGP.FGH.FGw;
          if (localObject != null) {}
          for (localObject = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).getContentBitmap();; localObject = null)
          {
            localc.h((Bitmap)localObject, 3);
            AppMethodBeat.o(248514);
            return;
          }
        }
        AppMethodBeat.o(248514);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/animation/swipeback/multiscene/MultiTaskSwipeBackAnimWrapperMS$doPrepareTransform$1", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$TranslucentCallback;", "onComplete", "", "done", "", "plugin-multitask_release"})
  public static final class c
    implements com.tencent.mm.plugin.multitask.a.a.b
  {
    public final void eG(boolean paramBoolean)
    {
      AppMethodBeat.i(249148);
      if (!paramBoolean)
      {
        Object localObject = this.FGH.FGu;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.multitask.b.b)localObject).faG();
          if (localObject != null)
          {
            localObject = ((daq)localObject).TIa;
            if (localObject != null)
            {
              ((dap)localObject).THV = false;
              AppMethodBeat.o(249148);
              return;
            }
          }
        }
      }
      AppMethodBeat.o(249148);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(a parama, int paramInt, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(247572);
      Object localObject = this.FGH.FGv;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).FGo; localObject != null; localObject = null)
      {
        a.a(this.FGH, paramInt, paramBoolean1, this.FGH.FGx);
        AppMethodBeat.o(247572);
        return;
      }
      if (this.FGH.FGx != null)
      {
        localObject = this.FGH.FGx;
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.multitask.c.c)localObject).Yb(paramInt);
          AppMethodBeat.o(247572);
          return;
        }
      }
      AppMethodBeat.o(247572);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "value", "", "onUpdate"})
  static final class e
    implements com.tencent.mm.ui.c.a.b.a
  {
    e(a parama, boolean paramBoolean, int paramInt1, int paramInt2, float paramFloat, Rect paramRect, int paramInt3, int paramInt4, int paramInt5) {}
    
    public final void bB(float paramFloat)
    {
      AppMethodBeat.i(249085);
      float f3;
      float f1;
      float f2;
      float f4;
      if (!paramBoolean)
      {
        f3 = j;
        f1 = (k * f1 - this.FGJ.height()) / 2.0F;
        f2 = 1.0F / f1 * (f1 * paramFloat);
        f1 = k - f2;
        f4 = 0.0F;
      }
      for (;;)
      {
        Object localObject = this.FGH.FGw;
        if (localObject != null) {
          ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).setMaskAlpha((int)(255.0F * paramFloat));
        }
        localObject = this.FGH.FGw;
        if (localObject != null) {
          ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).p(f4, f2, f3, f1);
        }
        localObject = com.tencent.mm.plugin.multitask.animation.c.a.c.FGt;
        f1 = com.tencent.mm.plugin.multitask.animation.c.a.c.faB() * paramFloat / f1;
        localObject = this.FGH.FGw;
        if (localObject != null) {
          ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).a(f1, f1, f1, f1, f1, f1, f1, f1);
        }
        localObject = this.FGH.FGw;
        if (localObject != null) {
          ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).setPivotX(m);
        }
        localObject = this.FGH.FGw;
        if (localObject != null) {
          ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).setPivotY(n);
        }
        localObject = this.FGH.FGw;
        if (localObject != null) {
          ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).setRotate(i * paramFloat);
        }
        localObject = this.FGH.FGw;
        if (localObject == null) {
          break;
        }
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).postInvalidate();
        AppMethodBeat.o(249085);
        return;
        f4 = (j * f1 - this.FGJ.width()) / 2.0F * paramFloat * (1.0F / f1);
        f3 = j - f4;
        f1 = k - 0.0F;
        f2 = 0.0F;
      }
      AppMethodBeat.o(249085);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a parama, com.tencent.mm.plugin.multitask.c.c paramc, Bitmap paramBitmap, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(247701);
      Object localObject = this.FGH.FGw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).setTranslationX(0.0F);
      }
      localObject = this.FGH.FGw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).setTranslationY(0.0F);
      }
      localObject = this.FGH.FGw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).setScaleX(1.0F);
      }
      localObject = this.FGH.FGw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).setScaleY(1.0F);
      }
      localObject = paramc;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.multitask.c.c)localObject).a(localBitmap, false, paramInt);
        AppMethodBeat.o(247701);
        return;
      }
      AppMethodBeat.o(247701);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(a parama, com.tencent.mm.plugin.multitask.c.c paramc, Bitmap paramBitmap, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(248976);
      this.FGH.FGA = false;
      MMHandlerThread.postToMainThread((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(248850);
          com.tencent.mm.plugin.multitask.c.c localc = this.FGV.FFN;
          if (localc != null)
          {
            localc.h(this.FGV.FGU, this.FGV.FGS);
            AppMethodBeat.o(248850);
            return;
          }
          AppMethodBeat.o(248850);
        }
      });
      AppMethodBeat.o(248976);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/animation/swipeback/multiscene/MultiTaskSwipeBackAnimWrapperMS$onCreate$1", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;", "canInterceptTouchEvent", "", "enableSwipeBack", "getSwipeBackTouchState", "", "onDispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onEdgeDragStarted", "edgeFlags", "pointerId", "onPositionChange", "scrollPercent", "", "onSwipeReleased", "willSwipeBack", "shouldInterceptTouchEvent", "ev", "plugin-multitask_release"})
  public static final class h
    implements com.tencent.mm.plugin.multitask.a.a.a
  {
    h(com.tencent.mm.plugin.multitask.b.b paramb) {}
    
    public final void XV(int paramInt) {}
    
    public final void by(float paramFloat) {}
    
    public final boolean fat()
    {
      AppMethodBeat.i(248980);
      boolean bool = paramb.faM();
      AppMethodBeat.o(248980);
      return bool;
    }
    
    public final int fau()
    {
      com.tencent.mm.plugin.multitask.animation.c.a.b localb = this.FGH.FGv;
      if (localb != null) {
        return localb.FGj;
      }
      return 0;
    }
    
    public final boolean fav()
    {
      AppMethodBeat.i(248982);
      a locala;
      if (this.FGH.FGy == -1L)
      {
        locala = this.FGH;
        localObject = paramb;
        if (localObject == null) {
          break label74;
        }
      }
      label74:
      for (Object localObject = Boolean.valueOf(((com.tencent.mm.plugin.multitask.b.b)localObject).faQ());; localObject = null)
      {
        locala.FGz = ((Boolean)localObject).booleanValue();
        this.FGH.FGy = 0L;
        boolean bool = this.FGH.FGz;
        AppMethodBeat.o(248982);
        return bool;
      }
    }
    
    public final boolean i(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(248983);
      p.k(paramMotionEvent, "ev");
      com.tencent.mm.plugin.multitask.animation.c.a.b localb = this.FGH.FGv;
      if (localb != null)
      {
        boolean bool = localb.i(paramMotionEvent);
        AppMethodBeat.o(248983);
        return bool;
      }
      AppMethodBeat.o(248983);
      return false;
    }
    
    public final void n(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(248979);
      p.k(paramMotionEvent, "event");
      com.tencent.mm.plugin.multitask.animation.c.a.b localb = this.FGH.FGv;
      if (localb != null)
      {
        localb.j(paramMotionEvent);
        AppMethodBeat.o(248979);
        return;
      }
      AppMethodBeat.o(248979);
    }
    
    public final int vm(boolean paramBoolean)
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.c.b.a
 * JD-Core Version:    0.7.0.1
 */