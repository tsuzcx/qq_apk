import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import org.json.JSONObject;

public class aimb
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  JSONObject jdField_a_of_type_OrgJsonJSONObject;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long;
  String jdField_b_of_type_JavaLangString;
  protected int c;
  long jdField_c_of_type_Long;
  String jdField_c_of_type_JavaLangString;
  int jdField_d_of_type_Int = 0;
  public long d;
  String jdField_d_of_type_JavaLangString;
  int e = 0;
  
  public aimb(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_Long = paramJSONObject.optLong("puin");
      this.jdField_a_of_type_Int = paramJSONObject.optInt("type");
      this.jdField_b_of_type_Int = paramJSONObject.optInt("show_tab");
      this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("content");
      this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("icon");
      this.jdField_c_of_type_JavaLangString = paramJSONObject.optString("url");
      this.jdField_b_of_type_Long = paramJSONObject.optLong("begin");
      this.jdField_c_of_type_Long = paramJSONObject.optLong("end");
      this.jdField_d_of_type_JavaLangString = paramJSONObject.optString("shool_id");
      this.jdField_c_of_type_Int = paramJSONObject.optInt("times");
      this.jdField_d_of_type_Long = paramJSONObject.optLong("msg_seqno");
      this.jdField_d_of_type_Long = paramJSONObject.optLong("msg_seqno");
      this.jdField_d_of_type_Int = paramJSONObject.optInt("tid");
      this.e = paramJSONObject.optInt("clicked");
    }
  }
  
  boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Long > 0L)
    {
      bool1 = bool2;
      if (this.jdField_c_of_type_Int >= 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean b()
  {
    boolean bool2 = true;
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    boolean bool1 = bool2;
    if (l >= this.jdField_b_of_type_Long)
    {
      bool1 = bool2;
      if (l <= this.jdField_c_of_type_Long) {
        bool1 = false;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimb
 * JD-Core Version:    0.7.0.1
 */