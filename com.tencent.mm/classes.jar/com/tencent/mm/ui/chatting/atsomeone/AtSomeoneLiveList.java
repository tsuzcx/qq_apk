package com.tencent.mm.ui.chatting.atsomeone;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mvvmlist.MMSearchLiveList;
import com.tencent.mm.plugin.mvvmlist.a.b;
import com.tencent.mm.plugin.mvvmlist.a.c;
import com.tencent.mm.plugin.mvvmlist.a.d;
import com.tencent.mm.plugin.mvvmlist.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneLiveList;", "Lcom/tencent/mm/plugin/mvvmlist/MMSearchLiveList;", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneLiveItem;", "", "dataSource", "Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "searchDataSource", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseSearchDataSource;", "config", "Lcom/tencent/mm/plugin/mvvmlist/MvvmListConfig;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseSearchDataSource;Lcom/tencent/mm/plugin/mvvmlist/MvvmListConfig;Landroidx/lifecycle/LifecycleOwner;)V", "showHeadList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getShowHeadList", "()Ljava/util/ArrayList;", "getLogTag", "handleSnapshotList", "", "snapshotList", "", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AtSomeoneLiveList
  extends MMSearchLiveList<f, String>
{
  public static final AtSomeoneLiveList.a aenG;
  final ArrayList<String> FWy;
  
  static
  {
    AppMethodBeat.i(254207);
    aenG = new AtSomeoneLiveList.a((byte)0);
    AppMethodBeat.o(254207);
  }
  
  public AtSomeoneLiveList(com.tencent.mm.plugin.mvvmlist.a.f<f, c<f>, d<f>> paramf, b<f, String> paramb, e parame, q paramq)
  {
    super(paramf, paramb, parame, paramq);
    AppMethodBeat.i(254201);
    this.FWy = new ArrayList();
    AppMethodBeat.o(254201);
  }
  
  public final String getLogTag()
  {
    return "MicroMsg.Mvvm.AtSomeoneLiveList";
  }
  
  public final List<f> hF(List<f> paramList)
  {
    AppMethodBeat.i(254212);
    s.u(paramList, "snapshotList");
    p.N(paramList);
    this.FWy.clear();
    this.FWy.add("🔍");
    Object localObject = "";
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      if (localf.type == 2)
      {
        if (!s.p(localf.FWw, localObject))
        {
          localf.FWu = true;
          localObject = localf.FWw;
          this.FWy.add(localObject);
        }
        else
        {
          localf.FWu = false;
        }
      }
      else {
        localf.FWu = false;
      }
    }
    localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add((f)((f)((Iterator)localObject).next()).gsx());
    }
    paramList = (List)paramList;
    AppMethodBeat.o(254212);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.atsomeone.AtSomeoneLiveList
 * JD-Core Version:    0.7.0.1
 */