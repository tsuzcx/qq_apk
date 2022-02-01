import android.view.View;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.widget.QQToast;

class ajui
  implements bliz
{
  ajui(ajuh paramajuh, boolean paramBoolean, Friends paramFriends, blir paramblir) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!bhnv.g(this.jdField_a_of_type_Ajuh.a)) {
      QQToast.a(this.jdField_a_of_type_Ajuh.a, 1, 2131691989, 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Blir.e();
      return;
      paramView = (FriendListHandler)ajuh.a(this.jdField_a_of_type_Ajuh).a(1);
      if (this.jdField_a_of_type_Boolean)
      {
        paramView.b(1, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin }, new boolean[] { false });
        bdll.b(ajuh.a(this.jdField_a_of_type_Ajuh), "dc00898", "", "", "0X800808B", "0X800808B", 0, 0, "", "", "", "");
      }
      else
      {
        paramView.b(1, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin }, new boolean[] { true });
        bdll.b(ajuh.a(this.jdField_a_of_type_Ajuh), "dc00898", "", "", "0X800808A", "0X800808A", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajui
 * JD-Core Version:    0.7.0.1
 */