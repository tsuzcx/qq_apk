package com.tencent.mm.plugin.ringtone.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ringtone.e.b;
import com.tencent.mm.plugin.ringtone.e.b.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.x;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.cx;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/data/RingtoneDataViewModel;", "Landroidx/lifecycle/ViewModel;", "ringtoneRepository", "Lcom/tencent/mm/plugin/ringtone/flow/RingtoneRemoteDataSource;", "(Lcom/tencent/mm/plugin/ringtone/flow/RingtoneRemoteDataSource;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/tencent/mm/plugin/ringtone/data/RingtoneDataViewModel$RingtoneUiState$Success;", "dataJob", "Lkotlinx/coroutines/Job;", "getDataJob", "()Lkotlinx/coroutines/Job;", "setDataJob", "(Lkotlinx/coroutines/Job;)V", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/tencent/mm/plugin/ringtone/data/RingtoneDataViewModel$RingtoneUiState;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "bindDataSource", "", "temp", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/ringtone/data/RingtoneConvertData;", "Lkotlin/collections/ArrayList;", "clearDataSource", "loading", "noMoreDataLoad", "RingtoneUiState", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends androidx.lifecycle.af
{
  private final b OCc;
  public aq OCd;
  private final x<g.a.a> OCe;
  public final kotlinx.coroutines.b.af<g.a> OCf;
  public cb OCg;
  
  public g(b paramb)
  {
    AppMethodBeat.i(272999);
    this.OCc = paramb;
    this.OCd = ar.b(ar.d((f)bg.kCi()), (f)cx.g(null));
    this.OCe = kotlinx.coroutines.b.ah.ji(new g.a.a(null, 1));
    this.OCf = ((kotlinx.coroutines.b.af)this.OCe);
    AppMethodBeat.o(272999);
  }
  
  public final void gOw()
  {
    AppMethodBeat.i(273018);
    cb localcb = this.OCg;
    if (localcb != null) {
      localcb.a(null);
    }
    kotlinx.coroutines.j.a(this.OCd, null, null, (m)new c(this, null), 3);
    AppMethodBeat.o(273018);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends k
    implements m<aq, d<? super kotlin.ah>, Object>
  {
    int label;
    
    public b(g paramg, ArrayList<e> paramArrayList, d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<kotlin.ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(273048);
      paramObject = (d)new b(this.OCi, this.OCj, paramd);
      AppMethodBeat.o(273048);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(273037);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273037);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = g.a(this.OCi);
        Object localObject = (List)this.OCj;
        s.u(localObject, "ringtone");
        paramObject = kotlinx.coroutines.b.j.y((m)new b.c((List)localObject, paramObject, null));
        localObject = (h)new a(this.OCi);
        d locald = (d)this;
        this.label = 1;
        if (paramObject.a((h)localObject, locald) == locala)
        {
          AppMethodBeat.o(273037);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(273037);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements h<List<? extends e>>
    {
      public a(g paramg) {}
      
      public final Object a(List<? extends e> paramList, d<? super kotlin.ah> paramd)
      {
        AppMethodBeat.i(273019);
        paramList = (List)paramList;
        g.b(this.OCi).setValue(new g.a.a(paramList, 3));
        paramList = kotlin.ah.aiuX;
        AppMethodBeat.o(273019);
        return paramList;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, d<? super kotlin.ah>, Object>
  {
    int label;
    
    c(g paramg, d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final d<kotlin.ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(273034);
      paramObject = (d)new c(this.OCi, paramd);
      AppMethodBeat.o(273034);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(273028);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273028);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      g.b(this.OCi).setValue(new g.a.a(null, 1));
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(273028);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class d
    extends k
    implements m<aq, d<? super kotlin.ah>, Object>
  {
    int label;
    
    public d(g paramg, d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final d<kotlin.ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(273036);
      paramObject = (d)new d(this.OCi, paramd);
      AppMethodBeat.o(273036);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(273030);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273030);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      g.b(this.OCi).setValue(new g.a.a(null, 2));
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(273030);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class e
    extends k
    implements m<aq, d<? super kotlin.ah>, Object>
  {
    int label;
    
    public e(g paramg, d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final d<kotlin.ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(273027);
      paramObject = (d)new e(this.OCi, paramd);
      AppMethodBeat.o(273027);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(273023);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273023);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      g.b(this.OCi).setValue(new g.a.a(null, 4));
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(273023);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.b.g
 * JD-Core Version:    0.7.0.1
 */