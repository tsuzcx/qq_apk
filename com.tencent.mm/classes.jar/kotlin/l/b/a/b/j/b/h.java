package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;

public final class h
{
  public static final h abkY;
  
  static
  {
    AppMethodBeat.i(60059);
    abkY = new h();
    AppMethodBeat.o(60059);
  }
  
  private final b a(List<?> paramList, kotlin.l.b.a.b.a.h paramh)
  {
    AppMethodBeat.i(60058);
    Object localObject1 = (Iterable)j.p((Iterable)paramList);
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      localObject2 = ((h)this).fF(localObject2);
      if (localObject2 != null) {
        paramList.add(localObject2);
      }
    }
    paramList = new b((List)paramList, (kotlin.g.a.b)new b(paramh));
    AppMethodBeat.o(60058);
    return paramList;
  }
  
  public static b a(List<? extends g<?>> paramList, ab paramab)
  {
    AppMethodBeat.i(60056);
    p.k(paramList, "value");
    p.k(paramab, "type");
    paramList = new b(paramList, (kotlin.g.a.b)new a(paramab));
    AppMethodBeat.o(60056);
    return paramList;
  }
  
  public final g<?> fF(Object paramObject)
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
      paramObject = (g)a(kotlin.a.e.dD((byte[])paramObject), kotlin.l.b.a.b.a.h.aaHq);
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof short[]))
    {
      paramObject = (g)a(kotlin.a.e.b((short[])paramObject), kotlin.l.b.a.b.a.h.aaHr);
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof int[]))
    {
      paramObject = (g)a(kotlin.a.e.X((int[])paramObject), kotlin.l.b.a.b.a.h.aaHs);
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof long[]))
    {
      paramObject = (g)a(kotlin.a.e.h((long[])paramObject), kotlin.l.b.a.b.a.h.aaHu);
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof char[]))
    {
      paramObject = (g)a(kotlin.a.e.f((char[])paramObject), kotlin.l.b.a.b.a.h.aaHp);
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof float[]))
    {
      paramObject = (g)a(kotlin.a.e.t((float[])paramObject), kotlin.l.b.a.b.a.h.aaHt);
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof double[]))
    {
      paramObject = (g)a(kotlin.a.e.d((double[])paramObject), kotlin.l.b.a.b.a.h.aaHv);
      AppMethodBeat.o(60057);
      return paramObject;
    }
    if ((paramObject instanceof boolean[]))
    {
      paramObject = (g)a(kotlin.a.e.d((boolean[])paramObject), kotlin.l.b.a.b.a.h.aaHo);
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
    extends q
    implements kotlin.g.a.b<y, ab>
  {
    a(ab paramab)
    {
      super();
    }
  }
  
  static final class b
    extends q
    implements kotlin.g.a.b<y, aj>
  {
    b(kotlin.l.b.a.b.a.h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.j.b.h
 * JD-Core Version:    0.7.0.1
 */