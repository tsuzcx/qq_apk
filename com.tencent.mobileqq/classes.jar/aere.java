import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.15.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class aere
  extends BroadcastReceiver
{
  public aere(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    String str1 = paramIntent.getStringExtra("event");
    if ((TroopInfo.isHomeworkTroop(this.a.app, this.a.a)) && ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramContext)) && ("onHomeworkTroopIdentityChanged".equals(str1)))
    {
      paramContext = paramIntent.getStringExtra("data");
      if (!TextUtils.isEmpty(paramContext)) {
        break label67;
      }
    }
    for (;;)
    {
      return;
      try
      {
        label67:
        paramContext = new JSONObject(paramContext);
        paramIntent = paramContext.optString("groupCode");
        if (TextUtils.equals(this.a.a, paramIntent))
        {
          paramContext.optString("content");
          paramIntent = paramContext.optString("source");
          int i = paramContext.optInt("rankId", 333);
          str1 = paramContext.optString("nickName");
          String str2 = paramContext.optString("uin");
          String str3 = paramContext.optString("course");
          paramContext = paramContext.optString("name");
          if ("qqProfile".equals(paramIntent))
          {
            ThreadManager.post(new FriendProfileMoreInfoActivity.15.1(this, str2, str1, i, str3, paramContext), 8, null, false);
            return;
          }
        }
      }
      catch (JSONException paramContext) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aere
 * JD-Core Version:    0.7.0.1
 */