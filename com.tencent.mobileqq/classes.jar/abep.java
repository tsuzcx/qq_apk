import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

class abep
  implements bfoq
{
  abep(abel paramabel, int[] paramArrayOfInt, mui parammui) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = this.jdField_a_of_type_ArrayOfInt[paramInt];
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "videoActionSheet onClick,showItems =  " + Arrays.toString(this.jdField_a_of_type_ArrayOfInt) + ",which = " + paramInt + ",item = " + i);
    }
    this.jdField_a_of_type_Mui.dismiss();
    switch (i)
    {
    default: 
      return;
    case 1: 
      FriendProfileCardActivity.a(this.jdField_a_of_type_Abel.a.app, this.jdField_a_of_type_Abel.a, this.jdField_a_of_type_Abel.a.a);
      axqw.b(this.jdField_a_of_type_Abel.a.app, "CliOper", "", "", "0X8008405", "0X8008405", 0, 0, "", "", "", "");
      return;
    }
    paramView = new SessionInfo();
    paramView.jdField_a_of_type_Int = bazo.a(this.jdField_a_of_type_Abel.a.a.a);
    paramView.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Abel.a.a.a.jdField_a_of_type_JavaLangString;
    paramView.d = FriendProfileCardActivity.a(this.jdField_a_of_type_Abel.a.a, this.jdField_a_of_type_Abel.a.app);
    paramView.b = this.jdField_a_of_type_Abel.a.a.a.d;
    acxv.a(this.jdField_a_of_type_Abel.a.app, this.jdField_a_of_type_Abel.a, paramView, false, null, null);
    axqw.b(this.jdField_a_of_type_Abel.a.app, "CliOper", "", "", "0X80085D6", "0X80085D6", 9, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abep
 * JD-Core Version:    0.7.0.1
 */