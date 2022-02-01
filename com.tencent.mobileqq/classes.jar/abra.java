import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class abra
  implements abkq
{
  abra(abqz paramabqz) {}
  
  public void onResponse(abkp paramabkp)
  {
    if ((paramabkp == null) || (paramabkp.a() == null) || (abqz.a(this.a) == null) || (abqz.a(this.a).get() == null)) {
      return;
    }
    String str = (String)abqz.a(this.a).get(paramabkp);
    abqz.a(this.a).remove(paramabkp);
    Object localObject1 = abrk.a(paramabkp.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet);
    Object localObject2 = abrk.a(paramabkp.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp);
    paramabkp = new JSONObject();
    try
    {
      paramabkp.put("request", localObject1);
      paramabkp.put("response", localObject2);
      ((abqc)abqz.a(this.a).get()).callJs(str, new String[] { paramabkp.toString() });
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
 * Qualified Name:     abra
 * JD-Core Version:    0.7.0.1
 */