import android.content.Context;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.intervideo.huayang.MonitorConfig;
import java.util.Map;

public final class aecx
  implements Runnable
{
  public aecx(Context paramContext, String paramString) {}
  
  public void run()
  {
    MonitorConfig.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
    if (MonitorConfig.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaLangString) != null)
    {
      Monitor.b(String.valueOf(((MonitorConfig)MonitorConfig.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaLangString)).jdField_a_of_type_Int));
      return;
    }
    Monitor.b("3235983");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aecx
 * JD-Core Version:    0.7.0.1
 */