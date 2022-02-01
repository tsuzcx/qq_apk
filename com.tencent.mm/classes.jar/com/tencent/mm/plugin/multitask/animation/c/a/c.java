package com.tencent.mm.plugin.multitask.animation.c.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v4.view.i;
import android.support.v4.view.t;
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
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "", "context", "Landroid/content/Context;", "forParent", "Landroid/view/ViewGroup;", "cb", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Callback;", "interpolator", "Landroid/view/animation/Interpolator;", "(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Callback;Landroid/view/animation/Interpolator;)V", "<set-?>", "", "activePointerId", "getActivePointerId", "()I", "Landroid/view/View;", "capturedView", "getCapturedView", "()Landroid/view/View;", "edgeSize", "getEdgeSize", "setEdgeSize", "(I)V", "mCallback", "mEdgeDragsInProgress", "", "mEdgeDragsLocked", "mInitialEdgesTouched", "mInitialMotionX", "", "mInitialMotionY", "mLastMotionX", "mLastMotionY", "mParentView", "mPointersDown", "mReleaseInProgress", "", "mScroller", "Landroid/widget/OverScroller;", "mSetIdleRunnable", "Ljava/lang/Runnable;", "mTrackingEdges", "mVelocityTracker", "Landroid/view/VelocityTracker;", "maxVelocity", "", "getMaxVelocity", "()F", "setMaxVelocity", "(F)V", "minVelocity", "getMinVelocity", "setMinVelocity", "positon", "Landroid/graphics/Rect;", "targetPositon", "getTargetPositon", "()Landroid/graphics/Rect;", "setTargetPositon", "(Landroid/graphics/Rect;)V", "touchSlop", "getTouchSlop", "viewDragState", "getViewDragState", "abort", "", "canScroll", "v", "checkV", "dx", "dy", "x", "y", "cancel", "captureChildView", "childView", "checkNewEdgeDrag", "delta", "odelta", "pointerId", "edge", "checkTouchSlop", "child", "directions", "clampMag", "value", "absMin", "absMax", "clearMotionHistory", "computeAxisDuration", "velocity", "motionRange", "computeSettleDuration", "xvel", "yvel", "continueSettling", "deferCallbacks", "(Z)Ljava/lang/Boolean;", "dispatchViewReleased", "distanceInfluenceForSnapDuration", "f", "dragTo", "left", "top", "ensureMotionHistorySizeForId", "findTopChildUnder", "flingCapturedView", "minLeft", "minTop", "maxLeft", "maxTop", "forceSettleCapturedViewAt", "finalLeft", "finalTop", "duration", "", "withNoAnim", "getEdgesTouched", "isCapturedViewUnder", "isDragging", "isEdgeTouched", "edges", "isFinished", "isPointerDown", "isViewUnder", "view", "moveTo", "adx", "ady", "processTouchEvent", "ev", "Landroid/view/MotionEvent;", "releaseViewForPointerUp", "reportNewEdgeDrags", "saveInitialMotion", "saveLastMotion", "setDragState", "state", "setEdgeTrackingEnabled", "edgeFlags", "settleCapturedViewAt", "shouldInterceptTouchEvent", "smoothSlideViewTo", "tryCaptureViewForDrag", "toCapture", "Callback", "Companion", "plugin-multitask_release"})
public final class c
{
  public static final b Aaz;
  private static final Interpolator sInterpolator;
  public int Aas;
  public float Aat;
  public float Aau;
  private int Aav;
  public final a Aaw;
  public View Aax;
  public Rect Aay;
  public final OverScroller UD;
  private float[] WA;
  private float[] WB;
  private int[] WC;
  private int[] WD;
  private int[] WE;
  private int WF;
  public int WJ;
  public boolean WM;
  public final ViewGroup WN;
  public final Runnable WO;
  private float[] Wy;
  private float[] Wz;
  public VelocityTracker mVelocityTracker;
  public int om;
  public int rZ;
  
  static
  {
    AppMethodBeat.i(200483);
    Aaz = new b((byte)0);
    sInterpolator = (Interpolator)c.c.AaA;
    AppMethodBeat.o(200483);
  }
  
