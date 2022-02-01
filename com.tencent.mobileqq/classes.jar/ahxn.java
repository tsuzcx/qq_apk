import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahxn
  implements View.OnClickListener
{
  ahxn(ahxh paramahxh) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_Akto != null) {
        this.a.jdField_a_of_type_Akto.a(1);
      }
      long l = System.currentTimeMillis();
      if (albv.a(ahxh.jdField_a_of_type_Long, l))
      {
        ahxh.jdField_a_of_type_Long = l;
        Object localObject = (MessageForQQWalletMsg)paramView.getTag();
        QQWalletRedPacketMsg localQQWalletRedPacketMsg = ((MessageForQQWalletMsg)localObject).mQQWalletRedPacketMsg;
        akqe localakqe = (akqe)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
        if (nty.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))
        {
          localakqe.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 1);
          if (QLog.isColorLevel()) {
            QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
          }
        }
        else
        {
          akqd localakqd = localakqe.a(localQQWalletRedPacketMsg.redPacketId);
          l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
          if ((localakqd != null) && ((localakqd.jdField_a_of_type_Boolean) || (localakqd.b) || (localakqd.c) || (localakqd.jdField_a_of_type_Long < l)))
          {
            localakqe.a(localQQWalletRedPacketMsg.redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
            l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=6", 0, null);
            localakqe.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localakqd, l, ((MessageForQQWalletMsg)localObject).fromHBList);
            localakqe.a(localQQWalletRedPacketMsg.redPacketId, true);
            if (QLog.isColorLevel()) {
              QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + localakqd.jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + localakqd.b + ",isPasswdRedBagOverDue=" + localakqd.c);
            }
          }
          else
          {
            if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
            {
              localObject = (agjr)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(27);
              if (localObject != null) {
                ((agjr)localObject).a(localQQWalletRedPacketMsg.redPacketId, localQQWalletRedPacketMsg.elem.title, anvx.a(2131710637));
              }
            }
            localakqe.a(localQQWalletRedPacketMsg.redPacketId, false);
            if (QLog.isColorLevel()) {
              QLog.d("PasswdRedBagManager", 2, "show passwdredbag tips = " + localQQWalletRedPacketMsg.elem.title);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxn
 * JD-Core Version:    0.7.0.1
 */