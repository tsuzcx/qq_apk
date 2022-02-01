import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.activity.TroopRequestRefuseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class afww
  implements View.OnClickListener
{
  public afww(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    if ((!bhnv.d(this.a)) && ((paramView != this.a.jdField_b_of_type_AndroidWidgetButton) || ((this.a.jdField_b_of_type_Int != 1) && (this.a.jdField_b_of_type_Int != 22)))) {
      QQToast.a(this.a, this.a.getString(2131693963), 0).b(this.a.getTitleBarHeight());
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.jdField_a_of_type_Boolean = this.a.getIntent().getExtras().getBoolean("is_unread");
      String str = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
      Object localObject1 = "0";
      int i = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
      if (this.a.jdField_a_of_type_Boolean) {
        localObject1 = "1";
      }
      label265:
      Object localObject2;
      if (paramView == this.a.jdField_a_of_type_AndroidWidgetButton)
      {
        if (((TroopManager)this.a.app.getManager(52)).b(this.a.jdField_a_of_type_JavaLangString) != null) {}
        for (;;)
        {
          if (this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 80) {
            break label265;
          }
          QLog.e("Q.systemmsg.TroopRequestActivity", 1, "TroopProxyActivity 已在725下架");
          break;
          axap.a().b(this.a.jdField_a_of_type_JavaLangString, this.a.app);
        }
        if (this.a.jdField_d_of_type_Boolean) {
          ajrj.a(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, "unnormal_edit_join");
        }
        if (i == 2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.systemmsg.TroopRequestActivity", 2, "doCheckPayTroopReq start: " + str);
          }
          this.a.h();
          TroopRequestActivity.a(this.a, this.a.app, str, this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, this.a.jdField_a_of_type_Ajqa);
          i = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
          if ((i != 2) && (i != 3))
          {
            i = 1;
            label390:
            if (i == 0) {
              break label509;
            }
            localObject2 = "0";
            label398:
            bdll.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "agree_invite", 0, 0, str, (String)localObject1, (String)localObject2, "1");
          }
        }
        for (;;)
        {
          if (this.a.j == 0)
          {
            bdll.b(this.a.app, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_confirm", 1, 0, String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), "", "");
            break;
            i = 0;
            break label390;
            label509:
            localObject2 = "1";
            break label398;
            if (i == 82)
            {
              this.a.h();
              TroopRequestActivity.a(this.a, this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get(), this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg);
              bdll.b(this.a.app, "P_CliOper", "Grp_public", "", "oper", "focus_invite", 0, 0, "", "", "", this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
            }
            else if (TroopRequestActivity.a(this.a, 1))
            {
              this.a.h();
              if (i == 1)
              {
                if ((this.a.r == null) || ("".equals(this.a.r)))
                {
                  i = 1;
                  label668:
                  if (i == 0) {
                    break label713;
                  }
                }
                label713:
                for (localObject2 = "1";; localObject2 = "0")
                {
                  bdll.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "agree_ask", 0, 0, str, (String)localObject1, (String)localObject2, "1");
                  break;
                  i = 0;
                  break label668;
                }
              }
            }
          }
        }
        if (this.a.j == 1) {
          bdll.b(this.a.app, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_confirm", 2, 0, String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), "", "");
        }
      }
      else if (paramView == this.a.jdField_b_of_type_AndroidWidgetButton)
      {
        if ((this.a.jdField_b_of_type_Int == 1) || (this.a.jdField_b_of_type_Int == 22))
        {
          localObject2 = new Intent(this.a, TroopRequestRefuseActivity.class);
          this.a.startActivityForResult((Intent)localObject2, 1005);
          if (this.a.jdField_d_of_type_Boolean) {
            ajrj.a(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, "unnormal_edit_reject");
          }
          bdll.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "refuse_ask_has_reason", 0, 0, str, (String)localObject1, "", "1");
          if (this.a.j == 0) {
            bdll.b(this.a.app, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_reject", 1, 0, String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), "", "");
          } else if (this.a.j == 1) {
            bdll.b(this.a.app, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_reject", 2, 0, String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), "", "");
          }
        }
        else if (TroopRequestActivity.a(this.a, 0))
        {
          this.a.h();
          if (i == 1)
          {
            if ((this.a.r == null) || ("".equals(this.a.r)))
            {
              i = 1;
              label1119:
              if (i == 0) {
                break label1165;
              }
            }
            label1165:
            for (localObject2 = "1";; localObject2 = "0")
            {
              bdll.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "refuse_ask", 0, 0, str, (String)localObject1, (String)localObject2, "1");
              break;
              i = 0;
              break label1119;
            }
          }
          if (i == 2)
          {
            i = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
            if ((i != 2) && (i != 3))
            {
              i = 1;
              label1206:
              if (i == 0) {
                break label1252;
              }
            }
            label1252:
            for (localObject2 = "0";; localObject2 = "1")
            {
              bdll.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "refuse_invite", 0, 0, str, (String)localObject1, (String)localObject2, "1");
              break;
              i = 0;
              break label1206;
            }
          }
        }
      }
      else if (paramView == this.a.rightViewText)
      {
        if (this.a.jdField_b_of_type_Int == 82)
        {
          if (TroopRequestActivity.a(this.a, 0)) {
            this.a.h();
          }
          bhju.a("Grp_contacts_news", "notice", "ignore_invite", 0, 0, new String[] { str, localObject1 });
        }
        if (TroopRequestActivity.a(this.a, 2))
        {
          this.a.h();
          if (i != 1) {
            break label1451;
          }
          bhju.a("Grp_contacts_news", "notice", "ignore_ask", 0, 0, new String[] { str, localObject1 });
        }
        for (;;)
        {
          if (this.a.j == 0)
          {
            bdll.b(this.a.app, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_ignore", 1, 0, String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), "", "");
            break;
            label1451:
            if (i == 2)
            {
              i = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
              if ((i != 2) && (i != 3))
              {
                i = 1;
                label1485:
                if (i == 0) {
                  break label1531;
                }
              }
              label1531:
              for (localObject2 = "0";; localObject2 = "1")
              {
                bhju.a("Grp_contacts_news", "notice", "ignore_invite", 0, 0, new String[] { str, localObject1, localObject2 });
                break;
                i = 0;
                break label1485;
              }
            }
          }
        }
        if (this.a.j == 1) {
          bdll.b(this.a.app, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_ignore", 2, 0, String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), "", "");
        }
      }
      else if (paramView == this.a.jdField_d_of_type_AndroidWidgetTextView)
      {
        if (this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 80)
        {
          localObject1 = TroopInfoActivity.a(this.a.jdField_a_of_type_JavaLangString, 5);
          TroopInfoActivity.a(this.a.getActivity(), (Bundle)localObject1);
        }
        else
        {
          if (((TroopManager)this.a.app.getManager(52)).b(this.a.jdField_a_of_type_JavaLangString) != null) {}
          for (;;)
          {
            if (((this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 11) || (this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 3)) && (this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 7)) {
              break label1849;
            }
            this.a.h();
            TroopRequestActivity.a(this.a, this.a.app, str, this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, this.a.jdField_a_of_type_Ajqa);
            bhju.a("Grp_contacts_news", "notice", "again_join", 0, 0, new String[] { str });
            break;
            axap.a().b(this.a.jdField_a_of_type_JavaLangString, this.a.app);
          }
          label1849:
          if ((this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 10) && (this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() == 3))
          {
            this.a.h();
            localObject1 = new ArrayList();
            ((ArrayList)localObject1).add(TroopRequestActivity.a(this.a));
            if ((((ArrayList)localObject1).size() > 0) && (this.a.jdField_a_of_type_JavaLangString.length() > 0)) {
              ((aoip)this.a.app.a(20)).a(this.a.jdField_a_of_type_JavaLangString, (ArrayList)localObject1, "");
            }
            bhju.a("Grp_contacts_news", "notice", "again_invite", 0, 0, new String[] { str });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afww
 * JD-Core Version:    0.7.0.1
 */