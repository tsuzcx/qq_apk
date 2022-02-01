package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.r;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;

public final class ad
{
  private static final Interpolator mU = new Interpolator()
  {
    public final float getInterpolation(float paramAnonymousFloat)
    {
      paramAnonymousFloat -= 1.0F;
      return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
    }
  };
  private int mi;
  private int nv = -1;
  private VelocityTracker nw;
  private OverScroller qO;
  private float sA;
  private int sB;
  private int sC;
  private final ae sD;
  private View sE;
  private boolean sF;
  private final ViewGroup sG;
  private final Runnable sH = new Runnable()
  {
    public final void run()
    {
      ad.this.ag(0);
    }
  };
  private int sq;
  private float[] sr;
  private float[] ss;
  private float[] st;
  private float[] su;
  private int[] sv;
  private int[] sw;
  private int[] sx;
  private int sy;
  private float sz;
  
  private ad(Context paramContext, ViewGroup paramViewGroup, ae paramae)
  {
    if (paramViewGroup == null) {
      throw new IllegalArgumentException("Parent view may not be null");
    }
    if (paramae == null) {
      throw new IllegalArgumentException("Callback may not be null");
    }
    this.sG = paramViewGroup;
    this.sD = paramae;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.sB = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.mi = paramViewGroup.getScaledTouchSlop();
    this.sz = paramViewGroup.getScaledMaximumFlingVelocity();
    this.sA = paramViewGroup.getScaledMinimumFlingVelocity();
    this.qO = new OverScroller(paramContext, mU);
  }
  
  private static float a(float paramFloat)
  {
    return (float)Math.sin((paramFloat - 0.5F) * 0.4712389F);
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3)
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
  
  public static ad a(ViewGroup paramViewGroup, float paramFloat, ae paramae)
  {
    paramViewGroup = new ad(paramViewGroup.getContext(), paramViewGroup, paramae);
    paramViewGroup.mi = ((int)(paramViewGroup.mi * (1.0F / paramFloat)));
    return paramViewGroup;
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 0;
    if ((this.sr == null) || (this.sr.length <= paramInt))
    {
      localObject = new float[paramInt + 1];
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.sr != null)
      {
        System.arraycopy(this.sr, 0, localObject, 0, this.sr.length);
        System.arraycopy(this.ss, 0, arrayOfFloat1, 0, this.ss.length);
        System.arraycopy(this.st, 0, arrayOfFloat2, 0, this.st.length);
        System.arraycopy(this.su, 0, arrayOfFloat3, 0, this.su.length);
        System.arraycopy(this.sv, 0, arrayOfInt1, 0, this.sv.length);
        System.arraycopy(this.sw, 0, arrayOfInt2, 0, this.sw.length);
        System.arraycopy(this.sx, 0, arrayOfInt3, 0, this.sx.length);
      }
      this.sr = ((float[])localObject);
      this.ss = arrayOfFloat1;
      this.st = arrayOfFloat2;
      this.su = arrayOfFloat3;
      this.sv = arrayOfInt1;
      this.sw = arrayOfInt2;
      this.sx = arrayOfInt3;
    }
    Object localObject = this.sr;
    this.st[paramInt] = paramFloat1;
    localObject[paramInt] = paramFloat1;
    localObject = this.ss;
    this.su[paramInt] = paramFloat2;
    localObject[paramInt] = paramFloat2;
    localObject = this.sv;
    int m = (int)paramFloat1;
    int k = (int)paramFloat2;
    if (m < this.sG.getLeft() + this.sB) {
      j = 1;
    }
    int i = j;
    if (k < this.sG.getTop() + this.sB) {
      i = j | 0x4;
    }
    j = i;
    if (m > this.sG.getRight() - this.sB) {
      j = i | 0x2;
    }
    i = j;
    if (k > this.sG.getBottom() - this.sB) {
      i = j | 0x8;
    }
    localObject[paramInt] = i;
    this.sy |= 1 << paramInt;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    if (((this.sv[paramInt1] & paramInt2) != paramInt2) || ((this.sC & paramInt2) == 0) || ((this.sx[paramInt1] & paramInt2) == paramInt2) || ((this.sw[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= this.mi) && (paramFloat2 <= this.mi))) {}
    while (((this.sw[paramInt1] & paramInt2) != 0) || (paramFloat1 <= this.mi)) {
      return false;
    }
    return true;
  }
  
