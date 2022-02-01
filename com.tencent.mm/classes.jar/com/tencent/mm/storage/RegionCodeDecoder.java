package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;

public final class RegionCodeDecoder
{
  private static RegionCodeDecoder FAG;
  public static final String FAH;
  public String FAI = "";
  private String FAJ = "";
  
  static
  {
    AppMethodBeat.i(43296);
    FAG = null;
    FAH = b.ahY() + "MicroMsg/regioncode/";
    AppMethodBeat.o(43296);
  }
  
  /* Error */
  private static String X(e parame)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 64
    //   4: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 66	com/tencent/mm/vfs/e
    //   10: dup
    //   11: new 28	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   18: aload_0
    //   19: invokevirtual 70	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
    //   22: invokestatic 76	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   25: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 78
    //   30: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokespecial 81	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   39: astore 4
    //   41: aload 4
    //   43: invokevirtual 85	com/tencent/mm/vfs/e:exists	()Z
    //   46: ifeq +104 -> 150
    //   49: new 87	java/io/BufferedReader
    //   52: dup
    //   53: new 89	com/tencent/mm/vfs/k
    //   56: dup
    //   57: aload 4
    //   59: invokespecial 92	com/tencent/mm/vfs/k:<init>	(Lcom/tencent/mm/vfs/e;)V
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
    //   104: invokevirtual 108	com/tencent/mm/vfs/e:getName	()Ljava/lang/String;
    //   107: aastore
    //   108: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   0	173	0	parame	e
    //   65	53	1	localBufferedReader	java.io.BufferedReader
    //   132	17	1	localObject1	Object
    //   157	1	1	localThrowable1	java.lang.Throwable
    //   165	1	1	localObject2	Object
    //   72	2	2	str	String
    //   86	8	2	localThrowable2	java.lang.Throwable
    //   169	1	2	localThrowable3	java.lang.Throwable
    //   1	127	3	localObject3	Object
    //   39	64	4	locale	e
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
  
