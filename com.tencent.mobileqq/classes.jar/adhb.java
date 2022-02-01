import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity.10.1;
import com.tencent.mobileqq.activity.ForwardTroopListFragment;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import eipc.EIPCClient;
import java.util.ArrayList;
import java.util.Map;

public class adhb
  implements View.OnClickListener
{
  public adhb(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131366179)
    {
      ForwardRecentActivity.a(this.a, 10);
      bcef.b(this.a.app, "CliOper", "", "", "friendchoose", "0X8009D91", ForwardRecentActivity.a(this.a), 0, "", "", "", "");
    }
    label400:
    label1583:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 2131369099)
      {
        if (this.a.i)
        {
          if (this.a.jdField_a_of_type_Atky != null)
          {
            this.a.jdField_a_of_type_Atky.a(false);
            com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.f = false;
          }
          if (this.a.j) {
            QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_fail", null, null);
          }
          ForwardRecentActivity.b(this.a);
          this.a.finish();
          bcef.b(this.a.app, "CliOper", "", "", "friendchoose", "0X8009D8F", ForwardRecentActivity.a(this.a), 0, "", "", "", "");
          if (this.a.getIntent().getBooleanExtra("forward_mini_program_ark_from_sdk", false)) {
            bcef.b(this.a.app, "dc00898", "", "", "0X8009F7A", "0X8009F7A", 0, 0, "2", "", "", "");
          }
        }
        for (;;)
        {
          break;
          if (ForwardRecentActivity.a(this.a))
          {
            ForwardRecentActivity.c(this.a);
            bcef.b(this.a.app, "CliOper", "", "", "friendchoose", "0X8009D98", ForwardRecentActivity.a(this.a), 0, "", "", "", ForwardRecentActivity.a(this.a));
          }
          else
          {
            ForwardRecentActivity.d(this.a);
            bcef.b(this.a.app, "CliOper", "", "", "friendchoose", "0X8009D93", ForwardRecentActivity.a(this.a), 0, "", "", "", ForwardRecentActivity.a(this.a));
          }
        }
      }
      if (i == 2131369070)
      {
        if (ForwardRecentActivity.a(this.a))
        {
          ForwardRecentActivity.e(this.a);
          bcef.b(this.a.app, "CliOper", "", "", "friendchoose", "0X8009D94", ForwardRecentActivity.a(this.a), 0, "", "", "", "");
        }
      }
      else
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("call_by_forward", true);
        if (this.a.jdField_a_of_type_AndroidNetUri != null) {
          ((Intent)localObject1).setData(this.a.jdField_a_of_type_AndroidNetUri);
        }
        localObject2 = this.a.jdField_a_of_type_Atky.a();
        if (!((Bundle)localObject2).getBoolean("sendMultiple", false)) {
          break label947;
        }
        ((Intent)localObject1).putStringArrayListExtra("foward_key_m_p_l", ((Bundle)localObject2).getStringArrayList("foward_key_m_p_l"));
        label475:
        ((Intent)localObject1).putExtras(this.a.jdField_a_of_type_Atky.a());
        if (!this.a.getIntent().getBooleanExtra("isFromShare", false)) {
          break label966;
        }
        ((Intent)localObject1).putExtras(this.a.jdField_a_of_type_Atky.a());
        ((Intent)localObject1).setAction(this.a.getIntent().getAction());
      }
      for (;;)
      {
        switch (paramView.getId())
        {
        case 2131367079: 
        case 2131367082: 
        case 2131367083: 
        case 2131367084: 
        default: 
          break;
        case 2131367078: 
          this.a.a("0X8007824");
          ForwardRecentActivity.a(this.a, (Intent)localObject1);
          bcef.b(this.a.app, "CliOper", "", "", "0X800665F", "0X800665F", 0, 0, "", "", "", "");
          ((Intent)localObject1).setClass(this.a, ForwardFriendListActivity.class);
          ((Intent)localObject1).putExtra("extra_choose_friend", 5);
          ((Intent)localObject1).putExtra("only_single_selection", this.a.i);
          ((Intent)localObject1).putParcelableArrayListExtra("selected_target_list", new ArrayList(ForwardRecentActivity.a(this.a).values()));
          this.a.startActivityForResult((Intent)localObject1, 20000);
          bcef.b(this.a.app, "CliOper", "", "", "Two_call", "Tc_msg_cate", 0, 0, "0", "", "", "");
          bcef.b(this.a.app, "CliOper", "", "", "friendchoose", "0X8009D95", ForwardRecentActivity.a(this.a), 0, "", "", "", "");
          if (!this.a.jdField_c_of_type_Boolean) {
            break;
          }
          if ((this.a.b != 1) || (this.a.jdField_c_of_type_Int != 1)) {
            break label1086;
          }
          bcef.b(this.a.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.buyerselectpage.select", 0, 0, "", "", "", "");
          break;
          if (this.a.jdField_a_of_type_Atky != null)
          {
            this.a.jdField_a_of_type_Atky.a(false);
            com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.f = false;
          }
          this.a.finish();
          bcef.b(this.a.app, "CliOper", "", "", "friendchoose", "0X8009D8F", ForwardRecentActivity.a(this.a), 0, "", "", "", "");
          if (!"caller_aecamera".equals(this.a.jdField_c_of_type_JavaLangString)) {
            break label400;
          }
          QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", "ae_camera_get_info_client", "action_get_cancle_send_info", null, null);
          break label400;
          label947:
          ((Intent)localObject1).putExtra("forward_filepath", ((Bundle)localObject2).getString("forward_filepath"));
          break label475;
          label966:
          ((Intent)localObject1).putExtras(this.a.getIntent().getExtras());
        }
      }
      Object localObject1 = new ForwardRecentActivity.10.1(this, (Intent)localObject1);
      Object localObject2 = new DenyRunnable(this.a, 6);
      aihs.a(this.a, this.a.app, (Runnable)localObject1, (Runnable)localObject2);
      localObject2 = this.a.app;
      if (this.a.e) {}
      for (localObject1 = "2";; localObject1 = "1")
      {
        bcef.b((QQAppInterface)localObject2, "dc00899", "Share", "", "select_friend", "clk_addressbook", 0, 0, (String)localObject1, "", "", "");
        break;
      }
      label1086:
      if ((this.a.b == 1) && (this.a.jdField_c_of_type_Int == 2))
      {
        bcef.b(this.a.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.payerselectpage.select", 0, 0, "", "", "", "");
        continue;
        this.a.a("0X8007826");
        i = 1;
        if (!this.a.jdField_a_of_type_Atky.a(atku.b)) {
          i = 2;
        }
        localObject1 = new Intent(this.a, SelectMemberActivity.class);
        ((Intent)localObject1).putExtra("param_type", 3000);
        ((Intent)localObject1).putExtra("param_subtype", 0);
        ((Intent)localObject1).putExtra("param_done_button_wording", this.a.getString(2131718085));
        ((Intent)localObject1).putExtra("param_done_button_highlight_wording", this.a.getString(2131718086));
        ((Intent)localObject1).putExtra("param_min", i);
        ((Intent)localObject1).putExtra("param_max", 99);
        ((Intent)localObject1).putExtra("param_donot_need_contacts", true);
        ((Intent)localObject1).putExtra("param_entrance", 12);
        this.a.startActivityForResult((Intent)localObject1, 20003);
        bcef.b(this.a.app, "CliOper", "", "", "friendchoose", "0X8009D92", ForwardRecentActivity.a(this.a), 0, "", "", "", "");
        continue;
        ForwardRecentActivity.a(this.a, (Intent)localObject1);
        if (this.a.i)
        {
          this.a.a("0X8007825");
          ((Intent)localObject1).setClass(this.a, TroopActivity.class);
          if (!this.a.jdField_a_of_type_Atky.a(atku.d))
          {
            ((Intent)localObject1).putExtra("onlyOneSegement", true);
            ((Intent)localObject1).putExtra("_key_mode", 0);
            ((Intent)localObject1).putExtra("key_tab_mode", 1);
            ((Intent)localObject1).putExtra("only_single_selection", this.a.i);
            this.a.startActivityForResult((Intent)localObject1, 20000);
            localObject2 = this.a.app;
            if (!this.a.e) {
              break label1583;
            }
          }
          for (localObject1 = "2";; localObject1 = "1")
          {
            bcef.b((QQAppInterface)localObject2, "dc00899", "Share", "", "select_friend", "clk_group", 0, 0, (String)localObject1, "", "", "");
            new bcek(this.a.app).a("dc00899").b("Grp_listNew").c("send_to").d("clk_grpList").a();
            break;
            if (this.a.jdField_a_of_type_Atky.a(atku.c)) {
              break label1418;
            }
            ((Intent)localObject1).putExtra("onlyOneSegement", true);
            ((Intent)localObject1).putExtra("_key_mode", 1);
            ((Intent)localObject1).putExtra("key_tab_mode", 1);
            break label1418;
          }
        }
        ((Intent)localObject1).putParcelableArrayListExtra("selected_target_list", new ArrayList(ForwardRecentActivity.a(this.a).values()));
        ((Intent)localObject1).putExtra("public_fragment_window_feature", 1);
        adxr.a(this.a, (Intent)localObject1, PublicTransFragmentActivity.class, ForwardTroopListFragment.class, 20000);
        bcef.b(this.a.app, "CliOper", "", "", "friendchoose", "0X8009D96", ForwardRecentActivity.a(this.a), 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adhb
 * JD-Core Version:    0.7.0.1
 */