package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.k;
import kotlin.a.p;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.m.ad;

public final class h
{
  public static final h ajjE;
  
  static
  {
    AppMethodBeat.i(60059);
    ajjE = new h();
    AppMethodBeat.o(60059);
  }
  
  private final b a(List<?> paramList, kotlin.l.b.a.b.a.i parami)
  {
    AppMethodBeat.i(60058);
    Object localObject = (Iterable)p.p((Iterable)paramList);
    paramList = (Collection)new ArrayList();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      g localg = jdMethod_if(((Iterator)localObject).next());
      if (localg != null) {
        paramList.add(localg);
      }
    }
    paramList = new b((List)paramList, (kotlin.g.a.b)new b(parami));
    AppMethodBeat.o(60058);
    return paramList;
  }
  
  public static b a(List<? extends g<?>> paramList, ad paramad)
  {
    AppMethodBeat.i(60056);
    kotlin.g.b.s.u(paramList, "value");
    kotlin.g.b.s.u(paramad, "type");
    paramList = new b(paramList, (kotlin.g.a.b)new a(paramad));
    AppMethodBeat.o(60056);
    return paramList;
  }
  
  public final g<?> jdMethod_if(Object paramObject)
  {
    AppMethodBeat.i(60057);
    if ((paramObject instanceof Byte))
    {
      paramObject = (g)new d(((Number)paramObject).byteValue());
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof Short))
    {
      paramObject = (g)new t(((Number)paramObject).shortValue());
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof Integer))
    {
      paramObject = (g)new m(((Number)paramObject).intValue());
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof Long))
    {
      paramObject = (g)new r(((Number)paramObject).longValue());
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof Character))
    {
      paramObject = (g)new e(((Character)paramObject).charValue());
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof Float))
    {
      paramObject = (g)new l(((Number)paramObject).floatValue());
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof Double))
    {
      paramObject = (g)new i(((Number)paramObject).doubleValue());
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof Boolean))
    {
      paramObject = (g)new c(((Boolean)paramObject).booleanValue());
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof String))
    {
      paramObject = (g)new u((String)paramObject);
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof byte[]))
    {
      paramObject = (g)a(k.dF((byte[])paramObject), kotlin.l.b.a.b.a.i.aiBJ);
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof short[]))
    {
      paramObject = (g)a(k.d((short[])paramObject), kotlin.l.b.a.b.a.i.aiBK);
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof int[]))
    {
      paramObject = (g)a(k.ae((int[])paramObject), kotlin.l.b.a.b.a.i.aiBL);
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof long[]))
    {
      paramObject = (g)a(k.k((long[])paramObject), kotlin.l.b.a.b.a.i.aiBN);
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof char[]))
    {
      paramObject = (g)a(k.f((char[])paramObject), kotlin.l.b.a.b.a.i.aiBI);
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof float[]))
    {
      paramObject = (g)a(k.D((float[])paramObject), kotlin.l.b.a.b.a.i.aiBM);
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof double[]))
    {
      paramObject = (g)a(k.f((double[])paramObject), kotlin.l.b.a.b.a.i.aiBO);
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof boolean[]))
    {
      paramObject = (g)a(k.f((boolean[])paramObject), kotlin.l.b.a.b.a.i.aiBH);
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if (paramObject == null)
    {
      paramObject = (g)new s();
      AppMethodBeat.o(60057);
      return paramObject;
    }
    AppMethodBeat.o(60057);
    return null;
  }
  
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.b<ae, ad>
  {
    a(ad paramad)
    {
      super();
    }
  }
  
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.b<ae, ad>
  {
    b(kotlin.l.b.a.b.a.i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.b.h
 * JD-Core Version:    0.7.0.1
 */