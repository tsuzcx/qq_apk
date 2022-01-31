package android.support.wearable.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.b.q;
import android.support.v4.view.ac;
import android.support.v4.view.r;
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
  private static final Interpolator Cy = new l();
  private static final Interpolator Cz = new DecelerateInterpolator(2.5F);
  private static final int[] kV = { 16842931 };
  private int CA;
  private int CB;
  private boolean CC = true;
  private int CD = 300;
  private final Point CE;
  private final Point CF;
  private Point CG;
  private final q<Point, m> CH;
  private final q<Point, m> CI;
  private final Rect CJ;
  private final Rect CK;
  private p CL;
  private int CM;
  private int CN;
  private boolean CO;
  private int CP = 1;
  private boolean CQ;
  private final int CR;
  private float CS;
  private float CT;
  private float CU;
  private float CV;
  private int CW;
  private final int CX;
  private final int CY;
  private o CZ;
  private n Cs;
  private int Da;
  private SparseIntArray Db;
  private View Dc;
  private b Dd;
  private WindowInsets De;
  private View.OnApplyWindowInsetsListener Df;
  private boolean Dg;
  private i Dh;
  private boolean Di;
  private boolean aU;
  private int kD = 0;
  private final int kl;
  private VelocityTracker lA = null;
  private final int lE;
  private boolean lI = true;
  private boolean lK;
  private final Runnable lV = new Runnable()
  {
    public final void run()
    {
      GridViewPager.b(GridViewPager.this);
      GridViewPager.c(GridViewPager.this);
    }
  };
  private Parcelable le;
  private ClassLoader lf;
  private final Scroller lg;
  private boolean lt;
  private int lz = -1;
  private final int tI;
  private i zN;
  
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
    this.kl = ac.a(paramAttributeSet);
    this.CR = (this.kl * this.kl);
    this.tI = paramAttributeSet.getScaledMinimumFlingVelocity();
    this.CX = ((int)(40.0F * f));
    this.CY = ((int)(200.0F * f));
    this.lE = ((int)(2.0F * f));
    this.CF = new Point();
    this.CH = new q();
    this.CI = new q();
    this.CJ = new Rect();
    this.CK = new Rect();
    this.lg = new Scroller(paramContext, Cz, true);
    this.CE = new Point();
    setOverScrollMode(1);
    this.Db = new SparseIntArray();
    this.Dd = new b();
    this.Dd.aD(this);
  }
  
  private void N(int paramInt1, int paramInt2)
  {
    this.Db.put(paramInt1, paramInt2);
  }
  
  private void O(int paramInt1, int paramInt2)
  {
    this.CO = false;
    b(paramInt1, paramInt2, true, false);
  }
  
  private m P(int paramInt1, int paramInt2)
  {
    Point localPoint = new Point(paramInt1, paramInt2);
    m localm2 = (m)this.CI.remove(localPoint);
    m localm1 = localm2;
    if (localm2 == null)
    {
      localm1 = new m();
      localm1.Dl = this.zN.a(this, paramInt1);
      localm1.Dm = paramInt1;
      localm1.Dn = paramInt2;
    }
    localPoint.set(paramInt1, paramInt2);
    localm1.Dm = paramInt1;
    localm1.Dn = paramInt2;
    this.CH.put(localPoint, localm1);
    return localm1;
  }
  
  private void Q(int paramInt1, int paramInt2)
  {
    Object localObject = new Point();
    if ((this.CF.x != paramInt1) || (this.CF.y != paramInt2))
    {
      ((Point)localObject).set(this.CF.x, this.CF.y);
      this.CF.set(paramInt1, paramInt2);
    }
    if (this.CO) {}
    label281:
    do
    {
      do
      {
        return;
      } while (getWindowToken() == null);
      i.fd();
      this.CK.setEmpty();
      this.zN.getRowCount();
      if (this.CA != 1) {
        throw new IllegalStateException("Adapter row count changed without a call to notifyDataSetChanged()");
      }
      this.zN.fa();
      this.CA = 1;
      this.CB = 2;
      int m = Math.max(1, this.CP);
      int i = Math.max(0, paramInt2 - m);
      int j = Math.min(0, paramInt2 + m);
      int k = Math.max(0, paramInt1 - m);
      m = Math.min(1, m + paramInt1);
      paramInt1 = this.CH.size() - 1;
      if (paramInt1 >= 0)
      {
        localObject = (m)this.CH.valueAt(paramInt1);
        if (((m)localObject).Dn == paramInt2) {
          if ((((m)localObject).Dm < k) || (((m)localObject).Dm > m)) {
            break label281;
          }
        }
        for (;;)
        {
          paramInt1 -= 1;
          break;
          int n = this.CF.x;
          i.fb();
          if ((((m)localObject).Dm != 0) || (((m)localObject).Dn < i) || (((m)localObject).Dn > j))
          {
            Point localPoint = (Point)this.CH.keyAt(paramInt1);
            this.CH.removeAt(paramInt1);
            localPoint.set(((m)localObject).Dm, ((m)localObject).Dn);
            this.CI.put(localPoint, localObject);
          }
        }
      }
      this.CE.y = paramInt2;
      for (this.CE.x = k; this.CE.x <= m; ((Point)localObject).x += 1)
      {
        if (!this.CH.containsKey(this.CE)) {
          P(this.CE.x, this.CE.y);
        }
        localObject = this.CE;
      }
      for (this.CE.y = i; this.CE.y <= j; ((Point)localObject).y += 1)
      {
        localObject = this.CE;
        paramInt1 = this.CE.y;
        ((Point)localObject).x = i.fb();
        if (!this.CH.containsKey(this.CE)) {
          P(this.CE.x, this.CE.y);
        }
        if (this.CE.y != this.CF.y) {
          N(this.CE.y, aT(this.CE.x) - getPaddingLeft());
        }
        localObject = this.CE;
      }
      paramInt1 = this.CI.size() - 1;
      while (paramInt1 >= 0)
      {
        localObject = (m)this.CI.removeAt(paramInt1);
        this.zN.b(this, ((m)localObject).Dl);
        paramInt1 -= 1;
      }
      this.CI.clear();
      i.fe();
      this.CJ.set(k, i, m, j);
      this.CK.set(aT(k) - getPaddingLeft(), aU(i) - getPaddingTop(), aT(m + 1) - getPaddingRight(), aU(j + 1) + getPaddingBottom());
      if (this.Dg)
      {
        this.Dg = false;
        b(this.Dh, this.zN);
        this.Dh = null;
      }
    } while (!this.Di);
    this.Di = false;
    fm();
  }
  
  private m R(int paramInt1, int paramInt2)
  {
    this.CE.set(paramInt1, paramInt2);
    return (m)this.CH.get(this.CE);
  }
  
  private boolean S(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (this.CH.size() == 0)
    {
      this.lK = false;
      a(0, 0, 0.0F, 0.0F, 0, 0);
      if (!this.lK) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
    }
    else
    {
      m localm = fn();
      int j = aT(localm.Dm);
      int i = aU(localm.Dn);
      paramInt1 = getPaddingLeft() + paramInt1 - j;
      paramInt2 = getPaddingTop() + paramInt2 - i;
      float f1 = v(paramInt1);
      float f2 = w(paramInt2);
      this.lK = false;
      a(localm.Dm, localm.Dn, f1, f2, paramInt1, paramInt2);
      if (!this.lK) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
      bool = true;
    }
    return bool;
  }
  
  private m T(int paramInt1, int paramInt2)
  {
    paramInt2 = (int)w(paramInt2);
    paramInt1 = (int)v(paramInt1);
    m localm2 = R(paramInt1, paramInt2);
    m localm1 = localm2;
    if (localm2 == null)
    {
      localm1 = new m();
      localm1.Dm = paramInt1;
      localm1.Dn = paramInt2;
    }
    return localm1;
  }
  
  private static boolean U(int paramInt1, int paramInt2)
  {
    return (paramInt1 >= 0) && (paramInt1 <= paramInt2);
  }
  
  private int a(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = paramInt4;
    if (Math.abs(paramInt4) < this.CY) {
      i = (int)Math.copySign(paramInt4, paramInt5);
    }
    float f = 0.5F / Math.max(Math.abs(0.5F - paramFloat), 0.001F);
    if ((Math.abs(paramInt5) > this.CX) && (f * 100.0F + Math.abs(i) > this.tI)) {
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
  
  private m a(Point paramPoint)
  {
    return (m)this.CH.get(paramPoint);
  }
  
  private View a(m paramm)
  {
    if (paramm.Dl != null)
    {
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = getChildAt(i);
        if (this.zN.a(localView, paramm.Dl)) {
          return localView;
        }
        i += 1;
      }
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, int paramInt4)
  {
    this.lK = true;
    if (this.CZ != null) {
      this.CZ.a(paramInt2, paramInt1, paramFloat2, paramFloat1, paramInt4, paramInt3);
    }
    if (this.Dd != null) {
      this.Dd.a(paramInt2, paramInt1, paramFloat2, paramFloat1, paramInt4, paramInt3);
    }
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3)
  {
    boolean bool = true;
    if (this.zN != null)
    {
      this.zN.getRowCount();
      if ((paramBoolean2) || (!this.CF.equals(paramInt2, paramInt1)) || (this.CH.size() == 0)) {}
    }
    else
    {
      return;
    }
    this.zN.getRowCount();
    paramInt1 = j(paramInt1, 0, 0);
    this.zN.fa();
    paramInt2 = j(paramInt2, 0, 1);
    if (paramInt2 != this.CF.x)
    {
      this.Da = 0;
      paramBoolean2 = bool;
    }
    while (this.lI)
    {
      this.CF.set(0, 0);
      i.fc();
      if (paramBoolean2)
      {
        if (this.CZ != null) {
          this.CZ.L(paramInt1, paramInt2);
        }
        if (this.Dd != null) {
          this.Dd.L(paramInt1, paramInt2);
        }
      }
      requestLayout();
      return;
      if (paramInt1 != this.CF.y)
      {
        this.Da = 1;
        paramBoolean2 = bool;
      }
      else
      {
        paramBoolean2 = false;
      }
    }
    Q(paramInt2, paramInt1);
    c(paramInt2, paramInt1, paramBoolean1, paramBoolean2);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.lz) {
      if (i != 0) {
        break label65;
      }
    }
    label65:
    for (i = 1;; i = 0)
    {
      this.CS = paramMotionEvent.getX(i);
      this.CT = paramMotionEvent.getY(i);
      this.lz = paramMotionEvent.getPointerId(i);
      if (this.lA != null) {
        this.lA.clear();
      }
      return;
    }
  }
  
  private void a(View paramView, GridViewPager.LayoutParams paramLayoutParams)
  {
    int j = 0;
    int m = fl();
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
  
  private m aE(View paramView)
  {
    int i = 0;
    while (i < this.CH.size())
    {
      m localm = (m)this.CH.valueAt(i);
      if ((localm != null) && (this.zN.a(paramView, localm.Dl))) {
        return localm;
      }
      i += 1;
    }
    return null;
  }
  
  private int aS(int paramInt)
  {
    return this.Db.get(paramInt, 0);
  }
  
  private int aT(int paramInt)
  {
    return (fl() + this.CN) * paramInt + getPaddingLeft();
  }
  
  private int aU(int paramInt)
  {
    return (getContentHeight() + this.CM) * paramInt + getPaddingTop();
  }
  
  private static String aV(int paramInt)
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
    if (this.Cs != null) {
      this.Cs.a(parami1, parami2);
    }
    if (this.Dd != null) {
      this.Dd.a(parami1, parami2);
    }
  }
  
  private void bA()
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(true);
    }
  }
  
  private void bv()
  {
    if (this.zN != null)
    {
      this.zN.getRowCount();
      Q(this.CF.x, this.CF.y);
    }
  }
  
  private void c(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    m localm = R(paramInt1, paramInt2);
    int j;
    int k;
    int i;
    if (localm != null)
    {
      j = aT(localm.Dm);
      k = getPaddingLeft();
      i = aU(localm.Dn) - getPaddingTop();
      j -= k;
    }
    for (;;)
    {
      i.fc();
      if (paramBoolean2)
      {
        if (this.CZ != null) {
          this.CZ.L(paramInt2, paramInt1);
        }
        if (this.Dd != null) {
          this.Dd.L(paramInt2, paramInt1);
        }
      }
      if (paramBoolean1)
      {
        if (getChildCount() != 0)
        {
          paramInt1 = aS(this.CF.y);
          paramInt2 = getScrollY();
          j -= paramInt1;
          i -= paramInt2;
          if ((j == 0) && (i == 0))
          {
            i(false);
            bv();
            z(0);
          }
        }
        else
        {
          return;
        }
        z(2);
        k = this.CD;
        this.lg.startScroll(paramInt1, paramInt2, j, i, k);
        r.f(this);
        return;
      }
      i(false);
      scrollTo(j, i);
      S(j, i);
      return;
      i = 0;
      j = 0;
    }
  }
  
  private void cm()
  {
    this.lt = false;
    this.CQ = false;
    if (this.lA != null)
    {
      this.lA.recycle();
      this.lA = null;
    }
  }
  
  private boolean f(MotionEvent paramMotionEvent)
  {
    if (this.lt) {
      return false;
    }
    this.lz = paramMotionEvent.getPointerId(0);
    this.CV = paramMotionEvent.getX();
    this.CU = paramMotionEvent.getY();
    this.CW = getScrollY();
    this.CS = this.CV;
    this.CT = this.CU;
    this.CQ = true;
    this.lA = VelocityTracker.obtain();
    this.lA.addMovement(paramMotionEvent);
    this.lg.computeScrollOffset();
    if (((this.kD != 2) && (this.kD != 3)) || (((this.Da == 0) && (Math.abs(this.lg.getFinalX() - this.lg.getCurrX()) > this.lE)) || ((this.Da == 1) && (Math.abs(this.lg.getFinalY() - this.lg.getCurrY()) > this.lE))))
    {
      this.lg.abortAnimation();
      this.CO = false;
      bv();
      this.lt = true;
      bA();
      z(1);
      return false;
    }
    i(false);
    this.lt = false;
    return false;
  }
  
  private int fl()
  {
    return getMeasuredWidth() - (getPaddingLeft() + getPaddingRight());
  }
  
  private void fm()
  {
    if (this.Cs != null) {
      this.Cs.onDataSetChanged();
    }
    if (this.Dd != null) {
      this.Dd.onDataSetChanged();
    }
  }
  
  private m fn()
  {
    return T(aS((int)w(getScrollY())), getScrollY());
  }
  
  private boolean g(MotionEvent paramMotionEvent)
  {
    int i = this.lz;
    if (i == -1) {
      return false;
    }
    i = paramMotionEvent.findPointerIndex(i);
    if (i == -1) {
      return this.lt;
    }
    float f4 = paramMotionEvent.getX(i);
    float f3 = paramMotionEvent.getY(i);
    float f6 = f4 - this.CS;
    float f1 = Math.abs(f6);
    float f5 = f3 - this.CT;
    float f2 = Math.abs(f5);
    label200:
    label216:
    label238:
    Object localObject;
    label262:
    label274:
    int j;
    int k;
    int m;
    int n;
    if ((!this.lt) && (f1 * f1 + f2 * f2 > this.CR))
    {
      this.lt = true;
      bA();
      z(1);
      if (f2 >= f1)
      {
        this.Da = 1;
        if ((f2 <= 0.0F) || (f1 <= 0.0F)) {
          break label923;
        }
        double d = Math.sqrt(f2 * f2 + f1 * f1);
        d = Math.acos(f1 / d);
        f1 = (float)(Math.sin(d) * this.kl);
        f2 = (float)(Math.cos(d) * this.kl);
        if (f6 <= 0.0F) {
          break label956;
        }
        f2 += this.CS;
        this.CS = f2;
        if (f5 <= 0.0F) {
          break label968;
        }
        f1 = this.CT + f1;
        this.CT = f1;
      }
    }
    else if (this.lt)
    {
      if (this.Da != 0) {
        break label980;
      }
      f1 = f4;
      if (this.Da != 1) {
        break label989;
      }
      f2 = f3;
      f4 = this.CS - f1;
      f3 = this.CT - f2;
      this.CS = f1;
      this.CT = f2;
      localObject = this.CJ;
      j = aT(((Rect)localObject).left) - getPaddingLeft();
      k = aT(((Rect)localObject).right) - getPaddingLeft();
      m = aU(((Rect)localObject).top) - getPaddingTop();
      n = aU(((Rect)localObject).bottom) - getPaddingTop();
      f6 = aS(this.CF.y);
      f2 = getScrollY();
      f5 = f2;
      f1 = f3;
      if (this.Da == 1)
      {
        i = getContentHeight() + this.CM;
        if (f3 >= 0.0F) {
          break label998;
        }
        f1 = -(f2 % i);
        label438:
        if (Math.abs(f1) > Math.abs(f3)) {
          break label1156;
        }
        f3 -= f1;
        f2 += f1;
      }
    }
    label1156:
    for (i = 1;; i = 0)
    {
      f5 = f2;
      f1 = f3;
      if (i != 0)
      {
        localObject = a(T((int)f6, (int)f2));
        f5 = f2;
        f1 = f3;
        if (localObject != null)
        {
          i = l((View)localObject, (int)Math.signum(f3));
          if (i <= 0) {
            break label1017;
          }
          f1 = Math.max(0.0F, Math.min(f3, i));
          label543:
          ((View)localObject).scrollBy(0, (int)f1);
          f3 -= f1;
          f5 = this.CT;
          this.CT = (f1 - (int)f1 + f5);
          f1 = f3;
          f5 = f2;
        }
      }
      i = (int)((int)f4 + f6);
      int i1 = (int)((int)f1 + f5);
      if ((i < j) || (i > k) || (i1 < m) || (i1 > n))
      {
        i = 1;
        label638:
        if (i == 0) {
          break label1149;
        }
        i1 = getOverScrollMode();
        if (((this.Da != 0) || (j >= k)) && ((this.Da != 1) || (m >= n))) {
          break label1040;
        }
        i = 1;
        label681:
        if ((i1 != 0) && ((i == 0) || (i1 != 1))) {
          break label1098;
        }
        if (f6 <= k) {
          break label1046;
        }
        f2 = f6 - k;
        label714:
        if (f5 <= n) {
          break label1072;
        }
        f3 = f5 - n;
        label731:
        if ((Math.abs(f2) <= 0.0F) || (Math.signum(f2) != Math.signum(f4))) {
          break label1142;
        }
        f2 = Cy.getInterpolation(1.0F - Math.abs(f2) / fl()) * f4;
        label781:
        if ((Math.abs(f3) <= 0.0F) || (Math.signum(f3) != Math.signum(f1))) {
          break label1139;
        }
        f1 = Cy.getInterpolation(1.0F - Math.abs(f3) / getContentHeight()) * f1;
      }
      for (;;)
      {
        f2 += f6;
        f1 += f5;
        this.CS += f2 - (int)f2;
        this.CT += f1 - (int)f1;
        scrollTo((int)f2, (int)f1);
        S((int)f2, (int)f1);
        r.f(this);
        this.lA.addMovement(paramMotionEvent);
        return this.lt;
        this.Da = 0;
        break;
        label923:
        if (f2 == 0.0F)
        {
          f2 = this.kl;
          f1 = 0.0F;
          break label200;
        }
        f2 = 0.0F;
        f1 = this.kl;
        break label200;
        label956:
        f2 = this.CS - f2;
        break label216;
        label968:
        f1 = this.CT - f1;
        break label238;
        label980:
        f1 = this.CS;
        break label262;
        label989:
        f2 = this.CT;
        break label274;
        label998:
        f1 = (i - f2 % i) % i;
        break label438;
        label1017:
        f1 = Math.min(0.0F, Math.max(f3, i));
        break label543;
        i = 0;
        break label638;
        label1040:
        i = 0;
        break label681;
        label1046:
        if (f6 < j)
        {
          f2 = f6 - j;
          break label714;
        }
        f2 = 0.0F;
        break label714;
        label1072:
        if (f5 < m)
        {
          f3 = f5 - m;
          break label731;
        }
        f3 = 0.0F;
        break label731;
        label1098:
        f2 = b(f4, j - f6, k - f6);
        f1 = b(f1, m - f5, n - f5);
        continue;
        label1139:
        continue;
        label1142:
        f2 = f4;
        break label781;
        label1149:
        f2 = f4;
      }
    }
  }
  
  private int getContentHeight()
  {
    return getMeasuredHeight() - (getPaddingTop() + getPaddingBottom());
  }
  
  private void i(boolean paramBoolean)
  {
    if (this.kD == 2) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.lg.abortAnimation();
        int j = aS(this.CF.y);
        int k = getScrollY();
        int m = this.lg.getCurrX();
        int n = this.lg.getCurrY();
        if ((j != m) || (k != n)) {
          scrollTo(m, n);
        }
      }
      this.Dc = null;
      this.CO = false;
      if (i != 0)
      {
        if (!paramBoolean) {
          break;
        }
        r.b(this, this.lV);
      }
      return;
    }
    this.lV.run();
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
  
  private static int l(View paramView, int paramInt)
  {
    int j = 0;
    int i;
    if ((paramView instanceof CardScrollView)) {
      i = ((CardScrollView)paramView).aQ(paramInt);
    }
    do
    {
      int k;
      int m;
      do
      {
        do
        {
          do
          {
            return i;
            i = j;
          } while (!(paramView instanceof ScrollView));
          paramView = (ScrollView)paramView;
          i = j;
        } while (paramView.getChildCount() <= 0);
        View localView = paramView.getChildAt(0);
        k = paramView.getHeight();
        m = localView.getHeight();
        i = j;
      } while (m <= k);
      if (paramInt > 0) {
        return Math.min(m - k - paramView.getScrollY(), 0);
      }
      i = j;
    } while (paramInt >= 0);
    return -paramView.getScrollY();
  }
  
  private float v(float paramFloat)
  {
    int i = fl() + this.CN;
    if (i == 0)
    {
      Log.e("GridViewPager", "getXIndex() called with zero width.");
      return 0.0F;
    }
    return paramFloat / i;
  }
  
  private float w(float paramFloat)
  {
    int i = getContentHeight() + this.CM;
    if (i == 0)
    {
      Log.e("GridViewPager", "getYIndex() called with zero height.");
      return 0.0F;
    }
    return paramFloat / i;
  }
  
  private void z(int paramInt)
  {
    if (this.kD == paramInt) {}
    do
    {
      return;
      this.kD = paramInt;
      if (this.CZ != null) {
        this.CZ.y(paramInt);
      }
    } while (this.Dd == null);
    this.Dd.y(paramInt);
  }
  
  public final void a(i parami)
  {
    int i;
    if (this.zN != null)
    {
      this.zN.unregisterDataSetObserver(this.CL);
      this.zN.a(null);
      i.fd();
      i = 0;
      while (i < this.CH.size())
      {
        localObject1 = (m)this.CH.valueAt(i);
        this.zN.b(this, ((m)localObject1).Dl);
        i += 1;
      }
      i.fe();
      this.CH.clear();
      removeAllViews();
      scrollTo(0, 0);
      this.Db.clear();
    }
    Object localObject1 = this.zN;
    this.CF.set(0, 0);
    this.zN = parami;
    this.CA = 0;
    this.CB = 0;
    boolean bool;
    Object localObject2;
    if (this.zN != null)
    {
      if (this.CL == null) {
        this.CL = new p(this, (byte)0);
      }
      this.zN.registerDataSetObserver(this.CL);
      this.zN.a(this.Dd);
      this.CO = false;
      bool = this.lI;
      this.lI = true;
      this.CA = this.zN.getRowCount();
      if (this.CA > 0)
      {
        this.CF.set(0, 0);
        localObject2 = this.zN;
        i = this.CF.y;
        this.CB = ((i)localObject2).fa();
      }
      if (this.CG != null)
      {
        i.fj();
        b(this.CG.y, this.CG.x, false, true);
        this.CG = null;
        this.le = null;
        this.lf = null;
      }
    }
    while (localObject1 != parami) {
      if (parami == null)
      {
        this.Dg = false;
        b((i)localObject1, parami);
        this.Dh = null;
        return;
        if (!bool)
        {
          bv();
        }
        else
        {
          requestLayout();
          continue;
          if (this.lt)
          {
            cancelPendingInputEvents();
            long l = SystemClock.uptimeMillis();
            localObject2 = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
            ((MotionEvent)localObject2).setSource(4098);
            dispatchTouchEvent((MotionEvent)localObject2);
            ((MotionEvent)localObject2).recycle();
          }
        }
      }
      else
      {
        this.Dg = true;
        this.Dh = ((i)localObject1);
        return;
      }
    }
    this.Dg = false;
    this.Dh = null;
  }
  
  public final void a(n paramn)
  {
    this.Cs = paramn;
    if ((paramn != null) && (this.zN != null) && (!this.Dg)) {
      paramn.a(null, this.zN);
    }
  }
  
  public final void a(o paramo)
  {
    this.CZ = paramo;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    aE(paramView);
    if (!checkLayoutParams(paramLayoutParams)) {
      paramLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    for (;;)
    {
      GridViewPager.LayoutParams localLayoutParams = (GridViewPager.LayoutParams)paramLayoutParams;
      if (this.aU)
      {
        localLayoutParams.mb = true;
        addViewInLayout(paramView, paramInt, paramLayoutParams);
      }
      for (;;)
      {
        if (this.De != null) {
          paramView.onApplyWindowInsets(this.De);
        }
        return;
        super.addView(paramView, paramInt, paramLayoutParams);
      }
    }
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    boolean bool = true;
    if ((getVisibility() != 0) || (this.zN == null) || (this.CH.isEmpty())) {
      bool = false;
    }
    int i;
    do
    {
      int j;
      do
      {
        return bool;
        i = aS(this.CF.y);
        j = this.CB;
        if (paramInt <= 0) {
          break;
        }
      } while (i + getPaddingLeft() < aT(j - 1));
      return false;
    } while (i > 0);
    return false;
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    boolean bool = true;
    if ((getVisibility() != 0) || (this.zN == null) || (this.CH.isEmpty())) {
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
        j = this.CA;
        if (paramInt <= 0) {
          break;
        }
      } while (i + getPaddingTop() < aU(j - 1));
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
    if ((!this.lg.isFinished()) && (this.lg.computeScrollOffset()))
    {
      if (this.kD == 3) {
        if (this.Dc == null) {
          this.lg.abortAnimation();
        }
      }
      for (;;)
      {
        r.f(this);
        return;
        int i = this.lg.getCurrX();
        int j = this.lg.getCurrY();
        this.Dc.scrollTo(i, j);
        continue;
        i = aS(this.CF.y);
        j = getScrollY();
        int k = this.lg.getCurrX();
        int m = this.lg.getCurrY();
        if ((i != k) || (j != m))
        {
          scrollTo(k, m);
          if (!S(k, m))
          {
            this.lg.abortAnimation();
            scrollTo(0, 0);
          }
        }
      }
    }
    i(true);
  }
  
  protected void debug(int paramInt)
  {
    super.debug(paramInt);
    String str = aV(paramInt);
    Log.d("View", str + "mCurItem={" + this.CF + "}");
    str = aV(paramInt);
    Log.d("View", str + "mAdapter={" + this.zN + "}");
    str = aV(paramInt);
    Log.d("View", str + "mRowCount=" + this.CA);
    str = aV(paramInt);
    Log.d("View", str + "mCurrentColumnCount=" + this.CB);
    int j = this.CH.size();
    if (j != 0)
    {
      str = aV(paramInt);
      Log.d("View", str + "mItems={");
    }
    int i = 0;
    while (i < j)
    {
      str = aV(paramInt + 1);
      Log.d("View", str + this.CH.keyAt(i) + " => " + this.CH.valueAt(i));
      i += 1;
    }
    if (j != 0)
    {
      str = aV(paramInt);
      Log.d("View", str + "}");
    }
  }
  
  public WindowInsets dispatchApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    WindowInsets localWindowInsets = onApplyWindowInsets(paramWindowInsets);
    if (this.Df != null) {
      this.Df.onApplyWindowInsets(this, localWindowInsets);
    }
    paramWindowInsets = localWindowInsets;
    if (this.CC) {
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
      if (this.CF.x > 0)
      {
        O(this.CF.x - 1, this.CF.y);
        i = 1;
      }
      else
      {
        i = 0;
        continue;
        if (this.zN != null)
        {
          i = this.CF.x;
          paramKeyEvent = this.zN;
          int j = this.CF.y;
          paramKeyEvent.fa();
          if (i <= 0)
          {
            O(this.CF.x + 1, this.CF.y);
            i = 1;
            continue;
          }
        }
        i = 0;
        continue;
        if (this.CF.y > 0)
        {
          O(this.CF.x, this.CF.y - 1);
          i = 1;
        }
        else
        {
          i = 0;
          continue;
          if (this.zN != null)
          {
            i = this.CF.y;
            this.zN.getRowCount();
            if (i < 0)
            {
              O(this.CF.x, this.CF.y + 1);
              i = 1;
              continue;
            }
          }
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
  
  public final i fk()
  {
    return this.zN;
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
    this.De = paramWindowInsets;
    return paramWindowInsets;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.lI = true;
    getParent().requestFitSystemWindows();
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.lV);
    super.onDetachedFromWindow();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i == 3) || (i == 1))
    {
      this.lt = false;
      this.CQ = false;
      this.lz = -1;
      if (this.lA != null)
      {
        this.lA.recycle();
        this.lA = null;
      }
      bool = false;
    }
    do
    {
      return bool;
      if (i == 0) {
        break;
      }
    } while (this.lt);
    if (!this.CQ) {
      return false;
    }
    switch (i)
    {
    }
    for (;;)
    {
      return this.lt;
      f(paramMotionEvent);
      continue;
      g(paramMotionEvent);
      continue;
      a(paramMotionEvent);
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
        Log.w("GridViewPager", "Got null layout params for child: " + localView);
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        m localm = aE(localView);
        if (localm == null)
        {
          Log.w("GridViewPager", "Unknown child view, not claimed by adapter: " + localView);
        }
        else
        {
          if (localLayoutParams.mb)
          {
            localLayoutParams.mb = false;
            a(localView, localLayoutParams);
          }
          paramInt4 = aT(localm.Dm);
          paramInt3 = aU(localm.Dn);
          paramInt4 = paramInt4 - aS(localm.Dn) + localLayoutParams.leftMargin;
          paramInt3 = localLayoutParams.topMargin + paramInt3;
          localView.layout(paramInt4, paramInt3, localView.getMeasuredWidth() + paramInt4, localView.getMeasuredHeight() + paramInt3);
        }
      }
    }
    if ((this.lI) && (!this.CH.isEmpty())) {
      c(this.CF.x, this.CF.y, false, false);
    }
    this.lI = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    this.aU = true;
    bv();
    this.aU = false;
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
    int j = paramParcelable.Do;
    if (U(paramParcelable.Dp, this.CA - 1))
    {
      this.zN.fa();
      if (!U(j, 1)) {}
    }
    while (i != 0)
    {
      this.CG = new Point(paramParcelable.Do, paramParcelable.Dp);
      return;
      i = 0;
    }
    this.CF.set(0, 0);
    scrollTo(0, 0);
  }
  
  public Parcelable onSaveInstanceState()
  {
    GridViewPager.SavedState localSavedState = new GridViewPager.SavedState(super.onSaveInstanceState());
    localSavedState.Do = this.CF.x;
    localSavedState.Dp = this.CF.y;
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    m localm;
    if (!this.CH.isEmpty())
    {
      int i2 = this.CN;
      int i3 = this.CN;
      int i = this.CM;
      int j = this.CM;
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
      float f = aS(this.CF.y) / (i3 + (paramInt3 - i6 - i7));
      paramInt1 = (int)((i2 + (paramInt1 - i4 - i5)) * f);
      paramInt2 = (int)(getScrollY() / (j + (paramInt4 - n - i1)) * (i + (paramInt2 - k - m)));
      scrollTo(paramInt1, paramInt2);
      if (!this.lg.isFinished())
      {
        localm = a(this.CF);
        paramInt3 = aT(localm.Dm);
        paramInt4 = getPaddingLeft();
        i = aU(localm.Dn);
        j = getPaddingTop();
        k = this.lg.getDuration();
        m = this.lg.timePassed();
        this.lg.startScroll(paramInt1, paramInt2, paramInt3 - paramInt4, i - j, k - m);
      }
    }
    label275:
    do
    {
      do
      {
        return;
        localm = a(this.CF);
      } while (localm == null);
      paramInt1 = aT(localm.Dm) - getPaddingLeft();
      paramInt2 = aU(localm.Dn) - getPaddingTop();
    } while ((paramInt1 == aS(localm.Dn)) && (paramInt2 == getScrollY()));
    i(false);
    scrollTo(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.zN == null) {
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
      Log.e("GridViewPager", "Unknown action type: " + i);
    case 0: 
    case 2: 
    case 1: 
    case 3: 
      for (;;)
      {
        return true;
        f(paramMotionEvent);
        continue;
        g(paramMotionEvent);
        continue;
        if ((this.lt) && (this.CA != 0)) {
          break;
        }
        this.lz = -1;
        cm();
      }
      localVelocityTracker = this.lA;
      localVelocityTracker.addMovement(paramMotionEvent);
      localVelocityTracker.computeCurrentVelocity(1000);
      m = paramMotionEvent.findPointerIndex(this.lz);
      i = this.CF.x;
      j = this.CF.y;
      k = 0;
      localm = fn();
      switch (this.Da)
      {
      default: 
        label212:
        if (this.kD != 3)
        {
          this.CO = true;
          if (j == this.CF.y) {
            break label639;
          }
          i = this.CF.x;
          i = i.fb();
        }
        break;
      }
      break;
    }
    label505:
    label639:
    for (;;)
    {
      a(j, i, true, true, k);
      this.lz = -1;
      cm();
      break;
      i = (int)(paramMotionEvent.getRawX() - this.CV);
      k = (int)localVelocityTracker.getXVelocity(this.lz);
      m = localm.Dm;
      float f = v(aS(localm.Dn) - aT(localm.Dm));
      int n = this.CF.x;
      i = a(m, f, this.CJ.left, this.CJ.right, k, i);
      break label212;
      paramMotionEvent.getX(m);
      m = this.CW;
      n = getScrollY();
      k = (int)localVelocityTracker.getYVelocity(this.lz);
      int i1 = localm.Dn;
      f = w(getScrollY() - aU(localm.Dn));
      if (f == 0.0F)
      {
        paramMotionEvent = a(fn());
        n = l(paramMotionEvent, -k);
        int i2;
        if (n != 0)
        {
          this.Dc = paramMotionEvent;
          if (Math.abs(k) >= Math.abs(this.tI))
          {
            i2 = -k;
            if (this.Dc != null)
            {
              if (i2 != 0) {
                break label505;
              }
              i(false);
              z(0);
            }
            cm();
          }
        }
        break label212;
        int i3 = this.Dc.getScrollX();
        m = this.Dc.getScrollY();
        z(3);
        if (i2 > 0)
        {
          i1 = m + n;
          n = m;
        }
        for (;;)
        {
          this.lg.fling(i3, m, 0, i2, i3 + 0, i3, n, i1);
          r.f(this);
          break;
          n = m + n;
          i1 = m;
        }
      }
      j = this.CF.y;
      j = a(i1, f, this.CJ.top, this.CJ.bottom, k, m - n);
      break label212;
      a(paramMotionEvent);
      break;
    }
  }
  
  public void removeView(View paramView)
  {
    aE(paramView);
    if (this.aU)
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
    if (this.kD == 2)
    {
      i = paramInt1;
      if (this.Da == 1) {
        i = aS(this.CF.y);
      }
    }
    super.scrollTo(0, paramInt2);
    paramInt2 = this.CF.y;
    if (aS(paramInt2) != i)
    {
      int k = getChildCount();
      int m = aS(paramInt2);
      paramInt1 = j;
      while (paramInt1 < k)
      {
        View localView = getChildAt(paramInt1);
        m localm = aE(localView);
        if ((localm != null) && (localm.Dn == paramInt2))
        {
          localView.offsetLeftAndRight(-(i - m));
          postInvalidateOnAnimation();
        }
        paramInt1 += 1;
      }
      N(paramInt2, i);
    }
  }
  
  public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    this.Df = paramOnApplyWindowInsetsListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.GridViewPager
 * JD-Core Version:    0.7.0.1
 */