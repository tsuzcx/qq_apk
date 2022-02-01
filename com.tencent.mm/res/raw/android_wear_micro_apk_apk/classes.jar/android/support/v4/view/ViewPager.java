package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager
  extends ViewGroup
{
  static final int[] mR = { 16842931 };
  private static final Comparator<ai> mT = new Comparator() {};
  private static final Interpolator mU = new Interpolator()
  {
    public final float getInterpolation(float paramAnonymousFloat)
    {
      paramAnonymousFloat -= 1.0F;
      return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
    }
  };
  private static final an nQ = new an();
  private boolean cE;
  private int mS;
  private final ArrayList<ai> mV = new ArrayList();
  private final ai mW = new ai();
  o mX;
  int mY;
  private int mZ = -1;
  private final Rect ma = new Rect();
  private float mg;
  private float mh;
  private int mi;
  private int mz = 0;
  private int nA;
  private boolean nB;
  private EdgeEffect nC;
  private EdgeEffect nD;
  private boolean nE = true;
  private boolean nF = false;
  private boolean nG;
  private int nH;
  private List<al> nI;
  private al nJ;
  private al nK;
  private List<ak> nL;
  private am nM;
  private int nN;
  private int nO;
  private ArrayList<View> nP;
  private final Runnable nR = new Runnable()
  {
    public final void run()
    {
      ViewPager.this.K(0);
      ViewPager.this.bM();
    }
  };
  private Parcelable na = null;
  private ClassLoader nb = null;
  private Scroller nc;
  private boolean nd;
  private int ne;
  private Drawable nf;
  private int ng;
  private int nh;
  private float ni = -3.402824E+038F;
  private float nj = 3.4028235E+38F;
  private int nk;
  private int nl;
  private boolean nm;
  private boolean nn;
  private int no = 1;
  private boolean np;
  private boolean nq;
  private int nr;
  private int ns;
  private float nt;
  private float nu;
  private int nv = -1;
  private VelocityTracker nw;
  private int nx;
  private int ny;
  private int nz;
  
  public ViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    paramContext = getContext();
    this.nc = new Scroller(paramContext, mU);
    paramAttributeSet = ViewConfiguration.get(paramContext);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.mi = paramAttributeSet.getScaledPagingTouchSlop();
    this.nx = ((int)(400.0F * f));
    this.ny = paramAttributeSet.getScaledMaximumFlingVelocity();
    this.nC = new EdgeEffect(paramContext);
    this.nD = new EdgeEffect(paramContext);
    this.nz = ((int)(25.0F * f));
    this.nA = ((int)(2.0F * f));
    this.nr = ((int)(16.0F * f));
    r.a(this, new aj(this));
    if (r.h(this) == 0) {
      r.f(this, 1);
    }
    r.a(this, new n()
    {
      private final Rect ma = new Rect();
      
      public final av a(View paramAnonymousView, av paramAnonymousav)
      {
        paramAnonymousView = r.a(paramAnonymousView, paramAnonymousav);
        if (paramAnonymousView.isConsumed()) {
          return paramAnonymousView;
        }
        paramAnonymousav = this.ma;
        paramAnonymousav.left = paramAnonymousView.getSystemWindowInsetLeft();
        paramAnonymousav.top = paramAnonymousView.getSystemWindowInsetTop();
        paramAnonymousav.right = paramAnonymousView.getSystemWindowInsetRight();
        paramAnonymousav.bottom = paramAnonymousView.getSystemWindowInsetBottom();
        int i = 0;
        int j = ViewPager.this.getChildCount();
        while (i < j)
        {
          av localav = r.b(ViewPager.this.getChildAt(i), paramAnonymousView);
          paramAnonymousav.left = Math.min(localav.getSystemWindowInsetLeft(), paramAnonymousav.left);
          paramAnonymousav.top = Math.min(localav.getSystemWindowInsetTop(), paramAnonymousav.top);
          paramAnonymousav.right = Math.min(localav.getSystemWindowInsetRight(), paramAnonymousav.right);
          paramAnonymousav.bottom = Math.min(localav.getSystemWindowInsetBottom(), paramAnonymousav.bottom);
          i += 1;
        }
        return paramAnonymousView.a(paramAnonymousav.left, paramAnonymousav.top, paramAnonymousav.right, paramAnonymousav.bottom);
      }
    });
  }
  
  private ai C(View paramView)
  {
    for (;;)
    {
      paramView = paramView.getParent();
      if (paramView == this) {
        break;
      }
      if ((paramView == null) || (!(paramView instanceof View))) {
        return null;
      }
      paramView = (View)paramView;
    }
    return bO();
  }
  
  private void M(int paramInt)
  {
    this.nn = false;
    a(paramInt, true, false);
  }
  
  private ai N(int paramInt)
  {
    new ai().position = paramInt;
    throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
  }
  
  private void O(int paramInt)
  {
    ai localai;
    if (this.mY != paramInt)
    {
      localai = P(this.mY);
      this.mY = paramInt;
    }
    for (;;)
    {
      if (this.mX == null) {
        bN();
      }
      do
      {
        return;
        if (this.nn)
        {
          bN();
          return;
        }
      } while (getWindowToken() == null);
      paramInt = this.no;
      int i1 = Math.max(0, this.mY - paramInt);
      int m = this.mX.getCount();
      int n = Math.min(m - 1, paramInt + this.mY);
      Object localObject1;
      if (m != this.mS) {
        try
        {
          String str = getResources().getResourceName(getId());
          throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mS + ", found: " + m + " Pager id: " + str + " Pager class: " + getClass() + " Problematic adapter: " + this.mX.getClass());
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          for (;;)
          {
            localObject1 = Integer.toHexString(getId());
          }
        }
      }
      paramInt = 0;
      label212:
      if (paramInt < this.mV.size())
      {
        localObject1 = (ai)this.mV.get(paramInt);
        if (((ai)localObject1).position >= this.mY) {
          if (((ai)localObject1).position != this.mY) {
            break label1125;
          }
        }
      }
      label778:
      label907:
      for (;;)
      {
        if ((localObject1 == null) && (m > 0)) {}
        label412:
        label564:
        for (Object localObject2 = N(this.mY);; localObject2 = localObject1)
        {
          float f1;
          int k;
          label311:
          int i2;
          float f2;
          label324:
          int j;
          int i;
          if (localObject2 != null)
          {
            f1 = 0.0F;
            k = paramInt - 1;
            if (k >= 0)
            {
              localObject1 = (ai)this.mV.get(k);
              i2 = bL();
              if (i2 > 0) {
                break label440;
              }
              f2 = 0.0F;
              j = this.mY - 1;
              i = paramInt;
              paramInt = k;
              label338:
              if (j < 0) {
                break label564;
              }
              if ((f1 < f2) || (j >= i1)) {
                break label467;
              }
              if (localObject1 == null) {
                break label564;
              }
              if ((j != ((ai)localObject1).position) || (((ai)localObject1).nT)) {
                break label1115;
              }
              this.mV.remove(paramInt);
              o.bG();
              paramInt -= 1;
              if (paramInt < 0) {
                break label461;
              }
              localObject1 = (ai)this.mV.get(paramInt);
              i -= 1;
            }
          }
          label440:
          label461:
          label467:
          label1107:
          label1113:
          label1115:
          for (;;)
          {
            j -= 1;
            break label338;
            paramInt += 1;
            break label212;
            localObject1 = null;
            break label311;
            f2 = 2.0F - ((ai)localObject2).nU + getPaddingLeft() / i2;
            break label324;
            localObject1 = null;
            break label412;
            if ((localObject1 != null) && (j == ((ai)localObject1).position))
            {
              f1 += ((ai)localObject1).nU;
              paramInt -= 1;
              if (paramInt >= 0) {
                localObject1 = (ai)this.mV.get(paramInt);
              } else {
                localObject1 = null;
              }
            }
            else
            {
              f1 += N(j).nU;
              i += 1;
              if (paramInt >= 0) {}
              for (localObject1 = (ai)this.mV.get(paramInt);; localObject1 = null) {
                break;
              }
              float f3 = ((ai)localObject2).nU;
              k = i + 1;
              if (f3 < 2.0F)
              {
                label617:
                Object localObject3;
                if (k < this.mV.size())
                {
                  localObject1 = (ai)this.mV.get(k);
                  if (i2 > 0) {
                    break label763;
                  }
                  f2 = 0.0F;
                  j = this.mY + 1;
                  localObject3 = localObject1;
                  label629:
                  if (j >= m) {
                    break label907;
                  }
                  if ((f3 < f2) || (j <= n)) {
                    break label790;
                  }
                  if (localObject3 == null) {
                    break label907;
                  }
                  localObject1 = localObject3;
                  f1 = f3;
                  paramInt = k;
                  if (j == localObject3.position)
                  {
                    localObject1 = localObject3;
                    f1 = f3;
                    paramInt = k;
                    if (!localObject3.nT)
                    {
                      this.mV.remove(k);
                      o.bG();
                      if (k >= this.mV.size()) {
                        break label778;
                      }
                      localObject1 = (ai)this.mV.get(k);
                      paramInt = k;
                      f1 = f3;
                    }
                  }
                }
                for (;;)
                {
                  j += 1;
                  localObject3 = localObject1;
                  f3 = f1;
                  k = paramInt;
                  break label629;
                  localObject1 = null;
                  break;
                  label763:
                  f2 = getPaddingRight() / i2 + 2.0F;
                  break label617;
                  localObject1 = null;
                  f1 = f3;
                  paramInt = k;
                  continue;
                  if ((localObject3 != null) && (j == localObject3.position))
                  {
                    f1 = f3 + localObject3.nU;
                    paramInt = k + 1;
                    if (paramInt < this.mV.size()) {
                      localObject1 = (ai)this.mV.get(paramInt);
                    } else {
                      localObject1 = null;
                    }
                  }
                  else
                  {
                    localObject1 = N(j);
                    paramInt = k + 1;
                    f1 = f3 + ((ai)localObject1).nU;
                    if (paramInt < this.mV.size()) {
                      localObject1 = (ai)this.mV.get(paramInt);
                    } else {
                      localObject1 = null;
                    }
                  }
                }
              }
              a((ai)localObject2, i, localai);
              i = getChildCount();
              paramInt = 0;
              while (paramInt < i)
              {
                localObject1 = (ViewPager.LayoutParams)getChildAt(paramInt).getLayoutParams();
                ((ViewPager.LayoutParams)localObject1).nY = paramInt;
                if ((!((ViewPager.LayoutParams)localObject1).nW) && (((ViewPager.LayoutParams)localObject1).nU == 0.0F))
                {
                  localai = bO();
                  if (localai != null)
                  {
                    ((ViewPager.LayoutParams)localObject1).nU = localai.nU;
                    ((ViewPager.LayoutParams)localObject1).position = localai.position;
                  }
                }
                paramInt += 1;
              }
              bN();
              if (!hasFocus()) {
                break;
              }
              localObject1 = findFocus();
              if (localObject1 != null) {}
              for (localObject1 = C((View)localObject1);; localObject1 = null)
              {
                if ((localObject1 != null) && (((ai)localObject1).position == this.mY)) {
                  break label1113;
                }
                paramInt = 0;
                for (;;)
                {
                  if (paramInt >= getChildCount()) {
                    break label1107;
                  }
                  localObject1 = getChildAt(paramInt);
                  localai = bO();
                  if ((localai != null) && (localai.position == this.mY) && (((View)localObject1).requestFocus(2))) {
                    break;
                  }
                  paramInt += 1;
                }
                break;
              }
              break;
            }
          }
        }
        label790:
        label1125:
        localObject1 = null;
      }
      localai = null;
    }
  }
  
  private ai P(int paramInt)
  {
    int i = 0;
    while (i < this.mV.size())
    {
      ai localai = (ai)this.mV.get(i);
      if (localai.position == paramInt) {
        return localai;
      }
      i += 1;
    }
    return null;
  }
  
  private boolean Q(int paramInt)
  {
    if (this.mV.size() == 0)
    {
      if (this.nE) {}
      do
      {
        return false;
        this.nG = false;
        a(0, 0.0F, 0);
      } while (this.nG);
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    ai localai = bS();
    int j = bL();
    int k = this.ne;
    float f = this.ne / j;
    int i = localai.position;
    f = (paramInt / j - localai.nV) / (localai.nU + f);
    paramInt = (int)((k + j) * f);
    this.nG = false;
    a(i, f, paramInt);
    if (!this.nG) {
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    return true;
  }
  
  private static float a(float paramFloat)
  {
    return (float)Math.sin((paramFloat - 0.5F) * 0.4712389F);
  }
  
  private Rect a(Rect paramRect, View paramView)
  {
    if (paramRect == null) {
      paramRect = new Rect();
    }
    for (;;)
    {
      if (paramView == null)
      {
        paramRect.set(0, 0, 0, 0);
        return paramRect;
      }
      paramRect.left = paramView.getLeft();
      paramRect.right = paramView.getRight();
      paramRect.top = paramView.getTop();
      paramRect.bottom = paramView.getBottom();
      for (paramView = paramView.getParent(); ((paramView instanceof ViewGroup)) && (paramView != this); paramView = paramView.getParent())
      {
        paramView = (ViewGroup)paramView;
        paramRect.left += paramView.getLeft();
        paramRect.right += paramView.getRight();
        paramRect.top += paramView.getTop();
        paramRect.bottom += paramView.getBottom();
      }
      return paramRect;
    }
  }
  
  private void a(int paramInt1, float paramFloat, int paramInt2)
  {
    int j;
    int i1;
    int k;
    View localView;
    int i;
    label119:
    int m;
    if (this.nH > 0)
    {
      int n = getScrollX();
      paramInt2 = getPaddingLeft();
      j = getPaddingRight();
      i1 = getWidth();
      int i2 = getChildCount();
      k = 0;
      if (k < i2)
      {
        localView = getChildAt(k);
        ViewPager.LayoutParams localLayoutParams = (ViewPager.LayoutParams)localView.getLayoutParams();
        if (!localLayoutParams.nW) {
          break label312;
        }
        switch (localLayoutParams.gravity & 0x7)
        {
        case 2: 
        case 4: 
        default: 
          i = paramInt2;
          int i3 = i + n - localView.getLeft();
          m = j;
          i = paramInt2;
          if (i3 != 0)
          {
            localView.offsetLeftAndRight(i3);
            i = paramInt2;
            m = j;
          }
          break;
        }
      }
    }
    for (;;)
    {
      k += 1;
      paramInt2 = i;
      j = m;
      break;
      m = paramInt2 + localView.getWidth();
      i = paramInt2;
      paramInt2 = m;
      break label119;
      i = Math.max((i1 - localView.getMeasuredWidth()) / 2, paramInt2);
      break label119;
      i = i1 - j - localView.getMeasuredWidth();
      j += localView.getMeasuredWidth();
      break label119;
      b(paramInt1, paramFloat);
      if (this.nM != null)
      {
        getScrollX();
        paramInt2 = getChildCount();
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          localView = getChildAt(paramInt1);
          if (!((ViewPager.LayoutParams)localView.getLayoutParams()).nW)
          {
            localView.getLeft();
            bL();
          }
          paramInt1 += 1;
        }
      }
      this.nG = true;
      return;
      label312:
      m = j;
      i = paramInt2;
    }
  }
  
  private void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    ai localai = P(paramInt1);
    float f;
    if (localai != null) {
      f = bL();
    }
    for (paramInt1 = (int)(Math.max(this.ni, Math.min(localai.nV, this.nj)) * f);; paramInt1 = 0)
    {
      if (paramBoolean1)
      {
        d(paramInt1, paramInt2);
        if (paramBoolean2) {
          bP();
        }
        return;
      }
      if (paramBoolean2) {
        bP();
      }
      l(false);
      scrollTo(paramInt1, 0);
      Q(paramInt1);
      return;
    }
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  private void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    boolean bool = false;
    if ((this.mX == null) || (this.mX.getCount() <= 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    if ((!paramBoolean2) && (this.mY == paramInt1) && (this.mV.size() != 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    int i;
    if (paramInt1 < 0) {
      i = 0;
    }
    for (;;)
    {
      paramInt1 = this.no;
      if ((i <= this.mY + paramInt1) && (i >= this.mY - paramInt1)) {
        break;
      }
      paramInt1 = 0;
      while (paramInt1 < this.mV.size())
      {
        ((ai)this.mV.get(paramInt1)).nT = true;
        paramInt1 += 1;
      }
      i = paramInt1;
      if (paramInt1 >= this.mX.getCount()) {
        i = this.mX.getCount() - 1;
      }
    }
    paramBoolean2 = bool;
    if (this.mY != i) {
      paramBoolean2 = true;
    }
    if (this.nE)
    {
      this.mY = i;
      if (paramBoolean2) {
        bP();
      }
      requestLayout();
      return;
    }
    O(i);
    a(i, paramBoolean1, paramInt2, paramBoolean2);
  }
  
  private void a(ai paramai1, int paramInt, ai paramai2)
  {
    int m = this.mX.getCount();
    int i = bL();
    float f2;
    if (i > 0)
    {
      f2 = this.ne / i;
      if (paramai2 == null) {
        break label393;
      }
      i = paramai2.position;
      if (i < paramai1.position)
      {
        f1 = paramai2.nV + paramai2.nU + f2;
        i += 1;
        j = 0;
      }
    }
    else
    {
      for (;;)
      {
        if ((i > paramai1.position) || (j >= this.mV.size())) {
          break label393;
        }
        for (paramai2 = (ai)this.mV.get(j);; paramai2 = (ai)this.mV.get(j))
        {
          k = i;
          f3 = f1;
          if (i <= paramai2.position) {
            break;
          }
          k = i;
          f3 = f1;
          if (j >= this.mV.size() - 1) {
            break;
          }
          j += 1;
        }
        f2 = 0.0F;
        break;
        while (k < paramai2.position)
        {
          f3 += 1.0F + f2;
          k += 1;
        }
        paramai2.nV = f3;
        f1 = f3 + (paramai2.nU + f2);
        i = k + 1;
      }
    }
    if (i > paramai1.position)
    {
      j = this.mV.size() - 1;
      f1 = paramai2.nV;
      i -= 1;
      while ((i >= paramai1.position) && (j >= 0))
      {
        for (paramai2 = (ai)this.mV.get(j);; paramai2 = (ai)this.mV.get(j))
        {
          k = i;
          f3 = f1;
          if (i >= paramai2.position) {
            break;
          }
          k = i;
          f3 = f1;
          if (j <= 0) {
            break;
          }
          j -= 1;
        }
        while (k > paramai2.position)
        {
          f3 -= 1.0F + f2;
          k -= 1;
        }
        f1 = f3 - (paramai2.nU + f2);
        paramai2.nV = f1;
        i = k - 1;
      }
    }
    label393:
    int k = this.mV.size();
    float f3 = paramai1.nV;
    i = paramai1.position - 1;
    if (paramai1.position == 0)
    {
      f1 = paramai1.nV;
      this.ni = f1;
      if (paramai1.position != m - 1) {
        break label526;
      }
      f1 = paramai1.nV + paramai1.nU - 1.0F;
      label459:
      this.nj = f1;
      j = paramInt - 1;
      f1 = f3;
    }
    for (;;)
    {
      if (j < 0) {
        break label579;
      }
      paramai2 = (ai)this.mV.get(j);
      for (;;)
      {
        if (i > paramai2.position)
        {
          i -= 1;
          f1 -= 1.0F + f2;
          continue;
          f1 = -3.402824E+038F;
          break;
          label526:
          f1 = 3.4028235E+38F;
          break label459;
        }
      }
      f1 -= paramai2.nU + f2;
      paramai2.nV = f1;
      if (paramai2.position == 0) {
        this.ni = f1;
      }
      i -= 1;
      j -= 1;
    }
    label579:
    float f1 = paramai1.nV + paramai1.nU + f2;
    int j = paramai1.position + 1;
    i = paramInt + 1;
    paramInt = j;
    while (i < k)
    {
      paramai1 = (ai)this.mV.get(i);
      while (paramInt < paramai1.position)
      {
        paramInt += 1;
        f1 += 1.0F + f2;
      }
      if (paramai1.position == m - 1) {
        this.nj = (paramai1.nU + f1 - 1.0F);
      }
      paramai1.nV = f1;
      f1 += paramai1.nU + f2;
      paramInt += 1;
      i += 1;
    }
    this.nF = false;
  }
  
  private boolean a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = paramView.getScrollX();
      int k = paramView.getScrollY();
      i = localViewGroup.getChildCount() - 1;
      if (i >= 0)
      {
        localView = localViewGroup.getChildAt(i);
        if ((paramInt2 + j < localView.getLeft()) || (paramInt2 + j >= localView.getRight()) || (paramInt3 + k < localView.getTop()) || (paramInt3 + k >= localView.getBottom()) || (!a(localView, true, paramInt1, paramInt2 + j - localView.getLeft(), paramInt3 + k - localView.getTop()))) {}
      }
    }
    while ((paramBoolean) && (paramView.canScrollHorizontally(-paramInt1)))
    {
      View localView;
      return true;
      i -= 1;
      break;
    }
    return false;
  }
  
  private boolean arrowScroll(int paramInt)
  {
    View localView = findFocus();
    Object localObject;
    int j;
    boolean bool;
    if (localView == this)
    {
      localObject = null;
      localView = FocusFinder.getInstance().findNextFocus(this, (View)localObject, paramInt);
      if ((localView == null) || (localView == localObject)) {
        break label317;
      }
      if (paramInt != 17) {
        break label263;
      }
      i = a(this.ma, localView).left;
      j = a(this.ma, (View)localObject).left;
      if ((localObject != null) && (i >= j))
      {
        bool = bU();
        label89:
        if (bool) {
          playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
        }
        return bool;
      }
    }
    else
    {
      if (localView == null) {
        break label363;
      }
      localObject = localView.getParent();
      if (!(localObject instanceof ViewGroup)) {
        break label370;
      }
      if (localObject != this) {}
    }
    label263:
    label317:
    label357:
    label363:
    label370:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localView.getClass().getSimpleName());
        localObject = localView.getParent();
        for (;;)
        {
          if ((localObject instanceof ViewGroup))
          {
            localStringBuilder.append(" => ").append(localObject.getClass().getSimpleName());
            localObject = ((ViewParent)localObject).getParent();
            continue;
            localObject = ((ViewParent)localObject).getParent();
            break;
          }
        }
        Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + localStringBuilder.toString());
        localObject = null;
        break;
        bool = localView.requestFocus();
        break label89;
        if (paramInt == 66)
        {
          i = a(this.ma, localView).left;
          j = a(this.ma, (View)localObject).left;
          if ((localObject == null) || (i > j))
          {
            bool = localView.requestFocus();
            break label89;
            if ((paramInt == 17) || (paramInt == 1))
            {
              bool = bU();
              break label89;
            }
            if ((paramInt != 66) && (paramInt != 2)) {
              break label357;
            }
          }
          bool = bV();
          break label89;
        }
        bool = false;
        break label89;
      }
      localObject = localView;
      break;
    }
  }
  
  private void b(int paramInt, float paramFloat)
  {
    if (this.nJ != null) {
      this.nJ.a(paramInt, paramFloat);
    }
    if (this.nI != null)
    {
      int j = this.nI.size();
      int i = 0;
      while (i < j)
      {
        al localal = (al)this.nI.get(i);
        if (localal != null) {
          localal.a(paramInt, paramFloat);
        }
        i += 1;
      }
    }
    if (this.nK != null) {
      this.nK.a(paramInt, paramFloat);
    }
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.nv) {
      if (i != 0) {
        break label56;
      }
    }
    label56:
    for (i = 1;; i = 0)
    {
      this.nt = paramMotionEvent.getX(i);
      this.nv = paramMotionEvent.getPointerId(i);
      if (this.nw != null) {
        this.nw.clear();
      }
      return;
    }
  }
  
  private boolean b(float paramFloat)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    float f1 = this.nt;
    this.nt = paramFloat;
    float f2 = getScrollX() + (f1 - paramFloat);
    int k = bL();
    paramFloat = k * this.ni;
    f1 = k;
    float f3 = this.nj;
    ai localai1 = (ai)this.mV.get(0);
    ai localai2 = (ai)this.mV.get(this.mV.size() - 1);
    if (localai1.position != 0)
    {
      paramFloat = localai1.nV;
      paramFloat = k * paramFloat;
    }
    for (int i = 0;; i = 1)
    {
      int j;
      if (localai2.position != this.mX.getCount() - 1)
      {
        f1 = localai2.nV * k;
        j = 0;
      }
      for (;;)
      {
        if (f2 < paramFloat)
        {
          if (i == 0) {
            break label251;
          }
          this.nC.onPull(Math.abs(paramFloat - f2) / k);
        }
        for (;;)
        {
          this.nt += paramFloat - (int)paramFloat;
          scrollTo((int)paramFloat, getScrollY());
          Q((int)paramFloat);
          return bool1;
          if (f2 > f1)
          {
            if (j != 0) {
              this.nD.onPull(Math.abs(f2 - f1) / k);
            }
            for (bool1 = bool2;; bool1 = false)
            {
              paramFloat = f1;
              break;
            }
          }
          bool1 = false;
          paramFloat = f2;
          continue;
          label251:
          bool1 = false;
        }
        j = 1;
        f1 *= f3;
      }
    }
  }
  
  private int bL()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private void bN()
  {
    if (this.nO != 0)
    {
      if (this.nP == null) {
        this.nP = new ArrayList();
      }
      for (;;)
      {
        int j = getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = getChildAt(i);
          this.nP.add(localView);
          i += 1;
        }
        this.nP.clear();
      }
      Collections.sort(this.nP, nQ);
    }
  }
  
  private ai bO()
  {
    int i = 0;
    while (i < this.mV.size())
    {
      ai localai = (ai)this.mV.get(i);
      if (this.mX.bH()) {
        return localai;
      }
      i += 1;
    }
    return null;
  }
  
  private void bP()
  {
    if (this.nJ != null) {
      this.nJ.bJ();
    }
    if (this.nI != null)
    {
      int j = this.nI.size();
      int i = 0;
      while (i < j)
      {
        al localal = (al)this.nI.get(i);
        if (localal != null) {
          localal.bJ();
        }
        i += 1;
      }
    }
    if (this.nK != null) {
      this.nK.bJ();
    }
  }
  
  private boolean bQ()
  {
    this.nv = -1;
    bT();
    this.nC.onRelease();
    this.nD.onRelease();
    return (this.nC.isFinished()) || (this.nD.isFinished());
  }
  
  private void bR()
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(true);
    }
  }
  
  private ai bS()
  {
    int i = bL();
    float f1;
    float f2;
    label36:
    int k;
    int j;
    Object localObject1;
    float f3;
    float f4;
    label53:
    Object localObject2;
    ai localai;
    if (i > 0)
    {
      f1 = getScrollX() / i;
      if (i <= 0) {
        break label204;
      }
      f2 = this.ne / i;
      k = -1;
      j = 1;
      i = 0;
      localObject1 = null;
      f3 = 0.0F;
      f4 = 0.0F;
      localObject2 = localObject1;
      if (i < this.mV.size())
      {
        localai = (ai)this.mV.get(i);
        if ((j != 0) || (localai.position == k + 1)) {
          break label238;
        }
        localai = this.mW;
        localai.nV = (f4 + f3 + f2);
        localai.position = (k + 1);
        localai.nU = 1.0F;
        i -= 1;
      }
    }
    label204:
    label209:
    label238:
    for (;;)
    {
      f4 = localai.nV;
      f3 = localai.nU;
      if (j == 0)
      {
        localObject2 = localObject1;
        if (f1 < f4) {}
      }
      else
      {
        if ((f1 >= f3 + f4 + f2) && (i != this.mV.size() - 1)) {
          break label209;
        }
        localObject2 = localai;
      }
      return localObject2;
      f1 = 0.0F;
      break;
      f2 = 0.0F;
      break label36;
      k = localai.position;
      f3 = localai.nU;
      i += 1;
      j = 0;
      localObject1 = localai;
      break label53;
    }
  }
  
  private void bT()
  {
    this.np = false;
    this.nq = false;
    if (this.nw != null)
    {
      this.nw.recycle();
      this.nw = null;
    }
  }
  
  private boolean bU()
  {
    if (this.mY > 0)
    {
      M(this.mY - 1);
      return true;
    }
    return false;
  }
  
  private boolean bV()
  {
    if ((this.mX != null) && (this.mY < this.mX.getCount() - 1))
    {
      M(this.mY + 1);
      return true;
    }
    return false;
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    if (getChildCount() == 0)
    {
      setScrollingCacheEnabled(false);
      return;
    }
    int i;
    if ((this.nc != null) && (!this.nc.isFinished()))
    {
      i = 1;
      if (i == 0) {
        break label127;
      }
      if (!this.nd) {
        break label115;
      }
      i = this.nc.getCurrX();
      label54:
      this.nc.abortAnimation();
      setScrollingCacheEnabled(false);
    }
    int j;
    int k;
    int m;
    for (;;)
    {
      j = getScrollY();
      k = paramInt1 - i;
      m = 0 - j;
      if ((k != 0) || (m != 0)) {
        break label136;
      }
      l(false);
      bM();
      K(0);
      return;
      i = 0;
      break;
      label115:
      i = this.nc.getStartX();
      break label54;
      label127:
      i = getScrollX();
    }
    label136:
    setScrollingCacheEnabled(true);
    K(2);
    paramInt1 = bL();
    int n = paramInt1 / 2;
    float f3 = Math.min(1.0F, Math.abs(k) * 1.0F / paramInt1);
    float f1 = n;
    float f2 = n;
    f3 = a(f3);
    paramInt2 = Math.abs(paramInt2);
    if (paramInt2 > 0) {}
    for (paramInt1 = Math.round(1000.0F * Math.abs((f2 * f3 + f1) / paramInt2)) * 4;; paramInt1 = (int)((Math.abs(k) / (f1 * 1.0F + this.ne) + 1.0F) * 100.0F))
    {
      paramInt1 = Math.min(paramInt1, 600);
      this.nd = false;
      this.nc.startScroll(i, j, k, m, paramInt1);
      r.g(this);
      return;
      f1 = paramInt1;
    }
  }
  
  private void l(boolean paramBoolean)
  {
    int i;
    if (this.mz == 2)
    {
      i = 1;
      if (i != 0)
      {
        setScrollingCacheEnabled(false);
        if (this.nc.isFinished()) {
          break label170;
        }
      }
    }
    label170:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        this.nc.abortAnimation();
        j = getScrollX();
        k = getScrollY();
        int m = this.nc.getCurrX();
        int n = this.nc.getCurrY();
        if ((j != m) || (k != n))
        {
          scrollTo(m, n);
          if (m != j) {
            Q(m);
          }
        }
      }
      this.nn = false;
      int k = 0;
      j = i;
      i = k;
      while (i < this.mV.size())
      {
        ai localai = (ai)this.mV.get(i);
        if (localai.nT)
        {
          localai.nT = false;
          j = 1;
        }
        i += 1;
      }
      i = 0;
      break;
    }
    if (j != 0)
    {
      if (paramBoolean) {
        r.b(this, this.nR);
      }
    }
    else {
      return;
    }
    this.nR.run();
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.nm != paramBoolean) {
      this.nm = paramBoolean;
    }
  }
  
  final void K(int paramInt)
  {
    int m = 0;
    if (this.mz == paramInt) {}
    label38:
    label77:
    label83:
    do
    {
      return;
      this.mz = paramInt;
      int i;
      int j;
      if (this.nM != null)
      {
        if (paramInt != 0)
        {
          i = 1;
          int n = getChildCount();
          j = 0;
          if (j >= n) {
            break label83;
          }
          if (i == 0) {
            break label77;
          }
        }
        for (int k = this.nN;; k = 0)
        {
          getChildAt(j).setLayerType(k, null);
          j += 1;
          break label38;
          i = 0;
          break;
        }
      }
      if (this.nJ != null) {
        this.nJ.J(paramInt);
      }
      if (this.nI != null)
      {
        j = this.nI.size();
        i = m;
        while (i < j)
        {
          al localal = (al)this.nI.get(i);
          if (localal != null) {
            localal.J(paramInt);
          }
          i += 1;
        }
      }
    } while (this.nK == null);
    this.nK.J(paramInt);
  }
  
  public final void L(int paramInt)
  {
    this.nn = false;
    if (!this.nE) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramInt, bool, false);
      return;
    }
  }
  
  final al a(al paramal)
  {
    al localal = this.nK;
    this.nK = paramal;
    return localal;
  }
  
  public final void a(ak paramak)
  {
    if (this.nL == null) {
      this.nL = new ArrayList();
    }
    this.nL.add(paramak);
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    int j = paramArrayList.size();
    int k = getDescendantFocusability();
    if (k != 393216)
    {
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (localView.getVisibility() == 0)
        {
          ai localai = bO();
          if ((localai != null) && (localai.position == this.mY)) {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
        i += 1;
      }
    }
    if (((k == 262144) && (j != paramArrayList.size())) || (!isFocusable())) {}
    while ((((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) || (paramArrayList == null)) {
      return;
    }
    paramArrayList.add(this);
  }
  
  public void addTouchables(ArrayList<View> paramArrayList)
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        ai localai = bO();
        if ((localai != null) && (localai.position == this.mY)) {
          localView.addTouchables(paramArrayList);
        }
      }
      i += 1;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!checkLayoutParams(paramLayoutParams)) {
      paramLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    for (;;)
    {
      ViewPager.LayoutParams localLayoutParams = (ViewPager.LayoutParams)paramLayoutParams;
      boolean bool2 = localLayoutParams.nW;
      if (paramView.getClass().getAnnotation(ah.class) != null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        localLayoutParams.nW = (bool1 | bool2);
        if (!this.cE) {
          break label105;
        }
        if ((localLayoutParams == null) || (!localLayoutParams.nW)) {
          break;
        }
        throw new IllegalStateException("Cannot add pager decor view during layout");
      }
      localLayoutParams.nX = true;
      addViewInLayout(paramView, paramInt, paramLayoutParams);
      return;
      label105:
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    }
  }
  
  public final void b(ak paramak)
  {
    if (this.nL != null) {
      this.nL.remove(paramak);
    }
  }
  
  final void bM()
  {
    O(this.mY);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    if (this.mX == null) {}
    int i;
    int j;
    do
    {
      do
      {
        return false;
        i = bL();
        j = getScrollX();
        if (paramInt >= 0) {
          break;
        }
      } while (j <= (int)(i * this.ni));
      return true;
    } while ((paramInt <= 0) || (j >= (int)(i * this.nj)));
    return true;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof ViewPager.LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    this.nd = true;
    if ((!this.nc.isFinished()) && (this.nc.computeScrollOffset()))
    {
      int i = getScrollX();
      int j = getScrollY();
      int k = this.nc.getCurrX();
      int m = this.nc.getCurrY();
      if ((i != k) || (j != m))
      {
        scrollTo(k, m);
        if (!Q(k))
        {
          this.nc.abortAnimation();
          scrollTo(0, m);
        }
      }
      r.g(this);
      return;
    }
    l(true);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!super.dispatchKeyEvent(paramKeyEvent))
    {
      if (paramKeyEvent.getAction() == 0) {}
      switch (paramKeyEvent.getKeyCode())
      {
      default: 
        bool1 = false;
      }
    }
    for (;;)
    {
      if (bool1) {
        bool2 = true;
      }
      return bool2;
      if (paramKeyEvent.hasModifiers(2))
      {
        bool1 = bU();
      }
      else
      {
        bool1 = arrowScroll(17);
        continue;
        if (paramKeyEvent.hasModifiers(2))
        {
          bool1 = bV();
        }
        else
        {
          bool1 = arrowScroll(66);
          continue;
          if (paramKeyEvent.hasNoModifiers())
          {
            bool1 = arrowScroll(2);
          }
          else
          {
            if (!paramKeyEvent.hasModifiers(1)) {
              break;
            }
            bool1 = arrowScroll(1);
          }
        }
      }
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramAccessibilityEvent.getEventType() == 4096)
    {
      bool1 = super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
      return bool1;
    }
    int j = getChildCount();
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        ai localai = bO();
        if ((localai != null) && (localai.position == this.mY) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
          return true;
        }
      }
      i += 1;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int k = 0;
    int i = 0;
    int m = getOverScrollMode();
    boolean bool;
    if ((m == 0) || ((m == 1) && (this.mX != null) && (this.mX.getCount() > 1)))
    {
      int j;
      if (!this.nC.isFinished())
      {
        k = paramCanvas.save();
        i = getHeight() - getPaddingTop() - getPaddingBottom();
        m = getWidth();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(-i + getPaddingTop(), this.ni * m);
        this.nC.setSize(i, m);
        j = this.nC.draw(paramCanvas) | false;
        paramCanvas.restoreToCount(k);
      }
      k = j;
      if (!this.nD.isFinished())
      {
        m = paramCanvas.save();
        k = getWidth();
        int n = getHeight();
        int i1 = getPaddingTop();
        int i2 = getPaddingBottom();
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-getPaddingTop(), -(this.nj + 1.0F) * k);
        this.nD.setSize(n - i1 - i2, k);
        bool = j | this.nD.draw(paramCanvas);
        paramCanvas.restoreToCount(m);
      }
    }
    for (;;)
    {
      if (bool) {
        r.g(this);
      }
      return;
      this.nC.finish();
      this.nD.finish();
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.nf;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewPager.LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewPager.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return generateDefaultLayoutParams();
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (this.nO == 2) {
      i = paramInt1 - 1 - paramInt2;
    }
    return ((ViewPager.LayoutParams)((View)this.nP.get(i)).getLayoutParams()).nY;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.nE = true;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.nR);
    if ((this.nc != null) && (!this.nc.isFinished())) {
      this.nc.abortAnimation();
    }
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.ne > 0) && (this.nf != null) && (this.mV.size() > 0) && (this.mX != null))
    {
      int k = getScrollX();
      int m = getWidth();
      float f3 = this.ne / m;
      Object localObject = (ai)this.mV.get(0);
      float f1 = ((ai)localObject).nV;
      int n = this.mV.size();
      int i = ((ai)localObject).position;
      int i1 = ((ai)this.mV.get(n - 1)).position;
      int j = 0;
      if (i < i1)
      {
        while ((i > ((ai)localObject).position) && (j < n))
        {
          localObject = this.mV;
          j += 1;
          localObject = (ai)((ArrayList)localObject).get(j);
        }
        float f2;
        if (i == ((ai)localObject).position) {
          f2 = (((ai)localObject).nV + ((ai)localObject).nU) * m;
        }
        for (f1 = ((ai)localObject).nV + ((ai)localObject).nU + f3;; f1 += 1.0F + f3)
        {
          if (this.ne + f2 > k)
          {
            this.nf.setBounds(Math.round(f2), this.ng, Math.round(this.ne + f2), this.nh);
            this.nf.draw(paramCanvas);
          }
          if (f2 > k + m) {
            return;
          }
          i += 1;
          break;
          f2 = (1.0F + f1) * m;
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i == 3) || (i == 1)) {
      bQ();
    }
    do
    {
      return false;
      if (i == 0) {
        break;
      }
      if (this.np) {
        return true;
      }
    } while (this.nq);
    switch (i)
    {
    }
    for (;;)
    {
      if (this.nw == null) {
        this.nw = VelocityTracker.obtain();
      }
      this.nw.addMovement(paramMotionEvent);
      return this.np;
      i = this.nv;
      if (i != -1)
      {
        i = paramMotionEvent.findPointerIndex(i);
        float f2 = paramMotionEvent.getX(i);
        float f1 = f2 - this.nt;
        float f4 = Math.abs(f1);
        float f3 = paramMotionEvent.getY(i);
        float f5 = Math.abs(f3 - this.mh);
        if (f1 != 0.0F)
        {
          float f6 = this.nt;
          if (((f6 < this.ns) && (f1 > 0.0F)) || ((f6 > getWidth() - this.ns) && (f1 < 0.0F))) {}
          for (i = 1; (i == 0) && (a(this, false, (int)f1, (int)f2, (int)f3)); i = 0)
          {
            this.nt = f2;
            this.nu = f3;
            this.nq = true;
            return false;
          }
        }
        if ((f4 > this.mi) && (0.5F * f4 > f5))
        {
          this.np = true;
          bR();
          K(1);
          if (f1 > 0.0F)
          {
            f1 = this.mg + this.mi;
            label328:
            this.nt = f1;
            this.nu = f3;
            setScrollingCacheEnabled(true);
          }
        }
        while ((this.np) && (b(f2)))
        {
          r.g(this);
          break;
          f1 = this.mg - this.mi;
          break label328;
          if (f5 > this.mi) {
            this.nq = true;
          }
        }
        f1 = paramMotionEvent.getX();
        this.mg = f1;
        this.nt = f1;
        f1 = paramMotionEvent.getY();
        this.mh = f1;
        this.nu = f1;
        this.nv = paramMotionEvent.getPointerId(0);
        this.nq = false;
        this.nd = true;
        this.nc.computeScrollOffset();
        if ((this.mz == 2) && (Math.abs(this.nc.getFinalX() - this.nc.getCurrX()) > this.nA))
        {
          this.nc.abortAnimation();
          this.nn = false;
          bM();
          this.np = true;
          bR();
          K(1);
        }
        else
        {
          l(false);
          this.np = false;
          continue;
          b(paramMotionEvent);
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = getChildCount();
    int i3 = paramInt3 - paramInt1;
    int i2 = paramInt4 - paramInt2;
    paramInt1 = getPaddingLeft();
    paramInt2 = getPaddingTop();
    paramInt3 = getPaddingRight();
    int j = getPaddingBottom();
    int i4 = getScrollX();
    int k = 0;
    int m = 0;
    View localView;
    ViewPager.LayoutParams localLayoutParams;
    int n;
    int i;
    if (m < i1)
    {
      localView = getChildAt(m);
      if (localView.getVisibility() == 8) {
        break label634;
      }
      localLayoutParams = (ViewPager.LayoutParams)localView.getLayoutParams();
      if (!localLayoutParams.nW) {
        break label634;
      }
      paramInt4 = localLayoutParams.gravity;
      n = localLayoutParams.gravity;
      switch (paramInt4 & 0x7)
      {
      case 2: 
      case 4: 
      default: 
        paramInt4 = paramInt1;
        i = paramInt3;
        paramInt3 = paramInt1;
        paramInt1 = i;
        label161:
        switch (n & 0x70)
        {
        default: 
          i = paramInt2;
          label203:
          paramInt4 += i4;
          localView.layout(paramInt4, i, localView.getMeasuredWidth() + paramInt4, localView.getMeasuredHeight() + i);
          paramInt4 = k + 1;
        }
        break;
      }
    }
    for (;;)
    {
      m += 1;
      i = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = i;
      k = paramInt4;
      break;
      i = paramInt1 + localView.getMeasuredWidth();
      paramInt4 = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = i;
      break label161;
      i = Math.max((i3 - localView.getMeasuredWidth()) / 2, paramInt1);
      paramInt4 = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = paramInt4;
      paramInt4 = i;
      break label161;
      paramInt4 = localView.getMeasuredWidth();
      i = localView.getMeasuredWidth();
      paramInt4 = i3 - paramInt3 - paramInt4;
      i = paramInt3 + i;
      paramInt3 = paramInt1;
      paramInt1 = i;
      break label161;
      n = paramInt2 + localView.getMeasuredHeight();
      i = paramInt2;
      paramInt2 = n;
      break label203;
      i = Math.max((i2 - localView.getMeasuredHeight()) / 2, paramInt2);
      break label203;
      i = i2 - j - localView.getMeasuredHeight();
      j += localView.getMeasuredHeight();
      break label203;
      paramInt4 = i3 - paramInt1 - paramInt3;
      paramInt3 = 0;
      while (paramInt3 < i1)
      {
        localView = getChildAt(paramInt3);
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (ViewPager.LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.nW)
          {
            ai localai = bO();
            if (localai != null)
            {
              float f = paramInt4;
              i = (int)(localai.nV * f) + paramInt1;
              if (localLayoutParams.nX)
              {
                localLayoutParams.nX = false;
                f = paramInt4;
                localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.nU * f), 1073741824), View.MeasureSpec.makeMeasureSpec(i2 - paramInt2 - j, 1073741824));
              }
              localView.layout(i, paramInt2, localView.getMeasuredWidth() + i, localView.getMeasuredHeight() + paramInt2);
            }
          }
        }
        paramInt3 += 1;
      }
      this.ng = paramInt2;
      this.nh = (i2 - j);
      this.nH = k;
      if (this.nE) {
        a(this.mY, false, 0, false);
      }
      this.nE = false;
      return;
      label634:
      paramInt4 = k;
      i = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = i;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    this.ns = Math.min(paramInt1 / 10, this.nr);
    paramInt1 = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int i4 = getChildCount();
    int k = 0;
    View localView;
    int i;
    int j;
    ViewPager.LayoutParams localLayoutParams;
    int m;
    int i1;
    label183:
    int n;
    if (k < i4)
    {
      localView = getChildAt(k);
      i = paramInt1;
      j = paramInt2;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (ViewPager.LayoutParams)localView.getLayoutParams();
        i = paramInt1;
        j = paramInt2;
        if (localLayoutParams != null)
        {
          i = paramInt1;
          j = paramInt2;
          if (localLayoutParams.nW)
          {
            i = localLayoutParams.gravity & 0x7;
            m = localLayoutParams.gravity & 0x70;
            i1 = -2147483648;
            j = -2147483648;
            if ((m != 48) && (m != 80)) {
              break label333;
            }
            m = 1;
            if ((i != 3) && (i != 5)) {
              break label339;
            }
            n = 1;
            label198:
            if (m == 0) {
              break label345;
            }
            i = 1073741824;
            label208:
            if (localLayoutParams.width == -2) {
              break label528;
            }
            i1 = 1073741824;
            if (localLayoutParams.width == -1) {
              break label522;
            }
            i = localLayoutParams.width;
          }
        }
      }
    }
    for (;;)
    {
      int i3;
      if (localLayoutParams.height != -2)
      {
        i2 = 1073741824;
        j = i2;
        if (localLayoutParams.height != -1)
        {
          i3 = localLayoutParams.height;
          j = i2;
        }
      }
      for (int i2 = i3;; i2 = paramInt2)
      {
        localView.measure(View.MeasureSpec.makeMeasureSpec(i, i1), View.MeasureSpec.makeMeasureSpec(i2, j));
        if (m != 0)
        {
          j = paramInt2 - localView.getMeasuredHeight();
          i = paramInt1;
        }
        for (;;)
        {
          k += 1;
          paramInt1 = i;
          paramInt2 = j;
          break;
          label333:
          m = 0;
          break label183;
          label339:
          n = 0;
          break label198;
          label345:
          i = i1;
          if (n == 0) {
            break label208;
          }
          j = 1073741824;
          i = i1;
          break label208;
          i = paramInt1;
          j = paramInt2;
          if (n != 0)
          {
            i = paramInt1 - localView.getMeasuredWidth();
            j = paramInt2;
          }
        }
        this.nk = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
        this.nl = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
        this.cE = true;
        bM();
        this.cE = false;
        i = getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          localView = getChildAt(paramInt2);
          if (localView.getVisibility() != 8)
          {
            localLayoutParams = (ViewPager.LayoutParams)localView.getLayoutParams();
            if ((localLayoutParams == null) || (!localLayoutParams.nW))
            {
              float f = paramInt1;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.nU * f), 1073741824), this.nl);
            }
          }
          paramInt2 += 1;
        }
        return;
      }
      label522:
      i = paramInt1;
      continue;
      label528:
      i1 = paramInt1;
      i2 = i;
      i = i1;
      i1 = i2;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int j = getChildCount();
    int k;
    int i;
    if ((paramInt & 0x2) != 0)
    {
      k = 1;
      i = 0;
    }
    while (i != j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        ai localai = bO();
        if ((localai != null) && (localai.position == this.mY) && (localView.requestFocus(paramInt, paramRect)))
        {
          return true;
          i = j - 1;
          j = -1;
          k = -1;
          continue;
        }
      }
      i += k;
    }
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof ViewPager.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (ViewPager.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (this.mX != null)
    {
      a(paramParcelable.position, false, true);
      return;
    }
    this.mZ = paramParcelable.position;
    this.na = paramParcelable.nZ;
    this.nb = paramParcelable.oa;
  }
  
  public Parcelable onSaveInstanceState()
  {
    ViewPager.SavedState localSavedState = new ViewPager.SavedState(super.onSaveInstanceState());
    localSavedState.position = this.mY;
    if (this.mX != null) {
      localSavedState.nZ = null;
    }
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
    {
      paramInt2 = this.ne;
      paramInt4 = this.ne;
      if ((paramInt3 <= 0) || (this.mV.isEmpty())) {
        break label132;
      }
      if (!this.nc.isFinished()) {
        this.nc.setFinalX(this.mY * bL());
      }
    }
    else
    {
      return;
    }
    int i = getPaddingLeft();
    int j = getPaddingRight();
    int k = getPaddingLeft();
    int m = getPaddingRight();
    float f = getScrollX() / (paramInt4 + (paramInt3 - k - m));
    scrollTo((int)((paramInt2 + (paramInt1 - i - j)) * f), getScrollY());
    return;
    label132:
    ai localai = P(this.mY);
    if (localai != null) {}
    for (f = Math.min(localai.nV, this.nj);; f = 0.0F)
    {
      paramInt1 = (int)(f * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (paramInt1 == getScrollX()) {
        break;
      }
      l(false);
      scrollTo(paramInt1, getScrollY());
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if (this.nB) {
      return true;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    if ((this.mX == null) || (this.mX.getCount() == 0)) {
      return false;
    }
    if (this.nw == null) {
      this.nw = VelocityTracker.obtain();
    }
    this.nw.addMovement(paramMotionEvent);
    boolean bool1 = bool2;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      bool1 = bool2;
    }
    for (;;)
    {
      if (bool1) {
        r.g(this);
      }
      return true;
      this.nc.abortAnimation();
      this.nn = false;
      bM();
      float f1 = paramMotionEvent.getX();
      this.mg = f1;
      this.nt = f1;
      f1 = paramMotionEvent.getY();
      this.mh = f1;
      this.nu = f1;
      this.nv = paramMotionEvent.getPointerId(0);
      bool1 = bool2;
      continue;
      int i;
      float f2;
      if (!this.np)
      {
        i = paramMotionEvent.findPointerIndex(this.nv);
        if (i == -1)
        {
          bool1 = bQ();
          continue;
        }
        f1 = paramMotionEvent.getX(i);
        float f3 = Math.abs(f1 - this.nt);
        f2 = paramMotionEvent.getY(i);
        float f4 = Math.abs(f2 - this.nu);
        if ((f3 > this.mi) && (f3 > f4))
        {
          this.np = true;
          bR();
          if (f1 - this.mg <= 0.0F) {
            break label392;
          }
        }
      }
      Object localObject;
      label392:
      for (f1 = this.mg + this.mi;; f1 = this.mg - this.mi)
      {
        this.nt = f1;
        this.nu = f2;
        K(1);
        setScrollingCacheEnabled(true);
        localObject = getParent();
        if (localObject != null) {
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
        }
        bool1 = bool2;
        if (!this.np) {
          break;
        }
        bool1 = b(paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.nv))) | false;
        break;
      }
      bool1 = bool2;
      if (this.np)
      {
        localObject = this.nw;
        ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.ny);
        int k = (int)((VelocityTracker)localObject).getXVelocity(this.nv);
        this.nn = true;
        int j = bL();
        int m = getScrollX();
        localObject = bS();
        f1 = this.ne / j;
        i = ((ai)localObject).position;
        f2 = (m / j - ((ai)localObject).nV) / (((ai)localObject).nU + f1);
        if ((Math.abs((int)(paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.nv)) - this.mg)) > this.nz) && (Math.abs(k) > this.nx))
        {
          if (k > 0) {}
          for (;;)
          {
            j = i;
            if (this.mV.size() > 0)
            {
              paramMotionEvent = (ai)this.mV.get(0);
              localObject = (ai)this.mV.get(this.mV.size() - 1);
              j = Math.max(paramMotionEvent.position, Math.min(i, ((ai)localObject).position));
            }
            a(j, true, true, k);
            bool1 = bQ();
            break;
            i += 1;
          }
        }
        if (i >= this.mY) {}
        for (f1 = 0.4F;; f1 = 0.6F)
        {
          i += (int)(f1 + f2);
          break;
        }
        bool1 = bool2;
        if (this.np)
        {
          a(this.mY, true, 0, false);
          bool1 = bQ();
          continue;
          i = paramMotionEvent.getActionIndex();
          this.nt = paramMotionEvent.getX(i);
          this.nv = paramMotionEvent.getPointerId(i);
          bool1 = bool2;
          continue;
          b(paramMotionEvent);
          this.nt = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.nv));
          bool1 = bool2;
        }
      }
    }
  }
  
  public void removeView(View paramView)
  {
    if (this.cE)
    {
      removeViewInLayout(paramView);
      return;
    }
    super.removeView(paramView);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.nf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.ViewPager
 * JD-Core Version:    0.7.0.1
 */