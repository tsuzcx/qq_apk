import android.text.TextUtils;
import com.tencent.gdtad.jsbridge.GdtDeviceDemoFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import org.json.JSONException;
import org.json.JSONObject;

final class acgk
  implements acgx
{
  public boolean a(acfw paramacfw, String paramString, String... paramVarArgs)
  {
    if (paramacfw != null) {}
    for (paramString = paramacfw.a(); (paramacfw == null) || (paramString == null); paramString = null)
    {
      acho.d("GdtDeviceDemoJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    for (;;)
    {
      try
      {
        paramacfw = new JSONObject(paramVarArgs[0]).optString("process", "com.tencent.mobileqq:mini");
        if (TextUtils.equals(paramacfw, "com.tencent.mobileqq"))
        {
          paramacfw = PublicFragmentActivity.class;
          GdtDeviceDemoFragment.a(paramString, paramacfw);
          return true;
        }
      }
      catch (JSONException paramacfw)
      {
        acho.d("GdtDeviceDemoJsCallHandler", "handleJsCallRequest error", paramacfw);
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
 * Qualified Name:     acgk
 * JD-Core Version:    0.7.0.1
 */