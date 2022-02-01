package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.f;
import kotlin.g.b.s;
import kotlinx.coroutines.a.ab;
import kotlinx.coroutines.a.g;
import kotlinx.coroutines.a.v;
import kotlinx.coroutines.a.x;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.a.e;
import kotlinx.coroutines.b.a.y;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/ChannelAsFlow;", "T", "Lkotlinx/coroutines/channels/ReceiveChannel;", "channel", "", "consume", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "", "additionalToStringProps", "()Ljava/lang/String;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ProducerScope;", "scope", "collectTo", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "create", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/flow/Flow;", "dropChannelOperators", "()Lkotlinx/coroutines/flow/Flow;", "markConsumed", "()V", "Lkotlinx/coroutines/CoroutineScope;", "produceImpl", "(Lkotlinx/coroutines/CoroutineScope;)Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Z", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class d<T>
  extends e<T>
{
  private final x<T> ajxS;
  private final boolean ajxT;
  
  static
  {
    AppMethodBeat.i(189130);
    ajxU = AtomicIntegerFieldUpdater.newUpdater(d.class, "consumed");
    AppMethodBeat.o(189130);
  }
  
  private d(x<? extends T> paramx, boolean paramBoolean, f paramf, int paramInt, g paramg)
  {
    super(paramf, paramInt, paramg);
    this.ajxS = paramx;
    this.ajxT = paramBoolean;
    this.consumed = 0;
  }
  
  private final void kDw()
  {
    int i = 1;
    AppMethodBeat.i(189122);
    if (this.ajxT)
    {
      if (ajxU.getAndSet(this, 1) == 0) {}
      while (i == 0)
      {
        Throwable localThrowable = (Throwable)new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once".toString());
        AppMethodBeat.o(189122);
        throw localThrowable;
        i = 0;
      }
    }
    AppMethodBeat.o(189122);
  }
  
  public final Object a(v<? super T> paramv, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(189147);
    paramv = k.a((h)new y((ab)paramv), this.ajxS, this.ajxT, paramd);
    if (paramv == a.aiwj)
    {
      AppMethodBeat.o(189147);
      return paramv;
    }
    paramv = ah.aiuX;
    AppMethodBeat.o(189147);
    return paramv;
  }
  
  public final Object a(h<? super T> paramh, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(189162);
    if (this.cZV == -3)
    {
      kDw();
      paramh = k.a(paramh, this.ajxS, this.ajxT, paramd);
      if (paramh == a.aiwj)
      {
        AppMethodBeat.o(189162);
        return paramh;
      }
      paramh = ah.aiuX;
      AppMethodBeat.o(189162);
      return paramh;
    }
    paramh = super.a(paramh, paramd);
    if (paramh == a.aiwj)
    {
      AppMethodBeat.o(189162);
      return paramh;
    }
    paramh = ah.aiuX;
    AppMethodBeat.o(189162);
    return paramh;
  }
  
  public final e<T> a(f paramf, int paramInt, g paramg)
  {
    AppMethodBeat.i(189138);
    paramf = (e)new d(this.ajxS, this.ajxT, paramf, paramInt, paramg);
    AppMethodBeat.o(189138);
    return paramf;
  }
  
  public final x<T> b(aq paramaq)
  {
    AppMethodBeat.i(189154);
    kDw();
    if (this.cZV == -3)
    {
      paramaq = this.ajxS;
      AppMethodBeat.o(189154);
      return paramaq;
    }
    paramaq = super.b(paramaq);
    AppMethodBeat.o(189154);
    return paramaq;
  }
  
  public final String kDx()
  {
    AppMethodBeat.i(189175);
    String str = s.X("channel=", this.ajxS);
    AppMethodBeat.o(189175);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.b.d
 * JD-Core Version:    0.7.0.1
 */