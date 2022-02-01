package com.tencent.mm.view.recyclerview;

import android.support.v7.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/recyclerview/ItemConvert;", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "", "()V", "isAttachedToRecyclerView", "", "()Z", "setAttachedToRecyclerView", "(Z)V", "getLayoutId", "", "onAttachedToRecyclerView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/view/recyclerview/ConvertData;IIZLjava/util/List;)V", "onCreateViewHolder", "onDetachedFromRecyclerView", "onViewRecycled", "libmmui_release"})
public abstract class e<D extends a>
{
  boolean RqG;
  
  public void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramWxRecyclerAdapter, "adapter");
    this.RqG = true;
  }
  
  public abstract void a(RecyclerView paramRecyclerView, h paramh, int paramInt);
  
  public abstract void a(h paramh, D paramD, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList);
  
  public void b(h paramh)
  {
    p.h(paramh, "holder");
  }
  
  public void c(RecyclerView paramRecyclerView)
  {
    p.h(paramRecyclerView, "recyclerView");
    this.RqG = false;
  }
  
  public abstract int getLayoutId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.e
 * JD-Core Version:    0.7.0.1
 */