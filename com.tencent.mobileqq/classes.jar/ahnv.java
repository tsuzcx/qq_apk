import java.util.HashMap;

public class ahnv
  extends ahnt
{
  public int a;
  long jdField_a_of_type_Long = 0L;
  public String a;
  boolean jdField_a_of_type_Boolean = false;
  long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString = "";
  boolean jdField_b_of_type_Boolean = false;
  public int i;
  int j = -1;
  int k = -1;
  int l = 1001;
  int m = -1;
  
  ahnv()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = -1;
  }
  
  public HashMap a(String paramString)
  {
    if ("ShortVideo.Send".equals(paramString))
    {
      paramString = new HashMap();
      paramString.put("param_DetailUrl", this.jdField_a_of_type_JavaLangString);
      paramString.put("param_uinType", this.jdField_b_of_type_Int + "");
      paramString.put("param_GroupMemberCount", this.c + "");
      paramString.put("param_isForward", this.jdField_a_of_type_Boolean + "");
      paramString.put("param_isExist", this.jdField_b_of_type_Boolean + "");
      paramString.put("param_forwardSourceUinType", this.jdField_a_of_type_Int + "");
      paramString.put("param_forwardSourceGroupMemberCount", this.i + "");
      paramString.put("param_age", this.d + "");
      paramString.put("param_gender", this.e + "");
      paramString.put("param_userType", this.l + "");
      paramString.put("param_shortVideoType", this.f + "");
      paramString.put("param_shortVideoSourceType", this.j + "");
      paramString.put("param_reportHour", this.g + "");
      paramString.put("param_fileInterval", this.k + "");
      paramString.put("param_netType", this.h + "");
      paramString.put("param_md5", this.jdField_b_of_type_JavaLangString);
      paramString.put("param_fileSize", this.jdField_a_of_type_Long + "");
      paramString.put("param_duration", this.jdField_b_of_type_Long + "");
      paramString.put("param_status", this.m + "");
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahnv
 * JD-Core Version:    0.7.0.1
 */