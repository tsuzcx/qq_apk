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

class aelg
  implements View.OnClickListener
{
  aelg(aela paramaela) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    do
    {
      Object localObject;
      agvx localagvx;
      agvw localagvw;
      do
      {
        do
        {
          do
          {
            return;
            if (this.a.jdField_a_of_type_Agyt != null) {
              this.a.jdField_a_of_type_Agyt.a(1);
            }
            l = System.currentTimeMillis();
          } while (!ahiv.a(aela.jdField_a_of_type_Long, l));
          aela.jdField_a_of_type_Long = l;
          localObject = (MessageForQQWalletMsg)paramView.getTag();
          paramView = ((MessageForQQWalletMsg)localObject).mQQWalletRedPacketMsg;
          localagvx = (agvx)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125);
          if (!myb.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localagvx.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1);
        } while (!QLog.isColorLevel());
        QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
        return;
        localagvw = localagvx.a(paramView.redPacketId);
        long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
        if ((localagvw == null) || ((!localagvw.jdField_a_of_type_Boolean) && (!localagvw.b) && (!localagvw.c) && (localagvw.jdField_a_of_type_Long >= l))) {
          break;
        }
        localagvx.a(paramView.redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=6", 0, null);
        localagvx.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localagvw, l, ((MessageForQQWalletMsg)localObject).fromHBList);
        localagvx.a(paramView.redPacketId, true);
      } while (!QLog.isColorLevel());
      QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + localagvw.jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + localagvw.b + ",isPasswdRedBagOverDue=" + localagvw.c);
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
      {
        localObject = (adiw)this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(27);
        if (localObject != null) {
          ((adiw)localObject).a(paramView.redPacketId, paramView.elem.title, ajya.a(2131711189));
        }
      }
      localagvx.a(paramView.redPacketId, false);
    } while (!QLog.isColorLevel());
    QLog.d("PasswdRedBagManager", 2, "show passwdredbag tips = " + paramView.elem.title);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aelg
 * JD-Core Version:    0.7.0.1
 */