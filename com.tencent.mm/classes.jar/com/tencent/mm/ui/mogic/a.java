package com.tencent.mm.ui.mogic;

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
import android.widget.OverScroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Arrays;

public final class a
{
  private static final Interpolator sInterpolator;
  public final a ILc;
  private int[] UA;
  private int[] UB;
  public int UC;
  public float UD;
  public float UE;
  private int UF;
  public int UG;
  public View UI;
  public boolean UJ;
  public final ViewGroup UK;
  public final Runnable UL;
  public int Uu;
  public float[] Uv;
  public float[] Uw;
  public float[] Ux;
  public float[] Uy;
  public int[] Uz;
  public int mActivePointerId;
  public p mLD;
  private int mTouchSlop;
  public VelocityTracker mVelocityTracker;
  
  static
  {
    AppMethodBeat.i(142886);
    sInterpolator = new Interpolator()
    {
      public final float getInterpolation(float paramAnonymousFloat)
      {
        paramAnonymousFloat -= 1.0F;
        return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
      }
    };
    AppMethodBeat.o(142886);
  }
  
  private a(Context paramContext, ViewGroup paramViewGroup, a parama, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(142868);
    this.mActivePointerId = -1;
    this.UL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142866);
        a.this.be(0);
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
    this.UK = paramViewGroup;
    this.ILc = parama;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.UF = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.mTouchSlop = paramViewGroup.getScaledTouchSlop();
    this.UD = paramViewGroup.getScaledMaximumFlingVelocity();
    this.UE = paramViewGroup.getScaledMinimumFlingVelocity();
    this.mLD = p.a(paramContext, paramInterpolator);
    AppMethodBeat.o(142868);
  }
  
  private int Q(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142871);
    paramInt3 = i(paramInt3, (int)this.UE, (int)this.UD);
    paramInt4 = i(paramInt4, (int)this.UE, (int)this.UD);
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
      paramInt1 = h(paramInt1, paramInt3, this.ILc.ftc());
      paramInt2 = h(paramInt2, paramInt4, 0);
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
    if (((this.Uz[paramInt1] & paramInt2) != paramInt2) || ((this.UG & paramInt2) == 0) || ((this.UB[paramInt1] & paramInt2) == paramInt2) || ((this.UA[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= this.mTouchSlop) && (paramFloat2 <= this.mTouchSlop)))
    {
      AppMethodBeat.o(142882);
      return false;
    }
    if (((this.UA[paramInt1] & paramInt2) == 0) && (paramFloat1 > this.mTouchSlop))
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
  
  private static float f(float paramFloat1, float paramFloat2, float paramFloat3)
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
  
  private int h(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(142872);
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(142872);
      return 0;
    }
    int i = this.UK.getWidth();
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
  
  private static int i(int paramInt1, int paramInt2, int paramInt3)
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
  
  public final View C(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142885);
    int i = this.UK.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.UK.getChildAt(i);
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
  
  public final void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(142877);
    if ((this.Uv == null) || (this.Uv.length <= paramInt))
    {
      localObject = new float[paramInt + 1];
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.Uv != null)
      {
        System.arraycopy(this.Uv, 0, localObject, 0, this.Uv.length);
        System.arraycopy(this.Uw, 0, arrayOfFloat1, 0, this.Uw.length);
        System.arraycopy(this.Ux, 0, arrayOfFloat2, 0, this.Ux.length);
        System.arraycopy(this.Uy, 0, arrayOfFloat3, 0, this.Uy.length);
        System.arraycopy(this.Uz, 0, arrayOfInt1, 0, this.Uz.length);
        System.arraycopy(this.UA, 0, arrayOfInt2, 0, this.UA.length);
        System.arraycopy(this.UB, 0, arrayOfInt3, 0, this.UB.length);
      }
      this.Uv = ((float[])localObject);
      this.Uw = arrayOfFloat1;
      this.Ux = arrayOfFloat2;
      this.Uy = arrayOfFloat3;
      this.Uz = arrayOfInt1;
      this.UA = arrayOfInt2;
      this.UB = arrayOfInt3;
    }
    Object localObject = this.Uv;
    this.Ux[paramInt] = paramFloat1;
    localObject[paramInt] = paramFloat1;
    localObject = this.Uw;
    this.Uy[paramInt] = paramFloat2;
    localObject[paramInt] = paramFloat2;
    localObject = this.Uz;
    int m = (int)paramFloat1;
    int k = (int)paramFloat2;
    if (m < this.UK.getLeft() + this.UF) {
      j = 1;
    }
    int i = j;
    if (k < this.UK.getTop() + this.UF) {
      i = j | 0x4;
    }
    j = i;
    if (m > this.UK.getRight() - this.UF) {
      j = i | 0x2;
    }
    i = j;
    if (k > this.UK.getBottom() - this.UF) {
      i = j | 0x8;
    }
    localObject[paramInt] = i;
    this.UC |= 1 << paramInt;
    AppMethodBeat.o(142877);
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
        int[] arrayOfInt = this.UA;
        arrayOfInt[paramInt] = (i | arrayOfInt[paramInt]);
      }
      AppMethodBeat.o(142881);
      return;
      j = 0;
    }
  }
  
  public final boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    AppMethodBeat.i(142870);
    int i = this.UI.getLeft();
    int j = this.UI.getTop();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.mLD.SC.abortAnimation();
      be(0);
      AppMethodBeat.o(142870);
      return false;
    }
    long l = paramLong;
    if (paramLong == 0L) {
      l = Q(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    ac.d("WxViewDragHelper", "ashutest:: xvel %d, yvel %d, dx %d, dy %d duration %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l) });
    this.mLD.startScroll(i, j, paramInt1, paramInt2, (int)l);
    be(2);
    AppMethodBeat.o(142870);
    return true;
  }
  
  public final void bc(int paramInt)
  {
    if (this.Uv == null) {
      return;
    }
    this.Uv[paramInt] = 0.0F;
    this.Uw[paramInt] = 0.0F;
    this.Ux[paramInt] = 0.0F;
    this.Uy[paramInt] = 0.0F;
    this.Uz[paramInt] = 0;
    this.UA[paramInt] = 0;
    this.UB[paramInt] = 0;
    this.UC &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  final void be(int paramInt)
  {
    AppMethodBeat.i(142879);
    if (this.Uu != paramInt)
    {
      this.Uu = paramInt;
      this.ILc.M(paramInt);
      if (paramInt == 0) {
        this.UI = null;
      }
    }
    AppMethodBeat.o(142879);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(142869);
    this.mActivePointerId = -1;
    if (this.Uv != null)
    {
      Arrays.fill(this.Uv, 0.0F);
      Arrays.fill(this.Uw, 0.0F);
      Arrays.fill(this.Ux, 0.0F);
      Arrays.fill(this.Uy, 0.0F);
      Arrays.fill(this.Uz, 0);
      Arrays.fill(this.UA, 0);
      Arrays.fill(this.UB, 0);
      this.UC = 0;
    }
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
    AppMethodBeat.o(142869);
  }
  
  public final void f(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(142878);
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    while (i < j)
    {
      int k = paramMotionEvent.getPointerId(i);
      float f1 = paramMotionEvent.getX(i);
      float f2 = paramMotionEvent.getY(i);
      this.Ux[k] = f1;
      this.Uy[k] = f2;
      i += 1;
    }
    AppMethodBeat.o(142878);
  }
  
  public final void fR()
  {
    AppMethodBeat.i(142884);
    this.mVelocityTracker.computeCurrentVelocity(1000, this.UD);
    l(f(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.UE, this.UD), f(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.UE, this.UD));
    AppMethodBeat.o(142884);
  }
  
  public final void l(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142876);
    this.UJ = true;
    this.ILc.a(this.UI, paramFloat1, paramFloat2);
    this.UJ = false;
    if (this.Uu == 1) {
      be(0);
    }
    AppMethodBeat.o(142876);
  }
  
  public final boolean w(View paramView, float paramFloat)
  {
    AppMethodBeat.i(142883);
    if (paramView == null)
    {
      AppMethodBeat.o(142883);
      return false;
    }
    int i;
    if (this.ILc.ftc() > 0) {
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
  
  public final boolean z(View paramView, int paramInt)
  {
    AppMethodBeat.i(142880);
    if ((paramView == this.UI) && (this.mActivePointerId == paramInt))
    {
      AppMethodBeat.o(142880);
      return true;
    }
    if ((paramView != null) && (this.ILc.acs(paramInt)))
    {
      this.mActivePointerId = paramInt;
      if (paramView.getParent() != this.UK)
      {
        paramView = new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.UK + ")");
        AppMethodBeat.o(142880);
        throw paramView;
      }
      this.UI = paramView;
      this.mActivePointerId = paramInt;
      be(1);
      AppMethodBeat.o(142880);
      return true;
    }
    AppMethodBeat.o(142880);
    return false;
  }
  
  public static abstract class a
  {
    public void M(int paramInt) {}
    
    public void a(View paramView, float paramFloat1, float paramFloat2) {}
    
    public abstract boolean acs(int paramInt);
    
    public int e(View paramView, int paramInt)
    {
      return 0;
    }
    
    public int ftc()
    {
      return 0;
    }
    
    public void jK(int paramInt1, int paramInt2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.mogic.a
 * JD-Core Version:    0.7.0.1
 */