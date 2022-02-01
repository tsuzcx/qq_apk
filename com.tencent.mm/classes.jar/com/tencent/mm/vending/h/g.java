package com.tencent.mm.vending.h;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.f.a;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public class g
{
  private static Map<String, d> YAX;
  private static Map<Thread, d> YAY;
  private static boolean YAZ;
  private static ThreadLocal<d> YBa;
  private static a YBb;
  
  static
  {
    AppMethodBeat.i(74933);
    YAX = new ConcurrentHashMap();
    YAY = new HashMap();
    YAZ = false;
    YBa = new ThreadLocal();
    YBb = null;
    ieP();
    AppMethodBeat.o(74933);
  }
  
  public static void a(String paramString, d paramd)
  {
    AppMethodBeat.i(74928);
    Assert.assertNotNull("Scheduler type is null", paramString);
    String str = paramString.toUpperCase(Locale.ENGLISH);
    if (YAX.containsKey(str)) {
      new IllegalStateException("Fatal error! Duplicate scheduler type " + paramString.toUpperCase(Locale.ENGLISH));
    }
    YAX.put(str, paramd);
    if ((paramd instanceof h)) {
      try
      {
        YAY.put(((h)paramd).mLooper.getThread(), paramd);
        return;
      }
      finally
      {
        AppMethodBeat.o(74928);
      }
    }
    if ((paramd instanceof i)) {
      try
      {
        AppMethodBeat.o(74928);
        throw null;
      }
      finally
      {
        AppMethodBeat.o(74928);
      }
    }
    AppMethodBeat.o(74928);
  }
  
  public static void bBw(String paramString)
  {
    AppMethodBeat.i(74929);
    YAX.remove(paramString.toUpperCase(Locale.ENGLISH));
    AppMethodBeat.o(74929);
  }
  
  public static d bBx(String paramString)
  {
    AppMethodBeat.i(74930);
    Assert.assertNotNull("Scheduler type is null", paramString);
    d locald = (d)YAX.get(paramString.toUpperCase(Locale.ENGLISH));
    Assert.assertNotNull("Scheduler type not found: " + paramString.toUpperCase(Locale.ENGLISH), locald);
    AppMethodBeat.o(74930);
    return locald;
  }
  
  public static d current()
  {
    AppMethodBeat.i(74931);
    Object localObject3 = (d)YBa.get();
    if ((localObject3 != null) && (YAY.size() == 0))
    {
      AppMethodBeat.o(74931);
      return localObject3;
    }
    try
    {
      d locald = (d)YAY.remove(Thread.currentThread());
      if ((localObject3 != null) && (locald == null))
      {
        AppMethodBeat.o(74931);
        return localObject3;
      }
    }
    finally
    {
      AppMethodBeat.o(74931);
    }
    if (localObject1 != null)
    {
      YBa.set(localObject1);
      AppMethodBeat.o(74931);
      return localObject1;
    }
    if (Looper.myLooper() != null)
    {
      localObject3 = new h(Looper.myLooper(), Looper.myLooper().toString());
      YBa.set(localObject3);
      AppMethodBeat.o(74931);
      return localObject3;
    }
    localObject3 = YBb;
    Object localObject2;
    if (localObject3 != null)
    {
      Thread.currentThread();
      localObject2 = ((a)localObject3).ieQ();
      a.i("Vending.SchedulerProvider", "This is not a handler thread(%s). So we get a instance(%s) from thread factory.", new Object[] { Thread.currentThread(), localObject2 });
    }
    for (;;)
    {
      localObject3 = localObject2;
      if (localObject2 != null) {
        break;
      }
      a.w("Vending.SchedulerProvider", "This is not a handler thread! %s", new Object[] { Thread.currentThread() });
      localObject2 = new c();
      AppMethodBeat.o(74931);
      return localObject2;
    }
  }
  
  /* Error */
  static void ieP()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 185
    //   5: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 42	com/tencent/mm/vending/h/g:YAZ	Z
    //   11: ifeq +12 -> 23
    //   14: ldc 185
    //   16: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: ldc 169
    //   25: ldc 187
    //   27: iconst_0
    //   28: anewarray 4	java/lang/Object
    //   31: invokestatic 176	com/tencent/mm/vending/f/a:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: iconst_1
    //   35: putstatic 42	com/tencent/mm/vending/h/g:YAZ	Z
    //   38: ldc 189
    //   40: getstatic 193	com/tencent/mm/vending/h/d:UI	Lcom/tencent/mm/vending/h/h;
    //   43: invokestatic 195	com/tencent/mm/vending/h/g:a	(Ljava/lang/String;Lcom/tencent/mm/vending/h/d;)V
    //   46: ldc 197
    //   48: getstatic 200	com/tencent/mm/vending/h/d:LOGIC	Lcom/tencent/mm/vending/h/h;
    //   51: invokestatic 195	com/tencent/mm/vending/h/g:a	(Ljava/lang/String;Lcom/tencent/mm/vending/h/d;)V
    //   54: ldc 202
    //   56: getstatic 205	com/tencent/mm/vending/h/d:HEAVY_WORK	Lcom/tencent/mm/vending/h/h;
    //   59: invokestatic 195	com/tencent/mm/vending/h/g:a	(Ljava/lang/String;Lcom/tencent/mm/vending/h/d;)V
    //   62: ldc 185
    //   64: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: goto -48 -> 19
    //   70: astore_0
    //   71: ldc 2
    //   73: monitorexit
    //   74: aload_0
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   70	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	19	70	finally
    //   23	67	70	finally
  }
  
  public static abstract interface a
  {
    public abstract d ieQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vending.h.g
 * JD-Core Version:    0.7.0.1
 */