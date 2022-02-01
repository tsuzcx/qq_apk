import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.activity.TroopRequestRefuseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class aepr
  implements View.OnClickListener
{
  public aepr(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    if ((!NetworkUtil.isNetSupport(this.a)) && ((paramView != this.a.jdField_b_of_type_AndroidWidgetButton) || ((this.a.jdField_b_of_type_Int != 1) && (this.a.jdField_b_of_type_Int != 22))))
    {
      QQToast.a(this.a, this.a.getString(2131694062), 0).b(this.a.getTitleBarHeight());
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    this.a.jdField_a_of_type_Boolean = this.a.getIntent().getExtras().getBoolean("is_unread");
    String str = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
    int i = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
    if (this.a.jdField_a_of_type_Boolean) {}
    for (Object localObject1 = "1";; localObject1 = "0")
    {
      Object localObject2 = ((TroopManager)this.a.app.getManager(52)).b(this.a.jdField_a_of_type_JavaLangString);
      if (localObject2 != null) {}
      for (long l = ((TroopInfo)localObject2).dwGroupClassExt;; l = 0L)
      {
        if (paramView == this.a.jdField_a_of_type_AndroidWidgetButton)
        {
          if (i == 91) {
            bcef.b(null, "dc00898", "", String.valueOf(this.a.jdField_a_of_type_JavaLangString), "0X800B4B3", "0X800B4B3", 0, 0, String.valueOf(l), "", "", "");
          }
          if (localObject2 != null) {}
          for (;;)
          {
            if (this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 80) {
              break label318;
            }
            QLog.e("Q.systemmsg.TroopRequestActivity", 1, "TroopProxyActivity 已在725下架");
            break;
            avnw.a().b(this.a.jdField_a_of_type_JavaLangString, this.a.app);
          }
          label318:
          if (this.a.jdField_d_of_type_Boolean) {
            aimg.a(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, "unnormal_edit_join");
          }
          if (i == 2)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.systemmsg.TroopRequestActivity", 2, "doCheckPayTroopReq start: " + str);
            }
            this.a.g();
            TroopRequestActivity.a(this.a, this.a.app, str, this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, this.a.jdField_a_of_type_Aikv);
            i = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
            if ((i != 2) && (i != 3))
            {
              i = 1;
              label443:
              if (i == 0) {
                break label577;
              }
              localObject2 = "0";
              label451:
              bcef.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "agree_invite", 0, 0, str, (String)localObject1, (String)localObject2, "1");
            }
          }
          for (;;)
          {
            if (this.a.j == 0)
            {
              bcef.b(this.a.app, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_confirm", 1, 0, String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get()), "");
              break;
              i = 0;
              break label443;
              label577:
              localObject2 = "1";
              break label451;
              if (i == 82)
              {
                this.a.g();
                TroopRequestActivity.a(this.a, this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get(), this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg);
                bcef.b(this.a.app, "P_CliOper", "Grp_public", "", "oper", "focus_invite", 0, 0, "", "", "", this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
              }
              else if (TroopRequestActivity.a(this.a, 1))
              {
                this.a.g();
                if (i == 1)
                {
                  if ((this.a.s == null) || ("".equals(this.a.s)))
                  {
                    i = 1;
                    label736:
                    if (i == 0) {
                      break label783;
                    }
                  }
                  label783:
                  for (localObject2 = "1";; localObject2 = "0")
                  {
                    bcef.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "agree_ask", 0, 0, str, (String)localObject1, (String)localObject2, "1");
                    break;
                    i = 0;
                    break label736;
                  }
                }
              }
            }
          }
          if (this.a.j != 1) {
            break;
          }
          bcef.b(this.a.app, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_confirm", 2, 0, String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get()), "");
          break;
        }
        if (paramView == this.a.jdField_b_of_type_AndroidWidgetButton)
        {
          if (i == 91) {
            bcef.b(null, "dc00898", "", String.valueOf(this.a.jdField_a_of_type_JavaLangString), "0X800B4B5", "0X800B4B5", 0, 0, String.valueOf(l), "", "", "");
          }
          if ((this.a.jdField_b_of_type_Int == 1) || (this.a.jdField_b_of_type_Int == 22))
          {
            localObject2 = new Intent(this.a, TroopRequestRefuseActivity.class);
            this.a.startActivityForResult((Intent)localObject2, 1005);
            if (this.a.jdField_d_of_type_Boolean) {
              aimg.a(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, "unnormal_edit_reject");
            }
            bcef.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "refuse_ask_has_reason", 0, 0, str, (String)localObject1, "", "1");
            if (this.a.j == 0)
            {
              bcef.b(this.a.app, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_reject", 1, 0, String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get()), "");
              break;
            }
            if (this.a.j != 1) {
              break;
            }
            bcef.b(this.a.app, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_reject", 2, 0, String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get()), "");
            break;
          }
          if (!TroopRequestActivity.a(this.a, 0)) {
            break;
          }
          this.a.g();
          if (i == 1)
          {
            if ((this.a.s == null) || ("".equals(this.a.s)))
            {
              i = 1;
              label1275:
              if (i == 0) {
                break label1322;
              }
            }
            label1322:
            for (localObject2 = "1";; localObject2 = "0")
            {
              bcef.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "refuse_ask", 0, 0, str, (String)localObject1, (String)localObject2, "1");
              break;
              i = 0;
              break label1275;
            }
          }
          if (i != 2) {
            break;
          }
          i = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
          if ((i != 2) && (i != 3))
          {
            i = 1;
            label1363:
            if (i == 0) {
              break label1410;
            }
          }
          label1410:
          for (localObject2 = "0";; localObject2 = "1")
          {
            bcef.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "refuse_invite", 0, 0, str, (String)localObject1, (String)localObject2, "1");
            break;
            i = 0;
            break label1363;
          }
        }
        if (paramView == this.a.rightViewText)
        {
          if (this.a.jdField_b_of_type_Int == 82)
          {
            if (TroopRequestActivity.a(this.a, 0)) {
              this.a.g();
            }
            bftc.a("Grp_contacts_news", "notice", "ignore_invite", 0, 0, new String[] { str, localObject1 });
          }
          if (i == 91) {
            bcef.b(null, "dc00898", "", String.valueOf(this.a.jdField_a_of_type_JavaLangString), "0X800B4B6", "0X800B4B6", 0, 0, String.valueOf(l), "", "", "");
          }
          if (TroopRequestActivity.a(this.a, 2))
          {
            this.a.g();
            if (i != 1) {
              break label1667;
            }
            bftc.a("Grp_contacts_news", "notice", "ignore_ask", 0, 0, new String[] { str, localObject1 });
          }
          for (;;)
          {
            if (this.a.j == 0)
            {
              bcef.b(this.a.app, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_ignore", 1, 0, String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get()), "");
              break;
              label1667:
              if (i == 2)
              {
                i = this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
                if ((i != 2) && (i != 3))
                {
                  i = 1;
                  label1701:
                  if (i == 0) {
                    break label1748;
                  }
                }
                label1748:
                for (localObject2 = "0";; localObject2 = "1")
                {
                  bftc.a("Grp_contacts_news", "notice", "ignore_invite", 0, 0, new String[] { str, localObject1, localObject2 });
                  break;
                  i = 0;
                  break label1701;
                }
              }
            }
          }
          if (this.a.j != 1) {
            break;
          }
          bcef.b(this.a.app, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_ignore", 2, 0, String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), String.valueOf(this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get()), "");
          break;
        }
        if (paramView != this.a.jdField_d_of_type_AndroidWidgetTextView) {
          break;
        }
        if (this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 80)
        {
          localObject1 = TroopInfoActivity.a(this.a.jdField_a_of_type_JavaLangString, 5);
          TroopInfoActivity.a(this.a.getActivity(), (Bundle)localObject1);
          if (i != 91) {
            break;
          }
          bcef.b(null, "dc00898", "", String.valueOf(this.a.jdField_a_of_type_JavaLangString), "0X800B4B8", "0X800B4B8", 0, 0, String.valueOf(l), "", "", "");
          break;
        }
        if (localObject2 != null) {}
        for (;;)
        {
          if (((this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 11) || (this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 3)) && (this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 7)) {
            break label2101;
          }
          this.a.g();
          TroopRequestActivity.a(this.a, this.a.app, str, this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, this.a.jdField_a_of_type_Aikv);
          bftc.a("Grp_contacts_news", "notice", "again_join", 0, 0, new String[] { str });
          break;
          avnw.a().b(this.a.jdField_a_of_type_JavaLangString, this.a.app);
        }
        label2101:
        if ((this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 10) || (this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 3)) {
          break;
        }
        this.a.g();
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(TroopRequestActivity.a(this.a));
        if ((((ArrayList)localObject1).size() > 0) && (this.a.jdField_a_of_type_JavaLangString.length() > 0)) {
          ((anca)this.a.app.getBusinessHandler(20)).a(this.a.jdField_a_of_type_JavaLangString, (ArrayList)localObject1, "");
        }
        bftc.a("Grp_contacts_news", "notice", "again_invite", 0, 0, new String[] { str });
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aepr
 * JD-Core Version:    0.7.0.1
 */