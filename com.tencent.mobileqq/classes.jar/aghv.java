import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class aghv
  implements View.OnClickListener
{
  aghv(aghr paramaghr) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    Object localObject1;
    do
    {
      MessageForQQWalletMsg localMessageForQQWalletMsg;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (this.a.jdField_a_of_type_Aist != null) {
                this.a.jdField_a_of_type_Aist.a(8);
              }
              l = System.currentTimeMillis();
            } while (!ajae.a(aghr.jdField_a_of_type_Long, l));
            aghr.jdField_a_of_type_Long = l;
            localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
            localObject1 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg;
            localObject2 = (aipw)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125);
            if (!nav.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
              break;
            }
            ((aipw)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 8);
          } while (!QLog.isColorLevel());
          QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
          return;
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
            break;
          }
          localObject3 = (bcjl)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
          boolean bool = ((bcjl)localObject3).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          localObject3 = ((bcjl)localObject3).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
          if ((!bool) && ((localObject3 == null) || (!((bcjr)localObject3).jdField_a_of_type_Boolean))) {
            break;
          }
          ((aipw)localObject2).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 8);
        } while (!QLog.isColorLevel());
        QLog.d("PasswdRedBagManager", 2, "current is in TroopMemberGag, dont show passwdredbag tips");
        return;
        localObject3 = ((aipw)localObject2).a(((QQWalletRedPacketMsg)localObject1).redPacketId);
        long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
        if ((localObject3 == null) || ((!((aipv)localObject3).jdField_a_of_type_Boolean) && (!((aipv)localObject3).b) && (!((aipv)localObject3).c) && (((aipv)localObject3).jdField_a_of_type_Long >= l))) {
          break;
        }
        ((aipw)localObject2).a(((QQWalletRedPacketMsg)localObject1).redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=18", 0, null);
        paramView = ajat.b(localMessageForQQWalletMsg);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("feedsid", ajat.a(localMessageForQQWalletMsg));
        ((aipw)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (aipv)localObject3, l, 131072, paramView, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId, localMessageForQQWalletMsg.fromHBList, (Bundle)localObject1);
      } while (!QLog.isColorLevel());
      QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + ((aipv)localObject3).jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + ((aipv)localObject3).b + ",isPasswdRedBagOverDue=" + ((aipv)localObject3).c);
      return;
      Object localObject2 = new Intent();
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
        ((Intent)localObject2).putExtra("session", this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      ((Intent)localObject2).putExtra("uniseq", localMessageForQQWalletMsg.uniseq);
      ((Intent)localObject2).putExtra("public_fragment_window_feature", 1);
      Object localObject3 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId;
      Object localObject4 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.authkey;
      Object localObject5 = ajae.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      int j = ((Bundle)localObject5).getInt("groupType");
      localObject5 = ((Bundle)localObject5).getString("name");
      int i = 0;
      if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem != null) {
        i = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.resourceType;
      }
      localObject3 = ajae.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, j, (String)localObject5, (String)localObject3, (String)localObject4, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "appid#1344242394|bargainor_id#1000030201|channel#detailtips", "redgiftDetail", null, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redChannel, i, localMessageForQQWalletMsg.fromHBList);
      localObject4 = new Bundle();
      ((Bundle)localObject4).putString("json", ((JSONObject)localObject3).toString());
      ((Bundle)localObject4).putString("callbackSn", "0");
      ((Intent)localObject2).putExtra("fromHBList", localMessageForQQWalletMsg.fromHBList);
      ((Intent)localObject2).putExtra("redPacketId", localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
      if (!(paramView.getContext() instanceof Activity)) {
        ((Intent)localObject2).addFlags(268435456);
      }
      adky.a(paramView.getContext(), (Intent)localObject2, PublicTransFragmentActivity.class, RedPacketKSongFragment.class);
    } while (!QLog.isColorLevel());
    QLog.d("PasswdRedBagManager", 2, "show passwdredbag ksong tips = " + ((QQWalletRedPacketMsg)localObject1).elem.title);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aghv
 * JD-Core Version:    0.7.0.1
 */