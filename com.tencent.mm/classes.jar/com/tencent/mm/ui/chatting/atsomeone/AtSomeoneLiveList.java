package com.tencent.mm.ui.chatting.atsomeone;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.livelist.MMSearchLiveList;
import com.tencent.mm.plugin.livelist.a.b;
import com.tencent.mm.plugin.livelist.a.c;
import com.tencent.mm.plugin.livelist.a.d;
import com.tencent.mm.plugin.livelist.a.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneLiveList;", "Lcom/tencent/mm/plugin/livelist/MMSearchLiveList;", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneLiveItem;", "", "dataSource", "Lcom/tencent/mm/plugin/livelist/datasource/IDataSource;", "Lcom/tencent/mm/plugin/livelist/datasource/DataRequest;", "Lcom/tencent/mm/plugin/livelist/datasource/DataResponse;", "searchDataSource", "Lcom/tencent/mm/plugin/livelist/datasource/BaseSearchDataSource;", "config", "Lcom/tencent/mm/plugin/livelist/MMLiveListConfig;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Lcom/tencent/mm/plugin/livelist/datasource/IDataSource;Lcom/tencent/mm/plugin/livelist/datasource/BaseSearchDataSource;Lcom/tencent/mm/plugin/livelist/MMLiveListConfig;Landroidx/lifecycle/LifecycleOwner;)V", "showHeadList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getShowHeadList", "()Ljava/util/ArrayList;", "getLogTag", "handleSnapshotList", "", "snapshotList", "", "Companion", "app_release"})
public final class AtSomeoneLiveList
  extends MMSearchLiveList<f, String>
{
  public static final AtSomeoneLiveList.a WGq;
  final ArrayList<String> WGp;
  
  static
  {
    AppMethodBeat.i(288394);
    WGq = new AtSomeoneLiveList.a((byte)0);
    AppMethodBeat.o(288394);
  }
  
  public AtSomeoneLiveList(e<f, c<f>, d<f>> parame, b<f, String> paramb, com.tencent.mm.plugin.livelist.f paramf, androidx.lifecycle.l paraml)
  {
    super(parame, paramb, paramf, paraml);
    AppMethodBeat.i(288393);
    this.WGp = new ArrayList();
    AppMethodBeat.o(288393);
  }
  
  public final List<f> fJ(List<f> paramList)
  {
    AppMethodBeat.i(288391);
    p.k(paramList, "snapshotList");
    j.lm(paramList);
    this.WGp.clear();
    this.WGp.add("🔍");
    Object localObject1 = "";
    Object localObject2 = ((Iterable)paramList).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      f localf = (f)((Iterator)localObject2).next();
      if (localf.type == 2)
      {
        if ((p.h(localf.WGn, localObject1) ^ true))
        {
          localf.WGl = true;
          localObject1 = localf.WGn;
          this.WGp.add(localObject1);
        }
        else
        {
          localf.WGl = false;
        }
      }
      else {
        localf.WGl = false;
      }
    }
    localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((f)((Iterator)localObject1).next()).eLO();
      if (localObject2 == null)
      {
        paramList = new t("null cannot be cast to non-null type com.tencent.mm.ui.chatting.atsomeone.AtSomeoneLiveItem");
        AppMethodBeat.o(288391);
        throw paramList;
      }
      paramList.add((f)localObject2);
    }
    paramList = (List)paramList;
    AppMethodBeat.o(288391);
    return paramList;
  }
  
  public final String getLogTag()
  {
    return "MicroMsg.Mvvm.AtSomeoneLiveList";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.atsomeone.AtSomeoneLiveList
 * JD-Core Version:    0.7.0.1
 */