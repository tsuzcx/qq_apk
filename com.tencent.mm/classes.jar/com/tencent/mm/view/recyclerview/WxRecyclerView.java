package com.tencent.mm.view.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.i;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.f;
import d.g;
import d.g.b.u;
import d.g.b.w;
import d.l;
import d.l.k;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "Landroid/support/v7/widget/RecyclerView;", "Lcom/tencent/mm/view/recyclerview/ISupportStrongConfig;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "flingSpeedFactor", "getFlingSpeedFactor", "()I", "setFlingSpeedFactor", "(I)V", "logObserver", "com/tencent/mm/view/recyclerview/WxRecyclerView$logObserver$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView$logObserver$1;", "fling", "", "velocityX", "velocityY", "isSupportAvoidCrashWithNotifyWhenScrollOrLayout", "isSupportNotifyItemViewChangeWithoutAnyAttachAndDetachAction", "onAttachedToWindow", "", "onLayout", "changed", "l", "t", "r", "b", "onViewAdded", "child", "Landroid/view/View;", "onViewRemoved", "openRecyclerViewDebug", "requestLayout", "scrollBy", "x", "y", "scrollTo", "scrollToPosition", "position", "setAdapter", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "setLayoutFrozen", "frozen", "smoothScrollBy", "dx", "dy", "interpolator", "Landroid/view/animation/Interpolator;", "smoothScrollToPosition", "stopScroll", "Companion", "libmmui_release"})
public class WxRecyclerView
  extends RecyclerView
{
  private static final f IbD;
  private static final f IbE;
  public static final a IbF;
  private final d IbC;
  private int LEr;
  
  static
  {
    AppMethodBeat.i(164764);
    IbF = new a((byte)0);
    IbD = g.E((d.g.a.a)WxRecyclerView.c.IbH);
    IbE = g.E((d.g.a.a)WxRecyclerView.b.IbG);
    AppMethodBeat.o(164764);
  }
  
  public WxRecyclerView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(204014);
    this.LEr = 100;
    this.IbC = new d();
    AppMethodBeat.o(204014);
  }
  
  public WxRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164762);
    this.LEr = 100;
    this.IbC = new d();
    AppMethodBeat.o(164762);
  }
  
  public WxRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164763);
    this.LEr = 100;
    this.IbC = new d();
    AppMethodBeat.o(164763);
  }
  
  public final void a(int paramInt1, int paramInt2, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(164758);
    super.a(paramInt1, paramInt2, paramInterpolator);
    StringBuilder localStringBuilder;
    if (a.fji())
    {
      localStringBuilder = new StringBuilder("[smoothScrollBy] dx=").append(paramInt1).append(" dy=").append(paramInt2).append(" interpolator=").append(paramInterpolator).append(' ');
      if (!a.fjj()) {
        break label86;
      }
    }
    label86:
    for (paramInterpolator = bt.eGN();; paramInterpolator = "")
    {
      ad.d("MicroMsg.WxRecyclerView", paramInterpolator);
      AppMethodBeat.o(164758);
      return;
    }
  }
  
  public final boolean ai(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204013);
    RecyclerView.i locali = getLayoutManager();
    if ((locali != null) && (locali.jE() == true))
    {
      bool = super.ai(d.h.a.bU(this.LEr * paramInt1 / 100.0F), paramInt2);
      AppMethodBeat.o(204013);
      return bool;
    }
    locali = getLayoutManager();
    if ((locali != null) && (locali.jF() == true))
    {
      bool = super.ai(paramInt1, d.h.a.bU(this.LEr * paramInt2 / 100.0F));
      AppMethodBeat.o(204013);
      return bool;
    }
    boolean bool = super.ai(paramInt1, paramInt2);
    AppMethodBeat.o(204013);
    return bool;
  }
  
  public final void ca(int paramInt)
  {
    AppMethodBeat.i(164755);
    super.ca(paramInt);
    if (a.fji()) {
      ad.d("MicroMsg.WxRecyclerView", "[scrollToPosition] position=".concat(String.valueOf(paramInt)));
    }
    AppMethodBeat.o(164755);
  }
  
  public final int getFlingSpeedFactor()
  {
    return this.LEr;
  }
  
  public final void kl()
  {
    AppMethodBeat.i(164756);
    super.kl();
    StringBuilder localStringBuilder;
    if (a.fji())
    {
      localStringBuilder = new StringBuilder("[stopScroll] ");
      if (!a.fjj()) {
        break label54;
      }
    }
    label54:
    for (Object localObject = bt.eGN();; localObject = "")
    {
      ad.d("MicroMsg.WxRecyclerView", localObject);
      AppMethodBeat.o(164756);
      return;
    }
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(164749);
    super.onAttachedToWindow();
    AppMethodBeat.o(164749);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(164751);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    StringBuilder localStringBuilder;
    if (a.fji())
    {
      localStringBuilder = new StringBuilder("[onLayout] changed=").append(paramBoolean).append(" [").append(paramInt1).append(':').append(paramInt2).append(':').append(paramInt3).append(':').append(paramInt4).append("] ");
      if (!a.fjj()) {
        break label115;
      }
    }
    label115:
    for (Object localObject = bt.eGN();; localObject = "")
    {
      ad.d("MicroMsg.WxRecyclerView", localObject);
      AppMethodBeat.o(164751);
      return;
    }
  }
  
  public void onViewAdded(View paramView)
  {
    AppMethodBeat.i(164760);
    super.onViewAdded(paramView);
    StringBuilder localStringBuilder;
    if (a.fji())
    {
      localStringBuilder = new StringBuilder("[onViewAdded] child=").append(paramView).append(' ');
      if (!a.fjj()) {
        break label67;
      }
    }
    label67:
    for (paramView = bt.eGN();; paramView = "")
    {
      ad.d("MicroMsg.WxRecyclerView", paramView);
      AppMethodBeat.o(164760);
      return;
    }
  }
  
  public void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(164761);
    super.onViewRemoved(paramView);
    StringBuilder localStringBuilder;
    if (a.fji())
    {
      localStringBuilder = new StringBuilder("[onViewRemoved] child=").append(paramView).append(' ');
      if (!a.fjj()) {
        break label67;
      }
    }
    label67:
    for (paramView = bt.eGN();; paramView = "")
    {
      ad.d("MicroMsg.WxRecyclerView", paramView);
      AppMethodBeat.o(164761);
      return;
    }
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(164752);
    super.requestLayout();
    StringBuilder localStringBuilder;
    if (a.fji())
    {
      localStringBuilder = new StringBuilder("[requestLayout] ");
      if (!a.fjj()) {
        break label57;
      }
    }
    label57:
    for (Object localObject = bt.eGN();; localObject = "")
    {
      ad.d("MicroMsg.WxRecyclerView", localObject);
      AppMethodBeat.o(164752);
      return;
    }
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164753);
    super.scrollBy(paramInt1, paramInt2);
    if (a.fji()) {
      ad.d("MicroMsg.WxRecyclerView", "[scrollBy] x=" + paramInt1 + " y=" + paramInt1);
    }
    AppMethodBeat.o(164753);
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164754);
    super.scrollTo(paramInt1, paramInt2);
    if (a.fji()) {
      ad.d("MicroMsg.WxRecyclerView", "[scrollTo] x=" + paramInt1 + " y=" + paramInt1);
    }
    AppMethodBeat.o(164754);
  }
  
  public void setAdapter(RecyclerView.a<?> parama)
  {
    AppMethodBeat.i(164750);
    super.setAdapter(parama);
    if ((parama instanceof d)) {
      ((d)parama).Ibh = true;
    }
    if (parama != null)
    {
      parama.a((RecyclerView.c)this.IbC);
      AppMethodBeat.o(164750);
      return;
    }
    AppMethodBeat.o(164750);
  }
  
  public final void setFlingSpeedFactor(int paramInt)
  {
    this.LEr = paramInt;
  }
  
  public void setLayoutFrozen(boolean paramBoolean)
  {
    AppMethodBeat.i(164759);
    super.setLayoutFrozen(paramBoolean);
    StringBuilder localStringBuilder;
    if (a.fji())
    {
      localStringBuilder = new StringBuilder("[setLayoutFrozen] frozen=").append(paramBoolean).append(' ');
      if (!a.fjj()) {
        break label67;
      }
    }
    label67:
    for (Object localObject = bt.eGN();; localObject = "")
    {
      ad.d("MicroMsg.WxRecyclerView", localObject);
      AppMethodBeat.o(164759);
      return;
    }
  }
  
  public final void smoothScrollToPosition(int paramInt)
  {
    AppMethodBeat.i(164757);
    super.smoothScrollToPosition(paramInt);
    StringBuilder localStringBuilder;
    if (a.fji())
    {
      localStringBuilder = new StringBuilder("[smoothScrollToPosition] position=").append(paramInt).append(' ');
      if (!a.fjj()) {
        break label67;
      }
    }
    label67:
    for (Object localObject = bt.eGN();; localObject = "")
    {
      ad.d("MicroMsg.WxRecyclerView", localObject);
      AppMethodBeat.o(164757);
      return;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/view/recyclerview/WxRecyclerView$Companion;", "", "()V", "TAG", "", "isEnableDumpStack", "", "()Z", "isEnableDumpStack$delegate", "Lkotlin/Lazy;", "isOpenRecyclerViewDebug", "isOpenRecyclerViewDebug$delegate", "isOpenRecyclerViewSystemDebug", "libmmui_release"})
  public static final class a
  {
    static
    {
      AppMethodBeat.i(164740);
      $$delegatedProperties = new k[] { (k)w.a(new u(w.bk(a.class), "isOpenRecyclerViewDebug", "isOpenRecyclerViewDebug()Z")), (k)w.a(new u(w.bk(a.class), "isEnableDumpStack", "isEnableDumpStack()Z")) };
      AppMethodBeat.o(164740);
    }
    
    public static boolean fji()
    {
      AppMethodBeat.i(164741);
      f localf = WxRecyclerView.fjg();
      a locala = WxRecyclerView.IbF;
      boolean bool = ((Boolean)localf.getValue()).booleanValue();
      AppMethodBeat.o(164741);
      return bool;
    }
    
    public static boolean fjj()
    {
      AppMethodBeat.i(164742);
      f localf = WxRecyclerView.fjh();
      a locala = WxRecyclerView.IbF;
      boolean bool = ((Boolean)localf.getValue()).booleanValue();
      AppMethodBeat.o(164742);
      return bool;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/view/recyclerview/WxRecyclerView$logObserver$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "libmmui_release"})
  public static final class d
    extends RecyclerView.c
  {
    public final void as(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(164744);
      super.as(paramInt1, paramInt2);
      Object localObject = WxRecyclerView.IbF;
      StringBuilder localStringBuilder;
      if (WxRecyclerView.a.fji())
      {
        localStringBuilder = new StringBuilder("[notify onItemRangeChanged] positionStart=").append(paramInt1).append(" itemCount=").append(paramInt2).append(' ');
        localObject = WxRecyclerView.IbF;
        if (!WxRecyclerView.a.fjj()) {
          break label84;
        }
      }
      label84:
      for (localObject = bt.eGN();; localObject = "")
      {
        ad.d("MicroMsg.WxRecyclerView", localObject);
        AppMethodBeat.o(164744);
        return;
      }
    }
    
    public final void at(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(164746);
      super.at(paramInt1, paramInt2);
      Object localObject = WxRecyclerView.IbF;
      StringBuilder localStringBuilder;
      if (WxRecyclerView.a.fji())
      {
        localStringBuilder = new StringBuilder("[notify onItemRangeInserted] positionStart=").append(paramInt1).append(" itemCount=").append(paramInt2).append(' ');
        localObject = WxRecyclerView.IbF;
        if (!WxRecyclerView.a.fjj()) {
          break label84;
        }
      }
      label84:
      for (localObject = bt.eGN();; localObject = "")
      {
        ad.d("MicroMsg.WxRecyclerView", localObject);
        AppMethodBeat.o(164746);
        return;
      }
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(164748);
      super.au(paramInt1, paramInt2);
      Object localObject = WxRecyclerView.IbF;
      StringBuilder localStringBuilder;
      if (WxRecyclerView.a.fji())
      {
        localStringBuilder = new StringBuilder("[notify onItemRangeRemoved] positionStart=").append(paramInt1).append(" itemCount=").append(paramInt2).append(' ');
        localObject = WxRecyclerView.IbF;
        if (!WxRecyclerView.a.fjj()) {
          break label84;
        }
      }
      label84:
      for (localObject = bt.eGN();; localObject = "")
      {
        ad.d("MicroMsg.WxRecyclerView", localObject);
        AppMethodBeat.o(164748);
        return;
      }
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(164745);
      super.f(paramInt1, paramInt2, paramObject);
      Object localObject = WxRecyclerView.IbF;
      if (WxRecyclerView.a.fji())
      {
        localObject = new StringBuilder("[notify onItemRangeChanged] positionStart=").append(paramInt1).append(" itemCount=").append(paramInt2).append(" payload=").append(paramObject).append(' ');
        paramObject = WxRecyclerView.IbF;
        if (!WxRecyclerView.a.fjj()) {
          break label95;
        }
      }
      label95:
      for (paramObject = bt.eGN();; paramObject = "")
      {
        ad.d("MicroMsg.WxRecyclerView", paramObject);
        AppMethodBeat.o(164745);
        return;
      }
    }
    
    public final void l(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(164747);
      super.l(paramInt1, paramInt2, paramInt3);
      Object localObject = WxRecyclerView.IbF;
      StringBuilder localStringBuilder;
      if (WxRecyclerView.a.fji())
      {
        localStringBuilder = new StringBuilder("[notify onItemRangeMoved] fromPosition=").append(paramInt1).append(" toPosition=").append(paramInt2).append(" itemCount=").append(paramInt3).append(' ');
        localObject = WxRecyclerView.IbF;
        if (!WxRecyclerView.a.fjj()) {
          break label98;
        }
      }
      label98:
      for (localObject = bt.eGN();; localObject = "")
      {
        ad.d("MicroMsg.WxRecyclerView", localObject);
        AppMethodBeat.o(164747);
        return;
      }
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(164743);
      super.onChanged();
      Object localObject = WxRecyclerView.IbF;
      StringBuilder localStringBuilder;
      if (WxRecyclerView.a.fji())
      {
        localStringBuilder = new StringBuilder("[notify onChanged] ");
        localObject = WxRecyclerView.IbF;
        if (!WxRecyclerView.a.fjj()) {
          break label62;
        }
      }
      label62:
      for (localObject = bt.eGN();; localObject = "")
      {
        ad.d("MicroMsg.WxRecyclerView", localObject);
        AppMethodBeat.o(164743);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.WxRecyclerView
 * JD-Core Version:    0.7.0.1
 */