package com.tencent.mm.plugin.ringtone.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ringtone.b.c;
import com.tencent.mm.protocal.protobuf.a.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.d.b.a.k;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.ac;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.x;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.cx;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/exclusive/ExclusiveDataViewModel;", "Landroidx/lifecycle/ViewModel;", "ringtoneRepository", "Lcom/tencent/mm/plugin/ringtone/flow/ExclusiveRemoteDataSource;", "(Lcom/tencent/mm/plugin/ringtone/flow/ExclusiveRemoteDataSource;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/tencent/mm/plugin/ringtone/exclusive/ExclusiveDataViewModel$ExclusiveUiState$Success;", "dataJob", "Lkotlinx/coroutines/Job;", "getDataJob", "()Lkotlinx/coroutines/Job;", "setDataJob", "(Lkotlinx/coroutines/Job;)V", "mRingtoneRemoteLimitedCapacity", "", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/tencent/mm/plugin/ringtone/exclusive/ExclusiveDataViewModel$ExclusiveUiState;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "bindDataSource", "", "temp", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/ringtone/data/ExclusiveConvertData;", "Lkotlin/collections/ArrayList;", "clearDataSource", "loadFromCache", "noExclusiveHasBeenSet", "noMoreExclusiveData", "availData", "", "onDeleteRingtone", "username", "spiltExclusiveList", "", "capacity", "Companion", "ExclusiveUiState", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends androidx.lifecycle.af
{
  public static final a.a OCk;
  public aq OCd;
  private final x<a.b.a> OCe;
  public final kotlinx.coroutines.b.af<a.b> OCf;
  public cb OCg;
  private final com.tencent.mm.plugin.ringtone.e.a OCl;
  private final int OCm;
  
  static
  {
    AppMethodBeat.i(272839);
    OCk = new a.a((byte)0);
    AppMethodBeat.o(272839);
  }
  
  public a(com.tencent.mm.plugin.ringtone.e.a parama)
  {
    AppMethodBeat.i(272815);
    this.OCl = parama;
    this.OCd = ar.d(cx.g(null).plus((f)bg.kCi()));
    this.OCe = kotlinx.coroutines.b.ah.ji(new a.b.a(null, 1));
    this.OCm = 10;
    this.OCf = ((kotlinx.coroutines.b.af)this.OCe);
    AppMethodBeat.o(272815);
  }
  
  public final void bp(final ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(272845);
    s.u(paramArrayList, "availData");
    this.OCg = kotlinx.coroutines.j.a(this.OCd, null, null, (m)new g(this, paramArrayList, null), 3);
    AppMethodBeat.o(272845);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    Object L$0;
    Object Uf;
    int label;
    
    public c(a parama, ArrayList<c> paramArrayList, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(272804);
      paramObject = (kotlin.d.d)new c(this.OCo, this.OCj, paramd);
      AppMethodBeat.o(272804);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(272796);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject1;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(272796);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localObject1 = (Iterable)a.j(this.OCj, a.a(this.OCo));
        paramObject = this.OCo;
        localObject1 = ((Iterable)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (List)((Iterator)localObject1).next();
          Object localObject3 = a.c(paramObject);
          s.u(localObject2, "ringtone");
          localObject2 = kotlinx.coroutines.b.j.y((m)new com.tencent.mm.plugin.ringtone.e.a.c((List)localObject2, (com.tencent.mm.plugin.ringtone.e.a)localObject3, null));
          localObject3 = (h)new a(paramObject);
          this.L$0 = paramObject;
          this.Uf = localObject1;
          this.label = 1;
          if (((g)localObject2).a((h)localObject3, this) != locala) {
            break label222;
          }
          AppMethodBeat.o(272796);
          return locala;
        }
        break;
      case 1: 
        localObject1 = (Iterator)this.Uf;
        localObject2 = (a)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject2;
      }
      label222:
      for (;;)
      {
        break;
        paramObject = kotlin.ah.aiuX;
        AppMethodBeat.o(272796);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements h<ArrayList<c>>
    {
      public a(a parama) {}
      
      public final Object a(ArrayList<c> paramArrayList, kotlin.d.d<? super kotlin.ah> paramd)
      {
        AppMethodBeat.i(272806);
        paramArrayList = (ArrayList)paramArrayList;
        a.b(this.OCo).setValue(new a.b.a((List)paramArrayList, 2));
        paramArrayList = kotlin.ah.aiuX;
        AppMethodBeat.o(272806);
        return paramArrayList;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class d
    extends k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    public d(a parama, kotlin.d.d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(272794);
      paramObject = (kotlin.d.d)new d(this.OCo, paramd);
      AppMethodBeat.o(272794);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(272790);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(272790);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      a.b(this.OCo).setValue(new a.b.a(null, 1));
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(272790);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class e
    extends k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    public e(a parama, kotlin.d.d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(272798);
      paramObject = (kotlin.d.d)new e(this.OCo, paramd);
      AppMethodBeat.o(272798);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(272791);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(272791);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = new ArrayList();
      localObject = com.tencent.mm.plugin.ringtone.d.gOs();
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.ringtone.g.a locala = (com.tencent.mm.plugin.ringtone.g.a)((Iterator)localObject).next();
          e locale = new e();
          locale.UserName = locala.name;
          locale.aciY = locala.OCY;
          paramObject.add(new c(locale));
        }
      }
      a.b(this.OCo).setValue(new a.b.a((List)paramObject, 5));
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(272791);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class f
    extends k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    public f(a parama, kotlin.d.d<? super f> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(272805);
      paramObject = (kotlin.d.d)new f(this.OCo, paramd);
      AppMethodBeat.o(272805);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(272797);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(272797);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      a.b(this.OCo).setValue(new a.b.a(null, 3));
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(272797);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    g(a parama, ArrayList<String> paramArrayList, kotlin.d.d<? super g> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(272808);
      paramObject = (kotlin.d.d)new g(this.OCo, paramArrayList, paramd);
      AppMethodBeat.o(272808);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(272799);
      Object localObject1 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(272799);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = new ArrayList();
      localObject1 = com.tencent.mm.plugin.ringtone.d.gOs();
      if (localObject1 != null)
      {
        Object localObject2 = (Iterable)localObject1;
        localObject1 = paramArrayList;
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (com.tencent.mm.plugin.ringtone.g.a)((Iterator)localObject2).next();
          if ((!p.a((Iterable)localObject1, ((com.tencent.mm.plugin.ringtone.g.a)localObject3).name)) || (((ArrayList)localObject1).isEmpty()))
          {
            localObject3 = ((com.tencent.mm.plugin.ringtone.g.a)localObject3).name;
            if (localObject3 != null)
            {
              e locale = new e();
              locale.UserName = ((String)localObject3);
              paramObject.add(new c(locale));
              com.tencent.mm.plugin.ringtone.d.b((String)localObject3, null);
              com.tencent.mm.plugin.ringtone.d.a((String)localObject3, null);
            }
          }
        }
      }
      a.b(this.OCo).setValue(new a.b.a((List)paramObject, 4));
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(272799);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class h
    extends k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    public h(String paramString, a parama, kotlin.d.d<? super h> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(272813);
      paramObject = (kotlin.d.d)new h(this.mrr, this.OCo, paramd);
      AppMethodBeat.o(272813);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(272803);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(272803);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = new ArrayList();
      localObject = new e();
      ((e)localObject).UserName = this.mrr;
      paramObject.add(new c((e)localObject));
      a.b(this.OCo).setValue(new a.b.a((List)paramObject, 4));
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(272803);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.c.a
 * JD-Core Version:    0.7.0.1
 */