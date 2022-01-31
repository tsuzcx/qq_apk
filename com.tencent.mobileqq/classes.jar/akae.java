import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;

class akae
  implements DialogInterface.OnDismissListener
{
  akae(akad paramakad, amip paramamip) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "finish all settings when dialog dismiss");
    }
    if (bdee.g(this.jdField_a_of_type_Akad.a))
    {
      boolean bool1 = QQSpecialFriendSettingActivity.a(this.jdField_a_of_type_Akad.a).a();
      boolean bool2 = QQSpecialFriendSettingActivity.b(this.jdField_a_of_type_Akad.a).a();
      paramDialogInterface = QQSpecialFriendSettingActivity.a(this.jdField_a_of_type_Akad.a);
      String str = QQSpecialFriendSettingActivity.a(this.jdField_a_of_type_Akad.a);
      int i = QQSpecialFriendSettingActivity.a(this.jdField_a_of_type_Akad.a);
      paramDialogInterface.a(str, new int[] { 2, 3 }, new boolean[] { bool1, bool2 }, new String[] { String.valueOf(i), null });
      paramDialogInterface = this.jdField_a_of_type_Akad.a.a.obtainMessage(8193);
      paramDialogInterface.obj = this.jdField_a_of_type_Akad.a.getString(2131699849);
      this.jdField_a_of_type_Akad.a.a.sendMessage(paramDialogInterface);
      if ((bool1) && (bool2))
      {
        paramDialogInterface = "0";
        azmj.b(null, "CliOper", "", "", "0X80050E2", "0X80050E2", 0, 0, paramDialogInterface, "", "", "");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Amip.a();
      return;
      paramDialogInterface = "1";
      break;
      paramDialogInterface = this.jdField_a_of_type_Akad.a.a.obtainMessage(8195);
      paramDialogInterface.arg1 = 0;
      paramDialogInterface.arg2 = 2131692397;
      this.jdField_a_of_type_Akad.a.a.sendMessage(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akae
 * JD-Core Version:    0.7.0.1
 */