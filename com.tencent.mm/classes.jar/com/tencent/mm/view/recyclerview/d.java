package com.tencent.mm.view.recyclerview;

import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/recyclerview/ExposeTimeRecordListener;", "T", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "", "()V", "getExposedId", "", "holder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "ignoreFlingExposed", "", "onExposeTimeRecorded", "", "recordsSet", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "onItemExposeStart", "item", "libmmui_release"})
public abstract class d<T extends a>
{
  public void a(b<T> paramb)
  {
    p.h(paramb, "item");
  }
  
  public abstract void l(Set<b<T>> paramSet);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.d
 * JD-Core Version:    0.7.0.1
 */