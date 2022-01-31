import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class aeso
  implements View.OnClickListener
{
  aeso(aert paramaert) {}
  
  public void onClick(View paramView)
  {
    actj.n = true;
    this.a.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
    }
    if (this.a.i != null) {
      this.a.i.setVisibility(0);
    }
    if (this.a.j != null) {
      this.a.j.setVisibility(0);
    }
    this.a.aB();
    if (this.a.jdField_a_of_type_Nnu.b(this.a.a()) != 0) {
      axqy.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005EC5", "0X8005EC5", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeso
 * JD-Core Version:    0.7.0.1
 */