import com.tencent.mobileqq.ark.ArkTipsManager;
import java.lang.ref.WeakReference;

public class aayj
  implements Runnable
{
  public aayj(ArkTipsManager paramArkTipsManager, long paramLong) {}
  
  public void run()
  {
    if ((ArkTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager) != null) && (this.jdField_a_of_type_Long == ArkTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager).b))
    {
      ArkTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager, this.jdField_a_of_type_Long);
      ArkTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager, new WeakReference(ArkTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager).a));
      this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aayj
 * JD-Core Version:    0.7.0.1
 */