import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class ajfu
  implements View.OnClickListener
{
  public ajfu(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onClick(View paramView)
  {
    if (!(paramView.getTag() instanceof ajeg)) {}
    ajeg localajeg;
    Object localObject1;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localajeg = (ajeg)paramView.getTag();
      if (localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 80) {
        break;
      }
      localObject1 = TroopInfoActivity.a(String.valueOf(localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), 5);
      TroopInfoActivity.a(this.a.a(), (Bundle)localObject1);
    }
    if (this.a.c == 1) {
      bdla.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "todotab_notice_confirm", 2, 0, String.valueOf(localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), String.valueOf(localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq), "");
    }
    for (;;)
    {
      if (NetworkUtil.isNetSupport(this.a.a())) {
        break label286;
      }
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.a().getString(2131694253), 0).b(this.a.a());
      break;
      bdla.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "todotab_notice_confirm", 1, 0, String.valueOf(localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), String.valueOf(localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq), "");
    }
    label286:
    ((FriendListHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(String.valueOf(localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
    TroopNotifyAndRecommendView.a(this.a, (structmsg.StructMsg)localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), localajeg.c);
    String str1 = localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get();
    String str2 = localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
    Object localObject2;
    if (localajeg.jdField_a_of_type_Int == 91)
    {
      localObject2 = (TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if ((localObject2 != null) && ((localajeg.jdField_a_of_type_Ajhy instanceof ajhw)))
      {
        localObject1 = (ajhw)localajeg.jdField_a_of_type_Ajhy;
        localObject2 = ((TroopManager)localObject2).b(String.valueOf(((ajhw)localObject1).e));
        if (localObject2 == null) {
          break label1214;
        }
      }
    }
    label539:
    label566:
    label1214:
    for (long l = ((TroopInfo)localObject2).dwGroupClassExt;; l = 0L)
    {
      bdla.b(null, "dc00898", "", String.valueOf(((ajhw)localObject1).e), "0X800B4B3", "0X800B4B3", 0, 0, String.valueOf(l), "", "", "");
      int i;
      if ((this.a.jdField_a_of_type_Ajep != null) && (localajeg.b < this.a.jdField_a_of_type_Ajep.jdField_a_of_type_Int))
      {
        localObject1 = "1";
        i = localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
        if ((i != 2) && (i != 3)) {
          break label668;
        }
        i = 0;
        if (i == 0) {
          break label673;
        }
        localObject2 = "0";
        label574:
        if ((str1 != null) && (!"".equals(str1))) {
          break label1098;
        }
        if (localajeg.jdField_a_of_type_Int != 82) {
          break label680;
        }
        TroopNotifyAndRecommendView.a(this.a, localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get(), (structmsg.StructMsg)localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
      }
      for (;;)
      {
        TroopNotifyAndRecommendView.m(this.a);
        this.a.jdField_a_of_type_Bisl.c(2131718527);
        this.a.jdField_a_of_type_Bisl.show();
        break;
        localObject1 = "0";
        break label539;
        i = 1;
        break label566;
        localObject2 = "1";
        break label574;
        if (localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopNotifyAndRecommendView", 2, "doCheckPayTroopReq start: " + str2);
          }
          if (((localajeg.jdField_a_of_type_Ajhy instanceof ajia)) && (((ajia)localajeg.jdField_a_of_type_Ajhy).jdField_a_of_type_Int != 0))
          {
            if (QLog.isColorLevel()) {
              QLog.i("TroopNotifyAndRecommendView", 2, "showJoinTroopSafeDialog");
            }
            ajgr.a(this.a.a(), TroopNotifyAndRecommendView.a(this.a), new Object[] { localajeg, str2, localObject1, localObject2 });
            break;
          }
          TroopRequestActivity.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, this.a.jdField_a_of_type_Ajfr);
          bhbu.a("Grp_contacts_news", "notice", "agree_invite", 0, 0, new String[] { str2, localObject1, localObject2, "0" });
          continue;
        }
        TroopNotifyAndRecommendView.a(this.a, 1, (structmsg.StructMsg)localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
        if ((localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has()) && (localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.has())) {
          ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(str2, localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "", localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get());
        }
        if (localajeg.jdField_a_of_type_Int == 1)
        {
          bhbu.a("Grp_contacts_news", "notice", "agree_ask", 0, 0, new String[] { str2, localObject1, localObject2, "0" });
        }
        else if (localajeg.jdField_a_of_type_Int == 2)
        {
          bhbu.a("Grp_contacts_news", "notice", "agree_invite", 0, 0, new String[] { str2, localObject1, localObject2, "0" });
          continue;
          label1098:
          TroopNotifyAndRecommendView.a(this.a, 0, (structmsg.StructMsg)localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
          if (localajeg.jdField_a_of_type_Int == 1) {
            bhbu.a("Grp_contacts_news", "notice", "refuse_ask", 0, 0, new String[] { str2, localObject1, localObject2, "0" });
          } else if (localajeg.jdField_a_of_type_Int == 2) {
            bhbu.a("Grp_contacts_news", "notice", "refuse_invite", 0, 0, new String[] { str2, localObject1, localObject2, "0" });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajfu
 * JD-Core Version:    0.7.0.1
 */