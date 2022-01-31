import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class abyw
  implements Runnable
{
  public abyw(ConfessManager paramConfessManager, String paramString, abyz paramabyz) {}
  
  public void run()
  {
    abyz localabyz = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.jdField_a_of_type_Abyz;
    if ((localabyz == null) || (this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      return;
      if (TextUtils.isEmpty(localabyz.c)) {
        localabyz.c = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Abyz.d);
      }
      if (localabyz.jdField_e_of_type_Int == 0) {
        localabyz.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.a(this.jdField_a_of_type_JavaLangString, localabyz.d, localabyz.b, localabyz.jdField_e_of_type_JavaLangString, localabyz.jdField_a_of_type_Int);
      }
    } while (localabyz.jdField_e_of_type_Int != 1);
    long l2 = MessageCache.a();
    List localList = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, 1);
    long l1;
    if ((localList != null) && (!localList.isEmpty())) {
      l1 = ((ChatMessage)localList.get(localList.size() - 1)).shmsgseq + 1L;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "enterGroupRecConfessChat shmsgseq: %s isRandomShmsgseq:%s", new Object[] { Long.valueOf(l1), Boolean.valueOf(localabyz.jdField_a_of_type_Boolean) }));
      }
      this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.a(this.jdField_a_of_type_JavaLangString, localabyz, l2, l2, l1);
      return;
      l1 = Math.abs(new Random().nextInt());
      localabyz.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abyw
 * JD-Core Version:    0.7.0.1
 */