import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class aams
{
  private static aams jdField_a_of_type_Aams;
  public static String a;
  private Map<String, aamu> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  private aams()
  {
    a(BaseApplicationImpl.getContext());
  }
  
  public static aams a()
  {
    try
    {
      if (jdField_a_of_type_Aams == null) {
        jdField_a_of_type_Aams = new aams();
      }
      aams localaams = jdField_a_of_type_Aams;
      return localaams;
    }
    finally {}
  }
  
  private String a(Context paramContext)
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      paramContext = paramContext.getExternalFilesDir("video_story");
      if (paramContext != null) {
        jdField_a_of_type_JavaLangString = paramContext.getAbsolutePath();
      }
    }
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      paramContext = Environment.getExternalStorageDirectory().getAbsolutePath();
      jdField_a_of_type_JavaLangString = paramContext + "/Tencent/MobileQQ/" + "video_story";
    }
    QZLog.i("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "intDownLoadRoot" + jdField_a_of_type_JavaLangString);
    return null;
  }
  
  public String a(String paramString)
  {
    try
    {
      paramString = paramString.split("/");
      paramString = paramString[(paramString.length - 1)];
      paramString = paramString.substring(0, paramString.indexOf(".zip"));
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public void a(aamd paramaamd)
  {
    if (paramaamd != null) {
      a(paramaamd.a(), null);
    }
  }
  
  public void a(aamf paramaamf)
  {
    if (paramaamf != null) {
      a(paramaamf.a(), null);
    }
  }
  
  public void a(String paramString, Downloader.DownloadListener paramDownloadListener)
  {
    QZLog.i("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "downLoadByUrl:" + paramString);
    if (TextUtils.isEmpty(paramString)) {
      QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, new Object[] { "downLoadByUrl:url is empty" });
    }
    String str1;
    String str2;
    aamu localaamu;
    bhyt localbhyt;
    bhyo localbhyo;
    Bundle localBundle;
    do
    {
      do
      {
        do
        {
          return;
          str1 = a(paramString);
          if (TextUtils.isEmpty(str1))
          {
            QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, new Object[] { "downLoadByUrl:prefixId is empty" });
            return;
          }
          QZLog.d("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "downLoadByUrl:prefixId:" + str1);
          if (b(str1))
          {
            QZLog.d("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "downLoadByUrl:resource has download");
            return;
          }
          if (c(str1))
          {
            QZLog.d("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "downLoadByUrl:resource on download");
            return;
          }
          if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
          {
            QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, new Object[] { "downLoadByUrl:mDownLoadRoot is empty" });
            return;
          }
          str2 = jdField_a_of_type_JavaLangString + "/" + str1 + ".zip";
        } while (TextUtils.isEmpty(paramString));
        localaamu = new aamu(this, null);
        this.jdField_a_of_type_JavaUtilMap.put(str1, localaamu);
        localbhyt = ((bhyq)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
      } while (localbhyt == null);
      localbhyo = new bhyo(paramString, new File(str2));
      localbhyo.b = 1;
      localBundle = new Bundle();
    } while (localbhyt == null);
    localbhyt.a(localbhyo, new aamt(this, paramDownloadListener, str2, localaamu, str1, paramString), localBundle);
  }
  
  public boolean a(String paramString)
  {
    paramString = a(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      return b(paramString);
    }
    return false;
  }
  
  public String b(String paramString)
  {
    return jdField_a_of_type_JavaLangString + "/" + a(paramString);
  }
  
  public boolean b(String paramString)
  {
    Object localObject = jdField_a_of_type_JavaLangString + "/" + paramString;
    if (new File((String)localObject + ".zip").exists())
    {
      QZLog.d("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "upZip failed:" + paramString);
      return false;
    }
    boolean bool2;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      bool2 = new File((String)localObject).exists();
      bool1 = bool2;
      if (bool2)
      {
        localObject = new aamu(this, null);
        aamu.a((aamu)localObject, 0);
        this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
      }
    }
    for (boolean bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public boolean c(String paramString)
  {
    paramString = (aamu)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return (aamu.a(paramString) == -1) || (aamu.a(paramString) == 1);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aams
 * JD-Core Version:    0.7.0.1
 */