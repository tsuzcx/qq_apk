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

class aeld
  implements View.OnClickListener
{
  aeld(aela paramaela) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    MessageForQQWalletMsg localMessageForQQWalletMsg;
    Object localObject;
    do
    {
      QQWalletRedPacketMsg localQQWalletRedPacketMsg;
      agvx localagvx;
      do
      {
        do
        {
          do
          {
            return;
            if (this.a.jdField_a_of_type_Agyt != null) {
              this.a.jdField_a_of_type_Agyt.a(11);
            }
            l = System.currentTimeMillis();
          } while (!ahiv.a(aela.jdField_a_of_type_Long, l));
          aela.jdField_a_of_type_Long = l;
          localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
          localQQWalletRedPacketMsg = localMessageForQQWalletMsg.mQQWalletRedPacketMsg;
          localagvx = (agvx)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125);
          if (!myb.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localagvx.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 11);
        } while (!QLog.isColorLevel());
        QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
        return;
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
          break;
        }
        localObject = (baky)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
        boolean bool = ((baky)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localObject = ((baky)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
        if ((!bool) && ((localObject == null) || (!((bale)localObject).jdField_a_of_type_Boolean))) {
          break;
        }
        localagvx.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 11);
      } while (!QLog.isColorLevel());
      QLog.d("PasswdRedBagManager", 2, "current is in TroopMemberGag, dont show passwdredbag tips");
      return;
      localObject = localagvx.a(localQQWalletRedPacketMsg.redPacketId);
      long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
      if ((localObject == null) || ((!((agvw)localObject).jdField_a_of_type_Boolean) && (!((agvw)localObject).b) && (!((agvw)localObject).c) && (((agvw)localObject).jdField_a_of_type_Long >= l))) {
        break;
      }
      localagvx.a(localQQWalletRedPacketMsg.redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      l = VACDReportUtil.a(null, "qqwallet", "graphb", "draw.click", "msgType=22", 0, null);
      localagvx.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (agvw)localObject, l, 1000001, "", localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId, localMessageForQQWalletMsg.fromHBList, null);
    } while (!QLog.isColorLevel());
    QLog.d("PasswdRedBagManager", 2, "click open draw redpacket, isPasswdRedBagOpen=" + ((agvw)localObject).jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + ((agvw)localObject).b + ",isPasswdRedBagOverDue=" + ((agvw)localObject).c);
    return;
    DrawRedpacketPannelPreviewFragment.a(paramView.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localMessageForQQWalletMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeld
 * JD-Core Version:    0.7.0.1
 */