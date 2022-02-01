import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class acha
  implements acag
{
  acha(acgz paramacgz) {}
  
  public void onResponse(acaf paramacaf)
  {
    if ((paramacaf == null) || (paramacaf.a() == null) || (acgz.a(this.a) == null) || (acgz.a(this.a).get() == null)) {
      return;
    }
    String str = (String)acgz.a(this.a).get(paramacaf);
    acgz.a(this.a).remove(paramacaf);
    Object localObject1 = achn.a(paramacaf.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet);
    Object localObject2 = achn.a(paramacaf.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp);
    paramacaf = new JSONObject();
    try
    {
      paramacaf.put("request", localObject1);
      paramacaf.put("response", localObject2);
      ((acfw)acgz.a(this.a).get()).callJs(str, new String[] { paramacaf.toString() });
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
 * Qualified Name:     acha
 * JD-Core Version:    0.7.0.1
 */