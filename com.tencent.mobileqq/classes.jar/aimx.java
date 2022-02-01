import android.view.View;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

class aimx
  implements bjoe
{
  aimx(aimv paramaimv, boolean paramBoolean, Friends paramFriends, bjnw parambjnw) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(aimv.a(this.jdField_a_of_type_Aimv))) {
      QQToast.a(aimv.a(this.jdField_a_of_type_Aimv), 1, 2131692035, 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bjnw.e();
      return;
      paramView = (FriendListHandler)aimv.a(this.jdField_a_of_type_Aimv).getBusinessHandler(1);
      if (this.jdField_a_of_type_Boolean) {
        paramView.setSpecialCareSwitch(1, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin }, new boolean[] { false });
      } else {
        paramView.setSpecialCareSwitch(1, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin }, new boolean[] { true });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimx
 * JD-Core Version:    0.7.0.1
 */