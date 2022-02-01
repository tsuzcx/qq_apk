import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ahod
{
  public JSONObject a = new JSONObject();
  
  public static ahod a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        ahod localahod = new ahod();
        localahod.a = paramString;
        return localahod;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AdEmoConfigBean", 2, paramString.getMessage());
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahod
 * JD-Core Version:    0.7.0.1
 */