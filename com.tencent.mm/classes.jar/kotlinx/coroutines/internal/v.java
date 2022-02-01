package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.an;

@Metadata(d1={""}, d2={"bindCancellationFun", "Lkotlin/Function1;", "", "", "E", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "element", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)Lkotlin/jvm/functions/Function1;", "callUndeliveredElement", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", "callUndeliveredElementCatchingException", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "undeliveredElementException", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlinx/coroutines/internal/UndeliveredElementException;)Lkotlinx/coroutines/internal/UndeliveredElementException;", "OnUndeliveredElement", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class v
{
  public static final <E> ak a(kotlin.g.a.b<? super E, ah> paramb, E paramE, ak paramak)
  {
    AppMethodBeat.i(189390);
    try
    {
      paramb.invoke(paramE);
      AppMethodBeat.o(189390);
      return paramak;
    }
    finally
    {
      while ((paramak != null) && (paramak.getCause() != paramb)) {
        kotlin.b.a((Throwable)paramak, paramb);
      }
      paramb = new ak(s.X("Exception in undelivered element handler for ", paramE), paramb);
      AppMethodBeat.o(189390);
    }
    return paramb;
  }
  
  public static final <E> void a(kotlin.g.a.b<? super E, ah> paramb, E paramE, f paramf)
  {
    AppMethodBeat.i(189397);
    paramb = a(paramb, paramE, null);
    if (paramb != null) {
      an.b(paramf, (Throwable)paramb);
    }
    AppMethodBeat.o(189397);
  }
  
  public static final <E> kotlin.g.a.b<Throwable, ah> b(kotlin.g.a.b<? super E, ah> paramb, final E paramE, final f paramf)
  {
    AppMethodBeat.i(189406);
    paramb = (kotlin.g.a.b)new a(paramb, paramE, paramf);
    AppMethodBeat.o(189406);
    return paramb;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "E", "<anonymous parameter 0>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<Throwable, ah>
  {
    a(kotlin.g.a.b<? super E, ah> paramb, E paramE, f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.internal.v
 * JD-Core Version:    0.7.0.1
 */