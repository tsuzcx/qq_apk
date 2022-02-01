import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class afvq
  implements View.OnClickListener
{
  public afvq(TroopMemberListActivity paramTroopMemberListActivity, List paramList, CheckBox paramCheckBox, boolean paramBoolean, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (aoip)this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app.a(20);
    String str;
    if (localObject != null)
    {
      ((aoip)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.b), this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked(), this.jdField_a_of_type_Boolean);
      str = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.n;
      if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break label152;
      }
    }
    label152:
    for (localObject = "0";; localObject = "1")
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app, "P_CliOper", "Grp_manage", "", "del_mber", "Clk_del", 1, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.b, str, (String)localObject, "");
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.i();
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidAppDialog.show();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afvq
 * JD-Core Version:    0.7.0.1
 */