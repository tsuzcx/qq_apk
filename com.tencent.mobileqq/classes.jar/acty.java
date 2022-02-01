import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtAd;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class acty
  implements acun
{
  public boolean a(acts paramacts, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    try
    {
      paramString = new JSONObject(paramVarArgs[0]);
      acvc.a("GdtC2SJsCallHandler", paramString.toString());
      int i = paramString.optInt("operationType");
      int j = paramString.optInt("businessType");
      qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(acvb.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramString.getJSONObject("adInfo")));
      acvi.a(i, j, localAdInfo);
      if (paramacts != null) {}
      for (paramString = paramacts.a();; paramString = null)
      {
        paramVarArgs = localObject;
        if (paramacts != null) {
          paramVarArgs = paramacts.a();
        }
        AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, false, "c2sReport", paramVarArgs, new GdtAd(localAdInfo));
        return true;
      }
      return true;
    }
    catch (Exception paramacts)
    {
      acvc.d("GdtC2SJsCallHandler", "handleJsCallRequest", paramacts);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acty
 * JD-Core Version:    0.7.0.1
 */