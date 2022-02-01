import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahcs
  implements View.OnClickListener
{
  ahcs(ahcp paramahcp) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_Ajxv != null) {
        this.a.jdField_a_of_type_Ajxv.a(11);
      }
      long l = System.currentTimeMillis();
      if (akgc.a(ahcp.jdField_a_of_type_Long, l))
      {
        ahcp.jdField_a_of_type_Long = l;
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
        QQWalletRedPacketMsg localQQWalletRedPacketMsg = localMessageForQQWalletMsg.mQQWalletRedPacketMsg;
        ajul localajul = (ajul)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125);
        if (nmy.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))
        {
          localajul.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 11);
          if (QLog.isColorLevel()) {
            QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
          }
        }
        else
        {
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1)
          {
            localObject = (bfbz)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
            boolean bool = ((bfbz)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            localObject = ((bfbz)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, false);
            if ((bool) || ((localObject != null) && (((bfcf)localObject).jdField_a_of_type_Boolean)))
            {
              localajul.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 11);
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("PasswdRedBagManager", 2, "current is in TroopMemberGag, dont show passwdredbag tips");
              continue;
            }
          }
          Object localObject = localajul.a(localQQWalletRedPacketMsg.redPacketId);
          l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
          if ((localObject != null) && ((((ajuk)localObject).jdField_a_of_type_Boolean) || (((ajuk)localObject).b) || (((ajuk)localObject).c) || (((ajuk)localObject).jdField_a_of_type_Long < l)))
          {
            localajul.a(localQQWalletRedPacketMsg.redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
            l = VACDReportUtil.a(null, "qqwallet", "graphb", "draw.click", "msgType=" + localMessageForQQWalletMsg.messageType, 0, null);
            Bundle localBundle = new Bundle();
            localBundle.putInt("subchannel", localQQWalletRedPacketMsg.body.subChannel);
            localajul.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (ajuk)localObject, l, 1000001, "", localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId, localMessageForQQWalletMsg.fromHBList, localBundle);
            if (QLog.isColorLevel()) {
              QLog.d("PasswdRedBagManager", 2, "click open draw redpacket, isPasswdRedBagOpen=" + ((ajuk)localObject).jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + ((ajuk)localObject).b + ",isPasswdRedBagOverDue=" + ((ajuk)localObject).c);
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
 * Qualified Name:     ahcs
 * JD-Core Version:    0.7.0.1
 */