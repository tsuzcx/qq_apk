import android.view.View;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class aehy
  implements bhuk
{
  public aehy(TroopRequestActivity paramTroopRequestActivity, bhuf parambhuf) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 20011;
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Bhuf.dismiss();
      return;
    }
    if (bdin.d(BaseApplication.getContext())) {
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
          zdv.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.s, String.valueOf(l), paramView, paramInt, null);
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        continue;
      }
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.app, "P_CliOper", "Grp_sysmsg", "", "verify_msg", "report", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.t, "", "");
      break;
      paramInt = 20009;
      continue;
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity, 2131694768, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.getTitleBarHeight());
      continue;
      paramInt = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aehy
 * JD-Core Version:    0.7.0.1
 */