import android.support.v4.app.FragmentActivity;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

class aese
  implements xeb
{
  aese(aerv paramaerv) {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    actn.n = true;
    this.a.d = new bcpq(aerv.d(this.a).getContext(), this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
    long l = NetConnInfoCenter.getServerTime();
    String str2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
    String str1;
    if ("DO_FOLLOW".equals(paramString)) {
      if (aerv.c(this.a))
      {
        aerv.a(this.a);
        str1 = "";
        paramString = str1;
        if (this.a.jdField_a_of_type_Azon != null)
        {
          paramString = str1;
          if (this.a.jdField_a_of_type_Azon.a != null)
          {
            paramString = str1;
            if (this.a.jdField_a_of_type_Azon.a.size() > 0) {
              paramString = ((TroopInfo)this.a.jdField_a_of_type_Azon.a.get(0)).troopuin;
            }
          }
        }
        axqw.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_public", "", "oper", "Clk_close_temp", 0, 0, paramString, "" + str2, "", "");
        this.a.jdField_a_of_type_Nnx.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, new aesf(this));
      }
    }
    do
    {
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) {
        noo.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004EF5", "0X8004EF5", 0, 0, Long.toString(l), "", "" + this.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId, aerv.a(this.a), false);
      }
      this.a.A(2131695619);
      this.a.bw();
      return;
      if ("DO_NOT_FOLLOW".equals(paramString))
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) {
          noo.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004EF7", "0X8004EF7", 0, 0, Long.toString(l), "", "" + this.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId, "" + aerv.a(this.a), false);
        }
        if (aerv.c(this.a))
        {
          aerv.a(this.a, str2);
          str1 = "";
          paramString = str1;
          if (this.a.jdField_a_of_type_Azon != null)
          {
            paramString = str1;
            if (this.a.jdField_a_of_type_Azon.a != null)
            {
              paramString = str1;
              if (this.a.jdField_a_of_type_Azon.a.size() > 0) {
                paramString = ((TroopInfo)this.a.jdField_a_of_type_Azon.a.get(0)).troopuin;
              }
            }
          }
          axqw.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_public", "", "oper", "Clk_focus_temp", 0, 0, paramString, "" + str2, "", "");
          return;
        }
        this.a.bt();
        return;
      }
    } while (!"DO_CANCEL".equals(paramString));
    this.a.A(2131695619);
    aerv.a(this.a, nnx.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 0, false, BaseApplication.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new aesg(this)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aese
 * JD-Core Version:    0.7.0.1
 */