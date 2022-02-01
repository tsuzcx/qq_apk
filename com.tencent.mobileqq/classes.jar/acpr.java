import com.tencent.gdtad.jsbridge.GdtBannerFragmentForJS;
import org.json.JSONException;
import org.json.JSONObject;

public class acpr
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
    try
    {
      GdtBannerFragmentForJS.a(paramString, new JSONObject(paramVarArgs[0]), GdtBannerFragmentForJS.class);
      return true;
    }
    catch (JSONException paramacpp)
    {
      acqy.d("GdtBannerJsCallHandler", "handleJsCallRequest error", paramacpp);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpr
 * JD-Core Version:    0.7.0.1
 */