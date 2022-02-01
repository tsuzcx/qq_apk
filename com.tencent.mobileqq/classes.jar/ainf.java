import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ainf
  implements View.OnClickListener
{
  ainf(aimx paramaimx) {}
  
  public void onClick(View paramView)
  {
    agej.n = true;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1001) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 10002)) {
      bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800514F", "0X800514F", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Clk_aio_right", 0, 0, String.valueOf(0), "", "", "");
      agju.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, null, this.a);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1010) {
        bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049C6", "0X80049C6", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainf
 * JD-Core Version:    0.7.0.1
 */