  private static String Y(e parame)
  {
    AppMethodBeat.i(43282);
    String str = i.aEN(com.tencent.mm.vfs.q.B(parame.mUri));
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.RegionCodeDecoder", "Failed to calculate hash for file %s", new Object[] { parame.getName() });
      AppMethodBeat.o(43282);
      return null;
    }
    parame = ai.du(str + "#" + parame.lastModified() + "#" + com.tencent.mm.compatible.deviceinfo.q.cG(true));
    AppMethodBeat.o(43282);
    return parame;
  }
  
  /* Error */
  private void Z(e parame)
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
    //   13: invokevirtual 85	com/tencent/mm/vfs/e:exists	()Z
    //   16: ifeq +9 -> 25
    //   19: aload_1
    //   20: invokevirtual 166	com/tencent/mm/vfs/e:list	()[Ljava/lang/String;
    //   23: astore 4
    //   25: aload_1
    //   26: invokevirtual 85	com/tencent/mm/vfs/e:exists	()Z
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
    //   51: invokestatic 172	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
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
    //   110: getfield 120	com/tencent/mm/vfs/e:mUri	Landroid/net/Uri;
    //   113: invokestatic 76	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   116: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: ldc 200
    //   121: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload 5
    //   126: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: aastore
    //   133: invokestatic 202	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: new 28	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   143: aload_1
    //   144: getfield 120	com/tencent/mm/vfs/e:mUri	Landroid/net/Uri;
    //   147: invokestatic 76	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
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
    //   180: invokestatic 208	com/tencent/mm/vfs/i:lC	(Ljava/lang/String;Ljava/lang/String;)J
    //   183: pop2
    //   184: new 66	com/tencent/mm/vfs/e
    //   187: dup
    //   188: aload 6
    //   190: invokespecial 81	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   193: aload_1
    //   194: invokestatic 212	com/tencent/mm/storage/RegionCodeDecoder:d	(Lcom/tencent/mm/vfs/e;Lcom/tencent/mm/vfs/e;)V
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
    //   227: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   230: ldc 162
    //   232: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: goto -187 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	RegionCodeDecoder
    //   0	238	1	parame	e
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
  
  private static String aJa(String paramString)
  {
    AppMethodBeat.i(43279);
    e locale = new e(paramString);
    Object localObject = X(locale);
    boolean bool;
    if (bt.isNullOrNil((String)localObject))
    {
      bool = false;
      if (bool) {
        break label199;
      }
      if (i.lC("assets:///regioncode/" + locale.getName(), paramString) <= 0L) {
        break label136;
      }
      i = 1;
      label64:
      if (i != 0) {
        break label146;
      }
      localObject = new e(locale.fhT(), "mmregioncode_en.txt");
      paramString = com.tencent.mm.vfs.q.B(((e)localObject).fhU());
      if (i.lC("assets:///regioncode/mmregioncode_en.txt", com.tencent.mm.vfs.q.B(((e)localObject).fhU())) <= 0L) {
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
      bool = ((String)localObject).equals(Y(locale));
      break;
      i = 0;
      break label64;
    }
    label146:
    localObject = new e(paramString);
    d((e)localObject, ((e)localObject).fhT());
    ad.w("MicroMsg.RegionCodeDecoder", "Verifying codeFile: %s failed, after fallback, %s will be used.", new Object[] { locale.getName(), ((e)localObject).getName() });
    AppMethodBeat.o(43279);
    return paramString;
    label199:
    AppMethodBeat.o(43279);
    return paramString;
  }
  
  @Deprecated
  public static String aJb(String paramString)
  {
    AppMethodBeat.i(43286);
    if (!bt.isNullOrNil(paramString))
    {
      paramString = FAH + "mmregioncode_" + paramString + ".txt";
      AppMethodBeat.o(43286);
      return paramString;
    }
    AppMethodBeat.o(43286);
    return null;
  }
  
  public static final boolean aJc(String paramString)
  {
    AppMethodBeat.i(43288);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(43288);
      return false;
    }
    boolean bool = paramString.equalsIgnoreCase("cn");
    AppMethodBeat.o(43288);
    return bool;
  }
  
  public static String aJd(String paramString)
  {
    AppMethodBeat.i(43290);
    String str = getLocName(paramString);
    if (bt.isNullOrNil(str))
    {
      paramString = bt.nullAsNil(paramString);
      AppMethodBeat.o(43290);
      return paramString;
    }
    AppMethodBeat.o(43290);
    return str;
  }
  
  public static final String aT(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(43287);
    StringBuffer localStringBuffer = new StringBuffer();
    if (!bt.isNullOrNil(paramString1))
    {
      localStringBuffer.append(paramString1);
      if (!bt.isNullOrNil(paramString2))
      {
        localStringBuffer.append('_');
        localStringBuffer.append(paramString2);
        if (!bt.isNullOrNil(paramString3))
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
  
  public static String aU(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(163521);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)) || (bt.isNullOrNil(paramString3)))
    {
      AppMethodBeat.o(163521);
      return null;
    }
    paramString1 = getLocName(aT(paramString1, paramString2, paramString3));
    AppMethodBeat.o(163521);
    return paramString1;
  }
  
  public static String aV(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(43292);
    paramString1 = aU(paramString1, paramString2, paramString3);
    if (bt.isNullOrNil(paramString1))
    {
      paramString1 = bt.nullAsNil(paramString3);
      AppMethodBeat.o(43292);
      return paramString1;
    }
    AppMethodBeat.o(43292);
    return paramString1;
  }
  
  /* Error */
  private void aa(e parame)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 285
    //   7: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aconst_null
    //   11: astore 4
    //   13: aload_1
    //   14: invokevirtual 85	com/tencent/mm/vfs/e:exists	()Z
    //   17: ifeq +9 -> 26
    //   20: aload_1
    //   21: invokevirtual 166	com/tencent/mm/vfs/e:list	()[Ljava/lang/String;
    //   24: astore 4
    //   26: aload_1
    //   27: invokevirtual 85	com/tencent/mm/vfs/e:exists	()Z
    //   30: ifeq +23 -> 53
    //   33: aload 4
    //   35: ifnull +18 -> 53
    //   38: aload 4
    //   40: arraylength
    //   41: ifeq +12 -> 53
    //   44: ldc_w 285
    //   47: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: invokestatic 172	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   56: invokevirtual 178	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   59: ldc 180
    //   61: invokevirtual 185	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   64: astore 4
    //   66: aload 4
    //   68: arraylength
    //   69: istore_3
    //   70: iload_2
    //   71: iload_3
    //   72: if_icmpge +156 -> 228
    //   75: aload 4
    //   77: iload_2
    //   78: aaload
    //   79: astore 5
    //   81: aload 5
    //   83: ldc_w 287
    //   86: invokevirtual 290	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   89: ifne +14 -> 103
    //   92: aload 5
    //   94: ldc_w 292
    //   97: invokevirtual 290	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   100: ifeq +121 -> 221
    //   103: ldc 103
    //   105: ldc 187
    //   107: iconst_2
    //   108: anewarray 4	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: ldc 189
    //   115: aload 5
    //   117: invokestatic 195	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   120: invokevirtual 198	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   123: aastore
    //   124: dup
    //   125: iconst_1
    //   126: new 28	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   133: aload_1
    //   134: getfield 120	com/tencent/mm/vfs/e:mUri	Landroid/net/Uri;
    //   137: invokestatic 76	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   140: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc 200
    //   145: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload 5
    //   150: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: aastore
    //   157: invokestatic 202	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   160: new 28	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   167: aload_1
    //   168: getfield 120	com/tencent/mm/vfs/e:mUri	Landroid/net/Uri;
    //   171: invokestatic 76	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   174: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: ldc 200
    //   179: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload 5
    //   184: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: astore 6
    //   192: ldc 204
    //   194: aload 5
    //   196: invokestatic 195	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   199: invokevirtual 198	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   202: aload 6
    //   204: invokestatic 208	com/tencent/mm/vfs/i:lC	(Ljava/lang/String;Ljava/lang/String;)J
    //   207: pop2
    //   208: new 66	com/tencent/mm/vfs/e
    //   211: dup
    //   212: aload 6
    //   214: invokespecial 81	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   217: aload_1
    //   218: invokestatic 212	com/tencent/mm/storage/RegionCodeDecoder:d	(Lcom/tencent/mm/vfs/e;Lcom/tencent/mm/vfs/e;)V
    //   221: iload_2
    //   222: iconst_1
    //   223: iadd
    //   224: istore_2
    //   225: goto -155 -> 70
    //   228: ldc_w 285
    //   231: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: goto -184 -> 50
    //   237: astore_1
    //   238: aload_0
    //   239: monitorexit
    //   240: aload_1
    //   241: athrow
    //   242: astore_1
    //   243: ldc 103
    //   245: aload_1
    //   246: ldc 55
    //   248: iconst_0
    //   249: anewarray 4	java/lang/Object
    //   252: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   255: ldc_w 285
    //   258: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   261: goto -211 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	RegionCodeDecoder
    //   0	264	1	parame	e
    //   1	224	2	i	int
    //   69	4	3	j	int
    //   11	65	4	arrayOfString	String[]
    //   79	116	5	str1	String
    //   190	23	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   4	10	237	finally
    //   13	26	237	finally
    //   26	33	237	finally
    //   38	50	237	finally
    //   53	70	237	finally
    //   81	103	237	finally
    //   103	221	237	finally
    //   228	234	237	finally
    //   243	261	237	finally
    //   53	70	242	java/lang/Exception
    //   81	103	242	java/lang/Exception
    //   103	221	242	java/lang/Exception
  }
  
  /* Error */
  public static void d(e parame1, e parame2)
  {
    // Byte code:
    //   0: ldc_w 293
    //   3: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 103
    //   8: ldc_w 295
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: invokevirtual 108	com/tencent/mm/vfs/e:getName	()Ljava/lang/String;
    //   21: aastore
    //   22: invokestatic 202	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: new 66	com/tencent/mm/vfs/e
    //   28: dup
    //   29: aload_1
    //   30: new 28	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   37: aload_0
    //   38: invokevirtual 108	com/tencent/mm/vfs/e:getName	()Ljava/lang/String;
    //   41: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 78
    //   46: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokespecial 226	com/tencent/mm/vfs/e:<init>	(Lcom/tencent/mm/vfs/e;Ljava/lang/String;)V
    //   55: astore_1
    //   56: aload_0
    //   57: invokestatic 230	com/tencent/mm/storage/RegionCodeDecoder:Y	(Lcom/tencent/mm/vfs/e;)Ljava/lang/String;
    //   60: astore_3
    //   61: aload_3
    //   62: invokestatic 132	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   65: ifne +120 -> 185
    //   68: aload_1
    //   69: invokevirtual 85	com/tencent/mm/vfs/e:exists	()Z
    //   72: ifne +11 -> 83
    //   75: aload_1
    //   76: invokevirtual 221	com/tencent/mm/vfs/e:fhT	()Lcom/tencent/mm/vfs/e;
    //   79: invokevirtual 298	com/tencent/mm/vfs/e:mkdirs	()Z
    //   82: pop
    //   83: new 300	com/tencent/mm/vfs/l
    //   86: dup
    //   87: aload_1
    //   88: invokespecial 301	com/tencent/mm/vfs/l:<init>	(Lcom/tencent/mm/vfs/e;)V
    //   91: astore_2
    //   92: aload_2
    //   93: astore_1
    //   94: aload_2
    //   95: aload_3
    //   96: invokevirtual 306	java/io/Writer:write	(Ljava/lang/String;)V
    //   99: aload_2
    //   100: invokevirtual 307	java/io/Writer:close	()V
    //   103: ldc_w 293
    //   106: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: return
    //   110: astore_0
    //   111: ldc_w 293
    //   114: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: return
    //   118: astore_3
    //   119: aconst_null
    //   120: astore_2
    //   121: aload_2
    //   122: astore_1
    //   123: ldc 103
    //   125: aload_3
    //   126: ldc_w 309
    //   129: iconst_1
    //   130: anewarray 4	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: aload_0
    //   136: invokevirtual 108	com/tencent/mm/vfs/e:getName	()Ljava/lang/String;
    //   139: aastore
    //   140: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: aload_2
    //   144: ifnull +41 -> 185
    //   147: aload_2
    //   148: invokevirtual 307	java/io/Writer:close	()V
    //   151: ldc_w 293
    //   154: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: return
    //   158: astore_0
    //   159: ldc_w 293
    //   162: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: return
    //   166: astore_0
    //   167: aconst_null
    //   168: astore_1
    //   169: aload_1
    //   170: ifnull +7 -> 177
    //   173: aload_1
    //   174: invokevirtual 307	java/io/Writer:close	()V
    //   177: ldc_w 293
    //   180: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aload_0
    //   184: athrow
    //   185: ldc_w 293
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
    //   0	204	0	parame1	e
    //   0	204	1	parame2	e
    //   91	57	2	locall	com.tencent.mm.vfs.l
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
  
  public static RegionCodeDecoder eMO()
  {
    AppMethodBeat.i(43277);
    if (FAG == null) {
      FAG = new RegionCodeDecoder();
    }
    RegionCodeDecoder localRegionCodeDecoder = FAG;
    if (!ac.eFu().equals(localRegionCodeDecoder.FAI)) {
      localRegionCodeDecoder.eKn();
    }
    localRegionCodeDecoder = FAG;
    AppMethodBeat.o(43277);
    return localRegionCodeDecoder;
  }
  
  public static String getCountry(String paramString)
  {
    AppMethodBeat.i(197136);
    paramString = getLocName(paramString);
    AppMethodBeat.o(197136);
    return paramString;
  }
  
  public static String getLocName(String paramString)
  {
    AppMethodBeat.i(43289);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(43289);
      return null;
    }
    paramString = DecoderJni.getLocName(paramString);
    AppMethodBeat.o(43289);
    return paramString;
  }
  
  public static String lf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(163520);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(163520);
      return null;
    }
    paramString1 = getLocName(aT(paramString1, paramString2, null));
    AppMethodBeat.o(163520);
    return paramString1;
  }
  
  public static String lg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(43291);
    paramString1 = lf(paramString1, paramString2);
    if (bt.isNullOrNil(paramString1))
    {
      paramString1 = bt.nullAsNil(paramString2);
      AppMethodBeat.o(43291);
      return paramString1;
    }
    AppMethodBeat.o(43291);
    return paramString1;
  }
  
  public final RegionCodeDecoder.Region[] aJe(String paramString)
  {
    AppMethodBeat.i(43294);
    if ((bt.isNullOrNil(this.FAJ)) || (bt.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(43294);
      return null;
    }
    paramString = DecoderJni.getProvinces(this.FAJ, paramString);
    AppMethodBeat.o(43294);
    return paramString;
  }
  
  public final void eKn()
  {
    AppMethodBeat.i(43278);
    Object localObject1 = new e(FAH);
    if (!((e)localObject1).exists())
    {
      ((e)localObject1).mkdirs();
      Z((e)localObject1);
    }
    Object localObject2 = ((e)localObject1).list();
    if ((localObject2 == null) || (localObject2.length == 0)) {
      Z((e)localObject1);
    }
    if (!i.eK(aJb("zh_HK")))
    {
      ad.w("MicroMsg.RegionCodeDecoder", "forward compatbility for not HK language support");
      aa((e)localObject1);
    }
    this.FAI = ac.eFu();
    localObject1 = eMP();
    if (bt.isNullOrNil((String)localObject1))
    {
      ad.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found, curLang: " + this.FAI);
      AppMethodBeat.o(43278);
      return;
    }
    localObject1 = FAH + (String)localObject1;
    localObject2 = aJa((String)localObject1);
    if (bt.isNullOrNil((String)localObject2))
    {
      ad.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found after verify, curLang: " + this.FAI);
      AppMethodBeat.o(43278);
      return;
    }
    if ((!bt.isNullOrNil(this.FAJ)) && (this.FAJ.equals(localObject1)) && (((String)localObject1).equals(localObject2)))
    {
      AppMethodBeat.o(43278);
      return;
    }
    ad.w("MicroMsg.RegionCodeDecoder", "buildMap, after verify, codeFile %s is used. curLang: %s", new Object[] { new e((String)localObject2).getName(), this.FAI });
    this.FAJ = ((String)localObject2);
    DecoderJni.buildFromFile(this.FAJ);
    AppMethodBeat.o(43278);
  }
  
  public final String eMP()
  {
    AppMethodBeat.i(43285);
    String str2 = "mmregioncode_" + this.FAI + ".txt";
    Object localObject = new StringBuilder("mmregioncode_");
    if (this.FAI.equalsIgnoreCase("zh_HK")) {}
    for (String str1 = "zh_TW";; str1 = this.FAI)
    {
      str1 = str1 + ".txt";
      localObject = new e(FAH);
      if (((e)localObject).exists()) {
        break;
      }
      ((e)localObject).mkdirs();
      AppMethodBeat.o(43285);
      return null;
    }
    if (new e(FAH + str2).exists())
    {
      AppMethodBeat.o(43285);
      return str2;
    }
    if ((this.FAI.equalsIgnoreCase("zh_HK")) && (new e(FAH + str1).exists()))
    {
      AppMethodBeat.o(43285);
      return str1;
    }
    if (new e(FAH + "mmregioncode_en.txt").exists())
    {
      AppMethodBeat.o(43285);
      return "mmregioncode_en.txt";
    }
    AppMethodBeat.o(43285);
    return null;
  }
  
  public final RegionCodeDecoder.Region[] eMQ()
  {
    AppMethodBeat.i(43293);
    if (bt.isNullOrNil(this.FAJ))
    {
      AppMethodBeat.o(43293);
      return null;
    }
    RegionCodeDecoder.Region[] arrayOfRegion = DecoderJni.getCountries(this.FAJ);
    AppMethodBeat.o(43293);
    return arrayOfRegion;
  }
  
  public final RegionCodeDecoder.Region[] lh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(43295);
    if ((bt.isNullOrNil(this.FAJ)) || (bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(43295);
      return null;
    }
    paramString1 = DecoderJni.getCities(this.FAJ, paramString1, paramString2);
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