package com.tencent.mm.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import androidx.core.b.a;
import androidx.core.g.p;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/HeadFooterLayout;", "Landroid/widget/LinearLayout;", "Landroidx/core/view/NestedScrollingParent2;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "decoratedBounds", "Landroid/graphics/Rect;", "extraOverScrollFooterDx", "getExtraOverScrollFooterDx", "()I", "setExtraOverScrollFooterDx", "(I)V", "footerViews", "Ljava/util/LinkedList;", "Landroid/view/View;", "getFooterViews", "()Ljava/util/LinkedList;", "footersHeight", "getFootersHeight", "setFootersHeight", "headerViews", "getHeaderViews", "headersHeight", "getHeadersHeight", "setHeadersHeight", "isConsumeOverScroll", "", "()Z", "setConsumeOverScroll", "(Z)V", "isDirtyLayout", "isEnableNestedScroll", "setEnableNestedScroll", "isSuperNestedScroll", "setSuperNestedScroll", "onTranslateYCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "dx", "dy", "", "getOnTranslateYCallback", "()Lkotlin/jvm/functions/Function2;", "setOnTranslateYCallback", "(Lkotlin/jvm/functions/Function2;)V", "overCallback", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "getOverCallback", "()Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "setOverCallback", "(Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "addFooter", "view", "isDirty", "addHeader", "getFooter", "id", "getHeader", "isFirstItemReachTop", "target", "isLastItemBottomVisible", "isLastItemReachBottom", "offset", "isNestedScrollingEnabled", "onBindRecyclerView", "onFinishInflate", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onNestedPreScroll", "consumed", "", "type", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "p0", "p1", "p2", "p3", "onNotOverScroll", "onOverScroll", "parent", "dampingDy", "isEnd", "isVertical", "isTopOverScroll", "onStartNestedScroll", "child", "axes", "onStopNestedScroll", "onStopScroll", "onViewAdded", "print", "log", "", "isVerbose", "removeFooter", "removeHeader", "requestLayout", "resetChildren", "setTranslationY", "translationY", "", "Companion", "OverCallback", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public class HeadFooterLayout
  extends LinearLayout
  implements p
{
  public static final HeadFooterLayout.a agGO;
  private final Rect FdB;
  private b agGP;
  private boolean agGQ;
  private boolean agGR;
  private boolean agGS;
  private m<? super Integer, ? super Integer, ah> agGT;
  private final LinkedList<View> agGU;
  private final LinkedList<View> agGV;
  private int agGW;
  private int agGX;
  private boolean agGY;
  private int agGZ;
  public RecyclerView mkw;
  
  static
  {
    AppMethodBeat.i(164536);
    agGO = new HeadFooterLayout.a((byte)0);
    AppMethodBeat.o(164536);
  }
  
  public HeadFooterLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164534);
    this.agGR = true;
    this.FdB = new Rect();
    this.agGU = new LinkedList();
    this.agGV = new LinkedList();
    AppMethodBeat.o(164534);
  }
  
  public HeadFooterLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164535);
    this.agGR = true;
    this.FdB = new Rect();
    this.agGU = new LinkedList();
    this.agGV = new LinkedList();
    AppMethodBeat.o(164535);
  }
  
  public static boolean N(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(234652);
    s.u(paramRecyclerView, "target");
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
    {
      int[] arrayOfInt = ((StaggeredGridLayoutManager)paramRecyclerView).n(null);
      s.s(arrayOfInt, "firstVisibleInfo");
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
        paramRecyclerView = ((StaggeredGridLayoutManager)paramRecyclerView).findViewByPosition(0);
        if (paramRecyclerView != null)
        {
          if (paramRecyclerView.getTop() >= 0)
          {
            AppMethodBeat.o(234652);
            return true;
          }
          AppMethodBeat.o(234652);
          return false;
        }
      }
    }
    else if ((paramRecyclerView instanceof LinearLayoutManager))
    {
      paramRecyclerView = ((LinearLayoutManager)paramRecyclerView).findViewByPosition(0);
      if (paramRecyclerView != null)
      {
        if (paramRecyclerView.getTop() >= 0)
        {
          AppMethodBeat.o(234652);
          return true;
        }
        AppMethodBeat.o(234652);
        return false;
      }
    }
    AppMethodBeat.o(234652);
    return false;
  }
  
  public static void eE(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(234678);
    s.u(paramString, "log");
    if (!paramBoolean) {
      Log.i("HeadFooterLayout", paramString);
    }
    AppMethodBeat.o(234678);
  }
  
  private boolean isLastItemBottomVisible(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(234656);
    s.u(paramRecyclerView, "target");
    Object localObject = paramRecyclerView.getLayoutManager();
    int[] arrayOfInt;
    int k;
    int j;
    int i;
    if ((localObject instanceof StaggeredGridLayoutManager))
    {
      arrayOfInt = ((StaggeredGridLayoutManager)localObject).o(null);
      s.s(arrayOfInt, "lastVisibleInfo");
      k = arrayOfInt.length;
      j = 0;
      i = 0;
      if (j < k)
      {
        if (arrayOfInt[j] != ((StaggeredGridLayoutManager)localObject).getItemCount() - 1) {
          break label293;
        }
        i = 1;
      }
    }
    label293:
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
            View localView = ((StaggeredGridLayoutManager)localObject).findViewByPosition(k);
            if (localView != null)
            {
              RecyclerView.getDecoratedBoundsWithMargins(localView, this.FdB);
              if (this.FdB.bottom > paramRecyclerView.getHeight())
              {
                AppMethodBeat.o(234656);
                return false;
              }
            }
          }
          i += 1;
        }
        AppMethodBeat.o(234656);
        return true;
        if ((localObject instanceof LinearLayoutManager))
        {
          i = ((LinearLayoutManager)localObject).Jw();
          if (i == ((LinearLayoutManager)localObject).getItemCount() - 1)
          {
            localObject = ((LinearLayoutManager)localObject).findViewByPosition(i);
            if (localObject != null)
            {
              RecyclerView.getDecoratedBoundsWithMargins((View)localObject, this.FdB);
              if (this.FdB.bottom <= paramRecyclerView.getHeight())
              {
                ((View)localObject).getHitRect(this.FdB);
                if (this.FdB.bottom <= paramRecyclerView.getHeight())
                {
                  AppMethodBeat.o(234656);
                  return true;
                }
                AppMethodBeat.o(234656);
                return false;
              }
            }
          }
        }
      }
      AppMethodBeat.o(234656);
      return false;
    }
  }
  
  private void jMq()
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
  
  public final boolean O(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(234720);
    s.u(paramRecyclerView, "target");
    Object localObject = paramRecyclerView.getLayoutManager();
    int[] arrayOfInt;
    int k;
    int j;
    int i;
    if ((localObject instanceof StaggeredGridLayoutManager))
    {
      arrayOfInt = ((StaggeredGridLayoutManager)localObject).o(null);
      s.s(arrayOfInt, "lastVisibleInfo");
      k = arrayOfInt.length;
      j = 0;
      i = 0;
      if (j < k)
      {
        if (arrayOfInt[j] != ((StaggeredGridLayoutManager)localObject).getItemCount() - 1) {
          break label316;
        }
        i = 1;
      }
    }
    label187:
    label316:
    for (;;)
    {
      j += 1;
      break;
      boolean bool;
      if (i != 0)
      {
        k = arrayOfInt.length;
        i = 0;
        bool = false;
        j = 0;
        if (i < k)
        {
          int m = arrayOfInt[i];
          if (m == -1) {
            break label313;
          }
          View localView = ((StaggeredGridLayoutManager)localObject).findViewByPosition(m);
          if (localView == null) {
            break label313;
          }
          RecyclerView.getDecoratedBoundsWithMargins(localView, this.FdB);
          m = this.FdB.bottom;
          if (localView.getBottom() <= j) {
            break label313;
          }
          if ((m <= paramRecyclerView.getHeight()) && (m >= paramRecyclerView.getHeight() + 0))
          {
            bool = true;
            j = localView.getBottom();
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        bool = false;
        break label187;
        AppMethodBeat.o(234720);
        return bool;
        if ((localObject instanceof LinearLayoutManager))
        {
          i = ((LinearLayoutManager)localObject).Jw();
          if (i == ((LinearLayoutManager)localObject).getItemCount() - 1)
          {
            localObject = ((LinearLayoutManager)localObject).findViewByPosition(i);
            if (localObject != null)
            {
              RecyclerView.getDecoratedBoundsWithMargins((View)localObject, this.FdB);
              i = this.FdB.bottom;
              if ((i <= paramRecyclerView.getHeight()) && (i >= paramRecyclerView.getHeight() + 0))
              {
                AppMethodBeat.o(234720);
                return true;
              }
            }
          }
        }
        AppMethodBeat.o(234720);
        return false;
      }
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(164521);
    s.u(paramView, "target");
    super.onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(164521);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(164514);
    s.u(paramView, "target");
    s.u(paramArrayOfInt, "consumed");
    super.onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt);
    int k = paramInt2 - paramArrayOfInt[1];
    boolean bool1;
    Object localObject;
    label123:
    boolean bool2;
    label159:
    label187:
    int j;
    if (((paramView instanceof RecyclerView)) && (s.p(paramView, getRecyclerView())))
    {
      bool1 = false;
      paramInt2 = 0;
      if ((((RecyclerView)paramView).getLayoutManager() instanceof LinearLayoutManager))
      {
        localObject = ((RecyclerView)paramView).getLayoutManager();
        if (localObject == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
          AppMethodBeat.o(164514);
          throw paramView;
        }
        if (((LinearLayoutManager)localObject).getOrientation() == 1)
        {
          bool1 = true;
          paramInt2 = 1;
          if (!isLastItemBottomVisible(getRecyclerView())) {
            break label430;
          }
          localObject = ((RecyclerView)paramView).getLayoutManager();
          s.checkNotNull(localObject);
          if (((RecyclerView.LayoutManager)localObject).getItemCount() == 0) {
            break label430;
          }
          bool2 = true;
          boolean bool3 = N(getRecyclerView());
          if ((!bool2) && (!bool3)) {
            break label471;
          }
          if (this.agGP != null) {
            break label436;
          }
          paramInt1 = 1;
          int i = paramInt1;
          if (bool2) {
            if ((int)getTranslationY() == -getHeadersHeight())
            {
              localObject = this.agGP;
              if ((localObject == null) || (((b)localObject).NK(k) != true)) {
                break label441;
              }
              j = 1;
              label235:
              i = paramInt1;
              if (j != 0) {}
            }
            else
            {
              i = 1;
            }
          }
          paramInt1 = i;
          if (bool3) {
            if ((int)getTranslationY() == 0)
            {
              localObject = this.agGP;
              if ((localObject == null) || (((b)localObject).v(k, paramInt3, this.agGQ) != true)) {
                break label447;
              }
              j = 1;
              label295:
              paramInt1 = i;
              if (j != 0) {}
            }
            else
            {
              paramInt1 = 1;
            }
          }
          if (paramInt1 == 0) {
            break label453;
          }
          a(getRecyclerView(), this, k, k, bool2, bool1, paramArrayOfInt, paramInt3, bool3);
        }
      }
    }
    for (;;)
    {
      if (paramInt1 == 0) {
        a(paramView, k, paramArrayOfInt);
      }
      AppMethodBeat.o(164514);
      return;
      bool1 = false;
      break;
      if (!(((RecyclerView)paramView).getLayoutManager() instanceof StaggeredGridLayoutManager)) {
        break label123;
      }
      localObject = ((RecyclerView)paramView).getLayoutManager();
      if (localObject == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager");
        AppMethodBeat.o(164514);
        throw paramView;
      }
      if (((StaggeredGridLayoutManager)localObject).mOrientation == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        paramInt2 = 0;
        break;
      }
      label430:
      bool2 = false;
      break label159;
      label436:
      paramInt1 = 0;
      break label187;
      label441:
      j = 0;
      break label235;
      label447:
      j = 0;
      break label295;
      label453:
      if (paramInt2 != 0) {
        paramArrayOfInt[1] = k;
      }
      this.agGQ = true;
      continue;
      label471:
      localObject = ((RecyclerView)paramView).getLayoutManager();
      s.checkNotNull(localObject);
      if (((RecyclerView.LayoutManager)localObject).getItemCount() <= 0)
      {
        localObject = this.agGP;
        if (localObject != null) {
          ((b)localObject).v(k, paramInt3, this.agGQ);
        }
        this.agGQ = true;
      }
      paramInt1 = 0;
    }
  }
  
  public void a(View paramView, int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(164515);
    s.u(paramView, "target");
    s.u(paramArrayOfInt, "consumed");
    AppMethodBeat.o(164515);
  }
  
  public void a(RecyclerView paramRecyclerView, HeadFooterLayout paramHeadFooterLayout, int paramInt)
  {
    AppMethodBeat.i(234795);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramHeadFooterLayout, "parent");
    AppMethodBeat.o(234795);
  }
  
  public void a(RecyclerView paramRecyclerView, HeadFooterLayout paramHeadFooterLayout, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int[] paramArrayOfInt, int paramInt3, boolean paramBoolean3)
  {
    int j = 0;
    AppMethodBeat.i(234805);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramHeadFooterLayout, "parent");
    s.u(paramArrayOfInt, "consumed");
    if ((paramBoolean1) && (paramBoolean3))
    {
      paramInt3 = a.clamp((int)getTranslationY() - paramInt2, -getHeadersHeight() - getFootersHeight() - this.agGZ, 0);
      if (getTranslationY() != -getHeadersHeight()) {
        break label311;
      }
    }
    label311:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        paramArrayOfInt[1] = paramInt1;
      }
      i = j;
      if (getTranslationY() == paramInt3) {
        i = 1;
      }
      if (i == 0)
      {
        setTranslationY(paramInt3);
        paramArrayOfInt[1] = paramInt1;
      }
      paramHeadFooterLayout.requestDisallowInterceptTouchEvent(true);
      eE("onOverScroll dy:" + paramInt1 + " dampingDy:" + paramInt2 + " isEnd:" + paramBoolean1 + " consumed[1]:" + paramArrayOfInt + "[1] translationY:" + getTranslationY() + " targetY:" + paramInt3 + " headersHeight:" + getHeadersHeight() + " footersHeight:" + getFootersHeight(), true);
      AppMethodBeat.o(234805);
      return;
      if (paramBoolean1)
      {
        paramInt3 = a.clamp((int)getTranslationY() - paramInt2, -getHeadersHeight() - getFootersHeight() - this.agGZ, -getHeadersHeight());
        break;
      }
      paramInt3 = a.clamp((int)getTranslationY() - paramInt2, -getHeadersHeight(), 0);
      break;
    }
  }
  
  public boolean a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164519);
    s.u(paramView1, "child");
    s.u(paramView2, "target");
    if (this.agGS)
    {
      bool = super.startNestedScroll(paramInt1);
      AppMethodBeat.o(164519);
      return bool;
    }
    boolean bool = this.agGR;
    AppMethodBeat.o(164519);
    return bool;
  }
  
  public final View aFR(int paramInt)
  {
    AppMethodBeat.i(234772);
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
      AppMethodBeat.o(234772);
      return localObject;
      i = 0;
      break label51;
      label71:
      break;
      localObject = null;
    }
  }
  
  public final void ag(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(164524);
    s.u(paramView, "view");
    getHeaderViews().add(paramView);
    this.agGY = paramBoolean;
    requestLayout();
    AppMethodBeat.o(164524);
  }
  
  public final void ah(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(234765);
    s.u(paramView, "view");
    if (getHeaderViews().remove(paramView))
    {
      removeView(paramView);
      this.agGY = paramBoolean;
      requestLayout();
    }
    AppMethodBeat.o(234765);
  }
  
  public final void ai(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(164525);
    s.u(paramView, "view");
    getFooterViews().add(paramView);
    this.agGY = paramBoolean;
    requestLayout();
    eE("[addFooter] view=" + paramView + " isDirty=" + paramBoolean + " hash=" + hashCode(), false);
    AppMethodBeat.o(164525);
  }
  
  public final void aj(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(234775);
    s.u(paramView, "view");
    if (getFooterViews().remove(paramView))
    {
      this.agGY = paramBoolean;
      removeView(paramView);
      requestLayout();
      eE("[removeFooter] view=" + paramView + " isDirty=" + paramBoolean + " hash=" + hashCode(), false);
    }
    AppMethodBeat.o(234775);
  }
  
  public void b(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164520);
    s.u(paramView1, "p0");
    s.u(paramView2, "p1");
    AppMethodBeat.o(164520);
  }
  
  public final boolean egA()
  {
    return this.agGR;
  }
  
  public final int getExtraOverScrollFooterDx()
  {
    return this.agGZ;
  }
  
  public LinkedList<View> getFooterViews()
  {
    return this.agGV;
  }
  
  public int getFootersHeight()
  {
    return this.agGX;
  }
  
  public LinkedList<View> getHeaderViews()
  {
    return this.agGU;
  }
  
  public int getHeadersHeight()
  {
    return this.agGW;
  }
  
  public final m<Integer, Integer, ah> getOnTranslateYCallback()
  {
    return this.agGT;
  }
  
  public final b getOverCallback()
  {
    return this.agGP;
  }
  
  public RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(234756);
    RecyclerView localRecyclerView = this.mkw;
    if (localRecyclerView != null)
    {
      AppMethodBeat.o(234756);
      return localRecyclerView;
    }
    s.bIx("recyclerView");
    AppMethodBeat.o(234756);
    return null;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return true;
  }
  
  public final boolean jMp()
  {
    return this.agGS;
  }
  
  public void l(View paramView, int paramInt)
  {
    AppMethodBeat.i(164518);
    s.u(paramView, "target");
    b localb = this.agGP;
    if (localb != null) {
      localb.ecZ();
    }
    this.agGQ = false;
    if (((paramView instanceof RecyclerView)) && ((((RecyclerView)paramView).getLayoutManager() instanceof LinearLayoutManager)) && (s.p(paramView, getRecyclerView())))
    {
      a(getRecyclerView(), this, paramInt);
      AppMethodBeat.o(164518);
      return;
    }
    if (((paramView instanceof RecyclerView)) && ((((RecyclerView)paramView).getLayoutManager() instanceof StaggeredGridLayoutManager)) && (s.p(paramView, getRecyclerView()))) {
      a(getRecyclerView(), this, paramInt);
    }
    AppMethodBeat.o(164518);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(164528);
    super.onFinishInflate();
    jMq();
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
    int k;
    int j;
    int m;
    Object localObject;
    if (getRecyclerView().getVisibility() == 8)
    {
      int n = getChildCount();
      if (n <= 0) {
        break label335;
      }
      k = 0;
      j = 0;
      m = k + 1;
      localObject = getChildAt(k);
      i = j;
      if (!s.p(localObject, getRecyclerView()))
      {
        i = j;
        if (!getHeaderViews().contains(localObject))
        {
          if (!getFooterViews().contains(localObject)) {
            break label219;
          }
          i = j;
        }
      }
      if (m < n) {
        break label325;
      }
    }
    for (;;)
    {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 0);
      localObject = ((Iterable)getHeaderViews()).iterator();
      View localView;
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          localView = (View)((Iterator)localObject).next();
          localView.measure(paramInt1, paramInt2);
          i += localView.getMeasuredHeight();
          j = getHeadersHeight();
          setHeadersHeight(localView.getMeasuredHeight() + j);
          continue;
          label219:
          ((View)localObject).measure(paramInt1, paramInt2);
          i = j + View.MeasureSpec.getSize(paramInt2);
          break;
        }
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
      label325:
      k = m;
      j = i;
      break;
      label335:
      i = 0;
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
    if (this.agGY)
    {
      this.agGY = false;
      jMq();
    }
    AppMethodBeat.o(164526);
  }
  
  public final void setConsumeOverScroll(boolean paramBoolean)
  {
    this.agGQ = paramBoolean;
  }
  
  public final void setEnableNestedScroll(boolean paramBoolean)
  {
    this.agGR = paramBoolean;
  }
  
  public final void setExtraOverScrollFooterDx(int paramInt)
  {
    this.agGZ = paramInt;
  }
  
  public void setFootersHeight(int paramInt)
  {
    this.agGX = paramInt;
  }
  
  public void setHeadersHeight(int paramInt)
  {
    this.agGW = paramInt;
  }
  
  public final void setOnTranslateYCallback(m<? super Integer, ? super Integer, ah> paramm)
  {
    this.agGT = paramm;
  }
  
  public final void setOverCallback(b paramb)
  {
    this.agGP = paramb;
  }
  
  public void setRecyclerView(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(234759);
    s.u(paramRecyclerView, "<set-?>");
    this.mkw = paramRecyclerView;
    AppMethodBeat.o(234759);
  }
  
  public final void setSuperNestedScroll(boolean paramBoolean)
  {
    this.agGS = paramBoolean;
  }
  
  public void setTranslationY(float paramFloat)
  {
    AppMethodBeat.i(234711);
    super.setTranslationY(paramFloat);
    m localm = this.agGT;
    if (localm != null) {
      localm.invoke(Integer.valueOf(0), Integer.valueOf((int)paramFloat));
    }
    AppMethodBeat.o(234711);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "", "onOverEnd", "", "dx", "", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract boolean NK(int paramInt);
    
    public abstract void ecZ();
    
    public abstract boolean v(int paramInt1, int paramInt2, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.view.HeadFooterLayout
 * JD-Core Version:    0.7.0.1
 */