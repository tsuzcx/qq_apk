package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;

@Metadata(d1={""}, d2={"awaitClose", "", "Lkotlinx/coroutines/channels/ProducerScope;", "block", "Lkotlin/Function0;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "produce", "Lkotlinx/coroutines/channels/ReceiveChannel;", "E", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "start", "Lkotlinx/coroutines/CoroutineStart;", "onCompletion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlinx/coroutines/CompletionHandler;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class t
{
  public static final Object a(v<?> paramv, kotlin.g.a.a<ah> parama, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(189268);
    Object localObject1;
    if ((paramd instanceof a))
    {
      localObject1 = (a)paramd;
      if ((((a)localObject1).label & 0x80000000) != 0) {
        ((a)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new a(paramd))
    {
      localObject2 = paramd.result;
      localObject1 = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramv = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(189268);
        throw paramv;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    if (paramd.getContext().get((f.c)cb.ajws) == paramv) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramv = (Throwable)new IllegalStateException("awaitClose() can only be invoked from the producer context".toString());
      AppMethodBeat.o(189268);
      throw paramv;
    }
    try
    {
      paramd.L$0 = paramv;
      paramd.Uf = parama;
      paramd.label = 1;
      localObject2 = new q(kotlin.d.a.b.au((kotlin.d.d)paramd), 1);
      ((q)localObject2).kBA();
      paramv.p((kotlin.g.a.b)new b((p)localObject2));
      paramv = ((q)localObject2).getResult();
      if (paramv == kotlin.d.a.a.aiwj) {
        s.u((kotlin.d.d)paramd, "frame");
      }
      if (paramv == localObject1)
      {
        AppMethodBeat.o(189268);
        return localObject1;
        paramv = (kotlin.g.a.a)paramd.Uf;
      }
      parama.invoke();
    }
    finally
    {
      try
      {
        ResultKt.throwOnFailure(localObject2);
        parama = paramv;
        parama.invoke();
        paramv = ah.aiuX;
        AppMethodBeat.o(189268);
        return paramv;
      }
      finally
      {
        parama = paramv;
        paramv = paramd;
      }
      paramv = finally;
    }
    AppMethodBeat.o(189268);
    throw paramv;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    a(kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(189363);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = t.a(null, null, (kotlin.d.d)this);
      AppMethodBeat.o(189363);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Throwable, ah>
  {
    b(p<? super ah> paramp)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.a.t
 * JD-Core Version:    0.7.0.1
 */