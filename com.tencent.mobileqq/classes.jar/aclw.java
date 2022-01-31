import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class aclw
  implements afnv
{
  public aclw(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void a(String paramString, structmsg.StructMsg paramStructMsg, int paramInt)
  {
    int i;
    if ((TroopInfo.hasPayPrivilege(paramInt, 128)) && (TroopInfo.hasPayPrivilege(paramInt, 512)))
    {
      i = 1;
      if (i == 0) {
        break label126;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.TroopRequestActivity", 2, "onTroopPrivilege payTroop, rspTroopUin: " + paramString + ", privilegeFlag = " + paramInt);
      }
      afnu.a(this.a, paramString);
      afnu.a(this.a.app);
      this.a.i();
      axqw.b(null, "P_CliOper", "BizTechReport", "", "agree_invite", "rsp_pay_troop_getPrivilege", 0, 0, "pay_troop", "", "", "");
    }
    label126:
    do
    {
      do
      {
        do
        {
          return;
          i = 0;
          break;
          if (((this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 11) || (this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 3)) && (this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 7)) {
            break label250;
          }
        } while (this.a.jdField_a_of_type_Akhq == null);
        try
        {
          long l = Long.parseLong(this.a.jdField_a_of_type_JavaLangString);
          this.a.h();
          this.a.jdField_a_of_type_Akhq.a(l, 8390784);
          return;
        }
        catch (Exception paramString) {}
      } while (!QLog.isColorLevel());
      QLog.i("Q.systemmsg.TroopRequestActivity", 2, paramString.toString());
      return;
      this.a.h();
      TroopRequestActivity.a(this.a, 1);
    } while (this.a.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 2);
    label250:
    axqw.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "agree_invite", 0, 0, paramString, "", "0", "0");
    axqw.b(null, "P_CliOper", "BizTechReport", "", "agree_invite", "rsp_pay_troop_getPrivilege", 0, 0, "normal_troop", "", "", "");
  }
  
  public void a(String paramString1, structmsg.StructMsg paramStructMsg, int paramInt1, int paramInt2, String paramString2)
  {
    this.a.i();
    paramStructMsg = this.a;
    if (paramInt1 == 72) {}
    for (paramInt1 = 2131690026;; paramInt1 = 2131690025)
    {
      bcpw.a(paramStructMsg, paramInt1, 1).a();
      axqw.b(null, "P_CliOper", "BizTechReport", "", "agree_invite", "rsp_pay_troop_getPrivilege", 0, 0, "err", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.e("Q.systemmsg.TroopRequestActivity", 2, "NotificationView onTroopPrivilege network! error rspTroopUin = " + paramString1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aclw
 * JD-Core Version:    0.7.0.1
 */