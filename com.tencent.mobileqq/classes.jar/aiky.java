import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class aiky
  implements View.OnClickListener
{
  public aiky(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onClick(View paramView)
  {
    if (!(paramView.getTag() instanceof aijj)) {}
    aijj localaijj;
    Object localObject;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localaijj = (aijj)paramView.getTag();
      if (localaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 80) {
        break;
      }
      localObject = TroopInfoActivity.a(String.valueOf(localaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), 5);
      TroopInfoActivity.a(this.a.a(), (Bundle)localObject);
    }
    if (this.a.c == 1) {
      bcef.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "todotab_notice_confirm", 2, 0, String.valueOf(localaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(localaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), String.valueOf(localaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq), "");
    }
    for (;;)
    {
      if (NetworkUtil.isNetSupport(this.a.a())) {
        break label286;
      }
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.a().getString(2131694062), 0).b(this.a.a());
      break;
      bcef.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "todotab_notice_confirm", 1, 0, String.valueOf(localaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(localaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), String.valueOf(localaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq), "");
    }
    label286:
    ((FriendListHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(1)).getFriendInfo(String.valueOf(localaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
    TroopNotifyAndRecommendView.a(this.a, (structmsg.StructMsg)localaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), localaijj.c);
    String str2 = localaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get();
    String str3 = localaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
    if (localaijj.jdField_a_of_type_Int == 91)
    {
      localObject = (TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      if (localObject == null) {
        break label1103;
      }
      localObject = ((TroopManager)localObject).b(String.valueOf(localaijj.f));
      if (localObject == null) {
        break label1103;
      }
    }
    label515:
    label542:
    label550:
    label1103:
    for (long l = ((TroopInfo)localObject).dwGroupClassExt;; l = 0L)
    {
      bcef.b(null, "dc00898", "", String.valueOf(localaijj.f), "0X800B4B3", "0X800B4B3", 0, 0, String.valueOf(l), "", "", "");
      int i;
      String str1;
      if ((this.a.jdField_a_of_type_Aijs != null) && (localaijj.b < this.a.jdField_a_of_type_Aijs.jdField_a_of_type_Int))
      {
        localObject = "1";
        i = localaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
        if ((i != 2) && (i != 3)) {
          break label643;
        }
        i = 0;
        if (i == 0) {
          break label648;
        }
        str1 = "0";
        if ((str2 != null) && (!"".equals(str2))) {
          break label987;
        }
        if (localaijj.jdField_a_of_type_Int != 82) {
          break label655;
        }
        TroopNotifyAndRecommendView.a(this.a, localaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get(), (structmsg.StructMsg)localaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
      }
      for (;;)
      {
        TroopNotifyAndRecommendView.m(this.a);
        this.a.jdField_a_of_type_Bhht.c(2131718142);
        this.a.jdField_a_of_type_Bhht.show();
        break;
        localObject = "0";
        break label515;
        i = 1;
        break label542;
        str1 = "1";
        break label550;
        if (localaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopNotifyAndRecommendView", 2, "doCheckPayTroopReq start: " + str3);
          }
          TroopRequestActivity.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str3, localaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, this.a.jdField_a_of_type_Aikv);
          bftc.a("Grp_contacts_news", "notice", "agree_invite", 0, 0, new String[] { str3, localObject, str1, "0" });
        }
        else
        {
          TroopNotifyAndRecommendView.a(this.a, 1, (structmsg.StructMsg)localaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
          if ((localaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has()) && (localaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.has())) {
            ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(str3, localaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "", localaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get());
          }
          if (localaijj.jdField_a_of_type_Int == 1)
          {
            bftc.a("Grp_contacts_news", "notice", "agree_ask", 0, 0, new String[] { str3, localObject, str1, "0" });
          }
          else if (localaijj.jdField_a_of_type_Int == 2)
          {
            bftc.a("Grp_contacts_news", "notice", "agree_invite", 0, 0, new String[] { str3, localObject, str1, "0" });
            continue;
            label987:
            TroopNotifyAndRecommendView.a(this.a, 0, (structmsg.StructMsg)localaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
            if (localaijj.jdField_a_of_type_Int == 1) {
              bftc.a("Grp_contacts_news", "notice", "refuse_ask", 0, 0, new String[] { str3, localObject, str1, "0" });
            } else if (localaijj.jdField_a_of_type_Int == 2) {
              bftc.a("Grp_contacts_news", "notice", "refuse_invite", 0, 0, new String[] { str3, localObject, str1, "0" });
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiky
 * JD-Core Version:    0.7.0.1
 */