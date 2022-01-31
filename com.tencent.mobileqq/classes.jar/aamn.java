import com.tencent.gdtad.jsbridge.GdtBannerFragmentForJS;
import org.json.JSONException;
import org.json.JSONObject;

public class aamn
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
    try
    {
      GdtBannerFragmentForJS.a(paramString, new JSONObject(paramVarArgs[0]), GdtBannerFragmentForJS.class);
      return true;
    }
    catch (JSONException paramaamm)
    {
      aanp.d("GdtBannerJsCallHandler", "handleJsCallRequest error", paramaamm);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamn
 * JD-Core Version:    0.7.0.1
 */