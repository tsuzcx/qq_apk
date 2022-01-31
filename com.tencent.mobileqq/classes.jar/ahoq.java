import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class ahoq
  implements View.OnClickListener
{
  public ahoq(NotificationView paramNotificationView) {}
  
  public void onClick(View paramView)
  {
    ahok localahok = (ahok)paramView.getTag();
    if (localahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 80)
    {
      paramView = TroopInfoActivity.a(String.valueOf(localahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), 5);
      TroopInfoActivity.a(this.a.a(), paramView);
      return;
    }
    if (!bdin.d(this.a.a()))
    {
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.a().getString(2131694766), 0).b(this.a.a());
      return;
    }
    ((FriendListHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).b(String.valueOf(localahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
    NotificationView.a(this.a, (structmsg.StructMsg)localahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), localahok.c);
    String str2 = localahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get();
    String str3 = localahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
    int i;
    label265:
    String str1;
    if (localahok.b < this.a.jdField_a_of_type_Ahoi.jdField_a_of_type_Int)
    {
      paramView = "1";
      i = localahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
      if ((i != 2) && (i != 3)) {
        break label419;
      }
      i = 0;
      if (i == 0) {
        break label424;
      }
      str1 = "0";
      label272:
      if ((str2 != null) && (!"".equals(str2))) {
        break label752;
      }
      if (localahok.jdField_a_of_type_Int != 82) {
        break label430;
      }
      azqs.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "focus_notice", 0, 0, "", "", "", localahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
      NotificationView.a(this.a, localahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get(), (structmsg.StructMsg)localahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
    }
    for (;;)
    {
      NotificationView.c(this.a);
      this.a.jdField_a_of_type_Bety.c(2131719785);
      this.a.jdField_a_of_type_Bety.show();
      return;
      paramView = "0";
      break;
      label419:
      i = 1;
      break label265;
      label424:
      str1 = "1";
      break label272;
      label430:
      if (localahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NotificationView", 2, "doCheckPayTroopReq start: " + str3);
        }
        TroopRequestActivity.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str3, localahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, this.a.jdField_a_of_type_Ahpq);
        bdes.a("Grp_contacts_news", "notice", "agree_invite", 0, 0, new String[] { str3, paramView, str1, "1" });
      }
      else
      {
        NotificationView.a(this.a, 1, (structmsg.StructMsg)localahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
        if ((localahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has()) && (localahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.has())) {
          ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(str3, localahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "", localahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get());
        }
        if (localahok.jdField_a_of_type_Int == 1)
        {
          bdes.a("Grp_contacts_news", "notice", "agree_ask", 0, 0, new String[] { str3, paramView, str1, "1" });
        }
        else if (localahok.jdField_a_of_type_Int == 2)
        {
          bdes.a("Grp_contacts_news", "notice", "agree_invite", 0, 0, new String[] { str3, paramView, str1, "1" });
          continue;
          label752:
          NotificationView.a(this.a, 0, (structmsg.StructMsg)localahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
          if (localahok.jdField_a_of_type_Int == 1) {
            bdes.a("Grp_contacts_news", "notice", "refuse_ask", 0, 0, new String[] { str3, paramView, str1, "1" });
          } else if (localahok.jdField_a_of_type_Int == 2) {
            bdes.a("Grp_contacts_news", "notice", "refuse_invite", 0, 0, new String[] { str3, paramView, str1, "1" });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahoq
 * JD-Core Version:    0.7.0.1
 */