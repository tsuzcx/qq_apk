package com.tencent.mm.ui.mvvm.b;

import com.tencent.mm.plugin.mvvmlist.MMSearchLiveList;
import com.tencent.mm.plugin.mvvmlist.MvvmList;
import com.tencent.mm.ui.component.c;
import com.tencent.mm.ui.mvvm.item.b;
import com.tencent.mm.view.recyclerview.WxLinearLayoutManager;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/uic/SelectContactLiveListApiUIC;", "Lcom/tencent/mm/ui/component/ApiUIC;", "adapter", "Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveItem;", "getAdapter", "()Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "layoutManager", "Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;", "getLayoutManager", "()Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;", "liveList", "Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "getLiveList", "()Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "searchAdapter", "getSearchAdapter", "searchLayoutManager", "getSearchLayoutManager", "searchLiveList", "Lcom/tencent/mm/plugin/mvvmlist/MMSearchLiveList;", "Lcom/tencent/mm/ui/mvvm/state/SearchQueryActionResult;", "getSearchLiveList", "()Lcom/tencent/mm/plugin/mvvmlist/MMSearchLiveList;", "searchRecyclerView", "getSearchRecyclerView", "isContact", "", "username", "", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface d
  extends c
{
  public abstract com.tencent.mm.plugin.mvvmlist.g<b> fcp();
  
  public abstract WxLinearLayoutManager fcq();
  
  public abstract MvvmList<b> gNg();
  
  public abstract WxRecyclerView getRecyclerView();
  
  public abstract WxLinearLayoutManager jCa();
  
  public abstract WxRecyclerView jCd();
  
  public abstract com.tencent.mm.plugin.mvvmlist.g<b> jCe();
  
  public abstract MMSearchLiveList<b, com.tencent.mm.ui.mvvm.a.g> jCf();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.mvvm.b.d
 * JD-Core Version:    0.7.0.1
 */