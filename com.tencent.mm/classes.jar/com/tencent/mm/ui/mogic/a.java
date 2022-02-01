package com.tencent.mm.ui.mogic;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.widget.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;

public final class a
{
  private static final Interpolator sInterpolator;
  public final a afAl;
  public float[] bxA;
  public float[] bxB;
  public float[] bxC;
  public int[] bxD;
  private int[] bxE;
  private int[] bxF;
  public int bxG;
  public float bxH;
  public float bxI;
  private int bxJ;
  public int bxK;
  public View bxM;
  public boolean bxN;
  public final ViewGroup bxO;
  public final Runnable bxP;
  public int bxy;
  public float[] bxz;
  public int mActivePointerId;
  private int mTouchSlop;
  public VelocityTracker mVelocityTracker;
  public i mri;
  
  static
  {
    AppMethodBeat.i(142886);
    sInterpolator = new a.1();
    AppMethodBeat.o(142886);
  }
  
  private a(Context paramContext, ViewGroup paramViewGroup, a parama, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(142868);
    this.mActivePointerId = -1;
    this.bxP = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142866);
        a.this.eM(0);
        AppMethodBeat.o(142866);
      }
    };
    if (paramViewGroup == null)
    {
      paramContext = new IllegalArgumentException("Parent view may not be null");
      AppMethodBeat.o(142868);
      throw paramContext;
    }
    if (parama == null)
    {
      paramContext = new IllegalArgumentException("Callback may not be null");
      AppMethodBeat.o(142868);
      throw paramContext;
    }
    this.bxO = paramViewGroup;
    this.afAl = parama;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.bxJ = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.mTouchSlop = paramViewGroup.getScaledTouchSlop();
    this.bxH = paramViewGroup.getScaledMaximumFlingVelocity();
    this.bxI = paramViewGroup.getScaledMinimumFlingVelocity();
    this.mri = i.a(paramContext, paramInterpolator);
    AppMethodBeat.o(142868);
  }
  
  private int R(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142871);
    paramInt3 = t(paramInt3, (int)this.bxI, (int)this.bxH);
    paramInt4 = t(paramInt4, (int)this.bxI, (int)this.bxH);
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
        break label162;
      }
    }
    label162:
    for (float f2 = m / n;; f2 = j / i1)
    {
      paramInt1 = s(paramInt1, paramInt3, this.afAl.aXi());
      paramInt2 = s(paramInt2, paramInt4, 0);
      float f3 = paramInt1;
      paramInt1 = (int)(f2 * paramInt2 + f1 * f3);
      AppMethodBeat.o(142871);
      return paramInt1;
      f1 = i / i1;
      break;
    }
  }
  
  public static a a(ViewGroup paramViewGroup, a parama, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(142867);
    paramViewGroup = new a(paramViewGroup.getContext(), paramViewGroup, parama, paramInterpolator);
    AppMethodBeat.o(142867);
    return paramViewGroup;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142882);
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    if (((this.bxD[paramInt1] & paramInt2) != paramInt2) || ((this.bxK & paramInt2) == 0) || ((this.bxF[paramInt1] & paramInt2) == paramInt2) || ((this.bxE[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= this.mTouchSlop) && (paramFloat2 <= this.mTouchSlop)))
    {
      AppMethodBeat.o(142882);
      return false;
    }
    if (((this.bxE[paramInt1] & paramInt2) == 0) && (paramFloat1 > this.mTouchSlop))
    {
      AppMethodBeat.o(142882);
      return true;
    }
    AppMethodBeat.o(142882);
    return false;
  }
  
  private static float distanceInfluenceForSnapDuration(float paramFloat)
  {
    AppMethodBeat.i(142875);
    paramFloat = (float)Math.sin((float)((paramFloat - 0.5F) * 0.47123891676382D));
    AppMethodBeat.o(142875);
    return paramFloat;
  }
  
  private static float i(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(142874);
    float f = Math.abs(paramFloat1);
    if (f < paramFloat2)
    {
      AppMethodBeat.o(142874);
      return 0.0F;
    }
    if (f > paramFloat3)
    {
      if (paramFloat1 > 0.0F)
      {
        AppMethodBeat.o(142874);
        return paramFloat3;
      }
      paramFloat1 = -paramFloat3;
      AppMethodBeat.o(142874);
      return paramFloat1;
    }
    AppMethodBeat.o(142874);
    return paramFloat1;
  }
  
  private int s(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(142872);
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(142872);
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
      AppMethodBeat.o(142872);
      return paramInt1;
    }
  }
  
  private static int t(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(142873);
    int i = Math.abs(paramInt1);
    if (i < paramInt2)
    {
      AppMethodBeat.o(142873);
      return 0;
    }
    if (i > paramInt3)
    {
      if (paramInt1 > 0)
      {
        AppMethodBeat.o(142873);
        return paramInt3;
      }
      paramInt1 = -paramInt3;
      AppMethodBeat.o(142873);
      return paramInt1;
    }
    AppMethodBeat.o(142873);
    return paramInt1;
  }
  
  public final boolean C(View paramView, int paramInt)
  {
    AppMethodBeat.i(142880);
    if ((paramView == this.bxM) && (this.mActivePointerId == paramInt))
    {
      AppMethodBeat.o(142880);
      return true;
    }
    if ((paramView != null) && (this.afAl.rT(paramInt)))
    {
      this.mActivePointerId = paramInt;
      if (paramView.getParent() != this.bxO)
      {
        paramView = new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.bxO + ")");
        AppMethodBeat.o(142880);
        throw paramView;
      }
      this.bxM = paramView;
      this.mActivePointerId = paramInt;
      eM(1);
      AppMethodBeat.o(142880);
      return true;
    }
    AppMethodBeat.o(142880);
    return false;
  }
  
  public final void Fy()
  {
    AppMethodBeat.i(142884);
    this.mVelocityTracker.computeCurrentVelocity(1000, this.bxH);
    N(i(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.bxI, this.bxH), i(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.bxI, this.bxH));
    AppMethodBeat.o(142884);
  }
  
  public final void N(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142876);
    this.bxN = true;
    this.afAl.b(this.bxM, paramFloat1, paramFloat2);
    this.bxN = false;
    if (this.bxy == 1) {
      eM(0);
    }
    AppMethodBeat.o(142876);
  }
  
  public final void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(142877);
    if ((this.bxz == null) || (this.bxz.length <= paramInt))
    {
      localObject = new float[paramInt + 1];
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.bxz != null)
      {
        System.arraycopy(this.bxz, 0, localObject, 0, this.bxz.length);
        System.arraycopy(this.bxA, 0, arrayOfFloat1, 0, this.bxA.length);
        System.arraycopy(this.bxB, 0, arrayOfFloat2, 0, this.bxB.length);
        System.arraycopy(this.bxC, 0, arrayOfFloat3, 0, this.bxC.length);
        System.arraycopy(this.bxD, 0, arrayOfInt1, 0, this.bxD.length);
        System.arraycopy(this.bxE, 0, arrayOfInt2, 0, this.bxE.length);
        System.arraycopy(this.bxF, 0, arrayOfInt3, 0, this.bxF.length);
      }
      this.bxz = ((float[])localObject);
      this.bxA = arrayOfFloat1;
      this.bxB = arrayOfFloat2;
      this.bxC = arrayOfFloat3;
      this.bxD = arrayOfInt1;
      this.bxE = arrayOfInt2;
      this.bxF = arrayOfInt3;
    }
    Object localObject = this.bxz;
    this.bxB[paramInt] = paramFloat1;
    localObject[paramInt] = paramFloat1;
    localObject = this.bxA;
    this.bxC[paramInt] = paramFloat2;
    localObject[paramInt] = paramFloat2;
    localObject = this.bxD;
    int m = (int)paramFloat1;
    int k = (int)paramFloat2;
    if (m < this.bxO.getLeft() + this.bxJ) {
      j = 1;
    }
    int i = j;
    if (k < this.bxO.getTop() + this.bxJ) {
      i = j | 0x4;
    }
    j = i;
    if (m > this.bxO.getRight() - this.bxJ) {
      j = i | 0x2;
    }
    i = j;
    if (k > this.bxO.getBottom() - this.bxJ) {
      i = j | 0x8;
    }
    localObject[paramInt] = i;
    this.bxG |= 1 << paramInt;
    AppMethodBeat.o(142877);
  }
  
  public final View aF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142885);
    int i = this.bxO.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.bxO.getChildAt(i);
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom()))
      {
        AppMethodBeat.o(142885);
        return localView;
      }
      i -= 1;
    }
    AppMethodBeat.o(142885);
    return null;
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(142881);
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
        arrayOfInt[paramInt] |= i;
        this.afAl.aG(i, paramInt);
      }
      AppMethodBeat.o(142881);
      return;
      j = 0;
    }
  }
  
  public final boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    AppMethodBeat.i(142870);
    int i = this.bxM.getLeft();
    int j = this.bxM.getTop();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.mri.bwz.abortAnimation();
      eM(0);
      AppMethodBeat.o(142870);
      return false;
    }
    long l = paramLong;
    if (paramLong == 0L) {
      l = R(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    Log.d("WxViewDragHelper", "ashutest:: xvel %d, yvel %d, dx %d, dy %d duration %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l) });
    this.mri.startScroll(i, j, paramInt1, paramInt2, (int)l);
    eM(2);
    AppMethodBeat.o(142870);
    return true;
  }
  
  public final boolean b(View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(249678);
    this.bxM = paramView;
    this.mActivePointerId = -1;
    boolean bool = b(paramInt, 0, 0, 0, paramLong);
    AppMethodBeat.o(249678);
    return bool;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(142869);
    this.mActivePointerId = -1;
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
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
    AppMethodBeat.o(142869);
  }
  
  public final void eK(int paramInt)
  {
    if (this.bxz == null) {
      return;
    }
    this.bxz[paramInt] = 0.0F;
    this.bxA[paramInt] = 0.0F;
    this.bxB[paramInt] = 0.0F;
    this.bxC[paramInt] = 0.0F;
    this.bxD[paramInt] = 0;
    this.bxE[paramInt] = 0;
    this.bxF[paramInt] = 0;
    this.bxG &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  final void eM(int paramInt)
  {
    AppMethodBeat.i(142879);
    if (this.bxy != paramInt)
    {
      this.bxy = paramInt;
      this.afAl.F(paramInt);
      if (paramInt == 0) {
        this.bxM = null;
      }
    }
    AppMethodBeat.o(142879);
  }
  
  public final void h(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(142878);
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
    AppMethodBeat.o(142878);
  }
  
  public final boolean s(View paramView, float paramFloat)
  {
    AppMethodBeat.i(142883);
    if (paramView == null)
    {
      AppMethodBeat.o(142883);
      return false;
    }
    int i;
    if (this.afAl.aXi() > 0) {
      i = 1;
    }
    while (i != 0) {
      if (Math.abs(paramFloat) > this.mTouchSlop)
      {
        AppMethodBeat.o(142883);
        return true;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(142883);
        return false;
      }
    }
    AppMethodBeat.o(142883);
    return false;
  }
  
  public static abstract class a
  {
    public void F(int paramInt) {}
    
    public void aG(int paramInt1, int paramInt2) {}
    
    public int aXi()
    {
      return 0;
    }
    
    public void b(View paramView, float paramFloat1, float paramFloat2) {}
    
    public int d(View paramView, int paramInt)
    {
      return 0;
    }
    
    public void dS(int paramInt1, int paramInt2) {}
    
    public abstract boolean rT(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.mogic.a
 * JD-Core Version:    0.7.0.1
 */