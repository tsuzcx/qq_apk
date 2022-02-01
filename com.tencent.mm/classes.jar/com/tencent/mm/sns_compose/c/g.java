package com.tencent.mm.sns_compose.c;

import androidx.lifecycle.af;
import androidx.lifecycle.ag;
import androidx.paging.at;
import androidx.paging.au;
import androidx.paging.av;
import androidx.paging.ay;
import androidx.paging.g.a;
import androidx.paging.g.d;
import androidx.paging.g.e;
import androidx.paging.g.f;
import androidx.paging.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sns_compose.a.f;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.ab;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.ah;
import kotlinx.coroutines.b.o;
import kotlinx.coroutines.b.v;
import kotlinx.coroutines.b.x;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sns_compose/page/WithTaViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "lazyData", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;", "getLazyData", "()Lkotlinx/coroutines/flow/Flow;", "modificationEvents", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/tencent/mm/sns_compose/page/ViewEvents;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "getScope", "()Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "setScope", "(Lcom/tencent/mm/sdk/coroutines/LifecycleScope;)V", "applyEvents", "paging", "sampleViewEvents", "initScope", "", "context", "Landroid/content/Context;", "onViewEvent", "viewEvents", "sns-compose_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends af
{
  public static final int Ue = 8;
  public LifecycleScope aczV;
  final x<List<d>> aczW;
  final kotlinx.coroutines.b.g<av<f>> aczX;
  
  public g()
  {
    AppMethodBeat.i(235586);
    this.aczW = ah.ji((List)ab.aivy);
    kotlinx.coroutines.b.g localg = new at(new au(40, 0, false, 40, 0, 0, 54), (kotlin.g.a.a)b.aczZ, (byte)0).bLH;
    aq localaq = ag.b((af)this);
    s.u(localg, "$this$cachedIn");
    s.u(localaq, "scope");
    s.u(localg, "$this$cachedIn");
    s.u(localaq, "scope");
    this.aczX = v.a(new androidx.paging.a.d(localaq, 1, o.d(o.a((kotlinx.coroutines.b.g)new androidx.paging.g.b(r.b((kotlinx.coroutines.b.g)new g.a(localg, localaq), (q)new g.d(null))), (m)new g.e(null, null)), (q)new g.f(null, null)), (m)new androidx.paging.g.c(null), (byte)0).bLH, (kotlinx.coroutines.b.g)this.aczW, (q)new c(this, null));
    AppMethodBeat.o(235586);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/paging/PagingSource;", "", "Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ay<Long, f>>
  {
    public static final b aczZ;
    
    static
    {
      AppMethodBeat.i(235515);
      aczZ = new b();
      AppMethodBeat.o(235515);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/paging/PagingData;", "Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;", "pagingData", "modifications", "", "Lcom/tencent/mm/sns_compose/page/ViewEvents;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements q<av<f>, List<? extends d>, kotlin.d.d<? super av<f>>, Object>
  {
    int label;
    
    c(g paramg, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(235553);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(235553);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = (av)this.L$0;
      localObject = ((Iterable)this.Uf).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramObject = g.a(paramObject, (d)((Iterator)localObject).next());
      }
      AppMethodBeat.o(235553);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sns_compose.c.g
 * JD-Core Version:    0.7.0.1
 */