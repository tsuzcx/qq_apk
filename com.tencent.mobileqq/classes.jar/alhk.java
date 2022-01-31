import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class alhk
{
  private static alhk jdField_a_of_type_Alhk;
  alhj jdField_a_of_type_Alhj;
  alhl jdField_a_of_type_Alhl = new alhl();
  alhn jdField_a_of_type_Alhn;
  
  static alhk a()
  {
    if (jdField_a_of_type_Alhk == null) {
      jdField_a_of_type_Alhk = new alhk();
    }
    return jdField_a_of_type_Alhk;
  }
  
  static SharedPreferences a()
  {
    return BaseApplication.getContext().getSharedPreferences("config_qq.android.tmg_opensdk", 4);
  }
  
  public static String a()
  {
    Object localObject = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TMG_Downloader", 2, "getFilesDir is null");
      }
      localObject = "";
    }
    String str;
    File localFile;
    do
    {
      return localObject;
      str = ((File)localObject).getParent() + "/txlib/tmg/";
      localFile = new File(str);
      localObject = str;
    } while (localFile.exists());
    localFile.mkdirs();
    return str;
  }
  
  public static String a(alhj paramalhj)
  {
    return a() + "tmg_sdk_" + paramalhj.a + "_" + paramalhj.b + ".zip";
  }
  
  public static void a()
  {
    ArrayList localArrayList = bdhb.a(a());
    if (localArrayList != null)
    {
      int i = 0;
      while (i < localArrayList.size())
      {
        QLog.e("TMG_Downloader", 1, String.format("ListSoDirs file i=" + i + ", name=" + (String)localArrayList.get(i), new Object[0]));
        i += 1;
      }
    }
  }
  
  static void a(String paramString)
  {
    SharedPreferences.Editor localEditor = a().edit();
    localEditor.putString("tmg_opensdk_download_md5", paramString);
    localEditor.commit();
  }
  
  static String b()
  {
    return a().getString("tmg_opensdk_download_md5", null);
  }
  
  public static boolean b(alhj paramalhj)
  {
    String str1 = paramalhj.b;
    paramalhj = a(paramalhj);
    String str2 = b();
    if ((TextUtils.isEmpty(str2)) || (!str2.equals(str1))) {
      if (QLog.isDevelopLevel()) {
        QLog.d("TMG_Downloader", 4, String.format("isSoReady, sp_md5[%s], xmlMd5[%s]", new Object[] { str2, str1 }));
      }
    }
    do
    {
      return false;
      if (bdhb.a(paramalhj)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("TMG_Downloader", 4, String.format("isSoReady, file no exist,  fileName[%s]", new Object[] { paramalhj }));
    return false;
    a();
    return true;
  }
  
  boolean a(alhj paramalhj)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      if (((QQAppInterface)localAppRuntime).getManager(21) == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("TMG_Downloader", 4, "innerDownload, getNetEngine 为空");
        }
        return false;
      }
    }
    else if (QLog.isDevelopLevel()) {
      QLog.d("TMG_Downloader", 4, "appRuntime 不是 QQAppInterface");
    }
    this.jdField_a_of_type_Alhj = paramalhj;
    return this.jdField_a_of_type_Alhl.a(paramalhj, this.jdField_a_of_type_Alhn);
  }
  
  boolean a(alhj paramalhj, alhn paramalhn)
  {
    this.jdField_a_of_type_Alhn = paramalhn;
    return a(paramalhj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alhk
 * JD-Core Version:    0.7.0.1
 */