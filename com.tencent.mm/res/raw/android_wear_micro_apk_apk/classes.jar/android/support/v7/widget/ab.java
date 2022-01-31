package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.view.a.a;
import android.support.v4.view.a.aa;
import android.support.v4.view.a.q;
import android.support.v4.view.r;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;

public abstract class ab
{
  d tb;
  RecyclerView uk;
  ai ul;
  private boolean um = false;
  private boolean un = false;
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int j = 1073741824;
    int i = Math.max(0, paramInt1 - paramInt2);
    if (paramBoolean) {
      if (paramInt3 >= 0)
      {
        paramInt1 = paramInt3;
        paramInt2 = j;
      }
    }
    for (;;)
    {
      return View.MeasureSpec.makeMeasureSpec(paramInt1, paramInt2);
      paramInt2 = 0;
      paramInt1 = 0;
      continue;
      paramInt2 = j;
      paramInt1 = paramInt3;
      if (paramInt3 < 0) {
        if (paramInt3 == -1)
        {
          paramInt1 = i;
          paramInt2 = j;
        }
        else if (paramInt3 == -2)
        {
          paramInt2 = -2147483648;
          paramInt1 = i;
        }
        else
        {
          paramInt2 = 0;
          paramInt1 = 0;
        }
      }
    }
  }
  
  private void al(int paramInt)
  {
    getChildAt(paramInt);
    this.tb.detachViewFromParent(paramInt);
  }
  
  public static int ao(View paramView)
  {
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).uo.eg();
  }
  
  public static int ap(View paramView)
  {
    Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).rY;
    int i = paramView.getMeasuredWidth();
    int j = localRect.left;
    return localRect.right + (i + j);
  }
  
  public static int aq(View paramView)
  {
    Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).rY;
    int i = paramView.getMeasuredHeight();
    int j = localRect.top;
    return localRect.bottom + (i + j);
  }
  
  public static int ar(View paramView)
  {
    return paramView.getLeft() - ((RecyclerView.LayoutParams)paramView.getLayoutParams()).rY.left;
  }
  
  public static int as(View paramView)
  {
    return paramView.getTop() - ((RecyclerView.LayoutParams)paramView.getLayoutParams()).rY.top;
  }
  
  public static int at(View paramView)
  {
    int i = paramView.getRight();
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).rY.right + i;
  }
  
  public static int au(View paramView)
  {
    int i = paramView.getBottom();
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).rY.bottom + i;
  }
  
  public static void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).rY;
    paramView.layout(localRect.left + paramInt1, localRect.top + paramInt2, paramInt3 - localRect.right, paramInt4 - localRect.bottom);
  }
  
  private void b(View paramView, int paramInt, boolean paramBoolean)
  {
    an localan1 = RecyclerView.ai(paramView);
    RecyclerView.LayoutParams localLayoutParams1;
    if ((paramBoolean) || (localan1.isRemoved()))
    {
      this.uk.tM.aA(paramView);
      localLayoutParams1 = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      if ((!localan1.ej()) && (!localan1.eh())) {
        break label126;
      }
      if (!localan1.eh()) {
        break label118;
      }
      localan1.ei();
      label67:
      this.tb.a(paramView, paramInt, paramView.getLayoutParams(), false);
    }
    for (;;)
    {
      if (localLayoutParams1.uq)
      {
        localan1.ve.invalidate();
        localLayoutParams1.uq = false;
      }
      return;
      this.uk.tM.az(paramView);
      break;
      label118:
      localan1.ek();
      break label67;
      label126:
      if (paramView.getParent() == this.uk)
      {
        Object localObject = this.tb;
        int i = ((d)localObject).rh.indexOfChild(paramView);
        if (i == -1) {
          i = -1;
        }
        int j;
        for (;;)
        {
          j = paramInt;
          if (paramInt == -1) {
            j = this.tb.getChildCount();
          }
          if (i != -1) {
            break;
          }
          throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.uk.indexOfChild(paramView));
          if (((d)localObject).ri.get(i)) {
            i = -1;
          } else {
            i -= ((d)localObject).ri.ad(i);
          }
        }
        if (i != j)
        {
          paramView = RecyclerView.e(this.uk);
          localObject = paramView.getChildAt(i);
          if (localObject == null) {
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i);
          }
          paramView.al(i);
          RecyclerView.LayoutParams localLayoutParams2 = (RecyclerView.LayoutParams)((View)localObject).getLayoutParams();
          an localan2 = RecyclerView.ai((View)localObject);
          if (localan2.isRemoved()) {
            paramView.uk.tM.aA((View)localObject);
          }
          for (;;)
          {
            paramView.tb.a((View)localObject, j, localLayoutParams2, localan2.isRemoved());
            break;
            paramView.uk.tM.az((View)localObject);
          }
        }
      }
      else
      {
        this.tb.a(paramView, paramInt, false);
        localLayoutParams1.up = true;
        if ((this.ul != null) && (this.ul.isRunning())) {
          this.ul.ay(paramView);
        }
      }
    }
  }
  
  private void removeViewAt(int paramInt)
  {
    if (getChildAt(paramInt) != null) {
      this.tb.removeViewAt(paramInt);
    }
  }
  
  public int a(int paramInt, af paramaf, ak paramak)
  {
    return 0;
  }
  
  public int a(af paramaf, ak paramak)
  {
    if ((this.uk == null) || (RecyclerView.g(this.uk) == null)) {}
    while (!cQ()) {
      return 1;
    }
    return RecyclerView.g(this.uk).getItemCount();
  }
  
  public RecyclerView.LayoutParams a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new RecyclerView.LayoutParams(paramContext, paramAttributeSet);
  }
  
  public RecyclerView.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof RecyclerView.LayoutParams)) {
      return new RecyclerView.LayoutParams((RecyclerView.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new RecyclerView.LayoutParams(paramLayoutParams);
  }
  
  public final void a(int paramInt, af paramaf)
  {
    View localView = getChildAt(paramInt);
    removeViewAt(paramInt);
    paramaf.av(localView);
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt)
  {
    Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
  }
  
  public void a(RecyclerView paramRecyclerView, af paramaf) {}
  
  public void a(af paramaf, ak paramak, View paramView, android.support.v4.view.a.e parame)
  {
    int i;
    if (cQ())
    {
      i = ao(paramView);
      if (!cP()) {
        break label48;
      }
    }
    label48:
    for (int j = ao(paramView);; j = 0)
    {
      parame.p(q.a(i, 1, j, 1, false));
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(ai paramai)
  {
    if ((this.ul != null) && (paramai != this.ul) && (this.ul.isRunning())) {
      this.ul.stop();
    }
    this.ul = paramai;
    this.ul.a(this.uk, this);
  }
  
  public final void a(View paramView, af paramaf)
  {
    this.tb.removeView(paramView);
    paramaf.av(paramView);
  }
  
  public boolean a(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams != null;
  }
  
  public final void addView(View paramView)
  {
    b(paramView, -1, false);
  }
  
  public final void addView(View paramView, int paramInt)
  {
    b(paramView, paramInt, false);
  }
  
  public View af(int paramInt)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      an localan = RecyclerView.ai(localView);
      if ((localan != null) && (localan.eg() == paramInt) && (!localan.ef()) && ((this.uk.tM.dY()) || (!localan.isRemoved()))) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  public void ag(int paramInt) {}
  
  public void am(int paramInt)
  {
    if (this.uk != null)
    {
      RecyclerView localRecyclerView = this.uk;
      int j = localRecyclerView.tb.getChildCount();
      int i = 0;
      while (i < j)
      {
        localRecyclerView.tb.getChildAt(i).offsetLeftAndRight(paramInt);
        i += 1;
      }
    }
  }
  
  public void an(int paramInt)
  {
    if (this.uk != null)
    {
      RecyclerView localRecyclerView = this.uk;
      int j = localRecyclerView.tb.getChildCount();
      int i = 0;
      while (i < j)
      {
        localRecyclerView.tb.getChildAt(i).offsetTopAndBottom(paramInt);
        i += 1;
      }
    }
  }
  
  public final void an(View paramView)
  {
    b(paramView, -1, true);
  }
  
  public void ao(int paramInt) {}
  
  public int b(int paramInt, af paramaf, ak paramak)
  {
    return 0;
  }
  
  public int b(af paramaf, ak paramak)
  {
    if ((this.uk == null) || (RecyclerView.g(this.uk) == null)) {}
    while (!cP()) {
      return 1;
    }
    return RecyclerView.g(this.uk).getItemCount();
  }
  
  public int b(ak paramak)
  {
    return 0;
  }
  
  final void b(RecyclerView paramRecyclerView, af paramaf)
  {
    this.un = false;
    a(paramRecyclerView, paramaf);
  }
  
  public final void b(af paramaf)
  {
    int i = getChildCount() - 1;
    if (i >= 0)
    {
      View localView = getChildAt(i);
      an localan = RecyclerView.ai(localView);
      if (!localan.ef())
      {
        if ((!localan.em()) || (localan.isRemoved()) || (localan.eo()) || (RecyclerView.g(this.uk).hasStableIds())) {
          break label86;
        }
        removeViewAt(i);
        paramaf.p(localan);
      }
      for (;;)
      {
        i -= 1;
        break;
        label86:
        al(i);
        paramaf.ax(localView);
      }
    }
  }
  
  public final void b(View paramView, Rect paramRect)
  {
    if (this.uk == null)
    {
      paramRect.set(0, 0, 0, 0);
      return;
    }
    paramRect.set(this.uk.al(paramView));
  }
  
  final void b(View paramView, android.support.v4.view.a.e parame)
  {
    an localan = RecyclerView.ai(paramView);
    if ((localan != null) && (!localan.isRemoved()) && (!this.tb.W(localan.ve))) {
      a(this.uk.sY, this.uk.tM, paramView, parame);
    }
  }
  
  public int c(ak paramak)
  {
    return 0;
  }
  
  final void c(af paramaf)
  {
    int j = paramaf.uu.size();
    int i = j - 1;
    while (i >= 0)
    {
      View localView = ((an)paramaf.uu.get(i)).ve;
      an localan = RecyclerView.ai(localView);
      if (!localan.ef())
      {
        localan.p(false);
        if (localan.ep()) {
          this.uk.removeDetachedView(localView, false);
        }
        if (this.uk.tC != null) {
          this.uk.tC.c(localan);
        }
        localan.p(true);
        paramaf.aw(localView);
      }
      i -= 1;
    }
    paramaf.uu.clear();
    if (j > 0) {
      this.uk.invalidate();
    }
  }
  
  public void c(af paramaf, ak paramak)
  {
    Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
  }
  
  public void cJ() {}
  
  public abstract RecyclerView.LayoutParams cK();
  
  public boolean cL()
  {
    return false;
  }
  
  public boolean cP()
  {
    return false;
  }
  
  public boolean cQ()
  {
    return false;
  }
  
  public int d(ak paramak)
  {
    return 0;
  }
  
  public View d(int paramInt, af paramaf, ak paramak)
  {
    return null;
  }
  
  public final void d(af paramaf)
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      if (!RecyclerView.ai(getChildAt(i)).ef()) {
        a(i, paramaf);
      }
      i -= 1;
    }
  }
  
  final void dM()
  {
    this.un = true;
  }
  
  public final boolean dN()
  {
    return (this.ul != null) && (this.ul.isRunning());
  }
  
  public void dO() {}
  
  final void dP()
  {
    if (this.ul != null) {
      this.ul.stop();
    }
  }
  
  public final void dQ()
  {
    this.um = true;
  }
  
  public int e(ak paramak)
  {
    return 0;
  }
  
  public int f(ak paramak)
  {
    return 0;
  }
  
  public void f(String paramString)
  {
    if (this.uk != null) {
      this.uk.f(paramString);
    }
  }
  
  public int g(ak paramak)
  {
    return 0;
  }
  
  public final View getChildAt(int paramInt)
  {
    if (this.tb != null) {
      return this.tb.getChildAt(paramInt);
    }
    return null;
  }
  
  public final int getChildCount()
  {
    if (this.tb != null) {
      return this.tb.getChildCount();
    }
    return 0;
  }
  
  public final int getHeight()
  {
    if (this.uk != null) {
      return this.uk.getHeight();
    }
    return 0;
  }
  
  public final int getItemCount()
  {
    if (this.uk != null) {}
    for (t localt = this.uk.de(); localt != null; localt = null) {
      return localt.getItemCount();
    }
    return 0;
  }
  
  public final int getPaddingBottom()
  {
    if (this.uk != null) {
      return this.uk.getPaddingBottom();
    }
    return 0;
  }
  
  public final int getPaddingLeft()
  {
    if (this.uk != null) {
      return this.uk.getPaddingLeft();
    }
    return 0;
  }
  
  public final int getPaddingRight()
  {
    if (this.uk != null) {
      return this.uk.getPaddingRight();
    }
    return 0;
  }
  
  public final int getPaddingTop()
  {
    if (this.uk != null) {
      return this.uk.getPaddingTop();
    }
    return 0;
  }
  
  public final int getWidth()
  {
    if (this.uk != null) {
      return this.uk.getWidth();
    }
    return 0;
  }
  
  public final boolean isAttachedToWindow()
  {
    return this.un;
  }
  
  public final void k(View paramView, int paramInt)
  {
    b(paramView, 0, true);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool2 = true;
    Object localObject = this.uk.sY;
    localObject = this.uk.tM;
    paramAccessibilityEvent = a.a(paramAccessibilityEvent);
    if (this.uk == null) {
      return;
    }
    boolean bool1 = bool2;
    if (!r.b(this.uk, 1))
    {
      bool1 = bool2;
      if (!r.b(this.uk, -1))
      {
        bool1 = bool2;
        if (!r.a(this.uk, -1)) {
          if (!r.a(this.uk, 1)) {
            break label115;
          }
        }
      }
    }
    label115:
    for (bool1 = bool2;; bool1 = false)
    {
      paramAccessibilityEvent.setScrollable(bool1);
      if (RecyclerView.g(this.uk) == null) {
        break;
      }
      paramAccessibilityEvent.setItemCount(RecyclerView.g(this.uk).getItemCount());
      return;
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  public Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  public void q(int paramInt1, int paramInt2) {}
  
  public void r(int paramInt1, int paramInt2) {}
  
  final void r(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView == null)
    {
      this.uk = null;
      this.tb = null;
      return;
    }
    this.uk = paramRecyclerView;
    this.tb = paramRecyclerView.tb;
  }
  
  public final void removeAllViews()
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      this.tb.removeViewAt(i);
      i -= 1;
    }
  }
  
  public final boolean removeCallbacks(Runnable paramRunnable)
  {
    if (this.uk != null) {
      return this.uk.removeCallbacks(paramRunnable);
    }
    return false;
  }
  
  public final void requestLayout()
  {
    if (this.uk != null) {
      this.uk.requestLayout();
    }
  }
  
  public void s(int paramInt1, int paramInt2) {}
  
  public void t(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.ab
 * JD-Core Version:    0.7.0.1
 */