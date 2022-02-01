import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class alzs
{
  private static alzs a;
  
  public static alzs a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new alzs();
      }
      return a;
    }
    finally {}
  }
  
  private boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().a("2658655094", 1008);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0)) {
      return amam.a((ChatMessage)paramQQAppInterface.get(paramQQAppInterface.size() - 1));
    }
    return false;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    int i;
    if ((amaj.a.a()) && (a(paramQQAppInterface)))
    {
      i = 1;
      if (i == 0) {
        break label38;
      }
    }
    label38:
    for (String str = "new_folder_weather_expose";; str = "folder_weather_expose")
    {
      a(paramQQAppInterface, str);
      return;
      i = 0;
      break;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForArkApp)) {
      if (!amam.a(paramMessageRecord)) {
        break label24;
      }
    }
    label24:
    for (paramMessageRecord = "new_folder_weather_arrive";; paramMessageRecord = "folder_weather_arrive")
    {
      a(paramQQAppInterface, paramMessageRecord);
      return;
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
    bcrt.a(paramQQAppInterface, "dc04698", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("WeatherDCReportHelper", 2, "reportWeather : " + paramString);
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    int i;
    if ((amaj.a.a()) && (a(paramQQAppInterface)))
    {
      i = 1;
      if (i == 0) {
        break label38;
      }
    }
    label38:
    for (String str = "new_folder_weather_click";; str = "folder_weather_click")
    {
      a(paramQQAppInterface, str);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alzs
 * JD-Core Version:    0.7.0.1
 */