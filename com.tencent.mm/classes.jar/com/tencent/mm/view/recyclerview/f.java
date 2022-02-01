package com.tencent.mm.view.recyclerview;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/recyclerview/ItemConvert;", "D", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "", "()V", "isAttachedToRecyclerView", "", "()Z", "setAttachedToRecyclerView", "(Z)V", "createViewHolder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "convertView", "Landroid/view/View;", "getLayoutId", "", "onAttachedToRecyclerView", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "holder", "item", "position", "type", "isHotPatch", "payloads", "", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/view/recyclerview/ConvertData;IIZLjava/util/List;)V", "onCreateViewHolder", "onDetachedFromRecyclerView", "onViewRecycled", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class f<D extends a>
{
  boolean agNV;
  
  public void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramWxRecyclerAdapter, "adapter");
    this.agNV = true;
  }
  
  public abstract void a(RecyclerView paramRecyclerView, j paramj, int paramInt);
  
  public abstract void a(j paramj, D paramD, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList);
  
  public j b(RecyclerView paramRecyclerView, View paramView)
  {
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramView, "convertView");
    return null;
  }
  
  public void e(RecyclerView paramRecyclerView)
  {
    s.u(paramRecyclerView, "recyclerView");
    this.agNV = false;
  }
  
  public abstract int getLayoutId();
  
  public void m(j paramj)
  {
    s.u(paramj, "holder");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.f
 * JD-Core Version:    0.7.0.1
 */