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
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Arrays;

public final class a
{
  private static final Interpolator sInterpolator;
  public final a Apv;
  public float[] MA;
  public int[] MC;
  private int[] MD;
  private int[] MF;
  public int MG;
  public float MH;
  public float MI;
  private int MJ;
  public int MK;
  public View MM;
  public boolean MN;
  public final ViewGroup MO;
  public final Runnable MP;
  public int Mw;
  public float[] Mx;
  public float[] My;
  public float[] Mz;
  public p jtz;
  public int mActivePointerId;
  private int mTouchSlop;
  public VelocityTracker mVelocityTracker;
  
  static
  {
    AppMethodBeat.i(107452);
    sInterpolator = new Interpolator()
    {
      public final float getInterpolation(float paramAnonymousFloat)
      {
        paramAnonymousFloat -= 1.0F;
        return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
      }
    };
    AppMethodBeat.o(107452);
  }
  
  private a(Context paramContext, ViewGroup paramViewGroup, a parama, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(107434);
    this.mActivePointerId = -1;
    this.MP = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107432);
        a.this.aL(0);
        AppMethodBeat.o(107432);
      }
    };
    if (paramViewGroup == null)
    {
      paramContext = new IllegalArgumentException("Parent view may not be null");
      AppMethodBeat.o(107434);
      throw paramContext;
    }
    if (parama == null)
    {
      paramContext = new IllegalArgumentException("Callback may not be null");
      AppMethodBeat.o(107434);
      throw paramContext;
    }
    this.MO = paramViewGroup;
    this.Apv = parama;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.MJ = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.mTouchSlop = paramViewGroup.getScaledTouchSlop();
    this.MH = paramViewGroup.getScaledMaximumFlingVelocity();
    this.MI = paramViewGroup.getScaledMinimumFlingVelocity();
    this.jtz = p.a(paramContext, paramInterpolator);
    AppMethodBeat.o(107434);
  }
  
  private int K(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(107437);
    paramInt3 = h(paramInt3, (int)this.MI, (int)this.MH);
    paramInt4 = h(paramInt4, (int)this.MI, (int)this.MH);
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
      paramInt1 = g(paramInt1, paramInt3, this.Apv.dNq());
      paramInt2 = g(paramInt2, paramInt4, 0);
      float f3 = paramInt1;
      paramInt1 = (int)(f2 * paramInt2 + f1 * f3);
      AppMethodBeat.o(107437);
      return paramInt1;
      f1 = i / i1;
      break;
    }
  }
  
  public static a a(ViewGroup paramViewGroup, a parama, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(107433);
    paramViewGroup = new a(paramViewGroup.getContext(), paramViewGroup, parama, paramInterpolator);
    AppMethodBeat.o(107433);
    return paramViewGroup;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107448);
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    if (((this.MC[paramInt1] & paramInt2) != paramInt2) || ((this.MK & paramInt2) == 0) || ((this.MF[paramInt1] & paramInt2) == paramInt2) || ((this.MD[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= this.mTouchSlop) && (paramFloat2 <= this.mTouchSlop)))
    {
      AppMethodBeat.o(107448);
      return false;
    }
    if (((this.MD[paramInt1] & paramInt2) == 0) && (paramFloat1 > this.mTouchSlop))
    {
      AppMethodBeat.o(107448);
      return true;
    }
    AppMethodBeat.o(107448);
    return false;
  }
  
  private static float distanceInfluenceForSnapDuration(float paramFloat)
  {
    AppMethodBeat.i(107441);
    paramFloat = (float)Math.sin((float)((paramFloat - 0.5F) * 0.47123891676382D));
    AppMethodBeat.o(107441);
    return paramFloat;
  }
  
  private static float e(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(107440);
    float f = Math.abs(paramFloat1);
    if (f < paramFloat2)
    {
      AppMethodBeat.o(107440);
      return 0.0F;
    }
    if (f > paramFloat3)
    {
      if (paramFloat1 > 0.0F)
      {
        AppMethodBeat.o(107440);
        return paramFloat3;
      }
      paramFloat1 = -paramFloat3;
      AppMethodBeat.o(107440);
      return paramFloat1;
    }
    AppMethodBeat.o(107440);
    return paramFloat1;
  }
  
  private int g(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(107438);
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(107438);
      return 0;
    }
    int i = this.MO.getWidth();
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
      AppMethodBeat.o(107438);
      return paramInt1;
    }
  }
  
  private static int h(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(107439);
    int i = Math.abs(paramInt1);
    if (i < paramInt2)
    {
      AppMethodBeat.o(107439);
      return 0;
    }
    if (i > paramInt3)
    {
      if (paramInt1 > 0)
      {
        AppMethodBeat.o(107439);
        return paramInt3;
      }
      paramInt1 = -paramInt3;
      AppMethodBeat.o(107439);
      return paramInt1;
    }
    AppMethodBeat.o(107439);
    return paramInt1;
  }
  
  public final View A(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107451);
    int i = this.MO.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.MO.getChildAt(i);
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom()))
      {
        AppMethodBeat.o(107451);
        return localView;
      }
      i -= 1;
    }
    AppMethodBeat.o(107451);
    return null;
  }
  
  public final void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(107443);
    if ((this.Mx == null) || (this.Mx.length <= paramInt))
    {
      localObject = new float[paramInt + 1];
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.Mx != null)
      {
        System.arraycopy(this.Mx, 0, localObject, 0, this.Mx.length);
        System.arraycopy(this.My, 0, arrayOfFloat1, 0, this.My.length);
        System.arraycopy(this.Mz, 0, arrayOfFloat2, 0, this.Mz.length);
        System.arraycopy(this.MA, 0, arrayOfFloat3, 0, this.MA.length);
        System.arraycopy(this.MC, 0, arrayOfInt1, 0, this.MC.length);
        System.arraycopy(this.MD, 0, arrayOfInt2, 0, this.MD.length);
        System.arraycopy(this.MF, 0, arrayOfInt3, 0, this.MF.length);
      }
      this.Mx = ((float[])localObject);
      this.My = arrayOfFloat1;
      this.Mz = arrayOfFloat2;
      this.MA = arrayOfFloat3;
      this.MC = arrayOfInt1;
      this.MD = arrayOfInt2;
      this.MF = arrayOfInt3;
    }
    Object localObject = this.Mx;
    this.Mz[paramInt] = paramFloat1;
    localObject[paramInt] = paramFloat1;
    localObject = this.My;
    this.MA[paramInt] = paramFloat2;
    localObject[paramInt] = paramFloat2;
    localObject = this.MC;
    int m = (int)paramFloat1;
    int k = (int)paramFloat2;
    if (m < this.MO.getLeft() + this.MJ) {
      j = 1;
    }
    int i = j;
    if (k < this.MO.getTop() + this.MJ) {
      i = j | 0x4;
    }
    j = i;
    if (m > this.MO.getRight() - this.MJ) {
      j = i | 0x2;
    }
    i = j;
    if (k > this.MO.getBottom() - this.MJ) {
      i = j | 0x8;
    }
    localObject[paramInt] = i;
    this.MG |= 1 << paramInt;
    AppMethodBeat.o(107443);
  }
  
  public final void aJ(int paramInt)
  {
    if (this.Mx == null) {
      return;
    }
    this.Mx[paramInt] = 0.0F;
    this.My[paramInt] = 0.0F;
    this.Mz[paramInt] = 0.0F;
    this.MA[paramInt] = 0.0F;
    this.MC[paramInt] = 0;
    this.MD[paramInt] = 0;
    this.MF[paramInt] = 0;
    this.MG &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  final void aL(int paramInt)
  {
    AppMethodBeat.i(107445);
    if (this.Mw != paramInt)
    {
      this.Mw = paramInt;
      this.Apv.w(paramInt);
      if (paramInt == 0) {
        this.MM = null;
      }
    }
    AppMethodBeat.o(107445);
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(107447);
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
        int[] arrayOfInt = this.MD;
        arrayOfInt[paramInt] = (i | arrayOfInt[paramInt]);
      }
      AppMethodBeat.o(107447);
      return;
      j = 0;
    }
  }
  
  public final boolean b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    AppMethodBeat.i(107436);
    int i = this.MM.getLeft();
    int j = this.MM.getTop();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.jtz.jR.abortAnimation();
      aL(0);
      AppMethodBeat.o(107436);
      return false;
    }
    long l = paramLong;
    if (paramLong == 0L) {
      l = K(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    ab.d("WxViewDragHelper", "ashutest:: xvel %d, yvel %d, dx %d, dy %d duration %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l) });
    this.jtz.startScroll(i, j, paramInt1, paramInt2, (int)l);
    aL(2);
    AppMethodBeat.o(107436);
    return true;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(107435);
    this.mActivePointerId = -1;
    if (this.Mx != null)
    {
      Arrays.fill(this.Mx, 0.0F);
      Arrays.fill(this.My, 0.0F);
      Arrays.fill(this.Mz, 0.0F);
      Arrays.fill(this.MA, 0.0F);
      Arrays.fill(this.MC, 0);
      Arrays.fill(this.MD, 0);
      Arrays.fill(this.MF, 0);
      this.MG = 0;
    }
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
    AppMethodBeat.o(107435);
  }
  
  public final void e(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(107444);
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    while (i < j)
    {
      int k = paramMotionEvent.getPointerId(i);
      float f1 = paramMotionEvent.getX(i);
      float f2 = paramMotionEvent.getY(i);
      this.Mz[k] = f1;
      this.MA[k] = f2;
      i += 1;
    }
    AppMethodBeat.o(107444);
  }
  
  public final void er()
  {
    AppMethodBeat.i(107450);
    this.mVelocityTracker.computeCurrentVelocity(1000, this.MH);
    u(e(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.MI, this.MH), e(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.MI, this.MH));
    AppMethodBeat.o(107450);
  }
  
  public final boolean r(View paramView, float paramFloat)
  {
    AppMethodBeat.i(107449);
    if (paramView == null)
    {
      AppMethodBeat.o(107449);
      return false;
    }
    int i;
    if (this.Apv.dNq() > 0) {
      i = 1;
    }
    while (i != 0) {
      if (Math.abs(paramFloat) > this.mTouchSlop)
      {
        AppMethodBeat.o(107449);
        return true;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(107449);
        return false;
      }
    }
    AppMethodBeat.o(107449);
    return false;
  }
  
  public final void u(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(107442);
    this.MN = true;
    this.Apv.a(this.MM, paramFloat1, paramFloat2);
    this.MN = false;
    if (this.Mw == 1) {
      aL(0);
    }
    AppMethodBeat.o(107442);
  }
  
  public final boolean x(View paramView, int paramInt)
  {
    AppMethodBeat.i(107446);
    if ((paramView == this.MM) && (this.mActivePointerId == paramInt))
    {
      AppMethodBeat.o(107446);
      return true;
    }
    if ((paramView != null) && (this.Apv.QM(paramInt)))
    {
      this.mActivePointerId = paramInt;
      if (paramView.getParent() != this.MO)
      {
        paramView = new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.MO + ")");
        AppMethodBeat.o(107446);
        throw paramView;
      }
      this.MM = paramView;
      this.mActivePointerId = paramInt;
      aL(1);
      AppMethodBeat.o(107446);
      return true;
    }
    AppMethodBeat.o(107446);
    return false;
  }
  
  public static abstract class a
  {
    public abstract boolean QM(int paramInt);
    
    public void a(View paramView, float paramFloat1, float paramFloat2) {}
    
    public int d(View paramView, int paramInt)
    {
      return 0;
    }
    
    public int dNq()
    {
      return 0;
    }
    
    public void hL(int paramInt1, int paramInt2) {}
    
    public void w(int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.mogic.a
 * JD-Core Version:    0.7.0.1
 */