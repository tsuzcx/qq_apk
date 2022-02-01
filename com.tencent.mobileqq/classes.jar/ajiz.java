import android.view.View;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.widget.QQToast;

class ajiz
  implements bkhw
{
  ajiz(ajiy paramajiy, boolean paramBoolean, Friends paramFriends, bkho parambkho) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!bgnt.g(this.jdField_a_of_type_Ajiy.a)) {
      QQToast.a(this.jdField_a_of_type_Ajiy.a, 1, 2131691985, 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkho.e();
      return;
      paramView = (FriendListHandler)ajiy.a(this.jdField_a_of_type_Ajiy).a(1);
      if (this.jdField_a_of_type_Boolean)
      {
        paramView.b(1, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin }, new boolean[] { false });
        bcst.b(ajiy.a(this.jdField_a_of_type_Ajiy), "dc00898", "", "", "0X800808B", "0X800808B", 0, 0, "", "", "", "");
      }
      else
      {
        paramView.b(1, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin }, new boolean[] { true });
        bcst.b(ajiy.a(this.jdField_a_of_type_Ajiy), "dc00898", "", "", "0X800808A", "0X800808A", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajiz
 * JD-Core Version:    0.7.0.1
 */