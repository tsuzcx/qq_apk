import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.jsp.TroopApiPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class adwy
  implements TroopMemberApiClient.Callback
{
  public adwy(TroopApiPlugin paramTroopApiPlugin) {}
  
  public void a(Bundle paramBundle)
  {
    int i = paramBundle.getInt("state", 0);
    int j = paramBundle.getInt("percentage", 0);
    long l = paramBundle.getLong("errCode", 0L);
    try
    {
      paramBundle = new JSONObject();
      paramBundle.put("state", i);
      paramBundle.put("percentage", j);
      paramBundle.put("errCode", l);
      this.a.callJs(this.a.e, new String[] { paramBundle.toString() });
      return;
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopApiPlugin", 2, "huanjiDownload exp", paramBundle);
      }
      this.a.callJs(this.a.e, new String[] { "{\"errCode\":-10,\"message\":\"request fail\"}" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adwy
 * JD-Core Version:    0.7.0.1
 */