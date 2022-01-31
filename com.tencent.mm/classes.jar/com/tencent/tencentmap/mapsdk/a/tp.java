package com.tencent.tencentmap.mapsdk.a;

public final class tp
{
  private static int a = 1000;
  private static int b = sq.a;
  private static int c = sq.b;
  private static int d = sq.c;
  private static int e = 0;
  private static int f = 1000;
  private static int g = sq.e;
  private static int h = 0;
  private static volatile boolean i = false;
  private static int j = 0;
  private static String k = null;
  private static final byte[] l = new byte[0];
  private static final byte[] m = new byte[0];
  
  public static int a()
  {
    synchronized (l)
    {
      int n = a;
      return n;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    synchronized (l)
    {
      a = paramInt1;
      b = paramInt2;
      c = paramInt3;
      d = paramInt4;
      return;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String arg4, String paramString2)
  {
    synchronized (m)
    {
      e = paramInt1;
      f = paramInt2;
      g = paramInt3;
      h = paramInt4;
      k = paramString2;
      return;
    }
  }
  
  public static void a(String paramString)
  {
    synchronized (m)
    {
      k = paramString;
      return;
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    synchronized (m)
    {
      i = paramBoolean;
      return;
    }
  }
  
  public static int b()
  {
    synchronized (l)
    {
      int n = b;
      return n;
    }
  }
  
  public static int c()
  {
    synchronized (l)
    {
      int n = c;
      return n;
    }
  }
  
  public static int d()
  {
    synchronized (l)
    {
      int n = d;
      return n;
    }
  }
  
  public static int e()
  {
    synchronized (m)
    {
      int n = f;
      return n;
    }
  }
  
  public static int f()
  {
    synchronized (m)
    {
      int n = e;
      return n;
    }
  }
  
  public static int g()
  {
    synchronized (m)
    {
      int n = g;
      return n;
    }
  }
  
  public static boolean h()
  {
    synchronized (m)
    {
      boolean bool = i;
      return bool;
    }
  }
  
  public static int i()
  {
    synchronized (m)
    {
      int n = h;
      return n;
    }
  }
  
  public static String j()
  {
    synchronized (m)
    {
      String str = k;
      return str;
    }
  }
  
  public static int k()
  {
    synchronized (m)
    {
      int n = j;
      return n;
    }
  }
  
  /* Error */
  public static void l()
  {
    // Byte code:
    //   0: invokestatic 68	com/tencent/tencentmap/mapsdk/a/ua:a	()Lcom/tencent/tencentmap/mapsdk/a/ua;
    //   3: astore 7
    //   5: aload 7
    //   7: ldc 70
    //   9: invokevirtual 73	com/tencent/tencentmap/mapsdk/a/ua:b	(Ljava/lang/String;)I
    //   12: istore_0
    //   13: aload 7
    //   15: ldc 75
    //   17: invokevirtual 73	com/tencent/tencentmap/mapsdk/a/ua:b	(Ljava/lang/String;)I
    //   20: istore_1
    //   21: aload 7
    //   23: ldc 77
    //   25: invokevirtual 73	com/tencent/tencentmap/mapsdk/a/ua:b	(Ljava/lang/String;)I
    //   28: istore_2
    //   29: aload 7
    //   31: ldc 79
    //   33: invokevirtual 73	com/tencent/tencentmap/mapsdk/a/ua:b	(Ljava/lang/String;)I
    //   36: istore_3
    //   37: getstatic 53	com/tencent/tencentmap/mapsdk/a/tp:l	[B
    //   40: astore 6
    //   42: aload 6
    //   44: monitorenter
    //   45: iload_1
    //   46: iconst_m1
    //   47: if_icmpeq +34 -> 81
    //   50: iload_0
    //   51: iconst_m1
    //   52: if_icmpeq +29 -> 81
    //   55: iload_2
    //   56: iconst_m1
    //   57: if_icmpeq +24 -> 81
    //   60: iload_3
    //   61: iconst_m1
    //   62: if_icmpeq +19 -> 81
    //   65: iload_0
    //   66: putstatic 30	com/tencent/tencentmap/mapsdk/a/tp:b	I
    //   69: iload_1
    //   70: putstatic 25	com/tencent/tencentmap/mapsdk/a/tp:a	I
    //   73: iload_2
    //   74: putstatic 36	com/tencent/tencentmap/mapsdk/a/tp:d	I
    //   77: iload_3
    //   78: putstatic 33	com/tencent/tencentmap/mapsdk/a/tp:c	I
    //   81: aload 6
    //   83: monitorexit
    //   84: aload 7
    //   86: ldc 81
    //   88: invokevirtual 73	com/tencent/tencentmap/mapsdk/a/ua:b	(Ljava/lang/String;)I
    //   91: istore_0
    //   92: aload 7
    //   94: ldc 83
    //   96: invokevirtual 73	com/tencent/tencentmap/mapsdk/a/ua:b	(Ljava/lang/String;)I
    //   99: istore_1
    //   100: aload 7
    //   102: ldc 85
    //   104: invokevirtual 73	com/tencent/tencentmap/mapsdk/a/ua:b	(Ljava/lang/String;)I
    //   107: istore_2
    //   108: aload 7
    //   110: ldc 87
    //   112: invokevirtual 73	com/tencent/tencentmap/mapsdk/a/ua:b	(Ljava/lang/String;)I
    //   115: istore_3
    //   116: aload 7
    //   118: ldc 89
    //   120: invokevirtual 73	com/tencent/tencentmap/mapsdk/a/ua:b	(Ljava/lang/String;)I
    //   123: istore 4
    //   125: aload 7
    //   127: ldc 91
    //   129: invokevirtual 94	com/tencent/tencentmap/mapsdk/a/ua:c	(Ljava/lang/String;)Z
    //   132: istore 5
    //   134: aload 7
    //   136: ldc 96
    //   138: invokevirtual 99	com/tencent/tencentmap/mapsdk/a/ua:a	(Ljava/lang/String;)Ljava/lang/String;
    //   141: pop
    //   142: aload 7
    //   144: ldc 101
    //   146: invokevirtual 99	com/tencent/tencentmap/mapsdk/a/ua:a	(Ljava/lang/String;)Ljava/lang/String;
    //   149: astore 7
    //   151: getstatic 55	com/tencent/tencentmap/mapsdk/a/tp:m	[B
    //   154: astore 6
    //   156: aload 6
    //   158: monitorenter
    //   159: iload_1
    //   160: putstatic 40	com/tencent/tencentmap/mapsdk/a/tp:f	I
    //   163: iload_2
    //   164: putstatic 38	com/tencent/tencentmap/mapsdk/a/tp:e	I
    //   167: iload_3
    //   168: putstatic 43	com/tencent/tencentmap/mapsdk/a/tp:g	I
    //   171: iload 4
    //   173: putstatic 45	com/tencent/tencentmap/mapsdk/a/tp:h	I
    //   176: iload 5
    //   178: putstatic 47	com/tencent/tencentmap/mapsdk/a/tp:i	Z
    //   181: aload 7
    //   183: putstatic 51	com/tencent/tencentmap/mapsdk/a/tp:k	Ljava/lang/String;
    //   186: iload_0
    //   187: putstatic 49	com/tencent/tencentmap/mapsdk/a/tp:j	I
    //   190: aload 6
    //   192: monitorexit
    //   193: return
    //   194: astore 7
    //   196: aload 6
    //   198: monitorexit
    //   199: aload 7
    //   201: athrow
    //   202: astore 7
    //   204: aload 6
    //   206: monitorexit
    //   207: aload 7
    //   209: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	175	0	n	int
    //   20	140	1	i1	int
    //   28	136	2	i2	int
    //   36	132	3	i3	int
    //   123	49	4	i4	int
    //   132	45	5	bool	boolean
    //   3	179	7	localObject1	Object
    //   194	6	7	localObject2	Object
    //   202	6	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   65	81	194	finally
    //   81	84	194	finally
    //   159	193	202	finally
  }
  
  public static boolean m()
  {
    synchronized (m)
    {
      boolean bool = ua.a().a(new String[] { "", "world_map_scene", "world_map_style", "world_map_version", "world_map_tile_url_regex", "world_map_logo_change_rule_json", "world_map_protocol_version" });
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.tp
 * JD-Core Version:    0.7.0.1
 */