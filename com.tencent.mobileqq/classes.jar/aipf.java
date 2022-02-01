import android.view.View;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

class aipf
  implements bjoe
{
  aipf(aipe paramaipe, boolean paramBoolean, Friends paramFriends, bjnw parambjnw) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_Aipe.a)) {
      QQToast.a(this.jdField_a_of_type_Aipe.a, 1, 2131692035, 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bjnw.e();
      return;
      paramView = (FriendListHandler)aipe.a(this.jdField_a_of_type_Aipe).getBusinessHandler(1);
      if (this.jdField_a_of_type_Boolean)
      {
        paramView.setSpecialCareSwitch(1, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin }, new boolean[] { false });
        bcef.b(aipe.a(this.jdField_a_of_type_Aipe), "dc00898", "", "", "0X800808B", "0X800808B", 0, 0, "", "", "", "");
      }
      else
      {
        paramView.setSpecialCareSwitch(1, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin }, new boolean[] { true });
        bcef.b(aipe.a(this.jdField_a_of_type_Aipe), "dc00898", "", "", "0X800808A", "0X800808A", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipf
 * JD-Core Version:    0.7.0.1
 */