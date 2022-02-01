package kotlin.l.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.l.b;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.f;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.w;
import kotlin.l.c;
import kotlin.l.u;
import kotlin.l.v;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"jvmErasure", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/KClassifier;", "getJvmErasure", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KClass;", "Lkotlin/reflect/KType;", "jvmErasure$annotations", "(Lkotlin/reflect/KType;)V", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KClass;", "kotlin-reflection"})
public final class a
{
  public static final b<?> a(c paramc)
  {
    AppMethodBeat.i(56267);
    p.k(paramc, "$this$jvmErasure");
    if ((paramc instanceof b))
    {
      paramc = (b)paramc;
      AppMethodBeat.o(56267);
      return paramc;
    }
    if ((paramc instanceof v))
    {
      List localList = ((v)paramc).iCz();
      Iterator localIterator = ((Iterable)localList).iterator();
      Object localObject;
      int i;
      if (localIterator.hasNext())
      {
        localObject = localIterator.next();
        paramc = (u)localObject;
        if (paramc == null)
        {
          paramc = new kotlin.t("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
          AppMethodBeat.o(56267);
          throw paramc;
        }
        h localh = ((kotlin.l.b.a.t)paramc).aaEm.iOU().iEf();
        paramc = localh;
        if (!(localh instanceof e)) {
          paramc = null;
        }
        paramc = (e)paramc;
        if ((paramc != null) && (paramc.iDN() != f.aaJZ) && (paramc.iDN() != f.aaKc))
        {
          i = 1;
          label166:
          if (i == 0) {
            break label221;
          }
        }
      }
      for (paramc = (c)localObject;; paramc = null)
      {
        localObject = (u)paramc;
        paramc = (c)localObject;
        if (localObject == null) {
          paramc = (u)j.lp(localList);
        }
        if (paramc != null)
        {
          paramc = a(paramc);
          if (paramc != null) {
            break label255;
          }
        }
        paramc = kotlin.g.b.ab.bO(Object.class);
        AppMethodBeat.o(56267);
        return paramc;
        i = 0;
        break label166;
        label221:
        break;
      }
    }
    paramc = (Throwable)new w("Cannot calculate JVM erasure for type: ".concat(String.valueOf(paramc)));
    AppMethodBeat.o(56267);
    throw paramc;
    label255:
    AppMethodBeat.o(56267);
    return paramc;
  }
  
  private static b<?> a(u paramu)
  {
    AppMethodBeat.i(56266);
    p.k(paramu, "$this$jvmErasure");
    Object localObject = paramu.iCy();
    if (localObject != null)
    {
      localObject = a((c)localObject);
      if (localObject != null) {}
    }
    else
    {
      paramu = (Throwable)new w("Cannot calculate JVM erasure for type: ".concat(String.valueOf(paramu)));
      AppMethodBeat.o(56266);
      throw paramu;
    }
    AppMethodBeat.o(56266);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a
 * JD-Core Version:    0.7.0.1
 */