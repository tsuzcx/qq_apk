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
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.animation.c.a.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/animation/swipeback/singlescene/MultiTaskSwipeBackAnimWrapperSS;", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/BaseMultiTaskSwipeBackAnimWrapper;", "()V", "enableSwipeback", "", "getEnableSwipeback", "()Z", "setEnableSwipeback", "(Z)V", "isExitAnimating", "setExitAnimating", "mDragHelper", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "getMDragHelper", "()Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "setMDragHelper", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;)V", "mListener", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "getMListener", "()Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "setMListener", "(Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;)V", "multiTaskHelper", "Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "getMultiTaskHelper", "()Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "setMultiTaskHelper", "(Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;)V", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "getPageAdapter", "()Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "setPageAdapter", "(Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "swipeBackFlag", "", "getSwipeBackFlag", "()J", "setSwipeBackFlag", "(J)V", "swipeView", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/TransformSwipeBackToMultiTaskView;", "getSwipeView", "()Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/TransformSwipeBackToMultiTaskView;", "setSwipeView", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/TransformSwipeBackToMultiTaskView;)V", "doPrepareTransform", "", "way", "", "exitAnim", "init", "initMaskView", "enterAnim", "listener", "onCreate", "refreshPosition", "resetView", "startSwipeAnim", "Companion", "ViewDragCallback", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.multitask.animation.c.a.a
{
  public static final a.a LCB;
  protected com.tencent.mm.plugin.multitask.a.a LBU;
  private com.tencent.mm.plugin.multitask.b.b LCn;
  com.tencent.mm.plugin.multitask.animation.c.a.b LCo;
  com.tencent.mm.plugin.multitask.animation.c.a.c LCp;
  com.tencent.mm.plugin.multitask.c.c LCq;
  long LCr = -1L;
  boolean LCs = true;
  private boolean LCt;
  
  static
  {
    AppMethodBeat.i(304290);
    LCB = new a.a((byte)0);
    AppMethodBeat.o(304290);
  }
  
  private static final void a(int paramInt1, int paramInt2, float paramFloat1, Rect paramRect, a parama, int paramInt3, int paramInt4, float paramFloat2)
  {
    AppMethodBeat.i(304236);
    s.u(paramRect, "$potision");
    s.u(parama, "this$0");
    float f1 = paramInt1;
    float f2 = (paramInt2 * paramFloat1 - paramRect.height()) / 2.0F * paramFloat2 * (1.0F / paramFloat1);
    float f3 = paramInt2;
    paramRect = parama.LCp;
    if (paramRect != null) {
      paramRect.setMaskAlpha((int)(255.0F * paramFloat2));
    }
    paramRect = parama.LCp;
    if (paramRect != null) {
      paramRect.t(0.0F, f2, f1, f3 - f2);
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
      paramRect.postInvalidate();
    }
    AppMethodBeat.o(304236);
  }
  
  private static final void a(a parama, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(304212);
    s.u(parama, "this$0");
    Object localObject1 = parama.LCo;
    if (localObject1 == null) {
      localObject1 = null;
    }
    while (localObject1 != null)
    {
      com.tencent.mm.plugin.multitask.c.c localc = parama.LCq;
      Log.i("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", "initMaskView, exitAnim:%b, enterAnim:%b, way:%d", new Object[] { Boolean.valueOf(paramBoolean), Boolean.FALSE, Integer.valueOf(paramInt) });
      if (parama.gjH().getMaskView() == null)
      {
        Log.w("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", "doMaskAnimation, page mask view is null");
        if (localc != null) {
          localc.aco(paramInt);
        }
        AppMethodBeat.o(304212);
        return;
        localObject1 = ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject1).LCj;
      }
      else
      {
        if (parama.gjH().getContentView() == null)
        {
          Log.w("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", "doMaskAnimation, page content view is null");
          if (localc != null) {
            localc.aco(paramInt);
          }
          AppMethodBeat.o(304212);
          return;
        }
        if (parama.gjH().cXB() == null)
        {
          Log.w("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", "doMaskAnimation, page root view is null");
          if (localc != null) {
            localc.aco(paramInt);
          }
          AppMethodBeat.o(304212);
          return;
        }
        if (parama.LCt)
        {
          Log.w("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", "isExitAnimating now!");
          AppMethodBeat.o(304212);
          return;
        }
        Bitmap localBitmap = parama.gjH().getBitmap();
        if ((localBitmap == null) || (localBitmap.isRecycled()) || (localBitmap.getWidth() == 0) || (localBitmap.getHeight() == 0))
        {
          Log.w("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", "doMaskAnimation, page get bitmap is null");
          if (localc != null) {
            localc.aco(paramInt);
          }
          AppMethodBeat.o(304212);
          return;
        }
        if (parama.LCp != null)
        {
          localObject1 = parama.LCp;
          if (localObject1 != null) {
            break label697;
          }
          localObject1 = null;
          if (localObject1 != null) {}
        }
        else
        {
          parama.LCp = new com.tencent.mm.plugin.multitask.animation.c.a.c((Context)parama.gjH().getActivity(), localBitmap);
          localObject1 = parama.LCp;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
          }
          localObject1 = parama.gjH().cXB();
          if (localObject1 != null) {
            ((ViewGroup)localObject1).addView((View)parama.LCp, ((ViewGroup)localObject1).getChildCount());
          }
        }
        parama.acm(paramInt);
        localObject1 = parama.gjH().getContentView();
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        if (paramBoolean)
        {
          parama.LCt = true;
          int i = (int)(localBitmap.getWidth() * 1.25F);
          int j = (int)(localBitmap.getHeight() * 1.25F);
          Rect localRect = new Rect(0, 0, i, j);
          localObject1 = parama.LCo;
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject1).LCj)
          {
            Object localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new Rect();
            }
            int k = ((Rect)localObject2).left + ((Rect)localObject2).width() / 2;
            int m = ((Rect)localObject2).top + ((Rect)localObject2).height() / 2;
            float f1 = ((Rect)localObject2).width() / i;
            float f2 = k - (localRect.left + localRect.width() / 2);
            int n = localRect.top;
            float f3 = m - (localRect.height() / 2 + n);
            com.tencent.mm.ui.anim.a.a.kY((View)parama.LCp).dS(f2 * f1).dT(f3 * f1).dU(f1).dV(f1).a(new a..ExternalSyntheticLambda0(i, j, f1, (Rect)localObject2, parama, k, m)).d((Interpolator)new AccelerateInterpolator()).aY(new a..ExternalSyntheticLambda3(parama, localc, localBitmap, paramInt)).aX(new a..ExternalSyntheticLambda2(parama, localc, localBitmap, paramInt)).zE(250L).start();
            AppMethodBeat.o(304212);
            return;
            label697:
            localObject1 = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).getParent();
            break;
          }
        }
        if (localc != null)
        {
          localObject1 = parama.LCp;
          if (localObject1 != null) {
            break label757;
          }
        }
        label757:
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).getContentBitmap())
        {
          localc.a((Bitmap)localObject1, true, paramInt);
          parama.gjI();
          AppMethodBeat.o(304212);
          return;
        }
      }
    }
    if (parama.LCq != null)
    {
      parama = parama.LCq;
      if (parama != null) {
        parama.aco(paramInt);
      }
    }
    AppMethodBeat.o(304212);
  }
  
  private static final void a(a parama, com.tencent.mm.plugin.multitask.c.c paramc, Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(304251);
    s.u(parama, "this$0");
    parama.gjI();
    if (paramc != null) {
      paramc.a(paramBitmap, false, paramInt);
    }
    AppMethodBeat.o(304251);
  }
  
  private static final void a(com.tencent.mm.plugin.multitask.c.c paramc, Bitmap paramBitmap, int paramInt, a parama)
  {
    Object localObject = null;
    AppMethodBeat.i(304261);
    s.u(paramBitmap, "$snapBlt");
    s.u(parama, "this$0");
    if (paramc != null) {
      paramc.g(paramBitmap, paramInt);
    }
    if (parama.LCp != null)
    {
      paramc = parama.LCp;
      if (paramc == null)
      {
        paramc = null;
        if (paramc == null) {
          break label121;
        }
        paramc = parama.LCp;
        if (paramc != null) {
          break label99;
        }
      }
      label99:
      for (paramc = localObject;; paramc = paramc.getParent())
      {
        if (paramc != null) {
          break label107;
        }
        paramc = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(304261);
        throw paramc;
        paramc = paramc.getParent();
        break;
      }
      label107:
      ((ViewGroup)paramc).removeView((View)parama.LCp);
    }
    label121:
    AppMethodBeat.o(304261);
  }
  
  private final void acm(int paramInt)
  {
    Integer localInteger = null;
    Object localObject3 = null;
    AppMethodBeat.i(304170);
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
          AppMethodBeat.o(304170);
          throw ((Throwable)localObject1);
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", "refreshPosition, get pos failed, %s", new Object[] { localException.getMessage() });
        }
      }
      AppMethodBeat.o(304170);
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
    AppMethodBeat.o(304170);
  }
  
  private static final void b(a parama, com.tencent.mm.plugin.multitask.c.c paramc, Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(304270);
    s.u(parama, "this$0");
    s.u(paramBitmap, "$snapBlt");
    parama.LCt = false;
    MMHandlerThread.postToMainThread(new a..ExternalSyntheticLambda4(paramc, paramBitmap, paramInt, parama));
    AppMethodBeat.o(304270);
  }
  
  private final void bp(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(304146);
    if (gjH().cor())
    {
      if (gjH().cCf()) {
        gjH().a(null);
      }
      MMHandlerThread.postToMainThread(new a..ExternalSyntheticLambda1(this, paramInt, paramBoolean));
      AppMethodBeat.o(304146);
      return;
    }
    if (this.LCq != null)
    {
      com.tencent.mm.plugin.multitask.c.c localc = this.LCq;
      if (localc != null) {
        localc.aco(paramInt);
      }
    }
    AppMethodBeat.o(304146);
  }
  
  private final void gjI()
  {
    AppMethodBeat.i(304183);
    com.tencent.mm.plugin.multitask.animation.c.a.c localc = this.LCp;
    if (localc != null) {
      localc.setTranslationX(0.0F);
    }
    localc = this.LCp;
    if (localc != null) {
      localc.setTranslationY(0.0F);
    }
    localc = this.LCp;
    if (localc != null) {
      localc.setScaleX(1.0F);
    }
    localc = this.LCp;
    if (localc != null) {
      localc.setScaleY(1.0F);
    }
    AppMethodBeat.o(304183);
  }
  
  public final void a(com.tencent.mm.plugin.multitask.a.a parama, final com.tencent.mm.plugin.multitask.b.b paramb, com.tencent.mm.plugin.multitask.c.c paramc)
  {
    AppMethodBeat.i(304372);
    s.u(parama, "pageAdapter");
    s.u(paramb, "multiTaskHelper");
    s.u(parama, "<set-?>");
    this.LBU = parama;
    this.LCn = paramb;
    this.LCq = paramc;
    parama = gjH();
    if (parama != null) {
      parama.a((com.tencent.mm.plugin.multitask.a.a.a)new c(this, paramb));
    }
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
        break label270;
      }
    }
    label270:
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
      AppMethodBeat.o(304372);
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
    AppMethodBeat.i(304384);
    bp(paramInt, true);
    AppMethodBeat.o(304384);
  }
  
  protected final com.tencent.mm.plugin.multitask.a.a gjH()
  {
    AppMethodBeat.i(304347);
    com.tencent.mm.plugin.multitask.a.a locala = this.LBU;
    if (locala != null)
    {
      AppMethodBeat.o(304347);
      return locala;
    }
    s.bIx("pageAdapter");
    AppMethodBeat.o(304347);
    return null;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/animation/swipeback/singlescene/MultiTaskSwipeBackAnimWrapperSS$ViewDragCallback;", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Callback;", "Lcom/tencent/mm/ui/base/ActivityUtil$IConvertActivityTranslucentCallback;", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/singlescene/MultiTaskSwipeBackAnimWrapperSS;)V", "CONSTANT_X_VELOCITY", "", "getCONSTANT_X_VELOCITY", "()I", "isFinish", "", "()Z", "setFinish", "(Z)V", "mStartTransX", "getMStartTransX", "setMStartTransX", "(I)V", "mStartTransY", "getMStartTransY", "setMStartTransY", "mStartViewPosition", "Landroid/graphics/Rect;", "getMStartViewPosition", "()Landroid/graphics/Rect;", "setMStartViewPosition", "(Landroid/graphics/Rect;)V", "autoHide", "firstValue", "", "clampViewPositionHorizontal", "child", "Landroid/view/View;", "left", "dx", "getViewHorizontalDragRange", "onComplete", "", "drawComplete", "onViewCaptured", "capturedChild", "activePointerId", "onViewDragStateChanged", "state", "onViewPositionChanged", "changedView", "top", "dy", "onViewReleased", "releasedChild", "xvel", "yvel", "onViewTouchPositionChanged", "touchX", "touchY", "adx", "ady", "tryCaptureView", "view", "i", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class b
    extends b.a
    implements com.tencent.mm.ui.base.b.b
  {
    private int LCu;
    private int LCv;
    private Rect LCx;
    private final int LCy;
    private boolean ooe;
    
    public b()
    {
      AppMethodBeat.i(304103);
      this.LCu = -1;
      this.LCv = -1;
      this.LCy = 400;
      AppMethodBeat.o(304103);
    }
    
    private static final void a(float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, Rect paramRect, com.tencent.mm.plugin.multitask.animation.c.a.c paramc, int paramInt3, int paramInt4, float paramFloat3)
    {
      AppMethodBeat.i(304120);
      s.u(paramRect, "$potision");
      s.u(paramc, "$view");
      paramFloat1 = (1.0F - paramFloat1) * paramFloat3 + paramFloat1;
      paramFloat3 = paramInt1;
      float f1 = (paramInt2 * paramFloat2 - paramRect.height()) / 2.0F * paramFloat1 * (1.0F / paramFloat2);
      float f2 = paramInt2;
      paramc.setPivotX(paramInt3);
      paramc.setPivotY(paramInt4);
      paramc.setMaskAlpha((int)(255.0F * paramFloat1));
      paramc.t(0.0F, f1, paramFloat3, f2 - f1);
      paramRect = com.tencent.mm.plugin.multitask.animation.c.a.c.LCk;
      paramFloat1 = paramFloat1 * com.tencent.mm.plugin.multitask.animation.c.a.c.gjG() / paramFloat2;
      paramc.a(paramFloat1, paramFloat1, paramFloat1, paramFloat1, paramFloat1, paramFloat1, paramFloat1, paramFloat1);
      paramc.postInvalidate();
      AppMethodBeat.o(304120);
    }
    
    private static final void a(a parama, Bitmap paramBitmap)
    {
      Object localObject = null;
      AppMethodBeat.i(304129);
      s.u(parama, "this$0");
      s.u(paramBitmap, "$bitmap");
      com.tencent.mm.plugin.multitask.c.c localc = parama.LCq;
      if (localc != null) {
        localc.g(paramBitmap, 3);
      }
      if (parama.LCp != null)
      {
        paramBitmap = parama.LCp;
        if (paramBitmap == null)
        {
          paramBitmap = null;
          if (paramBitmap == null) {
            break label120;
          }
          paramBitmap = parama.LCp;
          if (paramBitmap != null) {
            break label98;
          }
        }
        label98:
        for (paramBitmap = localObject;; paramBitmap = paramBitmap.getParent())
        {
          if (paramBitmap != null) {
            break label106;
          }
          parama = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(304129);
          throw parama;
          paramBitmap = paramBitmap.getParent();
          break;
        }
        label106:
        ((ViewGroup)paramBitmap).removeView((View)parama.LCp);
      }
      label120:
      AppMethodBeat.o(304129);
    }
    
    private static final void b(a parama)
    {
      Object localObject2 = null;
      AppMethodBeat.i(304142);
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
          AppMethodBeat.o(304142);
          throw parama;
          localObject1 = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).getParent();
          break;
        }
        label83:
        ((ViewGroup)localObject1).removeView((View)parama.LCp);
      }
      label97:
      AppMethodBeat.o(304142);
    }
    
    private static final void b(a parama, Bitmap paramBitmap)
    {
      AppMethodBeat.i(304135);
      s.u(parama, "this$0");
      s.u(paramBitmap, "$bitmap");
      MMHandlerThread.postToMainThread(new a.b..ExternalSyntheticLambda4(parama, paramBitmap));
      AppMethodBeat.o(304135);
    }
    
    private static final void c(a parama)
    {
      AppMethodBeat.i(304153);
      s.u(parama, "this$0");
      com.tencent.mm.plugin.multitask.c.c localc = parama.LCq;
      if (localc != null)
      {
        localObject = parama.LCp;
        if (localObject == null)
        {
          localObject = null;
          localc.g((Bitmap)localObject, 3);
        }
      }
      else
      {
        if (parama.LCp == null) {
          break label131;
        }
        localObject = parama.LCp;
        if (localObject != null) {
          break label101;
        }
        localObject = null;
        label57:
        if (localObject == null) {
          break label131;
        }
        localObject = parama.LCp;
        if (localObject != null) {
          break label109;
        }
      }
      label101:
      label109:
      for (Object localObject = null;; localObject = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).getParent())
      {
        if (localObject != null) {
          break label117;
        }
        parama = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(304153);
        throw parama;
        localObject = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).getContentBitmap();
        break;
        localObject = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject).getParent();
        break label57;
      }
      label117:
      ((ViewGroup)localObject).removeView((View)parama.LCp);
      label131:
      AppMethodBeat.o(304153);
    }
    
    private final boolean cF(float paramFloat)
    {
      AppMethodBeat.i(304115);
      com.tencent.mm.plugin.multitask.animation.c.a.c localc = this.LCC.LCp;
      Object localObject1 = this.LCC.LCp;
      Bitmap localBitmap;
      a locala;
      int i;
      int j;
      Rect localRect;
      if (localObject1 == null)
      {
        localBitmap = null;
        locala = this.LCC;
        if ((localc == null) || (localBitmap == null)) {
          break label317;
        }
        i = (int)(localBitmap.getWidth() * 1.25F);
        j = (int)(localBitmap.getHeight() * 1.25F);
        localRect = new Rect(0, 0, i, j);
        localObject1 = locala.LCo;
        if (localObject1 != null) {
          break label307;
        }
      }
      label307:
      for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject1).LCj)
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new Rect();
        }
        int k = ((Rect)localObject2).left + ((Rect)localObject2).width() / 2;
        int m = ((Rect)localObject2).top + ((Rect)localObject2).height() / 2;
        float f1 = ((Rect)localObject2).width() / i;
        float f2 = k - (localRect.left + localRect.width() / 2);
        int n = localRect.top;
        float f3 = m - (localRect.height() / 2 + n);
        com.tencent.mm.ui.anim.a.a.kY((View)localc).a(new a.b..ExternalSyntheticLambda0(paramFloat, i, j, f1, (Rect)localObject2, localc, k, m)).aX(new a.b..ExternalSyntheticLambda3(locala, localBitmap)).dU(f1).dV(f1).dS(f2 * f1).dT(f3 * f1).d((Interpolator)new AccelerateInterpolator()).zE(250L).start();
        AppMethodBeat.o(304115);
        return true;
        localBitmap = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).getContentBitmap();
        break;
      }
      label317:
      AppMethodBeat.o(304115);
      return false;
    }
    
    public final void F(int paramInt)
    {
      AppMethodBeat.i(304224);
      Log.d("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", s.X("onViewDragStateChanged, state:", Integer.valueOf(paramInt)));
      AppMethodBeat.o(304224);
    }
    
    public final void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(304253);
      if (this.LCC.LCp != null)
      {
        localObject1 = this.LCC.LCp;
        if ((localObject1 == null) || (((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).getWidth() != 0)) {
          break label75;
        }
        paramInt3 = 1;
        if (paramInt3 == 0)
        {
          localObject1 = this.LCC.LCo;
          if (localObject1 != null) {
            break label81;
          }
        }
      }
      label75:
      label81:
      for (Object localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject1).LCj)
      {
        if (localObject1 != null) {
          break label91;
        }
        AppMethodBeat.o(304253);
        return;
        paramInt3 = 0;
        break;
      }
      label91:
      localObject1 = this.LCC.LCp;
      label125:
      int i;
      label182:
      label205:
      float f2;
      label239:
      Object localObject2;
      int k;
      int m;
      label309:
      label330:
      float f3;
      label351:
      label370:
      float f5;
      if (localObject1 == null)
      {
        paramInt3 = 0;
        localObject1 = this.LCC.LCp;
        if (localObject1 != null) {
          break label536;
        }
        paramInt4 = 0;
        if (this.LCx == null) {
          this.LCx = com.tencent.mm.plugin.multitask.f.c.in((View)this.LCC.LCp);
        }
        if ((this.LCu == -1) && (this.LCv == -1))
        {
          localObject1 = this.LCC.LCp;
          if (localObject1 != null) {
            break label546;
          }
          i = 0;
          this.LCu = i;
          localObject1 = this.LCC.LCp;
          if (localObject1 != null) {
            break label557;
          }
          i = 0;
          this.LCv = i;
        }
        f2 = paramFloat1 / paramInt3 / 3.0F;
        localObject1 = this.LCC.LCo;
        if (localObject1 != null) {
          break label568;
        }
        localObject1 = null;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new Rect();
        }
        f4 = ((Rect)localObject2).width() / paramInt3;
        k = ((Rect)localObject2).left + ((Rect)localObject2).width() / 2;
        m = ((Rect)localObject2).top + ((Rect)localObject2).height() / 2;
        if (f2 <= 1.0F) {
          break label578;
        }
        f1 = 1.0F;
        f2 = 1.0F - f1 * (1.0F - f4);
        if (f2 <= 1.0F) {
          break label595;
        }
        f2 = 1.0F;
        f3 = (1.0F - f2) / (1.0F - f4);
        if (f3 <= 1.0F) {
          break label598;
        }
        f1 = 1.0F;
        f3 = k;
        localObject1 = this.LCx;
        if (localObject1 != null) {
          break label615;
        }
        i = 0;
        localObject1 = this.LCx;
        if (localObject1 != null) {
          break label625;
        }
        j = 0;
        label384:
        f7 = i + j / 2;
        f5 = m;
        localObject1 = this.LCx;
        if (localObject1 != null) {
          break label635;
        }
        i = 0;
        label413:
        localObject1 = this.LCx;
        if (localObject1 != null) {
          break label645;
        }
      }
      label645:
      for (int j = 0;; j = ((Rect)localObject1).height())
      {
        f6 = i + j / 2;
        f3 = this.LCu + (f3 - f7) * f4 * f1;
        f5 = this.LCv + (f5 - f6) * f4 * f1;
        if ((f1 < 0.16F) || (this.ooe)) {
          break label655;
        }
        this.ooe = true;
        if (!cF(f1)) {
          MMHandlerThread.postToMainThread(new a.b..ExternalSyntheticLambda1(this.LCC));
        }
        AppMethodBeat.o(304253);
        return;
        paramInt3 = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).getWidth();
        break;
        label536:
        paramInt4 = ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).getHeight();
        break label125;
        label546:
        i = (int)((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).getTranslationX();
        break label182;
        label557:
        i = (int)((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).getTranslationY();
        break label205;
        label568:
        localObject1 = ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject1).LCj;
        break label239;
        label578:
        f1 = f2;
        if (f2 >= 0.0F) {
          break label309;
        }
        f1 = 0.0F;
        break label309;
        label595:
        break label330;
        label598:
        f1 = f3;
        if (f3 >= 0.0F) {
          break label351;
        }
        f1 = 0.0F;
        break label351;
        label615:
        i = ((Rect)localObject1).left;
        break label370;
        label625:
        j = ((Rect)localObject1).width();
        break label384;
        label635:
        i = ((Rect)localObject1).top;
        break label413;
      }
      label655:
      float f6 = paramInt3;
      float f4 = (paramInt4 * f4 - ((Rect)localObject2).height()) / 2.0F * f1 * (1.0F / f4);
      float f7 = paramInt4;
      localObject1 = this.LCC.LCp;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).setMaskAlpha((int)(255.0F * f1));
      }
      localObject1 = this.LCC.LCp;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).t(0.0F, f4, f6, f7 - f4);
      }
      localObject1 = com.tencent.mm.plugin.multitask.animation.c.a.c.LCk;
      float f1 = com.tencent.mm.plugin.multitask.animation.c.a.c.gjG() * f1 / f2;
      localObject1 = this.LCC.LCp;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).a(f1, f1, f1, f1, f1, f1, f1, f1);
      }
      localObject1 = this.LCC.LCp;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).setPivotX(k);
      }
      localObject1 = this.LCC.LCp;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).setPivotY(m);
      }
      localObject1 = this.LCC.LCp;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).setTranslationX(f3);
      }
      localObject1 = this.LCC.LCp;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).setTranslationY(f5);
      }
      localObject1 = this.LCC.LCp;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).setScaleX(f2);
      }
      localObject1 = this.LCC.LCp;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).setScaleY(f2);
      }
      localObject1 = this.LCC.LCp;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.c)localObject1).postInvalidate();
      }
      Log.d("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", "touchX: %f, touchY: %f, dx: %d, dy: %d, transX: %f, transY: %f, scale: %f ", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(f3), Float.valueOf(f5), Float.valueOf(f2) });
      AppMethodBeat.o(304253);
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
      AppMethodBeat.i(304192);
      paramView = this.LCC.LCo;
      if (paramView == null)
      {
        AppMethodBeat.o(304192);
        return false;
      }
      boolean bool = paramView.ack(paramInt);
      AppMethodBeat.o(304192);
      return bool;
    }
    
    public final void d(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(304210);
      if (this.ooe)
      {
        AppMethodBeat.o(304210);
        return;
      }
      if ((Math.abs(paramFloat1) > this.LCy) && (cF(0.0F)))
      {
        this.ooe = true;
        Log.i("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", "onViewReleased, auto add multitask!");
        AppMethodBeat.o(304210);
        return;
      }
      MMHandlerThread.postToMainThread(new a.b..ExternalSyntheticLambda2(this.LCC));
      this.LCC.LCr = -1L;
      paramView = this.LCC.gjH().getContentView();
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      AppMethodBeat.o(304210);
    }
    
    public final void gjF()
    {
      AppMethodBeat.i(304234);
      Log.i("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", "onViewCaptured");
      a.a(this.LCC);
      this.LCu = -1;
      this.LCv = -1;
      this.ooe = false;
      AppMethodBeat.o(304234);
    }
    
    public final void m(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    public final void onComplete(boolean paramBoolean)
    {
      AppMethodBeat.i(304230);
      Log.d("MicroMsg.MultiTaskSwipeBackAndEnterAnimWrapperSS", "onComplete");
      AppMethodBeat.o(304230);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/animation/swipeback/singlescene/MultiTaskSwipeBackAnimWrapperSS$onCreate$1", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;", "canInterceptTouchEvent", "", "enableSwipeBack", "getSwipeBackTouchState", "", "onDispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onEdgeDragStarted", "edgeFlags", "pointerId", "onPositionChange", "scrollPercent", "", "onSwipeReleased", "willSwipeBack", "shouldInterceptTouchEvent", "ev", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.plugin.multitask.a.a.a
  {
    c(a parama, com.tencent.mm.plugin.multitask.b.b paramb) {}
    
    public final void aci(int paramInt) {}
    
    public final void cC(float paramFloat) {}
    
    public final boolean gjA()
    {
      AppMethodBeat.i(304145);
      a locala;
      if (this.LCC.LCr == -1L)
      {
        locala = this.LCC;
        localObject = paramb;
        if (localObject != null) {
          break label66;
        }
      }
      label66:
      for (Object localObject = null;; localObject = Boolean.valueOf(((com.tencent.mm.plugin.multitask.b.b)localObject).gjV()))
      {
        locala.LCs = ((Boolean)localObject).booleanValue();
        this.LCC.LCr = 0L;
        boolean bool = this.LCC.LCs;
        AppMethodBeat.o(304145);
        return bool;
      }
    }
    
    public final boolean gjy()
    {
      AppMethodBeat.i(304122);
      boolean bool = paramb.gjR();
      AppMethodBeat.o(304122);
      return bool;
    }
    
    public final int gjz()
    {
      com.tencent.mm.plugin.multitask.animation.c.a.b localb = this.LCC.LCo;
      if (localb == null) {
        return 0;
      }
      return localb.LCe;
    }
    
    public final boolean i(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(304128);
      s.u(paramMotionEvent, "ev");
      com.tencent.mm.plugin.multitask.animation.c.a.b localb = this.LCC.LCo;
      if (localb == null)
      {
        AppMethodBeat.o(304128);
        return false;
      }
      boolean bool = localb.i(paramMotionEvent);
      AppMethodBeat.o(304128);
      return bool;
    }
    
    public final void n(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(304113);
      s.u(paramMotionEvent, "event");
      com.tencent.mm.plugin.multitask.animation.c.a.b localb = this.LCC.LCo;
      if (localb != null) {
        localb.j(paramMotionEvent);
      }
      AppMethodBeat.o(304113);
    }
    
    public final int zE(boolean paramBoolean)
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.c.c.a
 * JD-Core Version:    0.7.0.1
 */