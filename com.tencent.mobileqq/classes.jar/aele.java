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

class aele
  implements View.OnClickListener
{
  aele(aelc paramaelc) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    MessageForQQWalletMsg localMessageForQQWalletMsg;
    Object localObject2;
    do
    {
      agvz localagvz;
      do
      {
        do
        {
          do
          {
            return;
            if (this.a.jdField_a_of_type_Agyv != null) {
              this.a.jdField_a_of_type_Agyv.a(9);
            }
            l = System.currentTimeMillis();
          } while (!ahix.a(aelc.jdField_a_of_type_Long, l));
          aelc.jdField_a_of_type_Long = l;
          localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
          localObject1 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg;
          localagvz = (agvz)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125);
          if (!mye.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localagvz.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 9);
        } while (!QLog.isColorLevel());
        QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
        return;
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
          break;
        }
        localObject2 = (bakk)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
        boolean bool = ((bakk)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localObject2 = ((bakk)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
        if ((!bool) && ((localObject2 == null) || (!((bakq)localObject2).jdField_a_of_type_Boolean))) {
          break;
        }
        localagvz.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 9);
      } while (!QLog.isColorLevel());
      QLog.d("PasswdRedBagManager", 2, "current is in TroopMemberGag, dont show passwdredbag tips");
      return;
      localObject2 = localagvz.a(((QQWalletRedPacketMsg)localObject1).redPacketId);
      long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
      if ((localObject2 == null) || ((!((agvy)localObject2).jdField_a_of_type_Boolean) && (!((agvy)localObject2).b) && (!((agvy)localObject2).c) && (((agvy)localObject2).jdField_a_of_type_Long >= l))) {
        break;
      }
      localagvz.a(((QQWalletRedPacketMsg)localObject1).redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=19", 0, null);
      paramView = ahjm.b(localMessageForQQWalletMsg);
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putString("feedsid", localMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.feedId);
      localagvz.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (agvy)localObject2, l, 262144, paramView, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId, localMessageForQQWalletMsg.fromHBList, (Bundle)localObject1);
    } while (!QLog.isColorLevel());
    QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + ((agvy)localObject2).jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + ((agvy)localObject2).b + ",isPasswdRedBagOverDue=" + ((agvy)localObject2).c);
    return;
    RedPacketEmojiFragment.a(paramView.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localMessageForQQWalletMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aele
 * JD-Core Version:    0.7.0.1
 */