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

class aarv
  implements aaru
{
  private aamu jdField_a_of_type_Aamu = new aarw(this);
  private WeakReference<aarb> jdField_a_of_type_JavaLangRefWeakReference;
  private Map<aamt, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public boolean a(aarb paramaarb, String paramString, String... paramVarArgs)
  {
    if (paramaarb != null) {}
    for (Activity localActivity = paramaarb.a(); (paramaarb == null) || (localActivity == null); localActivity = null)
    {
      aase.d("GdtLoadAdJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    try
    {
      Object localObject = new JSONObject(paramVarArgs[0]);
      aase.b("GdtLoadAdJsCallHandler", ((JSONObject)localObject).toString());
      paramVarArgs = new aamv();
      paramVarArgs.a = ((qq_ad_get.QQAdGet)qq_ad_get.QQAdGet.class.cast(aasd.a(new qq_ad_get.QQAdGet(), localObject)));
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaarb);
      localObject = new aamt(paramVarArgs, new WeakReference(this.jdField_a_of_type_Aamu));
      this.jdField_a_of_type_JavaUtilMap.put(localObject, paramString);
      ((aamt)localObject).a(new WeakReference(localActivity));
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
      if (paramaarb == null) {}
    }
    catch (JSONException paramaarb)
    {
      aase.d("GdtLoadAdJsCallHandler", "handleJsCallRequest error", paramaarb);
      return true;
    }
    for (paramaarb = paramaarb.a();; paramaarb = null)
    {
      AdReporterForAnalysis.reportForJSBridgeInvoked(localActivity, false, "loadAd", paramaarb);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aarv
 * JD-Core Version:    0.7.0.1
 */