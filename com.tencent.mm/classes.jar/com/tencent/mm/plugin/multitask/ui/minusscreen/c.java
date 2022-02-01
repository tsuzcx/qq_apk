package com.tencent.mm.plugin.multitask.ui.minusscreen;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.ui.minusscreen.view.e;
import com.tencent.mm.plugin.multitask.ui.minusscreen.view.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenGridLayoutConfig;", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/IMinusScreenLayoutConfig;", "multiTaskInfo", "", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/data/RVMultiTaskData;", "gridSpanCount", "", "(Ljava/util/List;I)V", "TAG", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getGridSpanCount", "()I", "getMultiTaskInfo", "()Ljava/util/List;", "viewListener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "getDefaultConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getIfReachBottom", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "setAdapter", "", "setListener", "listener", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements a
{
  private WxRecyclerAdapter<?> ALE;
  private final int FMi;
  private final List<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> LFB;
  private com.tencent.mm.plugin.multitask.ui.minusscreen.d.a LFC;
  private final String TAG;
  
  private c(List<com.tencent.mm.plugin.multitask.ui.minusscreen.b.a> paramList)
  {
    AppMethodBeat.i(304441);
    this.LFB = paramList;
    this.FMi = 2;
    this.TAG = "MicroMsg.MultiTask.MinusScreenGridLayoutConfig";
    AppMethodBeat.o(304441);
  }
  
  public static com.tencent.mm.view.recyclerview.f<?> eGS()
  {
    AppMethodBeat.i(304460);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
    {
      localObject = new RuntimeException("type invalid");
      AppMethodBeat.o(304460);
      throw ((Throwable)localObject);
    }
    Log.printInfoStack("FinderGridLayoutConfig", "type invalid", new Object[0]);
    Object localObject = (com.tencent.mm.view.recyclerview.f)new b();
    AppMethodBeat.o(304460);
    return localObject;
  }
  
  public final void a(com.tencent.mm.plugin.multitask.ui.minusscreen.d.a parama)
  {
    this.LFC = parama;
  }
  
  public final com.tencent.mm.view.recyclerview.g ech()
  {
    AppMethodBeat.i(304504);
    com.tencent.mm.view.recyclerview.g localg = (com.tencent.mm.view.recyclerview.g)new a(this);
    AppMethodBeat.o(304504);
    return localg;
  }
  
  public final RecyclerView.LayoutManager fT(Context paramContext)
  {
    AppMethodBeat.i(304491);
    s.u(paramContext, "context");
    paramContext = new MinusScreenGridLayoutManager(paramContext, this.FMi);
    paramContext.bWq = ((GridLayoutManager.b)new b());
    paramContext.setItemPrefetchEnabled(true);
    paramContext = (RecyclerView.LayoutManager)paramContext;
    AppMethodBeat.o(304491);
    return paramContext;
  }
  
  public final void setAdapter(WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    this.ALE = paramWxRecyclerAdapter;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenGridLayoutConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.view.recyclerview.g
  {
    a(c paramc) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(304335);
      switch (paramInt)
      {
      default: 
        localObject = this.Bbh;
        if (localObject != null) {
          break;
        }
      }
      for (Object localObject = null; localObject == null; localObject = (com.tencent.mm.view.recyclerview.f)((kotlin.g.a.b)localObject).invoke(Integer.valueOf(paramInt)))
      {
        localObject = c.eGS();
        AppMethodBeat.o(304335);
        return localObject;
        localObject = (com.tencent.mm.view.recyclerview.f)new h(c.a(this.LFD));
        AppMethodBeat.o(304335);
        return localObject;
        localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.multitask.ui.minusscreen.view.g(c.a(this.LFD));
        AppMethodBeat.o(304335);
        return localObject;
        localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.multitask.ui.minusscreen.view.b(c.a(this.LFD));
        AppMethodBeat.o(304335);
        return localObject;
        localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.multitask.ui.minusscreen.view.a(c.a(this.LFD));
        AppMethodBeat.o(304335);
        return localObject;
        localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.multitask.ui.minusscreen.view.c(c.a(this.LFD));
        AppMethodBeat.o(304335);
        return localObject;
        localObject = (com.tencent.mm.view.recyclerview.f)new e(c.a(this.LFD));
        AppMethodBeat.o(304335);
        return localObject;
        localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.multitask.ui.minusscreen.view.f(c.a(this.LFD));
        AppMethodBeat.o(304335);
        return localObject;
      }
      AppMethodBeat.o(304335);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenGridLayoutConfig$getLayoutManager$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends GridLayoutManager.b
  {
    public final int fJ(int paramInt)
    {
      if (paramInt == 0) {
        return 2;
      }
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.c
 * JD-Core Version:    0.7.0.1
 */