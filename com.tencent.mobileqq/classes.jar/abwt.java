import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class abwt
  extends BroadcastReceiver
{
  public abwt(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
      } while (!"changeGroupTribe".equals(paramIntent.getStringExtra("event")));
      paramContext = paramIntent.getStringExtra("data");
    } while (paramContext == null);
    try
    {
      paramContext = new JSONObject(paramContext);
      this.a.a.tribeId = paramContext.optInt("bid");
      this.a.a.tribeName = paramContext.optString("bname");
      this.a.d = true;
      paramContext = new ArrayList();
      if (!TextUtils.isEmpty(this.a.a.tribeName)) {
        paramContext.add(this.a.a.tribeName);
      }
      this.a.a(9, paramContext, true, 1, true);
      return;
    }
    catch (JSONException paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abwt
 * JD-Core Version:    0.7.0.1
 */