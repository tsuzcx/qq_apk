package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.a.b;
import android.support.v4.view.a.e;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public final class GridLayoutManager
  extends LinearLayoutManager
{
  static final int tG = View.MeasureSpec.makeMeasureSpec(0, 0);
  boolean tH;
  int tI;
  int[] tJ;
  View[] tK;
  final SparseIntArray tL;
  final SparseIntArray tM;
  k tN;
  final Rect tO;
  
  private int a(af paramaf, ak paramak, int paramInt)
  {
    if (!paramak.em()) {
      return this.tN.x(paramInt, this.tI);
    }
    int i = paramaf.aE(paramInt);
    if (i == -1)
    {
      Log.w("GridLayoutManager", "Cannot find span size for pre layout position. ".concat(String.valueOf(paramInt)));
      return 0;
    }
    return this.tN.x(i, this.tI);
  }
  
  private void a(af paramaf, ak paramak, int paramInt, boolean paramBoolean)
  {
    int m = 0;
    int j;
    int i;
    int k;
    int n;
    label52:
    GridLayoutManager.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      j = 1;
      i = 0;
      k = paramInt;
      paramInt = i;
      if ((this.tZ != 1) || (!da())) {
        break label159;
      }
      n = this.tI - 1;
      m = -1;
      i = paramInt;
      paramInt = n;
      if (i == k) {
        return;
      }
      View localView = this.tK[i];
      localLayoutParams = (GridLayoutManager.LayoutParams)localView.getLayoutParams();
      GridLayoutManager.LayoutParams.a(localLayoutParams, c(paramaf, paramak, av(localView)));
      if ((m != -1) || (GridLayoutManager.LayoutParams.b(localLayoutParams) <= 1)) {
        break label175;
      }
      GridLayoutManager.LayoutParams.b(localLayoutParams, paramInt - (GridLayoutManager.LayoutParams.b(localLayoutParams) - 1));
    }
    for (;;)
    {
      paramInt += GridLayoutManager.LayoutParams.b(localLayoutParams) * m;
      i += j;
      break label52;
      paramInt -= 1;
      j = -1;
      k = -1;
      break;
      label159:
      i = paramInt;
      n = 1;
      paramInt = m;
      m = n;
      break label52;
      label175:
      GridLayoutManager.LayoutParams.b(localLayoutParams, paramInt);
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    b(paramView, this.tO);
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i;
    if (!paramBoolean)
    {
      i = paramInt1;
      if (this.tZ != 1) {}
    }
    else
    {
      i = f(paramInt1, localLayoutParams.leftMargin + this.tO.left, localLayoutParams.rightMargin + this.tO.right);
    }
    if (!paramBoolean)
    {
      paramInt1 = paramInt2;
      if (this.tZ != 0) {}
    }
    else
    {
      paramInt1 = f(paramInt2, localLayoutParams.topMargin + this.tO.top, localLayoutParams.bottomMargin + this.tO.bottom);
    }
    paramView.measure(i, paramInt1);
  }
  
  private static int ap(int paramInt)
  {
    if (paramInt < 0) {
      return tG;
    }
    return View.MeasureSpec.makeMeasureSpec(paramInt, 1073741824);
  }
  
  private int b(af paramaf, ak paramak, int paramInt)
  {
    if (!paramak.em()) {
      i = this.tN.v(paramInt, this.tI);
    }
    int j;
    do
    {
      return i;
      j = this.tM.get(paramInt, -1);
      i = j;
    } while (j != -1);
    int i = paramaf.aE(paramInt);
    if (i == -1)
    {
      Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:".concat(String.valueOf(paramInt)));
      return 0;
    }
    return this.tN.v(i, this.tI);
  }
  
  private int c(af paramaf, ak paramak, int paramInt)
  {
    int i;
    if (!paramak.em()) {
      i = this.tN.cW();
    }
    int j;
    do
    {
      return i;
      j = this.tL.get(paramInt, -1);
      i = j;
    } while (j != -1);
    if (paramaf.aE(paramInt) == -1)
    {
      Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:".concat(String.valueOf(paramInt)));
      return 1;
    }
    return this.tN.cW();
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
  
  public final int a(af paramaf, ak paramak)
  {
    if (this.tZ == 0) {
      return this.tI;
    }
    if (paramak.getItemCount() <= 0) {
      return 0;
    }
    return a(paramaf, paramak, paramak.getItemCount() - 1);
  }
  
  public final RecyclerView.LayoutParams a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new GridLayoutManager.LayoutParams(paramContext, paramAttributeSet);
  }
  
  public final RecyclerView.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new GridLayoutManager.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new GridLayoutManager.LayoutParams(paramLayoutParams);
  }
  
  final View a(af paramaf, ak paramak, int paramInt1, int paramInt2, int paramInt3)
  {
    db();
    int j = this.ub.dj();
    int k = this.ub.dk();
    int i;
    Object localObject1;
    Object localObject2;
    label37:
    View localView;
    if (paramInt2 > paramInt1)
    {
      i = 1;
      localObject1 = null;
      localObject2 = null;
      if (paramInt1 == paramInt2) {
        break label164;
      }
      localView = getChildAt(paramInt1);
      int m = av(localView);
      if ((m < 0) || (m >= paramInt3) || (b(paramaf, paramak, m) != 0)) {
        break label179;
      }
      if (!((RecyclerView.LayoutParams)localView.getLayoutParams()).wd.isRemoved()) {
        break label120;
      }
      if (localObject2 != null) {
        break label179;
      }
      localObject2 = localView;
    }
    label164:
    label176:
    label179:
    for (;;)
    {
      paramInt1 += i;
      break label37;
      i = -1;
      break;
      label120:
      Object localObject3;
      if (this.ub.al(localView) < k)
      {
        localObject3 = localView;
        if (this.ub.am(localView) >= j) {}
      }
      else
      {
        if (localObject1 != null) {
          break label179;
        }
        localObject1 = localView;
        continue;
        if (localObject1 == null) {
          break label176;
        }
        localObject3 = localObject1;
      }
      return localObject3;
      return localObject2;
    }
  }
  
  final void a(af paramaf, ak paramak, m paramm)
  {
    super.a(paramaf, paramak, paramm);
    int i;
    int n;
    int j;
    int k;
    label115:
    int m;
    if (this.tZ == 1)
    {
      i = getWidth() - getPaddingRight() - getPaddingLeft();
      if ((this.tJ == null) || (this.tJ.length != this.tI + 1) || (this.tJ[(this.tJ.length - 1)] != i)) {
        this.tJ = new int[this.tI + 1];
      }
      this.tJ[0] = 0;
      n = i / this.tI;
      int i1 = i % this.tI;
      j = 1;
      i = 0;
      k = 0;
      if (j > this.tI) {
        break label207;
      }
      i += i1;
      if ((i <= 0) || (this.tI - i >= i1)) {
        break label301;
      }
      m = n + 1;
      i -= this.tI;
    }
    for (;;)
    {
      k += m;
      this.tJ[j] = k;
      j += 1;
      break label115;
      i = getHeight() - getPaddingBottom() - getPaddingTop();
      break;
      label207:
      if ((paramak.getItemCount() > 0) && (!paramak.em())) {
        for (i = b(paramaf, paramak, paramm.un); (i > 0) && (paramm.un > 0); i = b(paramaf, paramak, paramm.un)) {
          paramm.un -= 1;
        }
      }
      if ((this.tK == null) || (this.tK.length != this.tI)) {
        this.tK = new View[this.tI];
      }
      return;
      label301:
      m = n;
    }
  }
  
  final void a(af paramaf, ak paramak, o paramo, n paramn)
  {
    boolean bool;
    int n;
    if (paramo.tV == 1)
    {
      bool = true;
      j = 0;
      i = this.tI;
      n = j;
      if (!bool)
      {
        i = b(paramaf, paramak, paramo.tU) + c(paramaf, paramak, paramo.tU);
        n = j;
      }
    }
    int k;
    for (;;)
    {
      if ((n >= this.tI) || (!paramo.a(paramak)) || (i <= 0)) {
        break label207;
      }
      j = paramo.tU;
      k = c(paramaf, paramak, j);
      if (k > this.tI)
      {
        throw new IllegalArgumentException("Item at position " + j + " requires " + k + " spans but GridLayoutManager has only " + this.tI + " spans.");
        bool = false;
        break;
      }
      i -= k;
      if (i < 0) {
        break label207;
      }
      View localView = paramo.a(paramaf);
      if (localView == null) {
        break label207;
      }
      this.tK[n] = localView;
      n += 1;
    }
    label207:
    if (n == 0)
    {
      paramn.ur = true;
      return;
    }
    int i = 0;
    a(paramaf, paramak, n, bool);
    int j = 0;
    if (j < n)
    {
      paramaf = this.tK[j];
      if (paramo.uz == null) {
        if (bool)
        {
          addView(paramaf);
          label267:
          paramak = (GridLayoutManager.LayoutParams)paramaf.getLayoutParams();
          k = View.MeasureSpec.makeMeasureSpec(this.tJ[(GridLayoutManager.LayoutParams.a(paramak) + GridLayoutManager.LayoutParams.b(paramak))] - this.tJ[GridLayoutManager.LayoutParams.a(paramak)], 1073741824);
          if (this.tZ != 1) {
            break label390;
          }
          a(paramaf, k, ap(paramak.height), false);
          label329:
          k = this.ub.an(paramaf);
          if (k <= i) {
            break label862;
          }
          i = k;
        }
      }
    }
    label390:
    label581:
    label853:
    label862:
    for (;;)
    {
      j += 1;
      break;
      addView(paramaf, 0);
      break label267;
      if (bool)
      {
        au(paramaf);
        break label267;
      }
      n(paramaf, 0);
      break label267;
      a(paramaf, ap(paramak.width), k, false);
      break label329;
      k = ap(i);
      j = 0;
      if (j < n)
      {
        paramaf = this.tK[j];
        if (this.ub.an(paramaf) != i)
        {
          paramak = (GridLayoutManager.LayoutParams)paramaf.getLayoutParams();
          m = View.MeasureSpec.makeMeasureSpec(this.tJ[(GridLayoutManager.LayoutParams.a(paramak) + GridLayoutManager.LayoutParams.b(paramak))] - this.tJ[GridLayoutManager.LayoutParams.a(paramak)], 1073741824);
          if (this.tZ != 1) {
            break label512;
          }
          a(paramaf, m, k, true);
        }
        for (;;)
        {
          j += 1;
          break;
          a(paramaf, k, m, true);
        }
      }
      paramn.uq = i;
      j = 0;
      int m = 0;
      k = 0;
      int i2;
      int i1;
      if (this.tZ == 1) {
        if (paramo.tW == -1)
        {
          k = paramo.lm;
          i = k - i;
          i2 = 0;
          i1 = m;
          m = i2;
          if (m >= n) {
            break label853;
          }
          paramaf = this.tK[m];
          paramak = (GridLayoutManager.LayoutParams)paramaf.getLayoutParams();
          if (this.tZ != 1) {
            break label813;
          }
          i2 = getPaddingLeft() + this.tJ[GridLayoutManager.LayoutParams.a(paramak)];
          i1 = this.ub.ao(paramaf);
          j = k;
          i1 = i2 + i1;
          k = i2;
        }
      }
      for (;;)
      {
        c(paramaf, paramak.leftMargin + k, paramak.topMargin + i, i1 - paramak.rightMargin, j - paramak.bottomMargin);
        if ((paramak.wd.isRemoved()) || (paramak.wd.eD())) {
          paramn.us = true;
        }
        paramn.ut |= paramaf.isFocusable();
        i2 = j;
        m += 1;
        j = k;
        k = i2;
        break label581;
        i1 = paramo.lm;
        k = i1 + i;
        i = i1;
        break;
        if (paramo.tW == -1)
        {
          m = paramo.lm;
          j = m - i;
          i = 0;
          break;
        }
        j = paramo.lm;
        m = j + i;
        i = 0;
        break;
        i = getPaddingTop() + this.tJ[GridLayoutManager.LayoutParams.a(paramak)];
        i2 = i + this.ub.ao(paramaf);
        k = j;
        j = i2;
      }
      Arrays.fill(this.tK, null);
      return;
    }
  }
  
  public final void a(af paramaf, ak paramak, View paramView, b paramb)
  {
    boolean bool2 = false;
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (!(localLayoutParams instanceof GridLayoutManager.LayoutParams))
    {
      super.b(paramView, paramb);
      return;
    }
    paramView = (GridLayoutManager.LayoutParams)localLayoutParams;
    int i = a(paramaf, paramak, paramView.wd.ev());
    if (this.tZ == 0)
    {
      j = paramView.cU();
      k = paramView.cV();
      if ((this.tI > 1) && (paramView.cV() == this.tI)) {}
      for (bool1 = true;; bool1 = false)
      {
        paramb.w(e.a(j, k, i, 1, bool1));
        return;
      }
    }
    int j = paramView.cU();
    int k = paramView.cV();
    boolean bool1 = bool2;
    if (this.tI > 1)
    {
      bool1 = bool2;
      if (paramView.cV() == this.tI) {
        bool1 = true;
      }
    }
    paramb.w(e.a(i, 1, j, k, bool1));
  }
  
  public final boolean a(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof GridLayoutManager.LayoutParams;
  }
  
  public final int b(af paramaf, ak paramak)
  {
    if (this.tZ == 1) {
      return this.tI;
    }
    if (paramak.getItemCount() <= 0) {
      return 0;
    }
    return a(paramaf, paramak, paramak.getItemCount() - 1);
  }
  
  public final void c(af paramaf, ak paramak)
  {
    if (paramak.em())
    {
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        GridLayoutManager.LayoutParams localLayoutParams = (GridLayoutManager.LayoutParams)getChildAt(i).getLayoutParams();
        int k = localLayoutParams.wd.ev();
        this.tL.put(k, localLayoutParams.cV());
        this.tM.put(k, localLayoutParams.cU());
        i += 1;
      }
    }
    super.c(paramaf, paramak);
    this.tL.clear();
    this.tM.clear();
    if (!paramak.em()) {
      this.tH = false;
    }
  }
  
  public final void cR()
  {
    this.tN.tR.clear();
  }
  
  public final RecyclerView.LayoutParams cS()
  {
    return new GridLayoutManager.LayoutParams();
  }
  
  public final boolean cT()
  {
    return (this.uk == null) && (!this.tH);
  }
  
  public final void r(int paramInt1, int paramInt2)
  {
    this.tN.tR.clear();
  }
  
  public final void s(int paramInt1, int paramInt2)
  {
    this.tN.tR.clear();
  }
  
  public final void t(int paramInt1, int paramInt2)
  {
    this.tN.tR.clear();
  }
  
  public final void u(int paramInt1, int paramInt2)
  {
    this.tN.tR.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.GridLayoutManager
 * JD-Core Version:    0.7.0.1
 */