package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;

public final class RegionCodeDecoder
{
  private static RegionCodeDecoder yOR;
  public static final String yOS;
  public String yOT = "";
  private String yOU = "";
  
  static
  {
    AppMethodBeat.i(60229);
    yOR = null;
    yOS = com.tencent.mm.compatible.util.e.eQu + "MicroMsg/regioncode/";
    AppMethodBeat.o(60229);
  }
  
  /* Error */
  public static void a(b paramb1, b paramb2)
  {
    // Byte code:
    //   0: ldc 65
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 67
    //   7: ldc 69
    //   9: iconst_1
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_0
    //   16: invokevirtual 74	com/tencent/mm/vfs/b:getName	()Ljava/lang/String;
    //   19: aastore
    //   20: invokestatic 79	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   23: new 71	com/tencent/mm/vfs/b
    //   26: dup
    //   27: aload_1
    //   28: new 29	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   35: aload_0
    //   36: invokevirtual 74	com/tencent/mm/vfs/b:getName	()Ljava/lang/String;
    //   39: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc 81
    //   44: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokespecial 84	com/tencent/mm/vfs/b:<init>	(Lcom/tencent/mm/vfs/b;Ljava/lang/String;)V
    //   53: astore_1
    //   54: aload_0
    //   55: invokestatic 88	com/tencent/mm/storage/RegionCodeDecoder:n	(Lcom/tencent/mm/vfs/b;)Ljava/lang/String;
    //   58: astore_3
    //   59: aload_3
    //   60: invokestatic 94	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   63: ifne +114 -> 177
    //   66: aload_1
    //   67: invokevirtual 98	com/tencent/mm/vfs/b:exists	()Z
    //   70: ifne +11 -> 81
    //   73: aload_1
    //   74: invokevirtual 102	com/tencent/mm/vfs/b:dQI	()Lcom/tencent/mm/vfs/b;
    //   77: invokevirtual 105	com/tencent/mm/vfs/b:mkdirs	()Z
    //   80: pop
    //   81: new 107	com/tencent/mm/vfs/h
    //   84: dup
    //   85: aload_1
    //   86: invokespecial 110	com/tencent/mm/vfs/h:<init>	(Lcom/tencent/mm/vfs/b;)V
    //   89: astore_2
    //   90: aload_2
    //   91: astore_1
    //   92: aload_2
    //   93: aload_3
    //   94: invokevirtual 116	java/io/Writer:write	(Ljava/lang/String;)V
    //   97: aload_2
    //   98: invokevirtual 119	java/io/Writer:close	()V
    //   101: ldc 65
    //   103: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: return
    //   107: astore_0
    //   108: ldc 65
    //   110: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: return
    //   114: astore_3
    //   115: aconst_null
    //   116: astore_2
    //   117: aload_2
    //   118: astore_1
    //   119: ldc 67
    //   121: aload_3
    //   122: ldc 121
    //   124: iconst_1
    //   125: anewarray 4	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: aload_0
    //   131: invokevirtual 74	com/tencent/mm/vfs/b:getName	()Ljava/lang/String;
    //   134: aastore
    //   135: invokestatic 125	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   138: aload_2
    //   139: ifnull +38 -> 177
    //   142: aload_2
    //   143: invokevirtual 119	java/io/Writer:close	()V
    //   146: ldc 65
    //   148: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: return
    //   152: astore_0
    //   153: ldc 65
    //   155: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: return
    //   159: astore_0
    //   160: aconst_null
    //   161: astore_1
    //   162: aload_1
    //   163: ifnull +7 -> 170
    //   166: aload_1
    //   167: invokevirtual 119	java/io/Writer:close	()V
    //   170: ldc 65
    //   172: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: aload_0
    //   176: athrow
    //   177: ldc 65
    //   179: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: return
    //   183: astore_1
    //   184: goto -14 -> 170
    //   187: astore_0
    //   188: goto -26 -> 162
    //   191: astore_3
    //   192: goto -75 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	paramb1	b
    //   0	195	1	paramb2	b
    //   89	54	2	localh	com.tencent.mm.vfs.h
    //   58	36	3	str	String
    //   114	8	3	localThrowable1	java.lang.Throwable
    //   191	1	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   97	101	107	java/lang/Throwable
    //   81	90	114	java/lang/Throwable
    //   142	146	152	java/lang/Throwable
    //   81	90	159	finally
    //   166	170	183	java/lang/Throwable
    //   92	97	187	finally
    //   119	138	187	finally
    //   92	97	191	java/lang/Throwable
  }
  
