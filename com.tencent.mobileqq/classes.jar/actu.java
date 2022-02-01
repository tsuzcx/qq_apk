import com.tencent.gdtad.jsbridge.GdtBannerFragmentForJS;
import org.json.JSONException;
import org.json.JSONObject;

public class actu
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
    try
    {
      GdtBannerFragmentForJS.a(paramString, new JSONObject(paramVarArgs[0]), GdtBannerFragmentForJS.class);
      return true;
    }
    catch (JSONException paramacts)
    {
      acvc.d("GdtBannerJsCallHandler", "handleJsCallRequest error", paramacts);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     actu
 * JD-Core Version:    0.7.0.1
 */