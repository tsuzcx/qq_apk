package com.tencent.mm.ui.mvvm.datasource;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.mvvmlist.MvvmList;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.statecenter.IStateAction;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.mvvm.a.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.a.f;
import kotlinx.coroutines.a.q;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/datasource/SelectContactSearchDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseSearchDataSource;", "Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveItem;", "Lcom/tencent/mm/ui/mvvm/state/SearchQueryActionResult;", "Landroidx/lifecycle/LifecycleObserver;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "currentSearchTaskList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/fts/api/model/BaseFTSTask;", "Lkotlin/collections/ArrayList;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "Lkotlin/Lazy;", "searchResultCache", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/fts/api/model/FTSResult;", "Lkotlin/collections/HashMap;", "getSearchResultCache", "()Ljava/util/HashMap;", "destroy", "", "getSearchData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "dataRequest", "Lcom/tencent/mm/plugin/mvvmlist/SearchDataRequest;", "stateCenter", "Lcom/tencent/mm/sdk/statecenter/UIStateCenter;", "Lcom/tencent/mm/ui/mvvm/state/SelectContactState;", "stopSearch", "Companion", "FTSResultListener", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SelectContactSearchDataSource
  extends com.tencent.mm.plugin.mvvmlist.a.b<com.tencent.mm.ui.mvvm.item.b, com.tencent.mm.ui.mvvm.a.g>
  implements androidx.lifecycle.p
{
  public static final SelectContactSearchDataSource.a afAz;
  final AppCompatActivity activity;
  private ArrayList<com.tencent.mm.plugin.fts.a.a.c> afAA;
  public final HashMap<Integer, com.tencent.mm.plugin.fts.a.a.m> afAB;
  private final kotlin.j rdm;
  
  static
  {
    AppMethodBeat.i(250682);
    afAz = new SelectContactSearchDataSource.a((byte)0);
    AppMethodBeat.o(250682);
  }
  
  public SelectContactSearchDataSource(AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(250668);
    this.activity = paramAppCompatActivity;
    this.rdm = kotlin.k.cm((kotlin.g.a.a)SelectContactSearchDataSource.e.afAK);
    this.afAA = new ArrayList();
    this.afAB = new HashMap();
    AppMethodBeat.o(250668);
  }
  
  private final MMHandler getHandler()
  {
    AppMethodBeat.i(250674);
    MMHandler localMMHandler = (MMHandler)this.rdm.getValue();
    AppMethodBeat.o(250674);
    return localMMHandler;
  }
  
  public final kotlinx.coroutines.b.g<com.tencent.mm.plugin.mvvmlist.a.d<com.tencent.mm.ui.mvvm.item.b>> a(LifecycleScope paramLifecycleScope, final com.tencent.mm.plugin.mvvmlist.h<com.tencent.mm.ui.mvvm.item.b, com.tencent.mm.ui.mvvm.a.g> paramh)
  {
    AppMethodBeat.i(250699);
    s.u(paramLifecycleScope, "scope");
    s.u(paramh, "dataRequest");
    Object localObject1 = ((Iterable)this.afAA).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject1).next();
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask((com.tencent.mm.plugin.fts.a.a.c)localObject2);
    }
    this.afAA.clear();
    this.afAB.clear();
    if (((com.tencent.mm.ui.mvvm.a.g)paramh.Mnu).afAD)
    {
      localObject1 = new q();
      localObject2 = new com.tencent.mm.plugin.mvvmlist.a.d((com.tencent.mm.plugin.mvvmlist.a.c)paramh);
      Object localObject3 = (Iterable)((com.tencent.mm.ui.mvvm.a.g)paramh.Mnu).Hti;
      int i = 0;
      localObject3 = ((Iterable)localObject3).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = ((Iterator)localObject3).next();
        if (i < 0) {
          kotlin.a.p.kkW();
        }
        Object localObject5 = (String)localObject4;
        if (!kotlin.n.n.bp((CharSequence)localObject5)) {}
        for (int j = 1;; j = 0)
        {
          if (j != 0)
          {
            localObject4 = new q();
            com.tencent.mm.plugin.fts.a.a.l locall = new com.tencent.mm.plugin.fts.a.a.l();
            locall.query = ((String)localObject5);
            locall.qRb = 16;
            locall.HtB = ((Comparator)com.tencent.mm.plugin.fts.a.c.b.Hue);
            locall.handler = getHandler();
            locall.Htx = new int[] { 131072 };
            locall.HtC = ((com.tencent.mm.plugin.fts.a.l)new b((com.tencent.mm.plugin.mvvmlist.a.c)paramh, (q)localObject4, i, true));
            locall.HtA.add(com.tencent.mm.model.z.bAM());
            localObject5 = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).search(2, locall);
            this.afAA.add(localObject5);
            LifecycleScope.launchDefault$default(paramLifecycleScope, null, (kotlin.g.a.m)new c((q)localObject4, (com.tencent.mm.plugin.mvvmlist.a.d)localObject2, (q)localObject1, this, paramh, null), 1, null);
          }
          i += 1;
          break;
        }
      }
      paramh = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.ui.mvvm.b.d)com.tencent.mm.ui.component.k.d(this.activity).cq(com.tencent.mm.ui.mvvm.b.d.class)).gNg().aB((kotlin.g.a.b)new d(paramLifecycleScope, (com.tencent.mm.plugin.mvvmlist.a.d)localObject2, (q)localObject1));
      paramLifecycleScope = kotlinx.coroutines.b.k.a((f)localObject1);
      AppMethodBeat.o(250699);
      return paramLifecycleScope;
    }
    paramLifecycleScope = new q();
    localObject1 = new com.tencent.mm.plugin.fts.a.a.l();
    ((com.tencent.mm.plugin.fts.a.a.l)localObject1).query = ((com.tencent.mm.ui.mvvm.a.g)paramh.Mnu).Hte;
    ((com.tencent.mm.plugin.fts.a.a.l)localObject1).qRb = 16;
    ((com.tencent.mm.plugin.fts.a.a.l)localObject1).HtB = ((Comparator)com.tencent.mm.plugin.fts.a.c.b.Hue);
    ((com.tencent.mm.plugin.fts.a.a.l)localObject1).handler = getHandler();
    ((com.tencent.mm.plugin.fts.a.a.l)localObject1).Htx = new int[] { 131072, 131081 };
    ((com.tencent.mm.plugin.fts.a.a.l)localObject1).HtC = ((com.tencent.mm.plugin.fts.a.l)new b((com.tencent.mm.plugin.mvvmlist.a.c)paramh, paramLifecycleScope));
    ((com.tencent.mm.plugin.fts.a.a.l)localObject1).HtA.add(com.tencent.mm.model.z.bAM());
    paramh = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).search(2, (com.tencent.mm.plugin.fts.a.a.l)localObject1);
    this.afAA.add(paramh);
    paramLifecycleScope = kotlinx.coroutines.b.k.a((f)paramLifecycleScope);
    AppMethodBeat.o(250699);
    return paramLifecycleScope;
  }
  
  @androidx.lifecycle.z(Ho=j.a.ON_DESTROY)
  public final void destroy()
  {
    AppMethodBeat.i(250688);
    Iterator localIterator = ((Iterable)this.afAA).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fts.a.a.c localc = (com.tencent.mm.plugin.fts.a.a.c)localIterator.next();
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(localc);
    }
    this.afAA.clear();
    AppMethodBeat.o(250688);
  }
  
  public final void eui()
  {
    AppMethodBeat.i(250701);
    Iterator localIterator = ((Iterable)this.afAA).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.fts.a.a.c localc = (com.tencent.mm.plugin.fts.a.a.c)localIterator.next();
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(localc);
    }
    this.afAA.clear();
    AppMethodBeat.o(250701);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/datasource/SelectContactSearchDataSource$FTSResultListener;", "Lcom/tencent/mm/plugin/fts/api/IFTSResultListener;", "request", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveItem;", "channel", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "keywordIndex", "", "multiSearch", "", "(Lcom/tencent/mm/ui/mvvm/datasource/SelectContactSearchDataSource;Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;IZ)V", "getChannel", "()Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "getKeywordIndex", "()I", "getMultiSearch", "()Z", "getRequest", "()Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "onFTSSearchEnd", "", "result", "Lcom/tencent/mm/plugin/fts/api/model/FTSResult;", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements com.tencent.mm.plugin.fts.a.l
  {
    private final com.tencent.mm.plugin.mvvmlist.a.c<com.tencent.mm.ui.mvvm.item.b> DHT;
    private final int afAC;
    private final boolean afAD;
    private final q<com.tencent.mm.plugin.mvvmlist.a.d<com.tencent.mm.ui.mvvm.item.b>> ovy;
    
    public b(q<com.tencent.mm.plugin.mvvmlist.a.d<com.tencent.mm.ui.mvvm.item.b>> paramq, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(250640);
      this.DHT = paramq;
      this.ovy = paramInt;
      this.afAC = paramBoolean;
      boolean bool;
      this.afAD = bool;
      AppMethodBeat.o(250640);
    }
    
    public final void b(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      AppMethodBeat.i(250669);
      Object localObject1;
      if (paramm != null)
      {
        localObject1 = ((Iterable)SelectContactSearchDataSource.a(SelectContactSearchDataSource.this)).iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
        } while (!s.p((com.tencent.mm.plugin.fts.a.a.c)((Iterator)localObject1).next(), paramm.HtE));
      }
      for (int i = 1;; i = 0)
      {
        SelectContactSearchDataSource localSelectContactSearchDataSource;
        com.tencent.mm.plugin.mvvmlist.a.d locald;
        label152:
        Object localObject3;
        label173:
        ArrayList localArrayList;
        com.tencent.mm.ui.mvvm.item.b localb;
        label291:
        boolean bool;
        if (i != 0)
        {
          localObject1 = paramm;
          if (localObject1 == null) {
            break label658;
          }
          localSelectContactSearchDataSource = SelectContactSearchDataSource.this;
          if (paramm.resultCode != 0) {
            break label658;
          }
          localObject1 = com.tencent.mm.ui.component.k.aeZF;
          s.s(com.tencent.mm.ui.component.k.d(localSelectContactSearchDataSource.activity).q(com.tencent.mm.ui.mvvm.b.c.class), "UICProvider.of(activity)…ntactDataUIC::class.java)");
          locald = new com.tencent.mm.plugin.mvvmlist.a.d(this.DHT);
          if ((!this.afAD) || (paramm.HtF.size() <= 3)) {
            break label404;
          }
          localObject1 = paramm.HtF.subList(0, 3);
          s.s(localObject1, "showList");
          localObject3 = ((Iterable)localObject1).iterator();
          i = 0;
          if (!((Iterator)localObject3).hasNext()) {
            break label514;
          }
          localObject1 = ((Iterator)localObject3).next();
          if (i < 0) {
            kotlin.a.p.kkW();
          }
          o localo = (o)localObject1;
          localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(localo.Hsz);
          localArrayList = locald.pUj;
          s.s(localObject1, "contact");
          localb = new com.tencent.mm.ui.mvvm.item.b((au)localObject1, 10, 0);
          if ((i == 0) && (this.afAD))
          {
            localb.FWu = true;
            localObject1 = paramm.FWt;
            if (localObject1 != null) {
              break label413;
            }
            localObject1 = "";
            localb.bCq((String)localObject1);
          }
          localb.rpp = localo;
          localb.FWt = paramm.FWt;
          localObject1 = SelectContactSearchDataSource.b(localSelectContactSearchDataSource);
          if (localObject1 != null) {
            break label436;
          }
          bool = false;
          label328:
          localb.afey = bool;
          localObject1 = SelectContactSearchDataSource.b(localSelectContactSearchDataSource);
          if (localObject1 != null) {
            break label465;
          }
          bool = false;
        }
        label404:
        label413:
        Object localObject2;
        for (;;)
        {
          localb.wwJ = bool;
          localb.afAC = this.afAC;
          localb.afAN = i;
          localb.afAD = this.afAD;
          localObject1 = ah.aiuX;
          localArrayList.add(localb);
          i += 1;
          break label173;
          localObject1 = null;
          break;
          localObject1 = paramm.HtF;
          break label152;
          localObject2 = ((com.tencent.mm.plugin.fts.a.a.j)localObject1).Hte;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label291;
          }
          localObject1 = "";
          break label291;
          label436:
          localObject1 = (i)((UIStateCenter)localObject1).getState();
          if (localObject1 == null)
          {
            bool = false;
            break label328;
          }
          bool = ((i)localObject1).gZe();
          break label328;
          label465:
          localObject1 = (i)((UIStateCenter)localObject1).getState();
          if (localObject1 == null)
          {
            bool = false;
          }
          else
          {
            localObject2 = localb.contact.field_username;
            s.s(localObject2, "it.contact.username");
            bool = ((i)localObject1).bCr((String)localObject2);
          }
        }
        label514:
        if ((this.afAD) && (paramm.HtF.size() > 3))
        {
          localObject2 = new au();
          ((au)localObject2).setUsername(this.afAC + "_collapse");
          localObject1 = locald.pUj;
          localObject2 = new com.tencent.mm.ui.mvvm.item.b((au)localObject2, 11, 0);
          ((com.tencent.mm.ui.mvvm.item.b)localObject2).afAC = this.afAC;
          ((com.tencent.mm.ui.mvvm.item.b)localObject2).afAN = 2147483647;
          ((com.tencent.mm.ui.mvvm.item.b)localObject2).afAD = this.afAD;
          localObject3 = ah.aiuX;
          ((ArrayList)localObject1).add(localObject2);
        }
        localSelectContactSearchDataSource.afAB.put(Integer.valueOf(this.afAC), paramm);
        this.ovy.offer(locald);
        label658:
        AppMethodBeat.o(250669);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    c(q<com.tencent.mm.plugin.mvvmlist.a.d<com.tencent.mm.ui.mvvm.item.b>> paramq1, com.tencent.mm.plugin.mvvmlist.a.d<com.tencent.mm.ui.mvvm.item.b> paramd, q<com.tencent.mm.plugin.mvvmlist.a.d<com.tencent.mm.ui.mvvm.item.b>> paramq2, SelectContactSearchDataSource paramSelectContactSearchDataSource, com.tencent.mm.plugin.mvvmlist.h<com.tencent.mm.ui.mvvm.item.b, com.tencent.mm.ui.mvvm.a.g> paramh, kotlin.d.d<? super c> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(250645);
      paramObject = (kotlin.d.d)new c(this.ovx, this.MnC, this.afAF, jdField_this, paramh, paramd);
      AppMethodBeat.o(250645);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(250639);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(250639);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = kotlinx.coroutines.b.k.a((f)this.ovx);
        kotlinx.coroutines.b.h localh = (kotlinx.coroutines.b.h)new a(this.MnC, this.afAF, jdField_this, paramh);
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (paramObject.a(localh, locald) == locala)
        {
          AppMethodBeat.o(250639);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(250639);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements kotlinx.coroutines.b.h<com.tencent.mm.plugin.mvvmlist.a.d<com.tencent.mm.ui.mvvm.item.b>>
    {
      public a(com.tencent.mm.plugin.mvvmlist.a.d paramd, q paramq, SelectContactSearchDataSource paramSelectContactSearchDataSource, com.tencent.mm.plugin.mvvmlist.h paramh) {}
      
      public final Object a(com.tencent.mm.plugin.mvvmlist.a.d<com.tencent.mm.ui.mvvm.item.b> paramd, kotlin.d.d<? super ah> paramd1)
      {
        AppMethodBeat.i(250660);
        paramd = (com.tencent.mm.plugin.mvvmlist.a.d)paramd;
        this.MnE.pUj.addAll((Collection)paramd.pUj);
        this.afAH.offer(this.MnE);
        paramd = SelectContactSearchDataSource.b(this.afAE);
        if (paramd == null) {}
        for (paramd = null; paramd == kotlin.d.a.a.aiwj; paramd = ah.aiuX)
        {
          AppMethodBeat.o(250660);
          return paramd;
          paramd.dispatch((IStateAction)new com.tencent.mm.ui.mvvm.a.c(((com.tencent.mm.ui.mvvm.a.g)this.afAI.Mnu).mpa, ((com.tencent.mm.ui.mvvm.a.g)this.afAI.Mnu).Hte, ((com.tencent.mm.ui.mvvm.a.g)this.afAI.Mnu).Hti, this.afAE.afAB));
        }
        paramd = ah.aiuX;
        AppMethodBeat.o(250660);
        return paramd;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "snapshotList", "", "Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<List<? extends com.tencent.mm.ui.mvvm.item.b>, ah>
  {
    d(LifecycleScope paramLifecycleScope, com.tencent.mm.plugin.mvvmlist.a.d<com.tencent.mm.ui.mvvm.item.b> paramd, q<com.tencent.mm.plugin.mvvmlist.a.d<com.tencent.mm.ui.mvvm.item.b>> paramq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.mvvm.datasource.SelectContactSearchDataSource
 * JD-Core Version:    0.7.0.1
 */