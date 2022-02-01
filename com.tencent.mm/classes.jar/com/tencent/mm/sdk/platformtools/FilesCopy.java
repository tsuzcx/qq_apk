package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.q;
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
    Object localObject = new q(paramString1);
    if (!((q)localObject).ifE())
    {
      AppMethodBeat.o(157540);
      return false;
    }
    q localq = new q(paramString2);
    if (((q)localObject).ifH())
    {
      if ((!localq.ifH()) && (localq.ifE()))
      {
        AppMethodBeat.o(157540);
        return false;
      }
      copyFile(paramString1, paramString2);
      if (paramBoolean) {
        ((q)localObject).cFq();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(157540);
      return true;
      if (((q)localObject).isDirectory())
      {
        if (!localq.ifE()) {
          localq.ifK();
        }
        if (!localq.isDirectory())
        {
          AppMethodBeat.o(157540);
          return false;
        }
        localObject = ((q)localObject).ifI();
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
    //   40: invokestatic 129	com/tencent/mm/vfs/u:dI	(Ljava/lang/String;Z)Ljava/io/OutputStream;
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
    //   190: new 33	com/tencent/mm/vfs/q
    //   193: dup
    //   194: aload_1
    //   195: invokespecial 36	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   198: astore_1
    //   199: aload 13
    //   201: astore 12
    //   203: aload 13
    //   205: astore 11
    //   207: aload_1
    //   208: invokevirtual 40	com/tencent/mm/vfs/q:ifE	()Z
    //   211: ifeq +29 -> 240
    //   214: iload_3
    //   215: i2l
    //   216: lstore 7
    //   218: aload 13
    //   220: astore 12
    //   222: aload 13
    //   224: astore 11
    //   226: aload_1
    //   227: invokevirtual 153	com/tencent/mm/vfs/q:length	()J
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
    //   51: invokestatic 169	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   54: astore_0
    //   55: aload_1
    //   56: invokestatic 173	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   59: astore_1
    //   60: aload_1
    //   61: astore 6
    //   63: aload_0
    //   64: astore 5
    //   66: sipush 16384
    //   69: newarray byte
    //   71: astore 7
    //   73: aload_1
    //   74: astore 6
    //   76: aload_0
    //   77: astore 5
    //   79: aload_0
    //   80: aload 7
    //   82: invokevirtual 133	java/io/InputStream:read	([B)I
    //   85: istore_2
    //   86: iload_2
    //   87: iconst_m1
    //   88: if_icmpeq +66 -> 154
    //   91: aload_1
    //   92: astore 6
    //   94: aload_0
    //   95: astore 5
    //   97: aload_1
    //   98: aload 7
    //   100: iconst_0
    //   101: iload_2
    //   102: invokevirtual 139	java/io/OutputStream:write	([BII)V
    //   105: goto -32 -> 73
    //   108: astore 7
    //   110: aload_1
    //   111: astore 6
    //   113: aload_0
    //   114: astore 5
    //   116: ldc 8
    //   118: aload 7
    //   120: ldc 141
    //   122: iconst_0
    //   123: anewarray 4	java/lang/Object
    //   126: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   129: aload_0
    //   130: ifnull +7 -> 137
    //   133: aload_0
    //   134: invokevirtual 148	java/io/InputStream:close	()V
    //   137: aload_1
    //   138: ifnull +211 -> 349
    //   141: aload_1
    //   142: invokevirtual 149	java/io/OutputStream:close	()V
    //   145: iconst_0
    //   146: istore_3
    //   147: ldc 154
    //   149: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: iload_3
    //   153: ireturn
    //   154: iload_3
    //   155: istore 4
    //   157: aload_0
    //   158: ifnull +10 -> 168
    //   161: aload_0
    //   162: invokevirtual 148	java/io/InputStream:close	()V
    //   165: iload_3
    //   166: istore 4
    //   168: iload 4
    //   170: istore_3
    //   171: aload_1
    //   172: ifnull -25 -> 147
    //   175: aload_1
    //   176: invokevirtual 149	java/io/OutputStream:close	()V
    //   179: iload 4
    //   181: istore_3
    //   182: goto -35 -> 147
    //   185: astore_0
    //   186: ldc 8
    //   188: aload_0
    //   189: ldc 141
    //   191: iconst_0
    //   192: anewarray 4	java/lang/Object
    //   195: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   198: iconst_0
    //   199: istore_3
    //   200: goto -53 -> 147
    //   203: astore_0
    //   204: ldc 8
    //   206: aload_0
    //   207: ldc 141
    //   209: iconst_0
    //   210: anewarray 4	java/lang/Object
    //   213: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   216: iconst_0
    //   217: istore 4
    //   219: goto -51 -> 168
    //   222: astore_0
    //   223: ldc 8
    //   225: aload_0
    //   226: ldc 141
    //   228: iconst_0
    //   229: anewarray 4	java/lang/Object
    //   232: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   235: goto -98 -> 137
    //   238: astore_0
    //   239: ldc 8
    //   241: aload_0
    //   242: ldc 141
    //   244: iconst_0
    //   245: anewarray 4	java/lang/Object
    //   248: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   251: iconst_0
    //   252: istore_3
    //   253: goto -106 -> 147
    //   256: astore_1
    //   257: aconst_null
    //   258: astore 6
    //   260: aconst_null
    //   261: astore_0
    //   262: aload_0
    //   263: ifnull +7 -> 270
    //   266: aload_0
    //   267: invokevirtual 148	java/io/InputStream:close	()V
    //   270: aload 6
    //   272: ifnull +8 -> 280
    //   275: aload 6
    //   277: invokevirtual 149	java/io/OutputStream:close	()V
    //   280: ldc 154
    //   282: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   285: aload_1
    //   286: athrow
    //   287: astore_0
    //   288: ldc 8
    //   290: aload_0
    //   291: ldc 141
    //   293: iconst_0
    //   294: anewarray 4	java/lang/Object
    //   297: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: goto -30 -> 270
    //   303: astore_0
    //   304: ldc 8
    //   306: aload_0
    //   307: ldc 141
    //   309: iconst_0
    //   310: anewarray 4	java/lang/Object
    //   313: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   316: goto -36 -> 280
    //   319: astore_1
    //   320: aconst_null
    //   321: astore 6
    //   323: goto -61 -> 262
    //   326: astore_1
    //   327: aload 5
    //   329: astore_0
    //   330: goto -68 -> 262
    //   333: astore 7
    //   335: aconst_null
    //   336: astore_1
    //   337: aconst_null
    //   338: astore_0
    //   339: goto -229 -> 110
    //   342: astore 7
    //   344: aconst_null
    //   345: astore_1
    //   346: goto -236 -> 110
    //   349: iconst_0
    //   350: istore_3
    //   351: goto -204 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	paramString1	String
    //   0	354	1	paramString2	String
    //   85	17	2	i	int
    //   1	350	3	bool1	boolean
    //   155	63	4	bool2	boolean
    //   64	264	5	str1	String
    //   61	261	6	str2	String
    //   71	28	7	arrayOfByte	byte[]
    //   108	11	7	localException1	java.lang.Exception
    //   333	1	7	localException2	java.lang.Exception
    //   342	1	7	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   66	73	108	java/lang/Exception
    //   79	86	108	java/lang/Exception
    //   97	105	108	java/lang/Exception
    //   175	179	185	java/io/IOException
    //   161	165	203	java/io/IOException
    //   133	137	222	java/io/IOException
    //   141	145	238	java/io/IOException
    //   50	55	256	finally
    //   266	270	287	java/io/IOException
    //   275	280	303	java/io/IOException
    //   55	60	319	finally
    //   66	73	326	finally
    //   79	86	326	finally
    //   97	105	326	finally
    //   116	129	326	finally
    //   50	55	333	java/lang/Exception
    //   55	60	342	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.FilesCopy
 * JD-Core Version:    0.7.0.1
 */