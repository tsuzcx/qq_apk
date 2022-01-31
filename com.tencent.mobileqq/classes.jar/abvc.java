import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Debug;
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

public class abvc
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
      jdField_a_of_type_JavaLangString = bdzf.a((String)localObject + "/Tencent/MobileQQ/log/");
      localObject = new File(jdField_a_of_type_JavaLangString);
      if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
        ((File)localObject).mkdirs();
      }
    }
  }
  
  public static int a(String paramString, List<abve> paramList, List<Map<String, Integer>> paramList1)
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
                    localObject1 = (abve)paramList.get(n);
                    ((abve)localObject1).a += j;
                    localObject1 = (abve)paramList.get(n);
                    ((abve)localObject1).b += i;
                    localObject1 = (abve)paramList.get(n);
                    ((abve)localObject1).c += k;
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
    //   5: invokestatic 260	bdns:a	(JLjava/lang/String;)Ljava/lang/String;
    //   8: astore_3
    //   9: new 67	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   16: getstatic 13	abvc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    String str1 = bdzf.a(Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/" + BaseApplicationImpl.getContext().getPackageName().replace(".", "/") + "/");
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(paramLong);
    localObject = bdns.a(((Calendar)localObject).getTimeInMillis(), "yy.MM.dd.HH");
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
        abve localabve = new abve();
        HashMap localHashMap = new HashMap();
        localArrayList1.add(localabve);
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
        QLog.d("LeakInspector", 2, "generateDetailMemory", paramRunningAppProcessInfo);
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
  public static String a(String paramString1, List<abve> paramList, List<Map<String, Integer>> paramList1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: new 418	java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial 419	java/lang/StringBuffer:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: new 67	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 421
    //   21: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 135
    //   30: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload 4
    //   35: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc_w 423
    //   41: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokevirtual 426	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   50: pop
    //   51: aload 6
    //   53: ldc_w 428
    //   56: iconst_1
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: iload_3
    //   63: invokestatic 176	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   66: aastore
    //   67: invokestatic 432	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   70: invokevirtual 426	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   73: pop
    //   74: iconst_0
    //   75: istore_3
    //   76: iload_3
    //   77: aload_1
    //   78: invokeinterface 435 1 0
    //   83: if_icmpge +148 -> 231
    //   86: aload 6
    //   88: ldc_w 437
    //   91: iconst_2
    //   92: anewarray 4	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: getstatic 41	abvc:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   100: iload_3
    //   101: aaload
    //   102: aastore
    //   103: dup
    //   104: iconst_1
    //   105: aload_1
    //   106: iload_3
    //   107: invokeinterface 159 2 0
    //   112: checkcast 182	abve
    //   115: getfield 185	abve:a	J
    //   118: invokestatic 440	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   121: aastore
    //   122: invokestatic 432	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   125: invokevirtual 426	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   128: pop
    //   129: aload_2
    //   130: iload_3
    //   131: invokeinterface 159 2 0
    //   136: checkcast 161	java/util/Map
    //   139: invokeinterface 441 1 0
    //   144: ifle +80 -> 224
    //   147: aload_2
    //   148: iload_3
    //   149: invokeinterface 159 2 0
    //   154: checkcast 161	java/util/Map
    //   157: invokestatic 444	abvc:a	(Ljava/util/Map;)[Ljava/util/Map$Entry;
    //   160: astore 7
    //   162: iconst_0
    //   163: istore 5
    //   165: iload 5
    //   167: aload 7
    //   169: arraylength
    //   170: if_icmpge +54 -> 224
    //   173: aload 6
    //   175: ldc_w 446
    //   178: iconst_2
    //   179: anewarray 4	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: aload 7
    //   186: iload 5
    //   188: aaload
    //   189: invokeinterface 452 1 0
    //   194: aastore
    //   195: dup
    //   196: iconst_1
    //   197: aload 7
    //   199: iload 5
    //   201: aaload
    //   202: invokeinterface 455 1 0
    //   207: aastore
    //   208: invokestatic 432	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   211: invokevirtual 426	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
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
    //   240: ldc_w 421
    //   243: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_0
    //   247: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc_w 457
    //   253: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokevirtual 426	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   262: pop
    //   263: aload 6
    //   265: invokevirtual 458	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   268: astore_2
    //   269: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq +11 -> 283
    //   275: ldc_w 323
    //   278: iconst_2
    //   279: aload_2
    //   280: invokestatic 462	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: new 67	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   290: getstatic 13	abvc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   293: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: ldc_w 464
    //   299: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload_0
    //   303: invokestatic 465	abvc:a	(Ljava/lang/String;)Ljava/lang/String;
    //   306: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: ldc_w 373
    //   312: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload 4
    //   317: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: ldc_w 467
    //   323: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: astore 4
    //   331: new 271	java/io/FileWriter
    //   334: dup
    //   335: aload 4
    //   337: invokespecial 468	java/io/FileWriter:<init>	(Ljava/lang/String;)V
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
    //   368: invokevirtual 469	java/io/FileWriter:close	()V
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
    //   392: invokevirtual 469	java/io/FileWriter:close	()V
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
    //   0	419	1	paramList	List<abve>
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
    String str1 = bdns.a(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
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
    localStringBuffer.append(bdhb.a(new File(paramString2)));
    localStringBuffer.append("\n====== [" + paramString1 + " meminfo end] =======\n");
    if (QLog.isColorLevel()) {
      QLog.i("LeakInspector", 2, localStringBuffer.toString());
    }
  }
  
  public static Object[] a(String paramString)
  {
    if (!"mounted".equalsIgnoreCase(Environment.getExternalStorageState())) {
      return new Object[] { Boolean.valueOf(false), null };
    }
    Object localObject;
    boolean bool;
    try
    {
      localObject = b(paramString);
      bool = ((Boolean)localObject[0]).booleanValue();
      localObject = (String)localObject[1];
      if (!bool) {
        return new Object[] { Boolean.valueOf(false), null };
      }
    }
    catch (Throwable paramString)
    {
      bool = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LeakInspector", 2, "dumpQQMemory", paramString);
      }
      paramString = "";
      for (;;)
      {
        return new Object[] { Boolean.valueOf(bool), paramString };
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(a());
        localArrayList.addAll(b());
        localArrayList.add(b());
        localArrayList.add(a());
        localArrayList.add(localObject);
        paramString = a(localArrayList, paramString);
        bool = ((Boolean)paramString[0]).booleanValue();
        try
        {
          paramString = (String)paramString[1];
        }
        catch (Throwable paramString) {}
      }
    }
  }
  
  /* Error */
  public static Object[] a(List<String> paramList, String paramString)
  {
    // Byte code:
    //   0: invokestatic 253	java/lang/System:currentTimeMillis	()J
    //   3: ldc 255
    //   5: invokestatic 260	bdns:a	(JLjava/lang/String;)Ljava/lang/String;
    //   8: astore 7
    //   10: new 67	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   17: getstatic 13	abvc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   20: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 464
    //   26: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc_w 373
    //   36: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload 7
    //   41: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc_w 550
    //   47: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: astore 7
    //   55: new 552	java/io/BufferedOutputStream
    //   58: dup
    //   59: new 554	java/io/FileOutputStream
    //   62: dup
    //   63: new 49	java/io/File
    //   66: dup
    //   67: aload 7
    //   69: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   72: invokespecial 557	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   75: invokespecial 560	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   78: astore_1
    //   79: new 562	java/util/zip/ZipOutputStream
    //   82: dup
    //   83: aload_1
    //   84: invokespecial 563	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   87: astore 8
    //   89: invokestatic 253	java/lang/System:currentTimeMillis	()J
    //   92: lstore_3
    //   93: aload_0
    //   94: invokeinterface 486 1 0
    //   99: astore 9
    //   101: aload 9
    //   103: invokeinterface 491 1 0
    //   108: ifeq +324 -> 432
    //   111: new 49	java/io/File
    //   114: dup
    //   115: aload 9
    //   117: invokeinterface 494 1 0
    //   122: checkcast 15	java/lang/String
    //   125: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   128: astore 10
    //   130: aload 10
    //   132: invokevirtual 91	java/io/File:exists	()Z
    //   135: ifeq -34 -> 101
    //   138: aload 8
    //   140: new 565	java/util/zip/ZipEntry
    //   143: dup
    //   144: aload 10
    //   146: invokevirtual 566	java/io/File:getName	()Ljava/lang/String;
    //   149: invokespecial 567	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   152: invokevirtual 571	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   155: aload 8
    //   157: bipush 9
    //   159: invokevirtual 574	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   162: new 576	java/io/FileInputStream
    //   165: dup
    //   166: aload 10
    //   168: invokespecial 577	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   171: astore 10
    //   173: sipush 8192
    //   176: newarray byte
    //   178: astore 11
    //   180: aload 10
    //   182: aload 11
    //   184: iconst_0
    //   185: sipush 8192
    //   188: invokevirtual 581	java/io/FileInputStream:read	([BII)I
    //   191: istore_2
    //   192: iload_2
    //   193: iconst_m1
    //   194: if_icmpeq +160 -> 354
    //   197: aload 8
    //   199: aload 11
    //   201: iconst_0
    //   202: iload_2
    //   203: invokevirtual 584	java/util/zip/ZipOutputStream:write	([BII)V
    //   206: goto -26 -> 180
    //   209: astore 9
    //   211: aload 10
    //   213: ifnull +8 -> 221
    //   216: aload 10
    //   218: invokevirtual 585	java/io/FileInputStream:close	()V
    //   221: aload 8
    //   223: invokevirtual 586	java/util/zip/ZipOutputStream:flush	()V
    //   226: aload 8
    //   228: invokevirtual 589	java/util/zip/ZipOutputStream:closeEntry	()V
    //   231: aload 9
    //   233: athrow
    //   234: astore 9
    //   236: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   239: ifeq +15 -> 254
    //   242: ldc_w 323
    //   245: iconst_2
    //   246: ldc_w 591
    //   249: aload 9
    //   251: invokestatic 414	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   254: aload 8
    //   256: ifnull +8 -> 264
    //   259: aload 8
    //   261: invokevirtual 592	java/util/zip/ZipOutputStream:close	()V
    //   264: aload_1
    //   265: ifnull +402 -> 667
    //   268: aload_1
    //   269: invokevirtual 593	java/io/BufferedOutputStream:close	()V
    //   272: iconst_0
    //   273: istore 5
    //   275: iload 5
    //   277: istore 6
    //   279: iload 6
    //   281: ifeq +368 -> 649
    //   284: aload_0
    //   285: invokeinterface 486 1 0
    //   290: astore_0
    //   291: aload_0
    //   292: invokeinterface 491 1 0
    //   297: ifeq +352 -> 649
    //   300: aload_0
    //   301: invokeinterface 494 1 0
    //   306: checkcast 15	java/lang/String
    //   309: astore_1
    //   310: aload_1
    //   311: ldc_w 375
    //   314: invokevirtual 65	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   317: ifne -26 -> 291
    //   320: aload_1
    //   321: ldc_w 595
    //   324: invokevirtual 65	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   327: ifne -36 -> 291
    //   330: new 49	java/io/File
    //   333: dup
    //   334: aload_1
    //   335: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   338: astore_1
    //   339: aload_1
    //   340: invokevirtual 91	java/io/File:exists	()Z
    //   343: ifeq -52 -> 291
    //   346: aload_1
    //   347: invokevirtual 598	java/io/File:delete	()Z
    //   350: pop
    //   351: goto -60 -> 291
    //   354: aload 10
    //   356: ifnull +8 -> 364
    //   359: aload 10
    //   361: invokevirtual 585	java/io/FileInputStream:close	()V
    //   364: aload 8
    //   366: invokevirtual 586	java/util/zip/ZipOutputStream:flush	()V
    //   369: aload 8
    //   371: invokevirtual 589	java/util/zip/ZipOutputStream:closeEntry	()V
    //   374: goto -273 -> 101
    //   377: astore 9
    //   379: aload 8
    //   381: ifnull +8 -> 389
    //   384: aload 8
    //   386: invokevirtual 592	java/util/zip/ZipOutputStream:close	()V
    //   389: aload_1
    //   390: ifnull +7 -> 397
    //   393: aload_1
    //   394: invokevirtual 593	java/io/BufferedOutputStream:close	()V
    //   397: aload 9
    //   399: athrow
    //   400: astore_1
    //   401: iconst_0
    //   402: istore 5
    //   404: iload 5
    //   406: istore 6
    //   408: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   411: ifeq -132 -> 279
    //   414: ldc_w 323
    //   417: iconst_2
    //   418: ldc_w 591
    //   421: aload_1
    //   422: invokestatic 414	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   425: iload 5
    //   427: istore 6
    //   429: goto -150 -> 279
    //   432: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   435: ifeq +55 -> 490
    //   438: ldc_w 323
    //   441: iconst_2
    //   442: new 67	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   449: ldc_w 600
    //   452: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: invokestatic 253	java/lang/System:currentTimeMillis	()J
    //   458: lload_3
    //   459: lsub
    //   460: invokevirtual 603	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   463: ldc_w 605
    //   466: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: aload_0
    //   470: invokeinterface 435 1 0
    //   475: invokevirtual 389	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   478: ldc_w 607
    //   481: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   487: invokestatic 609	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   490: aload 8
    //   492: ifnull +8 -> 500
    //   495: aload 8
    //   497: invokevirtual 592	java/util/zip/ZipOutputStream:close	()V
    //   500: aload_1
    //   501: ifnull +172 -> 673
    //   504: aload_1
    //   505: invokevirtual 593	java/io/BufferedOutputStream:close	()V
    //   508: iconst_1
    //   509: istore 5
    //   511: goto -236 -> 275
    //   514: astore 8
    //   516: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   519: ifeq -19 -> 500
    //   522: ldc_w 323
    //   525: iconst_2
    //   526: ldc_w 591
    //   529: aload 8
    //   531: invokestatic 414	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   534: goto -34 -> 500
    //   537: astore_1
    //   538: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   541: ifeq +14 -> 555
    //   544: ldc_w 323
    //   547: iconst_2
    //   548: ldc_w 591
    //   551: aload_1
    //   552: invokestatic 414	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   555: iconst_1
    //   556: istore 5
    //   558: goto -283 -> 275
    //   561: astore 8
    //   563: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   566: ifeq -302 -> 264
    //   569: ldc_w 323
    //   572: iconst_2
    //   573: ldc_w 591
    //   576: aload 8
    //   578: invokestatic 414	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   581: goto -317 -> 264
    //   584: astore_1
    //   585: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   588: ifeq +98 -> 686
    //   591: ldc_w 323
    //   594: iconst_2
    //   595: ldc_w 591
    //   598: aload_1
    //   599: invokestatic 414	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   602: goto +84 -> 686
    //   605: astore 8
    //   607: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   610: ifeq -221 -> 389
    //   613: ldc_w 323
    //   616: iconst_2
    //   617: ldc_w 591
    //   620: aload 8
    //   622: invokestatic 414	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   625: goto -236 -> 389
    //   628: astore_1
    //   629: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   632: ifeq -235 -> 397
    //   635: ldc_w 323
    //   638: iconst_2
    //   639: ldc_w 591
    //   642: aload_1
    //   643: invokestatic 414	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   646: goto -249 -> 397
    //   649: iconst_2
    //   650: anewarray 4	java/lang/Object
    //   653: dup
    //   654: iconst_0
    //   655: iload 6
    //   657: invokestatic 525	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   660: aastore
    //   661: dup
    //   662: iconst_1
    //   663: aload 7
    //   665: aastore
    //   666: areturn
    //   667: iconst_0
    //   668: istore 5
    //   670: goto -395 -> 275
    //   673: iconst_1
    //   674: istore 5
    //   676: goto -401 -> 275
    //   679: astore_1
    //   680: iconst_1
    //   681: istore 5
    //   683: goto -279 -> 404
    //   686: iconst_0
    //   687: istore 5
    //   689: goto -414 -> 275
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	692	0	paramList	List<String>
    //   0	692	1	paramString	String
    //   191	12	2	i	int
    //   92	367	3	l	long
    //   273	415	5	bool1	boolean
    //   277	379	6	bool2	boolean
    //   8	656	7	str	String
    //   87	409	8	localZipOutputStream	java.util.zip.ZipOutputStream
    //   514	16	8	localIOException1	IOException
    //   561	16	8	localIOException2	IOException
    //   605	16	8	localIOException3	IOException
    //   99	17	9	localIterator	Iterator
    //   209	23	9	localObject1	Object
    //   234	16	9	localIOException4	IOException
    //   377	21	9	localObject2	Object
    //   128	232	10	localObject3	Object
    //   178	22	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   173	180	209	finally
    //   180	192	209	finally
    //   197	206	209	finally
    //   89	101	234	java/io/IOException
    //   101	173	234	java/io/IOException
    //   216	221	234	java/io/IOException
    //   221	234	234	java/io/IOException
    //   359	364	234	java/io/IOException
    //   364	374	234	java/io/IOException
    //   432	490	234	java/io/IOException
    //   89	101	377	finally
    //   101	173	377	finally
    //   216	221	377	finally
    //   221	234	377	finally
    //   236	254	377	finally
    //   359	364	377	finally
    //   364	374	377	finally
    //   432	490	377	finally
    //   55	89	400	java/lang/Exception
    //   259	264	400	java/lang/Exception
    //   268	272	400	java/lang/Exception
    //   384	389	400	java/lang/Exception
    //   393	397	400	java/lang/Exception
    //   397	400	400	java/lang/Exception
    //   563	581	400	java/lang/Exception
    //   585	602	400	java/lang/Exception
    //   607	625	400	java/lang/Exception
    //   629	646	400	java/lang/Exception
    //   495	500	514	java/io/IOException
    //   504	508	537	java/io/IOException
    //   259	264	561	java/io/IOException
    //   268	272	584	java/io/IOException
    //   384	389	605	java/io/IOException
    //   393	397	628	java/io/IOException
    //   495	500	679	java/lang/Exception
    //   504	508	679	java/lang/Exception
    //   516	534	679	java/lang/Exception
    //   538	555	679	java/lang/Exception
  }
  
  private static Map.Entry[] a(Map paramMap)
  {
    paramMap = paramMap.entrySet();
    paramMap = (Map.Entry[])paramMap.toArray(new Map.Entry[paramMap.size()]);
    Arrays.sort(paramMap, new abvd());
    return paramMap;
  }
  
  public static String b()
  {
    String str1 = bdns.a(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
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
            QLog.d("LeakInspector", 2, "generateTraces", localIOException);
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
          String str2 = bdhb.a(new File("/data/anr/traces.txt"));
          if (str2 != null) {
            bool = bdhb.a(jdField_a_of_type_JavaLangString, str1, str2);
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
                QLog.d("LeakInspector", 2, "InterruptedException", localInterruptedException);
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
        QLog.d("LeakInspector", 2, "generateMemInfo", paramRunningAppProcessInfo);
      }
    }
  }
  
  public static List<String> b()
  {
    ArrayList localArrayList = new ArrayList();
    long l = System.currentTimeMillis();
    localArrayList.add(a(l));
    localArrayList.add(a(l - 3600000L));
    localArrayList.add(alof.bc + "log.txt");
    return localArrayList;
  }
  
  public static Object[] b(String paramString)
  {
    Object localObject = "";
    if (QLog.isColorLevel()) {
      QLog.d("LeakInspector", 2, "ReportLog dumpHprof : " + paramString);
    }
    String str2 = bdns.a(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      localObject = new File(bdzf.a(Environment.getExternalStorageDirectory().getPath() + "/Tencent/MobileQQ/log/"));
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      String str1 = ((File)localObject).getAbsolutePath();
      localObject = str1;
      if (!str1.endsWith("/")) {
        localObject = str1 + "/";
      }
    }
    for (paramString = (String)localObject + "dump_" + paramString + "_" + str2 + ".hprof";; paramString = localException)
    {
      try
      {
        long l = System.currentTimeMillis();
        if ((bdep.a() * 1024L <= Runtime.getRuntime().totalMemory()) || (!"mounted".equals(Environment.getExternalStorageState()))) {
          break label318;
        }
        Debug.dumpHprofData(paramString);
        if (QLog.isColorLevel()) {
          QLog.d("LeakInspector", 2, "dump used " + (System.currentTimeMillis() - l) + " ms");
        }
        bool = true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("LeakInspector", 2, "generateHprof", localException);
          }
          bool = false;
          continue;
          label318:
          bool = false;
        }
      }
      return new Object[] { Boolean.valueOf(bool), paramString };
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abvc
 * JD-Core Version:    0.7.0.1
 */