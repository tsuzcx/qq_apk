package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;
import java.io.IOException;

public final class j
{
  /* Error */
  private static boolean a(java.io.InputStream paramInputStream, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: aload_0
    //   4: invokevirtual 16	java/io/InputStream:available	()I
    //   7: istore_3
    //   8: new 18	java/io/FileOutputStream
    //   11: dup
    //   12: aload_1
    //   13: iload_2
    //   14: invokespecial 22	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   17: astore 11
    //   19: aload 11
    //   21: astore 10
    //   23: sipush 16384
    //   26: newarray byte
    //   28: astore 12
    //   30: aload 11
    //   32: astore 10
    //   34: aload_0
    //   35: aload 12
    //   37: invokevirtual 26	java/io/InputStream:read	([B)I
    //   40: istore 4
    //   42: iload 4
    //   44: iconst_m1
    //   45: if_icmpeq +63 -> 108
    //   48: aload 11
    //   50: astore 10
    //   52: aload 11
    //   54: aload 12
    //   56: iconst_0
    //   57: iload 4
    //   59: invokevirtual 30	java/io/FileOutputStream:write	([BII)V
    //   62: goto -32 -> 30
    //   65: astore 10
    //   67: aload 11
    //   69: astore_1
    //   70: aload 10
    //   72: astore 11
    //   74: aload_1
    //   75: astore 10
    //   77: ldc 32
    //   79: aload 11
    //   81: ldc 34
    //   83: iconst_0
    //   84: anewarray 4	java/lang/Object
    //   87: invokestatic 40	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: aload_0
    //   91: ifnull +7 -> 98
    //   94: aload_0
    //   95: invokevirtual 44	java/io/InputStream:close	()V
    //   98: aload_1
    //   99: ifnull +7 -> 106
    //   102: aload_1
    //   103: invokevirtual 45	java/io/FileOutputStream:close	()V
    //   106: iconst_0
    //   107: ireturn
    //   108: iload_2
    //   109: ifeq +28 -> 137
    //   112: iload 5
    //   114: istore_2
    //   115: iload_2
    //   116: istore 5
    //   118: aload_0
    //   119: ifnull +10 -> 129
    //   122: aload_0
    //   123: invokevirtual 44	java/io/InputStream:close	()V
    //   126: iload_2
    //   127: istore 5
    //   129: aload 11
    //   131: invokevirtual 45	java/io/FileOutputStream:close	()V
    //   134: iload 5
    //   136: ireturn
    //   137: aload 11
    //   139: astore 10
    //   141: new 47	java/io/File
    //   144: dup
    //   145: aload_1
    //   146: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   149: astore_1
    //   150: aload 11
    //   152: astore 10
    //   154: aload_1
    //   155: invokevirtual 54	java/io/File:exists	()Z
    //   158: ifeq +28 -> 186
    //   161: iload_3
    //   162: i2l
    //   163: lstore 6
    //   165: aload 11
    //   167: astore 10
    //   169: aload_1
    //   170: invokevirtual 58	java/io/File:length	()J
    //   173: lstore 8
    //   175: iload 5
    //   177: istore_2
    //   178: lload 6
    //   180: lload 8
    //   182: lcmp
    //   183: ifeq -68 -> 115
    //   186: iconst_0
    //   187: istore_2
    //   188: goto -73 -> 115
    //   191: astore_0
    //   192: ldc 32
    //   194: aload_0
    //   195: ldc 34
    //   197: iconst_0
    //   198: anewarray 4	java/lang/Object
    //   201: invokestatic 40	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: iconst_0
    //   205: istore 5
    //   207: goto -78 -> 129
    //   210: astore_0
    //   211: ldc 32
    //   213: aload_0
    //   214: ldc 34
    //   216: iconst_0
    //   217: anewarray 4	java/lang/Object
    //   220: invokestatic 40	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   223: iconst_0
    //   224: ireturn
    //   225: astore_0
    //   226: ldc 32
    //   228: aload_0
    //   229: ldc 34
    //   231: iconst_0
    //   232: anewarray 4	java/lang/Object
    //   235: invokestatic 40	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   238: goto -140 -> 98
    //   241: astore_0
    //   242: ldc 32
    //   244: aload_0
    //   245: ldc 34
    //   247: iconst_0
    //   248: anewarray 4	java/lang/Object
    //   251: invokestatic 40	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   254: iconst_0
    //   255: ireturn
    //   256: astore_1
    //   257: aconst_null
    //   258: astore 10
    //   260: aload_0
    //   261: ifnull +7 -> 268
    //   264: aload_0
    //   265: invokevirtual 44	java/io/InputStream:close	()V
    //   268: aload 10
    //   270: ifnull +8 -> 278
    //   273: aload 10
    //   275: invokevirtual 45	java/io/FileOutputStream:close	()V
    //   278: aload_1
    //   279: athrow
    //   280: astore_0
    //   281: ldc 32
    //   283: aload_0
    //   284: ldc 34
    //   286: iconst_0
    //   287: anewarray 4	java/lang/Object
    //   290: invokestatic 40	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   293: goto -25 -> 268
    //   296: astore_0
    //   297: ldc 32
    //   299: aload_0
    //   300: ldc 34
    //   302: iconst_0
    //   303: anewarray 4	java/lang/Object
    //   306: invokestatic 40	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   309: goto -31 -> 278
    //   312: astore_1
    //   313: goto -53 -> 260
    //   316: astore 11
    //   318: aconst_null
    //   319: astore_1
    //   320: goto -246 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	paramInputStream	java.io.InputStream
    //   0	323	1	paramString	String
    //   0	323	2	paramBoolean	boolean
    //   7	155	3	i	int
    //   40	18	4	j	int
    //   1	205	5	bool	boolean
    //   163	16	6	l1	long
    //   173	8	8	l2	long
    //   21	30	10	localObject1	Object
    //   65	6	10	localException1	java.lang.Exception
    //   75	199	10	localObject2	Object
    //   17	149	11	localObject3	Object
    //   316	1	11	localException2	java.lang.Exception
    //   28	27	12	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   23	30	65	java/lang/Exception
    //   34	42	65	java/lang/Exception
    //   52	62	65	java/lang/Exception
    //   141	150	65	java/lang/Exception
    //   154	161	65	java/lang/Exception
    //   169	175	65	java/lang/Exception
    //   122	126	191	java/io/IOException
    //   129	134	210	java/io/IOException
    //   94	98	225	java/io/IOException
    //   102	106	241	java/io/IOException
    //   3	19	256	finally
    //   264	268	280	java/io/IOException
    //   273	278	296	java/io/IOException
    //   23	30	312	finally
    //   34	42	312	finally
    //   52	62	312	finally
    //   77	90	312	finally
    //   141	150	312	finally
    //   154	161	312	finally
    //   169	175	312	finally
    //   3	19	316	java/lang/Exception
  }
  
