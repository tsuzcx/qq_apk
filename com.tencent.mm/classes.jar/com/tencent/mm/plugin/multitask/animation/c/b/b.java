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
import com.tencent.mm.plugin.multitask.a.a.a;
import com.tencent.mm.plugin.multitask.a.a.b;
import com.tencent.mm.plugin.multitask.animation.c.a.c.a;
import com.tencent.mm.plugin.multitask.animation.c.a.c.b;
import com.tencent.mm.plugin.multitask.animation.c.a.d;
import com.tencent.mm.plugin.multitask.animation.c.a.d.a;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.protocal.protobuf.ffq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.k;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/animation/swipeback/multiscene/MultiTaskSwipeBackAnimWrapperMS;", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/BaseMultiTaskSwipeBackAnimWrapper;", "()V", "enableSwipeback", "", "getEnableSwipeback", "()Z", "setEnableSwipeback", "(Z)V", "isExitAnimating", "setExitAnimating", "mDragHelper", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "getMDragHelper", "()Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "setMDragHelper", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;)V", "mListener", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "getMListener", "()Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "setMListener", "(Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;)V", "multiTaskHelper", "Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "getMultiTaskHelper", "()Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "setMultiTaskHelper", "(Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;)V", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "getPageAdapter", "()Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "setPageAdapter", "(Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "swipeBackFlag", "", "getSwipeBackFlag", "()J", "setSwipeBackFlag", "(J)V", "swipeView", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/TransformSwipeBackToMultiTaskView;", "getSwipeView", "()Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/TransformSwipeBackToMultiTaskView;", "setSwipeView", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/TransformSwipeBackToMultiTaskView;)V", "doPrepareTransform", "", "way", "", "anim", "delay", "init", "initMaskView", "listener", "onCreate", "refreshPosition", "startSwipeAnim", "Companion", "ViewDragCallback", "plugin-multitask_release"})
public final class b
  extends com.tencent.mm.plugin.multitask.animation.c.a.b
{
  public static final b.a AaM;
  com.tencent.mm.plugin.multitask.b.b AaE;
  com.tencent.mm.plugin.multitask.animation.c.a.c AaG;
  d AaH;
  com.tencent.mm.plugin.multitask.c.c AaI;
  long AaJ = -1L;
  boolean AaK = true;
  boolean AaL;
  protected com.tencent.mm.plugin.multitask.a.a Aak;
  
  static
  {
    AppMethodBeat.i(200519);
    AaM = new b.a((byte)0);
    AppMethodBeat.o(200519);
  }
  
  private final void RJ(int paramInt)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    AppMethodBeat.i(200516);
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
          AppMethodBeat.o(200516);
          throw ((Throwable)localObject1);
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "refreshPosition, get pos failed, %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(200516);
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
              AppMethodBeat.o(200516);
              return;
            }
          }
          AppMethodBeat.o(200516);
          return;
        }
      }
    }
    AppMethodBeat.o(200516);
  }
  
  private final void a(final int paramInt, final boolean paramBoolean, final com.tencent.mm.plugin.multitask.c.c paramc)
  {
    AppMethodBeat.i(200518);
    Log.i("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "initMaskView, way:%d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject1 = this.Aak;
    if (localObject1 == null) {
      p.btv("pageAdapter");
    }
    if (((com.tencent.mm.plugin.multitask.a.a)localObject1).getMaskView() == null)
    {
      Log.w("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "doMaskAnimation, page mask view is null");
      if (paramc != null)
      {
        paramc.RL(paramInt);
        AppMethodBeat.o(200518);
        return;
      }
      AppMethodBeat.o(200518);
      return;
    }
    localObject1 = this.Aak;
    if (localObject1 == null) {
      p.btv("pageAdapter");
    }
    if (((com.tencent.mm.plugin.multitask.a.a)localObject1).getContentView() == null)
    {
      Log.w("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "doMaskAnimation, page content view is null");
      if (paramc != null)
      {
        paramc.RL(paramInt);
        AppMethodBeat.o(200518);
        return;
      }
      AppMethodBeat.o(200518);
      return;
    }
    localObject1 = this.Aak;
    if (localObject1 == null) {
      p.btv("pageAdapter");
    }
    if (((com.tencent.mm.plugin.multitask.a.a)localObject1).chG() == null)
    {
      Log.w("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "doMaskAnimation, page root view is null");
      if (paramc != null)
      {
        paramc.RL(paramInt);
        AppMethodBeat.o(200518);
        return;
      }
      AppMethodBeat.o(200518);
      return;
    }
    if (this.AaL)
    {
      Log.w("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "isExitAnimating now!");
      AppMethodBeat.o(200518);
      return;
    }
    if (this.Aak == null) {
      p.btv("pageAdapter");
    }
    localObject1 = this.Aak;
    if (localObject1 == null) {
      p.btv("pageAdapter");
    }
    final Bitmap localBitmap = ((com.tencent.mm.plugin.multitask.a.a)localObject1).getBitmap();
    if ((localBitmap == null) || (localBitmap.isRecycled()) || (localBitmap.getWidth() == 0) || (localBitmap.getHeight() == 0))
    {
      Log.w("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "doMaskAnimation, page get bitmap is null");
      if (paramc != null)
      {
        paramc.RL(paramInt);
        AppMethodBeat.o(200518);
        return;
      }
      AppMethodBeat.o(200518);
      return;
    }
    if (this.AaH != null)
    {
      localObject1 = this.AaH;
      if (localObject1 == null) {
        break label874;
      }
      localObject1 = ((d)localObject1).getParent();
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = this.Aak;
      if (localObject1 == null) {
        p.btv("pageAdapter");
      }
      this.AaH = new d((Context)((com.tencent.mm.plugin.multitask.a.a)localObject1).getActivity(), localBitmap);
      localObject1 = this.AaH;
      if (localObject1 != null) {
        ((d)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      }
      localObject1 = this.Aak;
      if (localObject1 == null) {
        p.btv("pageAdapter");
      }
      localObject1 = ((com.tencent.mm.plugin.multitask.a.a)localObject1).chG();
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setBackgroundColor(0);
      }
      if (localObject1 != null) {
        ((ViewGroup)localObject1).addView((View)this.AaH, ((ViewGroup)localObject1).getChildCount());
      }
    }
    RJ(paramInt);
    localObject1 = this.Aak;
    if (localObject1 == null) {
      p.btv("pageAdapter");
    }
    localObject1 = ((com.tencent.mm.plugin.multitask.a.a)localObject1).getContentView();
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(8);
    }
    if (paramBoolean)
    {
      localObject1 = this.AaE;
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
        paramBoolean = ((com.tencent.mm.plugin.multitask.b.b)localObject1).eqP();
        if (!paramBoolean) {
          break label885;
        }
        i = 90;
        this.AaL = true;
        j = (int)(localBitmap.getWidth() * 1.25F);
        k = (int)(localBitmap.getHeight() * 1.25F);
        localRect = new Rect(0, 0, j, k);
        localObject1 = this.AaG;
        if (localObject1 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).Aay;
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
          break label891;
        }
        f1 = ((Rect)localObject1).height() / k;
        label673:
        if (!paramBoolean) {
          break label906;
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
          localObject2 = this.AaH;
          if (localObject2 != null) {
            ((d)localObject2).setGradientOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
          }
        }
        com.tencent.mm.ui.c.a.a.gu((View)this.AaH).cn(f2 * f1).co(f3 * f1).cp(f1).cq(f1).a((com.tencent.mm.ui.c.a.b.a)new d(this, paramBoolean, j, k, f1, (Rect)localObject1, m, n, i)).c((Interpolator)new AccelerateInterpolator()).aK((Runnable)new e(this, paramc, localBitmap, paramInt)).aJ((Runnable)new f(this, paramc, localBitmap, paramInt)).gKg().start();
        AppMethodBeat.o(200518);
        return;
        label874:
        localObject1 = null;
        break;
        paramBoolean = false;
        break label537;
        label885:
        i = 0;
        break label545;
        label891:
        f1 = ((Rect)localObject1).width() / j;
        break label673;
        label906:
        ((Rect)localObject1).width();
      }
    }
    if (paramc != null)
    {
      localObject1 = this.AaH;
      if (localObject1 != null) {}
      for (localObject1 = ((d)localObject1).getContentBitmap();; localObject1 = null)
      {
        paramc.a((Bitmap)localObject1, true, paramInt);
        AppMethodBeat.o(200518);
        return;
      }
    }
    AppMethodBeat.o(200518);
  }
  
  private final void h(final int paramInt, final boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(200517);
    Object localObject = this.Aak;
    if (localObject == null) {
      p.btv("pageAdapter");
    }
    if (((com.tencent.mm.plugin.multitask.a.a)localObject).bCI())
    {
      if (MMHandlerThread.isMainThread())
      {
        localObject = this.Aak;
        if (localObject == null) {
          p.btv("pageAdapter");
        }
        ((com.tencent.mm.plugin.multitask.a.a)localObject).a((a.b)new c(this));
        if (paramBoolean2)
        {
          MMHandlerThread.postToMainThread((Runnable)new h(this, paramInt, paramBoolean1));
          AppMethodBeat.o(200517);
          return;
        }
        localObject = this.AaG;
        if (localObject != null) {}
        for (localObject = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).Aay; localObject != null; localObject = null)
        {
          a(paramInt, paramBoolean1, this.AaI);
          AppMethodBeat.o(200517);
          return;
        }
        if (this.AaI != null)
        {
          localObject = this.AaI;
          if (localObject != null)
          {
            ((com.tencent.mm.plugin.multitask.c.c)localObject).RL(paramInt);
            AppMethodBeat.o(200517);
            return;
          }
        }
        AppMethodBeat.o(200517);
        return;
      }
      if (this.AaI != null)
      {
        localObject = this.AaI;
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.multitask.c.c)localObject).RL(paramInt);
          AppMethodBeat.o(200517);
          return;
        }
      }
      AppMethodBeat.o(200517);
      return;
    }
    if (this.AaI != null)
    {
      localObject = this.AaI;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.multitask.c.c)localObject).RL(paramInt);
        AppMethodBeat.o(200517);
        return;
      }
    }
    AppMethodBeat.o(200517);
  }
  
  public final void RG(int paramInt)
  {
    AppMethodBeat.i(200515);
    h(paramInt, true, true);
    AppMethodBeat.o(200515);
  }
  
  public final void a(com.tencent.mm.plugin.multitask.a.a parama, final com.tencent.mm.plugin.multitask.b.b paramb, com.tencent.mm.plugin.multitask.c.c paramc)
  {
    AppMethodBeat.i(200514);
    p.h(parama, "pageAdapter");
    p.h(paramb, "multiTaskHelper");
    this.Aak = parama;
    this.AaE = paramb;
    this.AaI = paramc;
    parama = this.Aak;
    if (parama == null) {
      p.btv("pageAdapter");
    }
    parama.a((a.a)new g(this, paramb));
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
      AppMethodBeat.o(200514);
      return;
      parama = this.Aak;
      if (parama == null) {
        p.btv("pageAdapter");
      }
    }
    AppMethodBeat.o(200514);
  }
  
  protected final com.tencent.mm.plugin.multitask.a.a eqL()
  {
    AppMethodBeat.i(200513);
    com.tencent.mm.plugin.multitask.a.a locala = this.Aak;
    if (locala == null) {
      p.btv("pageAdapter");
    }
    AppMethodBeat.o(200513);
    return locala;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/animation/swipeback/multiscene/MultiTaskSwipeBackAnimWrapperMS$ViewDragCallback;", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Callback;", "Lcom/tencent/mm/ui/base/ActivityUtil$IConvertActivityTranslucentCallback;", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/multiscene/MultiTaskSwipeBackAnimWrapperMS;)V", "CONSTANT_X_VELOCITY", "", "getCONSTANT_X_VELOCITY", "()I", "isFinish", "", "()Z", "setFinish", "(Z)V", "mFractor", "", "getMFractor", "()F", "setMFractor", "(F)V", "mStartTransX", "getMStartTransX", "setMStartTransX", "(I)V", "mStartTransY", "getMStartTransY", "setMStartTransY", "mStartViewPosition", "Landroid/graphics/Rect;", "getMStartViewPosition", "()Landroid/graphics/Rect;", "setMStartViewPosition", "(Landroid/graphics/Rect;)V", "autoHide", "firstValue", "clampViewPositionHorizontal", "child", "Landroid/view/View;", "left", "dx", "getViewHorizontalDragRange", "onComplete", "", "drawComplete", "onViewCaptured", "capturedChild", "activePointerId", "onViewDragStateChanged", "state", "onViewPositionChanged", "changedView", "top", "dy", "onViewReleased", "releasedChild", "xvel", "yvel", "onViewTouchPositionChanged", "touchX", "touchY", "adx", "ady", "tryCaptureView", "view", "i", "plugin-multitask_release"})
  final class b
    extends c.a
    implements com.tencent.mm.ui.base.b.b
  {
    private int AaN = -1;
    private int AaO = -1;
    private float AaP;
    private Rect AaQ;
    private final int AaR = 400;
    private boolean iGD;
    
    private final boolean bx(final float paramFloat)
    {
      AppMethodBeat.i(200498);
      final d locald = this.AaS.AaH;
      Object localObject1 = this.AaS.AaH;
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
        localObject1 = ((d)localObject1).getContentBitmap();
        if ((locald == null) || (localObject1 == null)) {
          break label426;
        }
        localObject2 = this.AaS.AaE;
        if (localObject2 == null) {
          break label386;
        }
        bool = ((com.tencent.mm.plugin.multitask.b.b)localObject2).eqP();
        j = (int)(((Bitmap)localObject1).getWidth() * 1.25F);
        k = (int)(((Bitmap)localObject1).getHeight() * 1.25F);
        Rect localRect2 = new Rect(0, 0, j, k);
        localObject2 = this.AaS.AaG;
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
        m = ((Rect)localObject2).left + ((Rect)localObject2).width() / 2;
        n = ((Rect)localObject2).top + ((Rect)localObject2).height() / 2;
        if (!bool) {
          break label392;
        }
        f1 = ((Rect)localObject2).width() / k;
        if (!bool) {
          break label406;
        }
        f2 = ((Rect)localObject2).height() / j;
        f3 = m - (localRect2.left + localRect2.width() / 2);
        i = localRect2.top;
        f4 = n - (localRect2.height() / 2 + i);
        if (!bool) {
          break label420;
        }
      }
      label386:
      label392:
      label406:
      label420:
      for (final int i = 90;; i = 0)
      {
        if (bool) {
          locald.setGradientOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        com.tencent.mm.ui.c.a.a.gu((View)locald).a((com.tencent.mm.ui.c.a.b.a)new a(bool, j, k, f1, (Rect)localObject2, f2, locald, m, n, i, this, paramFloat)).aJ((Runnable)new b(locald, (Bitmap)localObject1, this, paramFloat)).cp(f1).cq(f1).cn(f3 * f1).co(f4 * f1).c((Interpolator)new AccelerateInterpolator()).gKg().start();
        AppMethodBeat.o(200498);
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
      label426:
      AppMethodBeat.o(200498);
      return false;
    }
    
    public final void L(int paramInt)
    {
      AppMethodBeat.i(200500);
      Log.d("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "onViewDragStateChanged, state:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(200500);
    }
    
    public final int RI(int paramInt)
    {
      return 0;
    }
    
    public final void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(200503);
      if (this.AaS.AaH != null)
      {
        localObject = this.AaS.AaH;
        if ((localObject == null) || (((d)localObject).getWidth() != 0))
        {
          localObject = this.AaS.AaG;
          if (localObject == null) {
            break label71;
          }
        }
      }
      label71:
      for (Object localObject = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).Aay; localObject == null; localObject = null)
      {
        AppMethodBeat.o(200503);
        return;
      }
      localObject = this.AaS.AaH;
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
        paramInt1 = ((d)localObject).getWidth();
        localObject = this.AaS.AaH;
        if (localObject == null) {
          break label522;
        }
        paramInt2 = ((d)localObject).getHeight();
        if (this.AaQ == null) {
          this.AaQ = com.tencent.mm.plugin.multitask.f.c.eA((View)this.AaS.AaH);
        }
        if ((this.AaN == -1) && (this.AaO == -1))
        {
          localObject = this.AaS.AaH;
          if (localObject == null) {
            break label528;
          }
          paramInt3 = (int)((d)localObject).getTranslationX();
          this.AaN = paramInt3;
          localObject = this.AaS.AaH;
          if (localObject == null) {
            break label534;
          }
          paramInt3 = (int)((d)localObject).getTranslationY();
          this.AaO = paramInt3;
        }
        paramFloat2 = paramFloat1 / paramInt1 / 3.0F;
        localObject = this.AaS.AaG;
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
        localRect = this.AaQ;
        if (localRect == null) {
          break label582;
        }
        paramInt3 = localRect.left;
        localRect = this.AaQ;
        if (localRect == null) {
          break label588;
        }
        paramInt4 = localRect.width();
        f3 = paramInt3 + paramInt4 / 2;
        f4 = j;
        localRect = this.AaQ;
        if (localRect == null) {
          break label594;
        }
        paramInt3 = localRect.top;
        label421:
        localRect = this.AaQ;
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
        f6 = this.AaN;
        f7 = this.AaO;
        this.AaP = paramFloat2;
        if ((paramFloat2 < 0.16F) || (this.iGD)) {
          break label606;
        }
        this.iGD = true;
        if (!bx(paramFloat2)) {
          MMHandlerThread.postToMainThread((Runnable)new d(this));
        }
        AppMethodBeat.o(200503);
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
      localObject = this.AaS.AaH;
      if (localObject != null) {
        ((d)localObject).setMaskAlpha((int)(255.0F * paramFloat2));
      }
      localObject = this.AaS.AaH;
      if (localObject != null) {
        ((d)localObject).o(0.0F, f9, f8, f10 - f9);
      }
      localObject = d.AaD;
      f8 = d.eqK() * paramFloat2 / paramFloat1;
      localObject = this.AaS.AaH;
      if (localObject != null) {
        ((d)localObject).a(f8, f8, f8, f8, f8, f8, f8, f8);
      }
      localObject = this.AaS.AaH;
      if (localObject != null) {
        ((d)localObject).setPivotX(i);
      }
      localObject = this.AaS.AaH;
      if (localObject != null) {
        ((d)localObject).setPivotY(j);
      }
      localObject = this.AaS.AaH;
      if (localObject != null) {
        ((d)localObject).setTranslationX(f6 + (f1 - f3) * f2 * paramFloat2);
      }
      localObject = this.AaS.AaH;
      if (localObject != null) {
        ((d)localObject).setTranslationY(f7 + (f4 - f5) * f2 * paramFloat2);
      }
      localObject = this.AaS.AaH;
      if (localObject != null) {
        ((d)localObject).setScaleX(paramFloat1);
      }
      localObject = this.AaS.AaH;
      if (localObject != null) {
        ((d)localObject).setScaleY(paramFloat1);
      }
      localObject = this.AaS.AaH;
      if (localObject != null)
      {
        ((d)localObject).postInvalidate();
        AppMethodBeat.o(200503);
        return;
      }
      AppMethodBeat.o(200503);
    }
    
    public final int awM()
    {
      return 1;
    }
    
    public final void b(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(200499);
      Log.d("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "onViewReleased, xvel: %f, yvel: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
      if (this.iGD)
      {
        Log.i("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "onViewReleased, isFinish!");
        AppMethodBeat.o(200499);
        return;
      }
      if ((Math.abs(paramFloat1) > this.AaR) && (bx(this.AaP)))
      {
        this.iGD = true;
        Log.i("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "onViewReleased, auto add multitask!");
        AppMethodBeat.o(200499);
        return;
      }
      MMHandlerThread.postToMainThread((Runnable)new c(this));
      this.AaS.AaJ = -1L;
      paramView = this.AaS.eqL().getContentView();
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      this.AaS.eqL();
      this.AaS.eqL().sj(true);
      AppMethodBeat.o(200499);
    }
    
    public final boolean c(View paramView, int paramInt)
    {
      AppMethodBeat.i(200497);
      paramView = this.AaS.AaG;
      if (paramView != null)
      {
        boolean bool = paramView.RH(paramInt);
        AppMethodBeat.o(200497);
        return bool;
      }
      AppMethodBeat.o(200497);
      return false;
    }
    
    public final void ei(boolean paramBoolean)
    {
      AppMethodBeat.i(200501);
      Log.d("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "onComplete");
      AppMethodBeat.o(200501);
    }
    
    public final void eqJ()
    {
      AppMethodBeat.i(200502);
      Log.i("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "onViewCaptured");
      if (this.iGD)
      {
        Log.i("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "onViewCaptured, isFinish!");
        AppMethodBeat.o(200502);
        return;
      }
      b.a(this.AaS);
      this.AaN = -1;
      this.AaO = -1;
      AppMethodBeat.o(200502);
    }
    
    public final void l(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "value", "", "onUpdate", "com/tencent/mm/plugin/multitask/animation/swipeback/multiscene/MultiTaskSwipeBackAnimWrapperMS$ViewDragCallback$autoHide$1$1"})
    static final class a
      implements com.tencent.mm.ui.c.a.b.a
    {
      a(boolean paramBoolean, int paramInt1, int paramInt2, float paramFloat1, Rect paramRect, float paramFloat2, d paramd, int paramInt3, int paramInt4, int paramInt5, b.b paramb, float paramFloat3) {}
      
      public final void by(float paramFloat)
      {
        AppMethodBeat.i(200492);
        float f5 = paramFloat + (1.0F - paramFloat) * paramFloat;
        float f3;
        float f1;
        float f2;
        float f4;
        if (!this.AaT)
        {
          f3 = j;
          f1 = (k * f1 - this.AaU.height()) / 2.0F;
          f2 = 1.0F / f1 * (f1 * f5);
          f1 = k - f2;
          f4 = 0.0F;
        }
        for (;;)
        {
          locald.setPivotX(m);
          locald.setPivotY(n);
          locald.setMaskAlpha((int)(255.0F * f5));
          locald.o(f4, f2, f3, f1);
          d.a locala = d.AaD;
          f1 = d.eqK() * f5 / f1;
          locald.a(f1, f1, f1, f1, f1, f1, f1, f1);
          locald.setRotate(i * paramFloat);
          locald.postInvalidate();
          AppMethodBeat.o(200492);
          return;
          f1 = k;
          f4 = (j * f1 - this.AaU.height()) / 2.0F * f5 * (1.0F / f2);
          f3 = j - f4;
          f2 = 0.0F;
        }
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/multitask/animation/swipeback/multiscene/MultiTaskSwipeBackAnimWrapperMS$ViewDragCallback$autoHide$1$2"})
    static final class b
      implements Runnable
    {
      b(d paramd, Bitmap paramBitmap, b.b paramb, float paramFloat) {}
      
      public final void run()
      {
        AppMethodBeat.i(200494);
        this.AaW.setVisibility(8);
        MMHandlerThread.postToMainThread((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(200493);
            com.tencent.mm.plugin.multitask.c.c localc = this.Abc.Aba.AaS.AaI;
            if (localc != null)
            {
              localc.g(this.Abc.cKG, 3);
              AppMethodBeat.o(200493);
              return;
            }
            AppMethodBeat.o(200493);
          }
        });
        AppMethodBeat.o(200494);
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
        AppMethodBeat.i(200495);
        if (this.Aba.AaS.AaH != null)
        {
          Object localObject1 = this.Aba.AaS.AaH;
          if (localObject1 != null) {
            localObject1 = ((d)localObject1).getParent();
          }
          while (localObject1 != null)
          {
            d locald = this.Aba.AaS.AaH;
            localObject1 = localObject2;
            if (locald != null) {
              localObject1 = locald.getParent();
            }
            if (localObject1 == null)
            {
              localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
              AppMethodBeat.o(200495);
              throw ((Throwable)localObject1);
              localObject1 = null;
            }
            else
            {
              ((ViewGroup)localObject1).removeView((View)this.Aba.AaS.AaH);
            }
          }
        }
        AppMethodBeat.o(200495);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class d
      implements Runnable
    {
      d(b.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(200496);
        com.tencent.mm.plugin.multitask.c.c localc = this.Aba.AaS.AaI;
        if (localc != null)
        {
          Object localObject = this.Aba.AaS.AaH;
          if (localObject != null) {}
          for (localObject = ((d)localObject).getContentBitmap();; localObject = null)
          {
            localc.g((Bitmap)localObject, 3);
            AppMethodBeat.o(200496);
            return;
          }
        }
        AppMethodBeat.o(200496);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/animation/swipeback/multiscene/MultiTaskSwipeBackAnimWrapperMS$doPrepareTransform$1", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$TranslucentCallback;", "onComplete", "", "done", "", "plugin-multitask_release"})
  public static final class c
    implements a.b
  {
    public final void ei(boolean paramBoolean)
    {
      AppMethodBeat.i(258583);
      if (!paramBoolean)
      {
        Object localObject = this.AaS.AaE;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.multitask.b.b)localObject).gEY();
          if (localObject != null)
          {
            localObject = ((crt)localObject).Uub;
            if (localObject != null)
            {
              ((ffq)localObject).Uua = false;
              AppMethodBeat.o(258583);
              return;
            }
          }
        }
      }
      AppMethodBeat.o(258583);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "value", "", "onUpdate"})
  static final class d
    implements com.tencent.mm.ui.c.a.b.a
  {
    d(b paramb, boolean paramBoolean, int paramInt1, int paramInt2, float paramFloat, Rect paramRect, int paramInt3, int paramInt4, int paramInt5) {}
    
    public final void by(float paramFloat)
    {
      AppMethodBeat.i(200505);
      float f3;
      float f1;
      float f2;
      float f4;
      if (!paramBoolean)
      {
        f3 = j;
        f1 = (k * f1 - this.AaU.height()) / 2.0F;
        f2 = 1.0F / f1 * (f1 * paramFloat);
        f1 = k - f2;
        f4 = 0.0F;
      }
      for (;;)
      {
        Object localObject = this.AaS.AaH;
        if (localObject != null) {
          ((d)localObject).setMaskAlpha((int)(255.0F * paramFloat));
        }
        localObject = this.AaS.AaH;
        if (localObject != null) {
          ((d)localObject).o(f4, f2, f3, f1);
        }
        localObject = d.AaD;
        f1 = d.eqK() * paramFloat / f1;
        localObject = this.AaS.AaH;
        if (localObject != null) {
          ((d)localObject).a(f1, f1, f1, f1, f1, f1, f1, f1);
        }
        localObject = this.AaS.AaH;
        if (localObject != null) {
          ((d)localObject).setPivotX(m);
        }
        localObject = this.AaS.AaH;
        if (localObject != null) {
          ((d)localObject).setPivotY(n);
        }
        localObject = this.AaS.AaH;
        if (localObject != null) {
          ((d)localObject).setRotate(i * paramFloat);
        }
        localObject = this.AaS.AaH;
        if (localObject == null) {
          break;
        }
        ((d)localObject).postInvalidate();
        AppMethodBeat.o(200505);
        return;
        f4 = (j * f1 - this.AaU.width()) / 2.0F * paramFloat * (1.0F / f1);
        f3 = j - f4;
        f1 = k - 0.0F;
        f2 = 0.0F;
      }
      AppMethodBeat.o(200505);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(b paramb, com.tencent.mm.plugin.multitask.c.c paramc, Bitmap paramBitmap, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(200506);
      Object localObject = this.AaS.AaH;
      if (localObject != null) {
        ((d)localObject).setTranslationX(0.0F);
      }
      localObject = this.AaS.AaH;
      if (localObject != null) {
        ((d)localObject).setTranslationY(0.0F);
      }
      localObject = this.AaS.AaH;
      if (localObject != null) {
        ((d)localObject).setScaleX(1.0F);
      }
      localObject = this.AaS.AaH;
      if (localObject != null) {
        ((d)localObject).setScaleY(1.0F);
      }
      localObject = paramc;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.multitask.c.c)localObject).a(localBitmap, false, paramInt);
        AppMethodBeat.o(200506);
        return;
      }
      AppMethodBeat.o(200506);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(b paramb, com.tencent.mm.plugin.multitask.c.c paramc, Bitmap paramBitmap, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(200508);
      this.AaS.AaL = false;
      MMHandlerThread.postToMainThread((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(200507);
          com.tencent.mm.plugin.multitask.c.c localc = this.Abg.zZX;
          if (localc != null)
          {
            localc.g(this.Abg.Abf, this.Abg.Abd);
            AppMethodBeat.o(200507);
            return;
          }
          AppMethodBeat.o(200507);
        }
      });
      AppMethodBeat.o(200508);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/animation/swipeback/multiscene/MultiTaskSwipeBackAnimWrapperMS$onCreate$1", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;", "canInterceptTouchEvent", "", "enableSwipeBack", "getSwipeBackTouchState", "", "onDispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onEdgeDragStarted", "edgeFlags", "pointerId", "onPositionChange", "scrollPercent", "", "onSwipeReleased", "willSwipeBack", "shouldInterceptTouchEvent", "ev", "plugin-multitask_release"})
  public static final class g
    implements a.a
  {
    g(com.tencent.mm.plugin.multitask.b.b paramb) {}
    
    public final void RF(int paramInt) {}
    
    public final void aY(float paramFloat) {}
    
    public final boolean eqD()
    {
      AppMethodBeat.i(200510);
      boolean bool = paramb.eqS();
      AppMethodBeat.o(200510);
      return bool;
    }
    
    public final int eqE()
    {
      com.tencent.mm.plugin.multitask.animation.c.a.c localc = this.AaS.AaG;
      if (localc != null) {
        return localc.Aas;
      }
      return 0;
    }
    
    public final boolean eqF()
    {
      AppMethodBeat.i(200511);
      b localb;
      if (this.AaS.AaJ == -1L)
      {
        localb = this.AaS;
        localObject = paramb;
        if (localObject == null) {
          break label74;
        }
      }
      label74:
      for (Object localObject = Boolean.valueOf(((com.tencent.mm.plugin.multitask.b.b)localObject).eqW());; localObject = null)
      {
        localb.AaK = ((Boolean)localObject).booleanValue();
        this.AaS.AaJ = 0L;
        boolean bool = this.AaS.AaK;
        AppMethodBeat.o(200511);
        return bool;
      }
    }
    
    public final boolean j(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(200512);
      p.h(paramMotionEvent, "ev");
      com.tencent.mm.plugin.multitask.animation.c.a.c localc = this.AaS.AaG;
      if (localc != null)
      {
        boolean bool = localc.j(paramMotionEvent);
        AppMethodBeat.o(200512);
        return bool;
      }
      AppMethodBeat.o(200512);
      return false;
    }
    
    public final int jJ(boolean paramBoolean)
    {
      return 0;
    }
    
    public final void n(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(200509);
      p.h(paramMotionEvent, "event");
      com.tencent.mm.plugin.multitask.animation.c.a.c localc = this.AaS.AaG;
      if (localc != null)
      {
        localc.k(paramMotionEvent);
        AppMethodBeat.o(200509);
        return;
      }
      AppMethodBeat.o(200509);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(b paramb, int paramInt, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(258584);
      Object localObject = this.AaS.AaG;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).Aay; localObject != null; localObject = null)
      {
        b.a(this.AaS, paramInt, paramBoolean1, this.AaS.AaI);
        AppMethodBeat.o(258584);
        return;
      }
      if (this.AaS.AaI != null)
      {
        localObject = this.AaS.AaI;
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.multitask.c.c)localObject).RL(paramInt);
          AppMethodBeat.o(258584);
          return;
        }
      }
      AppMethodBeat.o(258584);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.c.b.b
 * JD-Core Version:    0.7.0.1
 */