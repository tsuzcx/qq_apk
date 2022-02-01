package com.tencent.mm.plugin.mvvmlist;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmlist/MvvmListItemChangeObj;", "T", "Lcom/tencent/mm/plugin/mvvmlist/IMvvmListItem;", "", "oldItem", "(Lcom/tencent/mm/plugin/mvvmlist/IMvvmListItem;)V", "changeKey", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getChangeKey", "()Ljava/util/HashSet;", "setChangeKey", "(Ljava/util/HashSet;)V", "getOldItem", "()Lcom/tencent/mm/plugin/mvvmlist/IMvvmListItem;", "Lcom/tencent/mm/plugin/mvvmlist/IMvvmListItem;", "component1", "copy", "(Lcom/tencent/mm/plugin/mvvmlist/IMvvmListItem;)Lcom/tencent/mm/plugin/mvvmlist/MvvmListItemChangeObj;", "equals", "", "other", "hashCode", "", "toString", "plugin-mvvmlist_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f<T extends b<T>>
{
  private final T Mnr;
  
  public f(T paramT)
  {
    AppMethodBeat.i(278810);
    this.Mnr = paramT;
    AppMethodBeat.o(278810);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(278825);
    if (this == paramObject)
    {
      AppMethodBeat.o(278825);
      return true;
    }
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(278825);
      return false;
    }
    paramObject = (f)paramObject;
    if (!s.p(this.Mnr, paramObject.Mnr))
    {
      AppMethodBeat.o(278825);
      return false;
    }
    AppMethodBeat.o(278825);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(278820);
    int i = this.Mnr.hashCode();
    AppMethodBeat.o(278820);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(278815);
    String str = "MvvmListItemChangeObj(oldItem=" + this.Mnr + ')';
    AppMethodBeat.o(278815);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mvvmlist.f
 * JD-Core Version:    0.7.0.1
 */