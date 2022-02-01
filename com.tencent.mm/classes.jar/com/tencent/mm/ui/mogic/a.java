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
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Arrays;

public final class a
{
  private static final Interpolator sInterpolator;
  public final a KCj;
  public final ViewGroup WA;
  public final Runnable WB;
  public int Wk;
  public float[] Wl;
  public float[] Wm;
  public float[] Wn;
  public float[] Wo;
  public int[] Wp;
  private int[] Wq;
  private int[] Wr;
  public int Ws;
  public float Wt;
  public float Wu;
  private int Wv;
  public int Ww;
  public View Wy;
  public boolean Wz;
  public int mActivePointerId;
  private int mTouchSlop;
  public VelocityTracker mVelocityTracker;
  public p nlZ;
  
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
    this.WB = new Runnable()
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
    this.WA = paramViewGroup;
    this.KCj = parama;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.Wv = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.mTouchSlop = paramViewGroup.getScaledTouchSlop();
    this.Wt = paramViewGroup.getScaledMaximumFlingVelocity();
    this.Wu = paramViewGroup.getScaledMinimumFlingVelocity();
    this.nlZ = p.a(paramContext, paramInterpolator);
    AppMethodBeat.o(142868);
  }
  
  private int Q(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142871);
    paramInt3 = i(paramInt3, (int)this.Wu, (int)this.Wt);
    paramInt4 = i(paramInt4, (int)this.Wu, (int)this.Wt);
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
      paramInt1 = h(paramInt1, paramInt3, this.KCj.fJQ());
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
    if (((this.Wp[paramInt1] & paramInt2) != paramInt2) || ((this.Ww & paramInt2) == 0) || ((this.Wr[paramInt1] & paramInt2) == paramInt2) || ((this.Wq[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= this.mTouchSlop) && (paramFloat2 <= this.mTouchSlop)))
    {
      AppMethodBeat.o(142882);
      return false;
    }
    if (((this.Wq[paramInt1] & paramInt2) == 0) && (paramFloat1 > this.mTouchSlop))
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
    int i = this.WA.getWidth();
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
  
  public final View J(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142885);
    int i = this.WA.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.WA.getChildAt(i);
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
    if ((this.Wl == null) || (this.Wl.length <= paramInt))
    {
      localObject = new float[paramInt + 1];
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.Wl != null)
      {
        System.arraycopy(this.Wl, 0, localObject, 0, this.Wl.length);
        System.arraycopy(this.Wm, 0, arrayOfFloat1, 0, this.Wm.length);
        System.arraycopy(this.Wn, 0, arrayOfFloat2, 0, this.Wn.length);
        System.arraycopy(this.Wo, 0, arrayOfFloat3, 0, this.Wo.length);
        System.arraycopy(this.Wp, 0, arrayOfInt1, 0, this.Wp.length);
        System.arraycopy(this.Wq, 0, arrayOfInt2, 0, this.Wq.length);
        System.arraycopy(this.Wr, 0, arrayOfInt3, 0, this.Wr.length);
      }
      this.Wl = ((float[])localObject);
      this.Wm = arrayOfFloat1;
      this.Wn = arrayOfFloat2;
      this.Wo = arrayOfFloat3;
      this.Wp = arrayOfInt1;
      this.Wq = arrayOfInt2;
      this.Wr = arrayOfInt3;
    }
    Object localObject = this.Wl;
    this.Wn[paramInt] = paramFloat1;
    localObject[paramInt] = paramFloat1;
    localObject = this.Wm;
    this.Wo[paramInt] = paramFloat2;
    localObject[paramInt] = paramFloat2;
    localObject = this.Wp;
    int m = (int)paramFloat1;
    int k = (int)paramFloat2;
    if (m < this.WA.getLeft() + this.Wv) {
      j = 1;
    }
    int i = j;
    if (k < this.WA.getTop() + this.Wv) {
      i = j | 0x4;
    }
    j = i;
    if (m > this.WA.getRight() - this.Wv) {
      j = i | 0x2;
    }
    i = j;
    if (k > this.WA.getBottom() - this.Wv) {
      i = j | 0x8;
    }
    localObject[paramInt] = i;
    this.Ws |= 1 << paramInt;
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
        int[] arrayOfInt = this.Wq;
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
    int i = this.Wy.getLeft();
    int j = this.Wy.getTop();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.nlZ.Ur.abortAnimation();
      be(0);
      AppMethodBeat.o(142870);
      return false;
    }
    long l = paramLong;
    if (paramLong == 0L) {
      l = Q(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    ad.d("WxViewDragHelper", "ashutest:: xvel %d, yvel %d, dx %d, dy %d duration %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l) });
    this.nlZ.startScroll(i, j, paramInt1, paramInt2, (int)l);
    be(2);
    AppMethodBeat.o(142870);
    return true;
  }
  
  public final void bc(int paramInt)
  {
    if (this.Wl == null) {
      return;
    }
    this.Wl[paramInt] = 0.0F;
    this.Wm[paramInt] = 0.0F;
    this.Wn[paramInt] = 0.0F;
    this.Wo[paramInt] = 0.0F;
    this.Wp[paramInt] = 0;
    this.Wq[paramInt] = 0;
    this.Wr[paramInt] = 0;
    this.Ws &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  final void be(int paramInt)
  {
    AppMethodBeat.i(142879);
    if (this.Wk != paramInt)
    {
      this.Wk = paramInt;
      this.KCj.L(paramInt);
      if (paramInt == 0) {
        this.Wy = null;
      }
    }
    AppMethodBeat.o(142879);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(142869);
    this.mActivePointerId = -1;
    if (this.Wl != null)
    {
      Arrays.fill(this.Wl, 0.0F);
      Arrays.fill(this.Wm, 0.0F);
      Arrays.fill(this.Wn, 0.0F);
      Arrays.fill(this.Wo, 0.0F);
      Arrays.fill(this.Wp, 0);
      Arrays.fill(this.Wq, 0);
      Arrays.fill(this.Wr, 0);
      this.Ws = 0;
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
      this.Wn[k] = f1;
      this.Wo[k] = f2;
      i += 1;
    }
    AppMethodBeat.o(142878);
  }
  
  public final void gj()
  {
    AppMethodBeat.i(142884);
    this.mVelocityTracker.computeCurrentVelocity(1000, this.Wt);
    l(f(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.Wu, this.Wt), f(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.Wu, this.Wt));
    AppMethodBeat.o(142884);
  }
  
  public final void l(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142876);
    this.Wz = true;
    this.KCj.a(this.Wy, paramFloat1, paramFloat2);
    this.Wz = false;
    if (this.Wk == 1) {
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
    if (this.KCj.fJQ() > 0) {
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
    if ((paramView == this.Wy) && (this.mActivePointerId == paramInt))
    {
      AppMethodBeat.o(142880);
      return true;
    }
    if ((paramView != null) && (this.KCj.aeQ(paramInt)))
    {
      this.mActivePointerId = paramInt;
      if (paramView.getParent() != this.WA)
      {
        paramView = new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.WA + ")");
        AppMethodBeat.o(142880);
        throw paramView;
      }
      this.Wy = paramView;
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
    public void L(int paramInt) {}
    
    public void a(View paramView, float paramFloat1, float paramFloat2) {}
    
    public abstract boolean aeQ(int paramInt);
    
    public int e(View paramView, int paramInt)
    {
      return 0;
    }
    
    public int fJQ()
    {
      return 0;
    }
    
    public void jW(int paramInt1, int paramInt2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.mogic.a
 * JD-Core Version:    0.7.0.1
 */