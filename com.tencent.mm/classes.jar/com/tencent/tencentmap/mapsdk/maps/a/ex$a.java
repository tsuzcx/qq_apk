package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class ex$a<K, V>
  extends eb<Map<K, V>>
{
  private final dk b;
  private final Type c;
  private final Type d;
  private final eb<K> e;
  private final eb<V> f;
  private final eo<? extends Map<K, V>> g;
  
  public ex$a(dk paramdk, Type paramType1, eb<K> parameb, Type paramType2, eb<V> parameb1, eo<? extends Map<K, V>> parameo)
  {
    AppMethodBeat.i(147703);
    this.b = paramType1;
    this.c = parameb;
    this.d = parameb1;
    this.e = new fc(paramType1, paramType2, parameb);
    this.f = new fc(paramType1, parameo, parameb1);
    Object localObject;
    this.g = localObject;
    AppMethodBeat.o(147703);
  }
  
  private String a(dq paramdq)
  {
    AppMethodBeat.i(147706);
    if (paramdq.k())
    {
      paramdq = paramdq.o();
      if (paramdq.q())
      {
        paramdq = String.valueOf(paramdq.b());
        AppMethodBeat.o(147706);
        return paramdq;
      }
      if (paramdq.a())
      {
        paramdq = Boolean.toString(paramdq.h());
        AppMethodBeat.o(147706);
        return paramdq;
      }
      if (paramdq.r())
      {
        paramdq = paramdq.c();
        AppMethodBeat.o(147706);
        return paramdq;
      }
      paramdq = new AssertionError();
      AppMethodBeat.o(147706);
      throw paramdq;
    }
    if (paramdq.l())
    {
      AppMethodBeat.o(147706);
      return "null";
    }
    paramdq = new AssertionError();
    AppMethodBeat.o(147706);
    throw paramdq;
  }
  
  public final Map<K, V> a(ff paramff)
  {
    AppMethodBeat.i(147704);
    Object localObject = paramff.f();
    if (localObject == fg.i)
    {
      paramff.j();
      AppMethodBeat.o(147704);
      return null;
    }
    Map localMap = (Map)this.g.a();
    if (localObject == fg.a)
    {
      paramff.a();
      while (paramff.e())
      {
        paramff.a();
        localObject = this.e.b(paramff);
        if (localMap.put(localObject, this.f.b(paramff)) != null)
        {
          paramff = new dy("duplicate key: ".concat(String.valueOf(localObject)));
          AppMethodBeat.o(147704);
          throw paramff;
        }
        paramff.b();
      }
      paramff.b();
    }
    for (;;)
    {
      AppMethodBeat.o(147704);
      return localMap;
      paramff.c();
      while (paramff.e())
      {
        el.a.a(paramff);
        localObject = this.e.b(paramff);
        if (localMap.put(localObject, this.f.b(paramff)) != null)
        {
          paramff = new dy("duplicate key: ".concat(String.valueOf(localObject)));
          AppMethodBeat.o(147704);
          throw paramff;
        }
      }
      paramff.d();
    }
  }
  
  public final void a(fh paramfh, Map<K, V> paramMap)
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(147705);
    if (paramMap == null)
    {
      paramfh.f();
      AppMethodBeat.o(147705);
      return;
    }
    if (!ex.a(this.a))
    {
      paramfh.d();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        localObject = (Map.Entry)paramMap.next();
        paramfh.a(String.valueOf(((Map.Entry)localObject).getKey()));
        this.f.a(paramfh, ((Map.Entry)localObject).getValue());
      }
      paramfh.e();
      AppMethodBeat.o(147705);
      return;
    }
    Object localObject = new ArrayList(paramMap.size());
    ArrayList localArrayList = new ArrayList(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    int i = 0;
    if (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      dq localdq = this.e.a(localEntry.getKey());
      ((List)localObject).add(localdq);
      localArrayList.add(localEntry.getValue());
      if ((localdq.i()) || (localdq.j())) {}
      for (int j = 1;; j = 0)
      {
        i = j | i;
        break;
      }
    }
    if (i != 0)
    {
      paramfh.b();
      i = k;
      while (i < ((List)localObject).size())
      {
        paramfh.b();
        eq.a((dq)((List)localObject).get(i), paramfh);
        this.f.a(paramfh, localArrayList.get(i));
        paramfh.c();
        i += 1;
      }
      paramfh.c();
      AppMethodBeat.o(147705);
      return;
    }
    paramfh.d();
    i = m;
    while (i < ((List)localObject).size())
    {
      paramfh.a(a((dq)((List)localObject).get(i)));
      this.f.a(paramfh, localArrayList.get(i));
      i += 1;
    }
    paramfh.e();
    AppMethodBeat.o(147705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ex.a
 * JD-Core Version:    0.7.0.1
 */