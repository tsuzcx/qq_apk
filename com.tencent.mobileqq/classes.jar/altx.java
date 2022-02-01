import android.os.Process;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class altx
{
  public static final int a;
  public static final long a;
  public static final String a;
  public static final String b;
  public static final String c;
  public long b;
  public long c;
  
  static
  {
    jdField_a_of_type_JavaLangString = DeviceInfoUtil.getDeviceOSVersion();
    jdField_b_of_type_JavaLangString = DeviceInfoUtil.getModel();
    jdField_c_of_type_JavaLangString = DeviceInfoUtil.getCpuType();
    jdField_a_of_type_Int = DeviceInfoUtil.getCpuNumber();
    jdField_a_of_type_Long = DeviceInfoUtil.getCpuFrequency();
  }
  
  public altx()
  {
    this.jdField_b_of_type_Long = DeviceInfoUtil.getApplicationMemory(Process.myPid());
    this.jdField_c_of_type_Long = DeviceInfoUtil.getMemoryClass();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     altx
 * JD-Core Version:    0.7.0.1
 */