package kotlinx.coroutines.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.a.g;
import kotlinx.coroutines.a.i;
import kotlinx.coroutines.a.q;
import kotlinx.coroutines.a.r;
import kotlinx.coroutines.ae;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.c;
import kotlinx.coroutines.b.c<-TT;>;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/flow/internal/ChannelFlow;", "T", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "(Lkotlin/coroutines/CoroutineContext;I)V", "collectToFun", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "getCollectToFun$kotlinx_coroutines_core", "()Lkotlin/jvm/functions/Function2;", "produceCapacity", "getProduceCapacity", "()I", "additionalToStringProps", "", "broadcastImpl", "Lkotlinx/coroutines/channels/BroadcastChannel;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "start", "Lkotlinx/coroutines/CoroutineStart;", "collect", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectTo", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "fuse", "produceImpl", "Lkotlinx/coroutines/channels/ReceiveChannel;", "toString", "kotlinx-coroutines-core"})
public abstract class a<T>
  implements b<T>
{
  public final f abvW;
  public final int bgc;
  
  public a(f paramf, int paramInt)
  {
    this.abvW = paramf;
    this.bgc = -3;
  }
  
  protected abstract Object a(r<? super T> paramr, kotlin.d.d<? super x> paramd);
  
  public Object a(final c<? super T> paramc, kotlin.d.d<? super x> paramd)
  {
    paramc = (m)new a(this, paramc, null);
    Object localObject = new kotlinx.coroutines.internal.t(paramd.getContext(), paramd);
    localObject = kotlinx.coroutines.c.b.a((kotlinx.coroutines.internal.t)localObject, localObject, paramc);
    if (localObject == kotlin.d.a.a.aaAA) {
      p.k(paramd, "frame");
    }
    paramc = (c<? super T>)localObject;
    if (localObject != kotlin.d.a.a.aaAA) {
      paramc = x.aazN;
    }
    return paramc;
  }
  
  public kotlinx.coroutines.a.t<T> b(ak paramak)
  {
    f localf = this.abvW;
    if (this.bgc == -3) {}
    for (int i = -2;; i = this.bgc)
    {
      am localam = am.abwC;
      m localm = (m)new b(this, null);
      g localg = i.aFQ(i);
      paramak = new q(ae.a(paramak, localf), localg);
      paramak.a(localam, paramak, localm);
      return (kotlinx.coroutines.a.t)paramak;
    }
  }
  
  public String iSC()
  {
    return "";
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + '[' + iSC() + "context=" + this.abvW + ", capacity=" + this.bgc + ']';
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class a
    extends j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    a(a parama, c paramc, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(204301);
      paramd = new a(this.abyK, paramc, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(204301);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(204302);
      paramObject1 = ((a)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(204302);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(204299);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204299);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        c localc = paramc;
        kotlinx.coroutines.a.t localt = this.abyK.b(paramObject);
        this.L$0 = paramObject;
        this.label = 1;
        if (kotlinx.coroutines.b.d.a(localc, localt, this) == locala)
        {
          AppMethodBeat.o(204299);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = x.aazN;
      AppMethodBeat.o(204299);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "it", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends j
    implements m<r<? super T>, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    private r abyM;
    int label;
    
    b(a parama, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(204296);
      paramd = new b(this.abyK, paramd);
      paramd.abyM = ((r)paramObject);
      AppMethodBeat.o(204296);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(204297);
      paramObject1 = ((b)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(204297);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(204294);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204294);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.abyM;
        a locala1 = this.abyK;
        this.L$0 = paramObject;
        this.label = 1;
        if (locala1.a(paramObject, this) == locala)
        {
          AppMethodBeat.o(204294);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = x.aazN;
      AppMethodBeat.o(204294);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.b.a.a
 * JD-Core Version:    0.7.0.1
 */