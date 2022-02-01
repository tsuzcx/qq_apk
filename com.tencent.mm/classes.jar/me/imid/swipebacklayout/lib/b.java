package me.imid.swipebacklayout.lib;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.core.widget.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class b
{
  private static final Interpolator sInterpolator;
  int[] ajFo;
  final a ajFp;
  float[] bxA;
  private float[] bxB;
  private float[] bxC;
  private int[] bxE;
  private int[] bxF;
  private int bxG;
  float bxH;
  float bxI;
  int bxJ;
  int bxK;
  View bxM;
  boolean bxN;
  final ViewGroup bxO;
  final Runnable bxP;
  int bxy;
  float[] bxz;
  int mActivePointerId;
  private int mTouchSlop;
  VelocityTracker mVelocityTracker;
  i mri;
  
  static
  {
    AppMethodBeat.i(140924);
    sInterpolator = new b.1();
    AppMethodBeat.o(140924);
  }
  
  private b(Context paramContext, ViewGroup paramViewGroup, a parama)
  {
    AppMethodBeat.i(140898);
    this.mActivePointerId = -1;
    this.bxP = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140896);
        b.this.eM(0);
        AppMethodBeat.o(140896);
      }
    };
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
    this.bxO = paramViewGroup;
    this.ajFp = parama;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.bxJ = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.mTouchSlop = paramViewGroup.getScaledTouchSlop();
    this.bxH = paramViewGroup.getScaledMaximumFlingVelocity();
    this.bxI = paramViewGroup.getScaledMinimumFlingVelocity();
    this.mri = i.a(paramContext, sInterpolator);
    AppMethodBeat.o(140898);
  }
  
  private void B(View paramView, int paramInt)
  {
    AppMethodBeat.i(140899);
    if (paramView.getParent() != this.bxO)
    {
      paramView = new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.bxO + ")");
      AppMethodBeat.o(140899);
      throw paramView;
    }
    this.bxM = paramView;
    this.mActivePointerId = paramInt;
    eM(1);
    AppMethodBeat.o(140899);
  }
  
  private void Fy()
  {
    AppMethodBeat.i(140918);
    this.mVelocityTracker.computeCurrentVelocity(1000, this.bxH);
    N(i(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.bxI, this.bxH), i(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.bxI, this.bxH));
    AppMethodBeat.o(140918);
  }
  
  private void N(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(140905);
    this.bxN = true;
    this.ajFp.b(this.bxM, paramFloat1, paramFloat2);
    this.bxN = false;
    if (this.bxy == 1) {
      eM(0);
    }
    AppMethodBeat.o(140905);
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
    if (((this.ajFo[paramInt1] & paramInt2) != paramInt2) || ((this.bxK & paramInt2) == 0) || ((this.bxF[paramInt1] & paramInt2) == paramInt2) || ((this.bxE[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= this.mTouchSlop) && (paramFloat2 <= this.mTouchSlop)))
    {
      AppMethodBeat.o(140914);
      return false;
    }
    if (((this.bxE[paramInt1] & paramInt2) == 0) && (paramFloat1 > this.mTouchSlop))
    {
      AppMethodBeat.o(140914);
      return true;
    }
    AppMethodBeat.o(140914);
    return false;
  }
  
  private boolean aE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140920);
    boolean bool = g(this.bxM, paramInt1, paramInt2);
    AppMethodBeat.o(140920);
    return bool;
  }
  
  private void aXq()
  {
    AppMethodBeat.i(140906);
    if (this.bxz == null)
    {
      AppMethodBeat.o(140906);
      return;
    }
    Arrays.fill(this.bxz, 0.0F);
    Arrays.fill(this.bxA, 0.0F);
    Arrays.fill(this.bxB, 0.0F);
    Arrays.fill(this.bxC, 0.0F);
    Arrays.fill(this.ajFo, 0);
    Arrays.fill(this.bxE, 0);
    Arrays.fill(this.bxF, 0);
    this.bxG = 0;
    AppMethodBeat.o(140906);
  }
  
  private static float distanceInfluenceForSnapDuration(float paramFloat)
  {
    AppMethodBeat.i(140904);
    paramFloat = (float)Math.sin((float)((paramFloat - 0.5F) * 0.47123891676382D));
    AppMethodBeat.o(140904);
    return paramFloat;
  }
  
  private boolean eL(int paramInt)
  {
    return (this.bxG & 1 << paramInt) != 0;
  }
  
  private static boolean g(View paramView, int paramInt1, int paramInt2)
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
  
  private static float i(float paramFloat1, float paramFloat2, float paramFloat3)
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
  
  private void q(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(140919);
    int i = this.bxM.getLeft();
    int j = this.bxM.getTop();
    if (paramInt3 != 0)
    {
      paramInt1 = this.ajFp.d(this.bxM, paramInt1);
      this.bxM.offsetLeftAndRight(paramInt1 - i);
    }
    for (;;)
    {
      if (paramInt4 != 0)
      {
        paramInt2 = this.ajFp.c(this.bxM, paramInt2);
        this.bxM.offsetTopAndBottom(paramInt2 - j);
      }
      for (;;)
      {
        if ((paramInt3 != 0) || (paramInt4 != 0)) {
          this.ajFp.m(this.bxM, paramInt1, paramInt2, paramInt1 - i, paramInt2 - j);
        }
        AppMethodBeat.o(140919);
        return;
      }
    }
  }
  
  private int qB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140923);
    int i = 0;
    if (paramInt1 < this.bxO.getLeft() + this.bxJ) {
      i = 1;
    }
    if (paramInt2 < this.bxO.getTop() + this.bxJ) {
      i = 4;
    }
    if (paramInt1 > this.bxO.getRight() - this.bxJ) {
      i = 2;
    }
    if (paramInt2 > this.bxO.getBottom() - this.bxJ) {
      i = 8;
    }
    AppMethodBeat.o(140923);
    return i;
  }
  
  private void rU(int paramInt)
  {
    AppMethodBeat.i(140907);
    if ((this.bxz == null) || (this.bxz.length <= paramInt))
    {
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      float[] arrayOfFloat4 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.bxz != null)
      {
        System.arraycopy(this.bxz, 0, arrayOfFloat1, 0, this.bxz.length);
        System.arraycopy(this.bxA, 0, arrayOfFloat2, 0, this.bxA.length);
        System.arraycopy(this.bxB, 0, arrayOfFloat3, 0, this.bxB.length);
        System.arraycopy(this.bxC, 0, arrayOfFloat4, 0, this.bxC.length);
        System.arraycopy(this.ajFo, 0, arrayOfInt1, 0, this.ajFo.length);
        System.arraycopy(this.bxE, 0, arrayOfInt2, 0, this.bxE.length);
        System.arraycopy(this.bxF, 0, arrayOfInt3, 0, this.bxF.length);
      }
      this.bxz = arrayOfFloat1;
      this.bxA = arrayOfFloat2;
      this.bxB = arrayOfFloat3;
      this.bxC = arrayOfFloat4;
      this.ajFo = arrayOfInt1;
      this.bxE = arrayOfInt2;
      this.bxF = arrayOfInt3;
    }
    AppMethodBeat.o(140907);
  }
  
  static int t(int paramInt1, int paramInt2, int paramInt3)
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
  
  final boolean C(View paramView, int paramInt)
  {
    AppMethodBeat.i(140911);
    if ((paramView == this.bxM) && (this.mActivePointerId == paramInt))
    {
      AppMethodBeat.o(140911);
      return true;
    }
    if ((paramView != null) && (this.ajFp.rT(paramInt)))
    {
      this.mActivePointerId = paramInt;
      B(paramView, paramInt);
      AppMethodBeat.o(140911);
      return true;
    }
    AppMethodBeat.o(140911);
    return false;
  }
  
  final void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(140908);
    rU(paramInt);
    float[] arrayOfFloat = this.bxz;
    this.bxB[paramInt] = paramFloat1;
    arrayOfFloat[paramInt] = paramFloat1;
    arrayOfFloat = this.bxA;
    this.bxC[paramInt] = paramFloat2;
    arrayOfFloat[paramInt] = paramFloat2;
    this.ajFo[paramInt] = qB((int)paramFloat1, (int)paramFloat2);
    this.bxG |= 1 << paramInt;
    AppMethodBeat.o(140908);
  }
  
  public final View aF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140922);
    int i = this.bxO.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.bxO.getChildAt(i);
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
        int[] arrayOfInt = this.bxE;
        arrayOfInt[paramInt] = (i | arrayOfInt[paramInt]);
      }
      AppMethodBeat.o(140913);
      return;
      j = 0;
    }
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
    if (this.ajFp.aXi() > 0)
    {
      i = 1;
      if (this.ajFp.aM() <= 0) {
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
    aXq();
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
    AppMethodBeat.o(140900);
  }
  
  final void eK(int paramInt)
  {
    if (this.bxz == null) {
      return;
    }
    this.bxz[paramInt] = 0.0F;
    this.bxA[paramInt] = 0.0F;
    this.bxB[paramInt] = 0.0F;
    this.bxC[paramInt] = 0.0F;
    this.ajFo[paramInt] = 0;
    this.bxE[paramInt] = 0;
    this.bxF[paramInt] = 0;
    this.bxG &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  final void eM(int paramInt)
  {
    AppMethodBeat.i(140910);
    if (this.bxy != paramInt)
    {
      this.bxy = paramInt;
      this.ajFp.F(paramInt);
      if (paramInt == 0) {
        this.bxM = null;
      }
    }
    AppMethodBeat.o(140910);
  }
  
  final void h(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(140909);
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    while (i < j)
    {
      int k = paramMotionEvent.getPointerId(i);
      float f1 = paramMotionEvent.getX(i);
      float f2 = paramMotionEvent.getY(i);
      this.bxB[k] = f1;
      this.bxC[k] = f2;
      i += 1;
    }
    AppMethodBeat.o(140909);
  }
  
  public final void j(MotionEvent paramMotionEvent)
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
          paramMotionEvent = aF((int)f1, (int)f2);
          a(f1, f2, i);
          C(paramMotionEvent, i);
        } while ((this.ajFo[i] & this.bxK) == 0);
        AppMethodBeat.o(140912);
        return;
        i = paramMotionEvent.getPointerId(k);
        f1 = paramMotionEvent.getX(k);
        f2 = paramMotionEvent.getY(k);
        a(f1, f2, i);
        if (this.bxy == 0)
        {
          C(aF((int)f1, (int)f2), i);
          AppMethodBeat.o(140912);
          return;
        }
      } while (!aE((int)f1, (int)f2));
      C(this.bxM, i);
      AppMethodBeat.o(140912);
      return;
    case 2: 
      if (this.bxy == 1)
      {
        i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        i = (int)(f1 - this.bxB[this.mActivePointerId]);
        j = (int)(f2 - this.bxC[this.mActivePointerId]);
        q(this.bxM.getLeft() + i, this.bxM.getTop() + j, i, j);
        h(paramMotionEvent);
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
        float f3 = f1 - this.bxz[j];
        float f4 = f2 - this.bxA[j];
        b(f3, f4, j);
        if (this.bxy == 1) {
          break;
        }
        View localView = aF((int)f1, (int)f2);
        if ((c(localView, f3, f4)) && (C(localView, j))) {
          break;
        }
        i += 1;
      }
      h(paramMotionEvent);
      AppMethodBeat.o(140912);
      return;
    case 6: 
      j = paramMotionEvent.getPointerId(k);
      if ((this.bxy == 1) && (j == this.mActivePointerId))
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
        if ((aF((int)f1, (int)f2) != this.bxM) || (!C(this.bxM, m))) {
          break label619;
        }
      }
      break;
    }
    label672:
    for (i = this.mActivePointerId;; i = -1)
    {
      if (i == -1) {
        Fy();
      }
      eK(j);
      AppMethodBeat.o(140912);
      return;
      label619:
      i += 1;
      break label524;
      if (this.bxy == 1) {
        Fy();
      }
      cancel();
      AppMethodBeat.o(140912);
      return;
      if (this.bxy == 1) {
        N(0.0F, 0.0F);
      }
      cancel();
      break;
    }
  }
  
  public final boolean jU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140916);
    if (!eL(paramInt2))
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
      f1 = this.bxB[paramInt2] - this.bxz[paramInt2];
      f2 = this.bxC[paramInt2] - this.bxA[paramInt2];
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
  
  public final boolean qA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140917);
    if ((eL(paramInt2)) && ((this.ajFo[paramInt2] & paramInt1) != 0))
    {
      AppMethodBeat.o(140917);
      return true;
    }
    AppMethodBeat.o(140917);
    return false;
  }
  
  final int s(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(140901);
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(140901);
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
      paramInt1 = Math.min(paramInt1, 600);
      AppMethodBeat.o(140901);
      return paramInt1;
    }
  }
  
  public static abstract class a
  {
    public void F(int paramInt) {}
    
    public int aM()
    {
      return 0;
    }
    
    public int aXi()
    {
      return 0;
    }
    
    public void b(View paramView, float paramFloat1, float paramFloat2) {}
    
    public int c(View paramView, int paramInt)
    {
      return 0;
    }
    
    public int d(View paramView, int paramInt)
    {
      return 0;
    }
    
    public void m(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    public abstract boolean rT(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     me.imid.swipebacklayout.lib.b
 * JD-Core Version:    0.7.0.1
 */