import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class akgt
{
  private static akgt a;
  
  public static akgt a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new akgt();
      }
      return a;
    }
    finally {}
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return "folder_weather_arrive";
    case 1: 
      return "folder_weather_expose";
    case 2: 
      return "folder_weather_click";
    case 3: 
      return "aio_news_click";
    case 4: 
      return "aio_othercity_click";
    case 5: 
      return "aio_page_arrive";
    }
    return "aio_search_push";
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    String str = System.currentTimeMillis() + "|" + "QQWeather" + "|" + "QQWeather_native" + "|" + a(paramInt) + "|" + "android";
    azps.a(paramQQAppInterface, "dc04698", str);
    if (QLog.isColorLevel()) {
      QLog.d("WeatherDCReportHelper", 2, "reportWeather : " + str);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForArkApp)) {
      a().a(paramQQAppInterface, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akgt
 * JD-Core Version:    0.7.0.1
 */