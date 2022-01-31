import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class afck
  implements View.OnClickListener
{
  public afck(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onClick(View paramView)
  {
    if (!(paramView.getTag() instanceof afbb)) {
      return;
    }
    afbb localafbb = (afbb)paramView.getTag();
    if (localafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 80)
    {
      paramView = TroopInfoActivity.a(String.valueOf(localafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), 5);
      TroopInfoActivity.a(this.a.a(), paramView);
      return;
    }
    if (!badq.d(this.a.a()))
    {
      bbmy.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.a().getString(2131628946), 0).b(this.a.a());
      return;
    }
    ((FriendListHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).b(String.valueOf(localafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
    TroopNotifyAndRecommendView.a(this.a, (structmsg.StructMsg)localafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), localafbb.c);
    String str2 = localafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get();
    String str3 = localafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
    int i;
    label286:
    String str1;
    if ((this.a.jdField_a_of_type_Afbk != null) && (localafbb.b < this.a.jdField_a_of_type_Afbk.jdField_a_of_type_Int))
    {
      paramView = "1";
      i = localafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
      if ((i != 2) && (i != 3)) {
        break label383;
      }
      i = 0;
      if (i == 0) {
        break label388;
      }
      str1 = "0";
      label293:
      if ((str2 != null) && (!"".equals(str2))) {
        break label715;
      }
      if (localafbb.jdField_a_of_type_Int != 82) {
        break label394;
      }
      TroopNotifyAndRecommendView.a(this.a, localafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get(), (structmsg.StructMsg)localafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
    }
    for (;;)
    {
      TroopNotifyAndRecommendView.c(this.a);
      this.a.jdField_a_of_type_Bbms.c(2131653452);
      this.a.jdField_a_of_type_Bbms.show();
      return;
      paramView = "0";
      break;
      label383:
      i = 1;
      break label286;
      label388:
      str1 = "1";
      break label293;
      label394:
      if (localafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotifyAndRecommendView", 2, "doCheckPayTroopReq start: " + str3);
        }
        TroopRequestActivity.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str3, localafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, this.a.jdField_a_of_type_Afcf);
        azzx.a("Grp_contacts_news", "notice", "agree_invite", 0, 0, new String[] { str3, paramView, str1, "0" });
      }
      else
      {
        TroopNotifyAndRecommendView.a(this.a, 1, (structmsg.StructMsg)localafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
        if ((localafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has()) && (localafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.has())) {
          ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(str3, localafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "", localafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get());
        }
        if (localafbb.jdField_a_of_type_Int == 1)
        {
          azzx.a("Grp_contacts_news", "notice", "agree_ask", 0, 0, new String[] { str3, paramView, str1, "0" });
        }
        else if (localafbb.jdField_a_of_type_Int == 2)
        {
          azzx.a("Grp_contacts_news", "notice", "agree_invite", 0, 0, new String[] { str3, paramView, str1, "0" });
          continue;
          label715:
          TroopNotifyAndRecommendView.a(this.a, 0, (structmsg.StructMsg)localafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
          if (localafbb.jdField_a_of_type_Int == 1) {
            azzx.a("Grp_contacts_news", "notice", "refuse_ask", 0, 0, new String[] { str3, paramView, str1, "0" });
          } else if (localafbb.jdField_a_of_type_Int == 2) {
            azzx.a("Grp_contacts_news", "notice", "refuse_invite", 0, 0, new String[] { str3, paramView, str1, "0" });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afck
 * JD-Core Version:    0.7.0.1
 */