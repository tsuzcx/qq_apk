package com.tencent.mm.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import androidx.core.b.a;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.a.m;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/HeadFooterLayout;", "Landroid/widget/LinearLayout;", "Landroidx/core/view/NestedScrollingParent2;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "decoratedBounds", "Landroid/graphics/Rect;", "extraOverScrollFooterDx", "getExtraOverScrollFooterDx", "()I", "setExtraOverScrollFooterDx", "(I)V", "footerViews", "Ljava/util/LinkedList;", "Landroid/view/View;", "getFooterViews", "()Ljava/util/LinkedList;", "footersHeight", "getFootersHeight", "setFootersHeight", "headerViews", "getHeaderViews", "headersHeight", "getHeadersHeight", "setHeadersHeight", "isConsumeOverScroll", "", "()Z", "setConsumeOverScroll", "(Z)V", "isDirtyLayout", "isEnableNestedScroll", "setEnableNestedScroll", "isSuperNestedScroll", "setSuperNestedScroll", "onTranslateYCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "dx", "dy", "", "getOnTranslateYCallback", "()Lkotlin/jvm/functions/Function2;", "setOnTranslateYCallback", "(Lkotlin/jvm/functions/Function2;)V", "overCallback", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "getOverCallback", "()Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "setOverCallback", "(Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "addFooter", "view", "isDirty", "addHeader", "getFooter", "id", "getHeader", "isFirstItemReachTop", "target", "isLastItemBottomVisible", "isLastItemReachBottom", "offset", "isNestedScrollingEnabled", "onBindRecyclerView", "onFinishInflate", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onNestedPreScroll", "consumed", "", "type", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "p0", "p1", "p2", "p3", "onNotOverScroll", "onOverScroll", "parent", "dampingDy", "isEnd", "isVertical", "isTopOverScroll", "onStartNestedScroll", "child", "axes", "onStopNestedScroll", "onStopScroll", "onViewAdded", "print", "log", "", "isVerbose", "removeFooter", "removeHeader", "requestLayout", "resetChildren", "setTranslationY", "translationY", "", "Companion", "OverCallback", "libmmui_release"})
public class HeadFooterLayout
  extends LinearLayout
  implements androidx.core.g.p
{
  public static final a YLl;
  private b YKZ;
  private boolean YLa;
  private boolean YLb;
  private boolean YLc;
  private m<? super Integer, ? super Integer, x> YLd;
  private final Rect YLe;
  private final LinkedList<View> YLf;
  private final LinkedList<View> YLg;
  private int YLh;
  private int YLi;
  private boolean YLj;
  private int YLk;
  public RecyclerView jLl;
  
  static
  {
    AppMethodBeat.i(164536);
    YLl = new a((byte)0);
    AppMethodBeat.o(164536);
  }
  
  public HeadFooterLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164534);
    this.YLb = true;
    this.YLe = new Rect();
    this.YLf = new LinkedList();
    this.YLg = new LinkedList();
    AppMethodBeat.o(164534);
  }
  
  public HeadFooterLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164535);
    this.YLb = true;
    this.YLe = new Rect();
    this.YLf = new LinkedList();
    this.YLg = new LinkedList();
    AppMethodBeat.o(164535);
  }
  
  public static void bh(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(219721);
    kotlin.g.b.p.k(paramString, "log");
    if (!paramBoolean) {
      Log.i("HeadFooterLayout", paramString);
    }
    AppMethodBeat.o(219721);
  }
  
  private void ihc()
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
  
  public static boolean x(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(219674);
    kotlin.g.b.p.k(paramRecyclerView, "target");
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
    {
      int[] arrayOfInt = ((StaggeredGridLayoutManager)paramRecyclerView).k(null);
      kotlin.g.b.p.j(arrayOfInt, "firstVisibleInfo");
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
            AppMethodBeat.o(219674);
            return true;
          }
          AppMethodBeat.o(219674);
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
          AppMethodBeat.o(219674);
          return true;
        }
        AppMethodBeat.o(219674);
        return false;
      }
    }
    AppMethodBeat.o(219674);
    return false;
  }
  
  public final boolean B(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(219679);
    kotlin.g.b.p.k(paramRecyclerView, "target");
    Object localObject = paramRecyclerView.getLayoutManager();
    int[] arrayOfInt;
    int k;
    int j;
    int i;
    if ((localObject instanceof StaggeredGridLayoutManager))
    {
      arrayOfInt = ((StaggeredGridLayoutManager)localObject).l(null);
      kotlin.g.b.p.j(arrayOfInt, "lastVisibleInfo");
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
              RecyclerView.getDecoratedBoundsWithMargins(localView, this.YLe);
              n = this.YLe.bottom;
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
        AppMethodBeat.o(219679);
        return bool1;
        if ((localObject instanceof LinearLayoutManager))
        {
          i = ((LinearLayoutManager)localObject).kL();
          if (i == ((LinearLayoutManager)localObject).getItemCount() - 1)
          {
            localObject = ((RecyclerView.LayoutManager)localObject).findViewByPosition(i);
            if (localObject != null)
            {
              RecyclerView.getDecoratedBoundsWithMargins((View)localObject, this.YLe);
              i = this.YLe.bottom;
              if ((i <= paramRecyclerView.getHeight()) && (i >= paramRecyclerView.getHeight() + 0))
              {
                AppMethodBeat.o(219679);
                return true;
              }
            }
          }
        }
      }
      AppMethodBeat.o(219679);
      return false;
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(164521);
    kotlin.g.b.p.k(paramView, "target");
    super.onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(164521);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(164514);
    kotlin.g.b.p.k(paramView, "target");
    kotlin.g.b.p.k(paramArrayOfInt, "consumed");
    super.onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt);
    int j = paramInt2 - paramArrayOfInt[1];
    boolean bool1;
    Object localObject1;
    if (((paramView instanceof RecyclerView)) && (kotlin.g.b.p.h(paramView, getRecyclerView())))
    {
      bool1 = false;
      if ((((RecyclerView)paramView).getLayoutManager() instanceof LinearLayoutManager))
      {
        localObject1 = ((RecyclerView)paramView).getLayoutManager();
        if (localObject1 == null)
        {
          paramView = new t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
          AppMethodBeat.o(164514);
          throw paramView;
        }
        if (((LinearLayoutManager)localObject1).getOrientation() == 1)
        {
          bool1 = true;
          paramInt2 = 1;
        }
      }
    }
    for (;;)
    {
      localObject1 = getRecyclerView();
      kotlin.g.b.p.k(localObject1, "target");
      Object localObject2 = ((RecyclerView)localObject1).getLayoutManager();
      int[] arrayOfInt;
      int k;
      int i;
      if ((localObject2 instanceof StaggeredGridLayoutManager))
      {
        arrayOfInt = ((StaggeredGridLayoutManager)localObject2).l(null);
        paramInt1 = 0;
        kotlin.g.b.p.j(arrayOfInt, "lastVisibleInfo");
        k = arrayOfInt.length;
        i = 0;
        label180:
        if (i < k)
        {
          if (arrayOfInt[i] != ((StaggeredGridLayoutManager)localObject2).getItemCount() - 1) {
            break label786;
          }
          paramInt1 = 1;
        }
      }
      label786:
      for (;;)
      {
        i += 1;
        break label180;
        bool1 = false;
        break;
        if (!(((RecyclerView)paramView).getLayoutManager() instanceof StaggeredGridLayoutManager)) {
          break label789;
        }
        localObject1 = ((RecyclerView)paramView).getLayoutManager();
        if (localObject1 == null)
        {
          paramView = new t("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager");
          AppMethodBeat.o(164514);
          throw paramView;
        }
        if (((StaggeredGridLayoutManager)localObject1).getOrientation() == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          paramInt2 = 0;
          break;
        }
        boolean bool2;
        if (paramInt1 != 0)
        {
          i = arrayOfInt.length;
          paramInt1 = 0;
          while (paramInt1 < i)
          {
            k = arrayOfInt[paramInt1];
            if (k != -1)
            {
              View localView = ((RecyclerView.LayoutManager)localObject2).findViewByPosition(k);
              if (localView != null)
              {
                RecyclerView.getDecoratedBoundsWithMargins(localView, this.YLe);
                if (this.YLe.bottom > ((RecyclerView)localObject1).getHeight()) {
                  break label681;
                }
              }
            }
            paramInt1 += 1;
          }
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label686;
          }
          localObject1 = ((RecyclerView)paramView).getLayoutManager();
          if (localObject1 == null) {
            kotlin.g.b.p.iCn();
          }
          kotlin.g.b.p.j(localObject1, "target.layoutManager!!");
          if (((RecyclerView.LayoutManager)localObject1).getItemCount() == 0) {
            break label686;
          }
          bool2 = true;
          label410:
          boolean bool3 = x(getRecyclerView());
          if ((!bool2) && (!bool3)) {
            break label716;
          }
          if (this.YKZ != null) {
            break label692;
          }
          i = 1;
          label439:
          if (bool2)
          {
            if ((int)getTranslationY() == -getHeadersHeight())
            {
              localObject1 = this.YKZ;
              if (localObject1 != null) {
                ((b)localObject1).MB(j);
              }
            }
            i = 1;
          }
          paramInt1 = i;
          if (bool3)
          {
            if ((int)getTranslationY() == 0)
            {
              localObject1 = this.YKZ;
              if (localObject1 != null)
              {
                paramInt1 = i;
                if (((b)localObject1).v(j, paramInt3, this.YLa) == true) {
                  break label532;
                }
              }
            }
            paramInt1 = 1;
          }
          label532:
          if (paramInt1 == 0) {
            break label698;
          }
          a(getRecyclerView(), this, j, j, bool2, bool1, paramArrayOfInt, paramInt3, bool3);
        }
        for (;;)
        {
          if (paramInt1 == 0) {
            a(paramView, j, paramArrayOfInt);
          }
          AppMethodBeat.o(164514);
          return;
          if ((localObject2 instanceof LinearLayoutManager))
          {
            paramInt1 = ((LinearLayoutManager)localObject2).kL();
            if (paramInt1 == ((LinearLayoutManager)localObject2).getItemCount() - 1)
            {
              localObject2 = ((RecyclerView.LayoutManager)localObject2).findViewByPosition(paramInt1);
              if (localObject2 != null)
              {
                RecyclerView.getDecoratedBoundsWithMargins((View)localObject2, this.YLe);
                if (this.YLe.bottom <= ((RecyclerView)localObject1).getHeight())
                {
                  ((View)localObject2).getHitRect(this.YLe);
                  if (this.YLe.bottom <= ((RecyclerView)localObject1).getHeight())
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
          label681:
          paramInt1 = 0;
          break;
          label686:
          bool2 = false;
          break label410;
          label692:
          i = 0;
          break label439;
          label698:
          if (paramInt2 != 0) {
            paramArrayOfInt[1] = j;
          }
          this.YLa = true;
          continue;
          label716:
          localObject1 = ((RecyclerView)paramView).getLayoutManager();
          if (localObject1 == null) {
            kotlin.g.b.p.iCn();
          }
          kotlin.g.b.p.j(localObject1, "target.layoutManager!!");
          if (((RecyclerView.LayoutManager)localObject1).getItemCount() <= 0)
          {
            localObject1 = this.YKZ;
            if (localObject1 != null) {
              ((b)localObject1).v(j, paramInt3, this.YLa);
            }
            this.YLa = true;
          }
          paramInt1 = 0;
        }
      }
      label789:
      paramInt2 = 0;
    }
  }
  
  public void a(View paramView, int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(164515);
    kotlin.g.b.p.k(paramView, "target");
    kotlin.g.b.p.k(paramArrayOfInt, "consumed");
    AppMethodBeat.o(164515);
  }
  
  public void a(RecyclerView paramRecyclerView, HeadFooterLayout paramHeadFooterLayout, int paramInt)
  {
    AppMethodBeat.i(219722);
    kotlin.g.b.p.k(paramRecyclerView, "recyclerView");
    kotlin.g.b.p.k(paramHeadFooterLayout, "parent");
    AppMethodBeat.o(219722);
  }
  
  public void a(RecyclerView paramRecyclerView, HeadFooterLayout paramHeadFooterLayout, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int[] paramArrayOfInt, int paramInt3, boolean paramBoolean3)
  {
    AppMethodBeat.i(219730);
    kotlin.g.b.p.k(paramRecyclerView, "recyclerView");
    kotlin.g.b.p.k(paramHeadFooterLayout, "parent");
    kotlin.g.b.p.k(paramArrayOfInt, "consumed");
    if ((paramBoolean1) && (paramBoolean3)) {
      paramInt3 = a.clamp((int)getTranslationY() - paramInt2, -getHeadersHeight() - getFootersHeight() - this.YLk, 0);
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
      bh("onOverScroll dy:" + paramInt1 + " dampingDy:" + paramInt2 + " isEnd:" + paramBoolean1 + " consumed[1]:" + paramArrayOfInt + "[1] translationY:" + getTranslationY() + " targetY:" + paramInt3 + " headersHeight:" + getHeadersHeight() + " footersHeight:" + getFootersHeight(), true);
      AppMethodBeat.o(219730);
      return;
      if (paramBoolean1) {
        paramInt3 = a.clamp((int)getTranslationY() - paramInt2, -getHeadersHeight() - getFootersHeight() - this.YLk, -getHeadersHeight());
      } else {
        paramInt3 = a.clamp((int)getTranslationY() - paramInt2, -getHeadersHeight(), 0);
      }
    }
  }
  
  public boolean a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164519);
    kotlin.g.b.p.k(paramView1, "child");
    kotlin.g.b.p.k(paramView2, "target");
    if (this.YLc)
    {
      bool = super.startNestedScroll(paramInt1);
      AppMethodBeat.o(164519);
      return bool;
    }
    boolean bool = this.YLb;
    AppMethodBeat.o(164519);
    return bool;
  }
  
  public final void aa(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(164524);
    kotlin.g.b.p.k(paramView, "view");
    getHeaderViews().add(paramView);
    this.YLj = paramBoolean;
    requestLayout();
    AppMethodBeat.o(164524);
  }
  
  public final void ab(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(219691);
    kotlin.g.b.p.k(paramView, "view");
    if (getHeaderViews().remove(paramView))
    {
      removeView(paramView);
      this.YLj = paramBoolean;
      requestLayout();
    }
    AppMethodBeat.o(219691);
  }
  
  public final void ac(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(164525);
    kotlin.g.b.p.k(paramView, "view");
    getFooterViews().add(paramView);
    this.YLj = paramBoolean;
    requestLayout();
    bh("[addFooter] view=" + paramView + " isDirty=" + paramBoolean + " hash=" + hashCode(), false);
    AppMethodBeat.o(164525);
  }
  
  public final void ad(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(219700);
    kotlin.g.b.p.k(paramView, "view");
    if (getFooterViews().remove(paramView))
    {
      this.YLj = paramBoolean;
      removeView(paramView);
      requestLayout();
      bh("[removeFooter] view=" + paramView + " isDirty=" + paramBoolean + " hash=" + hashCode(), false);
    }
    AppMethodBeat.o(219700);
  }
  
  public final View azn(int paramInt)
  {
    AppMethodBeat.i(219698);
    Iterator localIterator = ((Iterable)getFooterViews()).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (paramInt == ((View)localObject).getId())
      {
        i = 1;
        label51:
        if (i == 0) {
          break label71;
        }
      }
    }
    for (;;)
    {
      localObject = (View)localObject;
      AppMethodBeat.o(219698);
      return localObject;
      i = 0;
      break label51;
      label71:
      break;
      localObject = null;
    }
  }
  
  public void b(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164520);
    kotlin.g.b.p.k(paramView1, "p0");
    kotlin.g.b.p.k(paramView2, "p1");
    AppMethodBeat.o(164520);
  }
  
  public final boolean dwe()
  {
    return this.YLb;
  }
  
  public final int getExtraOverScrollFooterDx()
  {
    return this.YLk;
  }
  
  public LinkedList<View> getFooterViews()
  {
    return this.YLg;
  }
  
  public int getFootersHeight()
  {
    return this.YLi;
  }
  
  public LinkedList<View> getHeaderViews()
  {
    return this.YLf;
  }
  
  public int getHeadersHeight()
  {
    return this.YLh;
  }
  
  public final m<Integer, Integer, x> getOnTranslateYCallback()
  {
    return this.YLd;
  }
  
  public final b getOverCallback()
  {
    return this.YKZ;
  }
  
  public RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(219685);
    RecyclerView localRecyclerView = this.jLl;
    if (localRecyclerView == null) {
      kotlin.g.b.p.bGy("recyclerView");
    }
    AppMethodBeat.o(219685);
    return localRecyclerView;
  }
  
  public final boolean ihb()
  {
    return this.YLc;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return true;
  }
  
  public void l(View paramView, int paramInt)
  {
    AppMethodBeat.i(164518);
    kotlin.g.b.p.k(paramView, "target");
    b localb = this.YKZ;
    if (localb != null) {
      localb.dtZ();
    }
    this.YLa = false;
    if (((paramView instanceof RecyclerView)) && ((((RecyclerView)paramView).getLayoutManager() instanceof LinearLayoutManager)) && (kotlin.g.b.p.h(paramView, getRecyclerView())))
    {
      a(getRecyclerView(), this, paramInt);
      AppMethodBeat.o(164518);
      return;
    }
    if (((paramView instanceof RecyclerView)) && ((((RecyclerView)paramView).getLayoutManager() instanceof StaggeredGridLayoutManager)) && (kotlin.g.b.p.h(paramView, getRecyclerView()))) {
      a(getRecyclerView(), this, paramInt);
    }
    AppMethodBeat.o(164518);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(164528);
    super.onFinishInflate();
    ihc();
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
        if (!kotlin.g.b.p.h(localObject, getRecyclerView()))
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
    if (this.YLj)
    {
      this.YLj = false;
      ihc();
    }
    AppMethodBeat.o(164526);
  }
  
  public final void setConsumeOverScroll(boolean paramBoolean)
  {
    this.YLa = paramBoolean;
  }
  
  public final void setEnableNestedScroll(boolean paramBoolean)
  {
    this.YLb = paramBoolean;
  }
  
  public final void setExtraOverScrollFooterDx(int paramInt)
  {
    this.YLk = paramInt;
  }
  
  public void setFootersHeight(int paramInt)
  {
    this.YLi = paramInt;
  }
  
  public void setHeadersHeight(int paramInt)
  {
    this.YLh = paramInt;
  }
  
  public final void setOnTranslateYCallback(m<? super Integer, ? super Integer, x> paramm)
  {
    this.YLd = paramm;
  }
  
  public final void setOverCallback(b paramb)
  {
    this.YKZ = paramb;
  }
  
  public void setRecyclerView(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(219687);
    kotlin.g.b.p.k(paramRecyclerView, "<set-?>");
    this.jLl = paramRecyclerView;
    AppMethodBeat.o(219687);
  }
  
  public final void setSuperNestedScroll(boolean paramBoolean)
  {
    this.YLc = paramBoolean;
  }
  
  public void setTranslationY(float paramFloat)
  {
    AppMethodBeat.i(219653);
    super.setTranslationY(paramFloat);
    m localm = this.YLd;
    if (localm != null)
    {
      localm.invoke(Integer.valueOf(0), Integer.valueOf((int)paramFloat));
      AppMethodBeat.o(219653);
      return;
    }
    AppMethodBeat.o(219653);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/HeadFooterLayout$Companion;", "", "()V", "TAG", "", "isDebug", "", "libmmui_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "", "onOverEnd", "", "dx", "", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "", "libmmui_release"})
  public static abstract interface b
  {
    public abstract boolean MB(int paramInt);
    
    public abstract void dtZ();
    
    public abstract boolean v(int paramInt1, int paramInt2, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.HeadFooterLayout
 * JD-Core Version:    0.7.0.1
 */