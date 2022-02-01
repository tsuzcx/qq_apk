package org.apache.commons.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  public static final BigInteger NSp;
  public static final BigInteger NSq;
  public static final BigInteger NSr;
  public static final BigInteger NSs;
  public static final BigInteger NSt;
  public static final BigInteger NSu;
  public static final BigInteger NSv;
  public static final File[] NSw;
  public static final BigInteger lBe;
  
  static
  {
    AppMethodBeat.i(10328);
    BigInteger localBigInteger = BigInteger.valueOf(1024L);
    lBe = localBigInteger;
    NSp = localBigInteger.multiply(localBigInteger);
    NSq = lBe.multiply(NSp);
    NSr = lBe.multiply(NSq);
    NSs = lBe.multiply(NSr);
    NSt = lBe.multiply(NSs);
    NSu = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(1152921504606846976L));
    NSv = lBe.multiply(NSu);
    NSw = new File[0];
    AppMethodBeat.o(10328);
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
  
  /* Error */
  private static void b(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    // Byte code:
    //   0: sipush 10322
    //   3: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokevirtual 91	java/io/File:exists	()Z
    //   10: ifeq +47 -> 57
    //   13: aload_1
    //   14: invokevirtual 94	java/io/File:isDirectory	()Z
    //   17: ifeq +40 -> 57
    //   20: new 69	java/io/IOException
    //   23: dup
    //   24: new 96	java/lang/StringBuilder
    //   27: dup
    //   28: ldc 98
    //   30: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: aload_1
    //   34: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   37: ldc 157
    //   39: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 84	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   48: astore_0
    //   49: sipush 10322
    //   52: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aload_0
    //   56: athrow
    //   57: new 159	java/io/FileInputStream
    //   60: dup
    //   61: aload_0
    //   62: invokespecial 162	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   65: astore 11
    //   67: aload 11
    //   69: invokevirtual 166	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   72: astore 12
    //   74: new 168	java/io/FileOutputStream
    //   77: dup
    //   78: aload_1
    //   79: invokespecial 169	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   82: astore 13
    //   84: aload 13
    //   86: invokevirtual 170	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   89: astore 14
    //   91: aload 12
    //   93: invokevirtual 175	java/nio/channels/FileChannel:size	()J
    //   96: lstore 9
    //   98: lconst_0
    //   99: lstore_3
    //   100: goto +358 -> 458
    //   103: aload 14
    //   105: aload 12
    //   107: lload_3
    //   108: lload 5
    //   110: invokevirtual 179	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   113: lstore 5
    //   115: lload 5
    //   117: lconst_0
    //   118: lcmp
    //   119: ifeq +11 -> 130
    //   122: lload_3
    //   123: lload 5
    //   125: ladd
    //   126: lstore_3
    //   127: goto +331 -> 458
    //   130: aload 14
    //   132: ifnull +8 -> 140
    //   135: aload 14
    //   137: invokevirtual 182	java/nio/channels/FileChannel:close	()V
    //   140: aload 13
    //   142: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   145: aload 12
    //   147: ifnull +8 -> 155
    //   150: aload 12
    //   152: invokevirtual 182	java/nio/channels/FileChannel:close	()V
    //   155: aload 11
    //   157: invokevirtual 184	java/io/FileInputStream:close	()V
    //   160: aload_0
    //   161: invokevirtual 187	java/io/File:length	()J
    //   164: lstore_3
    //   165: aload_1
    //   166: invokevirtual 187	java/io/File:length	()J
    //   169: lstore 5
    //   171: lload_3
    //   172: lload 5
    //   174: lcmp
    //   175: ifeq +257 -> 432
    //   178: new 69	java/io/IOException
    //   181: dup
    //   182: new 96	java/lang/StringBuilder
    //   185: dup
    //   186: ldc 189
    //   188: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   191: aload_0
    //   192: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   195: ldc 191
    //   197: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload_1
    //   201: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   204: ldc 193
    //   206: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: lload_3
    //   210: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   213: ldc 198
    //   215: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: lload 5
    //   220: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   223: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokespecial 84	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   229: astore_0
    //   230: sipush 10322
    //   233: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: aload_0
    //   237: athrow
    //   238: astore_1
    //   239: sipush 10322
    //   242: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   245: aload_1
    //   246: athrow
    //   247: astore_0
    //   248: aload 14
    //   250: ifnull +12 -> 262
    //   253: aload_1
    //   254: ifnull +113 -> 367
    //   257: aload 14
    //   259: invokevirtual 182	java/nio/channels/FileChannel:close	()V
    //   262: sipush 10322
    //   265: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: aload_0
    //   269: athrow
    //   270: astore_1
    //   271: sipush 10322
    //   274: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   277: aload_1
    //   278: athrow
    //   279: astore_0
    //   280: aload_1
    //   281: ifnull +105 -> 386
    //   284: aload 13
    //   286: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   289: sipush 10322
    //   292: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   295: aload_0
    //   296: athrow
    //   297: astore_1
    //   298: sipush 10322
    //   301: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   304: aload_1
    //   305: athrow
    //   306: astore_0
    //   307: aload 12
    //   309: ifnull +12 -> 321
    //   312: aload_1
    //   313: ifnull +92 -> 405
    //   316: aload 12
    //   318: invokevirtual 182	java/nio/channels/FileChannel:close	()V
    //   321: sipush 10322
    //   324: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   327: aload_0
    //   328: athrow
    //   329: astore_1
    //   330: sipush 10322
    //   333: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   336: aload_1
    //   337: athrow
    //   338: astore_0
    //   339: aload_1
    //   340: ifnull +84 -> 424
    //   343: aload 11
    //   345: invokevirtual 184	java/io/FileInputStream:close	()V
    //   348: sipush 10322
    //   351: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   354: aload_0
    //   355: athrow
    //   356: astore 14
    //   358: aload_1
    //   359: aload 14
    //   361: invokevirtual 202	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   364: goto -102 -> 262
    //   367: aload 14
    //   369: invokevirtual 182	java/nio/channels/FileChannel:close	()V
    //   372: goto -110 -> 262
    //   375: astore 13
    //   377: aload_1
    //   378: aload 13
    //   380: invokevirtual 202	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   383: goto -94 -> 289
    //   386: aload 13
    //   388: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   391: goto -102 -> 289
    //   394: astore 12
    //   396: aload_1
    //   397: aload 12
    //   399: invokevirtual 202	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   402: goto -81 -> 321
    //   405: aload 12
    //   407: invokevirtual 182	java/nio/channels/FileChannel:close	()V
    //   410: goto -89 -> 321
    //   413: astore 11
    //   415: aload_1
    //   416: aload 11
    //   418: invokevirtual 202	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   421: goto -73 -> 348
    //   424: aload 11
    //   426: invokevirtual 184	java/io/FileInputStream:close	()V
    //   429: goto -81 -> 348
    //   432: iload_2
    //   433: ifeq +12 -> 445
    //   436: aload_1
    //   437: aload_0
    //   438: invokevirtual 147	java/io/File:lastModified	()J
    //   441: invokevirtual 151	java/io/File:setLastModified	(J)Z
    //   444: pop
    //   445: sipush 10322
    //   448: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   451: return
    //   452: astore_0
    //   453: aconst_null
    //   454: astore_1
    //   455: goto -207 -> 248
    //   458: lload_3
    //   459: lload 9
    //   461: lcmp
    //   462: ifge -332 -> 130
    //   465: lload 9
    //   467: lload_3
    //   468: lsub
    //   469: lstore 7
    //   471: lload 7
    //   473: lstore 5
    //   475: lload 7
    //   477: ldc2_w 203
    //   480: lcmp
    //   481: ifle -378 -> 103
    //   484: ldc2_w 203
    //   487: lstore 5
    //   489: goto -386 -> 103
    //   492: astore_0
    //   493: aconst_null
    //   494: astore_1
    //   495: goto -215 -> 280
    //   498: astore_0
    //   499: aconst_null
    //   500: astore_1
    //   501: goto -194 -> 307
    //   504: astore_0
    //   505: aconst_null
    //   506: astore_1
    //   507: goto -168 -> 339
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	510	0	paramFile1	File
    //   0	510	1	paramFile2	File
    //   0	510	2	paramBoolean	boolean
    //   99	369	3	l1	long
    //   108	1	5	localObject	Object
    //   113	375	5	l2	long
    //   469	7	7	l3	long
    //   96	370	9	l4	long
    //   65	279	11	localFileInputStream	java.io.FileInputStream
    //   413	12	11	localThrowable1	java.lang.Throwable
    //   72	245	12	localFileChannel1	java.nio.channels.FileChannel
    //   394	12	12	localThrowable2	java.lang.Throwable
    //   82	203	13	localFileOutputStream	java.io.FileOutputStream
    //   375	12	13	localThrowable3	java.lang.Throwable
    //   89	169	14	localFileChannel2	java.nio.channels.FileChannel
    //   356	12	14	localThrowable4	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   91	98	238	java/lang/Throwable
    //   103	115	238	java/lang/Throwable
    //   239	247	247	finally
    //   84	91	270	java/lang/Throwable
    //   135	140	270	java/lang/Throwable
    //   262	270	270	java/lang/Throwable
    //   358	364	270	java/lang/Throwable
    //   367	372	270	java/lang/Throwable
    //   271	279	279	finally
    //   74	84	297	java/lang/Throwable
    //   140	145	297	java/lang/Throwable
    //   289	297	297	java/lang/Throwable
    //   377	383	297	java/lang/Throwable
    //   386	391	297	java/lang/Throwable
    //   298	306	306	finally
    //   67	74	329	java/lang/Throwable
    //   150	155	329	java/lang/Throwable
    //   321	329	329	java/lang/Throwable
    //   396	402	329	java/lang/Throwable
    //   405	410	329	java/lang/Throwable
    //   330	338	338	finally
    //   257	262	356	java/lang/Throwable
    //   284	289	375	java/lang/Throwable
    //   316	321	394	java/lang/Throwable
    //   343	348	413	java/lang/Throwable
    //   91	98	452	finally
    //   103	115	452	finally
    //   84	91	492	finally
    //   135	140	492	finally
    //   257	262	492	finally
    //   262	270	492	finally
    //   358	364	492	finally
    //   367	372	492	finally
    //   74	84	498	finally
    //   140	145	498	finally
    //   284	289	498	finally
    //   289	297	498	finally
    //   377	383	498	finally
    //   386	391	498	finally
    //   67	74	504	finally
    //   150	155	504	finally
    //   316	321	504	finally
    //   321	329	504	finally
    //   396	402	504	finally
    //   405	410	504	finally
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
    //   9: invokevirtual 91	java/io/File:exists	()Z
    //   12: ifeq +151 -> 163
    //   15: aload_1
    //   16: invokevirtual 94	java/io/File:isDirectory	()Z
    //   19: ifeq +100 -> 119
    //   22: new 69	java/io/IOException
    //   25: dup
    //   26: new 96	java/lang/StringBuilder
    //   29: dup
    //   30: ldc 208
    //   32: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   35: aload_1
    //   36: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   39: ldc 157
    //   41: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokespecial 84	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   50: astore_1
    //   51: sipush 10326
    //   54: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_1
    //   58: athrow
    //   59: astore_2
    //   60: sipush 10326
    //   63: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_2
    //   67: athrow
    //   68: astore_1
    //   69: aload_0
    //   70: ifnull +11 -> 81
    //   73: aload_2
    //   74: ifnull +252 -> 326
    //   77: aload_0
    //   78: invokevirtual 211	java/io/InputStream:close	()V
    //   81: sipush 10326
    //   84: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload_1
    //   88: athrow
    //   89: astore_2
    //   90: sipush 10326
    //   93: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aload_2
    //   97: athrow
    //   98: astore_1
    //   99: aload_0
    //   100: ifnull +11 -> 111
    //   103: aload_2
    //   104: ifnull +238 -> 342
    //   107: aload_0
    //   108: invokevirtual 211	java/io/InputStream:close	()V
    //   111: sipush 10326
    //   114: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload_1
    //   118: athrow
    //   119: aload_1
    //   120: invokevirtual 120	java/io/File:canWrite	()Z
    //   123: ifne +100 -> 223
    //   126: new 69	java/io/IOException
    //   129: dup
    //   130: new 96	java/lang/StringBuilder
    //   133: dup
    //   134: ldc 208
    //   136: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   139: aload_1
    //   140: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   143: ldc 122
    //   145: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokespecial 84	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   154: astore_1
    //   155: sipush 10326
    //   158: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: aload_1
    //   162: athrow
    //   163: aload_1
    //   164: invokevirtual 215	java/io/File:getParentFile	()Ljava/io/File;
    //   167: astore_2
    //   168: aload_2
    //   169: ifnull +54 -> 223
    //   172: aload_2
    //   173: invokevirtual 115	java/io/File:mkdirs	()Z
    //   176: ifne +47 -> 223
    //   179: aload_2
    //   180: invokevirtual 94	java/io/File:isDirectory	()Z
    //   183: ifne +40 -> 223
    //   186: new 69	java/io/IOException
    //   189: dup
    //   190: new 96	java/lang/StringBuilder
    //   193: dup
    //   194: ldc 217
    //   196: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   199: aload_2
    //   200: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   203: ldc 219
    //   205: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokespecial 84	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   214: astore_1
    //   215: sipush 10326
    //   218: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aload_1
    //   222: athrow
    //   223: new 168	java/io/FileOutputStream
    //   226: dup
    //   227: aload_1
    //   228: iconst_0
    //   229: invokespecial 222	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   232: astore 4
    //   234: aload_0
    //   235: aload 4
    //   237: invokestatic 228	org/apache/commons/a/e:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   240: pop
    //   241: aload 4
    //   243: invokevirtual 231	java/io/OutputStream:close	()V
    //   246: aload_0
    //   247: ifnull +7 -> 254
    //   250: aload_0
    //   251: invokevirtual 211	java/io/InputStream:close	()V
    //   254: aload_0
    //   255: ifnull +94 -> 349
    //   258: aload_0
    //   259: invokevirtual 211	java/io/InputStream:close	()V
    //   262: sipush 10326
    //   265: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: return
    //   269: astore_2
    //   270: sipush 10326
    //   273: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: aload_2
    //   277: athrow
    //   278: astore_1
    //   279: aload_2
    //   280: ifnull +27 -> 307
    //   283: aload 4
    //   285: invokevirtual 231	java/io/OutputStream:close	()V
    //   288: sipush 10326
    //   291: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   294: aload_1
    //   295: athrow
    //   296: astore 4
    //   298: aload_2
    //   299: aload 4
    //   301: invokevirtual 202	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   304: goto -16 -> 288
    //   307: aload 4
    //   309: invokevirtual 231	java/io/OutputStream:close	()V
    //   312: goto -24 -> 288
    //   315: astore 4
    //   317: aload_2
    //   318: aload 4
    //   320: invokevirtual 202	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   323: goto -242 -> 81
    //   326: aload_0
    //   327: invokevirtual 211	java/io/InputStream:close	()V
    //   330: goto -249 -> 81
    //   333: astore_0
    //   334: aload_2
    //   335: aload_0
    //   336: invokevirtual 202	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   339: goto -228 -> 111
    //   342: aload_0
    //   343: invokevirtual 211	java/io/InputStream:close	()V
    //   346: goto -235 -> 111
    //   349: sipush 10326
    //   352: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   355: return
    //   356: astore_1
    //   357: aconst_null
    //   358: astore_2
    //   359: goto -80 -> 279
    //   362: astore_1
    //   363: aconst_null
    //   364: astore_2
    //   365: goto -296 -> 69
    //   368: astore_1
    //   369: aload_3
    //   370: astore_2
    //   371: goto -272 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	paramInputStream	java.io.InputStream
    //   0	374	1	paramFile	File
    //   59	15	2	localThrowable1	java.lang.Throwable
    //   89	15	2	localThrowable2	java.lang.Throwable
    //   167	33	2	localFile	File
    //   269	66	2	localThrowable3	java.lang.Throwable
    //   358	13	2	localObject1	Object
    //   1	369	3	localObject2	Object
    //   232	52	4	localFileOutputStream	java.io.FileOutputStream
    //   296	12	4	localThrowable4	java.lang.Throwable
    //   315	4	4	localThrowable5	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   8	59	59	java/lang/Throwable
    //   119	163	59	java/lang/Throwable
    //   163	168	59	java/lang/Throwable
    //   172	223	59	java/lang/Throwable
    //   223	234	59	java/lang/Throwable
    //   241	246	59	java/lang/Throwable
    //   288	296	59	java/lang/Throwable
    //   298	304	59	java/lang/Throwable
    //   307	312	59	java/lang/Throwable
    //   60	68	68	finally
    //   81	89	89	java/lang/Throwable
    //   250	254	89	java/lang/Throwable
    //   317	323	89	java/lang/Throwable
    //   326	330	89	java/lang/Throwable
    //   90	98	98	finally
    //   234	241	269	java/lang/Throwable
    //   270	278	278	finally
    //   283	288	296	java/lang/Throwable
    //   77	81	315	java/lang/Throwable
    //   107	111	333	java/lang/Throwable
    //   234	241	356	finally
    //   8	59	362	finally
    //   119	163	362	finally
    //   163	168	362	finally
    //   172	223	362	finally
    //   223	234	362	finally
    //   241	246	362	finally
    //   283	288	362	finally
    //   288	296	362	finally
    //   298	304	362	finally
    //   307	312	362	finally
    //   77	81	368	finally
    //   81	89	368	finally
    //   250	254	368	finally
    //   317	323	368	finally
    //   326	330	368	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.apache.commons.a.c
 * JD-Core Version:    0.7.0.1
 */