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
  private static RegionCodeDecoder IMX;
  public static final String IMY;
  public String IMZ = "";
  private String INa = "";
  
  static
  {
    AppMethodBeat.i(43296);
    IMX = null;
    IMY = b.arL() + "MicroMsg/regioncode/";
    AppMethodBeat.o(43296);
  }
  
  /* Error */
  private static String Y(e parame)
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
    //   19: invokevirtual 70	com/tencent/mm/vfs/e:fOK	()Landroid/net/Uri;
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
  
  private static String Z(e parame)
  {
    AppMethodBeat.i(43282);
    String str = i.aPK(com.tencent.mm.vfs.q.B(parame.mUri));
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.RegionCodeDecoder", "Failed to calculate hash for file %s", new Object[] { parame.getName() });
      AppMethodBeat.o(43282);
      return null;
    }
    parame = ai.ee(str + "#" + parame.lastModified() + "#" + com.tencent.mm.compatible.deviceinfo.q.cH(true));
    AppMethodBeat.o(43282);
    return parame;
  }
  
  private static String aUn(String paramString)
  {
    AppMethodBeat.i(43279);
    e locale = new e(paramString);
    Object localObject = Y(locale);
    boolean bool;
    if (bt.isNullOrNil((String)localObject))
    {
      bool = false;
      if (bool) {
        break label199;
      }
      if (i.mz("assets:///regioncode/" + locale.getName(), paramString) <= 0L) {
        break label136;
      }
      i = 1;
      label64:
      if (i != 0) {
        break label146;
      }
      localObject = new e(locale.fOJ(), "mmregioncode_en.txt");
      paramString = com.tencent.mm.vfs.q.B(((e)localObject).fOK());
      if (i.mz("assets:///regioncode/mmregioncode_en.txt", com.tencent.mm.vfs.q.B(((e)localObject).fOK())) <= 0L) {
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
      bool = ((String)localObject).equals(Z(locale));
      break;
      i = 0;
      break label64;
    }
    label146:
    localObject = new e(paramString);
    d((e)localObject, ((e)localObject).fOJ());
    ad.w("MicroMsg.RegionCodeDecoder", "Verifying codeFile: %s failed, after fallback, %s will be used.", new Object[] { locale.getName(), ((e)localObject).getName() });
    AppMethodBeat.o(43279);
    return paramString;
    label199:
    AppMethodBeat.o(43279);
    return paramString;
  }
  
  @Deprecated
  public static String aUo(String paramString)
  {
    AppMethodBeat.i(43286);
    if (!bt.isNullOrNil(paramString))
    {
      paramString = IMY + "mmregioncode_" + paramString + ".txt";
      AppMethodBeat.o(43286);
      return paramString;
    }
    AppMethodBeat.o(43286);
    return null;
  }
  
  public static final boolean aUp(String paramString)
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
  
  public static String aUq(String paramString)
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
  
  /* Error */
  private void aa(e parame)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 224
    //   6: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aconst_null
    //   10: astore 4
    //   12: aload_1
    //   13: invokevirtual 85	com/tencent/mm/vfs/e:exists	()Z
    //   16: ifeq +9 -> 25
    //   19: aload_1
    //   20: invokevirtual 228	com/tencent/mm/vfs/e:list	()[Ljava/lang/String;
    //   23: astore 4
    //   25: aload_1
    //   26: invokevirtual 85	com/tencent/mm/vfs/e:exists	()Z
    //   29: ifeq +22 -> 51
    //   32: aload 4
    //   34: ifnull +17 -> 51
    //   37: aload 4
    //   39: arraylength
    //   40: ifeq +11 -> 51
    //   43: ldc 224
    //   45: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: invokestatic 234	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   54: invokevirtual 240	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   57: ldc 242
    //   59: invokevirtual 247	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   62: astore 4
    //   64: aload 4
    //   66: arraylength
    //   67: istore_3
    //   68: iload_2
    //   69: iload_3
    //   70: if_icmpge +136 -> 206
    //   73: aload 4
    //   75: iload_2
    //   76: aaload
    //   77: astore 5
    //   79: ldc 103
    //   81: ldc 249
    //   83: iconst_2
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: ldc 251
    //   91: aload 5
    //   93: invokestatic 255	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   96: invokevirtual 258	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
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
    //   119: ldc_w 260
    //   122: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload 5
    //   127: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: aastore
    //   134: invokestatic 262	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: new 28	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   144: aload_1
    //   145: getfield 120	com/tencent/mm/vfs/e:mUri	Landroid/net/Uri;
    //   148: invokestatic 76	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   151: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc_w 260
    //   157: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload 5
    //   162: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: astore 6
    //   170: ldc 164
    //   172: aload 5
    //   174: invokestatic 255	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   177: invokevirtual 258	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   180: aload 6
    //   182: invokestatic 169	com/tencent/mm/vfs/i:mz	(Ljava/lang/String;Ljava/lang/String;)J
    //   185: pop2
    //   186: new 66	com/tencent/mm/vfs/e
    //   189: dup
    //   190: aload 6
    //   192: invokespecial 81	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   195: aload_1
    //   196: invokestatic 192	com/tencent/mm/storage/RegionCodeDecoder:d	(Lcom/tencent/mm/vfs/e;Lcom/tencent/mm/vfs/e;)V
    //   199: iload_2
    //   200: iconst_1
    //   201: iadd
    //   202: istore_2
    //   203: goto -135 -> 68
    //   206: ldc 224
    //   208: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: goto -163 -> 48
    //   214: astore_1
    //   215: aload_0
    //   216: monitorexit
    //   217: aload_1
    //   218: athrow
    //   219: astore_1
    //   220: ldc 103
    //   222: aload_1
    //   223: ldc 55
    //   225: iconst_0
    //   226: anewarray 4	java/lang/Object
    //   229: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: ldc 224
    //   234: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: goto -189 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	this	RegionCodeDecoder
    //   0	240	1	parame	e
    //   1	202	2	i	int
    //   67	4	3	j	int
    //   10	64	4	arrayOfString	String[]
    //   77	96	5	str1	String
    //   168	23	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   4	9	214	finally
    //   12	25	214	finally
    //   25	32	214	finally
    //   37	48	214	finally
    //   51	68	214	finally
    //   79	199	214	finally
    //   206	211	214	finally
    //   220	237	214	finally
    //   51	68	219	java/lang/Exception
    //   79	199	219	java/lang/Exception
  }
  
  /* Error */
  private void ab(e parame)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 264
    //   7: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aconst_null
    //   11: astore 4
    //   13: aload_1
    //   14: invokevirtual 85	com/tencent/mm/vfs/e:exists	()Z
    //   17: ifeq +9 -> 26
    //   20: aload_1
    //   21: invokevirtual 228	com/tencent/mm/vfs/e:list	()[Ljava/lang/String;
    //   24: astore 4
    //   26: aload_1
    //   27: invokevirtual 85	com/tencent/mm/vfs/e:exists	()Z
    //   30: ifeq +23 -> 53
    //   33: aload 4
    //   35: ifnull +18 -> 53
    //   38: aload 4
    //   40: arraylength
    //   41: ifeq +12 -> 53
    //   44: ldc_w 264
    //   47: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: invokestatic 234	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   56: invokevirtual 240	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   59: ldc 242
    //   61: invokevirtual 247	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   64: astore 4
    //   66: aload 4
    //   68: arraylength
    //   69: istore_3
    //   70: iload_2
    //   71: iload_3
    //   72: if_icmpge +158 -> 230
    //   75: aload 4
    //   77: iload_2
    //   78: aaload
    //   79: astore 5
    //   81: aload 5
    //   83: ldc_w 266
    //   86: invokevirtual 269	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   89: ifne +14 -> 103
    //   92: aload 5
    //   94: ldc_w 271
    //   97: invokevirtual 269	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   100: ifeq +123 -> 223
    //   103: ldc 103
    //   105: ldc 249
    //   107: iconst_2
    //   108: anewarray 4	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: ldc 251
    //   115: aload 5
    //   117: invokestatic 255	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   120: invokevirtual 258	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
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
    //   143: ldc_w 260
    //   146: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload 5
    //   151: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: aastore
    //   158: invokestatic 262	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   161: new 28	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   168: aload_1
    //   169: getfield 120	com/tencent/mm/vfs/e:mUri	Landroid/net/Uri;
    //   172: invokestatic 76	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   175: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: ldc_w 260
    //   181: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload 5
    //   186: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: astore 6
    //   194: ldc 164
    //   196: aload 5
    //   198: invokestatic 255	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   201: invokevirtual 258	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   204: aload 6
    //   206: invokestatic 169	com/tencent/mm/vfs/i:mz	(Ljava/lang/String;Ljava/lang/String;)J
    //   209: pop2
    //   210: new 66	com/tencent/mm/vfs/e
    //   213: dup
    //   214: aload 6
    //   216: invokespecial 81	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   219: aload_1
    //   220: invokestatic 192	com/tencent/mm/storage/RegionCodeDecoder:d	(Lcom/tencent/mm/vfs/e;Lcom/tencent/mm/vfs/e;)V
    //   223: iload_2
    //   224: iconst_1
    //   225: iadd
    //   226: istore_2
    //   227: goto -157 -> 70
    //   230: ldc_w 264
    //   233: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: goto -186 -> 50
    //   239: astore_1
    //   240: aload_0
    //   241: monitorexit
    //   242: aload_1
    //   243: athrow
    //   244: astore_1
    //   245: ldc 103
    //   247: aload_1
    //   248: ldc 55
    //   250: iconst_0
    //   251: anewarray 4	java/lang/Object
    //   254: invokestatic 114	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   257: ldc_w 264
    //   260: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   263: goto -213 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	RegionCodeDecoder
    //   0	266	1	parame	e
    //   1	226	2	i	int
    //   69	4	3	j	int
    //   11	65	4	arrayOfString	String[]
    //   79	118	5	str1	String
    //   192	23	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   4	10	239	finally
    //   13	26	239	finally
    //   26	33	239	finally
    //   38	50	239	finally
    //   53	70	239	finally
    //   81	103	239	finally
    //   103	223	239	finally
    //   230	236	239	finally
    //   245	263	239	finally
    //   53	70	244	java/lang/Exception
    //   81	103	244	java/lang/Exception
    //   103	223	244	java/lang/Exception
  }
  
  public static final String bf(String paramString1, String paramString2, String paramString3)
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
  
  public static String bg(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(163521);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)) || (bt.isNullOrNil(paramString3)))
    {
      AppMethodBeat.o(163521);
      return null;
    }
    paramString1 = getLocName(bf(paramString1, paramString2, paramString3));
    AppMethodBeat.o(163521);
    return paramString1;
  }
  
  public static String bh(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(43292);
    paramString1 = bg(paramString1, paramString2, paramString3);
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
    //   22: invokestatic 262	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   52: invokespecial 178	com/tencent/mm/vfs/e:<init>	(Lcom/tencent/mm/vfs/e;Ljava/lang/String;)V
    //   55: astore_1
    //   56: aload_0
    //   57: invokestatic 182	com/tencent/mm/storage/RegionCodeDecoder:Z	(Lcom/tencent/mm/vfs/e;)Ljava/lang/String;
    //   60: astore_3
    //   61: aload_3
    //   62: invokestatic 132	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   65: ifne +120 -> 185
    //   68: aload_1
    //   69: invokevirtual 85	com/tencent/mm/vfs/e:exists	()Z
    //   72: ifne +11 -> 83
    //   75: aload_1
    //   76: invokevirtual 173	com/tencent/mm/vfs/e:fOJ	()Lcom/tencent/mm/vfs/e;
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
  
  public static RegionCodeDecoder fsz()
  {
    AppMethodBeat.i(43277);
    if (IMX == null) {
      IMX = new RegionCodeDecoder();
    }
    RegionCodeDecoder localRegionCodeDecoder = IMX;
    if (!ac.fks().equals(localRegionCodeDecoder.IMZ)) {
      localRegionCodeDecoder.fpM();
    }
    localRegionCodeDecoder = IMX;
    AppMethodBeat.o(43277);
    return localRegionCodeDecoder;
  }
  
  public static String getCountry(String paramString)
  {
    AppMethodBeat.i(221205);
    paramString = getLocName(paramString);
    AppMethodBeat.o(221205);
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
  
  public static String ma(String paramString1, String paramString2)
  {
    AppMethodBeat.i(163520);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(163520);
      return null;
    }
    paramString1 = getLocName(bf(paramString1, paramString2, null));
    AppMethodBeat.o(163520);
    return paramString1;
  }
  
  public static String mb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(43291);
    paramString1 = ma(paramString1, paramString2);
    if (bt.isNullOrNil(paramString1))
    {
      paramString1 = bt.nullAsNil(paramString2);
      AppMethodBeat.o(43291);
      return paramString1;
    }
    AppMethodBeat.o(43291);
    return paramString1;
  }
  
  public final RegionCodeDecoder.Region[] aUr(String paramString)
  {
    AppMethodBeat.i(43294);
    if ((bt.isNullOrNil(this.INa)) || (bt.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(43294);
      return null;
    }
    paramString = DecoderJni.getProvinces(this.INa, paramString);
    AppMethodBeat.o(43294);
    return paramString;
  }
  
  public final void fpM()
  {
    AppMethodBeat.i(43278);
    Object localObject1 = new e(IMY);
    if (!((e)localObject1).exists())
    {
      ((e)localObject1).mkdirs();
      aa((e)localObject1);
    }
    Object localObject2 = ((e)localObject1).list();
    if ((localObject2 == null) || (localObject2.length == 0)) {
      aa((e)localObject1);
    }
    if (!i.fv(aUo("zh_HK")))
    {
      ad.w("MicroMsg.RegionCodeDecoder", "forward compatbility for not HK language support");
      ab((e)localObject1);
    }
    this.IMZ = ac.fks();
    localObject1 = fsA();
    if (bt.isNullOrNil((String)localObject1))
    {
      ad.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found, curLang: " + this.IMZ);
      AppMethodBeat.o(43278);
      return;
    }
    localObject1 = IMY + (String)localObject1;
    localObject2 = aUn((String)localObject1);
    if (bt.isNullOrNil((String)localObject2))
    {
      ad.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found after verify, curLang: " + this.IMZ);
      AppMethodBeat.o(43278);
      return;
    }
    if ((!bt.isNullOrNil(this.INa)) && (this.INa.equals(localObject1)) && (((String)localObject1).equals(localObject2)))
    {
      AppMethodBeat.o(43278);
      return;
    }
    ad.w("MicroMsg.RegionCodeDecoder", "buildMap, after verify, codeFile %s is used. curLang: %s", new Object[] { new e((String)localObject2).getName(), this.IMZ });
    this.INa = ((String)localObject2);
    DecoderJni.buildFromFile(this.INa);
    AppMethodBeat.o(43278);
  }
  
  public final String fsA()
  {
    AppMethodBeat.i(43285);
    String str2 = "mmregioncode_" + this.IMZ + ".txt";
    Object localObject = new StringBuilder("mmregioncode_");
    if (this.IMZ.equalsIgnoreCase("zh_HK")) {}
    for (String str1 = "zh_TW";; str1 = this.IMZ)
    {
      str1 = str1 + ".txt";
      localObject = new e(IMY);
      if (((e)localObject).exists()) {
        break;
      }
      ((e)localObject).mkdirs();
      AppMethodBeat.o(43285);
      return null;
    }
    if (new e(IMY + str2).exists())
    {
      AppMethodBeat.o(43285);
      return str2;
    }
    if ((this.IMZ.equalsIgnoreCase("zh_HK")) && (new e(IMY + str1).exists()))
    {
      AppMethodBeat.o(43285);
      return str1;
    }
    if (new e(IMY + "mmregioncode_en.txt").exists())
    {
      AppMethodBeat.o(43285);
      return "mmregioncode_en.txt";
    }
    AppMethodBeat.o(43285);
    return null;
  }
  
  public final RegionCodeDecoder.Region[] fsB()
  {
    AppMethodBeat.i(43293);
    if (bt.isNullOrNil(this.INa))
    {
      AppMethodBeat.o(43293);
      return null;
    }
    RegionCodeDecoder.Region[] arrayOfRegion = DecoderJni.getCountries(this.INa);
    AppMethodBeat.o(43293);
    return arrayOfRegion;
  }
  
  public final RegionCodeDecoder.Region[] mc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(43295);
    if ((bt.isNullOrNil(this.INa)) || (bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(43295);
      return null;
    }
    paramString1 = DecoderJni.getCities(this.INa, paramString1, paramString2);
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