import com.tencent.mobileqq.activity.TroopInviteStatusFragment;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class aemh
  implements aikv
{
  public aemh(TroopInviteStatusFragment paramTroopInviteStatusFragment) {}
  
  public void a(String paramString, structmsg.StructMsg paramStructMsg, int paramInt)
  {
    if ((TroopInfo.hasPayPrivilege(paramInt, 128)) && (TroopInfo.hasPayPrivilege(paramInt, 512))) {}
    for (int i = 1; i != 0; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopInviteStatusFragment", 2, "onTroopPrivilege payTroop, rspTroopUin: " + paramString + ", privilegeFlag = " + paramInt);
      }
      aiku.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString, "");
      aiku.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((this.a.jdField_a_of_type_Bhht != null) && (this.a.jdField_a_of_type_Bhht.isShowing())) {
        this.a.jdField_a_of_type_Bhht.dismiss();
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopInviteStatusFragment", 2, "onTroopPrivilege normalTroop, rspTroopUin: " + paramString + ", privilegeFlag = " + paramInt + ", sendSystemMsgAction-----");
    }
    TroopInviteStatusFragment.a(this.a, 2);
  }
  
  public void a(String paramString1, structmsg.StructMsg paramStructMsg, int paramInt1, int paramInt2, String paramString2)
  {
    if ((this.a.jdField_a_of_type_Bhht != null) && (this.a.jdField_a_of_type_Bhht.isShowing())) {
      this.a.jdField_a_of_type_Bhht.dismiss();
    }
    if (QLog.isColorLevel()) {
      QLog.e("TroopInviteStatusFragment", 2, "NotificationView onTroopPrivilege network! error rspTroopUin = " + paramString1);
    }
    paramString1 = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    if (paramInt1 == 72) {}
    for (paramInt1 = 2131689994;; paramInt1 = 2131689993)
    {
      QQToast.a(paramString1, paramInt1, 1).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aemh
 * JD-Core Version:    0.7.0.1
 */