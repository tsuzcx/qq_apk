package android.support.wearable.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.ac;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ScrollView;
import android.widget.Scroller;

@TargetApi(20)
public class GridViewPager
  extends ViewGroup
{
  private static final Interpolator En = new l();
  private static final Interpolator Eo = new DecelerateInterpolator(2.5F);
  private static final int[] mR = { 16842931 };
  private i BC;
  private p EA;
  private int EB;
  private int EC;
  private boolean ED;
  private int EE = 1;
  private boolean EF;
  private final int EG;
  private float EH;
  private float EI;
  private float EJ;
  private float EK;
  private int EL;
  private final int EM;
  private final int EN;
  private o EO;
  private int EP;
  private SparseIntArray EQ;
  private View ER;
  private b ES;
  private WindowInsets ET;
  private View.OnApplyWindowInsetsListener EU;
  private boolean EV;
  private i EW;
  private boolean EX;
  private n Eh;
  private int Ep;
  private int Eq;
  private boolean Er = true;
  private int Es = 300;
  private final Point Et;
  private final Point Eu;
  private Point Ev;
  private final android.support.v4.b.r<Point, m> Ew;
  private final android.support.v4.b.r<Point, m> Ex;
  private final Rect Ey;
  private final Rect Ez;
  private boolean cE;
  private final int mi;
  private int mz = 0;
  private final int nA;
  private boolean nE = true;
  private boolean nG;
  private final Runnable nR = new Runnable()
  {
    public final void run()
    {
      GridViewPager.b(GridViewPager.this);
      GridViewPager.c(GridViewPager.this);
    }
  };
  private Parcelable na;
  private ClassLoader nb;
  private final Scroller nc;
  private boolean np;
  private int nv = -1;
  private VelocityTracker nw = null;
  private final int vy;
  
  public GridViewPager(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public GridViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GridViewPager(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = ViewConfiguration.get(getContext());
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.mi = ac.a(paramAttributeSet);
    this.EG = (this.mi * this.mi);
    this.vy = paramAttributeSet.getScaledMinimumFlingVelocity();
    this.EM = ((int)(40.0F * f));
    this.EN = ((int)(200.0F * f));
    this.nA = ((int)(2.0F * f));
    this.Eu = new Point();
    this.Ew = new android.support.v4.b.r();
    this.Ex = new android.support.v4.b.r();
    this.Ey = new Rect();
    this.Ez = new Rect();
    this.nc = new Scroller(paramContext, Eo, true);
    this.Et = new Point();
    setOverScrollMode(1);
    this.EQ = new SparseIntArray();
    this.ES = new b();
    this.ES.aM(this);
  }
  
  private void K(int paramInt)
  {
    if (this.mz == paramInt) {}
    do
    {
      return;
      this.mz = paramInt;
      if (this.EO != null) {
        this.EO.J(paramInt);
      }
    } while (this.ES == null);
    this.ES.J(paramInt);
  }
  
  private void P(int paramInt1, int paramInt2)
  {
    this.EQ.put(paramInt1, paramInt2);
  }
  
  private void Q(int paramInt1, int paramInt2)
  {
    this.ED = false;
    b(paramInt1, paramInt2, true, false);
  }
  
  private m R(int paramInt1, int paramInt2)
  {
    Point localPoint = new Point(paramInt1, paramInt2);
    m localm2 = (m)this.Ex.remove(localPoint);
    m localm1 = localm2;
    if (localm2 == null)
    {
      localm1 = new m();
      localm1.Fa = this.BC.a(this, paramInt1);
      localm1.Fb = paramInt1;
      localm1.Fc = paramInt2;
    }
    localPoint.set(paramInt1, paramInt2);
    localm1.Fb = paramInt1;
    localm1.Fc = paramInt2;
    this.Ew.put(localPoint, localm1);
    return localm1;
  }
  
  private void S(int paramInt1, int paramInt2)
  {
    Object localObject = new Point();
    if ((this.Eu.x != paramInt1) || (this.Eu.y != paramInt2))
    {
      ((Point)localObject).set(this.Eu.x, this.Eu.y);
      this.Eu.set(paramInt1, paramInt2);
    }
    if (this.ED) {}
    label258:
    do
    {
      do
      {
        return;
      } while (getWindowToken() == null);
      this.Ez.setEmpty();
      if (this.Ep != 1) {
        throw new IllegalStateException("Adapter row count changed without a call to notifyDataSetChanged()");
      }
      this.Ep = 1;
      this.Eq = 2;
      int m = Math.max(1, this.EE);
      int i = Math.max(0, paramInt2 - m);
      int j = Math.min(0, paramInt2 + m);
      int k = Math.max(0, paramInt1 - m);
      m = Math.min(1, m + paramInt1);
      paramInt1 = this.Ew.size() - 1;
      if (paramInt1 >= 0)
      {
        localObject = (m)this.Ew.valueAt(paramInt1);
        if (((m)localObject).Fc == paramInt2) {
          if ((((m)localObject).Fb < k) || (((m)localObject).Fb > m)) {
            break label258;
          }
        }
        for (;;)
        {
          paramInt1 -= 1;
          break;
          int n = this.Eu.x;
          if ((((m)localObject).Fb != 0) || (((m)localObject).Fc < i) || (((m)localObject).Fc > j))
          {
            Point localPoint = (Point)this.Ew.keyAt(paramInt1);
            this.Ew.removeAt(paramInt1);
            localPoint.set(((m)localObject).Fb, ((m)localObject).Fc);
            this.Ex.put(localPoint, localObject);
          }
        }
      }
      this.Et.y = paramInt2;
      for (this.Et.x = k; this.Et.x <= m; ((Point)localObject).x += 1)
      {
        if (!this.Ew.containsKey(this.Et)) {
          R(this.Et.x, this.Et.y);
        }
        localObject = this.Et;
      }
      for (this.Et.y = i; this.Et.y <= j; ((Point)localObject).y += 1)
      {
        localObject = this.Et;
        paramInt1 = this.Et.y;
        ((Point)localObject).x = 0;
        if (!this.Ew.containsKey(this.Et)) {
          R(this.Et.x, this.Et.y);
        }
        if (this.Et.y != this.Eu.y) {
          P(this.Et.y, bn(this.Et.x) - getPaddingLeft());
        }
        localObject = this.Et;
      }
      paramInt1 = this.Ex.size() - 1;
      while (paramInt1 >= 0)
      {
        localObject = (m)this.Ex.removeAt(paramInt1);
        this.BC.b(this, ((m)localObject).Fa);
        paramInt1 -= 1;
      }
      this.Ex.clear();
      this.Ey.set(k, i, m, j);
      this.Ez.set(bn(k) - getPaddingLeft(), bo(i) - getPaddingTop(), bn(m + 1) - getPaddingRight(), bo(j + 1) + getPaddingBottom());
      if (this.EV)
      {
        this.EV = false;
        b(this.EW, this.BC);
        this.EW = null;
      }
    } while (!this.EX);
    this.EX = false;
    fv();
  }
  
  private m T(int paramInt1, int paramInt2)
  {
    this.Et.set(paramInt1, paramInt2);
    return (m)this.Ew.get(this.Et);
  }
  
  private boolean U(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (this.Ew.size() == 0)
    {
      this.nG = false;
      a(0, 0, 0.0F, 0.0F, 0, 0);
      if (!this.nG) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
    }
    else
    {
      m localm = fw();
      int j = bn(localm.Fb);
      int i = bo(localm.Fc);
      paramInt1 = getPaddingLeft() + paramInt1 - j;
      paramInt2 = getPaddingTop() + paramInt2 - i;
      float f1 = w(paramInt1);
      float f2 = x(paramInt2);
      this.nG = false;
      a(localm.Fb, localm.Fc, f1, f2, paramInt1, paramInt2);
      if (!this.nG) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
      bool = true;
    }
    return bool;
  }
  
  private m V(int paramInt1, int paramInt2)
  {
    paramInt2 = (int)x(paramInt2);
    paramInt1 = (int)w(paramInt1);
    m localm2 = T(paramInt1, paramInt2);
    m localm1 = localm2;
    if (localm2 == null)
    {
      localm1 = new m();
      localm1.Fb = paramInt1;
      localm1.Fc = paramInt2;
    }
    return localm1;
  }
  
  private static boolean W(int paramInt1, int paramInt2)
  {
    return (paramInt1 >= 0) && (paramInt1 <= paramInt2);
  }
  
  private int a(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = paramInt4;
    if (Math.abs(paramInt4) < this.EN) {
      i = (int)Math.copySign(paramInt4, paramInt5);
    }
    float f = 0.5F / Math.max(Math.abs(0.5F - paramFloat), 0.001F);
    if ((Math.abs(paramInt5) > this.EM) && (f * 100.0F + Math.abs(i) > this.vy)) {
      if (i <= 0) {}
    }
    for (;;)
    {
      return j(paramInt1, paramInt2, paramInt3);
      paramInt1 += 1;
      continue;
      paramInt1 = Math.round(paramInt1 + paramFloat);
    }
  }
  
  private static int a(ScrollView paramScrollView, int paramInt)
  {
    int j = 0;
    int i = j;
    if (paramScrollView.getChildCount() > 0)
    {
      View localView = paramScrollView.getChildAt(0);
      int k = paramScrollView.getHeight();
      int m = localView.getHeight();
      i = j;
      if (m > k)
      {
        if (paramInt <= 0) {
          break label61;
        }
        i = Math.min(m - k - paramScrollView.getScrollY(), 0);
      }
    }
    label61:
    do
    {
      return i;
      i = j;
    } while (paramInt >= 0);
    return -paramScrollView.getScrollY();
  }
  
  private m a(Point paramPoint)
  {
    return (m)this.Ew.get(paramPoint);
  }
  
  private View a(m paramm)
  {
    if (paramm.Fa != null)
    {
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = getChildAt(i);
        if (this.BC.a(localView, paramm.Fa)) {
          return localView;
        }
        i += 1;
      }
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, int paramInt4)
  {
    this.nG = true;
    if (this.EO != null) {
      this.EO.a(paramInt2, paramInt1, paramFloat2, paramFloat1, paramInt4, paramInt3);
    }
    if (this.ES != null) {
      this.ES.a(paramInt2, paramInt1, paramFloat2, paramFloat1, paramInt4, paramInt3);
    }
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3)
  {
    boolean bool = true;
    if (this.BC == null) {}
    while ((!paramBoolean2) && (this.Eu.equals(paramInt2, paramInt1)) && (this.Ew.size() != 0)) {
      return;
    }
    paramInt1 = j(paramInt1, 0, 0);
    paramInt2 = j(paramInt2, 0, 1);
    if (paramInt2 != this.Eu.x)
    {
      this.EP = 0;
      paramBoolean2 = bool;
    }
    while (this.nE)
    {
      this.Eu.set(0, 0);
      if (paramBoolean2)
      {
        if (this.EO != null) {
          this.EO.N(paramInt1, paramInt2);
        }
        if (this.ES != null) {
          this.ES.N(paramInt1, paramInt2);
        }
      }
      requestLayout();
      return;
      if (paramInt1 != this.Eu.y)
      {
        this.EP = 1;
        paramBoolean2 = bool;
      }
      else
      {
        paramBoolean2 = false;
      }
    }
    S(paramInt2, paramInt1);
    c(paramInt2, paramInt1, paramBoolean1, paramBoolean2);
  }
  
  private void a(View paramView, GridViewPager.LayoutParams paramLayoutParams)
  {
    int j = 0;
    int m = fu();
    int k = getContentHeight();
    int i;
    if (paramLayoutParams.width == -2)
    {
      i = 0;
      if (paramLayoutParams.height != -2) {
        break label98;
      }
    }
    for (;;)
    {
      i = View.MeasureSpec.makeMeasureSpec(m, i);
      j = View.MeasureSpec.makeMeasureSpec(k, j);
      paramView.measure(getChildMeasureSpec(i, paramLayoutParams.leftMargin + paramLayoutParams.rightMargin, paramLayoutParams.width), getChildMeasureSpec(j, paramLayoutParams.topMargin + paramLayoutParams.bottomMargin, paramLayoutParams.height));
      return;
      i = 1073741824;
      break;
      label98:
      j = 1073741824;
    }
  }
  
  private m aN(View paramView)
  {
    int i = 0;
    while (i < this.Ew.size())
    {
      m localm = (m)this.Ew.valueAt(i);
      if ((localm != null) && (this.BC.a(paramView, localm.Fa))) {
        return localm;
      }
      i += 1;
    }
    return null;
  }
  
  private static float b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    if (paramFloat1 > paramFloat3) {
      return paramFloat3;
    }
    return paramFloat1;
  }
  
  private void b(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt1, paramInt2, paramBoolean1, paramBoolean2, 0);
  }
  
  private void b(i parami1, i parami2)
  {
    if (this.Eh != null) {
      this.Eh.a(parami1, parami2);
    }
    if (this.ES != null) {
      this.ES.a(parami1, parami2);
    }
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.nv) {
      if (i != 0) {
        break label65;
      }
    }
    label65:
    for (i = 1;; i = 0)
    {
      this.EH = paramMotionEvent.getX(i);
      this.EI = paramMotionEvent.getY(i);
      this.nv = paramMotionEvent.getPointerId(i);
      if (this.nw != null) {
        this.nw.clear();
      }
      return;
    }
  }
  
  private void bM()
  {
    if (this.BC != null) {
      S(this.Eu.x, this.Eu.y);
    }
  }
  
  private void bR()
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(true);
    }
  }
  
  private void bT()
  {
    this.np = false;
    this.EF = false;
    if (this.nw != null)
    {
      this.nw.recycle();
      this.nw = null;
    }
  }
  
  private int bm(int paramInt)
  {
    return this.EQ.get(paramInt, 0);
  }
  
  private int bn(int paramInt)
  {
    return (fu() + this.EC) * paramInt + getPaddingLeft();
  }
  
  private int bo(int paramInt)
  {
    return (getContentHeight() + this.EB) * paramInt + getPaddingTop();
  }
  
  private static String bp(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder((paramInt * 2 + 3) * 2);
    int i = 0;
    while (i < paramInt * 2 + 3)
    {
      localStringBuilder.append(' ').append(' ');
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void c(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    m localm = T(paramInt1, paramInt2);
    int j;
    int i;
    if (localm != null)
    {
      j = bn(localm.Fb) - getPaddingLeft();
      i = bo(localm.Fc) - getPaddingTop();
    }
    for (;;)
    {
      if (paramBoolean2)
      {
        if (this.EO != null) {
          this.EO.N(paramInt2, paramInt1);
        }
        if (this.ES != null) {
          this.ES.N(paramInt2, paramInt1);
        }
      }
      if (paramBoolean1)
      {
        d(j, i);
        return;
      }
      l(false);
      scrollTo(j, i);
      U(j, i);
      return;
      i = 0;
      j = 0;
    }
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    if (getChildCount() == 0) {
      return;
    }
    int i = bm(this.Eu.y);
    int j = getScrollY();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      l(false);
      bM();
      K(0);
      return;
    }
    K(2);
    int k = this.Es;
    this.nc.startScroll(i, j, paramInt1, paramInt2, k);
    android.support.v4.view.r.g(this);
  }
  
  private boolean d(float paramFloat1, float paramFloat2)
  {
    float f3 = this.EH - paramFloat1;
    float f1 = this.EI - paramFloat2;
    this.EH = paramFloat1;
    this.EI = paramFloat2;
    Object localObject = this.Ey;
    int j = bn(((Rect)localObject).left) - getPaddingLeft();
    int k = bn(((Rect)localObject).right) - getPaddingLeft();
    int m = bo(((Rect)localObject).top) - getPaddingTop();
    int n = bo(((Rect)localObject).bottom) - getPaddingTop();
    float f5 = bm(this.Eu.y);
    paramFloat2 = getScrollY();
    paramFloat1 = f1;
    float f4 = paramFloat2;
    if (this.EP == 1)
    {
      i = getContentHeight() + this.EB;
      if (f1 >= 0.0F) {
        break label579;
      }
      paramFloat1 = -(paramFloat2 % i);
      if (Math.abs(paramFloat1) > Math.abs(f1)) {
        break label716;
      }
      f1 -= paramFloat1;
      paramFloat2 += paramFloat1;
    }
    label324:
    label711:
    label716:
    for (int i = 1;; i = 0)
    {
      paramFloat1 = f1;
      f4 = paramFloat2;
      label239:
      float f2;
      if (i != 0)
      {
        localObject = a(V((int)f5, (int)paramFloat2));
        paramFloat1 = f1;
        f4 = paramFloat2;
        if (localObject != null)
        {
          i = p((View)localObject, (int)Math.signum(f1));
          if (i <= 0) {
            break label596;
          }
          paramFloat1 = Math.max(0.0F, Math.min(f1, i));
          ((View)localObject).scrollBy(0, (int)paramFloat1);
          f1 -= paramFloat1;
          f2 = this.EI;
          this.EI = (paramFloat1 - (int)paramFloat1 + f2);
          f4 = paramFloat2;
          paramFloat1 = f1;
        }
      }
      i = (int)((int)f3 + f5);
      int i1 = (int)((int)paramFloat1 + f4);
      if ((i < j) || (i > k) || (i1 < m) || (i1 > n))
      {
        i = 1;
        f1 = f3;
        if (i == 0) {
          break label711;
        }
        i1 = getOverScrollMode();
        if (((this.EP != 0) || (j >= k)) && ((this.EP != 1) || (m >= n))) {
          break label617;
        }
        i = 1;
        label370:
        if ((i1 != 0) && ((i == 0) || (i1 != 1))) {
          break label673;
        }
        if (f5 <= k) {
          break label623;
        }
        f1 = f5 - k;
        if (f4 <= n) {
          break label647;
        }
        f2 = f4 - n;
        paramFloat2 = f3;
        if (Math.abs(f1) > 0.0F)
        {
          paramFloat2 = f3;
          if (Math.signum(f1) == Math.signum(f3)) {
            paramFloat2 = f3 * En.getInterpolation(1.0F - Math.abs(f1) / fu());
          }
        }
        f1 = paramFloat2;
        if (Math.abs(f2) <= 0.0F) {
          break label711;
        }
        f1 = paramFloat2;
        if (Math.signum(f2) != Math.signum(paramFloat1)) {
          break label711;
        }
        paramFloat1 = En.getInterpolation(1.0F - Math.abs(f2) / getContentHeight()) * paramFloat1;
      }
      for (;;)
      {
        paramFloat2 += f5;
        paramFloat1 += f4;
        this.EH += paramFloat2 - (int)paramFloat2;
        this.EI += paramFloat1 - (int)paramFloat1;
        scrollTo((int)paramFloat2, (int)paramFloat1);
        U((int)paramFloat2, (int)paramFloat1);
        return true;
        paramFloat1 = (i - paramFloat2 % i) % i;
        break;
        label596:
        paramFloat1 = Math.min(0.0F, Math.max(f1, i));
        break label239;
        i = 0;
        break label324;
        label617:
        i = 0;
        break label370;
        label623:
        if (f5 < j)
        {
          f1 = f5 - j;
          break label402;
        }
        f1 = 0.0F;
        break label402;
        if (f4 < m)
        {
          f2 = f4 - m;
          break label419;
        }
        f2 = 0.0F;
        break label419;
        paramFloat2 = b(f3, j - f5, k - f5);
        paramFloat1 = b(paramFloat1, m - f4, n - f4);
        continue;
        paramFloat2 = f1;
      }
    }
  }
  
  private int fu()
  {
    return getMeasuredWidth() - (getPaddingLeft() + getPaddingRight());
  }
  
  private void fv()
  {
    if (this.Eh != null) {
      this.Eh.onDataSetChanged();
    }
    if (this.ES != null) {
      this.ES.onDataSetChanged();
    }
  }
  
  private m fw()
  {
    return V(bm((int)x(getScrollY())), getScrollY());
  }
  
  private boolean g(MotionEvent paramMotionEvent)
  {
    if (this.np) {
      return false;
    }
    this.nv = paramMotionEvent.getPointerId(0);
    this.EK = paramMotionEvent.getX();
    this.EJ = paramMotionEvent.getY();
    this.EL = getScrollY();
    this.EH = this.EK;
    this.EI = this.EJ;
    this.EF = true;
    this.nw = VelocityTracker.obtain();
    this.nw.addMovement(paramMotionEvent);
    this.nc.computeScrollOffset();
    if (((this.mz != 2) && (this.mz != 3)) || (((this.EP == 0) && (Math.abs(this.nc.getFinalX() - this.nc.getCurrX()) > this.nA)) || ((this.EP == 1) && (Math.abs(this.nc.getFinalY() - this.nc.getCurrY()) > this.nA))))
    {
      this.nc.abortAnimation();
      this.ED = false;
      bM();
      this.np = true;
      bR();
      K(1);
      return false;
    }
    l(false);
    this.np = false;
    return false;
  }
  
  private int getContentHeight()
  {
    return getMeasuredHeight() - (getPaddingTop() + getPaddingBottom());
  }
  
  private boolean h(MotionEvent paramMotionEvent)
  {
    int i = this.nv;
    if (i == -1) {
      return false;
    }
    i = paramMotionEvent.findPointerIndex(i);
    if (i == -1) {
      return this.np;
    }
    float f4 = paramMotionEvent.getX(i);
    float f3 = paramMotionEvent.getY(i);
    float f6 = f4 - this.EH;
    float f1 = Math.abs(f6);
    float f5 = f3 - this.EI;
    float f2 = Math.abs(f5);
    if ((!this.np) && (f1 * f1 + f2 * f2 > this.EG))
    {
      this.np = true;
      bR();
      K(1);
      if (f2 >= f1)
      {
        this.EP = 1;
        if ((f2 <= 0.0F) || (f1 <= 0.0F)) {
          break label308;
        }
        double d = Math.sqrt(f2 * f2 + f1 * f1);
        d = Math.acos(f1 / d);
        f1 = (float)(Math.sin(d) * this.mi);
        f2 = (float)(Math.cos(d) * this.mi);
        label200:
        if (f6 <= 0.0F) {
          break label341;
        }
        f2 += this.EH;
        label216:
        this.EH = f2;
        if (f5 <= 0.0F) {
          break label353;
        }
        f1 = this.EI + f1;
        label238:
        this.EI = f1;
      }
    }
    else if (this.np)
    {
      if (this.EP != 0) {
        break label365;
      }
      f1 = f4;
      label262:
      if (this.EP != 1) {
        break label374;
      }
    }
    label308:
    label341:
    label353:
    label365:
    label374:
    for (f2 = f3;; f2 = this.EI)
    {
      d(f1, f2);
      android.support.v4.view.r.g(this);
      this.nw.addMovement(paramMotionEvent);
      return this.np;
      this.EP = 0;
      break;
      if (f2 == 0.0F)
      {
        f2 = this.mi;
        f1 = 0.0F;
        break label200;
      }
      f2 = 0.0F;
      f1 = this.mi;
      break label200;
      f2 = this.EH - f2;
      break label216;
      f1 = this.EI - f1;
      break label238;
      f1 = this.EH;
      break label262;
    }
  }
  
  private static int j(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    return paramInt1;
  }
  
  private void l(boolean paramBoolean)
  {
    if (this.mz == 2) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.nc.abortAnimation();
        int j = bm(this.Eu.y);
        int k = getScrollY();
        int m = this.nc.getCurrX();
        int n = this.nc.getCurrY();
        if ((j != m) || (k != n)) {
          scrollTo(m, n);
        }
      }
      this.ER = null;
      this.ED = false;
      if (i != 0)
      {
        if (!paramBoolean) {
          break;
        }
        android.support.v4.view.r.b(this, this.nR);
      }
      return;
    }
    this.nR.run();
  }
  
  private static int p(View paramView, int paramInt)
  {
    int i = 0;
    if ((paramView instanceof CardScrollView)) {
      i = ((CardScrollView)paramView).bk(paramInt);
    }
    while (!(paramView instanceof ScrollView)) {
      return i;
    }
    return a((ScrollView)paramView, paramInt);
  }
  
  private float w(float paramFloat)
  {
    int i = fu() + this.EC;
    if (i == 0)
    {
      Log.e("GridViewPager", "getXIndex() called with zero width.");
      return 0.0F;
    }
    return paramFloat / i;
  }
  
  private float x(float paramFloat)
  {
    int i = getContentHeight() + this.EB;
    if (i == 0)
    {
      Log.e("GridViewPager", "getYIndex() called with zero height.");
      return 0.0F;
    }
    return paramFloat / i;
  }
  
  public final void a(i parami)
  {
    int i;
    if (this.BC != null)
    {
      this.BC.unregisterDataSetObserver(this.EA);
      this.BC.a(null);
      i = 0;
      while (i < this.Ew.size())
      {
        localObject = (m)this.Ew.valueAt(i);
        this.BC.b(this, ((m)localObject).Fa);
        i += 1;
      }
      this.Ew.clear();
      removeAllViews();
      scrollTo(0, 0);
      this.EQ.clear();
    }
    Object localObject = this.BC;
    this.Eu.set(0, 0);
    this.BC = parami;
    this.Ep = 0;
    this.Eq = 0;
    boolean bool;
    if (this.BC != null)
    {
      if (this.EA == null) {
        this.EA = new p(this, (byte)0);
      }
      this.BC.registerDataSetObserver(this.EA);
      this.BC.a(this.ES);
      this.ED = false;
      bool = this.nE;
      this.nE = true;
      this.Ep = 1;
      if (this.Ep > 0)
      {
        this.Eu.set(0, 0);
        i = this.Eu.y;
        this.Eq = 2;
      }
      if (this.Ev != null)
      {
        b(this.Ev.y, this.Ev.x, false, true);
        this.Ev = null;
        this.na = null;
        this.nb = null;
      }
    }
    while (localObject != parami) {
      if (parami == null)
      {
        this.EV = false;
        b((i)localObject, parami);
        this.EW = null;
        return;
        if (!bool)
        {
          bM();
        }
        else
        {
          requestLayout();
          continue;
          if (this.np)
          {
            cancelPendingInputEvents();
            long l = SystemClock.uptimeMillis();
            MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
            localMotionEvent.setSource(4098);
            dispatchTouchEvent(localMotionEvent);
            localMotionEvent.recycle();
          }
        }
      }
      else
      {
        this.EV = true;
        this.EW = ((i)localObject);
        return;
      }
    }
    this.EV = false;
    this.EW = null;
  }
  
  public final void a(n paramn)
  {
    this.Eh = paramn;
    if ((paramn != null) && (this.BC != null) && (!this.EV)) {
      paramn.a(null, this.BC);
    }
  }
  
  public final void a(o paramo)
  {
    this.EO = paramo;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    aN(paramView);
    if (!checkLayoutParams(paramLayoutParams)) {
      paramLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    for (;;)
    {
      GridViewPager.LayoutParams localLayoutParams = (GridViewPager.LayoutParams)paramLayoutParams;
      if (this.cE)
      {
        localLayoutParams.nX = true;
        addViewInLayout(paramView, paramInt, paramLayoutParams);
      }
      for (;;)
      {
        if (this.ET != null) {
          paramView.onApplyWindowInsets(this.ET);
        }
        return;
        super.addView(paramView, paramInt, paramLayoutParams);
      }
    }
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    boolean bool = true;
    if ((getVisibility() != 0) || (this.BC == null) || (this.Ew.isEmpty())) {
      bool = false;
    }
    int i;
    do
    {
      int j;
      do
      {
        return bool;
        i = bm(this.Eu.y);
        j = this.Eq;
        if (paramInt <= 0) {
          break;
        }
      } while (i + getPaddingLeft() < bn(j - 1));
      return false;
    } while (i > 0);
    return false;
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    boolean bool = true;
    if ((getVisibility() != 0) || (this.BC == null) || (this.Ew.isEmpty())) {
      bool = false;
    }
    int i;
    do
    {
      int j;
      do
      {
        return bool;
        i = getScrollY();
        j = this.Ep;
        if (paramInt <= 0) {
          break;
        }
      } while (i + getPaddingTop() < bo(j - 1));
      return false;
    } while (i > 0);
    return false;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof GridViewPager.LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    if ((!this.nc.isFinished()) && (this.nc.computeScrollOffset()))
    {
      if (this.mz == 3) {
        if (this.ER == null) {
          this.nc.abortAnimation();
        }
      }
      for (;;)
      {
        android.support.v4.view.r.g(this);
        return;
        int i = this.nc.getCurrX();
        int j = this.nc.getCurrY();
        this.ER.scrollTo(i, j);
        continue;
        i = bm(this.Eu.y);
        j = getScrollY();
        int k = this.nc.getCurrX();
        int m = this.nc.getCurrY();
        if ((i != k) || (j != m))
        {
          scrollTo(k, m);
          if (!U(k, m))
          {
            this.nc.abortAnimation();
            scrollTo(0, 0);
          }
        }
      }
    }
    l(true);
  }
  
  protected void debug(int paramInt)
  {
    super.debug(paramInt);
    String str = bp(paramInt);
    Log.d("View", str + "mCurItem={" + this.Eu + "}");
    str = bp(paramInt);
    Log.d("View", str + "mAdapter={" + this.BC + "}");
    str = bp(paramInt);
    Log.d("View", str + "mRowCount=" + this.Ep);
    str = bp(paramInt);
    Log.d("View", str + "mCurrentColumnCount=" + this.Eq);
    int j = this.Ew.size();
    if (j != 0)
    {
      str = bp(paramInt);
      Log.d("View", str + "mItems={");
    }
    int i = 0;
    while (i < j)
    {
      str = bp(paramInt + 1);
      Log.d("View", str + this.Ew.keyAt(i) + " => " + this.Ew.valueAt(i));
      i += 1;
    }
    if (j != 0)
    {
      str = bp(paramInt);
      Log.d("View", str + "}");
    }
  }
  
  public WindowInsets dispatchApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    WindowInsets localWindowInsets = onApplyWindowInsets(paramWindowInsets);
    if (this.EU != null) {
      this.EU.onApplyWindowInsets(this, localWindowInsets);
    }
    paramWindowInsets = localWindowInsets;
    if (this.Er) {
      paramWindowInsets = localWindowInsets.consumeSystemWindowInsets();
    }
    return paramWindowInsets;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    int i;
    if (!super.dispatchKeyEvent(paramKeyEvent)) {
      switch (paramKeyEvent.getKeyCode())
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      if (i != 0) {
        bool = true;
      }
      return bool;
      if (this.Eu.x > 0)
      {
        Q(this.Eu.x - 1, this.Eu.y);
        i = 1;
      }
      else
      {
        i = 0;
        continue;
        if (this.BC != null)
        {
          i = this.Eu.x;
          int j = this.Eu.y;
          if (i <= 0)
          {
            Q(this.Eu.x + 1, this.Eu.y);
            i = 1;
            continue;
          }
        }
        i = 0;
        continue;
        if (this.Eu.y > 0)
        {
          Q(this.Eu.x, this.Eu.y - 1);
          i = 1;
        }
        else
        {
          i = 0;
          continue;
          if ((this.BC != null) && (this.Eu.y < 0))
          {
            Q(this.Eu.x, this.Eu.y + 1);
            i = 1;
          }
          else
          {
            i = 0;
            continue;
            i = 0;
            continue;
            debug(0);
            i = 1;
          }
        }
      }
    }
  }
  
  public final i ft()
  {
    return this.BC;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new GridViewPager.LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new GridViewPager.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return generateDefaultLayoutParams();
  }
  
  public WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      getChildAt(i).dispatchApplyWindowInsets(paramWindowInsets);
      i += 1;
    }
    this.ET = paramWindowInsets;
    return paramWindowInsets;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.nE = true;
    getParent().requestFitSystemWindows();
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.nR);
    super.onDetachedFromWindow();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i == 3) || (i == 1))
    {
      this.np = false;
      this.EF = false;
      this.nv = -1;
      if (this.nw != null)
      {
        this.nw.recycle();
        this.nw = null;
      }
      bool = false;
    }
    do
    {
      return bool;
      if (i == 0) {
        break;
      }
    } while (this.np);
    if (!this.EF) {
      return false;
    }
    switch (i)
    {
    }
    for (;;)
    {
      return this.np;
      g(paramMotionEvent);
      continue;
      h(paramMotionEvent);
      continue;
      b(paramMotionEvent);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt1 = 0;
    if (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      GridViewPager.LayoutParams localLayoutParams = (GridViewPager.LayoutParams)localView.getLayoutParams();
      if (localLayoutParams == null) {
        Log.w("GridViewPager", "Got null layout params for child: ".concat(String.valueOf(localView)));
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        m localm = aN(localView);
        if (localm == null)
        {
          Log.w("GridViewPager", "Unknown child view, not claimed by adapter: ".concat(String.valueOf(localView)));
        }
        else
        {
          if (localLayoutParams.nX)
          {
            localLayoutParams.nX = false;
            a(localView, localLayoutParams);
          }
          paramInt4 = bn(localm.Fb);
          paramInt3 = bo(localm.Fc);
          paramInt4 = paramInt4 - bm(localm.Fc) + localLayoutParams.leftMargin;
          paramInt3 = localLayoutParams.topMargin + paramInt3;
          localView.layout(paramInt4, paramInt3, localView.getMeasuredWidth() + paramInt4, localView.getMeasuredHeight() + paramInt3);
        }
      }
    }
    if ((this.nE) && (!this.Ew.isEmpty())) {
      c(this.Eu.x, this.Eu.y, false, false);
    }
    this.nE = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    this.cE = true;
    bM();
    this.cE = false;
    paramInt2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView.getVisibility() != 8)
      {
        GridViewPager.LayoutParams localLayoutParams = (GridViewPager.LayoutParams)localView.getLayoutParams();
        if (localLayoutParams != null) {
          a(localView, localLayoutParams);
        }
      }
      paramInt1 += 1;
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    int i = 1;
    if (!(paramParcelable instanceof GridViewPager.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (GridViewPager.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    int j = paramParcelable.Fd;
    if ((W(paramParcelable.Fe, this.Ep - 1)) && (W(j, 1))) {}
    while (i != 0)
    {
      this.Ev = new Point(paramParcelable.Fd, paramParcelable.Fe);
      return;
      i = 0;
    }
    this.Eu.set(0, 0);
    scrollTo(0, 0);
  }
  
  public Parcelable onSaveInstanceState()
  {
    GridViewPager.SavedState localSavedState = new GridViewPager.SavedState(super.onSaveInstanceState());
    localSavedState.Fd = this.Eu.x;
    localSavedState.Fe = this.Eu.y;
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    m localm;
    if (!this.Ew.isEmpty())
    {
      int i2 = this.EC;
      int i3 = this.EC;
      int i = this.EB;
      int j = this.EB;
      if ((paramInt3 <= 0) || (paramInt4 <= 0)) {
        break label275;
      }
      int i4 = getPaddingLeft();
      int i5 = getPaddingRight();
      int i6 = getPaddingLeft();
      int i7 = getPaddingRight();
      int k = getPaddingTop();
      int m = getPaddingBottom();
      int n = getPaddingTop();
      int i1 = getPaddingBottom();
      float f = bm(this.Eu.y) / (i3 + (paramInt3 - i6 - i7));
      paramInt1 = (int)((i2 + (paramInt1 - i4 - i5)) * f);
      paramInt2 = (int)(getScrollY() / (j + (paramInt4 - n - i1)) * (i + (paramInt2 - k - m)));
      scrollTo(paramInt1, paramInt2);
      if (!this.nc.isFinished())
      {
        localm = a(this.Eu);
        paramInt3 = bn(localm.Fb);
        paramInt4 = getPaddingLeft();
        i = bo(localm.Fc);
        j = getPaddingTop();
        k = this.nc.getDuration();
        m = this.nc.timePassed();
        this.nc.startScroll(paramInt1, paramInt2, paramInt3 - paramInt4, i - j, k - m);
      }
    }
    label275:
    do
    {
      do
      {
        return;
        localm = a(this.Eu);
      } while (localm == null);
      paramInt1 = bn(localm.Fb) - getPaddingLeft();
      paramInt2 = bo(localm.Fc) - getPaddingTop();
    } while ((paramInt1 == bm(localm.Fc)) && (paramInt2 == getScrollY()));
    l(false);
    scrollTo(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.BC == null) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    VelocityTracker localVelocityTracker;
    int m;
    int j;
    int k;
    m localm;
    switch (i & 0xFF)
    {
    case 4: 
    case 5: 
    default: 
      Log.e("GridViewPager", "Unknown action type: ".concat(String.valueOf(i)));
    case 0: 
    case 2: 
    case 1: 
    case 3: 
      for (;;)
      {
        return true;
        g(paramMotionEvent);
        continue;
        h(paramMotionEvent);
        continue;
        if ((this.np) && (this.Ep != 0)) {
          break;
        }
        this.nv = -1;
        bT();
      }
      localVelocityTracker = this.nw;
      localVelocityTracker.addMovement(paramMotionEvent);
      localVelocityTracker.computeCurrentVelocity(1000);
      m = paramMotionEvent.findPointerIndex(this.nv);
      i = this.Eu.x;
      j = this.Eu.y;
      k = 0;
      localm = fw();
      switch (this.EP)
      {
      default: 
        label204:
        if (this.mz != 3)
        {
          this.ED = true;
          if (j == this.Eu.y) {
            break label629;
          }
          i = this.Eu.x;
          i = 0;
        }
        break;
      }
      break;
    }
    label495:
    label629:
    for (;;)
    {
      a(j, i, true, true, k);
      this.nv = -1;
      bT();
      break;
      i = (int)(paramMotionEvent.getRawX() - this.EK);
      k = (int)localVelocityTracker.getXVelocity(this.nv);
      m = localm.Fb;
      float f = w(bm(localm.Fc) - bn(localm.Fb));
      int n = this.Eu.x;
      i = a(m, f, this.Ey.left, this.Ey.right, k, i);
      break label204;
      paramMotionEvent.getX(m);
      m = this.EL;
      n = getScrollY();
      k = (int)localVelocityTracker.getYVelocity(this.nv);
      int i1 = localm.Fc;
      f = x(getScrollY() - bo(localm.Fc));
      if (f == 0.0F)
      {
        paramMotionEvent = a(fw());
        n = p(paramMotionEvent, -k);
        int i2;
        if (n != 0)
        {
          this.ER = paramMotionEvent;
          if (Math.abs(k) >= Math.abs(this.vy))
          {
            i2 = -k;
            if (this.ER != null)
            {
              if (i2 != 0) {
                break label495;
              }
              l(false);
              K(0);
            }
            bT();
          }
        }
        break label204;
        int i3 = this.ER.getScrollX();
        m = this.ER.getScrollY();
        K(3);
        if (i2 > 0)
        {
          i1 = m + n;
          n = m;
        }
        for (;;)
        {
          this.nc.fling(i3, m, 0, i2, i3 + 0, i3, n, i1);
          android.support.v4.view.r.g(this);
          break;
          n = m + n;
          i1 = m;
        }
      }
      j = this.Eu.y;
      j = a(i1, f, this.Ey.top, this.Ey.bottom, k, m - n);
      break label204;
      b(paramMotionEvent);
      break;
    }
  }
  
  public void removeView(View paramView)
  {
    aN(paramView);
    if (this.cE)
    {
      removeViewInLayout(paramView);
      return;
    }
    super.removeView(paramView);
  }
  
  public void requestFitSystemWindows() {}
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    int j = 0;
    int i = paramInt1;
    if (this.mz == 2)
    {
      i = paramInt1;
      if (this.EP == 1) {
        i = bm(this.Eu.y);
      }
    }
    super.scrollTo(0, paramInt2);
    paramInt2 = this.Eu.y;
    if (bm(paramInt2) != i)
    {
      int k = getChildCount();
      int m = bm(paramInt2);
      paramInt1 = j;
      while (paramInt1 < k)
      {
        View localView = getChildAt(paramInt1);
        m localm = aN(localView);
        if ((localm != null) && (localm.Fc == paramInt2))
        {
          localView.offsetLeftAndRight(-(i - m));
          postInvalidateOnAnimation();
        }
        paramInt1 += 1;
      }
      P(paramInt2, i);
    }
  }
  
  public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    this.EU = paramOnApplyWindowInsetsListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.GridViewPager
 * JD-Core Version:    0.7.0.1
 */