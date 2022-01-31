import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.codeEngine.MiniResDownloadManager.1;
import com.tencent.mobileqq.ar.codeEngine.MiniResDownloadManager.2;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class akve
{
  public static Handler a;
  private static ArrayList<akvf> a;
  
  static
  {
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
  }
  
  public static void a()
  {
    if (jdField_a_of_type_JavaUtilArrayList != null) {
      jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.ResDownloadManager", 2, "clearCallback");
    }
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        Object[] arrayOfObject = jdField_a_of_type_JavaUtilArrayList.toArray();
        if ((arrayOfObject == null) || (arrayOfObject.length <= 0)) {
          return;
        }
      }
      finally {}
      int i = 0;
      while (i < localObject.length)
      {
        akvf localakvf = (akvf)localObject[i];
        jdField_a_of_type_AndroidOsHandler.post(new MiniResDownloadManager.1(localakvf, paramInt1, paramInt2));
        i += 1;
      }
    }
  }
  
  public static void a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MiniRecog.ResDownloadManager", 2, "downloadFaceRes app is null");
      }
    }
    do
    {
      return;
      paramQQAppInterface = (amyp)paramQQAppInterface.getManager(77);
    } while (paramQQAppInterface == null);
    boolean bool;
    switch (paramInt)
    {
    default: 
      bool = false;
      paramQQAppInterface = null;
    }
    while (paramQQAppInterface != null)
    {
      paramInt = paramQQAppInterface.b();
      if (QLog.isColorLevel()) {
        QLog.d("MiniRecog.ResDownloadManager", 2, "initAr version=" + paramQQAppInterface.b());
      }
      if ((bool) && (paramQQAppInterface.g()) && (paramInt > 1)) {
        break;
      }
      paramQQAppInterface.a(true);
      return;
      paramQQAppInterface = paramQQAppInterface.a("qq.android.minidecode.so_v8.1.5");
      bool = akvg.a();
      continue;
      paramQQAppInterface = paramQQAppInterface.a("qq.android.minidetect.so_v8.0.7");
      bool = akvi.a();
      continue;
      paramQQAppInterface = paramQQAppInterface.a("qq.android.minidetect.model_v8.0.7");
      bool = akvh.a();
    }
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        Object[] arrayOfObject = jdField_a_of_type_JavaUtilArrayList.toArray();
        if ((arrayOfObject == null) || (arrayOfObject.length <= 0)) {
          return;
        }
      }
      finally {}
      int i = 0;
      while (i < localObject.length)
      {
        akvf localakvf = (akvf)localObject[i];
        jdField_a_of_type_AndroidOsHandler.post(new MiniResDownloadManager.2(localakvf, paramInt, paramBoolean));
        i += 1;
      }
    }
  }
  
  public static void a(akvf paramakvf)
  {
    if (paramakvf != null) {}
    try
    {
      if (!jdField_a_of_type_JavaUtilArrayList.contains(paramakvf))
      {
        if (QLog.isColorLevel()) {
          QLog.i("MiniRecog.ResDownloadManager", 2, "addDownloadCallback");
        }
        jdField_a_of_type_JavaUtilArrayList.add(paramakvf);
      }
      return;
    }
    finally {}
  }
  
  public static void a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              paramQQAppInterface = (amyp)paramQQAppInterface.getManager(77);
            } while (paramQQAppInterface == null);
            if (!paramBoolean) {
              break;
            }
            paramQQAppInterface = (amzf)paramQQAppInterface.a("qq.android.minidecode.so_v8.1.5");
          } while ((paramQQAppInterface == null) || (!paramQQAppInterface.g()) || (akvg.a()));
          paramQQAppInterface.g();
        } while (!QLog.isColorLevel());
        QLog.d("MiniRecog.ResDownloadManager", 2, "reset decode so download state");
        return;
        amzh localamzh = (amzh)paramQQAppInterface.a("qq.android.minidetect.so_v8.0.7");
        if ((localamzh != null) && (localamzh.g()) && (!akvi.a()))
        {
          localamzh.g();
          if (QLog.isColorLevel()) {
            QLog.d("MiniRecog.ResDownloadManager", 2, "reset detect so download state");
          }
        }
        paramQQAppInterface = (amzg)paramQQAppInterface.a("qq.android.minidetect.model_v8.0.7");
      } while ((paramQQAppInterface == null) || (!paramQQAppInterface.g()) || (akvh.a()));
      paramQQAppInterface.a();
    } while (!QLog.isColorLevel());
    QLog.d("MiniRecog.ResDownloadManager", 2, "reset model so download state");
  }
  
  private static boolean a(amza paramamza)
  {
    if (paramamza == null) {}
    do
    {
      do
      {
        return false;
        paramamza = paramamza.a();
      } while (paramamza == null);
      if ((!TextUtils.isEmpty(paramamza.strPkgName)) && (!TextUtils.isEmpty(paramamza.strResURL_big))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MiniRecog.ResDownloadManager", 2, "strPkgName is empty:" + TextUtils.isEmpty(paramamza.strPkgName) + " strResURL_big is empty:" + TextUtils.isEmpty(paramamza.strResURL_big) + " loadState :" + paramamza.loadState);
    return false;
    return true;
  }
  
  public static boolean a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = true;
    if (paramQQAppInterface == null) {}
    do
    {
      return false;
      paramQQAppInterface = (amyp)paramQQAppInterface.getManager(77);
    } while (paramQQAppInterface == null);
    if (paramBoolean)
    {
      paramQQAppInterface = (amzf)paramQQAppInterface.a("qq.android.minidecode.so_v8.1.5");
      bool1 = a(paramQQAppInterface);
      paramBoolean = bool1;
      if (!bool1)
      {
        paramBoolean = bool1;
        if (paramQQAppInterface != null)
        {
          paramBoolean = bool1;
          if (paramQQAppInterface.g())
          {
            paramBoolean = bool1;
            if (akvg.a()) {
              paramBoolean = true;
            }
          }
        }
      }
      if (paramBoolean) {
        paramQQAppInterface.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("MiniRecog.ResDownloadManager", 2, String.format("isMiniResConfigReady config exist [decode]=[%b]", new Object[] { Boolean.valueOf(paramBoolean) }));
      }
      return paramBoolean;
    }
    amzh localamzh = (amzh)paramQQAppInterface.a("qq.android.minidetect.so_v8.0.7");
    boolean bool1 = a(localamzh);
    paramBoolean = bool1;
    if (!bool1)
    {
      paramBoolean = bool1;
      if (localamzh != null)
      {
        paramBoolean = bool1;
        if (localamzh.g())
        {
          paramBoolean = bool1;
          if (akvi.a()) {
            paramBoolean = true;
          }
        }
      }
    }
    if (paramBoolean) {
      localamzh.a();
    }
    paramQQAppInterface = (amzg)paramQQAppInterface.a("qq.android.minidetect.model_v8.0.7");
    bool1 = a(paramQQAppInterface);
    if ((!bool1) && (paramQQAppInterface != null) && (paramQQAppInterface.g()) && (akvh.a())) {
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniRecog.ResDownloadManager", 2, String.format("isMiniResConfigReady config exist [detect,model]=[%b,%b]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1) }));
      }
      if ((paramBoolean) && (bool1)) {}
      for (paramBoolean = bool2;; paramBoolean = false) {
        return paramBoolean;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akve
 * JD-Core Version:    0.7.0.1
 */