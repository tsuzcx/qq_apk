import com.tencent.biz.subscribe.utils.SubscribeAdDeviceInfoHelper.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

public class aand
{
  private static aand jdField_a_of_type_Aand;
  private qq_ad_get.QQAdGet.DeviceInfo jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo;
  
  public static aand a()
  {
    if (jdField_a_of_type_Aand == null) {}
    try
    {
      if (jdField_a_of_type_Aand == null) {
        jdField_a_of_type_Aand = new aand();
      }
      return jdField_a_of_type_Aand;
    }
    finally {}
  }
  
  public qq_ad_get.QQAdGet.DeviceInfo a()
  {
    a();
    return this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo;
  }
  
  public void a()
  {
    ThreadManager.getFileThreadHandler().post(new SubscribeAdDeviceInfoHelper.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aand
 * JD-Core Version:    0.7.0.1
 */