import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;

public class agak
  implements View.OnClickListener
{
  public agak(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.i) && (!ChatHistoryTroopMemberFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment)))
    {
      if (((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.d == 11) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.a > 0)) || (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.d == 3))
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getActivity().getIntent();
        paramView.putExtra("member_uin", "0");
        paramView.putExtra("member_display_name", this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getActivity().setResult(-1, paramView);
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getActivity().finish();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.d == 11) {
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800621D", "0X800621D", 0, 0, "", "", "", "");
        }
        return;
      }
      bcql.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getActivity(), ajya.a(2131701665), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_b_of_type_AndroidViewView.getHeight());
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.h))
    {
      bcql.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.h, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_b_of_type_AndroidViewView.getHeight());
      return;
    }
    bcql.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getActivity(), ajya.a(2131701603), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_b_of_type_AndroidViewView.getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agak
 * JD-Core Version:    0.7.0.1
 */