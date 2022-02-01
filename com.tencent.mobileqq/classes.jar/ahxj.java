import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahxj
  implements View.OnClickListener
{
  ahxj(ahxh paramahxh) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_Akto != null) {
        this.a.jdField_a_of_type_Akto.a(9);
      }
      long l = System.currentTimeMillis();
      if (albv.a(ahxh.jdField_a_of_type_Long, l))
      {
        ahxh.jdField_a_of_type_Long = l;
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
        Object localObject1 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg;
        akqe localakqe = (akqe)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
        if (nty.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))
        {
          localakqe.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 9);
          if (QLog.isColorLevel()) {
            QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
          }
        }
        else
        {
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1)
          {
            localObject2 = (bgkf)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
            boolean bool = ((bgkf)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            localObject2 = ((bgkf)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, false);
            if ((bool) || ((localObject2 != null) && (((bgkl)localObject2).jdField_a_of_type_Boolean)))
            {
              localakqe.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 9);
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("PasswdRedBagManager", 2, "current is in TroopMemberGag, dont show passwdredbag tips");
              continue;
            }
          }
          Object localObject2 = localakqe.a(((QQWalletRedPacketMsg)localObject1).redPacketId);
          l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
          if ((localObject2 != null) && ((((akqd)localObject2).jdField_a_of_type_Boolean) || (((akqd)localObject2).b) || (((akqd)localObject2).c) || (((akqd)localObject2).jdField_a_of_type_Long < l)))
          {
            localakqe.a(((QQWalletRedPacketMsg)localObject1).redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
            l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=19", 0, null);
            localObject1 = alcm.b(localMessageForQQWalletMsg);
            Bundle localBundle = new Bundle();
            localBundle.putString("feedsid", localMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.feedId);
            localakqe.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (akqd)localObject2, l, 262144, (String)localObject1, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId, localMessageForQQWalletMsg.fromHBList, localBundle);
            if (QLog.isColorLevel()) {
              QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + ((akqd)localObject2).jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + ((akqd)localObject2).b + ",isPasswdRedBagOverDue=" + ((akqd)localObject2).c);
            }
          }
          else
          {
            QQToast.a(paramView.getContext(), "当前平台版本暂不支持抢该类型红包", 0).a();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxj
 * JD-Core Version:    0.7.0.1
 */