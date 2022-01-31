package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class th
{
  private static int e = 0;
  private tn a;
  private CopyOnWriteArrayList<tx> b = new CopyOnWriteArrayList();
  private SortedMap<String, tt> c = new TreeMap();
  private th.a d = new th.a(this, (byte)0);
  private int f = 0;
  
  public th(tn paramtn)
  {
    this.a = paramtn;
  }
  
  public static String a(String paramString)
  {
    e += 1;
    return paramString + e;
  }
  
  public final tq a(rw paramrw)
  {
    paramrw = new tq(this.a, paramrw);
    a(paramrw);
    return paramrw;
  }
  
  public final tt a(sb paramsb)
  {
    paramsb = new tt(this.a, paramsb);
    this.c.put(paramsb.m(), paramsb);
    return paramsb;
  }
  
  public final ty a(sd paramsd)
  {
    paramsd = new ty(this.a, paramsd);
    a(paramsd);
    return paramsd;
  }
  
  public final tz a(sf paramsf)
  {
    paramsf = new tu(this.a, paramsf);
    a(paramsf);
    return paramsf;
  }
  
  public final void a()
  {
    try
    {
      Iterator localIterator = this.c.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((tt)((Map.Entry)localIterator.next()).getValue()).c();
      }
      this.c.clear();
      localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((tx)localIterator.next()).n();
      }
      this.b.clear();
      if ((Build.VERSION.SDK_INT > 11) && (this.a.c() != null))
      {
        this.a.c().setLayerType(2, null);
        return;
      }
    }
    catch (Exception localException) {}
  }
  
  public final void a(Canvas paramCanvas)
  {
    int i = this.b.size();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      tx localtx = (tx)localIterator.next();
      if ((localtx.l()) && ((i <= 20) || (localtx.h()))) {
        localtx.a(paramCanvas);
      }
    }
  }
  
  public final void a(tx paramtx)
  {
    b(paramtx.j());
    this.b.add(paramtx);
    if ((Build.VERSION.SDK_INT > 11) && (!(paramtx instanceof tq)))
    {
      int i = this.f + 1;
      this.f = i;
      if ((i > 0) && (this.a.c() != null)) {
        this.a.c().setLayerType(1, null);
      }
    }
    if (this.f > 0) {
      this.a.f(false);
    }
    c();
    this.a.a(false, false);
  }
  
  public final boolean a(MotionEvent paramMotionEvent)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      tx localtx = (tx)localIterator.next();
      if ((localtx instanceof uz)) {
        ((uz)localtx).a(paramMotionEvent, this.a.d());
      }
    }
    return false;
  }
  
  public final boolean a(rx paramrx)
  {
    boolean bool2 = false;
    Iterator localIterator = this.b.iterator();
    tx localtx;
    do
    {
      bool1 = bool2;
      if (!localIterator.hasNext()) {
        break;
      }
      localtx = (tx)localIterator.next();
    } while ((!(localtx instanceof uz)) || (!((uz)localtx).a(paramrx, this.a.d())));
    boolean bool1 = true;
    if (!bool1)
    {
      localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        localtx = (tx)localIterator.next();
        if ((localtx instanceof uz)) {
          ((uz)localtx).a(paramrx);
        }
      }
    }
    return bool1;
  }
  
  public final boolean a(rx paramrx, MotionEvent paramMotionEvent)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      tx localtx = (tx)localIterator.next();
      if (((localtx instanceof uz)) && (((uz)localtx).a(paramrx, paramMotionEvent, this.a.d()))) {
        return true;
      }
    }
    return false;
  }
  
  protected final void b()
  {
    a();
  }
  
  public final boolean b(String paramString)
  {
    Iterator localIterator = this.b.iterator();
    tx localtx;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localtx = (tx)localIterator.next();
    } while ((localtx == null) || (!localtx.j().equals(paramString)));
    for (paramString = localtx; paramString != null; paramString = null)
    {
      boolean bool = this.b.remove(paramString);
      if ((Build.VERSION.SDK_INT > 11) && (bool) && (!(paramString instanceof tq)))
      {
        int i = this.f - 1;
        this.f = i;
        if ((i == 0) && (this.a.c() != null)) {
          this.a.c().setLayerType(1, null);
        }
      }
      if (this.f <= 0) {
        this.a.f(true);
      }
      this.a.a(false, false);
      return bool;
    }
    return false;
  }
  
  public final void c()
  {
    Object[] arrayOfObject = this.b.toArray();
    Arrays.sort(arrayOfObject, this.d);
    this.b.clear();
    int j = arrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfObject[i];
      this.b.add((tx)localObject);
      i += 1;
    }
  }
  
  public final boolean c(String paramString)
  {
    paramString = (tt)this.c.remove(paramString);
    if (paramString == null) {
      return false;
    }
    paramString.c();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.th
 * JD-Core Version:    0.7.0.1
 */