  private void ae(int paramInt)
  {
    if ((this.sr == null) || (!af(paramInt))) {
      return;
    }
    this.sr[paramInt] = 0.0F;
    this.ss[paramInt] = 0.0F;
    this.st[paramInt] = 0.0F;
    this.su[paramInt] = 0.0F;
    this.sv[paramInt] = 0;
    this.sw[paramInt] = 0;
    this.sx[paramInt] = 0;
    this.sy &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  private boolean af(int paramInt)
  {
    return (this.sy & 1 << paramInt) != 0;
  }
  
  private boolean ah(int paramInt)
  {
    if (!af(paramInt))
    {
      Log.e("ViewDragHelper", "Ignoring pointerId=" + paramInt + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
      return false;
    }
    return true;
  }
  
  private int b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = e(paramInt3, (int)this.sA, (int)this.sz);
    paramInt4 = e(paramInt4, (int)this.sA, (int)this.sz);
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
        break label156;
      }
    }
    label156:
    for (float f2 = m / n;; f2 = j / i1)
    {
      paramInt1 = d(paramInt1, paramInt3, this.sD.R(paramView));
      paramInt2 = d(paramInt2, paramInt4, 0);
      float f3 = paramInt1;
      return (int)(f2 * paramInt2 + f1 * f3);
      f1 = i / i1;
      break;
    }
  }
  
  private void b(float paramFloat1, float paramFloat2, int paramInt)
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
        int[] arrayOfInt = this.sw;
        arrayOfInt[paramInt] |= i;
        this.sD.f(i, paramInt);
      }
      return;
      j = 0;
    }
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    while (i < j)
    {
      int k = paramMotionEvent.getPointerId(i);
      if (ah(k))
      {
        float f1 = paramMotionEvent.getX(i);
        float f2 = paramMotionEvent.getY(i);
        this.st[k] = f1;
        this.su[k] = f2;
      }
      i += 1;
    }
  }
  
  private boolean c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = this.sE.getLeft();
    int j = this.sE.getTop();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.qO.abortAnimation();
      ag(0);
      return false;
    }
    paramInt3 = b(this.sE, paramInt1, paramInt2, paramInt3, paramInt4);
    this.qO.startScroll(i, j, paramInt1, paramInt2, paramInt3);
    ag(2);
    return true;
  }
  
  public static boolean c(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {}
    while ((paramInt1 < paramView.getLeft()) || (paramInt1 >= paramView.getRight()) || (paramInt2 < paramView.getTop()) || (paramInt2 >= paramView.getBottom())) {
      return false;
    }
    return true;
  }
  
  private void cG()
  {
    this.nw.computeCurrentVelocity(1000, this.sz);
    float f = a(this.nw.getXVelocity(this.nv), this.sA, this.sz);
    a(this.nw.getYVelocity(this.nv), this.sA, this.sz);
    q(f);
  }
  
  private int d(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return 0;
    }
    int i = this.sG.getWidth();
    int j = i / 2;
    float f3 = Math.min(1.0F, Math.abs(paramInt1) / i);
    float f1 = j;
    float f2 = j;
    f3 = a(f3);
    paramInt2 = Math.abs(paramInt2);
    if (paramInt2 > 0) {}
    for (paramInt1 = Math.round(Math.abs((f3 * f2 + f1) / paramInt2) * 1000.0F) * 4;; paramInt1 = (int)((Math.abs(paramInt1) / paramInt3 + 1.0F) * 256.0F)) {
      return Math.min(paramInt1, 600);
    }
  }
  
  private static int e(int paramInt1, int paramInt2, int paramInt3)
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
  
  private boolean g(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    for (;;)
    {
      return false;
      if (this.sD.R(paramView) > 0) {}
      for (int i = 1; (i != 0) && (Math.abs(paramFloat) > this.mi); i = 0) {
        return true;
      }
    }
  }
  
  private boolean m(View paramView, int paramInt)
  {
    if ((paramView == this.sE) && (this.nv == paramInt)) {
      return true;
    }
    if ((paramView != null) && (this.sD.P(paramView)))
    {
      this.nv = paramInt;
      l(paramView, paramInt);
      return true;
    }
    return false;
  }
  
  private void q(float paramFloat)
  {
    this.sF = true;
    this.sD.f(this.sE, paramFloat);
    this.sF = false;
    if (this.sq == 1) {
      ag(0);
    }
  }
  
  public final void abort()
  {
    cancel();
    if (this.sq == 2)
    {
      this.qO.getCurrX();
      this.qO.getCurrY();
      this.qO.abortAnimation();
      int i = this.qO.getCurrX();
      this.qO.getCurrY();
      this.sD.j(this.sE, i);
    }
    ag(0);
  }
  
  public final void ad(int paramInt)
  {
    this.sC = paramInt;
  }
  
  final void ag(int paramInt)
  {
    this.sG.removeCallbacks(this.sH);
    if (this.sq != paramInt)
    {
      this.sq = paramInt;
      this.sD.V(paramInt);
      if (this.sq == 0) {
        this.sE = null;
      }
    }
  }
  
  public final boolean b(View paramView, int paramInt1, int paramInt2)
  {
    this.sE = paramView;
    this.nv = -1;
    boolean bool = c(paramInt1, paramInt2, 0, 0);
    if ((!bool) && (this.sq == 0) && (this.sE != null)) {
      this.sE = null;
    }
    return bool;
  }
  
  public final int cB()
  {
    return this.sq;
  }
  
  public final int cC()
  {
    return this.sB;
  }
  
  public final View cD()
  {
    return this.sE;
  }
  
  public final boolean cE()
  {
    boolean bool2 = false;
    if (this.sq == 2)
    {
      boolean bool3 = this.qO.computeScrollOffset();
      int i = this.qO.getCurrX();
      int j = this.qO.getCurrY();
      int k = i - this.sE.getLeft();
      int m = j - this.sE.getTop();
      if (k != 0) {
        r.h(this.sE, k);
      }
      if (m != 0) {
        r.g(this.sE, m);
      }
      if ((k != 0) || (m != 0)) {
        this.sD.j(this.sE, i);
      }
      bool1 = bool3;
      if (bool3)
      {
        bool1 = bool3;
        if (i == this.qO.getFinalX())
        {
          bool1 = bool3;
          if (j == this.qO.getFinalY())
          {
            this.qO.abortAnimation();
            bool1 = false;
          }
        }
      }
      if (!bool1) {
        this.sG.post(this.sH);
      }
    }
    boolean bool1 = bool2;
    if (this.sq == 2) {
      bool1 = true;
    }
    return bool1;
  }
  
  public final boolean cF()
  {
    int k = this.sr.length;
    int j = 0;
    while (j < k)
    {
      int i;
      if (af(j))
      {
        float f1 = this.st[j] - this.sr[j];
        float f2 = this.su[j] - this.ss[j];
        if (f1 * f1 + f2 * f2 > this.mi * this.mi) {
          i = 1;
        }
      }
      while (i != 0)
      {
        return true;
        i = 0;
        continue;
        i = 0;
      }
      j += 1;
    }
    return false;
  }
  
  public final void cancel()
  {
    this.nv = -1;
    if (this.sr != null)
    {
      Arrays.fill(this.sr, 0.0F);
      Arrays.fill(this.ss, 0.0F);
      Arrays.fill(this.st, 0.0F);
      Arrays.fill(this.su, 0.0F);
      Arrays.fill(this.sv, 0);
      Arrays.fill(this.sw, 0);
      Arrays.fill(this.sx, 0);
      this.sy = 0;
    }
    if (this.nw != null)
    {
      this.nw.recycle();
      this.nw = null;
    }
  }
  
  public final boolean d(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getActionMasked();
    int i = paramMotionEvent.getActionIndex();
    if (j == 0) {
      cancel();
    }
    if (this.nw == null) {
      this.nw = VelocityTracker.obtain();
    }
    this.nw.addMovement(paramMotionEvent);
    switch (j)
    {
    }
    while (this.sq == 1)
    {
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      i = paramMotionEvent.getPointerId(0);
      a(f1, f2, i);
      paramMotionEvent = k((int)f1, (int)f2);
      if ((paramMotionEvent == this.sE) && (this.sq == 2)) {
        m(paramMotionEvent, i);
      }
      if ((this.sv[i] & this.sC) != 0)
      {
        this.sD.cl();
        continue;
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        a(f1, f2, j);
        if (this.sq == 0)
        {
          if ((this.sv[j] & this.sC) != 0) {
            this.sD.cl();
          }
        }
        else if (this.sq == 2)
        {
          paramMotionEvent = k((int)f1, (int)f2);
          if (paramMotionEvent == this.sE)
          {
            m(paramMotionEvent, j);
            continue;
            if ((this.sr != null) && (this.ss != null))
            {
              int k = paramMotionEvent.getPointerCount();
              i = 0;
              for (;;)
              {
                int m;
                float f3;
                float f4;
                View localView;
                if (i < k)
                {
                  m = paramMotionEvent.getPointerId(i);
                  if (!ah(m)) {
                    break label516;
                  }
                  f1 = paramMotionEvent.getX(i);
                  f2 = paramMotionEvent.getY(i);
                  f3 = f1 - this.sr[m];
                  f4 = this.ss[m];
                  localView = k((int)f1, (int)f2);
                  if ((localView == null) || (!g(localView, f3))) {
                    break label474;
                  }
                  j = 1;
                  label389:
                  if (j == 0) {
                    break label480;
                  }
                  int n = localView.getLeft();
                  int i1 = (int)f3;
                  i1 = this.sD.k(localView, i1 + n);
                  localView.getTop();
                  this.sD.S(localView);
                  int i2 = this.sD.R(localView);
                  if ((i2 != 0) && ((i2 <= 0) || (i1 != n))) {
                    break label480;
                  }
                }
                label474:
                label480:
                do
                {
                  c(paramMotionEvent);
                  break;
                  j = 0;
                  break label389;
                  b(f3, f2 - f4, m);
                } while ((this.sq == 1) || ((j != 0) && (m(localView, m))));
                label516:
                i += 1;
              }
              ae(paramMotionEvent.getPointerId(i));
              continue;
              cancel();
            }
          }
        }
      }
    }
    return false;
  }
  
  public final void e(MotionEvent paramMotionEvent)
  {
    int i = 0;
    int j = 0;
    int m = paramMotionEvent.getActionMasked();
    int k = paramMotionEvent.getActionIndex();
    if (m == 0) {
      cancel();
    }
    if (this.nw == null) {
      this.nw = VelocityTracker.obtain();
    }
    this.nw.addMovement(paramMotionEvent);
    float f1;
    float f2;
    switch (m)
    {
    case 4: 
    default: 
    case 0: 
    case 5: 
    case 2: 
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              f1 = paramMotionEvent.getX();
              f2 = paramMotionEvent.getY();
              i = paramMotionEvent.getPointerId(0);
              paramMotionEvent = k((int)f1, (int)f2);
              a(f1, f2, i);
              m(paramMotionEvent, i);
            } while ((this.sv[i] & this.sC) == 0);
            this.sD.cl();
            return;
            i = paramMotionEvent.getPointerId(k);
            f1 = paramMotionEvent.getX(k);
            f2 = paramMotionEvent.getY(k);
            a(f1, f2, i);
            if (this.sq != 0) {
              break;
            }
            m(k((int)f1, (int)f2), i);
          } while ((this.sv[i] & this.sC) == 0);
          this.sD.cl();
          return;
          j = (int)f1;
          k = (int)f2;
        } while (!c(this.sE, j, k));
        m(this.sE, i);
        return;
        if (this.sq != 1) {
          break;
        }
      } while (!ah(this.nv));
      i = paramMotionEvent.findPointerIndex(this.nv);
      f1 = paramMotionEvent.getX(i);
      f2 = paramMotionEvent.getY(i);
      k = (int)(f1 - this.st[this.nv]);
      m = (int)(f2 - this.su[this.nv]);
      j = this.sE.getLeft() + k;
      this.sE.getTop();
      int i1 = this.sE.getLeft();
      int n = this.sE.getTop();
      i = j;
      if (k != 0)
      {
        i = this.sD.k(this.sE, j);
        r.h(this.sE, i - i1);
      }
      if (m != 0)
      {
        j = this.sD.S(this.sE);
        r.g(this.sE, j - n);
      }
      if ((k != 0) || (m != 0)) {
        this.sD.j(this.sE, i);
      }
      c(paramMotionEvent);
      return;
      k = paramMotionEvent.getPointerCount();
      i = j;
      while (i < k)
      {
        j = paramMotionEvent.getPointerId(i);
        if (ah(j))
        {
          f1 = paramMotionEvent.getX(i);
          f2 = paramMotionEvent.getY(i);
          float f3 = f1 - this.sr[j];
          b(f3, f2 - this.ss[j], j);
          if (this.sq == 1) {
            break;
          }
          View localView = k((int)f1, (int)f2);
          if ((g(localView, f3)) && (m(localView, j))) {
            break;
          }
        }
        i += 1;
      }
      c(paramMotionEvent);
      return;
    case 6: 
      j = paramMotionEvent.getPointerId(k);
      if ((this.sq == 1) && (j == this.nv))
      {
        k = paramMotionEvent.getPointerCount();
        if (i >= k) {
          break label766;
        }
        m = paramMotionEvent.getPointerId(i);
        if (m == this.nv) {
          break label722;
        }
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        if ((k((int)f1, (int)f2) != this.sE) || (!m(this.sE, m))) {
          break label722;
        }
      }
      break;
    }
    label722:
    label766:
    for (i = this.nv;; i = -1)
    {
      if (i == -1) {
        cG();
      }
      ae(j);
      return;
      i += 1;
      break;
      if (this.sq == 1) {
        cG();
      }
      cancel();
      return;
      if (this.sq == 1) {
        q(0.0F);
      }
      cancel();
      return;
    }
  }
  
  public final int getTouchSlop()
  {
    return this.mi;
  }
  
  public final boolean j(int paramInt1, int paramInt2)
  {
    if (!this.sF) {
      throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }
    return c(paramInt1, paramInt2, (int)this.nw.getXVelocity(this.nv), (int)this.nw.getYVelocity(this.nv));
  }
  
  public final View k(int paramInt1, int paramInt2)
  {
    int i = this.sG.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.sG.getChildAt(i);
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom())) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  public final void l(View paramView, int paramInt)
  {
    if (paramView.getParent() != this.sG) {
      throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.sG + ")");
    }
    this.sE = paramView;
    this.nv = paramInt;
    this.sD.Q(paramView);
    ag(1);
  }
  
  public final void p(float paramFloat)
  {
    this.sA = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.ad
 * JD-Core Version:    0.7.0.1
 */