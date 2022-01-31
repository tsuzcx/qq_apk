import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ajee
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
  
  public ajee()
  {
    this.jdField_a_of_type_Double = 0.0D;
  }
  
  public static ajee a(String paramString)
  {
    ajee localajee = new ajee();
    try
    {
      JSONObject localJSONObject2 = new JSONObject(paramString);
      localajee.jdField_b_of_type_Int = localJSONObject2.optInt("product_type");
      JSONObject localJSONObject3 = localJSONObject2.optJSONObject("display_info");
      JSONObject localJSONObject1 = localJSONObject3.optJSONObject("video_info");
      localajee.jdField_b_of_type_JavaLangString = localJSONObject1.optString("tencent_video_id");
      localajee.jdField_a_of_type_Int = localJSONObject3.optInt("creative_size");
      JSONObject localJSONObject4 = localJSONObject3.optJSONObject("basic_info");
      localajee.h = localJSONObject4.optString("img");
      localajee.e = localJSONObject4.optString("txt");
      localJSONObject3 = localJSONObject3.optJSONObject("advertiser_info");
      localajee.jdField_c_of_type_Int = localJSONObject3.optInt("advertiser_id");
      localajee.f = localJSONObject3.optString("corporate_logo");
      localajee.d = localJSONObject3.optString("corporate_image_name");
      localJSONObject3 = localJSONObject2.optJSONObject("report_info");
      localajee.g = localJSONObject3.optString("click_url");
      localajee.jdField_c_of_type_JavaLangString = localJSONObject3.optString("exposure_url");
      localJSONObject2 = localJSONObject2.optJSONObject("app_info");
      localajee.jdField_a_of_type_Long = localJSONObject2.optLong("download_num");
      localajee.j = localJSONObject1.optString("video_url");
      if ((!TextUtils.isEmpty(localajee.j)) && (localajee.j.startsWith("https://"))) {
        localajee.j = localajee.j.replaceFirst("https://", "http://");
      }
      if (localJSONObject2.has("app_score_num")) {
        localajee.jdField_a_of_type_Double = localJSONObject2.optDouble("app_score_num");
      }
      localajee.i = paramString;
      return localajee;
    }
    catch (Throwable paramString)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, paramString, new Object[0]);
    }
    return localajee;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajee
 * JD-Core Version:    0.7.0.1
 */