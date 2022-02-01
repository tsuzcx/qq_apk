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
import androidx.core.widget.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;

public final class a
{
  private static final Interpolator sInterpolator;
  public int Rh;
  public float[] Ri;
  public float[] Rj;
  public float[] Rk;
  public float[] Rl;
  public int[] Rm;
  private int[] Rn;
  private int[] Ro;
  public int Rp;
  public float Rq;
  public float Rr;
  private int Rs;
  public int Rt;
  public View Rv;
  public boolean Rw;
  public final ViewGroup Rx;
  public final Runnable Ry;
  public final a XLw;
  public h jRY;
  public int mActivePointerId;
  private int mTouchSlop;
  public VelocityTracker mVelocityTracker;
  
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
    this.Ry = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142866);
        a.this.bR(0);
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
    this.Rx = paramViewGroup;
    this.XLw = parama;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.Rs = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.mTouchSlop = paramViewGroup.getScaledTouchSlop();
    this.Rq = paramViewGroup.getScaledMaximumFlingVelocity();
    this.Rr = paramViewGroup.getScaledMinimumFlingVelocity();
    this.jRY = h.a(paramContext, paramInterpolator);
    AppMethodBeat.o(142868);
  }
  
  private int M(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142871);
    paramInt3 = f(paramInt3, (int)this.Rr, (int)this.Rq);
    paramInt4 = f(paramInt4, (int)this.Rr, (int)this.Rq);
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
      paramInt1 = e(paramInt1, paramInt3, this.XLw.aEe());
      paramInt2 = e(paramInt2, paramInt4, 0);
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
    if (((this.Rm[paramInt1] & paramInt2) != paramInt2) || ((this.Rt & paramInt2) == 0) || ((this.Ro[paramInt1] & paramInt2) == paramInt2) || ((this.Rn[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= this.mTouchSlop) && (paramFloat2 <= this.mTouchSlop)))
    {
      AppMethodBeat.o(142882);
      return false;
    }
    if (((this.Rn[paramInt1] & paramInt2) == 0) && (paramFloat1 > this.mTouchSlop))
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
  
  private static float e(float paramFloat1, float paramFloat2, float paramFloat3)
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
  
  private int e(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(142872);
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(142872);
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
      paramInt1 = Math.min(paramInt1, 600);
      AppMethodBeat.o(142872);
      return paramInt1;
    }
  }
  
  private static int f(int paramInt1, int paramInt2, int paramInt3)
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
  
  public final View K(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142885);
    int i = this.Rx.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.Rx.getChildAt(i);
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
    if ((this.Ri == null) || (this.Ri.length <= paramInt))
    {
      localObject = new float[paramInt + 1];
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.Ri != null)
      {
        System.arraycopy(this.Ri, 0, localObject, 0, this.Ri.length);
        System.arraycopy(this.Rj, 0, arrayOfFloat1, 0, this.Rj.length);
        System.arraycopy(this.Rk, 0, arrayOfFloat2, 0, this.Rk.length);
        System.arraycopy(this.Rl, 0, arrayOfFloat3, 0, this.Rl.length);
        System.arraycopy(this.Rm, 0, arrayOfInt1, 0, this.Rm.length);
        System.arraycopy(this.Rn, 0, arrayOfInt2, 0, this.Rn.length);
        System.arraycopy(this.Ro, 0, arrayOfInt3, 0, this.Ro.length);
      }
      this.Ri = ((float[])localObject);
      this.Rj = arrayOfFloat1;
      this.Rk = arrayOfFloat2;
      this.Rl = arrayOfFloat3;
      this.Rm = arrayOfInt1;
      this.Rn = arrayOfInt2;
      this.Ro = arrayOfInt3;
    }
    Object localObject = this.Ri;
    this.Rk[paramInt] = paramFloat1;
    localObject[paramInt] = paramFloat1;
    localObject = this.Rj;
    this.Rl[paramInt] = paramFloat2;
    localObject[paramInt] = paramFloat2;
    localObject = this.Rm;
    int m = (int)paramFloat1;
    int k = (int)paramFloat2;
    if (m < this.Rx.getLeft() + this.Rs) {
      j = 1;
    }
    int i = j;
    if (k < this.Rx.getTop() + this.Rs) {
      i = j | 0x4;
    }
    j = i;
    if (m > this.Rx.getRight() - this.Rs) {
      j = i | 0x2;
    }
    i = j;
    if (k > this.Rx.getBottom() - this.Rs) {
      i = j | 0x8;
    }
    localObject[paramInt] = i;
    this.Rp |= 1 << paramInt;
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
        int[] arrayOfInt = this.Rn;
        arrayOfInt[paramInt] |= i;
        this.XLw.XV(i);
      }
      AppMethodBeat.o(142881);
      return;
      j = 0;
    }
  }
  
  public final boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    AppMethodBeat.i(142870);
    int i = this.Rv.getLeft();
    int j = this.Rv.getTop();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.jRY.Qi.abortAnimation();
      bR(0);
      AppMethodBeat.o(142870);
      return false;
    }
    long l = paramLong;
    if (paramLong == 0L) {
      l = M(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    Log.d("WxViewDragHelper", "ashutest:: xvel %d, yvel %d, dx %d, dy %d duration %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l) });
    this.jRY.startScroll(i, j, paramInt1, paramInt2, (int)l);
    bR(2);
    AppMethodBeat.o(142870);
    return true;
  }
  
  public final boolean b(View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(200902);
    this.Rv = paramView;
    this.mActivePointerId = -1;
    boolean bool = b(paramInt, 0, 0, 0, paramLong);
    AppMethodBeat.o(200902);
    return bool;
  }
  
  public final void bP(int paramInt)
  {
    if (this.Ri == null) {
      return;
    }
    this.Ri[paramInt] = 0.0F;
    this.Rj[paramInt] = 0.0F;
    this.Rk[paramInt] = 0.0F;
    this.Rl[paramInt] = 0.0F;
    this.Rm[paramInt] = 0;
    this.Rn[paramInt] = 0;
    this.Ro[paramInt] = 0;
    this.Rp &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  final void bR(int paramInt)
  {
    AppMethodBeat.i(142879);
    if (this.Rh != paramInt)
    {
      this.Rh = paramInt;
      this.XLw.G(paramInt);
      if (paramInt == 0) {
        this.Rv = null;
      }
    }
    AppMethodBeat.o(142879);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(142869);
    this.mActivePointerId = -1;
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
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
    AppMethodBeat.o(142869);
  }
  
  public final void e(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142876);
    this.Rw = true;
    this.XLw.a(this.Rv, paramFloat1, paramFloat2);
    this.Rw = false;
    if (this.Rh == 1) {
      bR(0);
    }
    AppMethodBeat.o(142876);
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
      this.Rk[k] = f1;
      this.Rl[k] = f2;
      i += 1;
    }
    AppMethodBeat.o(142878);
  }
  
  public final void hN()
  {
    AppMethodBeat.i(142884);
    this.mVelocityTracker.computeCurrentVelocity(1000, this.Rq);
    e(e(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.Rr, this.Rq), e(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.Rr, this.Rq));
    AppMethodBeat.o(142884);
  }
  
  public final boolean r(View paramView, float paramFloat)
  {
    AppMethodBeat.i(142883);
    if (paramView == null)
    {
      AppMethodBeat.o(142883);
      return false;
    }
    int i;
    if (this.XLw.aEe() > 0) {
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
  
  public final boolean y(View paramView, int paramInt)
  {
    AppMethodBeat.i(142880);
    if ((paramView == this.Rv) && (this.mActivePointerId == paramInt))
    {
      AppMethodBeat.o(142880);
      return true;
    }
    if ((paramView != null) && (this.XLw.rS(paramInt)))
    {
      this.mActivePointerId = paramInt;
      if (paramView.getParent() != this.Rx)
      {
        paramView = new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.Rx + ")");
        AppMethodBeat.o(142880);
        throw paramView;
      }
      this.Rv = paramView;
      this.mActivePointerId = paramInt;
      bR(1);
      AppMethodBeat.o(142880);
      return true;
    }
    AppMethodBeat.o(142880);
    return false;
  }
  
  public static abstract class a
  {
    public void G(int paramInt) {}
    
    public void XV(int paramInt) {}
    
    public void a(View paramView, float paramFloat1, float paramFloat2) {}
    
    public int aEe()
    {
      return 0;
    }
    
    public int d(View paramView, int paramInt)
    {
      return 0;
    }
    
    public void df(int paramInt1, int paramInt2) {}
    
    public abstract boolean rS(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.mogic.a
 * JD-Core Version:    0.7.0.1
 */