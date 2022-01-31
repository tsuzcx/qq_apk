import android.app.Activity;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;

class aang
  implements aanf
{
  private aaif jdField_a_of_type_Aaif = new aanh(this);
  private WeakReference<aamm> jdField_a_of_type_JavaLangRefWeakReference;
  private Map<aaie, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public boolean a(aamm paramaamm, String paramString, String... paramVarArgs)
  {
    if (paramaamm != null) {}
    for (Activity localActivity = paramaamm.a(); (paramaamm == null) || (localActivity == null); localActivity = null)
    {
      aanp.d("GdtLoadAdJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    try
    {
      Object localObject = new JSONObject(paramVarArgs[0]);
      aanp.b("GdtLoadAdJsCallHandler", ((JSONObject)localObject).toString());
      paramVarArgs = new aaig();
      paramVarArgs.a = ((qq_ad_get.QQAdGet)qq_ad_get.QQAdGet.class.cast(aano.a(new qq_ad_get.QQAdGet(), localObject)));
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaamm);
      localObject = new aaie(paramVarArgs, new WeakReference(this.jdField_a_of_type_Aaif));
      this.jdField_a_of_type_JavaUtilMap.put(localObject, paramString);
      ((aaie)localObject).a(new WeakReference(localActivity));
      paramString = new ArrayList();
      if ((paramVarArgs.a != null) && (!paramVarArgs.a.position_info.isEmpty()))
      {
        int i = 0;
        while (i < paramVarArgs.a.position_info.size())
        {
          localObject = ((qq_ad_get.QQAdGet.PositionInfo)paramVarArgs.a.position_info.get(i)).pos_id.get();
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramString.add(localObject);
          }
          i += 1;
        }
      }
      if (paramaamm == null) {}
    }
    catch (JSONException paramaamm)
    {
      aanp.d("GdtLoadAdJsCallHandler", "handleJsCallRequest error", paramaamm);
      return true;
    }
    for (paramaamm = paramaamm.a();; paramaamm = null)
    {
      AdReporterForAnalysis.reportForJSBridgeInvoked(localActivity, false, "loadAd", paramaamm);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aang
 * JD-Core Version:    0.7.0.1
 */