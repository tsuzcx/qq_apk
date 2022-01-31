import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mqp.app.sec.ScConfigManager;

public class algw
  implements Runnable
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public algw(ScConfigManager paramScConfigManager, QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    ScConfigManager.a(this.jdField_a_of_type_ComTencentMqpAppSecScConfigManager, this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMqpAppSecScConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     algw
 * JD-Core Version:    0.7.0.1
 */