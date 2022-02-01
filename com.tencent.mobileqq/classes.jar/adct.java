import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class adct
{
  private static String a;
  public static final String[] a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "NATIVE", "DALVIK", "CURSOR", "ASHMEM", "OTHER_DEV", "SO_MMAP", "JAR_MMAP", "APK_MMAP", "TTF_MMAP", "DEX_MMAP", "OTHER_MMAP", "UNKNOWN" };
    String str = Environment.getExternalStorageDirectory().getPath();
    if (!TextUtils.isEmpty(str))
    {
      Object localObject = str;
      if (!str.endsWith("/")) {
        localObject = str + "/";
      }
      jdField_a_of_type_JavaLangString = bhgg.a((String)localObject + "/Tencent/MobileQQ/log/");
      localObject = new File(jdField_a_of_type_JavaLangString);
      if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
        ((File)localObject).mkdirs();
      }
    }
  }
  
  public static int a(String paramString, List<adcv> paramList, List<Map<String, Integer>> paramList1)
  {
    int i1 = 0;
    int i2 = 0;
    int j = 0;
    int k = 0;
    long l1 = 0L;
    Object localObject1 = "";
    int i = 0;
    for (;;)
    {
      if (new File(paramString).exists()) {
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          return 0;
        }
        try
        {
          Thread.sleep(500L);
          if (i >= 10)
          {
            i = 0;
            continue;
            BufferedReader localBufferedReader = new BufferedReader(new FileReader(paramString));
            Object localObject2 = localBufferedReader.readLine();
            if (localObject2 == null)
            {
              localBufferedReader.close();
              return 0;
              while (i2 == 0)
              {
                int i3 = 0;
                if (((String)localObject2).length() < 1)
                {
                  i = 11;
                }
                else
                {
                  long l3;
                  if ((((String)localObject2).length() > 30) && (((String)localObject2).charAt(8) == '-') && (((String)localObject2).charAt(17) == ' '))
                  {
                    paramString = ((String)localObject2).split(" ");
                    localObject2 = paramString[0].split("-");
                    l3 = Long.parseLong(localObject2[0], 16);
                    long l2 = Long.parseLong(localObject2[1], 16);
                    n = 5;
                    while ((n < paramString.length) && (paramString[n].equals(""))) {
                      n += 1;
                    }
                    if (n < paramString.length)
                    {
                      paramString = paramString[n];
                      label236:
                      n = paramString.length();
                      if (!paramString.equals("[heap]")) {
                        break label441;
                      }
                      i = 0;
                      label253:
                      l1 = l2;
                      n = i;
                      i = m;
                      label263:
                      localObject2 = localBufferedReader.readLine();
                      if (localObject2 != null) {
                        break label616;
                      }
                      i2 = 1;
                      label278:
                      if (i3 != 0) {
                        break label982;
                      }
                      localObject1 = (Map)paramList1.get(n);
                      if (!((Map)localObject1).containsKey(paramString)) {
                        break label943;
                      }
                      ((Map)localObject1).put(paramString, Integer.valueOf(((Integer)((Map)localObject1).get(paramString)).intValue() + j));
                    }
                  }
                  for (;;)
                  {
                    localObject1 = (adcv)paramList.get(n);
                    ((adcv)localObject1).a += j;
                    localObject1 = (adcv)paramList.get(n);
                    ((adcv)localObject1).b += i;
                    localObject1 = (adcv)paramList.get(n);
                    ((adcv)localObject1).c += k;
                    i1 += j;
                    localObject1 = paramString;
                    m = i;
                    i = n;
                    break;
                    paramString = "";
                    break label236;
                    label441:
                    if (paramString.startsWith("/dev/ashmem/dalvik-"))
                    {
                      i = 1;
                      break label253;
                    }
                    if (paramString.startsWith("/dev/ashmem/CursorWindow"))
                    {
                      i = 2;
                      break label253;
                    }
                    if (paramString.startsWith("/dev/ashmem/"))
                    {
                      i = 3;
                      break label253;
                    }
                    if (paramString.startsWith("/dev/"))
                    {
                      i = 4;
                      break label253;
                    }
                    if (paramString.endsWith(".so"))
                    {
                      i = 5;
                      break label253;
                    }
                    if (paramString.endsWith(".jar"))
                    {
                      i = 6;
                      break label253;
                    }
                    if (paramString.endsWith(".apk"))
                    {
                      i = 7;
                      break label253;
                    }
                    if (paramString.endsWith(".ttf"))
                    {
                      i = 8;
                      break label253;
                    }
                    if (paramString.endsWith(".dex"))
                    {
                      i = 9;
                      break label253;
                    }
                    if (n > 0)
                    {
                      i = 10;
                      break label253;
                    }
                    if ((l3 != l1) || (i != 5)) {
                      break label1006;
                    }
                    i = 5;
                    paramString = (String)localObject1;
                    break label253;
                    i = m;
                    i3 = 1;
                    n = 11;
                    break label263;
                    label616:
                    String[] arrayOfString = ((String)localObject2).split(" ");
                    String str = arrayOfString[0];
                    i4 = 0;
                    m = 1;
                    try
                    {
                      while ((m < arrayOfString.length) && (arrayOfString[m].equals(""))) {
                        m += 1;
                      }
                      if (m >= arrayOfString.length) {
                        break label722;
                      }
                      m = Integer.parseInt(arrayOfString[m]);
                    }
                    catch (Exception localException)
                    {
                      for (;;)
                      {
                        label685:
                        m = i4;
                      }
                    }
                    if (str.equals("Size:"))
                    {
                      m = k;
                      k = j;
                      j = m;
                    }
                    for (;;)
                    {
                      m = k;
                      k = j;
                      j = m;
                      break;
                      label722:
                      m = 0;
                      break label685;
                      if (str.equals("Rss:"))
                      {
                        m = j;
                        j = k;
                        k = m;
                      }
                      else if (str.equals("Pss:"))
                      {
                        j = k;
                        k = m;
                      }
                      else if (str.equals("Shared_Clean:"))
                      {
                        m = j;
                        j = k;
                        k = m;
                      }
                      else if (str.equals("Shared_Dirty:"))
                      {
                        k = j;
                        j = m;
                      }
                      else if (str.equals("Private_Clean:"))
                      {
                        m = j;
                        j = k;
                        k = m;
                      }
                      else if (str.equals("Private_Dirty:"))
                      {
                        i4 = j;
                        i = m;
                        j = k;
                        k = i4;
                      }
                      else
                      {
                        if (!str.equals("Referenced:")) {
                          break label898;
                        }
                        m = j;
                        j = k;
                        k = m;
                      }
                    }
                    label898:
                    if ((((String)localObject2).length() <= 30) || (((String)localObject2).charAt(8) != '-') || (((String)localObject2).charAt(17) != ' ')) {
                      break label991;
                    }
                    System.out.println((String)localObject2);
                    break label278;
                    label943:
                    ((Map)localObject1).put(paramString, Integer.valueOf(j));
                  }
                }
              }
              localBufferedReader.close();
              return i1;
            }
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            int n;
            int i4;
            continue;
            label982:
            int m = i;
            i = n;
            continue;
            label991:
            m = j;
            j = k;
            k = m;
            continue;
            label1006:
            i = 11;
            continue;
            i = 11;
            m = 0;
            paramString = "";
          }
          i += 1;
        }
      }
    }
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: invokestatic 253	java/lang/System:currentTimeMillis	()J
    //   3: ldc 255
    //   5: invokestatic 260	bgsu:a	(JLjava/lang/String;)Ljava/lang/String;
    //   8: astore_3
    //   9: new 67	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   16: getstatic 13	adct:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   19: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc_w 262
    //   25: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_3
    //   29: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc_w 264
    //   35: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: astore 6
    //   43: invokestatic 267	java/lang/Thread:activeCount	()I
    //   46: istore_2
    //   47: iload_2
    //   48: ifne +8 -> 56
    //   51: ldc 11
    //   53: astore_3
    //   54: aload_3
    //   55: areturn
    //   56: new 269	java/io/BufferedWriter
    //   59: dup
    //   60: new 271	java/io/FileWriter
    //   63: dup
    //   64: aload 6
    //   66: iconst_0
    //   67: invokespecial 274	java/io/FileWriter:<init>	(Ljava/lang/String;Z)V
    //   70: invokespecial 277	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   73: astore 4
    //   75: aload 4
    //   77: astore_3
    //   78: iload_2
    //   79: anewarray 107	java/lang/Thread
    //   82: astore 5
    //   84: aload 4
    //   86: astore_3
    //   87: aload 5
    //   89: invokestatic 281	java/lang/Thread:enumerate	([Ljava/lang/Thread;)I
    //   92: pop
    //   93: aload 4
    //   95: astore_3
    //   96: new 67	java/lang/StringBuilder
    //   99: dup
    //   100: iload_2
    //   101: sipush 1024
    //   104: imul
    //   105: invokespecial 284	java/lang/StringBuilder:<init>	(I)V
    //   108: astore 7
    //   110: iconst_0
    //   111: istore_0
    //   112: goto +307 -> 419
    //   115: aload 4
    //   117: astore_3
    //   118: aload 8
    //   120: invokevirtual 287	java/lang/Thread:isAlive	()Z
    //   123: ifeq +115 -> 238
    //   126: aload 4
    //   128: astore_3
    //   129: aload 7
    //   131: ldc_w 289
    //   134: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 4
    //   140: astore_3
    //   141: aload 7
    //   143: aload 8
    //   145: invokevirtual 292	java/lang/Thread:getName	()Ljava/lang/String;
    //   148: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload 4
    //   154: astore_3
    //   155: aload 7
    //   157: ldc_w 294
    //   160: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload 4
    //   166: astore_3
    //   167: aload 8
    //   169: invokevirtual 298	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   172: astore 8
    //   174: aload 8
    //   176: ifnull +62 -> 238
    //   179: iconst_0
    //   180: istore_1
    //   181: aload 4
    //   183: astore_3
    //   184: iload_1
    //   185: aload 8
    //   187: arraylength
    //   188: if_icmpge +50 -> 238
    //   191: aload 4
    //   193: astore_3
    //   194: aload 7
    //   196: ldc_w 300
    //   199: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload 4
    //   205: astore_3
    //   206: aload 7
    //   208: aload 8
    //   210: iload_1
    //   211: aaload
    //   212: invokevirtual 303	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   215: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload 4
    //   221: astore_3
    //   222: aload 7
    //   224: ldc_w 294
    //   227: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: iload_1
    //   232: iconst_1
    //   233: iadd
    //   234: istore_1
    //   235: goto -54 -> 181
    //   238: aload 4
    //   240: astore_3
    //   241: aload 7
    //   243: ldc_w 294
    //   246: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 4
    //   252: astore_3
    //   253: aload 4
    //   255: aload 7
    //   257: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokevirtual 306	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   263: aload 4
    //   265: astore_3
    //   266: aload 4
    //   268: invokevirtual 309	java/io/BufferedWriter:flush	()V
    //   271: aload 4
    //   273: astore_3
    //   274: aload 7
    //   276: iconst_0
    //   277: invokevirtual 312	java/lang/StringBuilder:setLength	(I)V
    //   280: goto +155 -> 435
    //   283: astore 5
    //   285: aload 4
    //   287: astore_3
    //   288: aload 5
    //   290: invokevirtual 315	java/io/IOException:printStackTrace	()V
    //   293: aload 6
    //   295: astore_3
    //   296: aload 4
    //   298: ifnull -244 -> 54
    //   301: aload 4
    //   303: invokevirtual 316	java/io/BufferedWriter:close	()V
    //   306: aload 6
    //   308: areturn
    //   309: astore_3
    //   310: aload 6
    //   312: areturn
    //   313: aload 6
    //   315: astore_3
    //   316: aload 4
    //   318: ifnull -264 -> 54
    //   321: aload 4
    //   323: invokevirtual 316	java/io/BufferedWriter:close	()V
    //   326: aload 6
    //   328: areturn
    //   329: astore_3
    //   330: aload 6
    //   332: areturn
    //   333: astore 5
    //   335: aconst_null
    //   336: astore 4
    //   338: aload 4
    //   340: astore_3
    //   341: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   344: ifeq +18 -> 362
    //   347: aload 4
    //   349: astore_3
    //   350: ldc_w 323
    //   353: iconst_2
    //   354: ldc_w 325
    //   357: aload 5
    //   359: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   362: aload 6
    //   364: astore_3
    //   365: aload 4
    //   367: ifnull -313 -> 54
    //   370: aload 4
    //   372: invokevirtual 316	java/io/BufferedWriter:close	()V
    //   375: aload 6
    //   377: areturn
    //   378: astore_3
    //   379: aload 6
    //   381: areturn
    //   382: astore 4
    //   384: aconst_null
    //   385: astore_3
    //   386: aload_3
    //   387: ifnull +7 -> 394
    //   390: aload_3
    //   391: invokevirtual 316	java/io/BufferedWriter:close	()V
    //   394: aload 4
    //   396: athrow
    //   397: astore_3
    //   398: goto -4 -> 394
    //   401: astore 4
    //   403: goto -17 -> 386
    //   406: astore 5
    //   408: goto -70 -> 338
    //   411: astore 5
    //   413: aconst_null
    //   414: astore 4
    //   416: goto -131 -> 285
    //   419: iload_0
    //   420: iload_2
    //   421: if_icmpge -108 -> 313
    //   424: aload 5
    //   426: iload_0
    //   427: aaload
    //   428: astore 8
    //   430: aload 8
    //   432: ifnonnull -317 -> 115
    //   435: iload_0
    //   436: iconst_1
    //   437: iadd
    //   438: istore_0
    //   439: goto -20 -> 419
    // Local variable table:
    //   start	length	slot	name	signature
    //   111	328	0	i	int
    //   180	55	1	j	int
    //   46	376	2	k	int
    //   8	288	3	localObject1	Object
    //   309	1	3	localIOException1	IOException
    //   315	1	3	localObject2	Object
    //   329	1	3	localIOException2	IOException
    //   340	25	3	localObject3	Object
    //   378	1	3	localIOException3	IOException
    //   385	6	3	localObject4	Object
    //   397	1	3	localIOException4	IOException
    //   73	298	4	localBufferedWriter	java.io.BufferedWriter
    //   382	13	4	localObject5	Object
    //   401	1	4	localObject6	Object
    //   414	1	4	localObject7	Object
    //   82	6	5	arrayOfThread	Thread[]
    //   283	6	5	localIOException5	IOException
    //   333	25	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   406	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   411	14	5	localIOException6	IOException
    //   41	339	6	str	String
    //   108	167	7	localStringBuilder	java.lang.StringBuilder
    //   118	313	8	arrayOfStackTraceElement	java.lang.StackTraceElement[]
    // Exception table:
    //   from	to	target	type
    //   78	84	283	java/io/IOException
    //   87	93	283	java/io/IOException
    //   96	110	283	java/io/IOException
    //   118	126	283	java/io/IOException
    //   129	138	283	java/io/IOException
    //   141	152	283	java/io/IOException
    //   155	164	283	java/io/IOException
    //   167	174	283	java/io/IOException
    //   184	191	283	java/io/IOException
    //   194	203	283	java/io/IOException
    //   206	219	283	java/io/IOException
    //   222	231	283	java/io/IOException
    //   241	250	283	java/io/IOException
    //   253	263	283	java/io/IOException
    //   266	271	283	java/io/IOException
    //   274	280	283	java/io/IOException
    //   301	306	309	java/io/IOException
    //   321	326	329	java/io/IOException
    //   56	75	333	java/lang/OutOfMemoryError
    //   370	375	378	java/io/IOException
    //   56	75	382	finally
    //   390	394	397	java/io/IOException
    //   78	84	401	finally
    //   87	93	401	finally
    //   96	110	401	finally
    //   118	126	401	finally
    //   129	138	401	finally
    //   141	152	401	finally
    //   155	164	401	finally
    //   167	174	401	finally
    //   184	191	401	finally
    //   194	203	401	finally
    //   206	219	401	finally
    //   222	231	401	finally
    //   241	250	401	finally
    //   253	263	401	finally
    //   266	271	401	finally
    //   274	280	401	finally
    //   288	293	401	finally
    //   341	347	401	finally
    //   350	362	401	finally
    //   78	84	406	java/lang/OutOfMemoryError
    //   87	93	406	java/lang/OutOfMemoryError
    //   96	110	406	java/lang/OutOfMemoryError
    //   118	126	406	java/lang/OutOfMemoryError
    //   129	138	406	java/lang/OutOfMemoryError
    //   141	152	406	java/lang/OutOfMemoryError
    //   155	164	406	java/lang/OutOfMemoryError
    //   167	174	406	java/lang/OutOfMemoryError
    //   184	191	406	java/lang/OutOfMemoryError
    //   194	203	406	java/lang/OutOfMemoryError
    //   206	219	406	java/lang/OutOfMemoryError
    //   222	231	406	java/lang/OutOfMemoryError
    //   241	250	406	java/lang/OutOfMemoryError
    //   253	263	406	java/lang/OutOfMemoryError
    //   266	271	406	java/lang/OutOfMemoryError
    //   274	280	406	java/lang/OutOfMemoryError
    //   56	75	411	java/io/IOException
  }
  
  public static String a(long paramLong)
  {
    String str1 = bhgg.a(Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/" + BaseApplicationImpl.getContext().getPackageName().replace(".", "/") + "/");
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(paramLong);
    localObject = bgsu.a(((Calendar)localObject).getTimeInMillis(), "yy.MM.dd.HH");
    String str2 = MsfSdkUtils.getProcessName(BaseApplicationImpl.getContext());
    return str1 + str2.replace(":", "_") + "." + (String)localObject + ".log";
  }
  
  private static String a(ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo, String paramString)
  {
    try
    {
      String str = "/proc/" + paramRunningAppProcessInfo.pid + "/smaps";
      ArrayList localArrayList1 = new ArrayList(12);
      ArrayList localArrayList2 = new ArrayList(12);
      int i = 0;
      while (i < 12)
      {
        adcv localadcv = new adcv();
        HashMap localHashMap = new HashMap();
        localArrayList1.add(localadcv);
        localArrayList2.add(localHashMap);
        i += 1;
      }
      i = a(str, localArrayList1, localArrayList2);
      if (i > 0) {
        return a(paramRunningAppProcessInfo.processName, localArrayList1, localArrayList2, i, paramString);
      }
      return "";
    }
    catch (Throwable paramRunningAppProcessInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagnifierSDK.QAPMDumpMemInfoHandler", 2, "generateDetailMemory", paramRunningAppProcessInfo);
      }
    }
    return null;
  }
  
  private static String a(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    String[] arrayOfString;
    String str;
    do
    {
      return paramString;
      arrayOfString = paramString.split(":");
      paramString = arrayOfString[0].split("\\.");
      str = paramString[(paramString.length - 1)];
      paramString = str;
    } while (arrayOfString.length <= 1);
    return str + "_" + arrayOfString[1];
  }
  
  /* Error */
  public static String a(String paramString, long paramLong)
  {
    // Byte code:
    //   0: ldc 11
    //   2: astore 4
    //   4: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +30 -> 37
    //   10: ldc_w 323
    //   13: iconst_2
    //   14: new 67	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 419
    //   24: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_0
    //   28: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 422	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: invokestatic 253	java/lang/System:currentTimeMillis	()J
    //   40: ldc 255
    //   42: invokestatic 260	bgsu:a	(JLjava/lang/String;)Ljava/lang/String;
    //   45: astore 5
    //   47: ldc_w 424
    //   50: invokestatic 427	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   53: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   56: ifeq +704 -> 760
    //   59: new 49	java/io/File
    //   62: dup
    //   63: new 67	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   70: invokestatic 47	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   73: invokevirtual 53	java/io/File:getPath	()Ljava/lang/String;
    //   76: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc 79
    //   81: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 84	bhgg:a	(Ljava/lang/String;)Ljava/lang/String;
    //   90: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   93: astore_3
    //   94: aload_3
    //   95: invokevirtual 91	java/io/File:exists	()Z
    //   98: ifne +8 -> 106
    //   101: aload_3
    //   102: invokevirtual 97	java/io/File:mkdirs	()Z
    //   105: pop
    //   106: aload_3
    //   107: invokevirtual 430	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   110: astore 4
    //   112: aload 4
    //   114: astore_3
    //   115: aload 4
    //   117: ldc 61
    //   119: invokevirtual 65	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   122: ifne +24 -> 146
    //   125: new 67	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   132: aload 4
    //   134: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc 61
    //   139: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: astore_3
    //   146: new 67	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   153: aload_3
    //   154: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: ldc_w 432
    //   160: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_0
    //   164: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: ldc_w 373
    //   170: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload 5
    //   175: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: ldc_w 434
    //   181: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: astore 5
    //   189: new 436	java/io/FileOutputStream
    //   192: dup
    //   193: aload 5
    //   195: invokespecial 437	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   198: astore_3
    //   199: aload_3
    //   200: astore_0
    //   201: new 67	java/lang/StringBuilder
    //   204: dup
    //   205: sipush 1024
    //   208: invokespecial 284	java/lang/StringBuilder:<init>	(I)V
    //   211: astore 6
    //   213: aload_3
    //   214: astore_0
    //   215: aload 6
    //   217: ldc_w 439
    //   220: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_3
    //   225: astore_0
    //   226: aload 6
    //   228: invokestatic 445	com/tencent/mobileqq/app/BaseActivity:getActivityRoutes	()Ljava/util/ArrayList;
    //   231: invokevirtual 448	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload_3
    //   236: astore_0
    //   237: aload 6
    //   239: ldc_w 450
    //   242: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload_3
    //   247: astore_0
    //   248: aload 6
    //   250: ldc_w 452
    //   253: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload_3
    //   258: astore_0
    //   259: getstatic 456	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   262: ifnull +501 -> 763
    //   265: aload_3
    //   266: astore_0
    //   267: getstatic 456	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   270: invokevirtual 459	com/tencent/mobileqq/app/BaseActivity:getCurrentAccountUin	()Ljava/lang/String;
    //   273: astore 4
    //   275: aload_3
    //   276: astore_0
    //   277: aload 6
    //   279: aload 4
    //   281: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload_3
    //   286: astore_0
    //   287: aload 6
    //   289: ldc_w 450
    //   292: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload_3
    //   297: astore_0
    //   298: aload 6
    //   300: ldc_w 461
    //   303: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload_3
    //   308: astore_0
    //   309: aload 6
    //   311: getstatic 466	android/os/Build:MODEL	Ljava/lang/String;
    //   314: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload_3
    //   319: astore_0
    //   320: aload 6
    //   322: ldc_w 450
    //   325: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload_3
    //   330: astore_0
    //   331: aload 6
    //   333: ldc_w 468
    //   336: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload_3
    //   341: astore_0
    //   342: aload 6
    //   344: getstatic 473	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   347: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload_3
    //   352: astore_0
    //   353: aload 6
    //   355: ldc_w 450
    //   358: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload_3
    //   363: astore_0
    //   364: aload 6
    //   366: ldc_w 475
    //   369: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload_3
    //   374: astore_0
    //   375: aload 6
    //   377: bipush 100
    //   379: invokestatic 480	com/tencent/mfsdk/MagnifierSDK:a	()Lcom/tencent/mfsdk/MagnifierSDK;
    //   382: invokevirtual 483	com/tencent/mfsdk/MagnifierSDK:a	()Ladcc;
    //   385: getfield 487	adcc:a	I
    //   388: isub
    //   389: i2l
    //   390: invokestatic 493	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   393: invokevirtual 496	java/lang/Runtime:maxMemory	()J
    //   396: lmul
    //   397: ldc2_w 497
    //   400: ldiv
    //   401: invokevirtual 501	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload_3
    //   406: astore_0
    //   407: aload 6
    //   409: ldc_w 450
    //   412: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload_3
    //   417: astore_0
    //   418: aload 6
    //   420: ldc_w 503
    //   423: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload_3
    //   428: astore_0
    //   429: aload 6
    //   431: invokestatic 493	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   434: invokevirtual 506	java/lang/Runtime:totalMemory	()J
    //   437: invokestatic 493	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   440: invokevirtual 509	java/lang/Runtime:freeMemory	()J
    //   443: lsub
    //   444: invokevirtual 501	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   447: pop
    //   448: aload_3
    //   449: astore_0
    //   450: aload 6
    //   452: ldc_w 450
    //   455: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload_3
    //   460: astore_0
    //   461: aload 6
    //   463: ldc_w 511
    //   466: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload_3
    //   471: astore_0
    //   472: aload 6
    //   474: invokestatic 493	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   477: invokevirtual 506	java/lang/Runtime:totalMemory	()J
    //   480: invokevirtual 501	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload_3
    //   485: astore_0
    //   486: aload 6
    //   488: ldc_w 450
    //   491: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: pop
    //   495: aload_3
    //   496: astore_0
    //   497: aload 6
    //   499: ldc_w 513
    //   502: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload_3
    //   507: astore_0
    //   508: aload 6
    //   510: invokestatic 493	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   513: invokevirtual 509	java/lang/Runtime:freeMemory	()J
    //   516: invokevirtual 501	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   519: pop
    //   520: aload_3
    //   521: astore_0
    //   522: aload 6
    //   524: ldc_w 450
    //   527: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: pop
    //   531: aload_3
    //   532: astore_0
    //   533: aload 6
    //   535: ldc_w 515
    //   538: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: aload_3
    //   543: astore_0
    //   544: aload 6
    //   546: invokestatic 493	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   549: invokevirtual 496	java/lang/Runtime:maxMemory	()J
    //   552: invokevirtual 501	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   555: pop
    //   556: aload_3
    //   557: astore_0
    //   558: aload 6
    //   560: ldc_w 450
    //   563: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: pop
    //   567: aload_3
    //   568: astore_0
    //   569: aload 6
    //   571: ldc_w 517
    //   574: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: pop
    //   578: aload_3
    //   579: astore_0
    //   580: aload 6
    //   582: getstatic 521	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   585: invokevirtual 526	android/support/v4/util/MQLruCache:size	()I
    //   588: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   591: pop
    //   592: aload_3
    //   593: astore_0
    //   594: aload 6
    //   596: ldc_w 450
    //   599: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: pop
    //   603: aload_3
    //   604: astore_0
    //   605: aload 6
    //   607: ldc_w 528
    //   610: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: pop
    //   614: aload_3
    //   615: astore_0
    //   616: aload 6
    //   618: invokestatic 533	abfc:a	()Labfc;
    //   621: getfield 535	abfc:d	I
    //   624: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   627: pop
    //   628: aload_3
    //   629: astore_0
    //   630: aload 6
    //   632: ldc_w 450
    //   635: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: pop
    //   639: aload_3
    //   640: astore_0
    //   641: aload 6
    //   643: ldc_w 537
    //   646: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: pop
    //   650: aload_3
    //   651: astore_0
    //   652: aload 6
    //   654: invokestatic 541	anrr:a	()Ljava/lang/String;
    //   657: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: pop
    //   661: aload_3
    //   662: astore_0
    //   663: aload 6
    //   665: ldc_w 450
    //   668: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: pop
    //   672: aload_3
    //   673: astore_0
    //   674: aload 6
    //   676: ldc_w 543
    //   679: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: pop
    //   683: aload_3
    //   684: astore_0
    //   685: aload 6
    //   687: lload_1
    //   688: invokevirtual 501	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   691: pop
    //   692: aload_3
    //   693: astore_0
    //   694: aload_3
    //   695: aload 6
    //   697: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   700: invokevirtual 547	java/lang/String:getBytes	()[B
    //   703: invokevirtual 550	java/io/FileOutputStream:write	([B)V
    //   706: aload_3
    //   707: astore_0
    //   708: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   711: ifeq +33 -> 744
    //   714: aload_3
    //   715: astore_0
    //   716: ldc_w 323
    //   719: iconst_2
    //   720: new 67	java/lang/StringBuilder
    //   723: dup
    //   724: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   727: ldc_w 552
    //   730: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: aload 5
    //   735: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: invokestatic 422	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   744: aload 5
    //   746: astore 4
    //   748: aload_3
    //   749: ifnull +11 -> 760
    //   752: aload_3
    //   753: invokevirtual 553	java/io/FileOutputStream:close	()V
    //   756: aload 5
    //   758: astore 4
    //   760: aload 4
    //   762: areturn
    //   763: ldc_w 555
    //   766: astore 4
    //   768: goto -493 -> 275
    //   771: astore_0
    //   772: aload_0
    //   773: invokevirtual 315	java/io/IOException:printStackTrace	()V
    //   776: aload 5
    //   778: areturn
    //   779: astore 4
    //   781: aconst_null
    //   782: astore_3
    //   783: aload_3
    //   784: astore_0
    //   785: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   788: ifeq +17 -> 805
    //   791: aload_3
    //   792: astore_0
    //   793: ldc_w 323
    //   796: iconst_2
    //   797: ldc_w 557
    //   800: aload 4
    //   802: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   805: aload 5
    //   807: astore 4
    //   809: aload_3
    //   810: ifnull -50 -> 760
    //   813: aload_3
    //   814: invokevirtual 553	java/io/FileOutputStream:close	()V
    //   817: aload 5
    //   819: areturn
    //   820: astore_0
    //   821: aload_0
    //   822: invokevirtual 315	java/io/IOException:printStackTrace	()V
    //   825: aload 5
    //   827: areturn
    //   828: astore_3
    //   829: aconst_null
    //   830: astore_0
    //   831: aload_0
    //   832: ifnull +7 -> 839
    //   835: aload_0
    //   836: invokevirtual 553	java/io/FileOutputStream:close	()V
    //   839: aload_3
    //   840: athrow
    //   841: astore_0
    //   842: aload_0
    //   843: invokevirtual 315	java/io/IOException:printStackTrace	()V
    //   846: goto -7 -> 839
    //   849: astore_3
    //   850: goto -19 -> 831
    //   853: astore 4
    //   855: goto -72 -> 783
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	858	0	paramString	String
    //   0	858	1	paramLong	long
    //   93	721	3	localObject1	Object
    //   828	12	3	localObject2	Object
    //   849	1	3	localObject3	Object
    //   2	765	4	localObject4	Object
    //   779	22	4	localIOException1	IOException
    //   807	1	4	localObject5	Object
    //   853	1	4	localIOException2	IOException
    //   45	781	5	str	String
    //   211	485	6	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   752	756	771	java/io/IOException
    //   189	199	779	java/io/IOException
    //   813	817	820	java/io/IOException
    //   189	199	828	finally
    //   835	839	841	java/io/IOException
    //   201	213	849	finally
    //   215	224	849	finally
    //   226	235	849	finally
    //   237	246	849	finally
    //   248	257	849	finally
    //   259	265	849	finally
    //   267	275	849	finally
    //   277	285	849	finally
    //   287	296	849	finally
    //   298	307	849	finally
    //   309	318	849	finally
    //   320	329	849	finally
    //   331	340	849	finally
    //   342	351	849	finally
    //   353	362	849	finally
    //   364	373	849	finally
    //   375	405	849	finally
    //   407	416	849	finally
    //   418	427	849	finally
    //   429	448	849	finally
    //   450	459	849	finally
    //   461	470	849	finally
    //   472	484	849	finally
    //   486	495	849	finally
    //   497	506	849	finally
    //   508	520	849	finally
    //   522	531	849	finally
    //   533	542	849	finally
    //   544	556	849	finally
    //   558	567	849	finally
    //   569	578	849	finally
    //   580	592	849	finally
    //   594	603	849	finally
    //   605	614	849	finally
    //   616	628	849	finally
    //   630	639	849	finally
    //   641	650	849	finally
    //   652	661	849	finally
    //   663	672	849	finally
    //   674	683	849	finally
    //   685	692	849	finally
    //   694	706	849	finally
    //   708	714	849	finally
    //   716	744	849	finally
    //   785	791	849	finally
    //   793	805	849	finally
    //   201	213	853	java/io/IOException
    //   215	224	853	java/io/IOException
    //   226	235	853	java/io/IOException
    //   237	246	853	java/io/IOException
    //   248	257	853	java/io/IOException
    //   259	265	853	java/io/IOException
    //   267	275	853	java/io/IOException
    //   277	285	853	java/io/IOException
    //   287	296	853	java/io/IOException
    //   298	307	853	java/io/IOException
    //   309	318	853	java/io/IOException
    //   320	329	853	java/io/IOException
    //   331	340	853	java/io/IOException
    //   342	351	853	java/io/IOException
    //   353	362	853	java/io/IOException
    //   364	373	853	java/io/IOException
    //   375	405	853	java/io/IOException
    //   407	416	853	java/io/IOException
    //   418	427	853	java/io/IOException
    //   429	448	853	java/io/IOException
    //   450	459	853	java/io/IOException
    //   461	470	853	java/io/IOException
    //   472	484	853	java/io/IOException
    //   486	495	853	java/io/IOException
    //   497	506	853	java/io/IOException
    //   508	520	853	java/io/IOException
    //   522	531	853	java/io/IOException
    //   533	542	853	java/io/IOException
    //   544	556	853	java/io/IOException
    //   558	567	853	java/io/IOException
    //   569	578	853	java/io/IOException
    //   580	592	853	java/io/IOException
    //   594	603	853	java/io/IOException
    //   605	614	853	java/io/IOException
    //   616	628	853	java/io/IOException
    //   630	639	853	java/io/IOException
    //   641	650	853	java/io/IOException
    //   652	661	853	java/io/IOException
    //   663	672	853	java/io/IOException
    //   674	683	853	java/io/IOException
    //   685	692	853	java/io/IOException
    //   694	706	853	java/io/IOException
    //   708	714	853	java/io/IOException
    //   716	744	853	java/io/IOException
  }
  
  /* Error */
  public static String a(String paramString1, List<adcv> paramList, List<Map<String, Integer>> paramList1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: new 559	java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial 560	java/lang/StringBuffer:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: new 67	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 562
    //   21: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 135
    //   30: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload 4
    //   35: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc_w 564
    //   41: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokevirtual 567	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   50: pop
    //   51: aload 6
    //   53: ldc_w 569
    //   56: iconst_1
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: iload_3
    //   63: invokestatic 176	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   66: aastore
    //   67: invokestatic 573	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   70: invokevirtual 567	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   73: pop
    //   74: iconst_0
    //   75: istore_3
    //   76: iload_3
    //   77: aload_1
    //   78: invokeinterface 574 1 0
    //   83: if_icmpge +148 -> 231
    //   86: aload 6
    //   88: ldc_w 576
    //   91: iconst_2
    //   92: anewarray 4	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: getstatic 41	adct:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   100: iload_3
    //   101: aaload
    //   102: aastore
    //   103: dup
    //   104: iconst_1
    //   105: aload_1
    //   106: iload_3
    //   107: invokeinterface 159 2 0
    //   112: checkcast 182	adcv
    //   115: getfield 185	adcv:a	J
    //   118: invokestatic 579	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   121: aastore
    //   122: invokestatic 573	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   125: invokevirtual 567	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   128: pop
    //   129: aload_2
    //   130: iload_3
    //   131: invokeinterface 159 2 0
    //   136: checkcast 161	java/util/Map
    //   139: invokeinterface 580 1 0
    //   144: ifle +80 -> 224
    //   147: aload_2
    //   148: iload_3
    //   149: invokeinterface 159 2 0
    //   154: checkcast 161	java/util/Map
    //   157: invokestatic 583	adct:a	(Ljava/util/Map;)[Ljava/util/Map$Entry;
    //   160: astore 7
    //   162: iconst_0
    //   163: istore 5
    //   165: iload 5
    //   167: aload 7
    //   169: arraylength
    //   170: if_icmpge +54 -> 224
    //   173: aload 6
    //   175: ldc_w 585
    //   178: iconst_2
    //   179: anewarray 4	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: aload 7
    //   186: iload 5
    //   188: aaload
    //   189: invokeinterface 591 1 0
    //   194: aastore
    //   195: dup
    //   196: iconst_1
    //   197: aload 7
    //   199: iload 5
    //   201: aaload
    //   202: invokeinterface 594 1 0
    //   207: aastore
    //   208: invokestatic 573	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   211: invokevirtual 567	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   214: pop
    //   215: iload 5
    //   217: iconst_1
    //   218: iadd
    //   219: istore 5
    //   221: goto -56 -> 165
    //   224: iload_3
    //   225: iconst_1
    //   226: iadd
    //   227: istore_3
    //   228: goto -152 -> 76
    //   231: aload 6
    //   233: new 67	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   240: ldc_w 562
    //   243: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_0
    //   247: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc_w 596
    //   253: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokevirtual 567	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   262: pop
    //   263: aload 6
    //   265: invokevirtual 597	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   268: astore_2
    //   269: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq +11 -> 283
    //   275: ldc_w 323
    //   278: iconst_2
    //   279: aload_2
    //   280: invokestatic 600	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: new 67	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   290: getstatic 13	adct:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   293: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: ldc_w 432
    //   299: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload_0
    //   303: invokestatic 601	adct:a	(Ljava/lang/String;)Ljava/lang/String;
    //   306: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: ldc_w 373
    //   312: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload 4
    //   317: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: ldc_w 603
    //   323: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: astore 4
    //   331: new 271	java/io/FileWriter
    //   334: dup
    //   335: aload 4
    //   337: invokespecial 604	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   340: astore_0
    //   341: new 269	java/io/BufferedWriter
    //   344: dup
    //   345: aload_0
    //   346: invokespecial 277	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   349: astore_1
    //   350: aload_1
    //   351: aload_2
    //   352: invokevirtual 306	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   355: aload_1
    //   356: ifnull +7 -> 363
    //   359: aload_1
    //   360: invokevirtual 316	java/io/BufferedWriter:close	()V
    //   363: aload_0
    //   364: ifnull +7 -> 371
    //   367: aload_0
    //   368: invokevirtual 605	java/io/FileWriter:close	()V
    //   371: aload 4
    //   373: areturn
    //   374: astore_0
    //   375: aconst_null
    //   376: astore_2
    //   377: aconst_null
    //   378: astore_1
    //   379: aload_1
    //   380: ifnull +7 -> 387
    //   383: aload_1
    //   384: invokevirtual 316	java/io/BufferedWriter:close	()V
    //   387: aload_2
    //   388: ifnull +7 -> 395
    //   391: aload_2
    //   392: invokevirtual 605	java/io/FileWriter:close	()V
    //   395: aload_0
    //   396: athrow
    //   397: astore 4
    //   399: aconst_null
    //   400: astore_1
    //   401: aload_0
    //   402: astore_2
    //   403: aload 4
    //   405: astore_0
    //   406: goto -27 -> 379
    //   409: astore 4
    //   411: aload_0
    //   412: astore_2
    //   413: aload 4
    //   415: astore_0
    //   416: goto -37 -> 379
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	419	0	paramString1	String
    //   0	419	1	paramList	List<adcv>
    //   0	419	2	paramList1	List<Map<String, Integer>>
    //   0	419	3	paramInt	int
    //   0	419	4	paramString2	String
    //   163	57	5	i	int
    //   7	257	6	localStringBuffer	StringBuffer
    //   160	38	7	arrayOfEntry	Map.Entry[]
    // Exception table:
    //   from	to	target	type
    //   331	341	374	finally
    //   341	350	397	finally
    //   350	355	409	finally
  }
  
  public static List<String> a()
  {
    ArrayList localArrayList = new ArrayList(10);
    String str1 = bgsu.a(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
    Iterator localIterator = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ActivityManager.RunningAppProcessInfo)localIterator.next();
      if (((ActivityManager.RunningAppProcessInfo)localObject).processName.startsWith("com.tencent.mobileqq"))
      {
        String str2 = a((ActivityManager.RunningAppProcessInfo)localObject, str1);
        if (!TextUtils.isEmpty(str2)) {
          localArrayList.add(str2);
        }
        localObject = b((ActivityManager.RunningAppProcessInfo)localObject, str1);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  private static void a(String paramString1, String paramString2, String paramString3)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\n====== [" + paramString1 + " " + paramString3 + " meminfo begin] =======\n");
    localStringBuffer.append(bgmg.a(new File(paramString2)));
    localStringBuffer.append("\n====== [" + paramString1 + " meminfo end] =======\n");
    if (QLog.isColorLevel()) {
      QLog.i("MagnifierSDK.QAPMDumpMemInfoHandler", 2, localStringBuffer.toString());
    }
  }
  
  private static Map.Entry[] a(Map paramMap)
  {
    paramMap = paramMap.entrySet();
    paramMap = (Map.Entry[])paramMap.toArray(new Map.Entry[paramMap.size()]);
    Arrays.sort(paramMap, new adcu());
    return paramMap;
  }
  
  public static String b()
  {
    String str1 = bgsu.a(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
    str1 = "trace_mobileqq" + str1 + ".trace";
    int i = 0;
    for (int j = 0;; j = k)
    {
      if ((i >= 3) || (j != 0)) {
        break label139;
      }
      try
      {
        Runtime.getRuntime().exec("chmod 777 /data/anr");
        Runtime.getRuntime().exec("rm /data/anr/traces.txt");
        Runtime.getRuntime().exec("kill -3 " + Process.myPid());
        k = 1;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          int k = j;
          if (QLog.isColorLevel())
          {
            QLog.d("MagnifierSDK.QAPMDumpMemInfoHandler", 2, "generateTraces", localIOException);
            k = j;
          }
        }
      }
      i += 1;
    }
    label139:
    if (j != 0)
    {
      i = 0;
      boolean bool = false;
      for (;;)
      {
        if ((i < 3) && (!bool))
        {
          String str2 = bgmg.a(new File("/data/anr/traces.txt"));
          if (str2 != null) {
            bool = bgmg.a(jdField_a_of_type_JavaLangString, str1, str2);
          }
          if (!bool) {}
          try
          {
            Thread.sleep(1000L);
            i += 1;
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MagnifierSDK.QAPMDumpMemInfoHandler", 2, "InterruptedException", localInterruptedException);
              }
            }
          }
        }
      }
    }
    return jdField_a_of_type_JavaLangString + str1;
  }
  
  private static String b(ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo, String paramString)
  {
    String str1 = jdField_a_of_type_JavaLangString + a(paramRunningAppProcessInfo.processName) + paramString + ".meminfo";
    try
    {
      if (BaseApplicationImpl.sApplication.checkPermission("android.permission.DUMP", paramRunningAppProcessInfo.pid, paramRunningAppProcessInfo.uid) == 0) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          String str2 = "dumpsys meminfo " + paramRunningAppProcessInfo.processName + " > " + str1;
          Runtime.getRuntime().exec(str2);
          a(paramRunningAppProcessInfo.processName, str1, paramString);
        }
        return str1;
      }
      return "";
    }
    catch (IOException paramRunningAppProcessInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagnifierSDK.QAPMDumpMemInfoHandler", 2, "generateMemInfo", paramRunningAppProcessInfo);
      }
    }
  }
  
  public static List<String> b()
  {
    ArrayList localArrayList = new ArrayList();
    long l = System.currentTimeMillis();
    localArrayList.add(a(l));
    localArrayList.add(a(l - 3600000L));
    localArrayList.add(anhk.bf + "log.txt");
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adct
 * JD-Core Version:    0.7.0.1
 */