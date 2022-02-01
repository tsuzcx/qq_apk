import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

class aeqg
  implements bliz
{
  aeqg(aeqc paramaeqc, int[] paramArrayOfInt, mvg parammvg) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = this.jdField_a_of_type_ArrayOfInt[paramInt];
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "videoActionSheet onClick,showItems =  " + Arrays.toString(this.jdField_a_of_type_ArrayOfInt) + ",which = " + paramInt + ",item = " + i);
    }
    this.jdField_a_of_type_Mvg.dismiss();
    switch (i)
    {
    default: 
      return;
    case 1: 
      FriendProfileCardActivity.a(this.jdField_a_of_type_Aeqc.a.app, this.jdField_a_of_type_Aeqc.a, this.jdField_a_of_type_Aeqc.a.a);
      bdll.b(this.jdField_a_of_type_Aeqc.a.app, "CliOper", "", "", "0X8008405", "0X8008405", 0, 0, "", "", "", "");
      return;
    }
    paramView = new SessionInfo();
    paramView.jdField_a_of_type_Int = bhhz.a(this.jdField_a_of_type_Aeqc.a.a.a);
    paramView.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Aeqc.a.a.a.jdField_a_of_type_JavaLangString;
    paramView.d = FriendProfileCardActivity.a(this.jdField_a_of_type_Aeqc.a.a, this.jdField_a_of_type_Aeqc.a.app);
    paramView.b = this.jdField_a_of_type_Aeqc.a.a.a.d;
    agju.a(this.jdField_a_of_type_Aeqc.a.app, this.jdField_a_of_type_Aeqc.a, paramView, false, null, null);
    bdll.b(this.jdField_a_of_type_Aeqc.a.app, "CliOper", "", "", "0X80085D6", "0X80085D6", 9, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeqg
 * JD-Core Version:    0.7.0.1
 */