package com.tencent.mm.plugin.normsg.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.io.File;

public final class g
{
  private static String[] wKJ;
  private static String[] wKK;
  private static String[] wKL;
  public static boolean wKM;
  public static boolean wKN;
  public static boolean wKO;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: ldc 19
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iconst_2
    //   6: anewarray 27	java/lang/String
    //   9: dup
    //   10: iconst_0
    //   11: new 29	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   18: invokestatic 38	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   21: invokevirtual 44	android/content/Context:getFilesDir	()Ljava/io/File;
    //   24: invokevirtual 50	java/io/File:getParent	()Ljava/lang/String;
    //   27: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 56
    //   32: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 63	com/tencent/mm/plugin/normsg/c/g:decodeString	(Ljava/lang/String;)Ljava/lang/String;
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: new 29	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   51: invokestatic 38	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   54: invokevirtual 44	android/content/Context:getFilesDir	()Ljava/io/File;
    //   57: invokevirtual 50	java/io/File:getParent	()Ljava/lang/String;
    //   60: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: ldc 65
    //   65: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 63	com/tencent/mm/plugin/normsg/c/g:decodeString	(Ljava/lang/String;)Ljava/lang/String;
    //   74: aastore
    //   75: putstatic 67	com/tencent/mm/plugin/normsg/c/g:wKJ	[Ljava/lang/String;
    //   78: iconst_1
    //   79: anewarray 27	java/lang/String
    //   82: dup
    //   83: iconst_0
    //   84: new 29	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   91: invokestatic 38	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   94: invokevirtual 44	android/content/Context:getFilesDir	()Ljava/io/File;
    //   97: invokevirtual 50	java/io/File:getParent	()Ljava/lang/String;
    //   100: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc 69
    //   105: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 63	com/tencent/mm/plugin/normsg/c/g:decodeString	(Ljava/lang/String;)Ljava/lang/String;
    //   114: aastore
    //   115: putstatic 71	com/tencent/mm/plugin/normsg/c/g:wKK	[Ljava/lang/String;
    //   118: iconst_3
    //   119: anewarray 27	java/lang/String
    //   122: dup
    //   123: iconst_0
    //   124: new 29	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   131: invokestatic 38	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   134: invokevirtual 44	android/content/Context:getFilesDir	()Ljava/io/File;
    //   137: invokevirtual 50	java/io/File:getParent	()Ljava/lang/String;
    //   140: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc 73
    //   145: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 63	com/tencent/mm/plugin/normsg/c/g:decodeString	(Ljava/lang/String;)Ljava/lang/String;
    //   154: aastore
    //   155: dup
    //   156: iconst_1
    //   157: new 29	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   164: invokestatic 38	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   167: invokevirtual 44	android/content/Context:getFilesDir	()Ljava/io/File;
    //   170: invokevirtual 50	java/io/File:getParent	()Ljava/lang/String;
    //   173: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: ldc 75
    //   178: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 63	com/tencent/mm/plugin/normsg/c/g:decodeString	(Ljava/lang/String;)Ljava/lang/String;
    //   187: aastore
    //   188: dup
    //   189: iconst_2
    //   190: new 29	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   197: invokestatic 38	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   200: invokevirtual 44	android/content/Context:getFilesDir	()Ljava/io/File;
    //   203: invokevirtual 50	java/io/File:getParent	()Ljava/lang/String;
    //   206: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc 77
    //   211: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 63	com/tencent/mm/plugin/normsg/c/g:decodeString	(Ljava/lang/String;)Ljava/lang/String;
    //   220: aastore
    //   221: putstatic 79	com/tencent/mm/plugin/normsg/c/g:wKL	[Ljava/lang/String;
    //   224: iconst_0
    //   225: putstatic 81	com/tencent/mm/plugin/normsg/c/g:wKM	Z
    //   228: iconst_0
    //   229: putstatic 83	com/tencent/mm/plugin/normsg/c/g:wKN	Z
    //   232: iconst_0
    //   233: putstatic 85	com/tencent/mm/plugin/normsg/c/g:wKO	Z
    //   236: getstatic 67	com/tencent/mm/plugin/normsg/c/g:wKJ	[Ljava/lang/String;
    //   239: astore_2
    //   240: aload_2
    //   241: arraylength
    //   242: istore_1
    //   243: iconst_0
    //   244: istore_0
    //   245: iload_0
    //   246: iload_1
    //   247: if_icmpge +23 -> 270
    //   250: new 46	java/io/File
    //   253: dup
    //   254: aload_2
    //   255: iload_0
    //   256: aaload
    //   257: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   260: invokevirtual 92	java/io/File:exists	()Z
    //   263: ifeq +144 -> 407
    //   266: iconst_1
    //   267: putstatic 81	com/tencent/mm/plugin/normsg/c/g:wKM	Z
    //   270: new 46	java/io/File
    //   273: dup
    //   274: ldc 94
    //   276: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   279: astore_2
    //   280: aload_2
    //   281: invokevirtual 92	java/io/File:exists	()Z
    //   284: ifeq +83 -> 367
    //   287: aload_2
    //   288: invokevirtual 97	java/io/File:canRead	()Z
    //   291: ifeq +76 -> 367
    //   294: aload_2
    //   295: invokevirtual 101	java/io/File:length	()J
    //   298: lconst_0
    //   299: lcmp
    //   300: ifle +67 -> 367
    //   303: aload_2
    //   304: invokevirtual 101	java/io/File:length	()J
    //   307: l2i
    //   308: newarray byte
    //   310: astore_3
    //   311: new 103	java/io/FileInputStream
    //   314: dup
    //   315: aload_2
    //   316: invokespecial 106	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   319: astore_2
    //   320: aload_2
    //   321: aload_3
    //   322: invokevirtual 112	java/io/InputStream:read	([B)I
    //   325: pop
    //   326: aload_2
    //   327: invokevirtual 115	java/io/InputStream:close	()V
    //   330: new 27	java/lang/String
    //   333: dup
    //   334: aload_3
    //   335: invokespecial 118	java/lang/String:<init>	([B)V
    //   338: astore_2
    //   339: getstatic 71	com/tencent/mm/plugin/normsg/c/g:wKK	[Ljava/lang/String;
    //   342: astore_3
    //   343: aload_3
    //   344: arraylength
    //   345: istore_1
    //   346: iconst_0
    //   347: istore_0
    //   348: iload_0
    //   349: iload_1
    //   350: if_icmpge +17 -> 367
    //   353: aload_2
    //   354: aload_3
    //   355: iload_0
    //   356: aaload
    //   357: invokevirtual 122	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   360: ifeq +90 -> 450
    //   363: iconst_1
    //   364: putstatic 83	com/tencent/mm/plugin/normsg/c/g:wKN	Z
    //   367: getstatic 79	com/tencent/mm/plugin/normsg/c/g:wKL	[Ljava/lang/String;
    //   370: astore_2
    //   371: aload_2
    //   372: arraylength
    //   373: istore_1
    //   374: iconst_0
    //   375: istore_0
    //   376: iload_0
    //   377: iload_1
    //   378: if_icmpge +86 -> 464
    //   381: new 46	java/io/File
    //   384: dup
    //   385: aload_2
    //   386: iload_0
    //   387: aaload
    //   388: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   391: invokevirtual 92	java/io/File:exists	()Z
    //   394: ifeq +63 -> 457
    //   397: iconst_1
    //   398: putstatic 85	com/tencent/mm/plugin/normsg/c/g:wKO	Z
    //   401: ldc 19
    //   403: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   406: return
    //   407: iload_0
    //   408: iconst_1
    //   409: iadd
    //   410: istore_0
    //   411: goto -166 -> 245
    //   414: astore_2
    //   415: aconst_null
    //   416: astore_2
    //   417: aload_2
    //   418: ifnull -88 -> 330
    //   421: aload_2
    //   422: invokevirtual 115	java/io/InputStream:close	()V
    //   425: goto -95 -> 330
    //   428: astore_2
    //   429: goto -99 -> 330
    //   432: astore_2
    //   433: aconst_null
    //   434: astore_3
    //   435: aload_3
    //   436: ifnull +7 -> 443
    //   439: aload_3
    //   440: invokevirtual 115	java/io/InputStream:close	()V
    //   443: ldc 19
    //   445: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   448: aload_2
    //   449: athrow
    //   450: iload_0
    //   451: iconst_1
    //   452: iadd
    //   453: istore_0
    //   454: goto -106 -> 348
    //   457: iload_0
    //   458: iconst_1
    //   459: iadd
    //   460: istore_0
    //   461: goto -85 -> 376
    //   464: ldc 19
    //   466: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   469: return
    //   470: astore_2
    //   471: goto -141 -> 330
    //   474: astore_3
    //   475: goto -32 -> 443
    //   478: astore_3
    //   479: aload_2
    //   480: astore 4
    //   482: aload_3
    //   483: astore_2
    //   484: aload 4
    //   486: astore_3
    //   487: goto -52 -> 435
    //   490: astore 4
    //   492: goto -75 -> 417
    // Local variable table:
    //   start	length	slot	name	signature
    //   244	217	0	i	int
    //   242	137	1	j	int
    //   239	147	2	localObject1	Object
    //   414	1	2	localThrowable1	java.lang.Throwable
    //   416	6	2	localObject2	Object
    //   428	1	2	localIOException1	java.io.IOException
    //   432	17	2	localObject3	Object
    //   470	10	2	localIOException2	java.io.IOException
    //   483	1	2	localObject4	Object
    //   310	130	3	localObject5	Object
    //   474	1	3	localIOException3	java.io.IOException
    //   478	5	3	localObject6	Object
    //   486	1	3	localObject7	Object
    //   480	5	4	localIOException4	java.io.IOException
    //   490	1	4	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   311	320	414	java/lang/Throwable
    //   421	425	428	java/io/IOException
    //   311	320	432	finally
    //   326	330	470	java/io/IOException
    //   439	443	474	java/io/IOException
    //   320	326	478	finally
    //   320	326	490	java/lang/Throwable
  }
  
  private static String decodeString(String paramString)
  {
    AppMethodBeat.i(149092);
    String[] arrayOfString = new String[3];
    arrayOfString[0] = ak.getContext().getFilesDir().getParent();
    arrayOfString[1] = paramString;
    arrayOfString[2] = g.class.toString();
    paramString = new StringBuilder(arrayOfString[1].substring(arrayOfString[0].length() + 1)).reverse().toString();
    AppMethodBeat.o(149092);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.g
 * JD-Core Version:    0.7.0.1
 */