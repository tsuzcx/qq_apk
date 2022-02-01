import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import org.json.JSONException;
import org.json.JSONObject;

public class aalc
  extends BroadcastReceiver
{
  private aalc(SubscribeHybirdFragment paramSubscribeHybirdFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 0;
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (!TextUtils.equals(paramContext, "action_update_follow_state")) {
        break label89;
      }
    }
    label89:
    while (!TextUtils.equals(paramContext, "action_get_lbs_location")) {
      try
      {
        paramContext = new JSONObject();
        paramContext.put("uin", paramIntent.getStringExtra("uin"));
        paramContext.put("followState", paramIntent.getIntExtra("followState", 0));
        if (this.a.getWebView() != null) {
          this.a.getWebView().callJs(WebViewPlugin.toJsScript("updateFollowState", paramContext, null));
        }
        return;
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
    }
    for (;;)
    {
      try
      {
        paramContext = paramIntent.getStringArrayExtra("code");
        String[] arrayOfString = paramIntent.getStringArrayExtra("location");
        paramIntent = new JSONObject();
        JSONObject localJSONObject = new JSONObject();
        if ((paramContext != null) && (arrayOfString != null) && (paramContext.length == 4) && (arrayOfString.length == 4))
        {
          if (i < 4)
          {
            if ("0".equals(paramContext[i]))
            {
              paramContext[i] = "";
              arrayOfString[i] = "";
            }
          }
          else
          {
            paramIntent.put("country", paramContext[0]);
            paramIntent.put("province", paramContext[1]);
            paramIntent.put("city", paramContext[2]);
            paramIntent.put("area", paramContext[3]);
            localJSONObject.put("country", arrayOfString[0]);
            localJSONObject.put("province", arrayOfString[1]);
            localJSONObject.put("city", arrayOfString[2]);
            localJSONObject.put("area", arrayOfString[3]);
          }
        }
        else
        {
          paramContext = new JSONObject();
          paramContext.put("code", paramIntent);
          paramContext.put("location", localJSONObject);
          if (this.a.getWebView() == null) {
            break;
          }
          this.a.getWebView().callJs(WebViewPlugin.toJsScript("getlbslocationCallback", paramContext, null));
          return;
        }
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalc
 * JD-Core Version:    0.7.0.1
 */