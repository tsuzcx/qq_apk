import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

final class aaoa
  implements auoq
{
  aaoa(MessageForArkApp paramMessageForArkApp, QQAppInterface paramQQAppInterface) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(auor paramauor) {}
  
  public void b(auor paramauor)
  {
    try
    {
      if (paramauor.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.resIDForLongMsg = paramauor.c;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp, null, false);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityFacade", 2, "upload multi msg pack failed, result.errStr=" + paramauor.b + ",result.errStr=" + paramauor.jdField_a_of_type_JavaLangString);
      }
      astu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp);
      return;
    }
    catch (Exception paramauor)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityFacade", 2, "upload multi msg pack failed, catch exception", paramauor);
      }
      astu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaoa
 * JD-Core Version:    0.7.0.1
 */