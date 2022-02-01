package com.tencent.mm.plugin.mvvmlist;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mvvmlist.a.c;
import com.tencent.mm.plugin.mvvmlist.a.f;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmlist/MMSearchLiveList;", "T", "Lcom/tencent/mm/plugin/mvvmlist/IMvvmListItem;", "Q", "Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "dataSource", "Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "searchDataSource", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseSearchDataSource;", "config", "Lcom/tencent/mm/plugin/mvvmlist/MvvmListConfig;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseSearchDataSource;Lcom/tencent/mm/plugin/mvvmlist/MvvmListConfig;Landroidx/lifecycle/LifecycleOwner;)V", "getSearchDataSource", "()Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseSearchDataSource;", "searchJob", "Lkotlinx/coroutines/Job;", "getSearchJob", "()Lkotlinx/coroutines/Job;", "setSearchJob", "(Lkotlinx/coroutines/Job;)V", "startSearch", "", "query", "(Ljava/lang/Object;)V", "stopSearch", "plugin-mvvmlist_release"}, k=1, mv={1, 5, 1}, xi=48)
public class MMSearchLiveList<T extends b<T>, Q>
  extends MvvmList<T>
{
  final com.tencent.mm.plugin.mvvmlist.a.b<T, Q> MmG;
  cb MmH;
  
  public MMSearchLiveList(f<T, c<T>, com.tencent.mm.plugin.mvvmlist.a.d<T>> paramf, com.tencent.mm.plugin.mvvmlist.a.b<T, Q> paramb, e parame, q paramq)
  {
    super(paramf, parame, paramq);
    AppMethodBeat.i(278813);
    this.MmG = paramb;
    AppMethodBeat.o(278813);
  }
  
  public final void eui()
  {
    AppMethodBeat.i(278824);
    this.MmG.eui();
    cb localcb = this.MmH;
    if (localcb != null) {
      localcb.a(null);
    }
    AppMethodBeat.o(278824);
  }
  
  public final void gd(final Q paramQ)
  {
    AppMethodBeat.i(278819);
    cb localcb = this.MmH;
    if ((localcb != null) && (localcb.isActive() == true)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localcb = this.MmH;
        if (localcb != null) {
          localcb.a(null);
        }
      }
      this.MmH = LifecycleScope.launchDefault$default(this.MmN, null, (m)new a(this, paramQ, null), 1, null);
      AppMethodBeat.o(278819);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/mvvmlist/IMvvmListItem;", "Q", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    a(MMSearchLiveList<T, Q> paramMMSearchLiveList, Q paramQ, kotlin.d.d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(278738);
      paramObject = (kotlin.d.d)new a(this.MmI, paramQ, paramd);
      AppMethodBeat.o(278738);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(278737);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(278737);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.MmI.MmG.a(this.MmI.MmN, (c)new h(paramQ, this.MmI.MmM.pageSize));
        kotlinx.coroutines.b.h localh = (kotlinx.coroutines.b.h)new a(this.MmI);
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (paramObject.a(localh, locald) == locala)
        {
          AppMethodBeat.o(278737);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(278737);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements kotlinx.coroutines.b.h<com.tencent.mm.plugin.mvvmlist.a.d<T>>
    {
      public a(MMSearchLiveList paramMMSearchLiveList) {}
      
      public final Object a(com.tencent.mm.plugin.mvvmlist.a.d<T> paramd, kotlin.d.d<? super ah> paramd1)
      {
        AppMethodBeat.i(278811);
        paramd = (com.tencent.mm.plugin.mvvmlist.a.d)paramd;
        this.MmI.jg((List)paramd.pUj);
        this.MmI.MmH = null;
        paramd = ah.aiuX;
        AppMethodBeat.o(278811);
        return paramd;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mvvmlist.MMSearchLiveList
 * JD-Core Version:    0.7.0.1
 */