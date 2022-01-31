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

class aghx
  implements View.OnClickListener
{
  aghx(aghr paramaghr) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    do
    {
      Object localObject;
      aipw localaipw;
      aipv localaipv;
      do
      {
        do
        {
          do
          {
            return;
            if (this.a.jdField_a_of_type_Aist != null) {
              this.a.jdField_a_of_type_Aist.a(1);
            }
            l = System.currentTimeMillis();
          } while (!ajae.a(aghr.jdField_a_of_type_Long, l));
          aghr.jdField_a_of_type_Long = l;
          localObject = (MessageForQQWalletMsg)paramView.getTag();
          paramView = ((MessageForQQWalletMsg)localObject).mQQWalletRedPacketMsg;
          localaipw = (aipw)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125);
          if (!nav.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localaipw.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1);
        } while (!QLog.isColorLevel());
        QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
        return;
        localaipv = localaipw.a(paramView.redPacketId);
        long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
        if ((localaipv == null) || ((!localaipv.jdField_a_of_type_Boolean) && (!localaipv.b) && (!localaipv.c) && (localaipv.jdField_a_of_type_Long >= l))) {
          break;
        }
        localaipw.a(paramView.redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=6", 0, null);
        localaipw.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localaipv, l, ((MessageForQQWalletMsg)localObject).fromHBList);
        localaipw.a(paramView.redPacketId, true);
      } while (!QLog.isColorLevel());
      QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + localaipv.jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + localaipv.b + ",isPasswdRedBagOverDue=" + localaipv.c);
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
      {
        localObject = (afbe)this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(27);
        if (localObject != null) {
          ((afbe)localObject).a(paramView.redPacketId, paramView.elem.title, alpo.a(2131711561));
        }
      }
      localaipw.a(paramView.redPacketId, false);
    } while (!QLog.isColorLevel());
    QLog.d("PasswdRedBagManager", 2, "show passwdredbag tips = " + paramView.elem.title);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aghx
 * JD-Core Version:    0.7.0.1
 */