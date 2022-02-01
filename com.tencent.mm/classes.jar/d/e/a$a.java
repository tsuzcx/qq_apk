package d.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.lang.reflect.Method;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/internal/PlatformImplementations$ReflectAddSuppressedMethod;", "", "()V", "method", "Ljava/lang/reflect/Method;", "kotlin-stdlib"})
final class a$a
{
  public static final a MLu;
  public static final Method method;
  
  static
  {
    Object localObject2 = null;
    AppMethodBeat.i(128990);
    MLu = new a();
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
        if (!p.i(localMethod.getName(), "addSuppressed")) {
          break label136;
        }
        localObject1 = localMethod.getParameterTypes();
        p.g(localObject1, "it.parameterTypes");
        p.h(localObject1, "$this$singleOrNull");
        if (localObject1.length != 1) {
          break label131;
        }
        localObject1 = localObject1[0];
        if (!p.i((Class)localObject1, Throwable.class)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     d.e.a.a
 * JD-Core Version:    0.7.0.1
 */