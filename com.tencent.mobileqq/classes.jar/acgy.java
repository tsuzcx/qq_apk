import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ad.tangram.util.AdAppDeeplinkLauncher;
import com.tencent.ad.tangram.util.AdAppDeeplinkLauncher.Params;
import com.tencent.ad.tangram.util.AdAppDeeplinkLauncher.Result;
import com.tencent.ad.tangram.util.AdAppUtil;
import org.json.JSONException;
import org.json.JSONObject;

class acgy
  implements acgx
{
  public boolean a(acfw paramacfw, String paramString, String... paramVarArgs)
  {
    if (paramacfw != null) {}
    for (localActivity = paramacfw.a(); (paramacfw == null) || (localActivity == null); localActivity = null)
    {
      acho.d("GdtXiJingLaunchAppWithDeeplinkJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    try
    {
      paramVarArgs = new JSONObject(paramVarArgs[0]);
      acho.b("GdtXiJingLaunchAppWithDeeplinkJsCallHandler", paramVarArgs.toString());
      str1 = paramVarArgs.getString("deeplink");
      str2 = paramVarArgs.optString("packageName");
      if ((TextUtils.isEmpty(str2)) || (AdAppUtil.isInstalled(localActivity, str2))) {
        break label160;
      }
      i = 12;
    }
    catch (Throwable localJSONException)
    {
      try
      {
        paramVarArgs.put("error", i);
      }
      catch (JSONException localJSONException)
      {
        try
        {
          for (;;)
          {
            String str1;
            String str2;
            paramacfw.callJs(paramString, new String[] { paramVarArgs.toString() });
            if (paramacfw == null) {
              break;
            }
            paramacfw = paramacfw.a();
            AdReporterForAnalysis.reportForJSBridgeInvoked(localActivity, false, "launchAppWithDeeplink", paramacfw);
            return true;
            paramVarArgs = paramVarArgs;
            acho.d("GdtXiJingLaunchAppWithDeeplinkJsCallHandler", "handleJsCallRequest", paramVarArgs);
            int i = 4;
            continue;
            Bundle localBundle = new Bundle();
            localBundle.putString("big_brother_source_key", "biz_src_ads");
            if (localActivity.getIntent() != null) {
              if (!TextUtils.isEmpty(localActivity.getIntent().getStringExtra("big_brother_ref_source_key"))) {
                break label267;
              }
            }
            for (paramVarArgs = localActivity.getIntent().getStringExtra("big_brother_source_key");; paramVarArgs = localActivity.getIntent().getStringExtra("big_brother_ref_source_key"))
            {
              localBundle.putString("big_brother_ref_source_key", paramVarArgs);
              paramVarArgs = new AdAppDeeplinkLauncher.Params();
              paramVarArgs.deeplink = str1;
              paramVarArgs.packageName = str2;
              paramVarArgs.extrasForIntent = localBundle;
              paramVarArgs = AdAppDeeplinkLauncher.launch(localActivity, paramVarArgs);
              if (paramVarArgs == null) {
                break label281;
              }
              i = paramVarArgs.getErrorCode();
              break;
            }
            i = 1;
            continue;
            localJSONException = localJSONException;
            acho.d("GdtXiJingLaunchAppWithDeeplinkJsCallHandler", "handleJsCallRequest error", localJSONException);
          }
        }
        catch (Throwable paramString)
        {
          for (;;)
          {
            acho.d("GdtXiJingLaunchAppWithDeeplinkJsCallHandler", "handleJsCallRequest error", paramString);
            continue;
            paramacfw = null;
          }
        }
      }
    }
    paramVarArgs = new JSONObject();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acgy
 * JD-Core Version:    0.7.0.1
 */