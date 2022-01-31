import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class ahls
  implements View.OnClickListener
{
  public ahls(TroopSuspiciousFragment paramTroopSuspiciousFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject1;
    if ((paramView.getTag() instanceof ahkp))
    {
      localObject1 = (ahkp)paramView.getTag();
      if (localObject1 != null) {
        break label25;
      }
    }
    label25:
    Object localObject2;
    int i;
    label187:
    do
    {
      return;
      localObject2 = ((ahkp)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
      i = ((ahkp)localObject1).jdField_a_of_type_Int;
      if (ahla.a(i) == 0)
      {
        paramView = TroopInfoActivity.a(String.valueOf(((ahkp)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), 4);
        paramView.putInt("t_s_f", 1001);
        bclo.a(this.a.getActivity(), paramView, 2);
        if ((i == 2) || (i == 10) || (i == 12))
        {
          i = 1;
          localObject2 = TroopSuspiciousFragment.a(this.a);
          localObject1 = ((ahkp)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
          if (i == 0) {
            break label187;
          }
        }
        for (paramView = "0";; paramView = "1")
        {
          azmj.b((QQAppInterface)localObject2, "P_CliOper", "Grp_contacts", "", "notice", "see_data", 0, 0, (String)localObject1, paramView, "", "");
          return;
          i = 0;
          break;
        }
      }
    } while ((((ahkp)localObject1).jdField_a_of_type_Int == 2) && (TroopInfo.isQidianPrivateTroop(((ahkp)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get())));
    if (((ahkp)localObject1).jdField_a_of_type_Int == 82)
    {
      paramView = new Intent(this.a.a, AccountDetailActivity.class);
      paramView.putExtra("uin", ((ahkp)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
      paramView.putExtra("source", 112);
      this.a.startActivity(paramView);
      return;
    }
    long l = ((structmsg.StructMsg)localObject2).req_uin.get();
    switch (ahla.a(i))
    {
    default: 
      paramView = String.valueOf(l);
      label345:
      if (((aloz)TroopSuspiciousFragment.a(this.a).getManager(51)).b(paramView)) {
        paramView = new ProfileActivity.AllInOne(paramView, 1);
      }
      break;
    }
    for (;;)
    {
      l = ((structmsg.StructMsg)localObject2).msg.uint32_group_flagext3.get();
      boolean bool = TroopInfo.isQidianPrivateTroop(l);
      i = ((structmsg.StructMsg)localObject2).msg.group_msg_type.get();
      if (QLog.isColorLevel()) {
        QLog.d(".troop.qidian_private_troop", 2, "notification headView onClick: msgType=" + i + ", isQidianPrivateTroop=" + bool + ", flagExt3=" + l);
      }
      if ((bool) && (i == 2)) {
        break;
      }
      ProfileActivity.b(this.a.getActivity(), paramView);
      azmj.b(TroopSuspiciousFragment.a(this.a), "P_CliOper", "Grp_contacts", "", "notice", "see_fromdata", 0, 0, ((ahkp)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "", "3", "", "");
      return;
      paramView = ((ahkp)localObject1).jdField_a_of_type_JavaLangString;
      break label345;
      paramView = String.valueOf(((ahkp)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      break label345;
      if ((((structmsg.StructMsg)localObject2).msg.group_msg_type.get() == 2) && (((structmsg.StructMsg)localObject2).msg.sub_type.get() == 3))
      {
        paramView = new ProfileActivity.AllInOne(paramView, 26);
        paramView.d = 1;
      }
      else
      {
        paramView = new ProfileActivity.AllInOne(paramView, 24);
        bclo.a((structmsg.StructMsg)localObject2, paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahls
 * JD-Core Version:    0.7.0.1
 */