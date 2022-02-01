package com.tencent.mm.plugin.multitask.ui.minusscreen;

import android.content.Context;
import android.support.v7.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/IMinusScreenLayoutConfig;", "", "getIfReachBottom", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getViewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "viewParent", "Landroid/view/ViewGroup;", "getViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "setAdapter", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setListener", "listener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "Companion", "ui-multitask_release"})
public abstract interface a
{
  public static final a AdH = a.AdI;
  
  public abstract void a(com.tencent.mm.plugin.multitask.ui.minusscreen.d.a parama);
  
  public abstract f dcK();
  
  public abstract RecyclerView.LayoutManager eS(Context paramContext);
  
  public abstract void setAdapter(WxRecyclerAdapter<?> paramWxRecyclerAdapter);
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/IMinusScreenLayoutConfig$Companion;", "", "()V", "space", "", "getSpace", "()I", "ui-multitask_release"})
  public static final class a
  {
    private static final int tCv;
    
    static
    {
      AppMethodBeat.i(236433);
      AdI = new a();
      tCv = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 12.0F);
      AppMethodBeat.o(236433);
    }
    
    public static int erB()
    {
      return tCv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.a
 * JD-Core Version:    0.7.0.1
 */