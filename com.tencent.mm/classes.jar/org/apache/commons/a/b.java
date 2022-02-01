package org.apache.commons.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.math.BigInteger;

public final class b
{
  public static final BigInteger abHI;
  public static final BigInteger abHJ;
  public static final BigInteger abHK;
  public static final BigInteger abHL;
  public static final BigInteger abHM;
  public static final BigInteger abHN;
  public static final BigInteger abHO;
  public static final File[] abHP;
  public static final BigInteger pOd;
  
  static
  {
    AppMethodBeat.i(10328);
    BigInteger localBigInteger = BigInteger.valueOf(1024L);
    pOd = localBigInteger;
    abHI = localBigInteger.multiply(localBigInteger);
    abHJ = pOd.multiply(abHI);
    abHK = pOd.multiply(abHJ);
    abHL = pOd.multiply(abHK);
    abHM = pOd.multiply(abHL);
    abHN = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(1152921504606846976L));
    abHO = pOd.multiply(abHN);
    abHP = new File[0];
    AppMethodBeat.o(10328);
  }
  
  /* Error */
  public static void b(java.io.InputStream paramInputStream, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: sipush 10326
    //   5: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: invokevirtual 69	java/io/File:exists	()Z
    //   12: ifeq +151 -> 163
    //   15: aload_1
    //   16: invokevirtual 72	java/io/File:isDirectory	()Z
    //   19: ifeq +100 -> 119
    //   22: new 74	java/io/IOException
    //   25: dup
    //   26: new 76	java/lang/StringBuilder
    //   29: dup
    //   30: ldc 78
    //   32: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   35: aload_1
    //   36: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   39: ldc 88
    //   41: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokespecial 96	java/io/IOException:<init>	(Ljava/lang/String;)V
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
    //   78: invokevirtual 101	java/io/InputStream:close	()V
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
    //   108: invokevirtual 101	java/io/InputStream:close	()V
    //   111: sipush 10326
    //   114: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload_1
    //   118: athrow
    //   119: aload_1
    //   120: invokevirtual 104	java/io/File:canWrite	()Z
    //   123: ifne +100 -> 223
    //   126: new 74	java/io/IOException
    //   129: dup
    //   130: new 76	java/lang/StringBuilder
    //   133: dup
    //   134: ldc 78
    //   136: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   139: aload_1
    //   140: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   143: ldc 106
    //   145: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokespecial 96	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   154: astore_1
    //   155: sipush 10326
    //   158: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: aload_1
    //   162: athrow
    //   163: aload_1
    //   164: invokevirtual 110	java/io/File:getParentFile	()Ljava/io/File;
    //   167: astore_2
    //   168: aload_2
    //   169: ifnull +54 -> 223
    //   172: aload_2
    //   173: invokevirtual 113	java/io/File:mkdirs	()Z
    //   176: ifne +47 -> 223
    //   179: aload_2
    //   180: invokevirtual 72	java/io/File:isDirectory	()Z
    //   183: ifne +40 -> 223
    //   186: new 74	java/io/IOException
    //   189: dup
    //   190: new 76	java/lang/StringBuilder
    //   193: dup
    //   194: ldc 115
    //   196: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   199: aload_2
    //   200: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   203: ldc 117
    //   205: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokespecial 96	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   214: astore_1
    //   215: sipush 10326
    //   218: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aload_1
    //   222: athrow
    //   223: new 119	java/io/FileOutputStream
    //   226: dup
    //   227: aload_1
    //   228: iconst_0
    //   229: invokespecial 122	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   232: astore 4
    //   234: aload_0
    //   235: aload 4
    //   237: invokestatic 128	org/apache/commons/a/d:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   240: pop
    //   241: aload 4
    //   243: invokevirtual 131	java/io/OutputStream:close	()V
    //   246: aload_0
    //   247: ifnull +7 -> 254
    //   250: aload_0
    //   251: invokevirtual 101	java/io/InputStream:close	()V
    //   254: aload_0
    //   255: ifnull +94 -> 349
    //   258: aload_0
    //   259: invokevirtual 101	java/io/InputStream:close	()V
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
    //   285: invokevirtual 131	java/io/OutputStream:close	()V
    //   288: sipush 10326
    //   291: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   294: aload_1
    //   295: athrow
    //   296: astore 4
    //   298: aload_2
    //   299: aload 4
    //   301: invokevirtual 135	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   304: goto -16 -> 288
    //   307: aload 4
    //   309: invokevirtual 131	java/io/OutputStream:close	()V
    //   312: goto -24 -> 288
    //   315: astore 4
    //   317: aload_2
    //   318: aload 4
    //   320: invokevirtual 135	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   323: goto -242 -> 81
    //   326: aload_0
    //   327: invokevirtual 101	java/io/InputStream:close	()V
    //   330: goto -249 -> 81
    //   333: astore_0
    //   334: aload_2
    //   335: aload_0
    //   336: invokevirtual 135	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   339: goto -228 -> 111
    //   342: aload_0
    //   343: invokevirtual 101	java/io/InputStream:close	()V
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.apache.commons.a.b
 * JD-Core Version:    0.7.0.1
 */