  public static final String aF(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(60219);
    StringBuffer localStringBuffer = new StringBuffer();
    if (!bo.isNullOrNil(paramString1))
    {
      localStringBuffer.append(paramString1);
      if (!bo.isNullOrNil(paramString2))
      {
        localStringBuffer.append('_');
        localStringBuffer.append(paramString2);
        if (!bo.isNullOrNil(paramString3))
        {
          localStringBuffer.append('_');
          localStringBuffer.append(paramString3);
        }
      }
    }
    paramString1 = localStringBuffer.toString();
    AppMethodBeat.o(60219);
    return paramString1;
  }
  
  public static String aG(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(60225);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)) || (bo.isNullOrNil(paramString3))) {}
    for (paramString1 = null; bo.isNullOrNil(paramString1); paramString1 = getLocName(aF(paramString1, paramString2, paramString3)))
    {
      paramString1 = bo.nullAsNil(paramString3);
      AppMethodBeat.o(60225);
      return paramString1;
    }
    AppMethodBeat.o(60225);
    return paramString1;
  }
  
  private static String asv(String paramString)
  {
    AppMethodBeat.i(60213);
    b localb = new b(paramString);
    Object localObject = m(localb);
    boolean bool;
    if (bo.isNullOrNil((String)localObject))
    {
      bool = false;
      if (bool) {
        break label199;
      }
      if (com.tencent.mm.vfs.e.C("assets:///regioncode/" + localb.getName(), paramString) <= 0L) {
        break label136;
      }
      i = 1;
      label64:
      if (i != 0) {
        break label146;
      }
      localObject = new b(localb.dQI(), "mmregioncode_en.txt");
      paramString = j.p(((b)localObject).dQJ());
      if (com.tencent.mm.vfs.e.C("assets:///regioncode/mmregioncode_en.txt", j.p(((b)localObject).dQJ())) <= 0L) {
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
      AppMethodBeat.o(60213);
      return null;
      bool = ((String)localObject).equals(n(localb));
      break;
      i = 0;
      break label64;
    }
    label146:
    localObject = new b(paramString);
    a((b)localObject, ((b)localObject).dQI());
    ab.w("MicroMsg.RegionCodeDecoder", "Verifying codeFile: %s failed, after fallback, %s will be used.", new Object[] { localb.getName(), ((b)localObject).getName() });
    AppMethodBeat.o(60213);
    return paramString;
    label199:
    AppMethodBeat.o(60213);
    return paramString;
  }
  
  public static String asw(String paramString)
  {
    AppMethodBeat.i(60220);
    if ((bo.isNullOrNil(paramString)) || (!aa.apf(paramString)))
    {
      AppMethodBeat.o(60220);
      return null;
    }
    String str = paramString;
    if (paramString.equalsIgnoreCase("zh_HK")) {
      str = "zh_TW";
    }
    paramString = yOS + "mmregioncode_" + str + ".txt";
    AppMethodBeat.o(60220);
    return paramString;
  }
  
  public static final boolean asx(String paramString)
  {
    AppMethodBeat.i(60221);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(60221);
      return false;
    }
    boolean bool = paramString.equalsIgnoreCase("cn");
    AppMethodBeat.o(60221);
    return bool;
  }
  
  public static String asy(String paramString)
  {
    AppMethodBeat.i(60223);
    String str = getLocName(paramString);
    if (bo.isNullOrNil(str))
    {
      paramString = bo.nullAsNil(paramString);
      AppMethodBeat.o(60223);
      return paramString;
    }
    AppMethodBeat.o(60223);
    return str;
  }
  
  public static RegionCodeDecoder dyE()
  {
    AppMethodBeat.i(60211);
    if (yOR == null) {
      yOR = new RegionCodeDecoder();
    }
    RegionCodeDecoder localRegionCodeDecoder = yOR;
    if (!aa.dsG().equals(localRegionCodeDecoder.yOT)) {
      localRegionCodeDecoder.dwn();
    }
    localRegionCodeDecoder = yOR;
    AppMethodBeat.o(60211);
    return localRegionCodeDecoder;
  }
  
  public static String getLocName(String paramString)
  {
    AppMethodBeat.i(60222);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(60222);
      return null;
    }
    paramString = DecoderJni.getLocName(paramString);
    AppMethodBeat.o(60222);
    return paramString;
  }
  
  public static String iq(String paramString1, String paramString2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(60224);
    Object localObject1 = localObject2;
    if (!bo.isNullOrNil(paramString1)) {
      if (!bo.isNullOrNil(paramString2)) {
        break label44;
      }
    }
    label44:
    for (localObject1 = localObject2; bo.isNullOrNil((String)localObject1); localObject1 = getLocName(aF(paramString1, paramString2, null)))
    {
      paramString1 = bo.nullAsNil(paramString2);
      AppMethodBeat.o(60224);
      return paramString1;
    }
    AppMethodBeat.o(60224);
    return localObject1;
  }
  
  /* Error */
  private static String m(b paramb)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 232
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 71	com/tencent/mm/vfs/b
    //   10: dup
    //   11: new 29	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   18: aload_0
    //   19: invokevirtual 171	com/tencent/mm/vfs/b:dQJ	()Landroid/net/Uri;
    //   22: invokestatic 177	com/tencent/mm/vfs/j:p	(Landroid/net/Uri;)Ljava/lang/String;
    //   25: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 81
    //   30: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokespecial 153	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   39: astore 4
    //   41: aload 4
    //   43: invokevirtual 98	com/tencent/mm/vfs/b:exists	()Z
    //   46: ifeq +104 -> 150
    //   49: new 234	java/io/BufferedReader
    //   52: dup
    //   53: new 236	com/tencent/mm/vfs/g
    //   56: dup
    //   57: aload 4
    //   59: invokespecial 237	com/tencent/mm/vfs/g:<init>	(Lcom/tencent/mm/vfs/b;)V
    //   62: invokespecial 240	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   65: astore_1
    //   66: aload_1
    //   67: astore_0
    //   68: aload_1
    //   69: invokevirtual 243	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   72: astore_2
    //   73: aload_2
    //   74: astore_0
    //   75: aload_1
    //   76: invokevirtual 244	java/io/BufferedReader:close	()V
    //   79: ldc 232
    //   81: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload_0
    //   85: areturn
    //   86: astore_2
    //   87: aconst_null
    //   88: astore_1
    //   89: aload_1
    //   90: astore_0
    //   91: ldc 67
    //   93: aload_2
    //   94: ldc 246
    //   96: iconst_1
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload 4
    //   104: invokevirtual 74	com/tencent/mm/vfs/b:getName	()Ljava/lang/String;
    //   107: aastore
    //   108: invokestatic 125	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: aload_3
    //   112: astore_0
    //   113: aload_1
    //   114: ifnull -35 -> 79
    //   117: aload_1
    //   118: invokevirtual 244	java/io/BufferedReader:close	()V
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
    //   140: invokevirtual 244	java/io/BufferedReader:close	()V
    //   143: ldc 232
    //   145: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: aload_1
    //   149: athrow
    //   150: ldc 232
    //   152: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	173	0	paramb	b
    //   65	53	1	localBufferedReader	java.io.BufferedReader
    //   132	17	1	localObject1	Object
    //   157	1	1	localThrowable1	java.lang.Throwable
    //   165	1	1	localObject2	Object
    //   72	2	2	str	String
    //   86	8	2	localThrowable2	java.lang.Throwable
    //   169	1	2	localThrowable3	java.lang.Throwable
    //   1	127	3	localObject3	Object
    //   39	64	4	localb	b
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
  
  private static String n(b paramb)
  {
    AppMethodBeat.i(60216);
    String str = com.tencent.mm.vfs.e.avP(j.p(paramb.mUri));
    if (bo.isNullOrNil(str))
    {
      ab.e("MicroMsg.RegionCodeDecoder", "Failed to calculate hash for file %s", new Object[] { paramb.getName() });
      AppMethodBeat.o(60216);
      return null;
    }
    paramb = ag.cE(str + "#" + paramb.lastModified() + "#" + q.bP(true));
    AppMethodBeat.o(60216);
    return paramb;
  }
  
  /* Error */
  private void o(b paramb)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 282
    //   7: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aconst_null
    //   11: astore 4
    //   13: aload_1
    //   14: invokevirtual 98	com/tencent/mm/vfs/b:exists	()Z
    //   17: ifeq +9 -> 26
    //   20: aload_1
    //   21: invokevirtual 286	com/tencent/mm/vfs/b:list	()[Ljava/lang/String;
    //   24: astore 4
    //   26: aload_1
    //   27: invokevirtual 98	com/tencent/mm/vfs/b:exists	()Z
    //   30: ifeq +23 -> 53
    //   33: aload 4
    //   35: ifnull +18 -> 53
    //   38: aload 4
    //   40: arraylength
    //   41: ifeq +12 -> 53
    //   44: ldc_w 282
    //   47: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: invokestatic 292	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   56: invokevirtual 298	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   59: ldc_w 300
    //   62: invokevirtual 305	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   65: astore 4
    //   67: aload 4
    //   69: arraylength
    //   70: istore_3
    //   71: iload_2
    //   72: iload_3
    //   73: if_icmpge +138 -> 211
    //   76: aload 4
    //   78: iload_2
    //   79: aaload
    //   80: astore 5
    //   82: ldc 67
    //   84: ldc_w 307
    //   87: iconst_2
    //   88: anewarray 4	java/lang/Object
    //   91: dup
    //   92: iconst_0
    //   93: ldc_w 309
    //   96: aload 5
    //   98: invokestatic 313	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   101: invokevirtual 316	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   104: aastore
    //   105: dup
    //   106: iconst_1
    //   107: new 29	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   114: aload_1
    //   115: getfield 251	com/tencent/mm/vfs/b:mUri	Landroid/net/Uri;
    //   118: invokestatic 177	com/tencent/mm/vfs/j:p	(Landroid/net/Uri;)Ljava/lang/String;
    //   121: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: ldc_w 318
    //   127: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload 5
    //   132: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: aastore
    //   139: invokestatic 79	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: new 29	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   149: aload_1
    //   150: getfield 251	com/tencent/mm/vfs/b:mUri	Landroid/net/Uri;
    //   153: invokestatic 177	com/tencent/mm/vfs/j:p	(Landroid/net/Uri;)Ljava/lang/String;
    //   156: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: ldc_w 318
    //   162: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload 5
    //   167: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: astore 6
    //   175: ldc 158
    //   177: aload 5
    //   179: invokestatic 313	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   182: invokevirtual 316	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   185: aload 6
    //   187: invokestatic 165	com/tencent/mm/vfs/e:C	(Ljava/lang/String;Ljava/lang/String;)J
    //   190: pop2
    //   191: new 71	com/tencent/mm/vfs/b
    //   194: dup
    //   195: aload 6
    //   197: invokespecial 153	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   200: aload_1
    //   201: invokestatic 187	com/tencent/mm/storage/RegionCodeDecoder:a	(Lcom/tencent/mm/vfs/b;Lcom/tencent/mm/vfs/b;)V
    //   204: iload_2
    //   205: iconst_1
    //   206: iadd
    //   207: istore_2
    //   208: goto -137 -> 71
    //   211: ldc_w 282
    //   214: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: goto -167 -> 50
    //   220: astore_1
    //   221: aload_0
    //   222: monitorexit
    //   223: aload_1
    //   224: athrow
    //   225: astore_1
    //   226: ldc 67
    //   228: aload_1
    //   229: ldc 56
    //   231: iconst_0
    //   232: anewarray 4	java/lang/Object
    //   235: invokestatic 125	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   238: ldc_w 282
    //   241: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   244: goto -194 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	this	RegionCodeDecoder
    //   0	247	1	paramb	b
    //   1	207	2	i	int
    //   70	4	3	j	int
    //   11	66	4	arrayOfString	String[]
    //   80	98	5	str1	String
    //   173	23	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   4	10	220	finally
    //   13	26	220	finally
    //   26	33	220	finally
    //   38	50	220	finally
    //   53	71	220	finally
    //   82	204	220	finally
    //   211	217	220	finally
    //   226	244	220	finally
    //   53	71	225	java/lang/Exception
    //   82	204	225	java/lang/Exception
  }
  
  public final Region[] asz(String paramString)
  {
    AppMethodBeat.i(60227);
    if ((bo.isNullOrNil(this.yOU)) || (bo.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(60227);
      return null;
    }
    paramString = DecoderJni.getProvinces(this.yOU, paramString);
    AppMethodBeat.o(60227);
    return paramString;
  }
  
  public final void dwn()
  {
    AppMethodBeat.i(60212);
    Object localObject1 = new b(yOS);
    if (!((b)localObject1).exists())
    {
      ((b)localObject1).mkdirs();
      o((b)localObject1);
    }
    Object localObject2 = ((b)localObject1).list();
    if ((localObject2 == null) || (localObject2.length == 0)) {
      o((b)localObject1);
    }
    this.yOT = aa.dsG();
    localObject1 = dyF();
    if (bo.isNullOrNil((String)localObject1))
    {
      ab.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found, curLang: " + this.yOT);
      AppMethodBeat.o(60212);
      return;
    }
    localObject1 = yOS + (String)localObject1;
    localObject2 = asv((String)localObject1);
    if (bo.isNullOrNil((String)localObject2))
    {
      ab.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found after verify, curLang: " + this.yOT);
      AppMethodBeat.o(60212);
      return;
    }
    if ((!bo.isNullOrNil(this.yOU)) && (this.yOU.equals(localObject1)) && (((String)localObject1).equals(localObject2)))
    {
      AppMethodBeat.o(60212);
      return;
    }
    ab.w("MicroMsg.RegionCodeDecoder", "buildMap, after verify, codeFile %s is used. curLang: %s", new Object[] { new b((String)localObject2).getName(), this.yOT });
    this.yOU = ((String)localObject2);
    DecoderJni.buildFromFile(this.yOU);
    AppMethodBeat.o(60212);
  }
  
  public final String dyF()
  {
    AppMethodBeat.i(60218);
    Object localObject = new StringBuilder("mmregioncode_");
    if (this.yOT.equalsIgnoreCase("zh_HK")) {}
    for (String str1 = "zh_TW";; str1 = this.yOT)
    {
      str1 = str1 + ".txt";
      localObject = new b(yOS);
      if (((b)localObject).exists()) {
        break;
      }
      ((b)localObject).mkdirs();
      AppMethodBeat.o(60218);
      return null;
    }
    localObject = ((b)localObject).list();
    if ((localObject == null) || (localObject.length == 0))
    {
      AppMethodBeat.o(60218);
      return null;
    }
    int m = localObject.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      String str2 = localObject[i];
      if (str2.equals(str1))
      {
        AppMethodBeat.o(60218);
        return str2;
      }
      k = j;
      if (j == 0)
      {
        k = j;
        if (str2.equals("mmregioncode_en.txt")) {
          k = 1;
        }
      }
      i += 1;
    }
    if (j != 0)
    {
      AppMethodBeat.o(60218);
      return "mmregioncode_en.txt";
    }
    AppMethodBeat.o(60218);
    return null;
  }
  
  public final Region[] dyG()
  {
    AppMethodBeat.i(60226);
    if (bo.isNullOrNil(this.yOU))
    {
      AppMethodBeat.o(60226);
      return null;
    }
    Region[] arrayOfRegion = DecoderJni.getCountries(this.yOU);
    AppMethodBeat.o(60226);
    return arrayOfRegion;
  }
  
  public final Region[] ir(String paramString1, String paramString2)
  {
    AppMethodBeat.i(60228);
    if ((bo.isNullOrNil(this.yOU)) || (bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(60228);
      return null;
    }
    paramString1 = DecoderJni.getCities(this.yOU, paramString1, paramString2);
    AppMethodBeat.o(60228);
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
  
  public static class Region
  {
    private String code;
    private String countryCode;
    private boolean hasChildren = false;
    private boolean isCity = false;
    private boolean isCountry = false;
    private boolean isProvince = false;
    private String name;
    private Region parent = null;
    
    public String getCode()
    {
      return this.code;
    }
    
    public String getCountryCode()
    {
      return this.countryCode;
    }
    
    public String getName()
    {
      return this.name;
    }
    
    public Region getParent()
    {
      return this.parent;
    }
    
    public boolean hasChildren()
    {
      return this.hasChildren;
    }
    
    public boolean isCity()
    {
      return this.isCity;
    }
    
    public boolean isCountry()
    {
      return this.isCountry;
    }
    
    public boolean isProvince()
    {
      return this.isProvince;
    }
    
    public void setCity(boolean paramBoolean)
    {
      this.isCity = paramBoolean;
    }
    
    public void setCode(String paramString)
    {
      this.code = paramString;
    }
    
    public void setCountry(boolean paramBoolean)
    {
      this.isCountry = paramBoolean;
    }
    
    public void setCountryCode(String paramString)
    {
      this.countryCode = paramString;
    }
    
    public void setHasChildren(boolean paramBoolean)
    {
      this.hasChildren = paramBoolean;
    }
    
    public void setName(String paramString)
    {
      this.name = paramString;
    }
    
    public void setParent(Region paramRegion)
    {
      this.parent = paramRegion;
    }
    
    public void setProvince(boolean paramBoolean)
    {
      this.isProvince = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.RegionCodeDecoder
 * JD-Core Version:    0.7.0.1
 */