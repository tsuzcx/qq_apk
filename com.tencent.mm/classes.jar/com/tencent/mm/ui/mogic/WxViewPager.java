package com.tencent.mm.ui.mogic;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.d;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.ViewPager.f;
import android.support.v4.view.n;
import android.support.v4.view.q;
import android.support.v4.view.r;
import android.support.v4.widget.i;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import junit.framework.Assert;

public class WxViewPager
  extends ViewGroup
{
  private static final int[] Gr = { 16842931 };
  private static final Comparator<WxViewPager.b> Gt = new WxViewPager.1();
  private static final Interpolator Gu = new WxViewPager.2();
  private static final WxViewPager.f vXp = new WxViewPager.f();
  public float FH;
  private float FI;
  private ClassLoader GA = null;
  private Scroller GB;
  private int GE;
  private Drawable GF;
  private int GG;
  private int GH;
  private float GI = -3.402824E+038F;
  private float GJ = 3.4028235E+38F;
  private int GK;
  private int GL;
  private boolean GM;
  public boolean GN;
  private int GO = 1;
  private boolean GP;
  private int GQ;
  private int GR;
  public float GS;
  public float GT;
  private int GU;
  public int GV;
  private int GW;
  private int GX;
  public boolean GY;
  private int Gs;
  private n Gw;
  private int Gx;
  private int Gy = -1;
  private Parcelable Gz = null;
  private boolean Hb = true;
  private boolean Hc = false;
  private boolean Hd;
  private int He;
  private ViewPager.e Hg;
  private ViewPager.e Hh;
  private ViewPager.f Hj;
  private int Hl;
  private ArrayList<View> Hm;
  private final Runnable Ho = new Runnable()
  {
    public final void run()
    {
      WxViewPager.a(WxViewPager.this);
      WxViewPager.this.dm();
    }
  };
  private final ArrayList<WxViewPager.b> dU = new ArrayList();
  private final Rect ec = new Rect();
  public VelocityTracker fB;
  public int fC = -1;
  public boolean iZ;
  private int jb;
  private int lf = 0;
  private boolean mInLayout;
  public long oIS;
  private i oIT;
  private i oIU;
  private Method oIW;
  private final WxViewPager.b vXm = new WxViewPager.b();
  private e vXn;
  private WxViewPager.d vXo;
  
  public WxViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    paramContext = getContext();
    this.GB = new Scroller(paramContext, Gu);
    paramAttributeSet = ViewConfiguration.get(paramContext);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.jb = r.a(paramAttributeSet);
    this.GU = ((int)(400.0F * f));
    this.GV = paramAttributeSet.getScaledMaximumFlingVelocity();
    this.oIT = new i(paramContext);
    this.oIU = new i(paramContext);
    this.GW = ((int)(25.0F * f));
    this.GX = ((int)(2.0F * f));
    this.GQ = ((int)(16.0F * f));
    q.a(this, new WxViewPager.c(this));
    if (q.P(this) == 0) {
      q.n(this, 1);
    }
  }
  
  private void G(boolean paramBoolean)
  {
    if (this.lf == 2) {}
    int j;
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        setScrollingCacheEnabled(false);
        this.GB.abortAnimation();
        j = getScrollX();
        k = getScrollY();
        int m = this.GB.getCurrX();
        int n = this.GB.getCurrY();
        if ((j != m) || (k != n)) {
          scrollTo(m, n);
        }
      }
      this.GN = false;
      int k = 0;
      j = i;
      i = k;
      while (i < this.dU.size())
      {
        WxViewPager.b localb = (WxViewPager.b)this.dU.get(i);
        if (localb.Hq)
        {
          localb.Hq = false;
          j = 1;
        }
        i += 1;
      }
    }
    if (j != 0)
    {
      if (paramBoolean) {
        q.b(this, this.Ho);
      }
    }
    else {
      return;
    }
    this.Ho.run();
  }
  
  private WxViewPager.b Ib(int paramInt)
  {
    int i = 0;
    while (i < this.dU.size())
    {
      WxViewPager.b localb = (WxViewPager.b)this.dU.get(i);
      if (localb.position == paramInt) {
        return localb;
      }
      i += 1;
    }
    return null;
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
    int i;
    int k;
    int i2;
    int m;
    View localView;
    int j;
    label120:
    int n;
    if (this.He > 0)
    {
      int i1 = getScrollX();
      i = getPaddingLeft();
      k = getPaddingRight();
      i2 = getWidth();
      int i3 = getChildCount();
      m = 0;
      if (m < i3)
      {
        localView = getChildAt(m);
        WxViewPager.LayoutParams localLayoutParams = (WxViewPager.LayoutParams)localView.getLayoutParams();
        if (!localLayoutParams.Ht) {
          break label370;
        }
        switch (localLayoutParams.gravity & 0x7)
        {
        case 2: 
        case 4: 
        default: 
          j = i;
          int i4 = j + i1 - localView.getLeft();
          n = k;
          j = i;
          if (i4 != 0)
          {
            localView.offsetLeftAndRight(i4);
            j = i;
            n = k;
          }
          break;
        }
      }
    }
    for (;;)
    {
      m += 1;
      i = j;
      k = n;
      break;
      n = i + localView.getWidth();
      j = i;
      i = n;
      break label120;
      j = Math.max((i2 - localView.getMeasuredWidth()) / 2, i);
      break label120;
      j = i2 - k - localView.getMeasuredWidth();
      k += localView.getMeasuredWidth();
      break label120;
      if (this.Hg != null) {
        this.Hg.a(paramInt1, paramFloat, paramInt2);
      }
      if (this.Hh != null) {
        this.Hh.a(paramInt1, paramFloat, paramInt2);
      }
      if (this.Hj != null)
      {
        paramInt2 = getScrollX();
        i = getChildCount();
        paramInt1 = 0;
        while (paramInt1 < i)
        {
          localView = getChildAt(paramInt1);
          if (!((WxViewPager.LayoutParams)localView.getLayoutParams()).Ht)
          {
            paramFloat = (localView.getLeft() - paramInt2) / getClientWidth();
            this.Hj.j(localView, paramFloat);
          }
          paramInt1 += 1;
        }
      }
      this.Hd = true;
      return;
      label370:
      n = k;
      j = i;
    }
  }
  
  private void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    WxViewPager.b localb = Ib(paramInt1);
    int i = 0;
    if (localb != null) {
      i = (int)(getClientWidth() * Math.max(this.GI, Math.min(localb.Hs, this.GJ)));
    }
    if (paramBoolean1)
    {
      if (getChildCount() == 0) {
        setScrollingCacheEnabled(false);
      }
      int j;
      int k;
      int m;
      for (;;)
      {
        if ((paramBoolean2) && (this.Hg != null)) {
          this.Hg.R(paramInt1);
        }
        if ((paramBoolean2) && (this.Hh != null)) {
          this.Hh.R(paramInt1);
        }
        return;
        j = getScrollX();
        k = getScrollY();
        i -= j;
        m = 0 - k;
        if ((i != 0) || (m != 0)) {
          break;
        }
        G(false);
        dm();
        setScrollState(0);
      }
      setScrollingCacheEnabled(true);
      setScrollState(2);
      int n = getClientWidth();
      int i1 = n / 2;
      float f3 = Math.min(1.0F, 1.0F * Math.abs(i) / n);
      float f1 = i1;
      float f2 = i1;
      f3 = (float)Math.sin((float)((f3 - 0.5F) * 0.47123891676382D));
      paramInt2 = Math.abs(paramInt2);
      if (paramInt2 > 0) {}
      for (paramInt2 = Math.round(1000.0F * Math.abs((f2 * f3 + f1) / paramInt2)) * 4;; paramInt2 = (int)((Math.abs(i) / (f1 * f2 + this.GE) + 3.0F) * 100.0F))
      {
        paramInt2 = Math.min(paramInt2, 600);
        this.GB.startScroll(j, k, i, m, paramInt2);
        q.O(this);
        break;
        f1 = n;
        f2 = this.Gw.ax(this.Gx);
      }
    }
    if ((paramBoolean2) && (this.Hg != null)) {
      this.Hg.R(paramInt1);
    }
    if ((paramBoolean2) && (this.Hh != null)) {
      this.Hh.R(paramInt1);
    }
    G(false);
    scrollTo(i, 0);
    aA(i);
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  private void a(WxViewPager.b paramb1, int paramInt, WxViewPager.b paramb2)
  {
    int m = this.Gw.getCount();
    int i = getClientWidth();
    float f2;
    if (i > 0)
    {
      f2 = this.GE / i;
      if (paramb2 == null) {
        break label409;
      }
      i = paramb2.position;
      if (i < paramb1.position)
      {
        f1 = paramb2.Hs + paramb2.Hr + f2;
        i += 1;
        j = 0;
      }
    }
    else
    {
      for (;;)
      {
        if ((i > paramb1.position) || (j >= this.dU.size())) {
          break label409;
        }
        for (paramb2 = (WxViewPager.b)this.dU.get(j);; paramb2 = (WxViewPager.b)this.dU.get(j))
        {
          k = i;
          f3 = f1;
          if (i <= paramb2.position) {
            break;
          }
          k = i;
          f3 = f1;
          if (j >= this.dU.size() - 1) {
            break;
          }
          j += 1;
        }
        f2 = 0.0F;
        break;
        while (k < paramb2.position)
        {
          f3 += this.Gw.ax(k) + f2;
          k += 1;
        }
        paramb2.Hs = f3;
        f1 = f3 + (paramb2.Hr + f2);
        i = k + 1;
      }
    }
    if (i > paramb1.position)
    {
      j = this.dU.size() - 1;
      f1 = paramb2.Hs;
      i -= 1;
      while ((i >= paramb1.position) && (j >= 0))
      {
        for (paramb2 = (WxViewPager.b)this.dU.get(j);; paramb2 = (WxViewPager.b)this.dU.get(j))
        {
          k = i;
          f3 = f1;
          if (i >= paramb2.position) {
            break;
          }
          k = i;
          f3 = f1;
          if (j <= 0) {
            break;
          }
          j -= 1;
        }
        while (k > paramb2.position)
        {
          f3 -= this.Gw.ax(k) + f2;
          k -= 1;
        }
        f1 = f3 - (paramb2.Hr + f2);
        paramb2.Hs = f1;
        i = k - 1;
      }
    }
    label409:
    int k = this.dU.size();
    float f3 = paramb1.Hs;
    i = paramb1.position - 1;
    if (paramb1.position == 0)
    {
      f1 = paramb1.Hs;
      this.GI = f1;
      if (paramb1.position != m - 1) {
        break label550;
      }
      f1 = paramb1.Hs + paramb1.Hr - 1.0F;
      label475:
      this.GJ = f1;
      j = paramInt - 1;
      f1 = f3;
    }
    for (;;)
    {
      if (j < 0) {
        break label603;
      }
      paramb2 = (WxViewPager.b)this.dU.get(j);
      for (;;)
      {
        if (i > paramb2.position)
        {
          f1 -= this.Gw.ax(i) + f2;
          i -= 1;
          continue;
          f1 = -3.402824E+038F;
          break;
          label550:
          f1 = 3.4028235E+38F;
          break label475;
        }
      }
      f1 -= paramb2.Hr + f2;
      paramb2.Hs = f1;
      if (paramb2.position == 0) {
        this.GI = f1;
      }
      i -= 1;
      j -= 1;
    }
    label603:
    float f1 = paramb1.Hs + paramb1.Hr + f2;
    int j = paramb1.position + 1;
    i = paramInt + 1;
    paramInt = j;
    while (i < k)
    {
      paramb1 = (WxViewPager.b)this.dU.get(i);
      while (paramInt < paramb1.position)
      {
        f1 += this.Gw.ax(paramInt) + f2;
        paramInt += 1;
      }
      if (paramb1.position == m - 1) {
        this.GJ = (paramb1.Hr + f1 - 1.0F);
      }
      paramb1.Hs = f1;
      f1 += paramb1.Hr + f2;
      paramInt += 1;
      i += 1;
    }
    this.Hc = false;
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
    while ((paramBoolean) && (q.l(paramView, -paramInt1)))
    {
      View localView;
      return true;
      i -= 1;
      break;
    }
    return false;
  }
  
  private boolean aA(int paramInt)
  {
    WxViewPager.b localb;
    if (this.dU.size() == 0)
    {
      this.Hd = false;
      a(0, 0.0F, 0);
      if (!this.Hd) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
    }
    else
    {
      localb = cIG();
      if (localb != null) {
        break label53;
      }
    }
    return false;
    label53:
    int j = getClientWidth();
    int k = this.GE;
    float f = this.GE / j;
    int i = localb.position;
    f = (paramInt / j - localb.Hs) / (localb.Hr + f);
    paramInt = (int)((k + j) * f);
    this.Hd = false;
    a(i, f, paramInt);
    if (!this.Hd) {
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    return true;
  }
  
  private boolean arrowScroll(int paramInt)
  {
    boolean bool = false;
    View localView = findFocus();
    Object localObject;
    int j;
    if (localView == this)
    {
      localObject = null;
      localView = FocusFinder.getInstance().findNextFocus(this, (View)localObject, paramInt);
      if ((localView == null) || (localView == localObject)) {
        break label311;
      }
      if (paramInt != 17) {
        break label257;
      }
      i = a(this.ec, localView).left;
      j = a(this.ec, (View)localObject).left;
      if ((localObject != null) && (i >= j))
      {
        bool = dr();
        label92:
        if (bool) {
          playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
        }
        return bool;
      }
    }
    else
    {
      if (localView == null) {
        break label388;
      }
      localObject = localView.getParent();
      if (!(localObject instanceof ViewGroup)) {
        break label395;
      }
      if (localObject != this) {}
    }
    label257:
    label388:
    label395:
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
        new StringBuilder("arrowScroll tried to find focus based on non-child current focused view ").append(localStringBuilder.toString());
        localObject = null;
        break;
        bool = localView.requestFocus();
        break label92;
        if (paramInt != 66) {
          break label92;
        }
        i = a(this.ec, localView).left;
        j = a(this.ec, (View)localObject).left;
        if ((localObject == null) || (i > j))
        {
          bool = localView.requestFocus();
          break label92;
          label311:
          if ((paramInt == 17) || (paramInt == 1))
          {
            bool = dr();
            break label92;
          }
          if ((paramInt != 66) && (paramInt != 2)) {
            break label92;
          }
        }
        if ((this.Gw != null) && (this.Gx < this.Gw.getCount() - 1))
        {
          m(this.Gx + 1, true);
          bool = true;
          break label92;
        }
        bool = false;
        break label92;
      }
      localObject = localView;
      break;
    }
  }
  
  private void ay(int paramInt)
  {
    Object localObject2 = null;
    int j = 2;
    int i;
    if (this.Gx != paramInt)
    {
      if (this.Gx < paramInt)
      {
        i = 66;
        localObject2 = Ib(this.Gx);
        this.Gx = paramInt;
        j = i;
      }
    }
    else
    {
      if (this.Gw != null) {
        break label64;
      }
      dn();
    }
    label64:
    do
    {
      return;
      i = 17;
      break;
      if (this.GN)
      {
        dn();
        return;
      }
    } while (getWindowToken() == null);
    this.Gw.e(this);
    paramInt = this.GO;
    int i2 = Math.max(0, this.Gx - paramInt);
    int n = this.Gw.getCount();
    int i1 = Math.min(n - 1, paramInt + this.Gx);
    Object localObject1;
    if (n != this.Gs) {
      try
      {
        String str = getResources().getResourceName(getId());
        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.Gs + ", found: " + n + " Pager id: " + str + " Pager class: " + getClass() + " Problematic adapter: " + this.Gw.getClass());
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
    label249:
    if (paramInt < this.dU.size())
    {
      localObject1 = (WxViewPager.b)this.dU.get(paramInt);
      if (((WxViewPager.b)localObject1).position >= this.Gx) {
        if (((WxViewPager.b)localObject1).position != this.Gx) {
          break label1239;
        }
      }
    }
    for (;;)
    {
      if ((localObject1 == null) && (n > 0)) {}
      label517:
      label670:
      label682:
      label828:
      label1221:
      for (Object localObject3 = fD(this.Gx, paramInt);; localObject3 = localObject1)
      {
        float f1;
        int m;
        label349:
        int i3;
        float f2;
        label362:
        int k;
        if (localObject3 != null)
        {
          f1 = 0.0F;
          m = paramInt - 1;
          if (m >= 0)
          {
            localObject1 = (WxViewPager.b)this.dU.get(m);
            i3 = getClientWidth();
            if (i3 > 0) {
              break label490;
            }
            f2 = 0.0F;
            k = this.Gx - 1;
            i = paramInt;
            paramInt = m;
            label376:
            if (k < 0) {
              break label617;
            }
            if ((f1 < f2) || (k >= i2)) {
              break label517;
            }
            if (localObject1 == null) {
              break label617;
            }
            if ((k != ((WxViewPager.b)localObject1).position) || (((WxViewPager.b)localObject1).Hq)) {
              break label1229;
            }
            this.dU.remove(paramInt);
            this.Gw.a(this, k, ((WxViewPager.b)localObject1).object);
            paramInt -= 1;
            if (paramInt < 0) {
              break label511;
            }
            localObject1 = (WxViewPager.b)this.dU.get(paramInt);
            label462:
            i -= 1;
          }
        }
        label843:
        label1227:
        label1229:
        for (;;)
        {
          k -= 1;
          break label376;
          paramInt += 1;
          break label249;
          localObject1 = null;
          break label349;
          label490:
          f2 = 2.0F - ((WxViewPager.b)localObject3).Hr + getPaddingLeft() / i3;
          break label362;
          label511:
          localObject1 = null;
          break label462;
          if ((localObject1 != null) && (k == ((WxViewPager.b)localObject1).position))
          {
            f1 += ((WxViewPager.b)localObject1).Hr;
            paramInt -= 1;
            if (paramInt >= 0) {
              localObject1 = (WxViewPager.b)this.dU.get(paramInt);
            } else {
              localObject1 = null;
            }
          }
          else
          {
            f1 += fD(k, paramInt + 1).Hr;
            i += 1;
            if (paramInt >= 0) {}
            for (localObject1 = (WxViewPager.b)this.dU.get(paramInt);; localObject1 = null) {
              break;
            }
            label617:
            float f3 = ((WxViewPager.b)localObject3).Hr;
            m = i + 1;
            if (f3 < 2.0F)
            {
              Object localObject4;
              if (m < this.dU.size())
              {
                localObject1 = (WxViewPager.b)this.dU.get(m);
                if (i3 > 0) {
                  break label828;
                }
                f2 = 0.0F;
                k = this.Gx + 1;
                localObject4 = localObject1;
                if (k >= n) {
                  break label974;
                }
                if ((f3 < f2) || (k <= i1)) {
                  break label855;
                }
                if (localObject4 == null) {
                  break label974;
                }
                localObject1 = localObject4;
                f1 = f3;
                paramInt = m;
                if (k == localObject4.position)
                {
                  localObject1 = localObject4;
                  f1 = f3;
                  paramInt = m;
                  if (!localObject4.Hq)
                  {
                    this.dU.remove(m);
                    this.Gw.a(this, k, localObject4.object);
                    if (m >= this.dU.size()) {
                      break label843;
                    }
                    localObject1 = (WxViewPager.b)this.dU.get(m);
                    paramInt = m;
                    f1 = f3;
                  }
                }
              }
              for (;;)
              {
                k += 1;
                localObject4 = localObject1;
                f3 = f1;
                m = paramInt;
                break label682;
                localObject1 = null;
                break;
                f2 = getPaddingRight() / i3 + 2.0F;
                break label670;
                localObject1 = null;
                f1 = f3;
                paramInt = m;
                continue;
                label855:
                if ((localObject4 != null) && (k == localObject4.position))
                {
                  f1 = f3 + localObject4.Hr;
                  paramInt = m + 1;
                  if (paramInt < this.dU.size()) {
                    localObject1 = (WxViewPager.b)this.dU.get(paramInt);
                  } else {
                    localObject1 = null;
                  }
                }
                else
                {
                  localObject1 = fD(k, m);
                  paramInt = m + 1;
                  f1 = f3 + ((WxViewPager.b)localObject1).Hr;
                  if (paramInt < this.dU.size()) {
                    localObject1 = (WxViewPager.b)this.dU.get(paramInt);
                  } else {
                    localObject1 = null;
                  }
                }
              }
            }
            label974:
            a((WxViewPager.b)localObject3, i, (WxViewPager.b)localObject2);
            localObject2 = this.Gw;
            if (localObject3 != null) {}
            for (localObject1 = ((WxViewPager.b)localObject3).object;; localObject1 = null)
            {
              ((n)localObject2).j(localObject1);
              this.Gw.cc();
              i = getChildCount();
              paramInt = 0;
              while (paramInt < i)
              {
                localObject2 = getChildAt(paramInt);
                localObject1 = (WxViewPager.LayoutParams)((View)localObject2).getLayoutParams();
                ((WxViewPager.LayoutParams)localObject1).Hv = paramInt;
                if ((!((WxViewPager.LayoutParams)localObject1).Ht) && (((WxViewPager.LayoutParams)localObject1).Hr == 0.0F))
                {
                  localObject2 = ef((View)localObject2);
                  if (localObject2 != null)
                  {
                    ((WxViewPager.LayoutParams)localObject1).Hr = ((WxViewPager.b)localObject2).Hr;
                    ((WxViewPager.LayoutParams)localObject1).position = ((WxViewPager.b)localObject2).position;
                  }
                }
                paramInt += 1;
              }
            }
            dn();
            if (!hasFocus()) {
              break;
            }
            localObject1 = findFocus();
            if (localObject1 != null) {}
            for (localObject1 = eg((View)localObject1);; localObject1 = null)
            {
              if ((localObject1 != null) && (((WxViewPager.b)localObject1).position == this.Gx)) {
                break label1227;
              }
              paramInt = 0;
              for (;;)
              {
                if (paramInt >= getChildCount()) {
                  break label1221;
                }
                localObject1 = getChildAt(paramInt);
                localObject2 = ef((View)localObject1);
                if ((localObject2 != null) && (((WxViewPager.b)localObject2).position == this.Gx) && (((View)localObject1).requestFocus(j))) {
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
      label1239:
      localObject1 = null;
    }
  }
  
  private void d(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.fC) {
      if (i != 0) {
        break label56;
      }
    }
    label56:
    for (i = 1;; i = 0)
    {
      this.GS = paramMotionEvent.getX(i);
      this.fC = paramMotionEvent.getPointerId(i);
      if (this.fB != null) {
        this.fB.clear();
      }
      return;
    }
  }
  
  private void dn()
  {
    if (this.Hl != 0)
    {
      if (this.Hm == null) {
        this.Hm = new ArrayList();
      }
      for (;;)
      {
        int j = getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = getChildAt(i);
          this.Hm.add(localView);
          i += 1;
        }
        this.Hm.clear();
      }
      Collections.sort(this.Hm, vXp);
    }
  }
  
  private boolean dr()
  {
    if (this.Gx > 0)
    {
      m(this.Gx - 1, true);
      return true;
    }
    return false;
  }
  
  private void e(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > 0) && (!this.dU.isEmpty()))
    {
      int i = getPaddingLeft();
      int j = getPaddingRight();
      int k = getPaddingLeft();
      int m = getPaddingRight();
      f = getScrollX() / (paramInt2 - k - m + paramInt4);
      paramInt2 = (int)((paramInt1 - i - j + paramInt3) * f);
      scrollTo(paramInt2, getScrollY());
      if (!this.GB.isFinished())
      {
        paramInt3 = this.GB.getDuration();
        paramInt4 = this.GB.timePassed();
        localb = Ib(this.Gx);
        if (localb != null) {
          this.GB.startScroll(paramInt2, 0, (int)(localb.Hs * paramInt1), 0, paramInt3 - paramInt4);
        }
      }
      return;
    }
    WxViewPager.b localb = Ib(this.Gx);
    if (localb != null) {}
    for (float f = Math.min(localb.Hs, this.GJ);; f = 0.0F)
    {
      paramInt1 = (int)(f * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (paramInt1 == getScrollX()) {
        break;
      }
      G(false);
      scrollTo(paramInt1, getScrollY());
      return;
    }
  }
  
  private WxViewPager.b ef(View paramView)
  {
    int i = 0;
    while (i < this.dU.size())
    {
      WxViewPager.b localb = (WxViewPager.b)this.dU.get(i);
      if (this.Gw.a(paramView, localb.object)) {
        return localb;
      }
      i += 1;
    }
    return null;
  }
  
  private WxViewPager.b eg(View paramView)
  {
    for (;;)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent == this) {
        break;
      }
      if ((localViewParent == null) || (!(localViewParent instanceof View))) {
        return null;
      }
      paramView = (View)localViewParent;
    }
    return ef(paramView);
  }
  
  private WxViewPager.b fD(int paramInt1, int paramInt2)
  {
    WxViewPager.b localb = new WxViewPager.b();
    localb.position = paramInt1;
    localb.object = this.Gw.b(this, paramInt1);
    localb.Hr = this.Gw.ax(paramInt1);
    if ((paramInt2 < 0) || (paramInt2 >= this.dU.size()))
    {
      this.dU.add(localb);
      return localb;
    }
    this.dU.add(paramInt2, localb);
    return localb;
  }
  
  private boolean r(float paramFloat)
  {
    int j = 1;
    boolean bool2 = false;
    boolean bool1 = false;
    float f1 = this.GS;
    this.GS = paramFloat;
    float f2 = getScrollX() + (f1 - paramFloat);
    int k = getClientWidth();
    paramFloat = k * this.GI;
    f1 = k;
    float f3 = this.GJ;
    WxViewPager.b localb1 = (WxViewPager.b)this.dU.get(0);
    WxViewPager.b localb2 = (WxViewPager.b)this.dU.get(this.dU.size() - 1);
    if (localb1.position != 0)
    {
      paramFloat = localb1.Hs;
      paramFloat = k * paramFloat;
    }
    for (int i = 0;; i = 1)
    {
      if (localb2.position != this.Gw.getCount() - 1)
      {
        f1 = localb2.Hs * k;
        j = 0;
      }
      for (;;)
      {
        if (f2 < paramFloat)
        {
          f1 = paramFloat;
          if (i != 0)
          {
            bool1 = this.oIT.D(Math.abs(paramFloat - f2) / k);
            f1 = paramFloat;
          }
        }
        for (;;)
        {
          this.GS += f1 - (int)f1;
          scrollTo((int)f1, getScrollY());
          aA((int)f1);
          return bool1;
          if (f2 > f1)
          {
            bool1 = bool2;
            if (j != 0) {
              bool1 = this.oIU.D(Math.abs(f2 - f1) / k);
            }
          }
          else
          {
            f1 = f2;
          }
        }
        f1 *= f3;
      }
    }
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.GM != paramBoolean) {
      this.GM = paramBoolean;
    }
  }
  
  public final int a(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((Math.abs(paramInt3) > this.GW) && (Math.abs(paramInt2) > this.GU))
    {
      if (paramInt2 > 0) {}
      for (;;)
      {
        paramInt2 = paramInt1;
        if (this.dU.size() > 0) {
          paramInt2 = Math.max(cBh(), Math.min(paramInt1, cBi()));
        }
        return paramInt2;
        paramInt1 += 1;
      }
    }
    if (paramInt1 >= this.Gx) {}
    for (float f = 0.6F;; f = 0.4F)
    {
      paramInt1 = (int)(f + (paramInt1 + paramFloat));
      break;
    }
  }
  
  public final void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    boolean bool = false;
    if ((this.Gw == null) || (this.Gw.getCount() <= 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    if ((!paramBoolean2) && (this.Gx == paramInt1) && (this.dU.size() != 0))
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
      paramInt1 = this.GO;
      if ((i <= this.Gx + paramInt1) && (i >= this.Gx - paramInt1)) {
        break;
      }
      paramInt1 = 0;
      while (paramInt1 < this.dU.size())
      {
        ((WxViewPager.b)this.dU.get(paramInt1)).Hq = true;
        paramInt1 += 1;
      }
      i = paramInt1;
      if (paramInt1 >= this.Gw.getCount()) {
        i = this.Gw.getCount() - 1;
      }
    }
    paramBoolean2 = bool;
    if (this.Gx != i) {
      paramBoolean2 = true;
    }
    if (this.Hb)
    {
      this.Gx = i;
      if ((paramBoolean2) && (this.Hg != null)) {
        this.Hg.R(i);
      }
      if ((paramBoolean2) && (this.Hh != null)) {
        this.Hh.R(i);
      }
      requestLayout();
      return;
    }
    ay(i);
    a(i, paramBoolean1, paramInt2, paramBoolean2);
  }
  
  public boolean ab(float paramFloat1, float paramFloat2)
  {
    return ((paramFloat1 < this.GR) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getWidth() - this.GR) && (paramFloat2 < 0.0F));
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    Assert.assertNotNull(paramArrayList);
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
          WxViewPager.b localb = ef(localView);
          if ((localb != null) && (localb.position == this.Gx)) {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
        i += 1;
      }
    }
    if (((k == 262144) && (j != paramArrayList.size())) || (!isFocusable())) {}
    while (((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) {
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
        WxViewPager.b localb = ef(localView);
        if ((localb != null) && (localb.position == this.Gx)) {
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
      Assert.assertNotNull(paramLayoutParams);
      WxViewPager.LayoutParams localLayoutParams = (WxViewPager.LayoutParams)paramLayoutParams;
      localLayoutParams.Ht |= paramView instanceof WxViewPager.a;
      if (this.mInLayout)
      {
        if (localLayoutParams.Ht) {
          throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        localLayoutParams.Hu = true;
        addViewInLayout(paramView, paramInt, paramLayoutParams);
        return;
      }
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    }
  }
  
  public int cBh()
  {
    return ((WxViewPager.b)this.dU.get(0)).position;
  }
  
  public int cBi()
  {
    return ((WxViewPager.b)this.dU.get(this.dU.size() - 1)).position;
  }
  
  public final WxViewPager.b cIG()
  {
    int i = getClientWidth();
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
    WxViewPager.b localb;
    if (i > 0)
    {
      f1 = getScrollX() / i;
      if (i <= 0) {
        break label215;
      }
      f2 = this.GE / i;
      k = -1;
      j = 1;
      i = 0;
      localObject1 = null;
      f3 = 0.0F;
      f4 = 0.0F;
      localObject2 = localObject1;
      if (i < this.dU.size())
      {
        localb = (WxViewPager.b)this.dU.get(i);
        if ((j != 0) || (localb.position == k + 1)) {
          break label249;
        }
        localb = this.vXm;
        localb.Hs = (f4 + f3 + f2);
        localb.position = (k + 1);
        localb.Hr = this.Gw.ax(localb.position);
        i -= 1;
      }
    }
    label215:
    label220:
    label249:
    for (;;)
    {
      f4 = localb.Hs;
      f3 = localb.Hr;
      if (j == 0)
      {
        localObject2 = localObject1;
        if (f1 < f4) {}
      }
      else
      {
        if ((f1 >= f3 + f4 + f2) && (i != this.dU.size() - 1)) {
          break label220;
        }
        localObject2 = localb;
      }
      return localObject2;
      f1 = 0.0F;
      break;
      f2 = 0.0F;
      break label36;
      k = localb.position;
      f3 = localb.Hr;
      i += 1;
      j = 0;
      localObject1 = localb;
      break label53;
    }
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    if (this.Gw == null) {}
    int i;
    int j;
    do
    {
      do
      {
        return false;
        i = getClientWidth();
        j = getScrollX();
        if (paramInt >= 0) {
          break;
        }
      } while (j <= (int)(i * this.GI));
      return true;
    } while ((paramInt <= 0) || (j >= (int)(i * this.GJ)));
    return true;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof WxViewPager.LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    if ((!this.GB.isFinished()) && (this.GB.computeScrollOffset()))
    {
      int i = getScrollX();
      int j = getScrollY();
      int k = this.GB.getCurrX();
      int m = this.GB.getCurrY();
      if ((i != k) || (j != m))
      {
        scrollTo(k, m);
        if (!aA(k))
        {
          this.GB.abortAnimation();
          scrollTo(0, m);
        }
      }
      q.O(this);
      return;
    }
    G(true);
  }
  
  public final void dO()
  {
    this.iZ = false;
    this.GP = false;
    if (this.fB != null)
    {
      this.fB.recycle();
      this.fB = null;
    }
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
      bool1 = arrowScroll(17);
      continue;
      bool1 = arrowScroll(66);
      continue;
      if (Build.VERSION.SDK_INT < 11) {
        break;
      }
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
        WxViewPager.b localb = ef(localView);
        if ((localb != null) && (localb.position == this.Gx) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
          return true;
        }
      }
      i += 1;
    }
  }
  
  final void dl()
  {
    int i5 = this.Gw.getCount();
    this.Gs = i5;
    int i;
    int j;
    int n;
    int k;
    int i3;
    label60:
    Object localObject;
    int i4;
    int i2;
    int i1;
    int m;
    if ((this.dU.size() < this.GO * 2 + 1) && (this.dU.size() < i5))
    {
      i = 1;
      j = this.Gx;
      n = 0;
      k = 0;
      i3 = i;
      if (n >= this.dU.size()) {
        break label296;
      }
      localObject = (WxViewPager.b)this.dU.get(n);
      i4 = this.Gw.F(((WxViewPager.b)localObject).object);
      i2 = n;
      i1 = k;
      m = j;
      i = i3;
      if (i4 != -1)
      {
        if (i4 != -2) {
          break label236;
        }
        this.dU.remove(n);
        i2 = n - 1;
        n = k;
        if (k == 0)
        {
          this.Gw.e(this);
          n = 1;
        }
        this.Gw.a(this, ((WxViewPager.b)localObject).position, ((WxViewPager.b)localObject).object);
        if (this.Gx != ((WxViewPager.b)localObject).position) {
          break label380;
        }
        m = Math.max(0, Math.min(this.Gx, i5 - 1));
        i = 1;
        i1 = n;
      }
    }
    for (;;)
    {
      n = i2 + 1;
      k = i1;
      j = m;
      i3 = i;
      break label60;
      i = 0;
      break;
      label236:
      i2 = n;
      i1 = k;
      m = j;
      i = i3;
      if (((WxViewPager.b)localObject).position != i4)
      {
        if (((WxViewPager.b)localObject).position == this.Gx) {
          j = i4;
        }
        ((WxViewPager.b)localObject).position = i4;
        i = 1;
        i2 = n;
        i1 = k;
        m = j;
        continue;
        label296:
        if (k != 0) {
          this.Gw.cc();
        }
        Collections.sort(this.dU, Gt);
        if (i3 != 0)
        {
          k = getChildCount();
          i = 0;
          while (i < k)
          {
            localObject = (WxViewPager.LayoutParams)getChildAt(i).getLayoutParams();
            if (!((WxViewPager.LayoutParams)localObject).Ht) {
              ((WxViewPager.LayoutParams)localObject).Hr = 0.0F;
            }
            i += 1;
          }
          a(j, false, true);
          requestLayout();
        }
        return;
        label380:
        i = 1;
        i1 = n;
        m = j;
      }
    }
  }
  
  final void dm()
  {
    ay(this.Gx);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int k = 0;
    int i = 0;
    int m = q.L(this);
    boolean bool;
    if ((m == 0) || ((m == 1) && (this.Gw != null) && (this.Gw.getCount() > 1)))
    {
      int j;
      if (!this.oIT.KQ.isFinished())
      {
        k = paramCanvas.save();
        i = getHeight() - getPaddingTop() - getPaddingBottom();
        m = getWidth();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(-i + getPaddingTop(), this.GI * m);
        this.oIT.setSize(i, m);
        j = this.oIT.draw(paramCanvas) | false;
        paramCanvas.restoreToCount(k);
      }
      k = j;
      if (!this.oIU.KQ.isFinished())
      {
        m = paramCanvas.save();
        k = getWidth();
        int n = getHeight();
        int i1 = getPaddingTop();
        int i2 = getPaddingBottom();
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-getPaddingTop(), -(this.GJ + 1.0F) * k);
        this.oIU.setSize(n - i1 - i2, k);
        bool = j | this.oIU.draw(paramCanvas);
        paramCanvas.restoreToCount(m);
      }
    }
    for (;;)
    {
      if (bool) {
        q.O(this);
      }
      return;
      this.oIT.KQ.finish();
      this.oIU.KQ.finish();
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.GF;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new WxViewPager.LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new WxViewPager.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return generateDefaultLayoutParams();
  }
  
  public n getAdapter()
  {
    return this.Gw;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (this.Hl == 2) {
      i = paramInt1 - 1 - paramInt2;
    }
    return ((WxViewPager.LayoutParams)((View)this.Hm.get(i)).getLayoutParams()).Hv;
  }
  
  public int getClientWidth()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  public int getCurrentItem()
  {
    return this.Gx;
  }
  
  public int getOffscreenPageLimit()
  {
    return this.GO;
  }
  
  public int getPageMargin()
  {
    return this.GE;
  }
  
  public final void m(int paramInt, boolean paramBoolean)
  {
    this.GN = false;
    a(paramInt, paramBoolean, false);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.Hb = true;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.Ho);
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.GE > 0) && (this.GF != null) && (this.dU.size() > 0) && (this.Gw != null))
    {
      int k = getScrollX();
      int m = getWidth();
      float f3 = this.GE / m;
      Object localObject = (WxViewPager.b)this.dU.get(0);
      float f1 = ((WxViewPager.b)localObject).Hs;
      int n = this.dU.size();
      int i = ((WxViewPager.b)localObject).position;
      int i1 = ((WxViewPager.b)this.dU.get(n - 1)).position;
      int j = 0;
      if (i < i1)
      {
        while ((i > ((WxViewPager.b)localObject).position) && (j < n))
        {
          localObject = this.dU;
          j += 1;
          localObject = (WxViewPager.b)((ArrayList)localObject).get(j);
        }
        float f2;
        if (i == ((WxViewPager.b)localObject).position) {
          f2 = (((WxViewPager.b)localObject).Hs + ((WxViewPager.b)localObject).Hr) * m;
        }
        float f4;
        for (f1 = ((WxViewPager.b)localObject).Hs + ((WxViewPager.b)localObject).Hr + f3;; f1 += f4 + f3)
        {
          if (this.GE + f2 > k)
          {
            this.GF.setBounds((int)f2, this.GG, (int)(this.GE + f2 + 0.5F), this.GH);
            this.GF.draw(paramCanvas);
          }
          if (f2 > k + m) {
            return;
          }
          i += 1;
          break;
          f4 = this.Gw.ax(i);
          f2 = (f1 + f4) * m;
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i == 3) || (i == 1))
    {
      this.iZ = false;
      this.GP = false;
      this.fC = -1;
      if (this.fB != null)
      {
        this.fB.recycle();
        this.fB = null;
      }
    }
    do
    {
      return false;
      if (i == 0) {
        break;
      }
      if (this.iZ) {
        return true;
      }
    } while (this.GP);
    switch (i)
    {
    }
    for (;;)
    {
      if (this.fB == null) {
        this.fB = VelocityTracker.obtain();
      }
      this.fB.addMovement(paramMotionEvent);
      return this.iZ;
      i = this.fC;
      if (i != -1)
      {
        i = paramMotionEvent.findPointerIndex(i);
        float f2 = paramMotionEvent.getX(i);
        float f1 = f2 - this.GS;
        float f4 = Math.abs(f1);
        float f3 = paramMotionEvent.getY(i);
        float f5 = Math.abs(f3 - this.FI);
        if ((f1 != 0.0F) && (!ab(this.GS, f1)) && (a(this, false, (int)f1, (int)f2, (int)f3)))
        {
          this.GS = f2;
          this.GT = f3;
          this.GP = true;
          return false;
        }
        if ((f4 > this.jb) && (0.5F * f4 > f5))
        {
          this.iZ = true;
          setScrollState(1);
          if (f1 > 0.0F)
          {
            f1 = this.FH + this.jb;
            label305:
            this.GS = f1;
            this.GT = f3;
            setScrollingCacheEnabled(true);
          }
        }
        while ((this.iZ) && (r(f2)))
        {
          q.O(this);
          break;
          f1 = this.FH - this.jb;
          break label305;
          if (f5 > this.jb) {
            this.GP = true;
          }
        }
        f1 = paramMotionEvent.getX();
        this.FH = f1;
        this.GS = f1;
        f1 = paramMotionEvent.getY();
        this.FI = f1;
        this.GT = f1;
        this.fC = paramMotionEvent.getPointerId(0);
        this.GP = false;
        this.GB.computeScrollOffset();
        if ((this.lf == 2) && (Math.abs(this.GB.getFinalX() - this.GB.getCurrX()) > this.GX))
        {
          this.GB.abortAnimation();
          this.GN = false;
          dm();
          this.iZ = true;
          setScrollState(1);
        }
        else
        {
          G(false);
          this.iZ = false;
          continue;
          d(paramMotionEvent);
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
    WxViewPager.LayoutParams localLayoutParams;
    int n;
    int i;
    if (m < i1)
    {
      localView = getChildAt(m);
      if (localView.getVisibility() == 8) {
        break label636;
      }
      localLayoutParams = (WxViewPager.LayoutParams)localView.getLayoutParams();
      if (!localLayoutParams.Ht) {
        break label636;
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
          localLayoutParams = (WxViewPager.LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.Ht)
          {
            WxViewPager.b localb = ef(localView);
            if (localb != null)
            {
              float f = paramInt4;
              i = (int)(localb.Hs * f) + paramInt1;
              if (localLayoutParams.Hu)
              {
                localLayoutParams.Hu = false;
                f = paramInt4;
                localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.Hr * f), 1073741824), View.MeasureSpec.makeMeasureSpec(i2 - paramInt2 - j, 1073741824));
              }
              localView.layout(i, paramInt2, localView.getMeasuredWidth() + i, localView.getMeasuredHeight() + paramInt2);
            }
          }
        }
        paramInt3 += 1;
      }
      this.GG = paramInt2;
      this.GH = (i2 - j);
      this.He = k;
      if (this.Hb) {
        a(this.Gx, false, 0, false);
      }
      this.Hb = false;
      return;
      label636:
      paramInt4 = k;
      i = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = i;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    this.GR = Math.min(paramInt1 / 10, this.GQ);
    paramInt1 = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int i4 = getChildCount();
    int k = 0;
    View localView;
    int i;
    int j;
    WxViewPager.LayoutParams localLayoutParams;
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
        localLayoutParams = (WxViewPager.LayoutParams)localView.getLayoutParams();
        i = paramInt1;
        j = paramInt2;
        if (localLayoutParams != null)
        {
          i = paramInt1;
          j = paramInt2;
          if (localLayoutParams.Ht)
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
              break label533;
            }
            i1 = 1073741824;
            if (localLayoutParams.width == -1) {
              break label527;
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
        this.GK = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
        this.GL = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
        this.mInLayout = true;
        dm();
        this.mInLayout = false;
        i = getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          localView = getChildAt(paramInt2);
          if (localView.getVisibility() != 8)
          {
            localLayoutParams = (WxViewPager.LayoutParams)localView.getLayoutParams();
            if (((localLayoutParams == null) || (!localLayoutParams.Ht)) && (localLayoutParams != null))
            {
              float f = paramInt1;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.Hr * f), 1073741824), this.GL);
            }
          }
          paramInt2 += 1;
        }
        return;
      }
      label527:
      i = paramInt1;
      continue;
      label533:
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
        WxViewPager.b localb = ef(localView);
        if ((localb != null) && (localb.position == this.Gx) && (localView.requestFocus(paramInt, paramRect)))
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
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (this.Gw != null)
    {
      this.Gw.a(paramParcelable.Hw, paramParcelable.Hx);
      a(paramParcelable.position, false, true);
      return;
    }
    this.Gy = paramParcelable.position;
    this.Gz = paramParcelable.Hw;
    this.GA = paramParcelable.Hx;
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.position = this.Gx;
    if (this.Gw != null) {
      localSavedState.Hw = this.Gw.cd();
    }
    return localSavedState;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      e(paramInt1, paramInt3, this.GE, this.GE);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = 0;
    boolean bool4 = false;
    boolean bool3;
    if (this.GY) {
      bool3 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool3;
          if (paramMotionEvent.getAction() != 0) {
            break;
          }
          bool3 = bool4;
        } while (paramMotionEvent.getEdgeFlags() != 0);
        bool3 = bool4;
      } while (this.Gw == null);
      bool3 = bool4;
    } while (this.Gw.getCount() == 0);
    if (this.fB == null) {
      this.fB = VelocityTracker.obtain();
    }
    this.fB.addMovement(paramMotionEvent);
    int i = m;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      i = m;
    }
    for (;;)
    {
      if (i != 0) {
        q.O(this);
      }
      return true;
      this.GB.abortAnimation();
      this.GN = false;
      dm();
      this.iZ = true;
      setScrollState(1);
      float f1 = paramMotionEvent.getX();
      this.FH = f1;
      this.GS = f1;
      f1 = paramMotionEvent.getY();
      this.FI = f1;
      this.GT = f1;
      this.fC = paramMotionEvent.getPointerId(0);
      i = m;
      continue;
      float f2;
      if (!this.iZ)
      {
        i = paramMotionEvent.findPointerIndex(this.fC);
        f1 = paramMotionEvent.getX(i);
        float f3 = Math.abs(f1 - this.GS);
        f2 = paramMotionEvent.getY(i);
        float f4 = Math.abs(f2 - this.GT);
        if ((f3 > this.jb) && (f3 > f4))
        {
          this.iZ = true;
          if (f1 - this.FH <= 0.0F) {
            break label380;
          }
        }
      }
      label380:
      for (f1 = this.FH + this.jb;; f1 = this.FH - this.jb)
      {
        this.GS = f1;
        this.GT = f2;
        setScrollState(1);
        setScrollingCacheEnabled(true);
        i = m;
        if (!this.iZ) {
          break;
        }
        bool1 = r(paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.fC))) | false;
        break;
      }
      boolean bool1 = m;
      if (this.iZ)
      {
        Object localObject = this.fB;
        ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.GV);
        int n = (int)((VelocityTracker)localObject).getXVelocity(this.fC);
        this.GN = true;
        int j = getClientWidth();
        m = getScrollX();
        localObject = cIG();
        if (localObject != null)
        {
          int i1 = ((WxViewPager.b)localObject).position;
          f1 = (m / j - ((WxViewPager.b)localObject).Hs) / ((WxViewPager.b)localObject).Hr;
          m = paramMotionEvent.findPointerIndex(this.fC);
          j = m;
          if (m < 0) {
            j = 0;
          }
          a(a(i1, f1, n, (int)(paramMotionEvent.getX(j) - this.FH)), true, true, n);
        }
        this.fC = -1;
        dO();
        bool3 = this.oIT.dL();
        boolean bool2 = this.oIU.dL() | bool3;
        continue;
        bool2 = m;
        if (this.iZ)
        {
          a(this.Gx, true, 0, false);
          this.fC = -1;
          dO();
          bool3 = this.oIT.dL();
          bool2 = this.oIU.dL() | bool3;
          continue;
          int k = paramMotionEvent.getActionIndex();
          this.GS = paramMotionEvent.getX(k);
          this.fC = paramMotionEvent.getPointerId(k);
          k = m;
          continue;
          d(paramMotionEvent);
          this.GS = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.fC));
          k = m;
        }
      }
    }
  }
  
  public void removeView(View paramView)
  {
    if (this.mInLayout)
    {
      removeViewInLayout(paramView);
      return;
    }
    super.removeView(paramView);
  }
  
  public void setAdapter(n paramn)
  {
    if (this.Gw != null)
    {
      this.Gw.unregisterDataSetObserver(this.vXn);
      this.Gw.e(this);
      int i = 0;
      while (i < this.dU.size())
      {
        WxViewPager.b localb = (WxViewPager.b)this.dU.get(i);
        this.Gw.a(this, localb.position, localb.object);
        i += 1;
      }
      this.Gw.cc();
      this.dU.clear();
      int j;
      for (i = 0; i < getChildCount(); i = j + 1)
      {
        j = i;
        if (!((WxViewPager.LayoutParams)getChildAt(i).getLayoutParams()).Ht)
        {
          removeViewAt(i);
          j = i - 1;
        }
      }
      this.Gx = 0;
      scrollTo(0, 0);
    }
    this.Gw = paramn;
    this.Gs = 0;
    boolean bool;
    if (this.Gw != null)
    {
      if (this.vXn == null) {
        this.vXn = new e((byte)0);
      }
      this.Gw.registerDataSetObserver(this.vXn);
      this.GN = false;
      bool = this.Hb;
      this.Hb = true;
      this.Gs = this.Gw.getCount();
      if (this.Gy >= 0)
      {
        this.Gw.a(this.Gz, this.GA);
        a(this.Gy, false, true);
        this.Gy = -1;
        this.Gz = null;
        this.GA = null;
      }
    }
    else
    {
      return;
    }
    if (!bool)
    {
      dm();
      return;
    }
    requestLayout();
  }
  
  void setChildrenDrawingOrderEnabledCompat(boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT < 7) || (this.oIW == null)) {}
    try
    {
      this.oIW = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] { Boolean.TYPE });
      try
      {
        label37:
        if (this.oIW != null) {
          this.oIW.invoke(this, new Object[] { Boolean.valueOf(paramBoolean) });
        }
        return;
      }
      catch (Exception localException) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label37;
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.GN = false;
    if (!this.Hb) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramInt, bool, false);
      return;
    }
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0)
    {
      new StringBuilder("Requested offscreen page limit ").append(paramInt).append(" too small; defaulting to 1");
      i = 1;
    }
    if (i != this.GO)
    {
      this.GO = i;
      dm();
    }
  }
  
  void setOnAdapterChangeListener(WxViewPager.d paramd)
  {
    this.vXo = paramd;
  }
  
  public void setOnPageChangeListener(ViewPager.e parame)
  {
    this.Hg = parame;
  }
  
  public void setPageMargin(int paramInt)
  {
    int i = this.GE;
    this.GE = paramInt;
    int j = getWidth();
    e(j, j, paramInt, i);
    requestLayout();
  }
  
  public void setPageMarginDrawable(int paramInt)
  {
    setPageMarginDrawable(getContext().getResources().getDrawable(paramInt));
  }
  
  public void setPageMarginDrawable(Drawable paramDrawable)
  {
    this.GF = paramDrawable;
    if (paramDrawable != null) {
      refreshDrawableState();
    }
    if (paramDrawable == null) {}
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
    }
  }
  
  public void setScrollState(int paramInt)
  {
    if (this.lf == paramInt) {}
    label35:
    label70:
    do
    {
      return;
      this.lf = paramInt;
      if (this.Hj != null)
      {
        int i;
        int j;
        if (paramInt != 0)
        {
          i = 1;
          int m = getChildCount();
          j = 0;
          if (j >= m) {
            continue;
          }
          if (i == 0) {
            break label70;
          }
        }
        for (int k = 2;; k = 0)
        {
          q.o(getChildAt(j), k);
          j += 1;
          break label35;
          i = 0;
          break;
        }
      }
    } while (this.Hg == null);
    this.Hg.Q(paramInt);
  }
  
  public void setScroller(Scroller paramScroller)
  {
    this.GB = paramScroller;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.GF);
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = d.a(new WxViewPager.SavedState.1());
    Parcelable Hw;
    ClassLoader Hx;
    int position;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super();
      ClassLoader localClassLoader = paramClassLoader;
      if (paramClassLoader == null) {
        localClassLoader = getClass().getClassLoader();
      }
      this.position = paramParcel.readInt();
      this.Hw = paramParcel.readParcelable(localClassLoader);
      this.Hx = localClassLoader;
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.position);
      paramParcel.writeParcelable(this.Hw, paramInt);
    }
  }
  
  private final class e
    extends DataSetObserver
  {
    private e() {}
    
    public final void onChanged()
    {
      WxViewPager.this.dl();
    }
    
    public final void onInvalidated()
    {
      WxViewPager.this.dl();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.mogic.WxViewPager
 * JD-Core Version:    0.7.0.1
 */