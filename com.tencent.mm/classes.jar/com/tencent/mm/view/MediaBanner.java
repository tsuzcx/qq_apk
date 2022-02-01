package com.tencent.mm.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.w;
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
import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/view/MediaBanner;", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Landroid/support/v7/widget/RecyclerView$Adapter;", "adapter", "getAdapter", "()Landroid/support/v7/widget/RecyclerView$Adapter;", "setAdapter", "(Landroid/support/v7/widget/RecyclerView$Adapter;)V", "container", "Landroid/widget/LinearLayout;", "getContainer", "()Landroid/widget/LinearLayout;", "container$delegate", "Lkotlin/Lazy;", "focusPosition", "getFocusPosition", "()I", "setFocusPosition", "(I)V", "indicator", "Lcom/tencent/mm/view/MediaBannerIndicator;", "getIndicator", "()Lcom/tencent/mm/view/MediaBannerIndicator;", "indicatorBottomMargin", "indicatorHeight", "getIndicatorHeight", "manager", "Landroid/support/v7/widget/LinearLayoutManager;", "getManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "pageChangeCallback", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "getPageChangeCallback", "()Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "setPageChangeCallback", "(Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;)V", "pagerView", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "getPagerView", "()Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "pagerViewContainer", "getPagerViewContainer", "()Landroid/widget/FrameLayout;", "parentRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getParentRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setParentRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "style", "Lcom/tencent/mm/view/MediaBanner$Style;", "getStyle", "()Lcom/tencent/mm/view/MediaBanner$Style;", "setStyle", "(Lcom/tencent/mm/view/MediaBanner$Style;)V", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "viewPool", "getViewPool", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "setViewPool", "(Landroid/support/v7/widget/RecyclerView$RecycledViewPool;)V", "getChildViewAt", "Landroid/view/View;", "position", "getLinearLayoutManager", "isInterceptTouch", "", "direction", "event", "Landroid/view/MotionEvent;", "isSuperIntercept", "selectViewAt", "", "Companion", "ILayoutManagerScrollEnableCallback", "IPageChangeCallback", "Style", "libmmui_release"})
public class MediaBanner<VH extends RecyclerView.w>
  extends FrameLayout
{
  public static final MediaBanner.a LLB;
  private final f LLA;
  private final int LLq;
  private MediaBanner.d LLr;
  private c LLs;
  private final LinearLayoutManager LLt;
  private final MediaBannerIndicator LLu;
  private int LLv;
  private RecyclerView LLw;
  private final RecyclerHorizontalViewPager LLx;
  private final FrameLayout LLy;
  private RecyclerView.n LLz;
  private RecyclerView.a<VH> gqn;
  private final int nNB;
  
  static
  {
    AppMethodBeat.i(164547);
    LLB = new MediaBanner.a((byte)0);
    AppMethodBeat.o(164547);
  }
  
  public MediaBanner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164553);
    this.nNB = ((int)getResources().getDimension(2131165303));
    this.LLq = ((int)getResources().getDimension(2131165292));
    this.LLr = MediaBanner.d.LLD;
    paramContext = getContext();
    p.g(paramContext, "context");
    this.LLt = kQ(paramContext);
    this.LLu = new MediaBannerIndicator(getContext());
    paramContext = getContext();
    p.g(paramContext, "context");
    this.LLx = ((RecyclerHorizontalViewPager)new g(this, paramContext));
    this.LLy = new FrameLayout(getContext());
    this.LLA = g.O((d.g.a.a)new f(this));
    this.LLx.setHasFixedSize(false);
    this.LLt.cb(3);
    this.LLt.aw(true);
    this.LLt.setOrientation(0);
    this.LLx.setLayoutManager((RecyclerView.i)this.LLt);
    this.LLy.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    paramContext = getContainer();
    if (paramContext != null) {
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    }
    if (this.LLr == MediaBanner.d.LLD)
    {
      paramContext = getContainer();
      if (paramContext != null)
      {
        paramContext.setOrientation(1);
        paramContext.setGravity(49);
        this.LLy.addView((View)this.LLx, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
        paramContext.addView((View)this.LLy, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
        this.LLu.setGravity(17);
        paramContext.addView((View)this.LLu, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, this.LLq));
        paramContext.setGravity(17);
        addView((View)paramContext, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      }
    }
    for (;;)
    {
      this.LLx.setOnInterceptTouchEvent((RecyclerHorizontalViewPager.c)new RecyclerHorizontalViewPager.c()
      {
        private float aTL;
        
        public final boolean b(MotionEvent paramAnonymousMotionEvent, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(164538);
          p.h(paramAnonymousMotionEvent, "event");
          paramAnonymousBoolean = MediaBanner.c(paramAnonymousMotionEvent, paramAnonymousBoolean);
          AppMethodBeat.o(164538);
          return paramAnonymousBoolean;
        }
        
        public final void k(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(164537);
          p.h(paramAnonymousMotionEvent, "event");
          Object localObject = this.LLC.getParentRecyclerView();
          RecyclerView.i locali;
          int i;
          if (localObject != null)
          {
            localObject = ((RecyclerView)localObject).getLayoutManager();
            if (!(localObject instanceof MediaBanner.b)) {
              break label261;
            }
            locali = this.LLC.getPagerView().getLayoutManager();
            if (locali == null) {
              break label261;
            }
            if ((!(locali instanceof LinearLayoutManager)) || (((LinearLayoutManager)locali).getItemCount() <= 1)) {
              break label116;
            }
            i = 1;
            label79:
            if (i == 0) {
              break label121;
            }
          }
          for (;;)
          {
            if (locali != null)
            {
              if (locali == null)
              {
                paramAnonymousMotionEvent = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(164537);
                throw paramAnonymousMotionEvent;
                localObject = null;
                break;
                label116:
                i = 0;
                break label79;
                label121:
                locali = null;
                continue;
              }
              if (paramAnonymousMotionEvent.getAction() == 0) {
                this.aTL = paramAnonymousMotionEvent.getRawX();
              }
              for (;;)
              {
                if ((paramAnonymousMotionEvent.getAction() == 1) || (paramAnonymousMotionEvent.getAction() == 3)) {
                  ((MediaBanner.b)localObject).mz(true);
                }
                AppMethodBeat.o(164537);
                return;
                if (paramAnonymousMotionEvent.getAction() == 2)
                {
                  float f = paramAnonymousMotionEvent.getRawX() - this.aTL;
                  if ((Math.abs(f) >= 15.0F) && (((f > 0.0F) && (((LinearLayoutManager)locali).kp() > 0)) || ((f < 0.0F) && (((LinearLayoutManager)locali).kn() < ((LinearLayoutManager)locali).getItemCount() - 1)))) {
                    ((MediaBanner.b)localObject).mz(false);
                  }
                }
              }
            }
          }
          label261:
          AppMethodBeat.o(164537);
        }
      });
      AppMethodBeat.o(164553);
      return;
      if (this.LLr == MediaBanner.d.LLE)
      {
        this.LLy.addView((View)this.LLx);
        addView((View)this.LLy, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        paramContext = new FrameLayout.LayoutParams(-1, this.LLq);
        paramContext.bottomMargin = this.nNB;
        paramContext.gravity = 81;
        this.LLu.setGravity(81);
        addView((View)this.LLu, (ViewGroup.LayoutParams)paramContext);
      }
    }
  }
  
  public MediaBanner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164554);
    this.nNB = ((int)getResources().getDimension(2131165303));
    this.LLq = ((int)getResources().getDimension(2131165292));
    this.LLr = MediaBanner.d.LLD;
    paramContext = getContext();
    p.g(paramContext, "context");
    this.LLt = kQ(paramContext);
    this.LLu = new MediaBannerIndicator(getContext());
    paramContext = getContext();
    p.g(paramContext, "context");
    this.LLx = ((RecyclerHorizontalViewPager)new g(this, paramContext));
    this.LLy = new FrameLayout(getContext());
    this.LLA = g.O((d.g.a.a)new f(this));
    this.LLx.setHasFixedSize(false);
    this.LLt.cb(3);
    this.LLt.aw(true);
    this.LLt.setOrientation(0);
    this.LLx.setLayoutManager((RecyclerView.i)this.LLt);
    this.LLy.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    paramContext = getContainer();
    if (paramContext != null) {
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    }
    if (this.LLr == MediaBanner.d.LLD)
    {
      paramContext = getContainer();
      if (paramContext != null)
      {
        paramContext.setOrientation(1);
        paramContext.setGravity(49);
        this.LLy.addView((View)this.LLx, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
        paramContext.addView((View)this.LLy, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
        this.LLu.setGravity(17);
        paramContext.addView((View)this.LLu, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, this.LLq));
        paramContext.setGravity(17);
        addView((View)paramContext, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      }
    }
    for (;;)
    {
      this.LLx.setOnInterceptTouchEvent((RecyclerHorizontalViewPager.c)new RecyclerHorizontalViewPager.c()
      {
        private float aTL;
        
        public final boolean b(MotionEvent paramAnonymousMotionEvent, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(164538);
          p.h(paramAnonymousMotionEvent, "event");
          paramAnonymousBoolean = MediaBanner.c(paramAnonymousMotionEvent, paramAnonymousBoolean);
          AppMethodBeat.o(164538);
          return paramAnonymousBoolean;
        }
        
        public final void k(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(164537);
          p.h(paramAnonymousMotionEvent, "event");
          Object localObject = this.LLC.getParentRecyclerView();
          RecyclerView.i locali;
          int i;
          if (localObject != null)
          {
            localObject = ((RecyclerView)localObject).getLayoutManager();
            if (!(localObject instanceof MediaBanner.b)) {
              break label261;
            }
            locali = this.LLC.getPagerView().getLayoutManager();
            if (locali == null) {
              break label261;
            }
            if ((!(locali instanceof LinearLayoutManager)) || (((LinearLayoutManager)locali).getItemCount() <= 1)) {
              break label116;
            }
            i = 1;
            label79:
            if (i == 0) {
              break label121;
            }
          }
          for (;;)
          {
            if (locali != null)
            {
              if (locali == null)
              {
                paramAnonymousMotionEvent = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(164537);
                throw paramAnonymousMotionEvent;
                localObject = null;
                break;
                label116:
                i = 0;
                break label79;
                label121:
                locali = null;
                continue;
              }
              if (paramAnonymousMotionEvent.getAction() == 0) {
                this.aTL = paramAnonymousMotionEvent.getRawX();
              }
              for (;;)
              {
                if ((paramAnonymousMotionEvent.getAction() == 1) || (paramAnonymousMotionEvent.getAction() == 3)) {
                  ((MediaBanner.b)localObject).mz(true);
                }
                AppMethodBeat.o(164537);
                return;
                if (paramAnonymousMotionEvent.getAction() == 2)
                {
                  float f = paramAnonymousMotionEvent.getRawX() - this.aTL;
                  if ((Math.abs(f) >= 15.0F) && (((f > 0.0F) && (((LinearLayoutManager)locali).kp() > 0)) || ((f < 0.0F) && (((LinearLayoutManager)locali).kn() < ((LinearLayoutManager)locali).getItemCount() - 1)))) {
                    ((MediaBanner.b)localObject).mz(false);
                  }
                }
              }
            }
          }
          label261:
          AppMethodBeat.o(164537);
        }
      });
      AppMethodBeat.o(164554);
      return;
      if (this.LLr == MediaBanner.d.LLE)
      {
        this.LLy.addView((View)this.LLx);
        addView((View)this.LLy, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        paramContext = new FrameLayout.LayoutParams(-1, this.LLq);
        paramContext.bottomMargin = this.nNB;
        paramContext.gravity = 81;
        this.LLu.setGravity(81);
        addView((View)this.LLu, (ViewGroup.LayoutParams)paramContext);
      }
    }
  }
  
  public static boolean c(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    AppMethodBeat.i(164551);
    p.h(paramMotionEvent, "event");
    AppMethodBeat.o(164551);
    return paramBoolean;
  }
  
  private static LinearLayoutManager kQ(Context paramContext)
  {
    AppMethodBeat.i(193904);
    p.h(paramContext, "context");
    paramContext = new LinearLayoutManager();
    AppMethodBeat.o(193904);
    return paramContext;
  }
  
  public final RecyclerView.a<VH> getAdapter()
  {
    return this.gqn;
  }
  
  public final LinearLayout getContainer()
  {
    AppMethodBeat.i(164550);
    LinearLayout localLinearLayout = (LinearLayout)this.LLA.getValue();
    AppMethodBeat.o(164550);
    return localLinearLayout;
  }
  
  public final int getFocusPosition()
  {
    return this.LLv;
  }
  
  public final MediaBannerIndicator getIndicator()
  {
    return this.LLu;
  }
  
  public final int getIndicatorHeight()
  {
    return this.LLq;
  }
  
  public final LinearLayoutManager getManager()
  {
    return this.LLt;
  }
  
  public final c getPageChangeCallback()
  {
    return this.LLs;
  }
  
  public final RecyclerHorizontalViewPager getPagerView()
  {
    return this.LLx;
  }
  
  public final FrameLayout getPagerViewContainer()
  {
    return this.LLy;
  }
  
  public final RecyclerView getParentRecyclerView()
  {
    return this.LLw;
  }
  
  public final MediaBanner.d getStyle()
  {
    return this.LLr;
  }
  
  public final RecyclerView.n getViewPool()
  {
    return this.LLz;
  }
  
  public final void setAdapter(RecyclerView.a<VH> parama)
  {
    AppMethodBeat.i(164552);
    this.gqn = parama;
    this.LLx.setAdapter(this.gqn);
    parama = this.gqn;
    if (parama != null)
    {
      parama.a((RecyclerView.c)new e(this));
      AppMethodBeat.o(164552);
      return;
    }
    AppMethodBeat.o(164552);
  }
  
  public final void setFocusPosition(int paramInt)
  {
    this.LLv = paramInt;
  }
  
  public final void setPageChangeCallback(c paramc)
  {
    this.LLs = paramc;
  }
  
  public final void setParentRecyclerView(RecyclerView paramRecyclerView)
  {
    this.LLw = paramRecyclerView;
  }
  
  public final void setStyle(MediaBanner.d paramd)
  {
    AppMethodBeat.i(164548);
    p.h(paramd, "<set-?>");
    this.LLr = paramd;
    AppMethodBeat.o(164548);
  }
  
  public final void setViewPool(RecyclerView.n paramn)
  {
    AppMethodBeat.i(164549);
    this.LLz = paramn;
    this.LLx.setRecycledViewPool(paramn);
    AppMethodBeat.o(164549);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "", "onPageChange", "", "position", "", "isIdle", "", "libmmui_release"})
  public static abstract interface c
  {
    public abstract void af(int paramInt, boolean paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/view/MediaBanner$adapter$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeInserted", "positionStart", "", "itemCount", "onItemRangeRemoved", "libmmui_release"})
  public static final class e
    extends RecyclerView.c
  {
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(164543);
      super.au(paramInt1, paramInt2);
      RecyclerView.a locala = this.LLC.getAdapter();
      if (locala != null)
      {
        this.LLC.getIndicator().setCount(locala.getItemCount());
        AppMethodBeat.o(164543);
        return;
      }
      AppMethodBeat.o(164543);
    }
    
    public final void av(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(164544);
      super.av(paramInt1, paramInt2);
      RecyclerView.a locala = this.LLC.getAdapter();
      if (locala != null)
      {
        this.LLC.getIndicator().setCount(locala.getItemCount());
        AppMethodBeat.o(164544);
        return;
      }
      AppMethodBeat.o(164544);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(164542);
      super.onChanged();
      Object localObject = this.LLC.getAdapter();
      if (localObject != null)
      {
        this.LLC.getIndicator().setCount(((RecyclerView.a)localObject).getItemCount());
        if (this.LLC.getIndicator().getCount() > 0)
        {
          localObject = this.LLC.getPagerView();
          com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/view/MediaBanner$adapter$1", "onChanged", "()V", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerHorizontalViewPager)localObject).ca(((Integer)locala.mt(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/view/MediaBanner$adapter$1", "onChanged", "()V", "Undefined", "scrollToPosition", "(I)V");
        }
        AppMethodBeat.o(164542);
        return;
      }
      AppMethodBeat.o(164542);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/LinearLayout;", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<LinearLayout>
  {
    f(MediaBanner paramMediaBanner)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/view/MediaBanner$pagerView$1", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "onPageChange", "", "position", "", "isIdle", "", "libmmui_release"})
  public static final class g
    extends RecyclerHorizontalViewPager
  {
    g(Context paramContext)
    {
      super();
    }
    
    public final void af(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(164546);
      super.af(paramInt, paramBoolean);
      this.LLC.setFocusPosition(paramInt);
      this.LLC.getIndicator().setCurrentIndex(paramInt);
      MediaBanner.c localc = this.LLC.getPageChangeCallback();
      if (localc != null)
      {
        localc.af(paramInt, paramBoolean);
        AppMethodBeat.o(164546);
        return;
      }
      AppMethodBeat.o(164546);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.MediaBanner
 * JD-Core Version:    0.7.0.1
 */