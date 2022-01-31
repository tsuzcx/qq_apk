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

class aelh
  implements View.OnClickListener
{
  aelh(aela paramaela) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    for (;;)
    {
      return;
      if (this.a.jdField_a_of_type_Agyt != null) {
        this.a.jdField_a_of_type_Agyt.a(10);
      }
      long l = System.currentTimeMillis();
      if (!ahiv.a(aela.jdField_a_of_type_Long, l)) {
        continue;
      }
      aela.jdField_a_of_type_Long = l;
      Object localObject2 = (MessageForQQWalletMsg)paramView.getTag();
      paramView = ((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg;
      agvx localagvx = (agvx)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125);
      if (myb.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        localagvx.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 10);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
        return;
      }
      Object localObject1 = localagvx.a(paramView.redPacketId);
      l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
      if ((localObject1 != null) && ((((agvw)localObject1).jdField_a_of_type_Boolean) || (((agvw)localObject1).b) || (((agvw)localObject1).c) || (((agvw)localObject1).jdField_a_of_type_Long < l)))
      {
        localagvx.a(paramView.redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=6", 0, null);
        localagvx.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (agvw)localObject1, l, ((MessageForQQWalletMsg)localObject2).fromHBList, null);
        localagvx.a(paramView.redPacketId, true);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + ((agvw)localObject1).jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + ((agvw)localObject1).b + ",isPasswdRedBagOverDue=" + ((agvw)localObject1).c);
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
      {
        localObject2 = (adiw)this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(27);
        if ((localObject2 != null) && (localObject1 != null)) {
          ((adiw)localObject2).b(paramView.redPacketId, localagvx.a(((agvw)localObject1).e), ajya.a(2131711175));
        }
      }
      try
      {
        localObject1 = new ArrayList(1);
        ((ArrayList)localObject1).add(paramView.redPacketId);
        localagvx.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (ArrayList)localObject1);
        label421:
        localagvx.a(paramView.redPacketId, false);
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
 * Qualified Name:     aelh
 * JD-Core Version:    0.7.0.1
 */