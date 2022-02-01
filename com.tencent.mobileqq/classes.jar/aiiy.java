import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aiiy
{
  public JSONObject a = new JSONObject();
  
  public static aiiy a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        aiiy localaiiy = new aiiy();
        localaiiy.a = paramString;
        return localaiiy;
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
 * Qualified Name:     aiiy
 * JD-Core Version:    0.7.0.1
 */