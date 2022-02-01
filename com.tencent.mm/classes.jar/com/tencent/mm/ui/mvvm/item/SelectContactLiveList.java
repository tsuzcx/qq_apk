package com.tencent.mm.ui.mvvm.item;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mvvmlist.MvvmList;
import com.tencent.mm.plugin.mvvmlist.a.c;
import com.tencent.mm.plugin.mvvmlist.a.d;
import com.tencent.mm.plugin.mvvmlist.a.f;
import com.tencent.mm.plugin.mvvmlist.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveList;", "Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveItem;", "dataSource", "Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "config", "Lcom/tencent/mm/plugin/mvvmlist/MvvmListConfig;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;Lcom/tencent/mm/plugin/mvvmlist/MvvmListConfig;Landroidx/lifecycle/LifecycleOwner;)V", "getLogTag", "", "handleSnapshotList", "", "snapshotList", "", "Companion", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SelectContactLiveList
  extends MvvmList<b>
{
  public static final SelectContactLiveList.a afAQ;
  
  static
  {
    AppMethodBeat.i(250524);
    afAQ = new SelectContactLiveList.a((byte)0);
    AppMethodBeat.o(250524);
  }
  
  public SelectContactLiveList(f<b, c<b>, d<b>> paramf, e parame, q paramq)
  {
    super(paramf, parame, paramq);
    AppMethodBeat.i(250519);
    AppMethodBeat.o(250519);
  }
  
  public final String getLogTag()
  {
    return "MicroMsg.SelectContact.SelectContactLiveList";
  }
  
  public final List<b> hF(List<b> paramList)
  {
    AppMethodBeat.i(250531);
    s.u(paramList, "snapshotList");
    p.N(paramList);
    Object localObject1 = "";
    Iterator localIterator = ((Iterable)paramList).iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      if (i < 0) {
        p.kkW();
      }
      b localb1 = (b)localObject2;
      label116:
      b localb2;
      if (localb1.type != 30)
      {
        localObject2 = localObject1;
        if (localb1.type != 20) {}
      }
      else
      {
        localObject2 = localb1.FWw;
        if (s.p(localObject2, localObject1)) {
          break label168;
        }
        localb1.FWu = true;
        localObject1 = localObject2;
        localb2 = (b)p.ae(paramList, i - 1);
        localObject2 = localObject1;
        if (localb2 != null) {
          if (localb1.FWu) {
            break label177;
          }
        }
      }
      label168:
      label177:
      for (boolean bool = true;; bool = false)
      {
        localb2.wFP = bool;
        localObject2 = localObject1;
        i += 1;
        localObject1 = localObject2;
        break;
        localb1.FWu = false;
        break label116;
      }
    }
    localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramList.add((b)((b)((Iterator)localObject1).next()).gsx());
    }
    paramList = (List)paramList;
    AppMethodBeat.o(250531);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.mvvm.item.SelectContactLiveList
 * JD-Core Version:    0.7.0.1
 */