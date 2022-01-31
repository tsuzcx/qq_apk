import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;

public class ahxo
  implements View.OnClickListener
{
  public ahxo(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment, int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getActivity(), TroopMemberListActivity.class);
    paramView.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.c);
    paramView.putExtra("param_from", 15);
    paramView.putExtra("param_seq_days", ChatHistoryTroopMemberFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment));
    paramView.putExtra("param_seq_name", ChatHistoryTroopMemberFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment));
    paramView.putExtra("TROOP_INFO_MEMBER_NUM", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.startActivityForResult(paramView, 4);
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getActivity().app, "dc00899", "Grp_mber", "", "mber_list", "clk_inacentry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.c, "" + this.b, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxo
 * JD-Core Version:    0.7.0.1
 */