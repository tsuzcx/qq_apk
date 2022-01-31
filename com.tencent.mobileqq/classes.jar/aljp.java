import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.codeEngine.MiniResDownloadManager.1;
import com.tencent.mobileqq.ar.codeEngine.MiniResDownloadManager.2;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aljp
{
  public static Handler a;
  private static ArrayList<aljq> a;
  
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
        aljq localaljq = (aljq)localObject[i];
        jdField_a_of_type_AndroidOsHandler.post(new MiniResDownloadManager.1(localaljq, paramInt1, paramInt2));
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
      paramQQAppInterface = (anpc)paramQQAppInterface.getManager(77);
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
      paramQQAppInterface = paramQQAppInterface.a("qq.android.minidecode.so_v8.2.0");
      bool = aljr.a();
      continue;
      paramQQAppInterface = paramQQAppInterface.a("qq.android.minidetect.so_v8.2.0");
      bool = aljt.a();
      continue;
      paramQQAppInterface = paramQQAppInterface.a("qq.android.minidetect.model_v8.2.0");
      bool = aljs.a();
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
        aljq localaljq = (aljq)localObject[i];
        jdField_a_of_type_AndroidOsHandler.post(new MiniResDownloadManager.2(localaljq, paramInt, paramBoolean));
        i += 1;
      }
    }
  }
  
  public static void a(aljq paramaljq)
  {
    if (paramaljq != null) {}
    try
    {
      if (!jdField_a_of_type_JavaUtilArrayList.contains(paramaljq))
      {
        if (QLog.isColorLevel()) {
          QLog.i("MiniRecog.ResDownloadManager", 2, "addDownloadCallback");
        }
        jdField_a_of_type_JavaUtilArrayList.add(paramaljq);
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
              paramQQAppInterface = (anpc)paramQQAppInterface.getManager(77);
            } while (paramQQAppInterface == null);
            if (!paramBoolean) {
              break;
            }
            paramQQAppInterface = (anps)paramQQAppInterface.a("qq.android.minidecode.so_v8.2.0");
          } while ((paramQQAppInterface == null) || (!paramQQAppInterface.g()) || (aljr.a()));
          paramQQAppInterface.g();
        } while (!QLog.isColorLevel());
        QLog.d("MiniRecog.ResDownloadManager", 2, "reset decode so download state");
        return;
        anpu localanpu = (anpu)paramQQAppInterface.a("qq.android.minidetect.so_v8.2.0");
        if ((localanpu != null) && (localanpu.g()) && (!aljt.a()))
        {
          localanpu.g();
          if (QLog.isColorLevel()) {
            QLog.d("MiniRecog.ResDownloadManager", 2, "reset detect so download state");
          }
        }
        paramQQAppInterface = (anpt)paramQQAppInterface.a("qq.android.minidetect.model_v8.2.0");
      } while ((paramQQAppInterface == null) || (!paramQQAppInterface.g()) || (aljs.a()));
      paramQQAppInterface.a();
    } while (!QLog.isColorLevel());
    QLog.d("MiniRecog.ResDownloadManager", 2, "reset model so download state");
  }
  
  private static boolean a(anpn paramanpn)
  {
    if (paramanpn == null) {}
    do
    {
      do
      {
        return false;
        paramanpn = paramanpn.a();
      } while (paramanpn == null);
      if ((!TextUtils.isEmpty(paramanpn.strPkgName)) && (!TextUtils.isEmpty(paramanpn.strResURL_big))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MiniRecog.ResDownloadManager", 2, "strPkgName is empty:" + TextUtils.isEmpty(paramanpn.strPkgName) + " strResURL_big is empty:" + TextUtils.isEmpty(paramanpn.strResURL_big) + " loadState :" + paramanpn.loadState);
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
      paramQQAppInterface = (anpc)paramQQAppInterface.getManager(77);
    } while (paramQQAppInterface == null);
    if (paramBoolean)
    {
      paramQQAppInterface = (anps)paramQQAppInterface.a("qq.android.minidecode.so_v8.2.0");
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
            if (aljr.a()) {
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
    anpu localanpu = (anpu)paramQQAppInterface.a("qq.android.minidetect.so_v8.2.0");
    boolean bool1 = a(localanpu);
    paramBoolean = bool1;
    if (!bool1)
    {
      paramBoolean = bool1;
      if (localanpu != null)
      {
        paramBoolean = bool1;
        if (localanpu.g())
        {
          paramBoolean = bool1;
          if (aljt.a()) {
            paramBoolean = true;
          }
        }
      }
    }
    if (paramBoolean) {
      localanpu.a();
    }
    paramQQAppInterface = (anpt)paramQQAppInterface.a("qq.android.minidetect.model_v8.2.0");
    bool1 = a(paramQQAppInterface);
    if ((!bool1) && (paramQQAppInterface != null) && (paramQQAppInterface.g()) && (aljs.a())) {
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
 * Qualified Name:     aljp
 * JD-Core Version:    0.7.0.1
 */