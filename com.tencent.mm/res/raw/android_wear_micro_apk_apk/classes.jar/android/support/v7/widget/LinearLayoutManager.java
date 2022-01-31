package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.view.a.a;
import android.support.v4.view.a.aa;
import android.support.v4.view.r;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager
  extends ab
{
  int sj;
  private o sk;
  s sl;
  private boolean sm;
  private boolean sn;
  boolean so;
  private boolean sp;
  private boolean sq;
  int sr;
  int ss;
  private boolean st;
  LinearLayoutManager.SavedState su;
  final m sv;
  
  private int a(int paramInt, af paramaf, ak paramak, boolean paramBoolean)
  {
    int i = this.sl.db() - paramInt;
    if (i > 0)
    {
      int j = -c(-i, paramaf, paramak);
      i = j;
      if (paramBoolean)
      {
        paramInt = this.sl.db() - (paramInt + j);
        i = j;
        if (paramInt > 0)
        {
          this.sl.aj(paramInt);
          i = j + paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private int a(af paramaf, o paramo, ak paramak, boolean paramBoolean)
  {
    int k = paramo.sd;
    if (paramo.sF != -2147483648)
    {
      if (paramo.sd < 0) {
        paramo.sF += paramo.sd;
      }
      a(paramaf, paramo);
    }
    int i = paramo.sd + paramo.sG;
    n localn = new n();
    do
    {
      int j;
      do
      {
        if ((i <= 0) || (!paramo.k(paramak))) {
          break;
        }
        localn.sA = 0;
        localn.sB = false;
        localn.sC = false;
        localn.sD = false;
        a(paramaf, paramak, paramo, localn);
        if (localn.sB) {
          break;
        }
        paramo.jp += localn.sA * paramo.sg;
        if ((localn.sC) && (this.sk.sJ == null))
        {
          j = i;
          if (paramak.dY()) {}
        }
        else
        {
          paramo.sd -= localn.sA;
          j = i - localn.sA;
        }
        if (paramo.sF != -2147483648)
        {
          paramo.sF += localn.sA;
          if (paramo.sd < 0) {
            paramo.sF += paramo.sd;
          }
          a(paramaf, paramo);
        }
        i = j;
      } while (!paramBoolean);
      i = j;
    } while (!localn.sD);
    return k - paramo.sd;
  }
  
  private int a(ak paramak)
  {
    if (paramak.eb()) {
      return this.sl.dc();
    }
    return 0;
  }
  
  private View a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    cT();
    int j = this.sl.da();
    int k = this.sl.db();
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
      int m = this.sl.ae(localView);
      int n = this.sl.af(localView);
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
    this.sk.sG = a(paramak);
    this.sk.sg = paramInt1;
    if (paramInt1 == 1)
    {
      paramak = this.sk;
      paramak.sG += this.sl.getEndPadding();
      paramak = cV();
      localo = this.sk;
      if (this.so) {}
      for (paramInt1 = i;; paramInt1 = 1)
      {
        localo.sf = paramInt1;
        this.sk.se = (ao(paramak) + this.sk.sf);
        this.sk.jp = this.sl.af(paramak);
        paramInt1 = this.sl.af(paramak) - this.sl.db();
        this.sk.sd = paramInt2;
        if (paramBoolean)
        {
          paramak = this.sk;
          paramak.sd -= paramInt1;
        }
        this.sk.sF = paramInt1;
        return;
      }
    }
    paramak = cU();
    o localo = this.sk;
    localo.sG += this.sl.da();
    localo = this.sk;
    if (this.so) {}
    for (paramInt1 = j;; paramInt1 = -1)
    {
      localo.sf = paramInt1;
      this.sk.se = (ao(paramak) + this.sk.sf);
      this.sk.jp = this.sl.ae(paramak);
      paramInt1 = -this.sl.ae(paramak) + this.sl.da();
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
    if (!paramo.sE) {}
    for (;;)
    {
      return;
      int i;
      int j;
      int k;
      if (paramo.sg == -1)
      {
        i = paramo.sF;
        j = getChildCount();
        if (i >= 0)
        {
          k = this.sl.getEnd() - i;
          if (this.so)
          {
            i = 0;
            while (i < j)
            {
              paramo = getChildAt(i);
              if (this.sl.ae(paramo) < k)
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
              if (this.sl.ae(paramo) < k)
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
        j = paramo.sF;
        if (j >= 0)
        {
          k = getChildCount();
          if (this.so)
          {
            i = k - 1;
            while (i >= 0)
            {
              paramo = getChildAt(i);
              if (this.sl.af(paramo) > j)
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
              if (this.sl.af(paramo) > j)
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
    x(paramm.sx, paramm.sy);
  }
  
  private int b(int paramInt, af paramaf, ak paramak, boolean paramBoolean)
  {
    int i = paramInt - this.sl.da();
    if (i > 0)
    {
      int j = -c(i, paramaf, paramak);
      i = j;
      if (paramBoolean)
      {
        paramInt = paramInt + j - this.sl.da();
        i = j;
        if (paramInt > 0)
        {
          this.sl.aj(-paramInt);
          i = j - paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private void b(m paramm)
  {
    y(paramm.sx, paramm.sy);
  }
  
  private int c(int paramInt, af paramaf, ak paramak)
  {
    if ((getChildCount() == 0) || (paramInt == 0)) {
      return 0;
    }
    this.sk.sE = true;
    cT();
    if (paramInt > 0) {}
    int j;
    int k;
    for (int i = 1;; i = -1)
    {
      j = Math.abs(paramInt);
      a(i, j, true, paramak);
      k = this.sk.sF + a(paramaf, this.sk, paramak, false);
      if (k >= 0) {
        break;
      }
      return 0;
    }
    if (j > k) {
      paramInt = i * k;
    }
    this.sl.aj(-paramInt);
    this.sk.sI = paramInt;
    return paramInt;
  }
  
  private void cR()
  {
    boolean bool = true;
    if ((this.sj == 1) || (!cS())) {
      bool = this.sn;
    }
    for (;;)
    {
      this.so = bool;
      return;
      if (this.sn) {
        bool = false;
      }
    }
  }
  
  private View cU()
  {
    if (this.so) {}
    for (int i = getChildCount() - 1;; i = 0) {
      return getChildAt(i);
    }
  }
  
  private View cV()
  {
    if (this.so) {}
    for (int i = 0;; i = getChildCount() - 1) {
      return getChildAt(i);
    }
  }
  
  private View d(af paramaf, ak paramak)
  {
    if (this.so) {
      return f(paramaf, paramak);
    }
    return g(paramaf, paramak);
  }
  
  private View e(af paramaf, ak paramak)
  {
    if (this.so) {
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
  
  private int h(ak paramak)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    cT();
    s locals = this.sl;
    View localView;
    if (!this.sq)
    {
      bool1 = true;
      localView = m(bool1);
      if (this.sq) {
        break label74;
      }
    }
    label74:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ap.a(paramak, locals, localView, n(bool1), this, this.sq, this.so);
      bool1 = false;
      break;
    }
  }
  
  private int i(ak paramak)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    cT();
    s locals = this.sl;
    View localView;
    if (!this.sq)
    {
      bool1 = true;
      localView = m(bool1);
      if (this.sq) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ap.a(paramak, locals, localView, n(bool1), this, this.sq);
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
    cT();
    s locals = this.sl;
    View localView;
    if (!this.sq)
    {
      bool1 = true;
      localView = m(bool1);
      if (this.sq) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ap.b(paramak, locals, localView, n(bool1), this, this.sq);
      bool1 = false;
      break;
    }
  }
  
  private View m(boolean paramBoolean)
  {
    if (this.so) {
      return a(getChildCount() - 1, -1, paramBoolean, true);
    }
    return a(0, getChildCount(), paramBoolean, true);
  }
  
  private View n(boolean paramBoolean)
  {
    if (this.so) {
      return a(0, getChildCount(), paramBoolean, true);
    }
    return a(getChildCount() - 1, -1, paramBoolean, true);
  }
  
  private void x(int paramInt1, int paramInt2)
  {
    this.sk.sd = (this.sl.db() - paramInt2);
    o localo = this.sk;
    if (this.so) {}
    for (int i = -1;; i = 1)
    {
      localo.sf = i;
      this.sk.se = paramInt1;
      this.sk.sg = 1;
      this.sk.jp = paramInt2;
      this.sk.sF = -2147483648;
      return;
    }
  }
  
  private void y(int paramInt1, int paramInt2)
  {
    this.sk.sd = (paramInt2 - this.sl.da());
    this.sk.se = paramInt1;
    o localo = this.sk;
    if (this.so) {}
    for (paramInt1 = 1;; paramInt1 = -1)
    {
      localo.sf = paramInt1;
      this.sk.sg = -1;
      this.sk.jp = paramInt2;
      this.sk.sF = -2147483648;
      return;
    }
  }
  
  public final int a(int paramInt, af paramaf, ak paramak)
  {
    if (this.sj == 1) {
      return 0;
    }
    return c(paramInt, paramaf, paramak);
  }
  
  View a(af paramaf, ak paramak, int paramInt1, int paramInt2, int paramInt3)
  {
    cT();
    int j = this.sl.da();
    int k = this.sl.db();
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
      int m = ao(paramak);
      if ((m < 0) || (m >= paramInt3)) {
        break label155;
      }
      if (!((RecyclerView.LayoutParams)paramak.getLayoutParams()).uo.isRemoved()) {
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
      if (this.sl.ae(paramak) < k)
      {
        localObject = paramak;
        if (this.sl.af(paramak) >= j) {}
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
      public final PointF ah(int paramAnonymousInt)
      {
        int i = 1;
        int j = 0;
        LinearLayoutManager localLinearLayoutManager = LinearLayoutManager.this;
        if (localLinearLayoutManager.getChildCount() == 0) {
          return null;
        }
        if (paramAnonymousInt < LinearLayoutManager.ao(localLinearLayoutManager.getChildAt(0))) {
          j = 1;
        }
        paramAnonymousInt = i;
        if (j != localLinearLayoutManager.so) {
          paramAnonymousInt = -1;
        }
        if (localLinearLayoutManager.sj == 0) {
          return new PointF(paramAnonymousInt, 0.0F);
        }
        return new PointF(0.0F, paramAnonymousInt);
      }
    };
    paramRecyclerView.aw(paramInt);
    a(paramRecyclerView);
  }
  
  public final void a(RecyclerView paramRecyclerView, af paramaf)
  {
    super.a(paramRecyclerView, paramaf);
    if (this.st)
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
      paramn.sB = true;
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
    if (paramo.sJ == null)
    {
      bool2 = this.so;
      if (paramo.sg == -1)
      {
        bool1 = true;
        if (bool2 != bool1) {
          break label362;
        }
        addView(paramaf);
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramaf.getLayoutParams();
        Rect localRect = this.uk.al(paramaf);
        i = localRect.left;
        j = localRect.right;
        k = localRect.top;
        m = localRect.bottom;
        paramaf.measure(ab.a(getWidth(), i + j + 0 + (getPaddingLeft() + getPaddingRight() + localLayoutParams.leftMargin + localLayoutParams.rightMargin), localLayoutParams.width, cP()), ab.a(getHeight(), m + k + 0 + (getPaddingTop() + getPaddingBottom() + localLayoutParams.topMargin + localLayoutParams.bottomMargin), localLayoutParams.height, cQ()));
        paramn.sA = this.sl.ag(paramaf);
        if (this.sj != 1) {
          break label469;
        }
        if (!cS()) {
          break label418;
        }
        j = getWidth() - getPaddingRight();
        i = j - this.sl.ah(paramaf);
        if (paramo.sg != -1) {
          break label440;
        }
        n = paramo.jp;
        m = paramo.jp - paramn.sA;
        k = i;
        i = n;
      }
    }
    for (;;)
    {
      b(paramaf, paramak.leftMargin + k, paramak.topMargin + m, j - paramak.rightMargin, i - paramak.bottomMargin);
      if ((paramak.uo.isRemoved()) || (paramak.uo.eo())) {
        paramn.sC = true;
      }
      paramn.sD = paramaf.isFocusable();
      return;
      bool1 = false;
      break;
      label362:
      addView(paramaf, 0);
      break label61;
      bool2 = this.so;
      if (paramo.sg == -1) {}
      for (bool1 = true;; bool1 = false)
      {
        if (bool2 != bool1) {
          break label409;
        }
        an(paramaf);
        break;
      }
      label409:
      k(paramaf, 0);
      break label61;
      label418:
      i = getPaddingLeft();
      j = this.sl.ah(paramaf) + i;
      break label254;
      label440:
      m = paramo.jp;
      n = paramo.jp + paramn.sA;
      k = i;
      i = n;
      continue;
      label469:
      m = getPaddingTop();
      i = this.sl.ah(paramaf) + m;
      if (paramo.sg == -1)
      {
        j = paramo.jp;
        k = paramo.jp - paramn.sA;
      }
      else
      {
        k = paramo.jp;
        j = paramo.jp;
        n = paramn.sA;
        j += n;
      }
    }
  }
  
  public final View af(int paramInt)
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
      int j = paramInt - ao(getChildAt(0));
      if ((j < 0) || (j >= i)) {
        break;
      }
      localView = getChildAt(j);
      localObject = localView;
    } while (ao(localView) == paramInt);
    return super.af(paramInt);
  }
  
  public final void ag(int paramInt)
  {
    this.sr = paramInt;
    this.ss = -2147483648;
    if (this.su != null) {
      this.su.sK = -1;
    }
    requestLayout();
  }
  
  public final int b(int paramInt, af paramaf, ak paramak)
  {
    if (this.sj == 0) {
      return 0;
    }
    return c(paramInt, paramaf, paramak);
  }
  
  public final int b(ak paramak)
  {
    return h(paramak);
  }
  
  public final int c(ak paramak)
  {
    return h(paramak);
  }
  
  public void c(af paramaf, ak paramak)
  {
    if (((this.su != null) || (this.sr != -1)) && (paramak.getItemCount() == 0))
    {
      d(paramaf);
      return;
    }
    if ((this.su != null) && (this.su.cX())) {
      this.sr = this.su.sK;
    }
    cT();
    this.sk.sE = false;
    cR();
    Object localObject1 = this.sv;
    ((m)localObject1).sx = -1;
    ((m)localObject1).sy = -2147483648;
    ((m)localObject1).sz = false;
    this.sv.sz = (this.so ^ this.sp);
    Object localObject2 = this.sv;
    label157:
    label211:
    int j;
    label240:
    label242:
    int k;
    label265:
    label290:
    int m;
    if ((paramak.dY()) || (this.sr == -1))
    {
      i = 0;
      if (i == 0)
      {
        if (getChildCount() == 0) {
          break label1726;
        }
        if (this.uk != null) {
          break label1228;
        }
        localObject1 = null;
        if (localObject1 == null) {
          break label1575;
        }
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)((View)localObject1).getLayoutParams();
        if ((localLayoutParams.uo.isRemoved()) || (localLayoutParams.uo.eg() < 0) || (localLayoutParams.uo.eg() >= paramak.getItemCount())) {
          break label1263;
        }
        i = 1;
        if (i == 0) {
          break label1575;
        }
        j = ((m)localObject2).sw.sl.cZ();
        if (j < 0) {
          break label1268;
        }
        ((m)localObject2).ac((View)localObject1);
        i = 1;
        if (i == 0)
        {
          ((m)localObject2).cW();
          if (!this.sp) {
            break label1731;
          }
          i = paramak.getItemCount() - 1;
          ((m)localObject2).sx = i;
        }
      }
      i = a(paramak);
      if (this.sk.sI < 0) {
        break label1736;
      }
      j = 0;
      k = this.sl.da() + j;
      m = i + this.sl.getEndPadding();
      i = m;
      j = k;
      if (paramak.dY())
      {
        i = m;
        j = k;
        if (this.sr != -1)
        {
          i = m;
          j = k;
          if (this.ss != -2147483648)
          {
            localObject1 = af(this.sr);
            i = m;
            j = k;
            if (localObject1 != null)
            {
              if (!this.so) {
                break label1748;
              }
              i = this.sl.db() - this.sl.af((View)localObject1) - this.ss;
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
      a(paramaf, paramak, this.sv);
      b(paramaf);
      this.sk.sH = paramak.dY();
      if (!this.sv.sz) {
        break label1792;
      }
      b(this.sv);
      this.sk.sG = j;
      a(paramaf, this.sk, paramak, false);
      k = this.sk.jp;
      m = this.sk.se;
      j = i;
      if (this.sk.sd > 0) {
        j = i + this.sk.sd;
      }
      a(this.sv);
      this.sk.sG = j;
      localObject1 = this.sk;
      ((o)localObject1).se += this.sk.sf;
      a(paramaf, this.sk, paramak, false);
      j = this.sk.jp;
      if (this.sk.sd <= 0) {
        break label2368;
      }
      i = this.sk.sd;
      y(m, k);
      this.sk.sG = i;
      a(paramaf, this.sk, paramak, false);
    }
    label656:
    label1575:
    label1710:
    label1715:
    label1726:
    label2368:
    for (int i = this.sk.jp;; i = k)
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
          if (!(this.so ^ this.sp)) {
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
          if ((paramak.dZ()) && (getChildCount() != 0) && (!paramak.dY()) && (cL())) {
            break label2033;
          }
          if (!paramak.dY())
          {
            this.sr = -1;
            this.ss = -2147483648;
            this.sl.cY();
          }
          this.sm = this.sp;
          this.su = null;
          return;
          if ((this.sr < 0) || (this.sr >= paramak.getItemCount()))
          {
            this.sr = -1;
            this.ss = -2147483648;
            i = 0;
            break;
          }
          ((m)localObject2).sx = this.sr;
          if ((this.su != null) && (this.su.cX()))
          {
            ((m)localObject2).sz = this.su.sM;
            if (((m)localObject2).sz) {}
            for (((m)localObject2).sy = (this.sl.db() - this.su.sL);; ((m)localObject2).sy = (this.sl.da() + this.su.sL))
            {
              i = 1;
              break;
            }
          }
          if (this.ss == -2147483648)
          {
            localObject1 = af(this.sr);
            if (localObject1 != null) {
              if (this.sl.ag((View)localObject1) > this.sl.dc()) {
                ((m)localObject2).cW();
              }
            }
          }
          for (;;)
          {
            i = 1;
            break;
            if (this.sl.ae((View)localObject1) - this.sl.da() < 0)
            {
              ((m)localObject2).sy = this.sl.da();
              ((m)localObject2).sz = false;
            }
            else if (this.sl.db() - this.sl.af((View)localObject1) < 0)
            {
              ((m)localObject2).sy = this.sl.db();
              ((m)localObject2).sz = true;
            }
            else
            {
              if (((m)localObject2).sz) {}
              for (i = this.sl.af((View)localObject1) + this.sl.cZ();; i = this.sl.ae((View)localObject1))
              {
                ((m)localObject2).sy = i;
                i = 1;
                break;
              }
              if (getChildCount() > 0)
              {
                i = ao(getChildAt(0));
                if (this.sr >= i) {
                  break label1160;
                }
                bool = true;
                if (bool != this.so) {
                  break label1166;
                }
              }
              for (bool = true;; bool = false)
              {
                ((m)localObject2).sz = bool;
                ((m)localObject2).cW();
                break;
                bool = false;
                break label1133;
              }
              ((m)localObject2).sz = this.so;
              if (this.so) {
                ((m)localObject2).sy = (this.sl.db() - this.ss);
              } else {
                ((m)localObject2).sy = (this.sl.da() + this.ss);
              }
            }
          }
          label1228:
          localObject1 = this.uk.getFocusedChild();
          if ((localObject1 == null) || (this.tb.W((View)localObject1)))
          {
            localObject1 = null;
            break label157;
          }
          break label157;
          i = 0;
          break label211;
          ((m)localObject2).sx = ao((View)localObject1);
          if (((m)localObject2).sz)
          {
            i = ((m)localObject2).sw.sl.db() - j - ((m)localObject2).sw.sl.af((View)localObject1);
            ((m)localObject2).sy = (((m)localObject2).sw.sl.db() - i);
            if (i <= 0) {
              break label240;
            }
            j = ((m)localObject2).sw.sl.ag((View)localObject1);
            k = ((m)localObject2).sy;
            m = ((m)localObject2).sw.sl.da();
            j = k - j - (Math.min(((m)localObject2).sw.sl.ae((View)localObject1) - m, 0) + m);
            if (j >= 0) {
              break label240;
            }
            k = ((m)localObject2).sy;
            ((m)localObject2).sy = (Math.min(i, -j) + k);
            break label240;
          }
          k = ((m)localObject2).sw.sl.ae((View)localObject1);
          i = k - ((m)localObject2).sw.sl.da();
          ((m)localObject2).sy = k;
          if (i <= 0) {
            break label240;
          }
          m = ((m)localObject2).sw.sl.ag((View)localObject1);
          n = ((m)localObject2).sw.sl.db();
          i1 = ((m)localObject2).sw.sl.af((View)localObject1);
          j = ((m)localObject2).sw.sl.db() - Math.min(0, n - j - i1) - (k + m);
          if (j >= 0) {
            break label240;
          }
          ((m)localObject2).sy -= Math.min(i, -j);
          break label240;
          if (this.sm == this.sp)
          {
            if (((m)localObject2).sz)
            {
              localObject1 = d(paramaf, paramak);
              label1602:
              if (localObject1 == null) {
                break label1726;
              }
              ((m)localObject2).ac((View)localObject1);
              if ((!paramak.dY()) && (cL()))
              {
                if ((this.sl.ae((View)localObject1) < this.sl.db()) && (this.sl.af((View)localObject1) >= this.sl.da())) {
                  break label1710;
                }
                i = 1;
                if (i != 0) {
                  if (!((m)localObject2).sz) {
                    break label1715;
                  }
                }
              }
            }
            for (i = this.sl.db();; i = this.sl.da())
            {
              ((m)localObject2).sy = i;
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
          i = this.sl.ae((View)localObject1);
          j = this.sl.da();
          i = this.ss - (i - j);
          break label410;
          label1780:
          i = m - i;
          j = k;
          break label423;
          a(this.sv);
          this.sk.sG = i;
          a(paramaf, this.sk, paramak, false);
          k = this.sk.jp;
          m = this.sk.se;
          i = j;
          if (this.sk.sd > 0) {
            i = j + this.sk.sd;
          }
          b(this.sv);
          this.sk.sG = i;
          localObject1 = this.sk;
          ((o)localObject1).se += this.sk.sf;
          a(paramaf, this.sk, paramak, false);
          i = this.sk.jp;
          if (this.sk.sd <= 0) {
            break label2351;
          }
          j = this.sk.sd;
          x(m, k);
          this.sk.sG = j;
          a(paramaf, this.sk, paramak, false);
          k = this.sk.jp;
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
        localObject1 = paramaf.dS();
        int i2 = ((List)localObject1).size();
        int i3 = ao(getChildAt(0));
        int n = 0;
        if (n < i2)
        {
          localObject2 = (an)((List)localObject1).get(n);
          if (((an)localObject2).isRemoved()) {
            break label2338;
          }
          if (((an)localObject2).eg() < i3)
          {
            bool = true;
            if (bool == this.so) {
              break label2178;
            }
            i1 = -1;
            label2120:
            if (i1 != -1) {
              break label2184;
            }
            i1 = i + this.sl.ag(((an)localObject2).ve);
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
          i1 = this.sl.ag(((an)localObject2).ve) + j;
          j = i;
          i = i1;
          continue;
          this.sk.sJ = ((List)localObject1);
          if (i > 0)
          {
            y(ao(cU()), m);
            this.sk.sG = i;
            this.sk.sd = 0;
            this.sk.ad(null);
            a(paramaf, this.sk, paramak, false);
          }
          if (j > 0)
          {
            x(ao(cV()), k);
            this.sk.sG = j;
            this.sk.sd = 0;
            this.sk.ad(null);
            a(paramaf, this.sk, paramak, false);
          }
          this.sk.sJ = null;
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
  
  public RecyclerView.LayoutParams cK()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  public boolean cL()
  {
    return (this.su == null) && (this.sm == this.sp);
  }
  
  public final boolean cP()
  {
    return this.sj == 0;
  }
  
  public final boolean cQ()
  {
    return this.sj == 1;
  }
  
  protected final boolean cS()
  {
    return r.i(this.uk) == 1;
  }
  
  final void cT()
  {
    if (this.sk == null) {
      this.sk = new o();
    }
    if (this.sl == null) {
      this.sl = s.a(this, this.sj);
    }
  }
  
  public final int d(ak paramak)
  {
    return i(paramak);
  }
  
  public final View d(int paramInt, af paramaf, ak paramak)
  {
    cR();
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
      cT();
      if (paramInt != -1) {
        break;
      }
      localView = e(paramaf, paramak);
    } while (localView == null);
    cT();
    a(paramInt, (int)(0.33F * this.sl.dc()), false, paramak);
    this.sk.sF = -2147483648;
    this.sk.sE = false;
    a(paramaf, this.sk, paramak, true);
    if (paramInt == -1) {}
    for (paramaf = cU(); (paramaf != localView) && (paramaf.isFocusable()); paramaf = cV())
    {
      return paramaf;
      paramInt = -1;
      break label75;
      paramInt = 1;
      break label75;
      if (this.sj == 1)
      {
        paramInt = -1;
        break label75;
      }
      paramInt = -2147483648;
      break label75;
      if (this.sj == 1)
      {
        paramInt = 1;
        break label75;
      }
      paramInt = -2147483648;
      break label75;
      if (this.sj == 0)
      {
        paramInt = -1;
        break label75;
      }
      paramInt = -2147483648;
      break label75;
      if (this.sj == 0)
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
  
  public final int e(ak paramak)
  {
    return i(paramak);
  }
  
  public final int f(ak paramak)
  {
    return j(paramak);
  }
  
  public final void f(String paramString)
  {
    if (this.su == null) {
      super.f(paramString);
    }
  }
  
  public final int g(ak paramak)
  {
    return j(paramak);
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
    for (int i = j;; i = ao(localView))
    {
      paramAccessibilityEvent.setToIndex(i);
      return;
      i = ao(localView);
      break;
    }
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof LinearLayoutManager.SavedState))
    {
      this.su = ((LinearLayoutManager.SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    if (this.su != null) {
      return new LinearLayoutManager.SavedState(this.su);
    }
    LinearLayoutManager.SavedState localSavedState = new LinearLayoutManager.SavedState();
    if (getChildCount() > 0)
    {
      cT();
      boolean bool = this.sm ^ this.so;
      localSavedState.sM = bool;
      if (bool)
      {
        localView = cV();
        localSavedState.sL = (this.sl.db() - this.sl.af(localView));
        localSavedState.sK = ao(localView);
        return localSavedState;
      }
      View localView = cU();
      localSavedState.sK = ao(localView);
      localSavedState.sL = (this.sl.ae(localView) - this.sl.da());
      return localSavedState;
    }
    localSavedState.sK = -1;
    return localSavedState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.LinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */