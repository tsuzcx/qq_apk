package com.tencent.mm.sandbox.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class d
{
  /* Error */
  private static String C(File paramFile)
  {
    // Byte code:
    //   0: ldc2_w 11
    //   3: lstore_1
    //   4: ldc 13
    //   6: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokevirtual 25	java/io/File:exists	()Z
    //   13: ifne +10 -> 23
    //   16: ldc 13
    //   18: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aconst_null
    //   22: areturn
    //   23: new 30	java/io/FileInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 34	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: astore_3
    //   32: ldc2_w 11
    //   35: aload_0
    //   36: invokevirtual 38	java/io/File:length	()J
    //   39: lcmp
    //   40: ifgt +25 -> 65
    //   43: aload_3
    //   44: lload_1
    //   45: l2i
    //   46: invokestatic 44	com/tencent/mm/b/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   49: astore_0
    //   50: aload_3
    //   51: invokevirtual 48	java/io/FileInputStream:close	()V
    //   54: aload_3
    //   55: invokevirtual 48	java/io/FileInputStream:close	()V
    //   58: ldc 13
    //   60: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_0
    //   64: areturn
    //   65: aload_0
    //   66: invokevirtual 38	java/io/File:length	()J
    //   69: lstore_1
    //   70: goto -27 -> 43
    //   73: astore_0
    //   74: aconst_null
    //   75: astore_0
    //   76: aload_0
    //   77: ifnull +7 -> 84
    //   80: aload_0
    //   81: invokevirtual 48	java/io/FileInputStream:close	()V
    //   84: ldc 13
    //   86: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aconst_null
    //   90: areturn
    //   91: astore_0
    //   92: aconst_null
    //   93: astore_3
    //   94: aload_3
    //   95: ifnull +7 -> 102
    //   98: aload_3
    //   99: invokevirtual 48	java/io/FileInputStream:close	()V
    //   102: ldc 13
    //   104: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_0
    //   108: athrow
    //   109: astore_3
    //   110: goto -52 -> 58
    //   113: astore_0
    //   114: goto -30 -> 84
    //   117: astore_3
    //   118: goto -16 -> 102
    //   121: astore_0
    //   122: goto -28 -> 94
    //   125: astore_0
    //   126: aload_3
    //   127: astore_0
    //   128: goto -52 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramFile	File
    //   3	67	1	l	long
    //   31	68	3	localFileInputStream	java.io.FileInputStream
    //   109	1	3	localIOException1	java.io.IOException
    //   117	10	3	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   23	32	73	java/lang/Exception
    //   23	32	91	finally
    //   54	58	109	java/io/IOException
    //   80	84	113	java/io/IOException
    //   98	102	117	java/io/IOException
    //   32	43	121	finally
    //   43	54	121	finally
    //   65	70	121	finally
    //   32	43	125	java/lang/Exception
    //   43	54	125	java/lang/Exception
    //   65	70	125	java/lang/Exception
  }
  
  public static int aEL(String paramString)
  {
    AppMethodBeat.i(169802);
    if (paramString == null)
    {
      AppMethodBeat.o(169802);
      return 0;
    }
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      AppMethodBeat.o(169802);
      return 0;
    }
    int i = (int)paramString.length();
    AppMethodBeat.o(169802);
    return i;
  }
  
  /* Error */
  public static byte[] aEM(String paramString)
  {
    // Byte code:
    //   0: ldc 58
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +10 -> 16
    //   9: ldc 58
    //   11: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: aconst_null
    //   15: areturn
    //   16: new 21	java/io/File
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore_3
    //   25: aload_3
    //   26: invokevirtual 25	java/io/File:exists	()Z
    //   29: ifne +10 -> 39
    //   32: ldc 58
    //   34: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aconst_null
    //   38: areturn
    //   39: aload_3
    //   40: invokevirtual 38	java/io/File:length	()J
    //   43: l2i
    //   44: istore_2
    //   45: iload_2
    //   46: ifgt +10 -> 56
    //   49: ldc 58
    //   51: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: aconst_null
    //   55: areturn
    //   56: iload_2
    //   57: istore_1
    //   58: iload_2
    //   59: iconst_0
    //   60: iadd
    //   61: aload_3
    //   62: invokevirtual 38	java/io/File:length	()J
    //   65: l2i
    //   66: if_icmple +11 -> 77
    //   69: aload_3
    //   70: invokevirtual 38	java/io/File:length	()J
    //   73: l2i
    //   74: iconst_0
    //   75: iadd
    //   76: istore_1
    //   77: new 60	java/io/RandomAccessFile
    //   80: dup
    //   81: aload_0
    //   82: ldc 62
    //   84: invokespecial 65	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: astore 6
    //   89: aload 6
    //   91: astore 4
    //   93: iload_1
    //   94: newarray byte
    //   96: astore_3
    //   97: aload 6
    //   99: astore 4
    //   101: aload 6
    //   103: lconst_0
    //   104: invokevirtual 69	java/io/RandomAccessFile:seek	(J)V
    //   107: aload 6
    //   109: astore 4
    //   111: aload 6
    //   113: aload_3
    //   114: invokevirtual 73	java/io/RandomAccessFile:readFully	([B)V
    //   117: aload 6
    //   119: invokevirtual 74	java/io/RandomAccessFile:close	()V
    //   122: aload_3
    //   123: astore_0
    //   124: ldc 58
    //   126: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: aload_0
    //   130: areturn
    //   131: astore 4
    //   133: ldc 76
    //   135: aload 4
    //   137: ldc 78
    //   139: iconst_0
    //   140: anewarray 4	java/lang/Object
    //   143: invokestatic 84	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: ldc 76
    //   148: ldc 86
    //   150: iconst_5
    //   151: anewarray 4	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: aload 4
    //   158: invokevirtual 90	java/lang/Object:getClass	()Ljava/lang/Class;
    //   161: invokevirtual 96	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   164: aastore
    //   165: dup
    //   166: iconst_1
    //   167: aload 4
    //   169: invokevirtual 99	java/io/IOException:getMessage	()Ljava/lang/String;
    //   172: aastore
    //   173: dup
    //   174: iconst_2
    //   175: aload_0
    //   176: aastore
    //   177: dup
    //   178: iconst_3
    //   179: iconst_0
    //   180: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   183: aastore
    //   184: dup
    //   185: iconst_4
    //   186: iload_1
    //   187: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   190: aastore
    //   191: invokestatic 109	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   194: aload_3
    //   195: astore_0
    //   196: goto -72 -> 124
    //   199: astore 5
    //   201: aconst_null
    //   202: astore 6
    //   204: aconst_null
    //   205: astore_3
    //   206: aload 6
    //   208: astore 4
    //   210: ldc 76
    //   212: aload 5
    //   214: ldc 78
    //   216: iconst_0
    //   217: anewarray 4	java/lang/Object
    //   220: invokestatic 84	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   223: aload 6
    //   225: astore 4
    //   227: ldc 76
    //   229: ldc 111
    //   231: iconst_5
    //   232: anewarray 4	java/lang/Object
    //   235: dup
    //   236: iconst_0
    //   237: aload 5
    //   239: invokevirtual 90	java/lang/Object:getClass	()Ljava/lang/Class;
    //   242: invokevirtual 96	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   245: aastore
    //   246: dup
    //   247: iconst_1
    //   248: aload 5
    //   250: invokevirtual 112	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   253: aastore
    //   254: dup
    //   255: iconst_2
    //   256: aload_0
    //   257: aastore
    //   258: dup
    //   259: iconst_3
    //   260: iconst_0
    //   261: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   264: aastore
    //   265: dup
    //   266: iconst_4
    //   267: iload_1
    //   268: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   271: aastore
    //   272: invokestatic 109	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   275: aload 6
    //   277: ifnull +184 -> 461
    //   280: aload 6
    //   282: invokevirtual 74	java/io/RandomAccessFile:close	()V
    //   285: aload_3
    //   286: astore_0
    //   287: goto -163 -> 124
    //   290: astore 4
    //   292: ldc 76
    //   294: aload 4
    //   296: ldc 78
    //   298: iconst_0
    //   299: anewarray 4	java/lang/Object
    //   302: invokestatic 84	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   305: ldc 76
    //   307: ldc 86
    //   309: iconst_5
    //   310: anewarray 4	java/lang/Object
    //   313: dup
    //   314: iconst_0
    //   315: aload 4
    //   317: invokevirtual 90	java/lang/Object:getClass	()Ljava/lang/Class;
    //   320: invokevirtual 96	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   323: aastore
    //   324: dup
    //   325: iconst_1
    //   326: aload 4
    //   328: invokevirtual 99	java/io/IOException:getMessage	()Ljava/lang/String;
    //   331: aastore
    //   332: dup
    //   333: iconst_2
    //   334: aload_0
    //   335: aastore
    //   336: dup
    //   337: iconst_3
    //   338: iconst_0
    //   339: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   342: aastore
    //   343: dup
    //   344: iconst_4
    //   345: iload_1
    //   346: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   349: aastore
    //   350: invokestatic 109	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   353: aload_3
    //   354: astore_0
    //   355: goto -231 -> 124
    //   358: astore_3
    //   359: aconst_null
    //   360: astore 4
    //   362: aload 4
    //   364: ifnull +8 -> 372
    //   367: aload 4
    //   369: invokevirtual 74	java/io/RandomAccessFile:close	()V
    //   372: ldc 58
    //   374: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   377: aload_3
    //   378: athrow
    //   379: astore 4
    //   381: ldc 76
    //   383: aload 4
    //   385: ldc 78
    //   387: iconst_0
    //   388: anewarray 4	java/lang/Object
    //   391: invokestatic 84	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   394: ldc 76
    //   396: ldc 86
    //   398: iconst_5
    //   399: anewarray 4	java/lang/Object
    //   402: dup
    //   403: iconst_0
    //   404: aload 4
    //   406: invokevirtual 90	java/lang/Object:getClass	()Ljava/lang/Class;
    //   409: invokevirtual 96	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   412: aastore
    //   413: dup
    //   414: iconst_1
    //   415: aload 4
    //   417: invokevirtual 99	java/io/IOException:getMessage	()Ljava/lang/String;
    //   420: aastore
    //   421: dup
    //   422: iconst_2
    //   423: aload_0
    //   424: aastore
    //   425: dup
    //   426: iconst_3
    //   427: iconst_0
    //   428: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   431: aastore
    //   432: dup
    //   433: iconst_4
    //   434: iload_1
    //   435: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   438: aastore
    //   439: invokestatic 109	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   442: goto -70 -> 372
    //   445: astore_3
    //   446: goto -84 -> 362
    //   449: astore 5
    //   451: aconst_null
    //   452: astore_3
    //   453: goto -247 -> 206
    //   456: astore 5
    //   458: goto -252 -> 206
    //   461: aload_3
    //   462: astore_0
    //   463: goto -339 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	466	0	paramString	String
    //   57	378	1	i	int
    //   44	17	2	j	int
    //   24	330	3	localObject1	Object
    //   358	20	3	localObject2	Object
    //   445	1	3	localObject3	Object
    //   452	10	3	localObject4	Object
    //   91	19	4	localRandomAccessFile1	java.io.RandomAccessFile
    //   131	37	4	localIOException1	java.io.IOException
    //   208	18	4	localRandomAccessFile2	java.io.RandomAccessFile
    //   290	37	4	localIOException2	java.io.IOException
    //   360	8	4	localObject5	Object
    //   379	37	4	localIOException3	java.io.IOException
    //   199	50	5	localException1	java.lang.Exception
    //   449	1	5	localException2	java.lang.Exception
    //   456	1	5	localException3	java.lang.Exception
    //   87	194	6	localRandomAccessFile3	java.io.RandomAccessFile
    // Exception table:
    //   from	to	target	type
    //   117	122	131	java/io/IOException
    //   77	89	199	java/lang/Exception
    //   280	285	290	java/io/IOException
    //   77	89	358	finally
    //   367	372	379	java/io/IOException
    //   93	97	445	finally
    //   101	107	445	finally
    //   111	117	445	finally
    //   210	223	445	finally
    //   227	275	445	finally
    //   93	97	449	java/lang/Exception
    //   101	107	456	java/lang/Exception
    //   111	117	456	java/lang/Exception
  }
  
  public static String aEN(String paramString)
  {
    AppMethodBeat.i(169805);
    if (paramString == null)
    {
      AppMethodBeat.o(169805);
      return null;
    }
    paramString = new File(paramString);
    if (paramString.exists())
    {
      paramString = C(paramString);
      AppMethodBeat.o(169805);
      return paramString;
    }
    AppMethodBeat.o(169805);
    return null;
  }
  
  public static boolean deleteFile(String paramString)
  {
    AppMethodBeat.i(169801);
    if (paramString == null)
    {
      AppMethodBeat.o(169801);
      return true;
    }
    paramString = new File(paramString);
    if (paramString.exists())
    {
      boolean bool = paramString.delete();
      AppMethodBeat.o(169801);
      return bool;
    }
    AppMethodBeat.o(169801);
    return true;
  }
  
  public static final boolean eK(String paramString)
  {
    AppMethodBeat.i(169804);
    if (paramString == null)
    {
      AppMethodBeat.o(169804);
      return false;
    }
    if (new File(paramString).exists())
    {
      AppMethodBeat.o(169804);
      return true;
    }
    AppMethodBeat.o(169804);
    return false;
  }
  
  /* Error */
  public static int z(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 128
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnull +8 -> 14
    //   9: aload_1
    //   10: arraylength
    //   11: ifne +11 -> 22
    //   14: ldc 128
    //   16: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: bipush 254
    //   21: ireturn
    //   22: new 130	java/io/FileOutputStream
    //   25: dup
    //   26: aload_0
    //   27: iconst_1
    //   28: invokespecial 133	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   31: astore_3
    //   32: aload_3
    //   33: astore_2
    //   34: aload_3
    //   35: aload_1
    //   36: iconst_0
    //   37: aload_1
    //   38: arraylength
    //   39: invokevirtual 137	java/io/FileOutputStream:write	([BII)V
    //   42: aload_3
    //   43: invokevirtual 138	java/io/FileOutputStream:close	()V
    //   46: ldc 128
    //   48: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: iconst_0
    //   52: ireturn
    //   53: astore_2
    //   54: ldc 76
    //   56: aload_2
    //   57: ldc 78
    //   59: iconst_0
    //   60: anewarray 4	java/lang/Object
    //   63: invokestatic 84	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: ldc 76
    //   68: ldc 140
    //   70: iconst_4
    //   71: anewarray 4	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: aload_2
    //   77: invokevirtual 90	java/lang/Object:getClass	()Ljava/lang/Class;
    //   80: invokevirtual 96	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   83: aastore
    //   84: dup
    //   85: iconst_1
    //   86: aload_2
    //   87: invokevirtual 99	java/io/IOException:getMessage	()Ljava/lang/String;
    //   90: aastore
    //   91: dup
    //   92: iconst_2
    //   93: aload_0
    //   94: aastore
    //   95: dup
    //   96: iconst_3
    //   97: aload_1
    //   98: arraylength
    //   99: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: aastore
    //   103: invokestatic 109	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: goto -60 -> 46
    //   109: astore 4
    //   111: aconst_null
    //   112: astore_3
    //   113: aload_3
    //   114: astore_2
    //   115: ldc 76
    //   117: aload 4
    //   119: ldc 78
    //   121: iconst_0
    //   122: anewarray 4	java/lang/Object
    //   125: invokestatic 84	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: aload_3
    //   129: astore_2
    //   130: ldc 76
    //   132: ldc 142
    //   134: iconst_4
    //   135: anewarray 4	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: aload 4
    //   142: invokevirtual 90	java/lang/Object:getClass	()Ljava/lang/Class;
    //   145: invokevirtual 96	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   148: aastore
    //   149: dup
    //   150: iconst_1
    //   151: aload 4
    //   153: invokevirtual 112	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   156: aastore
    //   157: dup
    //   158: iconst_2
    //   159: aload_0
    //   160: aastore
    //   161: dup
    //   162: iconst_3
    //   163: aload_1
    //   164: arraylength
    //   165: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   168: aastore
    //   169: invokestatic 109	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: aload_3
    //   173: ifnull +7 -> 180
    //   176: aload_3
    //   177: invokevirtual 138	java/io/FileOutputStream:close	()V
    //   180: ldc 128
    //   182: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: iconst_m1
    //   186: ireturn
    //   187: astore_2
    //   188: ldc 76
    //   190: aload_2
    //   191: ldc 78
    //   193: iconst_0
    //   194: anewarray 4	java/lang/Object
    //   197: invokestatic 84	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   200: ldc 76
    //   202: ldc 140
    //   204: iconst_4
    //   205: anewarray 4	java/lang/Object
    //   208: dup
    //   209: iconst_0
    //   210: aload_2
    //   211: invokevirtual 90	java/lang/Object:getClass	()Ljava/lang/Class;
    //   214: invokevirtual 96	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   217: aastore
    //   218: dup
    //   219: iconst_1
    //   220: aload_2
    //   221: invokevirtual 99	java/io/IOException:getMessage	()Ljava/lang/String;
    //   224: aastore
    //   225: dup
    //   226: iconst_2
    //   227: aload_0
    //   228: aastore
    //   229: dup
    //   230: iconst_3
    //   231: aload_1
    //   232: arraylength
    //   233: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   236: aastore
    //   237: invokestatic 109	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   240: goto -60 -> 180
    //   243: astore_3
    //   244: aconst_null
    //   245: astore_2
    //   246: aload_2
    //   247: ifnull +7 -> 254
    //   250: aload_2
    //   251: invokevirtual 138	java/io/FileOutputStream:close	()V
    //   254: ldc 128
    //   256: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: aload_3
    //   260: athrow
    //   261: astore_2
    //   262: ldc 76
    //   264: aload_2
    //   265: ldc 78
    //   267: iconst_0
    //   268: anewarray 4	java/lang/Object
    //   271: invokestatic 84	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: ldc 76
    //   276: ldc 140
    //   278: iconst_4
    //   279: anewarray 4	java/lang/Object
    //   282: dup
    //   283: iconst_0
    //   284: aload_2
    //   285: invokevirtual 90	java/lang/Object:getClass	()Ljava/lang/Class;
    //   288: invokevirtual 96	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   291: aastore
    //   292: dup
    //   293: iconst_1
    //   294: aload_2
    //   295: invokevirtual 99	java/io/IOException:getMessage	()Ljava/lang/String;
    //   298: aastore
    //   299: dup
    //   300: iconst_2
    //   301: aload_0
    //   302: aastore
    //   303: dup
    //   304: iconst_3
    //   305: aload_1
    //   306: arraylength
    //   307: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   310: aastore
    //   311: invokestatic 109	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   314: goto -60 -> 254
    //   317: astore_3
    //   318: goto -72 -> 246
    //   321: astore 4
    //   323: goto -210 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	paramString	String
    //   0	326	1	paramArrayOfByte	byte[]
    //   33	1	2	localFileOutputStream1	java.io.FileOutputStream
    //   53	34	2	localIOException1	java.io.IOException
    //   114	16	2	localFileOutputStream2	java.io.FileOutputStream
    //   187	34	2	localIOException2	java.io.IOException
    //   245	6	2	localObject1	Object
    //   261	34	2	localIOException3	java.io.IOException
    //   31	146	3	localFileOutputStream3	java.io.FileOutputStream
    //   243	17	3	localObject2	Object
    //   317	1	3	localObject3	Object
    //   109	43	4	localException1	java.lang.Exception
    //   321	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   42	46	53	java/io/IOException
    //   22	32	109	java/lang/Exception
    //   176	180	187	java/io/IOException
    //   22	32	243	finally
    //   250	254	261	java/io/IOException
    //   34	42	317	finally
    //   115	128	317	finally
    //   130	172	317	finally
    //   34	42	321	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.d
 * JD-Core Version:    0.7.0.1
 */