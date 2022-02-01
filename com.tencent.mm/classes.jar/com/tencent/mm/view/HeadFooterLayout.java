package com.tencent.mm.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.n;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import d.v;
import d.y;
import java.util.Iterator;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/view/HeadFooterLayout;", "Landroid/widget/LinearLayout;", "Landroid/support/v4/view/NestedScrollingParent2;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "decoratedBounds", "Landroid/graphics/Rect;", "extraOverScrollFooterDx", "getExtraOverScrollFooterDx", "()I", "setExtraOverScrollFooterDx", "(I)V", "footerViews", "Ljava/util/LinkedList;", "Landroid/view/View;", "getFooterViews", "()Ljava/util/LinkedList;", "footersHeight", "getFootersHeight", "setFootersHeight", "headerViews", "getHeaderViews", "headersHeight", "getHeadersHeight", "setHeadersHeight", "isConsumeOverScroll", "", "()Z", "setConsumeOverScroll", "(Z)V", "isDirtyLayout", "isEnableNestedScroll", "setEnableNestedScroll", "onOverScrollListener", "Lkotlin/Function0;", "", "getOnOverScrollListener", "()Lkotlin/jvm/functions/Function0;", "setOnOverScrollListener", "(Lkotlin/jvm/functions/Function0;)V", "overCallback", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "getOverCallback", "()Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "setOverCallback", "(Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "addFooter", "view", "isDirty", "addHeader", "getFooter", "id", "getHeader", "isFirstItemReachTop", "target", "isLastItemBottomVisible", "isLastItemReachBottom", "offset", "onBindRecyclerView", "onFinishInflate", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onNestedPreScroll", "dx", "dy", "consumed", "", "type", "onNestedScroll", "p0", "p1", "p2", "p3", "p4", "p5", "onNestedScrollAccepted", "onNotOverScroll", "onOverScroll", "parent", "dampingDy", "isEnd", "isVertical", "isTopOverScroll", "onStartNestedScroll", "onStopNestedScroll", "onStopScroll", "onViewAdded", "child", "print", "log", "", "isVerbose", "removeFooter", "removeHeader", "requestLayout", "resetChildren", "Companion", "OverCallback", "libmmui_release"})
public class HeadFooterLayout
  extends LinearLayout
  implements n
{
  public static final a HUU;
  private b HUJ;
  private boolean HUK;
  private boolean HUL;
  private d.g.a.a<y> HUM;
  private final Rect HUN;
  private final LinkedList<View> HUO;
  private final LinkedList<View> HUP;
  private int HUQ;
  private int HUR;
  boolean HUS;
  private int HUT;
  public RecyclerView fPw;
  
  static
  {
    AppMethodBeat.i(164536);
    HUU = new a((byte)0);
    AppMethodBeat.o(164536);
  }
  
  public HeadFooterLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164534);
    this.HUL = true;
    this.HUN = new Rect();
    this.HUO = new LinkedList();
    this.HUP = new LinkedList();
    AppMethodBeat.o(164534);
  }
  
  public HeadFooterLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164535);
    this.HUL = true;
    this.HUN = new Rect();
    this.HUO = new LinkedList();
    this.HUP = new LinkedList();
    AppMethodBeat.o(164535);
  }
  
  public static void dq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(203963);
    k.h(paramString, "log");
    if (paramBoolean)
    {
      ad.v("HeadFooterLayout", paramString);
      AppMethodBeat.o(203963);
      return;
    }
    ad.i("HeadFooterLayout", paramString);
    AppMethodBeat.o(203963);
  }
  
  private void fiq()
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
  
  public static boolean s(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(164516);
    k.h(paramRecyclerView, "target");
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
    {
      int[] arrayOfInt = ((StaggeredGridLayoutManager)paramRecyclerView).x(null);
      k.g(arrayOfInt, "firstVisibleInfo");
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
        paramRecyclerView = paramRecyclerView.bY(0);
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
      paramRecyclerView = paramRecyclerView.bY(0);
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
  
  private boolean t(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(164517);
    k.h(paramRecyclerView, "target");
    Object localObject = paramRecyclerView.getLayoutManager();
    int[] arrayOfInt;
    int k;
    int j;
    int i;
    if ((localObject instanceof StaggeredGridLayoutManager))
    {
      arrayOfInt = ((StaggeredGridLayoutManager)localObject).ma();
      k.g(arrayOfInt, "lastVisibleInfo");
      k = arrayOfInt.length;
      j = 0;
      i = 0;
      if (j < k)
      {
        if (arrayOfInt[j] != ((StaggeredGridLayoutManager)localObject).getItemCount() - 1) {
          break label263;
        }
        i = 1;
      }
    }
    label263:
    for (;;)
    {
      j += 1;
      break;
      if (i != 0)
      {
        j = arrayOfInt.length;
        i = 0;
        while (i < j)
        {
          k = arrayOfInt[i];
          if (k != -1)
          {
            View localView = ((RecyclerView.i)localObject).bY(k);
            if (localView != null)
            {
              RecyclerView.c(localView, this.HUN);
              if (this.HUN.bottom > paramRecyclerView.getHeight())
              {
                AppMethodBeat.o(164517);
                return false;
              }
            }
          }
          i += 1;
        }
        AppMethodBeat.o(164517);
        return true;
        if ((localObject instanceof LinearLayoutManager))
        {
          i = ((LinearLayoutManager)localObject).jQ();
          if (i == ((LinearLayoutManager)localObject).getItemCount() - 1)
          {
            localObject = ((RecyclerView.i)localObject).bY(i);
            if (localObject != null)
            {
              new Rect();
              RecyclerView.c((View)localObject, this.HUN);
              if (this.HUN.bottom <= paramRecyclerView.getHeight())
              {
                AppMethodBeat.o(164517);
                return true;
              }
            }
          }
        }
      }
      AppMethodBeat.o(164517);
      return false;
    }
  }
  
  public final boolean C(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(203962);
    k.h(paramRecyclerView, "target");
    Object localObject = paramRecyclerView.getLayoutManager();
    int[] arrayOfInt;
    int k;
    int j;
    int i;
    if ((localObject instanceof StaggeredGridLayoutManager))
    {
      arrayOfInt = ((StaggeredGridLayoutManager)localObject).ma();
      k.g(arrayOfInt, "lastVisibleInfo");
      k = arrayOfInt.length;
      j = 0;
      i = 0;
      if (j < k)
      {
        if (arrayOfInt[j] != ((StaggeredGridLayoutManager)localObject).getItemCount() - 1) {
          break label339;
        }
        i = 1;
      }
    }
    label339:
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
            localView = ((RecyclerView.i)localObject).bY(n);
            bool2 = bool1;
            k = j;
            if (localView != null)
            {
              RecyclerView.c(localView, this.HUN);
              n = this.HUN.bottom;
              bool2 = bool1;
              k = j;
              if (localView.getBottom() > j) {
                if ((n > paramRecyclerView.getHeight()) || (n < paramRecyclerView.getHeight() + 0)) {
                  break label229;
                }
              }
            }
          }
          label229:
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
        AppMethodBeat.o(203962);
        return bool1;
        if ((localObject instanceof LinearLayoutManager))
        {
          i = ((LinearLayoutManager)localObject).jQ();
          if (i == ((LinearLayoutManager)localObject).getItemCount() - 1)
          {
            localObject = ((RecyclerView.i)localObject).bY(i);
            if (localObject != null)
            {
              RecyclerView.c((View)localObject, this.HUN);
              i = this.HUN.bottom;
              if ((i <= paramRecyclerView.getHeight()) && (i >= paramRecyclerView.getHeight() + 0))
              {
                AppMethodBeat.o(203962);
                return true;
              }
            }
          }
        }
      }
      AppMethodBeat.o(203962);
      return false;
    }
  }
  
  public final void K(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(164524);
    k.h(paramView, "view");
    getHeaderViews().add(paramView);
    this.HUS = paramBoolean;
    requestLayout();
    AppMethodBeat.o(164524);
  }
  
  public final void L(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(164525);
    k.h(paramView, "view");
    getFooterViews().add(paramView);
    this.HUS = paramBoolean;
    requestLayout();
    dq("[addFooter] view=" + paramView + " isDirty=" + paramBoolean + " hash=" + hashCode(), false);
    AppMethodBeat.o(164525);
  }
  
  public void a(RecyclerView paramRecyclerView, HeadFooterLayout paramHeadFooterLayout, int paramInt)
  {
    AppMethodBeat.i(164532);
    k.h(paramRecyclerView, "recyclerView");
    k.h(paramHeadFooterLayout, "parent");
    AppMethodBeat.o(164532);
  }
  
  public void a(RecyclerView paramRecyclerView, HeadFooterLayout paramHeadFooterLayout, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int[] paramArrayOfInt, int paramInt3, boolean paramBoolean3)
  {
    AppMethodBeat.i(164533);
    k.h(paramRecyclerView, "recyclerView");
    k.h(paramHeadFooterLayout, "parent");
    k.h(paramArrayOfInt, "consumed");
    if (!paramBoolean1) {}
    for (paramInt2 = android.support.v4.b.a.clamp((int)getTranslationY() - paramInt2, -getHeadersHeight(), 0);; paramInt2 = android.support.v4.b.a.clamp((int)getTranslationY() - paramInt2, -getHeadersHeight() - getFootersHeight() - this.HUT, -getHeadersHeight()))
    {
      if (getTranslationY() != -getHeadersHeight()) {
        paramArrayOfInt[1] = paramInt1;
      }
      if (getTranslationY() != paramInt2)
      {
        setTranslationY(paramInt2);
        paramArrayOfInt[1] = paramInt1;
      }
      AppMethodBeat.o(164533);
      return;
    }
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(164521);
    k.h(paramView, "p0");
    AppMethodBeat.o(164521);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(164514);
    k.h(paramView, "target");
    k.h(paramArrayOfInt, "consumed");
    Object localObject;
    boolean bool;
    if (((paramView instanceof RecyclerView)) && (k.g(paramView, getRecyclerView())) && ((((RecyclerView)paramView).getLayoutManager() instanceof LinearLayoutManager)))
    {
      localObject = ((RecyclerView)paramView).getLayoutManager();
      if (localObject == null)
      {
        paramView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(164514);
        throw paramView;
      }
      localObject = (LinearLayoutManager)localObject;
      if (((LinearLayoutManager)localObject).getOrientation() == 1) {
        bool = true;
      }
      while (s(getRecyclerView()))
      {
        localObject = this.HUM;
        if (localObject != null) {
          ((d.g.a.a)localObject).invoke();
        }
        if (this.HUJ != null)
        {
          localObject = this.HUJ;
          if (localObject == null) {
            k.fvU();
          }
          if (((b)localObject).r(paramInt2, paramInt3, this.HUK)) {}
        }
        else
        {
          a(getRecyclerView(), this, paramInt2, paramInt2, false, bool, paramArrayOfInt, paramInt3, true);
          paramInt1 = 1;
          if (paramInt1 == 0) {
            a(paramView, paramInt2, paramArrayOfInt);
          }
          AppMethodBeat.o(164514);
          return;
          bool = false;
          continue;
        }
        paramArrayOfInt[1] = paramInt2;
      }
    }
    for (;;)
    {
      this.HUK = true;
      do
      {
        do
        {
          paramInt1 = 0;
          break;
          if ((t(getRecyclerView())) && (((LinearLayoutManager)localObject).getItemCount() != 0))
          {
            localObject = this.HUM;
            if (localObject != null) {
              ((d.g.a.a)localObject).invoke();
            }
            if (this.HUJ != null)
            {
              localObject = this.HUJ;
              if (localObject == null) {
                k.fvU();
              }
              ((b)localObject).CF(paramInt2);
            }
            a(getRecyclerView(), this, paramInt2, paramInt2, true, bool, paramArrayOfInt, paramInt3, false);
            paramInt1 = 1;
            break;
          }
          if (((LinearLayoutManager)localObject).getItemCount() <= 0)
          {
            localObject = this.HUM;
            if (localObject != null) {
              ((d.g.a.a)localObject).invoke();
            }
            localObject = this.HUJ;
            if (localObject != null) {
              ((b)localObject).r(paramInt2, paramInt3, this.HUK);
            }
            this.HUK = true;
          }
          paramInt1 = 0;
          break;
        } while ((!(paramView instanceof RecyclerView)) || (!k.g(paramView, getRecyclerView())) || (!(((RecyclerView)paramView).getLayoutManager() instanceof StaggeredGridLayoutManager)));
        localObject = ((RecyclerView)paramView).getLayoutManager();
        if (localObject == null)
        {
          paramView = new v("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager");
          AppMethodBeat.o(164514);
          throw paramView;
        }
        localObject = (StaggeredGridLayoutManager)localObject;
        if (((StaggeredGridLayoutManager)localObject).getOrientation() == 1) {
          bool = true;
        }
        for (;;)
        {
          if (s(getRecyclerView()))
          {
            if (this.HUJ != null)
            {
              localObject = this.HUJ;
              if (localObject == null) {
                k.fvU();
              }
              if (((b)localObject).r(paramInt2, paramInt3, this.HUK)) {}
            }
            else
            {
              a(getRecyclerView(), this, paramInt2, paramInt2, false, bool, paramArrayOfInt, paramInt3, true);
              paramInt1 = 1;
              break;
              bool = false;
              continue;
            }
            this.HUK = true;
            paramInt1 = 0;
            break;
          }
        }
        if ((t(getRecyclerView())) && (((StaggeredGridLayoutManager)localObject).getItemCount() != 0))
        {
          if (this.HUJ != null)
          {
            localObject = this.HUJ;
            if (localObject == null) {
              k.fvU();
            }
            ((b)localObject).CF(paramInt2);
          }
          a(getRecyclerView(), this, paramInt2, paramInt2, true, bool, paramArrayOfInt, paramInt3, false);
          paramInt1 = 1;
          break;
        }
      } while (((StaggeredGridLayoutManager)localObject).getItemCount() > 0);
      localObject = this.HUJ;
      if (localObject != null) {
        ((b)localObject).r(paramInt2, paramInt3, this.HUK);
      }
    }
  }
  
  public void a(View paramView, int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(164515);
    k.h(paramView, "target");
    k.h(paramArrayOfInt, "consumed");
    AppMethodBeat.o(164515);
  }
  
  public final boolean a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164519);
    k.h(paramView1, "p0");
    k.h(paramView2, "p1");
    boolean bool = this.HUL;
    AppMethodBeat.o(164519);
    return bool;
  }
  
  public final void b(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164520);
    k.h(paramView1, "p0");
    k.h(paramView2, "p1");
    AppMethodBeat.o(164520);
  }
  
  public final int getExtraOverScrollFooterDx()
  {
    return this.HUT;
  }
  
  public LinkedList<View> getFooterViews()
  {
    return this.HUP;
  }
  
  public int getFootersHeight()
  {
    return this.HUR;
  }
  
  public LinkedList<View> getHeaderViews()
  {
    return this.HUO;
  }
  
  public int getHeadersHeight()
  {
    return this.HUQ;
  }
  
  public final d.g.a.a<y> getOnOverScrollListener()
  {
    return this.HUM;
  }
  
  public final b getOverCallback()
  {
    return this.HUJ;
  }
  
  public RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(164522);
    RecyclerView localRecyclerView = this.fPw;
    if (localRecyclerView == null) {
      k.aPZ("recyclerView");
    }
    AppMethodBeat.o(164522);
    return localRecyclerView;
  }
  
  public final void j(View paramView, int paramInt)
  {
    AppMethodBeat.i(164518);
    k.h(paramView, "target");
    b localb = this.HUJ;
    if (localb != null) {
      localb.cms();
    }
    this.HUK = false;
    if (((paramView instanceof RecyclerView)) && ((((RecyclerView)paramView).getLayoutManager() instanceof LinearLayoutManager)) && (k.g(paramView, getRecyclerView())))
    {
      a(getRecyclerView(), this, paramInt);
      AppMethodBeat.o(164518);
      return;
    }
    if (((paramView instanceof RecyclerView)) && ((((RecyclerView)paramView).getLayoutManager() instanceof StaggeredGridLayoutManager)) && (k.g(paramView, getRecyclerView()))) {
      a(getRecyclerView(), this, paramInt);
    }
    AppMethodBeat.o(164518);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(164528);
    super.onFinishInflate();
    fiq();
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
        if (!k.g(localObject, getRecyclerView()))
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
    if (this.HUS)
    {
      this.HUS = false;
      fiq();
    }
    AppMethodBeat.o(164526);
  }
  
  public final void setConsumeOverScroll(boolean paramBoolean)
  {
    this.HUK = paramBoolean;
  }
  
  public final void setEnableNestedScroll(boolean paramBoolean)
  {
    this.HUL = paramBoolean;
  }
  
  public final void setExtraOverScrollFooterDx(int paramInt)
  {
    this.HUT = paramInt;
  }
  
  public void setFootersHeight(int paramInt)
  {
    this.HUR = paramInt;
  }
  
  public void setHeadersHeight(int paramInt)
  {
    this.HUQ = paramInt;
  }
  
  public final void setOnOverScrollListener(d.g.a.a<y> parama)
  {
    this.HUM = parama;
  }
  
  public final void setOverCallback(b paramb)
  {
    this.HUJ = paramb;
  }
  
  public void setRecyclerView(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(164523);
    k.h(paramRecyclerView, "<set-?>");
    this.fPw = paramRecyclerView;
    AppMethodBeat.o(164523);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/view/HeadFooterLayout$Companion;", "", "()V", "TAG", "", "isDebug", "", "libmmui_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "", "onOverEnd", "", "dx", "", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "", "libmmui_release"})
  public static abstract interface b
  {
    public abstract boolean CF(int paramInt);
    
    public abstract void cms();
    
    public abstract boolean r(int paramInt1, int paramInt2, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.HeadFooterLayout
 * JD-Core Version:    0.7.0.1
 */