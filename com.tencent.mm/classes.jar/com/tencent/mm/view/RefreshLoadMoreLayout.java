package com.tencent.mm.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.f;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.ah.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.widget.MMProcessBar;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.ah.c;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "Lcom/tencent/mm/view/HeadFooterLayout;", "Lcom/tencent/mm/view/IViewActionCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DEBUG", "", "getDEBUG", "()Z", "actionCallback", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "getActionCallback", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "setActionCallback", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;)V", "canLoadMore", "getCanLoadMore", "setCanLoadMore", "(Z)V", "canRefresh", "getCanRefresh", "setCanRefresh", "damping", "", "getDamping", "()F", "setDamping", "(F)V", "delaySetHasTopMoreRunnable", "Ljava/lang/Runnable;", "emptyView", "Landroid/view/View;", "getEmptyView", "()Landroid/view/View;", "setEmptyView", "(Landroid/view/View;)V", "value", "enableLoadMore", "getEnableLoadMore", "setEnableLoadMore", "enablePullDownHeader", "getEnablePullDownHeader", "setEnablePullDownHeader", "enableRefresh", "getEnableRefresh", "setEnableRefresh", "isAnimation", "isAttachLoadMoreAtDown", "isAttachRefreshAtDown", "isAttachRefreshVisitor", "isFirstChangeLayout", "isHasBottomMore", "setHasBottomMore", "isHasPerformHapticFeedback", "isHasTopMore", "setHasTopMore", "isLoadingMore", "isPullDownHeader", "isRefreshing", "setRefreshing", "limitBottomRequest", "getLimitBottomRequest", "()I", "setLimitBottomRequest", "(I)V", "limitTopRequest", "getLimitTopRequest", "setLimitTopRequest", "loadMoreFooter", "loadMoreFooterHeight", "mainHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "preLoadMoreItemCount", "preRefreshItemCount", "refreshHeader", "getRefreshHeader", "setRefreshHeader", "refreshHeaderHeight", "refreshTargetY", "getRefreshTargetY", "setRefreshTargetY", "reportCallback", "getReportCallback", "setReportCallback", "stickTopLoadingLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$StickTopLoadingLayout;", "getStickTopLoadingLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout$StickTopLoadingLayout;", "setStickTopLoadingLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$StickTopLoadingLayout;)V", "test", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "getTest", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "setTest", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;)V", "animToCollapseHeader", "", "animToFinishLoadMore", "callback", "Lkotlin/Function0;", "animToFinishRefresh", "animToLoadMore", "refreshType", "animToRefresh", "animToShowLoadMore", "checkEmptyViewVisible", "doAfterLoadMoreAnim", "getLoadMoreFooter", "getRefreshHeaderHeight", "init", "isAttachLoadMore", "isHard", "invokeSource", "", "isAttachRefresh", "isFlingScope", "isNestedScrollingEnabled", "noFooterMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "noRefreshMore", "onAutoToLoadMore", "isSilence", "onAutoToRefresh", "isHideLoading", "onChanged", "onDetachedFromWindow", "onFinishLoadMore", "incrementSize", "onFinishLoadMore2", "onFinishRefresh", "onFinishRefresh2", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onItemRangeChanged", "positionStart", "itemCount", "payload", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onNestedFling", "target", "velocityX", "velocityY", "consumed", "onNestedPreFling", "onNotOverScroll", "dx", "dy", "", "type", "onOverScroll", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "dampingDy", "isEnd", "isVertical", "isTopOverScroll", "onPreFinishLoadMore", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "onRequestLoadMore", "loadMoreType", "onRequestRefresh", "onStartNestedScroll", "child", "axes", "onStopScroll", "pullDown", "reset", "setHasTopMoreDelay", "delay", "", "finish", "setLoadMoreFooter", "footer", "setRefreshHeaderView", "header", "setTranslationY", "translationY", "uiThread", "block", "ActionCallback", "ActionCallback2", "Companion", "MoreReason", "StickTopLoadingLayout", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public class RefreshLoadMoreLayout
  extends HeadFooterLayout
  implements k
{
  public static final RefreshLoadMoreLayout.c agIQ;
  private final boolean DEBUG;
  private boolean Jcx;
  private boolean agIR;
  private boolean agIS;
  View agIT;
  public View agIU;
  private int agIV;
  private int agIW;
  private int agIX;
  private int agIY;
  private boolean agIZ;
  private int agJa;
  private int agJb;
  private int agJc;
  private float agJd;
  public boolean agJe;
  protected boolean agJf;
  private Runnable agJg;
  private RefreshLoadMoreLayout.b agJh;
  private RefreshLoadMoreLayout.b agJi;
  private RefreshLoadMoreLayout.a agJj;
  private boolean agJk;
  private boolean agJl;
  private boolean agJm;
  private StickTopLoadingLayout agJn;
  private boolean agJo;
  private boolean agJp;
  private boolean agJq;
  private boolean canRefresh;
  private boolean isLoadingMore;
  private boolean isRefreshing;
  private final MMHandler mainHandler;
  private boolean upr;
  private View vDA;
  
  static
  {
    AppMethodBeat.i(164644);
    agIQ = new RefreshLoadMoreLayout.c((byte)0);
    AppMethodBeat.o(164644);
  }
  
  public RefreshLoadMoreLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164642);
    this.agIV = -1;
    this.agIW = -1;
    this.mainHandler = new MMHandler(Looper.getMainLooper());
    this.agJc = -1;
    this.agJe = true;
    this.agJf = true;
    this.agJk = true;
    this.agJl = true;
    this.canRefresh = true;
    this.upr = true;
    this.agJq = true;
    this.Jcx = true;
    f(paramAttributeSet);
    AppMethodBeat.o(164642);
  }
  
  public RefreshLoadMoreLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164643);
    this.agIV = -1;
    this.agIW = -1;
    this.mainHandler = new MMHandler(Looper.getMainLooper());
    this.agJc = -1;
    this.agJe = true;
    this.agJf = true;
    this.agJk = true;
    this.agJl = true;
    this.canRefresh = true;
    this.upr = true;
    this.agJq = true;
    this.Jcx = true;
    f(paramAttributeSet);
    AppMethodBeat.o(164643);
  }
  
  private static final void a(RefreshLoadMoreLayout paramRefreshLoadMoreLayout, int paramInt)
  {
    AppMethodBeat.i(234784);
    s.u(paramRefreshLoadMoreLayout, "this$0");
    paramRefreshLoadMoreLayout = paramRefreshLoadMoreLayout.getActionCallback();
    if (paramRefreshLoadMoreLayout != null) {
      paramRefreshLoadMoreLayout.ND(paramInt);
    }
    AppMethodBeat.o(234784);
  }
  
  private static final void a(RefreshLoadMoreLayout paramRefreshLoadMoreLayout, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(234780);
    s.u(paramRefreshLoadMoreLayout, "this$0");
    paramValueAnimator = paramRefreshLoadMoreLayout.getOnTranslateYCallback();
    if (paramValueAnimator != null) {
      paramValueAnimator.invoke(Integer.valueOf(0), Integer.valueOf((int)paramRefreshLoadMoreLayout.getTranslationY()));
    }
    paramValueAnimator = paramRefreshLoadMoreLayout.getStickTopLoadingLayout();
    if (paramValueAnimator != null) {
      paramValueAnimator.ex(paramRefreshLoadMoreLayout.getRefreshHeaderHeight() - Math.abs(paramRefreshLoadMoreLayout.getTranslationY()));
    }
    AppMethodBeat.o(234780);
  }
  
  private static final void a(RefreshLoadMoreLayout paramRefreshLoadMoreLayout, a parama)
  {
    AppMethodBeat.i(234778);
    s.u(paramRefreshLoadMoreLayout, "this$0");
    s.u(parama, "$finish");
    paramRefreshLoadMoreLayout.ch((a)new u(paramRefreshLoadMoreLayout));
    parama.invoke();
    AppMethodBeat.o(234778);
  }
  
  private final void aFS(int paramInt)
  {
    AppMethodBeat.i(164611);
    int i;
    if ((int)(paramInt / 1.5F) == 0) {
      if (paramInt > 0) {
        i = 1;
      }
    }
    for (;;)
    {
      this.agJo = true;
      setTranslationY(getTranslationY() - i);
      Log.d("MicroMsg.RLMoreLayout", "onNotOverScroll enablePullDownHeader " + i + ", " + getTranslationY() + ", " + paramInt);
      if (getTranslationY() < 0.0F) {
        setTranslationY(0.0F);
      }
      AppMethodBeat.o(164611);
      return;
      i = -1;
      continue;
      i = (int)(paramInt / 1.5F);
    }
  }
  
  private void aFT(int paramInt)
  {
    AppMethodBeat.i(234742);
    final float f;
    if (this.agJc == -1) {
      f = 0.0F;
    }
    for (;;)
    {
      a(this, paramInt, 2);
      animate().cancel();
      animate().translationY(f).setDuration(240L).setListener((Animator.AnimatorListener)new j(this, f)).start();
      AppMethodBeat.o(234742);
      return;
      if (this.agJn != null) {
        f = -this.agIX;
      } else {
        f = this.agJc;
      }
    }
  }
  
  private boolean aFU(int paramInt)
  {
    AppMethodBeat.i(234768);
    if (!this.agJe)
    {
      Log.i("MicroMsg.RLMoreLayout", "has't any more");
      AppMethodBeat.o(234768);
      return false;
    }
    if (this.isLoadingMore)
    {
      Log.i("MicroMsg.RLMoreLayout", "isLoadingMore...");
      AppMethodBeat.o(234768);
      return false;
    }
    this.isLoadingMore = true;
    a locala = (a)new r(paramInt, this);
    if (s.p(Thread.currentThread(), Looper.getMainLooper().getThread())) {
      locala.invoke();
    }
    for (;;)
    {
      AppMethodBeat.o(234768);
      return true;
      post(new RefreshLoadMoreLayout..ExternalSyntheticLambda3(locala));
    }
  }
  
  private boolean aT(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(234727);
    s.u(paramString, "invokeSource");
    if ((this.agIT == null) || (!this.agJq) || (!this.canRefresh))
    {
      AppMethodBeat.o(234727);
      return false;
    }
    RecyclerView.LayoutManager localLayoutManager = getRecyclerView().getLayoutManager();
    if ((localLayoutManager instanceof LinearLayoutManager))
    {
      if (this.DEBUG) {
        Log.i("MicroMsg.RLMoreLayout", "isAttachRefresh " + paramString + " isHard " + paramBoolean + " translationY:" + getTranslationY() + " refreshHeaderHeight:" + this.agIX + " findFirstCompletelyVisibleItemPosition:" + ((LinearLayoutManager)localLayoutManager).Jv());
      }
      if (paramBoolean)
      {
        if (getTranslationY() > -this.agIX)
        {
          AppMethodBeat.o(234727);
          return true;
        }
        AppMethodBeat.o(234727);
        return false;
      }
      if ((getTranslationY() >= -this.agIX) && (((LinearLayoutManager)localLayoutManager).Jv() == 0))
      {
        AppMethodBeat.o(234727);
        return true;
      }
      AppMethodBeat.o(234727);
      return false;
    }
    if ((localLayoutManager instanceof StaggeredGridLayoutManager))
    {
      paramString = ((StaggeredGridLayoutManager)localLayoutManager).Lb();
      s.s(paramString, "lastInfo");
      int k = paramString.length;
      int i = 0;
      int j = 0;
      while (i < k)
      {
        if (paramString[i] == 0) {
          j = 1;
        }
        i += 1;
      }
      if (paramBoolean)
      {
        if (getTranslationY() > -this.agIX)
        {
          AppMethodBeat.o(234727);
          return true;
        }
        AppMethodBeat.o(234727);
        return false;
      }
      if ((getTranslationY() >= -this.agIX) && (j != 0))
      {
        AppMethodBeat.o(234727);
        return true;
      }
      AppMethodBeat.o(234727);
      return false;
    }
    AppMethodBeat.o(234727);
    return false;
  }
  
  private final boolean aU(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(234736);
    if ((this.agIU == null) || (!this.upr))
    {
      AppMethodBeat.o(234736);
      return false;
    }
    RecyclerView.LayoutManager localLayoutManager = getRecyclerView().getLayoutManager();
    if ((localLayoutManager instanceof LinearLayoutManager))
    {
      if (paramBoolean)
      {
        if (getTranslationY() < -getHeadersHeight())
        {
          AppMethodBeat.o(234736);
          return true;
        }
        AppMethodBeat.o(234736);
        return false;
      }
      if ((getTranslationY() <= -getHeadersHeight()) && (O(getRecyclerView())))
      {
        AppMethodBeat.o(234736);
        return true;
      }
      AppMethodBeat.o(234736);
      return false;
    }
    int i;
    boolean bool;
    if ((localLayoutManager instanceof StaggeredGridLayoutManager))
    {
      int[] arrayOfInt = ((StaggeredGridLayoutManager)localLayoutManager).Lc();
      s.s(arrayOfInt, "lastInfo");
      int j = arrayOfInt.length;
      i = 0;
      bool = false;
      if (i < j)
      {
        if (arrayOfInt[i] != ((StaggeredGridLayoutManager)localLayoutManager).getItemCount() - 1) {
          break label362;
        }
        bool = true;
      }
    }
    label362:
    for (;;)
    {
      i += 1;
      break;
      eE("[isAttachLoadMore] " + paramString + " isHard " + paramBoolean + " translationY:" + getTranslationY() + " headersHeight:" + getHeadersHeight() + " loadingLast:" + bool + " itemCount " + ((StaggeredGridLayoutManager)localLayoutManager).getItemCount(), false);
      if (paramBoolean)
      {
        if (getTranslationY() < -getHeadersHeight())
        {
          AppMethodBeat.o(234736);
          return true;
        }
        AppMethodBeat.o(234736);
        return false;
      }
      if ((getTranslationY() <= -getHeadersHeight()) && (bool) && (((StaggeredGridLayoutManager)localLayoutManager).getItemCount() != 0))
      {
        AppMethodBeat.o(234736);
        return true;
      }
      AppMethodBeat.o(234736);
      return false;
      AppMethodBeat.o(234736);
      return false;
    }
  }
  
  private static final void cj(a parama)
  {
    AppMethodBeat.i(234783);
    s.u(parama, "$func");
    parama.invoke();
    AppMethodBeat.o(234783);
  }
  
  private static final void ck(a parama)
  {
    AppMethodBeat.i(234787);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(234787);
  }
  
  private void da(final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(234760);
    Log.i("MicroMsg.RLMoreLayout", "[onRequestRefresh] isHasTopMore=" + this.agJf + " isRefreshing=" + this.isRefreshing + " refreshType:" + paramInt);
    if (!this.agJf)
    {
      AppMethodBeat.o(234760);
      return;
    }
    if (this.isRefreshing)
    {
      AppMethodBeat.o(234760);
      return;
    }
    a locala = (a)new t(this, paramBoolean, paramInt);
    if (s.p(Thread.currentThread(), Looper.getMainLooper().getThread()))
    {
      locala.invoke();
      AppMethodBeat.o(234760);
      return;
    }
    uiThread((a)new RefreshLoadMoreLayout.s(locala));
    AppMethodBeat.o(234760);
  }
  
  private final void f(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(164616);
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, a.m.RefreshLoadMoreLayout);
    s.s(paramAttributeSet, "context.obtainStyledAttr…le.RefreshLoadMoreLayout)");
    int k = paramAttributeSet.getIndexCount();
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      int m = paramAttributeSet.getIndex(i);
      View localView;
      if (m == a.m.RefreshLoadMoreLayout_refreshLayout)
      {
        i = paramAttributeSet.getResourceId(a.m.RefreshLoadMoreLayout_refreshLayout, 0);
        if (i != 0)
        {
          this.agIT = LayoutInflater.from(getContext()).inflate(i, null);
          localView = this.agIT;
          if (localView != null) {
            localView.setVisibility(4);
          }
          localView = this.agIT;
          if (localView == null)
          {
            paramAttributeSet = new NullPointerException("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(164616);
            throw paramAttributeSet;
          }
          ag(localView, false);
        }
      }
      while (j >= k)
      {
        Log.i("MicroMsg.RLMoreLayout", "has static refreshHeader=" + this.agIT + " loadMoreFooter=" + this.agIU + " hash=" + hashCode());
        paramAttributeSet.recycle();
        AppMethodBeat.o(164616);
        return;
        if (m == a.m.RefreshLoadMoreLayout_loadMoreLayout)
        {
          m = paramAttributeSet.getResourceId(a.m.RefreshLoadMoreLayout_loadMoreLayout, 0);
          Log.i("MicroMsg.RLMoreLayout", "check footer res " + m + " i " + i);
          if (m != 0)
          {
            this.agIU = LayoutInflater.from(getContext()).inflate(m, (ViewGroup)this, false);
            localView = this.agIU;
            if (localView != null) {
              localView.setVisibility(4);
            }
            localView = this.agIU;
            if (localView == null)
            {
              paramAttributeSet = new NullPointerException("null cannot be cast to non-null type android.view.View");
              AppMethodBeat.o(164616);
              throw paramAttributeSet;
            }
            ai(localView, false);
          }
        }
      }
    }
  }
  
  private final void jMF()
  {
    AppMethodBeat.i(234770);
    Object localObject = this.agIU;
    if (localObject != null) {
      ((View)localObject).setVisibility(4);
    }
    localObject = this.agIU;
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(a.g.load_more_footer_tip_tv);
      if (localObject != null) {
        ((TextView)localObject).setText(a.k.app_loading);
      }
    }
    localObject = this.agIU;
    if (localObject != null)
    {
      localObject = ((View)localObject).findViewById(a.g.load_more_footer_end_layout);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
    AppMethodBeat.o(234770);
  }
  
  private void uiThread(a<ah> parama)
  {
    AppMethodBeat.i(164641);
    s.u(parama, "block");
    if (s.p(Thread.currentThread(), Looper.getMainLooper().getThread()))
    {
      parama.invoke();
      AppMethodBeat.o(164641);
      return;
    }
    this.mainHandler.post(new RefreshLoadMoreLayout..ExternalSyntheticLambda4(parama));
    AppMethodBeat.o(164641);
  }
  
  public final boolean NZ(boolean paramBoolean)
  {
    AppMethodBeat.i(235026);
    Log.i("MicroMsg.RLMoreLayout", s.X("[onAutoToLoadMore] isSilence=", Boolean.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      locala = RefreshLoadMoreLayout.d.agJr;
      paramBoolean = aFU(RefreshLoadMoreLayout.d.jML());
      AppMethodBeat.o(235026);
      return paramBoolean;
    }
    RefreshLoadMoreLayout.d.a locala = RefreshLoadMoreLayout.d.agJr;
    paramBoolean = aFU(RefreshLoadMoreLayout.d.jML());
    AppMethodBeat.o(235026);
    return paramBoolean;
  }
  
  public final void a(View paramView, int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(164610);
    s.u(paramView, "target");
    s.u(paramArrayOfInt, "consumed");
    if (this.agJo)
    {
      aFS(paramInt);
      paramArrayOfInt[1] = paramInt;
    }
    AppMethodBeat.o(164610);
  }
  
  public void a(RecyclerView paramRecyclerView, HeadFooterLayout paramHeadFooterLayout, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(234917);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramHeadFooterLayout, "parent");
    super.a(paramRecyclerView, paramHeadFooterLayout, paramInt);
    if (this.agJo)
    {
      this.agJo = false;
      paramRecyclerView.JO();
      Log.i("MicroMsg.RLMoreLayout", "animToCollapseHeader");
      if (getTranslationY() == 0.0F) {}
      for (paramInt = i;; paramInt = 0)
      {
        if (paramInt == 0)
        {
          animate().cancel();
          animate().translationY(0.0F).setDuration(240L).setListener((Animator.AnimatorListener)new e(this)).start();
        }
        AppMethodBeat.o(234917);
        return;
      }
    }
    if (paramInt == 0)
    {
      if (a(this, false, "onStopScroll", 1))
      {
        if ((!this.isRefreshing) && (this.agJf))
        {
          paramRecyclerView.JO();
          if (-this.agIV < getTranslationY())
          {
            paramRecyclerView = RefreshLoadMoreLayout.d.agJr;
            aFT(RefreshLoadMoreLayout.d.jMK());
            AppMethodBeat.o(234917);
            return;
          }
          if (-this.agIV > getTranslationY())
          {
            c(this);
            AppMethodBeat.o(234917);
          }
        }
        else if (this.isRefreshing)
        {
          paramRecyclerView = RefreshLoadMoreLayout.d.agJr;
          aFT(RefreshLoadMoreLayout.d.jMK());
          AppMethodBeat.o(234917);
        }
      }
      else if ((aU(true, "onStopScroll")) && (!this.isLoadingMore) && (this.agJe))
      {
        paramRecyclerView.JO();
        if (-this.agIX - (this.agIY - this.agIW) > getTranslationY())
        {
          paramRecyclerView = RefreshLoadMoreLayout.d.agJr;
          aFU(RefreshLoadMoreLayout.d.jMK());
          AppMethodBeat.o(234917);
          return;
        }
        if (-this.agIX - (this.agIY - this.agIW) < getTranslationY())
        {
          ci((a)RefreshLoadMoreLayout.f.agJN);
          AppMethodBeat.o(234917);
        }
      }
    }
    else if (a(this, false, "onStopScroll", 1)) {
      Log.w("MicroMsg.RLMoreLayout", "[onStopScroll] isAttachRefresh but type=" + paramInt + ' ');
    }
    AppMethodBeat.o(234917);
  }
  
  public void a(RecyclerView paramRecyclerView, HeadFooterLayout paramHeadFooterLayout, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int[] paramArrayOfInt, int paramInt3, boolean paramBoolean3)
  {
    AppMethodBeat.i(234938);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramHeadFooterLayout, "parent");
    s.u(paramArrayOfInt, "consumed");
    View localView;
    if ((paramInt3 == 0) && (this.agJg != null))
    {
      this.mainHandler.removeCallbacks(this.agJg);
      localView = this.agIT;
      if (localView != null)
      {
        localView = localView.findViewById(a.g.rl_loading_icon);
        if (localView != null) {
          localView.setVisibility(0);
        }
      }
      localView = this.agIT;
      if (localView != null)
      {
        localView = localView.findViewById(a.g.refresh_header_tip_tv);
        if (localView != null) {
          localView.setVisibility(8);
        }
      }
      localView = this.agIT;
      if (localView != null) {
        localView.setVisibility(4);
      }
      this.agJf = true;
      this.agJg = null;
    }
    boolean bool2 = aU(false, "onOverScroll");
    boolean bool1 = N(paramRecyclerView);
    if ((this.agJl) && (!this.agJm) && (-this.agIV < getTranslationY()) && (paramInt3 == 0))
    {
      performHapticFeedback(0, 2);
      this.agJm = true;
    }
    if ((paramInt3 == 1) && (((bool2) && (!this.isLoadingMore) && (this.agJe)) || ((bool1) && (!this.isRefreshing))))
    {
      if ((this.agJq) && (bool1) && (paramInt1 < 0))
      {
        paramRecyclerView.JO();
        AppMethodBeat.o(234938);
        return;
      }
      if ((this.Jcx) && (bool2) && (paramInt1 > 0)) {
        paramRecyclerView.JO();
      }
      AppMethodBeat.o(234938);
      return;
    }
    bool2 = a(this, false, "onOverScroll", 1);
    boolean bool3 = aU(true, "onOverScroll");
    if ((this.agJp) && (paramInt3 == 0) && (paramBoolean3))
    {
      if ((paramInt1 < 0) || (this.agJo))
      {
        aFS(paramInt1);
        paramArrayOfInt[1] = paramInt1;
        HeadFooterLayout.eE("[onOverScroll] pullDown", true);
        AppMethodBeat.o(234938);
      }
    }
    else if (this.agJo)
    {
      HeadFooterLayout.eE(s.X("[onOverScroll] isPullDownHeader ：", Boolean.valueOf(this.agJo)), true);
      AppMethodBeat.o(234938);
      return;
    }
    if ((paramInt3 != 0) && (bool1) && (this.isRefreshing) && (paramInt1 < 0) && (getTranslationY() > this.agJc) && (this.agJc != -1))
    {
      eE("[onOverScroll] isFirstItemReachTop  stopScroll", false);
      paramRecyclerView.JO();
      AppMethodBeat.o(234938);
      return;
    }
    float f2;
    float f1;
    if (((bool2) && (paramInt1 < 0) && (this.agJf)) || ((bool3) && (paramInt1 > 0) && (this.agJe)))
    {
      f2 = paramInt1;
      if (this.agJd == 0.0F)
      {
        paramInt2 = 1;
        if (paramInt2 == 0) {
          break label638;
        }
        f1 = 3.0F;
      }
    }
    label517:
    for (paramInt2 = (int)(f2 / f1);; paramInt2 = paramInt1)
    {
      int i;
      if ((paramBoolean3) && (!this.canRefresh) && (paramInt1 < 0)) {
        i = 0;
      }
      for (;;)
      {
        if (((bool2) && (paramInt1 < 0)) || ((bool3) && (paramInt1 > 0)))
        {
          if (bool2)
          {
            localView = this.agIT;
            if (localView != null) {
              localView.setVisibility(0);
            }
          }
          if (bool3)
          {
            localView = this.agIU;
            if (localView != null) {
              localView.setVisibility(0);
            }
          }
        }
        super.a(paramRecyclerView, paramHeadFooterLayout, paramInt1, i, paramBoolean1, paramBoolean2, paramArrayOfInt, paramInt3, paramBoolean3);
        AppMethodBeat.o(234938);
        return;
        paramInt2 = 0;
        break;
        label638:
        f1 = this.agJd;
        break label517;
        i = paramInt2;
        if (!this.upr)
        {
          i = paramInt2;
          if (paramInt1 > 0) {
            i = 0;
          }
        }
      }
    }
  }
  
  public boolean a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234973);
    s.u(paramView1, "child");
    s.u(paramView2, "target");
    if (jMp())
    {
      bool = super.startNestedScroll(paramInt1);
      AppMethodBeat.o(234973);
      return bool;
    }
    boolean bool = egA();
    AppMethodBeat.o(234973);
    return bool;
  }
  
  public final void aFV(final int paramInt)
  {
    AppMethodBeat.i(235028);
    uiThread((a)new o(this, paramInt));
    AppMethodBeat.o(235028);
  }
  
  public final void aFW(final int paramInt)
  {
    AppMethodBeat.i(164629);
    uiThread((a)new m(this, paramInt));
    AppMethodBeat.o(164629);
  }
  
  public final void bR(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(235022);
    Log.i("MicroMsg.RLMoreLayout", "[onAutoToRefresh] isSilence=" + paramBoolean1 + " isHideLoading=" + paramBoolean2);
    if (paramBoolean1)
    {
      locala = RefreshLoadMoreLayout.d.agJr;
      da(RefreshLoadMoreLayout.d.jML(), paramBoolean2);
      AppMethodBeat.o(235022);
      return;
    }
    RefreshLoadMoreLayout.d.a locala = RefreshLoadMoreLayout.d.agJr;
    aFT(RefreshLoadMoreLayout.d.jML());
    AppMethodBeat.o(235022);
  }
  
  public final void ch(final a<ah> parama)
  {
    AppMethodBeat.i(164624);
    s.u(parama, "callback");
    final float f = -this.agIX;
    if (this.DEBUG) {
      Log.i("MicroMsg.RLMoreLayout", "animToFinishRefresh " + getTranslationY() + " rectHeight:" + f);
    }
    if (!a(this, false, "onInterceptTouchEvent animToFinishRefresh", 1))
    {
      parama.invoke();
      this.agJm = false;
      AppMethodBeat.o(164624);
      return;
    }
    animate().cancel();
    animate().translationY(f).setDuration(240L).setUpdateListener(new RefreshLoadMoreLayout..ExternalSyntheticLambda0(this)).setListener((Animator.AnimatorListener)new i(this, f, parama)).start();
    AppMethodBeat.o(164624);
  }
  
  public final void ci(final a<ah> parama)
  {
    AppMethodBeat.i(164626);
    s.u(parama, "callback");
    Rect localRect = new Rect(0, 0, 0, 0);
    Object localObject = this.agIU;
    if (localObject != null) {
      ((View)localObject).getGlobalVisibleRect(localRect);
    }
    localObject = new ah.c();
    ((ah.c)localObject).aixa = (getTranslationY() + localRect.height());
    if (this.DEBUG) {
      Log.i("MicroMsg.RLMoreLayout", "animToFinishLoadMore " + getTranslationY() + " rectHeight:" + localRect.height() + " targetY:" + ((ah.c)localObject).aixa);
    }
    if (((ah.c)localObject).aixa >= -this.agIX) {
      ((ah.c)localObject).aixa = (-this.agIX);
    }
    animate().cancel();
    animate().translationY(((ah.c)localObject).aixa).setDuration(240L).setListener((Animator.AnimatorListener)new g(this, (ah.c)localObject, parama)).start();
    AppMethodBeat.o(164626);
  }
  
  public final void e(long paramLong, a<ah> parama)
  {
    AppMethodBeat.i(235015);
    s.u(parama, "finish");
    this.agJg = new RefreshLoadMoreLayout..ExternalSyntheticLambda2(this, parama);
    this.mainHandler.postDelayed(this.agJg, paramLong);
    AppMethodBeat.o(235015);
  }
  
  public final RefreshLoadMoreLayout.b getActionCallback()
  {
    return this.agJh;
  }
  
  public final boolean getCanLoadMore()
  {
    return this.upr;
  }
  
  public final boolean getCanRefresh()
  {
    return this.canRefresh;
  }
  
  public final boolean getDEBUG()
  {
    return this.DEBUG;
  }
  
  public final float getDamping()
  {
    return this.agJd;
  }
  
  public final View getEmptyView()
  {
    return this.vDA;
  }
  
  public final boolean getEnableLoadMore()
  {
    return this.Jcx;
  }
  
  public final boolean getEnablePullDownHeader()
  {
    return this.agJp;
  }
  
  public final boolean getEnableRefresh()
  {
    return this.agJq;
  }
  
  public final int getLimitBottomRequest()
  {
    return this.agIW;
  }
  
  public final int getLimitTopRequest()
  {
    return this.agIV;
  }
  
  public final View getLoadMoreFooter()
  {
    return this.agIU;
  }
  
  public final View getRefreshHeader()
  {
    return this.agIT;
  }
  
  public final int getRefreshHeaderHeight()
  {
    return this.agIX;
  }
  
  public final int getRefreshTargetY()
  {
    return this.agJc;
  }
  
  public final RefreshLoadMoreLayout.b getReportCallback()
  {
    return this.agJi;
  }
  
  public final StickTopLoadingLayout getStickTopLoadingLayout()
  {
    return this.agJn;
  }
  
  public final RefreshLoadMoreLayout.a getTest()
  {
    return this.agJj;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return true;
  }
  
  protected final boolean jME()
  {
    return this.isRefreshing;
  }
  
  public final void k(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(164630);
    s.u(paramd, "reason");
    uiThread((a)new p(paramd, this));
    AppMethodBeat.o(164630);
  }
  
  public final void l(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(235038);
    s.u(paramd, "reason");
    uiThread((a)new n(paramd, this));
    AppMethodBeat.o(235038);
  }
  
  public final void m(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(164635);
    Log.d("MicroMsg.RLMoreLayout", s.X("noFooterMore reason: ", paramd));
    setHasBottomMore(false);
    Object localObject = this.agIU;
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(a.g.load_more_footer_tip_tv);
      if (localObject != null)
      {
        if (paramd != null) {
          break label119;
        }
        paramd = null;
        if (paramd == null) {
          ((TextView)localObject).setText(a.k.load_more_no_result_tip);
        }
      }
    }
    paramd = this.agIU;
    if (paramd != null)
    {
      localObject = paramd.findViewById(a.g.load_more_footer_end_layout);
      if (localObject != null)
      {
        paramd = this.agIU;
        if (paramd != null) {
          break label145;
        }
      }
    }
    label145:
    for (paramd = null;; paramd = (TextView)paramd.findViewById(a.g.load_more_footer_tip_tv))
    {
      if (paramd != null) {
        paramd.setVisibility(8);
      }
      ((View)localObject).setVisibility(0);
      AppMethodBeat.o(164635);
      return;
      label119:
      paramd = paramd.agJt;
      if (paramd == null)
      {
        paramd = null;
        break;
      }
      ((TextView)localObject).setText(paramd);
      paramd = ah.aiuX;
      break;
    }
  }
  
  public void onChanged()
  {
    AppMethodBeat.i(164637);
    RecyclerView.a locala = getRecyclerView().getAdapter();
    if (locala != null) {
      locala.bZE.notifyChanged();
    }
    AppMethodBeat.o(164637);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(164631);
    super.onDetachedFromWindow();
    reset();
    AppMethodBeat.o(164631);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164615);
    s.u(paramMotionEvent, "ev");
    if (this.agIZ)
    {
      AppMethodBeat.o(164615);
      return true;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(164615);
      return bool;
      this.agIR = aT(false, "onInterceptTouchEvent ACTION_DOWN");
      this.agIS = aU(false, "onInterceptTouchEvent ACTION_DOWN");
      eE("[onInterceptTouchEvent] ACTION_DOWN isAttachRefreshAtDown=" + this.agIR + " isAttachLoadMoreAtDown=" + this.agIS, false);
      continue;
      eE("[onInterceptTouchEvent] ACTION_UP isAttachRefreshAtDown=" + this.agIR + " isAttachLoadMoreAtDown=" + this.agIS, false);
    }
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235070);
    if (paramInt2 > 0)
    {
      RecyclerView.a locala = getRecyclerView().getAdapter();
      if (locala != null) {
        locala.by(paramInt1, paramInt2);
      }
    }
    AppMethodBeat.o(235070);
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(164638);
    if (paramInt2 > 0)
    {
      RecyclerView.a locala = getRecyclerView().getAdapter();
      if (locala != null) {
        locala.e(paramInt1, paramInt2, paramObject);
      }
    }
    AppMethodBeat.o(164638);
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164639);
    if (paramInt2 > 0)
    {
      RecyclerView.a locala = getRecyclerView().getAdapter();
      if (locala != null) {
        locala.bA(paramInt1, paramInt2);
      }
      getRecyclerView().post(new RefreshLoadMoreLayout..ExternalSyntheticLambda1(this, paramInt2));
    }
    AppMethodBeat.o(164639);
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164640);
    if (paramInt2 > 0)
    {
      RecyclerView.a locala = getRecyclerView().getAdapter();
      if (locala != null) {
        locala.bB(paramInt1, paramInt2);
      }
    }
    AppMethodBeat.o(164640);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(164614);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (this.agJk))
    {
      setTranslationY(-this.agIX);
      this.agJk = false;
    }
    AppMethodBeat.o(164614);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(164613);
    super.onMeasure(paramInt1, paramInt2);
    View localView;
    if (this.agIT != null)
    {
      localView = this.agIT;
      s.checkNotNull(localView);
    }
    for (paramInt1 = localView.getMeasuredHeight();; paramInt1 = 0)
    {
      this.agIX = paramInt1;
      paramInt1 = i;
      if (this.agIU != null)
      {
        localView = this.agIU;
        s.checkNotNull(localView);
        paramInt1 = localView.getMeasuredHeight();
      }
      this.agIY = paramInt1;
      if (-1 == this.agIV) {
        this.agIV = ((int)(this.agIX * 0.15F));
      }
      if (-1 == this.agIW) {
        this.agIW = ((int)(this.agIY * 0.15F));
      }
      AppMethodBeat.o(164613);
      return;
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(234960);
    s.u(paramView, "target");
    paramBoolean = super.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(234960);
    return paramBoolean;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(234966);
    s.u(paramView, "target");
    boolean bool = super.onNestedPreFling(paramView, paramFloat1, paramFloat2);
    AppMethodBeat.o(234966);
    return bool;
  }
  
  public void onPreFinishLoadMore(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(235047);
    s.u(paramd, "reason");
    l(paramd);
    AppMethodBeat.o(235047);
  }
  
  public void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(164634);
    s.u(paramd, "reason");
    uiThread((a)new q(paramd, this));
    AppMethodBeat.o(164634);
  }
  
  public void onPreFinishRefresh(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(164633);
    s.u(paramd, "reason");
    k(paramd);
    AppMethodBeat.o(164633);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(164632);
    this.agJk = true;
    this.isRefreshing = false;
    this.isLoadingMore = false;
    setHasBottomMore(true);
    this.agIZ = false;
    setTranslationY(-this.agIX);
    View localView = this.agIT;
    if (localView != null) {
      localView.setVisibility(4);
    }
    localView = this.agIU;
    if (localView != null) {
      localView.setVisibility(4);
    }
    AppMethodBeat.o(164632);
  }
  
  public final void setActionCallback(RefreshLoadMoreLayout.b paramb)
  {
    this.agJh = paramb;
  }
  
  public final void setCanLoadMore(boolean paramBoolean)
  {
    this.upr = paramBoolean;
  }
  
  public final void setCanRefresh(boolean paramBoolean)
  {
    this.canRefresh = paramBoolean;
  }
  
  public final void setDamping(float paramFloat)
  {
    this.agJd = paramFloat;
  }
  
  public final void setEmptyView(View paramView)
  {
    this.vDA = paramView;
  }
  
  public final void setEnableLoadMore(boolean paramBoolean)
  {
    AppMethodBeat.i(235010);
    this.Jcx = paramBoolean;
    if ((!this.Jcx) && (this.agIU != null))
    {
      View localView = this.agIU;
      s.checkNotNull(localView);
      aj(localView, false);
      this.agIU = null;
      if (getTranslationY() > this.agIX) {
        setTranslationY(this.agIX);
      }
      Log.i("MicroMsg.RLMoreLayout", "set enableLoadMore false and remove footer hash=" + hashCode() + ", " + getTranslationY() + ", " + this.agIX);
    }
    Log.i("MicroMsg.RLMoreLayout", "set enableLoadMore " + paramBoolean + ", hash=" + hashCode());
    AppMethodBeat.o(235010);
  }
  
  public final void setEnablePullDownHeader(boolean paramBoolean)
  {
    this.agJp = paramBoolean;
  }
  
  public final void setEnableRefresh(boolean paramBoolean)
  {
    AppMethodBeat.i(164618);
    this.agJq = paramBoolean;
    if ((!this.agJq) && (this.agIT != null))
    {
      View localView = this.agIT;
      s.checkNotNull(localView);
      ah(localView, false);
      this.agIT = null;
      if (getTranslationY() <= 0 - this.agIX) {
        setTranslationY(getTranslationY() + this.agIX);
      }
      Log.i("MicroMsg.RLMoreLayout", "set enableRefresh false and remove header, " + getTranslationY() + ", " + this.agIX + " hash=" + hashCode());
    }
    Log.i("MicroMsg.RLMoreLayout", "set enableRefresh " + paramBoolean + " hash=" + hashCode());
    AppMethodBeat.o(164618);
  }
  
  public final void setHasBottomMore(boolean paramBoolean)
  {
    AppMethodBeat.i(164608);
    if (paramBoolean)
    {
      if (!this.agJk) {
        break label33;
      }
      jMF();
    }
    for (;;)
    {
      this.agJe = paramBoolean;
      AppMethodBeat.o(164608);
      return;
      label33:
      ci((a)new RefreshLoadMoreLayout.l(this));
    }
  }
  
  public final void setHasTopMore(boolean paramBoolean)
  {
    this.agJf = paramBoolean;
  }
  
  public final void setLimitBottomRequest(int paramInt)
  {
    this.agIW = paramInt;
  }
  
  public final void setLimitTopRequest(int paramInt)
  {
    this.agIV = paramInt;
  }
  
  public final void setLoadMoreFooter(View paramView)
  {
    AppMethodBeat.i(164617);
    s.u(paramView, "footer");
    View localView = this.agIU;
    if (localView != null) {
      aj(localView, true);
    }
    ai(paramView, true);
    this.agIU = paramView;
    paramView = this.agIU;
    if (paramView != null) {
      paramView.setVisibility(4);
    }
    AppMethodBeat.o(164617);
  }
  
  public final void setRefreshHeader(View paramView)
  {
    this.agIT = paramView;
  }
  
  public final void setRefreshHeaderView(View paramView)
  {
    AppMethodBeat.i(164619);
    s.u(paramView, "header");
    this.agJk = true;
    View localView = this.agIT;
    if (localView != null) {
      ah(localView, true);
    }
    ag(paramView, true);
    setEnableRefresh(true);
    this.agIT = paramView;
    paramView = this.agIT;
    if (paramView != null) {
      paramView.setVisibility(4);
    }
    AppMethodBeat.o(164619);
  }
  
  public final void setRefreshTargetY(int paramInt)
  {
    this.agJc = paramInt;
  }
  
  protected final void setRefreshing(boolean paramBoolean)
  {
    this.isRefreshing = paramBoolean;
  }
  
  public final void setReportCallback(RefreshLoadMoreLayout.b paramb)
  {
    this.agJi = paramb;
  }
  
  public final void setStickTopLoadingLayout(StickTopLoadingLayout paramStickTopLoadingLayout)
  {
    this.agJn = paramStickTopLoadingLayout;
  }
  
  public final void setTest(RefreshLoadMoreLayout.a parama)
  {
    this.agJj = parama;
  }
  
  public void setTranslationY(float paramFloat)
  {
    AppMethodBeat.i(234947);
    super.setTranslationY(paramFloat);
    StickTopLoadingLayout localStickTopLoadingLayout = this.agJn;
    if (localStickTopLoadingLayout != null) {
      localStickTopLoadingLayout.ex(getRefreshHeaderHeight() - Math.abs(paramFloat));
    }
    AppMethodBeat.o(234947);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/RefreshLoadMoreLayout$StickTopLoadingLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionCallback", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "getActionCallback", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "setActionCallback", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;)V", "alphaOffset", "getAlphaOffset", "()I", "setAlphaOffset", "(I)V", "hintHeight", "", "getHintHeight", "()F", "setHintHeight", "(F)V", "isRefreshing", "", "offsetExtra", "getOffsetExtra", "setOffsetExtra", "onScrollCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "offset", "", "getOnScrollCallback", "()Lkotlin/jvm/functions/Function1;", "setOnScrollCallback", "(Lkotlin/jvm/functions/Function1;)V", "progressBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "getProgressBar", "()Lcom/tencent/mm/ui/widget/MMProcessBar;", "topLoadingOffsetLimit", "getTopLoadingOffsetLimit", "setTopLoadingOffsetLimit", "onRefreshed", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshing", "isHideLoading", "onScroll", "y", "reset", "setExtra", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class StickTopLoadingLayout
    extends LinearLayout
  {
    public final MMProcessBar agJF;
    float agJG;
    public b<? super Float, ah> agJH;
    public float agJI;
    public float agJJ;
    private int agJK;
    RefreshLoadMoreLayout.b agJh;
    boolean isRefreshing;
    
    public StickTopLoadingLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(234721);
      this.agJF = new MMProcessBar(getContext());
      this.agJG = getContext().getResources().getDimension(a.e.Edge_8A);
      this.agJH = ((b)RefreshLoadMoreLayout.StickTopLoadingLayout.a.agJL);
      setOrientation(1);
      setGravity(1);
      int i = (int)getResources().getDimension(a.e.Edge_3A);
      this.agJF.setBackgroundResource(a.f.progress_single_white_medium_holo);
      addView((View)this.agJF, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(i, i));
      reset();
      setVisibility(0);
      AppMethodBeat.o(234721);
    }
    
    public StickTopLoadingLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      AppMethodBeat.i(234725);
      this.agJF = new MMProcessBar(getContext());
      this.agJG = getContext().getResources().getDimension(a.e.Edge_8A);
      this.agJH = ((b)RefreshLoadMoreLayout.StickTopLoadingLayout.a.agJL);
      setOrientation(1);
      setGravity(1);
      paramInt = (int)getResources().getDimension(a.e.Edge_3A);
      this.agJF.setBackgroundResource(a.f.progress_single_white_medium_holo);
      addView((View)this.agJF, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(paramInt, paramInt));
      reset();
      setVisibility(0);
      AppMethodBeat.o(234725);
    }
    
    private void reset()
    {
      AppMethodBeat.i(234726);
      this.agJF.setAlpha(1.0F);
      this.agJF.setVisibility(4);
      this.agJF.jEO();
      this.agJH.invoke(Float.valueOf(this.agJJ));
      setTranslationY(0.0F);
      AppMethodBeat.o(234726);
    }
    
    public final void ex(float paramFloat)
    {
      AppMethodBeat.i(234774);
      if (this.isRefreshing)
      {
        AppMethodBeat.o(234774);
        return;
      }
      float f2 = paramFloat - this.agJK;
      if (f2 >= this.agJG) {}
      for (float f1 = this.agJG;; f1 = f2)
      {
        f1 += this.agJI;
        this.agJF.setAlpha(f1 / this.agJG);
        f2 /= 6000.0F;
        this.agJF.setVisibility(0);
        this.agJF.ed(f2);
        if (paramFloat <= 0.0F)
        {
          this.agJF.setVisibility(4);
          this.agJF.jEO();
        }
        setTranslationY(f1);
        this.agJH.invoke(Float.valueOf(getTranslationY()));
        AppMethodBeat.o(234774);
        return;
      }
    }
    
    public final RefreshLoadMoreLayout.b getActionCallback()
    {
      return this.agJh;
    }
    
    public final int getAlphaOffset()
    {
      return this.agJK;
    }
    
    public final float getHintHeight()
    {
      return this.agJJ;
    }
    
    public final float getOffsetExtra()
    {
      return this.agJI;
    }
    
    public final b<Float, ah> getOnScrollCallback()
    {
      return this.agJH;
    }
    
    public final MMProcessBar getProgressBar()
    {
      return this.agJF;
    }
    
    public final float getTopLoadingOffsetLimit()
    {
      return this.agJG;
    }
    
    public final void n(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(234776);
      s.u(paramd, "reason");
      this.isRefreshing = false;
      reset();
      RefreshLoadMoreLayout.b localb = this.agJh;
      if (localb != null) {
        localb.onRefreshEnd(paramd);
      }
      AppMethodBeat.o(234776);
    }
    
    public final void setActionCallback(RefreshLoadMoreLayout.b paramb)
    {
      this.agJh = paramb;
    }
    
    public final void setAlphaOffset(int paramInt)
    {
      this.agJK = paramInt;
    }
    
    public final void setHintHeight(float paramFloat)
    {
      this.agJJ = paramFloat;
    }
    
    public final void setOffsetExtra(float paramFloat)
    {
      this.agJI = paramFloat;
    }
    
    public final void setOnScrollCallback(b<? super Float, ah> paramb)
    {
      AppMethodBeat.i(234751);
      s.u(paramb, "<set-?>");
      this.agJH = paramb;
      AppMethodBeat.o(234751);
    }
    
    public final void setTopLoadingOffsetLimit(float paramFloat)
    {
      this.agJG = paramFloat;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/view/RefreshLoadMoreLayout$animToCollapseHeader$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements Animator.AnimatorListener
  {
    e(RefreshLoadMoreLayout paramRefreshLoadMoreLayout) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(164575);
      AppMethodBeat.o(164575);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(164574);
      RefreshLoadMoreLayout.b(this.agJM, false);
      this.agJM.setTranslationY(0.0F);
      AppMethodBeat.o(164574);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(164576);
      RefreshLoadMoreLayout.b(this.agJM, true);
      AppMethodBeat.o(164576);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/view/RefreshLoadMoreLayout$animToFinishLoadMore$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements Animator.AnimatorListener
  {
    g(RefreshLoadMoreLayout paramRefreshLoadMoreLayout, ah.c paramc, a<ah> parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(164579);
      AppMethodBeat.o(164579);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(164578);
      RefreshLoadMoreLayout.b(this.agJM, false);
      this.agJM.setTranslationY(this.agJO.aixa);
      parama.invoke();
      AppMethodBeat.o(164578);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(164580);
      RefreshLoadMoreLayout.b(this.agJM, true);
      AppMethodBeat.o(164580);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/view/RefreshLoadMoreLayout$animToFinishRefresh$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements Animator.AnimatorListener
  {
    i(RefreshLoadMoreLayout paramRefreshLoadMoreLayout, float paramFloat, a<ah> parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(234670);
      RefreshLoadMoreLayout.b(this.agJM, false);
      this.agJM.setTranslationY(f);
      RefreshLoadMoreLayout.g(this.agJM);
      parama.invoke();
      AppMethodBeat.o(234670);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(234677);
      RefreshLoadMoreLayout.b(this.agJM, true);
      AppMethodBeat.o(234677);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/view/RefreshLoadMoreLayout$animToRefresh$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements Animator.AnimatorListener
  {
    j(RefreshLoadMoreLayout paramRefreshLoadMoreLayout, float paramFloat) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(164586);
      AppMethodBeat.o(164586);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(164585);
      RefreshLoadMoreLayout.b(this.agJM, false);
      this.agJM.setTranslationY(f);
      AppMethodBeat.o(164585);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(164587);
      RefreshLoadMoreLayout.b(this.agJM, true);
      AppMethodBeat.o(164587);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements a<ah>
  {
    m(RefreshLoadMoreLayout paramRefreshLoadMoreLayout, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements a<ah>
  {
    n(RefreshLoadMoreLayout.d<Object> paramd, RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements a<ah>
  {
    o(RefreshLoadMoreLayout paramRefreshLoadMoreLayout, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements a<ah>
  {
    p(RefreshLoadMoreLayout.d<Object> paramd, RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<View>
    {
      a(RefreshLoadMoreLayout paramRefreshLoadMoreLayout, RefreshLoadMoreLayout.d<Object> paramd)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends u
    implements a<ah>
  {
    q(RefreshLoadMoreLayout.d<Object> paramd, RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<ah>
    {
      a(RefreshLoadMoreLayout paramRefreshLoadMoreLayout, RefreshLoadMoreLayout.d<Object> paramd)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends u
    implements a<ah>
  {
    r(int paramInt, RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class t
    extends u
    implements a<ah>
  {
    t(RefreshLoadMoreLayout paramRefreshLoadMoreLayout, boolean paramBoolean, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class u
    extends u
    implements a<ah>
  {
    u(RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.view.RefreshLoadMoreLayout
 * JD-Core Version:    0.7.0.1
 */