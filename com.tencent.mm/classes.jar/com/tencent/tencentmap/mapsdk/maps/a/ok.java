package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

public class ok
{
  static final oh a;
  private static final ok b;
  private final AtomicReference<oh> c;
  private final AtomicReference<oi> d;
  private final AtomicReference<Object> e;
  
  static
  {
    AppMethodBeat.i(149610);
    b = new ok();
    a = new ok.1();
    AppMethodBeat.o(149610);
  }
  
  ok()
  {
    AppMethodBeat.i(149606);
    this.c = new AtomicReference();
    this.d = new AtomicReference();
    this.e = new AtomicReference();
    AppMethodBeat.o(149606);
  }
  
  public static ok a()
  {
    return b;
  }
  
  private static Object a(Class<?> paramClass)
  {
    AppMethodBeat.i(149609);
    String str1 = paramClass.getSimpleName();
    String str2 = System.getProperty("rxjava.plugin." + str1 + ".implementation");
    if (str2 != null) {
      try
      {
        paramClass = Class.forName(str2).asSubclass(paramClass).newInstance();
        AppMethodBeat.o(149609);
        return paramClass;
      }
      catch (ClassCastException paramClass)
      {
        paramClass = new RuntimeException(str1 + " implementation is not an instance of " + str1 + ": " + str2);
        AppMethodBeat.o(149609);
        throw paramClass;
      }
      catch (ClassNotFoundException paramClass)
      {
        paramClass = new RuntimeException(str1 + " implementation class not found: " + str2, paramClass);
        AppMethodBeat.o(149609);
        throw paramClass;
      }
      catch (InstantiationException paramClass)
      {
        paramClass = new RuntimeException(str1 + " implementation not able to be instantiated: " + str2, paramClass);
        AppMethodBeat.o(149609);
        throw paramClass;
      }
      catch (IllegalAccessException paramClass)
      {
        paramClass = new RuntimeException(str1 + " implementation not able to be accessed: " + str2, paramClass);
        AppMethodBeat.o(149609);
        throw paramClass;
      }
    }
    AppMethodBeat.o(149609);
    return null;
  }
  
  public oh b()
  {
    AppMethodBeat.i(149607);
    Object localObject;
    if (this.c.get() == null)
    {
      localObject = a(oh.class);
      if (localObject != null) {
        break label55;
      }
      this.c.compareAndSet(null, a);
    }
    for (;;)
    {
      localObject = (oh)this.c.get();
      AppMethodBeat.o(149607);
      return localObject;
      label55:
      this.c.compareAndSet(null, (oh)localObject);
    }
  }
  
  public oi c()
  {
    AppMethodBeat.i(149608);
    Object localObject;
    if (this.d.get() == null)
    {
      localObject = a(oi.class);
      if (localObject != null) {
        break label55;
      }
      this.d.compareAndSet(null, oj.a());
    }
    for (;;)
    {
      localObject = (oi)this.d.get();
      AppMethodBeat.o(149608);
      return localObject;
      label55:
      this.d.compareAndSet(null, (oi)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ok
 * JD-Core Version:    0.7.0.1
 */