import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtAd;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class achm
  implements acgx
{
  public boolean a(acfw paramacfw, String paramString, String... paramVarArgs)
  {
    try
    {
      paramVarArgs = new JSONObject(paramVarArgs[0]);
      acho.b("GdtPreLoaderJsCallHandler", paramVarArgs.toString());
      paramVarArgs = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(achn.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramVarArgs.getJSONObject("adInfo"))));
      acam.a().a(paramVarArgs);
      paramacfw.callJs(paramString, null);
      if (paramacfw != null)
      {
        paramString = paramacfw.a();
        if (paramacfw == null) {
          break label99;
        }
      }
      label99:
      for (paramacfw = paramacfw.a();; paramacfw = null)
      {
        AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, true, "preLoadAfterAdLoaded", paramacfw, paramVarArgs);
        return true;
        paramString = null;
        break;
      }
      return true;
    }
    catch (Throwable paramacfw)
    {
      paramacfw.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     achm
 * JD-Core Version:    0.7.0.1
 */