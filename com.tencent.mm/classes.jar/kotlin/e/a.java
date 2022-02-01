package kotlin.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import kotlin.g.b.p;
import kotlin.j.b;
import kotlin.j.c;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/internal/PlatformImplementations;", "", "()V", "addSuppressed", "", "cause", "", "exception", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "ReflectAddSuppressedMethod", "kotlin-stdlib"})
public class a
{
  public static c iBV()
  {
    AppMethodBeat.i(128996);
    c localc = (c)new b();
    AppMethodBeat.o(128996);
    return localc;
  }
  
  public void a(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    AppMethodBeat.i(128995);
    p.k(paramThrowable1, "cause");
    p.k(paramThrowable2, "exception");
    Method localMethod = a.a.method;
    if (localMethod != null)
    {
      localMethod.invoke(paramThrowable1, new Object[] { paramThrowable2 });
      AppMethodBeat.o(128995);
      return;
    }
    AppMethodBeat.o(128995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.e.a
 * JD-Core Version:    0.7.0.1
 */