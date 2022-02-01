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

class aigc
  implements View.OnClickListener
{
  aigc(aifz paramaifz) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_Alad != null) {
        this.a.jdField_a_of_type_Alad.a(11);
      }
      long l = System.currentTimeMillis();
      if (alik.a(aifz.jdField_a_of_type_Long, l))
      {
        aifz.jdField_a_of_type_Long = l;
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
        QQWalletRedPacketMsg localQQWalletRedPacketMsg = localMessageForQQWalletMsg.mQQWalletRedPacketMsg;
        akwu localakwu = (akwu)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125);
        if (nlj.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          localakwu.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 11);
          if (QLog.isColorLevel()) {
            QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
          }
        }
        else
        {
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
          {
            localObject = (bgsl)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
            boolean bool = ((bgsl)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            localObject = ((bgsl)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
            if ((bool) || ((localObject != null) && (((bgsr)localObject).jdField_a_of_type_Boolean)))
            {
              localakwu.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 11);
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("PasswdRedBagManager", 2, "current is in TroopMemberGag, dont show passwdredbag tips");
              continue;
            }
          }
          Object localObject = localakwu.a(localQQWalletRedPacketMsg.redPacketId);
          l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
          if ((localObject != null) && ((((akwt)localObject).jdField_a_of_type_Boolean) || (((akwt)localObject).b) || (((akwt)localObject).c) || (((akwt)localObject).jdField_a_of_type_Long < l)))
          {
            localakwu.a(localQQWalletRedPacketMsg.redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            l = VACDReportUtil.a(null, "qqwallet", "graphb", "draw.click", "msgType=" + localMessageForQQWalletMsg.messageType, 0, null);
            Bundle localBundle = new Bundle();
            localBundle.putInt("subchannel", localQQWalletRedPacketMsg.body.subChannel);
            localakwu.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (akwt)localObject, l, 1000001, "", localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId, localMessageForQQWalletMsg.fromHBList, localBundle);
            if (QLog.isColorLevel()) {
              QLog.d("PasswdRedBagManager", 2, "click open draw redpacket, isPasswdRedBagOpen=" + ((akwt)localObject).jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + ((akwt)localObject).b + ",isPasswdRedBagOverDue=" + ((akwt)localObject).c);
            }
          }
          else
          {
            DrawRedpacketPannelPreviewFragment.a(paramView.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localMessageForQQWalletMsg);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aigc
 * JD-Core Version:    0.7.0.1
 */