package com.tencent.mm.plugin.mvvmlist.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mvvmlist.b;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.a.q;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmlist/datasource/MergeDataSource;", "T", "Lcom/tencent/mm/plugin/mvvmlist/IMvvmListItem;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "dataSource", "", "Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "([Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;)V", "getDataSource", "()[Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;", "[Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;", "dataSourceIndex", "", "dataSourceOffsetMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "sortDataSource", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "combine", "getData", "Lkotlinx/coroutines/flow/Flow;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "request", "getSingleData", "", "dataResponse", "channel", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "onCreate", "Companion", "plugin-mvvmlist_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g<T extends b<T>>
  extends a<T>
{
  public static final g.a Mnv;
  private final f<T, c<T>, d<T>>[] Mnw;
  private final ArrayList<f<T, c<T>, d<T>>> Mnx;
  private int Mny;
  private final HashMap<Integer, Integer> Mnz;
  
  static
  {
    AppMethodBeat.i(278796);
    Mnv = new g.a((byte)0);
    AppMethodBeat.o(278796);
  }
  
  public g(f<T, c<T>, d<T>>... paramVarArgs)
  {
    AppMethodBeat.i(278747);
    this.Mnw = paramVarArgs;
    this.Mnx = new ArrayList();
    p.a((Collection)this.Mnx, this.Mnw);
    paramVarArgs = (List)this.Mnx;
    if (paramVarArgs.size() > 1) {
      p.a(paramVarArgs, (Comparator)new c());
    }
    this.Mnz = new HashMap();
    AppMethodBeat.o(278747);
  }
  
  private final void a(final LifecycleScope paramLifecycleScope, final c<T> paramc, final d<T> paramd, final q<d<T>> paramq)
  {
    Object localObject = null;
    AppMethodBeat.i(278758);
    f localf = (f)p.ae((List)this.Mnx, this.Mny);
    if (localf == null) {}
    for (paramLifecycleScope = localObject;; paramLifecycleScope = j.a((aq)paramLifecycleScope, null, null, (m)new b(localf, paramLifecycleScope, paramc, paramd, this, paramq, null), 3))
    {
      if (paramLifecycleScope == null) {
        paramq.offer(paramd);
      }
      AppMethodBeat.o(278758);
      return;
    }
  }
  
  public final f<T, c<T>, d<T>> a(f<T, c<T>, d<T>> paramf)
  {
    AppMethodBeat.i(278829);
    s.u(paramf, "dataSource");
    ArrayList localArrayList = new ArrayList();
    if ((paramf instanceof g))
    {
      localArrayList.addAll((Collection)this.Mnx);
      localArrayList.addAll((Collection)((g)paramf).Mnx);
    }
    for (;;)
    {
      paramf = ((Collection)localArrayList).toArray(new f[0]);
      if (paramf != null) {
        break;
      }
      paramf = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(278829);
      throw paramf;
      localArrayList.add(paramf);
    }
    paramf = (f[])paramf;
    paramf = (f)new g((f[])Arrays.copyOf(paramf, paramf.length));
    AppMethodBeat.o(278829);
    return paramf;
  }
  
  public final kotlinx.coroutines.b.g<d<T>> a(LifecycleScope paramLifecycleScope, c<T> paramc)
  {
    AppMethodBeat.i(278817);
    s.u(paramLifecycleScope, "scope");
    s.u(paramc, "request");
    Log.i("MicroMsg.Mvvm.MergeDataSource", "getData request:" + paramc.offset + " dataSourceIndex:" + this.Mny + " dataSourceSize:" + this.Mnx.size());
    q localq = new q();
    int i = paramc.offset;
    Map localMap = (Map)this.Mnz;
    Integer localInteger = Integer.valueOf(this.Mny);
    Object localObject = localMap.get(localInteger);
    if (localObject == null)
    {
      localObject = Integer.valueOf(0);
      localMap.put(localInteger, localObject);
    }
    for (;;)
    {
      a(paramLifecycleScope, new c(i - ((Number)localObject).intValue(), paramc.pageSize), new d(paramc), localq);
      paramLifecycleScope = kotlinx.coroutines.b.k.a((kotlinx.coroutines.a.f)localq);
      AppMethodBeat.o(278817);
      return paramLifecycleScope;
    }
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(278808);
    this.Mny = 0;
    this.Mnz.clear();
    ((Map)this.Mnz).put(Integer.valueOf(0), Integer.valueOf(0));
    Iterator localIterator = ((Iterable)this.Mnx).iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).onCreate();
    }
    AppMethodBeat.o(278808);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/mvvmlist/IMvvmListItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(f<T, c<T>, d<T>> paramf, LifecycleScope paramLifecycleScope, c<T> paramc, d<T> paramd, g<T> paramg, q<d<T>> paramq, kotlin.d.d<? super b> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(278741);
      paramObject = (kotlin.d.d)new b(this.MnA, paramLifecycleScope, paramc, paramd, jdField_this, paramq, paramd);
      AppMethodBeat.o(278741);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(278739);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(278739);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.MnA.a(paramLifecycleScope, paramc);
        h localh = (h)new a(paramd, jdField_this, paramc, paramq, paramLifecycleScope);
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (paramObject.a(localh, locald) == locala)
        {
          AppMethodBeat.o(278739);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(278739);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements h<d<T>>
    {
      public a(d paramd, g paramg, c paramc, q paramq, LifecycleScope paramLifecycleScope) {}
      
      public final Object a(d<T> paramd, kotlin.d.d<? super ah> paramd1)
      {
        AppMethodBeat.i(278743);
        paramd = (d)paramd;
        this.MnE.pUj.addAll((Collection)paramd.pUj);
        this.MnE.ABD = true;
        if (!paramd.ABD)
        {
          paramd1 = this.MnD;
          g.a(paramd1, g.a(paramd1) + 1);
          if (!g.b(this.MnD).containsKey(Integer.valueOf(g.a(this.MnD)))) {
            ((Map)g.b(this.MnD)).put(Integer.valueOf(g.a(this.MnD)), Integer.valueOf(this.MnF.offset + paramd.pUj.size()));
          }
          if (this.MnE.pUj.size() >= this.MnF.pageSize) {
            this.MnG.offer(this.MnE);
          }
        }
        for (;;)
        {
          paramd = ah.aiuX;
          AppMethodBeat.o(278743);
          return paramd;
          Log.i("MicroMsg.Mvvm.MergeDataSource", s.X("continue to request next datasource:", Integer.valueOf(g.a(this.MnD))));
          paramd = new c(0, this.MnF.pageSize - this.MnE.pUj.size());
          g.a(this.MnD, this.HzZ, paramd, this.MnE, this.MnG);
          continue;
          this.MnG.offer(this.MnE);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
  public static final class c<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(278735);
      int i = kotlin.b.a.b((Comparable)Integer.valueOf(((f)paramT2).getPriority()), (Comparable)Integer.valueOf(((f)paramT1).getPriority()));
      AppMethodBeat.o(278735);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mvvmlist.a.g
 * JD-Core Version:    0.7.0.1
 */