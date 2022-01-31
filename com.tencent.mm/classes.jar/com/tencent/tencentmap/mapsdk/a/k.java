package com.tencent.tencentmap.mapsdk.a;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class k
{
  public static final void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  /* Error */
  public static boolean a(File paramFile, String paramString)
  {
    // Byte code:
    //   0: new 20	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 24	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_3
    //   9: aload_3
    //   10: invokevirtual 28	java/io/File:exists	()Z
    //   13: ifne +8 -> 21
    //   16: aload_3
    //   17: invokevirtual 31	java/io/File:mkdirs	()Z
    //   20: pop
    //   21: new 33	java/util/zip/ZipFile
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 36	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   29: astore 5
    //   31: sipush 4096
    //   34: newarray byte
    //   36: astore 10
    //   38: aload 5
    //   40: invokevirtual 40	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   43: astore 11
    //   45: aconst_null
    //   46: astore 4
    //   48: aconst_null
    //   49: astore_0
    //   50: aload_0
    //   51: astore 8
    //   53: aload 4
    //   55: astore 7
    //   57: aload_0
    //   58: astore_3
    //   59: aload 5
    //   61: astore 6
    //   63: aload 11
    //   65: invokeinterface 45 1 0
    //   70: ifeq +438 -> 508
    //   73: aload_0
    //   74: astore 8
    //   76: aload 4
    //   78: astore 7
    //   80: aload_0
    //   81: astore_3
    //   82: aload 5
    //   84: astore 6
    //   86: aload 11
    //   88: invokeinterface 49 1 0
    //   93: checkcast 51	java/util/zip/ZipEntry
    //   96: astore 9
    //   98: aload_0
    //   99: astore 8
    //   101: aload 4
    //   103: astore 7
    //   105: aload_0
    //   106: astore_3
    //   107: aload 5
    //   109: astore 6
    //   111: aload 9
    //   113: invokevirtual 55	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   116: astore 12
    //   118: aload 12
    //   120: ifnull +26 -> 146
    //   123: aload_0
    //   124: astore 8
    //   126: aload 4
    //   128: astore 7
    //   130: aload_0
    //   131: astore_3
    //   132: aload 5
    //   134: astore 6
    //   136: aload 12
    //   138: ldc 57
    //   140: invokevirtual 63	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   143: ifne -93 -> 50
    //   146: aload_0
    //   147: astore 8
    //   149: aload 4
    //   151: astore 7
    //   153: aload_0
    //   154: astore_3
    //   155: aload 5
    //   157: astore 6
    //   159: aload 9
    //   161: invokevirtual 66	java/util/zip/ZipEntry:isDirectory	()Z
    //   164: ifeq +100 -> 264
    //   167: aload_0
    //   168: astore 8
    //   170: aload 4
    //   172: astore 7
    //   174: aload_0
    //   175: astore_3
    //   176: aload 5
    //   178: astore 6
    //   180: new 20	java/io/File
    //   183: dup
    //   184: new 68	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   191: aload_1
    //   192: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: getstatic 78	java/io/File:separator	Ljava/lang/String;
    //   198: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload 9
    //   203: invokevirtual 55	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   206: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokespecial 24	java/io/File:<init>	(Ljava/lang/String;)V
    //   215: invokevirtual 84	java/io/File:mkdir	()Z
    //   218: pop
    //   219: goto -169 -> 50
    //   222: astore_3
    //   223: aload 8
    //   225: astore_0
    //   226: aload 4
    //   228: astore_1
    //   229: aload_3
    //   230: astore 4
    //   232: aload_1
    //   233: astore 7
    //   235: aload_0
    //   236: astore_3
    //   237: aload 5
    //   239: astore 6
    //   241: aload 4
    //   243: invokestatic 90	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   246: invokestatic 95	com/tencent/tencentmap/mapsdk/a/rh:b	(Ljava/lang/String;)V
    //   249: aload_0
    //   250: invokestatic 97	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   253: aload_1
    //   254: invokestatic 97	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   257: aload 5
    //   259: invokevirtual 98	java/util/zip/ZipFile:close	()V
    //   262: iconst_0
    //   263: ireturn
    //   264: aload_0
    //   265: astore 8
    //   267: aload 4
    //   269: astore 7
    //   271: aload_0
    //   272: astore_3
    //   273: aload 5
    //   275: astore 6
    //   277: aload 5
    //   279: aload 9
    //   281: invokevirtual 102	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   284: astore_0
    //   285: aload_0
    //   286: astore 8
    //   288: aload 4
    //   290: astore 7
    //   292: aload_0
    //   293: astore_3
    //   294: aload 5
    //   296: astore 6
    //   298: new 20	java/io/File
    //   301: dup
    //   302: new 68	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   309: aload_1
    //   310: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: getstatic 78	java/io/File:separator	Ljava/lang/String;
    //   316: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload 9
    //   321: invokevirtual 55	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   324: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokespecial 24	java/io/File:<init>	(Ljava/lang/String;)V
    //   333: astore 9
    //   335: aload_0
    //   336: astore 8
    //   338: aload 4
    //   340: astore 7
    //   342: aload_0
    //   343: astore_3
    //   344: aload 5
    //   346: astore 6
    //   348: aload 9
    //   350: invokevirtual 28	java/io/File:exists	()Z
    //   353: ifne +87 -> 440
    //   356: aload_0
    //   357: astore 8
    //   359: aload 4
    //   361: astore 7
    //   363: aload_0
    //   364: astore_3
    //   365: aload 5
    //   367: astore 6
    //   369: aload 9
    //   371: invokevirtual 106	java/io/File:getParentFile	()Ljava/io/File;
    //   374: astore 12
    //   376: aload 12
    //   378: ifnull +43 -> 421
    //   381: aload_0
    //   382: astore 8
    //   384: aload 4
    //   386: astore 7
    //   388: aload_0
    //   389: astore_3
    //   390: aload 5
    //   392: astore 6
    //   394: aload 12
    //   396: invokevirtual 28	java/io/File:exists	()Z
    //   399: ifne +22 -> 421
    //   402: aload_0
    //   403: astore 8
    //   405: aload 4
    //   407: astore 7
    //   409: aload_0
    //   410: astore_3
    //   411: aload 5
    //   413: astore 6
    //   415: aload 12
    //   417: invokevirtual 31	java/io/File:mkdirs	()Z
    //   420: pop
    //   421: aload_0
    //   422: astore 8
    //   424: aload 4
    //   426: astore 7
    //   428: aload_0
    //   429: astore_3
    //   430: aload 5
    //   432: astore 6
    //   434: aload 9
    //   436: invokevirtual 109	java/io/File:createNewFile	()Z
    //   439: pop
    //   440: aload_0
    //   441: astore 8
    //   443: aload 4
    //   445: astore 7
    //   447: aload_0
    //   448: astore_3
    //   449: aload 5
    //   451: astore 6
    //   453: new 111	java/io/FileOutputStream
    //   456: dup
    //   457: aload 9
    //   459: invokespecial 112	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   462: astore 9
    //   464: aload_0
    //   465: aload 10
    //   467: invokevirtual 118	java/io/InputStream:read	([B)I
    //   470: istore_2
    //   471: iload_2
    //   472: ifle +15 -> 487
    //   475: aload 9
    //   477: aload 10
    //   479: iconst_0
    //   480: iload_2
    //   481: invokevirtual 124	java/io/OutputStream:write	([BII)V
    //   484: goto -20 -> 464
    //   487: aload 9
    //   489: invokevirtual 127	java/io/OutputStream:flush	()V
    //   492: aload_0
    //   493: invokestatic 97	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   496: aload 9
    //   498: invokestatic 97	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   501: aload 9
    //   503: astore 4
    //   505: goto -455 -> 50
    //   508: aload_0
    //   509: invokestatic 97	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   512: aload 4
    //   514: invokestatic 97	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   517: aload 5
    //   519: invokevirtual 98	java/util/zip/ZipFile:close	()V
    //   522: iconst_1
    //   523: ireturn
    //   524: astore_1
    //   525: aconst_null
    //   526: astore 4
    //   528: aconst_null
    //   529: astore_0
    //   530: aconst_null
    //   531: astore 5
    //   533: aload_0
    //   534: invokestatic 97	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   537: aload 4
    //   539: invokestatic 97	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/io/Closeable;)V
    //   542: aload 5
    //   544: invokevirtual 98	java/util/zip/ZipFile:close	()V
    //   547: aload_1
    //   548: athrow
    //   549: astore_0
    //   550: goto -28 -> 522
    //   553: astore_0
    //   554: goto -292 -> 262
    //   557: astore_0
    //   558: goto -11 -> 547
    //   561: astore_1
    //   562: aconst_null
    //   563: astore 4
    //   565: aconst_null
    //   566: astore_0
    //   567: goto -34 -> 533
    //   570: astore_1
    //   571: aload 9
    //   573: astore 4
    //   575: goto -42 -> 533
    //   578: astore_1
    //   579: aload 7
    //   581: astore 4
    //   583: aload_3
    //   584: astore_0
    //   585: aload 6
    //   587: astore 5
    //   589: goto -56 -> 533
    //   592: astore 4
    //   594: aconst_null
    //   595: astore_1
    //   596: aconst_null
    //   597: astore_0
    //   598: aconst_null
    //   599: astore 5
    //   601: goto -369 -> 232
    //   604: astore 4
    //   606: aconst_null
    //   607: astore_1
    //   608: aconst_null
    //   609: astore_0
    //   610: goto -378 -> 232
    //   613: astore 4
    //   615: aload 9
    //   617: astore_1
    //   618: goto -386 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	621	0	paramFile	File
    //   0	621	1	paramString	String
    //   470	11	2	i	int
    //   8	168	3	localFile1	File
    //   222	8	3	localException1	Exception
    //   236	348	3	localFile2	File
    //   46	536	4	localObject1	Object
    //   592	1	4	localException2	Exception
    //   604	1	4	localException3	Exception
    //   613	1	4	localException4	Exception
    //   29	571	5	localObject2	Object
    //   61	525	6	localObject3	Object
    //   55	525	7	localObject4	Object
    //   51	391	8	localFile3	File
    //   96	520	9	localObject5	Object
    //   36	442	10	arrayOfByte	byte[]
    //   43	44	11	localEnumeration	java.util.Enumeration
    //   116	300	12	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   63	73	222	java/lang/Exception
    //   86	98	222	java/lang/Exception
    //   111	118	222	java/lang/Exception
    //   136	146	222	java/lang/Exception
    //   159	167	222	java/lang/Exception
    //   180	219	222	java/lang/Exception
    //   277	285	222	java/lang/Exception
    //   298	335	222	java/lang/Exception
    //   348	356	222	java/lang/Exception
    //   369	376	222	java/lang/Exception
    //   394	402	222	java/lang/Exception
    //   415	421	222	java/lang/Exception
    //   434	440	222	java/lang/Exception
    //   453	464	222	java/lang/Exception
    //   21	31	524	finally
    //   517	522	549	java/io/IOException
    //   257	262	553	java/io/IOException
    //   542	547	557	java/io/IOException
    //   31	45	561	finally
    //   464	471	570	finally
    //   475	484	570	finally
    //   487	501	570	finally
    //   63	73	578	finally
    //   86	98	578	finally
    //   111	118	578	finally
    //   136	146	578	finally
    //   159	167	578	finally
    //   180	219	578	finally
    //   241	249	578	finally
    //   277	285	578	finally
    //   298	335	578	finally
    //   348	356	578	finally
    //   369	376	578	finally
    //   394	402	578	finally
    //   415	421	578	finally
    //   434	440	578	finally
    //   453	464	578	finally
    //   21	31	592	java/lang/Exception
    //   31	45	604	java/lang/Exception
    //   464	471	613	java/lang/Exception
    //   475	484	613	java/lang/Exception
    //   487	501	613	java/lang/Exception
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Stack localStack = new Stack();
    localStack.push(paramString);
    while (!localStack.isEmpty())
    {
      File localFile = new File((String)localStack.peek());
      if (localFile.exists())
      {
        if (localFile.isDirectory())
        {
          paramString = localFile.listFiles();
          if ((paramString == null) || (paramString.length == 0))
          {
            localFile.delete();
            localStack.pop();
          }
          else
          {
            int j = paramString.length;
            int i = 0;
            label96:
            if (i < j)
            {
              localFile = paramString[i];
              if (!localFile.isDirectory()) {
                break label131;
              }
              localStack.push(localFile.getAbsolutePath());
            }
            for (;;)
            {
              i += 1;
              break label96;
              break;
              label131:
              localFile.delete();
            }
          }
        }
        else
        {
          localFile.delete();
          localStack.pop();
        }
      }
      else {
        localStack.pop();
      }
    }
    return true;
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      paramString = new File(paramString);
      if ((paramString.exists()) && (paramString.isDirectory())) {
        return true;
      }
      if ((paramString.exists()) && (paramString.isFile())) {
        paramString.delete();
      }
      boolean bool = paramString.mkdirs();
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.k
 * JD-Core Version:    0.7.0.1
 */