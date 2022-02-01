package kotlinx.coroutines.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.a.h;
import kotlinx.coroutines.a.k;
import kotlinx.coroutines.a.v;
import kotlinx.coroutines.a.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.as;
import kotlinx.coroutines.c.b;
import kotlinx.coroutines.internal.y;

@Metadata(d1={""}, d2={"flowScope", "R", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scopedFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "(Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "flowProduce", "Lkotlinx/coroutines/channels/ReceiveChannel;", "T", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class p
{
  public static final <T> x<T> a(aq paramaq, f paramf, int paramInt, m<? super v<? super T>, ? super d<? super ah>, ? extends Object> paramm)
  {
    AppMethodBeat.i(189214);
    h localh = k.a(paramInt, null, 6);
    paramaq = new q(ak.a(paramaq, paramf), localh);
    paramaq.a(as.ajvM, paramaq, paramm);
    paramaq = (x)paramaq;
    AppMethodBeat.o(189214);
    return paramaq;
  }
  
  public static final <R> Object d(m<? super aq, ? super d<? super R>, ? extends Object> paramm, d<? super R> paramd)
  {
    AppMethodBeat.i(189200);
    o localo = new o(paramd.getContext(), paramd);
    paramm = b.a((y)localo, localo, paramm);
    if (paramm == a.aiwj) {
      s.u(paramd, "frame");
    }
    AppMethodBeat.o(189200);
    return paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.b.a.p
 * JD-Core Version:    0.7.0.1
 */