package com.tencent.mm.view.recyclerview;

import android.support.v7.widget.RecyclerView;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/view/recyclerview/ItemConvert;", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "", "()V", "isAttachedToRecyclerView", "", "()Z", "setAttachedToRecyclerView", "(Z)V", "getLayoutId", "", "onAttachedToRecyclerView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/view/recyclerview/ConvertData;IIZLjava/util/List;)V", "onCreateViewHolder", "onDetachedFromRecyclerView", "libmmui_release"})
public abstract class b<D extends a>
{
  boolean LRP;
  
  public void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramWxRecyclerAdapter, "adapter");
    this.LRP = true;
  }
  
  public abstract void a(RecyclerView paramRecyclerView, e parame, int paramInt);
  
  public abstract void a(e parame, D paramD, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList);
  
  public void d(RecyclerView paramRecyclerView)
  {
    p.h(paramRecyclerView, "recyclerView");
    this.LRP = false;
  }
  
  public abstract int getLayoutId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.b
 * JD-Core Version:    0.7.0.1
 */