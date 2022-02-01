package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.o;
import java.io.IOException;

public final class FilesCopy
{
  private static final String TAG = "MicroMsg.SDK.FilesCopy";
  
  public static boolean copy(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(157540);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(157540);
      return false;
    }
    Object localObject = new o(paramString1);
    if (!((o)localObject).exists())
    {
      AppMethodBeat.o(157540);
      return false;
    }
    o localo = new o(paramString2);
    if (((o)localObject).isFile())
    {
      if ((!localo.isFile()) && (localo.exists()))
      {
        AppMethodBeat.o(157540);
        return false;
      }
      copyFile(paramString1, paramString2);
      if (paramBoolean) {
        ((o)localObject).delete();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(157540);
      return true;
      if (((o)localObject).isDirectory())
      {
        if (!localo.exists()) {
          localo.mkdirs();
        }
        if (!localo.isDirectory())
        {
          AppMethodBeat.o(157540);
          return false;
        }
        localObject = ((o)localObject).list();
        while (i < localObject.length)
        {
          copy(paramString1 + "/" + localObject[i], paramString2 + "/" + localObject[i], paramBoolean);
          i += 1;
        }
      }
    }
  }
  
  public static boolean copyAssets(Context paramContext, String paramString1, String paramString2)
  {
    int i = 0;
    AppMethodBeat.i(157541);
    boolean bool;
    try
    {
      bool = copyAssetsStream(paramContext.getAssets().open(paramString1), paramString2, false);
      AppMethodBeat.o(157541);
      return bool;
    }
    catch (IOException localIOException)
    {
      Log.e("MicroMsg.SDK.FilesCopy", "copy assets file srcpath=%s to=%s failed, try pattern now", new Object[] { paramString1, paramString2 });
    }
    for (;;)
    {
      String str = paramString1 + "." + i;
      try
      {
        bool = copyAssetsStream(paramContext.getAssets().open(str), paramString2, true);
        if (bool) {
          break label104;
        }
      }
      catch (IOException paramContext)
      {
        label97:
        break label97;
      }
      AppMethodBeat.o(157541);
      return true;
      label104:
      Log.d("MicroMsg.SDK.FilesCopy", "copy pattern %s", new Object[] { str });
      i += 1;
    }
  }
  
