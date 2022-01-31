import android.text.TextUtils;
import com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import org.json.JSONException;
import org.json.JSONObject;

final class aamz
  implements aanf
{
  public boolean a(aamm paramaamm, String paramString, String... paramVarArgs)
  {
    if (paramaamm != null) {}
    for (paramString = paramaamm.a(); (paramaamm == null) || (paramString == null); paramString = null)
    {
      aanp.d("GdtBannerJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    for (;;)
    {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        paramaamm = paramVarArgs.optString("process", "com.tencent.mobileqq:mini");
        if (TextUtils.equals(paramaamm, "com.tencent.mobileqq"))
        {
          paramaamm = PublicFragmentActivity.class;
          GdtInterstitialFragmentForJS.a(paramString, paramaamm, paramVarArgs);
          return true;
        }
      }
      catch (JSONException paramaamm)
      {
        aanp.d("GdtBannerJsCallHandler", "handleJsCallRequest error", paramaamm);
        return true;
      }
      if (TextUtils.equals(paramaamm, "com.tencent.mobileqq:tool")) {
        paramaamm = PublicFragmentActivityForTool.class;
      } else {
        paramaamm = PublicFragmentActivityForMini.class;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamz
 * JD-Core Version:    0.7.0.1
 */