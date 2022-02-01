import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aipo
  implements View.OnClickListener
{
  aipo(aipm paramaipm) {}
  
  public void onClick(View paramView)
  {
    agej.n = true;
    int i;
    switch (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Clk_aio_right", 0, 0, String.valueOf(i), "", "", "");
      agju.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, null, this.a);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipo
 * JD-Core Version:    0.7.0.1
 */