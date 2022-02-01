package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "nodes", "", "Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/AwaitAll;", "(Lkotlinx/coroutines/AwaitAll;[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;)V", "[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "disposeAll", "", "invoke", "cause", "", "toString", "", "kotlinx-coroutines-core"})
final class c$b
  extends k
{
  private final c<T>[].a abwe;
  
  public c$b(c<T>[].a paramArrayOfc)
  {
    Object localObject;
    this.abwe = localObject;
  }
  
  public final void iQI()
  {
    AppMethodBeat.i(204889);
    c.a[] arrayOfa = this.abwe;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      arrayOfa[i].iQH().dispose();
      i += 1;
    }
    AppMethodBeat.o(204889);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204895);
    String str = "DisposeHandlersOnCancel[" + this.abwe + ']';
    AppMethodBeat.o(204895);
    return str;
  }
  
  public final void y(Throwable paramThrowable)
  {
    AppMethodBeat.i(204890);
    iQI();
    AppMethodBeat.o(204890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.coroutines.c.b
 * JD-Core Version:    0.7.0.1
 */