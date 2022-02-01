package com.tencent.mm.plugin.mvvmlist;

import com.tencent.mm.view.recyclerview.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmlist/IMvvmListItem;", "T", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "", "cloneItem", "()Ljava/lang/Object;", "getChangeObject", "Lcom/tencent/mm/plugin/mvvmlist/MvvmListItemChangeObj;", "old", "(Ljava/lang/Object;)Lcom/tencent/mm/plugin/mvvmlist/MvvmListItemChangeObj;", "getUniqueId", "", "isSameContent", "", "other", "(Ljava/lang/Object;)Z", "isSameItem", "plugin-mvvmlist_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b<T>
  extends a, Comparable<T>
{
  public abstract boolean fC(T paramT);
  
  public abstract String fcs();
  
  public abstract f<?> gb(T paramT);
  
  public abstract boolean gc(T paramT);
  
  public abstract T gsw();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mvvmlist.b
 * JD-Core Version:    0.7.0.1
 */