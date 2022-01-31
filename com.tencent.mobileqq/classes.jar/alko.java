import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloSoLoader.1;
import com.tencent.mobileqq.apollo.utils.ApolloSoLoader.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.startup.step.UpdateArkSo;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class alko
{
  public static long a;
  private static Runnable jdField_a_of_type_JavaLangRunnable = new ApolloSoLoader.1();
  public static StringBuilder a;
  public static CopyOnWriteArrayList<WeakReference<alkp>> a;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  public static boolean a;
  public static final String[] a;
  public static long b;
  private static boolean b;
  public static final String[] b;
  private static boolean c;
  public static final String[] c;
  private static boolean d;
  public static final String[] d;
  private static boolean e;
  public static final String[] e;
  private static boolean f;
  public static final String[] f;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "libjsc.so", "libTcHevcDec.so" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "libjsc.so" };
    jdField_c_of_type_ArrayOfJavaLangString = new String[] { "libTcHevcDec.so" };
    jdField_d_of_type_ArrayOfJavaLangString = new String[] { "libv8.so" };
    jdField_e_of_type_ArrayOfJavaLangString = new String[] { "libtinyskia.so", "libsava.so" };
    jdField_f_of_type_ArrayOfJavaLangString = new String[] { "brick.js", "ticker.js", "scene.js", "game.js" };
    jdField_d_of_type_Boolean = true;
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(100);
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private static String a(String paramString)
  {
    return bhss.a();
  }
  
  public static void a() {}
  
  public static void a(int paramInt)
  {
    try
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (WeakReference)localIterator.next();
        if (localObject2 != null)
        {
          localObject2 = (alkp)((WeakReference)localObject2).get();
          if (localObject2 != null) {
            ((alkp)localObject2).a(paramInt);
          }
        }
      }
    }
    finally {}
  }
  
  public static void a(alkp paramalkp)
  {
    if (paramalkp == null) {}
    for (;;)
    {
      return;
      try
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (paramalkp == localWeakReference.get()))
            {
              QLog.i("ApolloSoLoader", 1, "already add, cb:" + paramalkp);
              break;
            }
          }
        }
      }
      finally {}
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(new WeakReference(paramalkp));
    }
  }
  
  public static void a(String paramString)
  {
    boolean bool2 = true;
    try
    {
      QLog.i("ApolloSoLoader", 1, "[loadSo], from:" + paramString + ",sLoadEngineLibDone:" + jdField_b_of_type_Boolean + ",sIsTaskRunning:" + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      bool1 = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
      if (bool1) {}
      for (;;)
      {
        return;
        if (!jdField_b_of_type_Boolean) {
          break;
        }
        a(0);
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      }
      if (BaseApplicationImpl.sProcessId != 1) {
        break label183;
      }
    }
    finally {}
    boolean bool1 = true;
    label106:
    jdField_d_of_type_Boolean = bool1;
    if ((jdField_d_of_type_Boolean) && (aknx.a(BaseApplicationImpl.getContext()))) {}
    for (bool1 = bool2;; bool1 = false)
    {
      jdField_e_of_type_Boolean = bool1;
      if ((jdField_e_of_type_Boolean) && (jdField_a_of_type_Boolean))
      {
        alhp.a(10);
        alhp.a(10, 100);
        jdField_a_of_type_Boolean = false;
      }
      ThreadManager.removeJobFromThreadPool(jdField_a_of_type_JavaLangRunnable, 192);
      ThreadManager.excute(jdField_a_of_type_JavaLangRunnable, 192, null, true);
      break;
      label183:
      bool1 = false;
      break label106;
    }
  }
  
  private static void a(String[] paramArrayOfString)
  {
    for (;;)
    {
      int i;
      synchronized (bhss.a)
      {
        int j = paramArrayOfString.length;
        i = 0;
        if (i < j)
        {
          String str2 = paramArrayOfString[i];
          if (b(str2)) {
            break label223;
          }
          String str1 = bhss.a();
          Object localObject1 = str1;
          if (a(str2)) {
            localObject1 = str1 + "/test";
          }
          localObject1 = new File((String)localObject1, str2);
          QLog.i("ApolloSoLoader", 1, "ready to load [" + ((File)localObject1).getAbsolutePath() + "],[size]:" + ((File)localObject1).length());
          System.load(((File)localObject1).getAbsolutePath());
          QLog.i("ApolloSoLoader", 1, "end to load [" + ((File)localObject1).getAbsolutePath() + "]");
          if (!jdField_e_of_type_Boolean) {
            break label223;
          }
          alhp.a(10, 300, new Object[] { "load [" + ((File)localObject1).getAbsolutePath() + "]" });
        }
      }
      return;
      label223:
      i += 1;
    }
  }
  
  public static boolean a()
  {
    return jdField_b_of_type_Boolean;
  }
  
  public static boolean a(String paramString)
  {
    return false;
  }
  
  private static boolean a(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return false;
    }
    String str1 = bhss.a();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str2 = paramArrayOfString[i];
      File localFile = new File(str1, str2);
      if ((localFile == null) || (!localFile.exists()) || (!localFile.isFile()))
      {
        QLog.w("ApolloSoLoader", 1, "lib " + str2 + " NOT exist.");
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  /* Error */
  public static void b(alkp paramalkp)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +14 -> 18
    //   7: getstatic 70	alko:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   10: invokevirtual 266	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   13: istore_1
    //   14: iload_1
    //   15: ifne +7 -> 22
    //   18: ldc 2
    //   20: monitorexit
    //   21: return
    //   22: getstatic 70	alko:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   25: invokevirtual 94	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   28: astore_2
    //   29: aload_2
    //   30: invokeinterface 100 1 0
    //   35: ifeq -17 -> 18
    //   38: aload_2
    //   39: invokeinterface 104 1 0
    //   44: checkcast 106	java/lang/ref/WeakReference
    //   47: astore_3
    //   48: aload_3
    //   49: ifnull -20 -> 29
    //   52: aload_0
    //   53: aload_3
    //   54: invokevirtual 109	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   57: if_acmpne -28 -> 29
    //   60: getstatic 70	alko:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   63: aload_3
    //   64: invokevirtual 269	java/util/concurrent/CopyOnWriteArrayList:remove	(Ljava/lang/Object;)Z
    //   67: pop
    //   68: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq -53 -> 18
    //   74: ldc 116
    //   76: iconst_2
    //   77: iconst_2
    //   78: anewarray 4	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: ldc_w 274
    //   86: aastore
    //   87: dup
    //   88: iconst_1
    //   89: aload_0
    //   90: aastore
    //   91: invokestatic 277	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   94: goto -76 -> 18
    //   97: astore_0
    //   98: ldc 2
    //   100: monitorexit
    //   101: aload_0
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	paramalkp	alkp
    //   13	2	1	i	int
    //   28	11	2	localIterator	Iterator
    //   47	17	3	localWeakReference	WeakReference
    // Exception table:
    //   from	to	target	type
    //   7	14	97	finally
    //   22	29	97	finally
    //   29	48	97	finally
    //   52	94	97	finally
  }
  
  public static boolean b()
  {
    QLog.i("ApolloSoLoader", 1, "[delAllSoButJsc]");
    try
    {
      String str3;
      boolean bool;
      for (;;)
      {
        synchronized (bhss.a)
        {
          String str1 = bhss.a();
          arrayOfString = jdField_e_of_type_ArrayOfJavaLangString;
          j = arrayOfString.length;
          i = 0;
          if (i < j)
          {
            str3 = arrayOfString[i];
            bool = bdhb.d(str1 + "/" + str3);
            if (!bool) {
              return false;
            }
            i += 1;
            continue;
          }
          arrayOfString = jdField_f_of_type_ArrayOfJavaLangString;
          j = arrayOfString.length;
          i = 0;
          if (i >= j) {
            break;
          }
          str3 = arrayOfString[i];
          bool = bdhb.d(str1 + "/" + str3);
          if (!bool) {
            return false;
          }
        }
        i += 1;
      }
      String[] arrayOfString = jdField_d_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        str3 = arrayOfString[i];
        bool = bdhb.d(str2 + "/" + str3);
        if (!bool) {
          return false;
        }
        i += 1;
      }
      bdhb.a(bhss.a(1), false);
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSoLoader", 1, "Fail to del so files." + localThrowable);
    }
    return false;
  }
  
  private static boolean b(int paramInt)
  {
    try
    {
      synchronized (bhss.a)
      {
        File localFile1 = new File(bhss.a(paramInt));
        String str1 = bhss.a();
        if (localFile1.exists())
        {
          File[] arrayOfFile = localFile1.listFiles();
          int j = arrayOfFile.length;
          int i = 0;
          while (i < j)
          {
            File localFile2 = arrayOfFile[i];
            String str2 = localFile2.getAbsolutePath();
            String str3 = str1 + localFile2.getName();
            boolean bool = bdhb.d(str2, str3);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[tryCopyFromTmpDir] fromPath=").append(str2).append(", fromLen=").append(localFile2.length()).append(", toPath=").append(str3).append(", copy ret=").append(bool);
            QLog.i("ApolloSoLoader", 1, localStringBuilder.toString());
            if (jdField_e_of_type_Boolean) {
              alhp.a(10, 100, new Object[] { localStringBuilder.toString() });
            }
            if (!bool) {
              return false;
            }
            i += 1;
          }
          bdhb.a(localFile1.getAbsolutePath());
          QLog.i("ApolloSoLoader", 1, "[tryCopyFromTmpDir], done. type:" + paramInt);
        }
        return true;
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSoLoader", 1, localThrowable, new Object[0]);
    }
  }
  
  private static boolean b(String paramString)
  {
    if (!AppSetting.g) {}
    while (!"libsava.so".equals(paramString)) {
      return false;
    }
    System.loadLibrary("sava");
    QLog.i("ApolloSoLoader", 1, "sava is loaded for asan test.");
    return true;
  }
  
  private static void c(int paramInt)
  {
    QLog.i("ApolloSoLoader", 1, "[startDownload], libType:" + paramInt);
    long l;
    if (paramInt == 0)
    {
      l = System.currentTimeMillis() - jdField_b_of_type_Long;
      if (l < 120000L)
      {
        QLog.i("ApolloSoLoader", 1, "[startDownload], it's not time for downloading jsc.");
        if (jdField_e_of_type_Boolean) {
          alhp.a(10, 200, new Object[] { "it's not time for downloading jsc, deltaT:", Long.valueOf(l) });
        }
      }
    }
    do
    {
      do
      {
        return;
        if (jdField_e_of_type_Boolean) {
          alhp.a(10, 200, new Object[] { "startDownload:", Long.valueOf(l) });
        }
        jdField_b_of_type_Long = System.currentTimeMillis();
        apkx.a();
        return;
      } while (paramInt != 1);
      l = System.currentTimeMillis() - jdField_a_of_type_Long;
      if (l >= 120000L) {
        break;
      }
      QLog.i("ApolloSoLoader", 1, "[startDownload], it's not time for downloading sava.");
    } while (!jdField_e_of_type_Boolean);
    alhp.a(10, 201, new Object[] { "it's not time for downloading jsc, deltaT:", Long.valueOf(l) });
    return;
    jdField_a_of_type_Long = System.currentTimeMillis();
    if (jdField_e_of_type_Boolean) {
      alhp.a(10, 201, new Object[] { "startDownload:", Long.valueOf(l) });
    }
    apky.a();
  }
  
  private static void e()
  {
    try
    {
      File localFile = new File(BaseApplicationImpl.getContext().getFilesDir().getParent() + "/txlib/libsava.so");
      if ((localFile.exists()) && (localFile.delete())) {
        QLog.i("ApolloSoLoader", 1, "success to del old so.");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSoLoader", 1, localThrowable, new Object[0]);
    }
  }
  
  private static void f()
  {
    try
    {
      File localFile = new File(alof.aX + "pddata/prd/early", "android.qq.apollo.js.833g1");
      if (!localFile.exists())
      {
        c(1);
        return;
      }
      if (!jdField_c_of_type_Boolean)
      {
        bhss.a(localFile.getAbsolutePath(), 1);
        jdField_c_of_type_Boolean = true;
        QLog.i("ApolloSoLoader", 1, "[tryUnzipFromBackup], unzip success.");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSoLoader", 1, "[tryUnzipFromBackup]," + localThrowable);
    }
  }
  
  private static void g() {}
  
  private static void h()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label34;
      }
      ApolloCmdChannel.getChannel((QQAppInterface)localObject).checkSetNative();
    }
    for (;;)
    {
      aknx.b();
      return;
      label34:
      if ((localObject instanceof ToolAppRuntime))
      {
        localObject = akwd.a();
        if (localObject != null) {
          ((ApolloCmdChannel)localObject).checkSetNative();
        }
      }
    }
  }
  
  private static boolean j()
  {
    int i = 4;
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        if (jdField_d_of_type_Boolean) {
          i = 0;
        }
        SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", i);
        String str = localSharedPreferences.getString("res_name", "nothing");
        bool1 = localSharedPreferences.getBoolean("is_handle_reinstall_android.qq.apollo.js.833g1", false);
        if ((jdField_f_of_type_Boolean) || ((bool1) && (str.equals("android.qq.apollo.js.833g1")))) {
          break label257;
        }
        if (str.equals("android.qq.apollo.js.833g1")) {
          break;
        }
        QLog.i("ApolloSoLoader", 1, "oldRes:" + str + ",newRes:" + "android.qq.apollo.js.833g1");
        if (k())
        {
          bool1 = false;
          if (bool1)
          {
            localSharedPreferences.edit().putBoolean("is_handle_reinstall_android.qq.apollo.js.833g1", true).commit();
            jdField_f_of_type_Boolean = true;
          }
          bool1 = bool2;
          if (!jdField_e_of_type_Boolean) {
            return bool1;
          }
          alhp.a(10, 100, new Object[] { "reinstall delete old so, oldRes:", str, ",newRes:", "android.qq.apollo.js.833g1" });
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ApolloSoLoader", 1, localThrowable, new Object[0]);
        if (jdField_e_of_type_Boolean) {
          alhp.a(10, 100, new Object[] { "reinstall th:", localThrowable });
        }
        b();
        return false;
      }
      bool1 = b();
    }
    return false;
    label257:
    boolean bool1 = false;
    return bool1;
  }
  
  private static boolean k()
  {
    String str1 = bhss.a() + "libsava.so" + "." + "android.qq.apollo.js.833g1";
    if (new File(str1).exists())
    {
      QLog.i("ApolloSoLoader", 1, "Bingo, the latest sava has been predownloaded.");
      String str2 = bhss.a() + "libsava.so";
      bdhb.d(str2);
      if (!bdhb.c(str1, str2))
      {
        QLog.w("ApolloSoLoader", 1, "fail to rename.");
        return false;
      }
      return true;
    }
    QLog.i("ApolloSoLoader", 1, "It's a pity that the latest sava hasn't been predownloaded.");
    return false;
  }
  
  private static boolean l()
  {
    for (;;)
    {
      try
      {
        if (ApolloGameUtil.a())
        {
          QLog.i("ApolloSoLoader", 1, "[loadAllSo], Aborting! arch=x86");
          if (!jdField_e_of_type_Boolean) {
            break;
          }
          alhp.a(10, 300, 1002, new Object[] { "arch=x86" });
          break;
        }
        if (!UpdateArkSo.a(BaseApplicationImpl.getContext(), UpdateArkSo.a()))
        {
          if (!jdField_e_of_type_Boolean) {
            break label531;
          }
          alhp.a(10, 300, 1003, new Object[] { "png-armeabi-v7a load failed" });
          jdField_a_of_type_Boolean = true;
          break label531;
        }
        Object localObject = akwd.a();
        if (!(localObject instanceof AppInterface)) {
          break label524;
        }
        localObject = (apks)((AppInterface)localObject).getManager(77);
        if (localObject == null) {
          break label524;
        }
        localObject = (apky)((apks)localObject).a("android.qq.apollo.js.833g1");
        if (localObject == null) {
          break label524;
        }
        localObject = ((apky)localObject).a();
        if (localObject == null) {
          break label524;
        }
        i = ((XmlData)localObject).Version;
        QLog.i("ApolloSoLoader", 1, "[so info], str:android.qq.apollo.js.833g1,ver:" + i + ", IS_CPU_64_BIT=" + false);
        if (jdField_e_of_type_Boolean) {
          alhp.a(10, 300, new Object[] { "[so info], str:android.qq.apollo.js.833g1,ver:" + i });
        }
        if (a(jdField_d_of_type_ArrayOfJavaLangString))
        {
          a(jdField_d_of_type_ArrayOfJavaLangString);
          a(jdField_e_of_type_ArrayOfJavaLangString);
          if (!jdField_d_of_type_Boolean) {
            break label519;
          }
          i = 0;
          localObject = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", i);
          if (localObject != null) {
            ((SharedPreferences)localObject).edit().putString("res_name", "android.qq.apollo.js.833g1").commit();
          }
          localObject = BaseApplicationImpl.getApplication().getRuntime();
          if ((localObject != null) && ((localObject instanceof QQAppInterface)))
          {
            ArkAppCenter.a().postToMainThread(new ApolloSoLoader.2());
            QLog.e("ApolloSoLoader", 1, "[loadAllSo], Notify ark jsc has loaded.");
          }
          if (!jdField_e_of_type_Boolean) {
            break label533;
          }
          alhp.a(10, 300, 0, new Object[] { "loadAllSo success" });
          break label533;
        }
        if ((BaseApplicationImpl.sProcessId == 2) || (BaseApplicationImpl.sProcessId == 8))
        {
          a(jdField_b_of_type_ArrayOfJavaLangString);
          continue;
        }
        a(jdField_b_of_type_ArrayOfJavaLangString);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ApolloSoLoader", 1, "[loadAllSo], Something unexpected happened." + localThrowable);
        f();
        if (jdField_e_of_type_Boolean)
        {
          alhp.a(10, 300, 1004, new Object[] { "[loadAllSo], Something unexpected happened.", localThrowable });
          jdField_a_of_type_Boolean = true;
        }
        return false;
      }
      alhp.a(10, 299);
      if (!UpdateAvSo.a())
      {
        QLog.e("ApolloSoLoader", 1, "[loadAllSo] sharpp load error");
        alhp.a(10, 299, 1005, new Object[] { "sharpp load fail" });
        return false;
      }
      alhp.a(10, 299, 0, new Object[0]);
      continue;
      label519:
      int i = 4;
      continue;
      label524:
      i = -1;
    }
    return false;
    label531:
    return false;
    label533:
    return true;
  }
  
  private static boolean m()
  {
    if (!a(jdField_e_of_type_ArrayOfJavaLangString)) {}
    while (!a(jdField_f_of_type_ArrayOfJavaLangString)) {
      return false;
    }
    boolean bool = new aljn(-1, 3, "", "").a();
    QLog.i("ApolloSoLoader", 1, "[isSavaSoExists], check result:" + bool);
    if (jdField_e_of_type_Boolean) {
      alhp.a(10, 100, new Object[] { "[isSavaSoExists], check result:" + bool });
    }
    return bool;
  }
  
  private static boolean n()
  {
    boolean bool;
    if ((BaseApplicationImpl.sProcessId == 2) || (BaseApplicationImpl.sProcessId == 8))
    {
      if (a(jdField_b_of_type_ArrayOfJavaLangString))
      {
        QLog.i("ApolloSoLoader", 1, "jsc exists at new path.");
        if (new File(bhss.a() + "checkList_jsc").exists())
        {
          bool = new aljn(-1, 4, "", "").a();
          QLog.i("ApolloSoLoader", 1, "[isJscSoExists], check result:" + bool);
          return bool;
        }
        return true;
      }
    }
    else if (a(jdField_a_of_type_ArrayOfJavaLangString))
    {
      QLog.i("ApolloSoLoader", 1, "jsc exists at new path.");
      if (new File(bhss.a() + "checkList_jsc").exists())
      {
        bool = new aljn(-1, 4, "", "").a();
        QLog.i("ApolloSoLoader", 1, "[isJscSoExists], check result:" + bool);
        return bool;
      }
      return true;
    }
    String str1 = BaseApplicationImpl.getContext().getFilesDir().getParent() + "/txlib/";
    int j;
    int i;
    Object localObject2;
    if ((BaseApplicationImpl.sProcessId == 2) || (BaseApplicationImpl.sProcessId == 8))
    {
      ??? = jdField_b_of_type_ArrayOfJavaLangString;
      j = ???.length;
      i = 0;
      if (i >= j) {
        break label640;
      }
      localObject2 = new File(str1, ???[i]);
      if ((localObject2 == null) || (!((File)localObject2).exists()) || (!((File)localObject2).isFile())) {
        i = 0;
      }
    }
    for (;;)
    {
      label316:
      if (i != 0)
      {
        localObject2 = bhss.a();
        for (;;)
        {
          try
          {
            synchronized (bhss.a)
            {
              if ((BaseApplicationImpl.sProcessId != 2) && (BaseApplicationImpl.sProcessId != 8)) {
                continue;
              }
              arrayOfString = jdField_b_of_type_ArrayOfJavaLangString;
              j = arrayOfString.length;
              i = 0;
              if (i >= j) {
                continue;
              }
              str3 = arrayOfString[i];
              bool = bdhb.d(str1 + "/" + str3, (String)localObject2 + str3);
              if (bool) {
                continue;
              }
              return false;
            }
            i += 1;
          }
          catch (Throwable localThrowable)
          {
            String[] arrayOfString;
            String str3;
            QLog.e("ApolloSoLoader", 1, localThrowable, new Object[0]);
            return false;
          }
          ??? = jdField_a_of_type_ArrayOfJavaLangString;
          j = ???.length;
          i = 0;
          if (i >= j) {
            break label640;
          }
          localObject2 = new File(str2, ???[i]);
          if ((localObject2 == null) || (!((File)localObject2).exists()) || (!((File)localObject2).isFile()))
          {
            i = 0;
            break label316;
          }
          i += 1;
          continue;
          i += 1;
        }
        arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
        j = arrayOfString.length;
        i = 0;
        while (i < j)
        {
          str3 = arrayOfString[i];
          bool = bdhb.d(str2 + "/" + str3, (String)localObject2 + str3);
          if (!bool) {
            return false;
          }
          i += 1;
        }
        QLog.i("ApolloSoLoader", 1, "copy jsc from old path.");
        return true;
      }
      QLog.i("ApolloSoLoader", 1, "jsc NOT exists at old path.");
      return false;
      label640:
      i = 1;
    }
  }
  
  private static boolean o()
  {
    long l1 = System.currentTimeMillis();
    try
    {
      if (TextUtils.isEmpty(aknx.f)) {
        aknx.f = bdhb.b(new File(a("brick.js"), "brick.js"));
      }
      if (TextUtils.isEmpty(aknx.g)) {
        aknx.g = bdhb.b(new File(a("ticker.js"), "ticker.js"));
      }
      if (TextUtils.isEmpty(aknx.h)) {
        aknx.h = bdhb.b(new File(a("scene.js"), "scene.js"));
      }
      if (TextUtils.isEmpty(aknx.i)) {
        aknx.i = bdhb.b(new File(a("game.js"), "game.js"));
      }
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSoLoader", 1, "[initScriptLib]," + localThrowable);
      if (jdField_e_of_type_Boolean) {
        alhp.a(10, 100, new Object[] { "[initScriptLib], th:", localThrowable });
      }
      return false;
    }
    finally
    {
      long l2 = System.currentTimeMillis();
      QLog.i("ApolloSoLoader", 1, "[initScriptLib], costT:" + (l2 - l1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alko
 * JD-Core Version:    0.7.0.1
 */