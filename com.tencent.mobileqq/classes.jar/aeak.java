import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

class aeak
  implements bkzq
{
  aeak(aeag paramaeag, int[] paramArrayOfInt, mvn parammvn) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = this.jdField_a_of_type_ArrayOfInt[paramInt];
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "videoActionSheet onClick,showItems =  " + Arrays.toString(this.jdField_a_of_type_ArrayOfInt) + ",which = " + paramInt + ",item = " + i);
    }
    this.jdField_a_of_type_Mvn.dismiss();
    switch (i)
    {
    default: 
      return;
    case 1: 
      FriendProfileCardActivity.a(this.jdField_a_of_type_Aeag.a.app, this.jdField_a_of_type_Aeag.a, this.jdField_a_of_type_Aeag.a.a);
      bdla.b(this.jdField_a_of_type_Aeag.a.app, "CliOper", "", "", "0X8008405", "0X8008405", 0, 0, "", "", "", "");
      return;
    }
    paramView = new SessionInfo();
    paramView.curType = bhaa.a(this.jdField_a_of_type_Aeag.a.a.a);
    paramView.curFriendUin = this.jdField_a_of_type_Aeag.a.a.a.a;
    paramView.curFriendNick = FriendProfileCardActivity.a(this.jdField_a_of_type_Aeag.a.a, this.jdField_a_of_type_Aeag.a.app);
    paramView.troopUin = this.jdField_a_of_type_Aeag.a.a.a.d;
    aftr.a(this.jdField_a_of_type_Aeag.a.app, this.jdField_a_of_type_Aeag.a, paramView, false, null, null);
    bdla.b(this.jdField_a_of_type_Aeag.a.app, "CliOper", "", "", "0X80085D6", "0X80085D6", 9, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeak
 * JD-Core Version:    0.7.0.1
 */