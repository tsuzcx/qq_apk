import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import tencent.im.msg.im_msg_body.RichText;

public class aejn
  implements UpCallBack
{
  int jdField_a_of_type_Int;
  MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  String jdField_a_of_type_JavaLangString;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public aejn(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult.jdField_a_of_type_Int == 0)
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForStructing.structingMsg.mResid = paramSendResult.c;
      localMessageForStructing.structingMsg.mFileName = String.valueOf(localMessageForStructing.uniseq);
      ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, localMessageForStructing.uniseq, localMessageForStructing.structingMsg.getBytes());
      ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "send real struct msg done, cost : " + (System.currentTimeMillis() - MultiMsgManager.b()));
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "upload multi msg pack failed, result.errStr=" + paramSendResult.b + ",result.errStr=" + paramSendResult.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.extraflag = 32768;
    ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
    paramSendResult = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if ((paramSendResult != null) && (paramSendResult.uniseq == this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq)) {
      paramSendResult.extraflag = 32768;
    }
    paramSendResult = this.jdField_a_of_type_JavaLangString;
    int i = this.jdField_a_of_type_Int;
    long l = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
    ((MessageHandler)((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(0)).a(MessageHandler.c(this.jdField_a_of_type_Int), false, new Object[] { paramSendResult, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aejn
 * JD-Core Version:    0.7.0.1
 */