import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil;

class akyx
  implements Runnable
{
  akyx(akyw paramakyw) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.a.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.a.b, this.a.c, this.a.jdField_a_of_type_Long);
    if (localMessageRecord == null) {
      return;
    }
    MQPSensitiveMsgUtil.a(localMessageRecord);
    try
    {
      localMessageRecord.saveExtInfoToExtStr("sens_msg_confirmed", "1");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_original_text");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_need_parse");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_need_mask");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_attr");
      localMessageRecord.removeExtInfoToExtStr("sens_msg_has_not_confirmed_msg");
      this.a.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.a.b, this.a.c, this.a.jdField_a_of_type_Long, "extStr", localMessageRecord.extStr);
      this.a.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localMessageRecord);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akyx
 * JD-Core Version:    0.7.0.1
 */