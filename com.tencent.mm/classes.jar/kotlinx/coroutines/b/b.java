package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlinx.coroutines.a.g;
import kotlinx.coroutines.a.v;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/CallbackFlowBuilder;", "T", "Lkotlinx/coroutines/flow/ChannelFlowBuilder;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "Lkotlin/jvm/functions/Function2;", "collectTo", "scope", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class b<T>
  extends e<T>
{
  private final m<v<? super T>, kotlin.d.d<? super ah>, Object> aoK;
  
  private b(m<? super v<? super T>, ? super kotlin.d.d<? super ah>, ? extends Object> paramm, f paramf, int paramInt, g paramg)
  {
    super(paramm, paramf, paramInt, paramg);
    this.aoK = paramm;
  }
  
  public final Object a(v<? super T> paramv, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(189131);
    if ((paramd instanceof a))
    {
      localObject1 = (a)paramd;
      if ((((a)localObject1).label & 0x80000000) != 0) {
        ((a)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    a locala;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new a(this, paramd))
    {
      localObject2 = paramd.result;
      locala = a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramv = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(189131);
        throw paramv;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    paramd.L$0 = paramv;
    paramd.label = 1;
    Object localObject1 = paramv;
    if (super.a(paramv, paramd) == locala)
    {
      AppMethodBeat.o(189131);
      return locala;
      localObject1 = (v)paramd.L$0;
      ResultKt.throwOnFailure(localObject2);
    }
    if (!((v)localObject1).Ij())
    {
      paramv = new IllegalStateException("'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
      AppMethodBeat.o(189131);
      throw paramv;
    }
    paramv = ah.aiuX;
    AppMethodBeat.o(189131);
    return paramv;
  }
  
  public final kotlinx.coroutines.b.a.e<T> a(f paramf, int paramInt, g paramg)
  {
    AppMethodBeat.i(189140);
    paramf = (kotlinx.coroutines.b.a.e)new b(this.aoK, paramf, paramInt, paramg);
    AppMethodBeat.o(189140);
    return paramf;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    a(b<T> paramb, kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(189070);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.ajxR.a(null, (kotlin.d.d)this);
      AppMethodBeat.o(189070);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.b.b
 * JD-Core Version:    0.7.0.1
 */