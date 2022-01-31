package com.tencent.tencentmap.mapsdk.maps.a;

public class nn
{
  private static int a = no.a;
  private static int b = 1000;
  private static int c = no.b;
  private static int d = 0;
  private static volatile boolean e = false;
  private static int f = 0;
  private static String g = null;
  private static String h = null;
  private static int[] i = new int[0];
  private static byte[] j = new byte[0];
  
  public static int a()
  {
    synchronized (j)
    {
      int k = b;
      return k;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, int[] paramArrayOfInt, String paramString2)
  {
    synchronized (j)
    {
      a = paramInt1;
      b = paramInt2;
      c = paramInt3;
      d = paramInt4;
      g = paramString1;
      i = paramArrayOfInt;
      h = paramString2;
      return;
    }
  }
  
  /* Error */
  public static void a(android.content.Context arg0)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 55
    //   4: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: ifnonnull +9 -> 17
    //   11: ldc 55
    //   13: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: return
    //   17: aload_0
    //   18: invokestatic 68	com/tencent/tencentmap/mapsdk/a/u:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/u;
    //   21: astore 11
    //   23: aload 11
    //   25: ldc 70
    //   27: invokevirtual 73	com/tencent/tencentmap/mapsdk/a/u:b	(Ljava/lang/String;)I
    //   30: istore_2
    //   31: aload 11
    //   33: ldc 75
    //   35: invokevirtual 73	com/tencent/tencentmap/mapsdk/a/u:b	(Ljava/lang/String;)I
    //   38: istore_3
    //   39: aload 11
    //   41: ldc 77
    //   43: invokevirtual 73	com/tencent/tencentmap/mapsdk/a/u:b	(Ljava/lang/String;)I
    //   46: istore 4
    //   48: aload 11
    //   50: ldc 79
    //   52: invokevirtual 73	com/tencent/tencentmap/mapsdk/a/u:b	(Ljava/lang/String;)I
    //   55: istore 5
    //   57: aload 11
    //   59: ldc 81
    //   61: invokevirtual 73	com/tencent/tencentmap/mapsdk/a/u:b	(Ljava/lang/String;)I
    //   64: istore 6
    //   66: aload 11
    //   68: ldc 83
    //   70: invokevirtual 86	com/tencent/tencentmap/mapsdk/a/u:c	(Ljava/lang/String;)Z
    //   73: istore 7
    //   75: aload 11
    //   77: ldc 88
    //   79: invokevirtual 91	com/tencent/tencentmap/mapsdk/a/u:a	(Ljava/lang/String;)Ljava/lang/String;
    //   82: astore 10
    //   84: iconst_0
    //   85: newarray int
    //   87: astore 8
    //   89: aload 8
    //   91: astore_0
    //   92: new 93	org/json/JSONArray
    //   95: dup
    //   96: aload 11
    //   98: ldc 95
    //   100: invokevirtual 91	com/tencent/tencentmap/mapsdk/a/u:a	(Ljava/lang/String;)Ljava/lang/String;
    //   103: invokespecial 98	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   106: astore 12
    //   108: aload 8
    //   110: astore_0
    //   111: aload 12
    //   113: invokevirtual 101	org/json/JSONArray:length	()I
    //   116: newarray int
    //   118: astore 9
    //   120: aload 9
    //   122: astore_0
    //   123: aload 9
    //   125: astore 8
    //   127: iload_1
    //   128: aload 9
    //   130: arraylength
    //   131: if_icmpge +28 -> 159
    //   134: aload 9
    //   136: astore_0
    //   137: aload 9
    //   139: iload_1
    //   140: aload 12
    //   142: iload_1
    //   143: invokevirtual 105	org/json/JSONArray:getInt	(I)I
    //   146: iastore
    //   147: iload_1
    //   148: iconst_1
    //   149: iadd
    //   150: istore_1
    //   151: goto -31 -> 120
    //   154: astore 8
    //   156: aload_0
    //   157: astore 8
    //   159: aload 11
    //   161: ldc 107
    //   163: invokevirtual 91	com/tencent/tencentmap/mapsdk/a/u:a	(Ljava/lang/String;)Ljava/lang/String;
    //   166: astore 9
    //   168: getstatic 45	com/tencent/tencentmap/mapsdk/maps/a/nn:j	[B
    //   171: astore_0
    //   172: aload_0
    //   173: monitorenter
    //   174: iload_3
    //   175: putstatic 28	com/tencent/tencentmap/mapsdk/maps/a/nn:b	I
    //   178: iload 4
    //   180: putstatic 26	com/tencent/tencentmap/mapsdk/maps/a/nn:a	I
    //   183: iload 5
    //   185: putstatic 31	com/tencent/tencentmap/mapsdk/maps/a/nn:c	I
    //   188: iload 6
    //   190: putstatic 33	com/tencent/tencentmap/mapsdk/maps/a/nn:d	I
    //   193: iload 7
    //   195: putstatic 35	com/tencent/tencentmap/mapsdk/maps/a/nn:e	Z
    //   198: aload 10
    //   200: putstatic 39	com/tencent/tencentmap/mapsdk/maps/a/nn:g	Ljava/lang/String;
    //   203: aload 8
    //   205: putstatic 43	com/tencent/tencentmap/mapsdk/maps/a/nn:i	[I
    //   208: aload 9
    //   210: putstatic 41	com/tencent/tencentmap/mapsdk/maps/a/nn:h	Ljava/lang/String;
    //   213: iload_2
    //   214: putstatic 37	com/tencent/tencentmap/mapsdk/maps/a/nn:f	I
    //   217: aload_0
    //   218: monitorexit
    //   219: ldc 55
    //   221: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: return
    //   225: astore 8
    //   227: aload_0
    //   228: monitorexit
    //   229: ldc 55
    //   231: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: aload 8
    //   236: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	150	1	k	int
    //   30	184	2	m	int
    //   38	137	3	n	int
    //   46	133	4	i1	int
    //   55	129	5	i2	int
    //   64	125	6	i3	int
    //   73	121	7	bool	boolean
    //   87	39	8	localObject1	Object
    //   154	1	8	localException	java.lang.Exception
    //   157	47	8	localContext	android.content.Context
    //   225	10	8	localObject2	Object
    //   118	91	9	localObject3	Object
    //   82	117	10	str	String
    //   21	139	11	localu	com.tencent.tencentmap.mapsdk.a.u
    //   106	35	12	localJSONArray	org.json.JSONArray
    // Exception table:
    //   from	to	target	type
    //   92	108	154	java/lang/Exception
    //   111	120	154	java/lang/Exception
    //   127	134	154	java/lang/Exception
    //   137	147	154	java/lang/Exception
    //   174	219	225	finally
    //   227	229	225	finally
  }
  
  public static void a(boolean paramBoolean)
  {
    synchronized (j)
    {
      e = paramBoolean;
      return;
    }
  }
  
  public static int b()
  {
    synchronized (j)
    {
      int k = a;
      return k;
    }
  }
  
  public static int c()
  {
    synchronized (j)
    {
      int k = c;
      return k;
    }
  }
  
  public static boolean d()
  {
    synchronized (j)
    {
      boolean bool = e;
      return bool;
    }
  }
  
  public static String e()
  {
    synchronized (j)
    {
      String str = g;
      return str;
    }
  }
  
  public static int f()
  {
    synchronized (j)
    {
      int k = d;
      return k;
    }
  }
  
  public static String g()
  {
    synchronized (j)
    {
      String str = h;
      return str;
    }
  }
  
  public static int[] h()
  {
    synchronized (j)
    {
      int[] arrayOfInt = i;
      return arrayOfInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.nn
 * JD-Core Version:    0.7.0.1
 */