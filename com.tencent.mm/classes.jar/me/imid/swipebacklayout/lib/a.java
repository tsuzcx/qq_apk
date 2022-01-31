package me.imid.swipebacklayout.lib;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class a
{
  private static final Interpolator sInterpolator;
  int[] CLe;
  final a.a CLf;
  private float[] MA;
  private int[] MD;
  private int[] MF;
  private int MG;
  float MH;
  float MI;
  int MJ;
  int MK;
  View MM;
  boolean MN;
  final ViewGroup MO;
  final Runnable MP;
  int Mw;
  float[] Mx;
  float[] My;
  private float[] Mz;
  p jtz;
  int mActivePointerId;
  private int mTouchSlop;
  VelocityTracker mVelocityTracker;
  
  static
  {
    AppMethodBeat.i(91249);
    sInterpolator = new Interpolator()
    {
      public final float getInterpolation(float paramAnonymousFloat)
      {
        paramAnonymousFloat -= 1.0F;
        return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
      }
    };
    AppMethodBeat.o(91249);
  }
  
  private a(Context paramContext, ViewGroup paramViewGroup, a.a parama)
  {
    AppMethodBeat.i(91223);
    this.mActivePointerId = -1;
    this.MP = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(91221);
        a.this.aL(0);
        AppMethodBeat.o(91221);
      }
    };
    if (paramViewGroup == null)
    {
      paramContext = new IllegalArgumentException("Parent view may not be null");
      AppMethodBeat.o(91223);
      throw paramContext;
    }
    if (parama == null)
    {
      paramContext = new IllegalArgumentException("Callback may not be null");
      AppMethodBeat.o(91223);
      throw paramContext;
    }
    this.MO = paramViewGroup;
    this.CLf = parama;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.MJ = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.mTouchSlop = paramViewGroup.getScaledTouchSlop();
    this.MH = paramViewGroup.getScaledMaximumFlingVelocity();
    this.MI = paramViewGroup.getScaledMinimumFlingVelocity();
    this.jtz = p.a(paramContext, sInterpolator);
    AppMethodBeat.o(91223);
  }
  
  private void Wn(int paramInt)
  {
    AppMethodBeat.i(91232);
    if ((this.Mx == null) || (this.Mx.length <= paramInt))
    {
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      float[] arrayOfFloat4 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.Mx != null)
      {
        System.arraycopy(this.Mx, 0, arrayOfFloat1, 0, this.Mx.length);
        System.arraycopy(this.My, 0, arrayOfFloat2, 0, this.My.length);
        System.arraycopy(this.Mz, 0, arrayOfFloat3, 0, this.Mz.length);
        System.arraycopy(this.MA, 0, arrayOfFloat4, 0, this.MA.length);
        System.arraycopy(this.CLe, 0, arrayOfInt1, 0, this.CLe.length);
        System.arraycopy(this.MD, 0, arrayOfInt2, 0, this.MD.length);
        System.arraycopy(this.MF, 0, arrayOfInt3, 0, this.MF.length);
      }
      this.Mx = arrayOfFloat1;
      this.My = arrayOfFloat2;
      this.Mz = arrayOfFloat3;
      this.MA = arrayOfFloat4;
      this.CLe = arrayOfInt1;
      this.MD = arrayOfInt2;
      this.MF = arrayOfInt3;
    }
    AppMethodBeat.o(91232);
  }
  
  public static a a(ViewGroup paramViewGroup, a.a parama)
  {
    AppMethodBeat.i(91222);
    paramViewGroup = new a(paramViewGroup.getContext(), paramViewGroup, parama);
    AppMethodBeat.o(91222);
    return paramViewGroup;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91239);
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    if (((this.CLe[paramInt1] & paramInt2) != paramInt2) || ((this.MK & paramInt2) == 0) || ((this.MF[paramInt1] & paramInt2) == paramInt2) || ((this.MD[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= this.mTouchSlop) && (paramFloat2 <= this.mTouchSlop)))
    {
      AppMethodBeat.o(91239);
      return false;
    }
    if (((this.MD[paramInt1] & paramInt2) == 0) && (paramFloat1 > this.mTouchSlop))
    {
      AppMethodBeat.o(91239);
      return true;
    }
    AppMethodBeat.o(91239);
    return false;
  }
  
  private boolean aK(int paramInt)
  {
    return (this.MG & 1 << paramInt) != 0;
  }
  
  private static float distanceInfluenceForSnapDuration(float paramFloat)
  {
    AppMethodBeat.i(91229);
    paramFloat = (float)Math.sin((float)((paramFloat - 0.5F) * 0.47123891676382D));
    AppMethodBeat.o(91229);
    return paramFloat;
  }
  
  private static float e(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(91228);
    float f = Math.abs(paramFloat1);
    if (f < paramFloat2)
    {
      AppMethodBeat.o(91228);
      return 0.0F;
    }
    if (f > paramFloat3)
    {
      if (paramFloat1 > 0.0F)
      {
        AppMethodBeat.o(91228);
        return paramFloat3;
      }
      paramFloat1 = -paramFloat3;
      AppMethodBeat.o(91228);
      return paramFloat1;
    }
    AppMethodBeat.o(91228);
    return paramFloat1;
  }
  
  private void eq()
  {
    AppMethodBeat.i(91231);
    if (this.Mx == null)
    {
      AppMethodBeat.o(91231);
      return;
    }
    Arrays.fill(this.Mx, 0.0F);
    Arrays.fill(this.My, 0.0F);
    Arrays.fill(this.Mz, 0.0F);
    Arrays.fill(this.MA, 0.0F);
    Arrays.fill(this.CLe, 0);
    Arrays.fill(this.MD, 0);
    Arrays.fill(this.MF, 0);
    this.MG = 0;
    AppMethodBeat.o(91231);
  }
  
  private void er()
  {
    AppMethodBeat.i(91243);
    this.mVelocityTracker.computeCurrentVelocity(1000, this.MH);
    u(e(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.MI, this.MH), e(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.MI, this.MH));
    AppMethodBeat.o(91243);
  }
  
  static int h(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(91227);
    int i = Math.abs(paramInt1);
    if (i < paramInt2)
    {
      AppMethodBeat.o(91227);
      return 0;
    }
    if (i > paramInt3)
    {
      if (paramInt1 > 0)
      {
        AppMethodBeat.o(91227);
        return paramInt3;
      }
      paramInt1 = -paramInt3;
      AppMethodBeat.o(91227);
      return paramInt1;
    }
    AppMethodBeat.o(91227);
    return paramInt1;
  }
  
  private void i(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(91244);
    int i = this.MM.getLeft();
    int j = this.MM.getTop();
    if (paramInt3 != 0)
    {
      paramInt1 = this.CLf.d(this.MM, paramInt1);
      this.MM.offsetLeftAndRight(paramInt1 - i);
    }
    for (;;)
    {
      if (paramInt4 != 0)
      {
        paramInt2 = this.CLf.c(this.MM, paramInt2);
        this.MM.offsetTopAndBottom(paramInt2 - j);
      }
      for (;;)
      {
        if ((paramInt3 != 0) || (paramInt4 != 0)) {
          this.CLf.o(this.MM, paramInt1, paramInt2, paramInt1 - i, paramInt2 - j);
        }
        AppMethodBeat.o(91244);
        return;
      }
    }
  }
  
  private int iN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91248);
    int i = 0;
    if (paramInt1 < this.MO.getLeft() + this.MJ) {
      i = 1;
    }
    if (paramInt2 < this.MO.getTop() + this.MJ) {
      i = 4;
    }
    if (paramInt1 > this.MO.getRight() - this.MJ) {
      i = 2;
    }
    if (paramInt2 > this.MO.getBottom() - this.MJ) {
      i = 8;
    }
    AppMethodBeat.o(91248);
    return i;
  }
  
  private static boolean j(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91246);
    if (paramView == null)
    {
      AppMethodBeat.o(91246);
      return false;
    }
    if ((paramInt1 >= paramView.getLeft()) && (paramInt1 < paramView.getRight()) && (paramInt2 >= paramView.getTop()) && (paramInt2 < paramView.getBottom()))
    {
      AppMethodBeat.o(91246);
      return true;
    }
    AppMethodBeat.o(91246);
    return false;
  }
  
  private void u(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(91230);
    this.MN = true;
    this.CLf.a(this.MM, paramFloat1, paramFloat2);
    this.MN = false;
    if (this.Mw == 1) {
      aL(0);
    }
    AppMethodBeat.o(91230);
  }
  
  private void w(View paramView, int paramInt)
  {
    AppMethodBeat.i(91224);
    if (paramView.getParent() != this.MO)
    {
      paramView = new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.MO + ")");
      AppMethodBeat.o(91224);
      throw paramView;
    }
    this.MM = paramView;
    this.mActivePointerId = paramInt;
    aL(1);
    AppMethodBeat.o(91224);
  }
  
  private boolean z(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91245);
    boolean bool = j(this.MM, paramInt1, paramInt2);
    AppMethodBeat.o(91245);
    return bool;
  }
  
  public final View A(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91247);
    int i = this.MO.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.MO.getChildAt(i);
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom()))
      {
        AppMethodBeat.o(91247);
        return localView;
      }
      i -= 1;
    }
    AppMethodBeat.o(91247);
    return null;
  }
  
  final void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(91233);
    Wn(paramInt);
    float[] arrayOfFloat = this.Mx;
    this.Mz[paramInt] = paramFloat1;
    arrayOfFloat[paramInt] = paramFloat1;
    arrayOfFloat = this.My;
    this.MA[paramInt] = paramFloat2;
    arrayOfFloat[paramInt] = paramFloat2;
    this.CLe[paramInt] = iN((int)paramFloat1, (int)paramFloat2);
    this.MG |= 1 << paramInt;
    AppMethodBeat.o(91233);
  }
  
  final void aJ(int paramInt)
  {
    if (this.Mx == null) {
      return;
    }
    this.Mx[paramInt] = 0.0F;
    this.My[paramInt] = 0.0F;
    this.Mz[paramInt] = 0.0F;
    this.MA[paramInt] = 0.0F;
    this.CLe[paramInt] = 0;
    this.MD[paramInt] = 0;
    this.MF[paramInt] = 0;
    this.MG &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  public final void aL(int paramInt)
  {
    AppMethodBeat.i(91235);
    if (this.Mw != paramInt)
    {
      this.Mw = paramInt;
      this.CLf.w(paramInt);
      if (paramInt == 0) {
        this.MM = null;
      }
    }
    AppMethodBeat.o(91235);
  }
  
  final void b(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(91238);
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
      AppMethodBeat.o(91238);
      return;
      j = 0;
    }
  }
  
  final boolean c(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(91240);
    if (paramView == null)
    {
      AppMethodBeat.o(91240);
      return false;
    }
    int i;
    int j;
    if (this.CLf.dNq() > 0)
    {
      i = 1;
      if (this.CLf.aY() <= 0) {
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
          AppMethodBeat.o(91240);
          return true;
          i = 0;
          break;
          label89:
          j = 0;
          continue;
        }
        AppMethodBeat.o(91240);
        return false;
      }
    }
    if (i != 0)
    {
      if (Math.abs(paramFloat1) > this.mTouchSlop)
      {
        AppMethodBeat.o(91240);
        return true;
      }
      AppMethodBeat.o(91240);
      return false;
    }
    if (j != 0)
    {
      if (Math.abs(paramFloat2) > this.mTouchSlop)
      {
        AppMethodBeat.o(91240);
        return true;
      }
      AppMethodBeat.o(91240);
      return false;
    }
    AppMethodBeat.o(91240);
    return false;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(91225);
    this.mActivePointerId = -1;
    eq();
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
    AppMethodBeat.o(91225);
  }
  
  final void e(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(91234);
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
    AppMethodBeat.o(91234);
  }
  
  final int g(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(91226);
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(91226);
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
      AppMethodBeat.o(91226);
      return paramInt1;
    }
  }
  
  public final void g(MotionEvent paramMotionEvent)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(91237);
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
          AppMethodBeat.o(91237);
          return;
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          i = paramMotionEvent.getPointerId(0);
          paramMotionEvent = A((int)f1, (int)f2);
          a(f1, f2, i);
          x(paramMotionEvent, i);
        } while ((this.CLe[i] & this.MK) == 0);
        AppMethodBeat.o(91237);
        return;
        i = paramMotionEvent.getPointerId(k);
        f1 = paramMotionEvent.getX(k);
        f2 = paramMotionEvent.getY(k);
        a(f1, f2, i);
        if (this.Mw == 0)
        {
          x(A((int)f1, (int)f2), i);
          AppMethodBeat.o(91237);
          return;
        }
      } while (!z((int)f1, (int)f2));
      x(this.MM, i);
      AppMethodBeat.o(91237);
      return;
    case 2: 
      if (this.Mw == 1)
      {
        i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        i = (int)(f1 - this.Mz[this.mActivePointerId]);
        j = (int)(f2 - this.MA[this.mActivePointerId]);
        i(this.MM.getLeft() + i, this.MM.getTop() + j, i, j);
        e(paramMotionEvent);
        AppMethodBeat.o(91237);
        return;
      }
      k = paramMotionEvent.getPointerCount();
      i = j;
      while (i < k)
      {
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        float f3 = f1 - this.Mx[j];
        float f4 = f2 - this.My[j];
        b(f3, f4, j);
        if (this.Mw == 1) {
          break;
        }
        View localView = A((int)f1, (int)f2);
        if ((c(localView, f3, f4)) && (x(localView, j))) {
          break;
        }
        i += 1;
      }
      e(paramMotionEvent);
      AppMethodBeat.o(91237);
      return;
    case 6: 
      j = paramMotionEvent.getPointerId(k);
      if ((this.Mw == 1) && (j == this.mActivePointerId))
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
        if ((A((int)f1, (int)f2) != this.MM) || (!x(this.MM, m))) {
          break label619;
        }
      }
      break;
    }
    label672:
    for (i = this.mActivePointerId;; i = -1)
    {
      if (i == -1) {
        er();
      }
      aJ(j);
      AppMethodBeat.o(91237);
      return;
      label619:
      i += 1;
      break label524;
      if (this.Mw == 1) {
        er();
      }
      cancel();
      AppMethodBeat.o(91237);
      return;
      if (this.Mw == 1) {
        u(0.0F, 0.0F);
      }
      cancel();
      break;
    }
  }
  
  public final boolean iL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91241);
    if (!aK(paramInt2))
    {
      AppMethodBeat.o(91241);
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
      f1 = this.Mz[paramInt2] - this.Mx[paramInt2];
      f2 = this.MA[paramInt2] - this.My[paramInt2];
      if ((i == 0) || (paramInt1 == 0)) {
        break label129;
      }
      if (f1 * f1 + f2 * f2 <= this.mTouchSlop * this.mTouchSlop) {
        break label121;
      }
      AppMethodBeat.o(91241);
      return true;
      i = 0;
      break;
    }
    label121:
    AppMethodBeat.o(91241);
    return false;
    label129:
    if (i != 0)
    {
      if (Math.abs(f1) > this.mTouchSlop)
      {
        AppMethodBeat.o(91241);
        return true;
      }
      AppMethodBeat.o(91241);
      return false;
    }
    if (paramInt1 != 0)
    {
      if (Math.abs(f2) > this.mTouchSlop)
      {
        AppMethodBeat.o(91241);
        return true;
      }
      AppMethodBeat.o(91241);
      return false;
    }
    AppMethodBeat.o(91241);
    return false;
  }
  
  public final boolean iM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91242);
    if ((aK(paramInt2)) && ((this.CLe[paramInt2] & paramInt1) != 0))
    {
      AppMethodBeat.o(91242);
      return true;
    }
    AppMethodBeat.o(91242);
    return false;
  }
  
  final boolean x(View paramView, int paramInt)
  {
    AppMethodBeat.i(91236);
    if ((paramView == this.MM) && (this.mActivePointerId == paramInt))
    {
      AppMethodBeat.o(91236);
      return true;
    }
    if ((paramView != null) && (this.CLf.QM(paramInt)))
    {
      this.mActivePointerId = paramInt;
      w(paramView, paramInt);
      AppMethodBeat.o(91236);
      return true;
    }
    AppMethodBeat.o(91236);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     me.imid.swipebacklayout.lib.a
 * JD-Core Version:    0.7.0.1
 */