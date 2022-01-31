import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public final class aeya
{
  public HashMap<String, String> a = new HashMap();
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ECommerceDataReportConfigProcessor", 2, "configText : " + paramString);
      }
      try
      {
        paramString = new JSONObject(paramString);
        Iterator localIterator = paramString.keys();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          if (!TextUtils.isEmpty(str1))
          {
            String str2 = paramString.optString(str1, "");
            if (!TextUtils.isEmpty(str2)) {
              this.a.put(str1, str2);
            }
          }
        }
        return;
      }
      catch (Throwable paramString)
      {
        QLog.e("ECommerceDataReportConfigProcessor", 1, paramString, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeya
 * JD-Core Version:    0.7.0.1
 */