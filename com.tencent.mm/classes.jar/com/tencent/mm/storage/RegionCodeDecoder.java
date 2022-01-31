package com.tencent.mm.storage;

import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;

public final class RegionCodeDecoder
{
  private static RegionCodeDecoder uCF = null;
  public static final String uCG = com.tencent.mm.compatible.util.e.dOO + "MicroMsg/regioncode/";
  public String uCH = "";
  private String uCI = "";
  
  /* Error */
  public static void a(b paramb1, b paramb2)
  {
    // Byte code:
    //   0: ldc 56
    //   2: ldc 58
    //   4: iconst_1
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: aload_0
    //   11: invokevirtual 63	com/tencent/mm/vfs/b:getName	()Ljava/lang/String;
    //   14: aastore
    //   15: invokestatic 69	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: new 60	com/tencent/mm/vfs/b
    //   21: dup
    //   22: aload_1
    //   23: new 22	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   30: aload_0
    //   31: invokevirtual 63	com/tencent/mm/vfs/b:getName	()Ljava/lang/String;
    //   34: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 71
    //   39: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 74	com/tencent/mm/vfs/b:<init>	(Lcom/tencent/mm/vfs/b;Ljava/lang/String;)V
    //   48: astore_1
    //   49: aload_0
    //   50: invokestatic 78	com/tencent/mm/storage/RegionCodeDecoder:l	(Lcom/tencent/mm/vfs/b;)Ljava/lang/String;
    //   53: astore_3
    //   54: aload_3
    //   55: invokestatic 84	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   58: ifne +38 -> 96
    //   61: aload_1
    //   62: invokevirtual 88	com/tencent/mm/vfs/b:exists	()Z
    //   65: ifne +11 -> 76
    //   68: aload_1
    //   69: invokevirtual 92	com/tencent/mm/vfs/b:cLq	()Lcom/tencent/mm/vfs/b;
    //   72: invokevirtual 95	com/tencent/mm/vfs/b:mkdirs	()Z
    //   75: pop
    //   76: new 97	com/tencent/mm/vfs/h
    //   79: dup
    //   80: aload_1
    //   81: invokespecial 100	com/tencent/mm/vfs/h:<init>	(Lcom/tencent/mm/vfs/b;)V
    //   84: astore_2
    //   85: aload_2
    //   86: astore_1
    //   87: aload_2
    //   88: aload_3
    //   89: invokevirtual 106	java/io/Writer:write	(Ljava/lang/String;)V
    //   92: aload_2
    //   93: invokevirtual 109	java/io/Writer:close	()V
    //   96: return
    //   97: astore_3
    //   98: aconst_null
    //   99: astore_2
    //   100: aload_2
    //   101: astore_1
    //   102: ldc 56
    //   104: aload_3
    //   105: ldc 111
    //   107: iconst_1
    //   108: anewarray 4	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload_0
    //   114: invokevirtual 63	com/tencent/mm/vfs/b:getName	()Ljava/lang/String;
    //   117: aastore
    //   118: invokestatic 115	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   121: aload_2
    //   122: ifnull -26 -> 96
    //   125: aload_2
    //   126: invokevirtual 109	java/io/Writer:close	()V
    //   129: return
    //   130: astore_0
    //   131: return
    //   132: astore_0
    //   133: aconst_null
    //   134: astore_1
    //   135: aload_1
    //   136: ifnull +7 -> 143
    //   139: aload_1
    //   140: invokevirtual 109	java/io/Writer:close	()V
    //   143: aload_0
    //   144: athrow
    //   145: astore_0
    //   146: return
    //   147: astore_1
    //   148: goto -5 -> 143
    //   151: astore_0
    //   152: goto -17 -> 135
    //   155: astore_3
    //   156: goto -56 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramb1	b
    //   0	159	1	paramb2	b
    //   84	42	2	localh	com.tencent.mm.vfs.h
    //   53	36	3	str	String
    //   97	8	3	localThrowable1	java.lang.Throwable
    //   155	1	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   76	85	97	java/lang/Throwable
    //   125	129	130	java/lang/Throwable
    //   76	85	132	finally
    //   92	96	145	java/lang/Throwable
    //   139	143	147	java/lang/Throwable
    //   87	92	151	finally
    //   102	121	151	finally
    //   87	92	155	java/lang/Throwable
  }
  
  public static String ack(String paramString)
  {
    if ((bk.bl(paramString)) || (!x.Zh(paramString))) {
      return null;
    }
    String str = paramString;
    if (paramString.equalsIgnoreCase("zh_HK")) {
      str = "zh_TW";
    }
    return uCG + "mmregioncode_" + str + ".txt";
  }
  
  public static final boolean acl(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    return paramString.equalsIgnoreCase("cn");
  }
  
