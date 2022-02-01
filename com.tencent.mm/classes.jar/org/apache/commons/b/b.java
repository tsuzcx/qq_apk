package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.math.BigInteger;

public final class b
{
  public static final BigInteger ajUC;
  public static final BigInteger ajUD;
  public static final BigInteger ajUE;
  public static final BigInteger ajUF;
  public static final BigInteger ajUG;
  public static final BigInteger ajUH;
  public static final BigInteger ajUI;
  public static final File[] ajUJ;
  public static final BigInteger sSB;
  
  static
  {
    AppMethodBeat.i(10328);
    BigInteger localBigInteger = BigInteger.valueOf(1024L);
    sSB = localBigInteger;
    ajUC = localBigInteger.multiply(localBigInteger);
    ajUD = sSB.multiply(ajUC);
    ajUE = sSB.multiply(ajUD);
    ajUF = sSB.multiply(ajUE);
    ajUG = sSB.multiply(ajUF);
    ajUH = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(1152921504606846976L));
    ajUI = sSB.multiply(ajUH);
    ajUJ = new File[0];
    AppMethodBeat.o(10328);
  }
  
  /* Error */
  public static void c(java.io.InputStream paramInputStream, File paramFile)
  {
    // Byte code:
    //   0: sipush 10326
    //   3: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokevirtual 67	java/io/File:exists	()Z
    //   10: ifeq +151 -> 161
    //   13: aload_1
    //   14: invokevirtual 70	java/io/File:isDirectory	()Z
    //   17: ifeq +100 -> 117
    //   20: new 72	java/io/IOException
    //   23: dup
    //   24: new 74	java/lang/StringBuilder
    //   27: dup
    //   28: ldc 76
    //   30: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: aload_1
    //   34: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   37: ldc 86
    //   39: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 94	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   48: astore_1
    //   49: sipush 10326
    //   52: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aload_1
    //   56: athrow
    //   57: astore_1
    //   58: sipush 10326
    //   61: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_1
    //   65: athrow
    //   66: astore_2
    //   67: aload_0
    //   68: ifnull +11 -> 79
    //   71: aload_1
    //   72: ifnull +243 -> 315
    //   75: aload_0
    //   76: invokevirtual 99	java/io/InputStream:close	()V
    //   79: sipush 10326
    //   82: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aload_2
    //   86: athrow
    //   87: astore_1
    //   88: sipush 10326
    //   91: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_1
    //   95: athrow
    //   96: astore_2
    //   97: aload_0
    //   98: ifnull +11 -> 109
    //   101: aload_1
    //   102: ifnull +229 -> 331
    //   105: aload_0
    //   106: invokevirtual 99	java/io/InputStream:close	()V
    //   109: sipush 10326
    //   112: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: aload_2
    //   116: athrow
    //   117: aload_1
    //   118: invokevirtual 102	java/io/File:canWrite	()Z
    //   121: ifne +100 -> 221
    //   124: new 72	java/io/IOException
    //   127: dup
    //   128: new 74	java/lang/StringBuilder
    //   131: dup
    //   132: ldc 76
    //   134: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   137: aload_1
    //   138: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   141: ldc 104
    //   143: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokespecial 94	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   152: astore_1
    //   153: sipush 10326
    //   156: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: aload_1
    //   160: athrow
    //   161: aload_1
    //   162: invokevirtual 108	java/io/File:getParentFile	()Ljava/io/File;
    //   165: astore_2
    //   166: aload_2
    //   167: ifnull +54 -> 221
    //   170: aload_2
    //   171: invokevirtual 111	java/io/File:mkdirs	()Z
    //   174: ifne +47 -> 221
    //   177: aload_2
    //   178: invokevirtual 70	java/io/File:isDirectory	()Z
    //   181: ifne +40 -> 221
    //   184: new 72	java/io/IOException
    //   187: dup
    //   188: new 74	java/lang/StringBuilder
    //   191: dup
    //   192: ldc 113
    //   194: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   197: aload_2
    //   198: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   201: ldc 115
    //   203: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokespecial 94	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   212: astore_1
    //   213: sipush 10326
    //   216: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: aload_1
    //   220: athrow
    //   221: new 117	java/io/FileOutputStream
    //   224: dup
    //   225: aload_1
    //   226: iconst_0
    //   227: invokespecial 120	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   230: astore_3
    //   231: aload_0
    //   232: aload_3
    //   233: invokestatic 126	org/apache/commons/b/d:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   236: pop
    //   237: aload_3
    //   238: invokevirtual 129	java/io/OutputStream:close	()V
    //   241: aload_0
    //   242: ifnull +7 -> 249
    //   245: aload_0
    //   246: invokevirtual 99	java/io/InputStream:close	()V
    //   249: aload_0
    //   250: ifnull +88 -> 338
    //   253: aload_0
    //   254: invokevirtual 99	java/io/InputStream:close	()V
    //   257: sipush 10326
    //   260: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   263: return
    //   264: astore_1
    //   265: sipush 10326
    //   268: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   271: aload_1
    //   272: athrow
    //   273: astore_2
    //   274: aload_1
    //   275: ifnull +24 -> 299
    //   278: aload_3
    //   279: invokevirtual 129	java/io/OutputStream:close	()V
    //   282: sipush 10326
    //   285: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   288: aload_2
    //   289: athrow
    //   290: astore_3
    //   291: aload_1
    //   292: aload_3
    //   293: invokevirtual 135	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   296: goto -14 -> 282
    //   299: aload_3
    //   300: invokevirtual 129	java/io/OutputStream:close	()V
    //   303: goto -21 -> 282
    //   306: astore_3
    //   307: aload_1
    //   308: aload_3
    //   309: invokevirtual 135	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   312: goto -233 -> 79
    //   315: aload_0
    //   316: invokevirtual 99	java/io/InputStream:close	()V
    //   319: goto -240 -> 79
    //   322: astore_0
    //   323: aload_1
    //   324: aload_0
    //   325: invokevirtual 135	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   328: goto -219 -> 109
    //   331: aload_0
    //   332: invokevirtual 99	java/io/InputStream:close	()V
    //   335: goto -226 -> 109
    //   338: sipush 10326
    //   341: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   344: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	paramInputStream	java.io.InputStream
    //   0	345	1	paramFile	File
    //   66	20	2	localObject1	Object
    //   96	20	2	localObject2	Object
    //   165	33	2	localFile	File
    //   273	16	2	localObject3	Object
    //   230	49	3	localFileOutputStream	java.io.FileOutputStream
    //   290	10	3	localThrowable1	java.lang.Throwable
    //   306	3	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   6	57	57	finally
    //   117	161	57	finally
    //   161	166	57	finally
    //   170	221	57	finally
    //   221	231	57	finally
    //   237	241	57	finally
    //   282	290	57	finally
    //   291	296	57	finally
    //   299	303	57	finally
    //   58	66	66	finally
    //   79	87	87	finally
    //   245	249	87	finally
    //   307	312	87	finally
    //   315	319	87	finally
    //   88	96	96	finally
    //   231	237	264	finally
    //   265	273	273	finally
    //   278	282	290	finally
    //   75	79	306	finally
    //   105	109	322	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.apache.commons.b.b
 * JD-Core Version:    0.7.0.1
 */