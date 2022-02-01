import android.text.TextUtils;
import com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import org.json.JSONException;
import org.json.JSONObject;

final class acug
  implements acun
{
  public boolean a(acts paramacts, String paramString, String... paramVarArgs)
  {
    if (paramacts != null) {}
    for (paramString = paramacts.a(); (paramacts == null) || (paramString == null); paramString = null)
    {
      acvc.d("GdtBannerJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    for (;;)
    {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        paramacts = paramVarArgs.optString("process", "com.tencent.mobileqq:mini");
        if (TextUtils.equals(paramacts, "com.tencent.mobileqq"))
        {
          paramacts = PublicFragmentActivity.class;
          GdtInterstitialFragmentForJS.a(paramString, paramacts, paramVarArgs);
          return true;
        }
      }
      catch (JSONException paramacts)
      {
        acvc.d("GdtBannerJsCallHandler", "handleJsCallRequest error", paramacts);
        return true;
      }
      if (TextUtils.equals(paramacts, "com.tencent.mobileqq:tool")) {
        paramacts = PublicFragmentActivityForTool.class;
      } else {
        paramacts = PublicFragmentActivityForMini.class;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acug
 * JD-Core Version:    0.7.0.1
 */