import android.support.v4.app.FragmentActivity;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

class aesc
  implements xdy
{
  aesc(aert paramaert) {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    actj.n = true;
    this.a.d = new bcqf(aert.d(this.a).getContext(), this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
    long l = NetConnInfoCenter.getServerTime();
    String str2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
    String str1;
    if ("DO_FOLLOW".equals(paramString)) {
      if (aert.c(this.a))
      {
        aert.a(this.a);
        str1 = "";
        paramString = str1;
        if (this.a.jdField_a_of_type_Azop != null)
        {
          paramString = str1;
          if (this.a.jdField_a_of_type_Azop.a != null)
          {
            paramString = str1;
            if (this.a.jdField_a_of_type_Azop.a.size() > 0) {
              paramString = ((TroopInfo)this.a.jdField_a_of_type_Azop.a.get(0)).troopuin;
            }
          }
        }
        axqy.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_public", "", "oper", "Clk_close_temp", 0, 0, paramString, "" + str2, "", "");
        this.a.jdField_a_of_type_Nnu.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, new aesd(this));
      }
    }
    do
    {
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) {
        nol.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004EF5", "0X8004EF5", 0, 0, Long.toString(l), "", "" + this.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId, aert.a(this.a), false);
      }
      this.a.A(2131695620);
      this.a.bw();
      return;
      if ("DO_NOT_FOLLOW".equals(paramString))
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) {
          nol.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004EF7", "0X8004EF7", 0, 0, Long.toString(l), "", "" + this.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId, "" + aert.a(this.a), false);
        }
        if (aert.c(this.a))
        {
          aert.a(this.a, str2);
          str1 = "";
          paramString = str1;
          if (this.a.jdField_a_of_type_Azop != null)
          {
            paramString = str1;
            if (this.a.jdField_a_of_type_Azop.a != null)
            {
              paramString = str1;
              if (this.a.jdField_a_of_type_Azop.a.size() > 0) {
                paramString = ((TroopInfo)this.a.jdField_a_of_type_Azop.a.get(0)).troopuin;
              }
            }
          }
          axqy.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_public", "", "oper", "Clk_focus_temp", 0, 0, paramString, "" + str2, "", "");
          return;
        }
        this.a.bt();
        return;
      }
    } while (!"DO_CANCEL".equals(paramString));
    this.a.A(2131695620);
    aert.a(this.a, nnu.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 0, false, BaseApplication.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new aese(this)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aesc
 * JD-Core Version:    0.7.0.1
 */