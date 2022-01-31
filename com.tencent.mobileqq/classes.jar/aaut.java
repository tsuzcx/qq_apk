import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

class aaut
  implements begw
{
  aaut(aaur paramaaur, int[] paramArrayOfInt, mjj parammjj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = this.jdField_a_of_type_ArrayOfInt[paramInt];
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "videoActionSheet onClick,showItems =  " + Arrays.toString(this.jdField_a_of_type_ArrayOfInt) + ",which = " + paramInt + ",item = " + i);
    }
    this.jdField_a_of_type_Mjj.dismiss();
    switch (i)
    {
    default: 
      return;
    case 1: 
      FriendProfileCardActivity.a(this.jdField_a_of_type_Aaur.a.app, this.jdField_a_of_type_Aaur.a, this.jdField_a_of_type_Aaur.a.a);
      awqx.b(this.jdField_a_of_type_Aaur.a.app, "CliOper", "", "", "0X8008405", "0X8008405", 0, 0, "", "", "", "");
      return;
    }
    paramView = new SessionInfo();
    paramView.jdField_a_of_type_Int = azyk.a(this.jdField_a_of_type_Aaur.a.a.a);
    paramView.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Aaur.a.a.a.jdField_a_of_type_JavaLangString;
    paramView.d = FriendProfileCardActivity.a(this.jdField_a_of_type_Aaur.a.a, this.jdField_a_of_type_Aaur.a.app);
    paramView.b = this.jdField_a_of_type_Aaur.a.a.a.d;
    acnc.a(this.jdField_a_of_type_Aaur.a.app, this.jdField_a_of_type_Aaur.a, paramView, false, null, null);
    awqx.b(this.jdField_a_of_type_Aaur.a.app, "CliOper", "", "", "0X80085D6", "0X80085D6", 9, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaut
 * JD-Core Version:    0.7.0.1
 */