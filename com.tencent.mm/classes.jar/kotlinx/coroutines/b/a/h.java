package kotlinx.coroutines.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f.c;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.a.ab;
import kotlinx.coroutines.a.v;
import kotlinx.coroutines.internal.ag;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/internal/ChannelFlowOperator;", "S", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "flow", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectTo", "scope", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectWithContextUndispatched", "newContext", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flowCollect", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class h<S, T>
  extends e<T>
{
  protected final kotlinx.coroutines.b.g<S> bLH;
  
  public h(kotlinx.coroutines.b.g<? extends S> paramg, kotlin.d.f paramf, int paramInt, kotlinx.coroutines.a.g paramg1)
  {
    super(paramf, paramInt, paramg1);
    this.bLH = paramg;
  }
  
  protected final Object a(v<? super T> paramv, d<? super ah> paramd)
  {
    paramd = c((kotlinx.coroutines.b.h)new y((ab)paramv), paramd);
    paramv = paramd;
    if (paramd != a.aiwj) {
      paramv = ah.aiuX;
    }
    return paramv;
  }
  
  public final Object a(kotlinx.coroutines.b.h<? super T> paramh, d<? super ah> paramd)
  {
    Object localObject;
    kotlin.d.f localf;
    if (this.cZV == -3)
    {
      localObject = paramd.getContext();
      localf = ((kotlin.d.f)localObject).plus(this.aMa);
      if (s.p(localf, localObject))
      {
        paramd = c(paramh, paramd);
        paramh = paramd;
        if (paramd != a.aiwj) {
          paramh = ah.aiuX;
        }
      }
    }
    label111:
    do
    {
      return paramh;
      if (s.p(localf.get((f.c)kotlin.d.e.aiwc), ((kotlin.d.f)localObject).get((f.c)kotlin.d.e.aiwc)))
      {
        localObject = paramd.getContext();
        boolean bool;
        if ((paramh instanceof y))
        {
          bool = true;
          if (!bool) {
            break label178;
          }
        }
        for (;;)
        {
          localObject = (m)new a(this, null);
          paramh = f.a(localf, paramh, ag.i(localf), (m)localObject, paramd);
          paramd = paramh;
          if (paramh != a.aiwj) {
            paramd = ah.aiuX;
          }
          paramh = paramd;
          if (paramd == a.aiwj) {
            break;
          }
          return ah.aiuX;
          bool = paramh instanceof t;
          break label111;
          paramh = (kotlinx.coroutines.b.h)new aa(paramh, (kotlin.d.f)localObject);
        }
      }
      paramd = super.a(paramh, paramd);
      paramh = paramd;
    } while (paramd == a.aiwj);
    label178:
    return ah.aiuX;
  }
  
  protected abstract Object c(kotlinx.coroutines.b.h<? super T> paramh, d<? super ah> paramd);
  
  public String toString()
  {
    return this.bLH + " -> " + super.toString();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "S", "T", "it", "Lkotlinx/coroutines/flow/FlowCollector;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<kotlinx.coroutines.b.h<? super T>, d<? super ah>, Object>
  {
    int label;
    
    a(h<S, T> paramh, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(189195);
      paramd = new a(this.ajzv, paramd);
      paramd.L$0 = paramObject;
      paramObject = (d)paramd;
      AppMethodBeat.o(189195);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(189184);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(189184);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlinx.coroutines.b.h)this.L$0;
        h localh = this.ajzv;
        d locald = (d)this;
        this.label = 1;
        if (localh.c(paramObject, locald) == locala)
        {
          AppMethodBeat.o(189184);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(189184);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.b.a.h
 * JD-Core Version:    0.7.0.1
 */