package com.tencent.mm.plugin.multitask.animation.c.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.g.j;
import androidx.core.g.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "", "context", "Landroid/content/Context;", "forParent", "Landroid/view/ViewGroup;", "cb", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Callback;", "interpolator", "Landroid/view/animation/Interpolator;", "(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Callback;Landroid/view/animation/Interpolator;)V", "<set-?>", "", "activePointerId", "getActivePointerId", "()I", "Landroid/view/View;", "capturedView", "getCapturedView", "()Landroid/view/View;", "edgeSize", "getEdgeSize", "setEdgeSize", "(I)V", "mCallback", "mEdgeDragsInProgress", "", "mEdgeDragsLocked", "mInitialEdgesTouched", "mInitialMotionX", "", "mInitialMotionY", "mLastMotionX", "mLastMotionY", "mParentView", "mPointersDown", "mReleaseInProgress", "", "mScroller", "Landroid/widget/OverScroller;", "mSetIdleRunnable", "Ljava/lang/Runnable;", "mTrackingEdges", "mVelocityTracker", "Landroid/view/VelocityTracker;", "maxVelocity", "", "getMaxVelocity", "()F", "setMaxVelocity", "(F)V", "minVelocity", "getMinVelocity", "setMinVelocity", "positon", "Landroid/graphics/Rect;", "targetPositon", "getTargetPositon", "()Landroid/graphics/Rect;", "setTargetPositon", "(Landroid/graphics/Rect;)V", "touchSlop", "getTouchSlop", "viewDragState", "getViewDragState", "abort", "", "canScroll", "v", "checkV", "dx", "dy", "x", "y", "cancel", "captureChildView", "childView", "checkNewEdgeDrag", "delta", "odelta", "pointerId", "edge", "checkTouchSlop", "child", "directions", "clampMag", "value", "absMin", "absMax", "clearMotionHistory", "computeAxisDuration", "velocity", "motionRange", "computeSettleDuration", "xvel", "yvel", "continueSettling", "deferCallbacks", "(Z)Ljava/lang/Boolean;", "dispatchViewReleased", "distanceInfluenceForSnapDuration", "f", "dragTo", "left", "top", "ensureMotionHistorySizeForId", "findTopChildUnder", "flingCapturedView", "minLeft", "minTop", "maxLeft", "maxTop", "forceSettleCapturedViewAt", "finalLeft", "finalTop", "duration", "", "withNoAnim", "getEdgesTouched", "isCapturedViewUnder", "isDragging", "isEdgeTouched", "edges", "isFinished", "isPointerDown", "isViewUnder", "view", "moveTo", "adx", "ady", "processTouchEvent", "ev", "Landroid/view/MotionEvent;", "releaseViewForPointerUp", "reportNewEdgeDrags", "saveInitialMotion", "saveLastMotion", "setDragState", "state", "setEdgeTrackingEnabled", "edgeFlags", "settleCapturedViewAt", "shouldInterceptTouchEvent", "smoothSlideViewTo", "tryCaptureViewForDrag", "toCapture", "Callback", "Companion", "plugin-multitask_release"})
public final class b
{
  public static final b FGp;
  private static final Interpolator sInterpolator;
  public int FGj;
  public float FGk;
  private int FGl;
  public final a FGm;
  public View FGn;
  public Rect FGo;
  public final OverScroller Qi;
  private float[] Ri;
  private float[] Rj;
  private float[] Rk;
  private float[] Rl;
  private int[] Rm;
  private int[] Rn;
  private int[] Ro;
  private int Rp;
  public int Rt;
  public boolean Rw;
  public final ViewGroup Rx;
  public final Runnable Ry;
  public int bvF;
  public int bvH;
  public VelocityTracker mVelocityTracker;
  public float rti;
  
  static
  {
    AppMethodBeat.i(248922);
    FGp = new b((byte)0);
    sInterpolator = (Interpolator)b.c.FGq;
    AppMethodBeat.o(248922);
  }
  
  private b(Context paramContext, ViewGroup paramViewGroup, a parama, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(248920);
    this.bvF = -1;
    this.FGo = new Rect();
    this.Ry = ((Runnable)new d(this));
    if (paramViewGroup == null)
    {
      paramContext = (Throwable)new IllegalArgumentException("Parent view may not be null".toString());
      AppMethodBeat.o(248920);
      throw paramContext;
    }
    if (parama == null)
    {
      paramContext = (Throwable)new IllegalArgumentException("Callback may not be null".toString());
      AppMethodBeat.o(248920);
      throw paramContext;
    }
    this.Rx = paramViewGroup;
    this.FGm = parama;
    paramViewGroup = ViewConfiguration.get(paramContext);
    parama = paramContext.getResources();
    p.j(parama, "context.resources");
    this.FGl = ((int)(parama.getDisplayMetrics().density * 20.0F + 0.5F));
    p.j(paramViewGroup, "vc");
    this.bvH = paramViewGroup.getScaledTouchSlop();
    this.rti = paramViewGroup.getScaledMaximumFlingVelocity();
    this.FGk = paramViewGroup.getScaledMinimumFlingVelocity();
    this.Qi = new OverScroller(paramContext, paramInterpolator);
    AppMethodBeat.o(248920);
  }
  
