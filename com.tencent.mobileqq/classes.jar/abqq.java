import android.text.TextUtils;
import com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import org.json.JSONException;
import org.json.JSONObject;

final class abqq
  implements abqx
{
  public boolean a(abqc paramabqc, String paramString, String... paramVarArgs)
  {
    if (paramabqc != null) {}
    for (paramString = paramabqc.a(); (paramabqc == null) || (paramString == null); paramString = null)
    {
      abrl.d("GdtBannerJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    for (;;)
    {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        paramabqc = paramVarArgs.optString("process", "com.tencent.mobileqq:mini");
        if (TextUtils.equals(paramabqc, "com.tencent.mobileqq"))
        {
          paramabqc = PublicFragmentActivity.class;
          GdtInterstitialFragmentForJS.a(paramString, paramabqc, paramVarArgs);
          return true;
        }
      }
      catch (JSONException paramabqc)
      {
        abrl.d("GdtBannerJsCallHandler", "handleJsCallRequest error", paramabqc);
        return true;
      }
      if (TextUtils.equals(paramabqc, "com.tencent.mobileqq:tool")) {
        paramabqc = PublicFragmentActivityForTool.class;
      } else {
        paramabqc = PublicFragmentActivityForMini.class;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abqq
 * JD-Core Version:    0.7.0.1
 */