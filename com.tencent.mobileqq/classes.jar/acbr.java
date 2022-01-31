import android.view.View;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class acbr
  implements begw
{
  public acbr(TroopRequestActivity paramTroopRequestActivity, begr parambegr) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 20011;
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Begr.dismiss();
      return;
    }
    if (badq.d(BaseApplication.getContext())) {
      paramInt = i;
    }
    for (;;)
    {
      try
      {
        switch (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get())
        {
        case 1: 
        case 22: 
          long l = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get();
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.app.getCurrentAccountUin();
          xbq.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.s, String.valueOf(l), paramView, paramInt, null);
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        continue;
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.app, "P_CliOper", "Grp_sysmsg", "", "verify_msg", "report", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.t, "", "");
      break;
      paramInt = 20009;
      continue;
      bbmy.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity, 2131628948, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.getTitleBarHeight());
      continue;
      paramInt = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acbr
 * JD-Core Version:    0.7.0.1
 */