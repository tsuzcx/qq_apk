package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.l.b.a.c.a;
import kotlin.l.b.a.c.b;
import kotlin.l.b.a.c.e;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"K_CLASS_CACHE", "Lkotlin/reflect/jvm/internal/pcollections/HashPMap;", "", "kotlin.jvm.PlatformType", "", "clearKClassCache", "", "getOrCreateKotlinClass", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "jClass", "Ljava/lang/Class;", "kotlin-reflection"})
public final class f
{
  private static b<String, Object> aaCO;
  
  static
  {
    AppMethodBeat.i(56305);
    b localb = b.iQs();
    p.j(localb, "HashPMap.empty<String, Any>()");
    aaCO = localb;
    AppMethodBeat.o(56305);
  }
  
  public static final <T> g<T> bP(Class<T> paramClass)
  {
    Object localObject2 = null;
    AppMethodBeat.i(56304);
    p.k(paramClass, "jClass");
    String str = paramClass.getName();
    Object localObject1 = aaCO.aFK(str.hashCode());
    Object localObject3;
    if ((localObject1 != null) && (((a)localObject1).size > 0))
    {
      localObject3 = (e)((a)localObject1).Mx;
      if (!((e)localObject3).key.equals(str)) {}
    }
    for (localObject1 = ((e)localObject3).value;; localObject1 = null)
    {
      if (!(localObject1 instanceof WeakReference)) {
        break label133;
      }
      localObject3 = (g)((WeakReference)localObject1).get();
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((g)localObject3).aaBb;
      }
      if (!p.h(localObject1, paramClass)) {
        break label280;
      }
      AppMethodBeat.o(56304);
      return localObject3;
      localObject1 = ((a)localObject1).abuI;
      break;
    }
    label133:
    if (localObject1 != null)
    {
      localObject3 = (WeakReference[])localObject1;
      int j = localObject3.length;
      int i = 0;
      while (i < j)
      {
        g localg = (g)localObject3[i].get();
        if (localg != null) {}
        for (localObject2 = localg.aaBb; p.h(localObject2, paramClass); localObject2 = null)
        {
          AppMethodBeat.o(56304);
          return localg;
        }
        i += 1;
      }
      i = ((Object[])localObject1).length;
      localObject2 = new WeakReference[i + 1];
      System.arraycopy(localObject1, 0, localObject2, 0, i);
      paramClass = new g(paramClass);
      localObject2[i] = new WeakReference(paramClass);
      localObject1 = aaCO.P(str, localObject2);
      p.j(localObject1, "K_CLASS_CACHE.plus(name, newArray)");
      aaCO = (b)localObject1;
      AppMethodBeat.o(56304);
      return paramClass;
    }
    label280:
    paramClass = new g(paramClass);
    localObject1 = aaCO.P(str, new WeakReference(paramClass));
    p.j(localObject1, "K_CLASS_CACHE.plus(name, WeakReference(newKClass))");
    aaCO = (b)localObject1;
    AppMethodBeat.o(56304);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.f
 * JD-Core Version:    0.7.0.1
 */