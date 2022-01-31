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

class aeaj
  implements View.OnClickListener
{
  aeaj(aead paramaead) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    do
    {
      Object localObject;
      agjk localagjk;
      agjj localagjj;
      do
      {
        do
        {
          do
          {
            return;
            if (this.a.jdField_a_of_type_Agmg != null) {
              this.a.jdField_a_of_type_Agmg.a(1);
            }
            l = System.currentTimeMillis();
          } while (!agwi.a(aead.jdField_a_of_type_Long, l));
          aead.jdField_a_of_type_Long = l;
          localObject = (MessageForQQWalletMsg)paramView.getTag();
          paramView = ((MessageForQQWalletMsg)localObject).mQQWalletRedPacketMsg;
          localagjk = (agjk)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125);
          if (!mnf.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localagjk.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1);
        } while (!QLog.isColorLevel());
        QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
        return;
        localagjj = localagjk.a(paramView.redPacketId);
        long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
        if ((localagjj == null) || ((!localagjj.jdField_a_of_type_Boolean) && (!localagjj.b) && (!localagjj.c) && (localagjj.jdField_a_of_type_Long >= l))) {
          break;
        }
        localagjk.a(paramView.redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=6", 0, null);
        localagjk.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localagjj, l, ((MessageForQQWalletMsg)localObject).fromHBList);
        localagjk.a(paramView.redPacketId, true);
      } while (!QLog.isColorLevel());
      QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + localagjj.jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + localagjj.b + ",isPasswdRedBagOverDue=" + localagjj.c);
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
      {
        localObject = (acxx)this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(27);
        if (localObject != null) {
          ((acxx)localObject).a(paramView.redPacketId, paramView.elem.title, ajjy.a(2131645390));
        }
      }
      localagjk.a(paramView.redPacketId, false);
    } while (!QLog.isColorLevel());
    QLog.d("PasswdRedBagManager", 2, "show passwdredbag tips = " + paramView.elem.title);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeaj
 * JD-Core Version:    0.7.0.1
 */