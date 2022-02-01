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

class abqz
  implements abqx
{
  private abkq jdField_a_of_type_Abkq = new abra(this);
  private WeakReference<abqc> jdField_a_of_type_JavaLangRefWeakReference;
  private Map<abkp, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public boolean a(abqc paramabqc, String paramString, String... paramVarArgs)
  {
    if (paramabqc != null) {}
    for (Activity localActivity = paramabqc.a(); (paramabqc == null) || (localActivity == null); localActivity = null)
    {
      abrl.d("GdtLoadAdJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    try
    {
      Object localObject = new JSONObject(paramVarArgs[0]);
      abrl.b("GdtLoadAdJsCallHandler", ((JSONObject)localObject).toString());
      paramVarArgs = new abkr();
      paramVarArgs.a = ((qq_ad_get.QQAdGet)qq_ad_get.QQAdGet.class.cast(abrk.a(new qq_ad_get.QQAdGet(), localObject)));
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramabqc);
      localObject = new abkp(paramVarArgs, new WeakReference(this.jdField_a_of_type_Abkq));
      this.jdField_a_of_type_JavaUtilMap.put(localObject, paramString);
      ((abkp)localObject).a(new WeakReference(localActivity));
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
      if (paramabqc == null) {}
    }
    catch (JSONException paramabqc)
    {
      abrl.d("GdtLoadAdJsCallHandler", "handleJsCallRequest error", paramabqc);
      return true;
    }
    for (paramabqc = paramabqc.a();; paramabqc = null)
    {
      AdReporterForAnalysis.reportForJSBridgeInvoked(localActivity, false, "loadAd", paramabqc);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abqz
 * JD-Core Version:    0.7.0.1
 */