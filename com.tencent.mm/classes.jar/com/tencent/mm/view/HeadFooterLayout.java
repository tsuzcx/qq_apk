package com.tencent.mm.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.b.a;
import android.support.v4.view.n;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/HeadFooterLayout;", "Landroid/widget/LinearLayout;", "Landroid/support/v4/view/NestedScrollingParent2;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "decoratedBounds", "Landroid/graphics/Rect;", "extraOverScrollFooterDx", "getExtraOverScrollFooterDx", "()I", "setExtraOverScrollFooterDx", "(I)V", "footerViews", "Ljava/util/LinkedList;", "Landroid/view/View;", "getFooterViews", "()Ljava/util/LinkedList;", "footersHeight", "getFootersHeight", "setFootersHeight", "headerViews", "getHeaderViews", "headersHeight", "getHeadersHeight", "setHeadersHeight", "isConsumeOverScroll", "", "()Z", "setConsumeOverScroll", "(Z)V", "isDirtyLayout", "isEnableNestedScroll", "setEnableNestedScroll", "isSuperNestedScroll", "setSuperNestedScroll", "onTranslateYCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "dx", "dy", "", "getOnTranslateYCallback", "()Lkotlin/jvm/functions/Function2;", "setOnTranslateYCallback", "(Lkotlin/jvm/functions/Function2;)V", "overCallback", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "getOverCallback", "()Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "setOverCallback", "(Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "addFooter", "view", "isDirty", "addHeader", "getFooter", "id", "getHeader", "isFirstItemReachTop", "target", "isLastItemBottomVisible", "isLastItemReachBottom", "offset", "isNestedScrollingEnabled", "onBindRecyclerView", "onFinishInflate", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onNestedPreScroll", "consumed", "", "type", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "p0", "p1", "p2", "p3", "onNotOverScroll", "onOverScroll", "parent", "dampingDy", "isEnd", "isVertical", "isTopOverScroll", "onStartNestedScroll", "child", "axes", "onStopNestedScroll", "onStopScroll", "onViewAdded", "print", "log", "", "isVerbose", "removeFooter", "removeHeader", "requestLayout", "resetChildren", "setTranslationY", "translationY", "", "Companion", "OverCallback", "libmmui_release"})
public class HeadFooterLayout
  extends LinearLayout
  implements n
{
  public static final a RjA;
  private b Rjo;
  private boolean Rjp;
  boolean Rjq;
  boolean Rjr;
  private m<? super Integer, ? super Integer, x> Rjs;
  private final Rect Rjt;
  private final LinkedList<View> Rju;
  private final LinkedList<View> Rjv;
  private int Rjw;
  private int Rjx;
  private boolean Rjy;
  private int Rjz;
  public RecyclerView hak;
  
  static
  {
    AppMethodBeat.i(164536);
    RjA = new a((byte)0);
    AppMethodBeat.o(164536);
  }
  
  public HeadFooterLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164534);
    this.Rjq = true;
    this.Rjt = new Rect();
    this.Rju = new LinkedList();
    this.Rjv = new LinkedList();
    AppMethodBeat.o(164534);
  }
  
  public HeadFooterLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164535);
    this.Rjq = true;
    this.Rjt = new Rect();
    this.Rju = new LinkedList();
    this.Rjv = new LinkedList();
    AppMethodBeat.o(164535);
  }
  
  public static void dD(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(204956);
    p.h(paramString, "log");
    if (!paramBoolean) {
      Log.i("HeadFooterLayout", paramString);
    }
    AppMethodBeat.o(204956);
  }
  
  private void hfE()
  {
    AppMethodBeat.i(164527);
    removeAllViews();
    Iterator localIterator = getHeaderViews().iterator();
    while (localIterator.hasNext()) {
      addView((View)localIterator.next());
    }
    addView((View)getRecyclerView(), getRecyclerView().getLayoutParams());
    localIterator = getFooterViews().iterator();
    while (localIterator.hasNext()) {
      addView((View)localIterator.next());
    }
    AppMethodBeat.o(164527);
  }
  
  public static boolean w(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(164516);
    p.h(paramRecyclerView, "target");
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
    {
      int[] arrayOfInt = ((StaggeredGridLayoutManager)paramRecyclerView).n(null);
      p.g(arrayOfInt, "firstVisibleInfo");
      int k = arrayOfInt.length;
      int i = 0;
      int j = 0;
      while (i < k)
      {
        if (arrayOfInt[i] == 0) {
          j = 1;
        }
        i += 1;
      }
      if (j != 0)
      {
        paramRecyclerView = paramRecyclerView.findViewByPosition(0);
        if (paramRecyclerView != null)
        {
          if (paramRecyclerView.getTop() >= 0)
          {
            AppMethodBeat.o(164516);
            return true;
          }
          AppMethodBeat.o(164516);
          return false;
        }
      }
    }
    else if ((paramRecyclerView instanceof LinearLayoutManager))
    {
      paramRecyclerView = paramRecyclerView.findViewByPosition(0);
      if (paramRecyclerView != null)
      {
        if (paramRecyclerView.getTop() >= 0)
        {
          AppMethodBeat.o(164516);
          return true;
        }
        AppMethodBeat.o(164516);
        return false;
      }
    }
    AppMethodBeat.o(164516);
    return false;
  }
  
  public final void W(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(164524);
    p.h(paramView, "view");
    getHeaderViews().add(paramView);
    this.Rjy = paramBoolean;
    requestLayout();
    AppMethodBeat.o(164524);
  }
  
  public final void X(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(204953);
    p.h(paramView, "view");
    if (getHeaderViews().remove(paramView))
    {
      removeView(paramView);
      this.Rjy = paramBoolean;
      requestLayout();
    }
    AppMethodBeat.o(204953);
  }
  
  public final void Y(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(164525);
    p.h(paramView, "view");
    getFooterViews().add(paramView);
    this.Rjy = paramBoolean;
    requestLayout();
    dD("[addFooter] view=" + paramView + " isDirty=" + paramBoolean + " hash=" + hashCode(), false);
    AppMethodBeat.o(164525);
  }
  
  public final void Z(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(204955);
    p.h(paramView, "view");
    if (getFooterViews().remove(paramView))
    {
      this.Rjy = paramBoolean;
      removeView(paramView);
      requestLayout();
      dD("[removeFooter] view=" + paramView + " isDirty=" + paramBoolean + " hash=" + hashCode(), false);
    }
    AppMethodBeat.o(204955);
  }
  
  public void a(RecyclerView paramRecyclerView, HeadFooterLayout paramHeadFooterLayout, int paramInt)
  {
    AppMethodBeat.i(164532);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramHeadFooterLayout, "parent");
    AppMethodBeat.o(164532);
  }
  
  public void a(RecyclerView paramRecyclerView, HeadFooterLayout paramHeadFooterLayout, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int[] paramArrayOfInt, int paramInt3, boolean paramBoolean3)
  {
    AppMethodBeat.i(164533);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramHeadFooterLayout, "parent");
    p.h(paramArrayOfInt, "consumed");
    if ((paramBoolean1) && (paramBoolean3)) {
      paramInt3 = a.clamp((int)getTranslationY() - paramInt2, -getHeadersHeight() - getFootersHeight() - this.Rjz, 0);
    }
    for (;;)
    {
      if (getTranslationY() != -getHeadersHeight()) {
        paramArrayOfInt[1] = paramInt1;
      }
      if (getTranslationY() != paramInt3)
      {
        setTranslationY(paramInt3);
        paramArrayOfInt[1] = paramInt1;
      }
      dD("onOverScroll dy:" + paramInt1 + " dampingDy:" + paramInt2 + " isEnd:" + paramBoolean1 + " consumed[1]:" + paramArrayOfInt + "[1] translationY:" + getTranslationY() + " targetY:" + paramInt3 + " headersHeight:" + getHeadersHeight() + " footersHeight:" + getFootersHeight(), true);
      AppMethodBeat.o(164533);
      return;
      if (paramBoolean1) {
        paramInt3 = a.clamp((int)getTranslationY() - paramInt2, -getHeadersHeight() - getFootersHeight() - this.Rjz, -getHeadersHeight());
      } else {
        paramInt3 = a.clamp((int)getTranslationY() - paramInt2, -getHeadersHeight(), 0);
      }
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(164521);
    p.h(paramView, "target");
    super.onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(164521);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(164514);
    p.h(paramView, "target");
    p.h(paramArrayOfInt, "consumed");
    super.onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt);
    boolean bool1;
    Object localObject1;
    int i;
    if (((paramView instanceof RecyclerView)) && (p.j(paramView, getRecyclerView())))
    {
      bool1 = false;
      if ((((RecyclerView)paramView).getLayoutManager() instanceof LinearLayoutManager))
      {
        localObject1 = ((RecyclerView)paramView).getLayoutManager();
        if (localObject1 == null)
        {
          paramView = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          AppMethodBeat.o(164514);
          throw paramView;
        }
        if (((LinearLayoutManager)localObject1).getOrientation() == 1)
        {
          bool1 = true;
          i = 1;
        }
      }
    }
    for (;;)
    {
      localObject1 = getRecyclerView();
      p.h(localObject1, "target");
      Object localObject2 = ((RecyclerView)localObject1).getLayoutManager();
      int[] arrayOfInt;
      int k;
      int j;
      if ((localObject2 instanceof StaggeredGridLayoutManager))
      {
        arrayOfInt = ((StaggeredGridLayoutManager)localObject2).o(null);
        paramInt1 = 0;
        p.g(arrayOfInt, "lastVisibleInfo");
        k = arrayOfInt.length;
        j = 0;
        label173:
        if (j < k)
        {
          if (arrayOfInt[j] != ((StaggeredGridLayoutManager)localObject2).getItemCount() - 1) {
            break label774;
          }
          paramInt1 = 1;
        }
      }
      label774:
      for (;;)
      {
        j += 1;
        break label173;
        bool1 = false;
        break;
        if (!(((RecyclerView)paramView).getLayoutManager() instanceof StaggeredGridLayoutManager)) {
          break label777;
        }
        localObject1 = ((RecyclerView)paramView).getLayoutManager();
        if (localObject1 == null)
        {
          paramView = new t("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager");
          AppMethodBeat.o(164514);
          throw paramView;
        }
        if (((StaggeredGridLayoutManager)localObject1).getOrientation() == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          i = 0;
          break;
        }
        boolean bool2;
        if (paramInt1 != 0)
        {
          j = arrayOfInt.length;
          paramInt1 = 0;
          while (paramInt1 < j)
          {
            k = arrayOfInt[paramInt1];
            if (k != -1)
            {
              View localView = ((RecyclerView.LayoutManager)localObject2).findViewByPosition(k);
              if (localView != null)
              {
                RecyclerView.getDecoratedBoundsWithMargins(localView, this.Rjt);
                if (this.Rjt.bottom > ((RecyclerView)localObject1).getHeight()) {
                  break label670;
                }
              }
            }
            paramInt1 += 1;
          }
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label675;
          }
          localObject1 = ((RecyclerView)paramView).getLayoutManager();
          if (localObject1 == null) {
            p.hyc();
          }
          p.g(localObject1, "target.layoutManager!!");
          if (((RecyclerView.LayoutManager)localObject1).getItemCount() == 0) {
            break label675;
          }
          bool2 = true;
          label404:
          boolean bool3 = w(getRecyclerView());
          if ((!bool2) && (!bool3)) {
            break label705;
          }
          if (this.Rjo != null) {
            break label681;
          }
          j = 1;
          label433:
          if (bool2)
          {
            if ((int)getTranslationY() == -getHeadersHeight())
            {
              localObject1 = this.Rjo;
              if (localObject1 != null) {
                ((b)localObject1).IJ(paramInt2);
              }
            }
            j = 1;
          }
          paramInt1 = j;
          if (bool3)
          {
            if ((int)getTranslationY() == 0)
            {
              localObject1 = this.Rjo;
              if (localObject1 != null)
              {
                paramInt1 = j;
                if (((b)localObject1).u(paramInt2, paramInt3, this.Rjp) == true) {
                  break label524;
                }
              }
            }
            paramInt1 = 1;
          }
          label524:
          if (paramInt1 == 0) {
            break label687;
          }
          a(getRecyclerView(), this, paramInt2, paramInt2, bool2, bool1, paramArrayOfInt, paramInt3, bool3);
        }
        for (;;)
        {
          if (paramInt1 == 0) {
            a(paramView, paramInt2, paramArrayOfInt);
          }
          AppMethodBeat.o(164514);
          return;
          if ((localObject2 instanceof LinearLayoutManager))
          {
            paramInt1 = ((LinearLayoutManager)localObject2).ku();
            if (paramInt1 == ((LinearLayoutManager)localObject2).getItemCount() - 1)
            {
              localObject2 = ((RecyclerView.LayoutManager)localObject2).findViewByPosition(paramInt1);
              if (localObject2 != null)
              {
                RecyclerView.getDecoratedBoundsWithMargins((View)localObject2, this.Rjt);
                if (this.Rjt.bottom <= ((RecyclerView)localObject1).getHeight())
                {
                  ((View)localObject2).getHitRect(this.Rjt);
                  if (this.Rjt.bottom <= ((RecyclerView)localObject1).getHeight())
                  {
                    paramInt1 = 1;
                    break;
                  }
                  paramInt1 = 0;
                  break;
                }
              }
            }
          }
          label670:
          paramInt1 = 0;
          break;
          label675:
          bool2 = false;
          break label404;
          label681:
          j = 0;
          break label433;
          label687:
          if (i != 0) {
            paramArrayOfInt[1] = paramInt2;
          }
          this.Rjp = true;
          continue;
          label705:
          localObject1 = ((RecyclerView)paramView).getLayoutManager();
          if (localObject1 == null) {
            p.hyc();
          }
          p.g(localObject1, "target.layoutManager!!");
          if (((RecyclerView.LayoutManager)localObject1).getItemCount() <= 0)
          {
            localObject1 = this.Rjo;
            if (localObject1 != null) {
              ((b)localObject1).u(paramInt2, paramInt3, this.Rjp);
            }
            this.Rjp = true;
          }
          paramInt1 = 0;
        }
      }
      label777:
      i = 0;
    }
  }
  
  public void a(View paramView, int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(164515);
    p.h(paramView, "target");
    p.h(paramArrayOfInt, "consumed");
    AppMethodBeat.o(164515);
  }
  
  public boolean a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164519);
    p.h(paramView1, "child");
    p.h(paramView2, "target");
    if (this.Rjr)
    {
      bool = super.startNestedScroll(paramInt1);
      AppMethodBeat.o(164519);
      return bool;
    }
    boolean bool = this.Rjq;
    AppMethodBeat.o(164519);
    return bool;
  }
  
  public void b(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164520);
    p.h(paramView1, "p0");
    p.h(paramView2, "p1");
    AppMethodBeat.o(164520);
  }
  
  public final int getExtraOverScrollFooterDx()
  {
    return this.Rjz;
  }
  
  public final View getFooter$7529eef0()
  {
    AppMethodBeat.i(204954);
    Iterator localIterator = ((Iterable)getFooterViews()).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (2131301136 == ((View)localObject).getId())
      {
        i = 1;
        label50:
        if (i == 0) {
          break label70;
        }
      }
    }
    for (;;)
    {
      localObject = (View)localObject;
      AppMethodBeat.o(204954);
      return localObject;
      i = 0;
      break label50;
      label70:
      break;
      localObject = null;
    }
  }
  
  public LinkedList<View> getFooterViews()
  {
    return this.Rjv;
  }
  
  public int getFootersHeight()
  {
    return this.Rjx;
  }
  
  public LinkedList<View> getHeaderViews()
  {
    return this.Rju;
  }
  
  public int getHeadersHeight()
  {
    return this.Rjw;
  }
  
  public final m<Integer, Integer, x> getOnTranslateYCallback()
  {
    return this.Rjs;
  }
  
  public final b getOverCallback()
  {
    return this.Rjo;
  }
  
  public RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(164522);
    RecyclerView localRecyclerView = this.hak;
    if (localRecyclerView == null) {
      p.btv("recyclerView");
    }
    AppMethodBeat.o(164522);
    return localRecyclerView;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return true;
  }
  
  public void k(View paramView, int paramInt)
  {
    AppMethodBeat.i(164518);
    p.h(paramView, "target");
    b localb = this.Rjo;
    if (localb != null) {
      localb.ddr();
    }
    this.Rjp = false;
    if (((paramView instanceof RecyclerView)) && ((((RecyclerView)paramView).getLayoutManager() instanceof LinearLayoutManager)) && (p.j(paramView, getRecyclerView())))
    {
      a(getRecyclerView(), this, paramInt);
      AppMethodBeat.o(164518);
      return;
    }
    if (((paramView instanceof RecyclerView)) && ((((RecyclerView)paramView).getLayoutManager() instanceof StaggeredGridLayoutManager)) && (p.j(paramView, getRecyclerView()))) {
      a(getRecyclerView(), this, paramInt);
    }
    AppMethodBeat.o(164518);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(164528);
    super.onFinishInflate();
    hfE();
    AppMethodBeat.o(164528);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164530);
    setFootersHeight(0);
    setHeadersHeight(0);
    if (getRecyclerView().getVisibility() == 0) {
      getRecyclerView().measure(paramInt1, paramInt2);
    }
    int i = getRecyclerView().getMeasuredHeight();
    int j;
    Object localObject;
    if (getRecyclerView().getVisibility() == 8)
    {
      int m = getChildCount();
      j = 0;
      i = 0;
      if (j < m)
      {
        localObject = getChildAt(j);
        int k = i;
        if (!p.j(localObject, getRecyclerView()))
        {
          k = i;
          if (!getHeaderViews().contains(localObject)) {
            if (!getFooterViews().contains(localObject)) {
              break label138;
            }
          }
        }
        for (k = i;; k = i + View.MeasureSpec.getSize(paramInt2))
        {
          j += 1;
          i = k;
          break;
          label138:
          ((View)localObject).measure(paramInt1, paramInt2);
        }
      }
    }
    for (;;)
    {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 0);
      localObject = ((Iterable)getHeaderViews()).iterator();
      View localView;
      while (((Iterator)localObject).hasNext())
      {
        localView = (View)((Iterator)localObject).next();
        localView.measure(paramInt1, paramInt2);
        i += localView.getMeasuredHeight();
        j = getHeadersHeight();
        setHeadersHeight(localView.getMeasuredHeight() + j);
      }
      localObject = ((Iterable)getFooterViews()).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localView = (View)((Iterator)localObject).next();
        localView.measure(paramInt1, paramInt2);
        i += localView.getMeasuredHeight();
        j = getFootersHeight();
        setFootersHeight(localView.getMeasuredHeight() + j);
      }
      setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), i);
      AppMethodBeat.o(164530);
      return;
    }
  }
  
  public void onViewAdded(View paramView)
  {
    AppMethodBeat.i(164529);
    super.onViewAdded(paramView);
    if ((paramView instanceof RecyclerView)) {
      setRecyclerView((RecyclerView)paramView);
    }
    AppMethodBeat.o(164529);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(164526);
    super.requestLayout();
    if (this.Rjy)
    {
      this.Rjy = false;
      hfE();
    }
    AppMethodBeat.o(164526);
  }
  
  public final void setConsumeOverScroll(boolean paramBoolean)
  {
    this.Rjp = paramBoolean;
  }
  
  public final void setEnableNestedScroll(boolean paramBoolean)
  {
    this.Rjq = paramBoolean;
  }
  
  public final void setExtraOverScrollFooterDx(int paramInt)
  {
    this.Rjz = paramInt;
  }
  
  public void setFootersHeight(int paramInt)
  {
    this.Rjx = paramInt;
  }
  
  public void setHeadersHeight(int paramInt)
  {
    this.Rjw = paramInt;
  }
  
  public final void setOnTranslateYCallback(m<? super Integer, ? super Integer, x> paramm)
  {
    this.Rjs = paramm;
  }
  
  public final void setOverCallback(b paramb)
  {
    this.Rjo = paramb;
  }
  
  public void setRecyclerView(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(164523);
    p.h(paramRecyclerView, "<set-?>");
    this.hak = paramRecyclerView;
    AppMethodBeat.o(164523);
  }
  
  public final void setSuperNestedScroll(boolean paramBoolean)
  {
    this.Rjr = paramBoolean;
  }
  
  public void setTranslationY(float paramFloat)
  {
    AppMethodBeat.i(204951);
    super.setTranslationY(paramFloat);
    m localm = this.Rjs;
    if (localm != null)
    {
      localm.invoke(Integer.valueOf(0), Integer.valueOf((int)paramFloat));
      AppMethodBeat.o(204951);
      return;
    }
    AppMethodBeat.o(204951);
  }
  
  public final boolean x(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(204952);
    p.h(paramRecyclerView, "target");
    Object localObject = paramRecyclerView.getLayoutManager();
    int[] arrayOfInt;
    int k;
    int j;
    int i;
    if ((localObject instanceof StaggeredGridLayoutManager))
    {
      arrayOfInt = ((StaggeredGridLayoutManager)localObject).o(null);
      p.g(arrayOfInt, "lastVisibleInfo");
      k = arrayOfInt.length;
      j = 0;
      i = 0;
      if (j < k)
      {
        if (arrayOfInt[j] != ((StaggeredGridLayoutManager)localObject).getItemCount() - 1) {
          break label341;
        }
        i = 1;
      }
    }
    label341:
    for (;;)
    {
      j += 1;
      break;
      if (i != 0)
      {
        int m = arrayOfInt.length;
        i = 0;
        boolean bool1 = false;
        j = 0;
        if (i < m)
        {
          int n = arrayOfInt[i];
          boolean bool2 = bool1;
          k = j;
          View localView;
          if (n != -1)
          {
            localView = ((RecyclerView.LayoutManager)localObject).findViewByPosition(n);
            bool2 = bool1;
            k = j;
            if (localView != null)
            {
              RecyclerView.getDecoratedBoundsWithMargins(localView, this.Rjt);
              n = this.Rjt.bottom;
              bool2 = bool1;
              k = j;
              if (localView.getBottom() > j) {
                if ((n > paramRecyclerView.getHeight()) || (n < paramRecyclerView.getHeight() + 0)) {
                  break label231;
                }
              }
            }
          }
          label231:
          for (bool1 = true;; bool1 = false)
          {
            k = localView.getBottom();
            bool2 = bool1;
            i += 1;
            bool1 = bool2;
            j = k;
            break;
          }
        }
        AppMethodBeat.o(204952);
        return bool1;
        if ((localObject instanceof LinearLayoutManager))
        {
          i = ((LinearLayoutManager)localObject).ku();
          if (i == ((LinearLayoutManager)localObject).getItemCount() - 1)
          {
            localObject = ((RecyclerView.LayoutManager)localObject).findViewByPosition(i);
            if (localObject != null)
            {
              RecyclerView.getDecoratedBoundsWithMargins((View)localObject, this.Rjt);
              i = this.Rjt.bottom;
              if ((i <= paramRecyclerView.getHeight()) && (i >= paramRecyclerView.getHeight() + 0))
              {
                AppMethodBeat.o(204952);
                return true;
              }
            }
          }
        }
      }
      AppMethodBeat.o(204952);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/HeadFooterLayout$Companion;", "", "()V", "TAG", "", "isDebug", "", "libmmui_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "", "onOverEnd", "", "dx", "", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "", "libmmui_release"})
  public static abstract interface b
  {
    public abstract boolean IJ(int paramInt);
    
    public abstract void ddr();
    
    public abstract boolean u(int paramInt1, int paramInt2, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.HeadFooterLayout
 * JD-Core Version:    0.7.0.1
 */