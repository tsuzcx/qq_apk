package com.tencent.mm.ui.contact.address;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mvvmlist.MvvmList;
import com.tencent.mm.plugin.mvvmlist.a.c;
import com.tencent.mm.plugin.mvvmlist.a.f;
import com.tencent.mm.plugin.mvvmlist.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/address/AddressLiveList;", "Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "Lcom/tencent/mm/ui/contact/address/AddressLiveListItem;", "dataSource", "Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "config", "Lcom/tencent/mm/plugin/mvvmlist/MvvmListConfig;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;Lcom/tencent/mm/plugin/mvvmlist/MvvmListConfig;Landroidx/lifecycle/LifecycleOwner;)V", "getLogTag", "", "handleSnapshotList", "", "snapshotList", "", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AddressLiveList
  extends MvvmList<d>
{
  public static final AddressLiveList.a afjk;
  
  static
  {
    AppMethodBeat.i(253259);
    afjk = new AddressLiveList.a((byte)0);
    AppMethodBeat.o(253259);
  }
  
  public AddressLiveList(f<d, c<d>, com.tencent.mm.plugin.mvvmlist.a.d<d>> paramf, e parame, q paramq)
  {
    super(paramf, parame, paramq);
    AppMethodBeat.i(253250);
    AppMethodBeat.o(253250);
  }
  
  public final String getLogTag()
  {
    return "MicroMsg.Mvvm.AddressLiveList";
  }
  
  public final List<d> hF(List<d> paramList)
  {
    AppMethodBeat.i(253267);
    s.u(paramList, "snapshotList");
    p.N(paramList);
    Object localObject = "";
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if ((locald.type == 2) || (locald.type == 1))
      {
        String str = locald.FWw;
        if (!s.p(str, localObject))
        {
          locald.FWu = true;
          localObject = str;
        }
        else
        {
          locald.FWu = false;
        }
      }
      else
      {
        locald.FWu = false;
      }
    }
    localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add((d)((d)((Iterator)localObject).next()).gsx());
    }
    paramList = (List)paramList;
    AppMethodBeat.o(253267);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.address.AddressLiveList
 * JD-Core Version:    0.7.0.1
 */