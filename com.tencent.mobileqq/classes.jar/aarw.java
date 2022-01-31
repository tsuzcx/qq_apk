import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class aarw
  implements aamu
{
  aarw(aarv paramaarv) {}
  
  public void onResponse(aamt paramaamt)
  {
    if ((paramaamt == null) || (paramaamt.a() == null) || (aarv.a(this.a) == null) || (aarv.a(this.a).get() == null)) {
      return;
    }
    String str = (String)aarv.a(this.a).get(paramaamt);
    aarv.a(this.a).remove(paramaamt);
    Object localObject1 = aasd.a(paramaamt.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet);
    Object localObject2 = aasd.a(paramaamt.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp);
    paramaamt = new JSONObject();
    try
    {
      paramaamt.put("request", localObject1);
      paramaamt.put("response", localObject2);
      ((aarb)aarv.a(this.a).get()).callJs(str, new String[] { paramaamt.toString() });
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
 * Qualified Name:     aarw
 * JD-Core Version:    0.7.0.1
 */