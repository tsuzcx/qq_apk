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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/view/MediaBanner;", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Landroid/support/v7/widget/RecyclerView$Adapter;", "adapter", "getAdapter", "()Landroid/support/v7/widget/RecyclerView$Adapter;", "setAdapter", "(Landroid/support/v7/widget/RecyclerView$Adapter;)V", "container", "Landroid/widget/LinearLayout;", "getContainer", "()Landroid/widget/LinearLayout;", "container$delegate", "Lkotlin/Lazy;", "focusPosition", "getFocusPosition", "()I", "setFocusPosition", "(I)V", "indicator", "Lcom/tencent/mm/view/MediaBannerIndicator;", "getIndicator", "()Lcom/tencent/mm/view/MediaBannerIndicator;", "indicatorBottomMargin", "indicatorHeight", "getIndicatorHeight", "manager", "Landroid/support/v7/widget/LinearLayoutManager;", "getManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "pageChangeCallback", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "getPageChangeCallback", "()Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "setPageChangeCallback", "(Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;)V", "pagerView", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "getPagerView", "()Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "pagerViewContainer", "getPagerViewContainer", "()Landroid/widget/FrameLayout;", "parentRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getParentRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setParentRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "style", "Lcom/tencent/mm/view/MediaBanner$Style;", "getStyle", "()Lcom/tencent/mm/view/MediaBanner$Style;", "setStyle", "(Lcom/tencent/mm/view/MediaBanner$Style;)V", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "viewPool", "getViewPool", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "setViewPool", "(Landroid/support/v7/widget/RecyclerView$RecycledViewPool;)V", "getChildViewAt", "Landroid/view/View;", "position", "getLinearLayoutManager", "isInterceptTouch", "", "direction", "event", "Landroid/view/MotionEvent;", "isSuperIntercept", "selectViewAt", "", "Companion", "ILayoutManagerScrollEnableCallback", "IPageChangeCallback", "Style", "libmmui_release"})
public class MediaBanner<VH extends RecyclerView.w>
  extends FrameLayout
{
  public static final a LoQ;
  private final int LoF;
  private d LoG;
  private c LoH;
  private final LinearLayoutManager LoI;
  private final MediaBannerIndicator LoJ;
  private int LoK;
  private RecyclerView LoL;
  private final RecyclerHorizontalViewPager LoM;
  private final FrameLayout LoN;
  private RecyclerView.n LoO;
  private final f LoP;
  private RecyclerView.a<VH> gnR;
  private final int nHY;
  
  static
  {
    AppMethodBeat.i(164547);
    LoQ = new a((byte)0);
    AppMethodBeat.o(164547);
  }
  
  public MediaBanner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164553);
    this.nHY = ((int)getResources().getDimension(2131165303));
    this.LoF = ((int)getResources().getDimension(2131165292));
    this.LoG = d.LoS;
    paramContext = getContext();
    p.g(paramContext, "context");
    this.LoI = kJ(paramContext);
    this.LoJ = new MediaBannerIndicator(getContext());
    paramContext = getContext();
    p.g(paramContext, "context");
    this.LoM = ((RecyclerHorizontalViewPager)new g(this, paramContext));
    this.LoN = new FrameLayout(getContext());
    this.LoP = g.O((d.g.a.a)new f(this));
    this.LoM.setHasFixedSize(false);
    this.LoI.cb(3);
    this.LoI.aw(true);
    this.LoI.setOrientation(0);
    this.LoM.setLayoutManager((RecyclerView.i)this.LoI);
    this.LoN.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    paramContext = getContainer();
    if (paramContext != null) {
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    }
    if (this.LoG == d.LoS)
    {
      paramContext = getContainer();
      if (paramContext != null)
      {
        paramContext.setOrientation(1);
        paramContext.setGravity(49);
        this.LoN.addView((View)this.LoM, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
        paramContext.addView((View)this.LoN, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
        this.LoJ.setGravity(17);
        paramContext.addView((View)this.LoJ, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, this.LoF));
        paramContext.setGravity(17);
        addView((View)paramContext, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      }
    }
    for (;;)
    {
      this.LoM.setOnInterceptTouchEvent((RecyclerHorizontalViewPager.c)new RecyclerHorizontalViewPager.c()
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
          Object localObject = this.LoR.getParentRecyclerView();
          RecyclerView.i locali;
          int i;
          if (localObject != null)
          {
            localObject = ((RecyclerView)localObject).getLayoutManager();
            if (!(localObject instanceof MediaBanner.b)) {
              break label261;
            }
            locali = this.LoR.getPagerView().getLayoutManager();
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
                  ((MediaBanner.b)localObject).mu(true);
                }
                AppMethodBeat.o(164537);
                return;
                if (paramAnonymousMotionEvent.getAction() == 2)
                {
                  float f = paramAnonymousMotionEvent.getRawX() - this.aTL;
                  if ((Math.abs(f) >= 15.0F) && (((f > 0.0F) && (((LinearLayoutManager)locali).kp() > 0)) || ((f < 0.0F) && (((LinearLayoutManager)locali).kn() < ((LinearLayoutManager)locali).getItemCount() - 1)))) {
                    ((MediaBanner.b)localObject).mu(false);
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
      if (this.LoG == d.LoT)
      {
        this.LoN.addView((View)this.LoM);
        addView((View)this.LoN, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        paramContext = new FrameLayout.LayoutParams(-1, this.LoF);
        paramContext.bottomMargin = this.nHY;
        paramContext.gravity = 81;
        this.LoJ.setGravity(81);
        addView((View)this.LoJ, (ViewGroup.LayoutParams)paramContext);
      }
    }
  }
  
  public MediaBanner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164554);
    this.nHY = ((int)getResources().getDimension(2131165303));
    this.LoF = ((int)getResources().getDimension(2131165292));
    this.LoG = d.LoS;
    paramContext = getContext();
    p.g(paramContext, "context");
    this.LoI = kJ(paramContext);
    this.LoJ = new MediaBannerIndicator(getContext());
    paramContext = getContext();
    p.g(paramContext, "context");
    this.LoM = ((RecyclerHorizontalViewPager)new g(this, paramContext));
    this.LoN = new FrameLayout(getContext());
    this.LoP = g.O((d.g.a.a)new f(this));
    this.LoM.setHasFixedSize(false);
    this.LoI.cb(3);
    this.LoI.aw(true);
    this.LoI.setOrientation(0);
    this.LoM.setLayoutManager((RecyclerView.i)this.LoI);
    this.LoN.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    paramContext = getContainer();
    if (paramContext != null) {
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    }
    if (this.LoG == d.LoS)
    {
      paramContext = getContainer();
      if (paramContext != null)
      {
        paramContext.setOrientation(1);
        paramContext.setGravity(49);
        this.LoN.addView((View)this.LoM, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
        paramContext.addView((View)this.LoN, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
        this.LoJ.setGravity(17);
        paramContext.addView((View)this.LoJ, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, this.LoF));
        paramContext.setGravity(17);
        addView((View)paramContext, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      }
    }
    for (;;)
    {
      this.LoM.setOnInterceptTouchEvent((RecyclerHorizontalViewPager.c)new RecyclerHorizontalViewPager.c()
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
          Object localObject = this.LoR.getParentRecyclerView();
          RecyclerView.i locali;
          int i;
          if (localObject != null)
          {
            localObject = ((RecyclerView)localObject).getLayoutManager();
            if (!(localObject instanceof MediaBanner.b)) {
              break label261;
            }
            locali = this.LoR.getPagerView().getLayoutManager();
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
                  ((MediaBanner.b)localObject).mu(true);
                }
                AppMethodBeat.o(164537);
                return;
                if (paramAnonymousMotionEvent.getAction() == 2)
                {
                  float f = paramAnonymousMotionEvent.getRawX() - this.aTL;
                  if ((Math.abs(f) >= 15.0F) && (((f > 0.0F) && (((LinearLayoutManager)locali).kp() > 0)) || ((f < 0.0F) && (((LinearLayoutManager)locali).kn() < ((LinearLayoutManager)locali).getItemCount() - 1)))) {
                    ((MediaBanner.b)localObject).mu(false);
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
      if (this.LoG == d.LoT)
      {
        this.LoN.addView((View)this.LoM);
        addView((View)this.LoN, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        paramContext = new FrameLayout.LayoutParams(-1, this.LoF);
        paramContext.bottomMargin = this.nHY;
        paramContext.gravity = 81;
        this.LoJ.setGravity(81);
        addView((View)this.LoJ, (ViewGroup.LayoutParams)paramContext);
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
  
  private static LinearLayoutManager kJ(Context paramContext)
  {
    AppMethodBeat.i(186647);
    p.h(paramContext, "context");
    paramContext = new LinearLayoutManager();
    AppMethodBeat.o(186647);
    return paramContext;
  }
  
  public final RecyclerView.a<VH> getAdapter()
  {
    return this.gnR;
  }
  
  public final LinearLayout getContainer()
  {
    AppMethodBeat.i(164550);
    LinearLayout localLinearLayout = (LinearLayout)this.LoP.getValue();
    AppMethodBeat.o(164550);
    return localLinearLayout;
  }
  
  public final int getFocusPosition()
  {
    return this.LoK;
  }
  
  public final MediaBannerIndicator getIndicator()
  {
    return this.LoJ;
  }
  
  public final int getIndicatorHeight()
  {
    return this.LoF;
  }
  
  public final LinearLayoutManager getManager()
  {
    return this.LoI;
  }
  
  public final c getPageChangeCallback()
  {
    return this.LoH;
  }
  
  public final RecyclerHorizontalViewPager getPagerView()
  {
    return this.LoM;
  }
  
  public final FrameLayout getPagerViewContainer()
  {
    return this.LoN;
  }
  
  public final RecyclerView getParentRecyclerView()
  {
    return this.LoL;
  }
  
  public final d getStyle()
  {
    return this.LoG;
  }
  
  public final RecyclerView.n getViewPool()
  {
    return this.LoO;
  }
  
  public final void setAdapter(RecyclerView.a<VH> parama)
  {
    AppMethodBeat.i(164552);
    this.gnR = parama;
    this.LoM.setAdapter(this.gnR);
    parama = this.gnR;
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
    this.LoK = paramInt;
  }
  
  public final void setPageChangeCallback(c paramc)
  {
    this.LoH = paramc;
  }
  
  public final void setParentRecyclerView(RecyclerView paramRecyclerView)
  {
    this.LoL = paramRecyclerView;
  }
  
  public final void setStyle(d paramd)
  {
    AppMethodBeat.i(164548);
    p.h(paramd, "<set-?>");
    this.LoG = paramd;
    AppMethodBeat.o(164548);
  }
  
  public final void setViewPool(RecyclerView.n paramn)
  {
    AppMethodBeat.i(164549);
    this.LoO = paramn;
    this.LoM.setRecycledViewPool(paramn);
    AppMethodBeat.o(164549);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/view/MediaBanner$Companion;", "", "()V", "TAG", "", "libmmui_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/view/MediaBanner$ILayoutManagerScrollEnableCallback;", "", "setScrollVerticallyEnable", "", "enable", "", "libmmui_release"})
  public static abstract interface b
  {
    public abstract void mu(boolean paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "", "onPageChange", "", "position", "", "isIdle", "", "libmmui_release"})
  public static abstract interface c
  {
    public abstract void ad(int paramInt, boolean paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/view/MediaBanner$Style;", "", "(Ljava/lang/String;I)V", "BOTTOM", "INSIDE", "libmmui_release"})
  public static enum d
  {
    static
    {
      AppMethodBeat.i(164539);
      d locald1 = new d("BOTTOM", 0);
      LoS = locald1;
      d locald2 = new d("INSIDE", 1);
      LoT = locald2;
      LoU = new d[] { locald1, locald2 };
      AppMethodBeat.o(164539);
    }
    
    private d() {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/view/MediaBanner$adapter$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeInserted", "positionStart", "", "itemCount", "onItemRangeRemoved", "libmmui_release"})
  public static final class e
    extends RecyclerView.c
  {
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(164543);
      super.au(paramInt1, paramInt2);
      RecyclerView.a locala = this.LoR.getAdapter();
      if (locala != null)
      {
        this.LoR.getIndicator().setCount(locala.getItemCount());
        AppMethodBeat.o(164543);
        return;
      }
      AppMethodBeat.o(164543);
    }
    
    public final void av(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(164544);
      super.av(paramInt1, paramInt2);
      RecyclerView.a locala = this.LoR.getAdapter();
      if (locala != null)
      {
        this.LoR.getIndicator().setCount(locala.getItemCount());
        AppMethodBeat.o(164544);
        return;
      }
      AppMethodBeat.o(164544);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(164542);
      super.onChanged();
      Object localObject = this.LoR.getAdapter();
      if (localObject != null)
      {
        this.LoR.getIndicator().setCount(((RecyclerView.a)localObject).getItemCount());
        if (this.LoR.getIndicator().getCount() > 0)
        {
          localObject = this.LoR.getPagerView();
          com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/view/MediaBanner$adapter$1", "onChanged", "()V", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerHorizontalViewPager)localObject).ca(((Integer)locala.mq(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/view/MediaBanner$adapter$1", "onChanged", "()V", "Undefined", "scrollToPosition", "(I)V");
        }
        AppMethodBeat.o(164542);
        return;
      }
      AppMethodBeat.o(164542);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/LinearLayout;", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<LinearLayout>
  {
    f(MediaBanner paramMediaBanner)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/view/MediaBanner$pagerView$1", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "onPageChange", "", "position", "", "isIdle", "", "libmmui_release"})
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
      this.LoR.setFocusPosition(paramInt);
      this.LoR.getIndicator().setCurrentIndex(paramInt);
      MediaBanner.c localc = this.LoR.getPageChangeCallback();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.MediaBanner
 * JD-Core Version:    0.7.0.1
 */