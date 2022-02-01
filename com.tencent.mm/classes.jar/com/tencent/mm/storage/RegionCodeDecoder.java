package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;

public final class RegionCodeDecoder
{
  private static RegionCodeDecoder adlq;
  public static final String adlr;
  public String adls = "";
  private String adlt = "";
  
  static
  {
    AppMethodBeat.i(43296);
    adlq = null;
    adlr = b.bmq() + "MicroMsg/regioncode/";
    AppMethodBeat.o(43296);
  }
  
  /* Error */
  private static String ah(u paramu)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 62
    //   4: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 64	com/tencent/mm/vfs/u
    //   10: dup
    //   11: new 28	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   18: aload_0
    //   19: invokevirtual 68	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   22: invokestatic 74	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   25: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 76
    //   30: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokespecial 79	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   39: astore 4
    //   41: aload 4
    //   43: invokevirtual 83	com/tencent/mm/vfs/u:jKS	()Z
    //   46: ifeq +98 -> 144
    //   49: new 85	java/io/BufferedReader
    //   52: dup
    //   53: new 87	com/tencent/mm/vfs/ab
    //   56: dup
    //   57: aload 4
    //   59: invokespecial 90	com/tencent/mm/vfs/ab:<init>	(Lcom/tencent/mm/vfs/u;)V
    //   62: invokespecial 93	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   65: astore_3
    //   66: aload_3
    //   67: invokevirtual 96	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   70: astore_0
    //   71: aload_3
    //   72: invokevirtual 99	java/io/BufferedReader:close	()V
    //   75: aload_0
    //   76: astore_1
    //   77: ldc 62
    //   79: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload_1
    //   83: areturn
    //   84: astore_1
    //   85: aconst_null
    //   86: astore_0
    //   87: ldc 101
    //   89: aload_1
    //   90: ldc 103
    //   92: iconst_1
    //   93: anewarray 4	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: aload 4
    //   100: invokevirtual 106	com/tencent/mm/vfs/u:getName	()Ljava/lang/String;
    //   103: aastore
    //   104: invokestatic 112	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: aload_2
    //   108: astore_1
    //   109: aload_0
    //   110: ifnull -33 -> 77
    //   113: aload_0
    //   114: invokevirtual 99	java/io/BufferedReader:close	()V
    //   117: aload_2
    //   118: astore_1
    //   119: goto -42 -> 77
    //   122: astore_0
    //   123: aload_2
    //   124: astore_1
    //   125: goto -48 -> 77
    //   128: astore_1
    //   129: aload_0
    //   130: ifnull +7 -> 137
    //   133: aload_0
    //   134: invokevirtual 99	java/io/BufferedReader:close	()V
    //   137: ldc 62
    //   139: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: aload_1
    //   143: athrow
    //   144: ldc 62
    //   146: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aconst_null
    //   150: areturn
    //   151: astore_1
    //   152: aload_0
    //   153: astore_1
    //   154: goto -77 -> 77
    //   157: astore_0
    //   158: goto -21 -> 137
    //   161: astore_1
    //   162: aload_3
    //   163: astore_0
    //   164: goto -77 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	paramu	u
    //   76	7	1	localu1	u
    //   84	6	1	localThrowable	java.lang.Throwable
    //   108	17	1	localObject1	Object
    //   128	15	1	localObject2	Object
    //   151	1	1	localObject3	Object
    //   153	1	1	localu2	u
    //   161	1	1	localObject4	Object
    //   1	123	2	localObject5	Object
    //   65	98	3	localBufferedReader	java.io.BufferedReader
    //   39	60	4	localu3	u
    // Exception table:
    //   from	to	target	type
    //   49	66	84	finally
    //   113	117	122	finally
    //   87	107	128	finally
    //   71	75	151	finally
    //   133	137	157	finally
    //   66	71	161	finally
  }
  
  private static String ai(u paramu)
  {
    AppMethodBeat.i(43282);
    String str = y.bub(ah.v(paramu.mUri));
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.RegionCodeDecoder", "Failed to calculate hash for file %s", new Object[] { paramu.getName() });
      AppMethodBeat.o(43282);
      return null;
    }
    paramu = MD5Util.getMD5String(str + "#" + paramu.lastModified() + "#" + q.eD(true));
    AppMethodBeat.o(43282);
    return paramu;
  }
  
  /* Error */
  private void aj(u paramu)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 160
    //   6: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aconst_null
    //   10: astore 4
    //   12: aload_1
    //   13: invokevirtual 83	com/tencent/mm/vfs/u:jKS	()Z
    //   16: ifeq +9 -> 25
    //   19: aload_1
    //   20: invokevirtual 164	com/tencent/mm/vfs/u:jKW	()[Ljava/lang/String;
    //   23: astore 4
    //   25: aload_1
    //   26: invokevirtual 83	com/tencent/mm/vfs/u:jKS	()Z
    //   29: ifeq +22 -> 51
    //   32: aload 4
    //   34: ifnull +17 -> 51
    //   37: aload 4
    //   39: arraylength
    //   40: ifeq +11 -> 51
    //   43: ldc 160
    //   45: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: invokestatic 170	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   54: invokevirtual 176	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   57: ldc 178
    //   59: invokevirtual 184	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   62: astore 4
    //   64: aload 4
    //   66: arraylength
    //   67: istore_3
    //   68: iload_2
    //   69: iload_3
    //   70: if_icmpge +135 -> 205
    //   73: aload 4
    //   75: iload_2
    //   76: aaload
    //   77: astore 5
    //   79: ldc 101
    //   81: ldc 186
    //   83: iconst_2
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: ldc 188
    //   91: aload 5
    //   93: invokestatic 194	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   96: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   99: aastore
    //   100: dup
    //   101: iconst_1
    //   102: new 28	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   109: aload_1
    //   110: getfield 118	com/tencent/mm/vfs/u:mUri	Landroid/net/Uri;
    //   113: invokestatic 74	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   116: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: ldc 199
    //   121: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload 5
    //   126: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: aastore
    //   133: invokestatic 201	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: new 28	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   143: aload_1
    //   144: getfield 118	com/tencent/mm/vfs/u:mUri	Landroid/net/Uri;
    //   147: invokestatic 74	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   150: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc 199
    //   155: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload 5
    //   160: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: astore 6
    //   168: ldc 203
    //   170: aload 5
    //   172: invokestatic 194	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   175: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   178: aload 6
    //   180: iconst_0
    //   181: invokestatic 207	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   184: pop2
    //   185: new 64	com/tencent/mm/vfs/u
    //   188: dup
    //   189: aload 6
    //   191: invokespecial 79	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   194: aload_1
    //   195: invokestatic 211	com/tencent/mm/storage/RegionCodeDecoder:h	(Lcom/tencent/mm/vfs/u;Lcom/tencent/mm/vfs/u;)V
    //   198: iload_2
    //   199: iconst_1
    //   200: iadd
    //   201: istore_2
    //   202: goto -134 -> 68
    //   205: ldc 160
    //   207: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: goto -162 -> 48
    //   213: astore_1
    //   214: aload_0
    //   215: monitorexit
    //   216: aload_1
    //   217: athrow
    //   218: astore_1
    //   219: ldc 101
    //   221: aload_1
    //   222: ldc 55
    //   224: iconst_0
    //   225: anewarray 4	java/lang/Object
    //   228: invokestatic 112	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   231: ldc 160
    //   233: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: goto -188 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	this	RegionCodeDecoder
    //   0	239	1	paramu	u
    //   1	201	2	i	int
    //   67	4	3	j	int
    //   10	64	4	arrayOfString	String[]
    //   77	94	5	str1	String
    //   166	24	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   4	9	213	finally
    //   12	25	213	finally
    //   25	32	213	finally
    //   37	48	213	finally
    //   51	68	213	finally
    //   79	198	213	finally
    //   205	210	213	finally
    //   219	236	213	finally
    //   51	68	218	java/lang/Exception
    //   79	198	218	java/lang/Exception
  }
  
  /* Error */
  private void ak(u paramu)
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
    //   13: invokevirtual 83	com/tencent/mm/vfs/u:jKS	()Z
    //   16: ifeq +9 -> 25
    //   19: aload_1
    //   20: invokevirtual 164	com/tencent/mm/vfs/u:jKW	()[Ljava/lang/String;
    //   23: astore 4
    //   25: aload_1
    //   26: invokevirtual 83	com/tencent/mm/vfs/u:jKS	()Z
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
    //   51: invokestatic 170	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   54: invokevirtual 176	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   57: ldc 178
    //   59: invokevirtual 184	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   62: astore 4
    //   64: aload 4
    //   66: arraylength
    //   67: istore_3
    //   68: iload_2
    //   69: iload_3
    //   70: if_icmpge +155 -> 225
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
    //   96: ifeq +122 -> 218
    //   99: ldc 101
    //   101: ldc 186
    //   103: iconst_2
    //   104: anewarray 4	java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: ldc 188
    //   111: aload 5
    //   113: invokestatic 194	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   116: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   119: aastore
    //   120: dup
    //   121: iconst_1
    //   122: new 28	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   129: aload_1
    //   130: getfield 118	com/tencent/mm/vfs/u:mUri	Landroid/net/Uri;
    //   133: invokestatic 74	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   136: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc 199
    //   141: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload 5
    //   146: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: aastore
    //   153: invokestatic 201	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   156: new 28	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   163: aload_1
    //   164: getfield 118	com/tencent/mm/vfs/u:mUri	Landroid/net/Uri;
    //   167: invokestatic 74	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   170: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: ldc 199
    //   175: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload 5
    //   180: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: astore 6
    //   188: ldc 203
    //   190: aload 5
    //   192: invokestatic 194	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   195: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   198: aload 6
    //   200: iconst_0
    //   201: invokestatic 207	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   204: pop2
    //   205: new 64	com/tencent/mm/vfs/u
    //   208: dup
    //   209: aload 6
    //   211: invokespecial 79	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   214: aload_1
    //   215: invokestatic 211	com/tencent/mm/storage/RegionCodeDecoder:h	(Lcom/tencent/mm/vfs/u;Lcom/tencent/mm/vfs/u;)V
    //   218: iload_2
    //   219: iconst_1
    //   220: iadd
    //   221: istore_2
    //   222: goto -154 -> 68
    //   225: ldc 213
    //   227: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   230: goto -182 -> 48
    //   233: astore_1
    //   234: aload_0
    //   235: monitorexit
    //   236: aload_1
    //   237: athrow
    //   238: astore_1
    //   239: ldc 101
    //   241: aload_1
    //   242: ldc 55
    //   244: iconst_0
    //   245: anewarray 4	java/lang/Object
    //   248: invokestatic 112	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   251: ldc 213
    //   253: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: goto -208 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	this	RegionCodeDecoder
    //   0	259	1	paramu	u
    //   1	221	2	i	int
    //   67	4	3	j	int
    //   10	64	4	arrayOfString	String[]
    //   77	114	5	str1	String
    //   186	24	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   4	9	233	finally
    //   12	25	233	finally
    //   25	32	233	finally
    //   37	48	233	finally
    //   51	68	233	finally
    //   79	99	233	finally
    //   99	218	233	finally
    //   225	230	233	finally
    //   239	256	233	finally
    //   51	68	238	java/lang/Exception
    //   79	99	238	java/lang/Exception
    //   99	218	238	java/lang/Exception
  }
  
  public static final String bI(String paramString1, String paramString2, String paramString3)
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
  
  public static String bJ(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(163521);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString3)))
    {
      AppMethodBeat.o(163521);
      return null;
    }
    paramString1 = getLocName(bI(paramString1, paramString2, paramString3));
    AppMethodBeat.o(163521);
    return paramString1;
  }
  
  public static String bK(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(43292);
    paramString1 = bJ(paramString1, paramString2, paramString3);
    if (Util.isNullOrNil(paramString1))
    {
      paramString1 = Util.nullAsNil(paramString3);
      AppMethodBeat.o(43292);
      return paramString1;
    }
    AppMethodBeat.o(43292);
    return paramString1;
  }
  
  private static String byE(String paramString)
  {
    AppMethodBeat.i(43279);
    u localu = new u(paramString);
    Object localObject = ah(localu);
    boolean bool;
    if (Util.isNullOrNil((String)localObject))
    {
      bool = false;
      if (bool) {
        break label204;
      }
      if (y.O("assets:///regioncode/" + localu.getName(), paramString, false) <= 0L) {
        break label140;
      }
      i = 1;
      label65:
      if (i != 0) {
        break label150;
      }
      localObject = new u(localu.jKP(), "mmregioncode_en.txt");
      paramString = ah.v(((u)localObject).jKT());
      if (y.O("assets:///regioncode/mmregioncode_en.txt", ah.v(((u)localObject).jKT()), false) <= 0L) {
        break label145;
      }
    }
    label140:
    label145:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label150;
      }
      AppMethodBeat.o(43279);
      return null;
      bool = ((String)localObject).equals(ai(localu));
      break;
      i = 0;
      break label65;
    }
    label150:
    localObject = new u(paramString);
    h((u)localObject, ((u)localObject).jKP());
    Log.w("MicroMsg.RegionCodeDecoder", "Verifying codeFile: %s failed, after fallback, %s will be used.", new Object[] { localu.getName(), ((u)localObject).getName() });
    AppMethodBeat.o(43279);
    return paramString;
    label204:
    AppMethodBeat.o(43279);
    return paramString;
  }
  
  @Deprecated
  public static String byF(String paramString)
  {
    AppMethodBeat.i(43286);
    if (!Util.isNullOrNil(paramString))
    {
      paramString = adlr + "mmregioncode_" + paramString + ".txt";
      AppMethodBeat.o(43286);
      return paramString;
    }
    AppMethodBeat.o(43286);
    return null;
  }
  
  public static final boolean byG(String paramString)
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
  
  public static String byH(String paramString)
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
  
  /* Error */
  public static void h(u paramu1, u paramu2)
  {
    // Byte code:
    //   0: ldc_w 294
    //   3: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 101
    //   8: ldc_w 296
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: invokevirtual 106	com/tencent/mm/vfs/u:getName	()Ljava/lang/String;
    //   21: aastore
    //   22: invokestatic 201	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: new 64	com/tencent/mm/vfs/u
    //   28: dup
    //   29: aload_1
    //   30: new 28	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   37: aload_0
    //   38: invokevirtual 106	com/tencent/mm/vfs/u:getName	()Ljava/lang/String;
    //   41: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 76
    //   46: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokespecial 261	com/tencent/mm/vfs/u:<init>	(Lcom/tencent/mm/vfs/u;Ljava/lang/String;)V
    //   55: astore_1
    //   56: aload_0
    //   57: invokestatic 265	com/tencent/mm/storage/RegionCodeDecoder:ai	(Lcom/tencent/mm/vfs/u;)Ljava/lang/String;
    //   60: astore_2
    //   61: aload_2
    //   62: invokestatic 130	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   65: ifne +114 -> 179
    //   68: aload_1
    //   69: invokevirtual 83	com/tencent/mm/vfs/u:jKS	()Z
    //   72: ifne +11 -> 83
    //   75: aload_1
    //   76: invokevirtual 256	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
    //   79: invokevirtual 299	com/tencent/mm/vfs/u:jKY	()Z
    //   82: pop
    //   83: new 301	com/tencent/mm/vfs/ac
    //   86: dup
    //   87: aload_1
    //   88: invokespecial 302	com/tencent/mm/vfs/ac:<init>	(Lcom/tencent/mm/vfs/u;)V
    //   91: astore_1
    //   92: aload_1
    //   93: aload_2
    //   94: invokevirtual 307	java/io/Writer:write	(Ljava/lang/String;)V
    //   97: aload_1
    //   98: invokevirtual 308	java/io/Writer:close	()V
    //   101: ldc_w 294
    //   104: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: return
    //   108: astore_0
    //   109: ldc_w 294
    //   112: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: return
    //   116: astore_2
    //   117: aconst_null
    //   118: astore_1
    //   119: ldc 101
    //   121: aload_2
    //   122: ldc_w 310
    //   125: iconst_1
    //   126: anewarray 4	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: aload_0
    //   132: invokevirtual 106	com/tencent/mm/vfs/u:getName	()Ljava/lang/String;
    //   135: aastore
    //   136: invokestatic 112	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   139: aload_1
    //   140: ifnull +39 -> 179
    //   143: aload_1
    //   144: invokevirtual 308	java/io/Writer:close	()V
    //   147: ldc_w 294
    //   150: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: return
    //   154: astore_0
    //   155: ldc_w 294
    //   158: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: return
    //   162: astore_0
    //   163: aload_1
    //   164: ifnull +7 -> 171
    //   167: aload_1
    //   168: invokevirtual 308	java/io/Writer:close	()V
    //   171: ldc_w 294
    //   174: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: aload_0
    //   178: athrow
    //   179: ldc_w 294
    //   182: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: return
    //   186: astore_1
    //   187: goto -16 -> 171
    //   190: astore_2
    //   191: goto -72 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	paramu1	u
    //   0	194	1	paramu2	u
    //   60	34	2	str	String
    //   116	6	2	localThrowable	java.lang.Throwable
    //   190	1	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   97	101	108	finally
    //   83	92	116	finally
    //   143	147	154	finally
    //   119	139	162	finally
    //   167	171	186	finally
    //   92	97	190	finally
  }
  
  public static RegionCodeDecoder jcF()
  {
    AppMethodBeat.i(43277);
    if (adlq == null) {
      adlq = new RegionCodeDecoder();
    }
    RegionCodeDecoder localRegionCodeDecoder = adlq;
    if (!LocaleUtil.getApplicationLanguage().equals(localRegionCodeDecoder.adls)) {
      localRegionCodeDecoder.iZh();
    }
    localRegionCodeDecoder = adlq;
    AppMethodBeat.o(43277);
    return localRegionCodeDecoder;
  }
  
  public static String pL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(163520);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(163520);
      return null;
    }
    paramString1 = getLocName(bI(paramString1, paramString2, null));
    AppMethodBeat.o(163520);
    return paramString1;
  }
  
  public static String pM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(43291);
    paramString1 = pL(paramString1, paramString2);
    if (Util.isNullOrNil(paramString1))
    {
      paramString1 = Util.nullAsNil(paramString2);
      AppMethodBeat.o(43291);
      return paramString1;
    }
    AppMethodBeat.o(43291);
    return paramString1;
  }
  
  public final RegionCodeDecoder.Region[] byI(String paramString)
  {
    AppMethodBeat.i(43294);
    if ((Util.isNullOrNil(this.adlt)) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(43294);
      return null;
    }
    paramString = DecoderJni.getProvinces(this.adlt, paramString);
    AppMethodBeat.o(43294);
    return paramString;
  }
  
  public final void iZh()
  {
    AppMethodBeat.i(43278);
    Object localObject1 = new u(adlr);
    if (!((u)localObject1).jKS())
    {
      ((u)localObject1).jKY();
      aj((u)localObject1);
    }
    Object localObject2 = ((u)localObject1).jKW();
    if ((localObject2 == null) || (localObject2.length == 0)) {
      aj((u)localObject1);
    }
    if (!y.ZC(byF("zh_HK")))
    {
      Log.w("MicroMsg.RegionCodeDecoder", "forward compatbility for not HK language support");
      ak((u)localObject1);
    }
    this.adls = LocaleUtil.getApplicationLanguage();
    localObject1 = jcG();
    if (Util.isNullOrNil((String)localObject1))
    {
      Log.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found, curLang: " + this.adls);
      AppMethodBeat.o(43278);
      return;
    }
    localObject1 = adlr + (String)localObject1;
    localObject2 = byE((String)localObject1);
    if (Util.isNullOrNil((String)localObject2))
    {
      Log.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found after verify, curLang: " + this.adls);
      AppMethodBeat.o(43278);
      return;
    }
    if ((!Util.isNullOrNil(this.adlt)) && (this.adlt.equals(localObject1)) && (((String)localObject1).equals(localObject2)))
    {
      AppMethodBeat.o(43278);
      return;
    }
    Log.w("MicroMsg.RegionCodeDecoder", "buildMap, after verify, codeFile %s is used. curLang: %s", new Object[] { new u((String)localObject2).getName(), this.adls });
    this.adlt = ((String)localObject2);
    DecoderJni.buildFromFile(this.adlt);
    AppMethodBeat.o(43278);
  }
  
  public final String jcG()
  {
    AppMethodBeat.i(43285);
    String str2 = "mmregioncode_" + this.adls + ".txt";
    Object localObject = new StringBuilder("mmregioncode_");
    if (this.adls.equalsIgnoreCase("zh_HK")) {}
    for (String str1 = "zh_TW";; str1 = this.adls)
    {
      str1 = str1 + ".txt";
      localObject = new u(adlr);
      if (((u)localObject).jKS()) {
        break;
      }
      ((u)localObject).jKY();
      AppMethodBeat.o(43285);
      return null;
    }
    if (new u(adlr + str2).jKS())
    {
      AppMethodBeat.o(43285);
      return str2;
    }
    if ((this.adls.equalsIgnoreCase("zh_HK")) && (new u(adlr + str1).jKS()))
    {
      AppMethodBeat.o(43285);
      return str1;
    }
    if (new u(adlr + "mmregioncode_en.txt").jKS())
    {
      AppMethodBeat.o(43285);
      return "mmregioncode_en.txt";
    }
    AppMethodBeat.o(43285);
    return null;
  }
  
  public final RegionCodeDecoder.Region[] jcH()
  {
    AppMethodBeat.i(43293);
    if (Util.isNullOrNil(this.adlt))
    {
      AppMethodBeat.o(43293);
      return null;
    }
    RegionCodeDecoder.Region[] arrayOfRegion = DecoderJni.getCountries(this.adlt);
    AppMethodBeat.o(43293);
    return arrayOfRegion;
  }
  
  public final RegionCodeDecoder.Region[] pN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(43295);
    if ((Util.isNullOrNil(this.adlt)) || (Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(43295);
      return null;
    }
    paramString1 = DecoderJni.getCities(this.adlt, paramString1, paramString2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.RegionCodeDecoder
 * JD-Core Version:    0.7.0.1
 */