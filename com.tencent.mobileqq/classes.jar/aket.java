import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;

class aket
  implements DialogInterface.OnDismissListener
{
  aket(akes paramakes, amne paramamne) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "finish all settings when dialog dismiss");
    }
    if (bdin.g(this.jdField_a_of_type_Akes.a))
    {
      boolean bool1 = QQSpecialFriendSettingActivity.a(this.jdField_a_of_type_Akes.a).a();
      boolean bool2 = QQSpecialFriendSettingActivity.b(this.jdField_a_of_type_Akes.a).a();
      paramDialogInterface = QQSpecialFriendSettingActivity.a(this.jdField_a_of_type_Akes.a);
      String str = QQSpecialFriendSettingActivity.a(this.jdField_a_of_type_Akes.a);
      int i = QQSpecialFriendSettingActivity.a(this.jdField_a_of_type_Akes.a);
      paramDialogInterface.a(str, new int[] { 2, 3 }, new boolean[] { bool1, bool2 }, new String[] { String.valueOf(i), null });
      paramDialogInterface = this.jdField_a_of_type_Akes.a.a.obtainMessage(8193);
      paramDialogInterface.obj = this.jdField_a_of_type_Akes.a.getString(2131699861);
      this.jdField_a_of_type_Akes.a.a.sendMessage(paramDialogInterface);
      if ((bool1) && (bool2))
      {
        paramDialogInterface = "0";
        azqs.b(null, "CliOper", "", "", "0X80050E2", "0X80050E2", 0, 0, paramDialogInterface, "", "", "");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Amne.a();
      return;
      paramDialogInterface = "1";
      break;
      paramDialogInterface = this.jdField_a_of_type_Akes.a.a.obtainMessage(8195);
      paramDialogInterface.arg1 = 0;
      paramDialogInterface.arg2 = 2131692398;
      this.jdField_a_of_type_Akes.a.a.sendMessage(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aket
 * JD-Core Version:    0.7.0.1
 */