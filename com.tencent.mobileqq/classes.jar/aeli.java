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

class aeli
  implements View.OnClickListener
{
  aeli(aelc paramaelc) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    do
    {
      Object localObject;
      agvz localagvz;
      agvy localagvy;
      do
      {
        do
        {
          do
          {
            return;
            if (this.a.jdField_a_of_type_Agyv != null) {
              this.a.jdField_a_of_type_Agyv.a(1);
            }
            l = System.currentTimeMillis();
          } while (!ahix.a(aelc.jdField_a_of_type_Long, l));
          aelc.jdField_a_of_type_Long = l;
          localObject = (MessageForQQWalletMsg)paramView.getTag();
          paramView = ((MessageForQQWalletMsg)localObject).mQQWalletRedPacketMsg;
          localagvz = (agvz)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125);
          if (!mye.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localagvz.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1);
        } while (!QLog.isColorLevel());
        QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
        return;
        localagvy = localagvz.a(paramView.redPacketId);
        long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
        if ((localagvy == null) || ((!localagvy.jdField_a_of_type_Boolean) && (!localagvy.b) && (!localagvy.c) && (localagvy.jdField_a_of_type_Long >= l))) {
          break;
        }
        localagvz.a(paramView.redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=6", 0, null);
        localagvz.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localagvy, l, ((MessageForQQWalletMsg)localObject).fromHBList);
        localagvz.a(paramView.redPacketId, true);
      } while (!QLog.isColorLevel());
      QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + localagvy.jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + localagvy.b + ",isPasswdRedBagOverDue=" + localagvy.c);
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
      {
        localObject = (adiy)this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(27);
        if (localObject != null) {
          ((adiy)localObject).a(paramView.redPacketId, paramView.elem.title, ajyc.a(2131711178));
        }
      }
      localagvz.a(paramView.redPacketId, false);
    } while (!QLog.isColorLevel());
    QLog.d("PasswdRedBagManager", 2, "show passwdredbag tips = " + paramView.elem.title);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeli
 * JD-Core Version:    0.7.0.1
 */