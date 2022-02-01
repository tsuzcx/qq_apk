package com.tencent.mm.view.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "Landroid/support/v7/widget/RecyclerView;", "Lcom/tencent/mm/view/recyclerview/ISupportStrongConfig;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "flingSpeedFactor", "getFlingSpeedFactor", "()I", "setFlingSpeedFactor", "(I)V", "logObserver", "com/tencent/mm/view/recyclerview/WxRecyclerView$logObserver$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView$logObserver$1;", "canScrollHorizontally", "", "direction", "canScrollVertically", "fling", "velocityX", "velocityY", "isSupportAvoidCrashWithNotifyWhenScrollOrLayout", "isSupportNotifyItemViewChangeWithoutAnyAttachAndDetachAction", "onAttachedToWindow", "", "onLayout", "changed", "l", "t", "r", "b", "onViewAdded", "child", "Landroid/view/View;", "onViewRemoved", "openRecyclerViewDebug", "requestLayout", "scrollBy", "x", "y", "scrollTo", "scrollToPosition", "position", "setAdapter", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "setLayoutFrozen", "frozen", "smoothScrollBy", "dx", "dy", "interpolator", "Landroid/view/animation/Interpolator;", "smoothScrollToPosition", "stopScroll", "Companion", "libmmui_release"})
public class WxRecyclerView
  extends RecyclerView
{
  private static final f RrQ;
  private static final f RrR;
  public static final a RrS;
  private int RrO;
  private final d RrP;
  
  static
  {
    AppMethodBeat.i(164764);
    RrS = new a((byte)0);
    RrQ = kotlin.g.ah((kotlin.g.a.a)WxRecyclerView.c.RrU);
    RrR = kotlin.g.ah((kotlin.g.a.a)WxRecyclerView.b.RrT);
    AppMethodBeat.o(164764);
  }
  
  public WxRecyclerView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(205084);
    this.RrO = 100;
    this.RrP = new d();
    AppMethodBeat.o(205084);
  }
  
  public WxRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164762);
    this.RrO = 100;
    this.RrP = new d();
    AppMethodBeat.o(164762);
  }
  
  public WxRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164763);
    this.RrO = 100;
    this.RrP = new d();
    AppMethodBeat.o(164763);
  }
  
  public final void a(int paramInt1, int paramInt2, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(164758);
    super.a(paramInt1, paramInt2, paramInterpolator);
    StringBuilder localStringBuilder;
    if (a.hgA())
    {
      localStringBuilder = new StringBuilder("[smoothScrollBy] dx=").append(paramInt1).append(" dy=").append(paramInt2).append(" interpolator=").append(paramInterpolator).append(' ');
      if (!a.hgB()) {
        break label86;
      }
    }
    label86:
    for (paramInterpolator = Util.getStack();; paramInterpolator = "")
    {
      Log.d("MicroMsg.WxRecyclerView", paramInterpolator);
      AppMethodBeat.o(164758);
      return;
    }
  }
  
  public final boolean ak(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205081);
    RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
    if ((localLayoutManager != null) && (localLayoutManager.canScrollHorizontally() == true))
    {
      bool = super.ak(kotlin.h.a.cR(this.RrO * paramInt1 / 100.0F), paramInt2);
      AppMethodBeat.o(205081);
      return bool;
    }
    localLayoutManager = getLayoutManager();
    if ((localLayoutManager != null) && (localLayoutManager.canScrollVertically() == true))
    {
      bool = super.ak(paramInt1, kotlin.h.a.cR(this.RrO * paramInt2 / 100.0F));
      AppMethodBeat.o(205081);
      return bool;
    }
    boolean bool = super.ak(paramInt1, paramInt2);
    AppMethodBeat.o(205081);
    return bool;
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    AppMethodBeat.i(205082);
    boolean bool = super.canScrollHorizontally(paramInt);
    if (a.hgA()) {
      Log.i("MicroMsg.WxRecyclerView", "[canScrollHorizontally] direction=" + paramInt + " result=" + bool);
    }
    AppMethodBeat.o(205082);
    return bool;
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    AppMethodBeat.i(205083);
    boolean bool = super.canScrollVertically(paramInt);
    if (a.hgA()) {
      Log.i("MicroMsg.WxRecyclerView", "[canScrollVertically] direction=" + paramInt + " result=" + bool);
    }
    AppMethodBeat.o(205083);
    return bool;
  }
  
  public final int getFlingSpeedFactor()
  {
    return this.RrO;
  }
  
  public final void kQ()
  {
    AppMethodBeat.i(164756);
    super.kQ();
    StringBuilder localStringBuilder;
    if (a.hgA())
    {
      localStringBuilder = new StringBuilder("[stopScroll] ");
      if (!a.hgB()) {
        break label54;
      }
    }
    label54:
    for (Object localObject = Util.getStack();; localObject = "")
    {
      Log.d("MicroMsg.WxRecyclerView", localObject);
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
    if (a.hgA())
    {
      localStringBuilder = new StringBuilder("[onLayout] changed=").append(paramBoolean).append(" [").append(paramInt1).append(':').append(paramInt2).append(':').append(paramInt3).append(':').append(paramInt4).append("] ");
      if (!a.hgB()) {
        break label117;
      }
    }
    label117:
    for (Object localObject = Util.getStack();; localObject = "")
    {
      Log.d("MicroMsg.WxRecyclerView", localObject);
      AppMethodBeat.o(164751);
      return;
    }
  }
  
  public void onViewAdded(View paramView)
  {
    AppMethodBeat.i(164760);
    super.onViewAdded(paramView);
    StringBuilder localStringBuilder;
    if (a.hgA())
    {
      localStringBuilder = new StringBuilder("[onViewAdded] child=").append(paramView).append(' ');
      if (!a.hgB()) {
        break label67;
      }
    }
    label67:
    for (paramView = Util.getStack();; paramView = "")
    {
      Log.d("MicroMsg.WxRecyclerView", paramView);
      AppMethodBeat.o(164760);
      return;
    }
  }
  
  public void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(164761);
    super.onViewRemoved(paramView);
    StringBuilder localStringBuilder;
    if (a.hgA())
    {
      localStringBuilder = new StringBuilder("[onViewRemoved] child=").append(paramView).append(' ');
      if (!a.hgB()) {
        break label67;
      }
    }
    label67:
    for (paramView = Util.getStack();; paramView = "")
    {
      Log.d("MicroMsg.WxRecyclerView", paramView);
      AppMethodBeat.o(164761);
      return;
    }
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(164752);
    super.requestLayout();
    StringBuilder localStringBuilder;
    if (a.hgA())
    {
      localStringBuilder = new StringBuilder("[requestLayout] ");
      if (!a.hgB()) {
        break label57;
      }
    }
    label57:
    for (Object localObject = Util.getStack();; localObject = "")
    {
      Log.d("MicroMsg.WxRecyclerView", localObject);
      AppMethodBeat.o(164752);
      return;
    }
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164753);
    super.scrollBy(paramInt1, paramInt2);
    if (a.hgA()) {
      Log.d("MicroMsg.WxRecyclerView", "[scrollBy] x=" + paramInt1 + " y=" + paramInt1);
    }
    AppMethodBeat.o(164753);
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164754);
    super.scrollTo(paramInt1, paramInt2);
    if (a.hgA()) {
      Log.d("MicroMsg.WxRecyclerView", "[scrollTo] x=" + paramInt1 + " y=" + paramInt1);
    }
    AppMethodBeat.o(164754);
  }
  
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(164755);
    super.scrollToPosition(paramInt);
    if (a.hgA()) {
      Log.d("MicroMsg.WxRecyclerView", "[scrollToPosition] position=".concat(String.valueOf(paramInt)));
    }
    AppMethodBeat.o(164755);
  }
  
  public void setAdapter(RecyclerView.a<?> parama)
  {
    AppMethodBeat.i(164750);
    super.setAdapter(parama);
    if ((parama instanceof g)) {
      ((g)parama).RqI = true;
    }
    if (parama != null)
    {
      parama.a((RecyclerView.c)this.RrP);
      AppMethodBeat.o(164750);
      return;
    }
    AppMethodBeat.o(164750);
  }
  
  public final void setFlingSpeedFactor(int paramInt)
  {
    this.RrO = paramInt;
  }
  
  public void setLayoutFrozen(boolean paramBoolean)
  {
    AppMethodBeat.i(164759);
    super.setLayoutFrozen(paramBoolean);
    StringBuilder localStringBuilder;
    if (a.hgA())
    {
      localStringBuilder = new StringBuilder("[setLayoutFrozen] frozen=").append(paramBoolean).append(' ');
      if (!a.hgB()) {
        break label67;
      }
    }
    label67:
    for (Object localObject = Util.getStack();; localObject = "")
    {
      Log.d("MicroMsg.WxRecyclerView", localObject);
      AppMethodBeat.o(164759);
      return;
    }
  }
  
  public final void smoothScrollToPosition(int paramInt)
  {
    AppMethodBeat.i(164757);
    super.smoothScrollToPosition(paramInt);
    StringBuilder localStringBuilder;
    if (a.hgA())
    {
      localStringBuilder = new StringBuilder("[smoothScrollToPosition] position=").append(paramInt).append(' ');
      if (!a.hgB()) {
        break label67;
      }
    }
    label67:
    for (Object localObject = Util.getStack();; localObject = "")
    {
      Log.d("MicroMsg.WxRecyclerView", localObject);
      AppMethodBeat.o(164757);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/recyclerview/WxRecyclerView$Companion;", "", "()V", "TAG", "", "isEnableDumpStack", "", "()Z", "isEnableDumpStack$delegate", "Lkotlin/Lazy;", "isOpenRecyclerViewDebug", "isOpenRecyclerViewDebug$delegate", "isOpenRecyclerViewSystemDebug", "libmmui_release"})
  public static final class a
  {
    public static boolean hgA()
    {
      AppMethodBeat.i(164741);
      f localf = WxRecyclerView.hgy();
      a locala = WxRecyclerView.RrS;
      boolean bool = ((Boolean)localf.getValue()).booleanValue();
      AppMethodBeat.o(164741);
      return bool;
    }
    
    public static boolean hgB()
    {
      AppMethodBeat.i(164742);
      f localf = WxRecyclerView.hgz();
      a locala = WxRecyclerView.RrS;
      boolean bool = ((Boolean)localf.getValue()).booleanValue();
      AppMethodBeat.o(164742);
      return bool;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/view/recyclerview/WxRecyclerView$logObserver$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "libmmui_release"})
  public static final class d
    extends RecyclerView.c
  {
    public final void onChanged()
    {
      AppMethodBeat.i(164743);
      super.onChanged();
      Object localObject = WxRecyclerView.RrS;
      StringBuilder localStringBuilder;
      if (WxRecyclerView.a.hgA())
      {
        localStringBuilder = new StringBuilder("[notify onChanged] ");
        localObject = WxRecyclerView.RrS;
        if (!WxRecyclerView.a.hgB()) {
          break label62;
        }
      }
      label62:
      for (localObject = Util.getStack();; localObject = "")
      {
        Log.d("MicroMsg.WxRecyclerView", localObject);
        AppMethodBeat.o(164743);
        return;
      }
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(164744);
      super.onItemRangeChanged(paramInt1, paramInt2);
      Object localObject = WxRecyclerView.RrS;
      StringBuilder localStringBuilder;
      if (WxRecyclerView.a.hgA())
      {
        localStringBuilder = new StringBuilder("[notify onItemRangeChanged] positionStart=").append(paramInt1).append(" itemCount=").append(paramInt2).append(' ');
        localObject = WxRecyclerView.RrS;
        if (!WxRecyclerView.a.hgB()) {
          break label84;
        }
      }
      label84:
      for (localObject = Util.getStack();; localObject = "")
      {
        Log.d("MicroMsg.WxRecyclerView", localObject);
        AppMethodBeat.o(164744);
        return;
      }
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(164745);
      super.onItemRangeChanged(paramInt1, paramInt2, paramObject);
      Object localObject = WxRecyclerView.RrS;
      if (WxRecyclerView.a.hgA())
      {
        localObject = new StringBuilder("[notify onItemRangeChanged] positionStart=").append(paramInt1).append(" itemCount=").append(paramInt2).append(" payload=").append(paramObject).append(' ');
        paramObject = WxRecyclerView.RrS;
        if (!WxRecyclerView.a.hgB()) {
          break label95;
        }
      }
      label95:
      for (paramObject = Util.getStack();; paramObject = "")
      {
        Log.d("MicroMsg.WxRecyclerView", paramObject);
        AppMethodBeat.o(164745);
        return;
      }
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(164746);
      super.onItemRangeInserted(paramInt1, paramInt2);
      Object localObject = WxRecyclerView.RrS;
      StringBuilder localStringBuilder;
      if (WxRecyclerView.a.hgA())
      {
        localStringBuilder = new StringBuilder("[notify onItemRangeInserted] positionStart=").append(paramInt1).append(" itemCount=").append(paramInt2).append(' ');
        localObject = WxRecyclerView.RrS;
        if (!WxRecyclerView.a.hgB()) {
          break label84;
        }
      }
      label84:
      for (localObject = Util.getStack();; localObject = "")
      {
        Log.d("MicroMsg.WxRecyclerView", localObject);
        AppMethodBeat.o(164746);
        return;
      }
    }
    
    public final void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(164747);
      super.onItemRangeMoved(paramInt1, paramInt2, paramInt3);
      Object localObject = WxRecyclerView.RrS;
      StringBuilder localStringBuilder;
      if (WxRecyclerView.a.hgA())
      {
        localStringBuilder = new StringBuilder("[notify onItemRangeMoved] fromPosition=").append(paramInt1).append(" toPosition=").append(paramInt2).append(" itemCount=").append(paramInt3).append(' ');
        localObject = WxRecyclerView.RrS;
        if (!WxRecyclerView.a.hgB()) {
          break label98;
        }
      }
      label98:
      for (localObject = Util.getStack();; localObject = "")
      {
        Log.d("MicroMsg.WxRecyclerView", localObject);
        AppMethodBeat.o(164747);
        return;
      }
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(164748);
      super.onItemRangeRemoved(paramInt1, paramInt2);
      Object localObject = WxRecyclerView.RrS;
      StringBuilder localStringBuilder;
      if (WxRecyclerView.a.hgA())
      {
        localStringBuilder = new StringBuilder("[notify onItemRangeRemoved] positionStart=").append(paramInt1).append(" itemCount=").append(paramInt2).append(' ');
        localObject = WxRecyclerView.RrS;
        if (!WxRecyclerView.a.hgB()) {
          break label84;
        }
      }
      label84:
      for (localObject = Util.getStack();; localObject = "")
      {
        Log.d("MicroMsg.WxRecyclerView", localObject);
        AppMethodBeat.o(164748);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.WxRecyclerView
 * JD-Core Version:    0.7.0.1
 */