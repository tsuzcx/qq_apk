package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class dl
{
  private ek a;
  private dz b;
  private dj c;
  private final Map<Type, dm<?>> d;
  private final List<ec> e;
  private final List<ec> f;
  private boolean g;
  private String h;
  private int i;
  private int j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  
  public dl()
  {
    AppMethodBeat.i(98717);
    this.a = ek.a;
    this.b = dz.a;
    this.c = di.a;
    this.d = new HashMap();
    this.e = new ArrayList();
    this.f = new ArrayList();
    this.i = 2;
    this.j = 2;
    this.m = true;
    AppMethodBeat.o(98717);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, List<ec> paramList)
  {
    AppMethodBeat.i(147486);
    if ((paramString != null) && (!"".equals(paramString.trim()))) {}
    for (paramString = new df(paramString);; paramString = new df(paramInt1, paramInt2))
    {
      paramList.add(ea.a(fe.b(java.util.Date.class), paramString));
      paramList.add(ea.a(fe.b(Timestamp.class), paramString));
      paramList.add(ea.a(fe.b(java.sql.Date.class), paramString));
      AppMethodBeat.o(147486);
      return;
      if ((paramInt1 == 2) || (paramInt2 == 2)) {
        break;
      }
    }
    AppMethodBeat.o(147486);
  }
  
  public final dk a()
  {
    AppMethodBeat.i(147485);
    Object localObject = new ArrayList();
    ((List)localObject).addAll(this.e);
    Collections.reverse((List)localObject);
    ((List)localObject).addAll(this.f);
    a(this.h, this.i, this.j, (List)localObject);
    localObject = new dk(this.a, this.c, this.d, this.g, this.k, this.o, this.m, this.n, this.l, this.b, (List)localObject);
    AppMethodBeat.o(147485);
    return localObject;
  }
  
  public final dl a(Type paramType, Object paramObject)
  {
    AppMethodBeat.i(147484);
    if (((paramObject instanceof dx)) || ((paramObject instanceof dp)) || ((paramObject instanceof dm)) || ((paramObject instanceof eb))) {}
    for (boolean bool = true;; bool = false)
    {
      eh.a(bool);
      if ((paramObject instanceof dm)) {
        this.d.put(paramType, (dm)paramObject);
      }
      if (((paramObject instanceof dx)) || ((paramObject instanceof dp)))
      {
        fe localfe = fe.a(paramType);
        this.e.add(ea.b(localfe, paramObject));
      }
      if ((paramObject instanceof eb)) {
        this.e.add(fd.a(fe.a(paramType), (eb)paramObject));
      }
      AppMethodBeat.o(147484);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.dl
 * JD-Core Version:    0.7.0.1
 */