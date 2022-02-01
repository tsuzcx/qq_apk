import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class ahxl
  implements View.OnClickListener
{
  ahxl(ahxh paramahxh) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_Akto != null) {
        this.a.jdField_a_of_type_Akto.a(8);
      }
      long l = System.currentTimeMillis();
      if (albv.a(ahxh.jdField_a_of_type_Long, l))
      {
        ahxh.jdField_a_of_type_Long = l;
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
        Object localObject1 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg;
        Object localObject2 = (akqe)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
        if (nty.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))
        {
          ((akqe)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 8);
          if (QLog.isColorLevel()) {
            QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
          }
        }
        else
        {
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1)
          {
            localObject3 = (bgkf)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
            boolean bool = ((bgkf)localObject3).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            localObject3 = ((bgkf)localObject3).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, false);
            if ((bool) || ((localObject3 != null) && (((bgkl)localObject3).jdField_a_of_type_Boolean)))
            {
              ((akqe)localObject2).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 8);
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("PasswdRedBagManager", 2, "current is in TroopMemberGag, dont show passwdredbag tips");
              continue;
            }
          }
          Object localObject3 = ((akqe)localObject2).a(((QQWalletRedPacketMsg)localObject1).redPacketId);
          l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
          Object localObject4;
          if ((localObject3 != null) && ((((akqd)localObject3).jdField_a_of_type_Boolean) || (((akqd)localObject3).b) || (((akqd)localObject3).c) || (((akqd)localObject3).jdField_a_of_type_Long < l)))
          {
            ((akqe)localObject2).a(((QQWalletRedPacketMsg)localObject1).redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
            l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=18", 0, null);
            localObject1 = alcm.b(localMessageForQQWalletMsg);
            localObject4 = new Bundle();
            ((Bundle)localObject4).putString("feedsid", alcm.a(localMessageForQQWalletMsg));
            ((akqe)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (akqd)localObject3, l, 131072, (String)localObject1, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId, localMessageForQQWalletMsg.fromHBList, (Bundle)localObject4);
            if (QLog.isColorLevel()) {
              QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + ((akqd)localObject3).jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + ((akqd)localObject3).b + ",isPasswdRedBagOverDue=" + ((akqd)localObject3).c);
            }
          }
          else
          {
            localObject2 = new Intent();
            if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
              ((Intent)localObject2).putExtra("session", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo);
            }
            ((Intent)localObject2).putExtra("uniseq", localMessageForQQWalletMsg.uniseq);
            ((Intent)localObject2).putExtra("public_fragment_window_feature", 1);
            localObject3 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId;
            localObject4 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.authkey;
            Object localObject5 = albv.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            int j = ((Bundle)localObject5).getInt("groupType");
            localObject5 = ((Bundle)localObject5).getString("name");
            int i = 0;
            if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem != null) {
              i = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.resourceType;
            }
            localObject3 = albv.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, j, (String)localObject5, (String)localObject3, (String)localObject4, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "appid#1344242394|bargainor_id#1000030201|channel#detailtips", "redgiftDetail", null, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redChannel, i, localMessageForQQWalletMsg.fromHBList);
            localObject4 = new Bundle();
            ((Bundle)localObject4).putString("json", ((JSONObject)localObject3).toString());
            ((Bundle)localObject4).putString("callbackSn", "0");
            ((Intent)localObject2).putExtra("fromHBList", localMessageForQQWalletMsg.fromHBList);
            ((Intent)localObject2).putExtra("redPacketId", localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
            if (!(paramView.getContext() instanceof Activity)) {
              ((Intent)localObject2).addFlags(268435456);
            }
            aeow.a(paramView.getContext(), (Intent)localObject2, PublicTransFragmentActivity.class, RedPacketKSongFragment.class);
            if (QLog.isColorLevel()) {
              QLog.d("PasswdRedBagManager", 2, "show passwdredbag ksong tips = " + ((QQWalletRedPacketMsg)localObject1).elem.title);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxl
 * JD-Core Version:    0.7.0.1
 */