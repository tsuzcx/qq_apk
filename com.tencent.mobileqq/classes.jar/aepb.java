import com.tencent.mobileqq.activity.aio.AIOTimeReporter.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;

public class aepb
{
  private static String c = "HighDeviceFirstOpenAIOBusiness";
  private static String d = "HighDeviceFirstOpenAIOBase";
  private static String e = "HighDeviceNotFirstOpenAIOBusiness";
  private static String f = "HighDeviceNotFirstOpenAIOBase";
  private static String g = "MidDeviceFirstOpenAIOBusiness";
  private static String h = "MidDeviceFirstOpenAIOBase";
  private static String i = "MidDeviceNotFirstOpenAIOBusiness";
  private static String j = "MidDeviceNotFirstOpenAIOBase";
  private static String k = "LowDeviceFirstOpenAIOBusiness";
  private static String l = "LowDeviceFirstOpenAIOBase";
  private static String m = "LowDeviceNotFirstOpenAIOBusiness";
  private static String n = "LowDeviceNotFirstOpenAIOBase";
  private int a;
  public String a;
  private String b = "0";
  
  public aepb()
  {
    this.jdField_a_of_type_JavaLangString = "Q.aio.AIOTimeReporter";
    this.jdField_a_of_type_Int = -1;
  }
  
  private void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 4, "reSet ");
    }
    this.jdField_a_of_type_Int = -1;
    this.b = "0";
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 4, "reportAIOLifeCycleTime ");
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
 * Qualified Name:     aepb
 * JD-Core Version:    0.7.0.1
 */