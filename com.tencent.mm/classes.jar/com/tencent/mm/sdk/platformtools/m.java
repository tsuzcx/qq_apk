package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;

public final class m
{
  public static boolean C(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(51987);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(51987);
      return false;
    }
    Object localObject = new File(paramString1);
    if (!((File)localObject).exists())
    {
      AppMethodBeat.o(51987);
      return false;
    }
    File localFile = new File(paramString2);
    if (((File)localObject).isFile())
    {
      if ((!localFile.isFile()) && (localFile.exists()))
      {
        AppMethodBeat.o(51987);
        return false;
      }
      copyFile(paramString1, paramString2);
      if (paramBoolean) {
        ((File)localObject).delete();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(51987);
      return true;
      if (((File)localObject).isDirectory())
      {
        if (!localFile.exists()) {
          localFile.mkdir();
        }
        if (!localFile.isDirectory())
        {
          AppMethodBeat.o(51987);
          return false;
        }
        localObject = ((File)localObject).list();
        while (i < localObject.length)
        {
          C(paramString1 + "/" + localObject[i], paramString2 + "/" + localObject[i], paramBoolean);
          i += 1;
        }
      }
    }
  }
  
  /* Error */
  private static boolean a(java.io.InputStream paramInputStream, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: ldc 77
    //   8: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: invokevirtual 83	java/io/InputStream:available	()I
    //   15: istore_3
    //   16: new 85	java/io/FileOutputStream
    //   19: dup
    //   20: aload_1
    //   21: iload_2
    //   22: invokespecial 88	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   25: astore 12
    //   27: aload 12
    //   29: astore 11
    //   31: sipush 16384
    //   34: newarray byte
    //   36: astore 13
    //   38: aload 12
    //   40: astore 11
    //   42: aload_0
    //   43: aload 13
    //   45: invokevirtual 92	java/io/InputStream:read	([B)I
    //   48: istore 4
    //   50: iload 4
    //   52: iconst_m1
    //   53: if_icmpeq +74 -> 127
    //   56: aload 12
    //   58: astore 11
    //   60: aload 12
    //   62: aload 13
    //   64: iconst_0
    //   65: iload 4
    //   67: invokevirtual 96	java/io/FileOutputStream:write	([BII)V
    //   70: goto -32 -> 38
    //   73: astore 11
    //   75: aload 12
    //   77: astore_1
    //   78: aload 11
    //   80: astore 12
    //   82: aload_1
    //   83: astore 11
    //   85: ldc 98
    //   87: aload 12
    //   89: ldc 100
    //   91: iconst_0
    //   92: anewarray 4	java/lang/Object
    //   95: invokestatic 106	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   98: aload_0
    //   99: ifnull +7 -> 106
    //   102: aload_0
    //   103: invokevirtual 109	java/io/InputStream:close	()V
    //   106: iload 6
    //   108: istore_2
    //   109: aload_1
    //   110: ifnull +10 -> 120
    //   113: aload_1
    //   114: invokevirtual 110	java/io/FileOutputStream:close	()V
    //   117: iload 6
    //   119: istore_2
    //   120: ldc 77
    //   122: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: iload_2
    //   126: ireturn
    //   127: iload_2
    //   128: ifeq +31 -> 159
    //   131: iload 5
    //   133: istore_2
    //   134: iload_2
    //   135: istore 5
    //   137: aload_0
    //   138: ifnull +10 -> 148
    //   141: aload_0
    //   142: invokevirtual 109	java/io/InputStream:close	()V
    //   145: iload_2
    //   146: istore 5
    //   148: aload 12
    //   150: invokevirtual 110	java/io/FileOutputStream:close	()V
    //   153: iload 5
    //   155: istore_2
    //   156: goto -36 -> 120
    //   159: aload 12
    //   161: astore 11
    //   163: new 24	java/io/File
    //   166: dup
    //   167: aload_1
    //   168: invokespecial 28	java/io/File:<init>	(Ljava/lang/String;)V
    //   171: astore_1
    //   172: aload 12
    //   174: astore 11
    //   176: aload_1
    //   177: invokevirtual 32	java/io/File:exists	()Z
    //   180: ifeq +28 -> 208
    //   183: iload_3
    //   184: i2l
    //   185: lstore 7
    //   187: aload 12
    //   189: astore 11
    //   191: aload_1
    //   192: invokevirtual 114	java/io/File:length	()J
    //   195: lstore 9
    //   197: iload 5
    //   199: istore_2
    //   200: lload 7
    //   202: lload 9
    //   204: lcmp
    //   205: ifeq -71 -> 134
    //   208: iconst_0
    //   209: istore_2
    //   210: goto -76 -> 134
    //   213: astore_0
    //   214: ldc 98
    //   216: aload_0
    //   217: ldc 100
    //   219: iconst_0
    //   220: anewarray 4	java/lang/Object
    //   223: invokestatic 106	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   226: iconst_0
    //   227: istore 5
    //   229: goto -81 -> 148
    //   232: astore_0
    //   233: ldc 98
    //   235: aload_0
    //   236: ldc 100
    //   238: iconst_0
    //   239: anewarray 4	java/lang/Object
    //   242: invokestatic 106	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   245: iload 6
    //   247: istore_2
    //   248: goto -128 -> 120
    //   251: astore_0
    //   252: ldc 98
    //   254: aload_0
    //   255: ldc 100
    //   257: iconst_0
    //   258: anewarray 4	java/lang/Object
    //   261: invokestatic 106	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   264: goto -158 -> 106
    //   267: astore_0
    //   268: ldc 98
    //   270: aload_0
    //   271: ldc 100
    //   273: iconst_0
    //   274: anewarray 4	java/lang/Object
    //   277: invokestatic 106	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   280: iload 6
    //   282: istore_2
    //   283: goto -163 -> 120
    //   286: astore_1
    //   287: aconst_null
    //   288: astore 11
    //   290: aload_0
    //   291: ifnull +7 -> 298
    //   294: aload_0
    //   295: invokevirtual 109	java/io/InputStream:close	()V
    //   298: aload 11
    //   300: ifnull +8 -> 308
    //   303: aload 11
    //   305: invokevirtual 110	java/io/FileOutputStream:close	()V
    //   308: ldc 77
    //   310: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   313: aload_1
    //   314: athrow
    //   315: astore_0
    //   316: ldc 98
    //   318: aload_0
    //   319: ldc 100
    //   321: iconst_0
    //   322: anewarray 4	java/lang/Object
    //   325: invokestatic 106	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   328: goto -30 -> 298
    //   331: astore_0
    //   332: ldc 98
    //   334: aload_0
    //   335: ldc 100
    //   337: iconst_0
    //   338: anewarray 4	java/lang/Object
    //   341: invokestatic 106	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   344: goto -36 -> 308
    //   347: astore_1
    //   348: goto -58 -> 290
    //   351: astore 12
    //   353: aconst_null
    //   354: astore_1
    //   355: goto -273 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	paramInputStream	java.io.InputStream
    //   0	358	1	paramString	String
    //   0	358	2	paramBoolean	boolean
    //   15	169	3	i	int
    //   48	18	4	j	int
    //   1	227	5	bool1	boolean
    //   4	277	6	bool2	boolean
    //   185	16	7	l1	long
    //   195	8	9	l2	long
    //   29	30	11	localObject1	Object
    //   73	6	11	localException1	java.lang.Exception
    //   83	221	11	localObject2	Object
    //   25	163	12	localObject3	Object
    //   351	1	12	localException2	java.lang.Exception
    //   36	27	13	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   31	38	73	java/lang/Exception
    //   42	50	73	java/lang/Exception
    //   60	70	73	java/lang/Exception
    //   163	172	73	java/lang/Exception
    //   176	183	73	java/lang/Exception
    //   191	197	73	java/lang/Exception
    //   141	145	213	java/io/IOException
    //   148	153	232	java/io/IOException
    //   102	106	251	java/io/IOException
    //   113	117	267	java/io/IOException
    //   11	27	286	finally
    //   294	298	315	java/io/IOException
    //   303	308	331	java/io/IOException
    //   31	38	347	finally
    //   42	50	347	finally
    //   60	70	347	finally
    //   85	98	347	finally
    //   163	172	347	finally
    //   176	183	347	finally
    //   191	197	347	finally
    //   11	27	351	java/lang/Exception
  }
  
