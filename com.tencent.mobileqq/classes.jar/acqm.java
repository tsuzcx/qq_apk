import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class acqm
  implements acke
{
  acqm(acql paramacql) {}
  
  public void onResponse(ackd paramackd)
  {
    if ((paramackd == null) || (paramackd.a() == null) || (acql.a(this.a) == null) || (acql.a(this.a).get() == null)) {
      return;
    }
    String str = (String)acql.a(this.a).get(paramackd);
    acql.a(this.a).remove(paramackd);
    Object localObject1 = acqx.a(paramackd.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet);
    Object localObject2 = acqx.a(paramackd.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp);
    paramackd = new JSONObject();
    try
    {
      paramackd.put("request", localObject1);
      paramackd.put("response", localObject2);
      ((acpp)acql.a(this.a).get()).callJs(str, new String[] { paramackd.toString() });
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
 * Qualified Name:     acqm
 * JD-Core Version:    0.7.0.1
 */