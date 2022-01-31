import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.imaxad.ImaxAdNetPresenter;

public class adst
  implements Runnable
{
  public adst(ImaxAdNetPresenter paramImaxAdNetPresenter, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, "extStr", this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.extStr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adst
 * JD-Core Version:    0.7.0.1
 */