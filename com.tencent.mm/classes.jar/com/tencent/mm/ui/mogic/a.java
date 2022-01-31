package com.tencent.mm.ui.mogic;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.widget.n;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Arrays;

public final class a
{
  private static final Interpolator Gu = new Interpolator()
  {
    public final float getInterpolation(float paramAnonymousFloat)
    {
      paramAnonymousFloat -= 1.0F;
      return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
    }
  };
  public int MI;
  public float[] MJ;
  public float[] MK;
  public float[] ML;
  public float[] MM;
  public int[] MN;
  private int[] MO;
  private int[] MP;
  public int MQ;
  public float MR;
  public float MS;
  private int MT;
  public int MU;
  public View MW;
  public boolean MX;
  public final ViewGroup MY;
  public final Runnable MZ = new Runnable()
  {
    public final void run()
    {
      a.this.aP(0);
    }
  };
  public VelocityTracker fB;
  public int fC = -1;
  public n hBk;
  private int jb;
  public final a vXk;
  
  private a(Context paramContext, ViewGroup paramViewGroup, a parama)
  {
    if (paramViewGroup == null) {
      throw new IllegalArgumentException("Parent view may not be null");
    }
    if (parama == null) {
      throw new IllegalArgumentException("Callback may not be null");
    }
    this.MY = paramViewGroup;
    this.vXk = parama;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.MT = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.jb = paramViewGroup.getScaledTouchSlop();
    this.MR = paramViewGroup.getScaledMaximumFlingVelocity();
    this.MS = paramViewGroup.getScaledMinimumFlingVelocity();
    this.hBk = n.a(paramContext, Gu);
  }
  
  public static a a(ViewGroup paramViewGroup, a parama)
  {
    return new a(paramViewGroup.getContext(), paramViewGroup, parama);
  }
  
  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    if (((this.MN[paramInt1] & paramInt2) != paramInt2) || ((this.MU & paramInt2) == 0) || ((this.MP[paramInt1] & paramInt2) == paramInt2) || ((this.MO[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= this.jb) && (paramFloat2 <= this.jb))) {}
    while (((this.MO[paramInt1] & paramInt2) != 0) || (paramFloat1 <= this.jb)) {
      return false;
    }
    return true;
  }
  
  private static float e(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f = Math.abs(paramFloat1);
    if (f < paramFloat2) {
      paramFloat2 = 0.0F;
    }
    do
    {
      return paramFloat2;
      if (f <= paramFloat3) {
        break;
      }
      paramFloat2 = paramFloat3;
    } while (paramFloat1 > 0.0F);
    return -paramFloat3;
    return paramFloat1;
  }
  
