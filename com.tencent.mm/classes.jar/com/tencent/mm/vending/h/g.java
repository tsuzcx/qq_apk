package com.tencent.mm.vending.h;

import android.os.Looper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public class g
{
  private static Map<String, d> a = new ConcurrentHashMap();
  private static Map<Looper, d> b = new HashMap();
  private static boolean c = false;
  
  static
  {
    a();
  }
  
  /* Error */
  static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 27	com/tencent/mm/vending/h/g:c	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: ldc 33
    //   17: ldc 35
    //   19: iconst_0
    //   20: anewarray 4	java/lang/Object
    //   23: invokestatic 41	com/tencent/mm/vending/f/a:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: iconst_1
    //   27: putstatic 27	com/tencent/mm/vending/h/g:c	Z
    //   30: ldc 43
    //   32: getstatic 49	com/tencent/mm/vending/h/d:wtY	Lcom/tencent/mm/vending/h/h;
    //   35: invokestatic 52	com/tencent/mm/vending/h/g:a	(Ljava/lang/String;Lcom/tencent/mm/vending/h/d;)V
    //   38: ldc 54
    //   40: getstatic 57	com/tencent/mm/vending/h/d:wtZ	Lcom/tencent/mm/vending/h/h;
    //   43: invokestatic 52	com/tencent/mm/vending/h/g:a	(Ljava/lang/String;Lcom/tencent/mm/vending/h/d;)V
    //   46: ldc 59
    //   48: getstatic 62	com/tencent/mm/vending/h/d:wua	Lcom/tencent/mm/vending/h/h;
    //   51: invokestatic 52	com/tencent/mm/vending/h/g:a	(Ljava/lang/String;Lcom/tencent/mm/vending/h/d;)V
    //   54: goto -43 -> 11
    //   57: astore_1
    //   58: ldc 2
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   57	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	57	finally
    //   15	54	57	finally
  }
  
  public static void a(String paramString, d paramd)
  {
    Assert.assertNotNull("Scheduler type is null", paramString);
    String str = paramString.toUpperCase();
    if (a.containsKey(str)) {
      new IllegalStateException("Fatal error! Duplicate scheduler type " + paramString.toUpperCase());
    }
    a.put(str, paramd);
    if ((paramd instanceof h)) {
      try
      {
        b.put(((h)paramd).b, paramd);
        return;
      }
      finally {}
    }
  }
  
  public static void aeK(String paramString)
  {
    a.remove(paramString.toUpperCase());
  }
  
  public static d aeL(String paramString)
  {
    Assert.assertNotNull("Scheduler type is null", paramString);
    d locald = (d)a.get(paramString.toUpperCase());
    Assert.assertNotNull("Scheduler type not found: " + paramString.toUpperCase(), locald);
    return locald;
  }
  
  /* Error */
  public static d cLe()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 128	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +33 -> 41
    //   11: ldc 33
    //   13: ldc 130
    //   15: iconst_1
    //   16: anewarray 4	java/lang/Object
    //   19: dup
    //   20: iconst_0
    //   21: invokestatic 136	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   24: aastore
    //   25: invokestatic 139	com/tencent/mm/vending/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: new 141	com/tencent/mm/vending/h/c
    //   31: dup
    //   32: invokespecial 142	com/tencent/mm/vending/h/c:<init>	()V
    //   35: astore_0
    //   36: ldc 2
    //   38: monitorexit
    //   39: aload_0
    //   40: areturn
    //   41: getstatic 25	com/tencent/mm/vending/h/g:b	Ljava/util/Map;
    //   44: aload_2
    //   45: invokeinterface 118 2 0
    //   50: checkcast 45	com/tencent/mm/vending/h/d
    //   53: astore_1
    //   54: aload_1
    //   55: astore_0
    //   56: aload_1
    //   57: ifnonnull -21 -> 36
    //   60: new 105	com/tencent/mm/vending/h/h
    //   63: dup
    //   64: aload_2
    //   65: aload_2
    //   66: invokevirtual 143	android/os/Looper:toString	()Ljava/lang/String;
    //   69: invokespecial 146	com/tencent/mm/vending/h/h:<init>	(Landroid/os/Looper;Ljava/lang/String;)V
    //   72: astore_0
    //   73: getstatic 25	com/tencent/mm/vending/h/g:b	Ljava/util/Map;
    //   76: aload_2
    //   77: aload_0
    //   78: invokeinterface 103 3 0
    //   83: pop
    //   84: goto -48 -> 36
    //   87: astore_0
    //   88: ldc 2
    //   90: monitorexit
    //   91: aload_0
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   35	43	0	localObject1	Object
    //   87	5	0	localObject2	Object
    //   53	4	1	locald	d
    //   6	71	2	localLooper	Looper
    // Exception table:
    //   from	to	target	type
    //   3	7	87	finally
    //   11	36	87	finally
    //   41	54	87	finally
    //   60	84	87	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.h.g
 * JD-Core Version:    0.7.0.1
 */