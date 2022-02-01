import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class algh
{
  private static algh a;
  
  public static algh a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new algh();
      }
      return a;
    }
    finally {}
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, "new_folder_weather_expose");
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      algs.a(1, "");
      a(paramQQAppInterface, "new_folder_weather_arrive");
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface, paramString, null);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, Object paramObject)
  {
    String str2 = "";
    String str1 = str2;
    if (paramObject != null)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(String.valueOf(paramObject))) {
        str1 = "|" + paramObject;
      }
    }
    paramString = System.currentTimeMillis() + "|" + "QQWeather" + "|" + "QQWeather_native" + "|" + paramString + "|" + "android" + str1;
    bcdf.a(paramQQAppInterface, "dc04698", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("WeatherDCReportHelper", 2, "reportWeather : " + paramString);
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, "new_folder_weather_click");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     algh
 * JD-Core Version:    0.7.0.1
 */