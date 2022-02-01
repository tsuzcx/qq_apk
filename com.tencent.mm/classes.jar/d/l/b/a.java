package d.l.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.k;
import d.g.b.w;
import d.l;
import d.l.b;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.f;
import d.l.b.a.b.b.h;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.at;
import d.l.b.a.u;
import d.l.b.a.x;
import d.l.c;
import d.l.o;
import d.l.p;
import d.v;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 15}, fvu={""}, fvv={"jvmErasure", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/KClassifier;", "getJvmErasure", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KClass;", "Lkotlin/reflect/KType;", "jvmErasure$annotations", "(Lkotlin/reflect/KType;)V", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KClass;", "kotlin-reflection"})
public final class a
{
  public static final b<?> a(c paramc)
  {
    AppMethodBeat.i(56267);
    k.h(paramc, "$this$jvmErasure");
    if ((paramc instanceof b))
    {
      paramc = (b)paramc;
      AppMethodBeat.o(56267);
      return paramc;
    }
    if ((paramc instanceof p))
    {
      List localList = ((p)paramc).fwf();
      Iterator localIterator = ((Iterable)localList).iterator();
      Object localObject;
      int i;
      if (localIterator.hasNext())
      {
        localObject = localIterator.next();
        paramc = (o)localObject;
        if (paramc == null)
        {
          paramc = new v("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
          AppMethodBeat.o(56267);
          throw paramc;
        }
        h localh = ((u)paramc).Jko.fIW().fxM();
        paramc = localh;
        if (!(localh instanceof e)) {
          paramc = null;
        }
        paramc = (e)paramc;
        if ((paramc != null) && (paramc.fxu() != f.Jqe) && (paramc.fxu() != f.Jqh))
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
          paramc = (o)j.iz(localList);
        }
        if (paramc != null)
        {
          paramc = a(paramc);
          if (paramc != null) {
            break label255;
          }
        }
        paramc = w.bk(Object.class);
        AppMethodBeat.o(56267);
        return paramc;
        i = 0;
        break label166;
        label221:
        break;
      }
    }
    paramc = (Throwable)new x("Cannot calculate JVM erasure for type: ".concat(String.valueOf(paramc)));
    AppMethodBeat.o(56267);
    throw paramc;
    label255:
    AppMethodBeat.o(56267);
    return paramc;
  }
  
  private static b<?> a(o paramo)
  {
    AppMethodBeat.i(56266);
    k.h(paramo, "$this$jvmErasure");
    Object localObject = paramo.fwe();
    if (localObject != null)
    {
      localObject = a((c)localObject);
      if (localObject != null) {}
    }
    else
    {
      paramo = (Throwable)new x("Cannot calculate JVM erasure for type: ".concat(String.valueOf(paramo)));
      AppMethodBeat.o(56266);
      throw paramo;
    }
    AppMethodBeat.o(56266);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a
 * JD-Core Version:    0.7.0.1
 */