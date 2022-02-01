package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.l.b.a.c.a;
import kotlin.l.b.a.c.b;
import kotlin.l.b.a.c.e;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"K_CLASS_CACHE", "Lkotlin/reflect/jvm/internal/pcollections/HashPMap;", "", "kotlin.jvm.PlatformType", "", "clearKClassCache", "", "getOrCreateKotlinClass", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "jClass", "Ljava/lang/Class;", "kotlin-reflection"})
public final class f
{
  private static b<String, Object> SZU;
  
  static
  {
    AppMethodBeat.i(56305);
    b localb = b.hMb();
    p.g(localb, "HashPMap.empty<String, Any>()");
    SZU = localb;
    AppMethodBeat.o(56305);
  }
  
  public static final <T> g<T> bq(Class<T> paramClass)
  {
    Object localObject2 = null;
    AppMethodBeat.i(56304);
    p.h(paramClass, "jClass");
    String str = paramClass.getName();
    Object localObject1 = SZU.avQ(str.hashCode());
    Object localObject3;
    if ((localObject1 != null) && (((a)localObject1).size > 0))
    {
      localObject3 = (e)((a)localObject1).first;
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
        localObject1 = ((g)localObject3).SYp;
      }
      if (!p.j(localObject1, paramClass)) {
        break label280;
      }
      AppMethodBeat.o(56304);
      return localObject3;
      localObject1 = ((a)localObject1).TSj;
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
        for (localObject2 = localg.SYp; p.j(localObject2, paramClass); localObject2 = null)
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
      localObject1 = SZU.X(str, localObject2);
      p.g(localObject1, "K_CLASS_CACHE.plus(name, newArray)");
      SZU = (b)localObject1;
      AppMethodBeat.o(56304);
      return paramClass;
    }
    label280:
    paramClass = new g(paramClass);
    localObject1 = SZU.X(str, new WeakReference(paramClass));
    p.g(localObject1, "K_CLASS_CACHE.plus(name, WeakReference(newKClass))");
    SZU = (b)localObject1;
    AppMethodBeat.o(56304);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.f
 * JD-Core Version:    0.7.0.1
 */