package com.tencent.mm.sandbox.updater;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class d
{
  /* Error */
  private static String A(File paramFile)
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
    //   46: invokestatic 44	com/tencent/mm/b/g:e	(Ljava/io/InputStream;I)Ljava/lang/String;
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
  
  /* Error */
  public static int J(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 52
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnull +8 -> 14
    //   9: aload_1
    //   10: arraylength
    //   11: ifne +11 -> 22
    //   14: ldc 52
    //   16: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: bipush 254
    //   21: ireturn
    //   22: new 54	java/io/FileOutputStream
    //   25: dup
    //   26: aload_0
    //   27: iconst_1
    //   28: invokespecial 57	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   31: astore_3
    //   32: aload_3
    //   33: astore_2
    //   34: aload_3
    //   35: aload_1
    //   36: iconst_0
    //   37: aload_1
    //   38: arraylength
    //   39: invokevirtual 61	java/io/FileOutputStream:write	([BII)V
    //   42: aload_3
    //   43: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   46: ldc 52
    //   48: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: iconst_0
    //   52: ireturn
    //   53: astore_2
    //   54: ldc 64
    //   56: aload_2
    //   57: ldc 66
    //   59: iconst_0
    //   60: anewarray 4	java/lang/Object
    //   63: invokestatic 72	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: ldc 64
    //   68: ldc 74
    //   70: iconst_4
    //   71: anewarray 4	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: aload_2
    //   77: invokevirtual 78	java/lang/Object:getClass	()Ljava/lang/Class;
    //   80: invokevirtual 84	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   83: aastore
    //   84: dup
    //   85: iconst_1
    //   86: aload_2
    //   87: invokevirtual 87	java/io/IOException:getMessage	()Ljava/lang/String;
    //   90: aastore
    //   91: dup
    //   92: iconst_2
    //   93: aload_0
    //   94: aastore
    //   95: dup
    //   96: iconst_3
    //   97: aload_1
    //   98: arraylength
    //   99: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: aastore
    //   103: invokestatic 97	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: goto -60 -> 46
    //   109: astore 4
    //   111: aconst_null
    //   112: astore_3
    //   113: aload_3
    //   114: astore_2
    //   115: ldc 64
    //   117: aload 4
    //   119: ldc 66
    //   121: iconst_0
    //   122: anewarray 4	java/lang/Object
    //   125: invokestatic 72	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: aload_3
    //   129: astore_2
    //   130: ldc 64
    //   132: ldc 99
    //   134: iconst_4
    //   135: anewarray 4	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: aload 4
    //   142: invokevirtual 78	java/lang/Object:getClass	()Ljava/lang/Class;
    //   145: invokevirtual 84	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   148: aastore
    //   149: dup
    //   150: iconst_1
    //   151: aload 4
    //   153: invokevirtual 100	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   156: aastore
    //   157: dup
    //   158: iconst_2
    //   159: aload_0
    //   160: aastore
    //   161: dup
    //   162: iconst_3
    //   163: aload_1
    //   164: arraylength
    //   165: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   168: aastore
    //   169: invokestatic 97	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: aload_3
    //   173: ifnull +7 -> 180
    //   176: aload_3
    //   177: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   180: ldc 52
    //   182: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: iconst_m1
    //   186: ireturn
    //   187: astore_2
    //   188: ldc 64
    //   190: aload_2
    //   191: ldc 66
    //   193: iconst_0
    //   194: anewarray 4	java/lang/Object
    //   197: invokestatic 72	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   200: ldc 64
    //   202: ldc 74
    //   204: iconst_4
    //   205: anewarray 4	java/lang/Object
    //   208: dup
    //   209: iconst_0
    //   210: aload_2
    //   211: invokevirtual 78	java/lang/Object:getClass	()Ljava/lang/Class;
    //   214: invokevirtual 84	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   217: aastore
    //   218: dup
    //   219: iconst_1
    //   220: aload_2
    //   221: invokevirtual 87	java/io/IOException:getMessage	()Ljava/lang/String;
    //   224: aastore
    //   225: dup
    //   226: iconst_2
    //   227: aload_0
    //   228: aastore
    //   229: dup
    //   230: iconst_3
    //   231: aload_1
    //   232: arraylength
    //   233: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   236: aastore
    //   237: invokestatic 97	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   240: goto -60 -> 180
    //   243: astore_3
    //   244: aconst_null
    //   245: astore_2
    //   246: aload_2
    //   247: ifnull +7 -> 254
    //   250: aload_2
    //   251: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   254: ldc 52
    //   256: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: aload_3
    //   260: athrow
    //   261: astore_2
    //   262: ldc 64
    //   264: aload_2
    //   265: ldc 66
    //   267: iconst_0
    //   268: anewarray 4	java/lang/Object
    //   271: invokestatic 72	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: ldc 64
    //   276: ldc 74
    //   278: iconst_4
    //   279: anewarray 4	java/lang/Object
    //   282: dup
    //   283: iconst_0
    //   284: aload_2
    //   285: invokevirtual 78	java/lang/Object:getClass	()Ljava/lang/Class;
    //   288: invokevirtual 84	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   291: aastore
    //   292: dup
    //   293: iconst_1
    //   294: aload_2
    //   295: invokevirtual 87	java/io/IOException:getMessage	()Ljava/lang/String;
    //   298: aastore
    //   299: dup
    //   300: iconst_2
    //   301: aload_0
    //   302: aastore
    //   303: dup
    //   304: iconst_3
    //   305: aload_1
    //   306: arraylength
    //   307: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   310: aastore
    //   311: invokestatic 97	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public static final boolean bF(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(169809);
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null))
    {
      AppMethodBeat.o(169809);
      return false;
    }
    paramString2 = new File(paramString1 + paramString2);
    paramString1 = new File(paramString1 + paramString3);
    if (paramString2.exists())
    {
      boolean bool = paramString2.renameTo(paramString1);
      AppMethodBeat.o(169809);
      return bool;
    }
    AppMethodBeat.o(169809);
    return false;
  }
  
  public static int btZ(String paramString)
  {
    AppMethodBeat.i(169808);
    if (paramString == null)
    {
      AppMethodBeat.o(169808);
      return 0;
    }
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      AppMethodBeat.o(169808);
      return 0;
    }
    int i = (int)paramString.length();
    AppMethodBeat.o(169808);
    return i;
  }
  
  public static String bub(String paramString)
  {
    AppMethodBeat.i(169810);
    if (paramString == null)
    {
      AppMethodBeat.o(169810);
      return null;
    }
    paramString = new File(paramString);
    if (paramString.exists())
    {
      paramString = A(paramString);
      AppMethodBeat.o(169810);
      return paramString;
    }
    AppMethodBeat.o(169810);
    return null;
  }
  
  /* Error */
  public static int e(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: ldc 131
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnull +16 -> 22
    //   9: aload_1
    //   10: arraylength
    //   11: ifeq +11 -> 22
    //   14: aload_1
    //   15: arraylength
    //   16: iload_2
    //   17: iconst_0
    //   18: iadd
    //   19: if_icmpge +11 -> 30
    //   22: ldc 131
    //   24: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: bipush 254
    //   29: ireturn
    //   30: new 54	java/io/FileOutputStream
    //   33: dup
    //   34: aload_0
    //   35: iconst_1
    //   36: invokespecial 57	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   39: astore 4
    //   41: aload 4
    //   43: astore_3
    //   44: aload 4
    //   46: aload_1
    //   47: iconst_0
    //   48: iload_2
    //   49: invokevirtual 61	java/io/FileOutputStream:write	([BII)V
    //   52: aload 4
    //   54: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   57: ldc 131
    //   59: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: iconst_0
    //   63: ireturn
    //   64: astore_3
    //   65: ldc 64
    //   67: aload_3
    //   68: ldc 66
    //   70: iconst_0
    //   71: anewarray 4	java/lang/Object
    //   74: invokestatic 72	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   77: ldc 64
    //   79: ldc 133
    //   81: bipush 6
    //   83: anewarray 4	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: aload_3
    //   89: invokevirtual 78	java/lang/Object:getClass	()Ljava/lang/Class;
    //   92: invokevirtual 84	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   95: aastore
    //   96: dup
    //   97: iconst_1
    //   98: aload_3
    //   99: invokevirtual 87	java/io/IOException:getMessage	()Ljava/lang/String;
    //   102: aastore
    //   103: dup
    //   104: iconst_2
    //   105: aload_0
    //   106: aastore
    //   107: dup
    //   108: iconst_3
    //   109: aload_1
    //   110: arraylength
    //   111: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   114: aastore
    //   115: dup
    //   116: iconst_4
    //   117: iconst_0
    //   118: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   121: aastore
    //   122: dup
    //   123: iconst_5
    //   124: iload_2
    //   125: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   128: aastore
    //   129: invokestatic 97	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: goto -75 -> 57
    //   135: astore 5
    //   137: aconst_null
    //   138: astore 4
    //   140: aload 4
    //   142: astore_3
    //   143: ldc 64
    //   145: aload 5
    //   147: ldc 66
    //   149: iconst_0
    //   150: anewarray 4	java/lang/Object
    //   153: invokestatic 72	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   156: aload 4
    //   158: astore_3
    //   159: ldc 64
    //   161: ldc 135
    //   163: bipush 6
    //   165: anewarray 4	java/lang/Object
    //   168: dup
    //   169: iconst_0
    //   170: aload 5
    //   172: invokevirtual 78	java/lang/Object:getClass	()Ljava/lang/Class;
    //   175: invokevirtual 84	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   178: aastore
    //   179: dup
    //   180: iconst_1
    //   181: aload 5
    //   183: invokevirtual 100	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   186: aastore
    //   187: dup
    //   188: iconst_2
    //   189: aload_0
    //   190: aastore
    //   191: dup
    //   192: iconst_3
    //   193: aload_1
    //   194: arraylength
    //   195: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   198: aastore
    //   199: dup
    //   200: iconst_4
    //   201: iconst_0
    //   202: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   205: aastore
    //   206: dup
    //   207: iconst_5
    //   208: iload_2
    //   209: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: aastore
    //   213: invokestatic 97	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   216: aload 4
    //   218: ifnull +8 -> 226
    //   221: aload 4
    //   223: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   226: ldc 131
    //   228: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: iconst_m1
    //   232: ireturn
    //   233: astore_3
    //   234: ldc 64
    //   236: aload_3
    //   237: ldc 66
    //   239: iconst_0
    //   240: anewarray 4	java/lang/Object
    //   243: invokestatic 72	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   246: ldc 64
    //   248: ldc 133
    //   250: bipush 6
    //   252: anewarray 4	java/lang/Object
    //   255: dup
    //   256: iconst_0
    //   257: aload_3
    //   258: invokevirtual 78	java/lang/Object:getClass	()Ljava/lang/Class;
    //   261: invokevirtual 84	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   264: aastore
    //   265: dup
    //   266: iconst_1
    //   267: aload_3
    //   268: invokevirtual 87	java/io/IOException:getMessage	()Ljava/lang/String;
    //   271: aastore
    //   272: dup
    //   273: iconst_2
    //   274: aload_0
    //   275: aastore
    //   276: dup
    //   277: iconst_3
    //   278: aload_1
    //   279: arraylength
    //   280: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   283: aastore
    //   284: dup
    //   285: iconst_4
    //   286: iconst_0
    //   287: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   290: aastore
    //   291: dup
    //   292: iconst_5
    //   293: iload_2
    //   294: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   297: aastore
    //   298: invokestatic 97	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   301: goto -75 -> 226
    //   304: astore 4
    //   306: aconst_null
    //   307: astore_3
    //   308: aload_3
    //   309: ifnull +7 -> 316
    //   312: aload_3
    //   313: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   316: ldc 131
    //   318: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   321: aload 4
    //   323: athrow
    //   324: astore_3
    //   325: ldc 64
    //   327: aload_3
    //   328: ldc 66
    //   330: iconst_0
    //   331: anewarray 4	java/lang/Object
    //   334: invokestatic 72	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   337: ldc 64
    //   339: ldc 133
    //   341: bipush 6
    //   343: anewarray 4	java/lang/Object
    //   346: dup
    //   347: iconst_0
    //   348: aload_3
    //   349: invokevirtual 78	java/lang/Object:getClass	()Ljava/lang/Class;
    //   352: invokevirtual 84	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   355: aastore
    //   356: dup
    //   357: iconst_1
    //   358: aload_3
    //   359: invokevirtual 87	java/io/IOException:getMessage	()Ljava/lang/String;
    //   362: aastore
    //   363: dup
    //   364: iconst_2
    //   365: aload_0
    //   366: aastore
    //   367: dup
    //   368: iconst_3
    //   369: aload_1
    //   370: arraylength
    //   371: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   374: aastore
    //   375: dup
    //   376: iconst_4
    //   377: iconst_0
    //   378: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   381: aastore
    //   382: dup
    //   383: iconst_5
    //   384: iload_2
    //   385: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   388: aastore
    //   389: invokestatic 97	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   392: goto -76 -> 316
    //   395: astore 4
    //   397: goto -89 -> 308
    //   400: astore 5
    //   402: goto -262 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	405	0	paramString	String
    //   0	405	1	paramArrayOfByte	byte[]
    //   0	405	2	paramInt	int
    //   43	1	3	localFileOutputStream1	java.io.FileOutputStream
    //   64	35	3	localIOException1	java.io.IOException
    //   142	17	3	localFileOutputStream2	java.io.FileOutputStream
    //   233	35	3	localIOException2	java.io.IOException
    //   307	6	3	localObject1	Object
    //   324	35	3	localIOException3	java.io.IOException
    //   39	183	4	localFileOutputStream3	java.io.FileOutputStream
    //   304	18	4	localObject2	Object
    //   395	1	4	localObject3	Object
    //   135	47	5	localException1	java.lang.Exception
    //   400	1	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   52	57	64	java/io/IOException
    //   30	41	135	java/lang/Exception
    //   221	226	233	java/io/IOException
    //   30	41	304	finally
    //   312	316	324	java/io/IOException
    //   44	52	395	finally
    //   143	156	395	finally
    //   159	216	395	finally
    //   44	52	400	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.d
 * JD-Core Version:    0.7.0.1
 */