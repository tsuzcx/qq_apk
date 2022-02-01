import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

class adje
  implements bjoe
{
  adje(adja paramadja, int[] paramArrayOfInt, mup parammup) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = this.jdField_a_of_type_ArrayOfInt[paramInt];
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "videoActionSheet onClick,showItems =  " + Arrays.toString(this.jdField_a_of_type_ArrayOfInt) + ",which = " + paramInt + ",item = " + i);
    }
    this.jdField_a_of_type_Mup.dismiss();
    switch (i)
    {
    default: 
      return;
    case 1: 
      FriendProfileCardActivity.a(this.jdField_a_of_type_Adja.a.app, this.jdField_a_of_type_Adja.a, this.jdField_a_of_type_Adja.a.a);
      bcef.b(this.jdField_a_of_type_Adja.a.app, "CliOper", "", "", "0X8008405", "0X8008405", 0, 0, "", "", "", "");
      return;
    }
    paramView = new SessionInfo();
    paramView.curType = bfrj.a(this.jdField_a_of_type_Adja.a.a.a);
    paramView.curFriendUin = this.jdField_a_of_type_Adja.a.a.a.a;
    paramView.curFriendNick = FriendProfileCardActivity.a(this.jdField_a_of_type_Adja.a.a, this.jdField_a_of_type_Adja.a.app);
    paramView.troopUin = this.jdField_a_of_type_Adja.a.a.a.d;
    afcm.a(this.jdField_a_of_type_Adja.a.app, this.jdField_a_of_type_Adja.a, paramView, false, null, null);
    bcef.b(this.jdField_a_of_type_Adja.a.app, "CliOper", "", "", "0X80085D6", "0X80085D6", 9, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adje
 * JD-Core Version:    0.7.0.1
 */