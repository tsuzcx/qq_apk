package kotlin.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.j.b;
import kotlin.j.c;

@Metadata(d1={""}, d2={"Lkotlin/internal/PlatformImplementations;", "", "()V", "addSuppressed", "", "cause", "", "exception", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "getSuppressed", "", "ReflectThrowable", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public class a
{
  public void a(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    AppMethodBeat.i(128995);
    s.u(paramThrowable1, "cause");
    s.u(paramThrowable2, "exception");
    Method localMethod = a.aiwy;
    if (localMethod != null)
    {
      localMethod.invoke(paramThrowable1, new Object[] { paramThrowable2 });
      AppMethodBeat.o(128995);
      return;
    }
    AppMethodBeat.o(128995);
  }
  
  public c klk()
  {
    AppMethodBeat.i(128996);
    c localc = (c)new b();
    AppMethodBeat.o(128996);
    return localc;
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/internal/PlatformImplementations$ReflectThrowable;", "", "()V", "addSuppressed", "Ljava/lang/reflect/Method;", "getSuppressed", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  static final class a
  {
    public static final a aiwA;
    public static final Method aiwy;
    public static final Method aiwz;
    
    static
    {
      Object localObject2 = null;
      AppMethodBeat.i(190879);
      aiwA = new a();
      Method[] arrayOfMethod = Throwable.class.getMethods();
      s.s(arrayOfMethod, "throwableMethods");
      int k = arrayOfMethod.length;
      int i = 0;
      Object localObject1;
      label97:
      int j;
      if (i < k)
      {
        Method localMethod = arrayOfMethod[i];
        s.s(localMethod, "it");
        if (s.p(localMethod.getName(), "addSuppressed"))
        {
          localObject1 = localMethod.getParameterTypes();
          s.s(localObject1, "it.parameterTypes");
          s.u(localObject1, "$this$singleOrNull");
          if (localObject1.length == 1)
          {
            localObject1 = localObject1[0];
            if (!s.p((Class)localObject1, Throwable.class)) {
              break label174;
            }
            j = 1;
            label111:
            if (j == 0) {
              break label179;
            }
            localObject1 = localMethod;
            label118:
            aiwy = (Method)localObject1;
            j = arrayOfMethod.length;
            i = 0;
          }
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (i < j)
        {
          localObject1 = arrayOfMethod[i];
          s.s(localObject1, "it");
          if (!s.p(((Method)localObject1).getName(), "getSuppressed")) {}
        }
        else
        {
          aiwz = (Method)localObject1;
          AppMethodBeat.o(190879);
          return;
          localObject1 = null;
          break label97;
          label174:
          j = 0;
          break label111;
          label179:
          i += 1;
          break;
          localObject1 = null;
          break label118;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.e.a
 * JD-Core Version:    0.7.0.1
 */