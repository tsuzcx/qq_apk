package me.imid.swipebacklayout.lib;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.widget.p;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class b
{
  private static final Interpolator sInterpolator;
  int[] KgL;
  final a KgM;
  float[] TA;
  float[] TB;
  private float[] TC;
  private float[] TD;
  private int[] TF;
  private int[] TG;
  private int TH;
  float TI;
  float TJ;
  int TK;
  int TL;
  View TN;
  boolean TO;
  final ViewGroup TP;
  final Runnable TQ;
  int Tz;
  int mActivePointerId;
  private int mTouchSlop;
  VelocityTracker mVelocityTracker;
  p mjD;
  
  static
  {
    AppMethodBeat.i(140924);
    sInterpolator = new Interpolator()
    {
      public final float getInterpolation(float paramAnonymousFloat)
      {
        paramAnonymousFloat -= 1.0F;
        return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
      }
    };
    AppMethodBeat.o(140924);
  }
  
  private b(Context paramContext, ViewGroup paramViewGroup, a parama)
  {
    AppMethodBeat.i(140898);
    this.mActivePointerId = -1;
    this.TQ = new b.2(this);
    if (paramViewGroup == null)
    {
      paramContext = new IllegalArgumentException("Parent view may not be null");
      AppMethodBeat.o(140898);
      throw paramContext;
    }
    if (parama == null)
    {
      paramContext = new IllegalArgumentException("Callback may not be null");
      AppMethodBeat.o(140898);
      throw paramContext;
    }
    this.TP = paramViewGroup;
    this.KgM = parama;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.TK = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.mTouchSlop = paramViewGroup.getScaledTouchSlop();
    this.TI = paramViewGroup.getScaledMaximumFlingVelocity();
    this.TJ = paramViewGroup.getScaledMinimumFlingVelocity();
    this.mjD = p.a(paramContext, sInterpolator);
    AppMethodBeat.o(140898);
  }
  
  private boolean B(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140920);
    boolean bool = i(this.TN, paramInt1, paramInt2);
    AppMethodBeat.o(140920);
    return bool;
  }
  
  public static b a(ViewGroup paramViewGroup, a parama)
  {
    AppMethodBeat.i(140897);
    paramViewGroup = new b(paramViewGroup.getContext(), paramViewGroup, parama);
    AppMethodBeat.o(140897);
    return paramViewGroup;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140914);
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    if (((this.KgL[paramInt1] & paramInt2) != paramInt2) || ((this.TL & paramInt2) == 0) || ((this.TG[paramInt1] & paramInt2) == paramInt2) || ((this.TF[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= this.mTouchSlop) && (paramFloat2 <= this.mTouchSlop)))
    {
      AppMethodBeat.o(140914);
      return false;
    }
    if (((this.TF[paramInt1] & paramInt2) == 0) && (paramFloat1 > this.mTouchSlop))
    {
      AppMethodBeat.o(140914);
      return true;
    }
    AppMethodBeat.o(140914);
    return false;
  }
  
  private void agl(int paramInt)
  {
    AppMethodBeat.i(140907);
    if ((this.TA == null) || (this.TA.length <= paramInt))
    {
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      float[] arrayOfFloat4 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.TA != null)
      {
        System.arraycopy(this.TA, 0, arrayOfFloat1, 0, this.TA.length);
        System.arraycopy(this.TB, 0, arrayOfFloat2, 0, this.TB.length);
        System.arraycopy(this.TC, 0, arrayOfFloat3, 0, this.TC.length);
        System.arraycopy(this.TD, 0, arrayOfFloat4, 0, this.TD.length);
        System.arraycopy(this.KgL, 0, arrayOfInt1, 0, this.KgL.length);
        System.arraycopy(this.TF, 0, arrayOfInt2, 0, this.TF.length);
        System.arraycopy(this.TG, 0, arrayOfInt3, 0, this.TG.length);
      }
      this.TA = arrayOfFloat1;
      this.TB = arrayOfFloat2;
      this.TC = arrayOfFloat3;
      this.TD = arrayOfFloat4;
      this.KgL = arrayOfInt1;
      this.TF = arrayOfInt2;
      this.TG = arrayOfInt3;
    }
    AppMethodBeat.o(140907);
  }
  
  private boolean bd(int paramInt)
  {
    return (this.TH & 1 << paramInt) != 0;
  }
  
  private static float distanceInfluenceForSnapDuration(float paramFloat)
  {
    AppMethodBeat.i(140904);
    paramFloat = (float)Math.sin((float)((paramFloat - 0.5F) * 0.47123891676382D));
    AppMethodBeat.o(140904);
    return paramFloat;
  }
  
  private void fI()
  {
    AppMethodBeat.i(140906);
    if (this.TA == null)
    {
      AppMethodBeat.o(140906);
      return;
    }
    Arrays.fill(this.TA, 0.0F);
    Arrays.fill(this.TB, 0.0F);
    Arrays.fill(this.TC, 0.0F);
    Arrays.fill(this.TD, 0.0F);
    Arrays.fill(this.KgL, 0);
    Arrays.fill(this.TF, 0);
    Arrays.fill(this.TG, 0);
    this.TH = 0;
    AppMethodBeat.o(140906);
  }
  
  private void fJ()
  {
    AppMethodBeat.i(140918);
    this.mVelocityTracker.computeCurrentVelocity(1000, this.TI);
    l(g(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.TJ, this.TI), g(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.TJ, this.TI));
    AppMethodBeat.o(140918);
  }
  
  private static float g(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(140903);
    float f = Math.abs(paramFloat1);
    if (f < paramFloat2)
    {
      AppMethodBeat.o(140903);
      return 0.0F;
    }
    if (f > paramFloat3)
    {
      if (paramFloat1 > 0.0F)
      {
        AppMethodBeat.o(140903);
        return paramFloat3;
      }
      paramFloat1 = -paramFloat3;
      AppMethodBeat.o(140903);
      return paramFloat1;
    }
    AppMethodBeat.o(140903);
    return paramFloat1;
  }
  
  static int i(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(140902);
    int i = Math.abs(paramInt1);
    if (i < paramInt2)
    {
      AppMethodBeat.o(140902);
      return 0;
    }
    if (i > paramInt3)
    {
      if (paramInt1 > 0)
      {
        AppMethodBeat.o(140902);
        return paramInt3;
      }
      paramInt1 = -paramInt3;
      AppMethodBeat.o(140902);
      return paramInt1;
    }
    AppMethodBeat.o(140902);
    return paramInt1;
  }
  
  private void i(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(140919);
    int i = this.TN.getLeft();
    int j = this.TN.getTop();
    if (paramInt3 != 0)
    {
      paramInt1 = this.KgM.e(this.TN, paramInt1);
      this.TN.offsetLeftAndRight(paramInt1 - i);
    }
    for (;;)
    {
      if (paramInt4 != 0)
      {
        paramInt2 = this.KgM.d(this.TN, paramInt2);
        this.TN.offsetTopAndBottom(paramInt2 - j);
      }
      for (;;)
      {
        if ((paramInt3 != 0) || (paramInt4 != 0)) {
          this.KgM.o(this.TN, paramInt1, paramInt2, paramInt1 - i, paramInt2 - j);
        }
        AppMethodBeat.o(140919);
        return;
      }
    }
  }
  
  private static boolean i(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140921);
    if (paramView == null)
    {
      AppMethodBeat.o(140921);
      return false;
    }
    if ((paramInt1 >= paramView.getLeft()) && (paramInt1 < paramView.getRight()) && (paramInt2 >= paramView.getTop()) && (paramInt2 < paramView.getBottom()))
    {
      AppMethodBeat.o(140921);
      return true;
    }
    AppMethodBeat.o(140921);
    return false;
  }
  
  private int kU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140923);
    int i = 0;
    if (paramInt1 < this.TP.getLeft() + this.TK) {
      i = 1;
    }
    if (paramInt2 < this.TP.getTop() + this.TK) {
      i = 4;
    }
    if (paramInt1 > this.TP.getRight() - this.TK) {
      i = 2;
    }
    if (paramInt2 > this.TP.getBottom() - this.TK) {
      i = 8;
    }
    AppMethodBeat.o(140923);
    return i;
  }
  
  private void l(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(140905);
    this.TO = true;
    this.KgM.a(this.TN, paramFloat1, paramFloat2);
    this.TO = false;
    if (this.Tz == 1) {
      be(0);
    }
    AppMethodBeat.o(140905);
  }
  
  private void y(View paramView, int paramInt)
  {
    AppMethodBeat.i(140899);
    if (paramView.getParent() != this.TP)
    {
      paramView = new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.TP + ")");
      AppMethodBeat.o(140899);
      throw paramView;
    }
    this.TN = paramView;
    this.mActivePointerId = paramInt;
    be(1);
    AppMethodBeat.o(140899);
  }
  
  public final View C(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140922);
    int i = this.TP.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.TP.getChildAt(i);
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom()))
      {
        AppMethodBeat.o(140922);
        return localView;
      }
      i -= 1;
    }
    AppMethodBeat.o(140922);
    return null;
  }
  
  final void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(140908);
    agl(paramInt);
    float[] arrayOfFloat = this.TA;
    this.TC[paramInt] = paramFloat1;
    arrayOfFloat[paramInt] = paramFloat1;
    arrayOfFloat = this.TB;
    this.TD[paramInt] = paramFloat2;
    arrayOfFloat[paramInt] = paramFloat2;
    this.KgL[paramInt] = kU((int)paramFloat1, (int)paramFloat2);
    this.TH |= 1 << paramInt;
    AppMethodBeat.o(140908);
  }
  
  final void b(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(140913);
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
        int[] arrayOfInt = this.TF;
        arrayOfInt[paramInt] = (i | arrayOfInt[paramInt]);
      }
      AppMethodBeat.o(140913);
      return;
      j = 0;
    }
  }
  
  final void bc(int paramInt)
  {
    if (this.TA == null) {
      return;
    }
    this.TA[paramInt] = 0.0F;
    this.TB[paramInt] = 0.0F;
    this.TC[paramInt] = 0.0F;
    this.TD[paramInt] = 0.0F;
    this.KgL[paramInt] = 0;
    this.TF[paramInt] = 0;
    this.TG[paramInt] = 0;
    this.TH &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  public final void be(int paramInt)
  {
    AppMethodBeat.i(140910);
    if (this.Tz != paramInt)
    {
      this.Tz = paramInt;
      this.KgM.M(paramInt);
      if (paramInt == 0) {
        this.TN = null;
      }
    }
    AppMethodBeat.o(140910);
  }
  
  final boolean c(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(140915);
    if (paramView == null)
    {
      AppMethodBeat.o(140915);
      return false;
    }
    int i;
    int j;
    if (this.KgM.fdh() > 0)
    {
      i = 1;
      if (this.KgM.bH() <= 0) {
        break label89;
      }
      j = 1;
    }
    for (;;)
    {
      if ((i != 0) && (j != 0))
      {
        if (paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 > this.mTouchSlop * this.mTouchSlop)
        {
          AppMethodBeat.o(140915);
          return true;
          i = 0;
          break;
          label89:
          j = 0;
          continue;
        }
        AppMethodBeat.o(140915);
        return false;
      }
    }
    if (i != 0)
    {
      if (Math.abs(paramFloat1) > this.mTouchSlop)
      {
        AppMethodBeat.o(140915);
        return true;
      }
      AppMethodBeat.o(140915);
      return false;
    }
    if (j != 0)
    {
      if (Math.abs(paramFloat2) > this.mTouchSlop)
      {
        AppMethodBeat.o(140915);
        return true;
      }
      AppMethodBeat.o(140915);
      return false;
    }
    AppMethodBeat.o(140915);
    return false;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(140900);
    this.mActivePointerId = -1;
    fI();
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
    AppMethodBeat.o(140900);
  }
  
  final void f(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(140909);
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    while (i < j)
    {
      int k = paramMotionEvent.getPointerId(i);
      float f1 = paramMotionEvent.getX(i);
      float f2 = paramMotionEvent.getY(i);
      this.TC[k] = f1;
      this.TD[k] = f2;
      i += 1;
    }
    AppMethodBeat.o(140909);
  }
  
  final int h(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(140901);
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(140901);
      return 0;
    }
    int i = this.TP.getWidth();
    int j = i / 2;
    float f3 = Math.min(1.0F, Math.abs(paramInt1) / i);
    float f1 = j;
    float f2 = j;
    f3 = distanceInfluenceForSnapDuration(f3);
    paramInt2 = Math.abs(paramInt2);
    if (paramInt2 > 0) {}
    for (paramInt1 = Math.round(Math.abs((f3 * f2 + f1) / paramInt2) * 1000.0F) * 4;; paramInt1 = (int)((Math.abs(paramInt1) / paramInt3 + 1.0F) * 256.0F))
    {
      paramInt1 = Math.min(paramInt1, 600);
      AppMethodBeat.o(140901);
      return paramInt1;
    }
  }
  
  public final void h(MotionEvent paramMotionEvent)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(140912);
    int m = paramMotionEvent.getActionMasked();
    int k = paramMotionEvent.getActionIndex();
    if (m == 0) {
      cancel();
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    float f1;
    float f2;
    switch (m)
    {
    case 4: 
    default: 
    case 0: 
    case 5: 
      do
      {
        do
        {
          AppMethodBeat.o(140912);
          return;
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          i = paramMotionEvent.getPointerId(0);
          paramMotionEvent = C((int)f1, (int)f2);
          a(f1, f2, i);
          z(paramMotionEvent, i);
        } while ((this.KgL[i] & this.TL) == 0);
        AppMethodBeat.o(140912);
        return;
        i = paramMotionEvent.getPointerId(k);
        f1 = paramMotionEvent.getX(k);
        f2 = paramMotionEvent.getY(k);
        a(f1, f2, i);
        if (this.Tz == 0)
        {
          z(C((int)f1, (int)f2), i);
          AppMethodBeat.o(140912);
          return;
        }
      } while (!B((int)f1, (int)f2));
      z(this.TN, i);
      AppMethodBeat.o(140912);
      return;
    case 2: 
      if (this.Tz == 1)
      {
        i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        i = (int)(f1 - this.TC[this.mActivePointerId]);
        j = (int)(f2 - this.TD[this.mActivePointerId]);
        i(this.TN.getLeft() + i, this.TN.getTop() + j, i, j);
        f(paramMotionEvent);
        AppMethodBeat.o(140912);
        return;
      }
      k = paramMotionEvent.getPointerCount();
      i = j;
      while (i < k)
      {
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        float f3 = f1 - this.TA[j];
        float f4 = f2 - this.TB[j];
        b(f3, f4, j);
        if (this.Tz == 1) {
          break;
        }
        View localView = C((int)f1, (int)f2);
        if ((c(localView, f3, f4)) && (z(localView, j))) {
          break;
        }
        i += 1;
      }
      f(paramMotionEvent);
      AppMethodBeat.o(140912);
      return;
    case 6: 
      j = paramMotionEvent.getPointerId(k);
      if ((this.Tz == 1) && (j == this.mActivePointerId))
      {
        k = paramMotionEvent.getPointerCount();
        label524:
        if (i >= k) {
          break label672;
        }
        m = paramMotionEvent.getPointerId(i);
        if (m == this.mActivePointerId) {
          break label619;
        }
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        if ((C((int)f1, (int)f2) != this.TN) || (!z(this.TN, m))) {
          break label619;
        }
      }
      break;
    }
    label672:
    for (i = this.mActivePointerId;; i = -1)
    {
      if (i == -1) {
        fJ();
      }
      bc(j);
      AppMethodBeat.o(140912);
      return;
      label619:
      i += 1;
      break label524;
      if (this.Tz == 1) {
        fJ();
      }
      cancel();
      AppMethodBeat.o(140912);
      return;
      if (this.Tz == 1) {
        l(0.0F, 0.0F);
      }
      cancel();
      break;
    }
  }
  
  public final boolean kS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140916);
    if (!bd(paramInt2))
    {
      AppMethodBeat.o(140916);
      return false;
    }
    int i;
    if ((paramInt1 & 0x1) == 1)
    {
      i = 1;
      if ((paramInt1 & 0x2) != 2) {
        break label116;
      }
    }
    float f1;
    float f2;
    label116:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      f1 = this.TC[paramInt2] - this.TA[paramInt2];
      f2 = this.TD[paramInt2] - this.TB[paramInt2];
      if ((i == 0) || (paramInt1 == 0)) {
        break label129;
      }
      if (f1 * f1 + f2 * f2 <= this.mTouchSlop * this.mTouchSlop) {
        break label121;
      }
      AppMethodBeat.o(140916);
      return true;
      i = 0;
      break;
    }
    label121:
    AppMethodBeat.o(140916);
    return false;
    label129:
    if (i != 0)
    {
      if (Math.abs(f1) > this.mTouchSlop)
      {
        AppMethodBeat.o(140916);
        return true;
      }
      AppMethodBeat.o(140916);
      return false;
    }
    if (paramInt1 != 0)
    {
      if (Math.abs(f2) > this.mTouchSlop)
      {
        AppMethodBeat.o(140916);
        return true;
      }
      AppMethodBeat.o(140916);
      return false;
    }
    AppMethodBeat.o(140916);
    return false;
  }
  
  public final boolean kT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140917);
    if ((bd(paramInt2)) && ((this.KgL[paramInt2] & paramInt1) != 0))
    {
      AppMethodBeat.o(140917);
      return true;
    }
    AppMethodBeat.o(140917);
    return false;
  }
  
  final boolean z(View paramView, int paramInt)
  {
    AppMethodBeat.i(140911);
    if ((paramView == this.TN) && (this.mActivePointerId == paramInt))
    {
      AppMethodBeat.o(140911);
      return true;
    }
    if ((paramView != null) && (this.KgM.aaf(paramInt)))
    {
      this.mActivePointerId = paramInt;
      y(paramView, paramInt);
      AppMethodBeat.o(140911);
      return true;
    }
    AppMethodBeat.o(140911);
    return false;
  }
  
  public static abstract class a
  {
    public void M(int paramInt) {}
    
    public void a(View paramView, float paramFloat1, float paramFloat2) {}
    
    public abstract boolean aaf(int paramInt);
    
    public int bH()
    {
      return 0;
    }
    
    public int d(View paramView, int paramInt)
    {
      return 0;
    }
    
    public int e(View paramView, int paramInt)
    {
      return 0;
    }
    
    public int fdh()
    {
      return 0;
    }
    
    public void o(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     me.imid.swipebacklayout.lib.b
 * JD-Core Version:    0.7.0.1
 */