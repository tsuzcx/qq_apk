package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.l;
import kotlinx.coroutines.a.r;
import kotlinx.coroutines.a.t;
import kotlinx.coroutines.ak;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/flow/ChannelAsFlow;", "T", "Lkotlinx/coroutines/channels/ReceiveChannel;", "channel", "", "consume", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "<init>", "(Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/CoroutineContext;I)V", "", "additionalToStringProps", "()Ljava/lang/String;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineStart;", "start", "Lkotlinx/coroutines/channels/BroadcastChannel;", "broadcastImpl", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineStart;)Lkotlinx/coroutines/channels/BroadcastChannel;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ProducerScope;", "collectTo", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "create", "(Lkotlin/coroutines/CoroutineContext;I)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "markConsumed", "()V", "produceImpl", "(Lkotlinx/coroutines/CoroutineScope;)Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Z", "kotlinx-coroutines-core"})
public final class a<T>
  extends kotlinx.coroutines.b.a.a<T>
{
  private static final AtomicIntegerFieldUpdater abyG;
  private final t<T> abyH;
  private final boolean abyI;
  private volatile int consumed;
  
  static
  {
    AppMethodBeat.i(204280);
    abyG = AtomicIntegerFieldUpdater.newUpdater(a.class, "consumed");
    AppMethodBeat.o(204280);
  }
  
  private a(t<? extends T> paramt, f paramf)
  {
    super(paramf, -3);
    this.abyH = paramt;
    this.abyI = false;
    this.consumed = 0;
  }
  
  private final void iSB()
  {
    int i = 1;
    AppMethodBeat.i(204274);
    if (this.abyI)
    {
      if (abyG.getAndSet(this, 1) == 0) {}
      while (i == 0)
      {
        Throwable localThrowable = (Throwable)new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once".toString());
        AppMethodBeat.o(204274);
        throw localThrowable;
        i = 0;
      }
    }
    AppMethodBeat.o(204274);
  }
  
  public final Object a(r<? super T> paramr, d<? super kotlin.x> paramd)
  {
    AppMethodBeat.i(204275);
    paramr = e.a((c)new kotlinx.coroutines.b.a.c((kotlinx.coroutines.a.x)paramr), this.abyH, this.abyI, paramd);
    if (paramr == kotlin.d.a.a.aaAA)
    {
      AppMethodBeat.o(204275);
      return paramr;
    }
    paramr = kotlin.x.aazN;
    AppMethodBeat.o(204275);
    return paramr;
  }
  
  public final Object a(c<? super T> paramc, d<? super kotlin.x> paramd)
  {
    AppMethodBeat.i(204277);
    if (this.bgc == -3)
    {
      iSB();
      paramc = e.a(paramc, this.abyH, this.abyI, paramd);
      if (paramc == kotlin.d.a.a.aaAA)
      {
        AppMethodBeat.o(204277);
        return paramc;
      }
    }
    else
    {
      paramc = super.a(paramc, paramd);
      if (paramc == kotlin.d.a.a.aaAA)
      {
        AppMethodBeat.o(204277);
        return paramc;
      }
    }
    paramc = kotlin.x.aazN;
    AppMethodBeat.o(204277);
    return paramc;
  }
  
  public final t<T> b(ak paramak)
  {
    AppMethodBeat.i(204276);
    iSB();
    if (this.bgc == -3)
    {
      paramak = this.abyH;
      AppMethodBeat.o(204276);
      return paramak;
    }
    paramak = super.b(paramak);
    AppMethodBeat.o(204276);
    return paramak;
  }
  
  public final String iSC()
  {
    AppMethodBeat.i(204278);
    String str = "channel=" + this.abyH + ", ";
    AppMethodBeat.o(204278);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.b.a
 * JD-Core Version:    0.7.0.1
 */