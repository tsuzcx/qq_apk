import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aent
  implements View.OnClickListener
{
  public aent(TroopMemberListActivity paramTroopMemberListActivity, int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity, TroopMemberListActivity.class);
    localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.b);
    localIntent.putExtra("param_from", 15);
    localIntent.putExtra("param_seq_days", TroopMemberListActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity));
    localIntent.putExtra("param_seq_name", TroopMemberListActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity));
    localIntent.putExtra("TROOP_INFO_MEMBER_NUM", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.startActivityForResult(localIntent, 4);
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app, "dc00899", "Grp_mber", "", "mber_list", "clk_inacentry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.b, "" + this.b, "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aent
 * JD-Core Version:    0.7.0.1
 */