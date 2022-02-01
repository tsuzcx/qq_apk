package com.tencent.mm.plugin.multitask.ui.minusscreen;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.ui.minusscreen.view.g;
import com.tencent.mm.plugin.multitask.ui.minusscreen.view.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenGridLayoutConfig;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/IMinusScreenLayoutConfig;", "multiTaskInfo", "", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "gridSpanCount", "", "(Ljava/util/List;I)V", "TAG", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getGridSpanCount", "()I", "getMultiTaskInfo", "()Ljava/util/List;", "viewListener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "getDefaultConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getIfReachBottom", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "getViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "setAdapter", "", "setListener", "listener", "ui-multitask_release"})
public final class c
  implements a
{
  private final int Amp;
  private com.tencent.mm.plugin.multitask.ui.minusscreen.d.a FKm;
  private final List<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> FKn;
  private final String TAG;
  private WxRecyclerAdapter<?> xnR;
  
  private c(List<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> paramList)
  {
    AppMethodBeat.i(196394);
    this.FKn = paramList;
    this.Amp = 2;
    this.TAG = "MicroMsg.MultiTask.MinusScreenGridLayoutConfig";
    AppMethodBeat.o(196394);
  }
  
  public static com.tencent.mm.view.recyclerview.e<?> dNd()
  {
    AppMethodBeat.i(196393);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
    {
      localObject = (Throwable)new RuntimeException("type invalid");
      AppMethodBeat.o(196393);
      throw ((Throwable)localObject);
    }
    Log.printInfoStack("FinderGridLayoutConfig", "type invalid", new Object[0]);
    Object localObject = (com.tencent.mm.view.recyclerview.e)new b();
    AppMethodBeat.o(196393);
    return localObject;
  }
  
  public final void a(com.tencent.mm.plugin.multitask.ui.minusscreen.d.a parama)
  {
    this.FKm = parama;
  }
  
  public final com.tencent.mm.view.recyclerview.f dtg()
  {
    AppMethodBeat.i(196392);
    com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new a(this);
    AppMethodBeat.o(196392);
    return localf;
  }
  
  public final RecyclerView.LayoutManager eW(Context paramContext)
  {
    AppMethodBeat.i(196391);
    p.k(paramContext, "context");
    paramContext = new MinusScreenGridLayoutManager(paramContext, this.Amp);
    paramContext.a((GridLayoutManager.b)new b());
    paramContext.setItemPrefetchEnabled(true);
    paramContext = (RecyclerView.LayoutManager)paramContext;
    AppMethodBeat.o(196391);
    return paramContext;
  }
  
  public final void setAdapter(WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    this.xnR = paramWxRecyclerAdapter;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenGridLayoutConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "ui-multitask_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    public final com.tencent.mm.view.recyclerview.e<?> yx(int paramInt)
    {
      AppMethodBeat.i(197322);
      switch (paramInt)
      {
      default: 
        localObject = this.zJM;
        if (localObject != null)
        {
          com.tencent.mm.view.recyclerview.e locale = (com.tencent.mm.view.recyclerview.e)((kotlin.g.a.b)localObject).invoke(Integer.valueOf(paramInt));
          localObject = locale;
          if (locale != null) {}
        }
        else
        {
          localObject = c.dNd();
        }
        AppMethodBeat.o(197322);
        return localObject;
      case 2: 
        localObject = (com.tencent.mm.view.recyclerview.e)new h(c.a(this.FKo));
        AppMethodBeat.o(197322);
        return localObject;
      case 22: 
        localObject = (com.tencent.mm.view.recyclerview.e)new g(c.a(this.FKo));
        AppMethodBeat.o(197322);
        return localObject;
      case 4: 
        localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.multitask.ui.minusscreen.view.b(c.a(this.FKo));
        AppMethodBeat.o(197322);
        return localObject;
      case 1: 
        localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.multitask.ui.minusscreen.view.a(c.a(this.FKo));
        AppMethodBeat.o(197322);
        return localObject;
      case 5: 
        localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.multitask.ui.minusscreen.view.c(c.a(this.FKo));
        AppMethodBeat.o(197322);
        return localObject;
      case 3: 
        localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.multitask.ui.minusscreen.view.e(c.a(this.FKo));
        AppMethodBeat.o(197322);
        return localObject;
      }
      Object localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.multitask.ui.minusscreen.view.f(c.a(this.FKo));
      AppMethodBeat.o(197322);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenGridLayoutConfig$getLayoutManager$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "ui-multitask_release"})
  public static final class b
    extends GridLayoutManager.b
  {
    public final int cx(int paramInt)
    {
      if (paramInt == 0) {
        return 2;
      }
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.c
 * JD-Core Version:    0.7.0.1
 */