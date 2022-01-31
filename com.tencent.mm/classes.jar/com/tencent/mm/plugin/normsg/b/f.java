package com.tencent.mm.plugin.normsg.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.File;

public final class f
{
  private static String[] pif;
  private static String[] pig;
  private static String[] pih;
  public static boolean pii;
  public static boolean pij;
  public static boolean pik;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: sipush 10440
    //   3: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iconst_2
    //   7: anewarray 26	java/lang/String
    //   10: dup
    //   11: iconst_0
    //   12: new 28	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   19: invokestatic 37	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   22: invokevirtual 43	android/content/Context:getFilesDir	()Ljava/io/File;
    //   25: invokevirtual 49	java/io/File:getParent	()Ljava/lang/String;
    //   28: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 55
    //   33: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 62	com/tencent/mm/plugin/normsg/b/f:decodeString	(Ljava/lang/String;)Ljava/lang/String;
    //   42: aastore
    //   43: dup
    //   44: iconst_1
    //   45: new 28	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   52: invokestatic 37	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   55: invokevirtual 43	android/content/Context:getFilesDir	()Ljava/io/File;
    //   58: invokevirtual 49	java/io/File:getParent	()Ljava/lang/String;
    //   61: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc 64
    //   66: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 62	com/tencent/mm/plugin/normsg/b/f:decodeString	(Ljava/lang/String;)Ljava/lang/String;
    //   75: aastore
    //   76: putstatic 66	com/tencent/mm/plugin/normsg/b/f:pif	[Ljava/lang/String;
    //   79: iconst_1
    //   80: anewarray 26	java/lang/String
    //   83: dup
    //   84: iconst_0
    //   85: new 28	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   92: invokestatic 37	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   95: invokevirtual 43	android/content/Context:getFilesDir	()Ljava/io/File;
    //   98: invokevirtual 49	java/io/File:getParent	()Ljava/lang/String;
    //   101: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc 68
    //   106: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 62	com/tencent/mm/plugin/normsg/b/f:decodeString	(Ljava/lang/String;)Ljava/lang/String;
    //   115: aastore
    //   116: putstatic 70	com/tencent/mm/plugin/normsg/b/f:pig	[Ljava/lang/String;
    //   119: iconst_3
    //   120: anewarray 26	java/lang/String
    //   123: dup
    //   124: iconst_0
    //   125: new 28	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   132: invokestatic 37	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   135: invokevirtual 43	android/content/Context:getFilesDir	()Ljava/io/File;
    //   138: invokevirtual 49	java/io/File:getParent	()Ljava/lang/String;
    //   141: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc 72
    //   146: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 62	com/tencent/mm/plugin/normsg/b/f:decodeString	(Ljava/lang/String;)Ljava/lang/String;
    //   155: aastore
    //   156: dup
    //   157: iconst_1
    //   158: new 28	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   165: invokestatic 37	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   168: invokevirtual 43	android/content/Context:getFilesDir	()Ljava/io/File;
    //   171: invokevirtual 49	java/io/File:getParent	()Ljava/lang/String;
    //   174: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: ldc 74
    //   179: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 62	com/tencent/mm/plugin/normsg/b/f:decodeString	(Ljava/lang/String;)Ljava/lang/String;
    //   188: aastore
    //   189: dup
    //   190: iconst_2
    //   191: new 28	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   198: invokestatic 37	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   201: invokevirtual 43	android/content/Context:getFilesDir	()Ljava/io/File;
    //   204: invokevirtual 49	java/io/File:getParent	()Ljava/lang/String;
    //   207: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: ldc 76
    //   212: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 62	com/tencent/mm/plugin/normsg/b/f:decodeString	(Ljava/lang/String;)Ljava/lang/String;
    //   221: aastore
    //   222: putstatic 78	com/tencent/mm/plugin/normsg/b/f:pih	[Ljava/lang/String;
    //   225: iconst_0
    //   226: putstatic 80	com/tencent/mm/plugin/normsg/b/f:pii	Z
    //   229: iconst_0
    //   230: putstatic 82	com/tencent/mm/plugin/normsg/b/f:pij	Z
    //   233: iconst_0
    //   234: putstatic 84	com/tencent/mm/plugin/normsg/b/f:pik	Z
    //   237: getstatic 66	com/tencent/mm/plugin/normsg/b/f:pif	[Ljava/lang/String;
    //   240: astore_2
    //   241: aload_2
    //   242: arraylength
    //   243: istore_1
    //   244: iconst_0
    //   245: istore_0
    //   246: iload_0
    //   247: iload_1
    //   248: if_icmpge +23 -> 271
    //   251: new 45	java/io/File
    //   254: dup
    //   255: aload_2
    //   256: iload_0
    //   257: aaload
    //   258: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   261: invokevirtual 91	java/io/File:exists	()Z
    //   264: ifeq +145 -> 409
    //   267: iconst_1
    //   268: putstatic 80	com/tencent/mm/plugin/normsg/b/f:pii	Z
    //   271: new 45	java/io/File
    //   274: dup
    //   275: ldc 93
    //   277: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   280: astore_2
    //   281: aload_2
    //   282: invokevirtual 91	java/io/File:exists	()Z
    //   285: ifeq +83 -> 368
    //   288: aload_2
    //   289: invokevirtual 96	java/io/File:canRead	()Z
    //   292: ifeq +76 -> 368
    //   295: aload_2
    //   296: invokevirtual 100	java/io/File:length	()J
    //   299: lconst_0
    //   300: lcmp
    //   301: ifle +67 -> 368
    //   304: aload_2
    //   305: invokevirtual 100	java/io/File:length	()J
    //   308: l2i
    //   309: newarray byte
    //   311: astore_3
    //   312: new 102	java/io/FileInputStream
    //   315: dup
    //   316: aload_2
    //   317: invokespecial 105	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   320: astore_2
    //   321: aload_2
    //   322: aload_3
    //   323: invokevirtual 111	java/io/InputStream:read	([B)I
    //   326: pop
    //   327: aload_2
    //   328: invokevirtual 114	java/io/InputStream:close	()V
    //   331: new 26	java/lang/String
    //   334: dup
    //   335: aload_3
    //   336: invokespecial 117	java/lang/String:<init>	([B)V
    //   339: astore_2
    //   340: getstatic 70	com/tencent/mm/plugin/normsg/b/f:pig	[Ljava/lang/String;
    //   343: astore_3
    //   344: aload_3
    //   345: arraylength
    //   346: istore_1
    //   347: iconst_0
    //   348: istore_0
    //   349: iload_0
    //   350: iload_1
    //   351: if_icmpge +17 -> 368
    //   354: aload_2
    //   355: aload_3
    //   356: iload_0
    //   357: aaload
    //   358: invokevirtual 121	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   361: ifeq +92 -> 453
    //   364: iconst_1
    //   365: putstatic 82	com/tencent/mm/plugin/normsg/b/f:pij	Z
    //   368: getstatic 78	com/tencent/mm/plugin/normsg/b/f:pih	[Ljava/lang/String;
    //   371: astore_2
    //   372: aload_2
    //   373: arraylength
    //   374: istore_1
    //   375: iconst_0
    //   376: istore_0
    //   377: iload_0
    //   378: iload_1
    //   379: if_icmpge +88 -> 467
    //   382: new 45	java/io/File
    //   385: dup
    //   386: aload_2
    //   387: iload_0
    //   388: aaload
    //   389: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   392: invokevirtual 91	java/io/File:exists	()Z
    //   395: ifeq +65 -> 460
    //   398: iconst_1
    //   399: putstatic 84	com/tencent/mm/plugin/normsg/b/f:pik	Z
    //   402: sipush 10440
    //   405: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   408: return
    //   409: iload_0
    //   410: iconst_1
    //   411: iadd
    //   412: istore_0
    //   413: goto -167 -> 246
    //   416: astore_2
    //   417: aconst_null
    //   418: astore_2
    //   419: aload_2
    //   420: ifnull -89 -> 331
    //   423: aload_2
    //   424: invokevirtual 114	java/io/InputStream:close	()V
    //   427: goto -96 -> 331
    //   430: astore_2
    //   431: goto -100 -> 331
    //   434: astore_2
    //   435: aconst_null
    //   436: astore_3
    //   437: aload_3
    //   438: ifnull +7 -> 445
    //   441: aload_3
    //   442: invokevirtual 114	java/io/InputStream:close	()V
    //   445: sipush 10440
    //   448: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   451: aload_2
    //   452: athrow
    //   453: iload_0
    //   454: iconst_1
    //   455: iadd
    //   456: istore_0
    //   457: goto -108 -> 349
    //   460: iload_0
    //   461: iconst_1
    //   462: iadd
    //   463: istore_0
    //   464: goto -87 -> 377
    //   467: sipush 10440
    //   470: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   473: return
    //   474: astore_2
    //   475: goto -144 -> 331
    //   478: astore_3
    //   479: goto -34 -> 445
    //   482: astore_3
    //   483: aload_2
    //   484: astore 4
    //   486: aload_3
    //   487: astore_2
    //   488: aload 4
    //   490: astore_3
    //   491: goto -54 -> 437
    //   494: astore 4
    //   496: goto -77 -> 419
    // Local variable table:
    //   start	length	slot	name	signature
    //   245	219	0	i	int
    //   243	137	1	j	int
    //   240	147	2	localObject1	Object
    //   416	1	2	localThrowable1	java.lang.Throwable
    //   418	6	2	localObject2	Object
    //   430	1	2	localIOException1	java.io.IOException
    //   434	18	2	localObject3	Object
    //   474	10	2	localIOException2	java.io.IOException
    //   487	1	2	localObject4	Object
    //   311	131	3	localObject5	Object
    //   478	1	3	localIOException3	java.io.IOException
    //   482	5	3	localObject6	Object
    //   490	1	3	localObject7	Object
    //   484	5	4	localIOException4	java.io.IOException
    //   494	1	4	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   312	321	416	java/lang/Throwable
    //   423	427	430	java/io/IOException
    //   312	321	434	finally
    //   327	331	474	java/io/IOException
    //   441	445	478	java/io/IOException
    //   321	327	482	finally
    //   321	327	494	java/lang/Throwable
  }
  
  private static String decodeString(String paramString)
  {
    AppMethodBeat.i(10439);
    String[] arrayOfString = new String[3];
    arrayOfString[0] = ah.getContext().getFilesDir().getParent();
    arrayOfString[1] = paramString;
    arrayOfString[2] = f.class.toString();
    paramString = new StringBuilder(arrayOfString[1].substring(arrayOfString[0].length() + 1)).reverse().toString();
    AppMethodBeat.o(10439);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.f
 * JD-Core Version:    0.7.0.1
 */