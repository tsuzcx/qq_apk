package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlinx.coroutines.k;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/channels/AbstractChannel$RemoveReceiveOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "receive", "Lkotlinx/coroutines/channels/Receive;", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/channels/Receive;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
final class a$b
  extends k
{
  private final s<?> abyb;
  
  public a$b(s<?> params)
  {
    Object localObject;
    this.abyb = localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204554);
    String str = "RemoveReceiveOnCancel[" + this.abyb + ']';
    AppMethodBeat.o(204554);
    return str;
  }
  
  public final void y(Throwable paramThrowable)
  {
    AppMethodBeat.i(204552);
    this.abyb.remove();
    AppMethodBeat.o(204552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.coroutines.a.a.b
 * JD-Core Version:    0.7.0.1
 */