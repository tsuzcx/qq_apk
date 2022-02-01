import android.text.TextUtils;
import com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import org.json.JSONException;
import org.json.JSONObject;

final class acgq
  implements acgx
{
  public boolean a(acfw paramacfw, String paramString, String... paramVarArgs)
  {
    if (paramacfw != null) {}
    for (paramString = paramacfw.a(); (paramacfw == null) || (paramString == null); paramString = null)
    {
      acho.d("GdtBannerJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    for (;;)
    {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        paramacfw = paramVarArgs.optString("process", "com.tencent.mobileqq:mini");
        if (TextUtils.equals(paramacfw, "com.tencent.mobileqq"))
        {
          paramacfw = PublicFragmentActivity.class;
          GdtInterstitialFragmentForJS.a(paramString, paramacfw, paramVarArgs);
          return true;
        }
      }
      catch (JSONException paramacfw)
      {
        acho.d("GdtBannerJsCallHandler", "handleJsCallRequest error", paramacfw);
        return true;
      }
      if (TextUtils.equals(paramacfw, "com.tencent.mobileqq:tool")) {
        paramacfw = PublicFragmentActivityForTool.class;
      } else {
        paramacfw = PublicFragmentActivityForMini.class;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acgq
 * JD-Core Version:    0.7.0.1
 */