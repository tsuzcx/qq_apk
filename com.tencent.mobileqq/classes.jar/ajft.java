import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.troop.browser.TroopWebviewPlugin;
import org.json.JSONException;
import org.json.JSONObject;

public class ajft
  implements TroopMemberApiClient.Callback
{
  public ajft(TroopWebviewPlugin paramTroopWebviewPlugin, String paramString) {}
  
  public void a(Bundle paramBundle)
  {
    long l = paramBundle.getLong("lastMsgTime");
    paramBundle = paramBundle.getString("lastMsgContent");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("lastMsgTime", l);
      localJSONObject.put("lastMsgContent", paramBundle);
      if (!TextUtils.isEmpty(paramBundle))
      {
        localJSONObject.put("ret", 0);
        localJSONObject.put("errorMsg", "");
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopBrowserTroopWebviewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
        return;
        localJSONObject.put("ret", -1);
        localJSONObject.put("errorMsg", "lastSpeakMsg is empty");
      }
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajft
 * JD-Core Version:    0.7.0.1
 */