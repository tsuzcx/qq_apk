import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahxk
  implements View.OnClickListener
{
  ahxk(ahxh paramahxh) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_Akto != null) {
        this.a.jdField_a_of_type_Akto.a(11);
      }
      long l = System.currentTimeMillis();
      if (albv.a(ahxh.jdField_a_of_type_Long, l))
      {
        ahxh.jdField_a_of_type_Long = l;
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
        QQWalletRedPacketMsg localQQWalletRedPacketMsg = localMessageForQQWalletMsg.mQQWalletRedPacketMsg;
        akqe localakqe = (akqe)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
        if (nty.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))
        {
          localakqe.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 11);
          if (QLog.isColorLevel()) {
            QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
          }
        }
        else
        {
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1)
          {
            localObject = (bgkf)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
            boolean bool = ((bgkf)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            localObject = ((bgkf)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, false);
            if ((bool) || ((localObject != null) && (((bgkl)localObject).jdField_a_of_type_Boolean)))
            {
              localakqe.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 11);
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("PasswdRedBagManager", 2, "current is in TroopMemberGag, dont show passwdredbag tips");
              continue;
            }
          }
          Object localObject = localakqe.a(localQQWalletRedPacketMsg.redPacketId);
          l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
          if ((localObject != null) && ((((akqd)localObject).jdField_a_of_type_Boolean) || (((akqd)localObject).b) || (((akqd)localObject).c) || (((akqd)localObject).jdField_a_of_type_Long < l)))
          {
            localakqe.a(localQQWalletRedPacketMsg.redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
            l = VACDReportUtil.a(null, "qqwallet", "graphb", "draw.click", "msgType=" + localMessageForQQWalletMsg.messageType, 0, null);
            Bundle localBundle = new Bundle();
            localBundle.putInt("subchannel", localQQWalletRedPacketMsg.body.subChannel);
            localakqe.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (akqd)localObject, l, 1000001, "", localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId, localMessageForQQWalletMsg.fromHBList, localBundle);
            if (QLog.isColorLevel()) {
              QLog.d("PasswdRedBagManager", 2, "click open draw redpacket, isPasswdRedBagOpen=" + ((akqd)localObject).jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + ((akqd)localObject).b + ",isPasswdRedBagOverDue=" + ((akqd)localObject).c);
            }
          }
          else
          {
            DrawRedpacketPannelPreviewFragment.a(paramView.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, localMessageForQQWalletMsg);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxk
 * JD-Core Version:    0.7.0.1
 */