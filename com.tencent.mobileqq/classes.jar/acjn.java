import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

final class acjn
  implements awkh
{
  acjn(MessageForArkApp paramMessageForArkApp, QQAppInterface paramQQAppInterface) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(awki paramawki) {}
  
  public void b(awki paramawki)
  {
    try
    {
      if (paramawki.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.resIDForLongMsg = paramawki.c;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp, null, false);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityFacade", 2, "upload multi msg pack failed, result.errStr=" + paramawki.b + ",result.errStr=" + paramawki.jdField_a_of_type_JavaLangString);
      }
      aupa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp);
      return;
    }
    catch (Exception paramawki)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityFacade", 2, "upload multi msg pack failed, catch exception", paramawki);
      }
      aupa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acjn
 * JD-Core Version:    0.7.0.1
 */