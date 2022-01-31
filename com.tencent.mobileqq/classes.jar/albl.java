import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class albl
  implements albk
{
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    JSONObject localJSONObject = null;
    try
    {
      paramString3 = new JSONObject(paramString3).optString("gc");
      if (TextUtils.isEmpty(paramString3)) {
        return false;
      }
    }
    catch (Exception paramString3)
    {
      for (;;)
      {
        QLog.e("ark.ArkAppNotifyCenter", 1, "notify json error!", paramString3);
        paramString3 = localJSONObject;
      }
      if (paramString2.equals("GetIsTroopOwner")) {
        try
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("isOwner", azlj.a(ArkAppNotifyCenter.getAppInterface(), paramString3, ArkAppNotifyCenter.getAppInterface().c()));
          ark.arkNotify(paramString1, paramString2, localJSONObject.toString(), "json");
          return true;
        }
        catch (Throwable paramString1)
        {
          for (;;)
          {
            QLog.e("ark.ArkAppNotifyCenter", 1, "ark.notify error!", paramString1);
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     albl
 * JD-Core Version:    0.7.0.1
 */