import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtAd;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class acva
  implements acun
{
  public boolean a(acts paramacts, String paramString, String... paramVarArgs)
  {
    try
    {
      paramVarArgs = new JSONObject(paramVarArgs[0]);
      acvc.b("GdtPreLoaderJsCallHandler", paramVarArgs.toString());
      paramVarArgs = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(acvb.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramVarArgs.getJSONObject("adInfo"))));
      acoo.a().a(paramVarArgs);
      paramacts.callJs(paramString, null);
      if (paramacts != null)
      {
        paramString = paramacts.a();
        if (paramacts == null) {
          break label99;
        }
      }
      label99:
      for (paramacts = paramacts.a();; paramacts = null)
      {
        AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, true, "preLoadAfterAdLoaded", paramacts, paramVarArgs);
        return true;
        paramString = null;
        break;
      }
      return true;
    }
    catch (Throwable paramacts)
    {
      paramacts.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acva
 * JD-Core Version:    0.7.0.1
 */