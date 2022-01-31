import android.net.Uri;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class ahhz
{
  private static InputStream jdField_a_of_type_JavaIoInputStream;
  private static String jdField_a_of_type_JavaLangString;
  
  public static WebResourceResponse a(String paramString)
  {
    paramString = PreloadManager.e(a(paramString));
    if (QLog.isColorLevel()) {
      QLog.d("springHb_SpringHbUrlInterceptor", 2, "getWebResponse resPath: " + paramString);
    }
    if (bbjw.a(paramString)) {
      return null;
    }
    try
    {
      jdField_a_of_type_JavaIoInputStream = new BufferedInputStream(new FileInputStream(paramString));
      paramString = new WebResourceResponse("video/mp4", "UTF-8", jdField_a_of_type_JavaIoInputStream);
      return paramString;
    }
    catch (IOException paramString)
    {
      QLog.e("springHb_SpringHbUrlInterceptor", 1, paramString, new Object[0]);
      a();
    }
    return null;
  }
  
  private static String a(String paramString)
  {
    String str;
    if (bbjw.a(paramString)) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.lastIndexOf("?") == -1);
    return paramString.split("\\?")[0];
  }
  
  private static Map<String, String> a(String paramString)
  {
    int i = 0;
    Object localObject = paramString.substring(paramString.indexOf("?") + 1);
    paramString = new HashMap();
    for (;;)
    {
      try
      {
        localObject = ((String)localObject).split("&");
        int j = localObject.length;
        if (i < j)
        {
          String[] arrayOfString = localObject[i].split("=");
          if ((arrayOfString == null) || (arrayOfString.length != 2)) {
            break label85;
          }
          paramString.put(arrayOfString[0], URLDecoder.decode(arrayOfString[1]));
        }
      }
      catch (Exception localException) {}
      return paramString;
      label85:
      i += 1;
    }
  }
  
  public static void a()
  {
    if (jdField_a_of_type_JavaIoInputStream != null) {}
    try
    {
      jdField_a_of_type_JavaIoInputStream.close();
      jdField_a_of_type_JavaIoInputStream = null;
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public static boolean a(String paramString)
  {
    if (bbjw.a(paramString)) {}
    for (;;)
    {
      return false;
      Object localObject = a(paramString);
      if ((localObject == null) || (((Map)localObject).isEmpty())) {
        continue;
      }
      try
      {
        i = Integer.parseInt((String)((Map)localObject).get("o"));
        localObject = a(paramString);
        if ((i != 1) || ((!((String)localObject).endsWith(".mp4")) && (!((String)localObject).endsWith(".MP4")))) {
          continue;
        }
        label260:
        for (;;)
        {
          try
          {
            paramString = Uri.parse(paramString).getHost();
            if (QLog.isColorLevel()) {
              QLog.d("springHb_SpringHbUrlInterceptor", 2, "do intercept url's domain: " + paramString);
            }
            if (bbjw.a(jdField_a_of_type_JavaLangString))
            {
              localObject = QIPCClientHelper.getInstance().getClient().callServer("SpringHbIPCModule", "GetDomain", new Bundle());
              if ((localObject == null) || (((EIPCResult)localObject).data == null)) {
                jdField_a_of_type_JavaLangString = "down.qq.com";
              }
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("springHb_SpringHbUrlInterceptor", 2, "get domain from IPC: " + jdField_a_of_type_JavaLangString);
              }
              if (bbjw.a(jdField_a_of_type_JavaLangString)) {
                break;
              }
              localObject = jdField_a_of_type_JavaLangString.split("\\|");
              int j = localObject.length;
              i = 0;
              if (i >= j) {
                break;
              }
              if (!localObject[i].equals(paramString)) {
                break label260;
              }
              return true;
            }
            jdField_a_of_type_JavaLangString = ((EIPCResult)localObject).data.getString("res_domain");
            continue;
            i += 1;
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            QLog.e("springHb_SpringHbUrlInterceptor", 2, paramString.getLocalizedMessage());
            return false;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahhz
 * JD-Core Version:    0.7.0.1
 */