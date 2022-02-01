package d.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.k;
import d.l.b.a.b.b.y;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.aj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class h
{
  public static final h LFu;
  
  static
  {
    AppMethodBeat.i(60059);
    LFu = new h();
    AppMethodBeat.o(60059);
  }
  
  private final b a(List<?> paramList, d.l.b.a.b.a.h paramh)
  {
    AppMethodBeat.i(60058);
    Object localObject1 = (Iterable)j.l((Iterable)paramList);
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      localObject2 = ((h)this).fq(localObject2);
      if (localObject2 != null) {
        paramList.add(localObject2);
      }
    }
    paramList = new b((List)paramList, (d.g.a.b)new b(paramh));
    AppMethodBeat.o(60058);
    return paramList;
  }
  
  public static b a(List<? extends g<?>> paramList, ab paramab)
  {
    AppMethodBeat.i(60056);
    k.h(paramList, "value");
    k.h(paramab, "type");
    paramList = new b(paramList, (d.g.a.b)new a(paramab));
    AppMethodBeat.o(60056);
    return paramList;
  }
  
  public final g<?> fq(Object paramObject)
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
      paramObject = (g)new u(((Number)paramObject).shortValue());
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
      paramObject = (g)new s(((Number)paramObject).longValue());
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
      paramObject = (g)new v((String)paramObject);
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof byte[]))
    {
      paramObject = (g)a(d.a.e.cQ((byte[])paramObject), d.l.b.a.b.a.h.LaO);
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof short[]))
    {
      paramObject = (g)a(d.a.e.b((short[])paramObject), d.l.b.a.b.a.h.LaP);
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof int[]))
    {
      paramObject = (g)a(d.a.e.P((int[])paramObject), d.l.b.a.b.a.h.LaQ);
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof long[]))
    {
      paramObject = (g)a(d.a.e.f((long[])paramObject), d.l.b.a.b.a.h.LaS);
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof char[]))
    {
      paramObject = (g)a(d.a.e.d((char[])paramObject), d.l.b.a.b.a.h.LaN);
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof float[]))
    {
      paramObject = (g)a(d.a.e.s((float[])paramObject), d.l.b.a.b.a.h.LaR);
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof double[]))
    {
      paramObject = (g)a(d.a.e.d((double[])paramObject), d.l.b.a.b.a.h.LaT);
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof boolean[]))
    {
      paramObject = (g)a(d.a.e.d((boolean[])paramObject), d.l.b.a.b.a.h.LaM);
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if (paramObject == null)
    {
      paramObject = (g)new t();
      AppMethodBeat.o(60057);
      return paramObject;
    }
    AppMethodBeat.o(60057);
    return null;
  }
  
  static final class a
    extends d.g.b.l
    implements d.g.a.b<y, ab>
  {
    a(ab paramab)
    {
      super();
    }
  }
  
  static final class b
    extends d.g.b.l
    implements d.g.a.b<y, aj>
  {
    b(d.l.b.a.b.a.h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.b.h
 * JD-Core Version:    0.7.0.1
 */