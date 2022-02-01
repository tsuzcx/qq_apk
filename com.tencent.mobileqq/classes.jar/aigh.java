import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.RedPacketKuaKuaFragment;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class aigh
  implements View.OnClickListener
{
  aigh(aifz paramaifz) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_Alad != null) {
        this.a.jdField_a_of_type_Alad.a(14);
      }
      long l = System.currentTimeMillis();
      if (alik.a(aifz.jdField_a_of_type_Long, l))
      {
        aifz.jdField_a_of_type_Long = l;
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramView.getTag();
        QQWalletRedPacketMsg localQQWalletRedPacketMsg = localMessageForQQWalletMsg.mQQWalletRedPacketMsg;
        Object localObject1 = (akwu)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125);
        if (nlj.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          ((akwu)localObject1).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1);
          if (QLog.isColorLevel()) {
            QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont show passwdredbag tips");
          }
        }
        else
        {
          Object localObject2 = ((akwu)localObject1).a(localQQWalletRedPacketMsg.redPacketId);
          l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
          if ((localObject2 != null) && ((((akwt)localObject2).jdField_a_of_type_Boolean) || (((akwt)localObject2).b) || (((akwt)localObject2).c) || (((akwt)localObject2).jdField_a_of_type_Long < l)))
          {
            ((akwu)localObject1).a(localQQWalletRedPacketMsg.redPacketId, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.click", "msgType=6", 0, null);
            ((akwu)localObject1).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (akwt)localObject2, l, 1000002, localMessageForQQWalletMsg.fromHBList, null);
            ((akwu)localObject1).a(localQQWalletRedPacketMsg.redPacketId, true);
            if (QLog.isColorLevel()) {
              QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + ((akwt)localObject2).jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + ((akwt)localObject2).b + ",isPasswdRedBagOverDue=" + ((akwt)localObject2).c);
            }
          }
          else
          {
            localObject1 = new Intent();
            if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
              ((Intent)localObject1).putExtra("session", this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            }
            ((Intent)localObject1).putExtra("uniseq", localMessageForQQWalletMsg.uniseq);
            ((Intent)localObject1).putExtra("public_fragment_window_feature", 1);
            localObject2 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId;
            Object localObject3 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.authkey;
            Object localObject4 = alik.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            int j = ((Bundle)localObject4).getInt("groupType");
            localObject4 = ((Bundle)localObject4).getString("name");
            int i = 0;
            if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem != null) {
              i = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.resourceType;
            }
            localObject2 = alik.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, j, (String)localObject4, (String)localObject2, (String)localObject3, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "appid#1344242394|bargainor_id#1000030201|channel#detailtips", "redgiftDetail", null, localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redChannel, i, localMessageForQQWalletMsg.fromHBList);
            localObject3 = new Bundle();
            ((Bundle)localObject3).putString("json", ((JSONObject)localObject2).toString());
            ((Bundle)localObject3).putString("callbackSn", "0");
            ((Intent)localObject1).putExtra("fromHBList", localMessageForQQWalletMsg.fromHBList);
            ((Intent)localObject1).putExtra("redPacketId", localMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
            if (!(paramView.getContext() instanceof Activity)) {
              ((Intent)localObject1).addFlags(268435456);
            }
            afez.a(paramView.getContext(), (Intent)localObject1, PublicTransFragmentActivity.class, RedPacketKuaKuaFragment.class);
            if (QLog.isColorLevel()) {
              QLog.d("PasswdRedBagManager", 2, "show passwdredbag kuakua tips = " + localQQWalletRedPacketMsg.elem.title);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aigh
 * JD-Core Version:    0.7.0.1
 */