import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class aght
  implements View.OnClickListener
{
  aght(aghr paramaghr) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    MessageForQQWalletMsg localMessageForQQWalletMsg;
    Object localObject2;
    do
    {
      aipw localaipw;
      do
      {
        do
        {
          do
          {
            return;
            if (this.a.jdField_a_of_type_Aist != null) {
              this.a.jdField_a_of_type_Aist.a(9);
            }
            l = System.currentTimeMillis();
          } while (!ajae.a(aghr.jdField_a_of_type_Long, l));
          aghr.jdField_a_of_type_Long = l;
          localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
          localObject1 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg;
          localaipw = (aipw)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125);
          if (!nav.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localaipw.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 9);
        } while (!QLog.isColorLevel());
        QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
        return;
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
          break;
        }
        localObject2 = (bcjl)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
        boolean bool = ((bcjl)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localObject2 = ((bcjl)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
        if ((!bool) && ((localObject2 == null) || (!((bcjr)localObject2).jdField_a_of_type_Boolean))) {
          break;
        }
        localaipw.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 9);
      } while (!QLog.isColorLevel());
      QLog.d("PasswdRedBagManager", 2, "current is in TroopMemberGag, dont show passwdredbag tips");
      return;
      localObject2 = localaipw.a(((QQWalletRedPacketMsg)localObject1).redPacketId);
      long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
      if ((localObject2 == null) || ((!((aipv)localObject2).jdField_a_of_type_Boolean) && (!((aipv)localObject2).b) && (!((aipv)localObject2).c) && (((aipv)localObject2).jdField_a_of_type_Long >= l))) {
        break;
      }
      localaipw.a(((QQWalletRedPacketMsg)localObject1).redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=19", 0, null);
      paramView = ajat.b(localMessageForQQWalletMsg);
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putString("feedsid", localMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.feedId);
      localaipw.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (aipv)localObject2, l, 262144, paramView, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId, localMessageForQQWalletMsg.fromHBList, (Bundle)localObject1);
    } while (!QLog.isColorLevel());
    QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + ((aipv)localObject2).jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + ((aipv)localObject2).b + ",isPasswdRedBagOverDue=" + ((aipv)localObject2).c);
    return;
    RedPacketEmojiFragment.a(paramView.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localMessageForQQWalletMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aght
 * JD-Core Version:    0.7.0.1
 */