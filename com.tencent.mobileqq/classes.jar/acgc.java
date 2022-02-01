import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtAd;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class acgc
  implements acgx
{
  public boolean a(acfw paramacfw, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    try
    {
      paramString = new JSONObject(paramVarArgs[0]);
      acho.a("GdtC2SJsCallHandler", paramString.toString());
      int i = paramString.optInt("operationType");
      int j = paramString.optInt("businessType");
      qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(achn.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramString.getJSONObject("adInfo")));
      achv.a(i, j, localAdInfo);
      if (paramacfw != null) {}
      for (paramString = paramacfw.a();; paramString = null)
      {
        paramVarArgs = localObject;
        if (paramacfw != null) {
          paramVarArgs = paramacfw.a();
        }
        AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, false, "c2sReport", paramVarArgs, new GdtAd(localAdInfo));
        return true;
      }
      return true;
    }
    catch (Exception paramacfw)
    {
      acho.d("GdtC2SJsCallHandler", "handleJsCallRequest", paramacfw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acgc
 * JD-Core Version:    0.7.0.1
 */