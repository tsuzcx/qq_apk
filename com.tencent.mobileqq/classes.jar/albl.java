import android.os.Handler;
import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.utils.ArkPubicEventWrap.QWalletArkNotify.1;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import org.json.JSONObject;

public class albl
  extends apsw
  implements apsy
{
  public albl(albi paramalbi) {}
  
  public boolean notify(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ArkPubicEventWrap", 2, String.format(Locale.getDefault(), "appName:%1$s;eventName:%2$s;params:%3$s;", new Object[] { paramString1, paramString2, paramString3 }));
    }
    if ("ad_query_mute".equals(paramString2)) {
      albi.a(this.a, paramString1);
    }
    do
    {
      do
      {
        return true;
        if (!"event_query_package".equals(paramString2)) {
          break;
        }
      } while (TextUtils.isEmpty(paramString3));
      for (;;)
      {
        try
        {
          paramString2 = new JSONObject(paramString3).optString("packageName");
          paramString2 = bhfn.a(BaseApplicationImpl.getContext(), paramString2);
          paramString3 = new JSONObject();
          if ("0".equals(paramString2))
          {
            paramString3.put("errCode", 0);
            paramString3.put("isInstall", false);
            ark.arkNotify(paramString1, "event_query_package_callback", paramString3.toString(), "json");
            return true;
          }
        }
        catch (Throwable paramString2)
        {
          paramString2.printStackTrace();
          ark.arkNotify(paramString1, "event_query_package_callback", "", "json");
          return true;
        }
        paramString3.put("errCode", 0);
        paramString3.put("isInstall", true);
        paramString3.put("version", paramString2);
      }
      if (!"event_fullscreen_play".equals(paramString2)) {
        break;
      }
    } while (TextUtils.isEmpty(paramString3));
    try
    {
      paramString1 = new JSONObject(paramString3);
      paramString1.optString("videoUrl");
      paramString1.optString("playRate");
      paramString1.optString("totalRate");
      return true;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
      return true;
    }
    if ("beacon_report".equals(paramString2)) {
      try
      {
        paramString1 = new JSONObject(paramString3);
        alcd.a("000004B5DU3Q3LD1", paramString1.optString("event_name"), paramString1.optJSONObject("params"));
        return true;
      }
      catch (Throwable paramString1)
      {
        QLog.e("ArkPubicEventWrap", 1, paramString1, new Object[0]);
        return true;
      }
    }
    if ("get_view_location".equals(paramString2))
    {
      ThreadManagerV2.getUIHandlerV2().post(new ArkPubicEventWrap.QWalletArkNotify.1(this, paramString1, paramString3));
      return true;
    }
    albi.a(this.a);
    this.a.notifyObservers(new albk(this.a, paramString1, paramString2, paramString3));
    return super.notify(paramString1, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     albl
 * JD-Core Version:    0.7.0.1
 */