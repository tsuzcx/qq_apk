import com.tencent.common.config.AppSetting;
import java.util.ArrayList;
import java.util.List;

public class alfj
  implements alff
{
  private static final boolean jdField_a_of_type_Boolean = AppSetting.b;
  private final String jdField_a_of_type_JavaLangString = "huawei_arcore";
  private final ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final String b = "huawei_arcore_arch64";
  private final String c = "v8.0.0";
  private final String d = "v8.2.0";
  private final String e = "md5_config.xml";
  
  public alfj()
  {
    this.jdField_a_of_type_JavaUtilArrayList.add("libarengine_api");
    this.jdField_a_of_type_JavaUtilArrayList.add("libhuawei_arengine_impl");
    this.jdField_a_of_type_JavaUtilArrayList.add("libhuawei_arengine_ndk");
    this.jdField_a_of_type_JavaUtilArrayList.add("libhuawei_arengine_jni");
  }
  
  public String a()
  {
    if (jdField_a_of_type_Boolean) {
      return "huawei_arcore_arch64";
    }
    return "huawei_arcore";
  }
  
  public List<String> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public String b()
  {
    if (jdField_a_of_type_Boolean) {
      return "v8.2.0";
    }
    return "v8.0.0";
  }
  
  public String c()
  {
    return "md5_config.xml";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alfj
 * JD-Core Version:    0.7.0.1
 */