package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.a.e;
import android.support.v4.view.a.q;
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
  static final int rQ = View.MeasureSpec.makeMeasureSpec(0, 0);
  boolean rR;
  int rS;
  int[] rT;
  View[] rU;
  final SparseIntArray rV;
  final SparseIntArray rW;
  k rX;
  final Rect rY;
  
  private int a(af paramaf, ak paramak, int paramInt)
  {
    if (!paramak.dY()) {
      return this.rX.w(paramInt, this.rS);
    }
    int i = paramaf.as(paramInt);
    if (i == -1)
    {
      Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + paramInt);
      return 0;
    }
    return this.rX.w(i, this.rS);
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
      if ((this.sj != 1) || (!cS())) {
        break label159;
      }
      n = this.rS - 1;
      m = -1;
      i = paramInt;
      paramInt = n;
      if (i == k) {
        return;
      }
      View localView = this.rU[i];
      localLayoutParams = (GridLayoutManager.LayoutParams)localView.getLayoutParams();
      GridLayoutManager.LayoutParams.a(localLayoutParams, c(paramaf, paramak, ao(localView)));
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
    b(paramView, this.rY);
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i;
    if (!paramBoolean)
    {
      i = paramInt1;
      if (this.sj != 1) {}
    }
    else
    {
      i = f(paramInt1, localLayoutParams.leftMargin + this.rY.left, localLayoutParams.rightMargin + this.rY.right);
    }
    if (!paramBoolean)
    {
      paramInt1 = paramInt2;
      if (this.sj != 0) {}
    }
    else
    {
      paramInt1 = f(paramInt2, localLayoutParams.topMargin + this.rY.top, localLayoutParams.bottomMargin + this.rY.bottom);
    }
    paramView.measure(i, paramInt1);
  }
  
  private static int ae(int paramInt)
  {
    if (paramInt < 0) {
      return rQ;
    }
    return View.MeasureSpec.makeMeasureSpec(paramInt, 1073741824);
  }
  
  private int b(af paramaf, ak paramak, int paramInt)
  {
    if (!paramak.dY()) {
      i = this.rX.u(paramInt, this.rS);
    }
    int j;
    do
    {
      return i;
      j = this.rW.get(paramInt, -1);
      i = j;
    } while (j != -1);
    int i = paramaf.as(paramInt);
    if (i == -1)
    {
      Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + paramInt);
      return 0;
    }
    return this.rX.u(i, this.rS);
  }
  
  private int c(af paramaf, ak paramak, int paramInt)
  {
    int i;
    if (!paramak.dY()) {
      i = this.rX.cO();
    }
    int j;
    do
    {
      return i;
      j = this.rV.get(paramInt, -1);
      i = j;
    } while (j != -1);
    if (paramaf.as(paramInt) == -1)
    {
      Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + paramInt);
      return 1;
    }
    return this.rX.cO();
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
    if (this.sj == 0) {
      return this.rS;
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
    cT();
    int j = this.sl.da();
    int k = this.sl.db();
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
      int m = ao(localView);
      if ((m < 0) || (m >= paramInt3) || (b(paramaf, paramak, m) != 0)) {
        break label179;
      }
      if (!((RecyclerView.LayoutParams)localView.getLayoutParams()).uo.isRemoved()) {
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
      if (this.sl.ae(localView) < k)
      {
        localObject3 = localView;
        if (this.sl.af(localView) >= j) {}
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
    if (this.sj == 1)
    {
      i = getWidth() - getPaddingRight() - getPaddingLeft();
      if ((this.rT == null) || (this.rT.length != this.rS + 1) || (this.rT[(this.rT.length - 1)] != i)) {
        this.rT = new int[this.rS + 1];
      }
      this.rT[0] = 0;
      n = i / this.rS;
      int i1 = i % this.rS;
      j = 1;
      i = 0;
      k = 0;
      if (j > this.rS) {
        break label207;
      }
      i += i1;
      if ((i <= 0) || (this.rS - i >= i1)) {
        break label301;
      }
      m = n + 1;
      i -= this.rS;
    }
    for (;;)
    {
      k += m;
      this.rT[j] = k;
      j += 1;
      break label115;
      i = getHeight() - getPaddingBottom() - getPaddingTop();
      break;
      label207:
      if ((paramak.getItemCount() > 0) && (!paramak.dY())) {
        for (i = b(paramaf, paramak, paramm.sx); (i > 0) && (paramm.sx > 0); i = b(paramaf, paramak, paramm.sx)) {
          paramm.sx -= 1;
        }
      }
      if ((this.rU == null) || (this.rU.length != this.rS)) {
        this.rU = new View[this.rS];
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
    if (paramo.sf == 1)
    {
      bool = true;
      j = 0;
      i = this.rS;
      n = j;
      if (!bool)
      {
        i = b(paramaf, paramak, paramo.se) + c(paramaf, paramak, paramo.se);
        n = j;
      }
    }
    int k;
    for (;;)
    {
      if ((n >= this.rS) || (!paramo.k(paramak)) || (i <= 0)) {
        break label207;
      }
      j = paramo.se;
      k = c(paramaf, paramak, j);
      if (k > this.rS)
      {
        throw new IllegalArgumentException("Item at position " + j + " requires " + k + " spans but GridLayoutManager has only " + this.rS + " spans.");
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
      this.rU[n] = localView;
      n += 1;
    }
    label207:
    if (n == 0)
    {
      paramn.sB = true;
      return;
    }
    int i = 0;
    a(paramaf, paramak, n, bool);
    int j = 0;
    if (j < n)
    {
      paramaf = this.rU[j];
      if (paramo.sJ == null) {
        if (bool)
        {
          addView(paramaf);
          label267:
          paramak = (GridLayoutManager.LayoutParams)paramaf.getLayoutParams();
          k = View.MeasureSpec.makeMeasureSpec(this.rT[(GridLayoutManager.LayoutParams.a(paramak) + GridLayoutManager.LayoutParams.b(paramak))] - this.rT[GridLayoutManager.LayoutParams.a(paramak)], 1073741824);
          if (this.sj != 1) {
            break label390;
          }
          a(paramaf, k, ae(paramak.height), false);
          label329:
          k = this.sl.ag(paramaf);
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
        an(paramaf);
        break label267;
      }
      k(paramaf, 0);
      break label267;
      a(paramaf, ae(paramak.width), k, false);
      break label329;
      k = ae(i);
      j = 0;
      if (j < n)
      {
        paramaf = this.rU[j];
        if (this.sl.ag(paramaf) != i)
        {
          paramak = (GridLayoutManager.LayoutParams)paramaf.getLayoutParams();
          m = View.MeasureSpec.makeMeasureSpec(this.rT[(GridLayoutManager.LayoutParams.a(paramak) + GridLayoutManager.LayoutParams.b(paramak))] - this.rT[GridLayoutManager.LayoutParams.a(paramak)], 1073741824);
          if (this.sj != 1) {
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
      paramn.sA = i;
      j = 0;
      int m = 0;
      k = 0;
      int i2;
      int i1;
      if (this.sj == 1) {
        if (paramo.sg == -1)
        {
          k = paramo.jp;
          i = k - i;
          i2 = 0;
          i1 = m;
          m = i2;
          if (m >= n) {
            break label853;
          }
          paramaf = this.rU[m];
          paramak = (GridLayoutManager.LayoutParams)paramaf.getLayoutParams();
          if (this.sj != 1) {
            break label813;
          }
          i2 = getPaddingLeft() + this.rT[GridLayoutManager.LayoutParams.a(paramak)];
          i1 = this.sl.ah(paramaf);
          j = k;
          i1 = i2 + i1;
          k = i2;
        }
      }
      for (;;)
      {
        b(paramaf, paramak.leftMargin + k, paramak.topMargin + i, i1 - paramak.rightMargin, j - paramak.bottomMargin);
        if ((paramak.uo.isRemoved()) || (paramak.uo.eo())) {
          paramn.sC = true;
        }
        paramn.sD |= paramaf.isFocusable();
        i2 = j;
        m += 1;
        j = k;
        k = i2;
        break label581;
        i1 = paramo.jp;
        k = i1 + i;
        i = i1;
        break;
        if (paramo.sg == -1)
        {
          m = paramo.jp;
          j = m - i;
          i = 0;
          break;
        }
        j = paramo.jp;
        m = j + i;
        i = 0;
        break;
        i = getPaddingTop() + this.rT[GridLayoutManager.LayoutParams.a(paramak)];
        i2 = i + this.sl.ah(paramaf);
        k = j;
        j = i2;
      }
      Arrays.fill(this.rU, null);
      return;
    }
  }
  
  public final void a(af paramaf, ak paramak, View paramView, e parame)
  {
    boolean bool2 = false;
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (!(localLayoutParams instanceof GridLayoutManager.LayoutParams))
    {
      super.b(paramView, parame);
      return;
    }
    paramView = (GridLayoutManager.LayoutParams)localLayoutParams;
    int i = a(paramaf, paramak, paramView.uo.eg());
    if (this.sj == 0)
    {
      j = paramView.cM();
      k = paramView.cN();
      if ((this.rS > 1) && (paramView.cN() == this.rS)) {}
      for (bool1 = true;; bool1 = false)
      {
        parame.p(q.a(j, k, i, 1, bool1));
        return;
      }
    }
    int j = paramView.cM();
    int k = paramView.cN();
    boolean bool1 = bool2;
    if (this.rS > 1)
    {
      bool1 = bool2;
      if (paramView.cN() == this.rS) {
        bool1 = true;
      }
    }
    parame.p(q.a(i, 1, j, k, bool1));
  }
  
  public final boolean a(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof GridLayoutManager.LayoutParams;
  }
  
  public final int b(af paramaf, ak paramak)
  {
    if (this.sj == 1) {
      return this.rS;
    }
    if (paramak.getItemCount() <= 0) {
      return 0;
    }
    return a(paramaf, paramak, paramak.getItemCount() - 1);
  }
  
  public final void c(af paramaf, ak paramak)
  {
    if (paramak.dY())
    {
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        GridLayoutManager.LayoutParams localLayoutParams = (GridLayoutManager.LayoutParams)getChildAt(i).getLayoutParams();
        int k = localLayoutParams.uo.eg();
        this.rV.put(k, localLayoutParams.cN());
        this.rW.put(k, localLayoutParams.cM());
        i += 1;
      }
    }
    super.c(paramaf, paramak);
    this.rV.clear();
    this.rW.clear();
    if (!paramak.dY()) {
      this.rR = false;
    }
  }
  
  public final void cJ()
  {
    this.rX.sb.clear();
  }
  
  public final RecyclerView.LayoutParams cK()
  {
    return new GridLayoutManager.LayoutParams();
  }
  
  public final boolean cL()
  {
    return (this.su == null) && (!this.rR);
  }
  
  public final void q(int paramInt1, int paramInt2)
  {
    this.rX.sb.clear();
  }
  
  public final void r(int paramInt1, int paramInt2)
  {
    this.rX.sb.clear();
  }
  
  public final void s(int paramInt1, int paramInt2)
  {
    this.rX.sb.clear();
  }
  
  public final void t(int paramInt1, int paramInt2)
  {
    this.rX.sb.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.GridLayoutManager
 * JD-Core Version:    0.7.0.1
 */