import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aiod
  implements View.OnClickListener
{
  aiod(ainh paramainh) {}
  
  public void onClick(View paramView)
  {
    agej.n = true;
    this.a.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
    }
    if (this.a.h != null) {
      this.a.h.setVisibility(0);
    }
    if (this.a.i != null) {
      this.a.i.setVisibility(0);
    }
    this.a.aA();
    if (this.a.jdField_a_of_type_Obj.b(this.a.a()) != 0) {
      bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005EC5", "0X8005EC5", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiod
 * JD-Core Version:    0.7.0.1
 */