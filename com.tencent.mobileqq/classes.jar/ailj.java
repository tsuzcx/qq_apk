import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class ailj
  implements View.OnClickListener
{
  public ailj(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onClick(View paramView)
  {
    Object localObject2;
    if ((paramView.getTag() instanceof aikf))
    {
      localObject2 = (aikf)paramView.getTag();
      if (localObject2 != null) {
        break label32;
      }
    }
    label32:
    Object localObject3;
    int i;
    Object localObject1;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject3 = ((aikf)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
      i = ((aikf)localObject2).jdField_a_of_type_Int;
      if (aiku.a(i) == 0)
      {
        localObject1 = TroopInfoActivity.a(String.valueOf(((aikf)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), 4);
        ((Bundle)localObject1).putInt("t_s_f", 1001);
        TroopUtils.openTroopInfoActivity(this.a.a(), (Bundle)localObject1, 2);
        if ((i == 2) || (i == 10) || (i == 12))
        {
          i = 1;
          label117:
          localObject3 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject2 = ((aikf)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
          if (i == 0) {
            break label201;
          }
        }
        label201:
        for (localObject1 = "0";; localObject1 = "1")
        {
          bcef.b((QQAppInterface)localObject3, "P_CliOper", "Grp_contacts", "", "notice", "see_data", 0, 0, (String)localObject2, (String)localObject1, "", "");
          break;
          i = 0;
          break label117;
        }
      }
      if ((((aikf)localObject2).jdField_a_of_type_Int != 2) || (!TroopInfo.isQidianPrivateTroop(((aikf)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get())))
      {
        if (((aikf)localObject2).jdField_a_of_type_Int != 82) {
          break;
        }
        localObject1 = new Intent(this.a.jdField_a_of_type_AndroidContentContext, AccountDetailActivity.class);
        ((Intent)localObject1).putExtra("uin", ((aikf)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
        ((Intent)localObject1).putExtra("source", 112);
        this.a.a((Intent)localObject1);
      }
    }
    long l = ((structmsg.StructMsg)localObject3).req_uin.get();
    switch (aiku.a(i))
    {
    default: 
      localObject1 = String.valueOf(l);
      label370:
      if (((amsw)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b((String)localObject1)) {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 1);
      }
      break;
    }
    for (;;)
    {
      l = ((structmsg.StructMsg)localObject3).msg.uint32_group_flagext3.get();
      boolean bool = TroopInfo.isQidianPrivateTroop(l);
      i = ((structmsg.StructMsg)localObject3).msg.group_msg_type.get();
      if (QLog.isColorLevel()) {
        QLog.d(".troop.qidian_private_troop", 2, "notification headView onClick: msgType=" + i + ", isQidianPrivateTroop=" + bool + ", flagExt3=" + l);
      }
      if ((bool) && (i == 2)) {
        break;
      }
      ProfileActivity.b(this.a.a(), (ProfileActivity.AllInOne)localObject1);
      bcef.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "see_fromdata", 0, 0, ((aikf)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "", "3", "", "");
      break;
      localObject1 = ((aikf)localObject2).jdField_a_of_type_JavaLangString;
      break label370;
      localObject1 = String.valueOf(((aikf)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      break label370;
      if ((((structmsg.StructMsg)localObject3).msg.group_msg_type.get() == 2) && (((structmsg.StructMsg)localObject3).msg.sub_type.get() == 3))
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 26);
        ((ProfileActivity.AllInOne)localObject1).d = 1;
      }
      else
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 24);
        TroopUtils.prepareTroopNotifyData((structmsg.StructMsg)localObject3, (ProfileActivity.AllInOne)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailj
 * JD-Core Version:    0.7.0.1
 */