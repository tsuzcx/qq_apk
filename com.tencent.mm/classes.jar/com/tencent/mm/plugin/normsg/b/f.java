package com.tencent.mm.plugin.normsg.b;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.File;

public final class f
{
  private static String[] mHY;
  private static String[] mHZ;
  private static String[] mIa;
  public static boolean mIb;
  public static boolean mIc;
  public static boolean mIe;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: iconst_2
    //   1: anewarray 20	java/lang/String
    //   4: dup
    //   5: iconst_0
    //   6: new 22	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   13: invokestatic 31	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   16: invokevirtual 37	android/content/Context:getFilesDir	()Ljava/io/File;
    //   19: invokevirtual 43	java/io/File:getParent	()Ljava/lang/String;
    //   22: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 49
    //   27: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 56	com/tencent/mm/plugin/normsg/b/f:Kg	(Ljava/lang/String;)Ljava/lang/String;
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: new 22	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   46: invokestatic 31	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   49: invokevirtual 37	android/content/Context:getFilesDir	()Ljava/io/File;
    //   52: invokevirtual 43	java/io/File:getParent	()Ljava/lang/String;
    //   55: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 58
    //   60: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 56	com/tencent/mm/plugin/normsg/b/f:Kg	(Ljava/lang/String;)Ljava/lang/String;
    //   69: aastore
    //   70: putstatic 60	com/tencent/mm/plugin/normsg/b/f:mHY	[Ljava/lang/String;
    //   73: iconst_1
    //   74: anewarray 20	java/lang/String
    //   77: dup
    //   78: iconst_0
    //   79: new 22	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   86: invokestatic 31	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   89: invokevirtual 37	android/content/Context:getFilesDir	()Ljava/io/File;
    //   92: invokevirtual 43	java/io/File:getParent	()Ljava/lang/String;
    //   95: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc 62
    //   100: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 56	com/tencent/mm/plugin/normsg/b/f:Kg	(Ljava/lang/String;)Ljava/lang/String;
    //   109: aastore
    //   110: putstatic 64	com/tencent/mm/plugin/normsg/b/f:mHZ	[Ljava/lang/String;
    //   113: iconst_3
    //   114: anewarray 20	java/lang/String
    //   117: dup
    //   118: iconst_0
    //   119: new 22	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   126: invokestatic 31	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   129: invokevirtual 37	android/content/Context:getFilesDir	()Ljava/io/File;
    //   132: invokevirtual 43	java/io/File:getParent	()Ljava/lang/String;
    //   135: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc 66
    //   140: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 56	com/tencent/mm/plugin/normsg/b/f:Kg	(Ljava/lang/String;)Ljava/lang/String;
    //   149: aastore
    //   150: dup
    //   151: iconst_1
    //   152: new 22	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   159: invokestatic 31	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   162: invokevirtual 37	android/content/Context:getFilesDir	()Ljava/io/File;
    //   165: invokevirtual 43	java/io/File:getParent	()Ljava/lang/String;
    //   168: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: ldc 68
    //   173: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 56	com/tencent/mm/plugin/normsg/b/f:Kg	(Ljava/lang/String;)Ljava/lang/String;
    //   182: aastore
    //   183: dup
    //   184: iconst_2
    //   185: new 22	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   192: invokestatic 31	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   195: invokevirtual 37	android/content/Context:getFilesDir	()Ljava/io/File;
    //   198: invokevirtual 43	java/io/File:getParent	()Ljava/lang/String;
    //   201: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: ldc 70
    //   206: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 56	com/tencent/mm/plugin/normsg/b/f:Kg	(Ljava/lang/String;)Ljava/lang/String;
    //   215: aastore
    //   216: putstatic 72	com/tencent/mm/plugin/normsg/b/f:mIa	[Ljava/lang/String;
    //   219: iconst_0
    //   220: putstatic 74	com/tencent/mm/plugin/normsg/b/f:mIb	Z
    //   223: iconst_0
    //   224: putstatic 76	com/tencent/mm/plugin/normsg/b/f:mIc	Z
    //   227: iconst_0
    //   228: putstatic 78	com/tencent/mm/plugin/normsg/b/f:mIe	Z
    //   231: getstatic 60	com/tencent/mm/plugin/normsg/b/f:mHY	[Ljava/lang/String;
    //   234: astore_2
    //   235: aload_2
    //   236: arraylength
    //   237: istore_1
    //   238: iconst_0
    //   239: istore_0
    //   240: iload_0
    //   241: iload_1
    //   242: if_icmpge +23 -> 265
    //   245: new 39	java/io/File
    //   248: dup
    //   249: aload_2
    //   250: iload_0
    //   251: aaload
    //   252: invokespecial 81	java/io/File:<init>	(Ljava/lang/String;)V
    //   255: invokevirtual 85	java/io/File:exists	()Z
    //   258: ifeq +139 -> 397
    //   261: iconst_1
    //   262: putstatic 74	com/tencent/mm/plugin/normsg/b/f:mIb	Z
    //   265: new 39	java/io/File
    //   268: dup
    //   269: ldc 87
    //   271: invokespecial 81	java/io/File:<init>	(Ljava/lang/String;)V
    //   274: astore_2
    //   275: aload_2
    //   276: invokevirtual 85	java/io/File:exists	()Z
    //   279: ifeq +83 -> 362
    //   282: aload_2
    //   283: invokevirtual 90	java/io/File:canRead	()Z
    //   286: ifeq +76 -> 362
    //   289: aload_2
    //   290: invokevirtual 94	java/io/File:length	()J
    //   293: lconst_0
    //   294: lcmp
    //   295: ifle +67 -> 362
    //   298: aload_2
    //   299: invokevirtual 94	java/io/File:length	()J
    //   302: l2i
    //   303: newarray byte
    //   305: astore_3
    //   306: new 96	java/io/FileInputStream
    //   309: dup
    //   310: aload_2
    //   311: invokespecial 99	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   314: astore_2
    //   315: aload_2
    //   316: aload_3
    //   317: invokevirtual 105	java/io/InputStream:read	([B)I
    //   320: pop
    //   321: aload_2
    //   322: invokevirtual 108	java/io/InputStream:close	()V
    //   325: new 20	java/lang/String
    //   328: dup
    //   329: aload_3
    //   330: invokespecial 111	java/lang/String:<init>	([B)V
    //   333: astore_2
    //   334: getstatic 64	com/tencent/mm/plugin/normsg/b/f:mHZ	[Ljava/lang/String;
    //   337: astore_3
    //   338: aload_3
    //   339: arraylength
    //   340: istore_1
    //   341: iconst_0
    //   342: istore_0
    //   343: iload_0
    //   344: iload_1
    //   345: if_icmpge +17 -> 362
    //   348: aload_2
    //   349: aload_3
    //   350: iload_0
    //   351: aaload
    //   352: invokevirtual 115	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   355: ifeq +80 -> 435
    //   358: iconst_1
    //   359: putstatic 76	com/tencent/mm/plugin/normsg/b/f:mIc	Z
    //   362: getstatic 72	com/tencent/mm/plugin/normsg/b/f:mIa	[Ljava/lang/String;
    //   365: astore_2
    //   366: aload_2
    //   367: arraylength
    //   368: istore_1
    //   369: iconst_0
    //   370: istore_0
    //   371: iload_0
    //   372: iload_1
    //   373: if_icmpge +23 -> 396
    //   376: new 39	java/io/File
    //   379: dup
    //   380: aload_2
    //   381: iload_0
    //   382: aaload
    //   383: invokespecial 81	java/io/File:<init>	(Ljava/lang/String;)V
    //   386: invokevirtual 85	java/io/File:exists	()Z
    //   389: ifeq +53 -> 442
    //   392: iconst_1
    //   393: putstatic 78	com/tencent/mm/plugin/normsg/b/f:mIe	Z
    //   396: return
    //   397: iload_0
    //   398: iconst_1
    //   399: iadd
    //   400: istore_0
    //   401: goto -161 -> 240
    //   404: astore_2
    //   405: aconst_null
    //   406: astore_2
    //   407: aload_2
    //   408: ifnull -83 -> 325
    //   411: aload_2
    //   412: invokevirtual 108	java/io/InputStream:close	()V
    //   415: goto -90 -> 325
    //   418: astore_2
    //   419: goto -94 -> 325
    //   422: astore_2
    //   423: aconst_null
    //   424: astore_3
    //   425: aload_3
    //   426: ifnull +7 -> 433
    //   429: aload_3
    //   430: invokevirtual 108	java/io/InputStream:close	()V
    //   433: aload_2
    //   434: athrow
    //   435: iload_0
    //   436: iconst_1
    //   437: iadd
    //   438: istore_0
    //   439: goto -96 -> 343
    //   442: iload_0
    //   443: iconst_1
    //   444: iadd
    //   445: istore_0
    //   446: goto -75 -> 371
    //   449: astore_2
    //   450: goto -125 -> 325
    //   453: astore_3
    //   454: goto -21 -> 433
    //   457: astore_3
    //   458: aload_2
    //   459: astore 4
    //   461: aload_3
    //   462: astore_2
    //   463: aload 4
    //   465: astore_3
    //   466: goto -41 -> 425
    //   469: astore 4
    //   471: goto -64 -> 407
    // Local variable table:
    //   start	length	slot	name	signature
    //   239	207	0	i	int
    //   237	137	1	j	int
    //   234	147	2	localObject1	Object
    //   404	1	2	localThrowable1	java.lang.Throwable
    //   406	6	2	localObject2	Object
    //   418	1	2	localIOException1	java.io.IOException
    //   422	12	2	localObject3	Object
    //   449	10	2	localIOException2	java.io.IOException
    //   462	1	2	localObject4	Object
    //   305	125	3	localObject5	Object
    //   453	1	3	localIOException3	java.io.IOException
    //   457	5	3	localObject6	Object
    //   465	1	3	localObject7	Object
    //   459	5	4	localIOException4	java.io.IOException
    //   469	1	4	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   306	315	404	java/lang/Throwable
    //   411	415	418	java/io/IOException
    //   306	315	422	finally
    //   321	325	449	java/io/IOException
    //   429	433	453	java/io/IOException
    //   315	321	457	finally
    //   315	321	469	java/lang/Throwable
  }
  
  private static String Kg(String paramString)
  {
    String[] arrayOfString = new String[3];
    arrayOfString[0] = ae.getContext().getFilesDir().getParent();
    arrayOfString[1] = paramString;
    arrayOfString[2] = f.class.toString();
    return new StringBuilder(arrayOfString[1].substring(arrayOfString[0].length() + 1)).reverse().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.f
 * JD-Core Version:    0.7.0.1
 */