  public static boolean copyAssets(Context paramContext, String paramString1, String paramString2)
  {
    int i = 0;
    AppMethodBeat.i(51988);
    boolean bool;
    try
    {
      bool = a(paramContext.getAssets().open(paramString1), paramString2, false);
      AppMethodBeat.o(51988);
      return bool;
    }
    catch (IOException localIOException)
    {
      ab.e("MicroMsg.SDK.FilesCopy", "copy assets file srcpath=%s to=%s failed, try pattern now", new Object[] { paramString1, paramString2 });
    }
    for (;;)
    {
      String str = paramString1 + "." + i;
      try
      {
        bool = a(paramContext.getAssets().open(str), paramString2, true);
        if (bool) {
          break label104;
        }
      }
      catch (IOException paramContext)
      {
        label97:
        break label97;
      }
      AppMethodBeat.o(51988);
      return true;
      label104:
      ab.d("MicroMsg.SDK.FilesCopy", "copy pattern %s", new Object[] { str });
      i += 1;
    }
  }
  
  /* Error */
  public static boolean copyFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc 148
    //   4: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokestatic 19	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   11: ifne +10 -> 21
    //   14: aload_1
    //   15: invokestatic 19	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   18: ifeq +17 -> 35
    //   21: ldc 98
    //   23: ldc 150
    //   25: invokestatic 154	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: ldc 148
    //   30: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: iconst_0
    //   34: ireturn
    //   35: aload_0
    //   36: aload_1
    //   37: invokevirtual 160	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   40: ifeq +10 -> 50
    //   43: ldc 148
    //   45: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: iconst_1
    //   49: ireturn
    //   50: new 162	java/io/FileInputStream
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 163	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   58: astore 4
    //   60: new 85	java/io/FileOutputStream
    //   63: dup
    //   64: aload_1
    //   65: invokespecial 164	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   68: astore_0
    //   69: aload_0
    //   70: astore 5
    //   72: aload 4
    //   74: astore_1
    //   75: sipush 16384
    //   78: newarray byte
    //   80: astore 6
    //   82: aload_0
    //   83: astore 5
    //   85: aload 4
    //   87: astore_1
    //   88: aload 4
    //   90: aload 6
    //   92: invokevirtual 165	java/io/FileInputStream:read	([B)I
    //   95: istore_2
    //   96: iload_2
    //   97: iconst_m1
    //   98: if_icmpeq +68 -> 166
    //   101: aload_0
    //   102: astore 5
    //   104: aload 4
    //   106: astore_1
    //   107: aload_0
    //   108: aload 6
    //   110: iconst_0
    //   111: iload_2
    //   112: invokevirtual 96	java/io/FileOutputStream:write	([BII)V
    //   115: goto -33 -> 82
    //   118: astore 6
    //   120: aload_0
    //   121: astore 5
    //   123: aload 4
    //   125: astore_1
    //   126: ldc 98
    //   128: aload 6
    //   130: ldc 100
    //   132: iconst_0
    //   133: anewarray 4	java/lang/Object
    //   136: invokestatic 106	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   139: aload 4
    //   141: ifnull +8 -> 149
    //   144: aload 4
    //   146: invokevirtual 166	java/io/FileInputStream:close	()V
    //   149: aload_0
    //   150: ifnull +192 -> 342
    //   153: aload_0
    //   154: invokevirtual 110	java/io/FileOutputStream:close	()V
    //   157: iconst_0
    //   158: istore_3
    //   159: ldc 148
    //   161: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: iload_3
    //   165: ireturn
    //   166: aload 4
    //   168: invokevirtual 166	java/io/FileInputStream:close	()V
    //   171: aload_0
    //   172: invokevirtual 110	java/io/FileOutputStream:close	()V
    //   175: goto -16 -> 159
    //   178: astore_0
    //   179: ldc 98
    //   181: aload_0
    //   182: ldc 100
    //   184: iconst_0
    //   185: anewarray 4	java/lang/Object
    //   188: invokestatic 106	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: iconst_0
    //   192: istore_3
    //   193: goto -34 -> 159
    //   196: astore_1
    //   197: ldc 98
    //   199: aload_1
    //   200: ldc 100
    //   202: iconst_0
    //   203: anewarray 4	java/lang/Object
    //   206: invokestatic 106	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   209: iconst_0
    //   210: istore_3
    //   211: goto -40 -> 171
    //   214: astore_1
    //   215: ldc 98
    //   217: aload_1
    //   218: ldc 100
    //   220: iconst_0
    //   221: anewarray 4	java/lang/Object
    //   224: invokestatic 106	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   227: goto -78 -> 149
    //   230: astore_0
    //   231: ldc 98
    //   233: aload_0
    //   234: ldc 100
    //   236: iconst_0
    //   237: anewarray 4	java/lang/Object
    //   240: invokestatic 106	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   243: iconst_0
    //   244: istore_3
    //   245: goto -86 -> 159
    //   248: astore_0
    //   249: aconst_null
    //   250: astore 5
    //   252: aconst_null
    //   253: astore_1
    //   254: aload_1
    //   255: ifnull +7 -> 262
    //   258: aload_1
    //   259: invokevirtual 166	java/io/FileInputStream:close	()V
    //   262: aload 5
    //   264: ifnull +8 -> 272
    //   267: aload 5
    //   269: invokevirtual 110	java/io/FileOutputStream:close	()V
    //   272: ldc 148
    //   274: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   277: aload_0
    //   278: athrow
    //   279: astore_1
    //   280: ldc 98
    //   282: aload_1
    //   283: ldc 100
    //   285: iconst_0
    //   286: anewarray 4	java/lang/Object
    //   289: invokestatic 106	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   292: goto -30 -> 262
    //   295: astore_1
    //   296: ldc 98
    //   298: aload_1
    //   299: ldc 100
    //   301: iconst_0
    //   302: anewarray 4	java/lang/Object
    //   305: invokestatic 106	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   308: goto -36 -> 272
    //   311: astore_0
    //   312: aconst_null
    //   313: astore 5
    //   315: aload 4
    //   317: astore_1
    //   318: goto -64 -> 254
    //   321: astore_0
    //   322: goto -68 -> 254
    //   325: astore 6
    //   327: aconst_null
    //   328: astore_0
    //   329: aconst_null
    //   330: astore 4
    //   332: goto -212 -> 120
    //   335: astore 6
    //   337: aconst_null
    //   338: astore_0
    //   339: goto -219 -> 120
    //   342: iconst_0
    //   343: istore_3
    //   344: goto -185 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	paramString1	String
    //   0	347	1	paramString2	String
    //   95	17	2	i	int
    //   1	343	3	bool	boolean
    //   58	273	4	localFileInputStream	java.io.FileInputStream
    //   70	244	5	str	String
    //   80	29	6	arrayOfByte	byte[]
    //   118	11	6	localException1	java.lang.Exception
    //   325	1	6	localException2	java.lang.Exception
    //   335	1	6	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   75	82	118	java/lang/Exception
    //   88	96	118	java/lang/Exception
    //   107	115	118	java/lang/Exception
    //   171	175	178	java/io/IOException
    //   166	171	196	java/io/IOException
    //   144	149	214	java/io/IOException
    //   153	157	230	java/io/IOException
    //   50	60	248	finally
    //   258	262	279	java/io/IOException
    //   267	272	295	java/io/IOException
    //   60	69	311	finally
    //   75	82	321	finally
    //   88	96	321	finally
    //   107	115	321	finally
    //   126	139	321	finally
    //   50	60	325	java/lang/Exception
    //   60	69	335	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.m
 * JD-Core Version:    0.7.0.1
 */