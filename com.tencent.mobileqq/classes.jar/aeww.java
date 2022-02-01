import com.tencent.mobileqq.activity.aio.AIOTimeReporter.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;

public class aeww
{
  private static String b = "HighDeviceFirstOpenAIOBusiness";
  private static String c = "HighDeviceFirstOpenAIOBase";
  private static String d = "HighDeviceNotFirstOpenAIOBusiness";
  private static String e = "HighDeviceNotFirstOpenAIOBase";
  private static String f = "MidDeviceFirstOpenAIOBusiness";
  private static String g = "MidDeviceFirstOpenAIOBase";
  private static String h = "MidDeviceNotFirstOpenAIOBusiness";
  private static String i = "MidDeviceNotFirstOpenAIOBase";
  private static String j = "LowDeviceFirstOpenAIOBusiness";
  private static String k = "LowDeviceFirstOpenAIOBase";
  private static String l = "LowDeviceNotFirstOpenAIOBusiness";
  private static String m = "LowDeviceNotFirstOpenAIOBase";
  private int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString = "0";
  
  private void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.aio.AIOTimeReporter", 4, "reSet ");
    }
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "0";
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.aio.AIOTimeReporter", 4, "reportAIOLifeCycleTime ");
    }
    if (new Random().nextInt(100) != 1)
    {
      b();
      return;
    }
    ThreadManager.post(new AIOTimeReporter.1(this), 1, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeww
 * JD-Core Version:    0.7.0.1
 */