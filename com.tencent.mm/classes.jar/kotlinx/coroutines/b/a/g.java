package kotlinx.coroutines.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.d.f.c;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.a.ab;
import kotlinx.coroutines.a.v;
import kotlinx.coroutines.a.x;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.cf;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/internal/ChannelFlowMerge;", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "flow", "Lkotlinx/coroutines/flow/Flow;", "concurrency", "", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlinx/coroutines/flow/Flow;ILkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "additionalToStringProps", "", "collectTo", "", "scope", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "produceImpl", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class g<T>
  extends e<T>
{
  private final int ajzm;
  private final kotlinx.coroutines.b.g<kotlinx.coroutines.b.g<T>> bLH;
  
  private g(kotlinx.coroutines.b.g<? extends kotlinx.coroutines.b.g<? extends T>> paramg, int paramInt1, kotlin.d.f paramf, int paramInt2, kotlinx.coroutines.a.g paramg1)
  {
    super(paramf, paramInt2, paramg1);
    this.bLH = paramg;
    this.ajzm = paramInt1;
  }
  
  protected final Object a(final v<? super T> paramv, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(189236);
    final kotlinx.coroutines.e.f localf = kotlinx.coroutines.e.h.aMI(this.ajzm);
    final y localy = new y((ab)paramv);
    cb localcb = (cb)paramd.getContext().get((f.c)cb.ajws);
    paramv = this.bLH.a((kotlinx.coroutines.b.h)new a(localcb, localf, paramv, localy), paramd);
    if (paramv == a.aiwj)
    {
      AppMethodBeat.o(189236);
      return paramv;
    }
    paramv = ah.aiuX;
    AppMethodBeat.o(189236);
    return paramv;
  }
  
  protected final e<T> a(kotlin.d.f paramf, int paramInt, kotlinx.coroutines.a.g paramg)
  {
    AppMethodBeat.i(189220);
    paramf = (e)new g(this.bLH, this.ajzm, paramf, paramInt, paramg);
    AppMethodBeat.o(189220);
    return paramf;
  }
  
  public final x<T> b(aq paramaq)
  {
    AppMethodBeat.i(189229);
    paramaq = p.a(paramaq, this.aMa, this.cZV, kDL());
    AppMethodBeat.o(189229);
    return paramaq;
  }
  
  protected final String kDx()
  {
    AppMethodBeat.i(189240);
    String str = s.X("concurrency=", Integer.valueOf(this.ajzm));
    AppMethodBeat.o(189240);
    return str;
  }
  
  @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements kotlinx.coroutines.b.h<kotlinx.coroutines.b.g<? extends T>>
  {
    public a(cb paramcb, kotlinx.coroutines.e.f paramf, v paramv, y paramy) {}
    
    public final Object a(kotlinx.coroutines.b.g<? extends T> paramg, kotlin.d.d<? super ah> paramd)
    {
      AppMethodBeat.i(189153);
      if ((paramd instanceof 1))
      {
        localObject1 = (1)paramd;
        if ((((1)localObject1).label & 0x80000000) != 0) {
          ((1)localObject1).label += -2147483648;
        }
      }
      a locala;
      for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new kotlin.d.b.a.d(paramd)
          {
            Object L$0;
            Object Uf;
            int label;
            
            public final Object invokeSuspend(Object paramAnonymousObject)
            {
              AppMethodBeat.i(189157);
              this.result = paramAnonymousObject;
              this.label |= 0x80000000;
              paramAnonymousObject = this.ajzr.a(null, (kotlin.d.d)this);
              AppMethodBeat.o(189157);
              return paramAnonymousObject;
            }
          })
      {
        localObject2 = paramd.result;
        locala = a.aiwj;
        switch (paramd.label)
        {
        default: 
          paramg = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(189153);
          throw paramg;
        }
      }
      ResultKt.throwOnFailure(localObject2);
      Object localObject1 = (kotlinx.coroutines.b.g)paramg;
      paramg = this.ajzn;
      if (paramg != null) {
        cf.d(paramg);
      }
      Object localObject2 = localf;
      paramd.L$0 = this;
      paramd.Uf = localObject1;
      paramd.label = 1;
      paramg = this;
      if (((kotlinx.coroutines.e.f)localObject2).aE(paramd) == locala)
      {
        AppMethodBeat.o(189153);
        return locala;
        localObject1 = (kotlinx.coroutines.b.g)paramd.Uf;
        paramg = (a)paramd.L$0;
        ResultKt.throwOnFailure(localObject2);
      }
      j.a((aq)paramv, null, null, (m)new g.b((kotlinx.coroutines.b.g)localObject1, localy, localf, null), 3);
      paramg = ah.aiuX;
      AppMethodBeat.o(189153);
      return paramg;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(kotlinx.coroutines.b.g<? extends T> paramg, y<T> paramy, kotlinx.coroutines.e.f paramf, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(189160);
      paramObject = (kotlin.d.d)new b(this.ajzs, this.ajzt, this.ajzu, paramd);
      AppMethodBeat.o(189160);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(189151);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(189151);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      try
      {
        paramObject = this.ajzs;
        kotlinx.coroutines.b.h localh = (kotlinx.coroutines.b.h)this.ajzt;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        paramObject = paramObject.a(localh, locald);
        if (paramObject == locala)
        {
          AppMethodBeat.o(189151);
          return locala;
          ResultKt.throwOnFailure(paramObject);
        }
        this.ajzu.release();
        paramObject = ah.aiuX;
        AppMethodBeat.o(189151);
        return paramObject;
      }
      finally
      {
        this.ajzu.release();
        AppMethodBeat.o(189151);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.b.a.g
 * JD-Core Version:    0.7.0.1
 */