package com.tencent.mm.view.recyclerview;

import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/recyclerview/ExposeTimeRecordListener;", "T", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "", "()V", "getExposedId", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ignoreFlingExposed", "", "onExposeTimeRecorded", "", "recordsSet", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "onItemExposeStart", "item", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class d<T extends a>
{
  public void a(b<T> paramb)
  {
    s.u(paramb, "item");
  }
  
  public abstract void s(Set<b<T>> paramSet);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.d
 * JD-Core Version:    0.7.0.1
 */