package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.l.b.a.c.a;
import kotlin.l.b.a.c.b;
import kotlin.l.b.a.c.e;

@Metadata(d1={""}, d2={"K_CLASS_CACHE", "Lkotlin/reflect/jvm/internal/pcollections/HashPMap;", "", "kotlin.jvm.PlatformType", "", "clearKClassCache", "", "getOrCreateKotlinClass", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "jClass", "Ljava/lang/Class;", "kotlin-reflection"}, k=2, mv={1, 5, 1})
public final class g
{
  private static b<String, Object> aiyx;
  
  static
  {
    AppMethodBeat.i(56305);
    b localb = b.kBg();
    s.s(localb, "HashPMap.empty<String, Any>()");
    aiyx = localb;
    AppMethodBeat.o(56305);
  }
  
  public static final <T> h<T> cA(Class<T> paramClass)
  {
    Object localObject2 = null;
    AppMethodBeat.i(56304);
    s.u(paramClass, "jClass");
    String str = paramClass.getName();
    Object localObject1 = aiyx.aMx(str.hashCode());
    Object localObject3;
    if ((localObject1 != null) && (((a)localObject1).size > 0))
    {
      localObject3 = (e)((a)localObject1).bsC;
      if (!((e)localObject3).key.equals(str)) {}
    }
    for (localObject1 = ((e)localObject3).value;; localObject1 = null)
    {
      if (!(localObject1 instanceof WeakReference)) {
        break label133;
      }
      localObject3 = (h)((WeakReference)localObject1).get();
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((h)localObject3).aiwN;
      }
      if (!s.p(localObject1, paramClass)) {
        break label280;
      }
      AppMethodBeat.o(56304);
      return localObject3;
      localObject1 = ((a)localObject1).ajtN;
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
        h localh = (h)localObject3[i].get();
        if (localh != null) {}
        for (localObject2 = localh.aiwN; s.p(localObject2, paramClass); localObject2 = null)
        {
          AppMethodBeat.o(56304);
          return localh;
        }
        i += 1;
      }
      i = ((Object[])localObject1).length;
      localObject2 = new WeakReference[i + 1];
      System.arraycopy(localObject1, 0, localObject2, 0, i);
      paramClass = new h(paramClass);
      localObject2[i] = new WeakReference(paramClass);
      localObject1 = aiyx.ab(str, localObject2);
      s.s(localObject1, "K_CLASS_CACHE.plus(name, newArray)");
      aiyx = (b)localObject1;
      AppMethodBeat.o(56304);
      return paramClass;
    }
    label280:
    paramClass = new h(paramClass);
    localObject1 = aiyx.ab(str, new WeakReference(paramClass));
    s.s(localObject1, "K_CLASS_CACHE.plus(name, WeakReference(newKClass))");
    aiyx = (b)localObject1;
    AppMethodBeat.o(56304);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.g
 * JD-Core Version:    0.7.0.1
 */