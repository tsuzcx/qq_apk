package com.tencent.mm.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/MediaBanner;", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Landroid/support/v7/widget/RecyclerView$Adapter;", "adapter", "getAdapter", "()Landroid/support/v7/widget/RecyclerView$Adapter;", "setAdapter", "(Landroid/support/v7/widget/RecyclerView$Adapter;)V", "container", "Landroid/widget/LinearLayout;", "getContainer", "()Landroid/widget/LinearLayout;", "container$delegate", "Lkotlin/Lazy;", "dataObserver", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "getDataObserver", "()Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "setDataObserver", "(Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;)V", "focusPosition", "getFocusPosition", "()I", "setFocusPosition", "(I)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "indicator", "Lcom/tencent/mm/view/IMediaBannerIndicator;", "getIndicator", "()Lcom/tencent/mm/view/IMediaBannerIndicator;", "setIndicator", "(Lcom/tencent/mm/view/IMediaBannerIndicator;)V", "indicatorBottomMargin", "indicatorHeight", "getIndicatorHeight", "", "isAutoPlay", "()Z", "setAutoPlay", "(Z)V", "manager", "Landroid/support/v7/widget/LinearLayoutManager;", "getManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "pageChangeCallback", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "getPageChangeCallback", "()Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "setPageChangeCallback", "(Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;)V", "pagerView", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "getPagerView", "()Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "pagerViewContainer", "getPagerViewContainer", "()Landroid/widget/FrameLayout;", "parentRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getParentRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setParentRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "style", "Lcom/tencent/mm/view/MediaBanner$Style;", "getStyle", "()Lcom/tencent/mm/view/MediaBanner$Style;", "setStyle", "(Lcom/tencent/mm/view/MediaBanner$Style;)V", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "viewPool", "getViewPool", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "setViewPool", "(Landroid/support/v7/widget/RecyclerView$RecycledViewPool;)V", "getChildViewAt", "Landroid/view/View;", "position", "getLinearLayoutManager", "isInterceptTouch", "direction", "event", "Landroid/view/MotionEvent;", "isSuperIntercept", "onAttachedToWindow", "", "onDetachedFromWindow", "pauseLoopPlay", "selectViewAt", "isAuto", "setIndicatorStyle", "smoothScrollTo", "startLoopPlay", "stopLoopPlay", "Companion", "ILayoutManagerScrollEnableCallback", "IPageChangeCallback", "Style", "libmmui_release"})
public class MediaBanner<VH extends RecyclerView.v>
  extends FrameLayout
{
  public static final a RjN;
  private final int RjB;
  private d RjC;
  private c RjD;
  private final LinearLayoutManager RjE;
  private h RjF;
  private int RjG;
  private RecyclerView RjH;
  private RecyclerView.c RjI;
  private final RecyclerHorizontalViewPager RjJ;
  private final FrameLayout RjK;
  private RecyclerView.m RjL;
  private final f RjM;
  final MMHandler handler;
  private RecyclerView.a<VH> hbg;
  public boolean isAutoPlay;
  private final int oYw;
  
  static
  {
    AppMethodBeat.i(164547);
    RjN = new a((byte)0);
    AppMethodBeat.o(164547);
  }
  
  public MediaBanner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164553);
    this.oYw = ((int)getResources().getDimension(2131165314));
    this.RjB = ((int)getResources().getDimension(2131165299));
    this.RjC = d.RjP;
    paramContext = getContext();
    p.g(paramContext, "context");
    this.RjE = fF(paramContext);
    paramContext = getContext();
    p.g(paramContext, "context");
    this.RjF = ((h)new MediaBannerIndicator(paramContext));
    this.RjI = ((RecyclerView.c)new f(this));
    paramContext = getContext();
    p.g(paramContext, "context");
    this.RjJ = ((RecyclerHorizontalViewPager)new h(this, paramContext));
    this.RjK = new FrameLayout(getContext());
    this.RjM = g.ah((kotlin.g.a.a)new e(this));
    this.RjJ.setHasFixedSize(false);
    this.RjE.ca(3);
    this.RjE.setItemPrefetchEnabled(true);
    this.RjE.setOrientation(0);
    this.RjJ.setLayoutManager((RecyclerView.LayoutManager)this.RjE);
    this.RjK.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    paramContext = getContainer();
    if (paramContext != null) {
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    }
    setIndicatorStyle(this.RjC);
    this.RjJ.setOnInterceptTouchEvent((RecyclerHorizontalViewPager.c)new RecyclerHorizontalViewPager.c()
    {
      private float aTD;
      
      public final boolean b(MotionEvent paramAnonymousMotionEvent, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(204958);
        p.h(paramAnonymousMotionEvent, "event");
        paramAnonymousBoolean = MediaBanner.d(paramAnonymousMotionEvent, paramAnonymousBoolean);
        AppMethodBeat.o(204958);
        return paramAnonymousBoolean;
      }
      
      public final void n(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(204957);
        p.h(paramAnonymousMotionEvent, "event");
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          localObject = this.RjO;
          if (((MediaBanner)localObject).isAutoPlay)
          {
            ((MediaBanner)localObject).handler.removeMessages(1);
            ((MediaBanner)localObject).handler.sendEmptyMessageDelayed(1, 2000L);
          }
        }
        Object localObject = this.RjO.getParentRecyclerView();
        RecyclerView.LayoutManager localLayoutManager;
        int i;
        if (localObject != null)
        {
          localObject = ((RecyclerView)localObject).getLayoutManager();
          if (!(localObject instanceof MediaBanner.b)) {
            break label247;
          }
          localLayoutManager = this.RjO.getPagerView().getLayoutManager();
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
              paramAnonymousMotionEvent = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
              AppMethodBeat.o(204957);
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
              this.aTD = paramAnonymousMotionEvent.getRawX();
            }
            for (;;)
            {
              if ((paramAnonymousMotionEvent.getAction() == 1) || (paramAnonymousMotionEvent.getAction() == 3)) {
                ((MediaBanner.b)localObject).pc(true);
              }
              AppMethodBeat.o(204957);
              return;
              if ((paramAnonymousMotionEvent.getAction() == 2) && (Math.abs(paramAnonymousMotionEvent.getRawX() - this.aTD) >= 10.0F)) {
                ((MediaBanner.b)localObject).pc(false);
              }
            }
          }
        }
        label247:
        AppMethodBeat.o(204957);
      }
    });
    this.handler = new MMHandler(Looper.getMainLooper(), (MMHandler.Callback)new g(this));
    AppMethodBeat.o(164553);
  }
  
  public MediaBanner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164554);
    this.oYw = ((int)getResources().getDimension(2131165314));
    this.RjB = ((int)getResources().getDimension(2131165299));
    this.RjC = d.RjP;
    paramContext = getContext();
    p.g(paramContext, "context");
    this.RjE = fF(paramContext);
    paramContext = getContext();
    p.g(paramContext, "context");
    this.RjF = ((h)new MediaBannerIndicator(paramContext));
    this.RjI = ((RecyclerView.c)new f(this));
    paramContext = getContext();
    p.g(paramContext, "context");
    this.RjJ = ((RecyclerHorizontalViewPager)new h(this, paramContext));
    this.RjK = new FrameLayout(getContext());
    this.RjM = g.ah((kotlin.g.a.a)new e(this));
    this.RjJ.setHasFixedSize(false);
    this.RjE.ca(3);
    this.RjE.setItemPrefetchEnabled(true);
    this.RjE.setOrientation(0);
    this.RjJ.setLayoutManager((RecyclerView.LayoutManager)this.RjE);
    this.RjK.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    paramContext = getContainer();
    if (paramContext != null) {
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    }
    setIndicatorStyle(this.RjC);
    this.RjJ.setOnInterceptTouchEvent((RecyclerHorizontalViewPager.c)new RecyclerHorizontalViewPager.c()
    {
      private float aTD;
      
      public final boolean b(MotionEvent paramAnonymousMotionEvent, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(204958);
        p.h(paramAnonymousMotionEvent, "event");
        paramAnonymousBoolean = MediaBanner.d(paramAnonymousMotionEvent, paramAnonymousBoolean);
        AppMethodBeat.o(204958);
        return paramAnonymousBoolean;
      }
      
      public final void n(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(204957);
        p.h(paramAnonymousMotionEvent, "event");
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          localObject = this.RjO;
          if (((MediaBanner)localObject).isAutoPlay)
          {
            ((MediaBanner)localObject).handler.removeMessages(1);
            ((MediaBanner)localObject).handler.sendEmptyMessageDelayed(1, 2000L);
          }
        }
        Object localObject = this.RjO.getParentRecyclerView();
        RecyclerView.LayoutManager localLayoutManager;
        int i;
        if (localObject != null)
        {
          localObject = ((RecyclerView)localObject).getLayoutManager();
          if (!(localObject instanceof MediaBanner.b)) {
            break label247;
          }
          localLayoutManager = this.RjO.getPagerView().getLayoutManager();
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
              paramAnonymousMotionEvent = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
              AppMethodBeat.o(204957);
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
              this.aTD = paramAnonymousMotionEvent.getRawX();
            }
            for (;;)
            {
              if ((paramAnonymousMotionEvent.getAction() == 1) || (paramAnonymousMotionEvent.getAction() == 3)) {
                ((MediaBanner.b)localObject).pc(true);
              }
              AppMethodBeat.o(204957);
              return;
              if ((paramAnonymousMotionEvent.getAction() == 2) && (Math.abs(paramAnonymousMotionEvent.getRawX() - this.aTD) >= 10.0F)) {
                ((MediaBanner.b)localObject).pc(false);
              }
            }
          }
        }
        label247:
        AppMethodBeat.o(204957);
      }
    });
    this.handler = new MMHandler(Looper.getMainLooper(), (MMHandler.Callback)new g(this));
    AppMethodBeat.o(164554);
  }
  
  public static boolean d(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    AppMethodBeat.i(164551);
    p.h(paramMotionEvent, "event");
    AppMethodBeat.o(164551);
    return paramBoolean;
  }
  
  public final void bV(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(204971);
    RecyclerHorizontalViewPager localRecyclerHorizontalViewPager = this.RjJ;
    com.tencent.mm.hellhoundlib.b.a locala = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerHorizontalViewPager, locala.axQ(), "com/tencent/mm/view/MediaBanner", "selectViewAt", "(IZ)V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerHorizontalViewPager.scrollToPosition(((Integer)locala.pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerHorizontalViewPager, "com/tencent/mm/view/MediaBanner", "selectViewAt", "(IZ)V", "Undefined", "scrollToPosition", "(I)V");
    this.RjJ.e(paramInt, true, paramBoolean);
    AppMethodBeat.o(204971);
  }
  
  public final void bW(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(204973);
    RecyclerHorizontalViewPager localRecyclerHorizontalViewPager = this.RjJ;
    com.tencent.mm.hellhoundlib.b.a locala = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerHorizontalViewPager, locala.axQ(), "com/tencent/mm/view/MediaBanner", "smoothScrollTo", "(IZ)V", "Undefined", "smoothScrollToPosition", "(I)V");
    localRecyclerHorizontalViewPager.smoothScrollToPosition(((Integer)locala.pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerHorizontalViewPager, "com/tencent/mm/view/MediaBanner", "smoothScrollTo", "(IZ)V", "Undefined", "smoothScrollToPosition", "(I)V");
    this.RjJ.e(paramInt, true, paramBoolean);
    AppMethodBeat.o(204973);
  }
  
  public void dGY()
  {
    AppMethodBeat.i(204975);
    this.handler.removeMessages(1);
    this.handler.sendEmptyMessageDelayed(1, 2500L);
    AppMethodBeat.o(204975);
  }
  
  public void dGZ()
  {
    AppMethodBeat.i(204976);
    this.handler.removeMessages(1);
    AppMethodBeat.o(204976);
  }
  
  public LinearLayoutManager fF(Context paramContext)
  {
    AppMethodBeat.i(204967);
    p.h(paramContext, "context");
    paramContext = new LinearLayoutManager();
    AppMethodBeat.o(204967);
    return paramContext;
  }
  
  public final RecyclerView.a<VH> getAdapter()
  {
    return this.hbg;
  }
  
  public final LinearLayout getContainer()
  {
    AppMethodBeat.i(164550);
    LinearLayout localLinearLayout = (LinearLayout)this.RjM.getValue();
    AppMethodBeat.o(164550);
    return localLinearLayout;
  }
  
  public final RecyclerView.c getDataObserver()
  {
    return this.RjI;
  }
  
  public final int getFocusPosition()
  {
    return this.RjG;
  }
  
  public final h getIndicator()
  {
    return this.RjF;
  }
  
  public final int getIndicatorHeight()
  {
    return this.RjB;
  }
  
  public final LinearLayoutManager getManager()
  {
    return this.RjE;
  }
  
  public final c getPageChangeCallback()
  {
    return this.RjD;
  }
  
  public final RecyclerHorizontalViewPager getPagerView()
  {
    return this.RjJ;
  }
  
  public final FrameLayout getPagerViewContainer()
  {
    return this.RjK;
  }
  
  public final RecyclerView getParentRecyclerView()
  {
    return this.RjH;
  }
  
  public final d getStyle()
  {
    return this.RjC;
  }
  
  public final RecyclerView.m getViewPool()
  {
    return this.RjL;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(204977);
    super.onAttachedToWindow();
    if (this.isAutoPlay) {
      dGY();
    }
    AppMethodBeat.o(204977);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(204978);
    super.onDetachedFromWindow();
    dGZ();
    AppMethodBeat.o(204978);
  }
  
  public final void setAdapter(RecyclerView.a<VH> parama)
  {
    AppMethodBeat.i(164552);
    this.hbg = parama;
    this.RjJ.setAdapter(this.hbg);
    parama = this.hbg;
    if (parama != null)
    {
      parama.a(this.RjI);
      AppMethodBeat.o(164552);
      return;
    }
    AppMethodBeat.o(164552);
  }
  
  public final void setAutoPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(204968);
    this.isAutoPlay = paramBoolean;
    if (paramBoolean)
    {
      dGY();
      AppMethodBeat.o(204968);
      return;
    }
    dGZ();
    AppMethodBeat.o(204968);
  }
  
  public final void setDataObserver(RecyclerView.c paramc)
  {
    AppMethodBeat.i(204969);
    p.h(paramc, "<set-?>");
    this.RjI = paramc;
    AppMethodBeat.o(204969);
  }
  
  public final void setFocusPosition(int paramInt)
  {
    this.RjG = paramInt;
  }
  
  public final void setIndicator(h paramh)
  {
    AppMethodBeat.i(204966);
    p.h(paramh, "<set-?>");
    this.RjF = paramh;
    AppMethodBeat.o(204966);
  }
  
  public final void setIndicatorStyle(d paramd)
  {
    AppMethodBeat.i(204970);
    p.h(paramd, "style");
    this.RjC = paramd;
    switch (k.$EnumSwitchMapping$0[paramd.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(204970);
      return;
      this.RjK.removeView(this.RjF.getView());
      paramd = getContainer();
      if (paramd != null) {
        paramd.removeView(this.RjF.getView());
      }
      removeView(this.RjF.getView());
      AppMethodBeat.o(204970);
      return;
      paramd = getContainer();
      if (paramd != null)
      {
        paramd.setOrientation(1);
        paramd.setGravity(49);
        localObject = this.RjK;
        View localView = (View)this.RjJ;
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 17;
        ((FrameLayout)localObject).addView(localView, (ViewGroup.LayoutParams)localLayoutParams);
        paramd.addView((View)this.RjK, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
        localObject = this.RjF.getView();
        if ((localObject instanceof LinearLayout)) {
          ((LinearLayout)localObject).setGravity(17);
        }
        paramd.addView(this.RjF.getView(), (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, this.RjB));
        paramd.setGravity(17);
        addView((View)paramd, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        AppMethodBeat.o(204970);
        return;
      }
      AppMethodBeat.o(204970);
      return;
      this.RjK.addView((View)this.RjJ);
      addView((View)this.RjK, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      paramd = new FrameLayout.LayoutParams(-1, this.RjB);
      paramd.bottomMargin = this.oYw;
      paramd.gravity = 81;
      Object localObject = this.RjF.getView();
      if ((localObject instanceof LinearLayout)) {
        ((LinearLayout)localObject).setGravity(81);
      }
      addView(this.RjF.getView(), (ViewGroup.LayoutParams)paramd);
    }
  }
  
  public final void setPageChangeCallback(c paramc)
  {
    this.RjD = paramc;
  }
  
  public final void setParentRecyclerView(RecyclerView paramRecyclerView)
  {
    this.RjH = paramRecyclerView;
  }
  
  public final void setStyle(d paramd)
  {
    AppMethodBeat.i(164548);
    p.h(paramd, "<set-?>");
    this.RjC = paramd;
    AppMethodBeat.o(164548);
  }
  
  public final void setViewPool(RecyclerView.m paramm)
  {
    AppMethodBeat.i(164549);
    this.RjL = paramm;
    this.RjJ.setRecycledViewPool(paramm);
    AppMethodBeat.o(164549);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/MediaBanner$Companion;", "", "()V", "IMAGE_LOOP_INTERVAL", "", "IMAGE_LOOP_PAUSE_INTERVAL", "SCROLL_TO_NEXT_IMG_WHAT", "", "TAG", "", "libmmui_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/MediaBanner$ILayoutManagerScrollEnableCallback;", "", "setScrollVerticallyEnable", "", "enable", "", "libmmui_release"})
  public static abstract interface b
  {
    public abstract void pc(boolean paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "libmmui_release"})
  public static abstract interface c
  {
    public abstract void e(int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/MediaBanner$Style;", "", "(Ljava/lang/String;I)V", "BOTTOM", "INSIDE", "NONE", "libmmui_release"})
  public static enum d
  {
    static
    {
      AppMethodBeat.i(164539);
      d locald1 = new d("BOTTOM", 0);
      RjP = locald1;
      d locald2 = new d("INSIDE", 1);
      RjQ = locald2;
      d locald3 = new d("NONE", 2);
      RjR = locald3;
      RjS = new d[] { locald1, locald2, locald3 };
      AppMethodBeat.o(164539);
    }
    
    private d() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/LinearLayout;", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<LinearLayout>
  {
    e(MediaBanner paramMediaBanner)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/view/MediaBanner$dataObserver$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeInserted", "positionStart", "", "itemCount", "onItemRangeRemoved", "libmmui_release"})
  public static final class f
    extends RecyclerView.c
  {
    public final void onChanged()
    {
      AppMethodBeat.i(204960);
      super.onChanged();
      Object localObject = this.RjO.getAdapter();
      if (localObject != null)
      {
        this.RjO.getIndicator().setCount(((RecyclerView.a)localObject).getItemCount());
        if (this.RjO.getIndicator().getCount() > 0)
        {
          localObject = this.RjO.getPagerView();
          com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/view/MediaBanner$dataObserver$1", "onChanged", "()V", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerHorizontalViewPager)localObject).scrollToPosition(((Integer)locala.pG(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/view/MediaBanner$dataObserver$1", "onChanged", "()V", "Undefined", "scrollToPosition", "(I)V");
        }
        AppMethodBeat.o(204960);
        return;
      }
      AppMethodBeat.o(204960);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(204961);
      super.onItemRangeInserted(paramInt1, paramInt2);
      RecyclerView.a locala = this.RjO.getAdapter();
      if (locala != null)
      {
        this.RjO.getIndicator().setCount(locala.getItemCount());
        AppMethodBeat.o(204961);
        return;
      }
      AppMethodBeat.o(204961);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(204962);
      super.onItemRangeRemoved(paramInt1, paramInt2);
      RecyclerView.a locala = this.RjO.getAdapter();
      if (locala != null)
      {
        this.RjO.getIndicator().setCount(locala.getItemCount());
        AppMethodBeat.o(204962);
        return;
      }
      AppMethodBeat.o(204962);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class g
    implements MMHandler.Callback
  {
    g(MediaBanner paramMediaBanner) {}
    
    public final boolean handleMessage(final Message paramMessage)
    {
      int j = 0;
      AppMethodBeat.i(204964);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(204964);
        return true;
        paramMessage = this.RjO.getAdapter();
        label52:
        int k;
        if (paramMessage != null)
        {
          i = paramMessage.getItemCount();
          if (i <= 1) {
            break label114;
          }
          k = this.RjO.getFocusPosition() + 1;
          paramMessage = this.RjO.getAdapter();
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
          this.RjO.bW(k, true);
          this.RjO.dGY();
          break;
          i = 0;
          break label52;
          break;
        }
        label121:
        paramMessage = this.RjO.getAdapter();
        i = j;
        if (paramMessage != null) {
          i = paramMessage.getItemCount();
        }
        if (k != i) {
          continue;
        }
        paramMessage = this.RjO.getAdapter();
        if (!(paramMessage instanceof com.tencent.mm.ui.base.a.a)) {
          continue;
        }
        try
        {
          paramMessage.b(this.RjO.getDataObserver());
          label172:
          ((com.tencent.mm.ui.base.a.a)paramMessage).alC(((com.tencent.mm.ui.base.a.a)paramMessage).getItemCount());
          this.RjO.getPagerView().setItemAnimator(null);
          MediaBanner.b(this.RjO, k);
          this.RjO.postDelayed((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(204963);
              ((com.tencent.mm.ui.base.a.a)paramMessage).removeItem(((com.tencent.mm.ui.base.a.a)paramMessage).getItemCount() - 1);
              paramMessage.a(this.RjT.RjO.getDataObserver());
              this.RjT.RjO.bV(0, true);
              this.RjT.RjO.dGY();
              AppMethodBeat.o(204963);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/view/MediaBanner$pagerView$1", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "libmmui_release"})
  public static final class h
    extends RecyclerHorizontalViewPager
  {
    h(Context paramContext)
    {
      super();
    }
    
    public final void e(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(204965);
      super.e(paramInt, paramBoolean1, paramBoolean2);
      this.RjO.setFocusPosition(paramInt);
      this.RjO.getIndicator().setCurrentIndex(paramInt);
      MediaBanner.c localc = this.RjO.getPageChangeCallback();
      if (localc != null)
      {
        localc.e(paramInt, paramBoolean1, paramBoolean2);
        AppMethodBeat.o(204965);
        return;
      }
      AppMethodBeat.o(204965);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.MediaBanner
 * JD-Core Version:    0.7.0.1
 */