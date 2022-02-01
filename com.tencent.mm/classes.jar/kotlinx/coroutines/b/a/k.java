package kotlinx.coroutines.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlinx.coroutines.a.ab;
import kotlinx.coroutines.a.v;
import kotlinx.coroutines.a.x;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/internal/ChannelLimitedFlowMerge;", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "flows", "", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Ljava/lang/Iterable;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "collectTo", "", "scope", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "produceImpl", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class k<T>
  extends e<T>
{
  private final Iterable<kotlinx.coroutines.b.g<T>> ajzB;
  
  private k(Iterable<? extends kotlinx.coroutines.b.g<? extends T>> paramIterable, f paramf, int paramInt, kotlinx.coroutines.a.g paramg)
  {
    super(paramf, paramInt, paramg);
    this.ajzB = paramIterable;
  }
  
  protected final Object a(v<? super T> paramv, final d<? super ah> paramd)
  {
    AppMethodBeat.i(189237);
    paramd = new y((ab)paramv);
    Iterator localIterator = this.ajzB.iterator();
    while (localIterator.hasNext())
    {
      kotlinx.coroutines.b.g localg = (kotlinx.coroutines.b.g)localIterator.next();
      j.a((aq)paramv, null, null, (m)new a(localg, paramd, null), 3);
    }
    paramv = ah.aiuX;
    AppMethodBeat.o(189237);
    return paramv;
  }
  
  protected final e<T> a(f paramf, int paramInt, kotlinx.coroutines.a.g paramg)
  {
    AppMethodBeat.i(189221);
    paramf = (e)new k(this.ajzB, paramf, paramInt, paramg);
    AppMethodBeat.o(189221);
    return paramf;
  }
  
  public final x<T> b(aq paramaq)
  {
    AppMethodBeat.i(189231);
    paramaq = p.a(paramaq, this.aMa, this.cZV, kDL());
    AppMethodBeat.o(189231);
    return paramaq;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    a(kotlinx.coroutines.b.g<? extends T> paramg, y<T> paramy, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(189251);
      paramObject = (d)new a(this.Tbd, paramd, paramd);
      AppMethodBeat.o(189251);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(189241);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(189241);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.Tbd;
        h localh = (h)paramd;
        d locald = (d)this;
        this.label = 1;
        if (paramObject.a(localh, locald) == locala)
        {
          AppMethodBeat.o(189241);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(189241);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.b.a.k
 * JD-Core Version:    0.7.0.1
 */