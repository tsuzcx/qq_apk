import com.tencent.gdtad.jsbridge.GdtBannerFragmentForJS;
import org.json.JSONException;
import org.json.JSONObject;

public class aarc
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
    try
    {
      GdtBannerFragmentForJS.a(paramString, new JSONObject(paramVarArgs[0]), GdtBannerFragmentForJS.class);
      return true;
    }
    catch (JSONException paramaarb)
    {
      aase.d("GdtBannerJsCallHandler", "handleJsCallRequest error", paramaarb);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aarc
 * JD-Core Version:    0.7.0.1
 */