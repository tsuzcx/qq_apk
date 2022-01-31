package me.imid.swipebacklayout.lib;

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
import java.util.Arrays;

public final class a
{
  private static final Interpolator Gu = new a.1();
  int MI;
  float[] MJ;
  float[] MK;
  private float[] ML;
  private float[] MM;
  private int[] MO;
  private int[] MP;
  private int MQ;
  float MR;
  float MS;
  int MT;
  int MU;
  View MW;
  boolean MX;
  final ViewGroup MY;
  final Runnable MZ = new Runnable()
  {
    public final void run()
    {
      a.this.aP(0);
    }
  };
  VelocityTracker fB;
  int fC = -1;
  n hBk;
  private int jb;
  int[] xpc;
  final a xpd;
  
  private a(Context paramContext, ViewGroup paramViewGroup, a parama)
  {
    if (paramViewGroup == null) {
      throw new IllegalArgumentException("Parent view may not be null");
    }
    if (parama == null) {
      throw new IllegalArgumentException("Callback may not be null");
    }
    this.MY = paramViewGroup;
    this.xpd = parama;
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
    if (((this.xpc[paramInt1] & paramInt2) != paramInt2) || ((this.MU & paramInt2) == 0) || ((this.MP[paramInt1] & paramInt2) == paramInt2) || ((this.MO[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= this.jb) && (paramFloat2 <= this.jb))) {}
    while (((this.MO[paramInt1] & paramInt2) != 0) || (paramFloat1 <= this.jb)) {
      return false;
    }
    return true;
  }
  
  private boolean aO(int paramInt)
  {
    return (this.MQ & 1 << paramInt) != 0;
  }
  
  private void dX()
  {
    this.fB.computeCurrentVelocity(1000, this.MR);
    v(e(this.fB.getXVelocity(this.fC), this.MS, this.MR), e(this.fB.getYVelocity(this.fC), this.MS, this.MR));
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
  
  static int h(int paramInt1, int paramInt2, int paramInt3)
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
  
  private void v(float paramFloat1, float paramFloat2)
  {
    this.MX = true;
    this.xpd.a(this.MW, paramFloat1, paramFloat2);
    this.MX = false;
    if (this.MI == 1) {
      aP(0);
    }
  }
  
  final void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    int i = 0;
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
        System.arraycopy(this.xpc, 0, arrayOfInt1, 0, this.xpc.length);
        System.arraycopy(this.MO, 0, arrayOfInt2, 0, this.MO.length);
        System.arraycopy(this.MP, 0, arrayOfInt3, 0, this.MP.length);
      }
      this.MJ = ((float[])localObject);
      this.MK = arrayOfFloat1;
      this.ML = arrayOfFloat2;
      this.MM = arrayOfFloat3;
      this.xpc = arrayOfInt1;
      this.MO = arrayOfInt2;
      this.MP = arrayOfInt3;
    }
    Object localObject = this.MJ;
    this.ML[paramInt] = paramFloat1;
    localObject[paramInt] = paramFloat1;
    localObject = this.MK;
    this.MM[paramInt] = paramFloat2;
    localObject[paramInt] = paramFloat2;
    localObject = this.xpc;
    int k = (int)paramFloat1;
    int j = (int)paramFloat2;
    if (k < this.MY.getLeft() + this.MT) {
      i = 1;
    }
    if (j < this.MY.getTop() + this.MT) {
      i = 4;
    }
    if (k > this.MY.getRight() - this.MT) {
      i = 2;
    }
    if (j > this.MY.getBottom() - this.MT) {
      i = 8;
    }
    localObject[paramInt] = i;
    this.MQ |= 1 << paramInt;
  }
  
  final void aN(int paramInt)
  {
    if (this.MJ == null) {
      return;
    }
    this.MJ[paramInt] = 0.0F;
    this.MK[paramInt] = 0.0F;
    this.ML[paramInt] = 0.0F;
    this.MM[paramInt] = 0.0F;
    this.xpc[paramInt] = 0;
    this.MO[paramInt] = 0;
    this.MP[paramInt] = 0;
    this.MQ &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  final void aP(int paramInt)
  {
    if (this.MI != paramInt)
    {
      this.MI = paramInt;
      this.xpd.x(paramInt);
      if (paramInt == 0) {
        this.MW = null;
      }
    }
  }
  
  final void b(float paramFloat1, float paramFloat2, int paramInt)
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
  
  final boolean c(View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramView == null) {}
    label19:
    int j;
    label71:
    label77:
    do
    {
      do
      {
        return false;
        int i;
        if (this.xpd.cIF() > 0)
        {
          i = 1;
          if (this.xpd.au() <= 0) {
            break label71;
          }
        }
        for (j = 1;; j = 0)
        {
          if ((i == 0) || (j == 0)) {
            break label77;
          }
          if (paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 <= this.jb * this.jb) {
            break;
          }
          return true;
          i = 0;
          break label19;
        }
        if (i == 0) {
          break;
        }
      } while (Math.abs(paramFloat1) <= this.jb);
      return true;
    } while ((j == 0) || (Math.abs(paramFloat2) <= this.jb));
    return true;
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
      Arrays.fill(this.xpc, 0);
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
  
  final void e(MotionEvent paramMotionEvent)
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
  
  final int g(int paramInt1, int paramInt2, int paramInt3)
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
  
  public final void g(MotionEvent paramMotionEvent)
  {
    int k = 0;
    int i = 0;
    int j = 0;
    int n = paramMotionEvent.getActionMasked();
    int m = paramMotionEvent.getActionIndex();
    if (n == 0) {
      cancel();
    }
    if (this.fB == null) {
      this.fB = VelocityTracker.obtain();
    }
    this.fB.addMovement(paramMotionEvent);
    float f1;
    float f2;
    switch (n)
    {
    case 4: 
    default: 
    case 0: 
    case 5: 
      do
      {
        do
        {
          return;
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          i = paramMotionEvent.getPointerId(0);
          paramMotionEvent = y((int)f1, (int)f2);
          a(f1, f2, i);
          u(paramMotionEvent, i);
        } while ((this.xpc[i] & this.MU) == 0);
        return;
        k = paramMotionEvent.getPointerId(m);
        f1 = paramMotionEvent.getX(m);
        f2 = paramMotionEvent.getY(m);
        a(f1, f2, k);
        if (this.MI == 0)
        {
          u(y((int)f1, (int)f2), k);
          return;
        }
        m = (int)f1;
        n = (int)f2;
        paramMotionEvent = this.MW;
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
      u(this.MW, k);
      return;
    case 2: 
      if (this.MI == 1)
      {
        i = paramMotionEvent.findPointerIndex(this.fC);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        m = (int)(f1 - this.ML[this.fC]);
        n = (int)(f2 - this.MM[this.fC]);
        j = this.MW.getLeft() + m;
        k = this.MW.getTop() + n;
        int i1 = this.MW.getLeft();
        int i2 = this.MW.getTop();
        i = j;
        if (m != 0)
        {
          i = this.xpd.d(this.MW, j);
          this.MW.offsetLeftAndRight(i - i1);
        }
        j = k;
        if (n != 0)
        {
          j = this.xpd.c(this.MW, k);
          this.MW.offsetTopAndBottom(j - i2);
        }
        if ((m != 0) || (n != 0)) {
          this.xpd.k(this.MW, i, j, i - i1, j - i2);
        }
        e(paramMotionEvent);
        return;
      }
      j = paramMotionEvent.getPointerCount();
      i = k;
      while (i < j)
      {
        k = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        float f3 = f1 - this.MJ[k];
        float f4 = f2 - this.MK[k];
        b(f3, f4, k);
        if (this.MI == 1) {
          break;
        }
        View localView = y((int)f1, (int)f2);
        if ((c(localView, f3, f4)) && (u(localView, k))) {
          break;
        }
        i += 1;
      }
      e(paramMotionEvent);
      return;
    case 6: 
      j = paramMotionEvent.getPointerId(m);
      if ((this.MI == 1) && (j == this.fC))
      {
        k = paramMotionEvent.getPointerCount();
        if (i >= k) {
          break label809;
        }
        m = paramMotionEvent.getPointerId(i);
        if (m == this.fC) {
          break label764;
        }
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        if ((y((int)f1, (int)f2) != this.MW) || (!u(this.MW, m))) {
          break label764;
        }
      }
      break;
    }
    label809:
    for (i = this.fC;; i = -1)
    {
      if (i == -1) {
        dX();
      }
      aN(j);
      return;
      label764:
      i += 1;
      break;
      if (this.MI == 1) {
        dX();
      }
      cancel();
      return;
      if (this.MI == 1) {
        v(0.0F, 0.0F);
      }
      cancel();
      return;
    }
  }
  
  public final boolean gw(int paramInt1, int paramInt2)
  {
    if (!aO(paramInt2)) {}
    label20:
    float f2;
    label98:
    label103:
    do
    {
      float f1;
      do
      {
        return false;
        int i;
        if ((paramInt1 & 0x1) == 1)
        {
          i = 1;
          if ((paramInt1 & 0x2) != 2) {
            break label98;
          }
        }
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          f1 = this.ML[paramInt2] - this.MJ[paramInt2];
          f2 = this.MM[paramInt2] - this.MK[paramInt2];
          if ((i == 0) || (paramInt1 == 0)) {
            break label103;
          }
          if (f1 * f1 + f2 * f2 <= this.jb * this.jb) {
            break;
          }
          return true;
          i = 0;
          break label20;
        }
        if (i == 0) {
          break;
        }
      } while (Math.abs(f1) <= this.jb);
      return true;
    } while ((paramInt1 == 0) || (Math.abs(f2) <= this.jb));
    return true;
  }
  
  public final boolean gx(int paramInt1, int paramInt2)
  {
    return (aO(paramInt2)) && ((this.xpc[paramInt2] & paramInt1) != 0);
  }
  
  final boolean u(View paramView, int paramInt)
  {
    if ((paramView == this.MW) && (this.fC == paramInt)) {
      return true;
    }
    if ((paramView != null) && (this.xpd.Ia(paramInt)))
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
    
    public int au()
    {
      return 0;
    }
    
    public int c(View paramView, int paramInt)
    {
      return 0;
    }
    
    public int cIF()
    {
      return 0;
    }
    
    public int d(View paramView, int paramInt)
    {
      return 0;
    }
    
    public void k(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    public void x(int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     me.imid.swipebacklayout.lib.a
 * JD-Core Version:    0.7.0.1
 */