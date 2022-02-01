package org.apache.commons.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  public static final BigInteger LXQ;
  public static final BigInteger LXR;
  public static final BigInteger LXS;
  public static final BigInteger LXT;
  public static final BigInteger LXU;
  public static final BigInteger LXV;
  public static final BigInteger LXW;
  public static final File[] LXX;
  public static final BigInteger lee;
  
  static
  {
    AppMethodBeat.i(10328);
    BigInteger localBigInteger = BigInteger.valueOf(1024L);
    lee = localBigInteger;
    LXQ = localBigInteger.multiply(localBigInteger);
    LXR = lee.multiply(LXQ);
    LXS = lee.multiply(LXR);
    LXT = lee.multiply(LXS);
    LXU = lee.multiply(LXT);
    LXV = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(1152921504606846976L));
    LXW = lee.multiply(LXV);
    LXX = new File[0];
    AppMethodBeat.o(10328);
  }
  
  public static String CH(long paramLong)
  {
    AppMethodBeat.i(192460);
    Object localObject = BigInteger.valueOf(paramLong);
    if (((BigInteger)localObject).divide(LXU).compareTo(BigInteger.ZERO) > 0) {
      localObject = String.valueOf(((BigInteger)localObject).divide(LXU)) + " EB";
    }
    for (;;)
    {
      AppMethodBeat.o(192460);
      return localObject;
      if (((BigInteger)localObject).divide(LXT).compareTo(BigInteger.ZERO) > 0) {
        localObject = String.valueOf(((BigInteger)localObject).divide(LXT)) + " PB";
      } else if (((BigInteger)localObject).divide(LXS).compareTo(BigInteger.ZERO) > 0) {
        localObject = String.valueOf(((BigInteger)localObject).divide(LXS)) + " TB";
      } else if (((BigInteger)localObject).divide(LXR).compareTo(BigInteger.ZERO) > 0) {
        localObject = String.valueOf(((BigInteger)localObject).divide(LXR)) + " GB";
      } else if (((BigInteger)localObject).divide(LXQ).compareTo(BigInteger.ZERO) > 0) {
        localObject = String.valueOf(((BigInteger)localObject).divide(LXQ)) + " MB";
      } else if (((BigInteger)localObject).divide(lee).compareTo(BigInteger.ZERO) > 0) {
        localObject = String.valueOf(((BigInteger)localObject).divide(lee)) + " KB";
      } else {
        localObject = String.valueOf(localObject) + " bytes";
      }
    }
  }
  
  private static void a(File paramFile1, File paramFile2, FileFilter paramFileFilter, boolean paramBoolean, List<String> paramList)
  {
    AppMethodBeat.i(10325);
    if (paramFileFilter == null) {}
    for (File[] arrayOfFile = paramFile1.listFiles(); arrayOfFile == null; arrayOfFile = paramFile1.listFiles(paramFileFilter))
    {
      paramFile1 = new IOException("Failed to list contents of ".concat(String.valueOf(paramFile1)));
      AppMethodBeat.o(10325);
      throw paramFile1;
    }
    if (paramFile2.exists())
    {
      if (!paramFile2.isDirectory())
      {
        paramFile1 = new IOException("Destination '" + paramFile2 + "' exists but is not a directory");
        AppMethodBeat.o(10325);
        throw paramFile1;
      }
    }
    else if ((!paramFile2.mkdirs()) && (!paramFile2.isDirectory()))
    {
      paramFile1 = new IOException("Destination '" + paramFile2 + "' directory cannot be created");
      AppMethodBeat.o(10325);
      throw paramFile1;
    }
    if (!paramFile2.canWrite())
    {
      paramFile1 = new IOException("Destination '" + paramFile2 + "' cannot be written to");
      AppMethodBeat.o(10325);
      throw paramFile1;
    }
    int j = arrayOfFile.length;
    int i = 0;
    if (i < j)
    {
      File localFile1 = arrayOfFile[i];
      File localFile2 = new File(paramFile2, localFile1.getName());
      if ((paramList == null) || (!paramList.contains(localFile1.getCanonicalPath())))
      {
        if (!localFile1.isDirectory()) {
          break label287;
        }
        a(localFile1, localFile2, paramFileFilter, paramBoolean, paramList);
      }
      for (;;)
      {
        i += 1;
        break;
        label287:
        b(localFile1, localFile2, paramBoolean);
      }
    }
    if (paramBoolean) {
      paramFile2.setLastModified(paramFile1.lastModified());
    }
    AppMethodBeat.o(10325);
  }
  
  public static long an(File paramFile)
  {
    AppMethodBeat.i(192461);
    if (!paramFile.exists())
    {
      paramFile = new IllegalArgumentException(paramFile + " does not exist");
      AppMethodBeat.o(192461);
      throw paramFile;
    }
    if (!paramFile.isDirectory())
    {
      paramFile = new IllegalArgumentException(paramFile + " is not a directory");
      AppMethodBeat.o(192461);
      throw paramFile;
    }
    long l = ao(paramFile);
    AppMethodBeat.o(192461);
    return l;
  }
  
  private static long ao(File paramFile)
  {
    AppMethodBeat.i(192462);
    paramFile = paramFile.listFiles();
    if (paramFile == null)
    {
      AppMethodBeat.o(192462);
      return 0L;
    }
    int j = paramFile.length;
    int i = 0;
    long l1 = 0L;
    long l2;
    for (;;)
    {
      l2 = l1;
      NullPointerException localNullPointerException;
      if (i < j)
      {
        localNullPointerException = paramFile[i];
        if (localNullPointerException != null) {}
      }
      try
      {
        localNullPointerException = new NullPointerException("File must not be null");
        AppMethodBeat.o(192462);
        throw localNullPointerException;
      }
      catch (IOException localIOException)
      {
        l2 = l1;
        i += 1;
        l1 = l2;
      }
      l2 = l1;
      if (!Files.isSymbolicLink(localNullPointerException.toPath()))
      {
        if (localNullPointerException.isDirectory()) {}
        for (l2 = ao(localNullPointerException);; l2 = localNullPointerException.length())
        {
          l1 += l2;
          l2 = l1;
          if (l1 >= 0L) {
            break;
          }
          l2 = l1;
          AppMethodBeat.o(192462);
          return l2;
        }
      }
    }
  }
  
  /* Error */
  private static void b(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    // Byte code:
    //   0: sipush 10322
    //   3: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokevirtual 130	java/io/File:exists	()Z
    //   10: ifeq +47 -> 57
    //   13: aload_1
    //   14: invokevirtual 133	java/io/File:isDirectory	()Z
    //   17: ifeq +40 -> 57
    //   20: new 114	java/io/IOException
    //   23: dup
    //   24: new 76	java/lang/StringBuilder
    //   27: dup
    //   28: ldc 135
    //   30: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: aload_1
    //   34: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   37: ldc 218
    //   39: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 123	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   48: astore_0
    //   49: sipush 10322
    //   52: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aload_0
    //   56: athrow
    //   57: new 220	java/io/FileInputStream
    //   60: dup
    //   61: aload_0
    //   62: invokespecial 223	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   65: astore 11
    //   67: aload 11
    //   69: invokevirtual 227	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   72: astore 12
    //   74: new 229	java/io/FileOutputStream
    //   77: dup
    //   78: aload_1
    //   79: invokespecial 230	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   82: astore 13
    //   84: aload 13
    //   86: invokevirtual 231	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   89: astore 14
    //   91: aload 12
    //   93: invokevirtual 236	java/nio/channels/FileChannel:size	()J
    //   96: lstore 9
    //   98: lconst_0
    //   99: lstore_3
    //   100: goto +359 -> 459
    //   103: aload 14
    //   105: aload 12
    //   107: lload_3
    //   108: lload 5
    //   110: invokevirtual 240	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   113: lstore 5
    //   115: lload 5
    //   117: lconst_0
    //   118: lcmp
    //   119: ifeq +11 -> 130
    //   122: lload_3
    //   123: lload 5
    //   125: ladd
    //   126: lstore_3
    //   127: goto +332 -> 459
    //   130: aload 14
    //   132: ifnull +8 -> 140
    //   135: aload 14
    //   137: invokevirtual 243	java/nio/channels/FileChannel:close	()V
    //   140: aload 13
    //   142: invokevirtual 244	java/io/FileOutputStream:close	()V
    //   145: aload 12
    //   147: ifnull +8 -> 155
    //   150: aload 12
    //   152: invokevirtual 243	java/nio/channels/FileChannel:close	()V
    //   155: aload 11
    //   157: invokevirtual 245	java/io/FileInputStream:close	()V
    //   160: aload_0
    //   161: invokevirtual 214	java/io/File:length	()J
    //   164: lstore_3
    //   165: aload_1
    //   166: invokevirtual 214	java/io/File:length	()J
    //   169: lstore 5
    //   171: lload_3
    //   172: lload 5
    //   174: lcmp
    //   175: ifeq +258 -> 433
    //   178: new 114	java/io/IOException
    //   181: dup
    //   182: new 76	java/lang/StringBuilder
    //   185: dup
    //   186: ldc 247
    //   188: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   191: aload_0
    //   192: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   195: ldc 249
    //   197: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload_1
    //   201: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   204: ldc 251
    //   206: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: lload_3
    //   210: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   213: ldc_w 256
    //   216: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: lload 5
    //   221: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   224: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokespecial 123	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   230: astore_0
    //   231: sipush 10322
    //   234: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: aload_0
    //   238: athrow
    //   239: astore_1
    //   240: sipush 10322
    //   243: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: aload_1
    //   247: athrow
    //   248: astore_0
    //   249: aload 14
    //   251: ifnull +12 -> 263
    //   254: aload_1
    //   255: ifnull +113 -> 368
    //   258: aload 14
    //   260: invokevirtual 243	java/nio/channels/FileChannel:close	()V
    //   263: sipush 10322
    //   266: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   269: aload_0
    //   270: athrow
    //   271: astore_1
    //   272: sipush 10322
    //   275: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   278: aload_1
    //   279: athrow
    //   280: astore_0
    //   281: aload_1
    //   282: ifnull +105 -> 387
    //   285: aload 13
    //   287: invokevirtual 244	java/io/FileOutputStream:close	()V
    //   290: sipush 10322
    //   293: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   296: aload_0
    //   297: athrow
    //   298: astore_1
    //   299: sipush 10322
    //   302: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   305: aload_1
    //   306: athrow
    //   307: astore_0
    //   308: aload 12
    //   310: ifnull +12 -> 322
    //   313: aload_1
    //   314: ifnull +92 -> 406
    //   317: aload 12
    //   319: invokevirtual 243	java/nio/channels/FileChannel:close	()V
    //   322: sipush 10322
    //   325: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   328: aload_0
    //   329: athrow
    //   330: astore_1
    //   331: sipush 10322
    //   334: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   337: aload_1
    //   338: athrow
    //   339: astore_0
    //   340: aload_1
    //   341: ifnull +84 -> 425
    //   344: aload 11
    //   346: invokevirtual 245	java/io/FileInputStream:close	()V
    //   349: sipush 10322
    //   352: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   355: aload_0
    //   356: athrow
    //   357: astore 14
    //   359: aload_1
    //   360: aload 14
    //   362: invokevirtual 260	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   365: goto -102 -> 263
    //   368: aload 14
    //   370: invokevirtual 243	java/nio/channels/FileChannel:close	()V
    //   373: goto -110 -> 263
    //   376: astore 13
    //   378: aload_1
    //   379: aload 13
    //   381: invokevirtual 260	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   384: goto -94 -> 290
    //   387: aload 13
    //   389: invokevirtual 244	java/io/FileOutputStream:close	()V
    //   392: goto -102 -> 290
    //   395: astore 12
    //   397: aload_1
    //   398: aload 12
    //   400: invokevirtual 260	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   403: goto -81 -> 322
    //   406: aload 12
    //   408: invokevirtual 243	java/nio/channels/FileChannel:close	()V
    //   411: goto -89 -> 322
    //   414: astore 11
    //   416: aload_1
    //   417: aload 11
    //   419: invokevirtual 260	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   422: goto -73 -> 349
    //   425: aload 11
    //   427: invokevirtual 245	java/io/FileInputStream:close	()V
    //   430: goto -81 -> 349
    //   433: iload_2
    //   434: ifeq +12 -> 446
    //   437: aload_1
    //   438: aload_0
    //   439: invokevirtual 176	java/io/File:lastModified	()J
    //   442: invokevirtual 180	java/io/File:setLastModified	(J)Z
    //   445: pop
    //   446: sipush 10322
    //   449: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   452: return
    //   453: astore_0
    //   454: aconst_null
    //   455: astore_1
    //   456: goto -207 -> 249
    //   459: lload_3
    //   460: lload 9
    //   462: lcmp
    //   463: ifge -333 -> 130
    //   466: lload 9
    //   468: lload_3
    //   469: lsub
    //   470: lstore 7
    //   472: lload 7
    //   474: lstore 5
    //   476: lload 7
    //   478: ldc2_w 261
    //   481: lcmp
    //   482: ifle -379 -> 103
    //   485: ldc2_w 261
    //   488: lstore 5
    //   490: goto -387 -> 103
    //   493: astore_0
    //   494: aconst_null
    //   495: astore_1
    //   496: goto -215 -> 281
    //   499: astore_0
    //   500: aconst_null
    //   501: astore_1
    //   502: goto -194 -> 308
    //   505: astore_0
    //   506: aconst_null
    //   507: astore_1
    //   508: goto -168 -> 340
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	511	0	paramFile1	File
    //   0	511	1	paramFile2	File
    //   0	511	2	paramBoolean	boolean
    //   99	370	3	l1	long
    //   108	1	5	localObject	Object
    //   113	376	5	l2	long
    //   470	7	7	l3	long
    //   96	371	9	l4	long
    //   65	280	11	localFileInputStream	java.io.FileInputStream
    //   414	12	11	localThrowable1	java.lang.Throwable
    //   72	246	12	localFileChannel1	java.nio.channels.FileChannel
    //   395	12	12	localThrowable2	java.lang.Throwable
    //   82	204	13	localFileOutputStream	java.io.FileOutputStream
    //   376	12	13	localThrowable3	java.lang.Throwable
    //   89	170	14	localFileChannel2	java.nio.channels.FileChannel
    //   357	12	14	localThrowable4	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   91	98	239	java/lang/Throwable
    //   103	115	239	java/lang/Throwable
    //   240	248	248	finally
    //   84	91	271	java/lang/Throwable
    //   135	140	271	java/lang/Throwable
    //   263	271	271	java/lang/Throwable
    //   359	365	271	java/lang/Throwable
    //   368	373	271	java/lang/Throwable
    //   272	280	280	finally
    //   74	84	298	java/lang/Throwable
    //   140	145	298	java/lang/Throwable
    //   290	298	298	java/lang/Throwable
    //   378	384	298	java/lang/Throwable
    //   387	392	298	java/lang/Throwable
    //   299	307	307	finally
    //   67	74	330	java/lang/Throwable
    //   150	155	330	java/lang/Throwable
    //   322	330	330	java/lang/Throwable
    //   397	403	330	java/lang/Throwable
    //   406	411	330	java/lang/Throwable
    //   331	339	339	finally
    //   258	263	357	java/lang/Throwable
    //   285	290	376	java/lang/Throwable
    //   317	322	395	java/lang/Throwable
    //   344	349	414	java/lang/Throwable
    //   91	98	453	finally
    //   103	115	453	finally
    //   84	91	493	finally
    //   135	140	493	finally
    //   258	263	493	finally
    //   263	271	493	finally
    //   359	365	493	finally
    //   368	373	493	finally
    //   74	84	499	finally
    //   140	145	499	finally
    //   285	290	499	finally
    //   290	298	499	finally
    //   378	384	499	finally
    //   387	392	499	finally
    //   67	74	505	finally
    //   150	155	505	finally
    //   317	322	505	finally
    //   322	330	505	finally
    //   397	403	505	finally
    //   406	411	505	finally
  }
  
  /* Error */
  public static void c(java.io.InputStream paramInputStream, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: sipush 10326
    //   5: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: invokevirtual 130	java/io/File:exists	()Z
    //   12: ifeq +153 -> 165
    //   15: aload_1
    //   16: invokevirtual 133	java/io/File:isDirectory	()Z
    //   19: ifeq +101 -> 120
    //   22: new 114	java/io/IOException
    //   25: dup
    //   26: new 76	java/lang/StringBuilder
    //   29: dup
    //   30: ldc_w 266
    //   33: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   36: aload_1
    //   37: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: ldc 218
    //   42: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokespecial 123	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   51: astore_1
    //   52: sipush 10326
    //   55: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_1
    //   59: athrow
    //   60: astore_2
    //   61: sipush 10326
    //   64: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aload_2
    //   68: athrow
    //   69: astore_1
    //   70: aload_0
    //   71: ifnull +11 -> 82
    //   74: aload_2
    //   75: ifnull +255 -> 330
    //   78: aload_0
    //   79: invokevirtual 269	java/io/InputStream:close	()V
    //   82: sipush 10326
    //   85: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aload_1
    //   89: athrow
    //   90: astore_2
    //   91: sipush 10326
    //   94: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_2
    //   98: athrow
    //   99: astore_1
    //   100: aload_0
    //   101: ifnull +11 -> 112
    //   104: aload_2
    //   105: ifnull +241 -> 346
    //   108: aload_0
    //   109: invokevirtual 269	java/io/InputStream:close	()V
    //   112: sipush 10326
    //   115: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_1
    //   119: athrow
    //   120: aload_1
    //   121: invokevirtual 149	java/io/File:canWrite	()Z
    //   124: ifne +103 -> 227
    //   127: new 114	java/io/IOException
    //   130: dup
    //   131: new 76	java/lang/StringBuilder
    //   134: dup
    //   135: ldc_w 266
    //   138: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   141: aload_1
    //   142: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   145: ldc 151
    //   147: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokespecial 123	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   156: astore_1
    //   157: sipush 10326
    //   160: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload_1
    //   164: athrow
    //   165: aload_1
    //   166: invokevirtual 273	java/io/File:getParentFile	()Ljava/io/File;
    //   169: astore_2
    //   170: aload_2
    //   171: ifnull +56 -> 227
    //   174: aload_2
    //   175: invokevirtual 144	java/io/File:mkdirs	()Z
    //   178: ifne +49 -> 227
    //   181: aload_2
    //   182: invokevirtual 133	java/io/File:isDirectory	()Z
    //   185: ifne +42 -> 227
    //   188: new 114	java/io/IOException
    //   191: dup
    //   192: new 76	java/lang/StringBuilder
    //   195: dup
    //   196: ldc_w 275
    //   199: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   202: aload_2
    //   203: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   206: ldc_w 277
    //   209: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokespecial 123	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   218: astore_1
    //   219: sipush 10326
    //   222: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   225: aload_1
    //   226: athrow
    //   227: new 229	java/io/FileOutputStream
    //   230: dup
    //   231: aload_1
    //   232: iconst_0
    //   233: invokespecial 280	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   236: astore 4
    //   238: aload_0
    //   239: aload 4
    //   241: invokestatic 286	org/apache/commons/a/e:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   244: pop
    //   245: aload 4
    //   247: invokevirtual 289	java/io/OutputStream:close	()V
    //   250: aload_0
    //   251: ifnull +7 -> 258
    //   254: aload_0
    //   255: invokevirtual 269	java/io/InputStream:close	()V
    //   258: aload_0
    //   259: ifnull +94 -> 353
    //   262: aload_0
    //   263: invokevirtual 269	java/io/InputStream:close	()V
    //   266: sipush 10326
    //   269: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   272: return
    //   273: astore_2
    //   274: sipush 10326
    //   277: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: aload_2
    //   281: athrow
    //   282: astore_1
    //   283: aload_2
    //   284: ifnull +27 -> 311
    //   287: aload 4
    //   289: invokevirtual 289	java/io/OutputStream:close	()V
    //   292: sipush 10326
    //   295: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   298: aload_1
    //   299: athrow
    //   300: astore 4
    //   302: aload_2
    //   303: aload 4
    //   305: invokevirtual 260	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   308: goto -16 -> 292
    //   311: aload 4
    //   313: invokevirtual 289	java/io/OutputStream:close	()V
    //   316: goto -24 -> 292
    //   319: astore 4
    //   321: aload_2
    //   322: aload 4
    //   324: invokevirtual 260	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   327: goto -245 -> 82
    //   330: aload_0
    //   331: invokevirtual 269	java/io/InputStream:close	()V
    //   334: goto -252 -> 82
    //   337: astore_0
    //   338: aload_2
    //   339: aload_0
    //   340: invokevirtual 260	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   343: goto -231 -> 112
    //   346: aload_0
    //   347: invokevirtual 269	java/io/InputStream:close	()V
    //   350: goto -238 -> 112
    //   353: sipush 10326
    //   356: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   359: return
    //   360: astore_1
    //   361: aconst_null
    //   362: astore_2
    //   363: goto -80 -> 283
    //   366: astore_1
    //   367: aconst_null
    //   368: astore_2
    //   369: goto -299 -> 70
    //   372: astore_1
    //   373: aload_3
    //   374: astore_2
    //   375: goto -275 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	378	0	paramInputStream	java.io.InputStream
    //   0	378	1	paramFile	File
    //   60	15	2	localThrowable1	java.lang.Throwable
    //   90	15	2	localThrowable2	java.lang.Throwable
    //   169	34	2	localFile	File
    //   273	66	2	localThrowable3	java.lang.Throwable
    //   362	13	2	localObject1	Object
    //   1	373	3	localObject2	Object
    //   236	52	4	localFileOutputStream	java.io.FileOutputStream
    //   300	12	4	localThrowable4	java.lang.Throwable
    //   319	4	4	localThrowable5	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   8	60	60	java/lang/Throwable
    //   120	165	60	java/lang/Throwable
    //   165	170	60	java/lang/Throwable
    //   174	227	60	java/lang/Throwable
    //   227	238	60	java/lang/Throwable
    //   245	250	60	java/lang/Throwable
    //   292	300	60	java/lang/Throwable
    //   302	308	60	java/lang/Throwable
    //   311	316	60	java/lang/Throwable
    //   61	69	69	finally
    //   82	90	90	java/lang/Throwable
    //   254	258	90	java/lang/Throwable
    //   321	327	90	java/lang/Throwable
    //   330	334	90	java/lang/Throwable
    //   91	99	99	finally
    //   238	245	273	java/lang/Throwable
    //   274	282	282	finally
    //   287	292	300	java/lang/Throwable
    //   78	82	319	java/lang/Throwable
    //   108	112	337	java/lang/Throwable
    //   238	245	360	finally
    //   8	60	366	finally
    //   120	165	366	finally
    //   165	170	366	finally
    //   174	227	366	finally
    //   227	238	366	finally
    //   245	250	366	finally
    //   287	292	366	finally
    //   292	300	366	finally
    //   302	308	366	finally
    //   311	316	366	finally
    //   78	82	372	finally
    //   82	90	372	finally
    //   254	258	372	finally
    //   321	327	372	finally
    //   330	334	372	finally
  }
  
  public static void h(File paramFile1, File paramFile2)
  {
    AppMethodBeat.i(10324);
    if (!paramFile1.exists())
    {
      paramFile1 = new FileNotFoundException("Source '" + paramFile1 + "' does not exist");
      AppMethodBeat.o(10324);
      throw paramFile1;
    }
    if (!paramFile1.isDirectory())
    {
      paramFile1 = new IOException("Source '" + paramFile1 + "' exists but is not a directory");
      AppMethodBeat.o(10324);
      throw paramFile1;
    }
    if (paramFile1.getCanonicalPath().equals(paramFile2.getCanonicalPath()))
    {
      paramFile1 = new IOException("Source '" + paramFile1 + "' and destination '" + paramFile2 + "' are the same");
      AppMethodBeat.o(10324);
      throw paramFile1;
    }
    if (paramFile2.getCanonicalPath().startsWith(paramFile1.getCanonicalPath()))
    {
      File[] arrayOfFile = paramFile1.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        ArrayList localArrayList2 = new ArrayList(arrayOfFile.length);
        int j = arrayOfFile.length;
        int i = 0;
        for (;;)
        {
          localArrayList1 = localArrayList2;
          if (i >= j) {
            break;
          }
          localArrayList2.add(new File(paramFile2, arrayOfFile[i].getName()).getCanonicalPath());
          i += 1;
        }
      }
    }
    ArrayList localArrayList1 = null;
    a(paramFile1, paramFile2, null, true, localArrayList1);
    AppMethodBeat.o(10324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     org.apache.commons.a.c
 * JD-Core Version:    0.7.0.1
 */