  private c(Context paramContext, ViewGroup paramViewGroup, a parama, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(200482);
    this.om = -1;
    this.Aay = new Rect();
    this.WO = ((Runnable)new d(this));
    if (paramViewGroup == null)
    {
      paramContext = (Throwable)new IllegalArgumentException("Parent view may not be null".toString());
      AppMethodBeat.o(200482);
      throw paramContext;
    }
    if (parama == null)
    {
      paramContext = (Throwable)new IllegalArgumentException("Callback may not be null".toString());
      AppMethodBeat.o(200482);
      throw paramContext;
    }
    this.WN = paramViewGroup;
    this.Aaw = parama;
    paramViewGroup = ViewConfiguration.get(paramContext);
    parama = paramContext.getResources();
    p.g(parama, "context.resources");
    this.Aav = ((int)(parama.getDisplayMetrics().density * 20.0F + 0.5F));
    p.g(paramViewGroup, "vc");
    this.rZ = paramViewGroup.getScaledTouchSlop();
    this.Aat = paramViewGroup.getScaledMaximumFlingVelocity();
    this.Aau = paramViewGroup.getScaledMinimumFlingVelocity();
    this.UD = new OverScroller(paramContext, paramInterpolator);
    AppMethodBeat.o(200482);
  }
  
  private final int H(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(200463);
    paramInt3 = i(paramInt3, (int)this.Aau, (int)this.Aat);
    paramInt4 = i(paramInt4, (int)this.Aau, (int)this.Aat);
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
      paramInt1 = h(paramInt1, paramInt3, this.Aaw.awM());
      paramInt2 = h(paramInt2, paramInt4, 0);
      float f3 = paramInt1;
      paramInt1 = (int)(f2 * paramInt2 + f1 * f3);
      AppMethodBeat.o(200463);
      return paramInt1;
      f1 = i / i1;
      break;
    }
  }
  
  private View J(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200481);
    int i = this.WN.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.WN.getChildAt(i);
      p.g(localView, "child");
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom()))
      {
        AppMethodBeat.o(200481);
        return localView;
      }
      i -= 1;
    }
    AppMethodBeat.o(200481);
    return null;
  }
  
  private final void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(200469);
    Object localObject1;
    if (this.Wy != null)
    {
      localObject1 = this.Wy;
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
        Object localObject2 = this.Wy;
        Object localObject3 = this.Wz;
        Object localObject4 = this.WA;
        float[] arrayOfFloat4 = this.WB;
        if ((localObject2 != null) && (localObject3 != null) && (localObject4 != null) && (arrayOfFloat4 != null))
        {
          System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
          System.arraycopy(localObject3, 0, arrayOfFloat1, 0, localObject3.length);
          System.arraycopy(localObject4, 0, arrayOfFloat2, 0, localObject4.length);
          System.arraycopy(arrayOfFloat4, 0, arrayOfFloat3, 0, arrayOfFloat4.length);
        }
        localObject2 = this.WC;
        localObject3 = this.WD;
        localObject4 = this.WE;
        if ((localObject2 != null) && (localObject3 != null) && (localObject4 != null))
        {
          System.arraycopy(localObject2, 0, arrayOfInt1, 0, localObject2.length);
          System.arraycopy(localObject3, 0, arrayOfInt2, 0, localObject3.length);
          System.arraycopy(localObject4, 0, arrayOfInt3, 0, localObject4.length);
        }
        this.Wy = ((float[])localObject1);
        this.Wz = arrayOfFloat1;
        this.WA = arrayOfFloat2;
        this.WB = arrayOfFloat3;
        this.WC = arrayOfInt1;
        this.WD = arrayOfInt2;
        this.WE = arrayOfInt3;
      }
      localObject1 = this.WA;
      if (localObject1 != null) {
        localObject1[paramInt] = paramFloat1;
      }
      localObject1 = this.Wy;
      if (localObject1 != null) {
        localObject1[paramInt] = paramFloat1;
      }
      localObject1 = this.WB;
      if (localObject1 != null) {
        localObject1[paramInt] = paramFloat2;
      }
      localObject1 = this.Wz;
      if (localObject1 != null) {
        localObject1[paramInt] = paramFloat2;
      }
      localObject1 = this.WC;
      if (localObject1 != null)
      {
        int m = (int)paramFloat1;
        int k = (int)paramFloat2;
        int j = 0;
        if (m < this.WN.getLeft() + this.Aav) {
          j = 1;
        }
        i = j;
        if (k < this.WN.getTop() + this.Aav) {
          i = j | 0x4;
        }
        j = i;
        if (m > this.WN.getRight() - this.Aav) {
          j = i | 0x2;
        }
        i = j;
        if (k > this.WN.getBottom() - this.Aav) {
          i = j | 0x8;
        }
        localObject1[paramInt] = i;
      }
      this.WF |= 1 << paramInt;
      AppMethodBeat.o(200469);
      return;
    }
  }
  
  private final boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200476);
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    int[] arrayOfInt = this.WC;
    if (arrayOfInt != null)
    {
      i = arrayOfInt[paramInt1];
      if (((i & paramInt2) == paramInt2) && ((this.WJ & paramInt2) != 0))
      {
        arrayOfInt = this.WE;
        if (arrayOfInt == null) {
          break label141;
        }
        i = arrayOfInt[paramInt1];
        label70:
        if ((i & paramInt2) != paramInt2)
        {
          arrayOfInt = this.WD;
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
      if (((i & paramInt2) != paramInt2) && ((paramFloat1 > this.rZ) || (paramFloat2 > this.rZ))) {
        break label153;
      }
      AppMethodBeat.o(200476);
      return false;
      i = 0;
      break;
      i = 0;
      break label70;
    }
    label153:
    arrayOfInt = this.WD;
    if (arrayOfInt != null) {}
    for (paramInt1 = arrayOfInt[paramInt1]; ((paramInt1 & paramInt2) == 0) && (paramFloat1 > this.rZ); paramInt1 = 0)
    {
      AppMethodBeat.o(200476);
      return true;
    }
    AppMethodBeat.o(200476);
    return false;
  }
  
  private final void ab(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(200480);
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker != null) {
      localVelocityTracker.computeCurrentVelocity(1000, this.Aat);
    }
    n(f(t.a(this.mVelocityTracker, this.om), this.Aau, this.Aat), f(t.b(this.mVelocityTracker, this.om), this.Aau, this.Aat), paramFloat1, paramFloat2);
    AppMethodBeat.o(200480);
  }
  
  private final void b(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(200475);
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
        int[] arrayOfInt = this.WD;
        if (arrayOfInt != null)
        {
          arrayOfInt[paramInt] = (i | arrayOfInt[paramInt]);
          AppMethodBeat.o(200475);
          return;
        }
      }
      AppMethodBeat.o(200475);
      return;
      j = 0;
    }
  }
  
  private final void bd(int paramInt)
  {
    if (this.Wy != null)
    {
      localObject = this.Wy;
      if (localObject == null) {
        break label25;
      }
    }
    label25:
    for (int i = localObject.length; i <= paramInt; i = 0) {
      return;
    }
    Object localObject = this.Wy;
    if (localObject != null) {
      localObject[paramInt] = 0.0F;
    }
    localObject = this.Wz;
    if (localObject != null) {
      localObject[paramInt] = 0.0F;
    }
    localObject = this.WA;
    if (localObject != null) {
      localObject[paramInt] = 0.0F;
    }
    localObject = this.WB;
    if (localObject != null) {
      localObject[paramInt] = 0.0F;
    }
    localObject = this.WC;
    if (localObject != null) {
      localObject[paramInt] = 0;
    }
    localObject = this.WD;
    if (localObject != null) {
      localObject[paramInt] = 0;
    }
    localObject = this.WE;
    if (localObject != null) {
      localObject[paramInt] = 0;
    }
    this.WF &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  private boolean be(int paramInt)
  {
    return (this.WF & 0x1) << paramInt != 0;
  }
  
  private static float distanceInfluenceForSnapDuration(float paramFloat)
  {
    AppMethodBeat.i(200467);
    paramFloat = (float)Math.sin((paramFloat - 0.5F) * 0.4712389F);
    AppMethodBeat.o(200467);
    return paramFloat;
  }
  
  private static float f(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(200466);
    float f = Math.abs(paramFloat1);
    if (f < paramFloat2)
    {
      AppMethodBeat.o(200466);
      return 0.0F;
    }
    if (f > paramFloat3)
    {
      if (paramFloat1 > 0.0F)
      {
        AppMethodBeat.o(200466);
        return paramFloat3;
      }
      paramFloat1 = -paramFloat3;
      AppMethodBeat.o(200466);
      return paramFloat1;
    }
    AppMethodBeat.o(200466);
    return paramFloat1;
  }
  
  private final int h(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(200464);
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(200464);
      return 0;
    }
    int i = this.WN.getWidth();
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
      AppMethodBeat.o(200464);
      return paramInt1;
    }
  }
  
  private static int i(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(200465);
    int i = Math.abs(paramInt1);
    if (i < paramInt2)
    {
      AppMethodBeat.o(200465);
      return 0;
    }
    if (i > paramInt3)
    {
      if (paramInt1 > 0)
      {
        AppMethodBeat.o(200465);
        return paramInt3;
      }
      paramInt1 = -paramInt3;
      AppMethodBeat.o(200465);
      return paramInt1;
    }
    AppMethodBeat.o(200465);
    return paramInt1;
  }
  
  private final void i(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200470);
    int j = i.g(paramMotionEvent);
    int i = 0;
    while (i < j)
    {
      int k = i.c(paramMotionEvent, i);
      float f1 = i.d(paramMotionEvent, i);
      float f2 = i.e(paramMotionEvent, i);
      float[] arrayOfFloat1 = this.WA;
      float[] arrayOfFloat2 = this.WB;
      if ((arrayOfFloat1 != null) && (arrayOfFloat2 != null) && (arrayOfFloat1.length > k) && (arrayOfFloat2.length > k))
      {
        arrayOfFloat1[k] = f1;
        arrayOfFloat2[k] = f2;
      }
      i += 1;
    }
    AppMethodBeat.o(200470);
  }
  
  private final void n(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(200468);
    this.WM = true;
    this.Aaw.b(this.Aax, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    this.WM = false;
    if (this.Aas == 1) {
      bf(0);
    }
    AppMethodBeat.o(200468);
  }
  
  private final boolean r(View paramView, float paramFloat)
  {
    AppMethodBeat.i(200477);
    if (paramView == null)
    {
      AppMethodBeat.o(200477);
      return false;
    }
    int i;
    if (this.Aaw.awM() > 0) {
      i = 1;
    }
    while (i != 0) {
      if (Math.abs(paramFloat) > this.rZ)
      {
        AppMethodBeat.o(200477);
        return true;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(200477);
        return false;
      }
    }
    AppMethodBeat.o(200477);
    return false;
  }
  
  private boolean z(View paramView, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(200472);
    if ((paramView == this.Aax) && (this.om == paramInt))
    {
      AppMethodBeat.o(200472);
      return true;
    }
    if ((paramView != null) && (this.Aaw.c(paramView, paramInt)))
    {
      this.om = paramInt;
      p.h(paramView, "childView");
      if (paramView.getParent() == this.WN) {
        i = 1;
      }
      if (i == 0)
      {
        paramView = (Throwable)new IllegalArgumentException(("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.WN + ")").toString());
        AppMethodBeat.o(200472);
        throw paramView;
      }
      this.Aax = paramView;
      this.om = paramInt;
      this.Aaw.eqJ();
      bf(1);
      AppMethodBeat.o(200472);
      return true;
    }
    AppMethodBeat.o(200472);
    return false;
  }
  
  public final boolean RH(int paramInt)
  {
    AppMethodBeat.i(200479);
    if (be(paramInt))
    {
      int[] arrayOfInt = this.WC;
      if (arrayOfInt != null) {}
      for (paramInt = arrayOfInt[paramInt]; (paramInt & 0x1) != 0; paramInt = 0)
      {
        AppMethodBeat.o(200479);
        return true;
      }
    }
    AppMethodBeat.o(200479);
    return false;
  }
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(200462);
    View localView = this.Aax;
    int i;
    if (localView != null)
    {
      i = localView.getLeft();
      localView = this.Aax;
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
      this.UD.abortAnimation();
      bf(0);
      AppMethodBeat.o(200462);
      return false;
      i = 0;
      break;
    }
    label92:
    this.UD.forceFinished(true);
    if ((paramLong == 0L) && (!paramBoolean)) {
      paramLong = H(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    for (;;)
    {
      Log.d("MultiTaskSwipeDragHelper", "chrispaulwu:: xvel %d, yvel %d, dx %d, dy %d duration %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
      this.UD.startScroll(i, j, paramInt1, paramInt2, (int)paramLong);
      bf(2);
      AppMethodBeat.o(200462);
      return true;
      if (paramBoolean) {
        paramLong = 0L;
      }
    }
  }
  
  public final boolean a(View paramView, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(200461);
    this.Aax = paramView;
    this.om = -1;
    paramBoolean = a(paramInt1, paramInt2, 0, 0, paramLong, paramBoolean);
    AppMethodBeat.o(200461);
    return paramBoolean;
  }
  
  public final void abort()
  {
    AppMethodBeat.i(200460);
    cancel();
    if (this.Aas == 2)
    {
      int i = this.UD.getCurrX();
      int j = this.UD.getCurrY();
      this.UD.abortAnimation();
      int k = this.UD.getCurrX();
      int m = this.UD.getCurrY();
      this.Aaw.l(this.Aax, k, m, k - i, m - j);
    }
    bf(0);
    AppMethodBeat.o(200460);
  }
  
  public final void bf(int paramInt)
  {
    AppMethodBeat.i(200471);
    if (this.Aas != paramInt)
    {
      this.Aas = paramInt;
      this.Aaw.L(paramInt);
      if (paramInt == 0) {
        this.Aax = null;
      }
    }
    AppMethodBeat.o(200471);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(200459);
    this.om = -1;
    if (this.Wy != null)
    {
      Arrays.fill(this.Wy, 0.0F);
      Arrays.fill(this.Wz, 0.0F);
      Arrays.fill(this.WA, 0.0F);
      Arrays.fill(this.WB, 0.0F);
      Arrays.fill(this.WC, 0);
      Arrays.fill(this.WD, 0);
      Arrays.fill(this.WE, 0);
      this.WF = 0;
    }
    if (this.mVelocityTracker != null)
    {
      VelocityTracker localVelocityTracker = this.mVelocityTracker;
      if (localVelocityTracker != null) {
        localVelocityTracker.recycle();
      }
      this.mVelocityTracker = null;
    }
    AppMethodBeat.o(200459);
  }
  
  public final boolean hl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200478);
    if ((!be(paramInt2)) || (this.Wy == null))
    {
      AppMethodBeat.o(200478);
      return false;
    }
    int i;
    int j;
    label49:
    int k;
    if ((paramInt1 & 0x1) == 1)
    {
      i = 1;
      if ((paramInt1 & 0x2) != 2) {
        break label182;
      }
      j = 1;
      if ((paramInt1 & 0x8) != 8) {
        break label188;
      }
      k = 1;
      label61:
      if ((paramInt1 & 0x4) != 4) {
        break label194;
      }
    }
    float f1;
    float f2;
    label182:
    label188:
    label194:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      float[] arrayOfFloat1 = this.WA;
      float[] arrayOfFloat2 = this.WB;
      float[] arrayOfFloat3 = this.Wy;
      float[] arrayOfFloat4 = this.Wz;
      if ((arrayOfFloat1 == null) || (arrayOfFloat2 == null) || (arrayOfFloat3 == null) || (arrayOfFloat4 == null)) {
        break label363;
      }
      f1 = arrayOfFloat1[paramInt2] - arrayOfFloat3[paramInt2];
      f2 = arrayOfFloat2[paramInt2] - arrayOfFloat4[paramInt2];
      if ((i == 0) || (j == 0)) {
        break label207;
      }
      if (f1 * f1 + f2 * f2 <= this.rZ * this.rZ) {
        break label199;
      }
      AppMethodBeat.o(200478);
      return true;
      i = 0;
      break;
      j = 0;
      break label49;
      k = 0;
      break label61;
    }
    label199:
    AppMethodBeat.o(200478);
    return false;
    label207:
    if (paramInt1 != 0)
    {
      if ((f1 < this.rZ) && (Math.abs(f1) > Math.abs(f2)))
      {
        AppMethodBeat.o(200478);
        return true;
      }
      AppMethodBeat.o(200478);
      return false;
    }
    if (k != 0)
    {
      if ((f1 > this.rZ) && (Math.abs(f1) > Math.abs(f2)))
      {
        AppMethodBeat.o(200478);
        return true;
      }
      AppMethodBeat.o(200478);
      return false;
    }
    if (i != 0)
    {
      if (Math.abs(f1) > this.rZ)
      {
        AppMethodBeat.o(200478);
        return true;
      }
      AppMethodBeat.o(200478);
      return false;
    }
    if (j != 0)
    {
      if (Math.abs(f2) > this.rZ)
      {
        AppMethodBeat.o(200478);
        return true;
      }
      AppMethodBeat.o(200478);
      return false;
    }
    label363:
    AppMethodBeat.o(200478);
    return false;
  }
  
  public final boolean j(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200473);
    p.h(paramMotionEvent, "ev");
    int j = i.e(paramMotionEvent);
    int i = i.f(paramMotionEvent);
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
    while (this.Aas == 1)
    {
      AppMethodBeat.o(200473);
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      i = i.c(paramMotionEvent, 0);
      a(f1, f2, i);
      paramMotionEvent = J((int)f1, (int)f2);
      if ((paramMotionEvent == this.Aax) && (this.Aas == 2)) {
        z(paramMotionEvent, i);
      }
      paramMotionEvent = this.WC;
      if (paramMotionEvent != null) {}
      for (paramMotionEvent = Integer.valueOf(paramMotionEvent[i]); paramMotionEvent != null; paramMotionEvent = null)
      {
        ((Number)paramMotionEvent).intValue();
        break;
      }
      j = i.c(paramMotionEvent, i);
      f1 = i.d(paramMotionEvent, i);
      f2 = i.e(paramMotionEvent, i);
      a(f1, f2, j);
      if (this.Aas == 0)
      {
        paramMotionEvent = this.WC;
        if (paramMotionEvent != null) {}
        for (paramMotionEvent = Integer.valueOf(paramMotionEvent[j]); paramMotionEvent != null; paramMotionEvent = null)
        {
          ((Number)paramMotionEvent).intValue();
          if ((paramMotionEvent.intValue() & this.WJ) == 0) {
            break;
          }
          paramMotionEvent.intValue();
          break;
        }
      }
      label414:
      label545:
      label550:
      label556:
      if (this.Aas == 2)
      {
        paramMotionEvent = J((int)f1, (int)f2);
        label437:
        label475:
        if (paramMotionEvent == this.Aax)
        {
          z(paramMotionEvent, j);
          continue;
          i(paramMotionEvent);
          int m = i.g(paramMotionEvent);
          i = 0;
          label360:
          if ((i < m) && (this.Wy != null))
          {
            int n = i.c(paramMotionEvent, i);
            float f3 = i.d(paramMotionEvent, i);
            f2 = i.e(paramMotionEvent, i);
            localObject = this.Wy;
            if (localObject != null)
            {
              f1 = localObject[n];
              f3 -= f1;
              localObject = this.Wz;
              if (localObject == null) {
                break label545;
              }
              f1 = localObject[n];
              b(f3, f2 - f1, n);
              if (this.Aas == 1) {
                continue;
              }
              localObject = this.Wy;
              if (localObject == null) {
                break label550;
              }
              j = (int)localObject[n];
              localObject = this.Wz;
              if (localObject == null) {
                break label556;
              }
            }
            for (int k = (int)localObject[n];; k = 0)
            {
              localObject = J(j, k);
              if ((localObject != null) && (r((View)localObject, f3)) && (z((View)localObject, n))) {
                break;
              }
              i += 1;
              break label360;
              f1 = 0.0F;
              break label414;
              f1 = 0.0F;
              break label437;
              j = 0;
              break label475;
            }
            bd(i.c(paramMotionEvent, i));
            continue;
            cancel();
          }
        }
      }
    }
    AppMethodBeat.o(200473);
    return false;
  }
  
  public final void k(MotionEvent paramMotionEvent)
  {
    int i = 0;
    int k = 0;
    int m = 0;
    int j = 0;
    float f3 = 0.0F;
    float f2 = 0.0F;
    AppMethodBeat.i(200474);
    p.h(paramMotionEvent, "ev");
    int i1 = i.e(paramMotionEvent);
    int n = i.f(paramMotionEvent);
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
    float f4;
    label531:
    label799:
    label1314:
    switch (i1)
    {
    case 4: 
    default: 
    case 0: 
    case 5: 
      do
      {
        AppMethodBeat.o(200474);
        return;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        i = i.c(paramMotionEvent, 0);
        paramMotionEvent = J((int)f1, (int)f2);
        a(f1, f2, i);
        z(paramMotionEvent, i);
        paramMotionEvent = this.WC;
        if (paramMotionEvent != null) {}
        for (paramMotionEvent = Integer.valueOf(paramMotionEvent[i]); paramMotionEvent != null; paramMotionEvent = null)
        {
          ((Number)paramMotionEvent).intValue();
          if ((paramMotionEvent.intValue() & this.WJ) != 0) {
            paramMotionEvent.intValue();
          }
          AppMethodBeat.o(200474);
          return;
        }
        AppMethodBeat.o(200474);
        return;
        k = i.c(paramMotionEvent, n);
        f1 = i.d(paramMotionEvent, n);
        f2 = i.e(paramMotionEvent, n);
        a(f1, f2, k);
        if (this.Aas != 0) {
          break;
        }
        z(J((int)f1, (int)f2), k);
      } while (this.WC != null);
      AppMethodBeat.o(200474);
      return;
      m = (int)f1;
      n = (int)f2;
      paramMotionEvent = this.Aax;
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
        z(this.Aax, k);
      }
      AppMethodBeat.o(200474);
      return;
    case 2: 
      if (this.Aas == 1)
      {
        j = i.b(paramMotionEvent, this.om);
        i = j;
        if (j < 0) {
          i = 0;
        }
        f3 = i.d(paramMotionEvent, i);
        f4 = i.e(paramMotionEvent, i);
        localObject = this.WA;
        int i2;
        if (localObject != null)
        {
          f1 = localObject[this.om];
          i1 = (int)((f3 - f1) / 1.666667F);
          localObject = this.WB;
          if (localObject == null) {
            break label799;
          }
          f1 = localObject[this.om];
          i2 = (int)((f4 - f1) / 1.666667F);
          localObject = this.Aax;
          if (localObject == null) {
            break label804;
          }
          i = ((View)localObject).getLeft();
          n = i + i1;
          localObject = this.Aax;
          if (localObject == null) {
            break label810;
          }
          i = ((View)localObject).getTop();
          i += i2;
          localObject = this.Aax;
          if (localObject == null) {
            break label816;
          }
          j = ((View)localObject).getLeft();
          localObject = this.Aax;
          if (localObject == null) {
            break label822;
          }
          k = ((View)localObject).getTop();
          m = n;
          if (i1 != 0)
          {
            n = this.Aaw.RI(n);
            localObject = this.Aax;
            m = n;
            if (localObject != null)
            {
              ((View)localObject).offsetLeftAndRight(n - j);
              m = n;
            }
          }
          if (i2 != 0)
          {
            localObject = this.Aax;
            if (localObject == null) {
              break label828;
            }
            ((View)localObject).offsetTopAndBottom(0 - k);
            i = 0;
          }
          if ((i1 != 0) || (i2 != 0)) {
            this.Aaw.l(this.Aax, m, i, m - j, i - k);
          }
          localObject = this.Wy;
          if (localObject == null) {
            break label834;
          }
        }
        for (f1 = localObject[this.om];; f1 = 0.0F)
        {
          localObject = this.Wz;
          if (localObject != null) {
            f2 = localObject[this.om];
          }
          i = (int)(f3 - f1);
          j = (int)(f4 - f2);
          this.Aaw.a(f3, f4, i1, i2, i, j);
          i(paramMotionEvent);
          AppMethodBeat.o(200474);
          return;
          f1 = 0.0F;
          break;
          f1 = 0.0F;
          break label502;
          i = 0;
          break label531;
          i = 0;
          break label556;
          j = 0;
          break label581;
          k = 0;
          break label599;
          i = 0;
          break label676;
        }
      }
      m = i.g(paramMotionEvent);
      i = 0;
      if ((i < m) && (this.Wy != null))
      {
        n = i.c(paramMotionEvent, i);
        f3 = i.d(paramMotionEvent, i);
        f2 = i.e(paramMotionEvent, i);
        localObject = this.Wy;
        if (localObject != null)
        {
          f1 = localObject[n];
          f3 -= f1;
          localObject = this.Wz;
          if (localObject == null) {
            break label1028;
          }
          f1 = localObject[n];
          b(f3, f2 - f1, n);
          if (this.Aas == 1) {
            break label1045;
          }
          localObject = this.Wy;
          if (localObject == null) {
            break label1033;
          }
          j = (int)localObject[n];
          localObject = this.Wz;
          if (localObject == null) {
            break label1039;
          }
        }
        for (k = (int)localObject[n];; k = 0)
        {
          localObject = J(j, k);
          if ((r((View)localObject, f3)) && (z((View)localObject, n))) {
            break label1045;
          }
          i += 1;
          break;
          f1 = 0.0F;
          break label902;
          f1 = 0.0F;
          break label925;
          j = 0;
          break label963;
        }
      }
      i(paramMotionEvent);
      AppMethodBeat.o(200474);
      return;
    case 6: 
      label804:
      m = i.c(paramMotionEvent, n);
      if ((this.Aas == 1) && (m == this.om))
      {
        k = -1;
        n = i.g(paramMotionEvent);
      }
      for (;;)
      {
        j = k;
        if (i < n)
        {
          j = i.c(paramMotionEvent, i);
          if (j == this.om)
          {
            i += 1;
            continue;
          }
          f1 = i.d(paramMotionEvent, i);
          f2 = i.e(paramMotionEvent, i);
          if ((J((int)f1, (int)f2) == this.Aax) && (z(this.Aax, j))) {
            j = this.om;
          }
        }
        else
        {
          if (j == -1) {
            ab(0.0F, 0.0F);
          }
          bd(m);
          AppMethodBeat.o(200474);
          return;
        }
        i += 1;
      }
    case 1: 
      label502:
      float f5;
      label556:
      label581:
      label599:
      if (this.Aas == 1)
      {
        i = i.b(paramMotionEvent, this.om);
        if (i >= 0) {
          break label1311;
        }
        i = k;
        f4 = i.d(paramMotionEvent, i);
        f5 = i.e(paramMotionEvent, i);
        paramMotionEvent = this.Wy;
        if (paramMotionEvent == null) {
          break label1314;
        }
      }
      label676:
      label810:
      label816:
      label822:
      label828:
      label834:
      label963:
      for (f1 = paramMotionEvent[this.om];; f1 = 0.0F)
      {
        paramMotionEvent = this.Wz;
        f2 = f3;
        if (paramMotionEvent != null) {
          f2 = paramMotionEvent[this.om];
        }
        ab(f4 - f1, f5 - f2);
        cancel();
        AppMethodBeat.o(200474);
        return;
        break;
      }
    }
    label902:
    label925:
    label1311:
    if (this.Aas == 1)
    {
      i = i.b(paramMotionEvent, this.om);
      if (i >= 0) {
        break label1415;
      }
      i = m;
      label1346:
      f3 = i.d(paramMotionEvent, i);
      f4 = i.e(paramMotionEvent, i);
      paramMotionEvent = this.Wy;
      if (paramMotionEvent == null) {
        break label1418;
      }
      f1 = paramMotionEvent[this.om];
      label1378:
      paramMotionEvent = this.Wz;
      if (paramMotionEvent == null) {
        break label1423;
      }
    }
    label1028:
    label1033:
    label1039:
    label1045:
    for (f2 = paramMotionEvent[this.om];; f2 = 0.0F)
    {
      n(0.0F, 0.0F, f3 - f1, f4 - f2);
      cancel();
      break;
      break label1346;
      f1 = 0.0F;
      break label1378;
    }
  }
  
  public final void m(Rect paramRect)
  {
    AppMethodBeat.i(200458);
    p.h(paramRect, "positon");
    this.Aay = new Rect(paramRect);
    AppMethodBeat.o(200458);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Callback;", "", "()V", "clampViewPositionHorizontal", "", "child", "Landroid/view/View;", "left", "dx", "clampViewPositionVertical", "top", "dy", "getOrderedChildIndex", "index", "getViewHorizontalDragRange", "getViewVerticalDragRange", "onEdgeDragStarted", "", "edgeFlags", "pointerId", "onEdgeLock", "", "onEdgeTouched", "onViewCaptured", "capturedChild", "activePointerId", "onViewDragStateChanged", "state", "onViewPositionChanged", "changedView", "onViewReleased", "releasedChild", "xvel", "", "yvel", "onViewTouchPositionChanged", "touchX", "touchY", "adx", "ady", "tryCaptureView", "plugin-multitask_release"})
  public static abstract class a
  {
    public void L(int paramInt) {}
    
    public int RI(int paramInt)
    {
      return 0;
    }
    
    public void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    public int awM()
    {
      return 0;
    }
    
    public void b(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
    
    public abstract boolean c(View paramView, int paramInt);
    
    public void eqJ() {}
    
    public void l(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Companion;", "", "()V", "BASE_SETTLE_DURATION", "", "DIRECTION_ALL", "DIRECTION_HORIZONTAL", "DIRECTION_HORIZONTAL_LEFT", "DIRECTION_HORIZONTAL_RIGHT", "DIRECTION_VERTICAL", "EDGE_ALL", "EDGE_BOTTOM", "EDGE_LEFT", "EDGE_RIGHT", "EDGE_SIZE", "EDGE_TOP", "INVALID_POINTER", "MAX_SETTLE_DURATION", "STATE_DRAGGING", "STATE_IDLE", "STATE_SETTLING", "TAG", "", "sInterpolator", "Landroid/view/animation/Interpolator;", "create", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "forParent", "Landroid/view/ViewGroup;", "cb", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Callback;", "interpolator", "sensitivity", "", "plugin-multitask_release"})
  public static final class b
  {
    public static c a(ViewGroup paramViewGroup, c.a parama, Interpolator paramInterpolator)
    {
      AppMethodBeat.i(200456);
      p.h(paramViewGroup, "forParent");
      p.h(paramInterpolator, "interpolator");
      Context localContext = paramViewGroup.getContext();
      p.g(localContext, "forParent.context");
      paramViewGroup = new c(localContext, paramViewGroup, parama, paramInterpolator, (byte)0);
      AppMethodBeat.o(200456);
      return paramViewGroup;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(200457);
      this.AaB.bf(0);
      AppMethodBeat.o(200457);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.c.a.c
 * JD-Core Version:    0.7.0.1
 */