  private View K(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248918);
    int i = this.Rx.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.Rx.getChildAt(i);
      p.j(localView, "child");
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom()))
      {
        AppMethodBeat.o(248918);
        return localView;
      }
      i -= 1;
    }
    AppMethodBeat.o(248918);
    return null;
  }
  
  private final int M(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(248882);
    paramInt3 = f(paramInt3, (int)this.FGk, (int)this.rti);
    paramInt4 = f(paramInt4, (int)this.FGk, (int)this.rti);
    int i = Math.abs(paramInt1);
    int j = Math.abs(paramInt2);
    int k = Math.abs(paramInt3);
    int m = Math.abs(paramInt4);
    int n = k + m;
    int i1 = i + j;
    float f1;
    if (paramInt3 != 0)
    {
      f1 = k / n;
      if (paramInt4 == 0) {
        break label164;
      }
    }
    label164:
    for (float f2 = m / n;; f2 = j / i1)
    {
      paramInt1 = e(paramInt1, paramInt3, this.FGm.aEe());
      paramInt2 = e(paramInt2, paramInt4, 0);
      float f3 = paramInt1;
      paramInt1 = (int)(f2 * paramInt2 + f1 * f3);
      AppMethodBeat.o(248882);
      return paramInt1;
      f1 = i / i1;
      break;
    }
  }
  
  private final void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(248891);
    Object localObject1;
    if (this.Ri != null)
    {
      localObject1 = this.Ri;
      if (localObject1 == null) {
        break label500;
      }
    }
    label500:
    for (int i = localObject1.length;; i = 0)
    {
      if (i <= paramInt)
      {
        localObject1 = new float[paramInt + 1];
        float[] arrayOfFloat1 = new float[paramInt + 1];
        float[] arrayOfFloat2 = new float[paramInt + 1];
        float[] arrayOfFloat3 = new float[paramInt + 1];
        int[] arrayOfInt1 = new int[paramInt + 1];
        int[] arrayOfInt2 = new int[paramInt + 1];
        int[] arrayOfInt3 = new int[paramInt + 1];
        Object localObject2 = this.Ri;
        Object localObject3 = this.Rj;
        Object localObject4 = this.Rk;
        float[] arrayOfFloat4 = this.Rl;
        if ((localObject2 != null) && (localObject3 != null) && (localObject4 != null) && (arrayOfFloat4 != null))
        {
          System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
          System.arraycopy(localObject3, 0, arrayOfFloat1, 0, localObject3.length);
          System.arraycopy(localObject4, 0, arrayOfFloat2, 0, localObject4.length);
          System.arraycopy(arrayOfFloat4, 0, arrayOfFloat3, 0, arrayOfFloat4.length);
        }
        localObject2 = this.Rm;
        localObject3 = this.Rn;
        localObject4 = this.Ro;
        if ((localObject2 != null) && (localObject3 != null) && (localObject4 != null))
        {
          System.arraycopy(localObject2, 0, arrayOfInt1, 0, localObject2.length);
          System.arraycopy(localObject3, 0, arrayOfInt2, 0, localObject3.length);
          System.arraycopy(localObject4, 0, arrayOfInt3, 0, localObject4.length);
        }
        this.Ri = ((float[])localObject1);
        this.Rj = arrayOfFloat1;
        this.Rk = arrayOfFloat2;
        this.Rl = arrayOfFloat3;
        this.Rm = arrayOfInt1;
        this.Rn = arrayOfInt2;
        this.Ro = arrayOfInt3;
      }
      localObject1 = this.Rk;
      if (localObject1 != null) {
        localObject1[paramInt] = paramFloat1;
      }
      localObject1 = this.Ri;
      if (localObject1 != null) {
        localObject1[paramInt] = paramFloat1;
      }
      localObject1 = this.Rl;
      if (localObject1 != null) {
        localObject1[paramInt] = paramFloat2;
      }
      localObject1 = this.Rj;
      if (localObject1 != null) {
        localObject1[paramInt] = paramFloat2;
      }
      localObject1 = this.Rm;
      if (localObject1 != null)
      {
        int m = (int)paramFloat1;
        int k = (int)paramFloat2;
        int j = 0;
        if (m < this.Rx.getLeft() + this.FGl) {
          j = 1;
        }
        i = j;
        if (k < this.Rx.getTop() + this.FGl) {
          i = j | 0x4;
        }
        j = i;
        if (m > this.Rx.getRight() - this.FGl) {
          j = i | 0x2;
        }
        i = j;
        if (k > this.Rx.getBottom() - this.FGl) {
          i = j | 0x8;
        }
        localObject1[paramInt] = i;
      }
      this.Rp |= 1 << paramInt;
      AppMethodBeat.o(248891);
      return;
    }
  }
  
  private final boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248910);
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    int[] arrayOfInt = this.Rm;
    if (arrayOfInt != null)
    {
      i = arrayOfInt[paramInt1];
      if (((i & paramInt2) == paramInt2) && ((this.Rt & paramInt2) != 0))
      {
        arrayOfInt = this.Ro;
        if (arrayOfInt == null) {
          break label141;
        }
        i = arrayOfInt[paramInt1];
        label70:
        if ((i & paramInt2) != paramInt2)
        {
          arrayOfInt = this.Rn;
          if (arrayOfInt == null) {
            break label147;
          }
        }
      }
    }
    label141:
    label147:
    for (int i = arrayOfInt[paramInt1];; i = 0)
    {
      if (((i & paramInt2) != paramInt2) && ((paramFloat1 > this.bvH) || (paramFloat2 > this.bvH))) {
        break label153;
      }
      AppMethodBeat.o(248910);
      return false;
      i = 0;
      break;
      i = 0;
      break label70;
    }
    label153:
    arrayOfInt = this.Rn;
    if (arrayOfInt != null) {}
    for (paramInt1 = arrayOfInt[paramInt1]; ((paramInt1 & paramInt2) == 0) && (paramFloat1 > this.bvH); paramInt1 = 0)
    {
      AppMethodBeat.o(248910);
      return true;
    }
    AppMethodBeat.o(248910);
    return false;
  }
  
  private final void ac(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(248917);
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker != null) {
      localVelocityTracker.computeCurrentVelocity(1000, this.rti);
    }
    o(e(v.a(this.mVelocityTracker, this.bvF), this.FGk, this.rti), e(v.b(this.mVelocityTracker, this.bvF), this.FGk, this.rti), paramFloat1, paramFloat2);
    AppMethodBeat.o(248917);
  }
  
  private final void b(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(248908);
    if (a(paramFloat1, paramFloat2, paramInt, 1)) {}
    for (;;)
    {
      int i = j;
      if (a(paramFloat2, paramFloat1, paramInt, 4)) {
        i = j | 0x4;
      }
      j = i;
      if (a(paramFloat1, paramFloat2, paramInt, 2)) {
        j = i | 0x2;
      }
      i = j;
      if (a(paramFloat2, paramFloat1, paramInt, 8)) {
        i = j | 0x8;
      }
      if (i != 0)
      {
        int[] arrayOfInt = this.Rn;
        if (arrayOfInt != null)
        {
          arrayOfInt[paramInt] = (i | arrayOfInt[paramInt]);
          AppMethodBeat.o(248908);
          return;
        }
      }
      AppMethodBeat.o(248908);
      return;
      j = 0;
    }
  }
  
  private final void bP(int paramInt)
  {
    if (this.Ri != null)
    {
      localObject = this.Ri;
      if (localObject == null) {
        break label25;
      }
    }
    label25:
    for (int i = localObject.length; i <= paramInt; i = 0) {
      return;
    }
    Object localObject = this.Ri;
    if (localObject != null) {
      localObject[paramInt] = 0.0F;
    }
    localObject = this.Rj;
    if (localObject != null) {
      localObject[paramInt] = 0.0F;
    }
    localObject = this.Rk;
    if (localObject != null) {
      localObject[paramInt] = 0.0F;
    }
    localObject = this.Rl;
    if (localObject != null) {
      localObject[paramInt] = 0.0F;
    }
    localObject = this.Rm;
    if (localObject != null) {
      localObject[paramInt] = 0;
    }
    localObject = this.Rn;
    if (localObject != null) {
      localObject[paramInt] = 0;
    }
    localObject = this.Ro;
    if (localObject != null) {
      localObject[paramInt] = 0;
    }
    this.Rp &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  private boolean bQ(int paramInt)
  {
    return (this.Rp & 0x1) << paramInt != 0;
  }
  
  private static float distanceInfluenceForSnapDuration(float paramFloat)
  {
    AppMethodBeat.i(248888);
    paramFloat = (float)Math.sin((paramFloat - 0.5F) * 0.4712389F);
    AppMethodBeat.o(248888);
    return paramFloat;
  }
  
  private static float e(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(248886);
    float f = Math.abs(paramFloat1);
    if (f < paramFloat2)
    {
      AppMethodBeat.o(248886);
      return 0.0F;
    }
    if (f > paramFloat3)
    {
      if (paramFloat1 > 0.0F)
      {
        AppMethodBeat.o(248886);
        return paramFloat3;
      }
      paramFloat1 = -paramFloat3;
      AppMethodBeat.o(248886);
      return paramFloat1;
    }
    AppMethodBeat.o(248886);
    return paramFloat1;
  }
  
  private final int e(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(248884);
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(248884);
      return 0;
    }
    int i = this.Rx.getWidth();
    int j = i / 2;
    float f3 = Math.min(1.0F, Math.abs(paramInt1) / i);
    float f1 = j;
    float f2 = j;
    f3 = distanceInfluenceForSnapDuration(f3);
    paramInt2 = Math.abs(paramInt2);
    if (paramInt2 > 0) {}
    for (paramInt1 = Math.round(Math.abs((f3 * f2 + f1) / paramInt2) * 1000.0F) * 4;; paramInt1 = (int)((Math.abs(paramInt1) / paramInt3 + 1.0F) * 256.0F))
    {
      paramInt1 = Math.min(paramInt1, 350);
      AppMethodBeat.o(248884);
      return paramInt1;
    }
  }
  
  private static int f(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(248885);
    int i = Math.abs(paramInt1);
    if (i < paramInt2)
    {
      AppMethodBeat.o(248885);
      return 0;
    }
    if (i > paramInt3)
    {
      if (paramInt1 > 0)
      {
        AppMethodBeat.o(248885);
        return paramInt3;
      }
      paramInt1 = -paramInt3;
      AppMethodBeat.o(248885);
      return paramInt1;
    }
    AppMethodBeat.o(248885);
    return paramInt1;
  }
  
  private final void h(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(248893);
    int j = j.f(paramMotionEvent);
    int i = 0;
    while (i < j)
    {
      int k = j.d(paramMotionEvent, i);
      float f1 = j.e(paramMotionEvent, i);
      float f2 = j.f(paramMotionEvent, i);
      float[] arrayOfFloat1 = this.Rk;
      float[] arrayOfFloat2 = this.Rl;
      if ((arrayOfFloat1 != null) && (arrayOfFloat2 != null) && (arrayOfFloat1.length > k) && (arrayOfFloat2.length > k))
      {
        arrayOfFloat1[k] = f1;
        arrayOfFloat2[k] = f2;
      }
      i += 1;
    }
    AppMethodBeat.o(248893);
  }
  
  private final void o(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(248889);
    this.Rw = true;
    this.FGm.c(this.FGn, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    this.Rw = false;
    if (this.FGj == 1) {
      bR(0);
    }
    AppMethodBeat.o(248889);
  }
  
  private final boolean r(View paramView, float paramFloat)
  {
    AppMethodBeat.i(248912);
    if (paramView == null)
    {
      AppMethodBeat.o(248912);
      return false;
    }
    int i;
    if (this.FGm.aEe() > 0) {
      i = 1;
    }
    while (i != 0) {
      if (Math.abs(paramFloat) > this.bvH)
      {
        AppMethodBeat.o(248912);
        return true;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(248912);
        return false;
      }
    }
    AppMethodBeat.o(248912);
    return false;
  }
  
  private boolean y(View paramView, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(248899);
    if ((paramView == this.FGn) && (this.bvF == paramInt))
    {
      AppMethodBeat.o(248899);
      return true;
    }
    if ((paramView != null) && (this.FGm.b(paramView, paramInt)))
    {
      this.bvF = paramInt;
      p.k(paramView, "childView");
      if (paramView.getParent() == this.Rx) {
        i = 1;
      }
      if (i == 0)
      {
        paramView = (Throwable)new IllegalArgumentException(("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.Rx + ")").toString());
        AppMethodBeat.o(248899);
        throw paramView;
      }
      this.FGn = paramView;
      this.bvF = paramInt;
      this.FGm.faA();
      bR(1);
      AppMethodBeat.o(248899);
      return true;
    }
    AppMethodBeat.o(248899);
    return false;
  }
  
  public final boolean XX(int paramInt)
  {
    AppMethodBeat.i(248916);
    if (bQ(paramInt))
    {
      int[] arrayOfInt = this.Rm;
      if (arrayOfInt != null) {}
      for (paramInt = arrayOfInt[paramInt]; (paramInt & 0x1) != 0; paramInt = 0)
      {
        AppMethodBeat.o(248916);
        return true;
      }
    }
    AppMethodBeat.o(248916);
    return false;
  }
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(248880);
    View localView = this.FGn;
    int i;
    if (localView != null)
    {
      i = localView.getLeft();
      localView = this.FGn;
      if (localView == null) {
        break label86;
      }
    }
    label86:
    for (int j = localView.getTop();; j = 0)
    {
      paramInt1 -= i;
      paramInt2 -= j;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label92;
      }
      this.Qi.abortAnimation();
      bR(0);
      AppMethodBeat.o(248880);
      return false;
      i = 0;
      break;
    }
    label92:
    this.Qi.forceFinished(true);
    if ((paramLong == 0L) && (!paramBoolean)) {
      paramLong = M(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    for (;;)
    {
      Log.d("MultiTaskSwipeDragHelper", "chrispaulwu:: xvel %d, yvel %d, dx %d, dy %d duration %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
      this.Qi.startScroll(i, j, paramInt1, paramInt2, (int)paramLong);
      bR(2);
      AppMethodBeat.o(248880);
      return true;
      if (paramBoolean) {
        paramLong = 0L;
      }
    }
  }
  
  public final boolean a(View paramView, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(248877);
    this.FGn = paramView;
    this.bvF = -1;
    paramBoolean = a(paramInt1, paramInt2, 0, 0, paramLong, paramBoolean);
    AppMethodBeat.o(248877);
    return paramBoolean;
  }
  
  public final void bR(int paramInt)
  {
    AppMethodBeat.i(248898);
    if (this.FGj != paramInt)
    {
      this.FGj = paramInt;
      this.FGm.G(paramInt);
      if (paramInt == 0) {
        this.FGn = null;
      }
    }
    AppMethodBeat.o(248898);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(248874);
    this.bvF = -1;
    if (this.Ri != null)
    {
      Arrays.fill(this.Ri, 0.0F);
      Arrays.fill(this.Rj, 0.0F);
      Arrays.fill(this.Rk, 0.0F);
      Arrays.fill(this.Rl, 0.0F);
      Arrays.fill(this.Rm, 0);
      Arrays.fill(this.Rn, 0);
      Arrays.fill(this.Ro, 0);
      this.Rp = 0;
    }
    if (this.mVelocityTracker != null)
    {
      VelocityTracker localVelocityTracker = this.mVelocityTracker;
      if (localVelocityTracker != null) {
        localVelocityTracker.recycle();
      }
      this.mVelocityTracker = null;
    }
    AppMethodBeat.o(248874);
  }
  
  public final void hL()
  {
    AppMethodBeat.i(248876);
    cancel();
    if (this.FGj == 2)
    {
      int i = this.Qi.getCurrX();
      int j = this.Qi.getCurrY();
      this.Qi.abortAnimation();
      int k = this.Qi.getCurrX();
      int m = this.Qi.getCurrY();
      this.FGm.l(this.FGn, k, m, k - i, m - j);
    }
    bR(0);
    AppMethodBeat.o(248876);
  }
  
  public final boolean i(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(248901);
    p.k(paramMotionEvent, "ev");
    int j = j.d(paramMotionEvent);
    int i = j.e(paramMotionEvent);
    if (j == 0) {
      cancel();
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    Object localObject = this.mVelocityTracker;
    if (localObject != null) {
      ((VelocityTracker)localObject).addMovement(paramMotionEvent);
    }
    switch (j)
    {
    }
    while (this.FGj == 1)
    {
      AppMethodBeat.o(248901);
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      i = j.d(paramMotionEvent, 0);
      a(f1, f2, i);
      paramMotionEvent = K((int)f1, (int)f2);
      if ((paramMotionEvent == this.FGn) && (this.FGj == 2)) {
        y(paramMotionEvent, i);
      }
      paramMotionEvent = this.Rm;
      if (paramMotionEvent != null) {}
      for (paramMotionEvent = Integer.valueOf(paramMotionEvent[i]); paramMotionEvent != null; paramMotionEvent = null)
      {
        ((Number)paramMotionEvent).intValue();
        break;
      }
      j = j.d(paramMotionEvent, i);
      f1 = j.e(paramMotionEvent, i);
      f2 = j.f(paramMotionEvent, i);
      a(f1, f2, j);
      if (this.FGj == 0)
      {
        paramMotionEvent = this.Rm;
        if (paramMotionEvent != null) {}
        for (paramMotionEvent = Integer.valueOf(paramMotionEvent[j]); paramMotionEvent != null; paramMotionEvent = null)
        {
          ((Number)paramMotionEvent).intValue();
          if ((paramMotionEvent.intValue() & this.Rt) == 0) {
            break;
          }
          paramMotionEvent.intValue();
          break;
        }
      }
      label403:
      label442:
      label574:
      label579:
      label584:
      label590:
      if (this.FGj == 2)
      {
        paramMotionEvent = K((int)f1, (int)f2);
        label465:
        if (paramMotionEvent == this.FGn)
        {
          y(paramMotionEvent, j);
          continue;
          h(paramMotionEvent);
          int m = j.f(paramMotionEvent);
          i = 0;
          label360:
          if (i < m)
          {
            int n = j.d(paramMotionEvent, i);
            if ((this.Ri != null) && (n >= 0))
            {
              localObject = this.Ri;
              float f3;
              if (localObject != null)
              {
                j = localObject.length;
                if (n >= j) {
                  continue;
                }
                f3 = j.e(paramMotionEvent, i);
                f2 = j.f(paramMotionEvent, i);
                localObject = this.Ri;
                if (localObject == null) {
                  break label574;
                }
                f1 = localObject[n];
                f3 -= f1;
                localObject = this.Rj;
                if (localObject == null) {
                  break label579;
                }
                f1 = localObject[n];
                b(f3, f2 - f1, n);
                if (this.FGj == 1) {
                  continue;
                }
                localObject = this.Ri;
                if (localObject == null) {
                  break label584;
                }
                j = (int)localObject[n];
                label503:
                localObject = this.Rj;
                if (localObject == null) {
                  break label590;
                }
              }
              for (int k = (int)localObject[n];; k = 0)
              {
                localObject = K(j, k);
                if ((localObject != null) && (r((View)localObject, f3)) && (y((View)localObject, n))) {
                  break;
                }
                i += 1;
                break label360;
                j = 0;
                break label403;
                f1 = 0.0F;
                break label442;
                f1 = 0.0F;
                break label465;
                j = 0;
                break label503;
              }
              bP(j.d(paramMotionEvent, i));
              continue;
              cancel();
            }
          }
        }
      }
    }
    AppMethodBeat.o(248901);
    return false;
  }
  
  public final boolean iq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248915);
    if (!bQ(paramInt2))
    {
      AppMethodBeat.o(248915);
      return false;
    }
    int i;
    int j;
    label42:
    int k;
    if ((paramInt1 & 0x1) == 1)
    {
      i = 1;
      if ((paramInt1 & 0x2) != 2) {
        break label175;
      }
      j = 1;
      if ((paramInt1 & 0x8) != 8) {
        break label181;
      }
      k = 1;
      label54:
      if ((paramInt1 & 0x4) != 4) {
        break label187;
      }
    }
    float f1;
    float f2;
    label175:
    label181:
    label187:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      float[] arrayOfFloat1 = this.Rk;
      float[] arrayOfFloat2 = this.Rl;
      float[] arrayOfFloat3 = this.Ri;
      float[] arrayOfFloat4 = this.Rj;
      if ((arrayOfFloat1 == null) || (arrayOfFloat2 == null) || (arrayOfFloat3 == null) || (arrayOfFloat4 == null)) {
        break label356;
      }
      f1 = arrayOfFloat1[paramInt2] - arrayOfFloat3[paramInt2];
      f2 = arrayOfFloat2[paramInt2] - arrayOfFloat4[paramInt2];
      if ((i == 0) || (j == 0)) {
        break label200;
      }
      if (f1 * f1 + f2 * f2 <= this.bvH * this.bvH) {
        break label192;
      }
      AppMethodBeat.o(248915);
      return true;
      i = 0;
      break;
      j = 0;
      break label42;
      k = 0;
      break label54;
    }
    label192:
    AppMethodBeat.o(248915);
    return false;
    label200:
    if (paramInt1 != 0)
    {
      if ((f1 < this.bvH) && (Math.abs(f1) > Math.abs(f2)))
      {
        AppMethodBeat.o(248915);
        return true;
      }
      AppMethodBeat.o(248915);
      return false;
    }
    if (k != 0)
    {
      if ((f1 > this.bvH) && (Math.abs(f1) > Math.abs(f2)))
      {
        AppMethodBeat.o(248915);
        return true;
      }
      AppMethodBeat.o(248915);
      return false;
    }
    if (i != 0)
    {
      if (Math.abs(f1) > this.bvH)
      {
        AppMethodBeat.o(248915);
        return true;
      }
      AppMethodBeat.o(248915);
      return false;
    }
    if (j != 0)
    {
      if (Math.abs(f2) > this.bvH)
      {
        AppMethodBeat.o(248915);
        return true;
      }
      AppMethodBeat.o(248915);
      return false;
    }
    label356:
    AppMethodBeat.o(248915);
    return false;
  }
  
  public final void j(MotionEvent paramMotionEvent)
  {
    float f3 = 0.0F;
    float f2 = 0.0F;
    int i = 0;
    int k = 0;
    int m = 0;
    int j = 0;
    AppMethodBeat.i(248905);
    p.k(paramMotionEvent, "ev");
    int i1 = j.d(paramMotionEvent);
    int n = j.e(paramMotionEvent);
    if (i1 == 0) {
      cancel();
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    Object localObject = this.mVelocityTracker;
    if (localObject != null) {
      ((VelocityTracker)localObject).addMovement(paramMotionEvent);
    }
    float f1;
    label454:
    float f4;
    label547:
    label938:
    label1331:
    switch (i1)
    {
    case 4: 
    default: 
    case 0: 
    case 5: 
      do
      {
        AppMethodBeat.o(248905);
        return;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        i = j.d(paramMotionEvent, 0);
        paramMotionEvent = K((int)f1, (int)f2);
        a(f1, f2, i);
        y(paramMotionEvent, i);
        paramMotionEvent = this.Rm;
        if (paramMotionEvent != null) {}
        for (paramMotionEvent = Integer.valueOf(paramMotionEvent[i]); paramMotionEvent != null; paramMotionEvent = null)
        {
          ((Number)paramMotionEvent).intValue();
          if ((paramMotionEvent.intValue() & this.Rt) != 0) {
            paramMotionEvent.intValue();
          }
          AppMethodBeat.o(248905);
          return;
        }
        AppMethodBeat.o(248905);
        return;
        k = j.d(paramMotionEvent, n);
        f1 = j.e(paramMotionEvent, n);
        f2 = j.f(paramMotionEvent, n);
        a(f1, f2, k);
        if (this.FGj != 0) {
          break;
        }
        y(K((int)f1, (int)f2), k);
      } while (this.Rm != null);
      AppMethodBeat.o(248905);
      return;
      m = (int)f1;
      n = (int)f2;
      paramMotionEvent = this.FGn;
      i = j;
      if (paramMotionEvent != null)
      {
        i = j;
        if (m >= paramMotionEvent.getLeft())
        {
          i = j;
          if (m < paramMotionEvent.getRight())
          {
            i = j;
            if (n >= paramMotionEvent.getTop())
            {
              i = j;
              if (n < paramMotionEvent.getBottom()) {
                i = 1;
              }
            }
          }
        }
      }
      if (i != 0) {
        y(this.FGn, k);
      }
      AppMethodBeat.o(248905);
      return;
    case 2: 
      if (this.FGj == 1)
      {
        if (this.Ri != null)
        {
          localObject = this.Ri;
          if (localObject == null) {
            break label454;
          }
        }
        for (i = localObject.length; i <= this.bvF; i = 0)
        {
          AppMethodBeat.o(248905);
          return;
        }
        j = j.c(paramMotionEvent, this.bvF);
        i = j;
        if (j < 0) {
          i = 0;
        }
        f3 = j.e(paramMotionEvent, i);
        f4 = j.f(paramMotionEvent, i);
        localObject = this.Rk;
        int i2;
        if (localObject != null)
        {
          f1 = localObject[this.bvF];
          i1 = (int)((f3 - f1) / 1.666667F);
          localObject = this.Rl;
          if (localObject == null) {
            break label844;
          }
          f1 = localObject[this.bvF];
          i2 = (int)((f4 - f1) / 1.666667F);
          localObject = this.FGn;
          if (localObject == null) {
            break label849;
          }
          i = ((View)localObject).getLeft();
          n = i + i1;
          localObject = this.FGn;
          if (localObject == null) {
            break label855;
          }
          i = ((View)localObject).getTop();
          i += i2;
          localObject = this.FGn;
          if (localObject == null) {
            break label861;
          }
          j = ((View)localObject).getLeft();
          localObject = this.FGn;
          if (localObject == null) {
            break label867;
          }
          k = ((View)localObject).getTop();
          m = n;
          if (i1 != 0)
          {
            n = this.FGm.XY(n);
            localObject = this.FGn;
            m = n;
            if (localObject != null)
            {
              ((View)localObject).offsetLeftAndRight(n - j);
              m = n;
            }
          }
          if (i2 != 0)
          {
            localObject = this.FGn;
            if (localObject == null) {
              break label873;
            }
            ((View)localObject).offsetTopAndBottom(0 - k);
            i = 0;
          }
          if ((i1 != 0) || (i2 != 0)) {
            this.FGm.l(this.FGn, m, i, m - j, i - k);
          }
          localObject = this.Ri;
          if (localObject == null) {
            break label879;
          }
        }
        for (f1 = localObject[this.bvF];; f1 = 0.0F)
        {
          localObject = this.Rj;
          if (localObject != null) {
            f2 = localObject[this.bvF];
          }
          i = (int)(f3 - f1);
          j = (int)(f4 - f2);
          this.FGm.a(f3, f4, i1, i2, i, j);
          h(paramMotionEvent);
          AppMethodBeat.o(248905);
          return;
          f1 = 0.0F;
          break;
          f1 = 0.0F;
          break label547;
          i = 0;
          break label576;
          i = 0;
          break label601;
          j = 0;
          break label626;
          k = 0;
          break label644;
          i = 0;
          break label721;
        }
      }
      m = j.f(paramMotionEvent);
      i = 0;
      if (i < m)
      {
        n = j.d(paramMotionEvent, i);
        if (this.Ri != null)
        {
          localObject = this.Ri;
          if (localObject == null) {
            break label950;
          }
          j = localObject.length;
          if (j > n) {
            break label956;
          }
        }
      }
      do
      {
        h(paramMotionEvent);
        AppMethodBeat.o(248905);
        return;
        j = 0;
        break;
        f3 = j.e(paramMotionEvent, i);
        f2 = j.f(paramMotionEvent, i);
        localObject = this.Ri;
        if (localObject == null) {
          break label1109;
        }
        f1 = localObject[n];
        f3 -= f1;
        localObject = this.Rj;
        if (localObject == null) {
          break label1114;
        }
        f1 = localObject[n];
        b(f3, f2 - f1, n);
      } while (this.FGj == 1);
      localObject = this.Ri;
      if (localObject != null)
      {
        j = (int)localObject[n];
        localObject = this.Rj;
        if (localObject == null) {
          break label1125;
        }
      }
      for (k = (int)localObject[n];; k = 0)
      {
        localObject = K(j, k);
        if ((r((View)localObject, f3)) && (y((View)localObject, n))) {
          break label938;
        }
        i += 1;
        break;
        f1 = 0.0F;
        break label988;
        f1 = 0.0F;
        break label1011;
        j = 0;
        break label1049;
      }
    case 6: 
      label950:
      label956:
      label1109:
      label1114:
      m = j.d(paramMotionEvent, n);
      if ((this.FGj == 1) && (m == this.bvF))
      {
        k = -1;
        n = j.f(paramMotionEvent);
      }
      for (;;)
      {
        j = k;
        if (i < n)
        {
          j = j.d(paramMotionEvent, i);
          if (j == this.bvF)
          {
            i += 1;
            continue;
          }
          f1 = j.e(paramMotionEvent, i);
          f2 = j.f(paramMotionEvent, i);
          if ((K((int)f1, (int)f2) == this.FGn) && (y(this.FGn, j))) {
            j = this.bvF;
          }
        }
        else
        {
          if (j == -1) {
            ac(0.0F, 0.0F);
          }
          bP(m);
          AppMethodBeat.o(248905);
          return;
        }
        i += 1;
      }
    case 1: 
      label576:
      label601:
      label626:
      label1011:
      float f5;
      label721:
      label855:
      label861:
      label867:
      label873:
      label879:
      if (this.FGj == 1)
      {
        if (this.Ri != null)
        {
          localObject = this.Ri;
          if (localObject == null) {
            break label1331;
          }
        }
        for (i = localObject.length; i <= this.bvF; i = 0)
        {
          AppMethodBeat.o(248905);
          return;
        }
        i = j.c(paramMotionEvent, this.bvF);
        if (i >= 0) {
          break label1430;
        }
        i = k;
        f4 = j.e(paramMotionEvent, i);
        f5 = j.f(paramMotionEvent, i);
        paramMotionEvent = this.Ri;
        if (paramMotionEvent == null) {
          break label1433;
        }
      }
      label844:
      label849:
      label988:
      label1125:
      for (f1 = paramMotionEvent[this.bvF];; f1 = 0.0F)
      {
        paramMotionEvent = this.Rj;
        f2 = f3;
        if (paramMotionEvent != null) {
          f2 = paramMotionEvent[this.bvF];
        }
        ac(f4 - f1, f5 - f2);
        cancel();
        AppMethodBeat.o(248905);
        return;
        break;
      }
    }
    label644:
    label1049:
    if (this.FGj == 1)
    {
      if (this.Ri != null)
      {
        localObject = this.Ri;
        if (localObject == null) {
          break label1485;
        }
      }
      label1485:
      for (i = localObject.length; i <= this.bvF; i = 0)
      {
        AppMethodBeat.o(248905);
        return;
      }
      i = j.c(paramMotionEvent, this.bvF);
      if (i >= 0) {
        break label1579;
      }
      i = m;
      label1510:
      f3 = j.e(paramMotionEvent, i);
      f4 = j.f(paramMotionEvent, i);
      paramMotionEvent = this.Ri;
      if (paramMotionEvent == null) {
        break label1582;
      }
      f1 = paramMotionEvent[this.bvF];
      paramMotionEvent = this.Rj;
      if (paramMotionEvent == null) {
        break label1587;
      }
    }
    label1430:
    label1433:
    label1579:
    label1582:
    label1587:
    for (f2 = paramMotionEvent[this.bvF];; f2 = 0.0F)
    {
      o(0.0F, 0.0F, f3 - f1, f4 - f2);
      cancel();
      break;
      break label1510;
      f1 = 0.0F;
      break label1542;
    }
  }
  
  public final void t(Rect paramRect)
  {
    AppMethodBeat.i(248873);
    p.k(paramRect, "positon");
    this.FGo = new Rect(paramRect);
    AppMethodBeat.o(248873);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Callback;", "", "()V", "clampViewPositionHorizontal", "", "child", "Landroid/view/View;", "left", "dx", "clampViewPositionVertical", "top", "dy", "getOrderedChildIndex", "index", "getViewHorizontalDragRange", "getViewVerticalDragRange", "onEdgeDragStarted", "", "edgeFlags", "pointerId", "onEdgeLock", "", "onEdgeTouched", "onViewCaptured", "capturedChild", "activePointerId", "onViewDragStateChanged", "state", "onViewPositionChanged", "changedView", "onViewReleased", "releasedChild", "xvel", "", "yvel", "onViewTouchPositionChanged", "touchX", "touchY", "adx", "ady", "tryCaptureView", "plugin-multitask_release"})
  public static abstract class a
  {
    public void G(int paramInt) {}
    
    public int XY(int paramInt)
    {
      return 0;
    }
    
    public void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    public int aEe()
    {
      return 0;
    }
    
    public abstract boolean b(View paramView, int paramInt);
    
    public void c(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
    
    public void faA() {}
    
    public void l(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Companion;", "", "()V", "BASE_SETTLE_DURATION", "", "DIRECTION_ALL", "DIRECTION_HORIZONTAL", "DIRECTION_HORIZONTAL_LEFT", "DIRECTION_HORIZONTAL_RIGHT", "DIRECTION_VERTICAL", "EDGE_ALL", "EDGE_BOTTOM", "EDGE_LEFT", "EDGE_RIGHT", "EDGE_SIZE", "EDGE_TOP", "INVALID_POINTER", "MAX_SETTLE_DURATION", "STATE_DRAGGING", "STATE_IDLE", "STATE_SETTLING", "TAG", "", "sInterpolator", "Landroid/view/animation/Interpolator;", "create", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "forParent", "Landroid/view/ViewGroup;", "cb", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Callback;", "interpolator", "sensitivity", "", "plugin-multitask_release"})
  public static final class b
  {
    public static b a(ViewGroup paramViewGroup, b.a parama, Interpolator paramInterpolator)
    {
      AppMethodBeat.i(249075);
      p.k(paramViewGroup, "forParent");
      p.k(paramInterpolator, "interpolator");
      Context localContext = paramViewGroup.getContext();
      p.j(localContext, "forParent.context");
      paramViewGroup = new b(localContext, paramViewGroup, parama, paramInterpolator, (byte)0);
      AppMethodBeat.o(249075);
      return paramViewGroup;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(248938);
      this.FGr.bR(0);
      AppMethodBeat.o(248938);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.c.a.b
 * JD-Core Version:    0.7.0.1
 */