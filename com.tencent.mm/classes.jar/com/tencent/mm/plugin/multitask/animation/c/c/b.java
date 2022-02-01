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
import com.tencent.mm.plugin.multitask.a.a.a;
import com.tencent.mm.plugin.multitask.animation.c.a.c.a;
import com.tencent.mm.plugin.multitask.animation.c.a.c.b;
import com.tencent.mm.plugin.multitask.animation.c.a.d;
import com.tencent.mm.plugin.multitask.animation.c.a.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.k;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/animation/swipeback/singlescene/MultiTaskSwipeBackAnimWrapperSS;", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/BaseMultiTaskSwipeBackAnimWrapper;", "()V", "enableSwipeback", "", "getEnableSwipeback", "()Z", "setEnableSwipeback", "(Z)V", "isExitAnimating", "setExitAnimating", "mDragHelper", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "getMDragHelper", "()Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "setMDragHelper", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;)V", "mListener", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "getMListener", "()Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "setMListener", "(Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;)V", "multiTaskHelper", "Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "getMultiTaskHelper", "()Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "setMultiTaskHelper", "(Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;)V", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "getPageAdapter", "()Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "setPageAdapter", "(Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "swipeBackFlag", "", "getSwipeBackFlag", "()J", "setSwipeBackFlag", "(J)V", "swipeView", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/TransformSwipeBackToMultiTaskView;", "getSwipeView", "()Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/TransformSwipeBackToMultiTaskView;", "setSwipeView", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/TransformSwipeBackToMultiTaskView;)V", "doPrepareTransform", "", "way", "", "exitAnim", "init", "initMaskView", "enterAnim", "listener", "onCreate", "refreshPosition", "resetView", "startSwipeAnim", "Companion", "ViewDragCallback", "plugin-multitask_release"})
public final class b
  extends com.tencent.mm.plugin.multitask.animation.c.a.b
{
  public static final b.a Abj;
  private com.tencent.mm.plugin.multitask.b.b AaE;
  com.tencent.mm.plugin.multitask.animation.c.a.c AaG;
  d AaH;
  com.tencent.mm.plugin.multitask.c.c AaI;
  long AaJ = -1L;
  boolean AaK = true;
  boolean AaL;
  protected com.tencent.mm.plugin.multitask.a.a Aak;
  
  static
  {
    AppMethodBeat.i(200551);
    Abj = new b.a((byte)0);
    AppMethodBeat.o(200551);
  }
  
  private final void RJ(int paramInt)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    AppMethodBeat.i(200549);
    Object localObject1 = this.AaE;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.multitask.b.b)localObject1).RK(paramInt);
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
          localObject1 = ((Collection)new k(",").q((CharSequence)localObject1, 0)).toArray(new String[0]);
          if (localObject1 != null) {
            break label197;
          }
          localObject1 = new t("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(200549);
          throw ((Throwable)localObject1);
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", "refreshPosition, get pos failed, %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(200549);
          return;
        }
        Object localObject2 = null;
        break;
        label138:
        if (paramInt == 4)
        {
          localObject4 = this.AaE;
          localObject2 = localObject3;
          if (localObject4 != null) {
            localObject2 = ((com.tencent.mm.plugin.multitask.b.b)localObject4).eqQ();
          }
        }
        else
        {
          localObject3 = this.AaE;
          localObject2 = localObject4;
          if (localObject3 != null) {
            localObject2 = ((com.tencent.mm.plugin.multitask.b.b)localObject3).getPosition();
          }
          continue;
          label197:
          localObject3 = (String[])localObject2;
          if ((localObject3 != null) && (localObject3.length == 4))
          {
            localObject2 = this.AaG;
            if (localObject2 != null)
            {
              localObject4 = Integer.valueOf(localObject3[0]);
              p.g(localObject4, "Integer.valueOf(posVec[0])");
              paramInt = ((Integer)localObject4).intValue();
              localObject4 = Integer.valueOf(localObject3[1]);
              p.g(localObject4, "Integer.valueOf(posVec[1])");
              int i = ((Integer)localObject4).intValue();
              localObject4 = Integer.valueOf(localObject3[2]);
              p.g(localObject4, "Integer.valueOf(posVec[2])");
              int j = ((Integer)localObject4).intValue();
              localObject3 = Integer.valueOf(localObject3[3]);
              p.g(localObject3, "Integer.valueOf(posVec[3])");
              ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject2).m(new Rect(paramInt, i, j, ((Integer)localObject3).intValue()));
              AppMethodBeat.o(200549);
              return;
            }
          }
          AppMethodBeat.o(200549);
          return;
        }
      }
    }
    AppMethodBeat.o(200549);
  }
  
  private final void aJ(final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(200548);
    Object localObject = this.Aak;
    if (localObject == null) {
      p.btv("pageAdapter");
    }
    if (((com.tencent.mm.plugin.multitask.a.a)localObject).bCI())
    {
      localObject = this.Aak;
      if (localObject == null) {
        p.btv("pageAdapter");
      }
      if (((com.tencent.mm.plugin.multitask.a.a)localObject).bPv())
      {
        localObject = this.Aak;
        if (localObject == null) {
          p.btv("pageAdapter");
        }
        ((com.tencent.mm.plugin.multitask.a.a)localObject).a(null);
      }
      MMHandlerThread.postToMainThread((Runnable)new c(this, paramInt, paramBoolean));
      AppMethodBeat.o(200548);
      return;
    }
    if (this.AaI != null)
    {
      localObject = this.AaI;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.multitask.c.c)localObject).RL(paramInt);
        AppMethodBeat.o(200548);
        return;
      }
    }
    AppMethodBeat.o(200548);
  }
  
  private final void eqM()
  {
    AppMethodBeat.i(200550);
    d locald = this.AaH;
    if (locald != null) {
      locald.setTranslationX(0.0F);
    }
    locald = this.AaH;
    if (locald != null) {
      locald.setTranslationY(0.0F);
    }
    locald = this.AaH;
    if (locald != null) {
      locald.setScaleX(1.0F);
    }
    locald = this.AaH;
    if (locald != null)
    {
      locald.setScaleY(1.0F);
      AppMethodBeat.o(200550);
      return;
    }
    AppMethodBeat.o(200550);
  }
  
  public final void RG(int paramInt)
  {
    AppMethodBeat.i(200547);
    aJ(paramInt, true);
    AppMethodBeat.o(200547);
  }
  
  public final void a(com.tencent.mm.plugin.multitask.a.a parama, final com.tencent.mm.plugin.multitask.b.b paramb, com.tencent.mm.plugin.multitask.c.c paramc)
  {
    AppMethodBeat.i(200546);
    p.h(parama, "pageAdapter");
    p.h(paramb, "multiTaskHelper");
    this.Aak = parama;
    this.AaE = paramb;
    this.AaI = paramc;
    parama = this.Aak;
    if (parama == null) {
      p.btv("pageAdapter");
    }
    if (parama != null) {
      parama.a((a.a)new g(this, paramb));
    }
    parama = this.Aak;
    if (parama == null) {
      p.btv("pageAdapter");
    }
    parama = AnimationUtils.loadInterpolator((Context)parama.getActivity(), 2130772093);
    paramb = this.Aak;
    if (paramb == null) {
      p.btv("pageAdapter");
    }
    paramb = paramb.chG();
    if (paramb != null)
    {
      paramc = com.tencent.mm.plugin.multitask.animation.c.a.c.Aaz;
      paramc = (c.a)new b();
      p.g(parama, "interpolator");
      this.AaG = c.b.a(paramb, paramc, parama);
    }
    parama = this.AaG;
    if (parama != null) {
      parama.WJ = 1;
    }
    parama = this.Aak;
    if (parama == null) {
      p.btv("pageAdapter");
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
    for (float f = parama.density;; f = com.tencent.mm.cb.a.getDensity((Context)parama.getActivity()))
    {
      parama = this.AaG;
      if (parama != null) {
        parama.Aau = (100.0F * f);
      }
      parama = this.AaG;
      if (parama == null) {
        break;
      }
      parama.Aat = (f * 300.0F);
      AppMethodBeat.o(200546);
      return;
      parama = this.Aak;
      if (parama == null) {
        p.btv("pageAdapter");
      }
    }
    AppMethodBeat.o(200546);
  }
  
  protected final com.tencent.mm.plugin.multitask.a.a eqL()
  {
    AppMethodBeat.i(200545);
    com.tencent.mm.plugin.multitask.a.a locala = this.Aak;
    if (locala == null) {
      p.btv("pageAdapter");
    }
    AppMethodBeat.o(200545);
    return locala;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/animation/swipeback/singlescene/MultiTaskSwipeBackAnimWrapperSS$ViewDragCallback;", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Callback;", "Lcom/tencent/mm/ui/base/ActivityUtil$IConvertActivityTranslucentCallback;", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/singlescene/MultiTaskSwipeBackAnimWrapperSS;)V", "CONSTANT_X_VELOCITY", "", "getCONSTANT_X_VELOCITY", "()I", "isFinish", "", "()Z", "setFinish", "(Z)V", "mStartTransX", "getMStartTransX", "setMStartTransX", "(I)V", "mStartTransY", "getMStartTransY", "setMStartTransY", "mStartViewPosition", "Landroid/graphics/Rect;", "getMStartViewPosition", "()Landroid/graphics/Rect;", "setMStartViewPosition", "(Landroid/graphics/Rect;)V", "autoHide", "firstValue", "", "clampViewPositionHorizontal", "child", "Landroid/view/View;", "left", "dx", "getViewHorizontalDragRange", "onComplete", "", "drawComplete", "onViewCaptured", "capturedChild", "activePointerId", "onViewDragStateChanged", "state", "onViewPositionChanged", "changedView", "top", "dy", "onViewReleased", "releasedChild", "xvel", "yvel", "onViewTouchPositionChanged", "touchX", "touchY", "adx", "ady", "tryCaptureView", "view", "i", "plugin-multitask_release"})
  final class b
    extends c.a
    implements com.tencent.mm.ui.base.b.b
  {
    private int AaN = -1;
    private int AaO = -1;
    private Rect AaQ;
    private final int AaR = 400;
    private boolean iGD;
    
    private final boolean bx(final float paramFloat)
    {
      AppMethodBeat.i(200530);
      final d locald = this.Abk.AaH;
      Object localObject1 = this.Abk.AaH;
      if (localObject1 != null) {}
      for (localObject1 = ((d)localObject1).getContentBitmap(); (locald != null) && (localObject1 != null); localObject1 = null)
      {
        int i = (int)(((Bitmap)localObject1).getWidth() * 1.25F);
        final int j = (int)(((Bitmap)localObject1).getHeight() * 1.25F);
        Rect localRect2 = new Rect(0, 0, i, j);
        Object localObject2 = this.Abk.AaG;
        if (localObject2 != null)
        {
          Rect localRect1 = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject2).Aay;
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
        com.tencent.mm.ui.c.a.a.gu((View)locald).a((com.tencent.mm.ui.c.a.b.a)new a(i, j, f1, (Rect)localObject2, locald, k, m, this, paramFloat)).aJ((Runnable)new b((Bitmap)localObject1, this, paramFloat)).cp(f1).cq(f1).cn(f2 * f1).co(f3 * f1).c((Interpolator)new AccelerateInterpolator()).gKg().start();
        AppMethodBeat.o(200530);
        return true;
      }
      AppMethodBeat.o(200530);
      return false;
    }
    
    public final void L(int paramInt)
    {
      AppMethodBeat.i(200532);
      Log.d("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", "onViewDragStateChanged, state:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(200532);
    }
    
    public final int RI(int paramInt)
    {
      return 0;
    }
    
    public final void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(200535);
      if (this.Abk.AaH != null)
      {
        localObject = this.Abk.AaH;
        if ((localObject == null) || (((d)localObject).getWidth() != 0))
        {
          localObject = this.Abk.AaG;
          if (localObject == null) {
            break label69;
          }
        }
      }
      label69:
      for (Object localObject = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).Aay; localObject == null; localObject = null)
      {
        AppMethodBeat.o(200535);
        return;
      }
      localObject = this.Abk.AaH;
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
        paramInt3 = ((d)localObject).getWidth();
        localObject = this.Abk.AaH;
        if (localObject == null) {
          break label553;
        }
        paramInt4 = ((d)localObject).getHeight();
        if (this.AaQ == null) {
          this.AaQ = com.tencent.mm.plugin.multitask.f.c.eA((View)this.Abk.AaH);
        }
        if ((this.AaN == -1) && (this.AaO == -1))
        {
          localObject = this.Abk.AaH;
          if (localObject == null) {
            break label559;
          }
          i = (int)((d)localObject).getTranslationX();
          this.AaN = i;
          localObject = this.Abk.AaH;
          if (localObject == null) {
            break label565;
          }
          i = (int)((d)localObject).getTranslationY();
          this.AaO = i;
        }
        f2 = paramFloat1 / paramInt3 / 3.0F;
        localObject = this.Abk.AaG;
        if (localObject != null)
        {
          localRect = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).Aay;
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
        localRect = this.AaQ;
        if (localRect == null) {
          break label608;
        }
        i = localRect.left;
        localRect = this.AaQ;
        if (localRect == null) {
          break label614;
        }
        j = localRect.width();
        label398:
        f7 = i + j / 2;
        f5 = m;
        localRect = this.AaQ;
        if (localRect == null) {
          break label620;
        }
        i = localRect.top;
        label431:
        localRect = this.AaQ;
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
        f3 = this.AaN + (f3 - f7) * f4 * f1;
        f5 = this.AaO + (f5 - f6) * f4 * f1;
        if ((f1 < 0.16F) || (this.iGD)) {
          break label632;
        }
        this.iGD = true;
        if (!bx(f1)) {
          MMHandlerThread.postToMainThread((Runnable)new d(this));
        }
        AppMethodBeat.o(200535);
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
      localObject = this.Abk.AaH;
      if (localObject != null) {
        ((d)localObject).setMaskAlpha((int)(255.0F * f1));
      }
      localObject = this.Abk.AaH;
      if (localObject != null) {
        ((d)localObject).o(0.0F, f4, f6, f7 - f4);
      }
      localObject = d.AaD;
      float f1 = d.eqK() * f1 / f2;
      localObject = this.Abk.AaH;
      if (localObject != null) {
        ((d)localObject).a(f1, f1, f1, f1, f1, f1, f1, f1);
      }
      localObject = this.Abk.AaH;
      if (localObject != null) {
        ((d)localObject).setPivotX(k);
      }
      localObject = this.Abk.AaH;
      if (localObject != null) {
        ((d)localObject).setPivotY(m);
      }
      localObject = this.Abk.AaH;
      if (localObject != null) {
        ((d)localObject).setTranslationX(f3);
      }
      localObject = this.Abk.AaH;
      if (localObject != null) {
        ((d)localObject).setTranslationY(f5);
      }
      localObject = this.Abk.AaH;
      if (localObject != null) {
        ((d)localObject).setScaleX(f2);
      }
      localObject = this.Abk.AaH;
      if (localObject != null) {
        ((d)localObject).setScaleY(f2);
      }
      localObject = this.Abk.AaH;
      if (localObject != null) {
        ((d)localObject).postInvalidate();
      }
      Log.d("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", "touchX: %f, touchY: %f, dx: %d, dy: %d, transX: %f, transY: %f, scale: %f ", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(f3), Float.valueOf(f5), Float.valueOf(f2) });
      AppMethodBeat.o(200535);
    }
    
    public final int awM()
    {
      return 1;
    }
    
    public final void b(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(200531);
      if (this.iGD)
      {
        AppMethodBeat.o(200531);
        return;
      }
      if ((Math.abs(paramFloat1) > this.AaR) && (bx(0.0F)))
      {
        this.iGD = true;
        Log.i("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", "onViewReleased, auto add multitask!");
        AppMethodBeat.o(200531);
        return;
      }
      MMHandlerThread.postToMainThread((Runnable)new c(this));
      this.Abk.AaJ = -1L;
      paramView = this.Abk.eqL().getContentView();
      if (paramView != null)
      {
        paramView.setVisibility(0);
        AppMethodBeat.o(200531);
        return;
      }
      AppMethodBeat.o(200531);
    }
    
    public final boolean c(View paramView, int paramInt)
    {
      AppMethodBeat.i(200529);
      paramView = this.Abk.AaG;
      if (paramView != null)
      {
        boolean bool = paramView.RH(paramInt);
        AppMethodBeat.o(200529);
        return bool;
      }
      AppMethodBeat.o(200529);
      return false;
    }
    
    public final void ei(boolean paramBoolean)
    {
      AppMethodBeat.i(200533);
      Log.d("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", "onComplete");
      AppMethodBeat.o(200533);
    }
    
    public final void eqJ()
    {
      AppMethodBeat.i(200534);
      Log.i("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", "onViewCaptured");
      b.a(this.Abk);
      this.AaN = -1;
      this.AaO = -1;
      this.iGD = false;
      AppMethodBeat.o(200534);
    }
    
    public final void l(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "value", "", "onUpdate", "com/tencent/mm/plugin/multitask/animation/swipeback/singlescene/MultiTaskSwipeBackAnimWrapperSS$ViewDragCallback$autoHide$1$1"})
    static final class a
      implements com.tencent.mm.ui.c.a.b.a
    {
      a(int paramInt1, int paramInt2, float paramFloat1, Rect paramRect, d paramd, int paramInt3, int paramInt4, b.b paramb, float paramFloat2) {}
      
      public final void by(float paramFloat)
      {
        AppMethodBeat.i(200524);
        paramFloat = paramFloat + (1.0F - paramFloat) * paramFloat;
        float f1 = this.cKE;
        float f2 = (j * f1 - this.AaU.height()) / 2.0F * paramFloat * (1.0F / f1);
        float f3 = j;
        locald.setPivotX(k);
        locald.setPivotY(m);
        locald.setMaskAlpha((int)(255.0F * paramFloat));
        locald.o(0.0F, f2, f1, f3 - f2);
        d.a locala = d.AaD;
        paramFloat = paramFloat * d.eqK() / f1;
        locald.a(paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat);
        locald.postInvalidate();
        AppMethodBeat.o(200524);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/multitask/animation/swipeback/singlescene/MultiTaskSwipeBackAnimWrapperSS$ViewDragCallback$autoHide$1$2"})
    static final class b
      implements Runnable
    {
      b(Bitmap paramBitmap, b.b paramb, float paramFloat) {}
      
      public final void run()
      {
        AppMethodBeat.i(200526);
        MMHandlerThread.postToMainThread((Runnable)new Runnable()
        {
          public final void run()
          {
            Object localObject2 = null;
            AppMethodBeat.i(200525);
            Object localObject1 = this.Abm.Abl.Abk.AaI;
            if (localObject1 != null) {
              ((com.tencent.mm.plugin.multitask.c.c)localObject1).g(this.Abm.cKG, 3);
            }
            if (this.Abm.Abl.Abk.AaH != null)
            {
              localObject1 = this.Abm.Abl.Abk.AaH;
              if (localObject1 != null) {
                localObject1 = ((d)localObject1).getParent();
              }
              while (localObject1 != null)
              {
                d locald = this.Abm.Abl.Abk.AaH;
                localObject1 = localObject2;
                if (locald != null) {
                  localObject1 = locald.getParent();
                }
                if (localObject1 == null)
                {
                  localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
                  AppMethodBeat.o(200525);
                  throw ((Throwable)localObject1);
                  localObject1 = null;
                }
                else
                {
                  ((ViewGroup)localObject1).removeView((View)this.Abm.Abl.Abk.AaH);
                }
              }
            }
            AppMethodBeat.o(200525);
          }
        });
        AppMethodBeat.o(200526);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class c
      implements Runnable
    {
      c(b.b paramb) {}
      
      public final void run()
      {
        Object localObject2 = null;
        AppMethodBeat.i(200527);
        if (this.Abl.Abk.AaH != null)
        {
          Object localObject1 = this.Abl.Abk.AaH;
          if (localObject1 != null) {
            localObject1 = ((d)localObject1).getParent();
          }
          while (localObject1 != null)
          {
            d locald = this.Abl.Abk.AaH;
            localObject1 = localObject2;
            if (locald != null) {
              localObject1 = locald.getParent();
            }
            if (localObject1 == null)
            {
              localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
              AppMethodBeat.o(200527);
              throw ((Throwable)localObject1);
              localObject1 = null;
            }
            else
            {
              ((ViewGroup)localObject1).removeView((View)this.Abl.Abk.AaH);
            }
          }
        }
        AppMethodBeat.o(200527);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class d
      implements Runnable
    {
      d(b.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(200528);
        com.tencent.mm.plugin.multitask.c.c localc = this.Abl.Abk.AaI;
        if (localc != null)
        {
          localObject = this.Abl.Abk.AaH;
          if (localObject != null)
          {
            localObject = ((d)localObject).getContentBitmap();
            localc.g((Bitmap)localObject, 3);
          }
        }
        else
        {
          if (this.Abl.Abk.AaH == null) {
            break label161;
          }
          localObject = this.Abl.Abk.AaH;
          if (localObject == null) {
            break label131;
          }
          localObject = ((d)localObject).getParent();
          label81:
          if (localObject == null) {
            break label161;
          }
          localObject = this.Abl.Abk.AaH;
          if (localObject == null) {
            break label136;
          }
        }
        label131:
        label136:
        for (Object localObject = ((d)localObject).getParent();; localObject = null)
        {
          if (localObject != null) {
            break label141;
          }
          localObject = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(200528);
          throw ((Throwable)localObject);
          localObject = null;
          break;
          localObject = null;
          break label81;
        }
        label141:
        ((ViewGroup)localObject).removeView((View)this.Abl.Abk.AaH);
        label161:
        AppMethodBeat.o(200528);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(b paramb, int paramInt, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(200536);
      Object localObject = this.Abk.AaG;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).Aay; localObject != null; localObject = null)
      {
        b.a(this.Abk, paramInt, paramBoolean, this.Abk.AaI);
        AppMethodBeat.o(200536);
        return;
      }
      if (this.Abk.AaI != null)
      {
        localObject = this.Abk.AaI;
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.multitask.c.c)localObject).RL(paramInt);
          AppMethodBeat.o(200536);
          return;
        }
      }
      AppMethodBeat.o(200536);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "value", "", "onUpdate"})
  static final class d
    implements com.tencent.mm.ui.c.a.b.a
  {
    d(b paramb, int paramInt1, int paramInt2, float paramFloat, Rect paramRect, int paramInt3, int paramInt4) {}
    
    public final void by(float paramFloat)
    {
      AppMethodBeat.i(200537);
      float f1 = this.cKE;
      float f2 = (this.cKF * this.wrG - this.AaU.height()) / 2.0F * paramFloat * (1.0F / this.wrG);
      float f3 = this.cKF;
      Object localObject = this.Abk.AaH;
      if (localObject != null) {
        ((d)localObject).setMaskAlpha((int)(255.0F * paramFloat));
      }
      localObject = this.Abk.AaH;
      if (localObject != null) {
        ((d)localObject).o(0.0F, f2, f1, f3 - f2);
      }
      localObject = d.AaD;
      paramFloat = d.eqK() * paramFloat / this.wrG;
      localObject = this.Abk.AaH;
      if (localObject != null) {
        ((d)localObject).a(paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat);
      }
      localObject = this.Abk.AaH;
      if (localObject != null) {
        ((d)localObject).setPivotX(this.AaX);
      }
      localObject = this.Abk.AaH;
      if (localObject != null) {
        ((d)localObject).setPivotY(this.AaY);
      }
      localObject = this.Abk.AaH;
      if (localObject != null)
      {
        ((d)localObject).postInvalidate();
        AppMethodBeat.o(200537);
        return;
      }
      AppMethodBeat.o(200537);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(b paramb, com.tencent.mm.plugin.multitask.c.c paramc, Bitmap paramBitmap, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(200538);
      b.b(this.Abk);
      com.tencent.mm.plugin.multitask.c.c localc = this.zZX;
      if (localc != null)
      {
        localc.a(this.Abf, false, this.Abd);
        AppMethodBeat.o(200538);
        return;
      }
      AppMethodBeat.o(200538);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(b paramb, com.tencent.mm.plugin.multitask.c.c paramc, Bitmap paramBitmap, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(200540);
      this.Abk.AaL = false;
      MMHandlerThread.postToMainThread((Runnable)new Runnable()
      {
        public final void run()
        {
          Object localObject2 = null;
          AppMethodBeat.i(200539);
          Object localObject1 = this.Abo.zZX;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.multitask.c.c)localObject1).g(this.Abo.Aac, this.Abo.Abd);
          }
          if (this.Abo.Abk.AaH != null)
          {
            localObject1 = this.Abo.Abk.AaH;
            if (localObject1 != null) {
              localObject1 = ((d)localObject1).getParent();
            }
            while (localObject1 != null)
            {
              d locald = this.Abo.Abk.AaH;
              localObject1 = localObject2;
              if (locald != null) {
                localObject1 = locald.getParent();
              }
              if (localObject1 == null)
              {
                localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(200539);
                throw ((Throwable)localObject1);
                localObject1 = null;
              }
              else
              {
                ((ViewGroup)localObject1).removeView((View)this.Abo.Abk.AaH);
              }
            }
          }
          AppMethodBeat.o(200539);
        }
      });
      AppMethodBeat.o(200540);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/animation/swipeback/singlescene/MultiTaskSwipeBackAnimWrapperSS$onCreate$1", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;", "canInterceptTouchEvent", "", "enableSwipeBack", "getSwipeBackTouchState", "", "onDispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onEdgeDragStarted", "edgeFlags", "pointerId", "onPositionChange", "scrollPercent", "", "onSwipeReleased", "willSwipeBack", "shouldInterceptTouchEvent", "ev", "plugin-multitask_release"})
  public static final class g
    implements a.a
  {
    g(com.tencent.mm.plugin.multitask.b.b paramb) {}
    
    public final void RF(int paramInt) {}
    
    public final void aY(float paramFloat) {}
    
    public final boolean eqD()
    {
      AppMethodBeat.i(200542);
      boolean bool = paramb.eqS();
      AppMethodBeat.o(200542);
      return bool;
    }
    
    public final int eqE()
    {
      com.tencent.mm.plugin.multitask.animation.c.a.c localc = this.Abk.AaG;
      if (localc != null) {
        return localc.Aas;
      }
      return 0;
    }
    
    public final boolean eqF()
    {
      AppMethodBeat.i(200544);
      b localb;
      if (this.Abk.AaJ == -1L)
      {
        localb = this.Abk;
        localObject = paramb;
        if (localObject == null) {
          break label74;
        }
      }
      label74:
      for (Object localObject = Boolean.valueOf(((com.tencent.mm.plugin.multitask.b.b)localObject).eqW());; localObject = null)
      {
        localb.AaK = ((Boolean)localObject).booleanValue();
        this.Abk.AaJ = 0L;
        boolean bool = this.Abk.AaK;
        AppMethodBeat.o(200544);
        return bool;
      }
    }
    
    public final boolean j(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(200543);
      p.h(paramMotionEvent, "ev");
      com.tencent.mm.plugin.multitask.animation.c.a.c localc = this.Abk.AaG;
      if (localc != null)
      {
        boolean bool = localc.j(paramMotionEvent);
        AppMethodBeat.o(200543);
        return bool;
      }
      AppMethodBeat.o(200543);
      return false;
    }
    
    public final int jJ(boolean paramBoolean)
    {
      return 0;
    }
    
    public final void n(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(200541);
      p.h(paramMotionEvent, "event");
      com.tencent.mm.plugin.multitask.animation.c.a.c localc = this.Abk.AaG;
      if (localc != null)
      {
        localc.k(paramMotionEvent);
        AppMethodBeat.o(200541);
        return;
      }
      AppMethodBeat.o(200541);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.c.c.b
 * JD-Core Version:    0.7.0.1
 */