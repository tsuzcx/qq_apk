import android.text.TextUtils;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.ContactUtils;

public class abrs
  implements Runnable
{
  public abrs(ConfessManager paramConfessManager, String paramString) {}
  
  public void run()
  {
    abru localabru = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.jdField_a_of_type_Abru;
    if (localabru == null) {}
    do
    {
      return;
      if (TextUtils.isEmpty(localabru.jdField_a_of_type_JavaLangString)) {
        localabru.jdField_a_of_type_JavaLangString = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localabru.b);
      }
      if (localabru.d == 0) {
        localabru.d = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.a(this.jdField_a_of_type_JavaLangString, localabru.b, localabru.c, localabru.jdField_a_of_type_Int);
      }
    } while (localabru.d != 1);
    long l = MessageCache.a();
    this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.a(this.jdField_a_of_type_JavaLangString, localabru, l, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abrs
 * JD-Core Version:    0.7.0.1
 */