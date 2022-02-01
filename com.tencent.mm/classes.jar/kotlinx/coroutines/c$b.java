package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "nodes", "", "Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/AwaitAll;", "(Lkotlinx/coroutines/AwaitAll;[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;)V", "[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "disposeAll", "", "invoke", "cause", "", "toString", "", "kotlinx-coroutines-core"})
final class c$b
  extends i
{
  private final c<T>[].a TTB;
  
  public c$b(c<T>[].a paramArrayOfc)
  {
    Object localObject;
    this.TTB = localObject;
  }
  
  public final void hMq()
  {
    AppMethodBeat.i(192399);
    c.a[] arrayOfa = this.TTB;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      arrayOfa[i].hMp().dispose();
      i += 1;
    }
    AppMethodBeat.o(192399);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(192402);
    String str = "DisposeHandlersOnCancel[" + this.TTB + ']';
    AppMethodBeat.o(192402);
    return str;
  }
  
  public final void y(Throwable paramThrowable)
  {
    AppMethodBeat.i(192400);
    hMq();
    AppMethodBeat.o(192400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.c.b
 * JD-Core Version:    0.7.0.1
 */