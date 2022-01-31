package com.tencent.tencentmap.mapsdk.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class j
{
  public static final void a(Closeable paramCloseable)
  {
    AppMethodBeat.i(150428);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(150428);
        return;
      }
      catch (IOException paramCloseable) {}
    }
    AppMethodBeat.o(150428);
  }
  
  /* Error */
  public static boolean a(File paramFile, String paramString)
  {
    // Byte code:
    //   0: ldc 29
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 31	java/io/File
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 35	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 39	java/io/File:exists	()Z
    //   18: ifne +8 -> 26
    //   21: aload_3
    //   22: invokevirtual 42	java/io/File:mkdirs	()Z
    //   25: pop
    //   26: new 44	java/util/zip/ZipFile
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 47	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   34: astore 5
    //   36: sipush 4096
    //   39: newarray byte
    //   41: astore 10
    //   43: aload 5
    //   45: invokevirtual 51	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   48: astore 11
    //   50: aconst_null
    //   51: astore 4
    //   53: aconst_null
    //   54: astore_0
    //   55: aload_0
    //   56: astore 8
    //   58: aload 4
    //   60: astore 7
    //   62: aload_0
    //   63: astore_3
    //   64: aload 5
    //   66: astore 6
    //   68: aload 11
    //   70: invokeinterface 56 1 0
    //   75: ifeq +443 -> 518
    //   78: aload_0
    //   79: astore 8
    //   81: aload 4
    //   83: astore 7
    //   85: aload_0
    //   86: astore_3
    //   87: aload 5
    //   89: astore 6
    //   91: aload 11
    //   93: invokeinterface 60 1 0
    //   98: checkcast 62	java/util/zip/ZipEntry
    //   101: astore 9
    //   103: aload_0
    //   104: astore 8
    //   106: aload 4
    //   108: astore 7
    //   110: aload_0
    //   111: astore_3
    //   112: aload 5
    //   114: astore 6
    //   116: aload 9
    //   118: invokevirtual 66	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   121: astore 12
    //   123: aload 12
    //   125: ifnull +26 -> 151
    //   128: aload_0
    //   129: astore 8
    //   131: aload 4
    //   133: astore 7
    //   135: aload_0
    //   136: astore_3
    //   137: aload 5
    //   139: astore 6
    //   141: aload 12
    //   143: ldc 68
    //   145: invokevirtual 74	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   148: ifne -93 -> 55
    //   151: aload_0
    //   152: astore 8
    //   154: aload 4
    //   156: astore 7
    //   158: aload_0
    //   159: astore_3
    //   160: aload 5
    //   162: astore 6
    //   164: aload 9
    //   166: invokevirtual 77	java/util/zip/ZipEntry:isDirectory	()Z
    //   169: ifeq +105 -> 274
    //   172: aload_0
    //   173: astore 8
    //   175: aload 4
    //   177: astore 7
    //   179: aload_0
    //   180: astore_3
    //   181: aload 5
    //   183: astore 6
    //   185: new 31	java/io/File
    //   188: dup
    //   189: new 79	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   196: aload_1
    //   197: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: getstatic 89	java/io/File:separator	Ljava/lang/String;
    //   203: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload 9
    //   208: invokevirtual 66	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   211: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokespecial 35	java/io/File:<init>	(Ljava/lang/String;)V
    //   220: invokevirtual 95	java/io/File:mkdir	()Z
    //   223: pop
    //   224: goto -169 -> 55
    //   227: astore_3
    //   228: aload 8
    //   230: astore_0
    //   231: aload 4
    //   233: astore_1
    //   234: aload_3
    //   235: astore 4
    //   237: aload_1
    //   238: astore 7
    //   240: aload_0
    //   241: astore_3
    //   242: aload 5
    //   244: astore 6
    //   246: aload 4
    //   248: invokestatic 101	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   251: invokestatic 106	com/tencent/tencentmap/mapsdk/a/dw:b	(Ljava/lang/String;)V
    //   254: aload_0
    //   255: invokestatic 108	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   258: aload_1
    //   259: invokestatic 108	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   262: aload 5
    //   264: invokevirtual 109	java/util/zip/ZipFile:close	()V
    //   267: ldc 29
    //   269: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   272: iconst_0
    //   273: ireturn
    //   274: aload_0
    //   275: astore 8
    //   277: aload 4
    //   279: astore 7
    //   281: aload_0
    //   282: astore_3
    //   283: aload 5
    //   285: astore 6
    //   287: aload 5
    //   289: aload 9
    //   291: invokevirtual 113	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   294: astore_0
    //   295: aload_0
    //   296: astore 8
    //   298: aload 4
    //   300: astore 7
    //   302: aload_0
    //   303: astore_3
    //   304: aload 5
    //   306: astore 6
    //   308: new 31	java/io/File
    //   311: dup
    //   312: new 79	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   319: aload_1
    //   320: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: getstatic 89	java/io/File:separator	Ljava/lang/String;
    //   326: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload 9
    //   331: invokevirtual 66	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   334: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokespecial 35	java/io/File:<init>	(Ljava/lang/String;)V
    //   343: astore 9
    //   345: aload_0
    //   346: astore 8
    //   348: aload 4
    //   350: astore 7
    //   352: aload_0
    //   353: astore_3
    //   354: aload 5
    //   356: astore 6
    //   358: aload 9
    //   360: invokevirtual 39	java/io/File:exists	()Z
    //   363: ifne +87 -> 450
    //   366: aload_0
    //   367: astore 8
    //   369: aload 4
    //   371: astore 7
    //   373: aload_0
    //   374: astore_3
    //   375: aload 5
    //   377: astore 6
    //   379: aload 9
    //   381: invokevirtual 117	java/io/File:getParentFile	()Ljava/io/File;
    //   384: astore 12
    //   386: aload 12
    //   388: ifnull +43 -> 431
    //   391: aload_0
    //   392: astore 8
    //   394: aload 4
    //   396: astore 7
    //   398: aload_0
    //   399: astore_3
    //   400: aload 5
    //   402: astore 6
    //   404: aload 12
    //   406: invokevirtual 39	java/io/File:exists	()Z
    //   409: ifne +22 -> 431
    //   412: aload_0
    //   413: astore 8
    //   415: aload 4
    //   417: astore 7
    //   419: aload_0
    //   420: astore_3
    //   421: aload 5
    //   423: astore 6
    //   425: aload 12
    //   427: invokevirtual 42	java/io/File:mkdirs	()Z
    //   430: pop
    //   431: aload_0
    //   432: astore 8
    //   434: aload 4
    //   436: astore 7
    //   438: aload_0
    //   439: astore_3
    //   440: aload 5
    //   442: astore 6
    //   444: aload 9
    //   446: invokevirtual 120	java/io/File:createNewFile	()Z
    //   449: pop
    //   450: aload_0
    //   451: astore 8
    //   453: aload 4
    //   455: astore 7
    //   457: aload_0
    //   458: astore_3
    //   459: aload 5
    //   461: astore 6
    //   463: new 122	java/io/FileOutputStream
    //   466: dup
    //   467: aload 9
    //   469: invokespecial 123	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   472: astore 9
    //   474: aload_0
    //   475: aload 10
    //   477: invokevirtual 129	java/io/InputStream:read	([B)I
    //   480: istore_2
    //   481: iload_2
    //   482: ifle +15 -> 497
    //   485: aload 9
    //   487: aload 10
    //   489: iconst_0
    //   490: iload_2
    //   491: invokevirtual 135	java/io/OutputStream:write	([BII)V
    //   494: goto -20 -> 474
    //   497: aload 9
    //   499: invokevirtual 138	java/io/OutputStream:flush	()V
    //   502: aload_0
    //   503: invokestatic 108	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   506: aload 9
    //   508: invokestatic 108	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   511: aload 9
    //   513: astore 4
    //   515: goto -460 -> 55
    //   518: aload_0
    //   519: invokestatic 108	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   522: aload 4
    //   524: invokestatic 108	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   527: aload 5
    //   529: invokevirtual 109	java/util/zip/ZipFile:close	()V
    //   532: ldc 29
    //   534: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   537: iconst_1
    //   538: ireturn
    //   539: astore_1
    //   540: aconst_null
    //   541: astore 4
    //   543: aconst_null
    //   544: astore_0
    //   545: aconst_null
    //   546: astore 5
    //   548: aload_0
    //   549: invokestatic 108	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   552: aload 4
    //   554: invokestatic 108	com/tencent/tencentmap/mapsdk/a/j:a	(Ljava/io/Closeable;)V
    //   557: aload 5
    //   559: invokevirtual 109	java/util/zip/ZipFile:close	()V
    //   562: ldc 29
    //   564: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   567: aload_1
    //   568: athrow
    //   569: astore_0
    //   570: goto -38 -> 532
    //   573: astore_0
    //   574: goto -307 -> 267
    //   577: astore_0
    //   578: goto -16 -> 562
    //   581: astore_1
    //   582: aconst_null
    //   583: astore 4
    //   585: aconst_null
    //   586: astore_0
    //   587: goto -39 -> 548
    //   590: astore_1
    //   591: aload 9
    //   593: astore 4
    //   595: goto -47 -> 548
    //   598: astore_1
    //   599: aload 7
    //   601: astore 4
    //   603: aload_3
    //   604: astore_0
    //   605: aload 6
    //   607: astore 5
    //   609: goto -61 -> 548
    //   612: astore 4
    //   614: aconst_null
    //   615: astore_1
    //   616: aconst_null
    //   617: astore_0
    //   618: aconst_null
    //   619: astore 5
    //   621: goto -384 -> 237
    //   624: astore 4
    //   626: aconst_null
    //   627: astore_1
    //   628: aconst_null
    //   629: astore_0
    //   630: goto -393 -> 237
    //   633: astore 4
    //   635: aload 9
    //   637: astore_1
    //   638: goto -401 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	641	0	paramFile	File
    //   0	641	1	paramString	String
    //   480	11	2	i	int
    //   13	168	3	localFile1	File
    //   227	8	3	localException1	Exception
    //   241	363	3	localFile2	File
    //   51	551	4	localObject1	Object
    //   612	1	4	localException2	Exception
    //   624	1	4	localException3	Exception
    //   633	1	4	localException4	Exception
    //   34	586	5	localObject2	Object
    //   66	540	6	localObject3	Object
    //   60	540	7	localObject4	Object
    //   56	396	8	localFile3	File
    //   101	535	9	localObject5	Object
    //   41	447	10	arrayOfByte	byte[]
    //   48	44	11	localEnumeration	java.util.Enumeration
    //   121	305	12	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   68	78	227	java/lang/Exception
    //   91	103	227	java/lang/Exception
    //   116	123	227	java/lang/Exception
    //   141	151	227	java/lang/Exception
    //   164	172	227	java/lang/Exception
    //   185	224	227	java/lang/Exception
    //   287	295	227	java/lang/Exception
    //   308	345	227	java/lang/Exception
    //   358	366	227	java/lang/Exception
    //   379	386	227	java/lang/Exception
    //   404	412	227	java/lang/Exception
    //   425	431	227	java/lang/Exception
    //   444	450	227	java/lang/Exception
    //   463	474	227	java/lang/Exception
    //   26	36	539	finally
    //   527	532	569	java/io/IOException
    //   262	267	573	java/io/IOException
    //   557	562	577	java/io/IOException
    //   36	50	581	finally
    //   474	481	590	finally
    //   485	494	590	finally
    //   497	511	590	finally
    //   68	78	598	finally
    //   91	103	598	finally
    //   116	123	598	finally
    //   141	151	598	finally
    //   164	172	598	finally
    //   185	224	598	finally
    //   246	254	598	finally
    //   287	295	598	finally
    //   308	345	598	finally
    //   358	366	598	finally
    //   379	386	598	finally
    //   404	412	598	finally
    //   425	431	598	finally
    //   444	450	598	finally
    //   463	474	598	finally
    //   26	36	612	java/lang/Exception
    //   36	50	624	java/lang/Exception
    //   474	481	633	java/lang/Exception
    //   485	494	633	java/lang/Exception
    //   497	511	633	java/lang/Exception
  }
  
  public static boolean a(String paramString)
  {
    AppMethodBeat.i(150429);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(150429);
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
            label106:
            if (i < j)
            {
              localFile = paramString[i];
              if (!localFile.isDirectory()) {
                break label141;
              }
              localStack.push(localFile.getAbsolutePath());
            }
            for (;;)
            {
              i += 1;
              break label106;
              break;
              label141:
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
    AppMethodBeat.o(150429);
    return true;
  }
  
  public static boolean b(String paramString)
  {
    AppMethodBeat.i(150430);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(150430);
      return false;
    }
    try
    {
      paramString = new File(paramString);
      if (paramString.exists())
      {
        bool = paramString.isDirectory();
        if (bool)
        {
          AppMethodBeat.o(150430);
          return true;
        }
      }
      if ((paramString.exists()) && (paramString.isFile())) {
        paramString.delete();
      }
      boolean bool = paramString.mkdirs();
      AppMethodBeat.o(150430);
      return bool;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(150430);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.j
 * JD-Core Version:    0.7.0.1
 */