package kotlin.l.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.aa;
import kotlin.l;
import kotlin.l.b;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.f;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.w;
import kotlin.l.c;
import kotlin.l.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"jvmErasure", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/KClassifier;", "getJvmErasure", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KClass;", "Lkotlin/reflect/KType;", "jvmErasure$annotations", "(Lkotlin/reflect/KType;)V", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KClass;", "kotlin-reflection"})
public final class a
{
  public static final b<?> a(c paramc)
  {
    AppMethodBeat.i(56267);
    kotlin.g.b.p.h(paramc, "$this$jvmErasure");
    if ((paramc instanceof b))
    {
      paramc = (b)paramc;
      AppMethodBeat.o(56267);
      return paramc;
    }
    if ((paramc instanceof kotlin.l.p))
    {
      List localList = ((kotlin.l.p)paramc).hyo();
      Iterator localIterator = ((Iterable)localList).iterator();
      Object localObject;
      int i;
      if (localIterator.hasNext())
      {
        localObject = localIterator.next();
        paramc = (o)localObject;
        if (paramc == null)
        {
          paramc = new kotlin.t("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
          AppMethodBeat.o(56267);
          throw paramc;
        }
        h localh = ((kotlin.l.b.a.t)paramc).Tbs.hKE().hzS();
        paramc = localh;
        if (!(localh instanceof e)) {
          paramc = null;
        }
        paramc = (e)paramc;
        if ((paramc != null) && (paramc.hzB() != f.Thf) && (paramc.hzB() != f.Thi))
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
        localObject = (o)paramc;
        paramc = (c)localObject;
        if (localObject == null) {
          paramc = (o)j.kt(localList);
        }
        if (paramc != null)
        {
          paramc = a(paramc);
          if (paramc != null) {
            break label255;
          }
        }
        paramc = aa.bp(Object.class);
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
  
  private static b<?> a(o paramo)
  {
    AppMethodBeat.i(56266);
    kotlin.g.b.p.h(paramo, "$this$jvmErasure");
    Object localObject = paramo.hyn();
    if (localObject != null)
    {
      localObject = a((c)localObject);
      if (localObject != null) {}
    }
    else
    {
      paramo = (Throwable)new w("Cannot calculate JVM erasure for type: ".concat(String.valueOf(paramo)));
      AppMethodBeat.o(56266);
      throw paramo;
    }
    AppMethodBeat.o(56266);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a
 * JD-Core Version:    0.7.0.1
 */