  private int g(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return 0;
    }
    int i = this.MY.getWidth();
    int j = i / 2;
    float f3 = Math.min(1.0F, Math.abs(paramInt1) / i);
    float f1 = j;
    float f2 = j;
    f3 = (float)Math.sin((float)((f3 - 0.5F) * 0.47123891676382D));
    paramInt2 = Math.abs(paramInt2);
    if (paramInt2 > 0) {}
    for (paramInt1 = Math.round(Math.abs((f3 * f2 + f1) / paramInt2) * 1000.0F) * 4;; paramInt1 = (int)((Math.abs(paramInt1) / paramInt3 + 1.0F) * 256.0F)) {
      return Math.min(paramInt1, 600);
    }
  }
  
  private static int h(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = Math.abs(paramInt1);
    if (i < paramInt2) {
      paramInt2 = 0;
    }
    do
    {
      return paramInt2;
      if (i <= paramInt3) {
        break;
      }
      paramInt2 = paramInt3;
    } while (paramInt1 > 0);
    return -paramInt3;
    return paramInt1;
  }
  
  public final void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 0;
    if ((this.MJ == null) || (this.MJ.length <= paramInt))
    {
      localObject = new float[paramInt + 1];
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.MJ != null)
      {
        System.arraycopy(this.MJ, 0, localObject, 0, this.MJ.length);
        System.arraycopy(this.MK, 0, arrayOfFloat1, 0, this.MK.length);
        System.arraycopy(this.ML, 0, arrayOfFloat2, 0, this.ML.length);
        System.arraycopy(this.MM, 0, arrayOfFloat3, 0, this.MM.length);
        System.arraycopy(this.MN, 0, arrayOfInt1, 0, this.MN.length);
        System.arraycopy(this.MO, 0, arrayOfInt2, 0, this.MO.length);
        System.arraycopy(this.MP, 0, arrayOfInt3, 0, this.MP.length);
      }
      this.MJ = ((float[])localObject);
      this.MK = arrayOfFloat1;
      this.ML = arrayOfFloat2;
      this.MM = arrayOfFloat3;
      this.MN = arrayOfInt1;
      this.MO = arrayOfInt2;
      this.MP = arrayOfInt3;
    }
    Object localObject = this.MJ;
    this.ML[paramInt] = paramFloat1;
    localObject[paramInt] = paramFloat1;
    localObject = this.MK;
    this.MM[paramInt] = paramFloat2;
    localObject[paramInt] = paramFloat2;
    localObject = this.MN;
    int m = (int)paramFloat1;
    int k = (int)paramFloat2;
    if (m < this.MY.getLeft() + this.MT) {
      j = 1;
    }
    int i = j;
    if (k < this.MY.getTop() + this.MT) {
      i = j | 0x4;
    }
    j = i;
    if (m > this.MY.getRight() - this.MT) {
      j = i | 0x2;
    }
    i = j;
    if (k > this.MY.getBottom() - this.MT) {
      i = j | 0x8;
    }
    localObject[paramInt] = i;
    this.MQ |= 1 << paramInt;
  }
  
  public final void aN(int paramInt)
  {
    if (this.MJ == null) {
      return;
    }
    this.MJ[paramInt] = 0.0F;
    this.MK[paramInt] = 0.0F;
    this.ML[paramInt] = 0.0F;
    this.MM[paramInt] = 0.0F;
    this.MN[paramInt] = 0;
    this.MO[paramInt] = 0;
    this.MP[paramInt] = 0;
    this.MQ &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  final void aP(int paramInt)
  {
    if (this.MI != paramInt)
    {
      this.MI = paramInt;
      this.vXk.x(paramInt);
      if (paramInt == 0) {
        this.MW = null;
      }
    }
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 1;
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
        int[] arrayOfInt = this.MO;
        arrayOfInt[paramInt] = (i | arrayOfInt[paramInt]);
      }
      return;
      j = 0;
    }
  }
  
  public final void cancel()
  {
    this.fC = -1;
    if (this.MJ != null)
    {
      Arrays.fill(this.MJ, 0.0F);
      Arrays.fill(this.MK, 0.0F);
      Arrays.fill(this.ML, 0.0F);
      Arrays.fill(this.MM, 0.0F);
      Arrays.fill(this.MN, 0);
      Arrays.fill(this.MO, 0);
      Arrays.fill(this.MP, 0);
      this.MQ = 0;
    }
    if (this.fB != null)
    {
      this.fB.recycle();
      this.fB = null;
    }
  }
  
  public final void dX()
  {
    this.fB.computeCurrentVelocity(1000, this.MR);
    v(e(this.fB.getXVelocity(this.fC), this.MS, this.MR), e(this.fB.getYVelocity(this.fC), this.MS, this.MR));
  }
  
  public final void e(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    while (i < j)
    {
      int k = paramMotionEvent.getPointerId(i);
      float f1 = paramMotionEvent.getX(i);
      float f2 = paramMotionEvent.getY(i);
      this.ML[k] = f1;
      this.MM[k] = f2;
      i += 1;
    }
  }
  
  public final boolean h(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = this.MW.getLeft();
    int j = this.MW.getTop();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.hBk.iY.abortAnimation();
      aP(0);
      return false;
    }
    int m = h(paramInt3, (int)this.MS, (int)this.MR);
    int k = h(paramInt4, (int)this.MS, (int)this.MR);
    int n = Math.abs(paramInt1);
    int i1 = Math.abs(paramInt2);
    int i2 = Math.abs(m);
    int i3 = Math.abs(k);
    int i4 = i2 + i3;
    int i5 = n + i1;
    float f1;
    if (m != 0)
    {
      f1 = i2 / i4;
      if (k == 0) {
        break label284;
      }
    }
    label284:
    for (float f2 = i3 / i4;; f2 = i1 / i5)
    {
      m = g(paramInt1, m, this.vXk.cIF());
      k = g(paramInt2, k, 0);
      float f3 = m;
      k = (int)(f2 * k + f1 * f3);
      y.d("WxViewDragHelper", "ashutest:: xvel %d, yvel %d, dx %d, dy %d duration %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(k) });
      this.hBk.startScroll(i, j, paramInt1, paramInt2, k);
      aP(2);
      return true;
      f1 = n / i5;
      break;
    }
  }
  
  public final boolean o(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    for (;;)
    {
      return false;
      if (this.vXk.cIF() > 0) {}
      for (int i = 1; (i != 0) && (Math.abs(paramFloat) > this.jb); i = 0) {
        return true;
      }
    }
  }
  
  public final boolean u(View paramView, int paramInt)
  {
    if ((paramView == this.MW) && (this.fC == paramInt)) {
      return true;
    }
    if ((paramView != null) && (this.vXk.Ia(paramInt)))
    {
      this.fC = paramInt;
      if (paramView.getParent() != this.MY) {
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.MY + ")");
      }
      this.MW = paramView;
      this.fC = paramInt;
      aP(1);
      return true;
    }
    return false;
  }
  
  public final void v(float paramFloat1, float paramFloat2)
  {
    this.MX = true;
    this.vXk.a(this.MW, paramFloat1, paramFloat2);
    this.MX = false;
    if (this.MI == 1) {
      aP(0);
    }
  }
  
  public final View y(int paramInt1, int paramInt2)
  {
    int i = this.MY.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.MY.getChildAt(i);
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom())) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  public static abstract class a
  {
    public abstract boolean Ia(int paramInt);
    
    public void a(View paramView, float paramFloat1, float paramFloat2) {}
    
    public int cIF()
    {
      return 0;
    }
    
    public int d(View paramView, int paramInt)
    {
      return 0;
    }
    
    public void fC(int paramInt1, int paramInt2) {}
    
    public void x(int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.mogic.a
 * JD-Core Version:    0.7.0.1
 */