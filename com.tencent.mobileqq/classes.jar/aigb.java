import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aigb
  implements View.OnClickListener
{
  aigb(aifz paramaifz) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_Alad != null) {
        this.a.jdField_a_of_type_Alad.a(9);
      }
      long l = System.currentTimeMillis();
      if (alik.a(aifz.jdField_a_of_type_Long, l))
      {
        aifz.jdField_a_of_type_Long = l;
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
        Object localObject1 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg;
        akwu localakwu = (akwu)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125);
        if (nlj.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          localakwu.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 9);
          if (QLog.isColorLevel()) {
            QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
          }
        }
        else
        {
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
          {
            localObject2 = (bgsl)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
            boolean bool = ((bgsl)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            localObject2 = ((bgsl)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
            if ((bool) || ((localObject2 != null) && (((bgsr)localObject2).jdField_a_of_type_Boolean)))
            {
              localakwu.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 9);
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("PasswdRedBagManager", 2, "current is in TroopMemberGag, dont show passwdredbag tips");
              continue;
            }
          }
          Object localObject2 = localakwu.a(((QQWalletRedPacketMsg)localObject1).redPacketId);
          l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
          if ((localObject2 != null) && ((((akwt)localObject2).jdField_a_of_type_Boolean) || (((akwt)localObject2).b) || (((akwt)localObject2).c) || (((akwt)localObject2).jdField_a_of_type_Long < l)))
          {
            localakwu.a(((QQWalletRedPacketMsg)localObject1).redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=19", 0, null);
            localObject1 = aljb.b(localMessageForQQWalletMsg);
            Bundle localBundle = new Bundle();
            localBundle.putString("feedsid", localMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.feedId);
            localakwu.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (akwt)localObject2, l, 262144, (String)localObject1, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId, localMessageForQQWalletMsg.fromHBList, localBundle);
            if (QLog.isColorLevel()) {
              QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + ((akwt)localObject2).jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + ((akwt)localObject2).b + ",isPasswdRedBagOverDue=" + ((akwt)localObject2).c);
            }
          }
          else
          {
            RedPacketEmojiFragment.a(paramView.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localMessageForQQWalletMsg);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aigb
 * JD-Core Version:    0.7.0.1
 */