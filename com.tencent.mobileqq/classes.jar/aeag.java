import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class aeag
  implements View.OnClickListener
{
  aeag(aead paramaead) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    MessageForQQWalletMsg localMessageForQQWalletMsg;
    Object localObject;
    do
    {
      QQWalletRedPacketMsg localQQWalletRedPacketMsg;
      agjk localagjk;
      do
      {
        do
        {
          do
          {
            return;
            if (this.a.jdField_a_of_type_Agmg != null) {
              this.a.jdField_a_of_type_Agmg.a(11);
            }
            l = System.currentTimeMillis();
          } while (!agwi.a(aead.jdField_a_of_type_Long, l));
          aead.jdField_a_of_type_Long = l;
          localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
          localQQWalletRedPacketMsg = localMessageForQQWalletMsg.mQQWalletRedPacketMsg;
          localagjk = (agjk)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125);
          if (!mnf.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localagjk.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 11);
        } while (!QLog.isColorLevel());
        QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
        return;
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
          break;
        }
        localObject = (azjh)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
        boolean bool = ((azjh)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localObject = ((azjh)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
        if ((!bool) && ((localObject == null) || (!((azjn)localObject).jdField_a_of_type_Boolean))) {
          break;
        }
        localagjk.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 11);
      } while (!QLog.isColorLevel());
      QLog.d("PasswdRedBagManager", 2, "current is in TroopMemberGag, dont show passwdredbag tips");
      return;
      localObject = localagjk.a(localQQWalletRedPacketMsg.redPacketId);
      long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
      if ((localObject == null) || ((!((agjj)localObject).jdField_a_of_type_Boolean) && (!((agjj)localObject).b) && (!((agjj)localObject).c) && (((agjj)localObject).jdField_a_of_type_Long >= l))) {
        break;
      }
      localagjk.a(localQQWalletRedPacketMsg.redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      l = VACDReportUtil.a(null, "qqwallet", "graphb", "draw.click", "msgType=22", 0, null);
      localagjk.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (agjj)localObject, l, 1000001, "", localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId, localMessageForQQWalletMsg.fromHBList, null);
    } while (!QLog.isColorLevel());
    QLog.d("PasswdRedBagManager", 2, "click open draw redpacket, isPasswdRedBagOpen=" + ((agjj)localObject).jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + ((agjj)localObject).b + ",isPasswdRedBagOverDue=" + ((agjj)localObject).c);
    return;
    DrawRedpacketPannelPreviewFragment.a(paramView.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localMessageForQQWalletMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeag
 * JD-Core Version:    0.7.0.1
 */