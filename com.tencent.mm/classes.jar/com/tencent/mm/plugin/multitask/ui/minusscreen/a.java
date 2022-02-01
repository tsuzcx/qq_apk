package com.tencent.mm.plugin.multitask.ui.minusscreen;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/IMinusScreenLayoutConfig;", "", "getIfReachBottom", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewParent", "Landroid/view/ViewGroup;", "getViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "setAdapter", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setListener", "listener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "Companion", "ui-multitask_release"})
public abstract interface a
{
  public static final a.a FKk = a.a.FKl;
  
  public abstract void a(com.tencent.mm.plugin.multitask.ui.minusscreen.d.a parama);
  
  public abstract f dtg();
  
  public abstract RecyclerView.LayoutManager eW(Context paramContext);
  
  public abstract void setAdapter(WxRecyclerAdapter<?> paramWxRecyclerAdapter);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.a
 * JD-Core Version:    0.7.0.1
 */