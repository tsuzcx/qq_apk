package kotlin.l.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.l.b.a.aa;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.f;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.c;
import kotlin.l.d;
import kotlin.l.u;

@Metadata(d1={""}, d2={"jvmErasure", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/KClassifier;", "getJvmErasure", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KClass;", "Lkotlin/reflect/KType;", "getJvmErasure$annotations", "(Lkotlin/reflect/KType;)V", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KClass;", "kotlin-reflection"}, k=2, mv={1, 5, 1})
public final class a
{
  public static final c<?> a(d paramd)
  {
    AppMethodBeat.i(56267);
    s.u(paramd, "$this$jvmErasure");
    if ((paramd instanceof c))
    {
      paramd = (c)paramd;
      AppMethodBeat.o(56267);
      return paramd;
    }
    if ((paramd instanceof kotlin.l.v))
    {
      List localList = ((kotlin.l.v)paramd).klF();
      Iterator localIterator = ((Iterable)localList).iterator();
      Object localObject;
      int i;
      if (localIterator.hasNext())
      {
        localObject = localIterator.next();
        paramd = (u)localObject;
        if (paramd == null)
        {
          paramd = new NullPointerException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
          AppMethodBeat.o(56267);
          throw paramd;
        }
        h localh = ((kotlin.l.b.a.v)paramd).aiAd.kzm().knA();
        paramd = localh;
        if (!(localh instanceof e)) {
          paramd = null;
        }
        paramd = (e)paramd;
        if ((paramd != null) && (paramd.kna() != f.aiGu) && (paramd.kna() != f.aiGx))
        {
          i = 1;
          label166:
          if (i == 0) {
            break label221;
          }
        }
      }
      for (paramd = (d)localObject;; paramd = null)
      {
        localObject = (u)paramd;
        paramd = (d)localObject;
        if (localObject == null) {
          paramd = (u)p.oL(localList);
        }
        if (paramd != null)
        {
          paramd = c(paramd);
          if (paramd != null) {
            break label255;
          }
        }
        paramd = ai.cz(Object.class);
        AppMethodBeat.o(56267);
        return paramd;
        i = 0;
        break label166;
        label221:
        break;
      }
    }
    paramd = (Throwable)new aa("Cannot calculate JVM erasure for type: ".concat(String.valueOf(paramd)));
    AppMethodBeat.o(56267);
    throw paramd;
    label255:
    AppMethodBeat.o(56267);
    return paramd;
  }
  
  public static final c<?> c(u paramu)
  {
    AppMethodBeat.i(56266);
    s.u(paramu, "$this$jvmErasure");
    Object localObject = paramu.klQ();
    if (localObject != null)
    {
      localObject = a((d)localObject);
      if (localObject != null) {}
    }
    else
    {
      paramu = (Throwable)new aa("Cannot calculate JVM erasure for type: ".concat(String.valueOf(paramu)));
      AppMethodBeat.o(56266);
      throw paramu;
    }
    AppMethodBeat.o(56266);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a
 * JD-Core Version:    0.7.0.1
 */