import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
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
import java.util.ArrayList;

class ahxo
  implements View.OnClickListener
{
  ahxo(ahxh paramahxh) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_Akto != null) {
        this.a.jdField_a_of_type_Akto.a(10);
      }
      long l = System.currentTimeMillis();
      if (!albv.a(ahxh.jdField_a_of_type_Long, l)) {
        continue;
      }
      ahxh.jdField_a_of_type_Long = l;
      Object localObject2 = (MessageForQQWalletMsg)paramView.getTag();
      QQWalletRedPacketMsg localQQWalletRedPacketMsg = ((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg;
      akqe localakqe = (akqe)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
      if (nty.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))
      {
        localakqe.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 10);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
        continue;
      }
      Object localObject1 = localakqe.a(localQQWalletRedPacketMsg.redPacketId);
      l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
      if ((localObject1 != null) && ((((akqd)localObject1).jdField_a_of_type_Boolean) || (((akqd)localObject1).b) || (((akqd)localObject1).c) || (((akqd)localObject1).jdField_a_of_type_Long < l)))
      {
        localakqe.a(localQQWalletRedPacketMsg.redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
        l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=" + ((MessageForQQWalletMsg)localObject2).messageType, 0, null);
        Bundle localBundle = new Bundle();
        localBundle.putInt("subchannel", localQQWalletRedPacketMsg.body.subChannel);
        localakqe.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (akqd)localObject1, l, ((MessageForQQWalletMsg)localObject2).fromHBList, localBundle);
        localakqe.a(localQQWalletRedPacketMsg.redPacketId, true);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + ((akqd)localObject1).jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + ((akqd)localObject1).b + ",isPasswdRedBagOverDue=" + ((akqd)localObject1).c);
        continue;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
      {
        localObject2 = (agjr)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(27);
        if ((localObject2 != null) && (localObject1 != null)) {
          ((agjr)localObject2).a(localQQWalletRedPacketMsg.redPacketId, ((akqd)localObject1).e, localQQWalletRedPacketMsg.body.subChannel);
        }
      }
      try
      {
        localObject1 = new ArrayList(1);
        ((ArrayList)localObject1).add(localQQWalletRedPacketMsg.redPacketId);
        localakqe.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (ArrayList)localObject1);
        label483:
        localakqe.a(localQQWalletRedPacketMsg.redPacketId, false);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PasswdRedBagManager", 2, "show passwdredbag tips = " + localQQWalletRedPacketMsg.elem.title);
      }
      catch (Throwable localThrowable)
      {
        break label483;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxo
 * JD-Core Version:    0.7.0.1
 */