import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.RedPacketVoiceFragment;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class aelf
  implements View.OnClickListener
{
  aelf(aela paramaela) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    QQWalletRedPacketMsg localQQWalletRedPacketMsg;
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
              if (this.a.jdField_a_of_type_Agyt != null) {
                this.a.jdField_a_of_type_Agyt.a(2);
              }
              l = System.currentTimeMillis();
            } while (!ahiv.a(aela.jdField_a_of_type_Long, l));
            aela.jdField_a_of_type_Long = l;
            localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
            localQQWalletRedPacketMsg = localMessageForQQWalletMsg.mQQWalletRedPacketMsg;
            localObject1 = (agvx)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125);
            if (!myb.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
              break;
            }
            ((agvx)localObject1).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 2);
          } while (!QLog.isColorLevel());
          QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
          return;
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
            break;
          }
          localObject2 = (baky)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
          boolean bool = ((baky)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          localObject2 = ((baky)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
          if ((!bool) && ((localObject2 == null) || (!((bale)localObject2).jdField_a_of_type_Boolean))) {
            break;
          }
          ((agvx)localObject1).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 2);
        } while (!QLog.isColorLevel());
        QLog.d("PasswdRedBagManager", 2, "current is in TroopMemberGag, dont show passwdredbag tips");
        return;
        localObject2 = ((agvx)localObject1).a(localQQWalletRedPacketMsg.redPacketId);
        long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
        if ((localObject2 == null) || ((!((agvw)localObject2).jdField_a_of_type_Boolean) && (!((agvw)localObject2).b) && (!((agvw)localObject2).c) && (((agvw)localObject2).jdField_a_of_type_Long >= l))) {
          break;
        }
        ((agvx)localObject1).a(localQQWalletRedPacketMsg.redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=13", 0, null);
        paramView = ahjk.b(localMessageForQQWalletMsg);
        ((agvx)localObject1).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (agvw)localObject2, l, 65536, paramView, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId, localMessageForQQWalletMsg.fromHBList, null);
      } while (!QLog.isColorLevel());
      QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + ((agvw)localObject2).jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + ((agvw)localObject2).b + ",isPasswdRedBagOverDue=" + ((agvw)localObject2).c);
      return;
      Object localObject1 = new Intent();
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
        ((Intent)localObject1).putExtra("session", this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      ((Intent)localObject1).putExtra("uniseq", localMessageForQQWalletMsg.uniseq);
      ((Intent)localObject1).putExtra("public_fragment_window_feature", 1);
      Object localObject2 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId;
      Object localObject3 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.authkey;
      Object localObject4 = ahiv.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      int j = ((Bundle)localObject4).getInt("groupType");
      localObject4 = ((Bundle)localObject4).getString("name");
      int i = 0;
      if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem != null) {
        i = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.resourceType;
      }
      localObject2 = ahiv.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, j, (String)localObject4, (String)localObject2, (String)localObject3, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "appid#1344242394|bargainor_id#1000030201|channel#detailtips", "redgiftDetail", null, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redChannel, i, localMessageForQQWalletMsg.fromHBList);
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("json", ((JSONObject)localObject2).toString());
      ((Bundle)localObject3).putString("callbackSn", "0");
      ((Intent)localObject1).putExtra("detail_bundle", (Bundle)localObject3);
      ((Intent)localObject1).putExtra("fromHBList", localMessageForQQWalletMsg.fromHBList);
      ((Intent)localObject1).putExtra("redPacketId", localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
      if (!(paramView.getContext() instanceof Activity)) {
        ((Intent)localObject1).addFlags(268435456);
      }
      abtq.a(paramView.getContext(), (Intent)localObject1, PublicTransFragmentActivity.class, RedPacketVoiceFragment.class);
    } while (!QLog.isColorLevel());
    QLog.d("PasswdRedBagManager", 2, "show passwdredbag tips = " + localQQWalletRedPacketMsg.elem.title);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aelf
 * JD-Core Version:    0.7.0.1
 */