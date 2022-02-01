package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.f;
import kotlinx.coroutines.au;
import kotlinx.coroutines.b.a.u;
import kotlinx.coroutines.internal.ac;

@Metadata(d1={""}, d2={"NONE", "Lkotlinx/coroutines/internal/Symbol;", "getNONE$annotations", "()V", "PENDING", "getPENDING$annotations", "MutableStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "T", "value", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;", "fuseStateFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/StateFlow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "getAndUpdate", "function", "Lkotlin/Function1;", "(Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "increment", "", "delta", "update", "updateAndGet", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class ah
{
  private static final ac ajzd;
  private static final ac ajze;
  
  static
  {
    AppMethodBeat.i(189052);
    ajzd = new ac("NONE");
    ajze = new ac("PENDING");
    AppMethodBeat.o(189052);
  }
  
  public static final <T> g<T> a(af<? extends T> paramaf, f paramf, int paramInt, kotlinx.coroutines.a.g paramg)
  {
    int j = 1;
    AppMethodBeat.i(189031);
    int i;
    if (au.ASSERTIONS_ENABLED)
    {
      if (paramInt != -1) {}
      for (i = 1; i == 0; i = 0)
      {
        paramaf = new AssertionError();
        AppMethodBeat.o(189031);
        throw paramaf;
      }
    }
    if (paramInt >= 0) {
      if (paramInt <= 1) {
        i = j;
      }
    }
    while (((i != 0) || (paramInt == -2)) && (paramg == kotlinx.coroutines.a.g.ajxy))
    {
      paramaf = (g)paramaf;
      AppMethodBeat.o(189031);
      return paramaf;
      i = 0;
      continue;
      i = 0;
    }
    paramaf = ad.a((ab)paramaf, paramf, paramInt, paramg);
    AppMethodBeat.o(189031);
    return paramaf;
  }
  
  public static final void a(x<Integer> paramx, int paramInt)
  {
    AppMethodBeat.i(189023);
    Object localObject;
    do
    {
      localObject = paramx.getValue();
    } while (!paramx.ad(localObject, Integer.valueOf(((Number)localObject).intValue() + paramInt)));
    AppMethodBeat.o(189023);
  }
  
  public static final <T> x<T> ji(T paramT)
  {
    AppMethodBeat.i(189018);
    Object localObject = paramT;
    if (paramT == null) {
      localObject = u.ajzN;
    }
    paramT = (x)new ag(localObject);
    AppMethodBeat.o(189018);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.b.ah
 * JD-Core Version:    0.7.0.1
 */