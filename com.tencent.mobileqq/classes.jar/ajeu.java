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
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class ajeu
  implements View.OnClickListener
{
  public ajeu(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onClick(View paramView)
  {
    if (!(paramView.getTag() instanceof ajdm)) {}
    ajdm localajdm;
    Object localObject;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localajdm = (ajdm)paramView.getTag();
      if (localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 80) {
        break;
      }
      localObject = TroopInfoActivity.a(String.valueOf(localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), 5);
      TroopInfoActivity.a(this.a.a(), (Bundle)localObject);
    }
    if (this.a.c == 1) {
      bcst.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "todotab_notice_confirm", 2, 0, String.valueOf(localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), "", "");
    }
    for (;;)
    {
      if (bgnt.d(this.a.a())) {
        break label266;
      }
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.a().getString(2131693946), 0).b(this.a.a());
      break;
      bcst.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "todotab_notice_confirm", 1, 0, String.valueOf(localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), "", "");
    }
    label266:
    ((FriendListHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).b(String.valueOf(localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
    TroopNotifyAndRecommendView.a(this.a, (structmsg.StructMsg)localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), localajdm.c);
    String str2 = localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get();
    String str3 = localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
    label404:
    int i;
    label431:
    String str1;
    if ((this.a.jdField_a_of_type_Ajdv != null) && (localajdm.b < this.a.jdField_a_of_type_Ajdv.jdField_a_of_type_Int))
    {
      localObject = "1";
      i = localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
      if ((i != 2) && (i != 3)) {
        break label531;
      }
      i = 0;
      if (i == 0) {
        break label536;
      }
      str1 = "0";
      label439:
      if ((str2 != null) && (!"".equals(str2))) {
        break label868;
      }
      if (localajdm.jdField_a_of_type_Int != 82) {
        break label543;
      }
      TroopNotifyAndRecommendView.a(this.a, localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get(), (structmsg.StructMsg)localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
    }
    for (;;)
    {
      TroopNotifyAndRecommendView.f(this.a);
      this.a.jdField_a_of_type_Biau.c(2131717771);
      this.a.jdField_a_of_type_Biau.show();
      break;
      localObject = "0";
      break label404;
      label531:
      i = 1;
      break label431;
      label536:
      str1 = "1";
      break label439;
      label543:
      if (localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotifyAndRecommendView", 2, "doCheckPayTroopReq start: " + str3);
        }
        TroopRequestActivity.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str3, localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, this.a.jdField_a_of_type_Ajer);
        bgjt.a("Grp_contacts_news", "notice", "agree_invite", 0, 0, new String[] { str3, localObject, str1, "0" });
      }
      else
      {
        TroopNotifyAndRecommendView.a(this.a, 1, (structmsg.StructMsg)localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
        if ((localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has()) && (localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.has())) {
          ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(str3, localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "", localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get());
        }
        if (localajdm.jdField_a_of_type_Int == 1)
        {
          bgjt.a("Grp_contacts_news", "notice", "agree_ask", 0, 0, new String[] { str3, localObject, str1, "0" });
        }
        else if (localajdm.jdField_a_of_type_Int == 2)
        {
          bgjt.a("Grp_contacts_news", "notice", "agree_invite", 0, 0, new String[] { str3, localObject, str1, "0" });
          continue;
          label868:
          TroopNotifyAndRecommendView.a(this.a, 0, (structmsg.StructMsg)localajdm.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
          if (localajdm.jdField_a_of_type_Int == 1) {
            bgjt.a("Grp_contacts_news", "notice", "refuse_ask", 0, 0, new String[] { str3, localObject, str1, "0" });
          } else if (localajdm.jdField_a_of_type_Int == 2) {
            bgjt.a("Grp_contacts_news", "notice", "refuse_invite", 0, 0, new String[] { str3, localObject, str1, "0" });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajeu
 * JD-Core Version:    0.7.0.1
 */