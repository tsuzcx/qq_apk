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

class acql
  implements acqj
{
  private acke jdField_a_of_type_Acke = new acqm(this);
  private WeakReference<acpp> jdField_a_of_type_JavaLangRefWeakReference;
  private Map<ackd, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public boolean a(acpp paramacpp, String paramString, String... paramVarArgs)
  {
    if (paramacpp != null) {}
    for (Activity localActivity = paramacpp.a(); (paramacpp == null) || (localActivity == null); localActivity = null)
    {
      acqy.d("GdtLoadAdJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    try
    {
      Object localObject = new JSONObject(paramVarArgs[0]);
      acqy.b("GdtLoadAdJsCallHandler", ((JSONObject)localObject).toString());
      paramVarArgs = new ackf();
      paramVarArgs.a = ((qq_ad_get.QQAdGet)qq_ad_get.QQAdGet.class.cast(acqx.a(new qq_ad_get.QQAdGet(), localObject)));
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramacpp);
      localObject = new ackd(paramVarArgs, new WeakReference(this.jdField_a_of_type_Acke));
      this.jdField_a_of_type_JavaUtilMap.put(localObject, paramString);
      ((ackd)localObject).a(new WeakReference(localActivity));
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
      if (paramacpp == null) {}
    }
    catch (JSONException paramacpp)
    {
      acqy.d("GdtLoadAdJsCallHandler", "handleJsCallRequest error", paramacpp);
      return true;
    }
    for (paramacpp = paramacpp.a();; paramacpp = null)
    {
      AdReporterForAnalysis.reportForJSBridgeInvoked(localActivity, false, "loadAd", paramacpp);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acql
 * JD-Core Version:    0.7.0.1
 */