import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

final class ahfd
  extends bcym
{
  ahfd(MessageForShortVideo paramMessageForShortVideo, MessageForReplyText paramMessageForReplyText, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, bcyf parambcyf)
  {
    if (parambcyf.jdField_a_of_type_Int == 0)
    {
      parambcyf = (azjk)parambcyf.jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.mThumbFilePath = parambcyf.b;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.setSourceMessageRecord(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.msgData);
      ahfa.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.thumbWidth, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.thumbHeight, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.mThumbFilePath, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView);
      return;
    }
    QLog.d("ReplyTextItemBuilder", 2, "reply render get thumbPath Fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahfd
 * JD-Core Version:    0.7.0.1
 */