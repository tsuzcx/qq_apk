package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.view.a.a;
import android.support.v4.view.a.aa;
import android.support.v4.view.a.e;
import android.support.v4.view.a.q;
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
  private final Rect oI;
  private int rS;
  private int sj;
  private boolean sn;
  boolean so;
  private boolean sq;
  int sr;
  int ss;
  StaggeredGridLayoutManager.LazySpanLookup vA;
  private int vB;
  private boolean vC;
  private boolean vD;
  private StaggeredGridLayoutManager.SavedState vE;
  private int vF;
  private int vG;
  private int vH;
  private final aq vI;
  private boolean vJ;
  private final Runnable vK;
  private ar[] vu;
  s vv;
  s vw;
  private int vx;
  private l vy;
  private BitSet vz;
  
  private static int G(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      return paramInt2;
    }
    return View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
  }
  
  private void H(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.rS)
    {
      if (!ar.a(this.vu[i]).isEmpty()) {
        a(this.vu[i], paramInt1, paramInt2);
      }
      i += 1;
    }
  }
  
  private int a(af paramaf, l paraml, ak paramak)
  {
    this.vz.set(0, this.rS, true);
    int m;
    int n;
    label58:
    int i;
    int j;
    label82:
    View localView;
    StaggeredGridLayoutManager.LayoutParams localLayoutParams;
    int i4;
    label168:
    int i1;
    if (paraml.sg == 1)
    {
      m = paraml.si + paraml.sd;
      H(paraml.sg, m);
      if (!this.so) {
        break label412;
      }
      n = this.vv.db();
      i = 0;
      if ((paraml.se < 0) || (paraml.se >= paramak.getItemCount())) {
        break label424;
      }
      j = 1;
      if ((j == 0) || (this.vz.isEmpty())) {
        break label1514;
      }
      localView = paramaf.at(paraml.se);
      paraml.se += paraml.sf;
      localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
      i4 = localLayoutParams.uo.eg();
      localObject1 = this.vA;
      if ((((StaggeredGridLayoutManager.LazySpanLookup)localObject1).mData != null) && (i4 < ((StaggeredGridLayoutManager.LazySpanLookup)localObject1).mData.length)) {
        break label430;
      }
      i = -1;
      if (i != -1) {
        break label443;
      }
      i1 = 1;
      label177:
      if (i1 == 0) {
        break label747;
      }
      if (!localLayoutParams.vO) {
        break label449;
      }
      localObject1 = this.vu[0];
    }
    label198:
    Object localObject2;
    label224:
    label245:
    int k;
    label283:
    label307:
    label443:
    label449:
    int i6;
    label412:
    label424:
    label430:
    label471:
    label483:
    label502:
    int i5;
    int i2;
    label534:
    do
    {
      localObject2 = this.vA;
      ((StaggeredGridLayoutManager.LazySpanLookup)localObject2).aF(i4);
      ((StaggeredGridLayoutManager.LazySpanLookup)localObject2).mData[i4] = ((ar)localObject1).ac;
      localLayoutParams.vN = ((ar)localObject1);
      if (paraml.sg != 1) {
        break label759;
      }
      addView(localView);
      if (!localLayoutParams.vO) {
        break label794;
      }
      if (this.sj != 1) {
        break label769;
      }
      d(localView, this.vF, G(localLayoutParams.height, this.vH));
      if (paraml.sg != 1) {
        break label1054;
      }
      if (!localLayoutParams.vO) {
        break label852;
      }
      i = aB(n);
      j = i + this.vv.ag(localView);
      if ((i1 == 0) || (!localLayoutParams.vO)) {
        break label1605;
      }
      localObject2 = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
      ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2).vR = new int[this.rS];
      k = 0;
      while (k < this.rS)
      {
        ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2).vR[k] = (i - this.vu[k].aJ(i));
        k += 1;
      }
      m = paraml.sh - paraml.sd;
      break;
      n = this.vv.da();
      break label58;
      j = 0;
      break label82;
      i = localObject1.mData[i4];
      break label168;
      i1 = 0;
      break label177;
      i = paraml.sg;
      if (this.sj != 0) {
        break label600;
      }
      if (i != -1) {
        break label588;
      }
      i6 = 1;
      if (i6 == this.so) {
        break label594;
      }
      i = 1;
      if (i == 0) {
        break label654;
      }
      i = this.rS - 1;
      k = -1;
      j = -1;
      if (paraml.sg != 1) {
        break label669;
      }
      localObject2 = null;
      i3 = 2147483647;
      i5 = this.vv.da();
      i2 = i;
      i = i3;
      localObject1 = localObject2;
    } while (i2 == k);
    Object localObject1 = this.vu[i2];
    int i3 = ((ar)localObject1).aJ(i5);
    if (i3 < i) {
      i = i3;
    }
    for (;;)
    {
      i2 += j;
      localObject2 = localObject1;
      break label534;
      label588:
      i6 = 0;
      break label471;
      label594:
      i = 0;
      break label483;
      label600:
      if (i == -1)
      {
        i6 = 1;
        label609:
        if (i6 != this.so) {
          break label642;
        }
      }
      label642:
      for (i6 = 1;; i6 = 0)
      {
        if (i6 != cS()) {
          break label648;
        }
        i = 1;
        break;
        i6 = 0;
        break label609;
      }
      label648:
      i = 0;
      break label483;
      label654:
      i = 0;
      k = this.rS;
      j = 1;
      break label502;
      label669:
      localObject2 = null;
      i3 = -2147483648;
      i5 = this.vv.db();
      i2 = i;
      i = i3;
      label693:
      localObject1 = localObject2;
      if (i2 == k) {
        break label198;
      }
      localObject1 = this.vu[i2];
      i3 = ((ar)localObject1).aI(i5);
      if (i3 > i) {
        i = i3;
      }
      for (;;)
      {
        i2 += j;
        localObject2 = localObject1;
        break label693;
        label747:
        localObject1 = this.vu[i];
        break label224;
        label759:
        addView(localView, 0);
        break label245;
        label769:
        d(localView, G(localLayoutParams.width, this.vG), this.vF);
        break label283;
        label794:
        if (this.sj == 1)
        {
          d(localView, this.vG, G(localLayoutParams.height, this.vH));
          break label283;
        }
        d(localView, G(localLayoutParams.width, this.vG), this.vH);
        break label283;
        label852:
        i = ((ar)localObject1).aJ(n);
        break label307;
        ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2).vQ = -1;
        ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2).sx = i4;
        this.vA.a((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2);
        k = i;
        for (;;)
        {
          if ((localLayoutParams.vO) && (paraml.sf == -1)) {
            if (i1 == 0)
            {
              if (paraml.sg != 1) {
                break label1227;
              }
              i1 = this.vu[0].aJ(-2147483648);
              i = 1;
              label935:
              if (i >= this.rS) {
                break label1215;
              }
              if (this.vu[i].aJ(-2147483648) == i1) {
                break label1206;
              }
              i = 0;
              label964:
              if (i != 0) {
                break label1221;
              }
              i = 1;
            }
          }
          for (;;)
          {
            if (i != 0)
            {
              localObject2 = this.vA.aG(i4);
              if (localObject2 != null) {
                ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2).vS = true;
              }
              this.vJ = true;
            }
            if (paraml.sg != 1) {
              break label1402;
            }
            if (!localLayoutParams.vO) {
              break label1304;
            }
            i = this.rS - 1;
            while (i >= 0)
            {
              this.vu[i].aC(localView);
              i -= 1;
            }
            label1054:
            if (localLayoutParams.vO) {}
            for (i = aA(n);; i = ((ar)localObject1).aI(n))
            {
              k = this.vv.ag(localView);
              if ((i1 == 0) || (!localLayoutParams.vO)) {
                break label1192;
              }
              localObject2 = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
              ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2).vR = new int[this.rS];
              j = 0;
              while (j < this.rS)
              {
                ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2).vR[j] = (this.vu[j].aI(i) - i);
                j += 1;
              }
            }
            ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2).vQ = 1;
            ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2).sx = i4;
            this.vA.a((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject2);
            label1192:
            j = i;
            k = i - k;
            break;
            label1206:
            i += 1;
            break label935;
            label1215:
            i = 1;
            break label964;
            label1221:
            i = 0;
            continue;
            label1227:
            i1 = this.vu[0].aI(-2147483648);
            i = 1;
            label1243:
            if (i < this.rS) {
              if (this.vu[i].aI(-2147483648) == i1) {}
            }
            for (i = 0;; i = 1)
            {
              if (i != 0) {
                break label1298;
              }
              i = 1;
              break;
              i += 1;
              break label1243;
            }
            label1298:
            i = 0;
          }
          label1304:
          localLayoutParams.vN.aC(localView);
          label1314:
          if (localLayoutParams.vO)
          {
            i = this.vw.da();
            label1331:
            i1 = this.vw.ag(localView) + i;
            if (this.sj != 1) {
              break label1480;
            }
            c(localView, i, k, i1, j);
            label1366:
            if (!localLayoutParams.vO) {
              break label1496;
            }
            H(this.vy.sg, m);
          }
          for (;;)
          {
            a(paramaf, this.vy);
            i = 1;
            break;
            label1402:
            if (localLayoutParams.vO)
            {
              i = this.rS - 1;
              while (i >= 0)
              {
                this.vu[i].aB(localView);
                i -= 1;
              }
              break label1314;
            }
            localLayoutParams.vN.aB(localView);
            break label1314;
            i = ((ar)localObject1).ac * this.vx + this.vw.da();
            break label1331;
            label1480:
            c(localView, k, i, j, i1);
            break label1366;
            label1496:
            a((ar)localObject1, this.vy.sg, m);
          }
          label1514:
          if (i == 0) {
            a(paramaf, this.vy);
          }
          if (this.vy.sg == -1) {
            i = aA(this.vv.da());
          }
          for (i = this.vv.da() - i; i > 0; i = aB(this.vv.db()) - this.vv.db()) {
            return Math.min(paraml.sd, i);
          }
          return 0;
          label1605:
          k = i;
        }
        localObject1 = localObject2;
      }
      localObject1 = localObject2;
    }
  }
  
  private void a(int paramInt, ak paramak)
  {
    int k = 0;
    this.vy.sd = 0;
    this.vy.se = paramInt;
    int i;
    boolean bool1;
    if (dN())
    {
      i = paramak.ea();
      if (i != -1)
      {
        boolean bool2 = this.so;
        if (i < paramInt)
        {
          bool1 = true;
          if (bool2 != bool1) {
            break label139;
          }
          paramInt = this.vv.dc();
          i = 0;
        }
      }
    }
    for (;;)
    {
      int j = k;
      if (this.uk != null)
      {
        j = k;
        if (RecyclerView.p(this.uk)) {
          j = 1;
        }
      }
      if (j != 0)
      {
        this.vy.sh = (this.vv.da() - i);
        this.vy.si = (paramInt + this.vv.db());
        return;
        bool1 = false;
        break;
        label139:
        i = this.vv.dc();
        paramInt = 0;
        continue;
      }
      this.vy.si = (paramInt + this.vv.getEnd());
      this.vy.sh = (-i);
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
        if (this.vv.af(localView) <= paramInt)
        {
          localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.vO) {
            break label105;
          }
          i = 0;
          if (i >= this.rS) {
            break label79;
          }
          if (ar.a(this.vu[i]).size() != 1) {
            break label72;
          }
        }
      }
      label72:
      label79:
      label105:
      while (ar.a(localLayoutParams.vN).size() == 1)
      {
        for (;;)
        {
          return;
          i += 1;
        }
        int i = 0;
        while (i < this.rS)
        {
          this.vu[i].eD();
          i += 1;
        }
      }
      localLayoutParams.vN.eD();
      a(localView, paramaf);
    }
  }
  
  private void a(af paramaf, ak paramak, boolean paramBoolean)
  {
    int i = aB(this.vv.db());
    i = this.vv.db() - i;
    if (i > 0)
    {
      i -= -c(-i, paramaf, paramak);
      if ((paramBoolean) && (i > 0)) {
        this.vv.aj(i);
      }
    }
  }
  
  private void a(af paramaf, l paraml)
  {
    int k = 1;
    int i = 1;
    if (paraml.sd == 0)
    {
      if (paraml.sg == -1)
      {
        b(paramaf, paraml.si);
        return;
      }
      a(paramaf, paraml.sh);
      return;
    }
    int m;
    if (paraml.sg == -1)
    {
      n = paraml.sh;
      int i1 = paraml.sh;
      for (j = this.vu[0].aI(i1); i < this.rS; j = k)
      {
        m = this.vu[i].aI(i1);
        k = j;
        if (m > j) {
          k = m;
        }
        i += 1;
      }
      i = n - j;
      if (i < 0) {}
      for (i = paraml.si;; i = paraml.si - Math.min(i, paraml.sd))
      {
        b(paramaf, i);
        return;
      }
    }
    int n = paraml.si;
    int j = this.vu[0].aJ(n);
    i = k;
    while (i < this.rS)
    {
      m = this.vu[i].aJ(n);
      k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    i = j - paraml.si;
    if (i < 0) {}
    for (i = paraml.sh;; i = Math.min(i, paraml.sd) + j)
    {
      a(paramaf, i);
      return;
      j = paraml.sh;
    }
  }
  
  private void a(ar paramar, int paramInt1, int paramInt2)
  {
    int i = paramar.wb;
    if (paramInt1 == -1) {
      if (i + paramar.ez() <= paramInt2) {
        this.vz.set(paramar.ac, false);
      }
    }
    while (paramar.eB() - i < paramInt2) {
      return;
    }
    this.vz.set(paramar.ac, false);
  }
  
  private int aA(int paramInt)
  {
    int j = this.vu[0].aI(paramInt);
    int i = 1;
    while (i < this.rS)
    {
      int m = this.vu[i].aI(paramInt);
      int k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int aB(int paramInt)
  {
    int j = this.vu[0].aJ(paramInt);
    int i = 1;
    while (i < this.rS)
    {
      int m = this.vu[i].aJ(paramInt);
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int aC(int paramInt)
  {
    if (getChildCount() == 0) {
      if (!this.so) {}
    }
    for (;;)
    {
      return 1;
      return -1;
      if (paramInt < ex()) {}
      for (int i = 1; i != this.so; i = 0) {
        return -1;
      }
    }
  }
  
  private void az(int paramInt)
  {
    int i = 1;
    this.vy.sg = paramInt;
    l locall = this.vy;
    boolean bool2 = this.so;
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
      locall.sf = paramInt;
      return;
      bool1 = false;
      break;
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
        if (this.vv.ae(localView) >= paramInt)
        {
          localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.vO) {
            break label119;
          }
          j = 0;
          if (j >= this.rS) {
            break label88;
          }
          if (ar.a(this.vu[j]).size() != 1) {
            break label79;
          }
        }
      }
      label79:
      label88:
      label119:
      while (ar.a(localLayoutParams.vN).size() == 1)
      {
        for (;;)
        {
          return;
          j += 1;
        }
        int j = 0;
        while (j < this.rS)
        {
          this.vu[j].eC();
          j += 1;
        }
      }
      localLayoutParams.vN.eC();
      a(localView, paramaf);
      i -= 1;
    }
  }
  
  private void b(af paramaf, ak paramak, boolean paramBoolean)
  {
    int i = aA(this.vv.da()) - this.vv.da();
    if (i > 0)
    {
      i -= c(i, paramaf, paramak);
      if ((paramBoolean) && (i > 0)) {
        this.vv.aj(-i);
      }
    }
  }
  
  private int c(int paramInt, af paramaf, ak paramak)
  {
    ev();
    int i;
    int j;
    if (paramInt > 0)
    {
      i = 1;
      j = ew();
      a(j, paramak);
      az(i);
      this.vy.se = (j + this.vy.sf);
      j = Math.abs(paramInt);
      this.vy.sd = j;
      i = a(paramaf, this.vy, paramak);
      if (j >= i) {
        break label112;
      }
    }
    for (;;)
    {
      this.vv.aj(-paramInt);
      this.vC = this.so;
      return paramInt;
      i = -1;
      j = ex();
      break;
      label112:
      if (paramInt < 0) {
        paramInt = -i;
      } else {
        paramInt = i;
      }
    }
  }
  
  private static void c(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    b(paramView, localLayoutParams.leftMargin + paramInt1, localLayoutParams.topMargin + paramInt2, paramInt3 - localLayoutParams.rightMargin, paramInt4 - localLayoutParams.bottomMargin);
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
  
  private boolean cS()
  {
    return r.i(this.uk) == 1;
  }
  
  private void d(View paramView, int paramInt1, int paramInt2)
  {
    b(paramView, this.oI);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    paramView.measure(f(paramInt1, localLayoutParams.leftMargin + this.oI.left, localLayoutParams.rightMargin + this.oI.right), f(paramInt2, localLayoutParams.topMargin + this.oI.top, localLayoutParams.bottomMargin + this.oI.bottom));
  }
  
  private View eu()
  {
    int i = getChildCount() - 1;
    BitSet localBitSet = new BitSet(this.rS);
    localBitSet.set(0, this.rS, true);
    int j;
    int k;
    label57:
    int m;
    label65:
    int n;
    View localView;
    StaggeredGridLayoutManager.LayoutParams localLayoutParams;
    Object localObject;
    if ((this.sj == 1) && (cS()))
    {
      j = 1;
      if (!this.so) {
        break label151;
      }
      k = -1;
      if (i >= k) {
        break label166;
      }
      m = 1;
      n = i;
      if (n == k) {
        break label397;
      }
      localView = getChildAt(n);
      localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
      if (!localBitSet.get(localLayoutParams.vN.ac)) {
        break label210;
      }
      localObject = localLayoutParams.vN;
      if (!this.so) {
        break label172;
      }
      if (((ar)localObject).eB() >= this.vv.db()) {
        break label192;
      }
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {
        break label197;
      }
      return localView;
      j = -1;
      break;
      label151:
      k = 0;
      m = i + 1;
      i = k;
      k = m;
      break label57;
      label166:
      m = -1;
      break label65;
      label172:
      if (((ar)localObject).ez() > this.vv.da()) {
        i = 1;
      } else {
        label192:
        i = 0;
      }
    }
    label197:
    localBitSet.clear(localLayoutParams.vN.ac);
    label210:
    int i1;
    if ((!localLayoutParams.vO) && (n + m != k))
    {
      localObject = getChildAt(n + m);
      if (this.so)
      {
        i = this.vv.af(localView);
        i1 = this.vv.af((View)localObject);
        if (i < i1) {
          return localView;
        }
        if (i != i1) {
          break label399;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
        if (localLayoutParams.vN.ac - ((StaggeredGridLayoutManager.LayoutParams)localObject).vN.ac < 0)
        {
          i = 1;
          label319:
          if (j >= 0) {
            break label381;
          }
        }
        label381:
        for (i1 = 1;; i1 = 0)
        {
          if (i == i1) {
            break label387;
          }
          return localView;
          i = this.vv.ae(localView);
          i1 = this.vv.ae((View)localObject);
          if (i > i1) {
            return localView;
          }
          if (i != i1) {
            break label399;
          }
          i = 1;
          break;
          i = 0;
          break label319;
        }
      }
      label387:
      n += m;
      break;
      label397:
      return null;
      label399:
      i = 0;
    }
  }
  
  private void ev()
  {
    if (this.vv == null)
    {
      this.vv = s.a(this, this.sj);
      this.vw = s.a(this, 1 - this.sj);
      this.vy = new l();
    }
  }
  
  private int ew()
  {
    int i = getChildCount();
    if (i == 0) {
      return 0;
    }
    return ao(getChildAt(i - 1));
  }
  
  private int ex()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    return ao(getChildAt(0));
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
  
  private int h(ak paramak)
  {
    boolean bool2 = true;
    if (getChildCount() == 0) {
      return 0;
    }
    ev();
    s locals = this.vv;
    View localView;
    if (!this.sq)
    {
      bool1 = true;
      localView = q(bool1);
      if (this.sq) {
        break label74;
      }
    }
    label74:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ap.a(paramak, locals, localView, r(bool1), this, this.sq, this.so);
      bool1 = false;
      break;
    }
  }
  
  private void h(int paramInt1, int paramInt2, int paramInt3)
  {
    int k;
    int j;
    int i;
    if (this.so)
    {
      k = ew();
      if (paramInt3 != 3) {
        break label100;
      }
      if (paramInt1 >= paramInt2) {
        break label89;
      }
      j = paramInt2 + 1;
      i = paramInt1;
      label31:
      this.vA.aE(i);
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
      k = ex();
      break;
      label89:
      j = paramInt1 + 1;
      i = paramInt2;
      break label31;
      label100:
      j = paramInt1 + paramInt2;
      i = paramInt1;
      break label31;
      this.vA.J(paramInt1, paramInt2);
      break label72;
      this.vA.I(paramInt1, paramInt2);
      break label72;
      this.vA.I(paramInt1, 1);
      this.vA.J(paramInt2, 1);
      break label72;
      if (this.so) {}
      for (paramInt1 = ex(); i <= paramInt1; paramInt1 = ew())
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
    ev();
    s locals = this.vv;
    View localView;
    if (!this.sq)
    {
      bool1 = true;
      localView = q(bool1);
      if (this.sq) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ap.a(paramak, locals, localView, r(bool1), this, this.sq);
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
    ev();
    s locals = this.vv;
    View localView;
    if (!this.sq)
    {
      bool1 = true;
      localView = q(bool1);
      if (this.sq) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return ap.b(paramak, locals, localView, r(bool1), this, this.sq);
      bool1 = false;
      break;
    }
  }
  
  private View q(boolean paramBoolean)
  {
    ev();
    int j = this.vv.da();
    int k = this.vv.db();
    int m = getChildCount();
    Object localObject = null;
    int i = 0;
    if (i < m)
    {
      View localView = getChildAt(i);
      int n = this.vv.ae(localView);
      if ((this.vv.af(localView) <= j) || (n >= k)) {
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
  
  private View r(boolean paramBoolean)
  {
    ev();
    int j = this.vv.da();
    int k = this.vv.db();
    Object localObject = null;
    int i = getChildCount() - 1;
    if (i >= 0)
    {
      View localView = getChildAt(i);
      int m = this.vv.ae(localView);
      int n = this.vv.af(localView);
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
    if (this.sj == 0) {
      return this.rS;
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
      public final PointF ah(int paramAnonymousInt)
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
    paramRecyclerView.aw(paramInt);
    a(paramRecyclerView);
  }
  
  public final void a(RecyclerView paramRecyclerView, af paramaf)
  {
    removeCallbacks(this.vK);
    int i = 0;
    while (i < this.rS)
    {
      this.vu[i].clear();
      i += 1;
    }
  }
  
  public final void a(af paramaf, ak paramak, View paramView, e parame)
  {
    int i = 1;
    paramaf = paramView.getLayoutParams();
    if (!(paramaf instanceof StaggeredGridLayoutManager.LayoutParams))
    {
      super.b(paramView, parame);
      return;
    }
    paramaf = (StaggeredGridLayoutManager.LayoutParams)paramaf;
    int k;
    int m;
    int j;
    if (this.sj == 0)
    {
      k = paramaf.cM();
      if (paramaf.vO) {
        i = this.rS;
      }
      int n = -1;
      m = -1;
      j = i;
      i = n;
    }
    for (;;)
    {
      parame.p(q.a(k, j, m, i, paramaf.vO));
      return;
      m = paramaf.cM();
      if (paramaf.vO)
      {
        i = this.rS;
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
  
  public final void ag(int paramInt)
  {
    if ((this.vE != null) && (this.vE.sK != paramInt))
    {
      StaggeredGridLayoutManager.SavedState localSavedState = this.vE;
      localSavedState.vV = null;
      localSavedState.vU = 0;
      localSavedState.sK = -1;
      localSavedState.vT = -1;
    }
    this.sr = paramInt;
    this.ss = -2147483648;
    requestLayout();
  }
  
  public final void am(int paramInt)
  {
    super.am(paramInt);
    int i = 0;
    while (i < this.rS)
    {
      this.vu[i].aL(paramInt);
      i += 1;
    }
  }
  
  public final void an(int paramInt)
  {
    super.an(paramInt);
    int i = 0;
    while (i < this.rS)
    {
      this.vu[i].aL(paramInt);
      i += 1;
    }
  }
  
  public final void ao(int paramInt)
  {
    if ((paramInt != 0) || (getChildCount() == 0) || (this.vB == 0) || (!isAttachedToWindow())) {
      return;
    }
    int i;
    if (this.so)
    {
      i = ew();
      paramInt = ex();
      label43:
      if ((i != 0) || (eu() == null)) {
        break label83;
      }
      this.vA.clear();
    }
    for (;;)
    {
      dQ();
      requestLayout();
      return;
      i = ex();
      paramInt = ew();
      break label43;
      label83:
      if (!this.vJ) {
        break;
      }
      if (this.so) {}
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem1;
      for (int j = -1;; j = 1)
      {
        localFullSpanItem1 = this.vA.i(i, paramInt + 1, j);
        if (localFullSpanItem1 != null) {
          break;
        }
        this.vJ = false;
        this.vA.aD(paramInt + 1);
        return;
      }
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem2 = this.vA.i(i, localFullSpanItem1.sx, j * -1);
      if (localFullSpanItem2 == null) {
        this.vA.aD(localFullSpanItem1.sx);
      } else {
        this.vA.aD(localFullSpanItem2.sx + 1);
      }
    }
  }
  
  public final int b(int paramInt, af paramaf, ak paramak)
  {
    return c(paramInt, paramaf, paramak);
  }
  
  public final int b(af paramaf, ak paramak)
  {
    if (this.sj == 1) {
      return this.rS;
    }
    return super.b(paramaf, paramak);
  }
  
  public final int b(ak paramak)
  {
    return h(paramak);
  }
  
  public final int c(ak paramak)
  {
    return h(paramak);
  }
  
  public final void c(af paramaf, ak paramak)
  {
    int m = 1;
    ev();
    aq localaq = this.vI;
    localaq.sx = -1;
    localaq.jp = -2147483648;
    localaq.sz = false;
    localaq.vM = false;
    if (((this.vE != null) || (this.sr != -1)) && (paramak.getItemCount() == 0))
    {
      d(paramaf);
      return;
    }
    int k;
    label182:
    Object localObject;
    boolean bool;
    if (this.vE != null)
    {
      if (this.vE.vU > 0) {
        if (this.vE.vU == this.rS)
        {
          j = 0;
          if (j < this.rS)
          {
            this.vu[j].clear();
            k = this.vE.vV[j];
            i = k;
            if (k != -2147483648) {
              if (!this.vE.sM) {
                break label182;
              }
            }
            for (i = k + this.vv.db();; i = k + this.vv.da())
            {
              this.vu[j].aK(i);
              j += 1;
              break;
            }
          }
        }
        else
        {
          localObject = this.vE;
          ((StaggeredGridLayoutManager.SavedState)localObject).vV = null;
          ((StaggeredGridLayoutManager.SavedState)localObject).vU = 0;
          ((StaggeredGridLayoutManager.SavedState)localObject).vW = 0;
          ((StaggeredGridLayoutManager.SavedState)localObject).vX = null;
          ((StaggeredGridLayoutManager.SavedState)localObject).vP = null;
          this.vE.sK = this.vE.vT;
        }
      }
      this.vD = this.vE.vD;
      bool = this.vE.sn;
      f(null);
      if ((this.vE != null) && (this.vE.sn != bool)) {
        this.vE.sn = bool;
      }
      this.sn = bool;
      requestLayout();
      cR();
      if (this.vE.sK != -1)
      {
        this.sr = this.vE.sK;
        localaq.sz = this.vE.sM;
        if (this.vE.vW > 1)
        {
          this.vA.mData = this.vE.vX;
          this.vA.vP = this.vE.vP;
        }
        label386:
        if ((!paramak.dY()) && (this.sr != -1)) {
          break label622;
        }
        i = 0;
        label403:
        if (i == 0)
        {
          if (!this.vC) {
            break label1117;
          }
          k = paramak.getItemCount();
          i = getChildCount() - 1;
          label427:
          if (i < 0) {
            break label1112;
          }
          j = ao(getChildAt(i));
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
      localaq.sx = i;
      localaq.jp = -2147483648;
      if ((this.vE == null) && ((localaq.sz != this.vC) || (cS() != this.vD)))
      {
        this.vA.clear();
        localaq.vM = true;
      }
      if ((getChildCount() <= 0) || ((this.vE != null) && (this.vE.vU > 0))) {
        break label1330;
      }
      if (!localaq.vM) {
        break label1179;
      }
      i = 0;
      while (i < this.rS)
      {
        this.vu[i].clear();
        if (localaq.jp != -2147483648) {
          this.vu[i].aK(localaq.jp);
        }
        i += 1;
      }
      localaq.sz = this.so;
      break;
      cR();
      localaq.sz = this.so;
      break label386;
      if ((this.sr < 0) || (this.sr >= paramak.getItemCount()))
      {
        this.sr = -1;
        this.ss = -2147483648;
        i = 0;
        break label403;
      }
      if ((this.vE == null) || (this.vE.sK == -1) || (this.vE.vU <= 0))
      {
        localObject = af(this.sr);
        if (localObject != null)
        {
          if (this.so)
          {
            i = ew();
            label711:
            localaq.sx = i;
            if (this.ss == -2147483648) {
              break label804;
            }
            if (!localaq.sz) {
              break label774;
            }
          }
          label774:
          for (localaq.jp = (this.vv.db() - this.ss - this.vv.af((View)localObject));; localaq.jp = (this.vv.da() + this.ss - this.vv.ae((View)localObject)))
          {
            i = 1;
            break;
            i = ex();
            break label711;
          }
          label804:
          if (this.vv.ag((View)localObject) > this.vv.dc()) {
            if (localaq.sz)
            {
              i = this.vv.db();
              label839:
              localaq.jp = i;
            }
          }
        }
      }
      for (;;)
      {
        i = 1;
        break;
        i = this.vv.da();
        break label839;
        i = this.vv.ae((View)localObject) - this.vv.da();
        if (i < 0)
        {
          localaq.jp = (-i);
        }
        else
        {
          i = this.vv.db() - this.vv.af((View)localObject);
          if (i < 0)
          {
            localaq.jp = i;
          }
          else
          {
            localaq.jp = -2147483648;
            continue;
            localaq.sx = this.sr;
            if (this.ss == -2147483648) {
              if (aC(localaq.sx) == 1)
              {
                bool = true;
                label968:
                localaq.sz = bool;
                if (!localaq.sz) {
                  break label1016;
                }
                i = localaq.vL.vv.db();
                label995:
                localaq.jp = i;
              }
            }
            for (;;)
            {
              localaq.vM = true;
              break;
              bool = false;
              break label968;
              i = localaq.vL.vv.da();
              break label995;
              i = this.ss;
              if (localaq.sz) {
                localaq.jp = (localaq.vL.vv.db() - i);
              } else {
                localaq.jp = (i + localaq.vL.vv.da());
              }
            }
            localaq.jp = -2147483648;
            localaq.sx = this.sr;
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
        k = ao(getChildAt(j));
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
    if (j < this.rS)
    {
      localObject = this.vu[j];
      bool = this.so;
      n = localaq.jp;
      if (bool)
      {
        i = ((ar)localObject).aJ(-2147483648);
        label1226:
        ((ar)localObject).clear();
        if ((i != -2147483648) && ((!bool) || (i >= ((ar)localObject).vL.vv.db())) && ((bool) || (i <= ((ar)localObject).vL.vv.da()))) {
          break label1297;
        }
      }
      for (;;)
      {
        j += 1;
        break;
        i = ((ar)localObject).aI(-2147483648);
        break label1226;
        label1297:
        k = i;
        if (n != -2147483648) {
          k = i + n;
        }
        ((ar)localObject).wa = k;
        ((ar)localObject).vZ = k;
      }
    }
    label1330:
    b(paramaf);
    this.vJ = false;
    this.vx = (this.vw.dc() / this.rS);
    this.vF = View.MeasureSpec.makeMeasureSpec(this.vw.dc(), 1073741824);
    if (this.sj == 1)
    {
      this.vG = View.MeasureSpec.makeMeasureSpec(this.vx, 1073741824);
      this.vH = View.MeasureSpec.makeMeasureSpec(0, 0);
      a(localaq.sx, paramak);
      if (!localaq.sz) {
        break label1633;
      }
      az(-1);
      a(paramaf, this.vy, paramak);
      az(1);
      this.vy.se = (localaq.sx + this.vy.sf);
      a(paramaf, this.vy, paramak);
      label1472:
      if (getChildCount() > 0)
      {
        if (!this.so) {
          break label1688;
        }
        a(paramaf, paramak, true);
        b(paramaf, paramak, false);
      }
      label1500:
      if (!paramak.dY())
      {
        if ((this.vB == 0) || (getChildCount() <= 0)) {
          break label1705;
        }
        i = m;
        if (!this.vJ) {
          if (eu() == null) {
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
        removeCallbacks(this.vK);
        paramaf = this.vK;
        if (this.uk != null) {
          r.b(this.uk, paramaf);
        }
      }
      this.sr = -1;
      this.ss = -2147483648;
      this.vC = localaq.sz;
      this.vD = cS();
      this.vE = null;
      return;
      this.vH = View.MeasureSpec.makeMeasureSpec(this.vx, 1073741824);
      this.vG = View.MeasureSpec.makeMeasureSpec(0, 0);
      break;
      label1633:
      az(1);
      a(paramaf, this.vy, paramak);
      az(-1);
      this.vy.se = (localaq.sx + this.vy.sf);
      a(paramaf, this.vy, paramak);
      break label1472;
      b(paramaf, paramak, true);
      a(paramaf, paramak, false);
      break label1500;
    }
  }
  
  public final void cJ()
  {
    this.vA.clear();
    requestLayout();
  }
  
  public final RecyclerView.LayoutParams cK()
  {
    return new StaggeredGridLayoutManager.LayoutParams();
  }
  
  public final boolean cL()
  {
    return this.vE == null;
  }
  
  public final boolean cP()
  {
    return this.sj == 0;
  }
  
  public final boolean cQ()
  {
    return this.sj == 1;
  }
  
  public final int d(ak paramak)
  {
    return i(paramak);
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
    if (this.vE == null) {
      super.f(paramString);
    }
  }
  
  public final int g(ak paramak)
  {
    return j(paramak);
  }
  
  public final void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    View localView1;
    View localView2;
    if (getChildCount() > 0)
    {
      paramAccessibilityEvent = a.a(paramAccessibilityEvent);
      localView1 = q(false);
      localView2 = r(false);
      if ((localView1 != null) && (localView2 != null)) {}
    }
    else
    {
      return;
    }
    int i = ao(localView1);
    int j = ao(localView2);
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
      this.vE = ((StaggeredGridLayoutManager.SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public final Parcelable onSaveInstanceState()
  {
    if (this.vE != null) {
      return new StaggeredGridLayoutManager.SavedState(this.vE);
    }
    StaggeredGridLayoutManager.SavedState localSavedState = new StaggeredGridLayoutManager.SavedState();
    localSavedState.sn = this.sn;
    localSavedState.sM = this.vC;
    localSavedState.vD = this.vD;
    int i;
    label130:
    View localView;
    label150:
    label157:
    int j;
    label185:
    int k;
    if ((this.vA != null) && (this.vA.mData != null))
    {
      localSavedState.vX = this.vA.mData;
      localSavedState.vW = localSavedState.vX.length;
      localSavedState.vP = this.vA.vP;
      if (getChildCount() <= 0) {
        break label314;
      }
      ev();
      if (!this.vC) {
        break label254;
      }
      i = ew();
      localSavedState.sK = i;
      if (!this.so) {
        break label262;
      }
      localView = r(true);
      if (localView != null) {
        break label272;
      }
      i = -1;
      localSavedState.vT = i;
      localSavedState.vU = this.rS;
      localSavedState.vV = new int[this.rS];
      j = 0;
      if (j >= this.rS) {
        break label332;
      }
      if (!this.vC) {
        break label281;
      }
      k = this.vu[j].aJ(-2147483648);
      i = k;
      if (k != -2147483648) {
        i = k - this.vv.db();
      }
    }
    for (;;)
    {
      localSavedState.vV[j] = i;
      j += 1;
      break label185;
      localSavedState.vW = 0;
      break;
      label254:
      i = ex();
      break label130;
      label262:
      localView = q(true);
      break label150;
      label272:
      i = ao(localView);
      break label157;
      label281:
      k = this.vu[j].aI(-2147483648);
      i = k;
      if (k != -2147483648) {
        i = k - this.vv.da();
      }
    }
    label314:
    localSavedState.sK = -1;
    localSavedState.vT = -1;
    localSavedState.vU = 0;
    label332:
    return localSavedState;
  }
  
  public final void q(int paramInt1, int paramInt2)
  {
    h(paramInt1, paramInt2, 0);
  }
  
  public final void r(int paramInt1, int paramInt2)
  {
    h(paramInt1, paramInt2, 1);
  }
  
  public final void s(int paramInt1, int paramInt2)
  {
    h(paramInt1, paramInt2, 2);
  }
  
  public final void t(int paramInt1, int paramInt2)
  {
    h(paramInt1, paramInt2, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */