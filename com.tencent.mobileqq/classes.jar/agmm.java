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

class agmm
  implements View.OnClickListener
{
  agmm(agmg paramagmg) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    do
    {
      Object localObject;
      aiul localaiul;
      aiuk localaiuk;
      do
      {
        do
        {
          do
          {
            return;
            if (this.a.jdField_a_of_type_Aixi != null) {
              this.a.jdField_a_of_type_Aixi.a(1);
            }
            l = System.currentTimeMillis();
          } while (!ajet.a(agmg.jdField_a_of_type_Long, l));
          agmg.jdField_a_of_type_Long = l;
          localObject = (MessageForQQWalletMsg)paramView.getTag();
          paramView = ((MessageForQQWalletMsg)localObject).mQQWalletRedPacketMsg;
          localaiul = (aiul)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125);
          if (!nav.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localaiul.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1);
        } while (!QLog.isColorLevel());
        QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
        return;
        localaiuk = localaiul.a(paramView.redPacketId);
        long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
        if ((localaiuk == null) || ((!localaiuk.jdField_a_of_type_Boolean) && (!localaiuk.b) && (!localaiuk.c) && (localaiuk.jdField_a_of_type_Long >= l))) {
          break;
        }
        localaiul.a(paramView.redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=6", 0, null);
        localaiul.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localaiuk, l, ((MessageForQQWalletMsg)localObject).fromHBList);
        localaiul.a(paramView.redPacketId, true);
      } while (!QLog.isColorLevel());
      QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + localaiuk.jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + localaiuk.b + ",isPasswdRedBagOverDue=" + localaiuk.c);
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
      {
        localObject = (afft)this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(27);
        if (localObject != null) {
          ((afft)localObject).a(paramView.redPacketId, paramView.elem.title, alud.a(2131711573));
        }
      }
      localaiul.a(paramView.redPacketId, false);
    } while (!QLog.isColorLevel());
    QLog.d("PasswdRedBagManager", 2, "show passwdredbag tips = " + paramView.elem.title);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmm
 * JD-Core Version:    0.7.0.1
 */