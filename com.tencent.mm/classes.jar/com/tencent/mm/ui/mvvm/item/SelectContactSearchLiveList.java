package com.tencent.mm.ui.mvvm.item;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mvvmlist.MMSearchLiveList;
import com.tencent.mm.plugin.mvvmlist.a.c;
import com.tencent.mm.plugin.mvvmlist.a.d;
import com.tencent.mm.plugin.mvvmlist.a.f;
import com.tencent.mm.plugin.mvvmlist.e;
import com.tencent.mm.ui.mvvm.a.g;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/item/SelectContactSearchLiveList;", "Lcom/tencent/mm/plugin/mvvmlist/MMSearchLiveList;", "Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveItem;", "Lcom/tencent/mm/ui/mvvm/state/SearchQueryActionResult;", "dataSource", "Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "searchDataSource", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseSearchDataSource;", "config", "Lcom/tencent/mm/plugin/mvvmlist/MvvmListConfig;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseSearchDataSource;Lcom/tencent/mm/plugin/mvvmlist/MvvmListConfig;Landroidx/lifecycle/LifecycleOwner;)V", "getLogTag", "", "Companion", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SelectContactSearchLiveList
  extends MMSearchLiveList<b, g>
{
  public static final SelectContactSearchLiveList.a afAR;
  
  static
  {
    AppMethodBeat.i(250526);
    afAR = new SelectContactSearchLiveList.a((byte)0);
    AppMethodBeat.o(250526);
  }
  
  public SelectContactSearchLiveList(f<b, c<b>, d<b>> paramf, com.tencent.mm.plugin.mvvmlist.a.b<b, g> paramb, e parame, q paramq)
  {
    super(paramf, paramb, parame, paramq);
    AppMethodBeat.i(250521);
    AppMethodBeat.o(250521);
  }
  
  public final String getLogTag()
  {
    return "MicroMsg.SelectContact.SelectContactLiveList";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.mvvm.item.SelectContactSearchLiveList
 * JD-Core Version:    0.7.0.1
 */