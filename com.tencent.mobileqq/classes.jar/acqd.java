import android.text.TextUtils;
import com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import org.json.JSONException;
import org.json.JSONObject;

final class acqd
  implements acqj
{
  public boolean a(acpp paramacpp, String paramString, String... paramVarArgs)
  {
    if (paramacpp != null) {}
    for (paramString = paramacpp.a(); (paramacpp == null) || (paramString == null); paramString = null)
    {
      acqy.d("GdtBannerJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    for (;;)
    {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        paramacpp = paramVarArgs.optString("process", "com.tencent.mobileqq:mini");
        if (TextUtils.equals(paramacpp, "com.tencent.mobileqq"))
        {
          paramacpp = PublicFragmentActivity.class;
          GdtInterstitialFragmentForJS.a(paramString, paramacpp, paramVarArgs);
          return true;
        }
      }
      catch (JSONException paramacpp)
      {
        acqy.d("GdtBannerJsCallHandler", "handleJsCallRequest error", paramacpp);
        return true;
      }
      if (TextUtils.equals(paramacpp, "com.tencent.mobileqq:tool")) {
        paramacpp = PublicFragmentActivityForTool.class;
      } else {
        paramacpp = PublicFragmentActivityForMini.class;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqd
 * JD-Core Version:    0.7.0.1
 */