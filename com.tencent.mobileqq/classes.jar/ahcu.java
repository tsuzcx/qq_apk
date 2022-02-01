import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.qwallet.RedPacketVoiceFragment;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class ahcu
  implements View.OnClickListener
{
  ahcu(ahcp paramahcp) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_Ajxv != null) {
        this.a.jdField_a_of_type_Ajxv.a(2);
      }
      long l = System.currentTimeMillis();
      if (akgc.a(ahcp.jdField_a_of_type_Long, l))
      {
        ahcp.jdField_a_of_type_Long = l;
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
        Object localObject1 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg;
        Object localObject2 = (ajul)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125);
        if (nmy.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))
        {
          ((ajul)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 2);
          if (QLog.isColorLevel()) {
            QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
          }
        }
        else
        {
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1)
          {
            localObject3 = (bfbz)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
            boolean bool = ((bfbz)localObject3).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            localObject3 = ((bfbz)localObject3).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, false);
            if ((bool) || ((localObject3 != null) && (((bfcf)localObject3).jdField_a_of_type_Boolean)))
            {
              ((ajul)localObject2).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 2);
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("PasswdRedBagManager", 2, "current is in TroopMemberGag, dont show passwdredbag tips");
              continue;
            }
          }
          Object localObject3 = ((ajul)localObject2).a(((QQWalletRedPacketMsg)localObject1).redPacketId);
          l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
          if ((localObject3 != null) && ((((ajuk)localObject3).jdField_a_of_type_Boolean) || (((ajuk)localObject3).b) || (((ajuk)localObject3).c) || (((ajuk)localObject3).jdField_a_of_type_Long < l)))
          {
            ((ajul)localObject2).a(((QQWalletRedPacketMsg)localObject1).redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
            l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=13", 0, null);
            localObject1 = akgt.b(localMessageForQQWalletMsg);
            ((ajul)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (ajuk)localObject3, l, 65536, (String)localObject1, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId, localMessageForQQWalletMsg.fromHBList, null);
            if (QLog.isColorLevel()) {
              QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + ((ajuk)localObject3).jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + ((ajuk)localObject3).b + ",isPasswdRedBagOverDue=" + ((ajuk)localObject3).c);
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
            Object localObject4 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.authkey;
            Object localObject5 = akgc.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            int j = ((Bundle)localObject5).getInt("groupType");
            localObject5 = ((Bundle)localObject5).getString("name");
            int i = 0;
            if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem != null) {
              i = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.resourceType;
            }
            localObject3 = akgc.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, j, (String)localObject5, (String)localObject3, (String)localObject4, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "appid#1344242394|bargainor_id#1000030201|channel#detailtips", "redgiftDetail", null, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redChannel, i, localMessageForQQWalletMsg.fromHBList);
            localObject4 = new Bundle();
            ((Bundle)localObject4).putString("json", ((JSONObject)localObject3).toString());
            ((Bundle)localObject4).putString("callbackSn", "0");
            ((Intent)localObject2).putExtra("detail_bundle", (Bundle)localObject4);
            ((Intent)localObject2).putExtra("fromHBList", localMessageForQQWalletMsg.fromHBList);
            ((Intent)localObject2).putExtra("redPacketId", localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
            if (!(paramView.getContext() instanceof Activity)) {
              ((Intent)localObject2).addFlags(268435456);
            }
            adxr.a(paramView.getContext(), (Intent)localObject2, PublicTransFragmentActivity.class, RedPacketVoiceFragment.class);
            if (QLog.isColorLevel()) {
              QLog.d("PasswdRedBagManager", 2, "show passwdredbag tips = " + ((QQWalletRedPacketMsg)localObject1).elem.title);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahcu
 * JD-Core Version:    0.7.0.1
 */