import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class agmn
  implements View.OnClickListener
{
  agmn(agmg paramagmg) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    for (;;)
    {
      return;
      if (this.a.jdField_a_of_type_Aixi != null) {
        this.a.jdField_a_of_type_Aixi.a(10);
      }
      long l = System.currentTimeMillis();
      if (!ajet.a(agmg.jdField_a_of_type_Long, l)) {
        continue;
      }
      agmg.jdField_a_of_type_Long = l;
      Object localObject2 = (MessageForQQWalletMsg)paramView.getTag();
      paramView = ((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg;
      aiul localaiul = (aiul)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125);
      if (nav.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        localaiul.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 10);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
        return;
      }
      Object localObject1 = localaiul.a(paramView.redPacketId);
      l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
      if ((localObject1 != null) && ((((aiuk)localObject1).jdField_a_of_type_Boolean) || (((aiuk)localObject1).b) || (((aiuk)localObject1).c) || (((aiuk)localObject1).jdField_a_of_type_Long < l)))
      {
        localaiul.a(paramView.redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=6", 0, null);
        localaiul.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (aiuk)localObject1, l, ((MessageForQQWalletMsg)localObject2).fromHBList, null);
        localaiul.a(paramView.redPacketId, true);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + ((aiuk)localObject1).jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + ((aiuk)localObject1).b + ",isPasswdRedBagOverDue=" + ((aiuk)localObject1).c);
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
      {
        localObject2 = (afft)this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(27);
        if ((localObject2 != null) && (localObject1 != null)) {
          ((afft)localObject2).a(paramView.redPacketId, localaiul.a(((aiuk)localObject1).e), agmg.a(paramView.body.subChannel), paramView.body.subChannel);
        }
      }
      try
      {
        localObject1 = new ArrayList(1);
        ((ArrayList)localObject1).add(paramView.redPacketId);
        localaiul.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (ArrayList)localObject1);
        label433:
        localaiul.a(paramView.redPacketId, false);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PasswdRedBagManager", 2, "show passwdredbag tips = " + paramView.elem.title);
        return;
      }
      catch (Throwable localThrowable)
      {
        break label433;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmn
 * JD-Core Version:    0.7.0.1
 */