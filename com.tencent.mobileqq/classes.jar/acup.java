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

class acup
  implements acun
{
  private acoi jdField_a_of_type_Acoi = new acuq(this);
  private WeakReference<acts> jdField_a_of_type_JavaLangRefWeakReference;
  private Map<acoh, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public boolean a(acts paramacts, String paramString, String... paramVarArgs)
  {
    if (paramacts != null) {}
    for (Activity localActivity = paramacts.a(); (paramacts == null) || (localActivity == null); localActivity = null)
    {
      acvc.d("GdtLoadAdJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    try
    {
      Object localObject = new JSONObject(paramVarArgs[0]);
      acvc.b("GdtLoadAdJsCallHandler", ((JSONObject)localObject).toString());
      paramVarArgs = new acoj();
      paramVarArgs.a = ((qq_ad_get.QQAdGet)qq_ad_get.QQAdGet.class.cast(acvb.a(new qq_ad_get.QQAdGet(), localObject)));
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramacts);
      localObject = new acoh(paramVarArgs, new WeakReference(this.jdField_a_of_type_Acoi));
      this.jdField_a_of_type_JavaUtilMap.put(localObject, paramString);
      ((acoh)localObject).a(new WeakReference(localActivity));
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
      if (paramacts == null) {}
    }
    catch (JSONException paramacts)
    {
      acvc.d("GdtLoadAdJsCallHandler", "handleJsCallRequest error", paramacts);
      return true;
    }
    for (paramacts = paramacts.a();; paramacts = null)
    {
      AdReporterForAnalysis.reportForJSBridgeInvoked(localActivity, false, "loadAd", paramacts);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acup
 * JD-Core Version:    0.7.0.1
 */