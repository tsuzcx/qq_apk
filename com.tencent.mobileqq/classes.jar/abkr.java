import android.text.TextUtils;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.ContactUtils;

public class abkr
  implements Runnable
{
  public abkr(ConfessManager paramConfessManager, String paramString) {}
  
  public void run()
  {
    abkt localabkt = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.jdField_a_of_type_Abkt;
    if (localabkt == null) {}
    do
    {
      return;
      if (TextUtils.isEmpty(localabkt.jdField_a_of_type_JavaLangString)) {
        localabkt.jdField_a_of_type_JavaLangString = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localabkt.b);
      }
      if (localabkt.d == 0) {
        localabkt.d = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.a(this.jdField_a_of_type_JavaLangString, localabkt.b, localabkt.c, localabkt.jdField_a_of_type_Int);
      }
    } while (localabkt.d != 1);
    long l = MessageCache.a();
    this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.a(this.jdField_a_of_type_JavaLangString, localabkt, l, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abkr
 * JD-Core Version:    0.7.0.1
 */