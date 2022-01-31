import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aeak
  implements View.OnClickListener
{
  aeak(aead paramaead) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    for (;;)
    {
      return;
      if (this.a.jdField_a_of_type_Agmg != null) {
        this.a.jdField_a_of_type_Agmg.a(10);
      }
      long l = System.currentTimeMillis();
      if (!agwi.a(aead.jdField_a_of_type_Long, l)) {
        continue;
      }
      aead.jdField_a_of_type_Long = l;
      Object localObject2 = (MessageForQQWalletMsg)paramView.getTag();
      paramView = ((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg;
      agjk localagjk = (agjk)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125);
      if (mnf.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        localagjk.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 10);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
        return;
      }
      Object localObject1 = localagjk.a(paramView.redPacketId);
      l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
      if ((localObject1 != null) && ((((agjj)localObject1).jdField_a_of_type_Boolean) || (((agjj)localObject1).b) || (((agjj)localObject1).c) || (((agjj)localObject1).jdField_a_of_type_Long < l)))
      {
        localagjk.a(paramView.redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=6", 0, null);
        localagjk.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (agjj)localObject1, l, ((MessageForQQWalletMsg)localObject2).fromHBList, null);
        localagjk.a(paramView.redPacketId, true);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + ((agjj)localObject1).jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + ((agjj)localObject1).b + ",isPasswdRedBagOverDue=" + ((agjj)localObject1).c);
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
      {
        localObject2 = (acxx)this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(27);
        if ((localObject2 != null) && (localObject1 != null)) {
          ((acxx)localObject2).b(paramView.redPacketId, localagjk.a(((agjj)localObject1).e), ajjy.a(2131645376));
        }
      }
      try
      {
        localObject1 = new ArrayList(1);
        ((ArrayList)localObject1).add(paramView.redPacketId);
        localagjk.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (ArrayList)localObject1);
        label421:
        localagjk.a(paramView.redPacketId, false);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PasswdRedBagManager", 2, "show passwdredbag tips = " + paramView.elem.title);
        return;
      }
      catch (Throwable localThrowable)
      {
        break label421;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeak
 * JD-Core Version:    0.7.0.1
 */