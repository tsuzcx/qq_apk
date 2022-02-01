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

class acgz
  implements acgx
{
  private acag jdField_a_of_type_Acag = new acha(this);
  private WeakReference<acfw> jdField_a_of_type_JavaLangRefWeakReference;
  private Map<acaf, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public boolean a(acfw paramacfw, String paramString, String... paramVarArgs)
  {
    if (paramacfw != null) {}
    for (Activity localActivity = paramacfw.a(); (paramacfw == null) || (localActivity == null); localActivity = null)
    {
      acho.d("GdtLoadAdJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    try
    {
      Object localObject = new JSONObject(paramVarArgs[0]);
      acho.b("GdtLoadAdJsCallHandler", ((JSONObject)localObject).toString());
      paramVarArgs = new acah();
      paramVarArgs.a = ((qq_ad_get.QQAdGet)qq_ad_get.QQAdGet.class.cast(achn.a(new qq_ad_get.QQAdGet(), localObject)));
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramacfw);
      localObject = new acaf(paramVarArgs, new WeakReference(this.jdField_a_of_type_Acag));
      this.jdField_a_of_type_JavaUtilMap.put(localObject, paramString);
      ((acaf)localObject).a(new WeakReference(localActivity));
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
      if (paramacfw == null) {}
    }
    catch (JSONException paramacfw)
    {
      acho.d("GdtLoadAdJsCallHandler", "handleJsCallRequest error", paramacfw);
      return true;
    }
    for (paramacfw = paramacfw.a();; paramacfw = null)
    {
      AdReporterForAnalysis.reportForJSBridgeInvoked(localActivity, false, "loadAd", paramacfw);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acgz
 * JD-Core Version:    0.7.0.1
 */