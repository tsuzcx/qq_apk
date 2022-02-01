import android.view.View;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.widget.QQToast;

class ajgr
  implements bkhw
{
  ajgr(ajgp paramajgp, boolean paramBoolean, Friends paramFriends, bkho parambkho) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!bgnt.g(ajgp.a(this.jdField_a_of_type_Ajgp))) {
      QQToast.a(ajgp.a(this.jdField_a_of_type_Ajgp), 1, 2131691985, 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkho.e();
      return;
      paramView = (FriendListHandler)ajgp.a(this.jdField_a_of_type_Ajgp).a(1);
      if (this.jdField_a_of_type_Boolean) {
        paramView.b(1, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin }, new boolean[] { false });
      } else {
        paramView.b(1, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin }, new boolean[] { true });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgr
 * JD-Core Version:    0.7.0.1
 */