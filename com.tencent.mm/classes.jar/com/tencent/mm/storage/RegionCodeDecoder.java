package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public final class RegionCodeDecoder
{
  private static RegionCodeDecoder VHt;
  public static final String VHu;
  public String VHv = "";
  private String VHw = "";
  
  static
  {
    AppMethodBeat.i(43296);
    VHt = null;
    VHu = b.aSC() + "MicroMsg/regioncode/";
    AppMethodBeat.o(43296);
  }
  
  /* Error */
  private static String ae(com.tencent.mm.vfs.q paramq)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 64
    //   4: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 66	com/tencent/mm/vfs/q
    //   10: dup
    //   11: new 28	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   18: aload_0
    //   19: invokevirtual 69	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   22: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 71
    //   27: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokespecial 74	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   36: astore 4
    //   38: aload 4
    //   40: invokevirtual 78	com/tencent/mm/vfs/q:ifE	()Z
    //   43: ifeq +104 -> 147
    //   46: new 80	java/io/BufferedReader
    //   49: dup
    //   50: new 82	com/tencent/mm/vfs/x
    //   53: dup
    //   54: aload 4
    //   56: invokespecial 85	com/tencent/mm/vfs/x:<init>	(Lcom/tencent/mm/vfs/q;)V
    //   59: invokespecial 88	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   62: astore_1
    //   63: aload_1
    //   64: astore_0
    //   65: aload_1
    //   66: invokevirtual 91	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   69: astore_2
    //   70: aload_2
    //   71: astore_0
    //   72: aload_1
    //   73: invokevirtual 94	java/io/BufferedReader:close	()V
    //   76: ldc 64
    //   78: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_0
    //   82: areturn
    //   83: astore_2
    //   84: aconst_null
    //   85: astore_1
    //   86: aload_1
    //   87: astore_0
    //   88: ldc 96
    //   90: aload_2
    //   91: ldc 98
    //   93: iconst_1
    //   94: anewarray 4	java/lang/Object
    //   97: dup
    //   98: iconst_0
    //   99: aload 4
    //   101: invokevirtual 101	com/tencent/mm/vfs/q:getName	()Ljava/lang/String;
    //   104: aastore
    //   105: invokestatic 107	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: aload_3
    //   109: astore_0
    //   110: aload_1
    //   111: ifnull -35 -> 76
    //   114: aload_1
    //   115: invokevirtual 94	java/io/BufferedReader:close	()V
    //   118: aload_3
    //   119: astore_0
    //   120: goto -44 -> 76
    //   123: astore_0
    //   124: aload_3
    //   125: astore_0
    //   126: goto -50 -> 76
    //   129: astore_1
    //   130: aconst_null
    //   131: astore_0
    //   132: aload_0
    //   133: ifnull +7 -> 140
    //   136: aload_0
    //   137: invokevirtual 94	java/io/BufferedReader:close	()V
    //   140: ldc 64
    //   142: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aload_1
    //   146: athrow
    //   147: ldc 64
    //   149: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aconst_null
    //   153: areturn
    //   154: astore_1
    //   155: goto -79 -> 76
    //   158: astore_0
    //   159: goto -19 -> 140
    //   162: astore_1
    //   163: goto -31 -> 132
    //   166: astore_2
    //   167: goto -81 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	paramq	com.tencent.mm.vfs.q
    //   62	53	1	localBufferedReader	java.io.BufferedReader
    //   129	17	1	localObject1	Object
    //   154	1	1	localThrowable1	java.lang.Throwable
    //   162	1	1	localObject2	Object
    //   69	2	2	str	String
    //   83	8	2	localThrowable2	java.lang.Throwable
    //   166	1	2	localThrowable3	java.lang.Throwable
    //   1	124	3	localObject3	Object
    //   36	64	4	localq	com.tencent.mm.vfs.q
    // Exception table:
    //   from	to	target	type
    //   46	63	83	java/lang/Throwable
    //   114	118	123	java/lang/Throwable
    //   46	63	129	finally
    //   72	76	154	java/lang/Throwable
    //   136	140	158	java/lang/Throwable
    //   65	70	162	finally
    //   88	108	162	finally
    //   65	70	166	java/lang/Throwable
  }
  
  private static String af(com.tencent.mm.vfs.q paramq)
  {
    AppMethodBeat.i(43282);
    String str = u.buc(paramq.getPath());
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.RegionCodeDecoder", "Failed to calculate hash for file %s", new Object[] { paramq.getName() });
      AppMethodBeat.o(43282);
      return null;
    }
    paramq = MD5Util.getMD5String(str + "#" + paramq.lastModified() + "#" + com.tencent.mm.compatible.deviceinfo.q.dR(true));
    AppMethodBeat.o(43282);
    return paramq;
  }
  
  /* Error */
  private void ag(com.tencent.mm.vfs.q paramq)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 154
    //   6: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aconst_null
    //   10: astore 4
    //   12: aload_1
    //   13: invokevirtual 78	com/tencent/mm/vfs/q:ifE	()Z
    //   16: ifeq +9 -> 25
    //   19: aload_1
    //   20: invokevirtual 158	com/tencent/mm/vfs/q:ifI	()[Ljava/lang/String;
    //   23: astore 4
    //   25: aload_1
    //   26: invokevirtual 78	com/tencent/mm/vfs/q:ifE	()Z
    //   29: ifeq +22 -> 51
    //   32: aload 4
    //   34: ifnull +17 -> 51
    //   37: aload 4
    //   39: arraylength
    //   40: ifeq +11 -> 51
    //   43: ldc 154
    //   45: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: invokestatic 164	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   54: invokevirtual 170	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   57: ldc 172
    //   59: invokevirtual 178	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   62: astore 4
    //   64: aload 4
    //   66: arraylength
    //   67: istore_3
    //   68: iload_2
    //   69: iload_3
    //   70: if_icmpge +128 -> 198
    //   73: aload 4
    //   75: iload_2
    //   76: aaload
    //   77: astore 5
    //   79: ldc 96
    //   81: ldc 180
    //   83: iconst_2
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: ldc 182
    //   91: aload 5
    //   93: invokestatic 188	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   96: invokevirtual 191	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   99: aastore
    //   100: dup
    //   101: iconst_1
    //   102: new 28	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   109: aload_1
    //   110: invokevirtual 112	com/tencent/mm/vfs/q:getPath	()Ljava/lang/String;
    //   113: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc 193
    //   118: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload 5
    //   123: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: aastore
    //   130: invokestatic 195	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: new 28	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   140: aload_1
    //   141: invokevirtual 112	com/tencent/mm/vfs/q:getPath	()Ljava/lang/String;
    //   144: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc 193
    //   149: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload 5
    //   154: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: astore 6
    //   162: ldc 197
    //   164: aload 5
    //   166: invokestatic 188	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   169: invokevirtual 191	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   172: aload 6
    //   174: invokestatic 201	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   177: pop2
    //   178: new 66	com/tencent/mm/vfs/q
    //   181: dup
    //   182: aload 6
    //   184: invokespecial 74	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   187: aload_1
    //   188: invokestatic 204	com/tencent/mm/storage/RegionCodeDecoder:e	(Lcom/tencent/mm/vfs/q;Lcom/tencent/mm/vfs/q;)V
    //   191: iload_2
    //   192: iconst_1
    //   193: iadd
    //   194: istore_2
    //   195: goto -127 -> 68
    //   198: ldc 154
    //   200: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: goto -155 -> 48
    //   206: astore_1
    //   207: aload_0
    //   208: monitorexit
    //   209: aload_1
    //   210: athrow
    //   211: astore_1
    //   212: ldc 96
    //   214: aload_1
    //   215: ldc 55
    //   217: iconst_0
    //   218: anewarray 4	java/lang/Object
    //   221: invokestatic 107	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   224: ldc 154
    //   226: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   229: goto -181 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	RegionCodeDecoder
    //   0	232	1	paramq	com.tencent.mm.vfs.q
    //   1	194	2	i	int
    //   67	4	3	j	int
    //   10	64	4	arrayOfString	String[]
    //   77	88	5	str1	String
    //   160	23	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   4	9	206	finally
    //   12	25	206	finally
    //   25	32	206	finally
    //   37	48	206	finally
    //   51	68	206	finally
    //   79	191	206	finally
    //   198	203	206	finally
    //   212	229	206	finally
    //   51	68	211	java/lang/Exception
    //   79	191	211	java/lang/Exception
  }
  
  /* Error */
  private void ah(com.tencent.mm.vfs.q paramq)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 206
    //   6: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aconst_null
    //   10: astore 4
    //   12: aload_1
    //   13: invokevirtual 78	com/tencent/mm/vfs/q:ifE	()Z
    //   16: ifeq +9 -> 25
    //   19: aload_1
    //   20: invokevirtual 158	com/tencent/mm/vfs/q:ifI	()[Ljava/lang/String;
    //   23: astore 4
    //   25: aload_1
    //   26: invokevirtual 78	com/tencent/mm/vfs/q:ifE	()Z
    //   29: ifeq +22 -> 51
    //   32: aload 4
    //   34: ifnull +17 -> 51
    //   37: aload 4
    //   39: arraylength
    //   40: ifeq +11 -> 51
    //   43: ldc 206
    //   45: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: invokestatic 164	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   54: invokevirtual 170	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   57: ldc 172
    //   59: invokevirtual 178	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   62: astore 4
    //   64: aload 4
    //   66: arraylength
    //   67: istore_3
    //   68: iload_2
    //   69: iload_3
    //   70: if_icmpge +148 -> 218
    //   73: aload 4
    //   75: iload_2
    //   76: aaload
    //   77: astore 5
    //   79: aload 5
    //   81: ldc 208
    //   83: invokevirtual 211	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   86: ifne +13 -> 99
    //   89: aload 5
    //   91: ldc 213
    //   93: invokevirtual 211	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   96: ifeq +115 -> 211
    //   99: ldc 96
    //   101: ldc 180
    //   103: iconst_2
    //   104: anewarray 4	java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: ldc 182
    //   111: aload 5
    //   113: invokestatic 188	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   116: invokevirtual 191	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   119: aastore
    //   120: dup
    //   121: iconst_1
    //   122: new 28	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   129: aload_1
    //   130: invokevirtual 112	com/tencent/mm/vfs/q:getPath	()Ljava/lang/String;
    //   133: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc 193
    //   138: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload 5
    //   143: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: aastore
    //   150: invokestatic 195	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: new 28	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   160: aload_1
    //   161: invokevirtual 112	com/tencent/mm/vfs/q:getPath	()Ljava/lang/String;
    //   164: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: ldc 193
    //   169: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload 5
    //   174: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: astore 6
    //   182: ldc 197
    //   184: aload 5
    //   186: invokestatic 188	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   189: invokevirtual 191	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   192: aload 6
    //   194: invokestatic 201	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   197: pop2
    //   198: new 66	com/tencent/mm/vfs/q
    //   201: dup
    //   202: aload 6
    //   204: invokespecial 74	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   207: aload_1
    //   208: invokestatic 204	com/tencent/mm/storage/RegionCodeDecoder:e	(Lcom/tencent/mm/vfs/q;Lcom/tencent/mm/vfs/q;)V
    //   211: iload_2
    //   212: iconst_1
    //   213: iadd
    //   214: istore_2
    //   215: goto -147 -> 68
    //   218: ldc 206
    //   220: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: goto -175 -> 48
    //   226: astore_1
    //   227: aload_0
    //   228: monitorexit
    //   229: aload_1
    //   230: athrow
    //   231: astore_1
    //   232: ldc 96
    //   234: aload_1
    //   235: ldc 55
    //   237: iconst_0
    //   238: anewarray 4	java/lang/Object
    //   241: invokestatic 107	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   244: ldc 206
    //   246: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   249: goto -201 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	RegionCodeDecoder
    //   0	252	1	paramq	com.tencent.mm.vfs.q
    //   1	214	2	i	int
    //   67	4	3	j	int
    //   10	64	4	arrayOfString	String[]
    //   77	108	5	str1	String
    //   180	23	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   4	9	226	finally
    //   12	25	226	finally
    //   25	32	226	finally
    //   37	48	226	finally
    //   51	68	226	finally
    //   79	99	226	finally
    //   99	211	226	finally
    //   218	223	226	finally
    //   232	249	226	finally
    //   51	68	231	java/lang/Exception
    //   79	99	231	java/lang/Exception
    //   99	211	231	java/lang/Exception
  }
  
  public static final String bl(String paramString1, String paramString2, String paramString3)
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
  
  public static String bm(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(163521);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString3)))
    {
      AppMethodBeat.o(163521);
      return null;
    }
    paramString1 = getLocName(bl(paramString1, paramString2, paramString3));
    AppMethodBeat.o(163521);
    return paramString1;
  }
  
  public static String bn(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(43292);
    paramString1 = bm(paramString1, paramString2, paramString3);
    if (Util.isNullOrNil(paramString1))
    {
      paramString1 = Util.nullAsNil(paramString3);
      AppMethodBeat.o(43292);
      return paramString1;
    }
    AppMethodBeat.o(43292);
    return paramString1;
  }
  
  private static String bxl(String paramString)
  {
    AppMethodBeat.i(43279);
    com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q(paramString);
    Object localObject = ae(localq);
    boolean bool;
    if (Util.isNullOrNil((String)localObject))
    {
      bool = false;
      if (bool) {
        break label195;
      }
      if (u.on("assets:///regioncode/" + localq.getName(), paramString) <= 0L) {
        break label131;
      }
      i = 1;
      label64:
      if (i != 0) {
        break label141;
      }
      localObject = new com.tencent.mm.vfs.q(localq.ifB(), "mmregioncode_en.txt");
      paramString = ((com.tencent.mm.vfs.q)localObject).bOF();
      if (u.on("assets:///regioncode/mmregioncode_en.txt", ((com.tencent.mm.vfs.q)localObject).bOF()) <= 0L) {
        break label136;
      }
    }
    label131:
    label136:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label141;
      }
      AppMethodBeat.o(43279);
      return null;
      bool = ((String)localObject).equals(af(localq));
      break;
      i = 0;
      break label64;
    }
    label141:
    localObject = new com.tencent.mm.vfs.q(paramString);
    e((com.tencent.mm.vfs.q)localObject, ((com.tencent.mm.vfs.q)localObject).ifB());
    Log.w("MicroMsg.RegionCodeDecoder", "Verifying codeFile: %s failed, after fallback, %s will be used.", new Object[] { localq.getName(), ((com.tencent.mm.vfs.q)localObject).getName() });
    AppMethodBeat.o(43279);
    return paramString;
    label195:
    AppMethodBeat.o(43279);
    return paramString;
  }
  
  @Deprecated
  public static String bxm(String paramString)
  {
    AppMethodBeat.i(43286);
    if (!Util.isNullOrNil(paramString))
    {
      paramString = VHu + "mmregioncode_" + paramString + ".txt";
      AppMethodBeat.o(43286);
      return paramString;
    }
    AppMethodBeat.o(43286);
    return null;
  }
  
  public static final boolean bxn(String paramString)
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
  
  public static String bxo(String paramString)
  {
    AppMethodBeat.i(292926);
    paramString = getLocName(paramString);
    AppMethodBeat.o(292926);
    return paramString;
  }
  
  public static String bxp(String paramString)
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
  
  /* Error */
  public static void e(com.tencent.mm.vfs.q paramq1, com.tencent.mm.vfs.q paramq2)
  {
    // Byte code:
    //   0: ldc_w 287
    //   3: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 96
    //   8: ldc_w 289
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: invokevirtual 101	com/tencent/mm/vfs/q:getName	()Ljava/lang/String;
    //   21: aastore
    //   22: invokestatic 195	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: new 66	com/tencent/mm/vfs/q
    //   28: dup
    //   29: aload_1
    //   30: new 28	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   37: aload_0
    //   38: invokevirtual 101	com/tencent/mm/vfs/q:getName	()Ljava/lang/String;
    //   41: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 71
    //   46: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokespecial 254	com/tencent/mm/vfs/q:<init>	(Lcom/tencent/mm/vfs/q;Ljava/lang/String;)V
    //   55: astore_1
    //   56: aload_0
    //   57: invokestatic 258	com/tencent/mm/storage/RegionCodeDecoder:af	(Lcom/tencent/mm/vfs/q;)Ljava/lang/String;
    //   60: astore_3
    //   61: aload_3
    //   62: invokestatic 124	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   65: ifne +120 -> 185
    //   68: aload_1
    //   69: invokevirtual 78	com/tencent/mm/vfs/q:ifE	()Z
    //   72: ifne +11 -> 83
    //   75: aload_1
    //   76: invokevirtual 249	com/tencent/mm/vfs/q:ifB	()Lcom/tencent/mm/vfs/q;
    //   79: invokevirtual 292	com/tencent/mm/vfs/q:ifL	()Z
    //   82: pop
    //   83: new 294	com/tencent/mm/vfs/y
    //   86: dup
    //   87: aload_1
    //   88: invokespecial 295	com/tencent/mm/vfs/y:<init>	(Lcom/tencent/mm/vfs/q;)V
    //   91: astore_2
    //   92: aload_2
    //   93: astore_1
    //   94: aload_2
    //   95: aload_3
    //   96: invokevirtual 300	java/io/Writer:write	(Ljava/lang/String;)V
    //   99: aload_2
    //   100: invokevirtual 301	java/io/Writer:close	()V
    //   103: ldc_w 287
    //   106: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: return
    //   110: astore_0
    //   111: ldc_w 287
    //   114: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: return
    //   118: astore_3
    //   119: aconst_null
    //   120: astore_2
    //   121: aload_2
    //   122: astore_1
    //   123: ldc 96
    //   125: aload_3
    //   126: ldc_w 303
    //   129: iconst_1
    //   130: anewarray 4	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: aload_0
    //   136: invokevirtual 101	com/tencent/mm/vfs/q:getName	()Ljava/lang/String;
    //   139: aastore
    //   140: invokestatic 107	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: aload_2
    //   144: ifnull +41 -> 185
    //   147: aload_2
    //   148: invokevirtual 301	java/io/Writer:close	()V
    //   151: ldc_w 287
    //   154: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: return
    //   158: astore_0
    //   159: ldc_w 287
    //   162: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: return
    //   166: astore_0
    //   167: aconst_null
    //   168: astore_1
    //   169: aload_1
    //   170: ifnull +7 -> 177
    //   173: aload_1
    //   174: invokevirtual 301	java/io/Writer:close	()V
    //   177: ldc_w 287
    //   180: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aload_0
    //   184: athrow
    //   185: ldc_w 287
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
    //   0	204	0	paramq1	com.tencent.mm.vfs.q
    //   0	204	1	paramq2	com.tencent.mm.vfs.q
    //   91	57	2	localy	com.tencent.mm.vfs.y
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
  
  public static RegionCodeDecoder hAC()
  {
    AppMethodBeat.i(43277);
    if (VHt == null) {
      VHt = new RegionCodeDecoder();
    }
    RegionCodeDecoder localRegionCodeDecoder = VHt;
    if (!LocaleUtil.getApplicationLanguage().equals(localRegionCodeDecoder.VHv)) {
      localRegionCodeDecoder.hxD();
    }
    localRegionCodeDecoder = VHt;
    AppMethodBeat.o(43277);
    return localRegionCodeDecoder;
  }
  
  public static String nN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(163520);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(163520);
      return null;
    }
    paramString1 = getLocName(bl(paramString1, paramString2, null));
    AppMethodBeat.o(163520);
    return paramString1;
  }
  
  public static String nO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(43291);
    paramString1 = nN(paramString1, paramString2);
    if (Util.isNullOrNil(paramString1))
    {
      paramString1 = Util.nullAsNil(paramString2);
      AppMethodBeat.o(43291);
      return paramString1;
    }
    AppMethodBeat.o(43291);
    return paramString1;
  }
  
  public final RegionCodeDecoder.Region[] bxq(String paramString)
  {
    AppMethodBeat.i(43294);
    if ((Util.isNullOrNil(this.VHw)) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(43294);
      return null;
    }
    paramString = DecoderJni.getProvinces(this.VHw, paramString);
    AppMethodBeat.o(43294);
    return paramString;
  }
  
  public final String hAD()
  {
    AppMethodBeat.i(43285);
    String str2 = "mmregioncode_" + this.VHv + ".txt";
    Object localObject = new StringBuilder("mmregioncode_");
    if (this.VHv.equalsIgnoreCase("zh_HK")) {}
    for (String str1 = "zh_TW";; str1 = this.VHv)
    {
      str1 = str1 + ".txt";
      localObject = new com.tencent.mm.vfs.q(VHu);
      if (((com.tencent.mm.vfs.q)localObject).ifE()) {
        break;
      }
      ((com.tencent.mm.vfs.q)localObject).ifK();
      AppMethodBeat.o(43285);
      return null;
    }
    if (new com.tencent.mm.vfs.q(VHu + str2).ifE())
    {
      AppMethodBeat.o(43285);
      return str2;
    }
    if ((this.VHv.equalsIgnoreCase("zh_HK")) && (new com.tencent.mm.vfs.q(VHu + str1).ifE()))
    {
      AppMethodBeat.o(43285);
      return str1;
    }
    if (new com.tencent.mm.vfs.q(VHu + "mmregioncode_en.txt").ifE())
    {
      AppMethodBeat.o(43285);
      return "mmregioncode_en.txt";
    }
    AppMethodBeat.o(43285);
    return null;
  }
  
  public final RegionCodeDecoder.Region[] hAE()
  {
    AppMethodBeat.i(43293);
    if (Util.isNullOrNil(this.VHw))
    {
      AppMethodBeat.o(43293);
      return null;
    }
    RegionCodeDecoder.Region[] arrayOfRegion = DecoderJni.getCountries(this.VHw);
    AppMethodBeat.o(43293);
    return arrayOfRegion;
  }
  
  public final void hxD()
  {
    AppMethodBeat.i(43278);
    Object localObject1 = new com.tencent.mm.vfs.q(VHu);
    if (!((com.tencent.mm.vfs.q)localObject1).ifE())
    {
      ((com.tencent.mm.vfs.q)localObject1).ifK();
      ag((com.tencent.mm.vfs.q)localObject1);
    }
    Object localObject2 = ((com.tencent.mm.vfs.q)localObject1).ifI();
    if ((localObject2 == null) || (localObject2.length == 0)) {
      ag((com.tencent.mm.vfs.q)localObject1);
    }
    if (!u.agG(bxm("zh_HK")))
    {
      Log.w("MicroMsg.RegionCodeDecoder", "forward compatbility for not HK language support");
      ah((com.tencent.mm.vfs.q)localObject1);
    }
    this.VHv = LocaleUtil.getApplicationLanguage();
    localObject1 = hAD();
    if (Util.isNullOrNil((String)localObject1))
    {
      Log.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found, curLang: " + this.VHv);
      AppMethodBeat.o(43278);
      return;
    }
    localObject1 = VHu + (String)localObject1;
    localObject2 = bxl((String)localObject1);
    if (Util.isNullOrNil((String)localObject2))
    {
      Log.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found after verify, curLang: " + this.VHv);
      AppMethodBeat.o(43278);
      return;
    }
    if ((!Util.isNullOrNil(this.VHw)) && (this.VHw.equals(localObject1)) && (((String)localObject1).equals(localObject2)))
    {
      AppMethodBeat.o(43278);
      return;
    }
    Log.w("MicroMsg.RegionCodeDecoder", "buildMap, after verify, codeFile %s is used. curLang: %s", new Object[] { new com.tencent.mm.vfs.q((String)localObject2).getName(), this.VHv });
    this.VHw = ((String)localObject2);
    DecoderJni.buildFromFile(this.VHw);
    AppMethodBeat.o(43278);
  }
  
  public final RegionCodeDecoder.Region[] nP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(43295);
    if ((Util.isNullOrNil(this.VHw)) || (Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(43295);
      return null;
    }
    paramString1 = DecoderJni.getCities(this.VHw, paramString1, paramString2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.RegionCodeDecoder
 * JD-Core Version:    0.7.0.1
 */