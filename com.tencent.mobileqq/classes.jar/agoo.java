import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardInfo;

public final class agoo
  implements Runnable
{
  public agoo(String paramString, QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.vPersonalityLabelV2 = this.jdField_a_of_type_ArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agoo
 * JD-Core Version:    0.7.0.1
 */