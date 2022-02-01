package com.tencent.threadpool.j;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public final class a
{
  private static final ThreadLocal<a> ahCv;
  private static a ahCw;
  private static final AtomicLong ahCx;
  private static final ConcurrentHashMap<String, a> evG;
  public final d ahCy;
  private int ahCz;
  public final String tag;
  
  static
  {
    AppMethodBeat.i(183407);
    ahCv = new ThreadLocal();
    ahCw = null;
    evG = new ConcurrentHashMap();
    ahCx = new AtomicLong(0L);
    AppMethodBeat.o(183407);
  }
  
  private a(String paramString)
  {
    AppMethodBeat.i(183392);
    this.ahCz = 0;
    this.tag = paramString;
    this.ahCy = new d(new b(new b.a() {}));
    evG.put(this.tag, this);
    AppMethodBeat.o(183392);
  }
  
  static void a(a parama)
  {
    AppMethodBeat.i(183394);
    ahCv.set(parama);
    AppMethodBeat.o(183394);
  }
  
  public static a bFV(String paramString)
  {
    AppMethodBeat.i(183393);
    paramString = new a(paramString + "@" + ahCx.getAndIncrement());
    AppMethodBeat.o(183393);
    return paramString;
  }
  
  public static a bFW(String paramString)
  {
    AppMethodBeat.i(183400);
    paramString = (a)evG.get(paramString);
    AppMethodBeat.o(183400);
    return paramString;
  }
  
  static a bFX(String paramString)
  {
    try
    {
      AppMethodBeat.i(183401);
      a locala2 = (a)evG.get(paramString);
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = new a(paramString);
      }
      AppMethodBeat.o(183401);
      return locala1;
    }
    finally {}
  }
  
  public static a jZA()
  {
    AppMethodBeat.i(183397);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      locala = jZz();
      AppMethodBeat.o(183397);
      return locala;
    }
    a locala = (a)ahCv.get();
    AppMethodBeat.o(183397);
    return locala;
  }
  
  public static String jZB()
  {
    AppMethodBeat.i(183398);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      localObject = jZz().tag;
      AppMethodBeat.o(183398);
      return localObject;
    }
    Object localObject = (a)ahCv.get();
    if (localObject == null)
    {
      AppMethodBeat.o(183398);
      return null;
    }
    localObject = ((a)localObject).tag;
    AppMethodBeat.o(183398);
    return localObject;
  }
  
  public static Collection<a> jZC()
  {
    AppMethodBeat.i(183402);
    Collection localCollection = evG.values();
    AppMethodBeat.o(183402);
    return localCollection;
  }
  
  public static a jZz()
  {
    AppMethodBeat.i(183396);
    if (ahCw == null)
    {
      String str = m(Looper.getMainLooper());
      a locala2 = (a)evG.get(str);
      locala1 = locala2;
      if (locala2 == null) {
        locala1 = new a(str);
      }
      ahCw = locala1;
    }
    a locala1 = ahCw;
    AppMethodBeat.o(183396);
    return locala1;
  }
  
  public static String m(Looper paramLooper)
  {
    AppMethodBeat.i(183395);
    if (paramLooper == null)
    {
      AppMethodBeat.o(183395);
      return null;
    }
    paramLooper = paramLooper.getThread();
    paramLooper = paramLooper.getName() + "@" + paramLooper.getId();
    AppMethodBeat.o(183395);
    return paramLooper;
  }
  
  public static void release()
  {
    AppMethodBeat.i(183403);
    Iterator localIterator = evG.values().iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).ahCy.quit();
    }
    evG.clear();
    AppMethodBeat.o(183403);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(183406);
    if ((paramObject instanceof a))
    {
      boolean bool = ((a)paramObject).tag.equals(this.tag);
      AppMethodBeat.o(183406);
      return bool;
    }
    AppMethodBeat.o(183406);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(183405);
    int i = this.tag.hashCode();
    AppMethodBeat.o(183405);
    return i;
  }
  
  public final void quit()
  {
    AppMethodBeat.i(183399);
    this.ahCy.quit();
    AppMethodBeat.o(183399);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(183404);
    String str = "[" + this.tag + "]";
    AppMethodBeat.o(183404);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.j.a
 * JD-Core Version:    0.7.0.1
 */