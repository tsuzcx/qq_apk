package com.tencent.mm.ui.contact.address;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.livelist.MMLiveList;
import com.tencent.mm.plugin.livelist.a.c;
import com.tencent.mm.plugin.livelist.a.e;
import com.tencent.mm.plugin.livelist.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/contact/address/AddressLiveList;", "Lcom/tencent/mm/plugin/livelist/MMLiveList;", "Lcom/tencent/mm/ui/contact/address/AddressLiveListItem;", "dataSource", "Lcom/tencent/mm/plugin/livelist/datasource/IDataSource;", "Lcom/tencent/mm/plugin/livelist/datasource/DataRequest;", "Lcom/tencent/mm/plugin/livelist/datasource/DataResponse;", "config", "Lcom/tencent/mm/plugin/livelist/MMLiveListConfig;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Lcom/tencent/mm/plugin/livelist/datasource/IDataSource;Lcom/tencent/mm/plugin/livelist/MMLiveListConfig;Landroidx/lifecycle/LifecycleOwner;)V", "getLogTag", "", "handleSnapshotList", "", "snapshotList", "", "Companion", "app_release"})
public final class AddressLiveList
  extends MMLiveList<d>
{
  public static final AddressLiveList.a Xxc;
  
  static
  {
    AppMethodBeat.i(290531);
    Xxc = new AddressLiveList.a((byte)0);
    AppMethodBeat.o(290531);
  }
  
  public AddressLiveList(e<d, c<d>, com.tencent.mm.plugin.livelist.a.d<d>> parame, f paramf, androidx.lifecycle.l paraml)
  {
    super(parame, paramf, paraml);
    AppMethodBeat.i(290530);
    AppMethodBeat.o(290530);
  }
  
  public final List<d> fJ(List<d> paramList)
  {
    AppMethodBeat.i(290529);
    p.k(paramList, "snapshotList");
    j.lm(paramList);
    Object localObject1 = "";
    Iterator localIterator = ((Iterable)paramList).iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if ((locald.type == 2) || (locald.type == 1))
      {
        localObject2 = locald.WGn;
        if ((p.h(localObject2, localObject1) ^ true))
        {
          locald.WGl = true;
          localObject1 = localObject2;
        }
        else
        {
          locald.WGl = false;
        }
      }
      else
      {
        locald.WGl = false;
      }
    }
    localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((d)((Iterator)localObject1).next()).eLO();
      if (localObject2 == null)
      {
        paramList = new t("null cannot be cast to non-null type com.tencent.mm.ui.contact.address.AddressLiveListItem");
        AppMethodBeat.o(290529);
        throw paramList;
      }
      paramList.add((d)localObject2);
    }
    paramList = (List)paramList;
    AppMethodBeat.o(290529);
    return paramList;
  }
  
  public final String getLogTag()
  {
    return "MicroMsg.Mvvm.AddressLiveList";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.address.AddressLiveList
 * JD-Core Version:    0.7.0.1
 */