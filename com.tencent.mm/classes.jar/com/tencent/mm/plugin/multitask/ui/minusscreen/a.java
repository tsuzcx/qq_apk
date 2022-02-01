package com.tencent.mm.plugin.multitask.ui.minusscreen;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/IMinusScreenLayoutConfig;", "", "getIfReachBottom", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "setAdapter", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setListener", "listener", "Lcom/tencent/mm/plugin/multitask/ui/minusscreen/listener/MinusScreenViewItemListener;", "Companion", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
{
  public static final a.a LFz = a.a.LFA;
  
  public abstract void a(com.tencent.mm.plugin.multitask.ui.minusscreen.d.a parama);
  
  public abstract g ech();
  
  public abstract RecyclerView.LayoutManager fT(Context paramContext);
  
  public abstract void setAdapter(WxRecyclerAdapter<?> paramWxRecyclerAdapter);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.a
 * JD-Core Version:    0.7.0.1
 */