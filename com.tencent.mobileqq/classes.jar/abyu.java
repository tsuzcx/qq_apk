import android.text.TextUtils;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.ContactUtils;

public class abyu
  implements Runnable
{
  public abyu(ConfessManager paramConfessManager, String paramString) {}
  
  public void run()
  {
    abyy localabyy = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.jdField_a_of_type_Abyy;
    if (localabyy == null) {}
    do
    {
      return;
      if (TextUtils.isEmpty(localabyy.jdField_a_of_type_JavaLangString)) {
        localabyy.jdField_a_of_type_JavaLangString = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localabyy.b);
      }
      if (localabyy.d == 0) {
        localabyy.d = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.a(this.jdField_a_of_type_JavaLangString, localabyy.b, localabyy.c, localabyy.jdField_a_of_type_Int);
      }
    } while (localabyy.d != 1);
    long l = MessageCache.a();
    this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.a(this.jdField_a_of_type_JavaLangString, localabyy, l, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abyu
 * JD-Core Version:    0.7.0.1
 */