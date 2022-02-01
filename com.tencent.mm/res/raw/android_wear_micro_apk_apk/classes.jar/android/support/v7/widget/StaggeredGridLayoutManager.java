package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.view.a.a;
import android.support.v4.view.a.b;
import android.support.v4.view.a.e;
import android.support.v4.view.a.i;
import android.support.v4.view.r;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.BitSet;

public final class StaggeredGridLayoutManager
  extends ab
{
  private final Rect qy;
  private int tI;
  private int tZ;
  private boolean ud;
  boolean ue;
  private boolean ug;
  int uh;
  int ui;
  private ar[] xj;
  s xk;
  s xl;
  private int xm;
  private l xn;
  private BitSet xo;
  StaggeredGridLayoutManager.LazySpanLookup xp;
  private int xq;
  private boolean xr;
  private boolean xs;
  private StaggeredGridLayoutManager.SavedState xt;
  private int xu;
  private int xv;
  private int xw;
  private final aq xx;
  private boolean xy;
  private final Runnable xz;
  
  private static int I(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      return paramInt2;
    }
    return View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
  }
  
  private void J(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.tI)
    {
      if (!ar.b(this.xj[i]).isEmpty()) {
        a(this.xj[i], paramInt1, paramInt2);
      }
      i += 1;
    }
  }
  
  private int a(af paramaf, l paraml, ak paramak)
  {
    this.xo.set(0, this.tI, true);
    int k;
    int m;
    label58:
    int i;
    label61:
    View localView;
    StaggeredGridLayoutManager.LayoutParams localLayoutParams;
    int i2;
    int n;
    label126:
    ar localar;
    label147:
    label158:
    label179:
    label211:
    int i1;
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem;
    int j;
    if (paraml.tW == 1)
    {
      k = paraml.tY + paraml.tT;
      J(paraml.tW, k);
      if (!this.ue) {
        break label454;
      }
      m = this.xk.dk();
      i = 0;
      if ((!paraml.a(paramak)) || (this.xo.isEmpty())) {
        break label690;
      }
      localView = paraml.a(paramaf);
      localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
      i2 = localLayoutParams.wd.ev();
      i = this.xp.aW(i2);
      if (i != -1) {
        break label466;
      }
      n = 1;
      if (n == 0) {
        break label482;
      }
      if (!localLayoutParams.xD) {
        break label472;
      }
      localar = this.xj[0];
      this.xp.a(i2, localar);
      localLayoutParams.xC = localar;
      if (paraml.tW != 1) {
        break label494;
      }
      addView(localView);
      a(localView, localLayoutParams);
      if (paraml.tW != 1) {
        break label516;
      }
      if (!localLayoutParams.xD) {
        break label504;
      }
      i = aQ(m);
      i1 = this.xk.an(localView) + i;
      if ((n == 0) || (!localLayoutParams.xD)) {
        break label781;
      }
      localFullSpanItem = aM(i);
      localFullSpanItem.xF = -1;
      localFullSpanItem.un = i2;
      this.xp.a(localFullSpanItem);
      j = i;
    }
    for (;;)
    {
      if ((localLayoutParams.xD) && (paraml.tV == -1))
      {
        if (n == 0)
        {
          if (paraml.tW != 1) {
            break label614;
          }
          if (eK()) {
            break label608;
          }
          i = 1;
          label311:
          if (i == 0) {
            break label343;
          }
          localFullSpanItem = this.xp.ba(i2);
          if (localFullSpanItem != null) {
            localFullSpanItem.xH = true;
          }
        }
        this.xy = true;
      }
      label343:
      a(localView, localLayoutParams, paraml);
      if (localLayoutParams.xD)
      {
        i = this.xl.dj();
        label369:
        n = this.xl.an(localView) + i;
        if (this.tZ != 1) {
          break label656;
        }
        d(localView, i, j, n, i1);
        label404:
        if (!localLayoutParams.xD) {
          break label672;
        }
        J(this.xn.tW, k);
      }
      for (;;)
      {
        a(paramaf, this.xn);
        i = 1;
        break label61;
        k = paraml.tX - paraml.tT;
        break;
        label454:
        m = this.xk.dj();
        break label58;
        label466:
        n = 0;
        break label126;
        label472:
        localar = a(paraml);
        break label147;
        label482:
        localar = this.xj[i];
        break label158;
        label494:
        addView(localView, 0);
        break label179;
        label504:
        i = localar.bd(m);
        break label211;
        label516:
        if (localLayoutParams.xD) {}
        for (i = aP(m);; i = localar.bc(m))
        {
          j = i - this.xk.an(localView);
          if ((n != 0) && (localLayoutParams.xD))
          {
            localFullSpanItem = aN(i);
            localFullSpanItem.xF = 1;
            localFullSpanItem.un = i2;
            this.xp.a(localFullSpanItem);
          }
          i1 = i;
          break;
        }
        label608:
        i = 0;
        break label311;
        label614:
        if (!eL())
        {
          i = 1;
          break label311;
        }
        i = 0;
        break label311;
        i = localar.bL * this.xm + this.xl.dj();
        break label369;
        label656:
        d(localView, j, i, i1, n);
        break label404;
        label672:
        a(localar, this.xn.tW, k);
      }
      label690:
      if (i == 0) {
        a(paramaf, this.xn);
      }
      if (this.xn.tW == -1) {
        i = aP(this.xk.dj());
      }
      for (i = this.xk.dj() - i; i > 0; i = aQ(this.xk.dk()) - this.xk.dk()) {
        return Math.min(paraml.tT, i);
      }
      return 0;
      label781:
      j = i;
    }
  }
  
  private ar a(l paraml)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i;
    int j;
    int k;
    int n;
    int i1;
    int m;
    if (aS(paraml.tW))
    {
      i = this.tI - 1;
      j = -1;
      k = -1;
      if (paraml.tW != 1) {
        break label121;
      }
      n = 2147483647;
      i1 = this.xk.dj();
      m = i;
      paraml = (l)localObject1;
      i = n;
      label59:
      localObject1 = paraml;
      if (m == k) {
        break label192;
      }
      localObject1 = this.xj[m];
      n = ((ar)localObject1).bd(i1);
      if (n >= i) {
        break label198;
      }
      paraml = (l)localObject1;
      i = n;
    }
    label192:
    label195:
    label198:
    for (;;)
    {
      m += j;
      break label59;
      i = 0;
      k = this.tI;
      j = 1;
      break;
      label121:
      n = -2147483648;
      i1 = this.xk.dk();
      m = i;
      paraml = localObject2;
      i = n;
      localObject1 = paraml;
      if (m != k)
      {
        localObject1 = this.xj[m];
        n = ((ar)localObject1).bc(i1);
        if (n <= i) {
          break label195;
        }
        paraml = (l)localObject1;
        i = n;
      }
      for (;;)
      {
        m += j;
        break;
        return localObject1;
      }
    }
  }
  
  private void a(int paramInt, ak paramak)
  {
    this.xn.tT = 0;
    this.xn.tU = paramInt;
    int i;
    boolean bool1;
    if (eb())
    {
      i = paramak.eo();
      if (i != -1)
      {
        boolean bool2 = this.ue;
        if (i < paramInt)
        {
          bool1 = true;
          if (bool2 != bool1) {
            break label110;
          }
          paramInt = this.xk.dl();
          i = 0;
        }
      }
    }
    for (;;)
    {
      if (getClipToPadding())
      {
        this.xn.tX = (this.xk.dj() - i);
        this.xn.tY = (paramInt + this.xk.dk());
        return;
        bool1 = false;
        break;
        label110:
        i = this.xk.dl();
        paramInt = 0;
        continue;
      }
      this.xn.tY = (paramInt + this.xk.getEnd());
      this.xn.tX = (-i);
      return;
      paramInt = 0;
      i = 0;
    }
  }
  
  private void a(af paramaf, int paramInt)
  {
    for (;;)
    {
      View localView;
      StaggeredGridLayoutManager.LayoutParams localLayoutParams;
      if (getChildCount() > 0)
      {
        localView = getChildAt(0);
        if (this.xk.am(localView) <= paramInt)
        {
          localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.xD) {
            break label105;
          }
          i = 0;
          if (i >= this.tI) {
            break label79;
          }
          if (ar.b(this.xj[i]).size() != 1) {
            break label72;
          }
        }
      }
      label72:
      label79:
      label105:
      while (ar.b(localLayoutParams.xC).size() == 1)
      {
        for (;;)
        {
          return;
          i += 1;
        }
        int i = 0;
        while (i < this.tI)
        {
          this.xj[i].eT();
          i += 1;
        }
      }
      localLayoutParams.xC.eT();
      a(localView, paramaf);
    }
  }
  
  private void a(af paramaf, ak paramak, boolean paramBoolean)
  {
    int i = aQ(this.xk.dk());
    i = this.xk.dk() - i;
    if (i > 0)
    {
      i -= -c(-i, paramaf, paramak);
      if ((paramBoolean) && (i > 0)) {
        this.xk.av(i);
      }
    }
  }
  
  private void a(af paramaf, l paraml)
  {
    if (paraml.tT == 0)
    {
      if (paraml.tW == -1)
      {
        b(paramaf, paraml.tY);
        return;
      }
      a(paramaf, paraml.tX);
      return;
    }
    if (paraml.tW == -1)
    {
      i = paraml.tX - aO(paraml.tX);
      if (i < 0) {}
      for (i = paraml.tY;; i = paraml.tY - Math.min(i, paraml.tT))
      {
        b(paramaf, i);
        return;
      }
    }
    int i = aR(paraml.tY) - paraml.tY;
    if (i < 0) {}
    int j;
    for (i = paraml.tX;; i = Math.min(i, paraml.tT) + j)
    {
      a(paramaf, i);
      return;
      j = paraml.tX;
    }
  }
  
  private void a(ar paramar, int paramInt1, int paramInt2)
  {
    int i = paramar.xQ;
    if (paramInt1 == -1) {
      if (i + paramar.eP() <= paramInt2) {
        this.xo.set(paramar.bL, false);
      }
    }
    while (paramar.eR() - i < paramInt2) {
      return;
    }
    this.xo.set(paramar.bL, false);
  }
  
  private void a(View paramView, StaggeredGridLayoutManager.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams.xD)
    {
      if (this.tZ == 1)
      {
        d(paramView, this.xu, I(paramLayoutParams.height, this.xw));
        return;
      }
      d(paramView, I(paramLayoutParams.width, this.xv), this.xu);
      return;
    }
    if (this.tZ == 1)
    {
      d(paramView, this.xv, I(paramLayoutParams.height, this.xw));
      return;
    }
    d(paramView, I(paramLayoutParams.width, this.xv), this.xw);
  }
  
  private void a(View paramView, StaggeredGridLayoutManager.LayoutParams paramLayoutParams, l paraml)
  {
    if (paraml.tW == 1)
    {
      if (paramLayoutParams.xD)
      {
        aI(paramView);
        return;
      }
      paramLayoutParams.xC.aL(paramView);
      return;
    }
    if (paramLayoutParams.xD)
    {
      aJ(paramView);
      return;
    }
    paramLayoutParams.xC.aK(paramView);
  }
  
  private boolean a(ar paramar)
  {
    if (this.ue)
    {
      if (paramar.eR() >= this.xk.dk()) {}
    }
    else {
      while (paramar.eP() > this.xk.dj()) {
        return true;
      }
    }
    return false;
  }
  
  private void aI(View paramView)
  {
    int i = this.tI - 1;
    while (i >= 0)
    {
      this.xj[i].aL(paramView);
      i -= 1;
    }
  }
  
  private void aJ(View paramView)
  {
    int i = this.tI - 1;
    while (i >= 0)
    {
      this.xj[i].aK(paramView);
      i -= 1;
    }
  }
  
  private void aL(int paramInt)
  {
    int i = 1;
    this.xn.tW = paramInt;
    l locall = this.xn;
    boolean bool2 = this.ue;
    boolean bool1;
    if (paramInt == -1)
    {
      bool1 = true;
      if (bool2 != bool1) {
        break label49;
      }
    }
    label49:
    for (paramInt = i;; paramInt = -1)
    {
      locall.tV = paramInt;
      return;
      bool1 = false;
      break;
    }
  }
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem aM(int paramInt)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    localFullSpanItem.xG = new int[this.tI];
    int i = 0;
    while (i < this.tI)
    {
      localFullSpanItem.xG[i] = (paramInt - this.xj[i].bd(paramInt));
      i += 1;
    }
    return localFullSpanItem;
  }
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem aN(int paramInt)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    localFullSpanItem.xG = new int[this.tI];
    int i = 0;
    while (i < this.tI)
    {
      localFullSpanItem.xG[i] = (this.xj[i].bc(paramInt) - paramInt);
      i += 1;
    }
    return localFullSpanItem;
  }
  
  private int aO(int paramInt)
  {
    int j = this.xj[0].bc(paramInt);
    int i = 1;
    while (i < this.tI)
    {
      int m = this.xj[i].bc(paramInt);
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int aP(int paramInt)
  {
    int j = this.xj[0].bc(paramInt);
    int i = 1;
    while (i < this.tI)
    {
      int m = this.xj[i].bc(paramInt);
      int k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int aQ(int paramInt)
  {
    int j = this.xj[0].bd(paramInt);
    int i = 1;
    while (i < this.tI)
    {
      int m = this.xj[i].bd(paramInt);
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int aR(int paramInt)
  {
    int j = this.xj[0].bd(paramInt);
    int i = 1;
    while (i < this.tI)
    {
      int m = this.xj[i].bd(paramInt);
      int k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private boolean aS(int paramInt)
  {
    int i;
    if (this.tZ == 0) {
      if (paramInt == -1)
      {
        i = 1;
        if (i == this.ue) {
          break label29;
        }
      }
    }
    label29:
    label63:
    label66:
    for (;;)
    {
      return true;
      i = 0;
      break;
      return false;
      if (paramInt == -1)
      {
        i = 1;
        if (i != this.ue) {
          break label63;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == da()) {
          break label66;
        }
        return false;
        i = 0;
        break;
      }
    }
  }
  
  private int aT(int paramInt)
  {
    if (getChildCount() == 0) {
      if (!this.ue) {}
    }
    for (;;)
    {
      return 1;
      return -1;
      if (paramInt < eN()) {}
      for (int i = 1; i != this.ue; i = 0) {
        return -1;
      }
    }
  }
  
  private void b(af paramaf, int paramInt)
  {
    int i = getChildCount() - 1;
    for (;;)
    {
      View localView;
      StaggeredGridLayoutManager.LayoutParams localLayoutParams;
      if (i >= 0)
      {
        localView = getChildAt(i);
        if (this.xk.al(localView) >= paramInt)
        {
          localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.xD) {
            break label119;
          }
          j = 0;
          if (j >= this.tI) {
            break label88;
          }
          if (ar.b(this.xj[j]).size() != 1) {
            break label79;
          }
        }
      }
      label79:
      label88:
      label119:
      while (ar.b(localLayoutParams.xC).size() == 1)
      {
        for (;;)
        {
          return;
          j += 1;
        }
        int j = 0;
        while (j < this.tI)
        {
          this.xj[j].eS();
          j += 1;
        }
      }
      localLayoutParams.xC.eS();
      a(localView, paramaf);
      i -= 1;
    }
  }
  
  private void b(af paramaf, ak paramak, boolean paramBoolean)
  {
    int i = aP(this.xk.dj()) - this.xk.dj();
    if (i > 0)
    {
      i -= c(i, paramaf, paramak);
      if ((paramBoolean) && (i > 0)) {
        this.xk.av(-i);
      }
    }
  }
  
  private int c(int paramInt, af paramaf, ak paramak)
  {
    eJ();
    int i;
    int j;
    if (paramInt > 0)
    {
      i = 1;
      j = eM();
      a(j, paramak);
      aL(i);
      l locall = this.xn;
      locall.tU = (j + locall.tV);
      j = Math.abs(paramInt);
      this.xn.tT = j;
      i = a(paramaf, this.xn, paramak);
      if (j >= i) {
        break label114;
      }
    }
    for (;;)
    {
      this.xk.av(-paramInt);
      this.xr = this.ue;
      return paramInt;
      i = -1;
      j = eN();
      break;
      label114:
      if (paramInt < 0) {
        paramInt = -i;
      } else {
        paramInt = i;
      }
    }
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
  
  private void d(View paramView, int paramInt1, int paramInt2)
  {
    b(paramView, this.qy);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    paramView.measure(f(paramInt1, localLayoutParams.leftMargin + this.qy.left, localLayoutParams.rightMargin + this.qy.right), f(paramInt2, localLayoutParams.topMargin + this.qy.top, localLayoutParams.bottomMargin + this.qy.bottom));
  }
  
  private static void d(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    c(paramView, localLayoutParams.leftMargin + paramInt1, localLayoutParams.topMargin + paramInt2, paramInt3 - localLayoutParams.rightMargin, paramInt4 - localLayoutParams.bottomMargin);
  }
  
  private boolean da()
  {
    return r.j(this.wa) == 1;
  }
  
  private View eI()
  {
    int i = getChildCount() - 1;
    BitSet localBitSet = new BitSet(this.tI);
    localBitSet.set(0, this.tI, true);
    int j;
    int k;
    if ((this.tZ == 1) && (da()))
    {
      j = 1;
      if (!this.ue) {
        break label128;
      }
      k = -1;
      label57:
      if (i >= k) {
        break label143;
      }
    }
    int n;
    View localView;
    StaggeredGridLayoutManager.LayoutParams localLayoutParams;
    label128:
    label143:
    for (int m = 1;; m = -1)
    {
      n = i;
      if (n == k) {
        break label349;
      }
      localView = getChildAt(n);
      localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
      if (!localBitSet.get(localLayoutParams.xC.bL)) {
        break label162;
      }
      if (!a(localLayoutParams.xC)) {
        break label149;
      }
      return localView;
      j = -1;
      break;
      k = 0;
      m = i + 1;
      i = k;
      k = m;
      break label57;
    }
    label149:
    localBitSet.clear(localLayoutParams.xC.bL);
    label162:
    Object localObject;
    int i1;
    if ((!localLayoutParams.xD) && (n + m != k))
    {
      localObject = getChildAt(n + m);
      if (this.ue)
      {
        i = this.xk.am(localView);
        i1 = this.xk.am((View)localObject);
        if (i < i1) {
          return localView;
        }
        if (i != i1) {
          break label351;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
        if (localLayoutParams.xC.bL - ((StaggeredGridLayoutManager.LayoutParams)localObject).xC.bL < 0)
        {
          i = 1;
          label271:
          if (j >= 0) {
            break label333;
          }
        }
        label333:
        for (i1 = 1;; i1 = 0)
        {
          if (i == i1) {
            break label339;
          }
          return localView;
          i = this.xk.al(localView);
          i1 = this.xk.al((View)localObject);
          if (i > i1) {
            return localView;
          }
          if (i != i1) {
            break label351;
          }
          i = 1;
          break;
          i = 0;
          break label271;
        }
      }
      label339:
      n += m;
      break;
      label349:
      return null;
      label351:
      i = 0;
    }
  }
  
  private void eJ()
  {
    if (this.xk == null)
    {
      this.xk = s.a(this, this.tZ);
      this.xl = s.a(this, 1 - this.tZ);
      this.xn = new l();
    }
  }
  
  private boolean eK()
  {
    boolean bool2 = true;
    int j = this.xj[0].bd(-2147483648);
    int i = 1;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.tI)
      {
        if (this.xj[i].bd(-2147483648) != j) {
          bool1 = false;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean eL()
  {
    boolean bool2 = true;
    int j = this.xj[0].bc(-2147483648);
    int i = 1;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.tI)
      {
        if (this.xj[i].bc(-2147483648) != j) {
          bool1 = false;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private int eM()
  {
    int i = getChildCount();
    if (i == 0) {
      return 0;
    }
    return av(getChildAt(i - 1));
  }
  
  private int eN()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    return av(getChildAt(0));
  }
  
  private static int f(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0)) {}
    int i;
    do
    {
      return paramInt1;
      i = View.MeasureSpec.getMode(paramInt1);
    } while ((i != -2147483648) && (i != 1073741824));
    return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1) - paramInt2 - paramInt3, i);
  }
  
  private void h(int paramInt1, int paramInt2, int paramInt3)
  {
    int k;
    int j;
    int i;
    if (this.ue)
    {
      k = eM();
      if (paramInt3 != 3) {
        break label100;
      }
      if (paramInt1 >= paramInt2) {
        break label89;
      }
      j = paramInt2 + 1;
      i = paramInt1;
      label31:
      this.xp.aV(i);
      switch (paramInt3)
      {
      case 2: 
      default: 
        label72:
        if (j > k) {
          break;
        }
      }
    }
    for (;;)
    {
      return;
      k = eN();
      break;
      label89:
      j = paramInt1 + 1;
      i = paramInt2;
      break label31;
      label100:
      j = paramInt1 + paramInt2;
      i = paramInt1;
      break label31;
      this.xp.L(paramInt1, paramInt2);
      break label72;
      this.xp.K(paramInt1, paramInt2);
      break label72;
      this.xp.K(paramInt1, 1);
      this.xp.L(paramInt2, 1);
      break label72;
      if (this.ue) {}
      for (paramInt1 = eN(); i <= paramInt1; paramInt1 = eM())
      {
        requestLayout();
        return;
      }
    }
  }
  
  private int i(ak paramak)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    eJ();
    s locals = this.xk;
    View localView;
    if (!this.ug)
    {
      bool1 = true;
      localView = t(bool1);
      if (this.ug) {
        break label74;
      }
    }
    label74:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ap.a(paramak, locals, localView, u(bool1), this, this.ug, this.ue);
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
    eJ();
    s locals = this.xk;
    View localView;
    if (!this.ug)
    {
      bool1 = true;
      localView = t(bool1);
      if (this.ug) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ap.a(paramak, locals, localView, u(bool1), this, this.ug);
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
    eJ();
    s locals = this.xk;
    View localView;
    if (!this.ug)
    {
      bool1 = true;
      localView = t(bool1);
      if (this.ug) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ap.b(paramak, locals, localView, u(bool1), this, this.ug);
      bool1 = false;
      break;
    }
  }
  
  private View t(boolean paramBoolean)
  {
    eJ();
    int j = this.xk.dj();
    int k = this.xk.dk();
    int m = getChildCount();
    Object localObject = null;
    int i = 0;
    if (i < m)
    {
      View localView = getChildAt(i);
      int n = this.xk.al(localView);
      if ((this.xk.am(localView) <= j) || (n >= k)) {
        break label108;
      }
      if ((n >= j) || (!paramBoolean)) {
        return localView;
      }
      if (localObject != null) {
        break label108;
      }
      localObject = localView;
    }
    label108:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
  }
  
  private View u(boolean paramBoolean)
  {
    eJ();
    int j = this.xk.dj();
    int k = this.xk.dk();
    Object localObject = null;
    int i = getChildCount() - 1;
    if (i >= 0)
    {
      View localView = getChildAt(i);
      int m = this.xk.al(localView);
      int n = this.xk.am(localView);
      if ((n <= j) || (m >= k)) {
        break label110;
      }
      if ((n <= k) || (!paramBoolean)) {
        return localView;
      }
      if (localObject != null) {
        break label110;
      }
      localObject = localView;
    }
    label110:
    for (;;)
    {
      i -= 1;
      break;
      return localObject;
    }
  }
  
  public final int a(int paramInt, af paramaf, ak paramak)
  {
    return c(paramInt, paramaf, paramak);
  }
  
  public final int a(af paramaf, ak paramak)
  {
    if (this.tZ == 0) {
      return this.tI;
    }
    return super.a(paramaf, paramak);
  }
  
  public final RecyclerView.LayoutParams a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new StaggeredGridLayoutManager.LayoutParams(paramContext, paramAttributeSet);
  }
  
  public final RecyclerView.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new StaggeredGridLayoutManager.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new StaggeredGridLayoutManager.LayoutParams(paramLayoutParams);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = new p(paramRecyclerView.getContext())
    {
      public final PointF at(int paramAnonymousInt)
      {
        paramAnonymousInt = StaggeredGridLayoutManager.a(StaggeredGridLayoutManager.this, paramAnonymousInt);
        if (paramAnonymousInt == 0) {
          return null;
        }
        if (StaggeredGridLayoutManager.a(StaggeredGridLayoutManager.this) == 0) {
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
    removeCallbacks(this.xz);
    int i = 0;
    while (i < this.tI)
    {
      this.xj[i].clear();
      i += 1;
    }
  }
  
  public final void a(af paramaf, ak paramak, View paramView, b paramb)
  {
    int i = 1;
    paramaf = paramView.getLayoutParams();
    if (!(paramaf instanceof StaggeredGridLayoutManager.LayoutParams))
    {
      super.b(paramView, paramb);
      return;
    }
    paramaf = (StaggeredGridLayoutManager.LayoutParams)paramaf;
    int k;
    int m;
    int j;
    if (this.tZ == 0)
    {
      k = paramaf.cU();
      if (paramaf.xD) {
        i = this.tI;
      }
      int n = -1;
      m = -1;
      j = i;
      i = n;
    }
    for (;;)
    {
      paramb.w(e.a(k, j, m, i, paramaf.xD));
      return;
      m = paramaf.cU();
      if (paramaf.xD)
      {
        i = this.tI;
        j = -1;
        k = -1;
      }
      else
      {
        i = 1;
        j = -1;
        k = -1;
      }
    }
  }
  
  public final boolean a(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof StaggeredGridLayoutManager.LayoutParams;
  }
  
  public final void aA(int paramInt)
  {
    if ((paramInt != 0) || (getChildCount() == 0) || (this.xq == 0) || (!isAttachedToWindow())) {
      return;
    }
    int i;
    if (this.ue)
    {
      i = eM();
      paramInt = eN();
      label43:
      if ((i != 0) || (eI() == null)) {
        break label83;
      }
      this.xp.clear();
    }
    for (;;)
    {
      ee();
      requestLayout();
      return;
      i = eN();
      paramInt = eM();
      break label43;
      label83:
      if (!this.xy) {
        break;
      }
      if (this.ue) {}
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem1;
      for (int j = -1;; j = 1)
      {
        localFullSpanItem1 = this.xp.i(i, paramInt + 1, j);
        if (localFullSpanItem1 != null) {
          break;
        }
        this.xy = false;
        this.xp.aU(paramInt + 1);
        return;
      }
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem2 = this.xp.i(i, localFullSpanItem1.un, j * -1);
      if (localFullSpanItem2 == null) {
        this.xp.aU(localFullSpanItem1.un);
      } else {
        this.xp.aU(localFullSpanItem2.un + 1);
      }
    }
  }
  
  public final void as(int paramInt)
  {
    if ((this.xt != null) && (this.xt.uA != paramInt))
    {
      StaggeredGridLayoutManager.SavedState localSavedState = this.xt;
      localSavedState.xK = null;
      localSavedState.xJ = 0;
      localSavedState.uA = -1;
      localSavedState.xI = -1;
    }
    this.uh = paramInt;
    this.ui = -2147483648;
    requestLayout();
  }
  
  public final void ay(int paramInt)
  {
    super.ay(paramInt);
    int i = 0;
    while (i < this.tI)
    {
      this.xj[i].bf(paramInt);
      i += 1;
    }
  }
  
  public final void az(int paramInt)
  {
    super.az(paramInt);
    int i = 0;
    while (i < this.tI)
    {
      this.xj[i].bf(paramInt);
      i += 1;
    }
  }
  
  public final int b(int paramInt, af paramaf, ak paramak)
  {
    return c(paramInt, paramaf, paramak);
  }
  
  public final int b(af paramaf, ak paramak)
  {
    if (this.tZ == 1) {
      return this.tI;
    }
    return super.b(paramaf, paramak);
  }
  
  public final int c(ak paramak)
  {
    return i(paramak);
  }
  
  public final void c(af paramaf, ak paramak)
  {
    int m = 1;
    eJ();
    aq localaq = this.xx;
    localaq.un = -1;
    localaq.lm = -2147483648;
    localaq.up = false;
    localaq.xB = false;
    if (((this.xt != null) || (this.uh != -1)) && (paramak.getItemCount() == 0))
    {
      d(paramaf);
      return;
    }
    int k;
    label182:
    Object localObject;
    boolean bool;
    if (this.xt != null)
    {
      if (this.xt.xJ > 0) {
        if (this.xt.xJ == this.tI)
        {
          j = 0;
          if (j < this.tI)
          {
            this.xj[j].clear();
            k = this.xt.xK[j];
            i = k;
            if (k != -2147483648) {
              if (!this.xt.uC) {
                break label182;
              }
            }
            for (i = k + this.xk.dk();; i = k + this.xk.dj())
            {
              this.xj[j].be(i);
              j += 1;
              break;
            }
          }
        }
        else
        {
          localObject = this.xt;
          ((StaggeredGridLayoutManager.SavedState)localObject).xK = null;
          ((StaggeredGridLayoutManager.SavedState)localObject).xJ = 0;
          ((StaggeredGridLayoutManager.SavedState)localObject).xL = 0;
          ((StaggeredGridLayoutManager.SavedState)localObject).xM = null;
          ((StaggeredGridLayoutManager.SavedState)localObject).xE = null;
          this.xt.uA = this.xt.xI;
        }
      }
      this.xs = this.xt.xs;
      bool = this.xt.ud;
      f(null);
      if ((this.xt != null) && (this.xt.ud != bool)) {
        this.xt.ud = bool;
      }
      this.ud = bool;
      requestLayout();
      cZ();
      if (this.xt.uA != -1)
      {
        this.uh = this.xt.uA;
        localaq.up = this.xt.uC;
        if (this.xt.xL > 1)
        {
          this.xp.mData = this.xt.xM;
          this.xp.xE = this.xt.xE;
        }
        label386:
        if ((!paramak.em()) && (this.uh != -1)) {
          break label622;
        }
        i = 0;
        label403:
        if (i == 0)
        {
          if (!this.xr) {
            break label1117;
          }
          k = paramak.getItemCount();
          i = getChildCount() - 1;
          label427:
          if (i < 0) {
            break label1112;
          }
          j = av(getChildAt(i));
          if ((j < 0) || (j >= k)) {
            break label1105;
          }
          i = j;
        }
      }
    }
    label622:
    label1016:
    int n;
    for (;;)
    {
      localaq.un = i;
      localaq.lm = -2147483648;
      if ((this.xt == null) && ((localaq.up != this.xr) || (da() != this.xs)))
      {
        this.xp.clear();
        localaq.xB = true;
      }
      if ((getChildCount() <= 0) || ((this.xt != null) && (this.xt.xJ > 0))) {
        break label1330;
      }
      if (!localaq.xB) {
        break label1179;
      }
      i = 0;
      while (i < this.tI)
      {
        this.xj[i].clear();
        if (localaq.lm != -2147483648) {
          this.xj[i].be(localaq.lm);
        }
        i += 1;
      }
      localaq.up = this.ue;
      break;
      cZ();
      localaq.up = this.ue;
      break label386;
      if ((this.uh < 0) || (this.uh >= paramak.getItemCount()))
      {
        this.uh = -1;
        this.ui = -2147483648;
        i = 0;
        break label403;
      }
      if ((this.xt == null) || (this.xt.uA == -1) || (this.xt.xJ <= 0))
      {
        localObject = ar(this.uh);
        if (localObject != null)
        {
          if (this.ue)
          {
            i = eM();
            label711:
            localaq.un = i;
            if (this.ui == -2147483648) {
              break label804;
            }
            if (!localaq.up) {
              break label774;
            }
          }
          label774:
          for (localaq.lm = (this.xk.dk() - this.ui - this.xk.am((View)localObject));; localaq.lm = (this.xk.dj() + this.ui - this.xk.al((View)localObject)))
          {
            i = 1;
            break;
            i = eN();
            break label711;
          }
          label804:
          if (this.xk.an((View)localObject) > this.xk.dl()) {
            if (localaq.up)
            {
              i = this.xk.dk();
              label839:
              localaq.lm = i;
            }
          }
        }
      }
      for (;;)
      {
        i = 1;
        break;
        i = this.xk.dj();
        break label839;
        i = this.xk.al((View)localObject) - this.xk.dj();
        if (i < 0)
        {
          localaq.lm = (-i);
        }
        else
        {
          i = this.xk.dk() - this.xk.am((View)localObject);
          if (i < 0)
          {
            localaq.lm = i;
          }
          else
          {
            localaq.lm = -2147483648;
            continue;
            localaq.un = this.uh;
            if (this.ui == -2147483648) {
              if (aT(localaq.un) == 1)
              {
                bool = true;
                label968:
                localaq.up = bool;
                if (!localaq.up) {
                  break label1016;
                }
                i = localaq.xA.xk.dk();
                label995:
                localaq.lm = i;
              }
            }
            for (;;)
            {
              localaq.xB = true;
              break;
              bool = false;
              break label968;
              i = localaq.xA.xk.dj();
              break label995;
              i = this.ui;
              if (localaq.up) {
                localaq.lm = (localaq.xA.xk.dk() - i);
              } else {
                localaq.lm = (i + localaq.xA.xk.dj());
              }
            }
            localaq.lm = -2147483648;
            localaq.un = this.uh;
          }
        }
      }
      label1105:
      i -= 1;
      break label427;
      label1112:
      i = 0;
      continue;
      label1117:
      n = paramak.getItemCount();
      int i1 = getChildCount();
      j = 0;
      for (;;)
      {
        if (j >= i1) {
          break label1174;
        }
        k = av(getChildAt(j));
        if (k >= 0)
        {
          i = k;
          if (k < n) {
            break;
          }
        }
        j += 1;
      }
      label1174:
      i = 0;
    }
    label1179:
    int j = 0;
    if (j < this.tI)
    {
      localObject = this.xj[j];
      bool = this.ue;
      n = localaq.lm;
      if (bool)
      {
        i = ((ar)localObject).bd(-2147483648);
        label1226:
        ((ar)localObject).clear();
        if ((i != -2147483648) && ((!bool) || (i >= ((ar)localObject).xA.xk.dk())) && ((bool) || (i <= ((ar)localObject).xA.xk.dj()))) {
          break label1297;
        }
      }
      for (;;)
      {
        j += 1;
        break;
        i = ((ar)localObject).bc(-2147483648);
        break label1226;
        label1297:
        k = i;
        if (n != -2147483648) {
          k = i + n;
        }
        ((ar)localObject).xP = k;
        ((ar)localObject).xO = k;
      }
    }
    label1330:
    b(paramaf);
    this.xy = false;
    this.xm = (this.xl.dl() / this.tI);
    this.xu = View.MeasureSpec.makeMeasureSpec(this.xl.dl(), 1073741824);
    if (this.tZ == 1)
    {
      this.xv = View.MeasureSpec.makeMeasureSpec(this.xm, 1073741824);
      this.xw = View.MeasureSpec.makeMeasureSpec(0, 0);
      a(localaq.un, paramak);
      if (!localaq.up) {
        break label1633;
      }
      aL(-1);
      a(paramaf, this.xn, paramak);
      aL(1);
      this.xn.tU = (localaq.un + this.xn.tV);
      a(paramaf, this.xn, paramak);
      label1472:
      if (getChildCount() > 0)
      {
        if (!this.ue) {
          break label1688;
        }
        a(paramaf, paramak, true);
        b(paramaf, paramak, false);
      }
      label1500:
      if (!paramak.em())
      {
        if ((this.xq == 0) || (getChildCount() <= 0)) {
          break label1705;
        }
        i = m;
        if (!this.xy) {
          if (eI() == null) {
            break label1705;
          }
        }
      }
    }
    label1688:
    label1705:
    for (int i = m;; i = 0)
    {
      if (i != 0)
      {
        removeCallbacks(this.xz);
        paramaf = this.xz;
        if (this.wa != null) {
          r.b(this.wa, paramaf);
        }
      }
      this.uh = -1;
      this.ui = -2147483648;
      this.xr = localaq.up;
      this.xs = da();
      this.xt = null;
      return;
      this.xw = View.MeasureSpec.makeMeasureSpec(this.xm, 1073741824);
      this.xv = View.MeasureSpec.makeMeasureSpec(0, 0);
      break;
      label1633:
      aL(1);
      a(paramaf, this.xn, paramak);
      aL(-1);
      this.xn.tU = (localaq.un + this.xn.tV);
      a(paramaf, this.xn, paramak);
      break label1472;
      b(paramaf, paramak, true);
      a(paramaf, paramak, false);
      break label1500;
    }
  }
  
  public final void cR()
  {
    this.xp.clear();
    requestLayout();
  }
  
  public final RecyclerView.LayoutParams cS()
  {
    return new StaggeredGridLayoutManager.LayoutParams();
  }
  
  public final boolean cT()
  {
    return this.xt == null;
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
    if (this.xt == null) {
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
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    View localView1;
    View localView2;
    if (getChildCount() > 0)
    {
      paramAccessibilityEvent = a.a(paramAccessibilityEvent);
      localView1 = t(false);
      localView2 = u(false);
      if ((localView1 != null) && (localView2 != null)) {}
    }
    else
    {
      return;
    }
    int i = av(localView1);
    int j = av(localView2);
    if (i < j)
    {
      paramAccessibilityEvent.setFromIndex(i);
      paramAccessibilityEvent.setToIndex(j);
      return;
    }
    paramAccessibilityEvent.setFromIndex(j);
    paramAccessibilityEvent.setToIndex(i);
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof StaggeredGridLayoutManager.SavedState))
    {
      this.xt = ((StaggeredGridLayoutManager.SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    if (this.xt != null) {
      return new StaggeredGridLayoutManager.SavedState(this.xt);
    }
    StaggeredGridLayoutManager.SavedState localSavedState = new StaggeredGridLayoutManager.SavedState();
    localSavedState.ud = this.ud;
    localSavedState.uC = this.xr;
    localSavedState.xs = this.xs;
    int i;
    label130:
    View localView;
    label150:
    label157:
    int j;
    label185:
    int k;
    if ((this.xp != null) && (this.xp.mData != null))
    {
      localSavedState.xM = this.xp.mData;
      localSavedState.xL = localSavedState.xM.length;
      localSavedState.xE = this.xp.xE;
      if (getChildCount() <= 0) {
        break label314;
      }
      eJ();
      if (!this.xr) {
        break label254;
      }
      i = eM();
      localSavedState.uA = i;
      if (!this.ue) {
        break label262;
      }
      localView = u(true);
      if (localView != null) {
        break label272;
      }
      i = -1;
      localSavedState.xI = i;
      localSavedState.xJ = this.tI;
      localSavedState.xK = new int[this.tI];
      j = 0;
      if (j >= this.tI) {
        break label332;
      }
      if (!this.xr) {
        break label281;
      }
      k = this.xj[j].bd(-2147483648);
      i = k;
      if (k != -2147483648) {
        i = k - this.xk.dk();
      }
    }
    for (;;)
    {
      localSavedState.xK[j] = i;
      j += 1;
      break label185;
      localSavedState.xL = 0;
      break;
      label254:
      i = eN();
      break label130;
      label262:
      localView = t(true);
      break label150;
      label272:
      i = av(localView);
      break label157;
      label281:
      k = this.xj[j].bc(-2147483648);
      i = k;
      if (k != -2147483648) {
        i = k - this.xk.dj();
      }
    }
    label314:
    localSavedState.uA = -1;
    localSavedState.xI = -1;
    localSavedState.xJ = 0;
    label332:
    return localSavedState;
  }
  
  public final void r(int paramInt1, int paramInt2)
  {
    h(paramInt1, paramInt2, 0);
  }
  
  public final void s(int paramInt1, int paramInt2)
  {
    h(paramInt1, paramInt2, 1);
  }
  
  public final void t(int paramInt1, int paramInt2)
  {
    h(paramInt1, paramInt2, 2);
  }
  
  public final void u(int paramInt1, int paramInt2)
  {
    h(paramInt1, paramInt2, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */