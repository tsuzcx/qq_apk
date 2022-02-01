package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.view.a.a;
import android.support.v4.view.a.i;
import android.support.v4.view.r;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager
  extends ab
{
  int tZ;
  private o ua;
  s ub;
  private boolean uc;
  private boolean ud;
  boolean ue;
  private boolean uf;
  private boolean ug;
  int uh;
  int ui;
  private boolean uj;
  LinearLayoutManager.SavedState uk;
  final m ul;
  
  private int a(int paramInt, af paramaf, ak paramak, boolean paramBoolean)
  {
    int i = this.ub.dk() - paramInt;
    if (i > 0)
    {
      int j = -c(-i, paramaf, paramak);
      i = j;
      if (paramBoolean)
      {
        paramInt = this.ub.dk() - (paramInt + j);
        i = j;
        if (paramInt > 0)
        {
          this.ub.av(paramInt);
          i = j + paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private int a(af paramaf, o paramo, ak paramak, boolean paramBoolean)
  {
    int k = paramo.tT;
    if (paramo.uv != -2147483648)
    {
      if (paramo.tT < 0) {
        paramo.uv += paramo.tT;
      }
      a(paramaf, paramo);
    }
    int i = paramo.tT + paramo.uw;
    n localn = new n();
    do
    {
      int j;
      do
      {
        if ((i <= 0) || (!paramo.a(paramak))) {
          break;
        }
        localn.df();
        a(paramaf, paramak, paramo, localn);
        if (localn.ur) {
          break;
        }
        paramo.lm += localn.uq * paramo.tW;
        if ((localn.us) && (this.ua.uz == null))
        {
          j = i;
          if (paramak.em()) {}
        }
        else
        {
          paramo.tT -= localn.uq;
          j = i - localn.uq;
        }
        if (paramo.uv != -2147483648)
        {
          paramo.uv += localn.uq;
          if (paramo.tT < 0) {
            paramo.uv += paramo.tT;
          }
          a(paramaf, paramo);
        }
        i = j;
      } while (!paramBoolean);
      i = j;
    } while (!localn.ut);
    return k - paramo.tT;
  }
  
  private View a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    db();
    int j = this.ub.dj();
    int k = this.ub.dk();
    if (paramInt2 > paramInt1) {}
    Object localObject;
    View localView;
    for (int i = 1;; i = -1)
    {
      localObject = null;
      if (paramInt1 == paramInt2) {
        break label125;
      }
      localView = getChildAt(paramInt1);
      int m = this.ub.al(localView);
      int n = this.ub.am(localView);
      if ((m >= k) || (n <= j)) {
        break label128;
      }
      if ((paramBoolean1) && ((m < j) || (n > k))) {
        break;
      }
      return localView;
    }
    if (localObject == null) {
      localObject = localView;
    }
    label128:
    for (;;)
    {
      paramInt1 += i;
      break;
      label125:
      return localObject;
    }
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean, ak paramak)
  {
    int i = -1;
    int j = 1;
    this.ua.uw = b(paramak);
    this.ua.tW = paramInt1;
    if (paramInt1 == 1)
    {
      paramak = this.ua;
      paramak.uw += this.ub.getEndPadding();
      paramak = dd();
      localo = this.ua;
      if (this.ue) {}
      for (paramInt1 = i;; paramInt1 = 1)
      {
        localo.tV = paramInt1;
        this.ua.tU = (av(paramak) + this.ua.tV);
        this.ua.lm = this.ub.am(paramak);
        paramInt1 = this.ub.am(paramak) - this.ub.dk();
        this.ua.tT = paramInt2;
        if (paramBoolean)
        {
          paramak = this.ua;
          paramak.tT -= paramInt1;
        }
        this.ua.uv = paramInt1;
        return;
      }
    }
    paramak = dc();
    o localo = this.ua;
    localo.uw += this.ub.dj();
    localo = this.ua;
    if (this.ue) {}
    for (paramInt1 = j;; paramInt1 = -1)
    {
      localo.tV = paramInt1;
      this.ua.tU = (av(paramak) + this.ua.tV);
      this.ua.lm = this.ub.al(paramak);
      paramInt1 = -this.ub.al(paramak) + this.ub.dj();
      break;
    }
  }
  
  private void a(af paramaf, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {}
    for (;;)
    {
      return;
      int i = paramInt1;
      if (paramInt2 > paramInt1)
      {
        paramInt2 -= 1;
        while (paramInt2 >= paramInt1)
        {
          a(paramInt2, paramaf);
          paramInt2 -= 1;
        }
      }
      else
      {
        while (i > paramInt2)
        {
          a(i, paramaf);
          i -= 1;
        }
      }
    }
  }
  
  private void a(af paramaf, o paramo)
  {
    if (!paramo.uu) {}
    for (;;)
    {
      return;
      int i;
      int j;
      int k;
      if (paramo.tW == -1)
      {
        i = paramo.uv;
        j = getChildCount();
        if (i >= 0)
        {
          k = this.ub.getEnd() - i;
          if (this.ue)
          {
            i = 0;
            while (i < j)
            {
              paramo = getChildAt(i);
              if (this.ub.al(paramo) < k)
              {
                a(paramaf, 0, i);
                return;
              }
              i += 1;
            }
          }
          else
          {
            i = j - 1;
            while (i >= 0)
            {
              paramo = getChildAt(i);
              if (this.ub.al(paramo) < k)
              {
                a(paramaf, j - 1, i);
                return;
              }
              i -= 1;
            }
          }
        }
      }
      else
      {
        j = paramo.uv;
        if (j >= 0)
        {
          k = getChildCount();
          if (this.ue)
          {
            i = k - 1;
            while (i >= 0)
            {
              paramo = getChildAt(i);
              if (this.ub.am(paramo) > j)
              {
                a(paramaf, k - 1, i);
                return;
              }
              i -= 1;
            }
          }
          else
          {
            i = 0;
            while (i < k)
            {
              paramo = getChildAt(i);
              if (this.ub.am(paramo) > j)
              {
                a(paramaf, 0, i);
                return;
              }
              i += 1;
            }
          }
        }
      }
    }
  }
  
  private void a(m paramm)
  {
    y(paramm.un, paramm.uo);
  }
  
  private int b(int paramInt, af paramaf, ak paramak, boolean paramBoolean)
  {
    int i = paramInt - this.ub.dj();
    if (i > 0)
    {
      int j = -c(i, paramaf, paramak);
      i = j;
      if (paramBoolean)
      {
        paramInt = paramInt + j - this.ub.dj();
        i = j;
        if (paramInt > 0)
        {
          this.ub.av(-paramInt);
          i = j - paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private int b(ak paramak)
  {
    if (paramak.ep()) {
      return this.ub.dl();
    }
    return 0;
  }
  
  private void b(m paramm)
  {
    z(paramm.un, paramm.uo);
  }
  
  private int c(int paramInt, af paramaf, ak paramak)
  {
    if ((getChildCount() == 0) || (paramInt == 0)) {
      return 0;
    }
    this.ua.uu = true;
    db();
    if (paramInt > 0) {}
    int j;
    int k;
    for (int i = 1;; i = -1)
    {
      j = Math.abs(paramInt);
      a(i, j, true, paramak);
      k = this.ua.uv + a(paramaf, this.ua, paramak, false);
      if (k >= 0) {
        break;
      }
      return 0;
    }
    if (j > k) {
      paramInt = i * k;
    }
    this.ub.av(-paramInt);
    this.ua.uy = paramInt;
    return paramInt;
  }
  
  private void cZ()
  {
    boolean bool = true;
    if ((this.tZ == 1) || (!da())) {
      bool = this.ud;
    }
    for (;;)
    {
      this.ue = bool;
      return;
      if (this.ud) {
        bool = false;
      }
    }
  }
  
  private View d(af paramaf, ak paramak)
  {
    if (this.ue) {
      return f(paramaf, paramak);
    }
    return g(paramaf, paramak);
  }
  
  private View dc()
  {
    if (this.ue) {}
    for (int i = getChildCount() - 1;; i = 0) {
      return getChildAt(i);
    }
  }
  
  private View dd()
  {
    if (this.ue) {}
    for (int i = 0;; i = getChildCount() - 1) {
      return getChildAt(i);
    }
  }
  
  private View e(af paramaf, ak paramak)
  {
    if (this.ue) {
      return g(paramaf, paramak);
    }
    return f(paramaf, paramak);
  }
  
  private View f(af paramaf, ak paramak)
  {
    return a(paramaf, paramak, 0, getChildCount(), paramak.getItemCount());
  }
  
  private View g(af paramaf, ak paramak)
  {
    return a(paramaf, paramak, getChildCount() - 1, -1, paramak.getItemCount());
  }
  
  private int i(ak paramak)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    db();
    s locals = this.ub;
    View localView;
    if (!this.ug)
    {
      bool1 = true;
      localView = p(bool1);
      if (this.ug) {
        break label74;
      }
    }
    label74:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ap.a(paramak, locals, localView, q(bool1), this, this.ug, this.ue);
      bool1 = false;
      break;
    }
  }
  
  private int j(ak paramak)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    db();
    s locals = this.ub;
    View localView;
    if (!this.ug)
    {
      bool1 = true;
      localView = p(bool1);
      if (this.ug) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ap.a(paramak, locals, localView, q(bool1), this, this.ug);
      bool1 = false;
      break;
    }
  }
  
  private int k(ak paramak)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    db();
    s locals = this.ub;
    View localView;
    if (!this.ug)
    {
      bool1 = true;
      localView = p(bool1);
      if (this.ug) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ap.b(paramak, locals, localView, q(bool1), this, this.ug);
      bool1 = false;
      break;
    }
  }
  
  private View p(boolean paramBoolean)
  {
    if (this.ue) {
      return a(getChildCount() - 1, -1, paramBoolean, true);
    }
    return a(0, getChildCount(), paramBoolean, true);
  }
  
  private View q(boolean paramBoolean)
  {
    if (this.ue) {
      return a(0, getChildCount(), paramBoolean, true);
    }
    return a(getChildCount() - 1, -1, paramBoolean, true);
  }
  
  private void y(int paramInt1, int paramInt2)
  {
    this.ua.tT = (this.ub.dk() - paramInt2);
    o localo = this.ua;
    if (this.ue) {}
    for (int i = -1;; i = 1)
    {
      localo.tV = i;
      this.ua.tU = paramInt1;
      this.ua.tW = 1;
      this.ua.lm = paramInt2;
      this.ua.uv = -2147483648;
      return;
    }
  }
  
  private void z(int paramInt1, int paramInt2)
  {
    this.ua.tT = (paramInt2 - this.ub.dj());
    this.ua.tU = paramInt1;
    o localo = this.ua;
    if (this.ue) {}
    for (paramInt1 = 1;; paramInt1 = -1)
    {
      localo.tV = paramInt1;
      this.ua.tW = -1;
      this.ua.lm = paramInt2;
      this.ua.uv = -2147483648;
      return;
    }
  }
  
  public final int a(int paramInt, af paramaf, ak paramak)
  {
    if (this.tZ == 1) {
      return 0;
    }
    return c(paramInt, paramaf, paramak);
  }
  
  View a(af paramaf, ak paramak, int paramInt1, int paramInt2, int paramInt3)
  {
    db();
    int j = this.ub.dj();
    int k = this.ub.dk();
    int i;
    ak localak;
    if (paramInt2 > paramInt1)
    {
      i = 1;
      paramaf = null;
      localak = null;
      label36:
      if (paramInt1 == paramInt2) {
        break label142;
      }
      paramak = getChildAt(paramInt1);
      int m = av(paramak);
      if ((m < 0) || (m >= paramInt3)) {
        break label155;
      }
      if (!((RecyclerView.LayoutParams)paramak.getLayoutParams()).wd.isRemoved()) {
        break label104;
      }
      if (localak != null) {
        break label155;
      }
      localak = paramak;
    }
    label142:
    label152:
    label155:
    for (;;)
    {
      paramInt1 += i;
      break label36;
      i = -1;
      break;
      label104:
      Object localObject;
      if (this.ub.al(paramak) < k)
      {
        localObject = paramak;
        if (this.ub.am(paramak) >= j) {}
      }
      else
      {
        if (paramaf != null) {
          break label155;
        }
        paramaf = paramak;
        continue;
        if (paramaf == null) {
          break label152;
        }
        localObject = paramaf;
      }
      return localObject;
      return localak;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = new p(paramRecyclerView.getContext())
    {
      public final PointF at(int paramAnonymousInt)
      {
        int i = 1;
        int j = 0;
        LinearLayoutManager localLinearLayoutManager = LinearLayoutManager.this;
        if (localLinearLayoutManager.getChildCount() == 0) {
          return null;
        }
        if (paramAnonymousInt < LinearLayoutManager.av(localLinearLayoutManager.getChildAt(0))) {
          j = 1;
        }
        paramAnonymousInt = i;
        if (j != localLinearLayoutManager.ue) {
          paramAnonymousInt = -1;
        }
        if (localLinearLayoutManager.tZ == 0) {
          return new PointF(paramAnonymousInt, 0.0F);
        }
        return new PointF(0.0F, paramAnonymousInt);
      }
    };
    paramRecyclerView.aI(paramInt);
    a(paramRecyclerView);
  }
  
  public final void a(RecyclerView paramRecyclerView, af paramaf)
  {
    super.a(paramRecyclerView, paramaf);
    if (this.uj)
    {
      d(paramaf);
      paramaf.clear();
    }
  }
  
  void a(af paramaf, ak paramak, m paramm) {}
  
  void a(af paramaf, ak paramak, o paramo, n paramn)
  {
    paramaf = paramo.a(paramaf);
    if (paramaf == null)
    {
      paramn.ur = true;
      return;
    }
    paramak = (RecyclerView.LayoutParams)paramaf.getLayoutParams();
    boolean bool2;
    boolean bool1;
    label61:
    int i;
    int j;
    int k;
    int m;
    label254:
    int n;
    if (paramo.uz == null)
    {
      bool2 = this.ue;
      if (paramo.tW == -1)
      {
        bool1 = true;
        if (bool2 != bool1) {
          break label362;
        }
        addView(paramaf);
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramaf.getLayoutParams();
        Rect localRect = this.wa.as(paramaf);
        i = localRect.left;
        j = localRect.right;
        k = localRect.top;
        m = localRect.bottom;
        paramaf.measure(ab.a(getWidth(), i + j + 0 + (getPaddingLeft() + getPaddingRight() + localLayoutParams.leftMargin + localLayoutParams.rightMargin), localLayoutParams.width, cX()), ab.a(getHeight(), m + k + 0 + (getPaddingTop() + getPaddingBottom() + localLayoutParams.topMargin + localLayoutParams.bottomMargin), localLayoutParams.height, cY()));
        paramn.uq = this.ub.an(paramaf);
        if (this.tZ != 1) {
          break label469;
        }
        if (!da()) {
          break label418;
        }
        j = getWidth() - getPaddingRight();
        i = j - this.ub.ao(paramaf);
        if (paramo.tW != -1) {
          break label440;
        }
        n = paramo.lm;
        m = paramo.lm - paramn.uq;
        k = i;
        i = n;
      }
    }
    for (;;)
    {
      c(paramaf, paramak.leftMargin + k, paramak.topMargin + m, j - paramak.rightMargin, i - paramak.bottomMargin);
      if ((paramak.wd.isRemoved()) || (paramak.wd.eD())) {
        paramn.us = true;
      }
      paramn.ut = paramaf.isFocusable();
      return;
      bool1 = false;
      break;
      label362:
      addView(paramaf, 0);
      break label61;
      bool2 = this.ue;
      if (paramo.tW == -1) {}
      for (bool1 = true;; bool1 = false)
      {
        if (bool2 != bool1) {
          break label409;
        }
        au(paramaf);
        break;
      }
      label409:
      n(paramaf, 0);
      break label61;
      label418:
      i = getPaddingLeft();
      j = this.ub.ao(paramaf) + i;
      break label254;
      label440:
      m = paramo.lm;
      n = paramo.lm + paramn.uq;
      k = i;
      i = n;
      continue;
      label469:
      m = getPaddingTop();
      i = this.ub.ao(paramaf) + m;
      if (paramo.tW == -1)
      {
        j = paramo.lm;
        k = paramo.lm - paramn.uq;
      }
      else
      {
        k = paramo.lm;
        j = paramo.lm;
        n = paramn.uq;
        j += n;
      }
    }
  }
  
  public final View ar(int paramInt)
  {
    int i = getChildCount();
    Object localObject;
    if (i == 0) {
      localObject = null;
    }
    View localView;
    do
    {
      return localObject;
      int j = paramInt - av(getChildAt(0));
      if ((j < 0) || (j >= i)) {
        break;
      }
      localView = getChildAt(j);
      localObject = localView;
    } while (av(localView) == paramInt);
    return super.ar(paramInt);
  }
  
  public final void as(int paramInt)
  {
    this.uh = paramInt;
    this.ui = -2147483648;
    if (this.uk != null) {
      this.uk.uA = -1;
    }
    requestLayout();
  }
  
  public final int b(int paramInt, af paramaf, ak paramak)
  {
    if (this.tZ == 0) {
      return 0;
    }
    return c(paramInt, paramaf, paramak);
  }
  
  public final int c(ak paramak)
  {
    return i(paramak);
  }
  
  public void c(af paramaf, ak paramak)
  {
    if (((this.uk != null) || (this.uh != -1)) && (paramak.getItemCount() == 0))
    {
      d(paramaf);
      return;
    }
    if ((this.uk != null) && (this.uk.dg())) {
      this.uh = this.uk.uA;
    }
    db();
    this.ua.uu = false;
    cZ();
    Object localObject1 = this.ul;
    ((m)localObject1).un = -1;
    ((m)localObject1).uo = -2147483648;
    ((m)localObject1).up = false;
    this.ul.up = (this.ue ^ this.uf);
    Object localObject2 = this.ul;
    label157:
    label211:
    int j;
    label240:
    label242:
    int k;
    label265:
    label290:
    int m;
    if ((paramak.em()) || (this.uh == -1))
    {
      i = 0;
      if (i == 0)
      {
        if (getChildCount() == 0) {
          break label1726;
        }
        if (this.wa != null) {
          break label1228;
        }
        localObject1 = null;
        if (localObject1 == null) {
          break label1575;
        }
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)((View)localObject1).getLayoutParams();
        if ((localLayoutParams.wd.isRemoved()) || (localLayoutParams.wd.ev() < 0) || (localLayoutParams.wd.ev() >= paramak.getItemCount())) {
          break label1263;
        }
        i = 1;
        if (i == 0) {
          break label1575;
        }
        j = ((m)localObject2).um.ub.di();
        if (j < 0) {
          break label1268;
        }
        ((m)localObject2).ai((View)localObject1);
        i = 1;
        if (i == 0)
        {
          ((m)localObject2).de();
          if (!this.uf) {
            break label1731;
          }
          i = paramak.getItemCount() - 1;
          ((m)localObject2).un = i;
        }
      }
      i = b(paramak);
      if (this.ua.uy < 0) {
        break label1736;
      }
      j = 0;
      k = this.ub.dj() + j;
      m = i + this.ub.getEndPadding();
      i = m;
      j = k;
      if (paramak.em())
      {
        i = m;
        j = k;
        if (this.uh != -1)
        {
          i = m;
          j = k;
          if (this.ui != -2147483648)
          {
            localObject1 = ar(this.uh);
            i = m;
            j = k;
            if (localObject1 != null)
            {
              if (!this.ue) {
                break label1748;
              }
              i = this.ub.dk() - this.ub.am((View)localObject1) - this.ui;
              label410:
              if (i <= 0) {
                break label1780;
              }
              j = k + i;
              i = m;
            }
          }
        }
      }
      label423:
      a(paramaf, paramak, this.ul);
      b(paramaf);
      this.ua.ux = paramak.em();
      if (!this.ul.up) {
        break label1792;
      }
      b(this.ul);
      this.ua.uw = j;
      a(paramaf, this.ua, paramak, false);
      k = this.ua.lm;
      m = this.ua.tU;
      j = i;
      if (this.ua.tT > 0) {
        j = i + this.ua.tT;
      }
      a(this.ul);
      this.ua.uw = j;
      localObject1 = this.ua;
      ((o)localObject1).tU += this.ua.tV;
      a(paramaf, this.ua, paramak, false);
      j = this.ua.lm;
      if (this.ua.tT <= 0) {
        break label2368;
      }
      i = this.ua.tT;
      z(m, k);
      this.ua.uw = i;
      a(paramaf, this.ua, paramak, false);
    }
    label656:
    label1575:
    label1710:
    label1715:
    label1726:
    label2368:
    for (int i = this.ua.lm;; i = k)
    {
      k = j;
      j = i;
      i = k;
      for (;;)
      {
        k = i;
        m = j;
        if (getChildCount() > 0)
        {
          if (!(this.ue ^ this.uf)) {
            break label1988;
          }
          k = a(i, paramaf, paramak, true);
          m = j + k;
          j = b(m, paramaf, paramak, false);
          m += j;
        }
        boolean bool;
        label1133:
        label1263:
        label1268:
        int i1;
        for (k = j + (k + i);; k = n + i)
        {
          if ((paramak.en()) && (getChildCount() != 0) && (!paramak.em()) && (cT())) {
            break label2033;
          }
          if (!paramak.em())
          {
            this.uh = -1;
            this.ui = -2147483648;
            this.ub.dh();
          }
          this.uc = this.uf;
          this.uk = null;
          return;
          if ((this.uh < 0) || (this.uh >= paramak.getItemCount()))
          {
            this.uh = -1;
            this.ui = -2147483648;
            i = 0;
            break;
          }
          ((m)localObject2).un = this.uh;
          if ((this.uk != null) && (this.uk.dg()))
          {
            ((m)localObject2).up = this.uk.uC;
            if (((m)localObject2).up) {}
            for (((m)localObject2).uo = (this.ub.dk() - this.uk.uB);; ((m)localObject2).uo = (this.ub.dj() + this.uk.uB))
            {
              i = 1;
              break;
            }
          }
          if (this.ui == -2147483648)
          {
            localObject1 = ar(this.uh);
            if (localObject1 != null) {
              if (this.ub.an((View)localObject1) > this.ub.dl()) {
                ((m)localObject2).de();
              }
            }
          }
          for (;;)
          {
            i = 1;
            break;
            if (this.ub.al((View)localObject1) - this.ub.dj() < 0)
            {
              ((m)localObject2).uo = this.ub.dj();
              ((m)localObject2).up = false;
            }
            else if (this.ub.dk() - this.ub.am((View)localObject1) < 0)
            {
              ((m)localObject2).uo = this.ub.dk();
              ((m)localObject2).up = true;
            }
            else
            {
              if (((m)localObject2).up) {}
              for (i = this.ub.am((View)localObject1) + this.ub.di();; i = this.ub.al((View)localObject1))
              {
                ((m)localObject2).uo = i;
                i = 1;
                break;
              }
              if (getChildCount() > 0)
              {
                i = av(getChildAt(0));
                if (this.uh >= i) {
                  break label1160;
                }
                bool = true;
                if (bool != this.ue) {
                  break label1166;
                }
              }
              for (bool = true;; bool = false)
              {
                ((m)localObject2).up = bool;
                ((m)localObject2).de();
                break;
                bool = false;
                break label1133;
              }
              ((m)localObject2).up = this.ue;
              if (this.ue) {
                ((m)localObject2).uo = (this.ub.dk() - this.ui);
              } else {
                ((m)localObject2).uo = (this.ub.dj() + this.ui);
              }
            }
          }
          label1228:
          localObject1 = this.wa.getFocusedChild();
          if ((localObject1 == null) || (this.uR.ac((View)localObject1)))
          {
            localObject1 = null;
            break label157;
          }
          break label157;
          i = 0;
          break label211;
          ((m)localObject2).un = av((View)localObject1);
          if (((m)localObject2).up)
          {
            i = ((m)localObject2).um.ub.dk() - j - ((m)localObject2).um.ub.am((View)localObject1);
            ((m)localObject2).uo = (((m)localObject2).um.ub.dk() - i);
            if (i <= 0) {
              break label240;
            }
            j = ((m)localObject2).um.ub.an((View)localObject1);
            k = ((m)localObject2).uo;
            m = ((m)localObject2).um.ub.dj();
            j = k - j - (Math.min(((m)localObject2).um.ub.al((View)localObject1) - m, 0) + m);
            if (j >= 0) {
              break label240;
            }
            k = ((m)localObject2).uo;
            ((m)localObject2).uo = (Math.min(i, -j) + k);
            break label240;
          }
          k = ((m)localObject2).um.ub.al((View)localObject1);
          i = k - ((m)localObject2).um.ub.dj();
          ((m)localObject2).uo = k;
          if (i <= 0) {
            break label240;
          }
          m = ((m)localObject2).um.ub.an((View)localObject1);
          n = ((m)localObject2).um.ub.dk();
          i1 = ((m)localObject2).um.ub.am((View)localObject1);
          j = ((m)localObject2).um.ub.dk() - Math.min(0, n - j - i1) - (k + m);
          if (j >= 0) {
            break label240;
          }
          ((m)localObject2).uo -= Math.min(i, -j);
          break label240;
          if (this.uc == this.uf)
          {
            if (((m)localObject2).up)
            {
              localObject1 = d(paramaf, paramak);
              label1602:
              if (localObject1 == null) {
                break label1726;
              }
              ((m)localObject2).ai((View)localObject1);
              if ((!paramak.em()) && (cT()))
              {
                if ((this.ub.al((View)localObject1) < this.ub.dk()) && (this.ub.am((View)localObject1) >= this.ub.dj())) {
                  break label1710;
                }
                i = 1;
                if (i != 0) {
                  if (!((m)localObject2).up) {
                    break label1715;
                  }
                }
              }
            }
            for (i = this.ub.dk();; i = this.ub.dj())
            {
              ((m)localObject2).uo = i;
              i = 1;
              break;
              localObject1 = e(paramaf, paramak);
              break label1602;
              i = 0;
              break label1668;
            }
          }
          i = 0;
          break label242;
          label1731:
          i = 0;
          break label265;
          label1736:
          k = 0;
          j = i;
          i = k;
          break label290;
          label1748:
          i = this.ub.al((View)localObject1);
          j = this.ub.dj();
          i = this.ui - (i - j);
          break label410;
          label1780:
          i = m - i;
          j = k;
          break label423;
          a(this.ul);
          this.ua.uw = i;
          a(paramaf, this.ua, paramak, false);
          k = this.ua.lm;
          m = this.ua.tU;
          i = j;
          if (this.ua.tT > 0) {
            i = j + this.ua.tT;
          }
          b(this.ul);
          this.ua.uw = i;
          localObject1 = this.ua;
          ((o)localObject1).tU += this.ua.tV;
          a(paramaf, this.ua, paramak, false);
          i = this.ua.lm;
          if (this.ua.tT <= 0) {
            break label2351;
          }
          j = this.ua.tT;
          y(m, k);
          this.ua.uw = j;
          a(paramaf, this.ua, paramak, false);
          k = this.ua.lm;
          j = i;
          i = k;
          break label656;
          label1988:
          k = b(j, paramaf, paramak, true);
          i = k + i;
          n = a(i, paramaf, paramak, false);
          m = j + k + n;
        }
        label2033:
        i = 0;
        j = 0;
        localObject1 = paramaf.eg();
        int i2 = ((List)localObject1).size();
        int i3 = av(getChildAt(0));
        int n = 0;
        if (n < i2)
        {
          localObject2 = (an)((List)localObject1).get(n);
          if (((an)localObject2).isRemoved()) {
            break label2338;
          }
          if (((an)localObject2).ev() < i3)
          {
            bool = true;
            if (bool == this.ue) {
              break label2178;
            }
            i1 = -1;
            label2120:
            if (i1 != -1) {
              break label2184;
            }
            i1 = i + this.ub.an(((an)localObject2).wT);
            i = j;
            j = i1;
          }
        }
        for (;;)
        {
          i1 = n + 1;
          n = j;
          j = i;
          i = n;
          n = i1;
          break label2066;
          bool = false;
          break label2108;
          i1 = 1;
          break label2120;
          i1 = this.ub.an(((an)localObject2).wT) + j;
          j = i;
          i = i1;
          continue;
          this.ua.uz = ((List)localObject1);
          if (i > 0)
          {
            z(av(dc()), m);
            this.ua.uw = i;
            this.ua.tT = 0;
            this.ua.aj(null);
            a(paramaf, this.ua, paramak, false);
          }
          if (j > 0)
          {
            y(av(dd()), k);
            this.ua.uw = j;
            this.ua.tT = 0;
            this.ua.aj(null);
            a(paramaf, this.ua, paramak, false);
          }
          this.ua.uz = null;
          break;
          i1 = i;
          i = j;
          j = i1;
        }
        j = k;
        k = i;
        i = j;
        j = k;
      }
    }
  }
  
  public RecyclerView.LayoutParams cS()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  public boolean cT()
  {
    return (this.uk == null) && (this.uc == this.uf);
  }
  
  public final boolean cX()
  {
    return this.tZ == 0;
  }
  
  public final boolean cY()
  {
    return this.tZ == 1;
  }
  
  public final int d(ak paramak)
  {
    return i(paramak);
  }
  
  public final View d(int paramInt, af paramaf, ak paramak)
  {
    cZ();
    if (getChildCount() == 0) {}
    label75:
    View localView;
    label98:
    do
    {
      do
      {
        return null;
        switch (paramInt)
        {
        default: 
          paramInt = -2147483648;
        }
      } while (paramInt == -2147483648);
      db();
      if (paramInt != -1) {
        break;
      }
      localView = e(paramaf, paramak);
    } while (localView == null);
    db();
    a(paramInt, (int)(0.33F * this.ub.dl()), false, paramak);
    this.ua.uv = -2147483648;
    this.ua.uu = false;
    a(paramaf, this.ua, paramak, true);
    if (paramInt == -1) {}
    for (paramaf = dc(); (paramaf != localView) && (paramaf.isFocusable()); paramaf = dd())
    {
      return paramaf;
      paramInt = -1;
      break label75;
      paramInt = 1;
      break label75;
      if (this.tZ == 1)
      {
        paramInt = -1;
        break label75;
      }
      paramInt = -2147483648;
      break label75;
      if (this.tZ == 1)
      {
        paramInt = 1;
        break label75;
      }
      paramInt = -2147483648;
      break label75;
      if (this.tZ == 0)
      {
        paramInt = -1;
        break label75;
      }
      paramInt = -2147483648;
      break label75;
      if (this.tZ == 0)
      {
        paramInt = 1;
        break label75;
      }
      paramInt = -2147483648;
      break label75;
      localView = d(paramaf, paramak);
      break label98;
    }
  }
  
  protected final boolean da()
  {
    return r.j(this.wa) == 1;
  }
  
  final void db()
  {
    if (this.ua == null) {
      this.ua = new o();
    }
    if (this.ub == null) {
      this.ub = s.a(this, this.tZ);
    }
  }
  
  public final int e(ak paramak)
  {
    return j(paramak);
  }
  
  public final int f(ak paramak)
  {
    return j(paramak);
  }
  
  public final void f(String paramString)
  {
    if (this.uk == null) {
      super.f(paramString);
    }
  }
  
  public final int g(ak paramak)
  {
    return k(paramak);
  }
  
  public final int h(ak paramak)
  {
    return k(paramak);
  }
  
  public final void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    int j = -1;
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    View localView;
    if (getChildCount() > 0)
    {
      paramAccessibilityEvent = a.a(paramAccessibilityEvent);
      localView = a(0, getChildCount(), false, true);
      if (localView != null) {
        break label72;
      }
      i = -1;
      paramAccessibilityEvent.setFromIndex(i);
      localView = a(getChildCount() - 1, -1, false, true);
      if (localView != null) {
        break label81;
      }
    }
    label72:
    label81:
    for (int i = j;; i = av(localView))
    {
      paramAccessibilityEvent.setToIndex(i);
      return;
      i = av(localView);
      break;
    }
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof LinearLayoutManager.SavedState))
    {
      this.uk = ((LinearLayoutManager.SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    if (this.uk != null) {
      return new LinearLayoutManager.SavedState(this.uk);
    }
    LinearLayoutManager.SavedState localSavedState = new LinearLayoutManager.SavedState();
    if (getChildCount() > 0)
    {
      db();
      boolean bool = this.uc ^ this.ue;
      localSavedState.uC = bool;
      if (bool)
      {
        localView = dd();
        localSavedState.uB = (this.ub.dk() - this.ub.am(localView));
        localSavedState.uA = av(localView);
        return localSavedState;
      }
      View localView = dc();
      localSavedState.uA = av(localView);
      localSavedState.uB = (this.ub.al(localView) - this.ub.dj());
      return localSavedState;
    }
    localSavedState.uA = -1;
    return localSavedState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.LinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */