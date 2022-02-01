import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aljz
{
  private int a = -1;
  
  public static aljz a(String paramString)
  {
    aljz localaljz = new aljz();
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BeginnerBannerConfBean", 2, "[parse] config: " + paramString + ", expId: " + localaljz.a);
      }
      return localaljz;
      try
      {
        localaljz.a = new JSONObject(paramString).optInt("expid", -1);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("BeginnerBannerConfBean", 1, "[parse] parse error: ", localThrowable);
      }
    }
  }
  
  public int a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aljz
 * JD-Core Version:    0.7.0.1
 */