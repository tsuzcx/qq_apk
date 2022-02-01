package com.tencent.mm.plugin.mvvmlist;

import androidx.recyclerview.widget.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmlist/MvvmDiffCallback;", "T", "Lcom/tencent/mm/plugin/mvvmlist/IMvvmListItem;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "newList", "(Ljava/util/List;Ljava/util/List;)V", "getNewList", "()Ljava/util/List;", "getOldList", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getChangePayload", "", "getNewListSize", "getOldListSize", "plugin-mvvmlist_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d<T extends b<T>>
  extends g.a
{
  private final List<T> uoj;
  private final List<T> uok;
  
  public d(List<? extends T> paramList1, List<? extends T> paramList2)
  {
    AppMethodBeat.i(278812);
    this.uoj = paramList1;
    this.uok = paramList2;
    AppMethodBeat.o(278812);
  }
  
  public final int If()
  {
    AppMethodBeat.i(278823);
    int i = this.uoj.size();
    AppMethodBeat.o(278823);
    return i;
  }
  
  public final int Ig()
  {
    AppMethodBeat.i(278827);
    int i = this.uok.size();
    AppMethodBeat.o(278827);
    return i;
  }
  
  public final Object aT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(278836);
    Object localObject1 = p.ae(this.uoj, paramInt1);
    Object localObject2 = p.ae(this.uok, paramInt2);
    if ((localObject1 != null) && (localObject2 != null))
    {
      localObject1 = ((b)localObject2).gb((b)localObject1);
      AppMethodBeat.o(278836);
      return localObject1;
    }
    AppMethodBeat.o(278836);
    return null;
  }
  
  public final boolean aU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(278816);
    Object localObject1 = p.ae(this.uoj, paramInt1);
    Object localObject2 = p.ae(this.uok, paramInt2);
    if ((localObject1 != null) && (localObject2 != null))
    {
      localObject2 = (b)localObject2;
      boolean bool = ((b)localObject1).gc(localObject2);
      AppMethodBeat.o(278816);
      return bool;
    }
    AppMethodBeat.o(278816);
    return false;
  }
  
  public final boolean aV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(278832);
    Object localObject1 = p.ae(this.uoj, paramInt1);
    Object localObject2 = p.ae(this.uok, paramInt2);
    if ((localObject1 != null) && (localObject2 != null))
    {
      localObject2 = (b)localObject2;
      boolean bool = ((b)localObject1).fC(localObject2);
      AppMethodBeat.o(278832);
      return bool;
    }
    AppMethodBeat.o(278832);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mvvmlist.d
 * JD-Core Version:    0.7.0.1
 */