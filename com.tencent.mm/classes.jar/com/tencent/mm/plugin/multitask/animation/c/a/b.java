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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "", "context", "Landroid/content/Context;", "forParent", "Landroid/view/ViewGroup;", "cb", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Callback;", "interpolator", "Landroid/view/animation/Interpolator;", "(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Callback;Landroid/view/animation/Interpolator;)V", "<set-?>", "", "activePointerId", "getActivePointerId", "()I", "Landroid/view/View;", "capturedView", "getCapturedView", "()Landroid/view/View;", "edgeSize", "getEdgeSize", "setEdgeSize", "(I)V", "mCallback", "mEdgeDragsInProgress", "", "mEdgeDragsLocked", "mInitialEdgesTouched", "mInitialMotionX", "", "mInitialMotionY", "mLastMotionX", "mLastMotionY", "mParentView", "mPointersDown", "mReleaseInProgress", "", "mScroller", "Landroid/widget/OverScroller;", "mSetIdleRunnable", "Ljava/lang/Runnable;", "mTrackingEdges", "mVelocityTracker", "Landroid/view/VelocityTracker;", "maxVelocity", "", "getMaxVelocity", "()F", "setMaxVelocity", "(F)V", "minVelocity", "getMinVelocity", "setMinVelocity", "positon", "Landroid/graphics/Rect;", "targetPositon", "getTargetPositon", "()Landroid/graphics/Rect;", "setTargetPositon", "(Landroid/graphics/Rect;)V", "touchSlop", "getTouchSlop", "viewDragState", "getViewDragState", "abort", "", "canScroll", "v", "checkV", "dx", "dy", "x", "y", "cancel", "captureChildView", "childView", "checkNewEdgeDrag", "delta", "odelta", "pointerId", "edge", "checkTouchSlop", "child", "directions", "clampMag", "value", "absMin", "absMax", "clearMotionHistory", "computeAxisDuration", "velocity", "motionRange", "computeSettleDuration", "xvel", "yvel", "continueSettling", "deferCallbacks", "(Z)Ljava/lang/Boolean;", "dispatchViewReleased", "distanceInfluenceForSnapDuration", "f", "dragTo", "left", "top", "ensureMotionHistorySizeForId", "findTopChildUnder", "flingCapturedView", "minLeft", "minTop", "maxLeft", "maxTop", "forceSettleCapturedViewAt", "finalLeft", "finalTop", "duration", "", "withNoAnim", "getEdgesTouched", "isCapturedViewUnder", "isDragging", "isEdgeTouched", "edges", "isFinished", "isPointerDown", "isViewUnder", "view", "moveTo", "adx", "ady", "processTouchEvent", "ev", "Landroid/view/MotionEvent;", "releaseViewForPointerUp", "reportNewEdgeDrags", "saveInitialMotion", "saveLastMotion", "setDragState", "state", "setEdgeTrackingEnabled", "edgeFlags", "settleCapturedViewAt", "shouldInterceptTouchEvent", "smoothSlideViewTo", "tryCaptureViewForDrag", "toCapture", "Callback", "Companion", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b LCd;
  private static final Interpolator sInterpolator;
  public int LCe;
  public float LCf;
  private int LCg;
  public final a LCh;
  public View LCi;
  public Rect LCj;
  public final OverScroller bwz;
  private float[] bxA;
  private float[] bxB;
  private float[] bxC;
  private int[] bxD;
  private int[] bxE;
  private int[] bxF;
  private int bxG;
  public int bxK;
  public boolean bxN;
  public final ViewGroup bxO;
  public final Runnable bxP;
  private float[] bxz;
  public int doI;
  public int doK;
  public VelocityTracker mVelocityTracker;
  public float uDV;
  
  static
  {
    AppMethodBeat.i(304232);
    LCd = new b((byte)0);
    sInterpolator = b..ExternalSyntheticLambda0.INSTANCE;
    AppMethodBeat.o(304232);
  }
  
  private b(Context paramContext, ViewGroup paramViewGroup, a parama, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(304079);
    this.doI = -1;
    this.LCj = new Rect();
    this.bxP = new b..ExternalSyntheticLambda1(this);
    if (paramViewGroup == null)
    {
      paramContext = (Throwable)new IllegalArgumentException("Parent view may not be null".toString());
      AppMethodBeat.o(304079);
      throw paramContext;
    }
    if (parama == null)
    {
      paramContext = (Throwable)new IllegalArgumentException("Callback may not be null".toString());
      AppMethodBeat.o(304079);
      throw paramContext;
    }
    this.bxO = paramViewGroup;
    this.LCh = parama;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.LCg = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.doK = paramViewGroup.getScaledTouchSlop();
    this.uDV = paramViewGroup.getScaledMaximumFlingVelocity();
    this.LCf = paramViewGroup.getScaledMinimumFlingVelocity();
    this.bwz = new OverScroller(paramContext, paramInterpolator);
    AppMethodBeat.o(304079);
  }
  
  private boolean C(View paramView, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(304173);
    if ((paramView == this.LCi) && (this.doI == paramInt))
    {
      AppMethodBeat.o(304173);
      return true;
    }
    if ((paramView != null) && (this.LCh.b(paramView, paramInt)))
    {
      this.doI = paramInt;
      s.u(paramView, "childView");
      if (paramView.getParent() == this.bxO) {
        i = 1;
      }
      if (i == 0)
      {
        paramView = (Throwable)new IllegalArgumentException(("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.bxO + ')').toString());
        AppMethodBeat.o(304173);
        throw paramView;
      }
      this.LCi = paramView;
      this.doI = paramInt;
      this.LCh.gjF();
      eM(1);
      AppMethodBeat.o(304173);
      return true;
    }
    AppMethodBeat.o(304173);
    return false;
  }
  
  private final int R(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(304088);
    paramInt3 = t(paramInt3, (int)this.LCf, (int)this.uDV);
    paramInt4 = t(paramInt4, (int)this.LCf, (int)this.uDV);
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
      paramInt1 = s(paramInt1, paramInt3, this.LCh.aXi());
      paramInt2 = s(paramInt2, paramInt4, 0);
      float f3 = paramInt1;
      paramInt1 = (int)(f2 * paramInt2 + f1 * f3);
      AppMethodBeat.o(304088);
      return paramInt1;
      f1 = i / i1;
      break;
    }
  }
  
  private final void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(304139);
    Object localObject1;
    if (this.bxz != null)
    {
      localObject1 = this.bxz;
      if (localObject1 != null) {
        break label498;
      }
    }
    label498:
    for (int i = 0;; i = localObject1.length)
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
        Object localObject2 = this.bxz;
        Object localObject3 = this.bxA;
        Object localObject4 = this.bxB;
        float[] arrayOfFloat4 = this.bxC;
        if ((localObject2 != null) && (localObject3 != null) && (localObject4 != null) && (arrayOfFloat4 != null))
        {
          System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
          System.arraycopy(localObject3, 0, arrayOfFloat1, 0, localObject3.length);
          System.arraycopy(localObject4, 0, arrayOfFloat2, 0, localObject4.length);
          System.arraycopy(arrayOfFloat4, 0, arrayOfFloat3, 0, arrayOfFloat4.length);
        }
        localObject2 = this.bxD;
        localObject3 = this.bxE;
        localObject4 = this.bxF;
        if ((localObject2 != null) && (localObject3 != null) && (localObject4 != null))
        {
          System.arraycopy(localObject2, 0, arrayOfInt1, 0, localObject2.length);
          System.arraycopy(localObject3, 0, arrayOfInt2, 0, localObject3.length);
          System.arraycopy(localObject4, 0, arrayOfInt3, 0, localObject4.length);
        }
        this.bxz = ((float[])localObject1);
        this.bxA = arrayOfFloat1;
        this.bxB = arrayOfFloat2;
        this.bxC = arrayOfFloat3;
        this.bxD = arrayOfInt1;
        this.bxE = arrayOfInt2;
        this.bxF = arrayOfInt3;
      }
      localObject1 = this.bxB;
      if (localObject1 != null) {
        localObject1[paramInt] = paramFloat1;
      }
      localObject1 = this.bxz;
      if (localObject1 != null) {
        localObject1[paramInt] = paramFloat1;
      }
      localObject1 = this.bxC;
      if (localObject1 != null) {
        localObject1[paramInt] = paramFloat2;
      }
      localObject1 = this.bxA;
      if (localObject1 != null) {
        localObject1[paramInt] = paramFloat2;
      }
      localObject1 = this.bxD;
      if (localObject1 != null)
      {
        int m = (int)paramFloat1;
        int k = (int)paramFloat2;
        int j = 0;
        if (m < this.bxO.getLeft() + this.LCg) {
          j = 1;
        }
        i = j;
        if (k < this.bxO.getTop() + this.LCg) {
          i = j | 0x4;
        }
        j = i;
        if (m > this.bxO.getRight() - this.LCg) {
          j = i | 0x2;
        }
        i = j;
        if (k > this.bxO.getBottom() - this.LCg) {
          i = j | 0x8;
        }
        localObject1[paramInt] = i;
      }
      this.bxG |= 1 << paramInt;
      AppMethodBeat.o(304139);
      return;
    }
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(304215);
    s.u(paramb, "this$0");
    paramb.eM(0);
    AppMethodBeat.o(304215);
  }
  
  private final boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(304188);
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    int[] arrayOfInt = this.bxD;
    if (arrayOfInt == null)
    {
      i = 0;
      if (((i & paramInt2) == paramInt2) && ((this.bxK & paramInt2) != 0))
      {
        arrayOfInt = this.bxF;
        if (arrayOfInt != null) {
          break label135;
        }
        i = 0;
        label64:
        if ((i & paramInt2) != paramInt2)
        {
          arrayOfInt = this.bxE;
          if (arrayOfInt != null) {
            break label144;
          }
        }
      }
    }
    label135:
    label144:
    for (int i = 0;; i = arrayOfInt[paramInt1])
    {
      if (((i & paramInt2) != paramInt2) && ((paramFloat1 > this.doK) || (paramFloat2 > this.doK))) {
        break label153;
      }
      AppMethodBeat.o(304188);
      return false;
      i = arrayOfInt[paramInt1];
      break;
      i = arrayOfInt[paramInt1];
      break label64;
    }
    label153:
    arrayOfInt = this.bxE;
    if (arrayOfInt == null) {}
    for (paramInt1 = 0; ((paramInt1 & paramInt2) == 0) && (paramFloat1 > this.doK); paramInt1 = arrayOfInt[paramInt1])
    {
      AppMethodBeat.o(304188);
      return true;
    }
    AppMethodBeat.o(304188);
    return false;
  }
  
  private View aF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(304208);
    int i = this.bxO.getChildCount() - 1;
    if (i >= 0) {}
    for (;;)
    {
      int j = i - 1;
      View localView = this.bxO.getChildAt(i);
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom()))
      {
        AppMethodBeat.o(304208);
        return localView;
      }
      if (j < 0)
      {
        AppMethodBeat.o(304208);
        return null;
      }
      i = j;
    }
  }
  
  private final void aH(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(304201);
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker != null) {
      localVelocityTracker.computeCurrentVelocity(1000, this.uDV);
    }
    s(i(this.mVelocityTracker.getXVelocity(this.doI), this.LCf, this.uDV), i(this.mVelocityTracker.getYVelocity(this.doI), this.LCf, this.uDV), paramFloat1, paramFloat2);
    AppMethodBeat.o(304201);
  }
  
  private final void b(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(304181);
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
        int[] arrayOfInt = this.bxE;
        if (arrayOfInt != null) {
          arrayOfInt[paramInt] = (i | arrayOfInt[paramInt]);
        }
      }
      AppMethodBeat.o(304181);
      return;
      j = 0;
    }
  }
  
  private static final float cE(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * (paramFloat * paramFloat * paramFloat * paramFloat) + 1.0F;
  }
  
  private static float distanceInfluenceForSnapDuration(float paramFloat)
  {
    AppMethodBeat.i(304116);
    paramFloat = (float)Math.sin((paramFloat - 0.5F) * 0.4712389F);
    AppMethodBeat.o(304116);
    return paramFloat;
  }
  
  private final void eK(int paramInt)
  {
    if (this.bxz != null)
    {
      localObject = this.bxz;
      if (localObject != null) {
        break label24;
      }
    }
    label24:
    for (int i = 0; i <= paramInt; i = localObject.length) {
      return;
    }
    Object localObject = this.bxz;
    if (localObject != null) {
      localObject[paramInt] = 0.0F;
    }
    localObject = this.bxA;
    if (localObject != null) {
      localObject[paramInt] = 0.0F;
    }
    localObject = this.bxB;
    if (localObject != null) {
      localObject[paramInt] = 0.0F;
    }
    localObject = this.bxC;
    if (localObject != null) {
      localObject[paramInt] = 0.0F;
    }
    localObject = this.bxD;
    if (localObject != null) {
      localObject[paramInt] = 0;
    }
    localObject = this.bxE;
    if (localObject != null) {
      localObject[paramInt] = 0;
    }
    localObject = this.bxF;
    if (localObject != null) {
      localObject[paramInt] = 0;
    }
    this.bxG &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  private boolean eL(int paramInt)
  {
    return (this.bxG & 0x1) << paramInt != 0;
  }
  
  private void eM(int paramInt)
  {
    AppMethodBeat.i(304162);
    if (this.LCe != paramInt)
    {
      this.LCe = paramInt;
      this.LCh.F(paramInt);
      if (paramInt == 0) {
        this.LCi = null;
      }
    }
    AppMethodBeat.o(304162);
  }
  
  private final void h(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(304149);
    int k = paramMotionEvent.getPointerCount();
    int i = 0;
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      int m = paramMotionEvent.getPointerId(i);
      float f1 = paramMotionEvent.getX(i);
      float f2 = paramMotionEvent.getY(i);
      float[] arrayOfFloat1 = this.bxB;
      float[] arrayOfFloat2 = this.bxC;
      if ((arrayOfFloat1 != null) && (arrayOfFloat2 != null) && (arrayOfFloat1.length > m) && (arrayOfFloat2.length > m))
      {
        arrayOfFloat1[m] = f1;
        arrayOfFloat2[m] = f2;
      }
      if (j >= k)
      {
        AppMethodBeat.o(304149);
        return;
      }
      i = j;
    }
  }
  
  private static float i(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(304111);
    float f = Math.abs(paramFloat1);
    if (f < paramFloat2)
    {
      AppMethodBeat.o(304111);
      return 0.0F;
    }
    if (f > paramFloat3)
    {
      if (paramFloat1 > 0.0F)
      {
        AppMethodBeat.o(304111);
        return paramFloat3;
      }
      paramFloat1 = -paramFloat3;
      AppMethodBeat.o(304111);
      return paramFloat1;
    }
    AppMethodBeat.o(304111);
    return paramFloat1;
  }
  
  private final int s(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(304095);
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(304095);
      return 0;
    }
    int i = this.bxO.getWidth();
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
      AppMethodBeat.o(304095);
      return paramInt1;
    }
  }
  
  private final void s(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(304119);
    this.bxN = true;
    this.LCh.d(this.LCi, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    this.bxN = false;
    if (this.LCe == 1) {
      eM(0);
    }
    AppMethodBeat.o(304119);
  }
  
  private final boolean s(View paramView, float paramFloat)
  {
    AppMethodBeat.i(304195);
    if (paramView == null)
    {
      AppMethodBeat.o(304195);
      return false;
    }
    int i;
    if (this.LCh.aXi() > 0) {
      i = 1;
    }
    while (i != 0) {
      if (Math.abs(paramFloat) > this.doK)
      {
        AppMethodBeat.o(304195);
        return true;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(304195);
        return false;
      }
    }
    AppMethodBeat.o(304195);
    return false;
  }
  
  private static int t(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(304104);
    int i = Math.abs(paramInt1);
    if (i < paramInt2)
    {
      AppMethodBeat.o(304104);
      return 0;
    }
    if (i > paramInt3)
    {
      if (paramInt1 > 0)
      {
        AppMethodBeat.o(304104);
        return paramInt3;
      }
      paramInt1 = -paramInt3;
      AppMethodBeat.o(304104);
      return paramInt1;
    }
    AppMethodBeat.o(304104);
    return paramInt1;
  }
  
  public final void Fw()
  {
    AppMethodBeat.i(304263);
    cancel();
    if (this.LCe == 2)
    {
      int i = this.bwz.getCurrX();
      int j = this.bwz.getCurrY();
      this.bwz.abortAnimation();
      int k = this.bwz.getCurrX();
      int m = this.bwz.getCurrY();
      this.LCh.m(this.LCi, k, m, k - i, m - j);
    }
    eM(0);
    AppMethodBeat.o(304263);
  }
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(304278);
    View localView = this.LCi;
    int i;
    if (localView == null)
    {
      i = 0;
      localView = this.LCi;
      if (localView != null) {
        break label82;
      }
    }
    label82:
    for (int j = 0;; j = localView.getTop())
    {
      paramInt1 -= i;
      paramInt2 -= j;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label92;
      }
      this.bwz.abortAnimation();
      eM(0);
      AppMethodBeat.o(304278);
      return false;
      i = localView.getLeft();
      break;
    }
    label92:
    this.bwz.forceFinished(true);
    if ((paramLong == 0L) && (!paramBoolean)) {
      paramLong = R(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    for (;;)
    {
      Log.d("MultiTaskSwipeDragHelper", "chrispaulwu:: xvel %d, yvel %d, dx %d, dy %d duration %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
      this.bwz.startScroll(i, j, paramInt1, paramInt2, (int)paramLong);
      eM(2);
      AppMethodBeat.o(304278);
      return true;
      if (paramBoolean) {
        paramLong = 0L;
      }
    }
  }
  
  public final boolean a(View paramView, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(304266);
    this.LCi = paramView;
    this.doI = -1;
    paramBoolean = a(paramInt1, paramInt2, 0, 0, paramLong, paramBoolean);
    AppMethodBeat.o(304266);
    return paramBoolean;
  }
  
  public final boolean ack(int paramInt)
  {
    AppMethodBeat.i(304327);
    if (eL(paramInt))
    {
      int[] arrayOfInt = this.bxD;
      if (arrayOfInt == null) {}
      for (paramInt = 0; (paramInt & 0x1) != 0; paramInt = arrayOfInt[paramInt])
      {
        AppMethodBeat.o(304327);
        return true;
      }
    }
    AppMethodBeat.o(304327);
    return false;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(304258);
    this.doI = -1;
    if (this.bxz != null)
    {
      Arrays.fill(this.bxz, 0.0F);
      Arrays.fill(this.bxA, 0.0F);
      Arrays.fill(this.bxB, 0.0F);
      Arrays.fill(this.bxC, 0.0F);
      Arrays.fill(this.bxD, 0);
      Arrays.fill(this.bxE, 0);
      Arrays.fill(this.bxF, 0);
      this.bxG = 0;
    }
    if (this.mVelocityTracker != null)
    {
      VelocityTracker localVelocityTracker = this.mVelocityTracker;
      if (localVelocityTracker != null) {
        localVelocityTracker.recycle();
      }
      this.mVelocityTracker = null;
    }
    AppMethodBeat.o(304258);
  }
  
  public final boolean i(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(304295);
    s.u(paramMotionEvent, "ev");
    int j = paramMotionEvent.getActionMasked();
    int i = paramMotionEvent.getActionIndex();
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
    label401:
    label436:
    label565:
    label574:
    while (this.LCe == 1)
    {
      AppMethodBeat.o(304295);
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      i = paramMotionEvent.getPointerId(0);
      a(f1, f2, i);
      paramMotionEvent = aF((int)f1, (int)f2);
      if ((paramMotionEvent == this.LCi) && (this.LCe == 2)) {
        C(paramMotionEvent, i);
      }
      paramMotionEvent = this.bxD;
      if (paramMotionEvent == null) {}
      for (paramMotionEvent = null; paramMotionEvent != null; paramMotionEvent = Integer.valueOf(paramMotionEvent[i]))
      {
        ((Number)paramMotionEvent).intValue();
        break;
      }
      j = paramMotionEvent.getPointerId(i);
      f1 = paramMotionEvent.getX(i);
      f2 = paramMotionEvent.getY(i);
      a(f1, f2, j);
      if (this.LCe == 0)
      {
        paramMotionEvent = this.bxD;
        if (paramMotionEvent == null) {}
        for (paramMotionEvent = null; paramMotionEvent != null; paramMotionEvent = Integer.valueOf(paramMotionEvent[j]))
        {
          ((Number)paramMotionEvent).intValue();
          if ((paramMotionEvent.intValue() & this.bxK) == 0) {
            break;
          }
          paramMotionEvent.intValue();
          break;
        }
      }
      label455:
      label585:
      if (this.LCe == 2)
      {
        paramMotionEvent = aF((int)f1, (int)f2);
        label488:
        if (paramMotionEvent == this.LCi)
        {
          C(paramMotionEvent, j);
          continue;
          h(paramMotionEvent);
          int m = paramMotionEvent.getPointerCount();
          i = 0;
          label360:
          if (i < m)
          {
            int n = paramMotionEvent.getPointerId(i);
            if ((this.bxz != null) && (n >= 0))
            {
              localObject = this.bxz;
              float f3;
              if (localObject == null)
              {
                j = 0;
                if (n >= j) {
                  continue;
                }
                f3 = paramMotionEvent.getX(i);
                f2 = paramMotionEvent.getY(i);
                localObject = this.bxz;
                if (localObject != null) {
                  break label556;
                }
                f1 = 0.0F;
                f3 -= f1;
                localObject = this.bxA;
                if (localObject != null) {
                  break label565;
                }
                f1 = 0.0F;
                b(f3, f2 - f1, n);
                if (this.LCe == 1) {
                  continue;
                }
                localObject = this.bxz;
                if (localObject != null) {
                  break label574;
                }
                j = 0;
                localObject = this.bxA;
                if (localObject != null) {
                  break label585;
                }
              }
              for (int k = 0;; k = (int)localObject[n])
              {
                localObject = aF(j, k);
                if ((localObject != null) && (s((View)localObject, f3)) && (C((View)localObject, n))) {
                  break;
                }
                i += 1;
                break label360;
                j = localObject.length;
                break label401;
                f1 = localObject[n];
                break label436;
                f1 = localObject[n];
                break label455;
                j = (int)localObject[n];
                break label488;
              }
              eK(paramMotionEvent.getPointerId(i));
              continue;
              cancel();
            }
          }
        }
      }
    }
    label556:
    AppMethodBeat.o(304295);
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
    AppMethodBeat.i(304312);
    s.u(paramMotionEvent, "ev");
    int i1 = paramMotionEvent.getActionMasked();
    int n = paramMotionEvent.getActionIndex();
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
    label445:
    float f4;
    label528:
    label553:
    label1323:
    switch (i1)
    {
    case 4: 
    default: 
    case 0: 
    case 5: 
      do
      {
        do
        {
          AppMethodBeat.o(304312);
          return;
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          i = paramMotionEvent.getPointerId(0);
          paramMotionEvent = aF((int)f1, (int)f2);
          a(f1, f2, i);
          C(paramMotionEvent, i);
          paramMotionEvent = this.bxD;
          if (paramMotionEvent == null) {}
          for (paramMotionEvent = null; paramMotionEvent != null; paramMotionEvent = Integer.valueOf(paramMotionEvent[i]))
          {
            ((Number)paramMotionEvent).intValue();
            if ((paramMotionEvent.intValue() & this.bxK) != 0) {
              paramMotionEvent.intValue();
            }
            AppMethodBeat.o(304312);
            return;
          }
          k = paramMotionEvent.getPointerId(n);
          f1 = paramMotionEvent.getX(n);
          f2 = paramMotionEvent.getY(n);
          a(f1, f2, k);
          if (this.LCe != 0) {
            break;
          }
          C(aF((int)f1, (int)f2), k);
        } while (this.bxD == null);
        AppMethodBeat.o(304312);
        return;
        m = (int)f1;
        n = (int)f2;
        paramMotionEvent = this.LCi;
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
      } while (i == 0);
      C(this.LCi, k);
      AppMethodBeat.o(304312);
      return;
    case 2: 
      if (this.LCe == 1)
      {
        if (this.bxz != null)
        {
          localObject = this.bxz;
          if (localObject != null) {
            break label445;
          }
        }
        for (i = 0; i <= this.doI; i = localObject.length)
        {
          AppMethodBeat.o(304312);
          return;
        }
        j = paramMotionEvent.findPointerIndex(this.doI);
        i = j;
        if (j < 0) {
          i = 0;
        }
        f3 = paramMotionEvent.getX(i);
        f4 = paramMotionEvent.getY(i);
        localObject = this.bxB;
        int i2;
        if (localObject == null)
        {
          f1 = 0.0F;
          i1 = (int)((f3 - f1) / 1.666667F);
          localObject = this.bxC;
          if (localObject != null) {
            break label805;
          }
          f1 = 0.0F;
          i2 = (int)((f4 - f1) / 1.666667F);
          localObject = this.LCi;
          if (localObject != null) {
            break label816;
          }
          i = 0;
          m = i + i1;
          localObject = this.LCi;
          if (localObject != null) {
            break label826;
          }
          i = 0;
          n = i + i2;
          localObject = this.LCi;
          if (localObject != null) {
            break label836;
          }
          i = 0;
          localObject = this.LCi;
          if (localObject != null) {
            break label846;
          }
          j = 0;
          k = m;
          if (i1 != 0)
          {
            m = this.LCh.acl(m);
            localObject = this.LCi;
            k = m;
            if (localObject != null)
            {
              ((View)localObject).offsetLeftAndRight(m - i);
              k = m;
            }
          }
          m = n;
          if (i2 != 0)
          {
            localObject = this.LCi;
            if (localObject != null) {
              ((View)localObject).offsetTopAndBottom(0 - j);
            }
            m = 0;
          }
          if ((i1 != 0) || (i2 != 0)) {
            this.LCh.m(this.LCi, k, m, k - i, m - j);
          }
          localObject = this.bxz;
          if (localObject != null) {
            break label856;
          }
          f1 = 0.0F;
          localObject = this.bxA;
          if (localObject != null) {
            break label867;
          }
        }
        for (;;)
        {
          i = (int)(f3 - f1);
          j = (int)(f4 - f2);
          this.LCh.a(f3, f4, i1, i2, i, j);
          h(paramMotionEvent);
          AppMethodBeat.o(304312);
          return;
          f1 = localObject[this.doI];
          break;
          f1 = localObject[this.doI];
          break label528;
          i = ((View)localObject).getLeft();
          break label553;
          i = ((View)localObject).getTop();
          break label574;
          i = ((View)localObject).getLeft();
          break label595;
          j = ((View)localObject).getTop();
          break label609;
          f1 = localObject[this.doI];
          break label738;
          f2 = localObject[this.doI];
        }
      }
      m = paramMotionEvent.getPointerCount();
      i = 0;
      if (i < m)
      {
        n = paramMotionEvent.getPointerId(i);
        if (this.bxz != null)
        {
          localObject = this.bxz;
          if (localObject != null) {
            break label942;
          }
          j = 0;
          if (j > n) {
            break label950;
          }
        }
      }
      do
      {
        h(paramMotionEvent);
        AppMethodBeat.o(304312);
        return;
        j = localObject.length;
        break;
        f3 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        localObject = this.bxz;
        if (localObject != null) {
          break label1085;
        }
        f1 = 0.0F;
        f3 -= f1;
        localObject = this.bxA;
        if (localObject != null) {
          break label1094;
        }
        f1 = 0.0F;
        b(f3, f2 - f1, n);
      } while (this.LCe == 1);
      localObject = this.bxz;
      if (localObject == null)
      {
        j = 0;
        localObject = this.bxA;
        if (localObject != null) {
          break label1114;
        }
      }
      for (k = 0;; k = (int)localObject[n])
      {
        localObject = aF(j, k);
        if ((s((View)localObject, f3)) && (C((View)localObject, n))) {
          break label930;
        }
        i += 1;
        break;
        f1 = localObject[n];
        break label978;
        f1 = localObject[n];
        break label997;
        j = (int)localObject[n];
        break label1030;
      }
    case 6: 
      label1085:
      label1094:
      m = paramMotionEvent.getPointerId(n);
      if ((this.LCe == 1) && (m == this.doI))
      {
        k = -1;
        n = paramMotionEvent.getPointerCount();
      }
      for (;;)
      {
        j = k;
        if (i < n)
        {
          j = paramMotionEvent.getPointerId(i);
          if (j == this.doI)
          {
            i += 1;
            continue;
          }
          f1 = paramMotionEvent.getX(i);
          f2 = paramMotionEvent.getY(i);
          if ((aF((int)f1, (int)f2) == this.LCi) && (C(this.LCi, j))) {
            j = this.doI;
          }
        }
        else
        {
          if (j == -1) {
            aH(0.0F, 0.0F);
          }
          eK(m);
          AppMethodBeat.o(304312);
          return;
        }
        i += 1;
      }
    case 1: 
      label574:
      label595:
      label609:
      label738:
      label867:
      label997:
      float f5;
      label816:
      label826:
      label836:
      label846:
      label856:
      label1114:
      if (this.LCe == 1)
      {
        if (this.bxz != null)
        {
          localObject = this.bxz;
          if (localObject != null) {
            break label1323;
          }
        }
        for (i = 0; i <= this.doI; i = localObject.length)
        {
          AppMethodBeat.o(304312);
          return;
        }
        i = paramMotionEvent.findPointerIndex(this.doI);
        if (i >= 0) {
          break label1412;
        }
        i = k;
        f4 = paramMotionEvent.getX(i);
        f5 = paramMotionEvent.getY(i);
        paramMotionEvent = this.bxz;
        if (paramMotionEvent != null) {
          break label1415;
        }
        f1 = 0.0F;
        label1377:
        paramMotionEvent = this.bxA;
        if (paramMotionEvent != null) {
          break label1425;
        }
      }
      label942:
      label950:
      label978:
      for (f2 = f3;; f2 = paramMotionEvent[this.doI])
      {
        aH(f4 - f1, f5 - f2);
        cancel();
        AppMethodBeat.o(304312);
        return;
        break;
        f1 = paramMotionEvent[this.doI];
        break label1377;
      }
    }
    label805:
    if (this.LCe == 1)
    {
      if (this.bxz != null)
      {
        localObject = this.bxz;
        if (localObject != null) {
          break label1480;
        }
      }
      label1480:
      for (i = 0; i <= this.doI; i = localObject.length)
      {
        AppMethodBeat.o(304312);
        return;
      }
      i = paramMotionEvent.findPointerIndex(this.doI);
      if (i >= 0) {
        break label1566;
      }
      i = m;
      label1507:
      f3 = paramMotionEvent.getX(i);
      f4 = paramMotionEvent.getY(i);
      paramMotionEvent = this.bxz;
      if (paramMotionEvent != null) {
        break label1569;
      }
      f1 = 0.0F;
      label1534:
      paramMotionEvent = this.bxA;
      if (paramMotionEvent != null) {
        break label1579;
      }
    }
    label930:
    label1579:
    for (f2 = 0.0F;; f2 = paramMotionEvent[this.doI])
    {
      s(0.0F, 0.0F, f3 - f1, f4 - f2);
      cancel();
      break;
      break label1507;
      f1 = paramMotionEvent[this.doI];
      break label1534;
    }
  }
  
  public final boolean jU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(304320);
    if (!eL(paramInt2))
    {
      AppMethodBeat.o(304320);
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
      float[] arrayOfFloat1 = this.bxB;
      float[] arrayOfFloat2 = this.bxC;
      float[] arrayOfFloat3 = this.bxz;
      float[] arrayOfFloat4 = this.bxA;
      if ((arrayOfFloat1 == null) || (arrayOfFloat2 == null) || (arrayOfFloat3 == null) || (arrayOfFloat4 == null)) {
        break label356;
      }
      f1 = arrayOfFloat1[paramInt2] - arrayOfFloat3[paramInt2];
      f2 = arrayOfFloat2[paramInt2] - arrayOfFloat4[paramInt2];
      if ((i == 0) || (j == 0)) {
        break label200;
      }
      if (f1 * f1 + f2 * f2 <= this.doK * this.doK) {
        break label192;
      }
      AppMethodBeat.o(304320);
      return true;
      i = 0;
      break;
      j = 0;
      break label42;
      k = 0;
      break label54;
    }
    label192:
    AppMethodBeat.o(304320);
    return false;
    label200:
    if (paramInt1 != 0)
    {
      if ((f1 < this.doK) && (Math.abs(f1) > Math.abs(f2)))
      {
        AppMethodBeat.o(304320);
        return true;
      }
      AppMethodBeat.o(304320);
      return false;
    }
    if (k != 0)
    {
      if ((f1 > this.doK) && (Math.abs(f1) > Math.abs(f2)))
      {
        AppMethodBeat.o(304320);
        return true;
      }
      AppMethodBeat.o(304320);
      return false;
    }
    if (i != 0)
    {
      if (Math.abs(f1) > this.doK)
      {
        AppMethodBeat.o(304320);
        return true;
      }
      AppMethodBeat.o(304320);
      return false;
    }
    if (j != 0)
    {
      if (Math.abs(f2) > this.doK)
      {
        AppMethodBeat.o(304320);
        return true;
      }
      AppMethodBeat.o(304320);
      return false;
    }
    label356:
    AppMethodBeat.o(304320);
    return false;
  }
  
  public final void z(Rect paramRect)
  {
    AppMethodBeat.i(304252);
    s.u(paramRect, "positon");
    this.LCj = new Rect(paramRect);
    AppMethodBeat.o(304252);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Callback;", "", "()V", "clampViewPositionHorizontal", "", "child", "Landroid/view/View;", "left", "dx", "clampViewPositionVertical", "top", "dy", "getOrderedChildIndex", "index", "getViewHorizontalDragRange", "getViewVerticalDragRange", "onEdgeDragStarted", "", "edgeFlags", "pointerId", "onEdgeLock", "", "onEdgeTouched", "onViewCaptured", "capturedChild", "activePointerId", "onViewDragStateChanged", "state", "onViewPositionChanged", "changedView", "onViewReleased", "releasedChild", "xvel", "", "yvel", "onViewTouchPositionChanged", "touchX", "touchY", "adx", "ady", "tryCaptureView", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class a
  {
    public void F(int paramInt) {}
    
    public void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    public int aXi()
    {
      return 0;
    }
    
    public int acl(int paramInt)
    {
      return 0;
    }
    
    public abstract boolean b(View paramView, int paramInt);
    
    public void d(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
    
    public void gjF() {}
    
    public void m(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Companion;", "", "()V", "BASE_SETTLE_DURATION", "", "DIRECTION_ALL", "DIRECTION_HORIZONTAL", "DIRECTION_HORIZONTAL_LEFT", "DIRECTION_HORIZONTAL_RIGHT", "DIRECTION_VERTICAL", "EDGE_ALL", "EDGE_BOTTOM", "EDGE_LEFT", "EDGE_RIGHT", "EDGE_SIZE", "EDGE_TOP", "INVALID_POINTER", "MAX_SETTLE_DURATION", "STATE_DRAGGING", "STATE_IDLE", "STATE_SETTLING", "TAG", "", "sInterpolator", "Landroid/view/animation/Interpolator;", "create", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "forParent", "Landroid/view/ViewGroup;", "cb", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Callback;", "interpolator", "sensitivity", "", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static b a(ViewGroup paramViewGroup, b.a parama, Interpolator paramInterpolator)
    {
      AppMethodBeat.i(304046);
      s.u(paramViewGroup, "forParent");
      s.u(paramInterpolator, "interpolator");
      Context localContext = paramViewGroup.getContext();
      s.s(localContext, "forParent.context");
      paramViewGroup = new b(localContext, paramViewGroup, parama, paramInterpolator, (byte)0);
      AppMethodBeat.o(304046);
      return paramViewGroup;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.c.a.b
 * JD-Core Version:    0.7.0.1
 */