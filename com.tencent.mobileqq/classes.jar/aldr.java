import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment.ExtendFriendInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;

public class aldr
  implements View.OnClickListener
{
  public aldr(ProfileCardMoreInfoView paramProfileCardMoreInfoView, Card paramCard) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
      paramView.putExtra("key_extend_friend_info", new ExtendFriendProfileEditFragment.ExtendFriendInfo(this.jdField_a_of_type_ComTencentMobileqqDataCard));
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092DB", "0X80092DB", 0, 0, "", "", "", "");
    PublicFragmentActivity.a(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, ExtendFriendEditFragment.class, 4097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aldr
 * JD-Core Version:    0.7.0.1
 */