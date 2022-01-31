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

class aele
  implements View.OnClickListener
{
  aele(aela paramaela) {}
  
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
              if (this.a.jdField_a_of_type_Agyt != null) {
                this.a.jdField_a_of_type_Agyt.a(8);
              }
              l = System.currentTimeMillis();
            } while (!ahiv.a(aela.jdField_a_of_type_Long, l));
            aela.jdField_a_of_type_Long = l;
            localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
            localObject1 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg;
            localObject2 = (agvx)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125);
            if (!myb.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
              break;
            }
            ((agvx)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 8);
          } while (!QLog.isColorLevel());
          QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
          return;
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
            break;
          }
          localObject3 = (baky)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
          boolean bool = ((baky)localObject3).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          localObject3 = ((baky)localObject3).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
          if ((!bool) && ((localObject3 == null) || (!((bale)localObject3).jdField_a_of_type_Boolean))) {
            break;
          }
          ((agvx)localObject2).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 8);
        } while (!QLog.isColorLevel());
        QLog.d("PasswdRedBagManager", 2, "current is in TroopMemberGag, dont show passwdredbag tips");
        return;
        localObject3 = ((agvx)localObject2).a(((QQWalletRedPacketMsg)localObject1).redPacketId);
        long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
        if ((localObject3 == null) || ((!((agvw)localObject3).jdField_a_of_type_Boolean) && (!((agvw)localObject3).b) && (!((agvw)localObject3).c) && (((agvw)localObject3).jdField_a_of_type_Long >= l))) {
          break;
        }
        ((agvx)localObject2).a(((QQWalletRedPacketMsg)localObject1).redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=18", 0, null);
        paramView = ahjk.b(localMessageForQQWalletMsg);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("feedsid", ahjk.a(localMessageForQQWalletMsg));
        ((agvx)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (agvw)localObject3, l, 131072, paramView, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId, localMessageForQQWalletMsg.fromHBList, (Bundle)localObject1);
      } while (!QLog.isColorLevel());
      QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + ((agvw)localObject3).jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + ((agvw)localObject3).b + ",isPasswdRedBagOverDue=" + ((agvw)localObject3).c);
      return;
      Object localObject2 = new Intent();
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
        ((Intent)localObject2).putExtra("session", this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      ((Intent)localObject2).putExtra("uniseq", localMessageForQQWalletMsg.uniseq);
      ((Intent)localObject2).putExtra("public_fragment_window_feature", 1);
      Object localObject3 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId;
      Object localObject4 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.authkey;
      Object localObject5 = ahiv.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      int j = ((Bundle)localObject5).getInt("groupType");
      localObject5 = ((Bundle)localObject5).getString("name");
      int i = 0;
      if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem != null) {
        i = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.resourceType;
      }
      localObject3 = ahiv.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, j, (String)localObject5, (String)localObject3, (String)localObject4, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "appid#1344242394|bargainor_id#1000030201|channel#detailtips", "redgiftDetail", null, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redChannel, i, localMessageForQQWalletMsg.fromHBList);
      localObject4 = new Bundle();
      ((Bundle)localObject4).putString("json", ((JSONObject)localObject3).toString());
      ((Bundle)localObject4).putString("callbackSn", "0");
      ((Intent)localObject2).putExtra("fromHBList", localMessageForQQWalletMsg.fromHBList);
      ((Intent)localObject2).putExtra("redPacketId", localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
      if (!(paramView.getContext() instanceof Activity)) {
        ((Intent)localObject2).addFlags(268435456);
      }
      abtq.a(paramView.getContext(), (Intent)localObject2, PublicTransFragmentActivity.class, RedPacketKSongFragment.class);
    } while (!QLog.isColorLevel());
    QLog.d("PasswdRedBagManager", 2, "show passwdredbag ksong tips = " + ((QQWalletRedPacketMsg)localObject1).elem.title);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aele
 * JD-Core Version:    0.7.0.1
 */