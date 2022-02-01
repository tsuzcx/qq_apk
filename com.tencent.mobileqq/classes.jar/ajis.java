import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Friends;
import mqq.app.QQPermissionCallback;

class ajis
  implements QQPermissionCallback
{
  ajis(ajiq paramajiq, View paramView, Friends paramFriends, BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bglp.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    ajiq.a(this.jdField_a_of_type_Ajiq, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDataFriends);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajis
 * JD-Core Version:    0.7.0.1
 */