  /* Error */
  private static boolean copyAssetsStream(java.io.InputStream paramInputStream, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: ldc 117
    //   8: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aconst_null
    //   12: astore 14
    //   14: aconst_null
    //   15: astore 13
    //   17: aload 13
    //   19: astore 12
    //   21: aload 14
    //   23: astore 11
    //   25: aload_0
    //   26: invokevirtual 123	java/io/InputStream:available	()I
    //   29: istore_3
    //   30: aload 13
    //   32: astore 12
    //   34: aload 14
    //   36: astore 11
    //   38: aload_1
    //   39: iload_2
    //   40: invokestatic 129	com/tencent/mm/vfs/s:dw	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   43: astore 13
    //   45: aload 13
    //   47: astore 12
    //   49: aload 13
    //   51: astore 11
    //   53: sipush 16384
    //   56: newarray byte
    //   58: astore 14
    //   60: aload 13
    //   62: astore 12
    //   64: aload 13
    //   66: astore 11
    //   68: aload_0
    //   69: aload 14
    //   71: invokevirtual 133	java/io/InputStream:read	([B)I
    //   74: istore 4
    //   76: iload 4
    //   78: iconst_m1
    //   79: if_icmpeq +72 -> 151
    //   82: aload 13
    //   84: astore 12
    //   86: aload 13
    //   88: astore 11
    //   90: aload 13
    //   92: aload 14
    //   94: iconst_0
    //   95: iload 4
    //   97: invokevirtual 139	java/io/OutputStream:write	([BII)V
    //   100: goto -40 -> 60
    //   103: astore_1
    //   104: aload 12
    //   106: astore 11
    //   108: ldc 8
    //   110: aload_1
    //   111: ldc 141
    //   113: iconst_0
    //   114: anewarray 4	java/lang/Object
    //   117: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: aload_0
    //   121: ifnull +7 -> 128
    //   124: aload_0
    //   125: invokevirtual 148	java/io/InputStream:close	()V
    //   128: iload 6
    //   130: istore_2
    //   131: aload 12
    //   133: ifnull +11 -> 144
    //   136: aload 12
    //   138: invokevirtual 149	java/io/OutputStream:close	()V
    //   141: iload 6
    //   143: istore_2
    //   144: ldc 117
    //   146: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: iload_2
    //   150: ireturn
    //   151: iload_2
    //   152: ifeq +30 -> 182
    //   155: iload 5
    //   157: istore_2
    //   158: aload_0
    //   159: ifnull +10 -> 169
    //   162: aload_0
    //   163: invokevirtual 148	java/io/InputStream:close	()V
    //   166: iload 5
    //   168: istore_2
    //   169: aload 13
    //   171: ifnull +205 -> 376
    //   174: aload 13
    //   176: invokevirtual 149	java/io/OutputStream:close	()V
    //   179: goto -35 -> 144
    //   182: aload 13
    //   184: astore 12
    //   186: aload 13
    //   188: astore 11
    //   190: new 33	com/tencent/mm/vfs/o
    //   193: dup
    //   194: aload_1
    //   195: invokespecial 36	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   198: astore_1
    //   199: aload 13
    //   201: astore 12
    //   203: aload 13
    //   205: astore 11
    //   207: aload_1
    //   208: invokevirtual 40	com/tencent/mm/vfs/o:exists	()Z
    //   211: ifeq +29 -> 240
    //   214: iload_3
    //   215: i2l
    //   216: lstore 7
    //   218: aload 13
    //   220: astore 12
    //   222: aload 13
    //   224: astore 11
    //   226: aload_1
    //   227: invokevirtual 153	com/tencent/mm/vfs/o:length	()J
    //   230: lstore 9
    //   232: lload 7
    //   234: lload 9
    //   236: lcmp
    //   237: ifeq -82 -> 155
    //   240: iconst_0
    //   241: istore 5
    //   243: goto -88 -> 155
    //   246: astore_0
    //   247: ldc 8
    //   249: aload_0
    //   250: ldc 141
    //   252: iconst_0
    //   253: anewarray 4	java/lang/Object
    //   256: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   259: iconst_0
    //   260: istore_2
    //   261: goto -92 -> 169
    //   264: astore_0
    //   265: ldc 8
    //   267: aload_0
    //   268: ldc 141
    //   270: iconst_0
    //   271: anewarray 4	java/lang/Object
    //   274: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   277: iload 6
    //   279: istore_2
    //   280: goto -136 -> 144
    //   283: astore_0
    //   284: ldc 8
    //   286: aload_0
    //   287: ldc 141
    //   289: iconst_0
    //   290: anewarray 4	java/lang/Object
    //   293: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   296: goto -168 -> 128
    //   299: astore_0
    //   300: ldc 8
    //   302: aload_0
    //   303: ldc 141
    //   305: iconst_0
    //   306: anewarray 4	java/lang/Object
    //   309: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   312: iload 6
    //   314: istore_2
    //   315: goto -171 -> 144
    //   318: astore_1
    //   319: aload_0
    //   320: ifnull +7 -> 327
    //   323: aload_0
    //   324: invokevirtual 148	java/io/InputStream:close	()V
    //   327: aload 11
    //   329: ifnull +8 -> 337
    //   332: aload 11
    //   334: invokevirtual 149	java/io/OutputStream:close	()V
    //   337: ldc 117
    //   339: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   342: aload_1
    //   343: athrow
    //   344: astore_0
    //   345: ldc 8
    //   347: aload_0
    //   348: ldc 141
    //   350: iconst_0
    //   351: anewarray 4	java/lang/Object
    //   354: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   357: goto -30 -> 327
    //   360: astore_0
    //   361: ldc 8
    //   363: aload_0
    //   364: ldc 141
    //   366: iconst_0
    //   367: anewarray 4	java/lang/Object
    //   370: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   373: goto -36 -> 337
    //   376: goto -232 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	paramInputStream	java.io.InputStream
    //   0	379	1	paramString	String
    //   0	379	2	paramBoolean	boolean
    //   29	186	3	i	int
    //   74	22	4	j	int
    //   1	241	5	bool1	boolean
    //   4	309	6	bool2	boolean
    //   216	17	7	l1	long
    //   230	5	9	l2	long
    //   23	310	11	localObject	Object
    //   19	202	12	localOutputStream1	java.io.OutputStream
    //   15	208	13	localOutputStream2	java.io.OutputStream
    //   12	81	14	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   25	30	103	java/lang/Exception
    //   38	45	103	java/lang/Exception
    //   53	60	103	java/lang/Exception
    //   68	76	103	java/lang/Exception
    //   90	100	103	java/lang/Exception
    //   190	199	103	java/lang/Exception
    //   207	214	103	java/lang/Exception
    //   226	232	103	java/lang/Exception
    //   162	166	246	java/io/IOException
    //   174	179	264	java/io/IOException
    //   124	128	283	java/io/IOException
    //   136	141	299	java/io/IOException
    //   25	30	318	finally
    //   38	45	318	finally
    //   53	60	318	finally
    //   68	76	318	finally
    //   90	100	318	finally
    //   108	120	318	finally
    //   190	199	318	finally
    //   207	214	318	finally
    //   226	232	318	finally
    //   323	327	344	java/io/IOException
    //   332	337	360	java/io/IOException
  }
  
