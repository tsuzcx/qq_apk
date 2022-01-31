import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtAd;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class aann
  implements aanf
{
  public boolean a(aamm paramaamm, String paramString, String... paramVarArgs)
  {
    try
    {
      paramVarArgs = new JSONObject(paramVarArgs[0]);
      aanp.b("GdtPreLoaderJsCallHandler", paramVarArgs.toString());
      paramVarArgs = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(aano.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramVarArgs.getJSONObject("adInfo"))));
      aail.a().a(paramVarArgs);
      paramaamm.callJs(paramString, null);
      if (paramaamm != null)
      {
        paramString = paramaamm.a();
        if (paramaamm == null) {
          break label99;
        }
      }
      label99:
      for (paramaamm = paramaamm.a();; paramaamm = null)
      {
        AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, true, "preLoadAfterAdLoaded", paramaamm, paramVarArgs);
        return true;
        paramString = null;
        break;
      }
      return true;
    }
    catch (Throwable paramaamm)
    {
      paramaamm.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aann
 * JD-Core Version:    0.7.0.1
 */