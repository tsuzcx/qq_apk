import android.view.View;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.widget.QQToast;

class akde
  implements bhqd
{
  akde(akdd paramakdd, boolean paramBoolean, Friends paramFriends, bhpy parambhpy) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!bdee.g(this.jdField_a_of_type_Akdd.a)) {
      QQToast.a(this.jdField_a_of_type_Akdd.a, 1, 2131692397, 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhpy.e();
      return;
      paramView = (FriendListHandler)akdd.a(this.jdField_a_of_type_Akdd).a(1);
      if (this.jdField_a_of_type_Boolean)
      {
        paramView.b(1, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin }, new boolean[] { false });
        azmj.b(akdd.a(this.jdField_a_of_type_Akdd), "dc00898", "", "", "0X800808B", "0X800808B", 0, 0, "", "", "", "");
      }
      else
      {
        paramView.b(1, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin }, new boolean[] { true });
        azmj.b(akdd.a(this.jdField_a_of_type_Akdd), "dc00898", "", "", "0X800808A", "0X800808A", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akde
 * JD-Core Version:    0.7.0.1
 */