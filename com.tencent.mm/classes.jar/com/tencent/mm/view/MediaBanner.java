package com.tencent.mm.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.c;
import androidx.recyclerview.widget.RecyclerView.m;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/MediaBanner;", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "container", "Landroid/widget/LinearLayout;", "getContainer", "()Landroid/widget/LinearLayout;", "container$delegate", "Lkotlin/Lazy;", "dataObserver", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "getDataObserver", "()Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "setDataObserver", "(Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;)V", "focusPosition", "getFocusPosition", "()I", "setFocusPosition", "(I)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "indicator", "Lcom/tencent/mm/view/IMediaBannerIndicator;", "getIndicator", "()Lcom/tencent/mm/view/IMediaBannerIndicator;", "setIndicator", "(Lcom/tencent/mm/view/IMediaBannerIndicator;)V", "indicatorBottomMargin", "indicatorHeight", "getIndicatorHeight", "", "isAutoPlay", "()Z", "setAutoPlay", "(Z)V", "manager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "pageChangeCallback", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "getPageChangeCallback", "()Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "setPageChangeCallback", "(Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;)V", "pagerView", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "getPagerView", "()Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "pagerViewContainer", "getPagerViewContainer", "()Landroid/widget/FrameLayout;", "parentRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getParentRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setParentRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "style", "Lcom/tencent/mm/view/MediaBanner$Style;", "getStyle", "()Lcom/tencent/mm/view/MediaBanner$Style;", "setStyle", "(Lcom/tencent/mm/view/MediaBanner$Style;)V", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "viewPool", "getViewPool", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "setViewPool", "(Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;)V", "getChildViewAt", "Landroid/view/View;", "position", "getLinearLayoutManager", "isInterceptTouch", "direction", "event", "Landroid/view/MotionEvent;", "isSuperIntercept", "onAttachedToWindow", "", "onDetachedFromWindow", "pauseLoopPlay", "selectViewAt", "isAuto", "setIndicatorStyle", "smoothScrollTo", "startLoopPlay", "stopLoopPlay", "Companion", "ILayoutManagerScrollEnableCallback", "IPageChangeCallback", "Style", "libmmui_release"})
public class MediaBanner<VH extends RecyclerView.v>
  extends FrameLayout
{
  public static final a YLu;
  private int BdY;
  private h BdZ;
  private c Bea;
  private final int YLm;
  private d YLn;
  private final LinearLayoutManager YLo;
  private RecyclerView YLp;
  private RecyclerView.c YLq;
  private final FrameLayout YLr;
  private RecyclerView.m YLs;
  private final f YLt;
  final MMHandler handler;
  public boolean isAutoPlay;
  private RecyclerView.a<VH> jMq;
  private final int sax;
  private final RecyclerHorizontalViewPager zrx;
  
  static
  {
    AppMethodBeat.i(164547);
    YLu = new a((byte)0);
    AppMethodBeat.o(164547);
  }
  
  public MediaBanner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164553);
    this.sax = ((int)getResources().getDimension(a.e.Edge_A));
    this.YLm = ((int)getResources().getDimension(a.e.Edge_3A));
    this.YLn = d.YLw;
    paramContext = getContext();
    p.j(paramContext, "context");
    this.YLo = fW(paramContext);
    paramContext = getContext();
    p.j(paramContext, "context");
    this.BdZ = ((h)new MediaBannerIndicator(paramContext));
    this.YLq = ((RecyclerView.c)new f(this));
    paramContext = getContext();
    p.j(paramContext, "context");
    this.zrx = ((RecyclerHorizontalViewPager)new h(this, paramContext));
    this.YLr = new FrameLayout(getContext());
    this.YLt = g.ar((kotlin.g.a.a)new e(this));
    this.zrx.setHasFixedSize(false);
    this.YLo.cC(3);
    this.YLo.setItemPrefetchEnabled(true);
    this.YLo.setOrientation(0);
    this.zrx.setLayoutManager((RecyclerView.LayoutManager)this.YLo);
    this.YLr.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    paramContext = getContainer();
    if (paramContext != null) {
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    }
    setIndicatorStyle(this.YLn);
    this.zrx.setOnInterceptTouchEvent((RecyclerHorizontalViewPager.c)new RecyclerHorizontalViewPager.c()
    {
      private float aCa;
      
      public final boolean a(MotionEvent paramAnonymousMotionEvent, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(207709);
        p.k(paramAnonymousMotionEvent, "event");
        paramAnonymousBoolean = MediaBanner.c(paramAnonymousMotionEvent, paramAnonymousBoolean);
        AppMethodBeat.o(207709);
        return paramAnonymousBoolean;
      }
      
      public final void n(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(207707);
        p.k(paramAnonymousMotionEvent, "event");
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          localObject = this.YLv;
          if (((MediaBanner)localObject).isAutoPlay)
          {
            ((MediaBanner)localObject).handler.removeMessages(1);
            ((MediaBanner)localObject).handler.sendEmptyMessageDelayed(1, 2000L);
          }
        }
        Object localObject = this.YLv.getParentRecyclerView();
        RecyclerView.LayoutManager localLayoutManager;
        int i;
        if (localObject != null)
        {
          localObject = ((RecyclerView)localObject).getLayoutManager();
          if (!(localObject instanceof MediaBanner.b)) {
            break label247;
          }
          localLayoutManager = this.YLv.getPagerView().getLayoutManager();
          if (localLayoutManager == null) {
            break label247;
          }
          if ((!(localLayoutManager instanceof LinearLayoutManager)) || (((LinearLayoutManager)localLayoutManager).getItemCount() <= 1)) {
            break label150;
          }
          i = 1;
          label114:
          if (i == 0) {
            break label155;
          }
        }
        for (;;)
        {
          if (localLayoutManager != null)
          {
            if (localLayoutManager == null)
            {
              paramAnonymousMotionEvent = new t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
              AppMethodBeat.o(207707);
              throw paramAnonymousMotionEvent;
              localObject = null;
              break;
              label150:
              i = 0;
              break label114;
              label155:
              localLayoutManager = null;
              continue;
            }
            if (paramAnonymousMotionEvent.getAction() == 0) {
              this.aCa = paramAnonymousMotionEvent.getRawX();
            }
            for (;;)
            {
              if ((paramAnonymousMotionEvent.getAction() == 1) || (paramAnonymousMotionEvent.getAction() == 3)) {
                ((MediaBanner.b)localObject).rw(true);
              }
              AppMethodBeat.o(207707);
              return;
              if ((paramAnonymousMotionEvent.getAction() == 2) && (Math.abs(paramAnonymousMotionEvent.getRawX() - this.aCa) >= 10.0F)) {
                ((MediaBanner.b)localObject).rw(false);
              }
            }
          }
        }
        label247:
        AppMethodBeat.o(207707);
      }
    });
    this.handler = new MMHandler(Looper.getMainLooper(), (MMHandler.Callback)new g(this));
    AppMethodBeat.o(164553);
  }
  
  public MediaBanner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164554);
    this.sax = ((int)getResources().getDimension(a.e.Edge_A));
    this.YLm = ((int)getResources().getDimension(a.e.Edge_3A));
    this.YLn = d.YLw;
    paramContext = getContext();
    p.j(paramContext, "context");
    this.YLo = fW(paramContext);
    paramContext = getContext();
    p.j(paramContext, "context");
    this.BdZ = ((h)new MediaBannerIndicator(paramContext));
    this.YLq = ((RecyclerView.c)new f(this));
    paramContext = getContext();
    p.j(paramContext, "context");
    this.zrx = ((RecyclerHorizontalViewPager)new h(this, paramContext));
    this.YLr = new FrameLayout(getContext());
    this.YLt = g.ar((kotlin.g.a.a)new e(this));
    this.zrx.setHasFixedSize(false);
    this.YLo.cC(3);
    this.YLo.setItemPrefetchEnabled(true);
    this.YLo.setOrientation(0);
    this.zrx.setLayoutManager((RecyclerView.LayoutManager)this.YLo);
    this.YLr.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    paramContext = getContainer();
    if (paramContext != null) {
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    }
    setIndicatorStyle(this.YLn);
    this.zrx.setOnInterceptTouchEvent((RecyclerHorizontalViewPager.c)new RecyclerHorizontalViewPager.c()
    {
      private float aCa;
      
      public final boolean a(MotionEvent paramAnonymousMotionEvent, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(207709);
        p.k(paramAnonymousMotionEvent, "event");
        paramAnonymousBoolean = MediaBanner.c(paramAnonymousMotionEvent, paramAnonymousBoolean);
        AppMethodBeat.o(207709);
        return paramAnonymousBoolean;
      }
      
      public final void n(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(207707);
        p.k(paramAnonymousMotionEvent, "event");
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          localObject = this.YLv;
          if (((MediaBanner)localObject).isAutoPlay)
          {
            ((MediaBanner)localObject).handler.removeMessages(1);
            ((MediaBanner)localObject).handler.sendEmptyMessageDelayed(1, 2000L);
          }
        }
        Object localObject = this.YLv.getParentRecyclerView();
        RecyclerView.LayoutManager localLayoutManager;
        int i;
        if (localObject != null)
        {
          localObject = ((RecyclerView)localObject).getLayoutManager();
          if (!(localObject instanceof MediaBanner.b)) {
            break label247;
          }
          localLayoutManager = this.YLv.getPagerView().getLayoutManager();
          if (localLayoutManager == null) {
            break label247;
          }
          if ((!(localLayoutManager instanceof LinearLayoutManager)) || (((LinearLayoutManager)localLayoutManager).getItemCount() <= 1)) {
            break label150;
          }
          i = 1;
          label114:
          if (i == 0) {
            break label155;
          }
        }
        for (;;)
        {
          if (localLayoutManager != null)
          {
            if (localLayoutManager == null)
            {
              paramAnonymousMotionEvent = new t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
              AppMethodBeat.o(207707);
              throw paramAnonymousMotionEvent;
              localObject = null;
              break;
              label150:
              i = 0;
              break label114;
              label155:
              localLayoutManager = null;
              continue;
            }
            if (paramAnonymousMotionEvent.getAction() == 0) {
              this.aCa = paramAnonymousMotionEvent.getRawX();
            }
            for (;;)
            {
              if ((paramAnonymousMotionEvent.getAction() == 1) || (paramAnonymousMotionEvent.getAction() == 3)) {
                ((MediaBanner.b)localObject).rw(true);
              }
              AppMethodBeat.o(207707);
              return;
              if ((paramAnonymousMotionEvent.getAction() == 2) && (Math.abs(paramAnonymousMotionEvent.getRawX() - this.aCa) >= 10.0F)) {
                ((MediaBanner.b)localObject).rw(false);
              }
            }
          }
        }
        label247:
        AppMethodBeat.o(207707);
      }
    });
    this.handler = new MMHandler(Looper.getMainLooper(), (MMHandler.Callback)new g(this));
    AppMethodBeat.o(164554);
  }
  
  public static boolean c(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    AppMethodBeat.i(164551);
    p.k(paramMotionEvent, "event");
    AppMethodBeat.o(164551);
    return paramBoolean;
  }
  
  public final void ay(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(187414);
    RecyclerHorizontalViewPager localRecyclerHorizontalViewPager = this.zrx;
    com.tencent.mm.hellhoundlib.b.a locala = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localRecyclerHorizontalViewPager, locala.aFh(), "com/tencent/mm/view/MediaBanner", "smoothScrollTo", "(IZ)V", "Undefined", "smoothScrollToPosition", "(I)V");
    localRecyclerHorizontalViewPager.smoothScrollToPosition(((Integer)locala.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localRecyclerHorizontalViewPager, "com/tencent/mm/view/MediaBanner", "smoothScrollTo", "(IZ)V", "Undefined", "smoothScrollToPosition", "(I)V");
    this.zrx.g(paramInt, true, paramBoolean);
    AppMethodBeat.o(187414);
  }
  
  public final void ci(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(187407);
    RecyclerHorizontalViewPager localRecyclerHorizontalViewPager = this.zrx;
    com.tencent.mm.hellhoundlib.b.a locala = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localRecyclerHorizontalViewPager, locala.aFh(), "com/tencent/mm/view/MediaBanner", "selectViewAt", "(IZ)V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerHorizontalViewPager.scrollToPosition(((Integer)locala.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localRecyclerHorizontalViewPager, "com/tencent/mm/view/MediaBanner", "selectViewAt", "(IZ)V", "Undefined", "scrollToPosition", "(I)V");
    this.zrx.g(paramInt, true, paramBoolean);
    AppMethodBeat.o(187407);
  }
  
  public void eiX()
  {
    AppMethodBeat.i(187417);
    this.handler.removeMessages(1);
    this.handler.sendEmptyMessageDelayed(1, 2500L);
    AppMethodBeat.o(187417);
  }
  
  public void eiY()
  {
    AppMethodBeat.i(187419);
    this.handler.removeMessages(1);
    AppMethodBeat.o(187419);
  }
  
  public LinearLayoutManager fW(Context paramContext)
  {
    AppMethodBeat.i(187377);
    p.k(paramContext, "context");
    paramContext = new LinearLayoutManager();
    AppMethodBeat.o(187377);
    return paramContext;
  }
  
  public final RecyclerView.a<VH> getAdapter()
  {
    return this.jMq;
  }
  
  public final LinearLayout getContainer()
  {
    AppMethodBeat.i(164550);
    LinearLayout localLinearLayout = (LinearLayout)this.YLt.getValue();
    AppMethodBeat.o(164550);
    return localLinearLayout;
  }
  
  public final RecyclerView.c getDataObserver()
  {
    return this.YLq;
  }
  
  public final int getFocusPosition()
  {
    return this.BdY;
  }
  
  public final h getIndicator()
  {
    return this.BdZ;
  }
  
  public final int getIndicatorHeight()
  {
    return this.YLm;
  }
  
  public final LinearLayoutManager getManager()
  {
    return this.YLo;
  }
  
  public final c getPageChangeCallback()
  {
    return this.Bea;
  }
  
  public final RecyclerHorizontalViewPager getPagerView()
  {
    return this.zrx;
  }
  
  public final FrameLayout getPagerViewContainer()
  {
    return this.YLr;
  }
  
  public final RecyclerView getParentRecyclerView()
  {
    return this.YLp;
  }
  
  public final d getStyle()
  {
    return this.YLn;
  }
  
  public final RecyclerView.m getViewPool()
  {
    return this.YLs;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(187420);
    super.onAttachedToWindow();
    if (this.isAutoPlay) {
      eiX();
    }
    AppMethodBeat.o(187420);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(187421);
    super.onDetachedFromWindow();
    eiY();
    AppMethodBeat.o(187421);
  }
  
  public final void setAdapter(RecyclerView.a<VH> parama)
  {
    AppMethodBeat.i(187426);
    this.jMq = parama;
    this.zrx.setAdapter(this.jMq);
    parama = this.jMq;
    if (parama != null)
    {
      parama.a(this.YLq);
      AppMethodBeat.o(187426);
      return;
    }
    AppMethodBeat.o(187426);
  }
  
  public final void setAutoPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(187380);
    this.isAutoPlay = paramBoolean;
    if (paramBoolean)
    {
      eiX();
      AppMethodBeat.o(187380);
      return;
    }
    eiY();
    AppMethodBeat.o(187380);
  }
  
  public final void setDataObserver(RecyclerView.c paramc)
  {
    AppMethodBeat.i(187387);
    p.k(paramc, "<set-?>");
    this.YLq = paramc;
    AppMethodBeat.o(187387);
  }
  
  public final void setFocusPosition(int paramInt)
  {
    this.BdY = paramInt;
  }
  
  public final void setIndicator(h paramh)
  {
    AppMethodBeat.i(187365);
    p.k(paramh, "<set-?>");
    this.BdZ = paramh;
    AppMethodBeat.o(187365);
  }
  
  public final void setIndicatorStyle(d paramd)
  {
    AppMethodBeat.i(187404);
    p.k(paramd, "style");
    this.YLn = paramd;
    switch (k.$EnumSwitchMapping$0[paramd.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(187404);
      return;
      this.YLr.removeView(this.BdZ.getView());
      paramd = getContainer();
      if (paramd != null) {
        paramd.removeView(this.BdZ.getView());
      }
      removeView(this.BdZ.getView());
      AppMethodBeat.o(187404);
      return;
      paramd = getContainer();
      if (paramd != null)
      {
        paramd.setOrientation(1);
        paramd.setGravity(49);
        localObject = this.YLr;
        View localView = (View)this.zrx;
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 17;
        ((FrameLayout)localObject).addView(localView, (ViewGroup.LayoutParams)localLayoutParams);
        paramd.addView((View)this.YLr, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
        localObject = this.BdZ.getView();
        if ((localObject instanceof LinearLayout)) {
          ((LinearLayout)localObject).setGravity(17);
        }
        paramd.addView(this.BdZ.getView(), (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, this.YLm));
        paramd.setGravity(17);
        addView((View)paramd, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        AppMethodBeat.o(187404);
        return;
      }
      AppMethodBeat.o(187404);
      return;
      this.YLr.addView((View)this.zrx);
      addView((View)this.YLr, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      paramd = new FrameLayout.LayoutParams(-1, this.YLm);
      paramd.bottomMargin = this.sax;
      paramd.gravity = 81;
      Object localObject = this.BdZ.getView();
      if ((localObject instanceof LinearLayout)) {
        ((LinearLayout)localObject).setGravity(81);
      }
      addView(this.BdZ.getView(), (ViewGroup.LayoutParams)paramd);
    }
  }
  
  public final void setPageChangeCallback(c paramc)
  {
    this.Bea = paramc;
  }
  
  public final void setParentRecyclerView(RecyclerView paramRecyclerView)
  {
    this.YLp = paramRecyclerView;
  }
  
  public final void setStyle(d paramd)
  {
    AppMethodBeat.i(164548);
    p.k(paramd, "<set-?>");
    this.YLn = paramd;
    AppMethodBeat.o(164548);
  }
  
  public final void setViewPool(RecyclerView.m paramm)
  {
    AppMethodBeat.i(187395);
    this.YLs = paramm;
    this.zrx.setRecycledViewPool(paramm);
    AppMethodBeat.o(187395);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/MediaBanner$Companion;", "", "()V", "IMAGE_LOOP_INTERVAL", "", "IMAGE_LOOP_PAUSE_INTERVAL", "SCROLL_TO_NEXT_IMG_WHAT", "", "TAG", "", "libmmui_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/MediaBanner$ILayoutManagerScrollEnableCallback;", "", "setScrollVerticallyEnable", "", "enable", "", "libmmui_release"})
  public static abstract interface b
  {
    public abstract void rw(boolean paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "libmmui_release"})
  public static abstract interface c
  {
    public abstract void g(int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/MediaBanner$Style;", "", "(Ljava/lang/String;I)V", "BOTTOM", "INSIDE", "NONE", "libmmui_release"})
  public static enum d
  {
    static
    {
      AppMethodBeat.i(164539);
      d locald1 = new d("BOTTOM", 0);
      YLw = locald1;
      d locald2 = new d("INSIDE", 1);
      YLx = locald2;
      d locald3 = new d("NONE", 2);
      YLy = locald3;
      YLz = new d[] { locald1, locald2, locald3 };
      AppMethodBeat.o(164539);
    }
    
    private d() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/LinearLayout;", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<LinearLayout>
  {
    e(MediaBanner paramMediaBanner)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/view/MediaBanner$dataObserver$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeInserted", "positionStart", "", "itemCount", "onItemRangeRemoved", "libmmui_release"})
  public static final class f
    extends RecyclerView.c
  {
    public final void onChanged()
    {
      AppMethodBeat.i(199080);
      super.onChanged();
      Object localObject = this.YLv.getAdapter();
      if (localObject != null)
      {
        this.YLv.getIndicator().setCount(((RecyclerView.a)localObject).getItemCount());
        if (this.YLv.getIndicator().getCount() > 0)
        {
          localObject = this.YLv.getPagerView();
          com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/view/MediaBanner$dataObserver$1", "onChanged", "()V", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerHorizontalViewPager)localObject).scrollToPosition(((Integer)locala.sf(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/view/MediaBanner$dataObserver$1", "onChanged", "()V", "Undefined", "scrollToPosition", "(I)V");
        }
        AppMethodBeat.o(199080);
        return;
      }
      AppMethodBeat.o(199080);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199081);
      super.onItemRangeInserted(paramInt1, paramInt2);
      RecyclerView.a locala = this.YLv.getAdapter();
      if (locala != null)
      {
        this.YLv.getIndicator().setCount(locala.getItemCount());
        AppMethodBeat.o(199081);
        return;
      }
      AppMethodBeat.o(199081);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199082);
      super.onItemRangeRemoved(paramInt1, paramInt2);
      RecyclerView.a locala = this.YLv.getAdapter();
      if (locala != null)
      {
        this.YLv.getIndicator().setCount(locala.getItemCount());
        AppMethodBeat.o(199082);
        return;
      }
      AppMethodBeat.o(199082);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class g
    implements MMHandler.Callback
  {
    g(MediaBanner paramMediaBanner) {}
    
    public final boolean handleMessage(final Message paramMessage)
    {
      int j = 0;
      AppMethodBeat.i(195125);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(195125);
        return true;
        paramMessage = this.YLv.getAdapter();
        label52:
        int k;
        if (paramMessage != null)
        {
          i = paramMessage.getItemCount();
          if (i <= 1) {
            break label114;
          }
          k = this.YLv.getFocusPosition() + 1;
          paramMessage = this.YLv.getAdapter();
          if (paramMessage == null) {
            break label116;
          }
        }
        label114:
        label116:
        for (int i = paramMessage.getItemCount();; i = 0)
        {
          if (k >= i) {
            break label121;
          }
          this.YLv.ay(k, true);
          this.YLv.eiX();
          break;
          i = 0;
          break label52;
          break;
        }
        label121:
        paramMessage = this.YLv.getAdapter();
        i = j;
        if (paramMessage != null) {
          i = paramMessage.getItemCount();
        }
        if (k != i) {
          continue;
        }
        paramMessage = this.YLv.getAdapter();
        if (!(paramMessage instanceof com.tencent.mm.ui.base.a.a)) {
          continue;
        }
        try
        {
          paramMessage.b(this.YLv.getDataObserver());
          label172:
          ((com.tencent.mm.ui.base.a.a)paramMessage).auA(((com.tencent.mm.ui.base.a.a)paramMessage).getItemCount());
          this.YLv.getPagerView().setItemAnimator(null);
          MediaBanner.b(this.YLv, k);
          this.YLv.postDelayed((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(194444);
              ((com.tencent.mm.ui.base.a.a)paramMessage).removeItem(((com.tencent.mm.ui.base.a.a)paramMessage).getItemCount() - 1);
              paramMessage.a(this.YLA.YLv.getDataObserver());
              this.YLA.YLv.ci(0, true);
              this.YLA.YLv.eiX();
              AppMethodBeat.o(194444);
            }
          }, 500L);
        }
        catch (Exception localException)
        {
          break label172;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/view/MediaBanner$pagerView$1", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "libmmui_release"})
  public static final class h
    extends RecyclerHorizontalViewPager
  {
    h(Context paramContext)
    {
      super();
    }
    
    public final void g(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(193919);
      super.g(paramInt, paramBoolean1, paramBoolean2);
      this.YLv.setFocusPosition(paramInt);
      this.YLv.getIndicator().setCurrentIndex(paramInt);
      MediaBanner.c localc = this.YLv.getPageChangeCallback();
      if (localc != null)
      {
        localc.g(paramInt, paramBoolean1, paramBoolean2);
        AppMethodBeat.o(193919);
        return;
      }
      AppMethodBeat.o(193919);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.MediaBanner
 * JD-Core Version:    0.7.0.1
 */