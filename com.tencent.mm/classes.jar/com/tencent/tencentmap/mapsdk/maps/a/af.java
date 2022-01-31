package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class af
{
  public static String a;
  private static String b;
  private static Map<Integer, af.a> c;
  private static Map<String, af.a> d;
  private static an.a e;
  
  static
  {
    AppMethodBeat.i(147212);
    b = "AccessIpMgr";
    c = new ConcurrentHashMap();
    d = new ConcurrentHashMap();
    e = new an.a();
    AppMethodBeat.o(147212);
  }
  
  public static al a(String paramString)
  {
    AppMethodBeat.i(147209);
    Object localObject = (af.a)d.get(paramString);
    if (localObject != null)
    {
      paramString = new al(((af.a)localObject).b, ((af.a)localObject).d);
      paramString.c = ((af.a)localObject).a();
      AppMethodBeat.o(147209);
      return paramString;
    }
    localObject = new ad(paramString, -1);
    ((ad)localObject).a((byte)3);
    paramString = new al(paramString, "");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    paramString.c = localArrayList;
    AppMethodBeat.o(147209);
    return paramString;
  }
  
  public static void a()
  {
    AppMethodBeat.i(147206);
    ac.j().post(new aj());
    AppMethodBeat.o(147206);
  }
  
  public static void a(String paramString, ad paramad, int paramInt)
  {
    AppMethodBeat.i(147210);
    paramString = (af.a)d.get(paramString);
    if ((paramString != null) && (paramInt != 0)) {
      paramString.b(paramad);
    }
    AppMethodBeat.o(147210);
  }
  
  public static void b()
  {
    AppMethodBeat.i(147207);
    cw.d().f();
    AppMethodBeat.o(147207);
  }
  
  public static void c()
  {
    AppMethodBeat.i(147208);
    Object localObject1 = cw.d().f().a();
    if (localObject1 != null)
    {
      d.clear();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        al localal = (al)((Iterator)localObject1).next();
        af.a locala = new af.a(a);
        locala.b = localal.a;
        locala.d = localal.b;
        Object localObject2 = localal.c.iterator();
        while (((Iterator)localObject2).hasNext()) {
          locala.a((ad)((Iterator)localObject2).next());
        }
        localObject2 = new ad(localal.a, -1);
        ((ad)localObject2).a((byte)3);
        locala.a((ad)localObject2);
        d.put(localal.a, locala);
      }
    }
    AppMethodBeat.o(147208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.af
 * JD-Core Version:    0.7.0.1
 */