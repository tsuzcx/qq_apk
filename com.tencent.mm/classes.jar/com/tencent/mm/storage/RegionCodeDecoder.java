package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class RegionCodeDecoder
{
  private static RegionCodeDecoder Orw;
  public static final String Orx;
  public String Ory = "";
  private String Orz = "";
  
  static
  {
    AppMethodBeat.i(43296);
    Orw = null;
    Orx = b.aKA() + "MicroMsg/regioncode/";
    AppMethodBeat.o(43296);
  }
  
  /* Error */
  private static String ae(o paramo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 64
    //   4: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 66	com/tencent/mm/vfs/o
    //   10: dup
    //   11: new 28	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   18: aload_0
    //   19: invokevirtual 70	com/tencent/mm/vfs/o:her	()Landroid/net/Uri;
    //   22: invokestatic 76	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   25: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 78
    //   30: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokespecial 81	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   39: astore 4
    //   41: aload 4
    //   43: invokevirtual 85	com/tencent/mm/vfs/o:exists	()Z
    //   46: ifeq +104 -> 150
    //   49: new 87	java/io/BufferedReader
    //   52: dup
    //   53: new 89	com/tencent/mm/vfs/u
    //   56: dup
    //   57: aload 4
    //   59: invokespecial 92	com/tencent/mm/vfs/u:<init>	(Lcom/tencent/mm/vfs/o;)V
    //   62: invokespecial 95	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   65: astore_1
    //   66: aload_1
    //   67: astore_0
    //   68: aload_1
    //   69: invokevirtual 98	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   72: astore_2
    //   73: aload_2
    //   74: astore_0
    //   75: aload_1
    //   76: invokevirtual 101	java/io/BufferedReader:close	()V
    //   79: ldc 64
    //   81: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload_0
    //   85: areturn
    //   86: astore_2
    //   87: aconst_null
    //   88: astore_1
    //   89: aload_1
    //   90: astore_0
    //   91: ldc 103
    //   93: aload_2
    //   94: ldc 105
    //   96: iconst_1
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload 4
    //   104: invokevirtual 108	com/tencent/mm/vfs/o:getName	()Ljava/lang/String;
    //   107: aastore
    //   108: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: aload_3
    //   112: astore_0
    //   113: aload_1
    //   114: ifnull -35 -> 79
    //   117: aload_1
    //   118: invokevirtual 101	java/io/BufferedReader:close	()V
    //   121: aload_3
    //   122: astore_0
    //   123: goto -44 -> 79
    //   126: astore_0
    //   127: aload_3
    //   128: astore_0
    //   129: goto -50 -> 79
    //   132: astore_1
    //   133: aconst_null
    //   134: astore_0
    //   135: aload_0
    //   136: ifnull +7 -> 143
    //   139: aload_0
    //   140: invokevirtual 101	java/io/BufferedReader:close	()V
    //   143: ldc 64
    //   145: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: aload_1
    //   149: athrow
    //   150: ldc 64
    //   152: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: aconst_null
    //   156: areturn
    //   157: astore_1
    //   158: goto -79 -> 79
    //   161: astore_0
    //   162: goto -19 -> 143
    //   165: astore_1
    //   166: goto -31 -> 135
    //   169: astore_2
    //   170: goto -81 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramo	o
    //   65	53	1	localBufferedReader	java.io.BufferedReader
    //   132	17	1	localObject1	Object
    //   157	1	1	localThrowable1	java.lang.Throwable
    //   165	1	1	localObject2	Object
    //   72	2	2	str	String
    //   86	8	2	localThrowable2	java.lang.Throwable
    //   169	1	2	localThrowable3	java.lang.Throwable
    //   1	127	3	localObject3	Object
    //   39	64	4	localo	o
    // Exception table:
    //   from	to	target	type
    //   49	66	86	java/lang/Throwable
    //   117	121	126	java/lang/Throwable
    //   49	66	132	finally
    //   75	79	157	java/lang/Throwable
    //   139	143	161	java/lang/Throwable
    //   68	73	165	finally
    //   91	111	165	finally
    //   68	73	169	java/lang/Throwable
  }
  
  private static String af(o paramo)
  {
    AppMethodBeat.i(43282);
    String str = s.bhK(aa.z(paramo.mUri));
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.RegionCodeDecoder", "Failed to calculate hash for file %s", new Object[] { paramo.getName() });
      AppMethodBeat.o(43282);
      return null;
    }
    paramo = MD5Util.getMD5String(str + "#" + paramo.lastModified() + "#" + q.dr(true));
    AppMethodBeat.o(43282);
    return paramo;
  }
  
  /* Error */
  private void ag(o paramo)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 162
    //   6: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aconst_null
    //   10: astore 4
    //   12: aload_1
    //   13: invokevirtual 85	com/tencent/mm/vfs/o:exists	()Z
    //   16: ifeq +9 -> 25
    //   19: aload_1
    //   20: invokevirtual 166	com/tencent/mm/vfs/o:list	()[Ljava/lang/String;
    //   23: astore 4
    //   25: aload_1
    //   26: invokevirtual 85	com/tencent/mm/vfs/o:exists	()Z
    //   29: ifeq +22 -> 51
    //   32: aload 4
    //   34: ifnull +17 -> 51
    //   37: aload 4
    //   39: arraylength
    //   40: ifeq +11 -> 51
    //   43: ldc 162
    //   45: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: invokestatic 172	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   54: invokevirtual 178	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   57: ldc 180
    //   59: invokevirtual 185	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   62: astore 4
    //   64: aload 4
    //   66: arraylength
    //   67: istore_3
    //   68: iload_2
    //   69: iload_3
    //   70: if_icmpge +134 -> 204
    //   73: aload 4
    //   75: iload_2
    //   76: aaload
    //   77: astore 5
    //   79: ldc 103
    //   81: ldc 187
    //   83: iconst_2
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: ldc 189
    //   91: aload 5
    //   93: invokestatic 195	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   96: invokevirtual 198	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   99: aastore
    //   100: dup
    //   101: iconst_1
    //   102: new 28	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   109: aload_1
    //   110: getfield 120	com/tencent/mm/vfs/o:mUri	Landroid/net/Uri;
    //   113: invokestatic 76	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   116: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: ldc 200
    //   121: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload 5
    //   126: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: aastore
    //   133: invokestatic 202	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: new 28	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   143: aload_1
    //   144: getfield 120	com/tencent/mm/vfs/o:mUri	Landroid/net/Uri;
    //   147: invokestatic 76	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   150: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc 200
    //   155: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload 5
    //   160: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: astore 6
    //   168: ldc 204
    //   170: aload 5
    //   172: invokestatic 195	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   175: invokevirtual 198	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   178: aload 6
    //   180: invokestatic 208	com/tencent/mm/vfs/s:nw	(Ljava/lang/String;Ljava/lang/String;)J
    //   183: pop2
    //   184: new 66	com/tencent/mm/vfs/o
    //   187: dup
    //   188: aload 6
    //   190: invokespecial 81	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   193: aload_1
    //   194: invokestatic 211	com/tencent/mm/storage/RegionCodeDecoder:e	(Lcom/tencent/mm/vfs/o;Lcom/tencent/mm/vfs/o;)V
    //   197: iload_2
    //   198: iconst_1
    //   199: iadd
    //   200: istore_2
    //   201: goto -133 -> 68
    //   204: ldc 162
    //   206: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   209: goto -161 -> 48
    //   212: astore_1
    //   213: aload_0
    //   214: monitorexit
    //   215: aload_1
    //   216: athrow
    //   217: astore_1
    //   218: ldc 103
    //   220: aload_1
    //   221: ldc 55
    //   223: iconst_0
    //   224: anewarray 4	java/lang/Object
    //   227: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   230: ldc 162
    //   232: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: goto -187 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	RegionCodeDecoder
    //   0	238	1	paramo	o
    //   1	200	2	i	int
    //   67	4	3	j	int
    //   10	64	4	arrayOfString	String[]
    //   77	94	5	str1	String
    //   166	23	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   4	9	212	finally
    //   12	25	212	finally
    //   25	32	212	finally
    //   37	48	212	finally
    //   51	68	212	finally
    //   79	197	212	finally
    //   204	209	212	finally
    //   218	235	212	finally
    //   51	68	217	java/lang/Exception
    //   79	197	217	java/lang/Exception
  }
  
  /* Error */
  private void ah(o paramo)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 213
    //   6: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aconst_null
    //   10: astore 4
    //   12: aload_1
    //   13: invokevirtual 85	com/tencent/mm/vfs/o:exists	()Z
    //   16: ifeq +9 -> 25
    //   19: aload_1
    //   20: invokevirtual 166	com/tencent/mm/vfs/o:list	()[Ljava/lang/String;
    //   23: astore 4
    //   25: aload_1
    //   26: invokevirtual 85	com/tencent/mm/vfs/o:exists	()Z
    //   29: ifeq +22 -> 51
    //   32: aload 4
    //   34: ifnull +17 -> 51
    //   37: aload 4
    //   39: arraylength
    //   40: ifeq +11 -> 51
    //   43: ldc 213
    //   45: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: invokestatic 172	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   54: invokevirtual 178	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   57: ldc 180
    //   59: invokevirtual 185	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   62: astore 4
    //   64: aload 4
    //   66: arraylength
    //   67: istore_3
    //   68: iload_2
    //   69: iload_3
    //   70: if_icmpge +154 -> 224
    //   73: aload 4
    //   75: iload_2
    //   76: aaload
    //   77: astore 5
    //   79: aload 5
    //   81: ldc 215
    //   83: invokevirtual 218	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   86: ifne +13 -> 99
    //   89: aload 5
    //   91: ldc 220
    //   93: invokevirtual 218	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   96: ifeq +121 -> 217
    //   99: ldc 103
    //   101: ldc 187
    //   103: iconst_2
    //   104: anewarray 4	java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: ldc 189
    //   111: aload 5
    //   113: invokestatic 195	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   116: invokevirtual 198	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   119: aastore
    //   120: dup
    //   121: iconst_1
    //   122: new 28	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   129: aload_1
    //   130: getfield 120	com/tencent/mm/vfs/o:mUri	Landroid/net/Uri;
    //   133: invokestatic 76	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   136: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc 200
    //   141: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload 5
    //   146: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: aastore
    //   153: invokestatic 202	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   156: new 28	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   163: aload_1
    //   164: getfield 120	com/tencent/mm/vfs/o:mUri	Landroid/net/Uri;
    //   167: invokestatic 76	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   170: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: ldc 200
    //   175: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload 5
    //   180: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: astore 6
    //   188: ldc 204
    //   190: aload 5
    //   192: invokestatic 195	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   195: invokevirtual 198	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   198: aload 6
    //   200: invokestatic 208	com/tencent/mm/vfs/s:nw	(Ljava/lang/String;Ljava/lang/String;)J
    //   203: pop2
    //   204: new 66	com/tencent/mm/vfs/o
    //   207: dup
    //   208: aload 6
    //   210: invokespecial 81	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   213: aload_1
    //   214: invokestatic 211	com/tencent/mm/storage/RegionCodeDecoder:e	(Lcom/tencent/mm/vfs/o;Lcom/tencent/mm/vfs/o;)V
    //   217: iload_2
    //   218: iconst_1
    //   219: iadd
    //   220: istore_2
    //   221: goto -153 -> 68
    //   224: ldc 213
    //   226: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   229: goto -181 -> 48
    //   232: astore_1
    //   233: aload_0
    //   234: monitorexit
    //   235: aload_1
    //   236: athrow
    //   237: astore_1
    //   238: ldc 103
    //   240: aload_1
    //   241: ldc 55
    //   243: iconst_0
    //   244: anewarray 4	java/lang/Object
    //   247: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   250: ldc 213
    //   252: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   255: goto -207 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	RegionCodeDecoder
    //   0	258	1	paramo	o
    //   1	220	2	i	int
    //   67	4	3	j	int
    //   10	64	4	arrayOfString	String[]
    //   77	114	5	str1	String
    //   186	23	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   4	9	232	finally
    //   12	25	232	finally
    //   25	32	232	finally
    //   37	48	232	finally
    //   51	68	232	finally
    //   79	99	232	finally
    //   99	217	232	finally
    //   224	229	232	finally
    //   238	255	232	finally
    //   51	68	237	java/lang/Exception
    //   79	99	237	java/lang/Exception
    //   99	217	237	java/lang/Exception
  }
  
  private static String bkM(String paramString)
  {
    AppMethodBeat.i(43279);
    o localo = new o(paramString);
    Object localObject = ae(localo);
    boolean bool;
    if (Util.isNullOrNil((String)localObject))
    {
      bool = false;
      if (bool) {
        break label199;
      }
      if (s.nw("assets:///regioncode/" + localo.getName(), paramString) <= 0L) {
        break label136;
      }
      i = 1;
      label64:
      if (i != 0) {
        break label146;
      }
      localObject = new o(localo.heq(), "mmregioncode_en.txt");
      paramString = aa.z(((o)localObject).her());
      if (s.nw("assets:///regioncode/mmregioncode_en.txt", aa.z(((o)localObject).her())) <= 0L) {
        break label141;
      }
    }
    label136:
    label141:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label146;
      }
      AppMethodBeat.o(43279);
      return null;
      bool = ((String)localObject).equals(af(localo));
      break;
      i = 0;
      break label64;
    }
    label146:
    localObject = new o(paramString);
    e((o)localObject, ((o)localObject).heq());
    Log.w("MicroMsg.RegionCodeDecoder", "Verifying codeFile: %s failed, after fallback, %s will be used.", new Object[] { localo.getName(), ((o)localObject).getName() });
    AppMethodBeat.o(43279);
    return paramString;
    label199:
    AppMethodBeat.o(43279);
    return paramString;
  }
  
  @Deprecated
  public static String bkN(String paramString)
  {
    AppMethodBeat.i(43286);
    if (!Util.isNullOrNil(paramString))
    {
      paramString = Orx + "mmregioncode_" + paramString + ".txt";
      AppMethodBeat.o(43286);
      return paramString;
    }
    AppMethodBeat.o(43286);
    return null;
  }
  
  public static final boolean bkO(String paramString)
  {
    AppMethodBeat.i(43288);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(43288);
      return false;
    }
    boolean bool = paramString.equalsIgnoreCase("cn");
    AppMethodBeat.o(43288);
    return bool;
  }
  
  public static String bkP(String paramString)
  {
    AppMethodBeat.i(43290);
    String str = getLocName(paramString);
    if (Util.isNullOrNil(str))
    {
      paramString = Util.nullAsNil(paramString);
      AppMethodBeat.o(43290);
      return paramString;
    }
    AppMethodBeat.o(43290);
    return str;
  }
  
  public static final String bq(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(43287);
    StringBuffer localStringBuffer = new StringBuffer();
    if (!Util.isNullOrNil(paramString1))
    {
      localStringBuffer.append(paramString1);
      if (!Util.isNullOrNil(paramString2))
      {
        localStringBuffer.append('_');
        localStringBuffer.append(paramString2);
        if (!Util.isNullOrNil(paramString3))
        {
          localStringBuffer.append('_');
          localStringBuffer.append(paramString3);
        }
      }
    }
    paramString1 = localStringBuffer.toString();
    AppMethodBeat.o(43287);
    return paramString1;
  }
  
  public static String br(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(163521);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString3)))
    {
      AppMethodBeat.o(163521);
      return null;
    }
    paramString1 = getLocName(bq(paramString1, paramString2, paramString3));
    AppMethodBeat.o(163521);
    return paramString1;
  }
  
  public static String bs(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(43292);
    paramString1 = br(paramString1, paramString2, paramString3);
    if (Util.isNullOrNil(paramString1))
    {
      paramString1 = Util.nullAsNil(paramString3);
      AppMethodBeat.o(43292);
      return paramString1;
    }
    AppMethodBeat.o(43292);
    return paramString1;
  }
  
  /* Error */
  public static void e(o paramo1, o paramo2)
  {
    // Byte code:
    //   0: ldc_w 292
    //   3: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 103
    //   8: ldc_w 294
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: invokevirtual 108	com/tencent/mm/vfs/o:getName	()Ljava/lang/String;
    //   21: aastore
    //   22: invokestatic 202	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: new 66	com/tencent/mm/vfs/o
    //   28: dup
    //   29: aload_1
    //   30: new 28	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   37: aload_0
    //   38: invokevirtual 108	com/tencent/mm/vfs/o:getName	()Ljava/lang/String;
    //   41: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 78
    //   46: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokespecial 234	com/tencent/mm/vfs/o:<init>	(Lcom/tencent/mm/vfs/o;Ljava/lang/String;)V
    //   55: astore_1
    //   56: aload_0
    //   57: invokestatic 238	com/tencent/mm/storage/RegionCodeDecoder:af	(Lcom/tencent/mm/vfs/o;)Ljava/lang/String;
    //   60: astore_3
    //   61: aload_3
    //   62: invokestatic 132	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   65: ifne +120 -> 185
    //   68: aload_1
    //   69: invokevirtual 85	com/tencent/mm/vfs/o:exists	()Z
    //   72: ifne +11 -> 83
    //   75: aload_1
    //   76: invokevirtual 229	com/tencent/mm/vfs/o:heq	()Lcom/tencent/mm/vfs/o;
    //   79: invokevirtual 297	com/tencent/mm/vfs/o:mkdirs	()Z
    //   82: pop
    //   83: new 299	com/tencent/mm/vfs/v
    //   86: dup
    //   87: aload_1
    //   88: invokespecial 300	com/tencent/mm/vfs/v:<init>	(Lcom/tencent/mm/vfs/o;)V
    //   91: astore_2
    //   92: aload_2
    //   93: astore_1
    //   94: aload_2
    //   95: aload_3
    //   96: invokevirtual 305	java/io/Writer:write	(Ljava/lang/String;)V
    //   99: aload_2
    //   100: invokevirtual 306	java/io/Writer:close	()V
    //   103: ldc_w 292
    //   106: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: return
    //   110: astore_0
    //   111: ldc_w 292
    //   114: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: return
    //   118: astore_3
    //   119: aconst_null
    //   120: astore_2
    //   121: aload_2
    //   122: astore_1
    //   123: ldc 103
    //   125: aload_3
    //   126: ldc_w 308
    //   129: iconst_1
    //   130: anewarray 4	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: aload_0
    //   136: invokevirtual 108	com/tencent/mm/vfs/o:getName	()Ljava/lang/String;
    //   139: aastore
    //   140: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: aload_2
    //   144: ifnull +41 -> 185
    //   147: aload_2
    //   148: invokevirtual 306	java/io/Writer:close	()V
    //   151: ldc_w 292
    //   154: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: return
    //   158: astore_0
    //   159: ldc_w 292
    //   162: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: return
    //   166: astore_0
    //   167: aconst_null
    //   168: astore_1
    //   169: aload_1
    //   170: ifnull +7 -> 177
    //   173: aload_1
    //   174: invokevirtual 306	java/io/Writer:close	()V
    //   177: ldc_w 292
    //   180: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aload_0
    //   184: athrow
    //   185: ldc_w 292
    //   188: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: return
    //   192: astore_1
    //   193: goto -16 -> 177
    //   196: astore_0
    //   197: goto -28 -> 169
    //   200: astore_3
    //   201: goto -80 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	paramo1	o
    //   0	204	1	paramo2	o
    //   91	57	2	localv	com.tencent.mm.vfs.v
    //   60	36	3	str	String
    //   118	8	3	localThrowable1	java.lang.Throwable
    //   200	1	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   99	103	110	java/lang/Throwable
    //   83	92	118	java/lang/Throwable
    //   147	151	158	java/lang/Throwable
    //   83	92	166	finally
    //   173	177	192	java/lang/Throwable
    //   94	99	196	finally
    //   123	143	196	finally
    //   94	99	200	java/lang/Throwable
  }
  
  public static RegionCodeDecoder gEm()
  {
    AppMethodBeat.i(43277);
    if (Orw == null) {
      Orw = new RegionCodeDecoder();
    }
    RegionCodeDecoder localRegionCodeDecoder = Orw;
    if (!LocaleUtil.getApplicationLanguage().equals(localRegionCodeDecoder.Ory)) {
      localRegionCodeDecoder.gBs();
    }
    localRegionCodeDecoder = Orw;
    AppMethodBeat.o(43277);
    return localRegionCodeDecoder;
  }
  
  public static String getCountry(String paramString)
  {
    AppMethodBeat.i(258521);
    paramString = getLocName(paramString);
    AppMethodBeat.o(258521);
    return paramString;
  }
  
  public static String getLocName(String paramString)
  {
    AppMethodBeat.i(43289);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(43289);
      return null;
    }
    paramString = DecoderJni.getLocName(paramString);
    AppMethodBeat.o(43289);
    return paramString;
  }
  
  public static String mV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(163520);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(163520);
      return null;
    }
    paramString1 = getLocName(bq(paramString1, paramString2, null));
    AppMethodBeat.o(163520);
    return paramString1;
  }
  
  public static String mW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(43291);
    paramString1 = mV(paramString1, paramString2);
    if (Util.isNullOrNil(paramString1))
    {
      paramString1 = Util.nullAsNil(paramString2);
      AppMethodBeat.o(43291);
      return paramString1;
    }
    AppMethodBeat.o(43291);
    return paramString1;
  }
  
  public final RegionCodeDecoder.Region[] bkQ(String paramString)
  {
    AppMethodBeat.i(43294);
    if ((Util.isNullOrNil(this.Orz)) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(43294);
      return null;
    }
    paramString = DecoderJni.getProvinces(this.Orz, paramString);
    AppMethodBeat.o(43294);
    return paramString;
  }
  
  public final void gBs()
  {
    AppMethodBeat.i(43278);
    Object localObject1 = new o(Orx);
    if (!((o)localObject1).exists())
    {
      ((o)localObject1).mkdirs();
      ag((o)localObject1);
    }
    Object localObject2 = ((o)localObject1).list();
    if ((localObject2 == null) || (localObject2.length == 0)) {
      ag((o)localObject1);
    }
    if (!s.YS(bkN("zh_HK")))
    {
      Log.w("MicroMsg.RegionCodeDecoder", "forward compatbility for not HK language support");
      ah((o)localObject1);
    }
    this.Ory = LocaleUtil.getApplicationLanguage();
    localObject1 = gEn();
    if (Util.isNullOrNil((String)localObject1))
    {
      Log.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found, curLang: " + this.Ory);
      AppMethodBeat.o(43278);
      return;
    }
    localObject1 = Orx + (String)localObject1;
    localObject2 = bkM((String)localObject1);
    if (Util.isNullOrNil((String)localObject2))
    {
      Log.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found after verify, curLang: " + this.Ory);
      AppMethodBeat.o(43278);
      return;
    }
    if ((!Util.isNullOrNil(this.Orz)) && (this.Orz.equals(localObject1)) && (((String)localObject1).equals(localObject2)))
    {
      AppMethodBeat.o(43278);
      return;
    }
    Log.w("MicroMsg.RegionCodeDecoder", "buildMap, after verify, codeFile %s is used. curLang: %s", new Object[] { new o((String)localObject2).getName(), this.Ory });
    this.Orz = ((String)localObject2);
    DecoderJni.buildFromFile(this.Orz);
    AppMethodBeat.o(43278);
  }
  
  public final String gEn()
  {
    AppMethodBeat.i(43285);
    String str2 = "mmregioncode_" + this.Ory + ".txt";
    Object localObject = new StringBuilder("mmregioncode_");
    if (this.Ory.equalsIgnoreCase("zh_HK")) {}
    for (String str1 = "zh_TW";; str1 = this.Ory)
    {
      str1 = str1 + ".txt";
      localObject = new o(Orx);
      if (((o)localObject).exists()) {
        break;
      }
      ((o)localObject).mkdirs();
      AppMethodBeat.o(43285);
      return null;
    }
    if (new o(Orx + str2).exists())
    {
      AppMethodBeat.o(43285);
      return str2;
    }
    if ((this.Ory.equalsIgnoreCase("zh_HK")) && (new o(Orx + str1).exists()))
    {
      AppMethodBeat.o(43285);
      return str1;
    }
    if (new o(Orx + "mmregioncode_en.txt").exists())
    {
      AppMethodBeat.o(43285);
      return "mmregioncode_en.txt";
    }
    AppMethodBeat.o(43285);
    return null;
  }
  
  public final RegionCodeDecoder.Region[] gEo()
  {
    AppMethodBeat.i(43293);
    if (Util.isNullOrNil(this.Orz))
    {
      AppMethodBeat.o(43293);
      return null;
    }
    RegionCodeDecoder.Region[] arrayOfRegion = DecoderJni.getCountries(this.Orz);
    AppMethodBeat.o(43293);
    return arrayOfRegion;
  }
  
  public final RegionCodeDecoder.Region[] mX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(43295);
    if ((Util.isNullOrNil(this.Orz)) || (Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(43295);
      return null;
    }
    paramString1 = DecoderJni.getCities(this.Orz, paramString1, paramString2);
    AppMethodBeat.o(43295);
    return paramString1;
  }
  
  static class DecoderJni
  {
    public static native void buildFromFile(String paramString);
    
    public static native RegionCodeDecoder.Region[] getCities(String paramString1, String paramString2, String paramString3);
    
    public static native RegionCodeDecoder.Region[] getCountries(String paramString);
    
    public static native String getLocName(String paramString);
    
    public static native RegionCodeDecoder.Region[] getProvinces(String paramString1, String paramString2);
    
    public static native void release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.RegionCodeDecoder
 * JD-Core Version:    0.7.0.1
 */