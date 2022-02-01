package com.tencent.mm.plugin.mvvmlist;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "T", "Lcom/tencent/mm/plugin/mvvmlist/IMvvmListItem;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mvvmlist/MMLiveListAdapterCallback;", "liveList", "Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "itemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "needScrollData", "", "(Lcom/tencent/mm/plugin/mvvmlist/MvvmList;Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;Z)V", "getLiveList", "()Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "needBindClickEvent", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "scrollToPosition", "Companion", "plugin-mvvmlist_release"}, k=1, mv={1, 5, 1}, xi=48)
public class g<T extends b<T>>
  extends WxRecyclerAdapter<T>
  implements c
{
  public static final a Mns;
  private final MvvmList<T> Mnt;
  
  static
  {
    AppMethodBeat.i(278831);
    Mns = new a((byte)0);
    AppMethodBeat.o(278831);
  }
  
  private g(MvvmList<T> paramMvvmList, com.tencent.mm.view.recyclerview.g paramg)
  {
    super(paramg, (ArrayList)paramMvvmList.pUj, false);
    AppMethodBeat.i(278821);
    this.Mnt = paramMvvmList;
    paramMvvmList = this.Mnt;
    paramg = (c)this;
    s.u(paramg, "callback");
    paramMvvmList.MmP = paramg;
    AppMethodBeat.o(278821);
  }
  
  public final void aR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(278837);
    int i = this.agOb.size() + paramInt1;
    Log.i("MicroMsg.Mvvm.MvvmRecyclerAdapter", "onInserted pos:" + paramInt1 + " fixPos:" + i + " count:" + paramInt2);
    bA(i, paramInt2);
    AppMethodBeat.o(278837);
  }
  
  public final void aS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(278838);
    int i = this.agOb.size() + paramInt1;
    Log.i("MicroMsg.Mvvm.MvvmRecyclerAdapter", "onRemoved pos:" + paramInt1 + " fixPos:" + i + " count:" + paramInt2);
    bB(i, paramInt2);
    AppMethodBeat.o(278838);
  }
  
  public final void aW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(278841);
    int i = this.agOb.size() + paramInt1;
    int j = this.agOb.size() + paramInt2;
    Log.i("MicroMsg.Mvvm.MvvmRecyclerAdapter", "onMoved fromPos:" + paramInt1 + " fromFixPos:" + i + " toPos:" + paramInt2 + " toFixPos:" + j);
    bz(i, j);
    AppMethodBeat.o(278841);
  }
  
  public boolean bZD()
  {
    return true;
  }
  
  public final void c(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(278847);
    int i = this.agOb.size() + paramInt1;
    Log.i("MicroMsg.Mvvm.MvvmRecyclerAdapter", "onChanged pos:" + paramInt1 + " fixPos:" + i + " count:" + paramInt2 + ' ' + paramObject);
    e(i, paramInt2, paramObject);
    AppMethodBeat.o(278847);
  }
  
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(278852);
    int i = paramInt + this.agOb.size();
    Log.i("MicroMsg.Mvvm.MvvmRecyclerAdapter", "scrollToPosition pos:" + paramInt + " fixPos:" + i);
    RecyclerView localRecyclerView = getRecyclerView();
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aYi(), "com/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter", "scrollToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerView.scrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter", "scrollToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(278852);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter$Companion;", "", "()V", "TAG", "", "plugin-mvvmlist_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mvvmlist.g
 * JD-Core Version:    0.7.0.1
 */