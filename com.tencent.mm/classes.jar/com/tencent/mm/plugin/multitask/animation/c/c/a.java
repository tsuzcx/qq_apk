package com.tencent.mm.plugin.multitask.animation.c.c;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.animation.c.a.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.k;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/animation/swipeback/singlescene/MultiTaskSwipeBackAnimWrapperSS;", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/BaseMultiTaskSwipeBackAnimWrapper;", "()V", "enableSwipeback", "", "getEnableSwipeback", "()Z", "setEnableSwipeback", "(Z)V", "isExitAnimating", "setExitAnimating", "mDragHelper", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "getMDragHelper", "()Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "setMDragHelper", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;)V", "mListener", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "getMListener", "()Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "setMListener", "(Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;)V", "multiTaskHelper", "Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "getMultiTaskHelper", "()Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "setMultiTaskHelper", "(Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;)V", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "getPageAdapter", "()Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "setPageAdapter", "(Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "swipeBackFlag", "", "getSwipeBackFlag", "()J", "setSwipeBackFlag", "(J)V", "swipeView", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/TransformSwipeBackToMultiTaskView;", "getSwipeView", "()Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/TransformSwipeBackToMultiTaskView;", "setSwipeView", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/TransformSwipeBackToMultiTaskView;)V", "doPrepareTransform", "", "way", "", "exitAnim", "init", "initMaskView", "enterAnim", "listener", "onCreate", "refreshPosition", "resetView", "startSwipeAnim", "Companion", "ViewDragCallback", "plugin-multitask_release"})
public final class a
  extends com.tencent.mm.plugin.multitask.animation.c.a.a
{
  public static final a.a FGX;
  boolean FGA;
  protected com.tencent.mm.plugin.multitask.a.a FGb;
  private com.tencent.mm.plugin.multitask.b.b FGu;
  com.tencent.mm.plugin.multitask.animation.c.a.b FGv;
  com.tencent.mm.plugin.multitask.animation.c.a.c FGw;
  com.tencent.mm.plugin.multitask.c.c FGx;
  long FGy = -1L;
  boolean FGz = true;
  
  static
  {
    AppMethodBeat.i(247976);
    FGX = new a.a((byte)0);
    AppMethodBeat.o(247976);
  }
  
  private final void XZ(int paramInt)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    AppMethodBeat.i(247970);
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
          AppMethodBeat.o(247970);
          throw ((Throwable)localObject1);
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", "refreshPosition, get pos failed, %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(247970);
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
              AppMethodBeat.o(247970);
              return;
            }
          }
          AppMethodBeat.o(247970);
          return;
        }
      }
    }
    AppMethodBeat.o(247970);
  }
  
  private final void aO(final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(247967);
    Object localObject = this.FGb;
    if (localObject == null) {
      p.bGy("pageAdapter");
    }
    if (((com.tencent.mm.plugin.multitask.a.a)localObject).bOd())
    {
      localObject = this.FGb;
      if (localObject == null) {
        p.bGy("pageAdapter");
      }
      if (((com.tencent.mm.plugin.multitask.a.a)localObject).cbM())
      {
        localObject = this.FGb;
        if (localObject == null) {
          p.bGy("pageAdapter");
        }
        ((com.tencent.mm.plugin.multitask.a.a)localObject).a(null);
      }
      MMHandlerThread.postToMainThread((Runnable)new c(this, paramInt, paramBoolean));
      AppMethodBeat.o(247967);
      return;
    }
    if (this.FGx != null)
    {
      localObject = this.FGx;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.multitask.c.c)localObject).Yb(paramInt);
        AppMethodBeat.o(247967);
        return;
      }
    }
    AppMethodBeat.o(247967);
  }
  
  private final void faD()
  {
    AppMethodBeat.i(247973);
    com.tencent.mm.plugin.multitask.animation.c.a.c localc = this.FGw;
    if (localc != null) {
      localc.setTranslationX(0.0F);
    }
    localc = this.FGw;
    if (localc != null) {
      localc.setTranslationY(0.0F);
    }
    localc = this.FGw;
    if (localc != null) {
      localc.setScaleX(1.0F);
    }
    localc = this.FGw;
    if (localc != null)
    {
      localc.setScaleY(1.0F);
      AppMethodBeat.o(247973);
      return;
    }
    AppMethodBeat.o(247973);
  }
  
  public final void XW(int paramInt)
  {
    AppMethodBeat.i(247964);
    aO(paramInt, true);
    AppMethodBeat.o(247964);
  }
  
  public final void a(com.tencent.mm.plugin.multitask.a.a parama, final com.tencent.mm.plugin.multitask.b.b paramb, com.tencent.mm.plugin.multitask.c.c paramc)
  {
    AppMethodBeat.i(247962);
    p.k(parama, "pageAdapter");
    p.k(paramb, "multiTaskHelper");
    this.FGb = parama;
    this.FGu = paramb;
    this.FGx = paramc;
    parama = this.FGb;
    if (parama == null) {
      p.bGy("pageAdapter");
    }
    if (parama != null) {
      parama.a((com.tencent.mm.plugin.multitask.a.a.a)new g(this, paramb));
    }
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
      AppMethodBeat.o(247962);
      return;
      parama = this.FGb;
      if (parama == null) {
        p.bGy("pageAdapter");
      }
    }
    AppMethodBeat.o(247962);
  }
  
  protected final com.tencent.mm.plugin.multitask.a.a faC()
  {
    AppMethodBeat.i(247960);
    com.tencent.mm.plugin.multitask.a.a locala = this.FGb;
    if (locala == null) {
      p.bGy("pageAdapter");
    }
    AppMethodBeat.o(247960);
    return locala;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/animation/swipeback/singlescene/MultiTaskSwipeBackAnimWrapperSS$ViewDragCallback;", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Callback;", "Lcom/tencent/mm/ui/base/ActivityUtil$IConvertActivityTranslucentCallback;", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/singlescene/MultiTaskSwipeBackAnimWrapperSS;)V", "CONSTANT_X_VELOCITY", "", "getCONSTANT_X_VELOCITY", "()I", "isFinish", "", "()Z", "setFinish", "(Z)V", "mStartTransX", "getMStartTransX", "setMStartTransX", "(I)V", "mStartTransY", "getMStartTransY", "setMStartTransY", "mStartViewPosition", "Landroid/graphics/Rect;", "getMStartViewPosition", "()Landroid/graphics/Rect;", "setMStartViewPosition", "(Landroid/graphics/Rect;)V", "autoHide", "firstValue", "", "clampViewPositionHorizontal", "child", "Landroid/view/View;", "left", "dx", "getViewHorizontalDragRange", "onComplete", "", "drawComplete", "onViewCaptured", "capturedChild", "activePointerId", "onViewDragStateChanged", "state", "onViewPositionChanged", "changedView", "top", "dy", "onViewReleased", "releasedChild", "xvel", "yvel", "onViewTouchPositionChanged", "touchX", "touchY", "adx", "ady", "tryCaptureView", "view", "i", "plugin-multitask_release"})
  final class b
    extends com.tencent.mm.plugin.multitask.animation.c.a.b.a
    implements com.tencent.mm.ui.base.b.b
  {
    private int FGC = -1;
    private int FGD = -1;
    private Rect FGF;
    private final int FGG = 400;
    private boolean lwF;
    
    private final boolean bA(final float paramFloat)
    {
      AppMethodBeat.i(248161);
      final com.tencent.mm.plugin.multitask.animation.c.a.c localc = this.FGY.FGw;
      Object localObject1 = this.FGY.FGw;
      if (localObject1 != null) {}
      for (localObject1 = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).getContentBitmap(); (localc != null) && (localObject1 != null); localObject1 = null)
      {
        int i = (int)(((Bitmap)localObject1).getWidth() * 1.25F);
        final int j = (int)(((Bitmap)localObject1).getHeight() * 1.25F);
        Rect localRect2 = new Rect(0, 0, i, j);
        Object localObject2 = this.FGY.FGv;
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
        final int k = ((Rect)localObject2).left;
        k = ((Rect)localObject2).width() / 2 + k;
        final int m = ((Rect)localObject2).top;
        m = ((Rect)localObject2).height() / 2 + m;
        final float f1 = ((Rect)localObject2).width() / i;
        float f2 = k - (localRect2.left + localRect2.width() / 2);
        int n = localRect2.top;
        float f3 = m - (localRect2.height() / 2 + n);
        com.tencent.mm.ui.c.a.a.hF((View)localc).a((com.tencent.mm.ui.c.a.b.a)new a(i, j, f1, (Rect)localObject2, localc, k, m, this, paramFloat)).aP((Runnable)new b((Bitmap)localObject1, this, paramFloat)).cH(f1).cI(f1).cF(f2 * f1).cG(f3 * f1).c((Interpolator)new AccelerateInterpolator()).Vw(250L).start();
        AppMethodBeat.o(248161);
        return true;
      }
      AppMethodBeat.o(248161);
      return false;
    }
    
    public final void G(int paramInt)
    {
      AppMethodBeat.i(248164);
      Log.d("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", "onViewDragStateChanged, state:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(248164);
    }
    
    public final int XY(int paramInt)
    {
      return 0;
    }
    
    public final void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(248169);
      if (this.FGY.FGw != null)
      {
        localObject = this.FGY.FGw;
        if ((localObject == null) || (((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).getWidth() != 0))
        {
          localObject = this.FGY.FGv;
          if (localObject == null) {
            break label69;
          }
        }
      }
      label69:
      for (Object localObject = ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).FGo; localObject == null; localObject = null)
      {
        AppMethodBeat.o(248169);
        return;
      }
      localObject = this.FGY.FGw;
      label117:
      int i;
      label179:
      label207:
      float f2;
      Rect localRect;
      int k;
      int m;
      label315:
      label336:
      float f3;
      label357:
      label380:
      float f5;
      if (localObject != null)
      {
        paramInt3 = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).getWidth();
        localObject = this.FGY.FGw;
        if (localObject == null) {
          break label553;
        }
        paramInt4 = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).getHeight();
        if (this.FGF == null) {
          this.FGF = com.tencent.mm.plugin.multitask.f.c.fA((View)this.FGY.FGw);
        }
        if ((this.FGC == -1) && (this.FGD == -1))
        {
          localObject = this.FGY.FGw;
          if (localObject == null) {
            break label559;
          }
          i = (int)((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).getTranslationX();
          this.FGC = i;
          localObject = this.FGY.FGw;
          if (localObject == null) {
            break label565;
          }
          i = (int)((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).getTranslationY();
          this.FGD = i;
        }
        f2 = paramFloat1 / paramInt3 / 3.0F;
        localObject = this.FGY.FGv;
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
        f4 = ((Rect)localObject).width() / paramInt3;
        k = ((Rect)localObject).left + ((Rect)localObject).width() / 2;
        m = ((Rect)localObject).top + ((Rect)localObject).height() / 2;
        if (f2 <= 1.0F) {
          break label571;
        }
        f1 = 1.0F;
        f2 = 1.0F - f1 * (1.0F - f4);
        if (f2 <= 1.0F) {
          break label588;
        }
        f2 = 1.0F;
        f3 = (1.0F - f2) / (1.0F - f4);
        if (f3 <= 1.0F) {
          break label591;
        }
        f1 = 1.0F;
        f3 = k;
        localRect = this.FGF;
        if (localRect == null) {
          break label608;
        }
        i = localRect.left;
        localRect = this.FGF;
        if (localRect == null) {
          break label614;
        }
        j = localRect.width();
        label398:
        f7 = i + j / 2;
        f5 = m;
        localRect = this.FGF;
        if (localRect == null) {
          break label620;
        }
        i = localRect.top;
        label431:
        localRect = this.FGF;
        if (localRect == null) {
          break label626;
        }
      }
      label553:
      label559:
      label565:
      label571:
      label588:
      label591:
      label608:
      label614:
      label620:
      label626:
      for (int j = localRect.height();; j = 0)
      {
        f6 = i + j / 2;
        f3 = this.FGC + (f3 - f7) * f4 * f1;
        f5 = this.FGD + (f5 - f6) * f4 * f1;
        if ((f1 < 0.16F) || (this.lwF)) {
          break label632;
        }
        this.lwF = true;
        if (!bA(f1)) {
          MMHandlerThread.postToMainThread((Runnable)new d(this));
        }
        AppMethodBeat.o(248169);
        return;
        paramInt3 = 0;
        break;
        paramInt4 = 0;
        break label117;
        i = 0;
        break label179;
        i = 0;
        break label207;
        f1 = f2;
        if (f2 >= 0.0F) {
          break label315;
        }
        f1 = 0.0F;
        break label315;
        break label336;
        f1 = f3;
        if (f3 >= 0.0F) {
          break label357;
        }
        f1 = 0.0F;
        break label357;
        i = 0;
        break label380;
        j = 0;
        break label398;
        i = 0;
        break label431;
      }
      label632:
      float f6 = paramInt3;
      float f4 = (paramInt4 * f4 - ((Rect)localObject).height()) / 2.0F * f1 * (1.0F / f4);
      float f7 = paramInt4;
      localObject = this.FGY.FGw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).setMaskAlpha((int)(255.0F * f1));
      }
      localObject = this.FGY.FGw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).p(0.0F, f4, f6, f7 - f4);
      }
      localObject = com.tencent.mm.plugin.multitask.animation.c.a.c.FGt;
      float f1 = com.tencent.mm.plugin.multitask.animation.c.a.c.faB() * f1 / f2;
      localObject = this.FGY.FGw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).a(f1, f1, f1, f1, f1, f1, f1, f1);
      }
      localObject = this.FGY.FGw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).setPivotX(k);
      }
      localObject = this.FGY.FGw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).setPivotY(m);
      }
      localObject = this.FGY.FGw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).setTranslationX(f3);
      }
      localObject = this.FGY.FGw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).setTranslationY(f5);
      }
      localObject = this.FGY.FGw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).setScaleX(f2);
      }
      localObject = this.FGY.FGw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).setScaleY(f2);
      }
      localObject = this.FGY.FGw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).postInvalidate();
      }
      Log.d("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", "touchX: %f, touchY: %f, dx: %d, dy: %d, transX: %f, transY: %f, scale: %f ", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(f3), Float.valueOf(f5), Float.valueOf(f2) });
      AppMethodBeat.o(248169);
    }
    
    public final int aEe()
    {
      return 1;
    }
    
    public final boolean b(View paramView, int paramInt)
    {
      AppMethodBeat.i(248159);
      paramView = this.FGY.FGv;
      if (paramView != null)
      {
        boolean bool = paramView.XX(paramInt);
        AppMethodBeat.o(248159);
        return bool;
      }
      AppMethodBeat.o(248159);
      return false;
    }
    
    public final void c(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(248162);
      if (this.lwF)
      {
        AppMethodBeat.o(248162);
        return;
      }
      if ((Math.abs(paramFloat1) > this.FGG) && (bA(0.0F)))
      {
        this.lwF = true;
        Log.i("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", "onViewReleased, auto add multitask!");
        AppMethodBeat.o(248162);
        return;
      }
      MMHandlerThread.postToMainThread((Runnable)new c(this));
      this.FGY.FGy = -1L;
      paramView = this.FGY.faC().getContentView();
      if (paramView != null)
      {
        paramView.setVisibility(0);
        AppMethodBeat.o(248162);
        return;
      }
      AppMethodBeat.o(248162);
    }
    
    public final void eG(boolean paramBoolean)
    {
      AppMethodBeat.i(248165);
      Log.d("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", "onComplete");
      AppMethodBeat.o(248165);
    }
    
    public final void faA()
    {
      AppMethodBeat.i(248166);
      Log.i("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", "onViewCaptured");
      a.a(this.FGY);
      this.FGC = -1;
      this.FGD = -1;
      this.lwF = false;
      AppMethodBeat.o(248166);
    }
    
    public final void l(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "value", "", "onUpdate", "com/tencent/mm/plugin/multitask/animation/swipeback/singlescene/MultiTaskSwipeBackAnimWrapperSS$ViewDragCallback$autoHide$1$1"})
    static final class a
      implements com.tencent.mm.ui.c.a.b.a
    {
      a(int paramInt1, int paramInt2, float paramFloat1, Rect paramRect, com.tencent.mm.plugin.multitask.animation.c.a.c paramc, int paramInt3, int paramInt4, a.b paramb, float paramFloat2) {}
      
      public final void bB(float paramFloat)
      {
        AppMethodBeat.i(247987);
        paramFloat = paramFloat + (1.0F - paramFloat) * paramFloat;
        float f1 = this.cLp;
        float f2 = (j * f1 - this.FGJ.height()) / 2.0F * paramFloat * (1.0F / f1);
        float f3 = j;
        localc.setPivotX(k);
        localc.setPivotY(m);
        localc.setMaskAlpha((int)(255.0F * paramFloat));
        localc.p(0.0F, f2, f1, f3 - f2);
        c.a locala = com.tencent.mm.plugin.multitask.animation.c.a.c.FGt;
        paramFloat = paramFloat * com.tencent.mm.plugin.multitask.animation.c.a.c.faB() / f1;
        localc.a(paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat);
        localc.postInvalidate();
        AppMethodBeat.o(247987);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/multitask/animation/swipeback/singlescene/MultiTaskSwipeBackAnimWrapperSS$ViewDragCallback$autoHide$1$2"})
    static final class b
      implements Runnable
    {
      b(Bitmap paramBitmap, a.b paramb, float paramFloat) {}
      
      public final void run()
      {
        AppMethodBeat.i(248769);
        MMHandlerThread.postToMainThread((Runnable)new Runnable()
        {
          public final void run()
          {
            Object localObject2 = null;
            AppMethodBeat.i(248669);
            Object localObject1 = this.FHa.FGZ.FGY.FGx;
            if (localObject1 != null) {
              ((com.tencent.mm.plugin.multitask.c.c)localObject1).h(this.FHa.cLr, 3);
            }
            if (this.FHa.FGZ.FGY.FGw != null)
            {
              localObject1 = this.FHa.FGZ.FGY.FGw;
              if (localObject1 != null) {
                localObject1 = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).getParent();
              }
              while (localObject1 != null)
              {
                com.tencent.mm.plugin.multitask.animation.c.a.c localc = this.FHa.FGZ.FGY.FGw;
                localObject1 = localObject2;
                if (localc != null) {
                  localObject1 = localc.getParent();
                }
                if (localObject1 == null)
                {
                  localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
                  AppMethodBeat.o(248669);
                  throw ((Throwable)localObject1);
                  localObject1 = null;
                }
                else
                {
                  ((ViewGroup)localObject1).removeView((View)this.FHa.FGZ.FGY.FGw);
                }
              }
            }
            AppMethodBeat.o(248669);
          }
        });
        AppMethodBeat.o(248769);
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
        AppMethodBeat.i(247989);
        if (this.FGZ.FGY.FGw != null)
        {
          Object localObject1 = this.FGZ.FGY.FGw;
          if (localObject1 != null) {
            localObject1 = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).getParent();
          }
          while (localObject1 != null)
          {
            com.tencent.mm.plugin.multitask.animation.c.a.c localc = this.FGZ.FGY.FGw;
            localObject1 = localObject2;
            if (localc != null) {
              localObject1 = localc.getParent();
            }
            if (localObject1 == null)
            {
              localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
              AppMethodBeat.o(247989);
              throw ((Throwable)localObject1);
              localObject1 = null;
            }
            else
            {
              ((ViewGroup)localObject1).removeView((View)this.FGZ.FGY.FGw);
            }
          }
        }
        AppMethodBeat.o(247989);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class d
      implements Runnable
    {
      d(a.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(249183);
        com.tencent.mm.plugin.multitask.c.c localc = this.FGZ.FGY.FGx;
        if (localc != null)
        {
          localObject = this.FGZ.FGY.FGw;
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).getContentBitmap();
            localc.h((Bitmap)localObject, 3);
          }
        }
        else
        {
          if (this.FGZ.FGY.FGw == null) {
            break label161;
          }
          localObject = this.FGZ.FGY.FGw;
          if (localObject == null) {
            break label131;
          }
          localObject = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).getParent();
          label81:
          if (localObject == null) {
            break label161;
          }
          localObject = this.FGZ.FGY.FGw;
          if (localObject == null) {
            break label136;
          }
        }
        label131:
        label136:
        for (Object localObject = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).getParent();; localObject = null)
        {
          if (localObject != null) {
            break label141;
          }
          localObject = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(249183);
          throw ((Throwable)localObject);
          localObject = null;
          break;
          localObject = null;
          break label81;
        }
        label141:
        ((ViewGroup)localObject).removeView((View)this.FGZ.FGY.FGw);
        label161:
        AppMethodBeat.o(249183);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(a parama, int paramInt, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(247696);
      Object localObject = this.FGY.FGv;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).FGo; localObject != null; localObject = null)
      {
        a.a(this.FGY, paramInt, paramBoolean, this.FGY.FGx);
        AppMethodBeat.o(247696);
        return;
      }
      if (this.FGY.FGx != null)
      {
        localObject = this.FGY.FGx;
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.multitask.c.c)localObject).Yb(paramInt);
          AppMethodBeat.o(247696);
          return;
        }
      }
      AppMethodBeat.o(247696);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "value", "", "onUpdate"})
  static final class d
    implements com.tencent.mm.ui.c.a.b.a
  {
    d(a parama, int paramInt1, int paramInt2, float paramFloat, Rect paramRect, int paramInt3, int paramInt4) {}
    
    public final void bB(float paramFloat)
    {
      AppMethodBeat.i(248578);
      float f1 = this.cLp;
      float f2 = (this.cLq * this.BdK - this.FGJ.height()) / 2.0F * paramFloat * (1.0F / this.BdK);
      float f3 = this.cLq;
      Object localObject = this.FGY.FGw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).setMaskAlpha((int)(255.0F * paramFloat));
      }
      localObject = this.FGY.FGw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).p(0.0F, f2, f1, f3 - f2);
      }
      localObject = com.tencent.mm.plugin.multitask.animation.c.a.c.FGt;
      paramFloat = com.tencent.mm.plugin.multitask.animation.c.a.c.faB() * paramFloat / this.BdK;
      localObject = this.FGY.FGw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).a(paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat);
      }
      localObject = this.FGY.FGw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).setPivotX(this.FGM);
      }
      localObject = this.FGY.FGw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).setPivotY(this.FGN);
      }
      localObject = this.FGY.FGw;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).postInvalidate();
        AppMethodBeat.o(248578);
        return;
      }
      AppMethodBeat.o(248578);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(a parama, com.tencent.mm.plugin.multitask.c.c paramc, Bitmap paramBitmap, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(248799);
      a.b(this.FGY);
      com.tencent.mm.plugin.multitask.c.c localc = this.FFN;
      if (localc != null)
      {
        localc.a(this.FGU, false, this.FGS);
        AppMethodBeat.o(248799);
        return;
      }
      AppMethodBeat.o(248799);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a parama, com.tencent.mm.plugin.multitask.c.c paramc, Bitmap paramBitmap, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(247738);
      this.FGY.FGA = false;
      MMHandlerThread.postToMainThread((Runnable)new Runnable()
      {
        public final void run()
        {
          Object localObject2 = null;
          AppMethodBeat.i(247594);
          Object localObject1 = this.FHc.FFN;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.multitask.c.c)localObject1).h(this.FHc.FFS, this.FHc.FGS);
          }
          if (this.FHc.FGY.FGw != null)
          {
            localObject1 = this.FHc.FGY.FGw;
            if (localObject1 != null) {
              localObject1 = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).getParent();
            }
            while (localObject1 != null)
            {
              com.tencent.mm.plugin.multitask.animation.c.a.c localc = this.FHc.FGY.FGw;
              localObject1 = localObject2;
              if (localc != null) {
                localObject1 = localc.getParent();
              }
              if (localObject1 == null)
              {
                localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(247594);
                throw ((Throwable)localObject1);
                localObject1 = null;
              }
              else
              {
                ((ViewGroup)localObject1).removeView((View)this.FHc.FGY.FGw);
              }
            }
          }
          AppMethodBeat.o(247594);
        }
      });
      AppMethodBeat.o(247738);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/animation/swipeback/singlescene/MultiTaskSwipeBackAnimWrapperSS$onCreate$1", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;", "canInterceptTouchEvent", "", "enableSwipeBack", "getSwipeBackTouchState", "", "onDispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onEdgeDragStarted", "edgeFlags", "pointerId", "onPositionChange", "scrollPercent", "", "onSwipeReleased", "willSwipeBack", "shouldInterceptTouchEvent", "ev", "plugin-multitask_release"})
  public static final class g
    implements com.tencent.mm.plugin.multitask.a.a.a
  {
    g(com.tencent.mm.plugin.multitask.b.b paramb) {}
    
    public final void XV(int paramInt) {}
    
    public final void by(float paramFloat) {}
    
    public final boolean fat()
    {
      AppMethodBeat.i(249176);
      boolean bool = paramb.faM();
      AppMethodBeat.o(249176);
      return bool;
    }
    
    public final int fau()
    {
      com.tencent.mm.plugin.multitask.animation.c.a.b localb = this.FGY.FGv;
      if (localb != null) {
        return localb.FGj;
      }
      return 0;
    }
    
    public final boolean fav()
    {
      AppMethodBeat.i(249182);
      a locala;
      if (this.FGY.FGy == -1L)
      {
        locala = this.FGY;
        localObject = paramb;
        if (localObject == null) {
          break label74;
        }
      }
      label74:
      for (Object localObject = Boolean.valueOf(((com.tencent.mm.plugin.multitask.b.b)localObject).faQ());; localObject = null)
      {
        locala.FGz = ((Boolean)localObject).booleanValue();
        this.FGY.FGy = 0L;
        boolean bool = this.FGY.FGz;
        AppMethodBeat.o(249182);
        return bool;
      }
    }
    
    public final boolean i(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(249180);
      p.k(paramMotionEvent, "ev");
      com.tencent.mm.plugin.multitask.animation.c.a.b localb = this.FGY.FGv;
      if (localb != null)
      {
        boolean bool = localb.i(paramMotionEvent);
        AppMethodBeat.o(249180);
        return bool;
      }
      AppMethodBeat.o(249180);
      return false;
    }
    
    public final void n(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(249174);
      p.k(paramMotionEvent, "event");
      com.tencent.mm.plugin.multitask.animation.c.a.b localb = this.FGY.FGv;
      if (localb != null)
      {
        localb.j(paramMotionEvent);
        AppMethodBeat.o(249174);
        return;
      }
      AppMethodBeat.o(249174);
    }
    
    public final int vm(boolean paramBoolean)
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.c.c.a
 * JD-Core Version:    0.7.0.1
 */