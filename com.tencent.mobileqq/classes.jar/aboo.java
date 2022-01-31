import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.NotificationActivity;

public class aboo
  implements DialogInterface.OnClickListener
{
  public aboo(NotificationActivity paramNotificationActivity, CheckBox paramCheckBox, boolean paramBoolean, SharedPreferences paramSharedPreferences) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked();
      if (this.jdField_a_of_type_Boolean != bool) {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("MemoryAlertAutoClear", bool).commit();
      }
      label39:
      this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.finish();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label39;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aboo
 * JD-Core Version:    0.7.0.1
 */