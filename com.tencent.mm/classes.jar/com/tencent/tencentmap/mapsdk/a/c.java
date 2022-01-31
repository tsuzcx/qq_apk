package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;

public final class c
{
  private static c n = null;
  private Context a = null;
  private String b = "";
  private String c = "";
  private byte d = -1;
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  private long j = 0L;
  private String k = "";
  private String l = "";
  private String m = "";
  
  /* Error */
  public static void a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +211 -> 215
    //   7: getstatic 27	com/tencent/tencentmap/mapsdk/a/c:n	Lcom/tencent/tencentmap/mapsdk/a/c;
    //   10: ifnonnull +13 -> 23
    //   13: new 2	com/tencent/tencentmap/mapsdk/a/c
    //   16: dup
    //   17: invokespecial 61	com/tencent/tencentmap/mapsdk/a/c:<init>	()V
    //   20: putstatic 27	com/tencent/tencentmap/mapsdk/a/c:n	Lcom/tencent/tencentmap/mapsdk/a/c;
    //   23: getstatic 27	com/tencent/tencentmap/mapsdk/a/c:n	Lcom/tencent/tencentmap/mapsdk/a/c;
    //   26: astore_1
    //   27: aload_1
    //   28: monitorenter
    //   29: ldc 63
    //   31: iconst_0
    //   32: anewarray 4	java/lang/Object
    //   35: invokestatic 68	com/tencent/tencentmap/mapsdk/a/cy:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   38: getstatic 27	com/tencent/tencentmap/mapsdk/a/c:n	Lcom/tencent/tencentmap/mapsdk/a/c;
    //   41: aload_0
    //   42: putfield 33	com/tencent/tencentmap/mapsdk/a/c:a	Landroid/content/Context;
    //   45: aload_0
    //   46: invokestatic 73	com/tencent/tencentmap/mapsdk/a/e:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/e;
    //   49: pop
    //   50: getstatic 27	com/tencent/tencentmap/mapsdk/a/c:n	Lcom/tencent/tencentmap/mapsdk/a/c;
    //   53: invokestatic 76	com/tencent/tencentmap/mapsdk/a/e:a	()Ljava/lang/String;
    //   56: putfield 37	com/tencent/tencentmap/mapsdk/a/c:b	Ljava/lang/String;
    //   59: getstatic 27	com/tencent/tencentmap/mapsdk/a/c:n	Lcom/tencent/tencentmap/mapsdk/a/c;
    //   62: astore_2
    //   63: new 78	java/lang/StringBuffer
    //   66: dup
    //   67: invokespecial 79	java/lang/StringBuffer:<init>	()V
    //   70: astore_3
    //   71: aload_3
    //   72: ldc 81
    //   74: invokevirtual 85	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   77: pop
    //   78: aload_3
    //   79: invokestatic 87	com/tencent/tencentmap/mapsdk/a/e:b	()Ljava/lang/String;
    //   82: invokevirtual 85	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   85: pop
    //   86: aload_3
    //   87: ldc 89
    //   89: invokevirtual 85	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   92: pop
    //   93: aload_3
    //   94: invokestatic 91	com/tencent/tencentmap/mapsdk/a/e:c	()Ljava/lang/String;
    //   97: invokevirtual 85	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   100: pop
    //   101: aload_2
    //   102: aload_3
    //   103: invokevirtual 94	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   106: putfield 39	com/tencent/tencentmap/mapsdk/a/c:c	Ljava/lang/String;
    //   109: getstatic 27	com/tencent/tencentmap/mapsdk/a/c:n	Lcom/tencent/tencentmap/mapsdk/a/c;
    //   112: invokespecial 96	com/tencent/tencentmap/mapsdk/a/c:n	()V
    //   115: getstatic 27	com/tencent/tencentmap/mapsdk/a/c:n	Lcom/tencent/tencentmap/mapsdk/a/c;
    //   118: aload_0
    //   119: invokestatic 101	com/tencent/tencentmap/mapsdk/a/a:d	(Landroid/content/Context;)Ljava/lang/String;
    //   122: invokespecial 104	com/tencent/tencentmap/mapsdk/a/c:d	(Ljava/lang/String;)V
    //   125: getstatic 106	com/tencent/tencentmap/mapsdk/a/a:a	Ljava/lang/String;
    //   128: ifnull +12 -> 140
    //   131: getstatic 27	com/tencent/tencentmap/mapsdk/a/c:n	Lcom/tencent/tencentmap/mapsdk/a/c;
    //   134: getstatic 106	com/tencent/tencentmap/mapsdk/a/a:a	Ljava/lang/String;
    //   137: invokevirtual 108	com/tencent/tencentmap/mapsdk/a/c:a	(Ljava/lang/String;)V
    //   140: getstatic 27	com/tencent/tencentmap/mapsdk/a/c:n	Lcom/tencent/tencentmap/mapsdk/a/c;
    //   143: ldc 110
    //   145: invokespecial 112	com/tencent/tencentmap/mapsdk/a/c:e	(Ljava/lang/String;)V
    //   148: getstatic 27	com/tencent/tencentmap/mapsdk/a/c:n	Lcom/tencent/tencentmap/mapsdk/a/c;
    //   151: ldc 114
    //   153: invokespecial 116	com/tencent/tencentmap/mapsdk/a/c:f	(Ljava/lang/String;)V
    //   156: getstatic 27	com/tencent/tencentmap/mapsdk/a/c:n	Lcom/tencent/tencentmap/mapsdk/a/c;
    //   159: ldc 118
    //   161: invokevirtual 120	com/tencent/tencentmap/mapsdk/a/c:b	(Ljava/lang/String;)V
    //   164: getstatic 27	com/tencent/tencentmap/mapsdk/a/c:n	Lcom/tencent/tencentmap/mapsdk/a/c;
    //   167: aload_0
    //   168: invokestatic 122	com/tencent/tencentmap/mapsdk/a/e:b	(Landroid/content/Context;)Ljava/lang/String;
    //   171: invokespecial 124	com/tencent/tencentmap/mapsdk/a/c:g	(Ljava/lang/String;)V
    //   174: invokestatic 128	com/tencent/tencentmap/mapsdk/a/df:d	()Ljava/lang/String;
    //   177: ifnull +42 -> 219
    //   180: ldc 35
    //   182: invokestatic 128	com/tencent/tencentmap/mapsdk/a/df:d	()Ljava/lang/String;
    //   185: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   188: ifne +31 -> 219
    //   191: getstatic 27	com/tencent/tencentmap/mapsdk/a/c:n	Lcom/tencent/tencentmap/mapsdk/a/c;
    //   194: invokestatic 128	com/tencent/tencentmap/mapsdk/a/df:d	()Ljava/lang/String;
    //   197: invokespecial 136	com/tencent/tencentmap/mapsdk/a/c:h	(Ljava/lang/String;)V
    //   200: getstatic 27	com/tencent/tencentmap/mapsdk/a/c:n	Lcom/tencent/tencentmap/mapsdk/a/c;
    //   203: aload_0
    //   204: invokestatic 138	com/tencent/tencentmap/mapsdk/a/a:a	(Landroid/content/Context;)Ljava/lang/String;
    //   207: invokestatic 141	com/tencent/tencentmap/mapsdk/a/e:b	(Ljava/lang/String;)Ljava/lang/String;
    //   210: invokevirtual 143	com/tencent/tencentmap/mapsdk/a/c:c	(Ljava/lang/String;)V
    //   213: aload_1
    //   214: monitorexit
    //   215: ldc 2
    //   217: monitorexit
    //   218: return
    //   219: getstatic 27	com/tencent/tencentmap/mapsdk/a/c:n	Lcom/tencent/tencentmap/mapsdk/a/c;
    //   222: getstatic 27	com/tencent/tencentmap/mapsdk/a/c:n	Lcom/tencent/tencentmap/mapsdk/a/c;
    //   225: invokespecial 146	com/tencent/tencentmap/mapsdk/a/c:o	()Ljava/lang/String;
    //   228: invokespecial 136	com/tencent/tencentmap/mapsdk/a/c:h	(Ljava/lang/String;)V
    //   231: goto -31 -> 200
    //   234: astore_0
    //   235: aload_1
    //   236: monitorexit
    //   237: aload_0
    //   238: athrow
    //   239: astore_0
    //   240: ldc 2
    //   242: monitorexit
    //   243: aload_0
    //   244: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	paramContext	Context
    //   62	40	2	localc2	c
    //   70	33	3	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   29	140	234	finally
    //   140	200	234	finally
    //   200	215	234	finally
    //   219	231	234	finally
    //   7	23	239	finally
    //   23	29	239	finally
    //   235	239	239	finally
  }
  
  private void d(String paramString)
  {
    try
    {
      this.e = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void e(String paramString)
  {
    try
    {
      this.g = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void f(String paramString)
  {
    try
    {
      this.h = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  private void g(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 35
    //   4: aload_1
    //   5: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8: istore_2
    //   9: iload_2
    //   10: ifne +14 -> 24
    //   13: aload_0
    //   14: getfield 33	com/tencent/tencentmap/mapsdk/a/c:a	Landroid/content/Context;
    //   17: ldc 150
    //   19: aload_1
    //   20: invokestatic 153	com/tencent/tencentmap/mapsdk/a/a:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   23: pop
    //   24: aload_0
    //   25: aload_1
    //   26: putfield 55	com/tencent/tencentmap/mapsdk/a/c:k	Ljava/lang/String;
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    //   37: astore_3
    //   38: goto -14 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	c
    //   0	41	1	paramString	String
    //   8	2	2	bool	boolean
    //   37	1	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	9	32	finally
    //   13	24	32	finally
    //   24	29	32	finally
    //   13	24	37	java/lang/Exception
  }
  
  private void h(String paramString)
  {
    try
    {
      this.l = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static c m()
  {
    try
    {
      c localc = n;
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void n()
  {
    try
    {
      this.d = 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private String o()
  {
    try
    {
      String str = this.e;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String a()
  {
    return this.b;
  }
  
  public final void a(long paramLong)
  {
    try
    {
      this.j = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(String paramString)
  {
    try
    {
      this.f = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String b()
  {
    return this.c;
  }
  
  public final void b(String paramString)
  {
    try
    {
      this.i = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final byte c()
  {
    try
    {
      byte b1 = this.d;
      return b1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void c(String paramString)
  {
    try
    {
      this.m = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String d()
  {
    try
    {
      String str = this.f;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String e()
  {
    try
    {
      String str = this.g;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String f()
  {
    try
    {
      String str = this.h;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String g()
  {
    try
    {
      String str = this.i;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long h()
  {
    try
    {
      long l1 = this.j;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final String i()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 35
    //   4: aload_0
    //   5: getfield 55	com/tencent/tencentmap/mapsdk/a/c:k	Ljava/lang/String;
    //   8: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11: istore_1
    //   12: iload_1
    //   13: ifeq +18 -> 31
    //   16: aload_0
    //   17: aload_0
    //   18: getfield 33	com/tencent/tencentmap/mapsdk/a/c:a	Landroid/content/Context;
    //   21: ldc 150
    //   23: ldc 35
    //   25: invokestatic 160	com/tencent/tencentmap/mapsdk/a/a:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   28: putfield 55	com/tencent/tencentmap/mapsdk/a/c:k	Ljava/lang/String;
    //   31: aload_0
    //   32: getfield 55	com/tencent/tencentmap/mapsdk/a/c:k	Ljava/lang/String;
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: areturn
    //   40: astore_2
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: goto -15 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	c
    //   11	2	1	bool	boolean
    //   35	4	2	str	String
    //   40	4	2	localObject	Object
    //   45	1	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	12	40	finally
    //   16	31	40	finally
    //   31	36	40	finally
    //   16	31	45	java/lang/Exception
  }
  
  public final String j()
  {
    try
    {
      String str = this.l;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String k()
  {
    try
    {
      String str = this.m;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Context l()
  {
    try
    {
      Context localContext = this.a;
      return localContext;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.c
 * JD-Core Version:    0.7.0.1
 */