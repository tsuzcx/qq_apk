import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.debug.JSDebuggerSoLoader.2;
import com.tencent.mobileqq.ark.debug.JSDebuggerSoLoader.3;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

public class algs
{
  private static int jdField_a_of_type_Int = 1;
  private static algu jdField_a_of_type_Algu;
  private static Object jdField_a_of_type_JavaLangObject;
  private static Runnable jdField_a_of_type_JavaLangRunnable = new JSDebuggerSoLoader.3();
  private static String jdField_a_of_type_JavaLangString = "";
  private static boolean jdField_a_of_type_Boolean;
  private static boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static String a()
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      Object localObject = BaseApplicationImpl.getContext();
      if (localObject == null) {
        break label60;
      }
      localObject = ((Context)localObject).getFilesDir();
      if (localObject != null) {
        jdField_a_of_type_JavaLangString = ((File)localObject).getParent() + "/txlib/" + "arkdebugger/";
      }
    }
    for (;;)
    {
      return jdField_a_of_type_JavaLangString;
      label60:
      QLog.w("JSDebuggerSoLoader", 2, "getLibDirPath but context is null");
    }
  }
  
  public static void a(int paramInt, algu paramalgu)
  {
    try
    {
      jdField_a_of_type_Algu = paramalgu;
      jdField_a_of_type_Int = paramInt;
      ThreadManager.remove(jdField_a_of_type_JavaLangRunnable);
      ThreadManager.post(jdField_a_of_type_JavaLangRunnable, 5, null, true);
      return;
    }
    finally
    {
      paramalgu = finally;
      throw paramalgu;
    }
  }
  
  private static String b()
  {
    String str = a();
    if (!TextUtils.isEmpty(str)) {
      return str + "temp/";
    }
    return "";
  }
  
  private static void b()
  {
    b = false;
  }
  
  private static void b(int paramInt)
  {
    if (jdField_a_of_type_Algu != null) {
      jdField_a_of_type_Algu.a(paramInt);
    }
  }
  
  private static void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        Object localObject = new File(paramString);
        if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
        {
          localObject = ((File)localObject).list();
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            File localFile = new File(paramString, localObject[i]);
            if ((localFile.exists()) && (localFile.isFile())) {
              localFile.delete();
            }
            i += 1;
          }
        }
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("JSDebuggerSoLoader", 1, paramString, new Object[0]);
      }
    }
  }
  
  private static void b(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      ArkAppCenter.a(new JSDebuggerSoLoader.2(paramString1, paramString2));
    }
  }
  
  private static boolean b()
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = true;
    try
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_Boolean)
        {
          QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.sync failed");
          return bool1;
        }
        if (b)
        {
          b(2);
          QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.has succeed");
          bool1 = true;
        }
      }
      b(0);
    }
    finally {}
    String str1 = a();
    String str2 = b();
    Object localObject5;
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      c(str1);
      localObject5 = new File(str1 + "libarkDebuggerJSImpl.so");
      if (((File)localObject5).exists())
      {
        QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.js debugger so exists:" + localObject5);
        b(str1, "libarkDebuggerJSImpl.so");
        b(2);
        bool1 = bool2;
        break label564;
      }
    }
    label564:
    for (;;)
    {
      b = bool1;
      break;
      localObject5 = (Pair)alck.b.get("");
      if ((localObject5 != null) && (!TextUtils.isEmpty((CharSequence)((Pair)localObject5).second)))
      {
        c(str2);
        String str3 = str2 + (String)((Pair)localObject5).second;
        if ((new File(str3).exists()) && (b(str2, (String)((Pair)localObject5).second, (String)((Pair)localObject5).second, str1)))
        {
          QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.testZipAndUnzip 1 succeed");
          b(3);
          b(str1, "libarkDebuggerJSImpl.so");
          bool1 = true;
          break label567;
        }
        if (!TextUtils.isEmpty((CharSequence)((Pair)localObject5).first))
        {
          ??? = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
          if (??? != null)
          {
            ??? = (ArkAppCenter)((QQAppInterface)???).getManager(121);
            if (??? != null)
            {
              aldo localaldo = ((ArkAppCenter)???).a();
              if (localaldo != null)
              {
                String str4 = (String)((Pair)localObject5).second;
                b(str2);
                for (;;)
                {
                  synchronized (jdField_a_of_type_JavaLangObject)
                  {
                    if (!jdField_a_of_type_Boolean)
                    {
                      b(1);
                      localaldo.b((String)((Pair)localObject5).first, 0L, new algt(str3, str2, str4, str1));
                      jdField_a_of_type_Boolean = true;
                      QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.downloadArkJSDebugger");
                      bool1 = true;
                    }
                  }
                  QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.downloadArkJSDebugger.sync failed");
                  bool1 = false;
                }
              }
              QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.ArkAppCGI is null");
              break label570;
            }
            QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.ArkAppCenter is null");
            break label570;
          }
          QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.QQAppInterface is null");
          break label570;
        }
        b(7);
        QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.manage URL is null");
        break label570;
      }
      b(7);
      QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.manage MD5 is null");
      bool1 = false;
      break label564;
      b(9);
      QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.necessary dir path is null");
      bool1 = bool3;
    }
    for (;;)
    {
      label567:
      break;
      label570:
      bool1 = false;
    }
  }
  
  private static boolean b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    int i;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4))) {
      try
      {
        b(paramString4);
        paramString2 = new File(paramString1 + paramString2);
        if (paramString2.exists())
        {
          String str = bech.a(paramString2);
          if ((!TextUtils.isEmpty(str)) && (str.equals(paramString3)))
          {
            bace.a(paramString2.getAbsolutePath(), paramString1, false);
            paramString2 = new File(paramString1 + "libarkDebuggerJSImpl.so");
            if ((paramString2 == null) || (!paramString2.exists())) {
              break label406;
            }
            if (bace.d(paramString1 + "libarkDebuggerJSImpl.so", paramString4 + "libarkDebuggerJSImpl.so")) {
              QLog.i("JSDebuggerSoLoader", 2, "testZipAndUnzip.copyFile succeed:" + "libarkDebuggerJSImpl.so");
            }
            for (i = 0;; i = 1)
            {
              paramString2 = new File(paramString1 + "libjsc_ark.so");
              if ((paramString2 == null) || (!paramString2.exists())) {
                break label404;
              }
              if (!bace.d(paramString1 + "libjsc_ark.so", paramString4 + "libjsc_ark.so")) {
                break;
              }
              QLog.i("JSDebuggerSoLoader", 2, "testZipAndUnzip.copyFile succeed:" + "libjsc_ark.so");
              break label412;
              QLog.i("JSDebuggerSoLoader", 2, "testZipAndUnzip.copyFile failed:" + "libarkDebuggerJSImpl.so");
            }
            QLog.i("JSDebuggerSoLoader", 2, "testZipAndUnzip.copyFile failed:" + "libjsc_ark.so");
            i = 1;
          }
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("JSDebuggerSoLoader", 1, paramString1, new Object[0]);
      }
    }
    label404:
    label406:
    label412:
    do
    {
      return false;
      i = 0;
      break;
    } while (i != 0);
    return true;
  }
  
  private static void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = new File(paramString);
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("JSDebuggerSoLoader", 1, paramString, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     algs
 * JD-Core Version:    0.7.0.1
 */