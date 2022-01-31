import android.view.View;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.widget.QQToast;

class akht
  implements bhuk
{
  akht(akhs paramakhs, boolean paramBoolean, Friends paramFriends, bhuf parambhuf) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!bdin.g(this.jdField_a_of_type_Akhs.a)) {
      QQToast.a(this.jdField_a_of_type_Akhs.a, 1, 2131692398, 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhuf.e();
      return;
      paramView = (FriendListHandler)akhs.a(this.jdField_a_of_type_Akhs).a(1);
      if (this.jdField_a_of_type_Boolean)
      {
        paramView.b(1, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin }, new boolean[] { false });
        azqs.b(akhs.a(this.jdField_a_of_type_Akhs), "dc00898", "", "", "0X800808B", "0X800808B", 0, 0, "", "", "", "");
      }
      else
      {
        paramView.b(1, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin }, new boolean[] { true });
        azqs.b(akhs.a(this.jdField_a_of_type_Akhs), "dc00898", "", "", "0X800808A", "0X800808A", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akht
 * JD-Core Version:    0.7.0.1
 */