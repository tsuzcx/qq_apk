import android.app.Activity;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class abep
  extends WebViewPlugin
{
  bgot a = null;
  
  public abep()
  {
    this.mPluginNameSpace = "NearbyTroopsPlugin";
  }
  
  protected void a(String paramString)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyTroopsPlugin", 2, "setSelectTypeResult:" + paramString);
        }
        localActivity = this.mRuntime.a();
        localIntent = new Intent();
        try
        {
          paramString = new JSONObject(paramString).getJSONObject("data");
          if (paramString == null) {
            continue;
          }
          localIntent.putExtra("data", paramString.toString());
          localActivity.setResult(-1, localIntent);
          localActivity.finish();
          return;
        }
        catch (Exception paramString)
        {
          if (!QLog.isColorLevel()) {
            break label170;
          }
        }
        QLog.d("NearbyTroopsPlugin", 2, "setSelectTypeResult:" + paramString.toString());
      }
      catch (Exception paramString)
      {
        Activity localActivity;
        Intent localIntent;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("NearbyTroopsPlugin", 2, "setSelectTypeResult:" + paramString.toString());
        return;
      }
      localActivity.setResult(0, localIntent);
      continue;
      label170:
      paramString = null;
    }
  }
  
  protected void b(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyTroopsPlugin", 2, "giftAnimation:" + paramString);
      }
      localActivity = this.mRuntime.a();
      if (localActivity != null)
      {
        if (localActivity.isFinishing()) {
          return;
        }
        localObject = new JSONObject(paramString);
        i = ((JSONObject)localObject).optInt("id");
        long l1 = ((JSONObject)localObject).optLong("senderUin", 0L);
        long l2 = ((JSONObject)localObject).optLong("receiveUin", 0L);
        paramString = ((JSONObject)localObject).optString("brief");
        boolean bool = ((JSONObject)localObject).optBoolean("showClose", false);
        String str1 = ((JSONObject)localObject).optString("senderAvatarURL");
        String str2 = ((JSONObject)localObject).optString("receiverAvatarURL");
        localObject = ((JSONObject)localObject).optString("callback");
        localMessageForDeliverGiftTips = new MessageForDeliverGiftTips();
        localMessageForDeliverGiftTips.animationPackageId = i;
        localMessageForDeliverGiftTips.senderUin = l1;
        localMessageForDeliverGiftTips.receiverUin = l2;
        localMessageForDeliverGiftTips.showCloseBtn = bool;
        localMessageForDeliverGiftTips.animationBrief = paramString;
        localMessageForDeliverGiftTips.senderAvatarUrl = str1;
        localMessageForDeliverGiftTips.receiveAvatarUrl = str2;
        localMessageForDeliverGiftTips.frienduin = String.valueOf(10000L);
        if (this.a == null)
        {
          callJs((String)localObject, new String[] { "{\"result\":10,\"message\":\"troopGiftManager is null\"}" });
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      Activity localActivity;
      Object localObject;
      int i;
      MessageForDeliverGiftTips localMessageForDeliverGiftTips;
      if (QLog.isColorLevel())
      {
        QLog.d("NearbyTroopsPlugin", 2, "setSelectTypeResult:" + paramString.toString());
        return;
        this.a.a(localActivity);
        if (this.a.a(localMessageForDeliverGiftTips))
        {
          this.a.a = new abeq(this, (String)localObject);
          callJs((String)localObject, new String[] { "{\"result\":0,\"id\":" + i + "}" });
          return;
        }
        callJs((String)localObject, new String[] { "{\"result\":2}" });
      }
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("NearbyTroopsPlugin".equals(paramString2))
    {
      if (("setSelectTypeResult".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        a(paramVarArgs[0]);
        return true;
      }
      if (("giftAnimation".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        b(paramVarArgs[0]);
        return true;
      }
    }
    return false;
  }
  
  public void onCreate()
  {
    AppInterface localAppInterface = this.mRuntime.a();
    Activity localActivity = this.mRuntime.a();
    if ((localAppInterface == null) || (localActivity == null)) {
      return;
    }
    this.a = ((bgot)localAppInterface.getManager(223));
  }
  
  public void onDestroy()
  {
    if (this.a != null) {
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abep
 * JD-Core Version:    0.7.0.1
 */