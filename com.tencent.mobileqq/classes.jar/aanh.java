import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class aanh
  implements aaif
{
  aanh(aang paramaang) {}
  
  public void onResponse(aaie paramaaie)
  {
    if ((paramaaie == null) || (paramaaie.a() == null) || (aang.a(this.a) == null) || (aang.a(this.a).get() == null)) {
      return;
    }
    String str = (String)aang.a(this.a).get(paramaaie);
    aang.a(this.a).remove(paramaaie);
    Object localObject1 = aano.a(paramaaie.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet);
    Object localObject2 = aano.a(paramaaie.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp);
    paramaaie = new JSONObject();
    try
    {
      paramaaie.put("request", localObject1);
      paramaaie.put("response", localObject2);
      ((aamm)aang.a(this.a).get()).callJs(str, new String[] { paramaaie.toString() });
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
 * Qualified Name:     aanh
 * JD-Core Version:    0.7.0.1
 */