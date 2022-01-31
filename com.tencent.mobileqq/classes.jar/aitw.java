import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class aitw
{
  private SendHbActivity a;
  
  public aitw(SendHbActivity paramSendHbActivity)
  {
    this.a = paramSendHbActivity;
  }
  
  public void a()
  {
    Map localMap = this.a.a();
    localMap.put("channel", this.a.jdField_a_of_type_Int + "");
    localMap.put("bus_type", "1");
    localMap.put("type", "1");
    a(localMap);
  }
  
  public void a(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    try
    {
      localJSONObject.put("userId", paramString2);
      localJSONObject.put("viewTag", "qrcodeHb");
      localJSONObject.put("comeForm", 1);
      paramString2 = new JSONObject();
      if (!TextUtils.isEmpty(paramString1)) {
        paramString2.putOpt("qrToken", paramString1);
      }
      paramString2.putOpt("comeFrom", Integer.valueOf(1));
      localJSONObject.put("extra_data", paramString2.toString());
      paramString1 = new Bundle();
      paramString1.putString("json", localJSONObject.toString());
      paramString1.putString("callbackSn", "0");
      paramString1.putLong("vacreport_key_seq", this.a.jdField_a_of_type_Long);
      PayBridgeActivity.a(this.a, 5, paramString1);
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(Map<String, String> paramMap)
  {
    Object localObject = new JSONObject(paramMap);
    paramMap = this.a.b();
    paramMap.put("extra_data", ((JSONObject)localObject).toString());
    localObject = new Bundle();
    ((Bundle)localObject).putString("json", new JSONObject(paramMap).toString());
    ((Bundle)localObject).putString("callbackSn", "0");
    ((Bundle)localObject).putLong("vacreport_key_seq", this.a.jdField_a_of_type_Long);
    PayBridgeActivity.a(this.a, 5, (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aitw
 * JD-Core Version:    0.7.0.1
 */