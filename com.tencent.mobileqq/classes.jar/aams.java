import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtAd;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class aams
  implements aanf
{
  public boolean a(aamm paramaamm, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    try
    {
      paramString = new JSONObject(paramVarArgs[0]);
      aanp.a("GdtC2SJsCallHandler", paramString.toString());
      int i = paramString.optInt("operationType");
      int j = paramString.optInt("businessType");
      qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(aano.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramString.getJSONObject("adInfo")));
      aanv.a(i, j, localAdInfo);
      if (paramaamm != null) {}
      for (paramString = paramaamm.a();; paramString = null)
      {
        paramVarArgs = localObject;
        if (paramaamm != null) {
          paramVarArgs = paramaamm.a();
        }
        AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, false, "c2sReport", paramVarArgs, new GdtAd(localAdInfo));
        return true;
      }
      return true;
    }
    catch (Exception paramaamm)
    {
      aanp.d("GdtC2SJsCallHandler", "handleJsCallRequest", paramaamm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aams
 * JD-Core Version:    0.7.0.1
 */