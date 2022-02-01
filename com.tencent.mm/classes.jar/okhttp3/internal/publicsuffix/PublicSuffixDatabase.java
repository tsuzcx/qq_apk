package okhttp3.internal.publicsuffix;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.c;

public final class PublicSuffixDatabase
{
  private static final byte[] ajSE;
  private static final String[] ajSF;
  private static final String[] ajSG;
  private static final PublicSuffixDatabase ajSH;
  private final AtomicBoolean ajSI;
  private final CountDownLatch ajSJ;
  private byte[] ajSK;
  private byte[] ajSL;
  
  static
  {
    AppMethodBeat.i(187121);
    ajSE = new byte[] { 42 };
    ajSF = new String[0];
    ajSG = new String[] { "*" };
    ajSH = new PublicSuffixDatabase();
    AppMethodBeat.o(187121);
  }
  
  public PublicSuffixDatabase()
  {
    AppMethodBeat.i(187021);
    this.ajSI = new AtomicBoolean(false);
    this.ajSJ = new CountDownLatch(1);
    AppMethodBeat.o(187021);
  }
  
  private static String a(byte[] paramArrayOfByte, byte[][] paramArrayOfByte1, int paramInt)
  {
    AppMethodBeat.i(187111);
    int j = paramArrayOfByte.length;
    int i = 0;
    int k;
    int i5;
    int i6;
    int i4;
    for (;;)
    {
      if (i >= j) {
        break label357;
      }
      k = (i + j) / 2;
      while ((k >= 0) && (paramArrayOfByte[k] != 10)) {
        k -= 1;
      }
      i5 = k + 1;
      int i1 = 1;
      while (paramArrayOfByte[(i5 + i1)] != 10) {
        i1 += 1;
      }
      i6 = i5 + i1 - i5;
      k = 0;
      int m = 0;
      int n = 0;
      int i2 = paramInt;
      int i3;
      if (n != 0)
      {
        i3 = 46;
        n = 0;
      }
      int i7;
      for (;;)
      {
        i7 = i3 - (paramArrayOfByte[(i5 + m)] & 0xFF);
        if (i7 != 0) {
          break label350;
        }
        m += 1;
        i4 = k + 1;
        if (m == i6) {
          break label214;
        }
        k = i4;
        i3 = i2;
        if (paramArrayOfByte1[i2].length == i4)
        {
          if (i2 == paramArrayOfByte1.length - 1) {
            break label214;
          }
          i3 = i2 + 1;
          k = -1;
          n = 1;
        }
        i2 = i3;
        break;
        i3 = paramArrayOfByte1[i2][k] & 0xFF;
      }
      label214:
      if (i7 < 0)
      {
        j = i5 - 1;
      }
      else if (i7 > 0)
      {
        i = i1 + i5 + 1;
      }
      else
      {
        n = i6 - m;
        m = paramArrayOfByte1[i2].length - i4;
        k = i2 + 1;
        while (k < paramArrayOfByte1.length)
        {
          m += paramArrayOfByte1[k].length;
          k += 1;
        }
        if (m < n)
        {
          j = i5 - 1;
        }
        else
        {
          if (m <= n) {
            break;
          }
          i = i1 + i5 + 1;
        }
      }
    }
    label350:
    label357:
    for (paramArrayOfByte = new String(paramArrayOfByte, i5, i6, c.UTF_8);; paramArrayOfByte = null)
    {
      AppMethodBeat.o(187111);
      return paramArrayOfByte;
      i4 = k;
      break;
    }
  }
  
