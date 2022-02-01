package com.tencent.mm.plugin.mvvmlist;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmlist/BaseMvvmListItem;", "T", "Lcom/tencent/mm/plugin/mvvmlist/IMvvmListItem;", "", "()V", "cloneItem", "()Lcom/tencent/mm/plugin/mvvmlist/IMvvmListItem;", "getChangeObject", "Lcom/tencent/mm/plugin/mvvmlist/MvvmListItemChangeObj;", "old", "(Lcom/tencent/mm/plugin/mvvmlist/IMvvmListItem;)Lcom/tencent/mm/plugin/mvvmlist/MvvmListItemChangeObj;", "getItemId", "", "isSameItem", "", "other", "(Lcom/tencent/mm/plugin/mvvmlist/IMvvmListItem;)Z", "plugin-mvvmlist_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a<T extends b<T>>
  implements b<T>, Cloneable
{
  public long bZA()
  {
    return fcs().hashCode();
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public final T gsx()
  {
    return (b)super.clone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mvvmlist.a
 * JD-Core Version:    0.7.0.1
 */