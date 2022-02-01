package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlinx.coroutines.a.g;
import kotlinx.coroutines.a.v;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/ChannelFlowBuilder;", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "Lkotlin/jvm/functions/Function2;", "collectTo", "scope", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
class e<T>
  extends kotlinx.coroutines.b.a.e<T>
{
  private final m<v<? super T>, d<? super ah>, Object> aoK;
  
  public e(m<? super v<? super T>, ? super d<? super ah>, ? extends Object> paramm, f paramf, int paramInt, g paramg)
  {
    super(paramf, paramInt, paramg);
    this.aoK = paramm;
  }
  
  public Object a(v<? super T> paramv, d<? super ah> paramd)
  {
    AppMethodBeat.i(189126);
    paramd = this.aoK.invoke(paramv, paramd);
    paramv = paramd;
    if (paramd != a.aiwj) {
      paramv = ah.aiuX;
    }
    AppMethodBeat.o(189126);
    return paramv;
  }
  
  public kotlinx.coroutines.b.a.e<T> a(f paramf, int paramInt, g paramg)
  {
    AppMethodBeat.i(189116);
    paramf = (kotlinx.coroutines.b.a.e)new e(this.aoK, paramf, paramInt, paramg);
    AppMethodBeat.o(189116);
    return paramf;
  }
  
  public String toString()
  {
    AppMethodBeat.i(189135);
    String str = "block[" + this.aoK + "] -> " + super.toString();
    AppMethodBeat.o(189135);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.b.e
 * JD-Core Version:    0.7.0.1
 */