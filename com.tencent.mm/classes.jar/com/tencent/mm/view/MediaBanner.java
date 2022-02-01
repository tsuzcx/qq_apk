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
import d.g.b.u;
import d.g.b.w;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/view/MediaBanner;", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Landroid/support/v7/widget/RecyclerView$Adapter;", "adapter", "getAdapter", "()Landroid/support/v7/widget/RecyclerView$Adapter;", "setAdapter", "(Landroid/support/v7/widget/RecyclerView$Adapter;)V", "container", "Landroid/widget/LinearLayout;", "getContainer", "()Landroid/widget/LinearLayout;", "container$delegate", "Lkotlin/Lazy;", "focusPosition", "getFocusPosition", "()I", "setFocusPosition", "(I)V", "indicator", "Lcom/tencent/mm/view/MediaBannerIndicator;", "getIndicator", "()Lcom/tencent/mm/view/MediaBannerIndicator;", "indicatorBottomMargin", "indicatorHeight", "getIndicatorHeight", "manager", "Landroid/support/v7/widget/LinearLayoutManager;", "getManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "pageChangeCallback", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "getPageChangeCallback", "()Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "setPageChangeCallback", "(Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;)V", "pagerView", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "getPagerView", "()Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "pagerViewContainer", "getPagerViewContainer", "()Landroid/widget/FrameLayout;", "parentRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getParentRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setParentRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "style", "Lcom/tencent/mm/view/MediaBanner$Style;", "getStyle", "()Lcom/tencent/mm/view/MediaBanner$Style;", "setStyle", "(Lcom/tencent/mm/view/MediaBanner$Style;)V", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "viewPool", "getViewPool", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "setViewPool", "(Landroid/support/v7/widget/RecyclerView$RecycledViewPool;)V", "getChildViewAt", "Landroid/view/View;", "position", "getLinearLayoutManager", "isInterceptTouch", "", "direction", "event", "Landroid/view/MotionEvent;", "isSuperIntercept", "selectViewAt", "", "Companion", "ILayoutManagerScrollEnableCallback", "IPageChangeCallback", "Style", "libmmui_release"})
public class MediaBanner<VH extends RecyclerView.w>
  extends FrameLayout
{
  public static final MediaBanner.a JvO;
  private final int JvD;
  private MediaBanner.d JvE;
  private c JvF;
  private final LinearLayoutManager JvG;
  private final MediaBannerIndicator JvH;
  private int JvI;
  private RecyclerView JvJ;
  private final RecyclerHorizontalViewPager JvK;
  private final FrameLayout JvL;
  private RecyclerView.n JvM;
  private final f JvN;
  private RecyclerView.a<VH> fUp;
  private final int nhC;
  
  static
  {
    AppMethodBeat.i(164547);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(MediaBanner.class), "container", "getContainer()Landroid/widget/LinearLayout;")) };
    JvO = new MediaBanner.a((byte)0);
    AppMethodBeat.o(164547);
  }
  
  public MediaBanner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164553);
    this.nhC = ((int)getResources().getDimension(2131165303));
    this.JvD = ((int)getResources().getDimension(2131165292));
    this.JvE = MediaBanner.d.JvQ;
    paramContext = getContext();
    d.g.b.k.g(paramContext, "context");
    this.JvG = kx(paramContext);
    this.JvH = new MediaBannerIndicator(getContext());
    paramContext = getContext();
    d.g.b.k.g(paramContext, "context");
    this.JvK = ((RecyclerHorizontalViewPager)new g(this, paramContext));
    this.JvL = new FrameLayout(getContext());
    this.JvN = g.K((d.g.a.a)new f(this));
    this.JvK.setHasFixedSize(false);
    this.JvG.cb(3);
    this.JvG.aw(true);
    this.JvG.setOrientation(0);
    this.JvK.setLayoutManager((RecyclerView.i)this.JvG);
    this.JvL.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    paramContext = getContainer();
    if (paramContext != null) {
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    }
    if (this.JvE == MediaBanner.d.JvQ)
    {
      paramContext = getContainer();
      if (paramContext != null)
      {
        paramContext.setOrientation(1);
        paramContext.setGravity(49);
        this.JvL.addView((View)this.JvK, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
        paramContext.addView((View)this.JvL, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
        this.JvH.setGravity(17);
        paramContext.addView((View)this.JvH, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, this.JvD));
        paramContext.setGravity(17);
        addView((View)paramContext, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      }
    }
    for (;;)
    {
      this.JvK.setOnInterceptTouchEvent((RecyclerHorizontalViewPager.c)new RecyclerHorizontalViewPager.c()
      {
        private float rYu;
        
        public final boolean b(MotionEvent paramAnonymousMotionEvent, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(164538);
          d.g.b.k.h(paramAnonymousMotionEvent, "event");
          paramAnonymousBoolean = MediaBanner.c(paramAnonymousMotionEvent, paramAnonymousBoolean);
          AppMethodBeat.o(164538);
          return paramAnonymousBoolean;
        }
        
        public final void k(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(164537);
          d.g.b.k.h(paramAnonymousMotionEvent, "event");
          Object localObject = this.JvP.getParentRecyclerView();
          if (localObject != null)
          {
            localObject = ((RecyclerView)localObject).getLayoutManager();
            if (((localObject instanceof MediaBanner.b)) && (((RecyclerView.i)localObject).getItemCount() > 1))
            {
              if (paramAnonymousMotionEvent.getAction() != 0) {
                break label95;
              }
              this.rYu = paramAnonymousMotionEvent.getRawX();
            }
          }
          for (;;)
          {
            if ((paramAnonymousMotionEvent.getAction() == 1) || (paramAnonymousMotionEvent.getAction() == 3)) {
              ((MediaBanner.b)localObject).mc(true);
            }
            AppMethodBeat.o(164537);
            return;
            localObject = null;
            break;
            label95:
            if ((paramAnonymousMotionEvent.getAction() == 2) && (Math.abs(paramAnonymousMotionEvent.getRawX() - this.rYu) >= 15.0F)) {
              ((MediaBanner.b)localObject).mc(false);
            }
          }
        }
      });
      AppMethodBeat.o(164553);
      return;
      if (this.JvE == MediaBanner.d.JvR)
      {
        this.JvL.addView((View)this.JvK);
        addView((View)this.JvL, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        paramContext = new FrameLayout.LayoutParams(-1, this.JvD);
        paramContext.bottomMargin = this.nhC;
        paramContext.gravity = 81;
        this.JvH.setGravity(81);
        addView((View)this.JvH, (ViewGroup.LayoutParams)paramContext);
      }
    }
  }
  
  public MediaBanner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164554);
    this.nhC = ((int)getResources().getDimension(2131165303));
    this.JvD = ((int)getResources().getDimension(2131165292));
    this.JvE = MediaBanner.d.JvQ;
    paramContext = getContext();
    d.g.b.k.g(paramContext, "context");
    this.JvG = kx(paramContext);
    this.JvH = new MediaBannerIndicator(getContext());
    paramContext = getContext();
    d.g.b.k.g(paramContext, "context");
    this.JvK = ((RecyclerHorizontalViewPager)new g(this, paramContext));
    this.JvL = new FrameLayout(getContext());
    this.JvN = g.K((d.g.a.a)new f(this));
    this.JvK.setHasFixedSize(false);
    this.JvG.cb(3);
    this.JvG.aw(true);
    this.JvG.setOrientation(0);
    this.JvK.setLayoutManager((RecyclerView.i)this.JvG);
    this.JvL.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    paramContext = getContainer();
    if (paramContext != null) {
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    }
    if (this.JvE == MediaBanner.d.JvQ)
    {
      paramContext = getContainer();
      if (paramContext != null)
      {
        paramContext.setOrientation(1);
        paramContext.setGravity(49);
        this.JvL.addView((View)this.JvK, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
        paramContext.addView((View)this.JvL, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
        this.JvH.setGravity(17);
        paramContext.addView((View)this.JvH, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, this.JvD));
        paramContext.setGravity(17);
        addView((View)paramContext, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      }
    }
    for (;;)
    {
      this.JvK.setOnInterceptTouchEvent((RecyclerHorizontalViewPager.c)new RecyclerHorizontalViewPager.c()
      {
        private float rYu;
        
        public final boolean b(MotionEvent paramAnonymousMotionEvent, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(164538);
          d.g.b.k.h(paramAnonymousMotionEvent, "event");
          paramAnonymousBoolean = MediaBanner.c(paramAnonymousMotionEvent, paramAnonymousBoolean);
          AppMethodBeat.o(164538);
          return paramAnonymousBoolean;
        }
        
        public final void k(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(164537);
          d.g.b.k.h(paramAnonymousMotionEvent, "event");
          Object localObject = this.JvP.getParentRecyclerView();
          if (localObject != null)
          {
            localObject = ((RecyclerView)localObject).getLayoutManager();
            if (((localObject instanceof MediaBanner.b)) && (((RecyclerView.i)localObject).getItemCount() > 1))
            {
              if (paramAnonymousMotionEvent.getAction() != 0) {
                break label95;
              }
              this.rYu = paramAnonymousMotionEvent.getRawX();
            }
          }
          for (;;)
          {
            if ((paramAnonymousMotionEvent.getAction() == 1) || (paramAnonymousMotionEvent.getAction() == 3)) {
              ((MediaBanner.b)localObject).mc(true);
            }
            AppMethodBeat.o(164537);
            return;
            localObject = null;
            break;
            label95:
            if ((paramAnonymousMotionEvent.getAction() == 2) && (Math.abs(paramAnonymousMotionEvent.getRawX() - this.rYu) >= 15.0F)) {
              ((MediaBanner.b)localObject).mc(false);
            }
          }
        }
      });
      AppMethodBeat.o(164554);
      return;
      if (this.JvE == MediaBanner.d.JvR)
      {
        this.JvL.addView((View)this.JvK);
        addView((View)this.JvL, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        paramContext = new FrameLayout.LayoutParams(-1, this.JvD);
        paramContext.bottomMargin = this.nhC;
        paramContext.gravity = 81;
        this.JvH.setGravity(81);
        addView((View)this.JvH, (ViewGroup.LayoutParams)paramContext);
      }
    }
  }
  
  public static boolean c(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    AppMethodBeat.i(164551);
    d.g.b.k.h(paramMotionEvent, "event");
    AppMethodBeat.o(164551);
    return paramBoolean;
  }
  
  private static LinearLayoutManager kx(Context paramContext)
  {
    AppMethodBeat.i(197317);
    d.g.b.k.h(paramContext, "context");
    paramContext = new LinearLayoutManager();
    AppMethodBeat.o(197317);
    return paramContext;
  }
  
  public final RecyclerView.a<VH> getAdapter()
  {
    return this.fUp;
  }
  
  public final LinearLayout getContainer()
  {
    AppMethodBeat.i(164550);
    LinearLayout localLinearLayout = (LinearLayout)this.JvN.getValue();
    AppMethodBeat.o(164550);
    return localLinearLayout;
  }
  
  public final int getFocusPosition()
  {
    return this.JvI;
  }
  
  public final MediaBannerIndicator getIndicator()
  {
    return this.JvH;
  }
  
  public final int getIndicatorHeight()
  {
    return this.JvD;
  }
  
  public final LinearLayoutManager getManager()
  {
    return this.JvG;
  }
  
  public final c getPageChangeCallback()
  {
    return this.JvF;
  }
  
  public final RecyclerHorizontalViewPager getPagerView()
  {
    return this.JvK;
  }
  
  public final FrameLayout getPagerViewContainer()
  {
    return this.JvL;
  }
  
  public final RecyclerView getParentRecyclerView()
  {
    return this.JvJ;
  }
  
  public final MediaBanner.d getStyle()
  {
    return this.JvE;
  }
  
  public final RecyclerView.n getViewPool()
  {
    return this.JvM;
  }
  
  public final void setAdapter(RecyclerView.a<VH> parama)
  {
    AppMethodBeat.i(164552);
    this.fUp = parama;
    this.JvK.setAdapter(this.fUp);
    parama = this.fUp;
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
    this.JvI = paramInt;
  }
  
  public final void setPageChangeCallback(c paramc)
  {
    this.JvF = paramc;
  }
  
  public final void setParentRecyclerView(RecyclerView paramRecyclerView)
  {
    this.JvJ = paramRecyclerView;
  }
  
  public final void setStyle(MediaBanner.d paramd)
  {
    AppMethodBeat.i(164548);
    d.g.b.k.h(paramd, "<set-?>");
    this.JvE = paramd;
    AppMethodBeat.o(164548);
  }
  
  public final void setViewPool(RecyclerView.n paramn)
  {
    AppMethodBeat.i(164549);
    this.JvM = paramn;
    this.JvK.setRecycledViewPool(paramn);
    AppMethodBeat.o(164549);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "", "onPageChange", "", "position", "", "isIdle", "", "libmmui_release"})
  public static abstract interface c
  {
    public abstract void ad(int paramInt, boolean paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/view/MediaBanner$adapter$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeInserted", "positionStart", "", "itemCount", "onItemRangeRemoved", "libmmui_release"})
  public static final class e
    extends RecyclerView.c
  {
    public final void at(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(164543);
      super.at(paramInt1, paramInt2);
      RecyclerView.a locala = this.JvP.getAdapter();
      if (locala != null)
      {
        this.JvP.getIndicator().setCount(locala.getItemCount());
        AppMethodBeat.o(164543);
        return;
      }
      AppMethodBeat.o(164543);
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(164544);
      super.au(paramInt1, paramInt2);
      RecyclerView.a locala = this.JvP.getAdapter();
      if (locala != null)
      {
        this.JvP.getIndicator().setCount(locala.getItemCount());
        AppMethodBeat.o(164544);
        return;
      }
      AppMethodBeat.o(164544);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(164542);
      super.onChanged();
      Object localObject = this.JvP.getAdapter();
      if (localObject != null)
      {
        this.JvP.getIndicator().setCount(((RecyclerView.a)localObject).getItemCount());
        if (this.JvP.getIndicator().getCount() > 0)
        {
          localObject = this.JvP.getPagerView();
          com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.aeD(), "com/tencent/mm/view/MediaBanner$adapter$1", "onChanged", "()V", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerHorizontalViewPager)localObject).ca(((Integer)locala.lR(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/view/MediaBanner$adapter$1", "onChanged", "()V", "Undefined", "scrollToPosition", "(I)V");
        }
        AppMethodBeat.o(164542);
        return;
      }
      AppMethodBeat.o(164542);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/widget/LinearLayout;", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<LinearLayout>
  {
    f(MediaBanner paramMediaBanner)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/view/MediaBanner$pagerView$1", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "onPageChange", "", "position", "", "isIdle", "", "libmmui_release"})
  public static final class g
    extends RecyclerHorizontalViewPager
  {
    g(Context paramContext)
    {
      super();
    }
    
    public final void ad(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(164546);
      super.ad(paramInt, paramBoolean);
      this.JvP.setFocusPosition(paramInt);
      this.JvP.getIndicator().setCurrentIndex(paramInt);
      MediaBanner.c localc = this.JvP.getPageChangeCallback();
      if (localc != null)
      {
        localc.ad(paramInt, paramBoolean);
        AppMethodBeat.o(164546);
        return;
      }
      AppMethodBeat.o(164546);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.MediaBanner
 * JD-Core Version:    0.7.0.1
 */