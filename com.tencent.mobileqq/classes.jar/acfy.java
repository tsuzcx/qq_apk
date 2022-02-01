import com.tencent.gdtad.jsbridge.GdtBannerFragmentForJS;
import org.json.JSONException;
import org.json.JSONObject;

public class acfy
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
    try
    {
      GdtBannerFragmentForJS.a(paramString, new JSONObject(paramVarArgs[0]), GdtBannerFragmentForJS.class);
      return true;
    }
    catch (JSONException paramacfw)
    {
      acho.d("GdtBannerJsCallHandler", "handleJsCallRequest error", paramacfw);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acfy
 * JD-Core Version:    0.7.0.1
 */