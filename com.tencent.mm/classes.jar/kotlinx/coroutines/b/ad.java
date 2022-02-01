package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.f;
import kotlin.g.b.s;
import kotlinx.coroutines.b.a.i;

@Metadata(d1={""}, d2={"NO_VALUE", "Lkotlinx/coroutines/internal/Symbol;", "getNO_VALUE$annotations", "()V", "MutableSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "T", "replay", "", "extraBufferCapacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "fuseSharedFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharedFlow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "getBufferAt", "", "", "index", "", "([Ljava/lang/Object;J)Ljava/lang/Object;", "setBufferAt", "", "item", "([Ljava/lang/Object;JLjava/lang/Object;)V", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class ad
{
  public static final kotlinx.coroutines.internal.ac ajzb;
  
  static
  {
    AppMethodBeat.i(189053);
    ajzb = new kotlinx.coroutines.internal.ac("NO_VALUE");
    AppMethodBeat.o(189053);
  }
  
  public static final <T> g<T> a(ab<? extends T> paramab, f paramf, int paramInt, kotlinx.coroutines.a.g paramg)
  {
    AppMethodBeat.i(189029);
    if (((paramInt == 0) || (paramInt == -3)) && (paramg == kotlinx.coroutines.a.g.ajxx))
    {
      paramab = (g)paramab;
      AppMethodBeat.o(189029);
      return paramab;
    }
    paramab = (g)new i((g)paramab, paramf, paramInt, paramg);
    AppMethodBeat.o(189029);
    return paramab;
  }
  
  public static final <T> w<T> a(int paramInt1, int paramInt2, kotlinx.coroutines.a.g paramg)
  {
    int j = 0;
    AppMethodBeat.i(189016);
    if (paramInt1 >= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramg = (Throwable)new IllegalArgumentException(s.X("replay cannot be negative, but was ", Integer.valueOf(paramInt1)).toString());
      AppMethodBeat.o(189016);
      throw paramg;
    }
    if (paramInt2 >= 0) {}
    for (i = 1; i == 0; i = 0)
    {
      paramg = (Throwable)new IllegalArgumentException(s.X("extraBufferCapacity cannot be negative, but was ", Integer.valueOf(paramInt2)).toString());
      AppMethodBeat.o(189016);
      throw paramg;
    }
    if ((paramInt1 <= 0) && (paramInt2 <= 0))
    {
      i = j;
      if (paramg != kotlinx.coroutines.a.g.ajxx) {}
    }
    else
    {
      i = 1;
    }
    if (i == 0)
    {
      paramg = (Throwable)new IllegalArgumentException(s.X("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy ", paramg).toString());
      AppMethodBeat.o(189016);
      throw paramg;
    }
    paramInt2 = paramInt1 + paramInt2;
    if (paramInt2 < 0) {
      paramInt2 = 2147483647;
    }
    for (;;)
    {
      paramg = (w)new ac(paramInt1, paramInt2, paramg);
      AppMethodBeat.o(189016);
      return paramg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.b.ad
 * JD-Core Version:    0.7.0.1
 */