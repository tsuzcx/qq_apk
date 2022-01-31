import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.widget.QQToast;

public class aeaw
  implements View.OnClickListener
{
  public aeaw(TroopMemberListActivity paramTroopMemberListActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.f) && (!TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity)))
    {
      if (((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.d == 11) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_Int > 0)) || (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.d == 3))
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getIntent();
        paramView.putExtra("member_uin", "0");
        paramView.putExtra("member_display_name", this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.setResult(-1, paramView);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.finish();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.d == 11) {
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app, "CliOper", "", "", "0X800621D", "0X800621D", 0, 0, "", "", "", "");
        }
        return;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity, alpo.a(2131716011), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidViewView.getHeight());
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.g))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.g, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidViewView.getHeight());
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity, alpo.a(2131715971), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidViewView.getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeaw
 * JD-Core Version:    0.7.0.1
 */