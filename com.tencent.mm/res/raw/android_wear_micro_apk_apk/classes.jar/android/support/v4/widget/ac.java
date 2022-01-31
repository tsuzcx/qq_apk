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

public final class ac
{
  private static final Interpolator kY = new Interpolator()
  {
    public final float getInterpolation(float paramAnonymousFloat)
    {
      paramAnonymousFloat -= 1.0F;
      return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
    }
  };
  private int kl;
  private VelocityTracker lA;
  private int lz = -1;
  private OverScroller oY;
  private int qC;
  private float[] qD;
  private float[] qE;
  private float[] qF;
  private float[] qG;
  private int[] qH;
  private int[] qI;
  private int[] qJ;
  private int qK;
  private float qL;
  private float qM;
  private int qN;
  private int qO;
  private final ad qP;
  private View qQ;
  private boolean qR;
  private final ViewGroup qS;
  private final Runnable qT = new Runnable()
  {
    public final void run()
    {
      ac.this.V(0);
    }
  };
  
  private ac(Context paramContext, ViewGroup paramViewGroup, ad paramad)
  {
    if (paramViewGroup == null) {
      throw new IllegalArgumentException("Parent view may not be null");
    }
    if (paramad == null) {
      throw new IllegalArgumentException("Callback may not be null");
    }
    this.qS = paramViewGroup;
    this.qP = paramad;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.qN = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.kl = paramViewGroup.getScaledTouchSlop();
    this.qL = paramViewGroup.getScaledMaximumFlingVelocity();
    this.qM = paramViewGroup.getScaledMinimumFlingVelocity();
    this.oY = new OverScroller(paramContext, kY);
  }
  
