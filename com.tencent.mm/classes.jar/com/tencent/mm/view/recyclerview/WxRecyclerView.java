package com.tencent.mm.view.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.f;
import kotlin.g;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/tencent/mm/view/recyclerview/ISupportStrongConfig;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "flingSpeedFactor", "getFlingSpeedFactor", "()I", "setFlingSpeedFactor", "(I)V", "logObserver", "com/tencent/mm/view/recyclerview/WxRecyclerView$logObserver$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView$logObserver$1;", "canScrollHorizontally", "", "direction", "canScrollVertically", "fling", "velocityX", "velocityY", "isSupportAvoidCrashWithNotifyWhenScrollOrLayout", "isSupportNotifyItemViewChangeWithoutAnyAttachAndDetachAction", "onAttachedToWindow", "", "onLayout", "changed", "l", "t", "r", "b", "onViewAdded", "child", "Landroid/view/View;", "onViewRemoved", "openRecyclerViewDebug", "requestLayout", "scrollBy", "x", "y", "scrollTo", "scrollToPosition", "position", "setAdapter", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setLayoutFrozen", "frozen", "smoothScrollBy", "dx", "dy", "interpolator", "Landroid/view/animation/Interpolator;", "smoothScrollToPosition", "stopScroll", "Companion", "libmmui_release"})
public class WxRecyclerView
  extends RecyclerView
{
  private static final f YTq;
  private static final f YTr;
  public static final a YTs;
  private int YTo;
  private final d YTp;
  
  static
  {
    AppMethodBeat.i(164764);
    YTs = new a((byte)0);
    YTq = g.ar((kotlin.g.a.a)WxRecyclerView.c.YTu);
    YTr = g.ar((kotlin.g.a.a)WxRecyclerView.b.YTt);
    AppMethodBeat.o(164764);
  }
  
  public WxRecyclerView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(207408);
    this.YTo = 100;
    this.YTp = new d();
    AppMethodBeat.o(207408);
  }
  
  public WxRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164762);
    this.YTo = 100;
    this.YTp = new d();
    AppMethodBeat.o(164762);
  }
  
  public WxRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164763);
    this.YTo = 100;
    this.YTp = new d();
    AppMethodBeat.o(164763);
  }
  
  public final void a(int paramInt1, int paramInt2, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(164758);
    super.a(paramInt1, paramInt2, paramInterpolator);
    StringBuilder localStringBuilder;
    if (a.iic())
    {
      localStringBuilder = new StringBuilder("[smoothScrollBy] dx=").append(paramInt1).append(" dy=").append(paramInt2).append(" interpolator=").append(paramInterpolator).append(' ');
      if (!a.iid()) {
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
  
  public final boolean ay(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207391);
    RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
    if ((localLayoutManager != null) && (localLayoutManager.canScrollHorizontally() == true))
    {
      bool = super.ay(kotlin.h.a.dm(this.YTo * paramInt1 / 100.0F), paramInt2);
      AppMethodBeat.o(207391);
      return bool;
    }
    localLayoutManager = getLayoutManager();
    if ((localLayoutManager != null) && (localLayoutManager.canScrollVertically() == true))
    {
      bool = super.ay(paramInt1, kotlin.h.a.dm(this.YTo * paramInt2 / 100.0F));
      AppMethodBeat.o(207391);
      return bool;
    }
    boolean bool = super.ay(paramInt1, paramInt2);
    AppMethodBeat.o(207391);
    return bool;
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    AppMethodBeat.i(207404);
    boolean bool = super.canScrollHorizontally(paramInt);
    if (a.iic()) {
      Log.i("MicroMsg.WxRecyclerView", "[canScrollHorizontally] direction=" + paramInt + " result=" + bool);
    }
    AppMethodBeat.o(207404);
    return bool;
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    AppMethodBeat.i(207406);
    boolean bool = super.canScrollVertically(paramInt);
    if (a.iic()) {
      Log.i("MicroMsg.WxRecyclerView", "[canScrollVertically] direction=" + paramInt + " result=" + bool);
    }
    AppMethodBeat.o(207406);
    return bool;
  }
  
  public final int getFlingSpeedFactor()
  {
    return this.YTo;
  }
  
  public final void ld()
  {
    AppMethodBeat.i(164756);
    super.ld();
    StringBuilder localStringBuilder;
    if (a.iic())
    {
      localStringBuilder = new StringBuilder("[stopScroll] ");
      if (!a.iid()) {
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
    if (a.iic())
    {
      localStringBuilder = new StringBuilder("[onLayout] changed=").append(paramBoolean).append(" [").append(paramInt1).append(':').append(paramInt2).append(':').append(paramInt3).append(':').append(paramInt4).append("] ");
      if (!a.iid()) {
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
    if (a.iic())
    {
      localStringBuilder = new StringBuilder("[onViewAdded] child=").append(paramView).append(' ');
      if (!a.iid()) {
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
    if (a.iic())
    {
      localStringBuilder = new StringBuilder("[onViewRemoved] child=").append(paramView).append(' ');
      if (!a.iid()) {
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
    if (a.iic())
    {
      localStringBuilder = new StringBuilder("[requestLayout] ");
      if (!a.iid()) {
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
    if (a.iic()) {
      Log.d("MicroMsg.WxRecyclerView", "[scrollBy] x=" + paramInt1 + " y=" + paramInt1);
    }
    AppMethodBeat.o(164753);
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164754);
    super.scrollTo(paramInt1, paramInt2);
    if (a.iic()) {
      Log.d("MicroMsg.WxRecyclerView", "[scrollTo] x=" + paramInt1 + " y=" + paramInt1);
    }
    AppMethodBeat.o(164754);
  }
  
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(164755);
    super.scrollToPosition(paramInt);
    if (a.iic()) {
      Log.d("MicroMsg.WxRecyclerView", "[scrollToPosition] position=".concat(String.valueOf(paramInt)));
    }
    AppMethodBeat.o(164755);
  }
  
  public void setAdapter(RecyclerView.a<?> parama)
  {
    AppMethodBeat.i(207393);
    super.setAdapter(parama);
    if ((parama instanceof h)) {
      ((h)parama).YSg = true;
    }
    if (parama != null)
    {
      parama.a((RecyclerView.c)this.YTp);
      AppMethodBeat.o(207393);
      return;
    }
    AppMethodBeat.o(207393);
  }
  
  public final void setFlingSpeedFactor(int paramInt)
  {
    this.YTo = paramInt;
  }
  
  public void setLayoutFrozen(boolean paramBoolean)
  {
    AppMethodBeat.i(164759);
    super.setLayoutFrozen(paramBoolean);
    StringBuilder localStringBuilder;
    if (a.iic())
    {
      localStringBuilder = new StringBuilder("[setLayoutFrozen] frozen=").append(paramBoolean).append(' ');
      if (!a.iid()) {
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
    if (a.iic())
    {
      localStringBuilder = new StringBuilder("[smoothScrollToPosition] position=").append(paramInt).append(' ');
      if (!a.iid()) {
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/recyclerview/WxRecyclerView$Companion;", "", "()V", "TAG", "", "isEnableDumpStack", "", "()Z", "isEnableDumpStack$delegate", "Lkotlin/Lazy;", "isOpenRecyclerViewDebug", "isOpenRecyclerViewDebug$delegate", "isOpenRecyclerViewSystemDebug", "libmmui_release"})
  public static final class a
  {
    public static boolean iic()
    {
      AppMethodBeat.i(164741);
      f localf = WxRecyclerView.iia();
      a locala = WxRecyclerView.YTs;
      boolean bool = ((Boolean)localf.getValue()).booleanValue();
      AppMethodBeat.o(164741);
      return bool;
    }
    
    public static boolean iid()
    {
      AppMethodBeat.i(164742);
      f localf = WxRecyclerView.iib();
      a locala = WxRecyclerView.YTs;
      boolean bool = ((Boolean)localf.getValue()).booleanValue();
      AppMethodBeat.o(164742);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/view/recyclerview/WxRecyclerView$logObserver$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "libmmui_release"})
  public static final class d
    extends RecyclerView.c
  {
    public final void onChanged()
    {
      AppMethodBeat.i(164743);
      super.onChanged();
      Object localObject = WxRecyclerView.YTs;
      StringBuilder localStringBuilder;
      if (WxRecyclerView.a.iic())
      {
        localStringBuilder = new StringBuilder("[notify onChanged] ");
        localObject = WxRecyclerView.YTs;
        if (!WxRecyclerView.a.iid()) {
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
      Object localObject = WxRecyclerView.YTs;
      StringBuilder localStringBuilder;
      if (WxRecyclerView.a.iic())
      {
        localStringBuilder = new StringBuilder("[notify onItemRangeChanged] positionStart=").append(paramInt1).append(" itemCount=").append(paramInt2).append(' ');
        localObject = WxRecyclerView.YTs;
        if (!WxRecyclerView.a.iid()) {
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
      Object localObject = WxRecyclerView.YTs;
      if (WxRecyclerView.a.iic())
      {
        localObject = new StringBuilder("[notify onItemRangeChanged] positionStart=").append(paramInt1).append(" itemCount=").append(paramInt2).append(" payload=").append(paramObject).append(' ');
        paramObject = WxRecyclerView.YTs;
        if (!WxRecyclerView.a.iid()) {
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
      Object localObject = WxRecyclerView.YTs;
      StringBuilder localStringBuilder;
      if (WxRecyclerView.a.iic())
      {
        localStringBuilder = new StringBuilder("[notify onItemRangeInserted] positionStart=").append(paramInt1).append(" itemCount=").append(paramInt2).append(' ');
        localObject = WxRecyclerView.YTs;
        if (!WxRecyclerView.a.iid()) {
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
      Object localObject = WxRecyclerView.YTs;
      StringBuilder localStringBuilder;
      if (WxRecyclerView.a.iic())
      {
        localStringBuilder = new StringBuilder("[notify onItemRangeMoved] fromPosition=").append(paramInt1).append(" toPosition=").append(paramInt2).append(" itemCount=").append(paramInt3).append(' ');
        localObject = WxRecyclerView.YTs;
        if (!WxRecyclerView.a.iid()) {
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
      Object localObject = WxRecyclerView.YTs;
      StringBuilder localStringBuilder;
      if (WxRecyclerView.a.iic())
      {
        localStringBuilder = new StringBuilder("[notify onItemRangeRemoved] positionStart=").append(paramInt1).append(" itemCount=").append(paramInt2).append(' ');
        localObject = WxRecyclerView.YTs;
        if (!WxRecyclerView.a.iid()) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.WxRecyclerView
 * JD-Core Version:    0.7.0.1
 */