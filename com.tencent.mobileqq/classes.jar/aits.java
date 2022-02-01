import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aits
{
  public JSONObject a = new JSONObject();
  
  public static aits a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        aits localaits = new aits();
        localaits.a = paramString;
        return localaits;
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
 * Qualified Name:     aits
 * JD-Core Version:    0.7.0.1
 */