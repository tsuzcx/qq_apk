import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aexf
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  
  public JSONObject a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("user_id", this.a);
      localJSONObject2.put("keyword", this.b);
      localJSONObject2.put("appid", this.c);
      localJSONObject2.put("expose_md5s", this.d);
      localJSONObject2.put("expose_urls", this.e);
      localJSONObject2.put("click_md5", this.f);
      localJSONObject2.put("click_url", this.g);
      localJSONObject2.put("aio_type", this.h);
      localJSONObject2.put("mobile_type", this.i);
      localJSONObject2.put("to_user_id", this.j);
      localJSONObject2.put("passthough", this.k);
      localJSONObject1.put("dcId", this.l);
      localJSONObject1.put("data", localJSONObject2);
      return localJSONObject1;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("StickerRecReportData", 2, "convert error:" + localException);
    }
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aexf
 * JD-Core Version:    0.7.0.1
 */