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
  static final int[] kV = { 16842931 };
  private static final Comparator<ai> kX = new Comparator() {};
  private static final Interpolator kY = new Interpolator()
  {
    public final float getInterpolation(float paramAnonymousFloat)
    {
      paramAnonymousFloat -= 1.0F;
      return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
    }
  };
  private static final an lU = new an();
  private boolean aU;
  private int kD = 0;
  private int kW;
  private final ArrayList<ai> kZ = new ArrayList();
  private final Rect kd = new Rect();
  private float kj;
  private float kk;
  private int kl;
  private VelocityTracker lA;
  private int lB;
  private int lC;
  private int lD;
  private int lE;
  private boolean lF;
  private EdgeEffect lG;
  private EdgeEffect lH;
  private boolean lI = true;
  private boolean lJ = false;
  private boolean lK;
  private int lL;
  private List<al> lM;
  private al lN;
  private al lO;
  private List<ak> lP;
  private am lQ;
  private int lR;
  private int lS;
  private ArrayList<View> lT;
  private final Runnable lV = new Runnable()
  {
    public final void run()
    {
      ViewPager.this.z(0);
      ViewPager.this.bv();
    }
  };
  private final ai la = new ai();
  o lb;
  int lc;
  private int ld = -1;
  private Parcelable le = null;
  private ClassLoader lf = null;
  private Scroller lg;
  private boolean lh;
  private int li;
  private Drawable lj;
  private int lk;
  private int ll;
  private float lm = -3.402824E+038F;
  private float ln = 3.4028235E+38F;
  private int lo;
  private int lp;
  private boolean lq;
  private boolean lr;
  private int ls = 1;
  private boolean lt;
  private boolean lu;
  private int lv;
  private int lw;
  private float lx;
  private float ly;
  private int lz = -1;
  
  public ViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    paramContext = getContext();
    this.lg = new Scroller(paramContext, kY);
    paramAttributeSet = ViewConfiguration.get(paramContext);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.kl = paramAttributeSet.getScaledPagingTouchSlop();
    this.lB = ((int)(400.0F * f));
    this.lC = paramAttributeSet.getScaledMaximumFlingVelocity();
    this.lG = new EdgeEffect(paramContext);
    this.lH = new EdgeEffect(paramContext);
    this.lD = ((int)(25.0F * f));
    this.lE = ((int)(2.0F * f));
    this.lv = ((int)(16.0F * f));
    r.a(this, new aj(this));
    if (r.g(this) == 0) {
      r.c(this, 1);
    }
    r.a(this, new n()
    {
      private final Rect kd = new Rect();
      
      public final av a(View paramAnonymousView, av paramAnonymousav)
      {
        paramAnonymousView = r.a(paramAnonymousView, paramAnonymousav);
        if (paramAnonymousView.isConsumed()) {
          return paramAnonymousView;
        }
        paramAnonymousav = this.kd;
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
  
  private void B(int paramInt)
  {
    this.lr = false;
    a(paramInt, true, false);
  }
  
  private ai C(int paramInt)
  {
    new ai().position = paramInt;
    throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
  }
  
  private void D(int paramInt)
  {
    ai localai;
    if (this.lc != paramInt)
    {
      localai = E(this.lc);
      this.lc = paramInt;
    }
    for (;;)
    {
      if (this.lb == null) {
        bw();
      }
      do
      {
        return;
        if (this.lr)
        {
          bw();
          return;
        }
      } while (getWindowToken() == null);
      paramInt = this.ls;
      int i1 = Math.max(0, this.lc - paramInt);
      int m = this.lb.getCount();
      int n = Math.min(m - 1, paramInt + this.lc);
      Object localObject1;
      if (m != this.kW) {
        try
        {
          String str = getResources().getResourceName(getId());
          throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.kW + ", found: " + m + " Pager id: " + str + " Pager class: " + getClass() + " Problematic adapter: " + this.lb.getClass());
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
      if (paramInt < this.kZ.size())
      {
        localObject1 = (ai)this.kZ.get(paramInt);
        if (((ai)localObject1).position >= this.lc) {
          if (((ai)localObject1).position != this.lc) {
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
        for (Object localObject2 = C(this.lc);; localObject2 = localObject1)
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
              localObject1 = (ai)this.kZ.get(k);
              i2 = bu();
              if (i2 > 0) {
                break label440;
              }
              f2 = 0.0F;
              j = this.lc - 1;
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
              if ((j != ((ai)localObject1).position) || (((ai)localObject1).lX)) {
                break label1115;
              }
              this.kZ.remove(paramInt);
              o.bp();
              paramInt -= 1;
              if (paramInt < 0) {
                break label461;
              }
              localObject1 = (ai)this.kZ.get(paramInt);
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
            f2 = 2.0F - ((ai)localObject2).lY + getPaddingLeft() / i2;
            break label324;
            localObject1 = null;
            break label412;
            if ((localObject1 != null) && (j == ((ai)localObject1).position))
            {
              f1 += ((ai)localObject1).lY;
              paramInt -= 1;
              if (paramInt >= 0) {
                localObject1 = (ai)this.kZ.get(paramInt);
              } else {
                localObject1 = null;
              }
            }
            else
            {
              f1 += C(j).lY;
              i += 1;
              if (paramInt >= 0) {}
              for (localObject1 = (ai)this.kZ.get(paramInt);; localObject1 = null) {
                break;
              }
              float f3 = ((ai)localObject2).lY;
              k = i + 1;
              if (f3 < 2.0F)
              {
                label617:
                Object localObject3;
                if (k < this.kZ.size())
                {
                  localObject1 = (ai)this.kZ.get(k);
                  if (i2 > 0) {
                    break label763;
                  }
                  f2 = 0.0F;
                  j = this.lc + 1;
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
                    if (!localObject3.lX)
                    {
                      this.kZ.remove(k);
                      o.bp();
                      if (k >= this.kZ.size()) {
                        break label778;
                      }
                      localObject1 = (ai)this.kZ.get(k);
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
                    f1 = f3 + localObject3.lY;
                    paramInt = k + 1;
                    if (paramInt < this.kZ.size()) {
                      localObject1 = (ai)this.kZ.get(paramInt);
                    } else {
                      localObject1 = null;
                    }
                  }
                  else
                  {
                    localObject1 = C(j);
                    paramInt = k + 1;
                    f1 = f3 + ((ai)localObject1).lY;
                    if (paramInt < this.kZ.size()) {
                      localObject1 = (ai)this.kZ.get(paramInt);
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
                ((ViewPager.LayoutParams)localObject1).mc = paramInt;
                if ((!((ViewPager.LayoutParams)localObject1).ma) && (((ViewPager.LayoutParams)localObject1).lY == 0.0F))
                {
                  localai = bx();
                  if (localai != null)
                  {
                    ((ViewPager.LayoutParams)localObject1).lY = localai.lY;
                    ((ViewPager.LayoutParams)localObject1).position = localai.position;
                  }
                }
                paramInt += 1;
              }
              bw();
              if (!hasFocus()) {
                break;
              }
              localObject1 = findFocus();
              if (localObject1 != null) {}
              for (localObject1 = x((View)localObject1);; localObject1 = null)
              {
                if ((localObject1 != null) && (((ai)localObject1).position == this.lc)) {
                  break label1113;
                }
                paramInt = 0;
                for (;;)
                {
                  if (paramInt >= getChildCount()) {
                    break label1107;
                  }
                  localObject1 = getChildAt(paramInt);
                  localai = bx();
                  if ((localai != null) && (localai.position == this.lc) && (((View)localObject1).requestFocus(2))) {
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
  
  private ai E(int paramInt)
  {
    int i = 0;
    while (i < this.kZ.size())
    {
      ai localai = (ai)this.kZ.get(i);
      if (localai.position == paramInt) {
        return localai;
      }
      i += 1;
    }
    return null;
  }
  
  private boolean F(int paramInt)
  {
    if (this.kZ.size() == 0)
    {
      if (this.lI) {}
      do
      {
        return false;
        this.lK = false;
        a(0, 0.0F, 0);
      } while (this.lK);
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    ai localai = bB();
    int j = bu();
    int k = this.li;
    float f = this.li / j;
    int i = localai.position;
    f = (paramInt / j - localai.lZ) / (localai.lY + f);
    paramInt = (int)((k + j) * f);
    this.lK = false;
    a(i, f, paramInt);
    if (!this.lK) {
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    return true;
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
    Object localObject;
    int i;
    label119:
    int m;
    if (this.lL > 0)
    {
      int n = getScrollX();
      paramInt2 = getPaddingLeft();
      j = getPaddingRight();
      i1 = getWidth();
      int i2 = getChildCount();
      k = 0;
      if (k < i2)
      {
        localObject = getChildAt(k);
        ViewPager.LayoutParams localLayoutParams = (ViewPager.LayoutParams)((View)localObject).getLayoutParams();
        if (!localLayoutParams.ma) {
          break label404;
        }
        switch (localLayoutParams.gravity & 0x7)
        {
        case 2: 
        case 4: 
        default: 
          i = paramInt2;
          int i3 = i + n - ((View)localObject).getLeft();
          m = j;
          i = paramInt2;
          if (i3 != 0)
          {
            ((View)localObject).offsetLeftAndRight(i3);
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
      m = paramInt2 + ((View)localObject).getWidth();
      i = paramInt2;
      paramInt2 = m;
      break label119;
      i = Math.max((i1 - ((View)localObject).getMeasuredWidth()) / 2, paramInt2);
      break label119;
      i = i1 - j - ((View)localObject).getMeasuredWidth();
      j += ((View)localObject).getMeasuredWidth();
      break label119;
      if (this.lN != null) {
        this.lN.a(paramInt1, paramFloat);
      }
      if (this.lM != null)
      {
        i = this.lM.size();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          localObject = (al)this.lM.get(paramInt2);
          if (localObject != null) {
            ((al)localObject).a(paramInt1, paramFloat);
          }
          paramInt2 += 1;
        }
      }
      if (this.lO != null) {
        this.lO.a(paramInt1, paramFloat);
      }
      if (this.lQ != null)
      {
        getScrollX();
        paramInt2 = getChildCount();
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          localObject = getChildAt(paramInt1);
          if (!((ViewPager.LayoutParams)((View)localObject).getLayoutParams()).ma)
          {
            ((View)localObject).getLeft();
            bu();
          }
          paramInt1 += 1;
        }
      }
      this.lK = true;
      return;
      label404:
      m = j;
      i = paramInt2;
    }
  }
  
  private void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    ai localai = E(paramInt1);
    if (localai != null) {}
    for (int i = (int)(bu() * Math.max(this.lm, Math.min(localai.lZ, this.ln)));; i = 0)
    {
      if (paramBoolean1)
      {
        if (getChildCount() == 0)
        {
          setScrollingCacheEnabled(false);
          if (paramBoolean2) {
            by();
          }
          return;
        }
        if ((this.lg != null) && (!this.lg.isFinished()))
        {
          paramInt1 = 1;
          label85:
          if (paramInt1 == 0) {
            break label177;
          }
          if (!this.lh) {
            break label166;
          }
          paramInt1 = this.lg.getCurrX();
          label104:
          this.lg.abortAnimation();
          setScrollingCacheEnabled(false);
        }
        int j;
        int k;
        for (;;)
        {
          j = getScrollY();
          i -= paramInt1;
          k = 0 - j;
          if ((i != 0) || (k != 0)) {
            break label185;
          }
          i(false);
          bv();
          z(0);
          break;
          paramInt1 = 0;
          break label85;
          label166:
          paramInt1 = this.lg.getStartX();
          break label104;
          label177:
          paramInt1 = getScrollX();
        }
        label185:
        setScrollingCacheEnabled(true);
        z(2);
        int m = bu();
        int n = m / 2;
        float f3 = Math.min(1.0F, 1.0F * Math.abs(i) / m);
        float f1 = n;
        float f2 = n;
        f3 = (float)Math.sin((f3 - 0.5F) * 0.4712389F);
        paramInt2 = Math.abs(paramInt2);
        if (paramInt2 > 0) {}
        for (paramInt2 = Math.round(1000.0F * Math.abs((f2 * f3 + f1) / paramInt2)) * 4;; paramInt2 = (int)((Math.abs(i) / (f1 * 1.0F + this.li) + 1.0F) * 100.0F))
        {
          paramInt2 = Math.min(paramInt2, 600);
          this.lh = false;
          this.lg.startScroll(paramInt1, j, i, k, paramInt2);
          r.f(this);
          break;
          f1 = m;
        }
      }
      if (paramBoolean2) {
        by();
      }
      i(false);
      scrollTo(i, 0);
      F(i);
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
    if ((this.lb == null) || (this.lb.getCount() <= 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    if ((!paramBoolean2) && (this.lc == paramInt1) && (this.kZ.size() != 0))
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
      paramInt1 = this.ls;
      if ((i <= this.lc + paramInt1) && (i >= this.lc - paramInt1)) {
        break;
      }
      paramInt1 = 0;
      while (paramInt1 < this.kZ.size())
      {
        ((ai)this.kZ.get(paramInt1)).lX = true;
        paramInt1 += 1;
      }
      i = paramInt1;
      if (paramInt1 >= this.lb.getCount()) {
        i = this.lb.getCount() - 1;
      }
    }
    paramBoolean2 = bool;
    if (this.lc != i) {
      paramBoolean2 = true;
    }
    if (this.lI)
    {
      this.lc = i;
      if (paramBoolean2) {
        by();
      }
      requestLayout();
      return;
    }
    D(i);
    a(i, paramBoolean1, paramInt2, paramBoolean2);
  }
  
  private void a(ai paramai1, int paramInt, ai paramai2)
  {
    int m = this.lb.getCount();
    int i = bu();
    float f2;
    if (i > 0)
    {
      f2 = this.li / i;
      if (paramai2 == null) {
        break label393;
      }
      i = paramai2.position;
      if (i < paramai1.position)
      {
        f1 = paramai2.lZ + paramai2.lY + f2;
        i += 1;
        j = 0;
      }
    }
    else
    {
      for (;;)
      {
        if ((i > paramai1.position) || (j >= this.kZ.size())) {
          break label393;
        }
        for (paramai2 = (ai)this.kZ.get(j);; paramai2 = (ai)this.kZ.get(j))
        {
          k = i;
          f3 = f1;
          if (i <= paramai2.position) {
            break;
          }
          k = i;
          f3 = f1;
          if (j >= this.kZ.size() - 1) {
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
        paramai2.lZ = f3;
        f1 = f3 + (paramai2.lY + f2);
        i = k + 1;
      }
    }
    if (i > paramai1.position)
    {
      j = this.kZ.size() - 1;
      f1 = paramai2.lZ;
      i -= 1;
      while ((i >= paramai1.position) && (j >= 0))
      {
        for (paramai2 = (ai)this.kZ.get(j);; paramai2 = (ai)this.kZ.get(j))
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
        f1 = f3 - (paramai2.lY + f2);
        paramai2.lZ = f1;
        i = k - 1;
      }
    }
    label393:
    int k = this.kZ.size();
    float f3 = paramai1.lZ;
    i = paramai1.position - 1;
    if (paramai1.position == 0)
    {
      f1 = paramai1.lZ;
      this.lm = f1;
      if (paramai1.position != m - 1) {
        break label526;
      }
      f1 = paramai1.lZ + paramai1.lY - 1.0F;
      label459:
      this.ln = f1;
      j = paramInt - 1;
      f1 = f3;
    }
    for (;;)
    {
      if (j < 0) {
        break label579;
      }
      paramai2 = (ai)this.kZ.get(j);
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
      f1 -= paramai2.lY + f2;
      paramai2.lZ = f1;
      if (paramai2.position == 0) {
        this.lm = f1;
      }
      i -= 1;
      j -= 1;
    }
    label579:
    float f1 = paramai1.lZ + paramai1.lY + f2;
    int j = paramai1.position + 1;
    i = paramInt + 1;
    paramInt = j;
    while (i < k)
    {
      paramai1 = (ai)this.kZ.get(i);
      while (paramInt < paramai1.position)
      {
        paramInt += 1;
        f1 += 1.0F + f2;
      }
      if (paramai1.position == m - 1) {
        this.ln = (paramai1.lY + f1 - 1.0F);
      }
      paramai1.lZ = f1;
      f1 += paramai1.lY + f2;
      paramInt += 1;
      i += 1;
    }
    this.lJ = false;
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.lz) {
      if (i != 0) {
        break label56;
      }
    }
    label56:
    for (i = 1;; i = 0)
    {
      this.lx = paramMotionEvent.getX(i);
      this.lz = paramMotionEvent.getPointerId(i);
      if (this.lA != null) {
        this.lA.clear();
      }
      return;
    }
  }
  
  private boolean a(float paramFloat)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    float f1 = this.lx;
    this.lx = paramFloat;
    float f2 = getScrollX() + (f1 - paramFloat);
    int k = bu();
    paramFloat = k * this.lm;
    f1 = k;
    float f3 = this.ln;
    ai localai1 = (ai)this.kZ.get(0);
    ai localai2 = (ai)this.kZ.get(this.kZ.size() - 1);
    if (localai1.position != 0)
    {
      paramFloat = localai1.lZ;
      paramFloat = k * paramFloat;
    }
    for (int i = 0;; i = 1)
    {
      int j;
      if (localai2.position != this.lb.getCount() - 1)
      {
        f1 = localai2.lZ * k;
        j = 0;
      }
      for (;;)
      {
        if (f2 < paramFloat)
        {
          if (i == 0) {
            break label251;
          }
          this.lG.onPull(Math.abs(paramFloat - f2) / k);
        }
        for (;;)
        {
          this.lx += paramFloat - (int)paramFloat;
          scrollTo((int)paramFloat, getScrollY());
          F((int)paramFloat);
          return bool1;
          if (f2 > f1)
          {
            if (j != 0) {
              this.lH.onPull(Math.abs(f2 - f1) / k);
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
      i = a(this.kd, localView).left;
      j = a(this.kd, (View)localObject).left;
      if ((localObject != null) && (i >= j))
      {
        bool = bC();
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
          i = a(this.kd, localView).left;
          j = a(this.kd, (View)localObject).left;
          if ((localObject == null) || (i > j))
          {
            bool = localView.requestFocus();
            break label89;
            if ((paramInt == 17) || (paramInt == 1))
            {
              bool = bC();
              break label89;
            }
            if ((paramInt != 66) && (paramInt != 2)) {
              break label357;
            }
          }
          bool = bD();
          break label89;
        }
        bool = false;
        break label89;
      }
      localObject = localView;
      break;
    }
  }
  
  private void bA()
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(true);
    }
  }
  
  private ai bB()
  {
    int i = bu();
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
      f2 = this.li / i;
      k = -1;
      j = 1;
      i = 0;
      localObject1 = null;
      f3 = 0.0F;
      f4 = 0.0F;
      localObject2 = localObject1;
      if (i < this.kZ.size())
      {
        localai = (ai)this.kZ.get(i);
        if ((j != 0) || (localai.position == k + 1)) {
          break label238;
        }
        localai = this.la;
        localai.lZ = (f4 + f3 + f2);
        localai.position = (k + 1);
        localai.lY = 1.0F;
        i -= 1;
      }
    }
    label204:
    label209:
    label238:
    for (;;)
    {
      f4 = localai.lZ;
      f3 = localai.lY;
      if (j == 0)
      {
        localObject2 = localObject1;
        if (f1 < f4) {}
      }
      else
      {
        if ((f1 >= f3 + f4 + f2) && (i != this.kZ.size() - 1)) {
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
      f3 = localai.lY;
      i += 1;
      j = 0;
      localObject1 = localai;
      break label53;
    }
  }
  
  private boolean bC()
  {
    if (this.lc > 0)
    {
      B(this.lc - 1);
      return true;
    }
    return false;
  }
  
  private boolean bD()
  {
    if ((this.lb != null) && (this.lc < this.lb.getCount() - 1))
    {
      B(this.lc + 1);
      return true;
    }
    return false;
  }
  
  private int bu()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private void bw()
  {
    if (this.lS != 0)
    {
      if (this.lT == null) {
        this.lT = new ArrayList();
      }
      for (;;)
      {
        int j = getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = getChildAt(i);
          this.lT.add(localView);
          i += 1;
        }
        this.lT.clear();
      }
      Collections.sort(this.lT, lU);
    }
  }
  
  private ai bx()
  {
    int i = 0;
    while (i < this.kZ.size())
    {
      ai localai = (ai)this.kZ.get(i);
      if (this.lb.bq()) {
        return localai;
      }
      i += 1;
    }
    return null;
  }
  
  private void by()
  {
    if (this.lN != null) {
      this.lN.bs();
    }
    if (this.lM != null)
    {
      int j = this.lM.size();
      int i = 0;
      while (i < j)
      {
        al localal = (al)this.lM.get(i);
        if (localal != null) {
          localal.bs();
        }
        i += 1;
      }
    }
    if (this.lO != null) {
      this.lO.bs();
    }
  }
  
  private boolean bz()
  {
    boolean bool = false;
    this.lz = -1;
    this.lt = false;
    this.lu = false;
    if (this.lA != null)
    {
      this.lA.recycle();
      this.lA = null;
    }
    this.lG.onRelease();
    this.lH.onRelease();
    if ((this.lG.isFinished()) || (this.lH.isFinished())) {
      bool = true;
    }
    return bool;
  }
  
  private void i(boolean paramBoolean)
  {
    int i;
    if (this.kD == 2)
    {
      i = 1;
      if (i != 0)
      {
        setScrollingCacheEnabled(false);
        if (this.lg.isFinished()) {
          break label170;
        }
      }
    }
    label170:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        this.lg.abortAnimation();
        j = getScrollX();
        k = getScrollY();
        int m = this.lg.getCurrX();
        int n = this.lg.getCurrY();
        if ((j != m) || (k != n))
        {
          scrollTo(m, n);
          if (m != j) {
            F(m);
          }
        }
      }
      this.lr = false;
      int k = 0;
      j = i;
      i = k;
      while (i < this.kZ.size())
      {
        ai localai = (ai)this.kZ.get(i);
        if (localai.lX)
        {
          localai.lX = false;
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
        r.b(this, this.lV);
      }
    }
    else {
      return;
    }
    this.lV.run();
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.lq != paramBoolean) {
      this.lq = paramBoolean;
    }
  }
  
  private ai x(View paramView)
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
    return bx();
  }
  
  public final void A(int paramInt)
  {
    this.lr = false;
    if (!this.lI) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramInt, bool, false);
      return;
    }
  }
  
  final al a(al paramal)
  {
    al localal = this.lO;
    this.lO = paramal;
    return localal;
  }
  
  public final void a(ak paramak)
  {
    if (this.lP == null) {
      this.lP = new ArrayList();
    }
    this.lP.add(paramak);
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
          ai localai = bx();
          if ((localai != null) && (localai.position == this.lc)) {
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
        ai localai = bx();
        if ((localai != null) && (localai.position == this.lc)) {
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
      boolean bool2 = localLayoutParams.ma;
      if (paramView.getClass().getAnnotation(ah.class) != null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        localLayoutParams.ma = (bool1 | bool2);
        if (!this.aU) {
          break label105;
        }
        if ((localLayoutParams == null) || (!localLayoutParams.ma)) {
          break;
        }
        throw new IllegalStateException("Cannot add pager decor view during layout");
      }
      localLayoutParams.mb = true;
      addViewInLayout(paramView, paramInt, paramLayoutParams);
      return;
      label105:
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    }
  }
  
  public final void b(ak paramak)
  {
    if (this.lP != null) {
      this.lP.remove(paramak);
    }
  }
  
  final void bv()
  {
    D(this.lc);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    if (this.lb == null) {}
    int i;
    int j;
    do
    {
      do
      {
        return false;
        i = bu();
        j = getScrollX();
        if (paramInt >= 0) {
          break;
        }
      } while (j <= (int)(i * this.lm));
      return true;
    } while ((paramInt <= 0) || (j >= (int)(i * this.ln)));
    return true;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof ViewPager.LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    this.lh = true;
    if ((!this.lg.isFinished()) && (this.lg.computeScrollOffset()))
    {
      int i = getScrollX();
      int j = getScrollY();
      int k = this.lg.getCurrX();
      int m = this.lg.getCurrY();
      if ((i != k) || (j != m))
      {
        scrollTo(k, m);
        if (!F(k))
        {
          this.lg.abortAnimation();
          scrollTo(0, m);
        }
      }
      r.f(this);
      return;
    }
    i(true);
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
        bool1 = bC();
      }
      else
      {
        bool1 = arrowScroll(17);
        continue;
        if (paramKeyEvent.hasModifiers(2))
        {
          bool1 = bD();
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
        ai localai = bx();
        if ((localai != null) && (localai.position == this.lc) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
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
    if ((m == 0) || ((m == 1) && (this.lb != null) && (this.lb.getCount() > 1)))
    {
      int j;
      if (!this.lG.isFinished())
      {
        k = paramCanvas.save();
        i = getHeight() - getPaddingTop() - getPaddingBottom();
        m = getWidth();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(-i + getPaddingTop(), this.lm * m);
        this.lG.setSize(i, m);
        j = this.lG.draw(paramCanvas) | false;
        paramCanvas.restoreToCount(k);
      }
      k = j;
      if (!this.lH.isFinished())
      {
        m = paramCanvas.save();
        k = getWidth();
        int n = getHeight();
        int i1 = getPaddingTop();
        int i2 = getPaddingBottom();
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-getPaddingTop(), -(this.ln + 1.0F) * k);
        this.lH.setSize(n - i1 - i2, k);
        bool = j | this.lH.draw(paramCanvas);
        paramCanvas.restoreToCount(m);
      }
    }
    for (;;)
    {
      if (bool) {
        r.f(this);
      }
      return;
      this.lG.finish();
      this.lH.finish();
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.lj;
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
    if (this.lS == 2) {
      i = paramInt1 - 1 - paramInt2;
    }
    return ((ViewPager.LayoutParams)((View)this.lT.get(i)).getLayoutParams()).mc;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.lI = true;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.lV);
    if ((this.lg != null) && (!this.lg.isFinished())) {
      this.lg.abortAnimation();
    }
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.li > 0) && (this.lj != null) && (this.kZ.size() > 0) && (this.lb != null))
    {
      int k = getScrollX();
      int m = getWidth();
      float f3 = this.li / m;
      Object localObject = (ai)this.kZ.get(0);
      float f1 = ((ai)localObject).lZ;
      int n = this.kZ.size();
      int i = ((ai)localObject).position;
      int i1 = ((ai)this.kZ.get(n - 1)).position;
      int j = 0;
      if (i < i1)
      {
        while ((i > ((ai)localObject).position) && (j < n))
        {
          localObject = this.kZ;
          j += 1;
          localObject = (ai)((ArrayList)localObject).get(j);
        }
        float f2;
        if (i == ((ai)localObject).position) {
          f2 = (((ai)localObject).lZ + ((ai)localObject).lY) * m;
        }
        for (f1 = ((ai)localObject).lZ + ((ai)localObject).lY + f3;; f1 += 1.0F + f3)
        {
          if (this.li + f2 > k)
          {
            this.lj.setBounds(Math.round(f2), this.lk, Math.round(this.li + f2), this.ll);
            this.lj.draw(paramCanvas);
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
      bz();
    }
    do
    {
      return false;
      if (i == 0) {
        break;
      }
      if (this.lt) {
        return true;
      }
    } while (this.lu);
    switch (i)
    {
    }
    for (;;)
    {
      if (this.lA == null) {
        this.lA = VelocityTracker.obtain();
      }
      this.lA.addMovement(paramMotionEvent);
      return this.lt;
      i = this.lz;
      if (i != -1)
      {
        i = paramMotionEvent.findPointerIndex(i);
        float f2 = paramMotionEvent.getX(i);
        float f1 = f2 - this.lx;
        float f4 = Math.abs(f1);
        float f3 = paramMotionEvent.getY(i);
        float f5 = Math.abs(f3 - this.kk);
        if (f1 != 0.0F)
        {
          float f6 = this.lx;
          if (((f6 < this.lw) && (f1 > 0.0F)) || ((f6 > getWidth() - this.lw) && (f1 < 0.0F))) {}
          for (i = 1; (i == 0) && (a(this, false, (int)f1, (int)f2, (int)f3)); i = 0)
          {
            this.lx = f2;
            this.ly = f3;
            this.lu = true;
            return false;
          }
        }
        if ((f4 > this.kl) && (0.5F * f4 > f5))
        {
          this.lt = true;
          bA();
          z(1);
          if (f1 > 0.0F)
          {
            f1 = this.kj + this.kl;
            label328:
            this.lx = f1;
            this.ly = f3;
            setScrollingCacheEnabled(true);
          }
        }
        while ((this.lt) && (a(f2)))
        {
          r.f(this);
          break;
          f1 = this.kj - this.kl;
          break label328;
          if (f5 > this.kl) {
            this.lu = true;
          }
        }
        f1 = paramMotionEvent.getX();
        this.kj = f1;
        this.lx = f1;
        f1 = paramMotionEvent.getY();
        this.kk = f1;
        this.ly = f1;
        this.lz = paramMotionEvent.getPointerId(0);
        this.lu = false;
        this.lh = true;
        this.lg.computeScrollOffset();
        if ((this.kD == 2) && (Math.abs(this.lg.getFinalX() - this.lg.getCurrX()) > this.lE))
        {
          this.lg.abortAnimation();
          this.lr = false;
          bv();
          this.lt = true;
          bA();
          z(1);
        }
        else
        {
          i(false);
          this.lt = false;
          continue;
          a(paramMotionEvent);
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
      if (!localLayoutParams.ma) {
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
          if (!localLayoutParams.ma)
          {
            ai localai = bx();
            if (localai != null)
            {
              float f = paramInt4;
              i = (int)(localai.lZ * f) + paramInt1;
              if (localLayoutParams.mb)
              {
                localLayoutParams.mb = false;
                f = paramInt4;
                localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.lY * f), 1073741824), View.MeasureSpec.makeMeasureSpec(i2 - paramInt2 - j, 1073741824));
              }
              localView.layout(i, paramInt2, localView.getMeasuredWidth() + i, localView.getMeasuredHeight() + paramInt2);
            }
          }
        }
        paramInt3 += 1;
      }
      this.lk = paramInt2;
      this.ll = (i2 - j);
      this.lL = k;
      if (this.lI) {
        a(this.lc, false, 0, false);
      }
      this.lI = false;
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
    this.lw = Math.min(paramInt1 / 10, this.lv);
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
          if (localLayoutParams.ma)
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
        this.lo = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
        this.lp = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
        this.aU = true;
        bv();
        this.aU = false;
        i = getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          localView = getChildAt(paramInt2);
          if (localView.getVisibility() != 8)
          {
            localLayoutParams = (ViewPager.LayoutParams)localView.getLayoutParams();
            if ((localLayoutParams == null) || (!localLayoutParams.ma))
            {
              float f = paramInt1;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.lY * f), 1073741824), this.lp);
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
        ai localai = bx();
        if ((localai != null) && (localai.position == this.lc) && (localView.requestFocus(paramInt, paramRect)))
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
    if (this.lb != null)
    {
      Object localObject = paramParcelable.md;
      localObject = paramParcelable.me;
      a(paramParcelable.position, false, true);
      return;
    }
    this.ld = paramParcelable.position;
    this.le = paramParcelable.md;
    this.lf = paramParcelable.me;
  }
  
  public Parcelable onSaveInstanceState()
  {
    ViewPager.SavedState localSavedState = new ViewPager.SavedState(super.onSaveInstanceState());
    localSavedState.position = this.lc;
    if (this.lb != null) {
      localSavedState.md = null;
    }
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
    {
      paramInt2 = this.li;
      paramInt4 = this.li;
      if ((paramInt3 <= 0) || (this.kZ.isEmpty())) {
        break label132;
      }
      if (!this.lg.isFinished()) {
        this.lg.setFinalX(this.lc * bu());
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
    ai localai = E(this.lc);
    if (localai != null) {}
    for (f = Math.min(localai.lZ, this.ln);; f = 0.0F)
    {
      paramInt1 = (int)(f * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (paramInt1 == getScrollX()) {
        break;
      }
      i(false);
      scrollTo(paramInt1, getScrollY());
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if (this.lF) {
      return true;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    if ((this.lb == null) || (this.lb.getCount() == 0)) {
      return false;
    }
    if (this.lA == null) {
      this.lA = VelocityTracker.obtain();
    }
    this.lA.addMovement(paramMotionEvent);
    boolean bool1 = bool2;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      bool1 = bool2;
    }
    for (;;)
    {
      if (bool1) {
        r.f(this);
      }
      return true;
      this.lg.abortAnimation();
      this.lr = false;
      bv();
      float f1 = paramMotionEvent.getX();
      this.kj = f1;
      this.lx = f1;
      f1 = paramMotionEvent.getY();
      this.kk = f1;
      this.ly = f1;
      this.lz = paramMotionEvent.getPointerId(0);
      bool1 = bool2;
      continue;
      int i;
      float f2;
      if (!this.lt)
      {
        i = paramMotionEvent.findPointerIndex(this.lz);
        if (i == -1)
        {
          bool1 = bz();
          continue;
        }
        f1 = paramMotionEvent.getX(i);
        float f3 = Math.abs(f1 - this.lx);
        f2 = paramMotionEvent.getY(i);
        float f4 = Math.abs(f2 - this.ly);
        if ((f3 > this.kl) && (f3 > f4))
        {
          this.lt = true;
          bA();
          if (f1 - this.kj <= 0.0F) {
            break label392;
          }
        }
      }
      Object localObject;
      label392:
      for (f1 = this.kj + this.kl;; f1 = this.kj - this.kl)
      {
        this.lx = f1;
        this.ly = f2;
        z(1);
        setScrollingCacheEnabled(true);
        localObject = getParent();
        if (localObject != null) {
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
        }
        bool1 = bool2;
        if (!this.lt) {
          break;
        }
        bool1 = a(paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.lz))) | false;
        break;
      }
      bool1 = bool2;
      if (this.lt)
      {
        localObject = this.lA;
        ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.lC);
        int k = (int)((VelocityTracker)localObject).getXVelocity(this.lz);
        this.lr = true;
        int j = bu();
        int m = getScrollX();
        localObject = bB();
        f1 = this.li / j;
        i = ((ai)localObject).position;
        f2 = (m / j - ((ai)localObject).lZ) / (((ai)localObject).lY + f1);
        if ((Math.abs((int)(paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.lz)) - this.kj)) > this.lD) && (Math.abs(k) > this.lB))
        {
          if (k > 0) {}
          for (;;)
          {
            j = i;
            if (this.kZ.size() > 0)
            {
              paramMotionEvent = (ai)this.kZ.get(0);
              localObject = (ai)this.kZ.get(this.kZ.size() - 1);
              j = Math.max(paramMotionEvent.position, Math.min(i, ((ai)localObject).position));
            }
            a(j, true, true, k);
            bool1 = bz();
            break;
            i += 1;
          }
        }
        if (i >= this.lc) {}
        for (f1 = 0.4F;; f1 = 0.6F)
        {
          i += (int)(f1 + f2);
          break;
        }
        bool1 = bool2;
        if (this.lt)
        {
          a(this.lc, true, 0, false);
          bool1 = bz();
          continue;
          i = paramMotionEvent.getActionIndex();
          this.lx = paramMotionEvent.getX(i);
          this.lz = paramMotionEvent.getPointerId(i);
          bool1 = bool2;
          continue;
          a(paramMotionEvent);
          this.lx = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.lz));
          bool1 = bool2;
        }
      }
    }
  }
  
  public void removeView(View paramView)
  {
    if (this.aU)
    {
      removeViewInLayout(paramView);
      return;
    }
    super.removeView(paramView);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.lj);
  }
  
  final void z(int paramInt)
  {
    int m = 0;
    if (this.kD == paramInt) {}
    label38:
    label77:
    label83:
    do
    {
      return;
      this.kD = paramInt;
      int i;
      int j;
      if (this.lQ != null)
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
        for (int k = this.lR;; k = 0)
        {
          getChildAt(j).setLayerType(k, null);
          j += 1;
          break label38;
          i = 0;
          break;
        }
      }
      if (this.lN != null) {
        this.lN.y(paramInt);
      }
      if (this.lM != null)
      {
        j = this.lM.size();
        i = m;
        while (i < j)
        {
          al localal = (al)this.lM.get(i);
          if (localal != null) {
            localal.y(paramInt);
          }
          i += 1;
        }
      }
    } while (this.lO == null);
    this.lO.y(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.ViewPager
 * JD-Core Version:    0.7.0.1
 */