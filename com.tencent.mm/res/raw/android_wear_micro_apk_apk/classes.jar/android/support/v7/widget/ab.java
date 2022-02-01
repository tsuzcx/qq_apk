package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.view.a.a;
import android.support.v4.view.a.b;
import android.support.v4.view.a.e;
import android.support.v4.view.a.i;
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
  private boolean aR = false;
  d uR;
  RecyclerView wa;
  ai wb;
  private boolean wc = false;
  
  private void G(int paramInt1, int paramInt2)
  {
    View localView = getChildAt(paramInt1);
    if (localView == null) {
      throw new IllegalArgumentException("Cannot move a child from non-existing index:".concat(String.valueOf(paramInt1)));
    }
    ax(paramInt1);
    o(localView, paramInt2);
  }
  
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
  
  public static int aA(View paramView)
  {
    int i = paramView.getRight();
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).tO.right + i;
  }
  
  public static int aB(View paramView)
  {
    int i = paramView.getBottom();
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).tO.bottom + i;
  }
  
  public static int av(View paramView)
  {
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).wd.ev();
  }
  
  public static int aw(View paramView)
  {
    Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).tO;
    int i = paramView.getMeasuredWidth();
    int j = localRect.left;
    return localRect.right + (i + j);
  }
  
  public static int ax(View paramView)
  {
    Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).tO;
    int i = paramView.getMeasuredHeight();
    int j = localRect.top;
    return localRect.bottom + (i + j);
  }
  
  private void ax(int paramInt)
  {
    getChildAt(paramInt);
    this.uR.detachViewFromParent(paramInt);
  }
  
  public static int ay(View paramView)
  {
    return paramView.getLeft() - ((RecyclerView.LayoutParams)paramView.getLayoutParams()).tO.left;
  }
  
  public static int az(View paramView)
  {
    return paramView.getTop() - ((RecyclerView.LayoutParams)paramView.getLayoutParams()).tO.top;
  }
  
  private void b(View paramView, int paramInt, boolean paramBoolean)
  {
    an localan = RecyclerView.ap(paramView);
    RecyclerView.LayoutParams localLayoutParams;
    if ((paramBoolean) || (localan.isRemoved()))
    {
      this.wa.vC.aH(paramView);
      localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      if ((!localan.ey()) && (!localan.ew())) {
        break label126;
      }
      if (!localan.ew()) {
        break label118;
      }
      localan.ex();
      label67:
      this.uR.a(paramView, paramInt, paramView.getLayoutParams(), false);
    }
    for (;;)
    {
      if (localLayoutParams.wf)
      {
        localan.wT.invalidate();
        localLayoutParams.wf = false;
      }
      return;
      this.wa.vC.aG(paramView);
      break;
      label118:
      localan.ez();
      break label67;
      label126:
      if (paramView.getParent() == this.wa)
      {
        int j = this.uR.indexOfChild(paramView);
        int i = paramInt;
        if (paramInt == -1) {
          i = this.uR.getChildCount();
        }
        if (j == -1) {
          throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.wa.indexOfChild(paramView));
        }
        if (j != i) {
          RecyclerView.e(this.wa).G(j, i);
        }
      }
      else
      {
        this.uR.a(paramView, paramInt, false);
        localLayoutParams.we = true;
        if ((this.wb != null) && (this.wb.isRunning())) {
          this.wb.aF(paramView);
        }
      }
    }
  }
  
  public static void c(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).tO;
    paramView.layout(localRect.left + paramInt1, localRect.top + paramInt2, paramInt3 - localRect.right, paramInt4 - localRect.bottom);
  }
  
  private void o(View paramView, int paramInt)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    an localan = RecyclerView.ap(paramView);
    if (localan.isRemoved()) {
      this.wa.vC.aH(paramView);
    }
    for (;;)
    {
      this.uR.a(paramView, paramInt, localLayoutParams, localan.isRemoved());
      return;
      this.wa.vC.aG(paramView);
    }
  }
  
  private void removeViewAt(int paramInt)
  {
    if (getChildAt(paramInt) != null) {
      this.uR.removeViewAt(paramInt);
    }
  }
  
  public int a(int paramInt, af paramaf, ak paramak)
  {
    return 0;
  }
  
  public int a(af paramaf, ak paramak)
  {
    if ((this.wa == null) || (RecyclerView.g(this.wa) == null)) {}
    while (!cY()) {
      return 1;
    }
    return RecyclerView.g(this.wa).getItemCount();
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
    paramaf.aC(localView);
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt)
  {
    Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
  }
  
  public void a(RecyclerView paramRecyclerView, af paramaf) {}
  
  public void a(af paramaf, ak paramak, View paramView, b paramb)
  {
    int i;
    if (cY())
    {
      i = av(paramView);
      if (!cX()) {
        break label48;
      }
    }
    label48:
    for (int j = av(paramView);; j = 0)
    {
      paramb.w(e.a(i, 1, j, 1, false));
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(ai paramai)
  {
    if ((this.wb != null) && (paramai != this.wb) && (this.wb.isRunning())) {
      this.wb.stop();
    }
    this.wb = paramai;
    this.wb.a(this.wa, this);
  }
  
  public final void a(View paramView, af paramaf)
  {
    this.uR.removeView(paramView);
    paramaf.aC(paramView);
  }
  
  public boolean a(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams != null;
  }
  
  public void aA(int paramInt) {}
  
  public final void addView(View paramView)
  {
    b(paramView, -1, false);
  }
  
  public final void addView(View paramView, int paramInt)
  {
    b(paramView, paramInt, false);
  }
  
  public View ar(int paramInt)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      an localan = RecyclerView.ap(localView);
      if ((localan != null) && (localan.ev() == paramInt) && (!localan.eu()) && ((this.wa.vC.em()) || (!localan.isRemoved()))) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  public void as(int paramInt) {}
  
  public final void au(View paramView)
  {
    b(paramView, -1, true);
  }
  
  public void ay(int paramInt)
  {
    if (this.wa != null)
    {
      RecyclerView localRecyclerView = this.wa;
      int j = localRecyclerView.uR.getChildCount();
      int i = 0;
      while (i < j)
      {
        localRecyclerView.uR.getChildAt(i).offsetLeftAndRight(paramInt);
        i += 1;
      }
    }
  }
  
  public void az(int paramInt)
  {
    if (this.wa != null)
    {
      RecyclerView localRecyclerView = this.wa;
      int j = localRecyclerView.uR.getChildCount();
      int i = 0;
      while (i < j)
      {
        localRecyclerView.uR.getChildAt(i).offsetTopAndBottom(paramInt);
        i += 1;
      }
    }
  }
  
  public int b(int paramInt, af paramaf, ak paramak)
  {
    return 0;
  }
  
  public int b(af paramaf, ak paramak)
  {
    if ((this.wa == null) || (RecyclerView.g(this.wa) == null)) {}
    while (!cX()) {
      return 1;
    }
    return RecyclerView.g(this.wa).getItemCount();
  }
  
  final void b(RecyclerView paramRecyclerView, af paramaf)
  {
    this.aR = false;
    a(paramRecyclerView, paramaf);
  }
  
  public final void b(af paramaf)
  {
    int i = getChildCount() - 1;
    if (i >= 0)
    {
      View localView = getChildAt(i);
      an localan = RecyclerView.ap(localView);
      if (!localan.eu())
      {
        if ((!localan.eB()) || (localan.isRemoved()) || (localan.eD()) || (RecyclerView.g(this.wa).hasStableIds())) {
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
        ax(i);
        paramaf.aE(localView);
      }
    }
  }
  
  public final void b(View paramView, Rect paramRect)
  {
    if (this.wa == null)
    {
      paramRect.set(0, 0, 0, 0);
      return;
    }
    paramRect.set(this.wa.as(paramView));
  }
  
  final void b(View paramView, b paramb)
  {
    an localan = RecyclerView.ap(paramView);
    if ((localan != null) && (!localan.isRemoved()) && (!this.uR.ac(localan.wT))) {
      a(this.wa.uO, this.wa.vC, paramView, paramb);
    }
  }
  
  public int c(ak paramak)
  {
    return 0;
  }
  
  final void c(af paramaf)
  {
    int j = paramaf.wj.size();
    int i = j - 1;
    while (i >= 0)
    {
      View localView = ((an)paramaf.wj.get(i)).wT;
      an localan = RecyclerView.ap(localView);
      if (!localan.eu())
      {
        localan.s(false);
        if (localan.eE()) {
          this.wa.removeDetachedView(localView, false);
        }
        if (this.wa.vs != null) {
          this.wa.vs.c(localan);
        }
        localan.s(true);
        paramaf.aD(localView);
      }
      i -= 1;
    }
    paramaf.wj.clear();
    if (j > 0) {
      this.wa.invalidate();
    }
  }
  
  public void c(af paramaf, ak paramak)
  {
    Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
  }
  
  public void cR() {}
  
  public abstract RecyclerView.LayoutParams cS();
  
  public boolean cT()
  {
    return false;
  }
  
  public boolean cX()
  {
    return false;
  }
  
  public boolean cY()
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
      if (!RecyclerView.ap(getChildAt(i)).eu()) {
        a(i, paramaf);
      }
      i -= 1;
    }
  }
  
  public int e(ak paramak)
  {
    return 0;
  }
  
  final void ea()
  {
    this.aR = true;
  }
  
  public final boolean eb()
  {
    return (this.wb != null) && (this.wb.isRunning());
  }
  
  public void ec() {}
  
  final void ed()
  {
    if (this.wb != null) {
      this.wb.stop();
    }
  }
  
  public final void ee()
  {
    this.wc = true;
  }
  
  public int f(ak paramak)
  {
    return 0;
  }
  
  public void f(String paramString)
  {
    if (this.wa != null) {
      this.wa.f(paramString);
    }
  }
  
  public int g(ak paramak)
  {
    return 0;
  }
  
  public final View getChildAt(int paramInt)
  {
    if (this.uR != null) {
      return this.uR.getChildAt(paramInt);
    }
    return null;
  }
  
  public final int getChildCount()
  {
    if (this.uR != null) {
      return this.uR.getChildCount();
    }
    return 0;
  }
  
  public final boolean getClipToPadding()
  {
    return (this.wa != null) && (RecyclerView.p(this.wa));
  }
  
  public final int getHeight()
  {
    if (this.wa != null) {
      return this.wa.getHeight();
    }
    return 0;
  }
  
  public final int getItemCount()
  {
    if (this.wa != null) {}
    for (t localt = this.wa.dn(); localt != null; localt = null) {
      return localt.getItemCount();
    }
    return 0;
  }
  
  public final int getPaddingBottom()
  {
    if (this.wa != null) {
      return this.wa.getPaddingBottom();
    }
    return 0;
  }
  
  public final int getPaddingLeft()
  {
    if (this.wa != null) {
      return this.wa.getPaddingLeft();
    }
    return 0;
  }
  
  public final int getPaddingRight()
  {
    if (this.wa != null) {
      return this.wa.getPaddingRight();
    }
    return 0;
  }
  
  public final int getPaddingTop()
  {
    if (this.wa != null) {
      return this.wa.getPaddingTop();
    }
    return 0;
  }
  
  public final int getWidth()
  {
    if (this.wa != null) {
      return this.wa.getWidth();
    }
    return 0;
  }
  
  public int h(ak paramak)
  {
    return 0;
  }
  
  public final boolean isAttachedToWindow()
  {
    return this.aR;
  }
  
  public final void n(View paramView, int paramInt)
  {
    b(paramView, 0, true);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool2 = true;
    paramAccessibilityEvent = a.a(paramAccessibilityEvent);
    if (this.wa == null) {
      return;
    }
    boolean bool1 = bool2;
    if (!r.e(this.wa, 1))
    {
      bool1 = bool2;
      if (!r.e(this.wa, -1))
      {
        bool1 = bool2;
        if (!r.d(this.wa, -1)) {
          if (!r.d(this.wa, 1)) {
            break label97;
          }
        }
      }
    }
    label97:
    for (bool1 = bool2;; bool1 = false)
    {
      paramAccessibilityEvent.setScrollable(bool1);
      if (RecyclerView.g(this.wa) == null) {
        break;
      }
      paramAccessibilityEvent.setItemCount(RecyclerView.g(this.wa).getItemCount());
      return;
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  public Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  public void r(int paramInt1, int paramInt2) {}
  
  final void r(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView == null)
    {
      this.wa = null;
      this.uR = null;
      return;
    }
    this.wa = paramRecyclerView;
    this.uR = paramRecyclerView.uR;
  }
  
  public final void removeAllViews()
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      this.uR.removeViewAt(i);
      i -= 1;
    }
  }
  
  public final boolean removeCallbacks(Runnable paramRunnable)
  {
    if (this.wa != null) {
      return this.wa.removeCallbacks(paramRunnable);
    }
    return false;
  }
  
  public final void requestLayout()
  {
    if (this.wa != null) {
      this.wa.requestLayout();
    }
  }
  
  public void s(int paramInt1, int paramInt2) {}
  
  public void t(int paramInt1, int paramInt2) {}
  
  public void u(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.ab
 * JD-Core Version:    0.7.0.1
 */