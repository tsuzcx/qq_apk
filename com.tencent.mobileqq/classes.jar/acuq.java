import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class acuq
  implements acoi
{
  acuq(acup paramacup) {}
  
  public void onResponse(acoh paramacoh)
  {
    if ((paramacoh == null) || (paramacoh.a() == null) || (acup.a(this.a) == null) || (acup.a(this.a).get() == null)) {
      return;
    }
    String str = (String)acup.a(this.a).get(paramacoh);
    acup.a(this.a).remove(paramacoh);
    Object localObject1 = acvb.a(paramacoh.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet);
    Object localObject2 = acvb.a(paramacoh.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp);
    paramacoh = new JSONObject();
    try
    {
      paramacoh.put("request", localObject1);
      paramacoh.put("response", localObject2);
      ((acts)acup.a(this.a).get()).callJs(str, new String[] { paramacoh.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acuq
 * JD-Core Version:    0.7.0.1
 */