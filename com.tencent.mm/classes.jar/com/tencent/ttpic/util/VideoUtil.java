package com.tencent.ttpic.util;

import android.graphics.PointF;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.util.g;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

public class VideoUtil
{
  public static final String[] GPU_GL_ONE_THREAD = { "PowerVR SGX 544MP", "Adreno (TM) 306" };
  public static final String RES_PREFIX_ASSETS = "assets://";
  public static final String RES_PREFIX_HTTP = "http://";
  public static final String RES_PREFIX_HTTPS = "https://";
  public static final String RES_PREFIX_STORAGE = "/";
  private static final String TAG = VideoUtil.class.getSimpleName();
  public static final String THREAD_NAME_MEM = "mMemThread";
  
  public static List<Float> arrayToList(float[] paramArrayOfFloat)
  {
    ArrayList localArrayList = new ArrayList();
    if (isEmpty(paramArrayOfFloat)) {}
    for (;;)
    {
      return localArrayList;
      int j = paramArrayOfFloat.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(Float.valueOf(paramArrayOfFloat[i]));
        i += 1;
      }
    }
  }
  
  public static List<Integer> arrayToList(int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (isEmpty(paramArrayOfInt)) {}
    for (;;)
    {
      return localArrayList;
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(Integer.valueOf(paramArrayOfInt[i]));
        i += 1;
      }
    }
  }
  
  public static int daysBetween(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = new SimpleDateFormat("yyyy-MM-dd");
      paramString1 = ((SimpleDateFormat)localObject).parse(paramString1);
      paramString2 = ((SimpleDateFormat)localObject).parse(paramString2);
      localObject = Calendar.getInstance();
      ((Calendar)localObject).setTime(paramString1);
      long l = ((Calendar)localObject).getTimeInMillis();
      ((Calendar)localObject).setTime(paramString2);
      l = (((Calendar)localObject).getTimeInMillis() - l) / 86400000L;
      return (int)l;
    }
    catch (Exception paramString1)
    {
      g.i(TAG, paramString1.getMessage());
    }
    return 0;
  }
  
  public static float getFaceAngle(List<PointF> paramList)
  {
    float f1 = -1.0F;
    if (isEmpty(paramList)) {
      return 0.0F;
    }
    PointF localPointF = (PointF)paramList.get(0);
    paramList = (PointF)paramList.get(18);
    float f2 = paramList.x - localPointF.x;
    float f3 = paramList.x - localPointF.x;
    float f4 = paramList.y - localPointF.y;
    f2 = (f2 * f3 + 0.0F * f4) / ((float)Math.sqrt(0.0F + f2 * f2) * (float)Math.sqrt(f3 * f3 + f4 * f4));
    if ((f2 < -1.0F) && (f2 > -2.0F)) {}
    for (;;)
    {
      f1 = (float)Math.acos(f1);
      if (localPointF.y < paramList.y)
      {
        return -f1;
        if ((f2 > 1.0F) && (f2 < 2.0F)) {
          f1 = 1.0F;
        }
      }
      else
      {
        return f1;
      }
      f1 = f2;
    }
  }
  
  public static String getRealPath(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramString.startsWith("assets://")) {
        str = paramString.substring(9);
      }
    }
    return str;
  }
  
  public static boolean hasHoneycomb()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  public static boolean hasJellyBeanMR1()
  {
    return Build.VERSION.SDK_INT >= 17;
  }
  
  public static boolean hasJellyBeanMR2()
  {
    return Build.VERSION.SDK_INT >= 18;
  }
  
  public static boolean hasKitKat()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
  
  public static boolean indexOutOfBounds(Collection paramCollection, int paramInt)
  {
    return (paramCollection == null) || (paramInt < 0) || (paramInt >= paramCollection.size());
  }
  
  public static boolean indexOutOfBounds(FaceStatus[] paramArrayOfFaceStatus, int paramInt)
  {
    return (paramArrayOfFaceStatus == null) || (paramInt < 0) || (paramInt >= paramArrayOfFaceStatus.length);
  }
  
  public static boolean isEmpty(Collection paramCollection)
  {
    return (paramCollection == null) || (paramCollection.isEmpty());
  }
  
  private static boolean isEmpty(float[] paramArrayOfFloat)
  {
    return (paramArrayOfFloat == null) || (paramArrayOfFloat.length == 0);
  }
  
  private static boolean isEmpty(int[] paramArrayOfInt)
  {
    return (paramArrayOfInt == null) || (paramArrayOfInt.length == 0);
  }
  
  public static boolean isInOneGLThreadBlackList()
  {
    boolean bool2 = false;
    Object localObject = VideoDeviceUtil.getGPUInfo().split(";");
    boolean bool1 = bool2;
    String[] arrayOfString;
    int j;
    int i;
    if (localObject.length > 0)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(localObject[0]))
      {
        localObject = localObject[0].trim().toLowerCase();
        arrayOfString = GPU_GL_ONE_THREAD;
        j = arrayOfString.length;
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (((String)localObject).equals(arrayOfString[i].toLowerCase())) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static void printLength(BaseFilter paramBaseFilter)
  {
    while (paramBaseFilter != null) {
      paramBaseFilter = paramBaseFilter.getmNextFilter();
    }
  }
  
  public static void printLength(h paramh) {}
  
  /* Error */
  public static String unZip(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: istore_3
    //   8: iload_3
    //   9: ifeq +10 -> 19
    //   12: aconst_null
    //   13: astore_1
    //   14: ldc 2
    //   16: monitorexit
    //   17: aload_1
    //   18: areturn
    //   19: new 221	java/io/File
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 222	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore_0
    //   28: aload_0
    //   29: invokevirtual 225	java/io/File:exists	()Z
    //   32: ifne +8 -> 40
    //   35: aconst_null
    //   36: astore_1
    //   37: goto -23 -> 14
    //   40: new 221	java/io/File
    //   43: dup
    //   44: aload_1
    //   45: invokespecial 222	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: astore 4
    //   50: aload 4
    //   52: invokevirtual 225	java/io/File:exists	()Z
    //   55: ifne +9 -> 64
    //   58: aload 4
    //   60: invokevirtual 228	java/io/File:mkdirs	()Z
    //   63: pop
    //   64: new 230	java/io/FileInputStream
    //   67: dup
    //   68: aload_0
    //   69: invokespecial 233	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   72: astore 6
    //   74: new 235	java/util/zip/ZipInputStream
    //   77: dup
    //   78: new 237	java/io/BufferedInputStream
    //   81: dup
    //   82: aload 6
    //   84: invokespecial 240	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   87: invokespecial 241	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   90: astore 8
    //   92: aconst_null
    //   93: astore_0
    //   94: aconst_null
    //   95: astore 4
    //   97: aconst_null
    //   98: astore 5
    //   100: aload 5
    //   102: astore 7
    //   104: aload 8
    //   106: invokevirtual 245	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   109: astore 9
    //   111: aload 9
    //   113: ifnull +349 -> 462
    //   116: aload 9
    //   118: invokevirtual 250	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   121: astore 10
    //   123: aload 7
    //   125: astore 5
    //   127: aload 10
    //   129: ldc 252
    //   131: invokevirtual 255	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   134: ifne -34 -> 100
    //   137: aload 9
    //   139: invokevirtual 258	java/util/zip/ZipEntry:isDirectory	()Z
    //   142: ifeq +73 -> 215
    //   145: new 221	java/io/File
    //   148: dup
    //   149: new 260	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   156: aload_1
    //   157: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: getstatic 268	java/io/File:separator	Ljava/lang/String;
    //   163: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload 10
    //   168: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokespecial 222	java/io/File:<init>	(Ljava/lang/String;)V
    //   177: astore 9
    //   179: aload 9
    //   181: invokevirtual 225	java/io/File:exists	()Z
    //   184: ifne +9 -> 193
    //   187: aload 9
    //   189: invokevirtual 228	java/io/File:mkdirs	()Z
    //   192: pop
    //   193: aload 7
    //   195: astore 5
    //   197: aload 7
    //   199: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   202: ifeq -102 -> 100
    //   205: aload 9
    //   207: invokevirtual 274	java/io/File:getPath	()Ljava/lang/String;
    //   210: astore 5
    //   212: goto -112 -> 100
    //   215: sipush 4096
    //   218: newarray byte
    //   220: astore 9
    //   222: new 221	java/io/File
    //   225: dup
    //   226: new 260	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   233: aload_1
    //   234: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: getstatic 268	java/io/File:separator	Ljava/lang/String;
    //   240: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload 10
    //   245: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokespecial 222	java/io/File:<init>	(Ljava/lang/String;)V
    //   254: astore 5
    //   256: new 276	java/io/FileOutputStream
    //   259: dup
    //   260: aload 5
    //   262: invokespecial 277	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   265: astore 5
    //   267: new 279	java/io/BufferedOutputStream
    //   270: dup
    //   271: aload 5
    //   273: sipush 4096
    //   276: invokespecial 282	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   279: astore 4
    //   281: aload 8
    //   283: aload 9
    //   285: invokevirtual 286	java/util/zip/ZipInputStream:read	([B)I
    //   288: istore_2
    //   289: iload_2
    //   290: iconst_m1
    //   291: if_icmpeq +48 -> 339
    //   294: aload 4
    //   296: aload 9
    //   298: iconst_0
    //   299: iload_2
    //   300: invokevirtual 290	java/io/BufferedOutputStream:write	([BII)V
    //   303: goto -22 -> 281
    //   306: astore_0
    //   307: aload 4
    //   309: astore_0
    //   310: aload_0
    //   311: ifnull +7 -> 318
    //   314: aload_0
    //   315: invokevirtual 293	java/io/BufferedOutputStream:close	()V
    //   318: aload 5
    //   320: ifnull +8 -> 328
    //   323: aload 5
    //   325: invokevirtual 294	java/io/FileOutputStream:close	()V
    //   328: aload 5
    //   330: astore 4
    //   332: aload 7
    //   334: astore 5
    //   336: goto -236 -> 100
    //   339: aload 4
    //   341: invokevirtual 297	java/io/BufferedOutputStream:flush	()V
    //   344: aload 4
    //   346: invokevirtual 293	java/io/BufferedOutputStream:close	()V
    //   349: aload 5
    //   351: invokevirtual 294	java/io/FileOutputStream:close	()V
    //   354: aload 4
    //   356: astore_0
    //   357: aload 5
    //   359: astore 4
    //   361: aload 7
    //   363: astore 5
    //   365: goto -265 -> 100
    //   368: astore_0
    //   369: aload 4
    //   371: astore_0
    //   372: aload 5
    //   374: astore 4
    //   376: aload 7
    //   378: astore 5
    //   380: goto -280 -> 100
    //   383: astore 4
    //   385: aload 5
    //   387: astore 4
    //   389: aload 7
    //   391: astore 5
    //   393: goto -293 -> 100
    //   396: astore_0
    //   397: aload 4
    //   399: astore_1
    //   400: aload_1
    //   401: ifnull +7 -> 408
    //   404: aload_1
    //   405: invokevirtual 293	java/io/BufferedOutputStream:close	()V
    //   408: aload 5
    //   410: ifnull +8 -> 418
    //   413: aload 5
    //   415: invokevirtual 294	java/io/FileOutputStream:close	()V
    //   418: aload_0
    //   419: athrow
    //   420: astore_0
    //   421: aload 8
    //   423: astore_1
    //   424: aload 6
    //   426: astore 4
    //   428: aload 7
    //   430: astore_0
    //   431: aload_1
    //   432: ifnull +7 -> 439
    //   435: aload_1
    //   436: invokevirtual 298	java/util/zip/ZipInputStream:close	()V
    //   439: aload_0
    //   440: astore_1
    //   441: aload 4
    //   443: ifnull -429 -> 14
    //   446: aload 4
    //   448: invokevirtual 299	java/io/FileInputStream:close	()V
    //   451: aload_0
    //   452: astore_1
    //   453: goto -439 -> 14
    //   456: astore_1
    //   457: aload_0
    //   458: astore_1
    //   459: goto -445 -> 14
    //   462: aload 8
    //   464: invokevirtual 298	java/util/zip/ZipInputStream:close	()V
    //   467: aload 6
    //   469: invokevirtual 299	java/io/FileInputStream:close	()V
    //   472: aload 7
    //   474: astore_1
    //   475: goto -461 -> 14
    //   478: astore_0
    //   479: aload 7
    //   481: astore_1
    //   482: goto -468 -> 14
    //   485: astore_0
    //   486: aconst_null
    //   487: astore_1
    //   488: aconst_null
    //   489: astore 6
    //   491: aload_1
    //   492: ifnull +7 -> 499
    //   495: aload_1
    //   496: invokevirtual 298	java/util/zip/ZipInputStream:close	()V
    //   499: aload 6
    //   501: ifnull +8 -> 509
    //   504: aload 6
    //   506: invokevirtual 299	java/io/FileInputStream:close	()V
    //   509: aload_0
    //   510: athrow
    //   511: astore_0
    //   512: ldc 2
    //   514: monitorexit
    //   515: aload_0
    //   516: athrow
    //   517: astore_1
    //   518: goto -9 -> 509
    //   521: astore_0
    //   522: aconst_null
    //   523: astore_1
    //   524: goto -33 -> 491
    //   527: astore_0
    //   528: aload 8
    //   530: astore_1
    //   531: goto -40 -> 491
    //   534: astore_0
    //   535: aconst_null
    //   536: astore_1
    //   537: aconst_null
    //   538: astore 4
    //   540: aconst_null
    //   541: astore_0
    //   542: goto -111 -> 431
    //   545: astore_0
    //   546: aconst_null
    //   547: astore_1
    //   548: aload 6
    //   550: astore 4
    //   552: aconst_null
    //   553: astore_0
    //   554: goto -123 -> 431
    //   557: astore_1
    //   558: goto -140 -> 418
    //   561: astore_1
    //   562: aload_0
    //   563: astore 9
    //   565: aload 4
    //   567: astore 5
    //   569: aload_1
    //   570: astore_0
    //   571: aload 9
    //   573: astore_1
    //   574: goto -174 -> 400
    //   577: astore_1
    //   578: aload_0
    //   579: astore 4
    //   581: aload_1
    //   582: astore_0
    //   583: aload 4
    //   585: astore_1
    //   586: goto -186 -> 400
    //   589: astore 5
    //   591: aload 4
    //   593: astore 5
    //   595: goto -285 -> 310
    //   598: astore 4
    //   600: goto -290 -> 310
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	603	0	paramString1	String
    //   0	603	1	paramString2	String
    //   288	12	2	i	int
    //   7	2	3	bool	boolean
    //   48	327	4	localObject1	Object
    //   383	1	4	localIOException1	java.io.IOException
    //   387	205	4	localObject2	Object
    //   598	1	4	localIOException2	java.io.IOException
    //   98	470	5	localObject3	Object
    //   589	1	5	localIOException3	java.io.IOException
    //   593	1	5	localObject4	Object
    //   72	477	6	localFileInputStream	java.io.FileInputStream
    //   102	378	7	localObject5	Object
    //   90	439	8	localZipInputStream	java.util.zip.ZipInputStream
    //   109	463	9	localObject6	Object
    //   121	123	10	str	String
    // Exception table:
    //   from	to	target	type
    //   281	289	306	java/io/IOException
    //   294	303	306	java/io/IOException
    //   339	344	306	java/io/IOException
    //   344	354	368	java/io/IOException
    //   314	318	383	java/io/IOException
    //   323	328	383	java/io/IOException
    //   281	289	396	finally
    //   294	303	396	finally
    //   339	344	396	finally
    //   104	111	420	java/io/IOException
    //   116	123	420	java/io/IOException
    //   127	193	420	java/io/IOException
    //   197	212	420	java/io/IOException
    //   215	256	420	java/io/IOException
    //   418	420	420	java/io/IOException
    //   435	439	456	java/io/IOException
    //   446	451	456	java/io/IOException
    //   462	472	478	java/io/IOException
    //   64	74	485	finally
    //   3	8	511	finally
    //   19	35	511	finally
    //   40	64	511	finally
    //   435	439	511	finally
    //   446	451	511	finally
    //   462	472	511	finally
    //   495	499	511	finally
    //   504	509	511	finally
    //   509	511	511	finally
    //   495	499	517	java/io/IOException
    //   504	509	517	java/io/IOException
    //   74	92	521	finally
    //   104	111	527	finally
    //   116	123	527	finally
    //   127	193	527	finally
    //   197	212	527	finally
    //   215	256	527	finally
    //   314	318	527	finally
    //   323	328	527	finally
    //   344	354	527	finally
    //   404	408	527	finally
    //   413	418	527	finally
    //   418	420	527	finally
    //   64	74	534	java/io/IOException
    //   74	92	545	java/io/IOException
    //   404	408	557	java/io/IOException
    //   413	418	557	java/io/IOException
    //   256	267	561	finally
    //   267	281	577	finally
    //   256	267	589	java/io/IOException
    //   267	281	598	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoUtil
 * JD-Core Version:    0.7.0.1
 */