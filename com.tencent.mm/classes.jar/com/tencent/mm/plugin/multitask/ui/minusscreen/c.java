package com.tencent.mm.plugin.multitask.ui.minusscreen;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.ui.minusscreen.view.g;
import com.tencent.mm.plugin.multitask.ui.minusscreen.view.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenGridLayoutConfig;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/IMinusScreenLayoutConfig;", "multiTaskInfo", "", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "gridSpanCount", "", "(Ljava/util/List;I)V", "TAG", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getGridSpanCount", "()I", "getMultiTaskInfo", "()Ljava/util/List;", "viewListener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "getDefaultConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getIfReachBottom", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getViewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "getViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "setAdapter", "", "setListener", "listener", "ui-multitask_release"})
public final class c
  implements a
{
  private com.tencent.mm.plugin.multitask.ui.minusscreen.d.a AdJ;
  private final List<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> AdK;
  private final String TAG;
  private WxRecyclerAdapter<?> tFp;
  private final int vEY;
  
  private c(List<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> paramList)
  {
    AppMethodBeat.i(236440);
    this.AdK = paramList;
    this.vEY = 2;
    this.TAG = "MicroMsg.MultiTask.MinusScreenGridLayoutConfig";
    AppMethodBeat.o(236440);
  }
  
  public static com.tencent.mm.view.recyclerview.e<?> erC()
  {
    AppMethodBeat.i(236439);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
    {
      localObject = (Throwable)new RuntimeException("type invalid");
      AppMethodBeat.o(236439);
      throw ((Throwable)localObject);
    }
    Log.printInfoStack("FinderGridLayoutConfig", "type invalid", new Object[0]);
    Object localObject = (com.tencent.mm.view.recyclerview.e)new b();
    AppMethodBeat.o(236439);
    return localObject;
  }
  
  public final void a(com.tencent.mm.plugin.multitask.ui.minusscreen.d.a parama)
  {
    this.AdJ = parama;
  }
  
  public final com.tencent.mm.view.recyclerview.f dcK()
  {
    AppMethodBeat.i(236438);
    com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new a(this);
    AppMethodBeat.o(236438);
    return localf;
  }
  
  public final RecyclerView.LayoutManager eS(Context paramContext)
  {
    AppMethodBeat.i(236437);
    p.h(paramContext, "context");
    paramContext = new MinusScreenGridLayoutManager(paramContext, this.vEY);
    paramContext.a((GridLayoutManager.b)new b());
    paramContext.setItemPrefetchEnabled(true);
    paramContext = (RecyclerView.LayoutManager)paramContext;
    AppMethodBeat.o(236437);
    return paramContext;
  }
  
  public final void setAdapter(WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    this.tFp = paramWxRecyclerAdapter;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenGridLayoutConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "ui-multitask_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    a(kotlin.g.a.b paramb) {}
    
    public final com.tencent.mm.view.recyclerview.e<?> EC(int paramInt)
    {
      AppMethodBeat.i(236436);
      switch (paramInt)
      {
      default: 
        localObject = this.uTz;
        if (localObject != null)
        {
          com.tencent.mm.view.recyclerview.e locale = (com.tencent.mm.view.recyclerview.e)((kotlin.g.a.b)localObject).invoke(Integer.valueOf(paramInt));
          localObject = locale;
          if (locale != null) {}
        }
        else
        {
          localObject = c.erC();
        }
        AppMethodBeat.o(236436);
        return localObject;
      case 2: 
        localObject = (com.tencent.mm.view.recyclerview.e)new h(c.a(this.AdL));
        AppMethodBeat.o(236436);
        return localObject;
      case 22: 
        localObject = (com.tencent.mm.view.recyclerview.e)new g(c.a(this.AdL));
        AppMethodBeat.o(236436);
        return localObject;
      case 4: 
        localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.multitask.ui.minusscreen.view.b(c.a(this.AdL));
        AppMethodBeat.o(236436);
        return localObject;
      case 1: 
        localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.multitask.ui.minusscreen.view.a(c.a(this.AdL));
        AppMethodBeat.o(236436);
        return localObject;
      case 5: 
        localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.multitask.ui.minusscreen.view.c(c.a(this.AdL));
        AppMethodBeat.o(236436);
        return localObject;
      case 3: 
        localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.multitask.ui.minusscreen.view.e(c.a(this.AdL));
        AppMethodBeat.o(236436);
        return localObject;
      }
      Object localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.multitask.ui.minusscreen.view.f(c.a(this.AdL));
      AppMethodBeat.o(236436);
      return localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenGridLayoutConfig$getLayoutManager$1", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "ui-multitask_release"})
  public static final class b
    extends GridLayoutManager.b
  {
    public final int bX(int paramInt)
    {
      if (paramInt == 0) {
        return 2;
      }
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.c
 * JD-Core Version:    0.7.0.1
 */