import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
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

class acik
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
      jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath((String)localObject + "/Tencent/MobileQQ/log/");
      localObject = new File(jdField_a_of_type_JavaLangString);
      if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
        ((File)localObject).mkdirs();
      }
    }
  }
  
  public static int a(String paramString, List<acim> paramList, List<Map<String, Integer>> paramList1)
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
                    localObject1 = (acim)paramList.get(n);
                    ((acim)localObject1).a += j;
                    localObject1 = (acim)paramList.get(n);
                    ((acim)localObject1).b += i;
                    localObject1 = (acim)paramList.get(n);
                    ((acim)localObject1).c += k;
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
    //   0: invokestatic 254	java/lang/System:currentTimeMillis	()J
    //   3: ldc_w 256
    //   6: invokestatic 261	bfzl:a	(JLjava/lang/String;)Ljava/lang/String;
    //   9: astore_3
    //   10: new 67	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   17: getstatic 13	acik:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   20: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 263
    //   26: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_3
    //   30: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc_w 265
    //   36: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore 6
    //   44: invokestatic 268	java/lang/Thread:activeCount	()I
    //   47: istore_2
    //   48: iload_2
    //   49: ifne +8 -> 57
    //   52: ldc 11
    //   54: astore_3
    //   55: aload_3
    //   56: areturn
    //   57: new 270	java/io/BufferedWriter
    //   60: dup
    //   61: new 272	java/io/FileWriter
    //   64: dup
    //   65: aload 6
    //   67: iconst_0
    //   68: invokespecial 275	java/io/FileWriter:<init>	(Ljava/lang/String;Z)V
    //   71: invokespecial 278	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   74: astore 4
    //   76: aload 4
    //   78: astore_3
    //   79: iload_2
    //   80: anewarray 108	java/lang/Thread
    //   83: astore 5
    //   85: aload 4
    //   87: astore_3
    //   88: aload 5
    //   90: invokestatic 282	java/lang/Thread:enumerate	([Ljava/lang/Thread;)I
    //   93: pop
    //   94: aload 4
    //   96: astore_3
    //   97: new 67	java/lang/StringBuilder
    //   100: dup
    //   101: iload_2
    //   102: sipush 1024
    //   105: imul
    //   106: invokespecial 285	java/lang/StringBuilder:<init>	(I)V
    //   109: astore 7
    //   111: iconst_0
    //   112: istore_0
    //   113: goto +307 -> 420
    //   116: aload 4
    //   118: astore_3
    //   119: aload 8
    //   121: invokevirtual 288	java/lang/Thread:isAlive	()Z
    //   124: ifeq +115 -> 239
    //   127: aload 4
    //   129: astore_3
    //   130: aload 7
    //   132: ldc_w 290
    //   135: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload 4
    //   141: astore_3
    //   142: aload 7
    //   144: aload 8
    //   146: invokevirtual 293	java/lang/Thread:getName	()Ljava/lang/String;
    //   149: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 4
    //   155: astore_3
    //   156: aload 7
    //   158: ldc_w 295
    //   161: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 4
    //   167: astore_3
    //   168: aload 8
    //   170: invokevirtual 299	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   173: astore 8
    //   175: aload 8
    //   177: ifnull +62 -> 239
    //   180: iconst_0
    //   181: istore_1
    //   182: aload 4
    //   184: astore_3
    //   185: iload_1
    //   186: aload 8
    //   188: arraylength
    //   189: if_icmpge +50 -> 239
    //   192: aload 4
    //   194: astore_3
    //   195: aload 7
    //   197: ldc_w 301
    //   200: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload 4
    //   206: astore_3
    //   207: aload 7
    //   209: aload 8
    //   211: iload_1
    //   212: aaload
    //   213: invokevirtual 304	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   216: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload 4
    //   222: astore_3
    //   223: aload 7
    //   225: ldc_w 295
    //   228: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: iload_1
    //   233: iconst_1
    //   234: iadd
    //   235: istore_1
    //   236: goto -54 -> 182
    //   239: aload 4
    //   241: astore_3
    //   242: aload 7
    //   244: ldc_w 295
    //   247: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload 4
    //   253: astore_3
    //   254: aload 4
    //   256: aload 7
    //   258: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokevirtual 307	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   264: aload 4
    //   266: astore_3
    //   267: aload 4
    //   269: invokevirtual 310	java/io/BufferedWriter:flush	()V
    //   272: aload 4
    //   274: astore_3
    //   275: aload 7
    //   277: iconst_0
    //   278: invokevirtual 313	java/lang/StringBuilder:setLength	(I)V
    //   281: goto +155 -> 436
    //   284: astore 5
    //   286: aload 4
    //   288: astore_3
    //   289: aload 5
    //   291: invokevirtual 316	java/io/IOException:printStackTrace	()V
    //   294: aload 6
    //   296: astore_3
    //   297: aload 4
    //   299: ifnull -244 -> 55
    //   302: aload 4
    //   304: invokevirtual 317	java/io/BufferedWriter:close	()V
    //   307: aload 6
    //   309: areturn
    //   310: astore_3
    //   311: aload 6
    //   313: areturn
    //   314: aload 6
    //   316: astore_3
    //   317: aload 4
    //   319: ifnull -264 -> 55
    //   322: aload 4
    //   324: invokevirtual 317	java/io/BufferedWriter:close	()V
    //   327: aload 6
    //   329: areturn
    //   330: astore_3
    //   331: aload 6
    //   333: areturn
    //   334: astore 5
    //   336: aconst_null
    //   337: astore 4
    //   339: aload 4
    //   341: astore_3
    //   342: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   345: ifeq +18 -> 363
    //   348: aload 4
    //   350: astore_3
    //   351: ldc_w 324
    //   354: iconst_2
    //   355: ldc_w 326
    //   358: aload 5
    //   360: invokestatic 330	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   363: aload 6
    //   365: astore_3
    //   366: aload 4
    //   368: ifnull -313 -> 55
    //   371: aload 4
    //   373: invokevirtual 317	java/io/BufferedWriter:close	()V
    //   376: aload 6
    //   378: areturn
    //   379: astore_3
    //   380: aload 6
    //   382: areturn
    //   383: astore 4
    //   385: aconst_null
    //   386: astore_3
    //   387: aload_3
    //   388: ifnull +7 -> 395
    //   391: aload_3
    //   392: invokevirtual 317	java/io/BufferedWriter:close	()V
    //   395: aload 4
    //   397: athrow
    //   398: astore_3
    //   399: goto -4 -> 395
    //   402: astore 4
    //   404: goto -17 -> 387
    //   407: astore 5
    //   409: goto -70 -> 339
    //   412: astore 5
    //   414: aconst_null
    //   415: astore 4
    //   417: goto -131 -> 286
    //   420: iload_0
    //   421: iload_2
    //   422: if_icmpge -108 -> 314
    //   425: aload 5
    //   427: iload_0
    //   428: aaload
    //   429: astore 8
    //   431: aload 8
    //   433: ifnonnull -317 -> 116
    //   436: iload_0
    //   437: iconst_1
    //   438: iadd
    //   439: istore_0
    //   440: goto -20 -> 420
    // Local variable table:
    //   start	length	slot	name	signature
    //   112	328	0	i	int
    //   181	55	1	j	int
    //   47	376	2	k	int
    //   9	288	3	localObject1	Object
    //   310	1	3	localIOException1	IOException
    //   316	1	3	localObject2	Object
    //   330	1	3	localIOException2	IOException
    //   341	25	3	localObject3	Object
    //   379	1	3	localIOException3	IOException
    //   386	6	3	localObject4	Object
    //   398	1	3	localIOException4	IOException
    //   74	298	4	localBufferedWriter	java.io.BufferedWriter
    //   383	13	4	localObject5	Object
    //   402	1	4	localObject6	Object
    //   415	1	4	localObject7	Object
    //   83	6	5	arrayOfThread	Thread[]
    //   284	6	5	localIOException5	IOException
    //   334	25	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   407	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   412	14	5	localIOException6	IOException
    //   42	339	6	str	String
    //   109	167	7	localStringBuilder	java.lang.StringBuilder
    //   119	313	8	arrayOfStackTraceElement	java.lang.StackTraceElement[]
    // Exception table:
    //   from	to	target	type
    //   79	85	284	java/io/IOException
    //   88	94	284	java/io/IOException
    //   97	111	284	java/io/IOException
    //   119	127	284	java/io/IOException
    //   130	139	284	java/io/IOException
    //   142	153	284	java/io/IOException
    //   156	165	284	java/io/IOException
    //   168	175	284	java/io/IOException
    //   185	192	284	java/io/IOException
    //   195	204	284	java/io/IOException
    //   207	220	284	java/io/IOException
    //   223	232	284	java/io/IOException
    //   242	251	284	java/io/IOException
    //   254	264	284	java/io/IOException
    //   267	272	284	java/io/IOException
    //   275	281	284	java/io/IOException
    //   302	307	310	java/io/IOException
    //   322	327	330	java/io/IOException
    //   57	76	334	java/lang/OutOfMemoryError
    //   371	376	379	java/io/IOException
    //   57	76	383	finally
    //   391	395	398	java/io/IOException
    //   79	85	402	finally
    //   88	94	402	finally
    //   97	111	402	finally
    //   119	127	402	finally
    //   130	139	402	finally
    //   142	153	402	finally
    //   156	165	402	finally
    //   168	175	402	finally
    //   185	192	402	finally
    //   195	204	402	finally
    //   207	220	402	finally
    //   223	232	402	finally
    //   242	251	402	finally
    //   254	264	402	finally
    //   267	272	402	finally
    //   275	281	402	finally
    //   289	294	402	finally
    //   342	348	402	finally
    //   351	363	402	finally
    //   79	85	407	java/lang/OutOfMemoryError
    //   88	94	407	java/lang/OutOfMemoryError
    //   97	111	407	java/lang/OutOfMemoryError
    //   119	127	407	java/lang/OutOfMemoryError
    //   130	139	407	java/lang/OutOfMemoryError
    //   142	153	407	java/lang/OutOfMemoryError
    //   156	165	407	java/lang/OutOfMemoryError
    //   168	175	407	java/lang/OutOfMemoryError
    //   185	192	407	java/lang/OutOfMemoryError
    //   195	204	407	java/lang/OutOfMemoryError
    //   207	220	407	java/lang/OutOfMemoryError
    //   223	232	407	java/lang/OutOfMemoryError
    //   242	251	407	java/lang/OutOfMemoryError
    //   254	264	407	java/lang/OutOfMemoryError
    //   267	272	407	java/lang/OutOfMemoryError
    //   275	281	407	java/lang/OutOfMemoryError
    //   57	76	412	java/io/IOException
  }
  
  public static String a(long paramLong)
  {
    String str1 = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/" + BaseApplicationImpl.getContext().getPackageName().replace(".", "/") + "/");
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(paramLong);
    localObject = bfzl.a(((Calendar)localObject).getTimeInMillis(), "yy.MM.dd.HH");
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
        acim localacim = new acim();
        HashMap localHashMap = new HashMap();
        localArrayList1.add(localacim);
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
    //   4: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +30 -> 37
    //   10: ldc_w 324
    //   13: iconst_2
    //   14: new 67	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 420
    //   24: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_0
    //   28: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 423	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: invokestatic 254	java/lang/System:currentTimeMillis	()J
    //   40: ldc_w 256
    //   43: invokestatic 261	bfzl:a	(JLjava/lang/String;)Ljava/lang/String;
    //   46: astore 5
    //   48: ldc_w 425
    //   51: invokestatic 428	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   54: invokevirtual 152	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   57: ifeq +704 -> 761
    //   60: new 49	java/io/File
    //   63: dup
    //   64: new 67	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   71: invokestatic 47	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   74: invokevirtual 53	java/io/File:getPath	()Ljava/lang/String;
    //   77: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc 79
    //   82: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 85	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   91: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   94: astore_3
    //   95: aload_3
    //   96: invokevirtual 92	java/io/File:exists	()Z
    //   99: ifne +8 -> 107
    //   102: aload_3
    //   103: invokevirtual 98	java/io/File:mkdirs	()Z
    //   106: pop
    //   107: aload_3
    //   108: invokevirtual 431	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   111: astore 4
    //   113: aload 4
    //   115: astore_3
    //   116: aload 4
    //   118: ldc 61
    //   120: invokevirtual 65	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   123: ifne +24 -> 147
    //   126: new 67	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   133: aload 4
    //   135: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc 61
    //   140: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: astore_3
    //   147: new 67	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   154: aload_3
    //   155: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: ldc_w 433
    //   161: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_0
    //   165: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: ldc_w 374
    //   171: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload 5
    //   176: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: ldc_w 435
    //   182: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: astore 5
    //   190: new 437	java/io/FileOutputStream
    //   193: dup
    //   194: aload 5
    //   196: invokespecial 438	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   199: astore_3
    //   200: aload_3
    //   201: astore_0
    //   202: new 67	java/lang/StringBuilder
    //   205: dup
    //   206: sipush 1024
    //   209: invokespecial 285	java/lang/StringBuilder:<init>	(I)V
    //   212: astore 6
    //   214: aload_3
    //   215: astore_0
    //   216: aload 6
    //   218: ldc_w 440
    //   221: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload_3
    //   226: astore_0
    //   227: aload 6
    //   229: invokestatic 446	com/tencent/mobileqq/app/BaseActivity:getActivityRoutes	()Ljava/util/ArrayList;
    //   232: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload_3
    //   237: astore_0
    //   238: aload 6
    //   240: ldc_w 451
    //   243: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload_3
    //   248: astore_0
    //   249: aload 6
    //   251: ldc_w 453
    //   254: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload_3
    //   259: astore_0
    //   260: getstatic 457	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   263: ifnull +501 -> 764
    //   266: aload_3
    //   267: astore_0
    //   268: getstatic 457	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   271: invokevirtual 460	com/tencent/mobileqq/app/BaseActivity:getCurrentAccountUin	()Ljava/lang/String;
    //   274: astore 4
    //   276: aload_3
    //   277: astore_0
    //   278: aload 6
    //   280: aload 4
    //   282: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload_3
    //   287: astore_0
    //   288: aload 6
    //   290: ldc_w 451
    //   293: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload_3
    //   298: astore_0
    //   299: aload 6
    //   301: ldc_w 462
    //   304: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload_3
    //   309: astore_0
    //   310: aload 6
    //   312: getstatic 467	android/os/Build:MODEL	Ljava/lang/String;
    //   315: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload_3
    //   320: astore_0
    //   321: aload 6
    //   323: ldc_w 451
    //   326: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload_3
    //   331: astore_0
    //   332: aload 6
    //   334: ldc_w 469
    //   337: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload_3
    //   342: astore_0
    //   343: aload 6
    //   345: getstatic 474	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   348: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload_3
    //   353: astore_0
    //   354: aload 6
    //   356: ldc_w 451
    //   359: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: aload_3
    //   364: astore_0
    //   365: aload 6
    //   367: ldc_w 476
    //   370: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload_3
    //   375: astore_0
    //   376: aload 6
    //   378: bipush 100
    //   380: invokestatic 481	com/tencent/mfsdk/MagnifierSDK:a	()Lcom/tencent/mfsdk/MagnifierSDK;
    //   383: invokevirtual 484	com/tencent/mfsdk/MagnifierSDK:a	()Lachu;
    //   386: getfield 488	achu:a	I
    //   389: isub
    //   390: i2l
    //   391: invokestatic 494	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   394: invokevirtual 497	java/lang/Runtime:maxMemory	()J
    //   397: lmul
    //   398: ldc2_w 498
    //   401: ldiv
    //   402: invokevirtual 502	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload_3
    //   407: astore_0
    //   408: aload 6
    //   410: ldc_w 451
    //   413: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload_3
    //   418: astore_0
    //   419: aload 6
    //   421: ldc_w 504
    //   424: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: aload_3
    //   429: astore_0
    //   430: aload 6
    //   432: invokestatic 494	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   435: invokevirtual 507	java/lang/Runtime:totalMemory	()J
    //   438: invokestatic 494	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   441: invokevirtual 510	java/lang/Runtime:freeMemory	()J
    //   444: lsub
    //   445: invokevirtual 502	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: aload_3
    //   450: astore_0
    //   451: aload 6
    //   453: ldc_w 451
    //   456: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: aload_3
    //   461: astore_0
    //   462: aload 6
    //   464: ldc_w 512
    //   467: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: pop
    //   471: aload_3
    //   472: astore_0
    //   473: aload 6
    //   475: invokestatic 494	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   478: invokevirtual 507	java/lang/Runtime:totalMemory	()J
    //   481: invokevirtual 502	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: aload_3
    //   486: astore_0
    //   487: aload 6
    //   489: ldc_w 451
    //   492: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload_3
    //   497: astore_0
    //   498: aload 6
    //   500: ldc_w 514
    //   503: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: pop
    //   507: aload_3
    //   508: astore_0
    //   509: aload 6
    //   511: invokestatic 494	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   514: invokevirtual 510	java/lang/Runtime:freeMemory	()J
    //   517: invokevirtual 502	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   520: pop
    //   521: aload_3
    //   522: astore_0
    //   523: aload 6
    //   525: ldc_w 451
    //   528: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload_3
    //   533: astore_0
    //   534: aload 6
    //   536: ldc_w 516
    //   539: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: aload_3
    //   544: astore_0
    //   545: aload 6
    //   547: invokestatic 494	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   550: invokevirtual 497	java/lang/Runtime:maxMemory	()J
    //   553: invokevirtual 502	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   556: pop
    //   557: aload_3
    //   558: astore_0
    //   559: aload 6
    //   561: ldc_w 451
    //   564: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: pop
    //   568: aload_3
    //   569: astore_0
    //   570: aload 6
    //   572: ldc_w 518
    //   575: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: pop
    //   579: aload_3
    //   580: astore_0
    //   581: aload 6
    //   583: getstatic 522	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   586: invokevirtual 527	android/support/v4/util/MQLruCache:size	()I
    //   589: invokevirtual 390	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: aload_3
    //   594: astore_0
    //   595: aload 6
    //   597: ldc_w 451
    //   600: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: pop
    //   604: aload_3
    //   605: astore_0
    //   606: aload 6
    //   608: ldc_w 529
    //   611: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: pop
    //   615: aload_3
    //   616: astore_0
    //   617: aload 6
    //   619: invokestatic 534	aafp:a	()Laafp;
    //   622: getfield 536	aafp:d	I
    //   625: invokevirtual 390	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: aload_3
    //   630: astore_0
    //   631: aload 6
    //   633: ldc_w 451
    //   636: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: pop
    //   640: aload_3
    //   641: astore_0
    //   642: aload 6
    //   644: ldc_w 538
    //   647: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: pop
    //   651: aload_3
    //   652: astore_0
    //   653: aload 6
    //   655: invokestatic 542	amxy:a	()Ljava/lang/String;
    //   658: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: pop
    //   662: aload_3
    //   663: astore_0
    //   664: aload 6
    //   666: ldc_w 451
    //   669: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: pop
    //   673: aload_3
    //   674: astore_0
    //   675: aload 6
    //   677: ldc_w 544
    //   680: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: pop
    //   684: aload_3
    //   685: astore_0
    //   686: aload 6
    //   688: lload_1
    //   689: invokevirtual 502	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   692: pop
    //   693: aload_3
    //   694: astore_0
    //   695: aload_3
    //   696: aload 6
    //   698: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   701: invokevirtual 548	java/lang/String:getBytes	()[B
    //   704: invokevirtual 551	java/io/FileOutputStream:write	([B)V
    //   707: aload_3
    //   708: astore_0
    //   709: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   712: ifeq +33 -> 745
    //   715: aload_3
    //   716: astore_0
    //   717: ldc_w 324
    //   720: iconst_2
    //   721: new 67	java/lang/StringBuilder
    //   724: dup
    //   725: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   728: ldc_w 553
    //   731: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: aload 5
    //   736: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   742: invokestatic 423	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   745: aload 5
    //   747: astore 4
    //   749: aload_3
    //   750: ifnull +11 -> 761
    //   753: aload_3
    //   754: invokevirtual 554	java/io/FileOutputStream:close	()V
    //   757: aload 5
    //   759: astore 4
    //   761: aload 4
    //   763: areturn
    //   764: ldc_w 556
    //   767: astore 4
    //   769: goto -493 -> 276
    //   772: astore_0
    //   773: aload_0
    //   774: invokevirtual 316	java/io/IOException:printStackTrace	()V
    //   777: aload 5
    //   779: areturn
    //   780: astore 4
    //   782: aconst_null
    //   783: astore_3
    //   784: aload_3
    //   785: astore_0
    //   786: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   789: ifeq +17 -> 806
    //   792: aload_3
    //   793: astore_0
    //   794: ldc_w 324
    //   797: iconst_2
    //   798: ldc_w 558
    //   801: aload 4
    //   803: invokestatic 330	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   806: aload 5
    //   808: astore 4
    //   810: aload_3
    //   811: ifnull -50 -> 761
    //   814: aload_3
    //   815: invokevirtual 554	java/io/FileOutputStream:close	()V
    //   818: aload 5
    //   820: areturn
    //   821: astore_0
    //   822: aload_0
    //   823: invokevirtual 316	java/io/IOException:printStackTrace	()V
    //   826: aload 5
    //   828: areturn
    //   829: astore_3
    //   830: aconst_null
    //   831: astore_0
    //   832: aload_0
    //   833: ifnull +7 -> 840
    //   836: aload_0
    //   837: invokevirtual 554	java/io/FileOutputStream:close	()V
    //   840: aload_3
    //   841: athrow
    //   842: astore_0
    //   843: aload_0
    //   844: invokevirtual 316	java/io/IOException:printStackTrace	()V
    //   847: goto -7 -> 840
    //   850: astore_3
    //   851: goto -19 -> 832
    //   854: astore 4
    //   856: goto -72 -> 784
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	859	0	paramString	String
    //   0	859	1	paramLong	long
    //   94	721	3	localObject1	Object
    //   829	12	3	localObject2	Object
    //   850	1	3	localObject3	Object
    //   2	766	4	localObject4	Object
    //   780	22	4	localIOException1	IOException
    //   808	1	4	localObject5	Object
    //   854	1	4	localIOException2	IOException
    //   46	781	5	str	String
    //   212	485	6	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   753	757	772	java/io/IOException
    //   190	200	780	java/io/IOException
    //   814	818	821	java/io/IOException
    //   190	200	829	finally
    //   836	840	842	java/io/IOException
    //   202	214	850	finally
    //   216	225	850	finally
    //   227	236	850	finally
    //   238	247	850	finally
    //   249	258	850	finally
    //   260	266	850	finally
    //   268	276	850	finally
    //   278	286	850	finally
    //   288	297	850	finally
    //   299	308	850	finally
    //   310	319	850	finally
    //   321	330	850	finally
    //   332	341	850	finally
    //   343	352	850	finally
    //   354	363	850	finally
    //   365	374	850	finally
    //   376	406	850	finally
    //   408	417	850	finally
    //   419	428	850	finally
    //   430	449	850	finally
    //   451	460	850	finally
    //   462	471	850	finally
    //   473	485	850	finally
    //   487	496	850	finally
    //   498	507	850	finally
    //   509	521	850	finally
    //   523	532	850	finally
    //   534	543	850	finally
    //   545	557	850	finally
    //   559	568	850	finally
    //   570	579	850	finally
    //   581	593	850	finally
    //   595	604	850	finally
    //   606	615	850	finally
    //   617	629	850	finally
    //   631	640	850	finally
    //   642	651	850	finally
    //   653	662	850	finally
    //   664	673	850	finally
    //   675	684	850	finally
    //   686	693	850	finally
    //   695	707	850	finally
    //   709	715	850	finally
    //   717	745	850	finally
    //   786	792	850	finally
    //   794	806	850	finally
    //   202	214	854	java/io/IOException
    //   216	225	854	java/io/IOException
    //   227	236	854	java/io/IOException
    //   238	247	854	java/io/IOException
    //   249	258	854	java/io/IOException
    //   260	266	854	java/io/IOException
    //   268	276	854	java/io/IOException
    //   278	286	854	java/io/IOException
    //   288	297	854	java/io/IOException
    //   299	308	854	java/io/IOException
    //   310	319	854	java/io/IOException
    //   321	330	854	java/io/IOException
    //   332	341	854	java/io/IOException
    //   343	352	854	java/io/IOException
    //   354	363	854	java/io/IOException
    //   365	374	854	java/io/IOException
    //   376	406	854	java/io/IOException
    //   408	417	854	java/io/IOException
    //   419	428	854	java/io/IOException
    //   430	449	854	java/io/IOException
    //   451	460	854	java/io/IOException
    //   462	471	854	java/io/IOException
    //   473	485	854	java/io/IOException
    //   487	496	854	java/io/IOException
    //   498	507	854	java/io/IOException
    //   509	521	854	java/io/IOException
    //   523	532	854	java/io/IOException
    //   534	543	854	java/io/IOException
    //   545	557	854	java/io/IOException
    //   559	568	854	java/io/IOException
    //   570	579	854	java/io/IOException
    //   581	593	854	java/io/IOException
    //   595	604	854	java/io/IOException
    //   606	615	854	java/io/IOException
    //   617	629	854	java/io/IOException
    //   631	640	854	java/io/IOException
    //   642	651	854	java/io/IOException
    //   653	662	854	java/io/IOException
    //   664	673	854	java/io/IOException
    //   675	684	854	java/io/IOException
    //   686	693	854	java/io/IOException
    //   695	707	854	java/io/IOException
    //   709	715	854	java/io/IOException
    //   717	745	854	java/io/IOException
  }
  
  /* Error */
  public static String a(String paramString1, List<acim> paramList, List<Map<String, Integer>> paramList1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: new 560	java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial 561	java/lang/StringBuffer:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: new 67	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 563
    //   21: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 136
    //   30: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload 4
    //   35: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc_w 565
    //   41: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokevirtual 568	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   50: pop
    //   51: aload 6
    //   53: ldc_w 570
    //   56: iconst_1
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: iload_3
    //   63: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   66: aastore
    //   67: invokestatic 574	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   70: invokevirtual 568	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   73: pop
    //   74: iconst_0
    //   75: istore_3
    //   76: iload_3
    //   77: aload_1
    //   78: invokeinterface 575 1 0
    //   83: if_icmpge +148 -> 231
    //   86: aload 6
    //   88: ldc_w 577
    //   91: iconst_2
    //   92: anewarray 4	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: getstatic 41	acik:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   100: iload_3
    //   101: aaload
    //   102: aastore
    //   103: dup
    //   104: iconst_1
    //   105: aload_1
    //   106: iload_3
    //   107: invokeinterface 160 2 0
    //   112: checkcast 183	acim
    //   115: getfield 186	acim:a	J
    //   118: invokestatic 580	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   121: aastore
    //   122: invokestatic 574	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   125: invokevirtual 568	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   128: pop
    //   129: aload_2
    //   130: iload_3
    //   131: invokeinterface 160 2 0
    //   136: checkcast 162	java/util/Map
    //   139: invokeinterface 581 1 0
    //   144: ifle +80 -> 224
    //   147: aload_2
    //   148: iload_3
    //   149: invokeinterface 160 2 0
    //   154: checkcast 162	java/util/Map
    //   157: invokestatic 584	acik:a	(Ljava/util/Map;)[Ljava/util/Map$Entry;
    //   160: astore 7
    //   162: iconst_0
    //   163: istore 5
    //   165: iload 5
    //   167: aload 7
    //   169: arraylength
    //   170: if_icmpge +54 -> 224
    //   173: aload 6
    //   175: ldc_w 586
    //   178: iconst_2
    //   179: anewarray 4	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: aload 7
    //   186: iload 5
    //   188: aaload
    //   189: invokeinterface 592 1 0
    //   194: aastore
    //   195: dup
    //   196: iconst_1
    //   197: aload 7
    //   199: iload 5
    //   201: aaload
    //   202: invokeinterface 595 1 0
    //   207: aastore
    //   208: invokestatic 574	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   211: invokevirtual 568	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
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
    //   240: ldc_w 563
    //   243: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_0
    //   247: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc_w 597
    //   253: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokevirtual 568	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   262: pop
    //   263: aload 6
    //   265: invokevirtual 598	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   268: astore_2
    //   269: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq +11 -> 283
    //   275: ldc_w 324
    //   278: iconst_2
    //   279: aload_2
    //   280: invokestatic 601	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: new 67	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   290: getstatic 13	acik:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   293: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: ldc_w 433
    //   299: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload_0
    //   303: invokestatic 603	acik:a	(Ljava/lang/String;)Ljava/lang/String;
    //   306: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: ldc_w 374
    //   312: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload 4
    //   317: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: ldc_w 605
    //   323: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: astore 4
    //   331: new 272	java/io/FileWriter
    //   334: dup
    //   335: aload 4
    //   337: invokespecial 606	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   340: astore_0
    //   341: new 270	java/io/BufferedWriter
    //   344: dup
    //   345: aload_0
    //   346: invokespecial 278	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   349: astore_1
    //   350: aload_1
    //   351: aload_2
    //   352: invokevirtual 307	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   355: aload_1
    //   356: ifnull +7 -> 363
    //   359: aload_1
    //   360: invokevirtual 317	java/io/BufferedWriter:close	()V
    //   363: aload_0
    //   364: ifnull +7 -> 371
    //   367: aload_0
    //   368: invokevirtual 607	java/io/FileWriter:close	()V
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
    //   384: invokevirtual 317	java/io/BufferedWriter:close	()V
    //   387: aload_2
    //   388: ifnull +7 -> 395
    //   391: aload_2
    //   392: invokevirtual 607	java/io/FileWriter:close	()V
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
    //   0	419	1	paramList	List<acim>
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
    String str1 = bfzl.a(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
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
    localStringBuffer.append(FileUtils.readFileContent(new File(paramString2)));
    localStringBuffer.append("\n====== [" + paramString1 + " meminfo end] =======\n");
    if (QLog.isColorLevel()) {
      QLog.i("MagnifierSDK.QAPMDumpMemInfoHandler", 2, localStringBuffer.toString());
    }
  }
  
  private static Map.Entry[] a(Map paramMap)
  {
    paramMap = paramMap.entrySet();
    paramMap = (Map.Entry[])paramMap.toArray(new Map.Entry[paramMap.size()]);
    Arrays.sort(paramMap, new acil());
    return paramMap;
  }
  
  public static String b()
  {
    String str1 = bfzl.a(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
    str1 = "trace_mobileqq" + str1 + ".trace";
    int i = 0;
    for (int j = 0;; j = k)
    {
      if ((i >= 3) || (j != 0)) {
        break label140;
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
    label140:
    if (j != 0)
    {
      i = 0;
      boolean bool = false;
      for (;;)
      {
        if ((i < 3) && (!bool))
        {
          String str2 = FileUtils.readFileContent(new File("/data/anr/traces.txt"));
          if (str2 != null) {
            bool = FileUtils.writeFile(jdField_a_of_type_JavaLangString, str1, str2);
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
    localArrayList.add(AppConstants.LOG_PATH_SDCARD + "log.txt");
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acik
 * JD-Core Version:    0.7.0.1
 */