import android.text.TextUtils;
import com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import org.json.JSONException;
import org.json.JSONObject;

final class aaro
  implements aaru
{
  public boolean a(aarb paramaarb, String paramString, String... paramVarArgs)
  {
    if (paramaarb != null) {}
    for (paramString = paramaarb.a(); (paramaarb == null) || (paramString == null); paramString = null)
    {
      aase.d("GdtBannerJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    for (;;)
    {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        paramaarb = paramVarArgs.optString("process", "com.tencent.mobileqq:mini");
        if (TextUtils.equals(paramaarb, "com.tencent.mobileqq"))
        {
          paramaarb = PublicFragmentActivity.class;
          GdtInterstitialFragmentForJS.a(paramString, paramaarb, paramVarArgs);
          return true;
        }
      }
      catch (JSONException paramaarb)
      {
        aase.d("GdtBannerJsCallHandler", "handleJsCallRequest error", paramaarb);
        return true;
      }
      if (TextUtils.equals(paramaarb, "com.tencent.mobileqq:tool")) {
        paramaarb = PublicFragmentActivityForTool.class;
      } else {
        paramaarb = PublicFragmentActivityForMini.class;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaro
 * JD-Core Version:    0.7.0.1
 */