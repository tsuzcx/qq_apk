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
import com.tencent.mm.plugin.multitask.animation.c.a.b.a;
import com.tencent.mm.protocal.protobuf.drx;
import com.tencent.mm.protocal.protobuf.dry;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/animation/swipeback/multiscene/MultiTaskSwipeBackAnimWrapperMS;", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/BaseMultiTaskSwipeBackAnimWrapper;", "()V", "enableSwipeback", "", "getEnableSwipeback", "()Z", "setEnableSwipeback", "(Z)V", "isExitAnimating", "setExitAnimating", "mDragHelper", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "getMDragHelper", "()Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "setMDragHelper", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;)V", "mListener", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "getMListener", "()Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "setMListener", "(Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;)V", "multiTaskHelper", "Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "getMultiTaskHelper", "()Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "setMultiTaskHelper", "(Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;)V", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "getPageAdapter", "()Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "setPageAdapter", "(Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "swipeBackFlag", "", "getSwipeBackFlag", "()J", "setSwipeBackFlag", "(J)V", "swipeView", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/TransformSwipeBackToMultiTaskView;", "getSwipeView", "()Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/TransformSwipeBackToMultiTaskView;", "setSwipeView", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/TransformSwipeBackToMultiTaskView;)V", "doPrepareTransform", "", "way", "", "anim", "delay", "init", "initMaskView", "listener", "onCreate", "refreshPosition", "startSwipeAnim", "Companion", "ViewDragCallback", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.multitask.animation.c.a.a
{
  public static final a.a LCm;
  protected com.tencent.mm.plugin.multitask.a.a LBU;
  com.tencent.mm.plugin.multitask.b.b LCn;
  com.tencent.mm.plugin.multitask.animation.c.a.b LCo;
  com.tencent.mm.plugin.multitask.animation.c.a.c LCp;
  com.tencent.mm.plugin.multitask.c.c LCq;
  long LCr = -1L;
  boolean LCs = true;
  private boolean LCt;
  
  static
  {
    AppMethodBeat.i(304107);
    LCm = new a.a((byte)0);
    AppMethodBeat.o(304107);
  }
  
  private final void a(int paramInt, boolean paramBoolean, com.tencent.mm.plugin.multitask.c.c paramc)
  {
    AppMethodBeat.i(304053);
    Log.i("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "initMaskView, way:%d", new Object[] { Integer.valueOf(paramInt) });
    if (gjH().getMaskView() == null)
    {
      Log.w("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "doMaskAnimation, page mask view is null");
      if (paramc != null) {
        paramc.aco(paramInt);
      }
      AppMethodBeat.o(304053);
      return;
    }
    if (gjH().getContentView() == null)
    {
      Log.w("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "doMaskAnimation, page content view is null");
      if (paramc != null) {
        paramc.aco(paramInt);
      }
      AppMethodBeat.o(304053);
      return;
    }
    if (gjH().cXB() == null)
    {
      Log.w("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "doMaskAnimation, page root view is null");
      if (paramc != null) {
        paramc.aco(paramInt);
      }
      AppMethodBeat.o(304053);
      return;
    }
    if (this.LCt)
    {
      Log.w("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "isExitAnimating now!");
      AppMethodBeat.o(304053);
      return;
    }
    gjH();
    Bitmap localBitmap = gjH().getBitmap();
    if ((localBitmap == null) || (localBitmap.isRecycled()) || (localBitmap.getWidth() == 0) || (localBitmap.getHeight() == 0))
    {
      Log.w("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "doMaskAnimation, page get bitmap is null");
      if (paramc != null) {
        paramc.aco(paramInt);
      }
      AppMethodBeat.o(304053);
      return;
    }
    if (this.LCp != null)
    {
      localObject1 = this.LCp;
      if (localObject1 != null) {
        break label712;
      }
      localObject1 = null;
      if (localObject1 != null) {}
    }
    else
    {
      this.LCp = new com.tencent.mm.plugin.multitask.animation.c.a.c((Context)gjH().getActivity(), localBitmap);
      localObject1 = this.LCp;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      }
      localObject1 = gjH().cXB();
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setBackgroundColor(0);
      }
      if (localObject1 != null) {
        ((ViewGroup)localObject1).addView((View)this.LCp, ((ViewGroup)localObject1).getChildCount());
      }
    }
    acm(paramInt);
    Object localObject1 = gjH().getContentView();
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(8);
    }
    if (paramBoolean)
    {
      localObject1 = this.LCn;
      label385:
      int i;
      label393:
      int j;
      int k;
      Rect localRect;
      label453:
      Object localObject2;
      int m;
      int n;
      float f1;
      if (localObject1 == null)
      {
        paramBoolean = false;
        if (!paramBoolean) {
          break label733;
        }
        i = 90;
        this.LCt = true;
        j = (int)(localBitmap.getWidth() * 1.25F);
        k = (int)(localBitmap.getHeight() * 1.25F);
        localRect = new Rect(0, 0, j, k);
        localObject1 = this.LCo;
        if (localObject1 != null) {
          break label739;
        }
        localObject1 = null;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new Rect();
        }
        m = ((Rect)localObject2).left + ((Rect)localObject2).width() / 2;
        n = ((Rect)localObject2).top + ((Rect)localObject2).height() / 2;
        if (!paramBoolean) {
          break label749;
        }
        f1 = ((Rect)localObject2).height() / k;
        label517:
        if (!paramBoolean) {
          break label764;
        }
        ((Rect)localObject2).width();
      }
      for (;;)
      {
        float f2 = m - (localRect.left + localRect.width() / 2);
        int i1 = localRect.top;
        float f3 = n - (localRect.height() / 2 + i1);
        if (paramBoolean)
        {
          localObject1 = this.LCp;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).setGradientOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
          }
        }
        com.tencent.mm.ui.anim.a.a.kY((View)this.LCp).dS(f2 * f1).dT(f3 * f1).dU(f1).dV(f1).a(new a..ExternalSyntheticLambda0(paramBoolean, j, k, f1, (Rect)localObject2, this, m, n, i)).d((Interpolator)new AccelerateInterpolator()).aY(new a..ExternalSyntheticLambda2(this, paramc, localBitmap, paramInt)).aX(new a..ExternalSyntheticLambda3(this, paramc, localBitmap, paramInt)).zE(250L).start();
        AppMethodBeat.o(304053);
        return;
        label712:
        localObject1 = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).getParent();
        break;
        paramBoolean = ((com.tencent.mm.plugin.multitask.b.b)localObject1).gjN();
        break label385;
        label733:
        i = 0;
        break label393;
        label739:
        localObject1 = ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject1).LCj;
        break label453;
        label749:
        f1 = ((Rect)localObject2).width() / j;
        break label517;
        label764:
        ((Rect)localObject2).width();
      }
    }
    if (paramc != null)
    {
      localObject1 = this.LCp;
      if (localObject1 != null) {
        break label807;
      }
    }
    label807:
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).getContentBitmap())
    {
      paramc.a((Bitmap)localObject1, true, paramInt);
      AppMethodBeat.o(304053);
      return;
    }
  }
  
  private static final void a(a parama, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(304060);
    s.u(parama, "this$0");
    Object localObject = parama.LCo;
    if (localObject == null) {}
    for (localObject = null; localObject != null; localObject = ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).LCj)
    {
      parama.a(paramInt, paramBoolean, parama.LCq);
      AppMethodBeat.o(304060);
      return;
    }
    if (parama.LCq != null)
    {
      parama = parama.LCq;
      if (parama != null) {
        parama.aco(paramInt);
      }
    }
    AppMethodBeat.o(304060);
  }
  
  private static final void a(a parama, com.tencent.mm.plugin.multitask.c.c paramc, Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(304076);
    s.u(parama, "this$0");
    com.tencent.mm.plugin.multitask.animation.c.a.c localc = parama.LCp;
    if (localc != null) {
      localc.setTranslationX(0.0F);
    }
    localc = parama.LCp;
    if (localc != null) {
      localc.setTranslationY(0.0F);
    }
    localc = parama.LCp;
    if (localc != null) {
      localc.setScaleX(1.0F);
    }
    parama = parama.LCp;
    if (parama != null) {
      parama.setScaleY(1.0F);
    }
    if (paramc != null) {
      paramc.a(paramBitmap, false, paramInt);
    }
    AppMethodBeat.o(304076);
  }
  
  private static final void a(com.tencent.mm.plugin.multitask.c.c paramc, Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(304082);
    if (paramc != null) {
      paramc.g(paramBitmap, paramInt);
    }
    AppMethodBeat.o(304082);
  }
  
  private static final void a(boolean paramBoolean, int paramInt1, int paramInt2, float paramFloat1, Rect paramRect, a parama, int paramInt3, int paramInt4, int paramInt5, float paramFloat2)
  {
    AppMethodBeat.i(304070);
    s.u(paramRect, "$potision");
    s.u(parama, "this$0");
    float f4;
    float f3;
    float f1;
    if (!paramBoolean)
    {
      f4 = 0.0F;
      f3 = paramInt1;
      f1 = (paramInt2 * paramFloat1 - paramRect.height()) / 2.0F * paramFloat2 * (1.0F / paramFloat1);
    }
    for (float f2 = paramInt2 - f1;; f2 = paramInt2 - 0.0F)
    {
      paramRect = parama.LCp;
      if (paramRect != null) {
        paramRect.setMaskAlpha((int)(255.0F * paramFloat2));
      }
      paramRect = parama.LCp;
      if (paramRect != null) {
        paramRect.t(f4, f1, f3, f2);
      }
      paramRect = com.tencent.mm.plugin.multitask.animation.c.a.c.LCk;
      paramFloat1 = com.tencent.mm.plugin.multitask.animation.c.a.c.gjG() * paramFloat2 / paramFloat1;
      paramRect = parama.LCp;
      if (paramRect != null) {
        paramRect.a(paramFloat1, paramFloat1, paramFloat1, paramFloat1, paramFloat1, paramFloat1, paramFloat1, paramFloat1);
      }
      paramRect = parama.LCp;
      if (paramRect != null) {
        paramRect.setPivotX(paramInt3);
      }
      paramRect = parama.LCp;
      if (paramRect != null) {
        paramRect.setPivotY(paramInt4);
      }
      paramRect = parama.LCp;
      if (paramRect != null) {
        paramRect.setRotate(paramInt5 * paramFloat2);
      }
      paramRect = parama.LCp;
      if (paramRect != null) {
        paramRect.postInvalidate();
      }
      AppMethodBeat.o(304070);
      return;
      f4 = (paramInt1 * paramFloat1 - paramRect.width()) / 2.0F * paramFloat2 * (1.0F / paramFloat1);
      f3 = paramInt1 - f4;
      f1 = 0.0F;
    }
  }
  
  private final void acm(int paramInt)
  {
    Integer localInteger = null;
    Object localObject3 = null;
    AppMethodBeat.i(304029);
    Object localObject1 = this.LCn;
    if (localObject1 == null) {}
    for (localObject1 = null; !Util.isNullOrNil((String)localObject1); localObject2 = localException.acn(paramInt))
    {
      if (localObject1 != null) {
        try
        {
          localObject1 = (CharSequence)localObject1;
          localObject1 = ((Collection)new k(",").o((CharSequence)localObject1, 0)).toArray(new String[0]);
          if (localObject1 != null) {
            break label209;
          }
          localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(304029);
          throw ((Throwable)localObject1);
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "refreshPosition, get pos failed, %s", new Object[] { localException.getMessage() });
        }
      }
      AppMethodBeat.o(304029);
      return;
    }
    if (paramInt == 4)
    {
      localObject2 = this.LCn;
      if (localObject2 == null) {}
      for (localObject2 = localObject3;; localObject2 = ((com.tencent.mm.plugin.multitask.b.b)localObject2).gjP()) {
        break;
      }
    }
    Object localObject2 = this.LCn;
    if (localObject2 == null) {}
    for (localObject2 = localInteger;; localObject2 = ((com.tencent.mm.plugin.multitask.b.b)localObject2).getPosition()) {
      break;
    }
    label209:
    localObject3 = (String[])localObject2;
    if ((localObject3 != null) && (localObject3.length == 4))
    {
      localObject2 = this.LCo;
      if (localObject2 != null)
      {
        localInteger = Integer.valueOf(localObject3[0]);
        s.s(localInteger, "valueOf(posVec[0])");
        paramInt = ((Number)localInteger).intValue();
        localInteger = Integer.valueOf(localObject3[1]);
        s.s(localInteger, "valueOf(posVec[1])");
        int i = ((Number)localInteger).intValue();
        localInteger = Integer.valueOf(localObject3[2]);
        s.s(localInteger, "valueOf(posVec[2])");
        int j = ((Number)localInteger).intValue();
        localObject3 = Integer.valueOf(localObject3[3]);
        s.s(localObject3, "valueOf(posVec[3])");
        ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject2).z(new Rect(paramInt, i, j, ((Number)localObject3).intValue()));
      }
    }
    AppMethodBeat.o(304029);
  }
  
  private static final void b(a parama, com.tencent.mm.plugin.multitask.c.c paramc, Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(304090);
    s.u(parama, "this$0");
    parama.LCt = false;
    MMHandlerThread.postToMainThread(new a..ExternalSyntheticLambda4(paramc, paramBitmap, paramInt));
    AppMethodBeat.o(304090);
  }
  
  private final void l(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(304039);
    Object localObject;
    if (gjH().cor())
    {
      if (MMHandlerThread.isMainThread())
      {
        gjH().a((com.tencent.mm.plugin.multitask.a.a.b)new c(this));
        if (paramBoolean2)
        {
          MMHandlerThread.postToMainThread(new a..ExternalSyntheticLambda1(this, paramInt, paramBoolean1));
          AppMethodBeat.o(304039);
          return;
        }
        localObject = this.LCo;
        if (localObject == null) {}
        for (localObject = null; localObject != null; localObject = ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).LCj)
        {
          a(paramInt, paramBoolean1, this.LCq);
          AppMethodBeat.o(304039);
          return;
        }
        if (this.LCq != null)
        {
          localObject = this.LCq;
          if (localObject != null)
          {
            ((com.tencent.mm.plugin.multitask.c.c)localObject).aco(paramInt);
            AppMethodBeat.o(304039);
          }
        }
      }
      else if (this.LCq != null)
      {
        localObject = this.LCq;
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.multitask.c.c)localObject).aco(paramInt);
          AppMethodBeat.o(304039);
        }
      }
    }
    else if (this.LCq != null)
    {
      localObject = this.LCq;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.c.c)localObject).aco(paramInt);
      }
    }
    AppMethodBeat.o(304039);
  }
  
  public final void a(com.tencent.mm.plugin.multitask.a.a parama, final com.tencent.mm.plugin.multitask.b.b paramb, com.tencent.mm.plugin.multitask.c.c paramc)
  {
    AppMethodBeat.i(304154);
    s.u(parama, "pageAdapter");
    s.u(paramb, "multiTaskHelper");
    s.u(parama, "<set-?>");
    this.LBU = parama;
    this.LCn = paramb;
    this.LCq = paramc;
    gjH().a((com.tencent.mm.plugin.multitask.a.a.a)new d(this, paramb));
    parama = AnimationUtils.loadInterpolator((Context)gjH().getActivity(), com.tencent.mm.ah.a.a.mm_decelerate_interpolator);
    paramb = gjH().cXB();
    if (paramb != null)
    {
      paramc = com.tencent.mm.plugin.multitask.animation.c.a.b.LCd;
      paramc = (b.a)new b();
      s.s(parama, "interpolator");
      this.LCo = com.tencent.mm.plugin.multitask.animation.c.a.b.b.a(paramb, paramc, parama);
    }
    parama = this.LCo;
    if (parama != null) {
      parama.bxK = 1;
    }
    parama = gjH().getActivity();
    if (parama == null)
    {
      parama = null;
      if (parama != null) {
        break label264;
      }
    }
    label264:
    for (float f = com.tencent.mm.cd.a.getDensity((Context)gjH().getActivity());; f = parama.floatValue())
    {
      parama = this.LCo;
      if (parama != null) {
        parama.LCf = (100.0F * f);
      }
      parama = this.LCo;
      if (parama != null) {
        parama.uDV = (f * 300.0F);
      }
      AppMethodBeat.o(304154);
      return;
      parama = parama.getResources();
      if (parama == null)
      {
        parama = null;
        break;
      }
      parama = parama.getDisplayMetrics();
      if (parama == null)
      {
        parama = null;
        break;
      }
      parama = Float.valueOf(parama.density);
      break;
    }
  }
  
  public final void acj(int paramInt)
  {
    AppMethodBeat.i(304159);
    l(paramInt, true, true);
    AppMethodBeat.o(304159);
  }
  
  protected final com.tencent.mm.plugin.multitask.a.a gjH()
  {
    AppMethodBeat.i(304138);
    com.tencent.mm.plugin.multitask.a.a locala = this.LBU;
    if (locala != null)
    {
      AppMethodBeat.o(304138);
      return locala;
    }
    s.bIx("pageAdapter");
    AppMethodBeat.o(304138);
    return null;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/animation/swipeback/multiscene/MultiTaskSwipeBackAnimWrapperMS$ViewDragCallback;", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Callback;", "Lcom/tencent/mm/ui/base/ActivityUtil$IConvertActivityTranslucentCallback;", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/multiscene/MultiTaskSwipeBackAnimWrapperMS;)V", "CONSTANT_X_VELOCITY", "", "getCONSTANT_X_VELOCITY", "()I", "isFinish", "", "()Z", "setFinish", "(Z)V", "mFractor", "", "getMFractor", "()F", "setMFractor", "(F)V", "mStartTransX", "getMStartTransX", "setMStartTransX", "(I)V", "mStartTransY", "getMStartTransY", "setMStartTransY", "mStartViewPosition", "Landroid/graphics/Rect;", "getMStartViewPosition", "()Landroid/graphics/Rect;", "setMStartViewPosition", "(Landroid/graphics/Rect;)V", "autoHide", "firstValue", "clampViewPositionHorizontal", "child", "Landroid/view/View;", "left", "dx", "getViewHorizontalDragRange", "onComplete", "", "drawComplete", "onViewCaptured", "capturedChild", "activePointerId", "onViewDragStateChanged", "state", "onViewPositionChanged", "changedView", "top", "dy", "onViewReleased", "releasedChild", "xvel", "yvel", "onViewTouchPositionChanged", "touchX", "touchY", "adx", "ady", "tryCaptureView", "view", "i", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class b
    extends b.a
    implements com.tencent.mm.ui.base.b.b
  {
    private int LCu;
    private int LCv;
    private float LCw;
    private Rect LCx;
    private final int LCy;
    private boolean ooe;
    
    public b()
    {
      AppMethodBeat.i(304021);
      this.LCu = -1;
      this.LCv = -1;
      this.LCy = 400;
      AppMethodBeat.o(304021);
    }
    
    private static final void a(float paramFloat1, boolean paramBoolean, int paramInt1, int paramInt2, float paramFloat2, Rect paramRect, float paramFloat3, com.tencent.mm.plugin.multitask.animation.c.a.c paramc, int paramInt3, int paramInt4, int paramInt5, float paramFloat4)
    {
      AppMethodBeat.i(304044);
      s.u(paramRect, "$potision");
      s.u(paramc, "$view");
      float f4 = paramFloat1 + (1.0F - paramFloat1) * paramFloat4;
      float f2;
      float f1;
      if (!paramBoolean)
      {
        f2 = 0.0F;
        f1 = paramInt1;
        paramFloat1 = (paramInt2 * paramFloat2 - paramRect.height()) / 2.0F * f4 * (1.0F / paramFloat2);
        paramFloat3 = paramInt2 - paramFloat1;
      }
      for (;;)
      {
        paramc.setPivotX(paramInt3);
        paramc.setPivotY(paramInt4);
        paramc.setMaskAlpha((int)(255.0F * f4));
        paramc.t(f2, paramFloat1, f1, paramFloat3);
        paramRect = com.tencent.mm.plugin.multitask.animation.c.a.c.LCk;
        paramFloat1 = com.tencent.mm.plugin.multitask.animation.c.a.c.gjG() * f4 / paramFloat2;
        paramc.a(paramFloat1, paramFloat1, paramFloat1, paramFloat1, paramFloat1, paramFloat1, paramFloat1, paramFloat1);
        paramc.setRotate(paramInt5 * paramFloat4);
        paramc.postInvalidate();
        AppMethodBeat.o(304044);
        return;
        paramFloat1 = 0.0F;
        f1 = paramInt2;
        f2 = (paramInt1 * paramFloat2 - paramRect.height()) / 2.0F;
        f2 = 1.0F / paramFloat3 * (f2 * f4);
        float f3 = paramInt1 - f2;
        paramFloat3 = f1;
        f1 = f3;
      }
    }
    
    private static final void a(com.tencent.mm.plugin.multitask.animation.c.a.c paramc, a parama, Bitmap paramBitmap)
    {
      AppMethodBeat.i(304052);
      s.u(paramc, "$view");
      s.u(parama, "this$0");
      s.u(paramBitmap, "$bitmap");
      paramc.setVisibility(8);
      MMHandlerThread.postToMainThread(new a.b..ExternalSyntheticLambda4(parama, paramBitmap));
      AppMethodBeat.o(304052);
    }
    
    private static final void a(a parama, Bitmap paramBitmap)
    {
      AppMethodBeat.i(304048);
      s.u(parama, "this$0");
      s.u(paramBitmap, "$bitmap");
      parama = parama.LCq;
      if (parama != null) {
        parama.g(paramBitmap, 3);
      }
      AppMethodBeat.o(304048);
    }
    
    private static final void b(a parama)
    {
      Object localObject2 = null;
      AppMethodBeat.i(304059);
      s.u(parama, "this$0");
      if (parama.LCp != null)
      {
        Object localObject1 = parama.LCp;
        if (localObject1 == null)
        {
          localObject1 = null;
          if (localObject1 == null) {
            break label97;
          }
          localObject1 = parama.LCp;
          if (localObject1 != null) {
            break label75;
          }
        }
        label75:
        for (localObject1 = localObject2;; localObject1 = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).getParent())
        {
          if (localObject1 != null) {
            break label83;
          }
          parama = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(304059);
          throw parama;
          localObject1 = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).getParent();
          break;
        }
        label83:
        ((ViewGroup)localObject1).removeView((View)parama.LCp);
      }
      label97:
      AppMethodBeat.o(304059);
    }
    
    private static final void c(a parama)
    {
      AppMethodBeat.i(304064);
      s.u(parama, "this$0");
      com.tencent.mm.plugin.multitask.c.c localc = parama.LCq;
      if (localc != null)
      {
        parama = parama.LCp;
        if (parama != null) {
          break label45;
        }
      }
      label45:
      for (parama = null;; parama = parama.getContentBitmap())
      {
        localc.g(parama, 3);
        AppMethodBeat.o(304064);
        return;
      }
    }
    
    private final boolean cF(float paramFloat)
    {
      AppMethodBeat.i(304034);
      com.tencent.mm.plugin.multitask.animation.c.a.c localc = this.LCz.LCp;
      Object localObject1 = this.LCz.LCp;
      Bitmap localBitmap;
      a locala;
      boolean bool;
      label62:
      int j;
      int k;
      label118:
      Object localObject2;
      int m;
      int n;
      float f1;
      label182:
      float f2;
      label198:
      float f3;
      float f4;
      if (localObject1 == null)
      {
        localBitmap = null;
        locala = this.LCz;
        if ((localc == null) || (localBitmap == null)) {
          break label432;
        }
        localObject1 = locala.LCn;
        if (localObject1 != null) {
          break label376;
        }
        bool = false;
        j = (int)(localBitmap.getWidth() * 1.25F);
        k = (int)(localBitmap.getHeight() * 1.25F);
        Rect localRect = new Rect(0, 0, j, k);
        localObject1 = locala.LCo;
        if (localObject1 != null) {
          break label388;
        }
        localObject1 = null;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new Rect();
        }
        m = ((Rect)localObject2).left + ((Rect)localObject2).width() / 2;
        n = ((Rect)localObject2).top + ((Rect)localObject2).height() / 2;
        if (!bool) {
          break label398;
        }
        f1 = ((Rect)localObject2).width() / k;
        if (!bool) {
          break label412;
        }
        f2 = ((Rect)localObject2).height() / j;
        f3 = m - (localRect.left + localRect.width() / 2);
        i = localRect.top;
        f4 = n - (localRect.height() / 2 + i);
        if (!bool) {
          break label426;
        }
      }
      label388:
      label398:
      label412:
      label426:
      for (int i = 90;; i = 0)
      {
        if (bool) {
          localc.setGradientOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        com.tencent.mm.ui.anim.a.a.kY((View)localc).a(new a.b..ExternalSyntheticLambda0(paramFloat, bool, j, k, f1, (Rect)localObject2, f2, localc, m, n, i)).aX(new a.b..ExternalSyntheticLambda1(localc, locala, localBitmap)).dU(f1).dV(f1).dS(f3 * f1).dT(f4 * f1).d((Interpolator)new AccelerateInterpolator()).zE(250L).start();
        AppMethodBeat.o(304034);
        return true;
        localBitmap = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).getContentBitmap();
        break;
        label376:
        bool = ((com.tencent.mm.plugin.multitask.b.b)localObject1).gjN();
        break label62;
        localObject1 = ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject1).LCj;
        break label118;
        f1 = ((Rect)localObject2).width() / j;
        break label182;
        f2 = ((Rect)localObject2).width() / j;
        break label198;
      }
      label432:
      AppMethodBeat.o(304034);
      return false;
    }
    
    public final void F(int paramInt)
    {
      AppMethodBeat.i(304134);
      Log.d("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", s.X("onViewDragStateChanged, state:", Integer.valueOf(paramInt)));
      AppMethodBeat.o(304134);
    }
    
    public final void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(304165);
      if (this.LCz.LCp != null)
      {
        localObject1 = this.LCz.LCp;
        if ((localObject1 == null) || (((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).getWidth() != 0)) {
          break label73;
        }
        paramInt1 = 1;
        if (paramInt1 == 0)
        {
          localObject1 = this.LCz.LCo;
          if (localObject1 != null) {
            break label78;
          }
        }
      }
      label73:
      label78:
      for (Object localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject1).LCj)
      {
        if (localObject1 != null) {
          break label88;
        }
        AppMethodBeat.o(304165);
        return;
        paramInt1 = 0;
        break;
      }
      label88:
      localObject1 = this.LCz.LCp;
      label121:
      Object localObject2;
      label178:
      label201:
      label233:
      float f2;
      int i;
      int j;
      label300:
      label317:
      float f1;
      label336:
      label355:
      label369:
      float f3;
      float f4;
      if (localObject1 == null)
      {
        paramInt1 = 0;
        localObject1 = this.LCz.LCp;
        if (localObject1 != null) {
          break label499;
        }
        paramInt2 = 0;
        if (this.LCx == null) {
          this.LCx = com.tencent.mm.plugin.multitask.f.c.in((View)this.LCz.LCp);
        }
        if ((this.LCu == -1) && (this.LCv == -1))
        {
          localObject1 = this.LCz.LCp;
          if (localObject1 != null) {
            break label509;
          }
          paramInt3 = 0;
          this.LCu = paramInt3;
          localObject1 = this.LCz.LCp;
          if (localObject1 != null) {
            break label520;
          }
          paramInt3 = 0;
          this.LCv = paramInt3;
        }
        paramFloat2 = paramFloat1 / paramInt1 / 3.0F;
        localObject1 = this.LCz.LCo;
        if (localObject1 != null) {
          break label531;
        }
        localObject1 = null;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new Rect();
        }
        f2 = ((Rect)localObject2).width() / paramInt1;
        i = ((Rect)localObject2).left + ((Rect)localObject2).width() / 2;
        j = ((Rect)localObject2).top + ((Rect)localObject2).height() / 2;
        if (paramFloat2 <= 1.0F) {
          break label541;
        }
        paramFloat1 = 1.0F;
        paramFloat1 = 1.0F - paramFloat1 * (1.0F - f2);
        if (paramFloat1 <= 1.0F) {
          break label554;
        }
        paramFloat1 = 1.0F;
        f1 = (1.0F - paramFloat1) / (1.0F - f2);
        if (f1 <= 1.0F) {
          break label568;
        }
        paramFloat2 = 1.0F;
        f1 = i;
        localObject1 = this.LCx;
        if (localObject1 != null) {
          break label583;
        }
        paramInt3 = 0;
        localObject1 = this.LCx;
        if (localObject1 != null) {
          break label593;
        }
        paramInt4 = 0;
        f3 = paramInt3 + paramInt4 / 2;
        f4 = j;
        localObject1 = this.LCx;
        if (localObject1 != null) {
          break label603;
        }
        paramInt3 = 0;
        label398:
        localObject1 = this.LCx;
        if (localObject1 != null) {
          break label613;
        }
      }
      float f5;
      float f6;
      float f7;
      label520:
      label531:
      label541:
      label554:
      label568:
      label583:
      label593:
      label603:
      label613:
      for (paramInt4 = 0;; paramInt4 = ((Rect)localObject1).height())
      {
        f5 = paramInt3 + paramInt4 / 2;
        f6 = this.LCu;
        f7 = this.LCv;
        this.LCw = paramFloat2;
        if ((paramFloat2 < 0.16F) || (this.ooe)) {
          break label623;
        }
        this.ooe = true;
        if (!cF(paramFloat2)) {
          MMHandlerThread.postToMainThread(new a.b..ExternalSyntheticLambda3(this.LCz));
        }
        AppMethodBeat.o(304165);
        return;
        paramInt1 = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).getWidth();
        break;
        label499:
        paramInt2 = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).getHeight();
        break label121;
        label509:
        paramInt3 = (int)((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).getTranslationX();
        break label178;
        paramInt3 = (int)((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).getTranslationY();
        break label201;
        localObject1 = ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject1).LCj;
        break label233;
        paramFloat1 = paramFloat2;
        if (paramFloat2 >= 0.0F) {
          break label300;
        }
        paramFloat1 = 0.0F;
        break label300;
        if (paramFloat1 < 0.0F)
        {
          paramFloat1 = 0.0F;
          break label317;
        }
        break label317;
        paramFloat2 = f1;
        if (f1 >= 0.0F) {
          break label336;
        }
        paramFloat2 = 0.0F;
        break label336;
        paramInt3 = ((Rect)localObject1).left;
        break label355;
        paramInt4 = ((Rect)localObject1).width();
        break label369;
        paramInt3 = ((Rect)localObject1).top;
        break label398;
      }
      label623:
      float f8 = paramInt1;
      float f9 = (paramInt2 * f2 - ((Rect)localObject2).height()) / 2.0F * paramFloat2 * (1.0F / f2);
      float f10 = paramInt2;
      localObject1 = this.LCz.LCp;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).setMaskAlpha((int)(255.0F * paramFloat2));
      }
      localObject1 = this.LCz.LCp;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).t(0.0F, f9, f8, f10 - f9);
      }
      localObject1 = com.tencent.mm.plugin.multitask.animation.c.a.c.LCk;
      f8 = com.tencent.mm.plugin.multitask.animation.c.a.c.gjG() * paramFloat2 / paramFloat1;
      localObject1 = this.LCz.LCp;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).a(f8, f8, f8, f8, f8, f8, f8, f8);
      }
      localObject1 = this.LCz.LCp;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).setPivotX(i);
      }
      localObject1 = this.LCz.LCp;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).setPivotY(j);
      }
      localObject1 = this.LCz.LCp;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).setTranslationX(f6 + (f1 - f3) * f2 * paramFloat2);
      }
      localObject1 = this.LCz.LCp;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).setTranslationY(f7 + (f4 - f5) * f2 * paramFloat2);
      }
      localObject1 = this.LCz.LCp;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).setScaleX(paramFloat1);
      }
      localObject1 = this.LCz.LCp;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).setScaleY(paramFloat1);
      }
      localObject1 = this.LCz.LCp;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).postInvalidate();
      }
      AppMethodBeat.o(304165);
    }
    
    public final int aXi()
    {
      return 1;
    }
    
    public final int acl(int paramInt)
    {
      return 0;
    }
    
    public final boolean b(View paramView, int paramInt)
    {
      AppMethodBeat.i(304106);
      paramView = this.LCz.LCo;
      if (paramView == null)
      {
        AppMethodBeat.o(304106);
        return false;
      }
      boolean bool = paramView.ack(paramInt);
      AppMethodBeat.o(304106);
      return bool;
    }
    
    public final void d(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(304125);
      Log.d("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "onViewReleased, xvel: %f, yvel: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
      if (this.ooe)
      {
        Log.i("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "onViewReleased, isFinish!");
        AppMethodBeat.o(304125);
        return;
      }
      if ((Math.abs(paramFloat1) > this.LCy) && (cF(this.LCw)))
      {
        this.ooe = true;
        Log.i("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "onViewReleased, auto add multitask!");
        AppMethodBeat.o(304125);
        return;
      }
      MMHandlerThread.postToMainThread(new a.b..ExternalSyntheticLambda2(this.LCz));
      this.LCz.LCr = -1L;
      paramView = this.LCz.gjH().getContentView();
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      this.LCz.gjH();
      this.LCz.gjH().zD(true);
      AppMethodBeat.o(304125);
    }
    
    public final void gjF()
    {
      AppMethodBeat.i(304148);
      Log.i("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "onViewCaptured");
      if (this.ooe)
      {
        Log.i("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "onViewCaptured, isFinish!");
        AppMethodBeat.o(304148);
        return;
      }
      a.a(this.LCz);
      this.LCu = -1;
      this.LCv = -1;
      AppMethodBeat.o(304148);
    }
    
    public final void m(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    public final void onComplete(boolean paramBoolean)
    {
      AppMethodBeat.i(304140);
      Log.d("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperMS", "onComplete");
      AppMethodBeat.o(304140);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/animation/swipeback/multiscene/MultiTaskSwipeBackAnimWrapperMS$doPrepareTransform$1", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$TranslucentCallback;", "onComplete", "", "done", "", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.plugin.multitask.a.a.b
  {
    c(a parama) {}
    
    public final void onComplete(boolean paramBoolean)
    {
      drx localdrx = null;
      AppMethodBeat.i(304013);
      Object localObject;
      if (!paramBoolean)
      {
        localObject = this.LCz.LCn;
        if (localObject != null) {
          break label38;
        }
      }
      for (;;)
      {
        if (localdrx != null) {
          localdrx.aaXE = false;
        }
        AppMethodBeat.o(304013);
        return;
        label38:
        localObject = ((com.tencent.mm.plugin.multitask.b.b)localObject).gjL();
        if (localObject != null) {
          localdrx = ((dry)localObject).aaXJ;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/animation/swipeback/multiscene/MultiTaskSwipeBackAnimWrapperMS$onCreate$1", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;", "canInterceptTouchEvent", "", "enableSwipeBack", "getSwipeBackTouchState", "", "onDispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onEdgeDragStarted", "edgeFlags", "pointerId", "onPositionChange", "scrollPercent", "", "onSwipeReleased", "willSwipeBack", "shouldInterceptTouchEvent", "ev", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.mm.plugin.multitask.a.a.a
  {
    d(a parama, com.tencent.mm.plugin.multitask.b.b paramb) {}
    
    public final void aci(int paramInt) {}
    
    public final void cC(float paramFloat) {}
    
    public final boolean gjA()
    {
      AppMethodBeat.i(304055);
      a locala;
      if (this.LCz.LCr == -1L)
      {
        locala = this.LCz;
        localObject = paramb;
        if (localObject != null) {
          break label75;
        }
      }
      label75:
      for (Object localObject = null;; localObject = Boolean.valueOf(((com.tencent.mm.plugin.multitask.b.b)localObject).gjV()))
      {
        locala.LCs = ((Boolean)localObject).booleanValue();
        this.LCz.LCr = 0L;
        if ((!this.LCz.LCs) || (!gjy())) {
          break;
        }
        AppMethodBeat.o(304055);
        return true;
      }
      AppMethodBeat.o(304055);
      return false;
    }
    
    public final boolean gjy()
    {
      AppMethodBeat.i(304050);
      boolean bool = paramb.gjR();
      AppMethodBeat.o(304050);
      return bool;
    }
    
    public final int gjz()
    {
      com.tencent.mm.plugin.multitask.animation.c.a.b localb = this.LCz.LCo;
      if (localb == null) {
        return 0;
      }
      return localb.LCe;
    }
    
    public final boolean i(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(304062);
      s.u(paramMotionEvent, "ev");
      com.tencent.mm.plugin.multitask.animation.c.a.b localb = this.LCz.LCo;
      if (localb == null)
      {
        AppMethodBeat.o(304062);
        return false;
      }
      boolean bool = localb.i(paramMotionEvent);
      AppMethodBeat.o(304062);
      return bool;
    }
    
    public final void n(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(304042);
      s.u(paramMotionEvent, "event");
      com.tencent.mm.plugin.multitask.animation.c.a.b localb = this.LCz.LCo;
      if (localb != null) {
        localb.j(paramMotionEvent);
      }
      AppMethodBeat.o(304042);
    }
    
    public final int zE(boolean paramBoolean)
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.c.b.a
 * JD-Core Version:    0.7.0.1
 */