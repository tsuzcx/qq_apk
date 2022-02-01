package kotlin.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import kotlin.g.b.p;
import kotlin.j.b;
import kotlin.j.c;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/internal/PlatformImplementations;", "", "()V", "addSuppressed", "", "cause", "", "exception", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "ReflectAddSuppressedMethod", "kotlin-stdlib"})
public class a
{
  public static c hxN()
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
    Method localMethod = a.method;
    if (localMethod != null)
    {
      localMethod.invoke(paramThrowable1, new Object[] { paramThrowable2 });
      AppMethodBeat.o(128995);
      return;
    }
    AppMethodBeat.o(128995);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/internal/PlatformImplementations$ReflectAddSuppressedMethod;", "", "()V", "method", "Ljava/lang/reflect/Method;", "kotlin-stdlib"})
  static final class a
  {
    public static final a SYd;
    public static final Method method;
    
    static
    {
      Object localObject2 = null;
      AppMethodBeat.i(128990);
      SYd = new a();
      Method[] arrayOfMethod = Throwable.class.getMethods();
      p.g(arrayOfMethod, "throwableClass.methods");
      int k = arrayOfMethod.length;
      int i = 0;
      for (;;)
      {
        Object localObject1 = localObject2;
        Method localMethod;
        if (i < k)
        {
          localMethod = arrayOfMethod[i];
          p.g(localMethod, "it");
          if (!p.j(localMethod.getName(), "addSuppressed")) {
            break label136;
          }
          localObject1 = localMethod.getParameterTypes();
          p.g(localObject1, "it.parameterTypes");
          p.h(localObject1, "$this$singleOrNull");
          if (localObject1.length != 1) {
            break label131;
          }
          localObject1 = localObject1[0];
          if (!p.j((Class)localObject1, Throwable.class)) {
            break label136;
          }
        }
        label131:
        label136:
        for (int j = 1;; j = 0)
        {
          if (j == 0) {
            break label141;
          }
          localObject1 = localMethod;
          method = (Method)localObject1;
          AppMethodBeat.o(128990);
          return;
          localObject1 = null;
          break;
        }
        label141:
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.e.a
 * JD-Core Version:    0.7.0.1
 */