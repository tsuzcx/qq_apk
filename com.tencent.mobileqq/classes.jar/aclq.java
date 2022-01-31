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
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class aclq
  implements View.OnClickListener
{
  public aclq(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    int j = 1;
    int k = 1;
    int m = 1;
    int i = 1;
    if ((!bbev.d(this.a)) && ((paramView != this.a.jdField_b_of_type_AndroidWidgetButton) || ((this.a.jdField_b_of_type_Int != 1) && (this.a.jdField_b_of_type_Int != 22)))) {
      bcpw.a(this.a, this.a.getString(2131694607), 0).b(this.a.getTitleBarHeight());
    }
    String str2;
    label435:
    label637:
    do
    {
      do
      {
        String str1;
        int n;
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    this.a.jdField_a_of_type_Boolean = this.a.getIntent().getExtras().getBoolean("is_unread");
                    str2 = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
                    str1 = "0";
                    n = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
                    if (this.a.jdField_a_of_type_Boolean) {
                      str1 = "1";
                    }
                    if (paramView != this.a.jdField_a_of_type_AndroidWidgetButton) {
                      break;
                    }
                    if (((TroopManager)this.a.app.getManager(52)).b(this.a.jdField_a_of_type_JavaLangString) != null) {}
                    while (this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 80)
                    {
                      QLog.e("Q.systemmsg.TroopRequestActivity", 1, "TroopProxyActivity 已在725下架");
                      return;
                      asfd.a().b(this.a.jdField_a_of_type_JavaLangString, this.a.app);
                    }
                    if (this.a.jdField_d_of_type_Boolean) {
                      afoq.a(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, "unnormal_edit_join");
                    }
                    if (n == 2)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.systemmsg.TroopRequestActivity", 2, "doCheckPayTroopReq start: " + str2);
                      }
                      this.a.h();
                      TroopRequestActivity.a(this.a, this.a.app, str2, this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, this.a.jdField_a_of_type_Afnv);
                      j = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
                      if ((j != 2) && (j != 3)) {
                        if (i == 0) {
                          break label435;
                        }
                      }
                      for (paramView = "0";; paramView = "1")
                      {
                        axqw.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "agree_invite", 0, 0, str2, str1, paramView, "1");
                        return;
                        i = 0;
                        break;
                      }
                    }
                    if (n == 82)
                    {
                      this.a.h();
                      TroopRequestActivity.a(this.a, this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get(), this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg);
                      axqw.b(this.a.app, "P_CliOper", "Grp_public", "", "oper", "focus_invite", 0, 0, "", "", "", this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
                      return;
                    }
                  } while (!TroopRequestActivity.a(this.a, 1));
                  this.a.h();
                } while (n != 1);
                i = j;
                if (this.a.r != null)
                {
                  if ("".equals(this.a.r)) {
                    i = j;
                  }
                }
                else {
                  if (i == 0) {
                    break label637;
                  }
                }
                for (paramView = "1";; paramView = "0")
                {
                  axqw.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "agree_ask", 0, 0, str2, str1, paramView, "1");
                  return;
                  i = 0;
                  break;
                }
                if (paramView != this.a.jdField_b_of_type_AndroidWidgetButton) {
                  break;
                }
                if ((this.a.jdField_b_of_type_Int == 1) || (this.a.jdField_b_of_type_Int == 22))
                {
                  paramView = new Intent(this.a, TroopRequestRefuseActivity.class);
                  this.a.startActivityForResult(paramView, 1005);
                  if (this.a.jdField_d_of_type_Boolean) {
                    afoq.a(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, "unnormal_edit_reject");
                  }
                  axqw.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "refuse_ask_has_reason", 0, 0, str2, str1, "", "1");
                  return;
                }
              } while (!TroopRequestActivity.a(this.a, 0));
              this.a.h();
              if (n == 1)
              {
                i = k;
                if (this.a.r != null)
                {
                  if ("".equals(this.a.r)) {
                    i = k;
                  }
                }
                else {
                  if (i == 0) {
                    break label852;
                  }
                }
                for (paramView = "1";; paramView = "0")
                {
                  axqw.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "refuse_ask", 0, 0, str2, str1, paramView, "1");
                  return;
                  i = 0;
                  break;
                }
              }
            } while (n != 2);
            i = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
            if ((i != 2) && (i != 3))
            {
              i = m;
              if (i == 0) {
                break label936;
              }
            }
            for (paramView = "0";; paramView = "1")
            {
              axqw.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "refuse_invite", 0, 0, str2, str1, paramView, "1");
              return;
              i = 0;
              break;
            }
            if (paramView != this.a.rightViewText) {
              break;
            }
            if (this.a.jdField_b_of_type_Int == 82)
            {
              if (TroopRequestActivity.a(this.a, 0)) {
                this.a.h();
              }
              bbbb.a("Grp_contacts_news", "notice", "ignore_invite", 0, 0, new String[] { str2, str1 });
            }
          } while (!TroopRequestActivity.a(this.a, 2));
          this.a.h();
          if (n == 1)
          {
            bbbb.a("Grp_contacts_news", "notice", "ignore_ask", 0, 0, new String[] { str2, str1 });
            return;
          }
        } while (n != 2);
        i = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
        if ((i != 2) && (i != 3))
        {
          i = 1;
          if (i == 0) {
            break label1136;
          }
        }
        for (paramView = "0";; paramView = "1")
        {
          bbbb.a("Grp_contacts_news", "notice", "ignore_invite", 0, 0, new String[] { str2, str1, paramView });
          return;
          i = 0;
          break;
        }
      } while (paramView != this.a.jdField_d_of_type_AndroidWidgetTextView);
      if (this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 80)
      {
        paramView = TroopInfoActivity.a(this.a.jdField_a_of_type_JavaLangString, 5);
        TroopInfoActivity.a(this.a.getActivity(), paramView);
        return;
      }
      if (((TroopManager)this.a.app.getManager(52)).b(this.a.jdField_a_of_type_JavaLangString) != null) {}
      while (((this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 11) && (this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() == 3)) || (this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 7))
      {
        this.a.h();
        TroopRequestActivity.a(this.a, this.a.app, str2, this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, this.a.jdField_a_of_type_Afnv);
        bbbb.a("Grp_contacts_news", "notice", "again_join", 0, 0, new String[] { str2 });
        return;
        asfd.a().b(this.a.jdField_a_of_type_JavaLangString, this.a.app);
      }
    } while ((this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 10) || (this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 3));
    label852:
    label1136:
    this.a.h();
    label936:
    paramView = new ArrayList();
    paramView.add(TroopRequestActivity.a(this.a));
    if ((paramView.size() > 0) && (this.a.jdField_a_of_type_JavaLangString.length() > 0)) {
      ((akhq)this.a.app.a(20)).a(this.a.jdField_a_of_type_JavaLangString, paramView, "");
    }
    bbbb.a("Grp_contacts_news", "notice", "again_invite", 0, 0, new String[] { str2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aclq
 * JD-Core Version:    0.7.0.1
 */