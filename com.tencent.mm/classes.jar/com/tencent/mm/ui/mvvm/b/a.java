package com.tencent.mm.ui.mvvm.b;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mvvmbase.BaseMvvmActivity;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.mvvm.datasource.SelectContactSearchDataSource;
import com.tencent.mm.ui.mvvm.item.SelectContactLiveList;
import com.tencent.mm.ui.mvvm.item.SelectContactSearchLiveList;
import com.tencent.mm.view.recyclerview.WxLinearLayoutManager;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/uic/BaseSelectContactLiveListUIC;", "Lcom/tencent/mm/plugin/mvvmbase/BaseMvvmUIC;", "Lcom/tencent/mm/ui/mvvm/uic/SelectContactLiveListApiUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "adapter", "Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveItem;", "getAdapter", "()Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "dataSource", "Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "getDataSource", "()Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;", "dataSource$delegate", "favorDataSource", "Lcom/tencent/mm/ui/mvvm/datasource/SelectContactFavorDataSource;", "getFavorDataSource", "()Lcom/tencent/mm/ui/mvvm/datasource/SelectContactFavorDataSource;", "favorDataSource$delegate", "layoutManager", "Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;", "getLayoutManager", "()Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;", "layoutManager$delegate", "liveList", "Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveList;", "getLiveList", "()Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveList;", "liveList$delegate", "normalDataSource", "Lcom/tencent/mm/ui/mvvm/datasource/SelectContactDataSource;", "getNormalDataSource", "()Lcom/tencent/mm/ui/mvvm/datasource/SelectContactDataSource;", "normalDataSource$delegate", "onItemClickListener", "com/tencent/mm/ui/mvvm/uic/BaseSelectContactLiveListUIC$onItemClickListener$2$1", "getOnItemClickListener", "()Lcom/tencent/mm/ui/mvvm/uic/BaseSelectContactLiveListUIC$onItemClickListener$2$1;", "onItemClickListener$delegate", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "kotlin.jvm.PlatformType", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "recyclerView$delegate", "searchAdapter", "getSearchAdapter", "searchAdapter$delegate", "searchDataSource", "Lcom/tencent/mm/ui/mvvm/datasource/SelectContactSearchDataSource;", "getSearchDataSource", "()Lcom/tencent/mm/ui/mvvm/datasource/SelectContactSearchDataSource;", "searchDataSource$delegate", "searchLayoutManager", "getSearchLayoutManager", "searchLayoutManager$delegate", "searchLiveList", "Lcom/tencent/mm/ui/mvvm/item/SelectContactSearchLiveList;", "getSearchLiveList", "()Lcom/tencent/mm/ui/mvvm/item/SelectContactSearchLiveList;", "searchLiveList$delegate", "searchRecyclerView", "getSearchRecyclerView", "searchRecyclerView$delegate", "buildItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initHeaderView", "", "isContact", "", "username", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
  extends com.tencent.mm.plugin.mvvmbase.a
  implements d
{
  private final j CNQ;
  final j DHL;
  private final j DHM;
  private final j EKZ;
  private final j FWi;
  private final j FWm;
  final j afBj;
  final j afBk;
  private final j afBl;
  private final j afBm;
  private final j afBn;
  private final j afBo;
  private final j xZP;
  
  public a(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(250626);
    this.afBj = kotlin.k.cm((kotlin.g.a.a)new d(paramAppCompatActivity));
    this.afBk = kotlin.k.cm((kotlin.g.a.a)new g(paramAppCompatActivity));
    this.DHL = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.DHM = kotlin.k.cm((kotlin.g.a.a)new l(paramAppCompatActivity));
    this.EKZ = kotlin.k.cm((kotlin.g.a.a)new e(paramAppCompatActivity));
    this.afBl = kotlin.k.cm((kotlin.g.a.a)new m(paramAppCompatActivity));
    this.FWi = kotlin.k.cm((kotlin.g.a.a)new f(this, paramAppCompatActivity));
    this.afBm = kotlin.k.cm((kotlin.g.a.a)new n(this, paramAppCompatActivity));
    this.CNQ = kotlin.k.cm((kotlin.g.a.a)new j(this));
    this.afBn = kotlin.k.cm((kotlin.g.a.a)new o(this));
    this.xZP = kotlin.k.cm((kotlin.g.a.a)new a(this));
    this.afBo = kotlin.k.cm((kotlin.g.a.a)new k(this));
    this.FWm = kotlin.k.cm((kotlin.g.a.a)new i(this));
    AppMethodBeat.o(250626);
  }
  
  public final com.tencent.mm.plugin.mvvmlist.g<com.tencent.mm.ui.mvvm.item.b> fcp()
  {
    AppMethodBeat.i(250677);
    com.tencent.mm.plugin.mvvmlist.g localg = (com.tencent.mm.plugin.mvvmlist.g)this.xZP.getValue();
    AppMethodBeat.o(250677);
    return localg;
  }
  
  public final WxLinearLayoutManager fcq()
  {
    AppMethodBeat.i(250648);
    WxLinearLayoutManager localWxLinearLayoutManager = (WxLinearLayoutManager)this.EKZ.getValue();
    AppMethodBeat.o(250648);
    return localWxLinearLayoutManager;
  }
  
  public final WxRecyclerView getRecyclerView()
  {
    AppMethodBeat.i(250672);
    WxRecyclerView localWxRecyclerView = (WxRecyclerView)this.CNQ.getValue();
    AppMethodBeat.o(250672);
    return localWxRecyclerView;
  }
  
  public void initHeaderView()
  {
    AppMethodBeat.i(250690);
    View localView = LayoutInflater.from((Context)getActivity()).inflate(com.tencent.mm.plugin.selectcontact.a.f.contact_header, (ViewGroup)getRecyclerView(), false);
    com.tencent.mm.view.recyclerview.i locali = (com.tencent.mm.view.recyclerview.i)fcp();
    s.s(localView, "holderView");
    com.tencent.mm.view.recyclerview.i.a(locali, localView, localView.hashCode());
    localView = LayoutInflater.from((Context)getActivity()).inflate(com.tencent.mm.plugin.selectcontact.a.f.contact_header, (ViewGroup)getRecyclerView(), false);
    locali = (com.tencent.mm.view.recyclerview.i)jCe();
    s.s(localView, "searchHolderView");
    com.tencent.mm.view.recyclerview.i.a(locali, localView, localView.hashCode());
    AppMethodBeat.o(250690);
  }
  
  public final SelectContactSearchDataSource jBZ()
  {
    AppMethodBeat.i(250643);
    SelectContactSearchDataSource localSelectContactSearchDataSource = (SelectContactSearchDataSource)this.DHM.getValue();
    AppMethodBeat.o(250643);
    return localSelectContactSearchDataSource;
  }
  
  public final WxLinearLayoutManager jCa()
  {
    AppMethodBeat.i(250655);
    WxLinearLayoutManager localWxLinearLayoutManager = (WxLinearLayoutManager)this.afBl.getValue();
    AppMethodBeat.o(250655);
    return localWxLinearLayoutManager;
  }
  
  public final SelectContactLiveList jCb()
  {
    AppMethodBeat.i(250664);
    SelectContactLiveList localSelectContactLiveList = (SelectContactLiveList)this.FWi.getValue();
    AppMethodBeat.o(250664);
    return localSelectContactLiveList;
  }
  
  public final SelectContactSearchLiveList jCc()
  {
    AppMethodBeat.i(250667);
    SelectContactSearchLiveList localSelectContactSearchLiveList = (SelectContactSearchLiveList)this.afBm.getValue();
    AppMethodBeat.o(250667);
    return localSelectContactSearchLiveList;
  }
  
  public final WxRecyclerView jCd()
  {
    AppMethodBeat.i(250676);
    WxRecyclerView localWxRecyclerView = (WxRecyclerView)this.afBn.getValue();
    AppMethodBeat.o(250676);
    return localWxRecyclerView;
  }
  
  public final com.tencent.mm.plugin.mvvmlist.g<com.tencent.mm.ui.mvvm.item.b> jCe()
  {
    AppMethodBeat.i(250681);
    com.tencent.mm.plugin.mvvmlist.g localg = (com.tencent.mm.plugin.mvvmlist.g)this.afBo.getValue();
    AppMethodBeat.o(250681);
    return localg;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(250686);
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    s.s(com.tencent.mm.ui.component.k.d(getActivity()).q(c.class), "UICProvider.of(activity)…ntactDataUIC::class.java)");
    paramBundle = gst();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getStateCenter();
      if (paramBundle != null) {
        paramBundle.observe((q)getActivity(), (kotlin.g.a.b)new h(this));
      }
    }
    AppMethodBeat.o(250686);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.mvvmlist.g<com.tencent.mm.ui.mvvm.item.b>>
  {
    a(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/mvvm/uic/BaseSelectContactLiveListUIC$buildItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.view.recyclerview.g
  {
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(250579);
      if (paramInt == 11)
      {
        localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.ui.mvvm.item.c();
        AppMethodBeat.o(250579);
        return localf;
      }
      com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.ui.mvvm.item.a();
      AppMethodBeat.o(250579);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;", "Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveItem;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.mvvmlist.a.f<com.tencent.mm.ui.mvvm.item.b, com.tencent.mm.plugin.mvvmlist.a.c<com.tencent.mm.ui.mvvm.item.b>, com.tencent.mm.plugin.mvvmlist.a.d<com.tencent.mm.ui.mvvm.item.b>>>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/mvvm/datasource/SelectContactFavorDataSource;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<com.tencent.mm.ui.mvvm.datasource.b>
  {
    d(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<WxLinearLayoutManager>
  {
    e(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveList;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<SelectContactLiveList>
  {
    f(a parama, AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/mvvm/datasource/SelectContactDataSource;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<com.tencent.mm.ui.mvvm.datasource.a>
  {
    g(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "state", "Lcom/tencent/mm/ui/mvvm/state/SelectContactState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.b<com.tencent.mm.ui.mvvm.a.i, ah>
  {
    h(a parama)
    {
      super();
    }
    
    private static final boolean a(a parama, View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(250570);
      s.u(parama, "this$0");
      parama = parama.gst();
      if (parama != null) {
        parama.hideVKB();
      }
      AppMethodBeat.o(250570);
      return false;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Ljava/util/ArrayList;", "Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveItem;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<ArrayList<com.tencent.mm.ui.mvvm.item.b>, ah>
    {
      a(com.tencent.mm.ui.mvvm.a.i parami)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Ljava/util/ArrayList;", "Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveItem;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.b<ArrayList<com.tencent.mm.ui.mvvm.item.b>, ah>
    {
      b(com.tencent.mm.ui.mvvm.a.i parami)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Ljava/util/ArrayList;", "Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveItem;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements kotlin.g.a.b<ArrayList<com.tencent.mm.ui.mvvm.item.b>, ah>
    {
      c(com.tencent.mm.ui.mvvm.a.i parami)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "com/tencent/mm/ui/mvvm/uic/BaseSelectContactLiveListUIC$onItemClickListener$2$1"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<1>
  {
    i(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<WxRecyclerView>
  {
    j(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.mvvmlist.g<com.tencent.mm.ui.mvvm.item.b>>
  {
    k(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/mvvm/datasource/SelectContactSearchDataSource;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<SelectContactSearchDataSource>
  {
    l(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.a<WxLinearLayoutManager>
  {
    m(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/mvvm/item/SelectContactSearchLiveList;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.a<SelectContactSearchLiveList>
  {
    n(a parama, AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.a<WxRecyclerView>
  {
    o(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.mvvm.b.a
 * JD-Core Version:    0.7.0.1
 */