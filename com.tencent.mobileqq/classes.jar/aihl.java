import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;

class aihl
  implements Runnable
{
  aihl(aihk paramaihk, StructMsgForAudioShare paramStructMsgForAudioShare, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    long l = NetConnInfoCenter.getServerTime();
    if (PublicAccountChatPie.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForAudioShare.uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
    for (int i = 1;; i = 0)
    {
      PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForAudioShare.uin, "0X80055C7", "0X80055C7", 0, 0, Long.toString(l), Long.toString(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForAudioShare.msgId), this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForAudioShare.mMsgAction, Integer.toString(i), false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aihl
 * JD-Core Version:    0.7.0.1
 */