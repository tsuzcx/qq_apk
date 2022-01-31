package com.tencent.mm.vending.h;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public class g
{
  private static Map<String, d> a;
  private static Map<Looper, d> b;
  private static boolean c;
  
  static
  {
    AppMethodBeat.i(126136);
    a = new ConcurrentHashMap();
    b = new HashMap();
    c = false;
    a();
    AppMethodBeat.o(126136);
  }
  
  /* Error */
  static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 42
    //   5: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 34	com/tencent/mm/vending/h/g:c	Z
    //   11: ifeq +12 -> 23
    //   14: ldc 42
    //   16: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: ldc 44
    //   25: ldc 46
    //   27: iconst_0
    //   28: anewarray 4	java/lang/Object
    //   31: invokestatic 51	com/tencent/mm/vending/f/a:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: iconst_1
    //   35: putstatic 34	com/tencent/mm/vending/h/g:c	Z
    //   38: ldc 53
    //   40: getstatic 59	com/tencent/mm/vending/h/d:AOW	Lcom/tencent/mm/vending/h/h;
    //   43: invokestatic 62	com/tencent/mm/vending/h/g:a	(Ljava/lang/String;Lcom/tencent/mm/vending/h/d;)V
    //   46: ldc 64
    //   48: getstatic 67	com/tencent/mm/vending/h/d:AOX	Lcom/tencent/mm/vending/h/h;
    //   51: invokestatic 62	com/tencent/mm/vending/h/g:a	(Ljava/lang/String;Lcom/tencent/mm/vending/h/d;)V
    //   54: ldc 69
    //   56: getstatic 72	com/tencent/mm/vending/h/d:AOY	Lcom/tencent/mm/vending/h/h;
    //   59: invokestatic 62	com/tencent/mm/vending/h/g:a	(Ljava/lang/String;Lcom/tencent/mm/vending/h/d;)V
    //   62: ldc 42
    //   64: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static void a(String paramString, d paramd)
  {
    AppMethodBeat.i(126131);
    Assert.assertNotNull("Scheduler type is null", paramString);
    String str = paramString.toUpperCase(Locale.ENGLISH);
    if (a.containsKey(str)) {
      new IllegalStateException("Fatal error! Duplicate scheduler type " + paramString.toUpperCase(Locale.ENGLISH));
    }
    a.put(str, paramd);
    if ((paramd instanceof h)) {
      try
      {
        b.put(((h)paramd).b, paramd);
        return;
      }
      finally
      {
        AppMethodBeat.o(126131);
      }
    }
    AppMethodBeat.o(126131);
  }
  
  public static void avC(String paramString)
  {
    AppMethodBeat.i(126132);
    a.remove(paramString.toUpperCase(Locale.ENGLISH));
    AppMethodBeat.o(126132);
  }
  
  public static d avD(String paramString)
  {
    AppMethodBeat.i(126133);
    Assert.assertNotNull("Scheduler type is null", paramString);
    d locald = (d)a.get(paramString.toUpperCase(Locale.ENGLISH));
    Assert.assertNotNull("Scheduler type not found: " + paramString.toUpperCase(Locale.ENGLISH), locald);
    AppMethodBeat.o(126133);
    return locald;
  }
  
  /* Error */
  public static d dQu()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 143
    //   5: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 149	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   11: astore_2
    //   12: aload_2
    //   13: ifnonnull +38 -> 51
    //   16: ldc 44
    //   18: ldc 151
    //   20: iconst_1
    //   21: anewarray 4	java/lang/Object
    //   24: dup
    //   25: iconst_0
    //   26: invokestatic 157	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   29: aastore
    //   30: invokestatic 160	com/tencent/mm/vending/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   33: new 162	com/tencent/mm/vending/h/c
    //   36: dup
    //   37: invokespecial 163	com/tencent/mm/vending/h/c:<init>	()V
    //   40: astore_0
    //   41: ldc 143
    //   43: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: ldc 2
    //   48: monitorexit
    //   49: aload_0
    //   50: areturn
    //   51: getstatic 32	com/tencent/mm/vending/h/g:b	Ljava/util/Map;
    //   54: aload_2
    //   55: invokeinterface 138 2 0
    //   60: checkcast 55	com/tencent/mm/vending/h/d
    //   63: astore_1
    //   64: aload_1
    //   65: astore_0
    //   66: aload_1
    //   67: ifnonnull +27 -> 94
    //   70: new 123	com/tencent/mm/vending/h/h
    //   73: dup
    //   74: aload_2
    //   75: aload_2
    //   76: invokevirtual 164	android/os/Looper:toString	()Ljava/lang/String;
    //   79: invokespecial 167	com/tencent/mm/vending/h/h:<init>	(Landroid/os/Looper;Ljava/lang/String;)V
    //   82: astore_0
    //   83: getstatic 32	com/tencent/mm/vending/h/g:b	Ljava/util/Map;
    //   86: aload_2
    //   87: aload_0
    //   88: invokeinterface 121 3 0
    //   93: pop
    //   94: ldc 143
    //   96: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: goto -53 -> 46
    //   102: astore_0
    //   103: ldc 2
    //   105: monitorexit
    //   106: aload_0
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   40	48	0	localObject1	Object
    //   102	5	0	localObject2	Object
    //   63	4	1	locald	d
    //   11	76	2	localLooper	Looper
    // Exception table:
    //   from	to	target	type
    //   3	12	102	finally
    //   16	46	102	finally
    //   51	64	102	finally
    //   70	94	102	finally
    //   94	99	102	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.h.g
 * JD-Core Version:    0.7.0.1
 */