import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class airi
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
  
  public airi()
  {
    this.jdField_a_of_type_Double = 0.0D;
  }
  
  public static airi a(String paramString)
  {
    airi localairi = new airi();
    try
    {
      JSONObject localJSONObject2 = new JSONObject(paramString);
      localairi.jdField_b_of_type_Int = localJSONObject2.optInt("product_type");
      JSONObject localJSONObject3 = localJSONObject2.optJSONObject("display_info");
      JSONObject localJSONObject1 = localJSONObject3.optJSONObject("video_info");
      localairi.jdField_b_of_type_JavaLangString = localJSONObject1.optString("tencent_video_id");
      localairi.jdField_a_of_type_Int = localJSONObject3.optInt("creative_size");
      JSONObject localJSONObject4 = localJSONObject3.optJSONObject("basic_info");
      localairi.h = localJSONObject4.optString("img");
      localairi.e = localJSONObject4.optString("txt");
      localJSONObject3 = localJSONObject3.optJSONObject("advertiser_info");
      localairi.jdField_c_of_type_Int = localJSONObject3.optInt("advertiser_id");
      localairi.f = localJSONObject3.optString("corporate_logo");
      localairi.d = localJSONObject3.optString("corporate_image_name");
      localJSONObject3 = localJSONObject2.optJSONObject("report_info");
      localairi.g = localJSONObject3.optString("click_url");
      localairi.jdField_c_of_type_JavaLangString = localJSONObject3.optString("exposure_url");
      localJSONObject2 = localJSONObject2.optJSONObject("app_info");
      localairi.jdField_a_of_type_Long = localJSONObject2.optLong("download_num");
      localairi.j = localJSONObject1.optString("video_url");
      if ((!TextUtils.isEmpty(localairi.j)) && (localairi.j.startsWith("https://"))) {
        localairi.j = localairi.j.replaceFirst("https://", "http://");
      }
      if (localJSONObject2.has("app_score_num")) {
        localairi.jdField_a_of_type_Double = localJSONObject2.optDouble("app_score_num");
      }
      localairi.i = paramString;
      return localairi;
    }
    catch (Throwable paramString)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, paramString, new Object[0]);
    }
    return localairi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     airi
 * JD-Core Version:    0.7.0.1
 */