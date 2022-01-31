package com.tencent.ttpic.baseutils;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtils
{
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(49799);
    TAG = ZipUtils.class.getSimpleName();
    AppMethodBeat.o(49799);
  }
  
  private static void doZip(ZipOutputStream paramZipOutputStream, File paramFile, String paramString, byte[] paramArrayOfByte)
  {
    int i = 0;
    AppMethodBeat.i(49797);
    if ((paramZipOutputStream != null) && (paramFile != null))
    {
      if (!paramFile.exists())
      {
        paramZipOutputStream = new FileNotFoundException("Target File is missing");
        AppMethodBeat.o(49797);
        throw paramZipOutputStream;
      }
      if (TextUtils.isEmpty(paramString)) {
        paramString = paramFile.getName();
      }
    }
    for (;;)
    {
      if (paramFile.isFile()) {}
      for (;;)
      {
        try
        {
          paramFile = new BufferedInputStream(new FileInputStream(paramFile));
          try
          {
            paramZipOutputStream.putNextEntry(new ZipEntry(paramString));
            i = paramFile.read(paramArrayOfByte, 0, paramArrayOfByte.length);
            if (-1 != i)
            {
              paramZipOutputStream.write(paramArrayOfByte, 0, i);
              continue;
              if (paramFile == null) {}
            }
          }
          catch (IOException paramZipOutputStream) {}
        }
        catch (IOException paramZipOutputStream)
        {
          paramFile = null;
          continue;
        }
        try
        {
          paramFile.close();
          AppMethodBeat.o(49797);
          throw paramZipOutputStream;
          paramString = paramString + File.separator + paramFile.getName();
          break;
          try
          {
            paramFile.close();
            AppMethodBeat.o(49797);
            return;
          }
          catch (IOException paramZipOutputStream)
          {
            AppMethodBeat.o(49797);
            return;
          }
          if (paramFile.isDirectory())
          {
            paramFile = paramFile.listFiles();
            if (paramFile != null)
            {
              int j = paramFile.length;
              if (i < j)
              {
                doZip(paramZipOutputStream, paramFile[i], paramString, paramArrayOfByte);
                i += 1;
                continue;
              }
            }
          }
          AppMethodBeat.o(49797);
          return;
          paramZipOutputStream = new IOException("I/O Object got NullPointerException");
          AppMethodBeat.o(49797);
          throw paramZipOutputStream;
        }
        catch (IOException paramFile) {}
      }
    }
  }
  
  /* Error */
  public static String unZip(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 118
    //   5: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifeq +15 -> 27
    //   15: ldc 118
    //   17: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: aconst_null
    //   21: astore_0
    //   22: ldc 2
    //   24: monitorexit
    //   25: aload_0
    //   26: areturn
    //   27: new 37	java/io/File
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 119	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore_0
    //   36: aload_0
    //   37: invokevirtual 41	java/io/File:exists	()Z
    //   40: ifne +13 -> 53
    //   43: ldc 118
    //   45: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aconst_null
    //   49: astore_0
    //   50: goto -28 -> 22
    //   53: new 37	java/io/File
    //   56: dup
    //   57: aload_1
    //   58: invokespecial 119	java/io/File:<init>	(Ljava/lang/String;)V
    //   61: astore_3
    //   62: aload_3
    //   63: invokevirtual 41	java/io/File:exists	()Z
    //   66: ifne +8 -> 74
    //   69: aload_3
    //   70: invokevirtual 122	java/io/File:mkdirs	()Z
    //   73: pop
    //   74: new 64	java/io/FileInputStream
    //   77: dup
    //   78: aload_0
    //   79: invokespecial 67	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   82: astore 5
    //   84: new 124	java/util/zip/ZipInputStream
    //   87: dup
    //   88: new 62	java/io/BufferedInputStream
    //   91: dup
    //   92: aload 5
    //   94: invokespecial 70	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   97: invokespecial 125	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   100: astore 9
    //   102: aconst_null
    //   103: astore_0
    //   104: aconst_null
    //   105: astore_3
    //   106: aconst_null
    //   107: astore 4
    //   109: aload 4
    //   111: astore 6
    //   113: aload 9
    //   115: invokevirtual 129	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   118: astore 8
    //   120: aload 8
    //   122: ifnull +492 -> 614
    //   125: getstatic 23	com/tencent/ttpic/baseutils/ZipUtils:TAG	Ljava/lang/String;
    //   128: ldc 131
    //   130: aload 8
    //   132: invokestatic 137	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   135: invokevirtual 141	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   138: invokestatic 147	com/tencent/ttpic/baseutils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload 8
    //   143: invokevirtual 148	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   146: astore 7
    //   148: aload 6
    //   150: astore 4
    //   152: aload 7
    //   154: ldc 150
    //   156: invokevirtual 153	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   159: ifne -50 -> 109
    //   162: aload 8
    //   164: invokevirtual 154	java/util/zip/ZipEntry:isDirectory	()Z
    //   167: ifeq +99 -> 266
    //   170: new 92	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   177: aload_1
    //   178: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: getstatic 100	java/io/File:separator	Ljava/lang/String;
    //   184: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload 7
    //   189: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: astore 4
    //   197: getstatic 23	com/tencent/ttpic/baseutils/ZipUtils:TAG	Ljava/lang/String;
    //   200: ldc 156
    //   202: aload 4
    //   204: invokestatic 137	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   207: invokevirtual 141	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   210: invokestatic 147	com/tencent/ttpic/baseutils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: new 37	java/io/File
    //   216: dup
    //   217: aload 4
    //   219: invokespecial 119	java/io/File:<init>	(Ljava/lang/String;)V
    //   222: astore 7
    //   224: aload 7
    //   226: invokevirtual 41	java/io/File:exists	()Z
    //   229: ifne +9 -> 238
    //   232: aload 7
    //   234: invokevirtual 122	java/io/File:mkdirs	()Z
    //   237: pop
    //   238: aload 4
    //   240: aconst_null
    //   241: invokestatic 161	com/tencent/ttpic/baseutils/FileUtils:deleteFiles	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: aload 6
    //   246: astore 4
    //   248: aload 6
    //   250: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   253: ifeq -144 -> 109
    //   256: aload 7
    //   258: invokevirtual 164	java/io/File:getPath	()Ljava/lang/String;
    //   261: astore 4
    //   263: goto -154 -> 109
    //   266: sipush 4096
    //   269: newarray byte
    //   271: astore 10
    //   273: new 92	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   280: aload_1
    //   281: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: getstatic 100	java/io/File:separator	Ljava/lang/String;
    //   287: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload 7
    //   292: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: astore 4
    //   300: getstatic 23	com/tencent/ttpic/baseutils/ZipUtils:TAG	Ljava/lang/String;
    //   303: ldc 166
    //   305: aload 4
    //   307: invokestatic 137	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   310: invokevirtual 141	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   313: invokestatic 147	com/tencent/ttpic/baseutils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: new 37	java/io/File
    //   319: dup
    //   320: aload 4
    //   322: invokespecial 119	java/io/File:<init>	(Ljava/lang/String;)V
    //   325: astore 4
    //   327: new 168	java/io/FileOutputStream
    //   330: dup
    //   331: aload 4
    //   333: invokespecial 169	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   336: astore 4
    //   338: new 171	java/io/BufferedOutputStream
    //   341: dup
    //   342: aload 4
    //   344: sipush 4096
    //   347: invokespecial 174	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   350: astore_3
    //   351: aload_3
    //   352: astore 7
    //   354: aload 4
    //   356: astore 8
    //   358: aload 9
    //   360: aload 10
    //   362: invokevirtual 177	java/util/zip/ZipInputStream:read	([B)I
    //   365: istore_2
    //   366: iload_2
    //   367: iconst_m1
    //   368: if_icmpeq +67 -> 435
    //   371: aload_3
    //   372: astore 7
    //   374: aload 4
    //   376: astore 8
    //   378: aload_3
    //   379: aload 10
    //   381: iconst_0
    //   382: iload_2
    //   383: invokevirtual 178	java/io/BufferedOutputStream:write	([BII)V
    //   386: goto -35 -> 351
    //   389: astore 7
    //   391: aload_3
    //   392: astore_0
    //   393: aload 7
    //   395: astore_3
    //   396: aload_0
    //   397: astore 7
    //   399: aload 4
    //   401: astore 8
    //   403: aload_3
    //   404: invokestatic 182	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   407: aload_0
    //   408: ifnull +7 -> 415
    //   411: aload_0
    //   412: invokevirtual 183	java/io/BufferedOutputStream:close	()V
    //   415: aload 4
    //   417: ifnull +8 -> 425
    //   420: aload 4
    //   422: invokevirtual 184	java/io/FileOutputStream:close	()V
    //   425: aload 4
    //   427: astore_3
    //   428: aload 6
    //   430: astore 4
    //   432: goto -323 -> 109
    //   435: aload_3
    //   436: astore 7
    //   438: aload 4
    //   440: astore 8
    //   442: aload_3
    //   443: invokevirtual 187	java/io/BufferedOutputStream:flush	()V
    //   446: aload_3
    //   447: invokevirtual 183	java/io/BufferedOutputStream:close	()V
    //   450: aload 4
    //   452: invokevirtual 184	java/io/FileOutputStream:close	()V
    //   455: aload_3
    //   456: astore_0
    //   457: aload 4
    //   459: astore_3
    //   460: aload 6
    //   462: astore 4
    //   464: goto -355 -> 109
    //   467: astore_0
    //   468: aload_0
    //   469: invokestatic 182	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   472: aload_3
    //   473: astore_0
    //   474: aload 4
    //   476: astore_3
    //   477: aload 6
    //   479: astore 4
    //   481: goto -372 -> 109
    //   484: astore_3
    //   485: aload_3
    //   486: invokestatic 182	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   489: aload 4
    //   491: astore_3
    //   492: aload 6
    //   494: astore 4
    //   496: goto -387 -> 109
    //   499: astore_0
    //   500: aload 8
    //   502: astore 4
    //   504: aload 7
    //   506: ifnull +8 -> 514
    //   509: aload 7
    //   511: invokevirtual 183	java/io/BufferedOutputStream:close	()V
    //   514: aload 4
    //   516: ifnull +8 -> 524
    //   519: aload 4
    //   521: invokevirtual 184	java/io/FileOutputStream:close	()V
    //   524: ldc 118
    //   526: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   529: aload_0
    //   530: athrow
    //   531: astore 4
    //   533: aload 9
    //   535: astore_1
    //   536: aload 5
    //   538: astore_3
    //   539: aload 6
    //   541: astore_0
    //   542: aload 4
    //   544: invokestatic 182	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   547: aload_1
    //   548: ifnull +7 -> 555
    //   551: aload_1
    //   552: invokevirtual 188	java/util/zip/ZipInputStream:close	()V
    //   555: aload_3
    //   556: ifnull +7 -> 563
    //   559: aload_3
    //   560: invokevirtual 189	java/io/FileInputStream:close	()V
    //   563: ldc 118
    //   565: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   568: goto -546 -> 22
    //   571: astore_0
    //   572: ldc 2
    //   574: monitorexit
    //   575: aload_0
    //   576: athrow
    //   577: astore_1
    //   578: aload_1
    //   579: invokestatic 182	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   582: goto -58 -> 524
    //   585: astore_0
    //   586: aload 9
    //   588: astore_1
    //   589: aload_1
    //   590: ifnull +7 -> 597
    //   593: aload_1
    //   594: invokevirtual 188	java/util/zip/ZipInputStream:close	()V
    //   597: aload 5
    //   599: ifnull +8 -> 607
    //   602: aload 5
    //   604: invokevirtual 189	java/io/FileInputStream:close	()V
    //   607: ldc 118
    //   609: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   612: aload_0
    //   613: athrow
    //   614: aload 9
    //   616: invokevirtual 188	java/util/zip/ZipInputStream:close	()V
    //   619: aload 5
    //   621: invokevirtual 189	java/io/FileInputStream:close	()V
    //   624: aload 6
    //   626: astore_0
    //   627: goto -64 -> 563
    //   630: astore_0
    //   631: aload_0
    //   632: invokestatic 182	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   635: aload 6
    //   637: astore_0
    //   638: goto -75 -> 563
    //   641: astore_1
    //   642: aload_1
    //   643: invokestatic 182	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   646: goto -83 -> 563
    //   649: astore_1
    //   650: aload_1
    //   651: invokestatic 182	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   654: goto -47 -> 607
    //   657: astore_0
    //   658: aconst_null
    //   659: astore_1
    //   660: aconst_null
    //   661: astore 5
    //   663: goto -74 -> 589
    //   666: astore_0
    //   667: aconst_null
    //   668: astore_1
    //   669: goto -80 -> 589
    //   672: astore_0
    //   673: aload_3
    //   674: astore 5
    //   676: goto -87 -> 589
    //   679: astore 4
    //   681: aconst_null
    //   682: astore_1
    //   683: aconst_null
    //   684: astore_3
    //   685: aconst_null
    //   686: astore_0
    //   687: goto -145 -> 542
    //   690: astore 4
    //   692: aconst_null
    //   693: astore_1
    //   694: aload 5
    //   696: astore_3
    //   697: aconst_null
    //   698: astore_0
    //   699: goto -157 -> 542
    //   702: astore_1
    //   703: aload_0
    //   704: astore 7
    //   706: aload_1
    //   707: astore_0
    //   708: aload_3
    //   709: astore 4
    //   711: goto -207 -> 504
    //   714: astore_1
    //   715: aload_0
    //   716: astore 7
    //   718: aload_1
    //   719: astore_0
    //   720: goto -216 -> 504
    //   723: astore 7
    //   725: aload_3
    //   726: astore 4
    //   728: aload 7
    //   730: astore_3
    //   731: goto -335 -> 396
    //   734: astore_3
    //   735: goto -339 -> 396
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	738	0	paramString1	String
    //   0	738	1	paramString2	String
    //   365	18	2	i	int
    //   61	416	3	localObject1	Object
    //   484	2	3	localIOException1	IOException
    //   491	240	3	localObject2	Object
    //   734	1	3	localIOException2	IOException
    //   107	413	4	localObject3	Object
    //   531	12	4	localIOException3	IOException
    //   679	1	4	localIOException4	IOException
    //   690	1	4	localIOException5	IOException
    //   709	18	4	localObject4	Object
    //   82	613	5	localObject5	Object
    //   111	525	6	localObject6	Object
    //   146	227	7	localObject7	Object
    //   389	5	7	localIOException6	IOException
    //   397	320	7	localObject8	Object
    //   723	6	7	localIOException7	IOException
    //   118	383	8	localObject9	Object
    //   100	515	9	localZipInputStream	java.util.zip.ZipInputStream
    //   271	109	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   358	366	389	java/io/IOException
    //   378	386	389	java/io/IOException
    //   442	446	389	java/io/IOException
    //   446	455	467	java/io/IOException
    //   411	415	484	java/io/IOException
    //   420	425	484	java/io/IOException
    //   358	366	499	finally
    //   378	386	499	finally
    //   403	407	499	finally
    //   442	446	499	finally
    //   113	120	531	java/io/IOException
    //   125	148	531	java/io/IOException
    //   152	238	531	java/io/IOException
    //   238	244	531	java/io/IOException
    //   248	263	531	java/io/IOException
    //   266	327	531	java/io/IOException
    //   468	472	531	java/io/IOException
    //   485	489	531	java/io/IOException
    //   524	531	531	java/io/IOException
    //   578	582	531	java/io/IOException
    //   3	20	571	finally
    //   27	48	571	finally
    //   53	74	571	finally
    //   551	555	571	finally
    //   559	563	571	finally
    //   563	568	571	finally
    //   593	597	571	finally
    //   602	607	571	finally
    //   607	614	571	finally
    //   614	624	571	finally
    //   631	635	571	finally
    //   642	646	571	finally
    //   650	654	571	finally
    //   509	514	577	java/io/IOException
    //   519	524	577	java/io/IOException
    //   113	120	585	finally
    //   125	148	585	finally
    //   152	238	585	finally
    //   238	244	585	finally
    //   248	263	585	finally
    //   266	327	585	finally
    //   411	415	585	finally
    //   420	425	585	finally
    //   446	455	585	finally
    //   468	472	585	finally
    //   485	489	585	finally
    //   509	514	585	finally
    //   519	524	585	finally
    //   524	531	585	finally
    //   578	582	585	finally
    //   614	624	630	java/io/IOException
    //   551	555	641	java/io/IOException
    //   559	563	641	java/io/IOException
    //   593	597	649	java/io/IOException
    //   602	607	649	java/io/IOException
    //   74	84	657	finally
    //   84	102	666	finally
    //   542	547	672	finally
    //   74	84	679	java/io/IOException
    //   84	102	690	java/io/IOException
    //   327	338	702	finally
    //   338	351	714	finally
    //   327	338	723	java/io/IOException
    //   338	351	734	java/io/IOException
  }
  
  public static boolean zip(File paramFile1, File paramFile2)
  {
    AppMethodBeat.i(49795);
    boolean bool = zip(new File[] { paramFile1 }, paramFile2);
    AppMethodBeat.o(49795);
    return bool;
  }
  
  /* Error */
  public static boolean zip(File[] paramArrayOfFile, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: iconst_0
    //   4: istore 5
    //   6: ldc 196
    //   8: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: ifnull +142 -> 154
    //   15: aload_0
    //   16: arraylength
    //   17: ifle +137 -> 154
    //   20: aload_1
    //   21: ifnull +133 -> 154
    //   24: sipush 4096
    //   27: newarray byte
    //   29: astore 7
    //   31: new 75	java/util/zip/ZipOutputStream
    //   34: dup
    //   35: new 171	java/io/BufferedOutputStream
    //   38: dup
    //   39: new 168	java/io/FileOutputStream
    //   42: dup
    //   43: aload_1
    //   44: iconst_0
    //   45: invokespecial 199	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   48: invokespecial 202	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   51: invokespecial 203	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   54: astore_1
    //   55: aload_0
    //   56: arraylength
    //   57: istore_3
    //   58: iconst_0
    //   59: istore_2
    //   60: iload_2
    //   61: iload_3
    //   62: if_icmpge +20 -> 82
    //   65: aload_1
    //   66: aload_0
    //   67: iload_2
    //   68: aaload
    //   69: aconst_null
    //   70: aload 7
    //   72: invokestatic 112	com/tencent/ttpic/baseutils/ZipUtils:doZip	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;[B)V
    //   75: iload_2
    //   76: iconst_1
    //   77: iadd
    //   78: istore_2
    //   79: goto -19 -> 60
    //   82: aload_1
    //   83: invokevirtual 204	java/util/zip/ZipOutputStream:flush	()V
    //   86: aload_1
    //   87: invokevirtual 207	java/util/zip/ZipOutputStream:closeEntry	()V
    //   90: iconst_1
    //   91: istore 4
    //   93: aload_1
    //   94: invokevirtual 208	java/util/zip/ZipOutputStream:close	()V
    //   97: ldc 196
    //   99: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: iload 4
    //   104: ireturn
    //   105: astore_0
    //   106: aconst_null
    //   107: astore_1
    //   108: iload 5
    //   110: istore 4
    //   112: aload_1
    //   113: ifnull -16 -> 97
    //   116: aload_1
    //   117: invokevirtual 208	java/util/zip/ZipOutputStream:close	()V
    //   120: iload 5
    //   122: istore 4
    //   124: goto -27 -> 97
    //   127: astore_0
    //   128: iload 5
    //   130: istore 4
    //   132: goto -35 -> 97
    //   135: astore_0
    //   136: aload 6
    //   138: astore_1
    //   139: aload_1
    //   140: ifnull +7 -> 147
    //   143: aload_1
    //   144: invokevirtual 208	java/util/zip/ZipOutputStream:close	()V
    //   147: ldc 196
    //   149: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload_0
    //   153: athrow
    //   154: ldc 196
    //   156: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: iconst_0
    //   160: ireturn
    //   161: astore_0
    //   162: goto -65 -> 97
    //   165: astore_1
    //   166: goto -19 -> 147
    //   169: astore_0
    //   170: goto -31 -> 139
    //   173: astore_0
    //   174: goto -66 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramArrayOfFile	File[]
    //   0	177	1	paramFile	File
    //   59	20	2	i	int
    //   57	6	3	j	int
    //   91	40	4	bool1	boolean
    //   4	125	5	bool2	boolean
    //   1	136	6	localObject	Object
    //   29	42	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   24	55	105	java/io/IOException
    //   116	120	127	java/io/IOException
    //   24	55	135	finally
    //   93	97	161	java/io/IOException
    //   143	147	165	java/io/IOException
    //   55	58	169	finally
    //   65	75	169	finally
    //   82	90	169	finally
    //   55	58	173	java/io/IOException
    //   65	75	173	java/io/IOException
    //   82	90	173	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.ZipUtils
 * JD-Core Version:    0.7.0.1
 */