  public static boolean copyAssets(Context paramContext, String paramString1, String paramString2)
  {
    int i = 0;
    try
    {
      boolean bool = a(paramContext.getAssets().open(paramString1), paramString2, false);
      return bool;
    }
    catch (IOException localIOException)
    {
      y.e("MicroMsg.SDK.FilesCopy", "copy assets file srcpath=%s to=%s failed, try pattern now", new Object[] { paramString1, paramString2 });
      for (;;)
      {
        String str = paramString1 + "." + i;
        try
        {
          if (a(paramContext.getAssets().open(str), paramString2, true))
          {
            y.d("MicroMsg.SDK.FilesCopy", "copy pattern %s", new Object[] { str });
            i += 1;
          }
        }
        catch (IOException paramContext) {}
      }
    }
    return true;
  }
  
  /* Error */
  public static boolean copyFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: iconst_1
    //   4: istore_3
    //   5: aload_0
    //   6: invokestatic 111	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   9: ifne +10 -> 19
    //   12: aload_1
    //   13: invokestatic 111	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   16: ifeq +14 -> 30
    //   19: ldc 32
    //   21: ldc 113
    //   23: invokestatic 117	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: iconst_0
    //   27: istore_3
    //   28: iload_3
    //   29: ireturn
    //   30: aload_0
    //   31: aload_1
    //   32: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   35: ifne -7 -> 28
    //   38: new 125	java/io/FileInputStream
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 126	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   46: astore 5
    //   48: new 18	java/io/FileOutputStream
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 127	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   56: astore_0
    //   57: aload_0
    //   58: astore 6
    //   60: aload 5
    //   62: astore_1
    //   63: sipush 16384
    //   66: newarray byte
    //   68: astore 7
    //   70: aload_0
    //   71: astore 6
    //   73: aload 5
    //   75: astore_1
    //   76: aload 5
    //   78: aload 7
    //   80: invokevirtual 128	java/io/FileInputStream:read	([B)I
    //   83: istore_2
    //   84: iload_2
    //   85: iconst_m1
    //   86: if_icmpeq +61 -> 147
    //   89: aload_0
    //   90: astore 6
    //   92: aload 5
    //   94: astore_1
    //   95: aload_0
    //   96: aload 7
    //   98: iconst_0
    //   99: iload_2
    //   100: invokevirtual 30	java/io/FileOutputStream:write	([BII)V
    //   103: goto -33 -> 70
    //   106: astore 7
    //   108: aload_0
    //   109: astore 6
    //   111: aload 5
    //   113: astore_1
    //   114: ldc 32
    //   116: aload 7
    //   118: ldc 34
    //   120: iconst_0
    //   121: anewarray 4	java/lang/Object
    //   124: invokestatic 40	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: aload 5
    //   129: ifnull +8 -> 137
    //   132: aload 5
    //   134: invokevirtual 129	java/io/FileInputStream:close	()V
    //   137: aload_0
    //   138: ifnull +176 -> 314
    //   141: aload_0
    //   142: invokevirtual 45	java/io/FileOutputStream:close	()V
    //   145: iconst_0
    //   146: ireturn
    //   147: aload 5
    //   149: invokevirtual 129	java/io/FileInputStream:close	()V
    //   152: iload 4
    //   154: istore_3
    //   155: aload_0
    //   156: invokevirtual 45	java/io/FileOutputStream:close	()V
    //   159: iload_3
    //   160: ireturn
    //   161: astore_0
    //   162: ldc 32
    //   164: aload_0
    //   165: ldc 34
    //   167: iconst_0
    //   168: anewarray 4	java/lang/Object
    //   171: invokestatic 40	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: iconst_0
    //   175: ireturn
    //   176: astore_1
    //   177: ldc 32
    //   179: aload_1
    //   180: ldc 34
    //   182: iconst_0
    //   183: anewarray 4	java/lang/Object
    //   186: invokestatic 40	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: iconst_0
    //   190: istore_3
    //   191: goto -36 -> 155
    //   194: astore_1
    //   195: ldc 32
    //   197: aload_1
    //   198: ldc 34
    //   200: iconst_0
    //   201: anewarray 4	java/lang/Object
    //   204: invokestatic 40	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   207: goto -70 -> 137
    //   210: astore_0
    //   211: ldc 32
    //   213: aload_0
    //   214: ldc 34
    //   216: iconst_0
    //   217: anewarray 4	java/lang/Object
    //   220: invokestatic 40	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   223: iconst_0
    //   224: ireturn
    //   225: astore_0
    //   226: aconst_null
    //   227: astore 6
    //   229: aconst_null
    //   230: astore_1
    //   231: aload_1
    //   232: ifnull +7 -> 239
    //   235: aload_1
    //   236: invokevirtual 129	java/io/FileInputStream:close	()V
    //   239: aload 6
    //   241: ifnull +8 -> 249
    //   244: aload 6
    //   246: invokevirtual 45	java/io/FileOutputStream:close	()V
    //   249: aload_0
    //   250: athrow
    //   251: astore_1
    //   252: ldc 32
    //   254: aload_1
    //   255: ldc 34
    //   257: iconst_0
    //   258: anewarray 4	java/lang/Object
    //   261: invokestatic 40	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   264: goto -25 -> 239
    //   267: astore_1
    //   268: ldc 32
    //   270: aload_1
    //   271: ldc 34
    //   273: iconst_0
    //   274: anewarray 4	java/lang/Object
    //   277: invokestatic 40	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   280: goto -31 -> 249
    //   283: astore_0
    //   284: aconst_null
    //   285: astore 6
    //   287: aload 5
    //   289: astore_1
    //   290: goto -59 -> 231
    //   293: astore_0
    //   294: goto -63 -> 231
    //   297: astore 7
    //   299: aconst_null
    //   300: astore_0
    //   301: aconst_null
    //   302: astore 5
    //   304: goto -196 -> 108
    //   307: astore 7
    //   309: aconst_null
    //   310: astore_0
    //   311: goto -203 -> 108
    //   314: iconst_0
    //   315: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	paramString1	String
    //   0	316	1	paramString2	String
    //   83	17	2	i	int
    //   4	187	3	bool1	boolean
    //   1	152	4	bool2	boolean
    //   46	257	5	localFileInputStream	java.io.FileInputStream
    //   58	228	6	str	String
    //   68	29	7	arrayOfByte	byte[]
    //   106	11	7	localException1	java.lang.Exception
    //   297	1	7	localException2	java.lang.Exception
    //   307	1	7	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   63	70	106	java/lang/Exception
    //   76	84	106	java/lang/Exception
    //   95	103	106	java/lang/Exception
    //   155	159	161	java/io/IOException
    //   147	152	176	java/io/IOException
    //   132	137	194	java/io/IOException
    //   141	145	210	java/io/IOException
    //   38	48	225	finally
    //   235	239	251	java/io/IOException
    //   244	249	267	java/io/IOException
    //   48	57	283	finally
    //   63	70	293	finally
    //   76	84	293	finally
    //   95	103	293	finally
    //   114	127	293	finally
    //   38	48	297	java/lang/Exception
    //   48	57	307	java/lang/Exception
  }
  
  public static boolean u(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 0;
    if (bk.bl(paramString1)) {}
    Object localObject;
    File localFile;
    do
    {
      do
      {
        return false;
        localObject = new File(paramString1);
      } while (!((File)localObject).exists());
      localFile = new File(paramString2);
      if (!((File)localObject).isFile()) {
        break;
      }
    } while ((!localFile.isFile()) && (localFile.exists()));
    copyFile(paramString1, paramString2);
    if (paramBoolean) {
      ((File)localObject).delete();
    }
    for (;;)
    {
      return true;
      if (((File)localObject).isDirectory())
      {
        if (!localFile.exists()) {
          localFile.mkdir();
        }
        if (!localFile.isDirectory()) {
          break;
        }
        localObject = ((File)localObject).list();
        while (i < localObject.length)
        {
          u(paramString1 + "/" + localObject[i], paramString2 + "/" + localObject[i], paramBoolean);
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.j
 * JD-Core Version:    0.7.0.1
 */