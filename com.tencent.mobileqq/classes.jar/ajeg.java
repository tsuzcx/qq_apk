import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ajeg
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
  
  public ajeg()
  {
    this.jdField_a_of_type_Double = 0.0D;
  }
  
  public static ajeg a(String paramString)
  {
    ajeg localajeg = new ajeg();
    try
    {
      JSONObject localJSONObject2 = new JSONObject(paramString);
      localajeg.jdField_b_of_type_Int = localJSONObject2.optInt("product_type");
      JSONObject localJSONObject3 = localJSONObject2.optJSONObject("display_info");
      JSONObject localJSONObject1 = localJSONObject3.optJSONObject("video_info");
      localajeg.jdField_b_of_type_JavaLangString = localJSONObject1.optString("tencent_video_id");
      localajeg.jdField_a_of_type_Int = localJSONObject3.optInt("creative_size");
      JSONObject localJSONObject4 = localJSONObject3.optJSONObject("basic_info");
      localajeg.h = localJSONObject4.optString("img");
      localajeg.e = localJSONObject4.optString("txt");
      localJSONObject3 = localJSONObject3.optJSONObject("advertiser_info");
      localajeg.jdField_c_of_type_Int = localJSONObject3.optInt("advertiser_id");
      localajeg.f = localJSONObject3.optString("corporate_logo");
      localajeg.d = localJSONObject3.optString("corporate_image_name");
      localJSONObject3 = localJSONObject2.optJSONObject("report_info");
      localajeg.g = localJSONObject3.optString("click_url");
      localajeg.jdField_c_of_type_JavaLangString = localJSONObject3.optString("exposure_url");
      localJSONObject2 = localJSONObject2.optJSONObject("app_info");
      localajeg.jdField_a_of_type_Long = localJSONObject2.optLong("download_num");
      localajeg.j = localJSONObject1.optString("video_url");
      if ((!TextUtils.isEmpty(localajeg.j)) && (localajeg.j.startsWith("https://"))) {
        localajeg.j = localajeg.j.replaceFirst("https://", "http://");
      }
      if (localJSONObject2.has("app_score_num")) {
        localajeg.jdField_a_of_type_Double = localJSONObject2.optDouble("app_score_num");
      }
      localajeg.i = paramString;
      return localajeg;
    }
    catch (Throwable paramString)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, paramString, new Object[0]);
    }
    return localajeg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajeg
 * JD-Core Version:    0.7.0.1
 */