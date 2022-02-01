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

public final class b
{
  private static final Interpolator sInterpolator;
  int[] Oma;
  final a Omb;
  final ViewGroup WA;
  final Runnable WB;
  int Wk;
  float[] Wl;
  float[] Wm;
  private float[] Wn;
  private float[] Wo;
  private int[] Wq;
  private int[] Wr;
  private int Ws;
  float Wt;
  float Wu;
  int Wv;
  int Ww;
  View Wy;
  boolean Wz;
  int mActivePointerId;
  private int mTouchSlop;
  VelocityTracker mVelocityTracker;
  p nrj;
  
  static
  {
    AppMethodBeat.i(140924);
    sInterpolator = new b.1();
    AppMethodBeat.o(140924);
  }
  
  private b(Context paramContext, ViewGroup paramViewGroup, a parama)
  {
    AppMethodBeat.i(140898);
    this.mActivePointerId = -1;
    this.WB = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140896);
        b.this.be(0);
        AppMethodBeat.o(140896);
      }
    };
    if (paramViewGroup == null)
    {
      paramContext = new IllegalArgumentException("Parent view may not be null");
      AppMethodBeat.o(140898);
      throw paramContext;
    }
    if (parama == null)
    {
      paramContext = new IllegalArgumentException("Callback may not be null");
      AppMethodBeat.o(140898);
      throw paramContext;
    }
    this.WA = paramViewGroup;
    this.Omb = parama;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.Wv = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.mTouchSlop = paramViewGroup.getScaledTouchSlop();
    this.Wt = paramViewGroup.getScaledMaximumFlingVelocity();
    this.Wu = paramViewGroup.getScaledMinimumFlingVelocity();
    this.nrj = p.a(paramContext, sInterpolator);
    AppMethodBeat.o(140898);
  }
  
  private boolean I(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140920);
    boolean bool = i(this.Wy, paramInt1, paramInt2);
    AppMethodBeat.o(140920);
    return bool;
  }
  
  public static b a(ViewGroup paramViewGroup, a parama)
  {
    AppMethodBeat.i(140897);
    paramViewGroup = new b(paramViewGroup.getContext(), paramViewGroup, parama);
    AppMethodBeat.o(140897);
    return paramViewGroup;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140914);
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    if (((this.Oma[paramInt1] & paramInt2) != paramInt2) || ((this.Ww & paramInt2) == 0) || ((this.Wr[paramInt1] & paramInt2) == paramInt2) || ((this.Wq[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= this.mTouchSlop) && (paramFloat2 <= this.mTouchSlop)))
    {
      AppMethodBeat.o(140914);
      return false;
    }
    if (((this.Wq[paramInt1] & paramInt2) == 0) && (paramFloat1 > this.mTouchSlop))
    {
      AppMethodBeat.o(140914);
      return true;
    }
    AppMethodBeat.o(140914);
    return false;
  }
  
  private void amy(int paramInt)
  {
    AppMethodBeat.i(140907);
    if ((this.Wl == null) || (this.Wl.length <= paramInt))
    {
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      float[] arrayOfFloat4 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.Wl != null)
      {
        System.arraycopy(this.Wl, 0, arrayOfFloat1, 0, this.Wl.length);
        System.arraycopy(this.Wm, 0, arrayOfFloat2, 0, this.Wm.length);
        System.arraycopy(this.Wn, 0, arrayOfFloat3, 0, this.Wn.length);
        System.arraycopy(this.Wo, 0, arrayOfFloat4, 0, this.Wo.length);
        System.arraycopy(this.Oma, 0, arrayOfInt1, 0, this.Oma.length);
        System.arraycopy(this.Wq, 0, arrayOfInt2, 0, this.Wq.length);
        System.arraycopy(this.Wr, 0, arrayOfInt3, 0, this.Wr.length);
      }
      this.Wl = arrayOfFloat1;
      this.Wm = arrayOfFloat2;
      this.Wn = arrayOfFloat3;
      this.Wo = arrayOfFloat4;
      this.Oma = arrayOfInt1;
      this.Wq = arrayOfInt2;
      this.Wr = arrayOfInt3;
    }
    AppMethodBeat.o(140907);
  }
  
  private boolean bd(int paramInt)
  {
    return (this.Ws & 1 << paramInt) != 0;
  }
  
  private static float distanceInfluenceForSnapDuration(float paramFloat)
  {
    AppMethodBeat.i(140904);
    paramFloat = (float)Math.sin((float)((paramFloat - 0.5F) * 0.47123891676382D));
    AppMethodBeat.o(140904);
    return paramFloat;
  }
  
  private static float f(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(140903);
    float f = Math.abs(paramFloat1);
    if (f < paramFloat2)
    {
      AppMethodBeat.o(140903);
      return 0.0F;
    }
    if (f > paramFloat3)
    {
      if (paramFloat1 > 0.0F)
      {
        AppMethodBeat.o(140903);
        return paramFloat3;
      }
      paramFloat1 = -paramFloat3;
      AppMethodBeat.o(140903);
      return paramFloat1;
    }
    AppMethodBeat.o(140903);
    return paramFloat1;
  }
  
  private void gi()
  {
    AppMethodBeat.i(140906);
    if (this.Wl == null)
    {
      AppMethodBeat.o(140906);
      return;
    }
    Arrays.fill(this.Wl, 0.0F);
    Arrays.fill(this.Wm, 0.0F);
    Arrays.fill(this.Wn, 0.0F);
    Arrays.fill(this.Wo, 0.0F);
    Arrays.fill(this.Oma, 0);
    Arrays.fill(this.Wq, 0);
    Arrays.fill(this.Wr, 0);
    this.Ws = 0;
    AppMethodBeat.o(140906);
  }
  
  private void gj()
  {
    AppMethodBeat.i(140918);
    this.mVelocityTracker.computeCurrentVelocity(1000, this.Wt);
    l(f(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.Wu, this.Wt), f(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.Wu, this.Wt));
    AppMethodBeat.o(140918);
  }
  
  static int i(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(140902);
    int i = Math.abs(paramInt1);
    if (i < paramInt2)
    {
      AppMethodBeat.o(140902);
      return 0;
    }
    if (i > paramInt3)
    {
      if (paramInt1 > 0)
      {
        AppMethodBeat.o(140902);
        return paramInt3;
      }
      paramInt1 = -paramInt3;
      AppMethodBeat.o(140902);
      return paramInt1;
    }
    AppMethodBeat.o(140902);
    return paramInt1;
  }
  
  private void i(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(140919);
    int i = this.Wy.getLeft();
    int j = this.Wy.getTop();
    if (paramInt3 != 0)
    {
      paramInt1 = this.Omb.e(this.Wy, paramInt1);
      this.Wy.offsetLeftAndRight(paramInt1 - i);
    }
    for (;;)
    {
      if (paramInt4 != 0)
      {
        paramInt2 = this.Omb.d(this.Wy, paramInt2);
        this.Wy.offsetTopAndBottom(paramInt2 - j);
      }
      for (;;)
      {
        if ((paramInt3 != 0) || (paramInt4 != 0)) {
          this.Omb.o(this.Wy, paramInt1, paramInt2, paramInt1 - i, paramInt2 - j);
        }
        AppMethodBeat.o(140919);
        return;
      }
    }
  }
  
  private static boolean i(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140921);
    if (paramView == null)
    {
      AppMethodBeat.o(140921);
      return false;
    }
    if ((paramInt1 >= paramView.getLeft()) && (paramInt1 < paramView.getRight()) && (paramInt2 >= paramView.getTop()) && (paramInt2 < paramView.getBottom()))
    {
      AppMethodBeat.o(140921);
      return true;
    }
    AppMethodBeat.o(140921);
    return false;
  }
  
  private void l(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(140905);
    this.Wz = true;
    this.Omb.a(this.Wy, paramFloat1, paramFloat2);
    this.Wz = false;
    if (this.Wk == 1) {
      be(0);
    }
    AppMethodBeat.o(140905);
  }
  
  private int lG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140923);
    int i = 0;
    if (paramInt1 < this.WA.getLeft() + this.Wv) {
      i = 1;
    }
    if (paramInt2 < this.WA.getTop() + this.Wv) {
      i = 4;
    }
    if (paramInt1 > this.WA.getRight() - this.Wv) {
      i = 2;
    }
    if (paramInt2 > this.WA.getBottom() - this.Wv) {
      i = 8;
    }
    AppMethodBeat.o(140923);
    return i;
  }
  
  private void y(View paramView, int paramInt)
  {
    AppMethodBeat.i(140899);
    if (paramView.getParent() != this.WA)
    {
      paramView = new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.WA + ")");
      AppMethodBeat.o(140899);
      throw paramView;
    }
    this.Wy = paramView;
    this.mActivePointerId = paramInt;
    be(1);
    AppMethodBeat.o(140899);
  }
  
  public final View J(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140922);
    int i = this.WA.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.WA.getChildAt(i);
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom()))
      {
        AppMethodBeat.o(140922);
        return localView;
      }
      i -= 1;
    }
    AppMethodBeat.o(140922);
    return null;
  }
  
  final void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(140908);
    amy(paramInt);
    float[] arrayOfFloat = this.Wl;
    this.Wn[paramInt] = paramFloat1;
    arrayOfFloat[paramInt] = paramFloat1;
    arrayOfFloat = this.Wm;
    this.Wo[paramInt] = paramFloat2;
    arrayOfFloat[paramInt] = paramFloat2;
    this.Oma[paramInt] = lG((int)paramFloat1, (int)paramFloat2);
    this.Ws |= 1 << paramInt;
    AppMethodBeat.o(140908);
  }
  
  final void b(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(140913);
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
      AppMethodBeat.o(140913);
      return;
      j = 0;
    }
  }
  
  final void bc(int paramInt)
  {
    if (this.Wl == null) {
      return;
    }
    this.Wl[paramInt] = 0.0F;
    this.Wm[paramInt] = 0.0F;
    this.Wn[paramInt] = 0.0F;
    this.Wo[paramInt] = 0.0F;
    this.Oma[paramInt] = 0;
    this.Wq[paramInt] = 0;
    this.Wr[paramInt] = 0;
    this.Ws &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  final void be(int paramInt)
  {
    AppMethodBeat.i(140910);
    if (this.Wk != paramInt)
    {
      this.Wk = paramInt;
      this.Omb.L(paramInt);
      if (paramInt == 0) {
        this.Wy = null;
      }
    }
    AppMethodBeat.o(140910);
  }
  
  final boolean c(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(140915);
    if (paramView == null)
    {
      AppMethodBeat.o(140915);
      return false;
    }
    int i;
    int j;
    if (this.Omb.fOh() > 0)
    {
      i = 1;
      if (this.Omb.ce() <= 0) {
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
          AppMethodBeat.o(140915);
          return true;
          i = 0;
          break;
          label89:
          j = 0;
          continue;
        }
        AppMethodBeat.o(140915);
        return false;
      }
    }
    if (i != 0)
    {
      if (Math.abs(paramFloat1) > this.mTouchSlop)
      {
        AppMethodBeat.o(140915);
        return true;
      }
      AppMethodBeat.o(140915);
      return false;
    }
    if (j != 0)
    {
      if (Math.abs(paramFloat2) > this.mTouchSlop)
      {
        AppMethodBeat.o(140915);
        return true;
      }
      AppMethodBeat.o(140915);
      return false;
    }
    AppMethodBeat.o(140915);
    return false;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(140900);
    this.mActivePointerId = -1;
    gi();
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
    AppMethodBeat.o(140900);
  }
  
  final void f(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(140909);
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
    AppMethodBeat.o(140909);
  }
  
  final int h(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(140901);
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(140901);
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
      AppMethodBeat.o(140901);
      return paramInt1;
    }
  }
  
  public final void h(MotionEvent paramMotionEvent)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(140912);
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
          AppMethodBeat.o(140912);
          return;
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          i = paramMotionEvent.getPointerId(0);
          paramMotionEvent = J((int)f1, (int)f2);
          a(f1, f2, i);
          z(paramMotionEvent, i);
        } while ((this.Oma[i] & this.Ww) == 0);
        AppMethodBeat.o(140912);
        return;
        i = paramMotionEvent.getPointerId(k);
        f1 = paramMotionEvent.getX(k);
        f2 = paramMotionEvent.getY(k);
        a(f1, f2, i);
        if (this.Wk == 0)
        {
          z(J((int)f1, (int)f2), i);
          AppMethodBeat.o(140912);
          return;
        }
      } while (!I((int)f1, (int)f2));
      z(this.Wy, i);
      AppMethodBeat.o(140912);
      return;
    case 2: 
      if (this.Wk == 1)
      {
        i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        i = (int)(f1 - this.Wn[this.mActivePointerId]);
        j = (int)(f2 - this.Wo[this.mActivePointerId]);
        i(this.Wy.getLeft() + i, this.Wy.getTop() + j, i, j);
        f(paramMotionEvent);
        AppMethodBeat.o(140912);
        return;
      }
      k = paramMotionEvent.getPointerCount();
      i = j;
      while (i < k)
      {
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        float f3 = f1 - this.Wl[j];
        float f4 = f2 - this.Wm[j];
        b(f3, f4, j);
        if (this.Wk == 1) {
          break;
        }
        View localView = J((int)f1, (int)f2);
        if ((c(localView, f3, f4)) && (z(localView, j))) {
          break;
        }
        i += 1;
      }
      f(paramMotionEvent);
      AppMethodBeat.o(140912);
      return;
    case 6: 
      j = paramMotionEvent.getPointerId(k);
      if ((this.Wk == 1) && (j == this.mActivePointerId))
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
        if ((J((int)f1, (int)f2) != this.Wy) || (!z(this.Wy, m))) {
          break label619;
        }
      }
      break;
    }
    label672:
    for (i = this.mActivePointerId;; i = -1)
    {
      if (i == -1) {
        gj();
      }
      bc(j);
      AppMethodBeat.o(140912);
      return;
      label619:
      i += 1;
      break label524;
      if (this.Wk == 1) {
        gj();
      }
      cancel();
      AppMethodBeat.o(140912);
      return;
      if (this.Wk == 1) {
        l(0.0F, 0.0F);
      }
      cancel();
      break;
    }
  }
  
  public final boolean lE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140916);
    if (!bd(paramInt2))
    {
      AppMethodBeat.o(140916);
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
      f1 = this.Wn[paramInt2] - this.Wl[paramInt2];
      f2 = this.Wo[paramInt2] - this.Wm[paramInt2];
      if ((i == 0) || (paramInt1 == 0)) {
        break label129;
      }
      if (f1 * f1 + f2 * f2 <= this.mTouchSlop * this.mTouchSlop) {
        break label121;
      }
      AppMethodBeat.o(140916);
      return true;
      i = 0;
      break;
    }
    label121:
    AppMethodBeat.o(140916);
    return false;
    label129:
    if (i != 0)
    {
      if (Math.abs(f1) > this.mTouchSlop)
      {
        AppMethodBeat.o(140916);
        return true;
      }
      AppMethodBeat.o(140916);
      return false;
    }
    if (paramInt1 != 0)
    {
      if (Math.abs(f2) > this.mTouchSlop)
      {
        AppMethodBeat.o(140916);
        return true;
      }
      AppMethodBeat.o(140916);
      return false;
    }
    AppMethodBeat.o(140916);
    return false;
  }
  
  public final boolean lF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140917);
    if ((bd(paramInt2)) && ((this.Oma[paramInt2] & paramInt1) != 0))
    {
      AppMethodBeat.o(140917);
      return true;
    }
    AppMethodBeat.o(140917);
    return false;
  }
  
  final boolean z(View paramView, int paramInt)
  {
    AppMethodBeat.i(140911);
    if ((paramView == this.Wy) && (this.mActivePointerId == paramInt))
    {
      AppMethodBeat.o(140911);
      return true;
    }
    if ((paramView != null) && (this.Omb.afz(paramInt)))
    {
      this.mActivePointerId = paramInt;
      y(paramView, paramInt);
      AppMethodBeat.o(140911);
      return true;
    }
    AppMethodBeat.o(140911);
    return false;
  }
  
  public static abstract class a
  {
    public void L(int paramInt) {}
    
    public void a(View paramView, float paramFloat1, float paramFloat2) {}
    
    public abstract boolean afz(int paramInt);
    
    public int ce()
    {
      return 0;
    }
    
    public int d(View paramView, int paramInt)
    {
      return 0;
    }
    
    public int e(View paramView, int paramInt)
    {
      return 0;
    }
    
    public int fOh()
    {
      return 0;
    }
    
    public void o(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     me.imid.swipebacklayout.lib.b
 * JD-Core Version:    0.7.0.1
 */