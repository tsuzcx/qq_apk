import com.tencent.gdtad.jsbridge.GdtBannerFragmentForJS;
import org.json.JSONException;
import org.json.JSONObject;

public class abqe
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
    try
    {
      GdtBannerFragmentForJS.a(paramString, new JSONObject(paramVarArgs[0]), GdtBannerFragmentForJS.class);
      return true;
    }
    catch (JSONException paramabqc)
    {
      abrl.d("GdtBannerJsCallHandler", "handleJsCallRequest error", paramabqc);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abqe
 * JD-Core Version:    0.7.0.1
 */