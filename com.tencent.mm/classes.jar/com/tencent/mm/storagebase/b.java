package com.tencent.mm.storagebase;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  static final boolean Jje;
  
  static
  {
    boolean bool = false;
    AppMethodBeat.i(133325);
    String str;
    int i;
    if ((Build.VERSION.SDK_INT == 28) && (Build.BRAND.equals("samsung")))
    {
      str = Build.HARDWARE.toLowerCase();
      i = -1;
      switch (str.hashCode())
      {
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        bool = true;
      }
      Jje = bool;
      AppMethodBeat.o(133325);
      return;
      if (str.equals("exynos7884"))
      {
        i = 0;
        continue;
        if (str.equals("exynos7884a"))
        {
          i = 1;
          continue;
          if (str.equals("exynos7884b"))
          {
            i = 2;
            continue;
            if (str.equals("exynos7885"))
            {
              i = 3;
              continue;
              if (str.equals("exynos7904"))
              {
                i = 4;
                continue;
                if (str.equals("exynos7905")) {
                  i = 5;
                }
              }
            }
          }
        }
      }
    }
  }
  
  /* Error */
  static String fxG()
  {
    // Byte code:
    //   0: ldc 70
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 76	android/os/Environment:getDataDirectory	()Ljava/io/File;
    //   8: invokevirtual 81	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   11: astore 9
    //   13: ldc 83
    //   15: astore 6
    //   17: ldc 83
    //   19: astore 7
    //   21: ldc 83
    //   23: astore 4
    //   25: new 85	java/io/BufferedReader
    //   28: dup
    //   29: new 87	com/tencent/mm/vfs/q
    //   32: dup
    //   33: ldc 89
    //   35: invokespecial 93	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   38: invokespecial 96	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   41: astore 8
    //   43: aload 8
    //   45: astore_3
    //   46: aload 4
    //   48: astore 5
    //   50: aload 6
    //   52: astore_2
    //   53: ldc 98
    //   55: invokestatic 104	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   58: astore 10
    //   60: aload 8
    //   62: astore_3
    //   63: aload 4
    //   65: astore 5
    //   67: aload 6
    //   69: astore_2
    //   70: aload 8
    //   72: invokevirtual 107	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   75: astore 11
    //   77: aload 4
    //   79: astore_1
    //   80: aload 6
    //   82: astore_0
    //   83: aload 11
    //   85: ifnull +98 -> 183
    //   88: aload 8
    //   90: astore_3
    //   91: aload 4
    //   93: astore 5
    //   95: aload 6
    //   97: astore_2
    //   98: aload 10
    //   100: aload 11
    //   102: invokevirtual 111	java/util/regex/Pattern:split	(Ljava/lang/CharSequence;)[Ljava/lang/String;
    //   105: astore 11
    //   107: aload 8
    //   109: astore_3
    //   110: aload 4
    //   112: astore 5
    //   114: aload 6
    //   116: astore_2
    //   117: aload 11
    //   119: arraylength
    //   120: iconst_3
    //   121: if_icmplt -61 -> 60
    //   124: aload 8
    //   126: astore_3
    //   127: aload 4
    //   129: astore 5
    //   131: aload 6
    //   133: astore_2
    //   134: aload 11
    //   136: iconst_1
    //   137: aaload
    //   138: aload 9
    //   140: invokevirtual 35	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   143: ifeq -83 -> 60
    //   146: aload 11
    //   148: iconst_2
    //   149: aaload
    //   150: astore 6
    //   152: aload 4
    //   154: astore_1
    //   155: aload 6
    //   157: astore_0
    //   158: aload 8
    //   160: astore_3
    //   161: aload 4
    //   163: astore 5
    //   165: aload 6
    //   167: astore_2
    //   168: aload 11
    //   170: arraylength
    //   171: iconst_3
    //   172: if_icmple +11 -> 183
    //   175: aload 11
    //   177: iconst_3
    //   178: aaload
    //   179: astore_1
    //   180: aload 6
    //   182: astore_0
    //   183: aload 8
    //   185: astore_3
    //   186: aload_1
    //   187: astore 5
    //   189: aload_0
    //   190: astore_2
    //   191: new 113	android/os/StatFs
    //   194: dup
    //   195: aload 9
    //   197: invokespecial 114	android/os/StatFs:<init>	(Ljava/lang/String;)V
    //   200: astore 6
    //   202: aload 7
    //   204: astore 4
    //   206: aload 8
    //   208: astore_3
    //   209: aload_1
    //   210: astore 5
    //   212: aload_0
    //   213: astore_2
    //   214: aload 6
    //   216: invokevirtual 117	android/os/StatFs:getBlockSize	()I
    //   219: ifle +55 -> 274
    //   222: aload 8
    //   224: astore_3
    //   225: aload_1
    //   226: astore 5
    //   228: aload_0
    //   229: astore_2
    //   230: ldc 119
    //   232: iconst_3
    //   233: anewarray 4	java/lang/Object
    //   236: dup
    //   237: iconst_0
    //   238: aload 6
    //   240: invokevirtual 117	android/os/StatFs:getBlockSize	()I
    //   243: invokestatic 125	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   246: aastore
    //   247: dup
    //   248: iconst_1
    //   249: aload 6
    //   251: invokevirtual 128	android/os/StatFs:getAvailableBlocks	()I
    //   254: invokestatic 125	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   257: aastore
    //   258: dup
    //   259: iconst_2
    //   260: aload 6
    //   262: invokevirtual 131	android/os/StatFs:getBlockCount	()I
    //   265: invokestatic 125	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   268: aastore
    //   269: invokestatic 135	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   272: astore 4
    //   274: aload 8
    //   276: invokevirtual 138	java/io/BufferedReader:close	()V
    //   279: aload_0
    //   280: astore 5
    //   282: aload 4
    //   284: astore_3
    //   285: new 140	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   292: aload 5
    //   294: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: bipush 10
    //   299: invokevirtual 149	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   302: aload_3
    //   303: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: bipush 10
    //   308: invokevirtual 149	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   311: aload_1
    //   312: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: astore_0
    //   319: ldc 70
    //   321: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   324: aload_0
    //   325: areturn
    //   326: astore_1
    //   327: aconst_null
    //   328: astore_0
    //   329: aload 6
    //   331: astore_2
    //   332: aload_0
    //   333: astore_3
    //   334: ldc 154
    //   336: new 140	java/lang/StringBuilder
    //   339: dup
    //   340: ldc 156
    //   342: invokespecial 157	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   345: aload_1
    //   346: invokevirtual 160	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   349: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: invokestatic 166	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   358: aload 4
    //   360: astore_1
    //   361: aload 7
    //   363: astore_3
    //   364: aload_2
    //   365: astore 5
    //   367: aload_0
    //   368: ifnull -83 -> 285
    //   371: aload_0
    //   372: invokevirtual 138	java/io/BufferedReader:close	()V
    //   375: aload 4
    //   377: astore_1
    //   378: aload 7
    //   380: astore_3
    //   381: aload_2
    //   382: astore 5
    //   384: goto -99 -> 285
    //   387: astore_0
    //   388: aload 4
    //   390: astore_1
    //   391: aload 7
    //   393: astore_3
    //   394: aload_2
    //   395: astore 5
    //   397: goto -112 -> 285
    //   400: astore_0
    //   401: aconst_null
    //   402: astore_3
    //   403: aload_3
    //   404: ifnull +7 -> 411
    //   407: aload_3
    //   408: invokevirtual 138	java/io/BufferedReader:close	()V
    //   411: ldc 70
    //   413: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   416: aload_0
    //   417: athrow
    //   418: astore_2
    //   419: aload 4
    //   421: astore_3
    //   422: aload_0
    //   423: astore 5
    //   425: goto -140 -> 285
    //   428: astore_1
    //   429: goto -18 -> 411
    //   432: astore_0
    //   433: goto -30 -> 403
    //   436: astore_1
    //   437: aload 5
    //   439: astore 4
    //   441: aload 8
    //   443: astore_0
    //   444: goto -112 -> 332
    // Local variable table:
    //   start	length	slot	name	signature
    //   82	290	0	localObject1	Object
    //   387	1	0	localIOException1	java.io.IOException
    //   400	23	0	localObject2	Object
    //   432	1	0	localObject3	Object
    //   443	1	0	localBufferedReader1	java.io.BufferedReader
    //   79	233	1	localObject4	Object
    //   326	20	1	localException1	java.lang.Exception
    //   360	31	1	localObject5	Object
    //   428	1	1	localIOException2	java.io.IOException
    //   436	1	1	localException2	java.lang.Exception
    //   52	343	2	localObject6	Object
    //   418	1	2	localIOException3	java.io.IOException
    //   45	377	3	localObject7	Object
    //   23	417	4	localObject8	Object
    //   48	390	5	localObject9	Object
    //   15	315	6	localObject10	Object
    //   19	373	7	str1	String
    //   41	401	8	localBufferedReader2	java.io.BufferedReader
    //   11	185	9	str2	String
    //   58	41	10	localPattern	java.util.regex.Pattern
    //   75	101	11	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   25	43	326	java/lang/Exception
    //   371	375	387	java/io/IOException
    //   25	43	400	finally
    //   274	279	418	java/io/IOException
    //   407	411	428	java/io/IOException
    //   53	60	432	finally
    //   70	77	432	finally
    //   98	107	432	finally
    //   117	124	432	finally
    //   134	146	432	finally
    //   168	175	432	finally
    //   191	202	432	finally
    //   214	222	432	finally
    //   230	274	432	finally
    //   334	358	432	finally
    //   53	60	436	java/lang/Exception
    //   70	77	436	java/lang/Exception
    //   98	107	436	java/lang/Exception
    //   117	124	436	java/lang/Exception
    //   134	146	436	java/lang/Exception
    //   168	175	436	java/lang/Exception
    //   191	202	436	java/lang/Exception
    //   214	222	436	java/lang/Exception
    //   230	274	436	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storagebase.b
 * JD-Core Version:    0.7.0.1
 */