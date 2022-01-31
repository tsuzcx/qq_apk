import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class afmx
  implements afnt
{
  public afmx(NotificationView paramNotificationView) {}
  
  public void a(String paramString, structmsg.StructMsg paramStructMsg, int paramInt)
  {
    int i;
    if ((TroopInfo.hasPayPrivilege(paramInt, 128)) && (TroopInfo.hasPayPrivilege(paramInt, 512)))
    {
      i = 1;
      if (i == 0) {
        break label131;
      }
      if (QLog.isColorLevel()) {
        QLog.d("NotificationView", 2, "onTroopPrivilege payTroop, rspTroopUin: " + paramString + ", privilegeFlag = " + paramInt);
      }
      afns.a(this.a.jdField_a_of_type_AndroidContentContext, paramString);
      afns.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((this.a.jdField_a_of_type_Bcqf != null) && (this.a.jdField_a_of_type_Bcqf.isShowing())) {
        this.a.jdField_a_of_type_Bcqf.dismiss();
      }
    }
    label131:
    do
    {
      return;
      i = 0;
      break;
      paramStructMsg = afns.a(paramString);
      if (paramStructMsg == null) {
        break label269;
      }
      if (QLog.isColorLevel()) {
        QLog.d("NotificationView", 2, "onTroopPrivilege normalTroop, rspTroopUin: " + paramString + ", privilegeFlag = " + paramInt + ", sendSystemMsgAction-----");
      }
      NotificationView.a(this.a, 1, (structmsg.StructMsg)paramStructMsg.get());
    } while (paramStructMsg.msg.group_msg_type.get() != 2);
    axqy.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "agree_invite", 0, 0, paramString, "", "0", "0");
    axqy.b(null, "P_CliOper", "BizTechReport", "", "agree_invite", "rsp_pay_troop_getPrivilege", 0, 0, "normal_troop", "", "", "");
    return;
    label269:
    if (QLog.isColorLevel()) {
      QLog.e("NotificationView", 2, "NotificationView onTroopPrivilege cache error--------------");
    }
    axqy.b(null, "P_CliOper", "BizTechReport", "", "agree_invite", "rsp_pay_troop_getPrivilege", 0, 0, "normal_troop_error", "", "", "");
  }
  
  public void a(String paramString1, structmsg.StructMsg paramStructMsg, int paramInt1, int paramInt2, String paramString2)
  {
    if ((this.a.jdField_a_of_type_Bcqf != null) && (this.a.jdField_a_of_type_Bcqf.isShowing())) {
      this.a.jdField_a_of_type_Bcqf.dismiss();
    }
    if (QLog.isColorLevel()) {
      QLog.e("NotificationView", 2, "NotificationView onTroopPrivilege network! error rspTroopUin = " + paramString1);
    }
    axqy.b(null, "P_CliOper", "BizTechReport", "", "agree_invite", "rsp_pay_troop_getPrivilege", 0, 0, "err", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afmx
 * JD-Core Version:    0.7.0.1
 */