  /* Error */
  private String[] av(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: iconst_0
    //   4: istore_3
    //   5: ldc 81
    //   7: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: getfield 54	okhttp3/internal/publicsuffix/PublicSuffixDatabase:ajSI	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   14: invokevirtual 85	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   17: ifne +244 -> 261
    //   20: aload_0
    //   21: getfield 54	okhttp3/internal/publicsuffix/PublicSuffixDatabase:ajSI	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   24: iconst_0
    //   25: iconst_1
    //   26: invokevirtual 89	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   29: ifeq +232 -> 261
    //   32: iconst_0
    //   33: istore_2
    //   34: ldc 2
    //   36: ldc 91
    //   38: invokevirtual 97	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   41: astore 4
    //   43: aload 4
    //   45: ifnull +88 -> 133
    //   48: new 99	j/m
    //   51: dup
    //   52: aload 4
    //   54: invokestatic 105	j/p:ah	(Ljava/io/InputStream;)Lj/aa;
    //   57: invokespecial 108	j/m:<init>	(Lj/aa;)V
    //   60: invokestatic 114	j/q:b	(Lj/aa;)Lj/h;
    //   63: astore 4
    //   65: aload 4
    //   67: invokeinterface 120 1 0
    //   72: newarray byte
    //   74: astore 5
    //   76: aload 4
    //   78: aload 5
    //   80: invokeinterface 124 2 0
    //   85: aload 4
    //   87: invokeinterface 120 1 0
    //   92: newarray byte
    //   94: astore 7
    //   96: aload 4
    //   98: aload 7
    //   100: invokeinterface 124 2 0
    //   105: aload 4
    //   107: invokestatic 128	okhttp3/internal/c:closeQuietly	(Ljava/io/Closeable;)V
    //   110: aload_0
    //   111: monitorenter
    //   112: aload_0
    //   113: aload 5
    //   115: putfield 130	okhttp3/internal/publicsuffix/PublicSuffixDatabase:ajSK	[B
    //   118: aload_0
    //   119: aload 7
    //   121: putfield 132	okhttp3/internal/publicsuffix/PublicSuffixDatabase:ajSL	[B
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_0
    //   127: getfield 60	okhttp3/internal/publicsuffix/PublicSuffixDatabase:ajSJ	Ljava/util/concurrent/CountDownLatch;
    //   130: invokevirtual 135	java/util/concurrent/CountDownLatch:countDown	()V
    //   133: iload_2
    //   134: ifeq +9 -> 143
    //   137: invokestatic 141	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   140: invokevirtual 144	java/lang/Thread:interrupt	()V
    //   143: aload_0
    //   144: monitorenter
    //   145: aload_0
    //   146: getfield 130	okhttp3/internal/publicsuffix/PublicSuffixDatabase:ajSK	[B
    //   149: ifnonnull +133 -> 282
    //   152: new 146	java/lang/IllegalStateException
    //   155: dup
    //   156: ldc 148
    //   158: invokespecial 151	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   161: astore_1
    //   162: ldc 81
    //   164: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: aload_1
    //   168: athrow
    //   169: astore_1
    //   170: aload_0
    //   171: monitorexit
    //   172: ldc 81
    //   174: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: aload_1
    //   178: athrow
    //   179: astore 5
    //   181: aload 4
    //   183: invokestatic 128	okhttp3/internal/c:closeQuietly	(Ljava/io/Closeable;)V
    //   186: ldc 81
    //   188: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: aload 5
    //   193: athrow
    //   194: astore 4
    //   196: invokestatic 154	java/lang/Thread:interrupted	()Z
    //   199: pop
    //   200: iconst_1
    //   201: istore_2
    //   202: goto -168 -> 34
    //   205: astore 4
    //   207: aload_0
    //   208: monitorexit
    //   209: ldc 81
    //   211: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: aload 4
    //   216: athrow
    //   217: astore 4
    //   219: invokestatic 160	okhttp3/internal/g/g:kIq	()Lokhttp3/internal/g/g;
    //   222: iconst_5
    //   223: ldc 162
    //   225: aload 4
    //   227: invokevirtual 166	okhttp3/internal/g/g:g	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   230: iload_2
    //   231: ifeq -88 -> 143
    //   234: invokestatic 141	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   237: invokevirtual 144	java/lang/Thread:interrupt	()V
    //   240: goto -97 -> 143
    //   243: astore_1
    //   244: iload_2
    //   245: ifeq +9 -> 254
    //   248: invokestatic 141	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   251: invokevirtual 144	java/lang/Thread:interrupt	()V
    //   254: ldc 81
    //   256: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: aload_1
    //   260: athrow
    //   261: aload_0
    //   262: getfield 60	okhttp3/internal/publicsuffix/PublicSuffixDatabase:ajSJ	Ljava/util/concurrent/CountDownLatch;
    //   265: invokevirtual 169	java/util/concurrent/CountDownLatch:await	()V
    //   268: goto -125 -> 143
    //   271: astore 4
    //   273: invokestatic 141	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   276: invokevirtual 144	java/lang/Thread:interrupt	()V
    //   279: goto -136 -> 143
    //   282: aload_0
    //   283: monitorexit
    //   284: aload_1
    //   285: arraylength
    //   286: anewarray 170	[B
    //   289: astore 7
    //   291: iconst_0
    //   292: istore_2
    //   293: iload_2
    //   294: aload_1
    //   295: arraylength
    //   296: if_icmpge +23 -> 319
    //   299: aload 7
    //   301: iload_2
    //   302: aload_1
    //   303: iload_2
    //   304: aaload
    //   305: getstatic 69	okhttp3/internal/c:UTF_8	Ljava/nio/charset/Charset;
    //   308: invokevirtual 174	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   311: aastore
    //   312: iload_2
    //   313: iconst_1
    //   314: iadd
    //   315: istore_2
    //   316: goto -23 -> 293
    //   319: iconst_0
    //   320: istore_2
    //   321: iload_2
    //   322: aload 7
    //   324: arraylength
    //   325: if_icmpge +249 -> 574
    //   328: aload_0
    //   329: getfield 130	okhttp3/internal/publicsuffix/PublicSuffixDatabase:ajSK	[B
    //   332: aload 7
    //   334: iload_2
    //   335: invokestatic 176	okhttp3/internal/publicsuffix/PublicSuffixDatabase:a	([B[[BI)Ljava/lang/String;
    //   338: astore_1
    //   339: aload_1
    //   340: ifnull +124 -> 464
    //   343: aload 7
    //   345: arraylength
    //   346: iconst_1
    //   347: if_icmple +221 -> 568
    //   350: aload 7
    //   352: invokevirtual 182	[[B:clone	()Ljava/lang/Object;
    //   355: checkcast 178	[[B
    //   358: astore 5
    //   360: iconst_0
    //   361: istore_2
    //   362: iload_2
    //   363: aload 5
    //   365: arraylength
    //   366: iconst_1
    //   367: isub
    //   368: if_icmpge +200 -> 568
    //   371: aload 5
    //   373: iload_2
    //   374: getstatic 28	okhttp3/internal/publicsuffix/PublicSuffixDatabase:ajSE	[B
    //   377: aastore
    //   378: aload_0
    //   379: getfield 130	okhttp3/internal/publicsuffix/PublicSuffixDatabase:ajSK	[B
    //   382: aload 5
    //   384: iload_2
    //   385: invokestatic 176	okhttp3/internal/publicsuffix/PublicSuffixDatabase:a	([B[[BI)Ljava/lang/String;
    //   388: astore 4
    //   390: aload 4
    //   392: ifnull +79 -> 471
    //   395: aload 6
    //   397: astore 5
    //   399: aload 4
    //   401: ifnull +35 -> 436
    //   404: iload_3
    //   405: istore_2
    //   406: aload 6
    //   408: astore 5
    //   410: iload_2
    //   411: aload 7
    //   413: arraylength
    //   414: iconst_1
    //   415: isub
    //   416: if_icmpge +20 -> 436
    //   419: aload_0
    //   420: getfield 132	okhttp3/internal/publicsuffix/PublicSuffixDatabase:ajSL	[B
    //   423: aload 7
    //   425: iload_2
    //   426: invokestatic 176	okhttp3/internal/publicsuffix/PublicSuffixDatabase:a	([B[[BI)Ljava/lang/String;
    //   429: astore 5
    //   431: aload 5
    //   433: ifnull +45 -> 478
    //   436: aload 5
    //   438: ifnull +47 -> 485
    //   441: ldc 184
    //   443: aload 5
    //   445: invokestatic 188	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   448: invokevirtual 192	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   451: ldc 194
    //   453: invokevirtual 198	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   456: astore_1
    //   457: ldc 81
    //   459: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   462: aload_1
    //   463: areturn
    //   464: iload_2
    //   465: iconst_1
    //   466: iadd
    //   467: istore_2
    //   468: goto -147 -> 321
    //   471: iload_2
    //   472: iconst_1
    //   473: iadd
    //   474: istore_2
    //   475: goto -113 -> 362
    //   478: iload_2
    //   479: iconst_1
    //   480: iadd
    //   481: istore_2
    //   482: goto -76 -> 406
    //   485: aload_1
    //   486: ifnonnull +19 -> 505
    //   489: aload 4
    //   491: ifnonnull +14 -> 505
    //   494: getstatic 36	okhttp3/internal/publicsuffix/PublicSuffixDatabase:ajSG	[Ljava/lang/String;
    //   497: astore_1
    //   498: ldc 81
    //   500: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   503: aload_1
    //   504: areturn
    //   505: aload_1
    //   506: ifnull +39 -> 545
    //   509: aload_1
    //   510: ldc 194
    //   512: invokevirtual 198	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   515: astore_1
    //   516: aload 4
    //   518: ifnull +34 -> 552
    //   521: aload 4
    //   523: ldc 194
    //   525: invokevirtual 198	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   528: astore 4
    //   530: aload_1
    //   531: arraylength
    //   532: aload 4
    //   534: arraylength
    //   535: if_icmple +25 -> 560
    //   538: ldc 81
    //   540: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   543: aload_1
    //   544: areturn
    //   545: getstatic 32	okhttp3/internal/publicsuffix/PublicSuffixDatabase:ajSF	[Ljava/lang/String;
    //   548: astore_1
    //   549: goto -33 -> 516
    //   552: getstatic 32	okhttp3/internal/publicsuffix/PublicSuffixDatabase:ajSF	[Ljava/lang/String;
    //   555: astore 4
    //   557: goto -27 -> 530
    //   560: ldc 81
    //   562: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   565: aload 4
    //   567: areturn
    //   568: aconst_null
    //   569: astore 4
    //   571: goto -176 -> 395
    //   574: aconst_null
    //   575: astore_1
    //   576: goto -233 -> 343
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	579	0	this	PublicSuffixDatabase
    //   0	579	1	paramArrayOfString	String[]
    //   33	449	2	i	int
    //   4	401	3	j	int
    //   41	141	4	localObject1	Object
    //   194	1	4	localInterruptedIOException	java.io.InterruptedIOException
    //   205	10	4	localObject2	Object
    //   217	9	4	localIOException	java.io.IOException
    //   271	1	4	localInterruptedException	java.lang.InterruptedException
    //   388	182	4	localObject3	Object
    //   74	40	5	arrayOfByte	byte[]
    //   179	13	5	localObject4	Object
    //   358	86	5	localObject5	Object
    //   1	406	6	localObject6	Object
    //   94	330	7	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   145	169	169	finally
    //   282	284	169	finally
    //   65	105	179	finally
    //   34	43	194	java/io/InterruptedIOException
    //   48	65	194	java/io/InterruptedIOException
    //   105	112	194	java/io/InterruptedIOException
    //   126	133	194	java/io/InterruptedIOException
    //   181	194	194	java/io/InterruptedIOException
    //   207	217	194	java/io/InterruptedIOException
    //   112	126	205	finally
    //   34	43	217	java/io/IOException
    //   48	65	217	java/io/IOException
    //   105	112	217	java/io/IOException
    //   126	133	217	java/io/IOException
    //   181	194	217	java/io/IOException
    //   207	217	217	java/io/IOException
    //   34	43	243	finally
    //   48	65	243	finally
    //   105	112	243	finally
    //   126	133	243	finally
    //   181	194	243	finally
    //   196	200	243	finally
    //   207	217	243	finally
    //   219	230	243	finally
    //   261	268	271	java/lang/InterruptedException
  }
  
  public static PublicSuffixDatabase kIr()
  {
    return ajSH;
  }
  
  public final String bKN(String paramString)
  {
    AppMethodBeat.i(187137);
    if (paramString == null)
    {
      paramString = new NullPointerException("domain == null");
      AppMethodBeat.o(187137);
      throw paramString;
    }
    Object localObject = IDN.toUnicode(paramString).split("\\.");
    String[] arrayOfString = av((String[])localObject);
    if ((localObject.length == arrayOfString.length) && (arrayOfString[0].charAt(0) != '!'))
    {
      AppMethodBeat.o(187137);
      return null;
    }
    if (arrayOfString[0].charAt(0) == '!') {}
    for (int i = localObject.length - arrayOfString.length;; i = localObject.length - (arrayOfString.length + 1))
    {
      localObject = new StringBuilder();
      paramString = paramString.split("\\.");
      while (i < paramString.length)
      {
        ((StringBuilder)localObject).append(paramString[i]).append('.');
        i += 1;
      }
    }
    ((StringBuilder)localObject).deleteCharAt(((StringBuilder)localObject).length() - 1);
    paramString = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(187137);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     okhttp3.internal.publicsuffix.PublicSuffixDatabase
 * JD-Core Version:    0.7.0.1
 */