  private void T(int paramInt)
  {
    if ((this.qD == null) || (!U(paramInt))) {
      return;
    }
    this.qD[paramInt] = 0.0F;
    this.qE[paramInt] = 0.0F;
    this.qF[paramInt] = 0.0F;
    this.qG[paramInt] = 0.0F;
    this.qH[paramInt] = 0;
    this.qI[paramInt] = 0;
    this.qJ[paramInt] = 0;
    this.qK &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  private boolean U(int paramInt)
  {
    return (this.qK & 1 << paramInt) != 0;
  }
  
  private boolean W(int paramInt)
  {
    if (!U(paramInt))
    {
      Log.e("ViewDragHelper", "Ignoring pointerId=" + paramInt + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
      return false;
    }
    return true;
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
  
  public static ac a(ViewGroup paramViewGroup, float paramFloat, ad paramad)
  {
    paramViewGroup = new ac(paramViewGroup.getContext(), paramViewGroup, paramad);
    paramViewGroup.kl = ((int)(paramViewGroup.kl * (1.0F / paramFloat)));
    return paramViewGroup;
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 0;
    if ((this.qD == null) || (this.qD.length <= paramInt))
    {
      localObject = new float[paramInt + 1];
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.qD != null)
      {
        System.arraycopy(this.qD, 0, localObject, 0, this.qD.length);
        System.arraycopy(this.qE, 0, arrayOfFloat1, 0, this.qE.length);
        System.arraycopy(this.qF, 0, arrayOfFloat2, 0, this.qF.length);
        System.arraycopy(this.qG, 0, arrayOfFloat3, 0, this.qG.length);
        System.arraycopy(this.qH, 0, arrayOfInt1, 0, this.qH.length);
        System.arraycopy(this.qI, 0, arrayOfInt2, 0, this.qI.length);
        System.arraycopy(this.qJ, 0, arrayOfInt3, 0, this.qJ.length);
      }
      this.qD = ((float[])localObject);
      this.qE = arrayOfFloat1;
      this.qF = arrayOfFloat2;
      this.qG = arrayOfFloat3;
      this.qH = arrayOfInt1;
      this.qI = arrayOfInt2;
      this.qJ = arrayOfInt3;
    }
    Object localObject = this.qD;
    this.qF[paramInt] = paramFloat1;
    localObject[paramInt] = paramFloat1;
    localObject = this.qE;
    this.qG[paramInt] = paramFloat2;
    localObject[paramInt] = paramFloat2;
    localObject = this.qH;
    int m = (int)paramFloat1;
    int k = (int)paramFloat2;
    if (m < this.qS.getLeft() + this.qN) {
      j = 1;
    }
    int i = j;
    if (k < this.qS.getTop() + this.qN) {
      i = j | 0x4;
    }
    j = i;
    if (m > this.qS.getRight() - this.qN) {
      j = i | 0x2;
    }
    i = j;
    if (k > this.qS.getBottom() - this.qN) {
      i = j | 0x8;
    }
    localObject[paramInt] = i;
    this.qK |= 1 << paramInt;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    if (((this.qH[paramInt1] & paramInt2) != paramInt2) || ((this.qO & paramInt2) == 0) || ((this.qJ[paramInt1] & paramInt2) == paramInt2) || ((this.qI[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= this.kl) && (paramFloat2 <= this.kl))) {}
    while (((this.qI[paramInt1] & paramInt2) != 0) || (paramFloat1 <= this.kl)) {
      return false;
    }
    return true;
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
        int[] arrayOfInt = this.qI;
        arrayOfInt[paramInt] |= i;
        this.qP.e(i, paramInt);
      }
      return;
      j = 0;
    }
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    while (i < j)
    {
      int k = paramMotionEvent.getPointerId(i);
      if (W(k))
      {
        float f1 = paramMotionEvent.getX(i);
        float f2 = paramMotionEvent.getY(i);
        this.qF[k] = f1;
        this.qG[k] = f2;
      }
      i += 1;
    }
  }
  
  private boolean c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = this.qQ.getLeft();
    int j = this.qQ.getTop();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.oY.abortAnimation();
      V(0);
      return false;
    }
    View localView = this.qQ;
    paramInt3 = e(paramInt3, (int)this.qM, (int)this.qL);
    paramInt4 = e(paramInt4, (int)this.qM, (int)this.qL);
    int k = Math.abs(paramInt1);
    int m = Math.abs(paramInt2);
    int n = Math.abs(paramInt3);
    int i1 = Math.abs(paramInt4);
    int i2 = n + i1;
    int i3 = k + m;
    float f1;
    if (paramInt3 != 0)
    {
      f1 = n / i2;
      if (paramInt4 == 0) {
        break label231;
      }
    }
    label231:
    for (float f2 = i1 / i2;; f2 = m / i3)
    {
      paramInt3 = d(paramInt1, paramInt3, this.qP.L(localView));
      paramInt4 = d(paramInt2, paramInt4, 0);
      float f3 = paramInt3;
      paramInt3 = (int)(f2 * paramInt4 + f1 * f3);
      this.oY.startScroll(i, j, paramInt1, paramInt2, paramInt3);
      V(2);
      return true;
      f1 = k / i3;
      break;
    }
  }
  
  public static boolean c(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {}
    while ((paramInt1 < paramView.getLeft()) || (paramInt1 >= paramView.getRight()) || (paramInt2 < paramView.getTop()) || (paramInt2 >= paramView.getBottom())) {
      return false;
    }
    return true;
  }
  
  private void cz()
  {
    this.lA.computeCurrentVelocity(1000, this.qL);
    float f = a(this.lA.getXVelocity(this.lz), this.qM, this.qL);
    a(this.lA.getYVelocity(this.lz), this.qM, this.qL);
    p(f);
  }
  
  private int d(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return 0;
    }
    int i = this.qS.getWidth();
    int j = i / 2;
    float f3 = Math.min(1.0F, Math.abs(paramInt1) / i);
    float f1 = j;
    float f2 = j;
    f3 = (float)Math.sin((f3 - 0.5F) * 0.4712389F);
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
      if (this.qP.L(paramView) > 0) {}
      for (int i = 1; (i != 0) && (Math.abs(paramFloat) > this.kl); i = 0) {
        return true;
      }
    }
  }
  
  private boolean j(View paramView, int paramInt)
  {
    if ((paramView == this.qQ) && (this.lz == paramInt)) {
      return true;
    }
    if ((paramView != null) && (this.qP.J(paramView)))
    {
      this.lz = paramInt;
      i(paramView, paramInt);
      return true;
    }
    return false;
  }
  
  private void p(float paramFloat)
  {
    this.qR = true;
    this.qP.f(this.qQ, paramFloat);
    this.qR = false;
    if (this.qC == 1) {
      V(0);
    }
  }
  
  public final void S(int paramInt)
  {
    this.qO = paramInt;
  }
  
  final void V(int paramInt)
  {
    this.qS.removeCallbacks(this.qT);
    if (this.qC != paramInt)
    {
      this.qC = paramInt;
      this.qP.K(paramInt);
      if (this.qC == 0) {
        this.qQ = null;
      }
    }
  }
  
  public final void abort()
  {
    cancel();
    if (this.qC == 2)
    {
      this.oY.getCurrX();
      this.oY.getCurrY();
      this.oY.abortAnimation();
      int i = this.oY.getCurrX();
      this.oY.getCurrY();
      this.qP.g(this.qQ, i);
    }
    V(0);
  }
  
  public final boolean b(View paramView, int paramInt1, int paramInt2)
  {
    this.qQ = paramView;
    this.lz = -1;
    boolean bool = c(paramInt1, paramInt2, 0, 0);
    if ((!bool) && (this.qC == 0) && (this.qQ != null)) {
      this.qQ = null;
    }
    return bool;
  }
  
  public final boolean c(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getActionMasked();
    int i = paramMotionEvent.getActionIndex();
    if (j == 0) {
      cancel();
    }
    if (this.lA == null) {
      this.lA = VelocityTracker.obtain();
    }
    this.lA.addMovement(paramMotionEvent);
    switch (j)
    {
    }
    while (this.qC == 1)
    {
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      i = paramMotionEvent.getPointerId(0);
      a(f1, f2, i);
      paramMotionEvent = j((int)f1, (int)f2);
      if ((paramMotionEvent == this.qQ) && (this.qC == 2)) {
        j(paramMotionEvent, i);
      }
      if ((this.qH[i] & this.qO) != 0)
      {
        this.qP.cg();
        continue;
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        a(f1, f2, j);
        if (this.qC == 0)
        {
          if ((this.qH[j] & this.qO) != 0) {
            this.qP.cg();
          }
        }
        else if (this.qC == 2)
        {
          paramMotionEvent = j((int)f1, (int)f2);
          if (paramMotionEvent == this.qQ)
          {
            j(paramMotionEvent, j);
            continue;
            if ((this.qD != null) && (this.qE != null))
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
                  if (!W(m)) {
                    break label516;
                  }
                  f1 = paramMotionEvent.getX(i);
                  f2 = paramMotionEvent.getY(i);
                  f3 = f1 - this.qD[m];
                  f4 = this.qE[m];
                  localView = j((int)f1, (int)f2);
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
                  i1 = this.qP.h(localView, i1 + n);
                  localView.getTop();
                  this.qP.M(localView);
                  int i2 = this.qP.L(localView);
                  if ((i2 != 0) && ((i2 <= 0) || (i1 != n))) {
                    break label480;
                  }
                }
                label474:
                label480:
                do
                {
                  b(paramMotionEvent);
                  break;
                  j = 0;
                  break label389;
                  b(f3, f2 - f4, m);
                } while ((this.qC == 1) || ((j != 0) && (j(localView, m))));
                label516:
                i += 1;
              }
              T(paramMotionEvent.getPointerId(i));
              continue;
              cancel();
            }
          }
        }
      }
    }
    return false;
  }
  
  public final void cancel()
  {
    this.lz = -1;
    if (this.qD != null)
    {
      Arrays.fill(this.qD, 0.0F);
      Arrays.fill(this.qE, 0.0F);
      Arrays.fill(this.qF, 0.0F);
      Arrays.fill(this.qG, 0.0F);
      Arrays.fill(this.qH, 0);
      Arrays.fill(this.qI, 0);
      Arrays.fill(this.qJ, 0);
      this.qK = 0;
    }
    if (this.lA != null)
    {
      this.lA.recycle();
      this.lA = null;
    }
  }
  
  public final int cu()
  {
    return this.qC;
  }
  
  public final int cv()
  {
    return this.qN;
  }
  
  public final View cw()
  {
    return this.qQ;
  }
  
  public final boolean cx()
  {
    boolean bool2 = false;
    if (this.qC == 2)
    {
      boolean bool3 = this.oY.computeScrollOffset();
      int i = this.oY.getCurrX();
      int j = this.oY.getCurrY();
      int k = i - this.qQ.getLeft();
      int m = j - this.qQ.getTop();
      if (k != 0) {
        r.e(this.qQ, k);
      }
      if (m != 0) {
        r.d(this.qQ, m);
      }
      if ((k != 0) || (m != 0)) {
        this.qP.g(this.qQ, i);
      }
      bool1 = bool3;
      if (bool3)
      {
        bool1 = bool3;
        if (i == this.oY.getFinalX())
        {
          bool1 = bool3;
          if (j == this.oY.getFinalY())
          {
            this.oY.abortAnimation();
            bool1 = false;
          }
        }
      }
      if (!bool1) {
        this.qS.post(this.qT);
      }
    }
    boolean bool1 = bool2;
    if (this.qC == 2) {
      bool1 = true;
    }
    return bool1;
  }
  
  public final boolean cy()
  {
    int k = this.qD.length;
    int j = 0;
    while (j < k)
    {
      int i;
      if (U(j))
      {
        float f1 = this.qF[j] - this.qD[j];
        float f2 = this.qG[j] - this.qE[j];
        if (f1 * f1 + f2 * f2 > this.kl * this.kl) {
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
  
  public final void d(MotionEvent paramMotionEvent)
  {
    int i = 0;
    int j = 0;
    int m = paramMotionEvent.getActionMasked();
    int k = paramMotionEvent.getActionIndex();
    if (m == 0) {
      cancel();
    }
    if (this.lA == null) {
      this.lA = VelocityTracker.obtain();
    }
    this.lA.addMovement(paramMotionEvent);
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
              paramMotionEvent = j((int)f1, (int)f2);
              a(f1, f2, i);
              j(paramMotionEvent, i);
            } while ((this.qH[i] & this.qO) == 0);
            this.qP.cg();
            return;
            i = paramMotionEvent.getPointerId(k);
            f1 = paramMotionEvent.getX(k);
            f2 = paramMotionEvent.getY(k);
            a(f1, f2, i);
            if (this.qC != 0) {
              break;
            }
            j(j((int)f1, (int)f2), i);
          } while ((this.qH[i] & this.qO) == 0);
          this.qP.cg();
          return;
          j = (int)f1;
          k = (int)f2;
        } while (!c(this.qQ, j, k));
        j(this.qQ, i);
        return;
        if (this.qC != 1) {
          break;
        }
      } while (!W(this.lz));
      i = paramMotionEvent.findPointerIndex(this.lz);
      f1 = paramMotionEvent.getX(i);
      f2 = paramMotionEvent.getY(i);
      k = (int)(f1 - this.qF[this.lz]);
      m = (int)(f2 - this.qG[this.lz]);
      j = this.qQ.getLeft() + k;
      this.qQ.getTop();
      int i1 = this.qQ.getLeft();
      int n = this.qQ.getTop();
      i = j;
      if (k != 0)
      {
        i = this.qP.h(this.qQ, j);
        r.e(this.qQ, i - i1);
      }
      if (m != 0)
      {
        j = this.qP.M(this.qQ);
        r.d(this.qQ, j - n);
      }
      if ((k != 0) || (m != 0)) {
        this.qP.g(this.qQ, i);
      }
      b(paramMotionEvent);
      return;
      k = paramMotionEvent.getPointerCount();
      i = j;
      while (i < k)
      {
        j = paramMotionEvent.getPointerId(i);
        if (W(j))
        {
          f1 = paramMotionEvent.getX(i);
          f2 = paramMotionEvent.getY(i);
          float f3 = f1 - this.qD[j];
          b(f3, f2 - this.qE[j], j);
          if (this.qC == 1) {
            break;
          }
          View localView = j((int)f1, (int)f2);
          if ((g(localView, f3)) && (j(localView, j))) {
            break;
          }
        }
        i += 1;
      }
      b(paramMotionEvent);
      return;
    case 6: 
      j = paramMotionEvent.getPointerId(k);
      if ((this.qC == 1) && (j == this.lz))
      {
        k = paramMotionEvent.getPointerCount();
        if (i >= k) {
          break label766;
        }
        m = paramMotionEvent.getPointerId(i);
        if (m == this.lz) {
          break label722;
        }
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        if ((j((int)f1, (int)f2) != this.qQ) || (!j(this.qQ, m))) {
          break label722;
        }
      }
      break;
    }
    label722:
    label766:
    for (i = this.lz;; i = -1)
    {
      if (i == -1) {
        cz();
      }
      T(j);
      return;
      i += 1;
      break;
      if (this.qC == 1) {
        cz();
      }
      cancel();
      return;
      if (this.qC == 1) {
        p(0.0F);
      }
      cancel();
      return;
    }
  }
  
  public final int getTouchSlop()
  {
    return this.kl;
  }
  
  public final void i(View paramView, int paramInt)
  {
    if (paramView.getParent() != this.qS) {
      throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.qS + ")");
    }
    this.qQ = paramView;
    this.lz = paramInt;
    this.qP.K(paramView);
    V(1);
  }
  
  public final boolean i(int paramInt1, int paramInt2)
  {
    if (!this.qR) {
      throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }
    return c(paramInt1, paramInt2, (int)this.lA.getXVelocity(this.lz), (int)this.lA.getYVelocity(this.lz));
  }
  
  public final View j(int paramInt1, int paramInt2)
  {
    int i = this.qS.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.qS.getChildAt(i);
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom())) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  public final void o(float paramFloat)
  {
    this.qM = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.ac
 * JD-Core Version:    0.7.0.1
 */