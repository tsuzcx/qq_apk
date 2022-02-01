package com.tencent.mm.view.recyclerview;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/recyclerview/ItemConvert;", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "", "()V", "isAttachedToRecyclerView", "", "()Z", "setAttachedToRecyclerView", "(Z)V", "getLayoutId", "", "onAttachedToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/view/recyclerview/ConvertData;IIZLjava/util/List;)V", "onCreateViewHolder", "onDetachedFromRecyclerView", "onViewRecycled", "libmmui_release"})
public abstract class e<D extends a>
{
  boolean YSe;
  
  public void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    p.k(paramRecyclerView, "recyclerView");
    p.k(paramWxRecyclerAdapter, "adapter");
    this.YSe = true;
  }
  
  public abstract void a(RecyclerView paramRecyclerView, i parami, int paramInt);
  
  public abstract void a(i parami, D paramD, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList);
  
  public void b(i parami)
  {
    p.k(parami, "holder");
  }
  
  public void e(RecyclerView paramRecyclerView)
  {
    p.k(paramRecyclerView, "recyclerView");
    this.YSe = false;
  }
  
  public abstract int getLayoutId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.e
 * JD-Core Version:    0.7.0.1
 */