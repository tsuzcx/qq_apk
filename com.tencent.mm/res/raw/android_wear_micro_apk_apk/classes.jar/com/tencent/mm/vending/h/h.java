package com.tencent.mm.vending.h;

import android.os.Looper;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public class h
{
  private static boolean ack;
  private static Map<Looper, d> acn;
  private static Map<String, d> adJ = new ConcurrentHashMap();
  
  static
  {
    acn = new HashMap();
    ack = false;
    me();
  }
  
  public static d J(String paramString)
  {
    Assert.assertNotNull("Scheduler type is null", paramString);
    d locald = (d)adJ.get(paramString.toUpperCase(Locale.ENGLISH));
    Assert.assertNotNull("Scheduler type not found: " + paramString.toUpperCase(Locale.ENGLISH), locald);
    return locald;
  }
  
  private static void a(String paramString, d paramd)
  {
    Assert.assertNotNull("Scheduler type is null", paramString);
    String str = paramString.toUpperCase(Locale.ENGLISH);
    if (adJ.containsKey(str)) {
      new IllegalStateException("Fatal error! Duplicate scheduler type " + paramString.toUpperCase(Locale.ENGLISH));
    }
    adJ.put(str, paramd);
    if ((paramd instanceof i)) {
      try
      {
        acn.put(((i)paramd).getLooper(), paramd);
        return;
      }
      finally {}
    }
  }
  
  /* Error */
  static void me()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 27	com/tencent/mm/vending/h/h:ack	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: invokestatic 103	com/tencent/mm/vending/f/a:mq	()V
    //   18: iconst_1
    //   19: putstatic 27	com/tencent/mm/vending/h/h:ack	Z
    //   22: ldc 105
    //   24: getstatic 109	com/tencent/mm/vending/h/d:adB	Lcom/tencent/mm/vending/h/i;
    //   27: invokestatic 111	com/tencent/mm/vending/h/h:a	(Ljava/lang/String;Lcom/tencent/mm/vending/h/d;)V
    //   30: ldc 113
    //   32: getstatic 116	com/tencent/mm/vending/h/d:adC	Lcom/tencent/mm/vending/h/i;
    //   35: invokestatic 111	com/tencent/mm/vending/h/h:a	(Ljava/lang/String;Lcom/tencent/mm/vending/h/d;)V
    //   38: ldc 118
    //   40: getstatic 121	com/tencent/mm/vending/h/d:adD	Lcom/tencent/mm/vending/h/i;
    //   43: invokestatic 111	com/tencent/mm/vending/h/h:a	(Ljava/lang/String;Lcom/tencent/mm/vending/h/d;)V
    //   46: goto -35 -> 11
    //   49: astore_1
    //   50: ldc 2
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   49	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	49	finally
    //   15	46	49	finally
  }
  
  /* Error */
  public static d mt()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 128	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +23 -> 31
    //   11: invokestatic 134	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   14: pop
    //   15: invokestatic 137	com/tencent/mm/vending/f/a:mp	()V
    //   18: new 139	com/tencent/mm/vending/h/c
    //   21: dup
    //   22: invokespecial 140	com/tencent/mm/vending/h/c:<init>	()V
    //   25: astore_0
    //   26: ldc 2
    //   28: monitorexit
    //   29: aload_0
    //   30: areturn
    //   31: getstatic 25	com/tencent/mm/vending/h/h:acn	Ljava/util/Map;
    //   34: aload_2
    //   35: invokeinterface 60 2 0
    //   40: checkcast 62	com/tencent/mm/vending/h/d
    //   43: astore_1
    //   44: aload_1
    //   45: astore_0
    //   46: aload_1
    //   47: ifnonnull -21 -> 26
    //   50: new 94	com/tencent/mm/vending/h/i
    //   53: dup
    //   54: aload_2
    //   55: aload_2
    //   56: invokevirtual 141	android/os/Looper:toString	()Ljava/lang/String;
    //   59: invokespecial 144	com/tencent/mm/vending/h/i:<init>	(Landroid/os/Looper;Ljava/lang/String;)V
    //   62: astore_0
    //   63: getstatic 25	com/tencent/mm/vending/h/h:acn	Ljava/util/Map;
    //   66: aload_2
    //   67: aload_0
    //   68: invokeinterface 92 3 0
    //   73: pop
    //   74: goto -48 -> 26
    //   77: astore_0
    //   78: ldc 2
    //   80: monitorexit
    //   81: aload_0
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   25	43	0	localObject1	Object
    //   77	5	0	localObject2	Object
    //   43	4	1	locald	d
    //   6	61	2	localLooper	Looper
    // Exception table:
    //   from	to	target	type
    //   3	7	77	finally
    //   11	26	77	finally
    //   31	44	77	finally
    //   50	74	77	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.h.h
 * JD-Core Version:    0.7.0.1
 */