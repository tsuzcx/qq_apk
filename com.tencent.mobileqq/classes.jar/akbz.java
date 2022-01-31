import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ContactUtils.OnGetTroopMemberNameCallback;

public final class akbz
  implements Runnable
{
  public akbz(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ContactUtils.OnGetTroopMemberNameCallback paramOnGetTroopMemberNameCallback) {}
  
  public void run()
  {
    String str = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.b);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsContactUtils$OnGetTroopMemberNameCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsContactUtils$OnGetTroopMemberNameCallback.a(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akbz
 * JD-Core Version:    0.7.0.1
 */