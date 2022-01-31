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
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class afmx
  implements View.OnClickListener
{
  public afmx(NotificationView paramNotificationView) {}
  
  public void onClick(View paramView)
  {
    afmr localafmr = (afmr)paramView.getTag();
    if (localafmr.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 80)
    {
      paramView = TroopInfoActivity.a(String.valueOf(localafmr.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), 5);
      TroopInfoActivity.a(this.a.a(), paramView);
      return;
    }
    if (!bbev.d(this.a.a()))
    {
      bcpw.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.a().getString(2131694607), 0).b(this.a.a());
      return;
    }
    ((FriendListHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).b(String.valueOf(localafmr.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
    NotificationView.a(this.a, (structmsg.StructMsg)localafmr.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), localafmr.c);
    String str2 = localafmr.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get();
    String str3 = localafmr.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
    int i;
    label265:
    String str1;
    if (localafmr.b < this.a.jdField_a_of_type_Afmp.jdField_a_of_type_Int)
    {
      paramView = "1";
      i = localafmr.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
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
      if (localafmr.jdField_a_of_type_Int != 82) {
        break label430;
      }
      axqw.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "focus_notice", 0, 0, "", "", "", localafmr.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
      NotificationView.a(this.a, localafmr.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get(), (structmsg.StructMsg)localafmr.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
    }
    for (;;)
    {
      NotificationView.c(this.a);
      this.a.jdField_a_of_type_Bcpq.c(2131719281);
      this.a.jdField_a_of_type_Bcpq.show();
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
      if (localafmr.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NotificationView", 2, "doCheckPayTroopReq start: " + str3);
        }
        TroopRequestActivity.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str3, localafmr.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, this.a.jdField_a_of_type_Afnv);
        bbbb.a("Grp_contacts_news", "notice", "agree_invite", 0, 0, new String[] { str3, paramView, str1, "1" });
      }
      else
      {
        NotificationView.a(this.a, 1, (structmsg.StructMsg)localafmr.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
        if ((localafmr.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has()) && (localafmr.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.has())) {
          ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(str3, localafmr.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "", localafmr.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get());
        }
        if (localafmr.jdField_a_of_type_Int == 1)
        {
          bbbb.a("Grp_contacts_news", "notice", "agree_ask", 0, 0, new String[] { str3, paramView, str1, "1" });
        }
        else if (localafmr.jdField_a_of_type_Int == 2)
        {
          bbbb.a("Grp_contacts_news", "notice", "agree_invite", 0, 0, new String[] { str3, paramView, str1, "1" });
          continue;
          label752:
          NotificationView.a(this.a, 0, (structmsg.StructMsg)localafmr.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
          if (localafmr.jdField_a_of_type_Int == 1) {
            bbbb.a("Grp_contacts_news", "notice", "refuse_ask", 0, 0, new String[] { str3, paramView, str1, "1" });
          } else if (localafmr.jdField_a_of_type_Int == 2) {
            bbbb.a("Grp_contacts_news", "notice", "refuse_invite", 0, 0, new String[] { str3, paramView, str1, "1" });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afmx
 * JD-Core Version:    0.7.0.1
 */