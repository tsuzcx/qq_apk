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

class aelj
  implements View.OnClickListener
{
  aelj(aelc paramaelc) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    for (;;)
    {
      return;
      if (this.a.jdField_a_of_type_Agyv != null) {
        this.a.jdField_a_of_type_Agyv.a(10);
      }
      long l = System.currentTimeMillis();
      if (!ahix.a(aelc.jdField_a_of_type_Long, l)) {
        continue;
      }
      aelc.jdField_a_of_type_Long = l;
      Object localObject2 = (MessageForQQWalletMsg)paramView.getTag();
      paramView = ((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg;
      agvz localagvz = (agvz)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125);
      if (mye.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        localagvz.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 10);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
        return;
      }
      Object localObject1 = localagvz.a(paramView.redPacketId);
      l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
      if ((localObject1 != null) && ((((agvy)localObject1).jdField_a_of_type_Boolean) || (((agvy)localObject1).b) || (((agvy)localObject1).c) || (((agvy)localObject1).jdField_a_of_type_Long < l)))
      {
        localagvz.a(paramView.redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=6", 0, null);
        localagvz.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (agvy)localObject1, l, ((MessageForQQWalletMsg)localObject2).fromHBList, null);
        localagvz.a(paramView.redPacketId, true);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + ((agvy)localObject1).jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + ((agvy)localObject1).b + ",isPasswdRedBagOverDue=" + ((agvy)localObject1).c);
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
      {
        localObject2 = (adiy)this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(27);
        if ((localObject2 != null) && (localObject1 != null)) {
          ((adiy)localObject2).b(paramView.redPacketId, localagvz.a(((agvy)localObject1).e), ajyc.a(2131711164));
        }
      }
      try
      {
        localObject1 = new ArrayList(1);
        ((ArrayList)localObject1).add(paramView.redPacketId);
        localagvz.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (ArrayList)localObject1);
        label421:
        localagvz.a(paramView.redPacketId, false);
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
 * Qualified Name:     aelj
 * JD-Core Version:    0.7.0.1
 */