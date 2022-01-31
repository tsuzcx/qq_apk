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

class aghu
  implements View.OnClickListener
{
  aghu(aghr paramaghr) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    MessageForQQWalletMsg localMessageForQQWalletMsg;
    Object localObject;
    do
    {
      QQWalletRedPacketMsg localQQWalletRedPacketMsg;
      aipw localaipw;
      do
      {
        do
        {
          do
          {
            return;
            if (this.a.jdField_a_of_type_Aist != null) {
              this.a.jdField_a_of_type_Aist.a(11);
            }
            l = System.currentTimeMillis();
          } while (!ajae.a(aghr.jdField_a_of_type_Long, l));
          aghr.jdField_a_of_type_Long = l;
          localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
          localQQWalletRedPacketMsg = localMessageForQQWalletMsg.mQQWalletRedPacketMsg;
          localaipw = (aipw)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125);
          if (!nav.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localaipw.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 11);
        } while (!QLog.isColorLevel());
        QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
        return;
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
          break;
        }
        localObject = (bcjl)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
        boolean bool = ((bcjl)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localObject = ((bcjl)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
        if ((!bool) && ((localObject == null) || (!((bcjr)localObject).jdField_a_of_type_Boolean))) {
          break;
        }
        localaipw.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 11);
      } while (!QLog.isColorLevel());
      QLog.d("PasswdRedBagManager", 2, "current is in TroopMemberGag, dont show passwdredbag tips");
      return;
      localObject = localaipw.a(localQQWalletRedPacketMsg.redPacketId);
      long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
      if ((localObject == null) || ((!((aipv)localObject).jdField_a_of_type_Boolean) && (!((aipv)localObject).b) && (!((aipv)localObject).c) && (((aipv)localObject).jdField_a_of_type_Long >= l))) {
        break;
      }
      localaipw.a(localQQWalletRedPacketMsg.redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      l = VACDReportUtil.a(null, "qqwallet", "graphb", "draw.click", "msgType=22", 0, null);
      localaipw.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (aipv)localObject, l, 1000001, "", localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId, localMessageForQQWalletMsg.fromHBList, null);
    } while (!QLog.isColorLevel());
    QLog.d("PasswdRedBagManager", 2, "click open draw redpacket, isPasswdRedBagOpen=" + ((aipv)localObject).jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + ((aipv)localObject).b + ",isPasswdRedBagOverDue=" + ((aipv)localObject).c);
    return;
    DrawRedpacketPannelPreviewFragment.a(paramView.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localMessageForQQWalletMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aghu
 * JD-Core Version:    0.7.0.1
 */