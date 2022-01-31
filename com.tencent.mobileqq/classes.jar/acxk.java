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
import eipc.EIPCClient;
import java.util.ArrayList;
import java.util.Map;

public class acxk
  implements View.OnClickListener
{
  public acxk(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131365851)
    {
      ForwardRecentActivity.a(this.a, 10);
      azqs.b(this.a.app, "CliOper", "", "", "friendchoose", "0X8009D91", ForwardRecentActivity.a(this.a), 0, "", "", "", "");
    }
    label56:
    label328:
    Object localObject;
    label387:
    label462:
    do
    {
      do
      {
        return;
        if (i != 2131368655) {
          break label328;
        }
        if (!this.a.i) {
          break;
        }
        if (this.a.jdField_a_of_type_Aryv != null)
        {
          this.a.jdField_a_of_type_Aryv.a(false);
          com.tencent.mobileqq.app.PhoneContactManagerImp.f = false;
        }
        if (this.a.j) {
          QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_fail", null, null);
        }
        ForwardRecentActivity.b(this.a);
        this.a.finish();
        azqs.b(this.a.app, "CliOper", "", "", "friendchoose", "0X8009D8F", ForwardRecentActivity.a(this.a), 0, "", "", "", "");
      } while (!this.a.getIntent().getBooleanExtra("forward_mini_program_ark_from_sdk", false));
      azqs.b(this.a.app, "dc00898", "", "", "0X8009F7A", "0X8009F7A", 0, 0, "2", "", "", "");
      return;
      if (ForwardRecentActivity.a(this.a))
      {
        ForwardRecentActivity.c(this.a);
        azqs.b(this.a.app, "CliOper", "", "", "friendchoose", "0X8009D98", ForwardRecentActivity.a(this.a), 0, "", "", "", ForwardRecentActivity.a(this.a));
        return;
      }
      ForwardRecentActivity.d(this.a);
      azqs.b(this.a.app, "CliOper", "", "", "friendchoose", "0X8009D93", ForwardRecentActivity.a(this.a), 0, "", "", "", ForwardRecentActivity.a(this.a));
      return;
      Bundle localBundle;
      if (i == 2131368626)
      {
        if (ForwardRecentActivity.a(this.a))
        {
          ForwardRecentActivity.e(this.a);
          azqs.b(this.a.app, "CliOper", "", "", "friendchoose", "0X8009D94", ForwardRecentActivity.a(this.a), 0, "", "", "", "");
        }
      }
      else
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("call_by_forward", true);
        if (this.a.jdField_a_of_type_AndroidNetUri != null) {
          ((Intent)localObject).setData(this.a.jdField_a_of_type_AndroidNetUri);
        }
        localBundle = this.a.jdField_a_of_type_Aryv.a();
        if (!localBundle.getBoolean("sendMultiple", false)) {
          break label924;
        }
        ((Intent)localObject).putStringArrayListExtra("foward_key_m_p_l", localBundle.getStringArrayList("foward_key_m_p_l"));
        ((Intent)localObject).putExtras(this.a.jdField_a_of_type_Aryv.a());
        if (!this.a.getIntent().getBooleanExtra("isFromShare", false)) {
          break label943;
        }
        ((Intent)localObject).putExtras(this.a.jdField_a_of_type_Aryv.a());
        ((Intent)localObject).setAction(this.a.getIntent().getAction());
      }
      for (;;)
      {
        switch (paramView.getId())
        {
        case 2131366745: 
        case 2131366748: 
        case 2131366749: 
        case 2131366750: 
        default: 
          return;
        case 2131366744: 
          this.a.a("0X8007824");
          ForwardRecentActivity.a(this.a, (Intent)localObject);
          azqs.b(this.a.app, "CliOper", "", "", "0X800665F", "0X800665F", 0, 0, "", "", "", "");
          ((Intent)localObject).setClass(this.a, ForwardFriendListActivity.class);
          ((Intent)localObject).putExtra("extra_choose_friend", 5);
          ((Intent)localObject).putExtra("only_single_selection", this.a.i);
          ((Intent)localObject).putParcelableArrayListExtra("selected_target_list", new ArrayList(ForwardRecentActivity.a(this.a).values()));
          this.a.startActivityForResult((Intent)localObject, 20000);
          azqs.b(this.a.app, "CliOper", "", "", "Two_call", "Tc_msg_cate", 0, 0, "0", "", "", "");
          azqs.b(this.a.app, "CliOper", "", "", "friendchoose", "0X8009D95", ForwardRecentActivity.a(this.a), 0, "", "", "", "");
          if (!this.a.jdField_c_of_type_Boolean) {
            break label56;
          }
          if ((this.a.b != 1) || (this.a.jdField_c_of_type_Int != 1)) {
            break label1057;
          }
          azqs.b(this.a.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.buyerselectpage.select", 0, 0, "", "", "", "");
          return;
          if (this.a.jdField_a_of_type_Aryv != null)
          {
            this.a.jdField_a_of_type_Aryv.a(false);
            com.tencent.mobileqq.app.PhoneContactManagerImp.f = false;
          }
          this.a.finish();
          azqs.b(this.a.app, "CliOper", "", "", "friendchoose", "0X8009D8F", ForwardRecentActivity.a(this.a), 0, "", "", "", "");
          if (!"caller_aecamera".equals(this.a.jdField_c_of_type_JavaLangString)) {
            break label387;
          }
          QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", "ae_camera_get_info_client", "action_get_cancle_send_info", null, null);
          break label387;
          ((Intent)localObject).putExtra("forward_filepath", localBundle.getString("forward_filepath"));
          break label462;
          ((Intent)localObject).putExtras(this.a.getIntent().getExtras());
        }
      }
      paramView = new ForwardRecentActivity.10.1(this, (Intent)localObject);
      localObject = new DenyRunnable(this.a, 6);
      aozx.a(this.a, this.a.app, paramView, (Runnable)localObject);
      localObject = this.a.app;
      if (this.a.e) {}
      for (paramView = "2";; paramView = "1")
      {
        azqs.b((QQAppInterface)localObject, "dc00899", "Share", "", "select_friend", "clk_addressbook", 0, 0, paramView, "", "", "");
        return;
      }
    } while ((this.a.b != 1) || (this.a.jdField_c_of_type_Int != 2));
    label924:
    label943:
    azqs.b(this.a.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.payerselectpage.select", 0, 0, "", "", "", "");
    label1057:
    return;
    this.a.a("0X8007826");
    i = 1;
    if (!this.a.jdField_a_of_type_Aryv.a(aryl.b)) {
      i = 2;
    }
    paramView = new Intent(this.a, SelectMemberActivity.class);
    paramView.putExtra("param_type", 3000);
    paramView.putExtra("param_subtype", 0);
    paramView.putExtra("param_done_button_wording", this.a.getString(2131719714));
    paramView.putExtra("param_done_button_highlight_wording", this.a.getString(2131719715));
    paramView.putExtra("param_min", i);
    paramView.putExtra("param_max", 99);
    paramView.putExtra("param_donot_need_contacts", true);
    paramView.putExtra("param_entrance", 12);
    this.a.startActivityForResult(paramView, 20003);
    azqs.b(this.a.app, "CliOper", "", "", "friendchoose", "0X8009D92", ForwardRecentActivity.a(this.a), 0, "", "", "", "");
    return;
    ForwardRecentActivity.a(this.a, (Intent)localObject);
    if (this.a.i)
    {
      this.a.a("0X8007825");
      ((Intent)localObject).setClass(this.a, TroopActivity.class);
      if (!this.a.jdField_a_of_type_Aryv.a(aryl.d))
      {
        ((Intent)localObject).putExtra("onlyOneSegement", true);
        ((Intent)localObject).putExtra("_key_mode", 0);
        ((Intent)localObject).putExtra("key_tab_mode", 1);
        ((Intent)localObject).putExtra("only_single_selection", this.a.i);
        this.a.startActivityForResult((Intent)localObject, 20000);
        localObject = this.a.app;
        if (!this.a.e) {
          break label1543;
        }
      }
      label1543:
      for (paramView = "2";; paramView = "1")
      {
        azqs.b((QQAppInterface)localObject, "dc00899", "Share", "", "select_friend", "clk_group", 0, 0, paramView, "", "", "");
        new azqx(this.a.app).a("dc00899").b("Grp_listNew").c("send_to").d("clk_grpList").a();
        return;
        if (this.a.jdField_a_of_type_Aryv.a(aryl.c)) {
          break;
        }
        ((Intent)localObject).putExtra("onlyOneSegement", true);
        ((Intent)localObject).putExtra("_key_mode", 1);
        ((Intent)localObject).putExtra("key_tab_mode", 1);
        break;
      }
    }
    ((Intent)localObject).putParcelableArrayListExtra("selected_target_list", new ArrayList(ForwardRecentActivity.a(this.a).values()));
    ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
    adpn.a(this.a, (Intent)localObject, PublicTransFragmentActivity.class, ForwardTroopListFragment.class, 20000);
    azqs.b(this.a.app, "CliOper", "", "", "friendchoose", "0X8009D96", ForwardRecentActivity.a(this.a), 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     acxk
 * JD-Core Version:    0.7.0.1
 */