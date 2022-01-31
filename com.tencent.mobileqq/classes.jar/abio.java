import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.armap.ARMapActivity;

public class abio
  implements Runnable
{
  public abio(ARMapActivity paramARMapActivity, int paramInt) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.isResume()) {
      return;
    }
    SosoInterface.b(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.a);
    SosoInterface.jdField_a_of_type_Int = this.jdField_a_of_type_Int * 1000;
    SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abio
 * JD-Core Version:    0.7.0.1
 */