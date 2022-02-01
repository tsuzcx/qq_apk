package d.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.j.b;
import d.j.c;
import d.l;
import java.lang.reflect.Method;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/internal/PlatformImplementations;", "", "()V", "addSuppressed", "", "cause", "", "exception", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "ReflectAddSuppressedMethod", "kotlin-stdlib"})
public class a
{
  public static c gfM()
  {
    AppMethodBeat.i(128996);
    c localc = (c)new b();
    AppMethodBeat.o(128996);
    return localc;
  }
  
  public void a(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    AppMethodBeat.i(128995);
    p.h(paramThrowable1, "cause");
    p.h(paramThrowable2, "exception");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.e.a
 * JD-Core Version:    0.7.0.1
 */