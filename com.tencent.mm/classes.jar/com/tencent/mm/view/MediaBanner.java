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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/MediaBanner;", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "container", "Landroid/widget/LinearLayout;", "getContainer", "()Landroid/widget/LinearLayout;", "container$delegate", "Lkotlin/Lazy;", "dataObserver", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "getDataObserver", "()Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "setDataObserver", "(Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;)V", "focusPosition", "getFocusPosition", "()I", "setFocusPosition", "(I)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "indicator", "Lcom/tencent/mm/view/IMediaBannerIndicator;", "getIndicator", "()Lcom/tencent/mm/view/IMediaBannerIndicator;", "setIndicator", "(Lcom/tencent/mm/view/IMediaBannerIndicator;)V", "indicatorBottomMargin", "indicatorHeight", "getIndicatorHeight", "", "isAutoPlay", "()Z", "setAutoPlay", "(Z)V", "manager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "pageChangeCallback", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "getPageChangeCallback", "()Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "setPageChangeCallback", "(Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;)V", "pagerView", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "getPagerView", "()Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "pagerViewContainer", "getPagerViewContainer", "()Landroid/widget/FrameLayout;", "parentRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getParentRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setParentRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "style", "Lcom/tencent/mm/view/MediaBanner$Style;", "getStyle", "()Lcom/tencent/mm/view/MediaBanner$Style;", "setStyle", "(Lcom/tencent/mm/view/MediaBanner$Style;)V", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "viewPool", "getViewPool", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "setViewPool", "(Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;)V", "getChildViewAt", "Landroid/view/View;", "position", "getLinearLayoutManager", "isInterceptTouch", "direction", "event", "Landroid/view/MotionEvent;", "isSuperIntercept", "onAttachedToWindow", "", "onDetachedFromWindow", "pauseLoopPlay", "selectViewAt", "isAuto", "setIndicatorStyle", "smoothScrollTo", "startLoopPlay", "stopLoopPlay", "Companion", "ILayoutManagerScrollEnableCallback", "IPageChangeCallback", "Style", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public class MediaBanner<VH extends RecyclerView.v>
  extends FrameLayout
{
  public static final MediaBanner.a agHa;
  private final RecyclerHorizontalViewPager EuD;
  private int GGA;
  private i GGB;
  private c GGC;
  private final int agHb;
  private d agHc;
  private final LinearLayoutManager agHd;
  private RecyclerView agHe;
  private RecyclerView.c agHf;
  private final FrameLayout agHg;
  private RecyclerView.m agHh;
  final MMHandler handler;
  public boolean isAutoPlay;
  private RecyclerView.a<VH> mlt;
  private final j vFm;
  private final int vlO;
  
  static
  {
    AppMethodBeat.i(164547);
    agHa = new MediaBanner.a((byte)0);
    AppMethodBeat.o(164547);
  }
  
  public MediaBanner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164553);
    this.vlO = ((int)getResources().getDimension(a.e.Edge_A));
    this.agHb = ((int)getResources().getDimension(a.e.Edge_3A));
    this.agHc = d.agHj;
    paramContext = getContext();
    s.s(paramContext, "context");
    this.agHd = hr(paramContext);
    paramContext = getContext();
    s.s(paramContext, "context");
    this.GGB = ((i)new MediaBannerIndicator(paramContext));
    this.agHf = ((RecyclerView.c)new g(this));
    this.EuD = ((RecyclerHorizontalViewPager)new h(this, getContext()));
    this.agHg = new FrameLayout(getContext());
    this.vFm = k.cm((kotlin.g.a.a)new f(this));
    this.EuD.setHasFixedSize(false);
    this.agHd.bXK = 3;
    this.agHd.setItemPrefetchEnabled(true);
    this.agHd.setOrientation(0);
    this.EuD.setLayoutManager((RecyclerView.LayoutManager)this.agHd);
    this.agHg.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    paramContext = getContainer();
    if (paramContext != null) {
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    }
    setIndicatorStyle(this.agHc);
    this.EuD.setOnInterceptTouchEvent((RecyclerHorizontalViewPager.c)new RecyclerHorizontalViewPager.c()
    {
      private float cxM;
      
      public final boolean a(MotionEvent paramAnonymousMotionEvent, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(234629);
        s.u(paramAnonymousMotionEvent, "event");
        paramAnonymousBoolean = MediaBanner.c(paramAnonymousMotionEvent, paramAnonymousBoolean);
        AppMethodBeat.o(234629);
        return paramAnonymousBoolean;
      }
      
      public final void n(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(234621);
        s.u(paramAnonymousMotionEvent, "event");
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          localObject = this.agHi;
          if (((MediaBanner)localObject).isAutoPlay)
          {
            ((MediaBanner)localObject).handler.removeMessages(1);
            ((MediaBanner)localObject).handler.sendEmptyMessageDelayed(1, 2000L);
          }
        }
        Object localObject = this.agHi.getParentRecyclerView();
        RecyclerView.LayoutManager localLayoutManager;
        int i;
        if (localObject == null)
        {
          localObject = null;
          if ((localObject instanceof MediaBanner.b))
          {
            localLayoutManager = this.agHi.getPagerView().getLayoutManager();
            if (localLayoutManager != null)
            {
              if ((!(localLayoutManager instanceof LinearLayoutManager)) || (((LinearLayoutManager)localLayoutManager).getItemCount() <= 1)) {
                break label175;
              }
              i = 1;
              label111:
              if (i == 0) {
                break label180;
              }
              label115:
              if (localLayoutManager != null)
              {
                if (paramAnonymousMotionEvent.getAction() != 0) {
                  break label186;
                }
                this.cxM = paramAnonymousMotionEvent.getRawX();
              }
            }
          }
        }
        for (;;)
        {
          if ((paramAnonymousMotionEvent.getAction() == 1) || (paramAnonymousMotionEvent.getAction() == 3)) {
            ((MediaBanner.b)localObject).vd(true);
          }
          AppMethodBeat.o(234621);
          return;
          localObject = ((RecyclerView)localObject).getLayoutManager();
          break;
          label175:
          i = 0;
          break label111;
          label180:
          localLayoutManager = null;
          break label115;
          label186:
          if ((paramAnonymousMotionEvent.getAction() == 2) && (Math.abs(paramAnonymousMotionEvent.getRawX() - this.cxM) >= 10.0F)) {
            ((MediaBanner.b)localObject).vd(false);
          }
        }
      }
    });
    this.handler = new MMHandler(Looper.getMainLooper(), new MediaBanner..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(164553);
  }
  
  public MediaBanner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164554);
    this.vlO = ((int)getResources().getDimension(a.e.Edge_A));
    this.agHb = ((int)getResources().getDimension(a.e.Edge_3A));
    this.agHc = d.agHj;
    paramContext = getContext();
    s.s(paramContext, "context");
    this.agHd = hr(paramContext);
    paramContext = getContext();
    s.s(paramContext, "context");
    this.GGB = ((i)new MediaBannerIndicator(paramContext));
    this.agHf = ((RecyclerView.c)new g(this));
    this.EuD = ((RecyclerHorizontalViewPager)new h(this, getContext()));
    this.agHg = new FrameLayout(getContext());
    this.vFm = k.cm((kotlin.g.a.a)new f(this));
    this.EuD.setHasFixedSize(false);
    this.agHd.bXK = 3;
    this.agHd.setItemPrefetchEnabled(true);
    this.agHd.setOrientation(0);
    this.EuD.setLayoutManager((RecyclerView.LayoutManager)this.agHd);
    this.agHg.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    paramContext = getContainer();
    if (paramContext != null) {
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    }
    setIndicatorStyle(this.agHc);
    this.EuD.setOnInterceptTouchEvent((RecyclerHorizontalViewPager.c)new RecyclerHorizontalViewPager.c()
    {
      private float cxM;
      
      public final boolean a(MotionEvent paramAnonymousMotionEvent, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(234629);
        s.u(paramAnonymousMotionEvent, "event");
        paramAnonymousBoolean = MediaBanner.c(paramAnonymousMotionEvent, paramAnonymousBoolean);
        AppMethodBeat.o(234629);
        return paramAnonymousBoolean;
      }
      
      public final void n(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(234621);
        s.u(paramAnonymousMotionEvent, "event");
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          localObject = this.agHi;
          if (((MediaBanner)localObject).isAutoPlay)
          {
            ((MediaBanner)localObject).handler.removeMessages(1);
            ((MediaBanner)localObject).handler.sendEmptyMessageDelayed(1, 2000L);
          }
        }
        Object localObject = this.agHi.getParentRecyclerView();
        RecyclerView.LayoutManager localLayoutManager;
        int i;
        if (localObject == null)
        {
          localObject = null;
          if ((localObject instanceof MediaBanner.b))
          {
            localLayoutManager = this.agHi.getPagerView().getLayoutManager();
            if (localLayoutManager != null)
            {
              if ((!(localLayoutManager instanceof LinearLayoutManager)) || (((LinearLayoutManager)localLayoutManager).getItemCount() <= 1)) {
                break label175;
              }
              i = 1;
              label111:
              if (i == 0) {
                break label180;
              }
              label115:
              if (localLayoutManager != null)
              {
                if (paramAnonymousMotionEvent.getAction() != 0) {
                  break label186;
                }
                this.cxM = paramAnonymousMotionEvent.getRawX();
              }
            }
          }
        }
        for (;;)
        {
          if ((paramAnonymousMotionEvent.getAction() == 1) || (paramAnonymousMotionEvent.getAction() == 3)) {
            ((MediaBanner.b)localObject).vd(true);
          }
          AppMethodBeat.o(234621);
          return;
          localObject = ((RecyclerView)localObject).getLayoutManager();
          break;
          label175:
          i = 0;
          break label111;
          label180:
          localLayoutManager = null;
          break label115;
          label186:
          if ((paramAnonymousMotionEvent.getAction() == 2) && (Math.abs(paramAnonymousMotionEvent.getRawX() - this.cxM) >= 10.0F)) {
            ((MediaBanner.b)localObject).vd(false);
          }
        }
      }
    });
    this.handler = new MMHandler(Looper.getMainLooper(), new MediaBanner..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(164554);
  }
  
  private static final void a(RecyclerView.a parama, MediaBanner paramMediaBanner)
  {
    AppMethodBeat.i(234753);
    s.u(paramMediaBanner, "this$0");
    ((com.tencent.mm.ui.base.a.a)parama).removeItem(((com.tencent.mm.ui.base.a.a)parama).getItemCount() - 1);
    parama.a(paramMediaBanner.getDataObserver());
    paramMediaBanner.cZ(0, true);
    paramMediaBanner.fla();
    AppMethodBeat.o(234753);
  }
  
  private static final boolean a(MediaBanner paramMediaBanner, Message paramMessage)
  {
    AppMethodBeat.i(234757);
    s.u(paramMediaBanner, "this$0");
    s.u(paramMessage, "it");
    int i;
    int j;
    if (paramMessage.what == 1)
    {
      paramMessage = paramMediaBanner.getAdapter();
      if (paramMessage != null) {
        break label85;
      }
      i = 0;
      if (i > 1)
      {
        j = paramMediaBanner.getFocusPosition() + 1;
        paramMessage = paramMediaBanner.getAdapter();
        if (paramMessage != null) {
          break label93;
        }
        i = 0;
        label62:
        if (j >= i) {
          break label101;
        }
        paramMediaBanner.aU(j, true);
        paramMediaBanner.fla();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(234757);
      return true;
      label85:
      i = paramMessage.getItemCount();
      break;
      label93:
      i = paramMessage.getItemCount();
      break label62;
      label101:
      paramMessage = paramMediaBanner.getAdapter();
      if (paramMessage == null)
      {
        i = 0;
        if (j != i) {
          continue;
        }
        paramMessage = paramMediaBanner.getAdapter();
        if (!(paramMessage instanceof com.tencent.mm.ui.base.a.a)) {
          continue;
        }
      }
      try
      {
        paramMessage.b(paramMediaBanner.getDataObserver());
        label137:
        ((com.tencent.mm.ui.base.a.a)paramMessage).aBb(((com.tencent.mm.ui.base.a.a)paramMessage).getItemCount());
        paramMediaBanner.getPagerView().setItemAnimator(null);
        paramMediaBanner.aU(j, false);
        paramMediaBanner.postDelayed(new MediaBanner..ExternalSyntheticLambda1(paramMessage, paramMediaBanner), 500L);
        continue;
        i = paramMessage.getItemCount();
      }
      catch (Exception localException)
      {
        break label137;
      }
    }
  }
  
  private void aU(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(234741);
    RecyclerHorizontalViewPager localRecyclerHorizontalViewPager = this.EuD;
    com.tencent.mm.hellhoundlib.b.a locala = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localRecyclerHorizontalViewPager, locala.aYi(), "com/tencent/mm/view/MediaBanner", "smoothScrollTo", "(IZ)V", "Undefined", "smoothScrollToPosition", "(I)V");
    localRecyclerHorizontalViewPager.smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localRecyclerHorizontalViewPager, "com/tencent/mm/view/MediaBanner", "smoothScrollTo", "(IZ)V", "Undefined", "smoothScrollToPosition", "(I)V");
    this.EuD.g(paramInt, true, paramBoolean);
    AppMethodBeat.o(234741);
  }
  
  public static boolean c(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    AppMethodBeat.i(164551);
    s.u(paramMotionEvent, "event");
    AppMethodBeat.o(164551);
    return paramBoolean;
  }
  
  private void cZ(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(234733);
    RecyclerHorizontalViewPager localRecyclerHorizontalViewPager = this.EuD;
    com.tencent.mm.hellhoundlib.b.a locala = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localRecyclerHorizontalViewPager, locala.aYi(), "com/tencent/mm/view/MediaBanner", "selectViewAt", "(IZ)V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerHorizontalViewPager.scrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localRecyclerHorizontalViewPager, "com/tencent/mm/view/MediaBanner", "selectViewAt", "(IZ)V", "Undefined", "scrollToPosition", "(I)V");
    this.EuD.g(paramInt, true, paramBoolean);
    AppMethodBeat.o(234733);
  }
  
  public void fla()
  {
    AppMethodBeat.i(234828);
    this.handler.removeMessages(1);
    this.handler.sendEmptyMessageDelayed(1, 2500L);
    AppMethodBeat.o(234828);
  }
  
  public void flb()
  {
    AppMethodBeat.i(234831);
    this.handler.removeMessages(1);
    AppMethodBeat.o(234831);
  }
  
  public final RecyclerView.a<VH> getAdapter()
  {
    return this.mlt;
  }
  
  public final LinearLayout getContainer()
  {
    AppMethodBeat.i(164550);
    LinearLayout localLinearLayout = (LinearLayout)this.vFm.getValue();
    AppMethodBeat.o(164550);
    return localLinearLayout;
  }
  
  public final RecyclerView.c getDataObserver()
  {
    return this.agHf;
  }
  
  public final int getFocusPosition()
  {
    return this.GGA;
  }
  
  public final i getIndicator()
  {
    return this.GGB;
  }
  
  public final int getIndicatorHeight()
  {
    return this.agHb;
  }
  
  public final LinearLayoutManager getManager()
  {
    return this.agHd;
  }
  
  public final c getPageChangeCallback()
  {
    return this.GGC;
  }
  
  public final RecyclerHorizontalViewPager getPagerView()
  {
    return this.EuD;
  }
  
  public final FrameLayout getPagerViewContainer()
  {
    return this.agHg;
  }
  
  public final RecyclerView getParentRecyclerView()
  {
    return this.agHe;
  }
  
  public final d getStyle()
  {
    return this.agHc;
  }
  
  public final RecyclerView.m getViewPool()
  {
    return this.agHh;
  }
  
  public LinearLayoutManager hr(Context paramContext)
  {
    AppMethodBeat.i(234804);
    s.u(paramContext, "context");
    paramContext = new LinearLayoutManager();
    AppMethodBeat.o(234804);
    return paramContext;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(234836);
    super.onAttachedToWindow();
    if (this.isAutoPlay) {
      fla();
    }
    AppMethodBeat.o(234836);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(234842);
    super.onDetachedFromWindow();
    flb();
    AppMethodBeat.o(234842);
  }
  
  public final void setAdapter(RecyclerView.a<VH> parama)
  {
    AppMethodBeat.i(234851);
    this.mlt = parama;
    this.EuD.setAdapter(this.mlt);
    parama = this.mlt;
    if (parama != null) {
      parama.a(this.agHf);
    }
    AppMethodBeat.o(234851);
  }
  
  public final void setAutoPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(234807);
    this.isAutoPlay = paramBoolean;
    if (paramBoolean)
    {
      fla();
      AppMethodBeat.o(234807);
      return;
    }
    flb();
    AppMethodBeat.o(234807);
  }
  
  public final void setDataObserver(RecyclerView.c paramc)
  {
    AppMethodBeat.i(234812);
    s.u(paramc, "<set-?>");
    this.agHf = paramc;
    AppMethodBeat.o(234812);
  }
  
  public final void setFocusPosition(int paramInt)
  {
    this.GGA = paramInt;
  }
  
  public final void setIndicator(i parami)
  {
    AppMethodBeat.i(234786);
    s.u(parami, "<set-?>");
    this.GGB = parami;
    AppMethodBeat.o(234786);
  }
  
  public final void setIndicatorStyle(d paramd)
  {
    AppMethodBeat.i(234826);
    s.u(paramd, "style");
    this.agHc = paramd;
    switch (e.$EnumSwitchMapping$0[paramd.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(234826);
      return;
      this.agHg.removeView(this.GGB.getView());
      paramd = getContainer();
      if (paramd != null) {
        paramd.removeView(this.GGB.getView());
      }
      removeView(this.GGB.getView());
      AppMethodBeat.o(234826);
      return;
      paramd = getContainer();
      if (paramd != null)
      {
        paramd.setOrientation(1);
        paramd.setGravity(49);
        Object localObject = getPagerViewContainer();
        View localView = (View)getPagerView();
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 17;
        ah localah = ah.aiuX;
        ((FrameLayout)localObject).addView(localView, (ViewGroup.LayoutParams)localLayoutParams);
        paramd.addView((View)getPagerViewContainer(), (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
        localObject = getIndicator().getView();
        if ((localObject instanceof LinearLayout)) {
          ((LinearLayout)localObject).setGravity(17);
        }
        paramd.addView(getIndicator().getView(), (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, getIndicatorHeight()));
        paramd.setGravity(17);
        addView((View)paramd, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        AppMethodBeat.o(234826);
        return;
        this.agHg.addView((View)this.EuD);
        addView((View)this.agHg, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        paramd = new FrameLayout.LayoutParams(-1, this.agHb);
        paramd.bottomMargin = this.vlO;
        paramd.gravity = 81;
        localObject = this.GGB.getView();
        if ((localObject instanceof LinearLayout)) {
          ((LinearLayout)localObject).setGravity(81);
        }
        addView(this.GGB.getView(), (ViewGroup.LayoutParams)paramd);
      }
    }
  }
  
  public final void setPageChangeCallback(c paramc)
  {
    this.GGC = paramc;
  }
  
  public final void setParentRecyclerView(RecyclerView paramRecyclerView)
  {
    this.agHe = paramRecyclerView;
  }
  
  public final void setStyle(d paramd)
  {
    AppMethodBeat.i(164548);
    s.u(paramd, "<set-?>");
    this.agHc = paramd;
    AppMethodBeat.o(164548);
  }
  
  public final void setViewPool(RecyclerView.m paramm)
  {
    AppMethodBeat.i(234820);
    this.agHh = paramm;
    this.EuD.setRecycledViewPool(paramm);
    AppMethodBeat.o(234820);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/MediaBanner$ILayoutManagerScrollEnableCallback;", "", "setScrollVerticallyEnable", "", "enable", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void vd(boolean paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void g(int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/MediaBanner$Style;", "", "(Ljava/lang/String;I)V", "BOTTOM", "INSIDE", "NONE", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum d
  {
    static
    {
      AppMethodBeat.i(164539);
      agHj = new d("BOTTOM", 0);
      agHk = new d("INSIDE", 1);
      agHl = new d("NONE", 2);
      agHm = new d[] { agHj, agHk, agHl };
      AppMethodBeat.o(164539);
    }
    
    private d() {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    f(MediaBanner<VH> paramMediaBanner)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/view/MediaBanner$dataObserver$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeInserted", "positionStart", "", "itemCount", "onItemRangeRemoved", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends RecyclerView.c
  {
    g(MediaBanner<VH> paramMediaBanner) {}
    
    public final void onChanged()
    {
      AppMethodBeat.i(235048);
      super.onChanged();
      Object localObject1 = this.agHi.getAdapter();
      if (localObject1 != null)
      {
        Object localObject2 = this.agHi;
        ((MediaBanner)localObject2).getIndicator().setCount(((RecyclerView.a)localObject1).getItemCount());
        if (((MediaBanner)localObject2).getIndicator().getCount() > 0)
        {
          localObject1 = ((MediaBanner)localObject2).getPagerView();
          localObject2 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/view/MediaBanner$dataObserver$1", "onChanged", "()V", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerHorizontalViewPager)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/view/MediaBanner$dataObserver$1", "onChanged", "()V", "Undefined", "scrollToPosition", "(I)V");
        }
      }
      AppMethodBeat.o(235048);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(235053);
      super.onItemRangeInserted(paramInt1, paramInt2);
      RecyclerView.a locala = this.agHi.getAdapter();
      if (locala != null) {
        this.agHi.getIndicator().setCount(locala.getItemCount());
      }
      AppMethodBeat.o(235053);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(235058);
      super.onItemRangeRemoved(paramInt1, paramInt2);
      RecyclerView.a locala = this.agHi.getAdapter();
      if (locala != null) {
        this.agHi.getIndicator().setCount(locala.getItemCount());
      }
      AppMethodBeat.o(235058);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/view/MediaBanner$pagerView$1", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    extends RecyclerHorizontalViewPager
  {
    h(MediaBanner<VH> paramMediaBanner, Context paramContext)
    {
      super();
      AppMethodBeat.i(235046);
      AppMethodBeat.o(235046);
    }
    
    public final void g(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(235051);
      super.g(paramInt, paramBoolean1, paramBoolean2);
      this.agHi.setFocusPosition(paramInt);
      this.agHi.getIndicator().setCurrentIndex(paramInt);
      MediaBanner.c localc = this.agHi.getPageChangeCallback();
      if (localc != null) {
        localc.g(paramInt, paramBoolean1, paramBoolean2);
      }
      AppMethodBeat.o(235051);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.MediaBanner
 * JD-Core Version:    0.7.0.1
 */