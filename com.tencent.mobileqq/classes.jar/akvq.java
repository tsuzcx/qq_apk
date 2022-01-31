import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class akvq
{
  public static String a;
  public double a;
  public int a;
  public long a;
  public int b;
  public long b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  
  static
  {
    jdField_a_of_type_JavaLangString = "cmgame_process.CmGameADInfo";
  }
  
  public akvq()
  {
    this.jdField_a_of_type_Double = 0.0D;
  }
  
  public static akvq a(String paramString)
  {
    akvq localakvq = new akvq();
    try
    {
      JSONObject localJSONObject2 = new JSONObject(paramString);
      localakvq.jdField_b_of_type_Int = localJSONObject2.optInt("product_type");
      JSONObject localJSONObject3 = localJSONObject2.optJSONObject("display_info");
      JSONObject localJSONObject1 = localJSONObject3.optJSONObject("video_info");
      localakvq.jdField_b_of_type_JavaLangString = localJSONObject1.optString("tencent_video_id");
      localakvq.jdField_a_of_type_Int = localJSONObject3.optInt("creative_size");
      JSONObject localJSONObject4 = localJSONObject3.optJSONObject("basic_info");
      localakvq.h = localJSONObject4.optString("img");
      localakvq.e = localJSONObject4.optString("txt");
      localJSONObject3 = localJSONObject3.optJSONObject("advertiser_info");
      localakvq.jdField_c_of_type_Int = localJSONObject3.optInt("advertiser_id");
      localakvq.f = localJSONObject3.optString("corporate_logo");
      localakvq.d = localJSONObject3.optString("corporate_image_name");
      localJSONObject3 = localJSONObject2.optJSONObject("report_info");
      localakvq.g = localJSONObject3.optString("click_url");
      localakvq.jdField_c_of_type_JavaLangString = localJSONObject3.optString("exposure_url");
      localJSONObject2 = localJSONObject2.optJSONObject("app_info");
      localakvq.jdField_a_of_type_Long = localJSONObject2.optLong("download_num");
      localakvq.j = localJSONObject1.optString("video_url");
      if ((!TextUtils.isEmpty(localakvq.j)) && (localakvq.j.startsWith("https://"))) {
        localakvq.j = localakvq.j.replaceFirst("https://", "http://");
      }
      if (localJSONObject2.has("app_score_num")) {
        localakvq.jdField_a_of_type_Double = localJSONObject2.optDouble("app_score_num");
      }
      localakvq.i = paramString;
      return localakvq;
    }
    catch (Throwable paramString)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, paramString, new Object[0]);
    }
    return localakvq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akvq
 * JD-Core Version:    0.7.0.1
 */