  public static String acm(String paramString)
  {
    String str2 = getLocName(paramString);
    String str1 = str2;
    if (bk.bl(str2)) {
      str1 = bk.pm(paramString);
    }
    return str1;
  }
  
  public static final String ao(String paramString1, String paramString2, String paramString3)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (!bk.bl(paramString1))
    {
      localStringBuffer.append(paramString1);
      if (!bk.bl(paramString2))
      {
        localStringBuffer.append('_');
        localStringBuffer.append(paramString2);
        if (!bk.bl(paramString3))
        {
          localStringBuffer.append('_');
          localStringBuffer.append(paramString3);
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  public static String ap(String paramString1, String paramString2, String paramString3)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2)) || (bk.bl(paramString3))) {}
    for (paramString1 = null;; paramString1 = getLocName(ao(paramString1, paramString2, paramString3)))
    {
      paramString2 = paramString1;
      if (bk.bl(paramString1)) {
        paramString2 = bk.pm(paramString3);
      }
      return paramString2;
    }
  }
  
  public static RegionCodeDecoder cvV()
  {
    if (uCF == null) {
      uCF = new RegionCodeDecoder();
    }
    RegionCodeDecoder localRegionCodeDecoder = uCF;
    if (!x.cqJ().equals(localRegionCodeDecoder.uCH)) {
      localRegionCodeDecoder.ctM();
    }
    return uCF;
  }
  
  public static String getLocName(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    return DecoderJni.getLocName(paramString);
  }
  
  public static String gp(String paramString1, String paramString2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!bk.bl(paramString1)) {
      if (!bk.bl(paramString2)) {
        break label36;
      }
    }
    label36:
    for (localObject1 = localObject2;; localObject1 = getLocName(ao(paramString1, paramString2, null)))
    {
      paramString1 = (String)localObject1;
      if (bk.bl((String)localObject1)) {
        paramString1 = bk.pm(paramString2);
      }
      return paramString1;
    }
  }
  
  /* Error */
  private static String k(b paramb)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 60	com/tencent/mm/vfs/b
    //   5: dup
    //   6: new 22	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   13: aload_0
    //   14: invokevirtual 181	com/tencent/mm/vfs/b:cLr	()Landroid/net/Uri;
    //   17: invokestatic 187	com/tencent/mm/vfs/j:n	(Landroid/net/Uri;)Ljava/lang/String;
    //   20: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc 71
    //   25: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokespecial 189	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   34: astore 4
    //   36: aload_3
    //   37: astore_0
    //   38: aload 4
    //   40: invokevirtual 88	com/tencent/mm/vfs/b:exists	()Z
    //   43: ifeq +33 -> 76
    //   46: new 191	java/io/BufferedReader
    //   49: dup
    //   50: new 193	com/tencent/mm/vfs/g
    //   53: dup
    //   54: aload 4
    //   56: invokespecial 194	com/tencent/mm/vfs/g:<init>	(Lcom/tencent/mm/vfs/b;)V
    //   59: invokespecial 197	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   62: astore_1
    //   63: aload_1
    //   64: astore_0
    //   65: aload_1
    //   66: invokevirtual 200	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   69: astore_2
    //   70: aload_2
    //   71: astore_0
    //   72: aload_1
    //   73: invokevirtual 201	java/io/BufferedReader:close	()V
    //   76: aload_0
    //   77: areturn
    //   78: astore_2
    //   79: aconst_null
    //   80: astore_1
    //   81: aload_1
    //   82: astore_0
    //   83: ldc 56
    //   85: aload_2
    //   86: ldc 203
    //   88: iconst_1
    //   89: anewarray 4	java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: aload 4
    //   96: invokevirtual 63	com/tencent/mm/vfs/b:getName	()Ljava/lang/String;
    //   99: aastore
    //   100: invokestatic 115	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: aload_3
    //   104: astore_0
    //   105: aload_1
    //   106: ifnull -30 -> 76
    //   109: aload_1
    //   110: invokevirtual 201	java/io/BufferedReader:close	()V
    //   113: aconst_null
    //   114: areturn
    //   115: astore_0
    //   116: aconst_null
    //   117: areturn
    //   118: astore_1
    //   119: aconst_null
    //   120: astore_0
    //   121: aload_0
    //   122: ifnull +7 -> 129
    //   125: aload_0
    //   126: invokevirtual 201	java/io/BufferedReader:close	()V
    //   129: aload_1
    //   130: athrow
    //   131: astore_1
    //   132: aload_0
    //   133: areturn
    //   134: astore_0
    //   135: goto -6 -> 129
    //   138: astore_1
    //   139: goto -18 -> 121
    //   142: astore_2
    //   143: goto -62 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramb	b
    //   62	48	1	localBufferedReader	java.io.BufferedReader
    //   118	12	1	localObject1	Object
    //   131	1	1	localThrowable1	java.lang.Throwable
    //   138	1	1	localObject2	Object
    //   69	2	2	str	String
    //   78	8	2	localThrowable2	java.lang.Throwable
    //   142	1	2	localThrowable3	java.lang.Throwable
    //   1	103	3	localObject3	Object
    //   34	61	4	localb	b
    // Exception table:
    //   from	to	target	type
    //   46	63	78	java/lang/Throwable
    //   109	113	115	java/lang/Throwable
    //   46	63	118	finally
    //   72	76	131	java/lang/Throwable
    //   125	129	134	java/lang/Throwable
    //   65	70	138	finally
    //   83	103	138	finally
    //   65	70	142	java/lang/Throwable
  }
  
  private static String l(b paramb)
  {
    String str = com.tencent.mm.vfs.e.aeY(j.n(paramb.mUri));
    if (bk.bl(str))
    {
      y.e("MicroMsg.RegionCodeDecoder", "Failed to calculate hash for file %s", new Object[] { paramb.getName() });
      return null;
    }
    return ad.bB(str + "#" + paramb.lastModified() + "#" + q.zf());
  }
  
  /* Error */
  private void m(b paramb)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aconst_null
    //   5: astore 4
    //   7: aload_1
    //   8: invokevirtual 88	com/tencent/mm/vfs/b:exists	()Z
    //   11: ifeq +9 -> 20
    //   14: aload_1
    //   15: invokevirtual 243	com/tencent/mm/vfs/b:list	()[Ljava/lang/String;
    //   18: astore 4
    //   20: aload_1
    //   21: invokevirtual 88	com/tencent/mm/vfs/b:exists	()Z
    //   24: ifeq +19 -> 43
    //   27: aload 4
    //   29: ifnull +14 -> 43
    //   32: aload 4
    //   34: arraylength
    //   35: istore_3
    //   36: iload_3
    //   37: ifeq +6 -> 43
    //   40: aload_0
    //   41: monitorexit
    //   42: return
    //   43: invokestatic 249	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   46: invokevirtual 255	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   49: ldc_w 257
    //   52: invokevirtual 262	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   55: astore 4
    //   57: aload 4
    //   59: arraylength
    //   60: istore_3
    //   61: iload_2
    //   62: iload_3
    //   63: if_icmpge -23 -> 40
    //   66: aload 4
    //   68: iload_2
    //   69: aaload
    //   70: astore 5
    //   72: ldc 56
    //   74: ldc_w 264
    //   77: iconst_2
    //   78: anewarray 4	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: new 22	java/lang/StringBuilder
    //   86: dup
    //   87: ldc_w 266
    //   90: invokespecial 267	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   93: aload 5
    //   95: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: aastore
    //   102: dup
    //   103: iconst_1
    //   104: new 22	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   111: aload_1
    //   112: getfield 207	com/tencent/mm/vfs/b:mUri	Landroid/net/Uri;
    //   115: invokestatic 187	com/tencent/mm/vfs/j:n	(Landroid/net/Uri;)Ljava/lang/String;
    //   118: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc_w 269
    //   124: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload 5
    //   129: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: aastore
    //   136: invokestatic 69	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   139: new 22	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   146: aload_1
    //   147: getfield 207	com/tencent/mm/vfs/b:mUri	Landroid/net/Uri;
    //   150: invokestatic 187	com/tencent/mm/vfs/j:n	(Landroid/net/Uri;)Ljava/lang/String;
    //   153: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc_w 269
    //   159: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload 5
    //   164: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: astore 6
    //   172: new 22	java/lang/StringBuilder
    //   175: dup
    //   176: ldc_w 271
    //   179: invokespecial 267	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   182: aload 5
    //   184: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: aload 6
    //   192: invokestatic 275	com/tencent/mm/vfs/e:r	(Ljava/lang/String;Ljava/lang/String;)J
    //   195: pop2
    //   196: new 60	com/tencent/mm/vfs/b
    //   199: dup
    //   200: aload 6
    //   202: invokespecial 189	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   205: aload_1
    //   206: invokestatic 277	com/tencent/mm/storage/RegionCodeDecoder:a	(Lcom/tencent/mm/vfs/b;Lcom/tencent/mm/vfs/b;)V
    //   209: iload_2
    //   210: iconst_1
    //   211: iadd
    //   212: istore_2
    //   213: goto -152 -> 61
    //   216: astore_1
    //   217: ldc 56
    //   219: aload_1
    //   220: ldc 46
    //   222: iconst_0
    //   223: anewarray 4	java/lang/Object
    //   226: invokestatic 115	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   229: goto -189 -> 40
    //   232: astore_1
    //   233: aload_0
    //   234: monitorexit
    //   235: aload_1
    //   236: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	RegionCodeDecoder
    //   0	237	1	paramb	b
    //   1	212	2	i	int
    //   35	29	3	j	int
    //   5	62	4	arrayOfString	String[]
    //   70	113	5	str1	String
    //   170	31	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   43	61	216	java/lang/Exception
    //   72	209	216	java/lang/Exception
    //   7	20	232	finally
    //   20	27	232	finally
    //   32	36	232	finally
    //   43	61	232	finally
    //   72	209	232	finally
    //   217	229	232	finally
  }
  
  public final Region[] acn(String paramString)
  {
    if ((bk.bl(this.uCI)) || (bk.bl(paramString))) {
      return null;
    }
    return DecoderJni.getProvinces(this.uCI, paramString);
  }
  
  public final void ctM()
  {
    Object localObject1 = new b(uCG);
    if (!((b)localObject1).exists())
    {
      ((b)localObject1).mkdirs();
      m((b)localObject1);
    }
    Object localObject2 = ((b)localObject1).list();
    if ((localObject2 == null) || (localObject2.length == 0)) {
      m((b)localObject1);
    }
    this.uCH = x.cqJ();
    localObject1 = cvW();
    if (bk.bl((String)localObject1)) {
      y.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found, curLang: " + this.uCH);
    }
    label180:
    label231:
    do
    {
      return;
      localObject2 = uCG + (String)localObject1;
      b localb1 = new b((String)localObject2);
      localObject1 = k(localb1);
      boolean bool;
      int i;
      b localb2;
      if (bk.bl((String)localObject1))
      {
        bool = false;
        if (bool) {
          break label347;
        }
        if (com.tencent.mm.vfs.e.r("assets:///regioncode/" + localb1.getName(), (String)localObject2) <= 0L) {
          break label283;
        }
        i = 1;
        if (i != 0) {
          break label293;
        }
        localb2 = new b(localb1.cLq(), "mmregioncode_en.txt");
        localObject1 = j.n(localb2.cLr());
        if (com.tencent.mm.vfs.e.r("assets:///regioncode/mmregioncode_en.txt", j.n(localb2.cLr())) <= 0L) {
          break label288;
        }
        i = 1;
        if (i != 0) {
          break label296;
        }
        localObject1 = null;
      }
      for (;;)
      {
        if (!bk.bl((String)localObject1)) {
          break label353;
        }
        y.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found after verify, curLang: " + this.uCH);
        return;
        bool = ((String)localObject1).equals(l(localb1));
        break;
        i = 0;
        break label180;
        i = 0;
        break label231;
        localObject1 = localObject2;
        localb2 = new b((String)localObject1);
        a(localb2, localb2.cLq());
        y.w("MicroMsg.RegionCodeDecoder", "Verifying codeFile: %s failed, after fallback, %s will be used.", new Object[] { localb1.getName(), localb2.getName() });
        continue;
        localObject1 = localObject2;
      }
    } while ((!bk.bl(this.uCI)) && (this.uCI.equals(localObject2)) && (((String)localObject2).equals(localObject1)));
    label283:
    label288:
    label293:
    label296:
    label347:
    label353:
    y.w("MicroMsg.RegionCodeDecoder", "buildMap, after verify, codeFile %s is used. curLang: %s", new Object[] { new b((String)localObject1).getName(), this.uCH });
    this.uCI = ((String)localObject1);
    DecoderJni.buildFromFile(this.uCI);
  }
  
  public final String cvW()
  {
    Object localObject = new StringBuilder("mmregioncode_");
    if (this.uCH.equalsIgnoreCase("zh_HK")) {}
    for (String str1 = "zh_TW";; str1 = this.uCH)
    {
      str1 = str1 + ".txt";
      localObject = new b(uCG);
      if (((b)localObject).exists()) {
        break;
      }
      ((b)localObject).mkdirs();
      return null;
    }
    localObject = ((b)localObject).list();
    if ((localObject == null) || (localObject.length == 0)) {
      return null;
    }
    int m = localObject.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      String str2 = localObject[i];
      if (str2.equals(str1)) {
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
    if (j != 0) {
      return "mmregioncode_en.txt";
    }
    return null;
  }
  
  public final Region[] cvX()
  {
    if (bk.bl(this.uCI)) {
      return null;
    }
    return DecoderJni.getCountries(this.uCI);
  }
  
  public final Region[] gq(String paramString1, String paramString2)
  {
    if ((bk.bl(this.uCI)) || (bk.bl(paramString1)) || (bk.bl(paramString2))) {
      return null;
    }
    return DecoderJni.getCities(this.uCI, paramString1, paramString2);
  }
  
  private static class DecoderJni
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