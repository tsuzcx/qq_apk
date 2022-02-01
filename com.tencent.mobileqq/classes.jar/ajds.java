import android.app.Activity;
import android.os.Bundle;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class ajds
  implements View.OnClickListener
{
  public ajds(NotificationView paramNotificationView) {}
  
  public void onClick(View paramView)
  {
    ajdm localajdm = (ajdm)paramView.getTag();
    Object localObject;
    if (localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 80)
    {
      localObject = TroopInfoActivity.a(String.valueOf(localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), 5);
      TroopInfoActivity.a(this.a.a(), (Bundle)localObject);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (bgnt.d(this.a.a())) {
        break;
      }
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.a().getString(2131693946), 0).b(this.a.a());
    }
    ((FriendListHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).b(String.valueOf(localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
    NotificationView.a(this.a, (structmsg.StructMsg)localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), localajdm.c);
    String str2 = localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get();
    String str3 = localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
    label247:
    int i;
    label274:
    String str1;
    if (localajdm.b < this.a.jdField_a_of_type_Ajdk.jdField_a_of_type_Int)
    {
      localObject = "1";
      i = localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
      if ((i != 2) && (i != 3)) {
        break label431;
      }
      i = 0;
      if (i == 0) {
        break label436;
      }
      str1 = "0";
      label282:
      if ((str2 != null) && (!"".equals(str2))) {
        break label768;
      }
      if (localajdm.jdField_a_of_type_Int != 82) {
        break label443;
      }
      bcst.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "focus_notice", 0, 0, "", "", "", localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
      NotificationView.a(this.a, localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get(), (structmsg.StructMsg)localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
    }
    label768:
    for (;;)
    {
      NotificationView.c(this.a);
      this.a.jdField_a_of_type_Biau.c(2131717771);
      this.a.jdField_a_of_type_Biau.show();
      break;
      localObject = "0";
      break label247;
      label431:
      i = 1;
      break label274;
      label436:
      str1 = "1";
      break label282;
      label443:
      if (localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NotificationView", 2, "doCheckPayTroopReq start: " + str3);
        }
        TroopRequestActivity.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str3, localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, this.a.jdField_a_of_type_Ajer);
        bgjt.a("Grp_contacts_news", "notice", "agree_invite", 0, 0, new String[] { str3, localObject, str1, "1" });
      }
      else
      {
        NotificationView.a(this.a, 1, (structmsg.StructMsg)localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
        if ((localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has()) && (localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.has())) {
          ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(str3, localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "", localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get());
        }
        if (localajdm.jdField_a_of_type_Int == 1)
        {
          bgjt.a("Grp_contacts_news", "notice", "agree_ask", 0, 0, new String[] { str3, localObject, str1, "1" });
        }
        else if (localajdm.jdField_a_of_type_Int == 2)
        {
          bgjt.a("Grp_contacts_news", "notice", "agree_invite", 0, 0, new String[] { str3, localObject, str1, "1" });
          continue;
          NotificationView.a(this.a, 0, (structmsg.StructMsg)localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
          if (localajdm.jdField_a_of_type_Int == 1) {
            bgjt.a("Grp_contacts_news", "notice", "refuse_ask", 0, 0, new String[] { str3, localObject, str1, "1" });
          } else if (localajdm.jdField_a_of_type_Int == 2) {
            bgjt.a("Grp_contacts_news", "notice", "refuse_invite", 0, 0, new String[] { str3, localObject, str1, "1" });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajds
 * JD-Core Version:    0.7.0.1
 */