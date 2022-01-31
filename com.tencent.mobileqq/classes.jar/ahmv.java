import android.view.View;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.widget.QQToast;

class ahmv
  implements bhqd
{
  ahmv(ahmt paramahmt, boolean paramBoolean, Friends paramFriends, bhpy parambhpy) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!bdee.g(ahmt.a(this.jdField_a_of_type_Ahmt))) {
      QQToast.a(ahmt.a(this.jdField_a_of_type_Ahmt), 1, 2131692397, 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhpy.e();
      return;
      paramView = (FriendListHandler)ahmt.a(this.jdField_a_of_type_Ahmt).a(1);
      if (this.jdField_a_of_type_Boolean) {
        paramView.b(1, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin }, new boolean[] { false });
      } else {
        paramView.b(1, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin }, new boolean[] { true });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmv
 * JD-Core Version:    0.7.0.1
 */