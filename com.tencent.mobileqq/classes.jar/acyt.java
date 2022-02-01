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

class acyt
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
  
  public static int a(String paramString, List<acyv> paramList, List<Map<String, Integer>> paramList1)
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
            Object localObject2 = null;
            try
            {
              paramString = localBufferedReader.readLine();
              if (paramString != null) {
                break label1040;
              }
              localBufferedReader.close();
              return 0;
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                paramString = (String)localObject2;
                if (QLog.isColorLevel())
                {
                  QLog.d("MagnifierSDK.QAPMDumpMemInfoHandler", 2, "readMapinfo", localIOException);
                  paramString = (String)localObject2;
                }
              }
            }
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
                    label264:
                    n = paramString.length();
                    if (!paramString.equals("[heap]")) {
                      break label469;
                    }
                    i = 0;
                    label281:
                    l1 = l2;
                    n = i;
                    i = m;
                    label291:
                    localObject2 = localBufferedReader.readLine();
                    if (localObject2 != null) {
                      break label644;
                    }
                    i2 = 1;
                    label306:
                    if (i3 != 0) {
                      break label1010;
                    }
                    localObject1 = (Map)paramList1.get(n);
                    if (!((Map)localObject1).containsKey(paramString)) {
                      break label971;
                    }
                    ((Map)localObject1).put(paramString, Integer.valueOf(((Integer)((Map)localObject1).get(paramString)).intValue() + j));
                  }
                }
                for (;;)
                {
                  localObject1 = (acyv)paramList.get(n);
                  ((acyv)localObject1).a += j;
                  localObject1 = (acyv)paramList.get(n);
                  ((acyv)localObject1).b += i;
                  localObject1 = (acyv)paramList.get(n);
                  ((acyv)localObject1).c += k;
                  i1 += j;
                  localObject1 = paramString;
                  m = i;
                  i = n;
                  break;
                  paramString = "";
                  break label264;
                  label469:
                  if (paramString.startsWith("/dev/ashmem/dalvik-"))
                  {
                    i = 1;
                    break label281;
                  }
                  if (paramString.startsWith("/dev/ashmem/CursorWindow"))
                  {
                    i = 2;
                    break label281;
                  }
                  if (paramString.startsWith("/dev/ashmem/"))
                  {
                    i = 3;
                    break label281;
                  }
                  if (paramString.startsWith("/dev/"))
                  {
                    i = 4;
                    break label281;
                  }
                  if (paramString.endsWith(".so"))
                  {
                    i = 5;
                    break label281;
                  }
                  if (paramString.endsWith(".jar"))
                  {
                    i = 6;
                    break label281;
                  }
                  if (paramString.endsWith(".apk"))
                  {
                    i = 7;
                    break label281;
                  }
                  if (paramString.endsWith(".ttf"))
                  {
                    i = 8;
                    break label281;
                  }
                  if (paramString.endsWith(".dex"))
                  {
                    i = 9;
                    break label281;
                  }
                  if (n > 0)
                  {
                    i = 10;
                    break label281;
                  }
                  if ((l3 != l1) || (i != 5)) {
                    break label1034;
                  }
                  i = 5;
                  paramString = (String)localObject1;
                  break label281;
                  i = m;
                  i3 = 1;
                  n = 11;
                  break label291;
                  label644:
                  String[] arrayOfString = ((String)localObject2).split(" ");
                  Object localObject3 = arrayOfString[0];
                  i4 = 0;
                  m = 1;
                  try
                  {
                    while ((m < arrayOfString.length) && (arrayOfString[m].equals(""))) {
                      m += 1;
                    }
                    if (m >= arrayOfString.length) {
                      break label750;
                    }
                    m = Integer.parseInt(arrayOfString[m]);
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      label713:
                      m = i4;
                    }
                  }
                  if (localObject3.equals("Size:"))
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
                    label750:
                    m = 0;
                    break label713;
                    if (localObject3.equals("Rss:"))
                    {
                      m = j;
                      j = k;
                      k = m;
                    }
                    else if (localObject3.equals("Pss:"))
                    {
                      j = k;
                      k = m;
                    }
                    else if (localObject3.equals("Shared_Clean:"))
                    {
                      m = j;
                      j = k;
                      k = m;
                    }
                    else if (localObject3.equals("Shared_Dirty:"))
                    {
                      k = j;
                      j = m;
                    }
                    else if (localObject3.equals("Private_Clean:"))
                    {
                      m = j;
                      j = k;
                      k = m;
                    }
                    else if (localObject3.equals("Private_Dirty:"))
                    {
                      i4 = j;
                      i = m;
                      j = k;
                      k = i4;
                    }
                    else
                    {
                      if (!localObject3.equals("Referenced:")) {
                        break label926;
                      }
                      m = j;
                      j = k;
                      k = m;
                    }
                  }
                  label926:
                  if ((((String)localObject2).length() <= 30) || (((String)localObject2).charAt(8) != '-') || (((String)localObject2).charAt(17) != ' ')) {
                    break label1019;
                  }
                  System.out.println((String)localObject2);
                  break label306;
                  label971:
                  ((Map)localObject1).put(paramString, Integer.valueOf(j));
                }
              }
            }
            localBufferedReader.close();
            return i1;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            int n;
            int i4;
            continue;
            label1010:
            int m = i;
            i = n;
            continue;
            label1019:
            m = j;
            j = k;
            k = m;
            continue;
            label1034:
            i = 11;
            continue;
            label1040:
            i = 11;
            m = 0;
            String str = paramString;
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
    //   0: invokestatic 267	java/lang/System:currentTimeMillis	()J
    //   3: ldc_w 269
    //   6: invokestatic 274	bhid:a	(JLjava/lang/String;)Ljava/lang/String;
    //   9: astore_3
    //   10: new 67	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   17: getstatic 13	acyt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   20: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 276
    //   26: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_3
    //   30: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc_w 278
    //   36: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore 6
    //   44: invokestatic 281	java/lang/Thread:activeCount	()I
    //   47: istore_2
    //   48: iload_2
    //   49: ifne +8 -> 57
    //   52: ldc 11
    //   54: astore_3
    //   55: aload_3
    //   56: areturn
    //   57: new 283	java/io/BufferedWriter
    //   60: dup
    //   61: new 285	java/io/FileWriter
    //   64: dup
    //   65: aload 6
    //   67: iconst_0
    //   68: invokespecial 288	java/io/FileWriter:<init>	(Ljava/lang/String;Z)V
    //   71: invokespecial 291	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   74: astore 4
    //   76: aload 4
    //   78: astore_3
    //   79: iload_2
    //   80: anewarray 110	java/lang/Thread
    //   83: astore 5
    //   85: aload 4
    //   87: astore_3
    //   88: aload 5
    //   90: invokestatic 295	java/lang/Thread:enumerate	([Ljava/lang/Thread;)I
    //   93: pop
    //   94: aload 4
    //   96: astore_3
    //   97: new 67	java/lang/StringBuilder
    //   100: dup
    //   101: iload_2
    //   102: sipush 1024
    //   105: imul
    //   106: invokespecial 298	java/lang/StringBuilder:<init>	(I)V
    //   109: astore 7
    //   111: iconst_0
    //   112: istore_0
    //   113: goto +306 -> 419
    //   116: aload 4
    //   118: astore_3
    //   119: aload 8
    //   121: invokevirtual 301	java/lang/Thread:isAlive	()Z
    //   124: ifeq +115 -> 239
    //   127: aload 4
    //   129: astore_3
    //   130: aload 7
    //   132: ldc_w 303
    //   135: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload 4
    //   141: astore_3
    //   142: aload 7
    //   144: aload 8
    //   146: invokevirtual 306	java/lang/Thread:getName	()Ljava/lang/String;
    //   149: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 4
    //   155: astore_3
    //   156: aload 7
    //   158: ldc_w 308
    //   161: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 4
    //   167: astore_3
    //   168: aload 8
    //   170: invokevirtual 312	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
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
    //   197: ldc_w 314
    //   200: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload 4
    //   206: astore_3
    //   207: aload 7
    //   209: aload 8
    //   211: iload_1
    //   212: aaload
    //   213: invokevirtual 317	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   216: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload 4
    //   222: astore_3
    //   223: aload 7
    //   225: ldc_w 308
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
    //   244: ldc_w 308
    //   247: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload 4
    //   253: astore_3
    //   254: aload 4
    //   256: aload 7
    //   258: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokevirtual 320	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   264: aload 4
    //   266: astore_3
    //   267: aload 4
    //   269: invokevirtual 323	java/io/BufferedWriter:flush	()V
    //   272: aload 4
    //   274: astore_3
    //   275: aload 7
    //   277: iconst_0
    //   278: invokevirtual 326	java/lang/StringBuilder:setLength	(I)V
    //   281: goto +154 -> 435
    //   284: astore 5
    //   286: aload 4
    //   288: astore_3
    //   289: aload 5
    //   291: invokevirtual 329	java/io/IOException:printStackTrace	()V
    //   294: aload 6
    //   296: astore_3
    //   297: aload 4
    //   299: ifnull -244 -> 55
    //   302: aload 4
    //   304: invokevirtual 330	java/io/BufferedWriter:close	()V
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
    //   324: invokevirtual 330	java/io/BufferedWriter:close	()V
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
    //   342: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   345: ifeq +17 -> 362
    //   348: aload 4
    //   350: astore_3
    //   351: ldc 135
    //   353: iconst_2
    //   354: ldc_w 332
    //   357: aload 5
    //   359: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   362: aload 6
    //   364: astore_3
    //   365: aload 4
    //   367: ifnull -312 -> 55
    //   370: aload 4
    //   372: invokevirtual 330	java/io/BufferedWriter:close	()V
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
    //   391: invokevirtual 330	java/io/BufferedWriter:close	()V
    //   394: aload 4
    //   396: athrow
    //   397: astore_3
    //   398: goto -4 -> 394
    //   401: astore 4
    //   403: goto -17 -> 386
    //   406: astore 5
    //   408: goto -69 -> 339
    //   411: astore 5
    //   413: aconst_null
    //   414: astore 4
    //   416: goto -130 -> 286
    //   419: iload_0
    //   420: iload_2
    //   421: if_icmpge -107 -> 314
    //   424: aload 5
    //   426: iload_0
    //   427: aaload
    //   428: astore 8
    //   430: aload 8
    //   432: ifnonnull -316 -> 116
    //   435: iload_0
    //   436: iconst_1
    //   437: iadd
    //   438: istore_0
    //   439: goto -20 -> 419
    // Local variable table:
    //   start	length	slot	name	signature
    //   112	327	0	i	int
    //   181	55	1	j	int
    //   47	375	2	k	int
    //   9	288	3	localObject1	Object
    //   310	1	3	localIOException1	IOException
    //   316	1	3	localObject2	Object
    //   330	1	3	localIOException2	IOException
    //   341	24	3	localObject3	Object
    //   378	1	3	localIOException3	IOException
    //   385	6	3	localObject4	Object
    //   397	1	3	localIOException4	IOException
    //   74	297	4	localBufferedWriter	java.io.BufferedWriter
    //   382	13	4	localObject5	Object
    //   401	1	4	localObject6	Object
    //   414	1	4	localObject7	Object
    //   83	6	5	arrayOfThread	Thread[]
    //   284	6	5	localIOException5	IOException
    //   334	24	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   406	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   411	14	5	localIOException6	IOException
    //   42	338	6	str	String
    //   109	167	7	localStringBuilder	java.lang.StringBuilder
    //   119	312	8	arrayOfStackTraceElement	java.lang.StackTraceElement[]
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
    //   370	375	378	java/io/IOException
    //   57	76	382	finally
    //   390	394	397	java/io/IOException
    //   79	85	401	finally
    //   88	94	401	finally
    //   97	111	401	finally
    //   119	127	401	finally
    //   130	139	401	finally
    //   142	153	401	finally
    //   156	165	401	finally
    //   168	175	401	finally
    //   185	192	401	finally
    //   195	204	401	finally
    //   207	220	401	finally
    //   223	232	401	finally
    //   242	251	401	finally
    //   254	264	401	finally
    //   267	272	401	finally
    //   275	281	401	finally
    //   289	294	401	finally
    //   342	348	401	finally
    //   351	362	401	finally
    //   79	85	406	java/lang/OutOfMemoryError
    //   88	94	406	java/lang/OutOfMemoryError
    //   97	111	406	java/lang/OutOfMemoryError
    //   119	127	406	java/lang/OutOfMemoryError
    //   130	139	406	java/lang/OutOfMemoryError
    //   142	153	406	java/lang/OutOfMemoryError
    //   156	165	406	java/lang/OutOfMemoryError
    //   168	175	406	java/lang/OutOfMemoryError
    //   185	192	406	java/lang/OutOfMemoryError
    //   195	204	406	java/lang/OutOfMemoryError
    //   207	220	406	java/lang/OutOfMemoryError
    //   223	232	406	java/lang/OutOfMemoryError
    //   242	251	406	java/lang/OutOfMemoryError
    //   254	264	406	java/lang/OutOfMemoryError
    //   267	272	406	java/lang/OutOfMemoryError
    //   275	281	406	java/lang/OutOfMemoryError
    //   57	76	411	java/io/IOException
  }
  
  public static String a(long paramLong)
  {
    String str1 = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/" + BaseApplicationImpl.getContext().getPackageName().replace(".", "/") + "/");
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(paramLong);
    localObject = bhid.a(((Calendar)localObject).getTimeInMillis(), "yy.MM.dd.HH");
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
        acyv localacyv = new acyv();
        HashMap localHashMap = new HashMap();
        localArrayList1.add(localacyv);
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
    //   4: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +29 -> 36
    //   10: ldc 135
    //   12: iconst_2
    //   13: new 67	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 422
    //   23: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 425	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: invokestatic 267	java/lang/System:currentTimeMillis	()J
    //   39: ldc_w 269
    //   42: invokestatic 274	bhid:a	(JLjava/lang/String;)Ljava/lang/String;
    //   45: astore 5
    //   47: ldc_w 427
    //   50: invokestatic 430	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   53: invokevirtual 167	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   56: ifeq +703 -> 759
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
    //   87: invokestatic 85	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   90: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   93: astore_3
    //   94: aload_3
    //   95: invokevirtual 92	java/io/File:exists	()Z
    //   98: ifne +8 -> 106
    //   101: aload_3
    //   102: invokevirtual 98	java/io/File:mkdirs	()Z
    //   105: pop
    //   106: aload_3
    //   107: invokevirtual 433	java/io/File:getAbsolutePath	()Ljava/lang/String;
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
    //   157: ldc_w 435
    //   160: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_0
    //   164: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: ldc_w 379
    //   170: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload 5
    //   175: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: ldc_w 437
    //   181: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: astore 5
    //   189: new 439	java/io/FileOutputStream
    //   192: dup
    //   193: aload 5
    //   195: invokespecial 440	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   198: astore_3
    //   199: aload_3
    //   200: astore_0
    //   201: new 67	java/lang/StringBuilder
    //   204: dup
    //   205: sipush 1024
    //   208: invokespecial 298	java/lang/StringBuilder:<init>	(I)V
    //   211: astore 6
    //   213: aload_3
    //   214: astore_0
    //   215: aload 6
    //   217: ldc_w 442
    //   220: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_3
    //   225: astore_0
    //   226: aload 6
    //   228: invokestatic 448	com/tencent/mobileqq/app/BaseActivity:getActivityRoutes	()Ljava/util/ArrayList;
    //   231: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload_3
    //   236: astore_0
    //   237: aload 6
    //   239: ldc_w 453
    //   242: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload_3
    //   247: astore_0
    //   248: aload 6
    //   250: ldc_w 455
    //   253: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload_3
    //   258: astore_0
    //   259: getstatic 459	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   262: ifnull +500 -> 762
    //   265: aload_3
    //   266: astore_0
    //   267: getstatic 459	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   270: invokevirtual 462	com/tencent/mobileqq/app/BaseActivity:getCurrentAccountUin	()Ljava/lang/String;
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
    //   289: ldc_w 453
    //   292: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload_3
    //   297: astore_0
    //   298: aload 6
    //   300: ldc_w 464
    //   303: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload_3
    //   308: astore_0
    //   309: aload 6
    //   311: getstatic 469	android/os/Build:MODEL	Ljava/lang/String;
    //   314: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload_3
    //   319: astore_0
    //   320: aload 6
    //   322: ldc_w 453
    //   325: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload_3
    //   330: astore_0
    //   331: aload 6
    //   333: ldc_w 471
    //   336: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload_3
    //   341: astore_0
    //   342: aload 6
    //   344: getstatic 476	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   347: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload_3
    //   352: astore_0
    //   353: aload 6
    //   355: ldc_w 453
    //   358: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload_3
    //   363: astore_0
    //   364: aload 6
    //   366: ldc_w 478
    //   369: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload_3
    //   374: astore_0
    //   375: aload 6
    //   377: bipush 100
    //   379: invokestatic 483	com/tencent/mfsdk/MagnifierSDK:a	()Lcom/tencent/mfsdk/MagnifierSDK;
    //   382: invokevirtual 486	com/tencent/mfsdk/MagnifierSDK:a	()Lacyc;
    //   385: getfield 490	acyc:a	I
    //   388: isub
    //   389: i2l
    //   390: invokestatic 496	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   393: invokevirtual 499	java/lang/Runtime:maxMemory	()J
    //   396: lmul
    //   397: ldc2_w 500
    //   400: ldiv
    //   401: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload_3
    //   406: astore_0
    //   407: aload 6
    //   409: ldc_w 453
    //   412: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload_3
    //   417: astore_0
    //   418: aload 6
    //   420: ldc_w 506
    //   423: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload_3
    //   428: astore_0
    //   429: aload 6
    //   431: invokestatic 496	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   434: invokevirtual 509	java/lang/Runtime:totalMemory	()J
    //   437: invokestatic 496	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   440: invokevirtual 512	java/lang/Runtime:freeMemory	()J
    //   443: lsub
    //   444: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   447: pop
    //   448: aload_3
    //   449: astore_0
    //   450: aload 6
    //   452: ldc_w 453
    //   455: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload_3
    //   460: astore_0
    //   461: aload 6
    //   463: ldc_w 514
    //   466: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload_3
    //   471: astore_0
    //   472: aload 6
    //   474: invokestatic 496	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   477: invokevirtual 509	java/lang/Runtime:totalMemory	()J
    //   480: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload_3
    //   485: astore_0
    //   486: aload 6
    //   488: ldc_w 453
    //   491: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: pop
    //   495: aload_3
    //   496: astore_0
    //   497: aload 6
    //   499: ldc_w 516
    //   502: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload_3
    //   507: astore_0
    //   508: aload 6
    //   510: invokestatic 496	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   513: invokevirtual 512	java/lang/Runtime:freeMemory	()J
    //   516: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   519: pop
    //   520: aload_3
    //   521: astore_0
    //   522: aload 6
    //   524: ldc_w 453
    //   527: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: pop
    //   531: aload_3
    //   532: astore_0
    //   533: aload 6
    //   535: ldc_w 518
    //   538: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: aload_3
    //   543: astore_0
    //   544: aload 6
    //   546: invokestatic 496	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   549: invokevirtual 499	java/lang/Runtime:maxMemory	()J
    //   552: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   555: pop
    //   556: aload_3
    //   557: astore_0
    //   558: aload 6
    //   560: ldc_w 453
    //   563: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: pop
    //   567: aload_3
    //   568: astore_0
    //   569: aload 6
    //   571: ldc_w 520
    //   574: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: pop
    //   578: aload_3
    //   579: astore_0
    //   580: aload 6
    //   582: getstatic 524	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   585: invokevirtual 529	android/support/v4/util/MQLruCache:size	()I
    //   588: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   591: pop
    //   592: aload_3
    //   593: astore_0
    //   594: aload 6
    //   596: ldc_w 453
    //   599: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: pop
    //   603: aload_3
    //   604: astore_0
    //   605: aload 6
    //   607: ldc_w 531
    //   610: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: pop
    //   614: aload_3
    //   615: astore_0
    //   616: aload 6
    //   618: invokestatic 536	aavb:a	()Laavb;
    //   621: getfield 538	aavb:d	I
    //   624: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   627: pop
    //   628: aload_3
    //   629: astore_0
    //   630: aload 6
    //   632: ldc_w 453
    //   635: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: pop
    //   639: aload_3
    //   640: astore_0
    //   641: aload 6
    //   643: ldc_w 540
    //   646: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: pop
    //   650: aload_3
    //   651: astore_0
    //   652: aload 6
    //   654: invokestatic 544	aoam:a	()Ljava/lang/String;
    //   657: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: pop
    //   661: aload_3
    //   662: astore_0
    //   663: aload 6
    //   665: ldc_w 453
    //   668: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: pop
    //   672: aload_3
    //   673: astore_0
    //   674: aload 6
    //   676: ldc_w 546
    //   679: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: pop
    //   683: aload_3
    //   684: astore_0
    //   685: aload 6
    //   687: lload_1
    //   688: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   691: pop
    //   692: aload_3
    //   693: astore_0
    //   694: aload_3
    //   695: aload 6
    //   697: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   700: invokevirtual 550	java/lang/String:getBytes	()[B
    //   703: invokevirtual 553	java/io/FileOutputStream:write	([B)V
    //   706: aload_3
    //   707: astore_0
    //   708: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   711: ifeq +32 -> 743
    //   714: aload_3
    //   715: astore_0
    //   716: ldc 135
    //   718: iconst_2
    //   719: new 67	java/lang/StringBuilder
    //   722: dup
    //   723: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   726: ldc_w 555
    //   729: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: aload 5
    //   734: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   740: invokestatic 425	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   743: aload 5
    //   745: astore 4
    //   747: aload_3
    //   748: ifnull +11 -> 759
    //   751: aload_3
    //   752: invokevirtual 556	java/io/FileOutputStream:close	()V
    //   755: aload 5
    //   757: astore 4
    //   759: aload 4
    //   761: areturn
    //   762: ldc_w 558
    //   765: astore 4
    //   767: goto -492 -> 275
    //   770: astore_0
    //   771: aload_0
    //   772: invokevirtual 329	java/io/IOException:printStackTrace	()V
    //   775: aload 5
    //   777: areturn
    //   778: astore 4
    //   780: aconst_null
    //   781: astore_3
    //   782: aload_3
    //   783: astore_0
    //   784: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   787: ifeq +16 -> 803
    //   790: aload_3
    //   791: astore_0
    //   792: ldc 135
    //   794: iconst_2
    //   795: ldc_w 560
    //   798: aload 4
    //   800: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   803: aload 5
    //   805: astore 4
    //   807: aload_3
    //   808: ifnull -49 -> 759
    //   811: aload_3
    //   812: invokevirtual 556	java/io/FileOutputStream:close	()V
    //   815: aload 5
    //   817: areturn
    //   818: astore_0
    //   819: aload_0
    //   820: invokevirtual 329	java/io/IOException:printStackTrace	()V
    //   823: aload 5
    //   825: areturn
    //   826: astore_3
    //   827: aconst_null
    //   828: astore_0
    //   829: aload_0
    //   830: ifnull +7 -> 837
    //   833: aload_0
    //   834: invokevirtual 556	java/io/FileOutputStream:close	()V
    //   837: aload_3
    //   838: athrow
    //   839: astore_0
    //   840: aload_0
    //   841: invokevirtual 329	java/io/IOException:printStackTrace	()V
    //   844: goto -7 -> 837
    //   847: astore_3
    //   848: goto -19 -> 829
    //   851: astore 4
    //   853: goto -71 -> 782
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	856	0	paramString	String
    //   0	856	1	paramLong	long
    //   93	719	3	localObject1	Object
    //   826	12	3	localObject2	Object
    //   847	1	3	localObject3	Object
    //   2	764	4	localObject4	Object
    //   778	21	4	localIOException1	IOException
    //   805	1	4	localObject5	Object
    //   851	1	4	localIOException2	IOException
    //   45	779	5	str	String
    //   211	485	6	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   751	755	770	java/io/IOException
    //   189	199	778	java/io/IOException
    //   811	815	818	java/io/IOException
    //   189	199	826	finally
    //   833	837	839	java/io/IOException
    //   201	213	847	finally
    //   215	224	847	finally
    //   226	235	847	finally
    //   237	246	847	finally
    //   248	257	847	finally
    //   259	265	847	finally
    //   267	275	847	finally
    //   277	285	847	finally
    //   287	296	847	finally
    //   298	307	847	finally
    //   309	318	847	finally
    //   320	329	847	finally
    //   331	340	847	finally
    //   342	351	847	finally
    //   353	362	847	finally
    //   364	373	847	finally
    //   375	405	847	finally
    //   407	416	847	finally
    //   418	427	847	finally
    //   429	448	847	finally
    //   450	459	847	finally
    //   461	470	847	finally
    //   472	484	847	finally
    //   486	495	847	finally
    //   497	506	847	finally
    //   508	520	847	finally
    //   522	531	847	finally
    //   533	542	847	finally
    //   544	556	847	finally
    //   558	567	847	finally
    //   569	578	847	finally
    //   580	592	847	finally
    //   594	603	847	finally
    //   605	614	847	finally
    //   616	628	847	finally
    //   630	639	847	finally
    //   641	650	847	finally
    //   652	661	847	finally
    //   663	672	847	finally
    //   674	683	847	finally
    //   685	692	847	finally
    //   694	706	847	finally
    //   708	714	847	finally
    //   716	743	847	finally
    //   784	790	847	finally
    //   792	803	847	finally
    //   201	213	851	java/io/IOException
    //   215	224	851	java/io/IOException
    //   226	235	851	java/io/IOException
    //   237	246	851	java/io/IOException
    //   248	257	851	java/io/IOException
    //   259	265	851	java/io/IOException
    //   267	275	851	java/io/IOException
    //   277	285	851	java/io/IOException
    //   287	296	851	java/io/IOException
    //   298	307	851	java/io/IOException
    //   309	318	851	java/io/IOException
    //   320	329	851	java/io/IOException
    //   331	340	851	java/io/IOException
    //   342	351	851	java/io/IOException
    //   353	362	851	java/io/IOException
    //   364	373	851	java/io/IOException
    //   375	405	851	java/io/IOException
    //   407	416	851	java/io/IOException
    //   418	427	851	java/io/IOException
    //   429	448	851	java/io/IOException
    //   450	459	851	java/io/IOException
    //   461	470	851	java/io/IOException
    //   472	484	851	java/io/IOException
    //   486	495	851	java/io/IOException
    //   497	506	851	java/io/IOException
    //   508	520	851	java/io/IOException
    //   522	531	851	java/io/IOException
    //   533	542	851	java/io/IOException
    //   544	556	851	java/io/IOException
    //   558	567	851	java/io/IOException
    //   569	578	851	java/io/IOException
    //   580	592	851	java/io/IOException
    //   594	603	851	java/io/IOException
    //   605	614	851	java/io/IOException
    //   616	628	851	java/io/IOException
    //   630	639	851	java/io/IOException
    //   641	650	851	java/io/IOException
    //   652	661	851	java/io/IOException
    //   663	672	851	java/io/IOException
    //   674	683	851	java/io/IOException
    //   685	692	851	java/io/IOException
    //   694	706	851	java/io/IOException
    //   708	714	851	java/io/IOException
    //   716	743	851	java/io/IOException
  }
  
  /* Error */
  public static String a(String paramString1, List<acyv> paramList, List<Map<String, Integer>> paramList1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: new 562	java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial 563	java/lang/StringBuffer:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: new 67	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 565
    //   21: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 151
    //   30: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload 4
    //   35: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc_w 567
    //   41: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokevirtual 570	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   50: pop
    //   51: aload 6
    //   53: ldc_w 572
    //   56: iconst_1
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: iload_3
    //   63: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   66: aastore
    //   67: invokestatic 576	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   70: invokevirtual 570	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   73: pop
    //   74: iconst_0
    //   75: istore_3
    //   76: iload_3
    //   77: aload_1
    //   78: invokeinterface 577 1 0
    //   83: if_icmpge +148 -> 231
    //   86: aload 6
    //   88: ldc_w 579
    //   91: iconst_2
    //   92: anewarray 4	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: getstatic 41	acyt:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   100: iload_3
    //   101: aaload
    //   102: aastore
    //   103: dup
    //   104: iconst_1
    //   105: aload_1
    //   106: iload_3
    //   107: invokeinterface 175 2 0
    //   112: checkcast 198	acyv
    //   115: getfield 201	acyv:a	J
    //   118: invokestatic 582	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   121: aastore
    //   122: invokestatic 576	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   125: invokevirtual 570	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   128: pop
    //   129: aload_2
    //   130: iload_3
    //   131: invokeinterface 175 2 0
    //   136: checkcast 177	java/util/Map
    //   139: invokeinterface 583 1 0
    //   144: ifle +80 -> 224
    //   147: aload_2
    //   148: iload_3
    //   149: invokeinterface 175 2 0
    //   154: checkcast 177	java/util/Map
    //   157: invokestatic 586	acyt:a	(Ljava/util/Map;)[Ljava/util/Map$Entry;
    //   160: astore 7
    //   162: iconst_0
    //   163: istore 5
    //   165: iload 5
    //   167: aload 7
    //   169: arraylength
    //   170: if_icmpge +54 -> 224
    //   173: aload 6
    //   175: ldc_w 588
    //   178: iconst_2
    //   179: anewarray 4	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: aload 7
    //   186: iload 5
    //   188: aaload
    //   189: invokeinterface 594 1 0
    //   194: aastore
    //   195: dup
    //   196: iconst_1
    //   197: aload 7
    //   199: iload 5
    //   201: aaload
    //   202: invokeinterface 597 1 0
    //   207: aastore
    //   208: invokestatic 576	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   211: invokevirtual 570	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
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
    //   240: ldc_w 565
    //   243: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_0
    //   247: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc_w 599
    //   253: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokevirtual 570	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   262: pop
    //   263: aload 6
    //   265: invokevirtual 600	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   268: astore_2
    //   269: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq +10 -> 282
    //   275: ldc 135
    //   277: iconst_2
    //   278: aload_2
    //   279: invokestatic 603	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: new 67	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   289: getstatic 13	acyt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   292: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: ldc_w 435
    //   298: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload_0
    //   302: invokestatic 605	acyt:a	(Ljava/lang/String;)Ljava/lang/String;
    //   305: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: ldc_w 379
    //   311: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: aload 4
    //   316: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: ldc_w 607
    //   322: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: astore 4
    //   330: new 285	java/io/FileWriter
    //   333: dup
    //   334: aload 4
    //   336: invokespecial 608	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   339: astore_0
    //   340: new 283	java/io/BufferedWriter
    //   343: dup
    //   344: aload_0
    //   345: invokespecial 291	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   348: astore_1
    //   349: aload_1
    //   350: aload_2
    //   351: invokevirtual 320	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   354: aload_1
    //   355: ifnull +7 -> 362
    //   358: aload_1
    //   359: invokevirtual 330	java/io/BufferedWriter:close	()V
    //   362: aload_0
    //   363: ifnull +7 -> 370
    //   366: aload_0
    //   367: invokevirtual 609	java/io/FileWriter:close	()V
    //   370: aload 4
    //   372: areturn
    //   373: astore_0
    //   374: aconst_null
    //   375: astore_2
    //   376: aconst_null
    //   377: astore_1
    //   378: aload_1
    //   379: ifnull +7 -> 386
    //   382: aload_1
    //   383: invokevirtual 330	java/io/BufferedWriter:close	()V
    //   386: aload_2
    //   387: ifnull +7 -> 394
    //   390: aload_2
    //   391: invokevirtual 609	java/io/FileWriter:close	()V
    //   394: aload_0
    //   395: athrow
    //   396: astore 4
    //   398: aconst_null
    //   399: astore_1
    //   400: aload_0
    //   401: astore_2
    //   402: aload 4
    //   404: astore_0
    //   405: goto -27 -> 378
    //   408: astore 4
    //   410: aload_0
    //   411: astore_2
    //   412: aload 4
    //   414: astore_0
    //   415: goto -37 -> 378
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	paramString1	String
    //   0	418	1	paramList	List<acyv>
    //   0	418	2	paramList1	List<Map<String, Integer>>
    //   0	418	3	paramInt	int
    //   0	418	4	paramString2	String
    //   163	57	5	i	int
    //   7	257	6	localStringBuffer	StringBuffer
    //   160	38	7	arrayOfEntry	Map.Entry[]
    // Exception table:
    //   from	to	target	type
    //   330	340	373	finally
    //   340	349	396	finally
    //   349	354	408	finally
  }
  
  public static List<String> a()
  {
    ArrayList localArrayList = new ArrayList(10);
    String str1 = bhid.a(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
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
    Arrays.sort(paramMap, new acyu());
    return paramMap;
  }
  
  public static String b()
  {
    String str1 = bhid.a(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
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
 * Qualified Name:     acyt
 * JD-Core Version:    0.7.0.1
 */