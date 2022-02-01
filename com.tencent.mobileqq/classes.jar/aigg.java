import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class aigg
  implements View.OnClickListener
{
  aigg(aifz paramaifz) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_Alad != null) {
        this.a.jdField_a_of_type_Alad.a(10);
      }
      long l = System.currentTimeMillis();
      if (!alik.a(aifz.jdField_a_of_type_Long, l)) {
        continue;
      }
      aifz.jdField_a_of_type_Long = l;
      Object localObject2 = (MessageForQQWalletMsg)paramView.getTag();
      QQWalletRedPacketMsg localQQWalletRedPacketMsg = ((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg;
      akwu localakwu = (akwu)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125);
      if (nlj.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        localakwu.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 10);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
        continue;
      }
      Object localObject1 = localakwu.a(localQQWalletRedPacketMsg.redPacketId);
      l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
      if ((localObject1 != null) && ((((akwt)localObject1).jdField_a_of_type_Boolean) || (((akwt)localObject1).b) || (((akwt)localObject1).c) || (((akwt)localObject1).jdField_a_of_type_Long < l)))
      {
        localakwu.a(localQQWalletRedPacketMsg.redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=" + ((MessageForQQWalletMsg)localObject2).messageType, 0, null);
        Bundle localBundle = new Bundle();
        localBundle.putInt("subchannel", localQQWalletRedPacketMsg.body.subChannel);
        localakwu.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (akwt)localObject1, l, ((MessageForQQWalletMsg)localObject2).fromHBList, localBundle);
        localakwu.a(localQQWalletRedPacketMsg.redPacketId, true);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + ((akwt)localObject1).jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + ((akwt)localObject1).b + ",isPasswdRedBagOverDue=" + ((akwt)localObject1).c);
        continue;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
      {
        localObject2 = (agvx)this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(27);
        if ((localObject2 != null) && (localObject1 != null)) {
          ((agvx)localObject2).a(localQQWalletRedPacketMsg.redPacketId, ((akwt)localObject1).e, localQQWalletRedPacketMsg.body.subChannel);
        }
      }
      try
      {
        localObject1 = new ArrayList(1);
        ((ArrayList)localObject1).add(localQQWalletRedPacketMsg.redPacketId);
        localakwu.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (ArrayList)localObject1);
        label482:
        localakwu.a(localQQWalletRedPacketMsg.redPacketId, false);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PasswdRedBagManager", 2, "show passwdredbag tips = " + localQQWalletRedPacketMsg.elem.title);
      }
      catch (Throwable localThrowable)
      {
        break label482;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aigg
 * JD-Core Version:    0.7.0.1
 */