  /* Error */
  public static boolean copyFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc 154
    //   4: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokestatic 28	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   11: ifne +10 -> 21
    //   14: aload_1
    //   15: invokestatic 28	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   18: ifeq +17 -> 35
    //   21: ldc 8
    //   23: ldc 156
    //   25: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: ldc 154
    //   30: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: iconst_0
    //   34: ireturn
    //   35: aload_0
    //   36: aload_1
    //   37: invokevirtual 166	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   40: ifeq +10 -> 50
    //   43: ldc 154
    //   45: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: iconst_1
    //   49: ireturn
    //   50: aload_0
    //   51: invokestatic 169	com/tencent/mm/vfs/s:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   54: astore_0
    //   55: aload_1
    //   56: iconst_0
    //   57: invokestatic 129	com/tencent/mm/vfs/s:dw	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   60: astore_1
    //   61: aload_1
    //   62: astore 6
    //   64: aload_0
    //   65: astore 5
    //   67: sipush 16384
    //   70: newarray byte
    //   72: astore 7
    //   74: aload_1
    //   75: astore 6
    //   77: aload_0
    //   78: astore 5
    //   80: aload_0
    //   81: aload 7
    //   83: invokevirtual 133	java/io/InputStream:read	([B)I
    //   86: istore_2
    //   87: iload_2
    //   88: iconst_m1
    //   89: if_icmpeq +66 -> 155
    //   92: aload_1
    //   93: astore 6
    //   95: aload_0
    //   96: astore 5
    //   98: aload_1
    //   99: aload 7
    //   101: iconst_0
    //   102: iload_2
    //   103: invokevirtual 139	java/io/OutputStream:write	([BII)V
    //   106: goto -32 -> 74
    //   109: astore 7
    //   111: aload_1
    //   112: astore 6
    //   114: aload_0
    //   115: astore 5
    //   117: ldc 8
    //   119: aload 7
    //   121: ldc 141
    //   123: iconst_0
    //   124: anewarray 4	java/lang/Object
    //   127: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   130: aload_0
    //   131: ifnull +7 -> 138
    //   134: aload_0
    //   135: invokevirtual 148	java/io/InputStream:close	()V
    //   138: aload_1
    //   139: ifnull +211 -> 350
    //   142: aload_1
    //   143: invokevirtual 149	java/io/OutputStream:close	()V
    //   146: iconst_0
    //   147: istore_3
    //   148: ldc 154
    //   150: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: iload_3
    //   154: ireturn
    //   155: iload_3
    //   156: istore 4
    //   158: aload_0
    //   159: ifnull +10 -> 169
    //   162: aload_0
    //   163: invokevirtual 148	java/io/InputStream:close	()V
    //   166: iload_3
    //   167: istore 4
    //   169: iload 4
    //   171: istore_3
    //   172: aload_1
    //   173: ifnull -25 -> 148
    //   176: aload_1
    //   177: invokevirtual 149	java/io/OutputStream:close	()V
    //   180: iload 4
    //   182: istore_3
    //   183: goto -35 -> 148
    //   186: astore_0
    //   187: ldc 8
    //   189: aload_0
    //   190: ldc 141
    //   192: iconst_0
    //   193: anewarray 4	java/lang/Object
    //   196: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   199: iconst_0
    //   200: istore_3
    //   201: goto -53 -> 148
    //   204: astore_0
    //   205: ldc 8
    //   207: aload_0
    //   208: ldc 141
    //   210: iconst_0
    //   211: anewarray 4	java/lang/Object
    //   214: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   217: iconst_0
    //   218: istore 4
    //   220: goto -51 -> 169
    //   223: astore_0
    //   224: ldc 8
    //   226: aload_0
    //   227: ldc 141
    //   229: iconst_0
    //   230: anewarray 4	java/lang/Object
    //   233: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   236: goto -98 -> 138
    //   239: astore_0
    //   240: ldc 8
    //   242: aload_0
    //   243: ldc 141
    //   245: iconst_0
    //   246: anewarray 4	java/lang/Object
    //   249: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   252: iconst_0
    //   253: istore_3
    //   254: goto -106 -> 148
    //   257: astore_1
    //   258: aconst_null
    //   259: astore 6
    //   261: aconst_null
    //   262: astore_0
    //   263: aload_0
    //   264: ifnull +7 -> 271
    //   267: aload_0
    //   268: invokevirtual 148	java/io/InputStream:close	()V
    //   271: aload 6
    //   273: ifnull +8 -> 281
    //   276: aload 6
    //   278: invokevirtual 149	java/io/OutputStream:close	()V
    //   281: ldc 154
    //   283: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   286: aload_1
    //   287: athrow
    //   288: astore_0
    //   289: ldc 8
    //   291: aload_0
    //   292: ldc 141
    //   294: iconst_0
    //   295: anewarray 4	java/lang/Object
    //   298: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   301: goto -30 -> 271
    //   304: astore_0
    //   305: ldc 8
    //   307: aload_0
    //   308: ldc 141
    //   310: iconst_0
    //   311: anewarray 4	java/lang/Object
    //   314: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   317: goto -36 -> 281
    //   320: astore_1
    //   321: aconst_null
    //   322: astore 6
    //   324: goto -61 -> 263
    //   327: astore_1
    //   328: aload 5
    //   330: astore_0
    //   331: goto -68 -> 263
    //   334: astore 7
    //   336: aconst_null
    //   337: astore_1
    //   338: aconst_null
    //   339: astore_0
    //   340: goto -229 -> 111
    //   343: astore 7
    //   345: aconst_null
    //   346: astore_1
    //   347: goto -236 -> 111
    //   350: iconst_0
    //   351: istore_3
    //   352: goto -204 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	355	0	paramString1	String
    //   0	355	1	paramString2	String
    //   86	17	2	i	int
    //   1	351	3	bool1	boolean
    //   156	63	4	bool2	boolean
    //   65	264	5	str1	String
    //   62	261	6	str2	String
    //   72	28	7	arrayOfByte	byte[]
    //   109	11	7	localException1	java.lang.Exception
    //   334	1	7	localException2	java.lang.Exception
    //   343	1	7	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   67	74	109	java/lang/Exception
    //   80	87	109	java/lang/Exception
    //   98	106	109	java/lang/Exception
    //   176	180	186	java/io/IOException
    //   162	166	204	java/io/IOException
    //   134	138	223	java/io/IOException
    //   142	146	239	java/io/IOException
    //   50	55	257	finally
    //   267	271	288	java/io/IOException
    //   276	281	304	java/io/IOException
    //   55	61	320	finally
    //   67	74	327	finally
    //   80	87	327	finally
    //   98	106	327	finally
    //   117	130	327	finally
    //   50	55	334	java/lang/Exception
    //   55	61	343	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.FilesCopy
 * JD-Core Version:    0.7.0.1
 */