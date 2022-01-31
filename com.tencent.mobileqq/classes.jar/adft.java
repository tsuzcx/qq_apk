import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.MemoryManager;

public class adft
  implements DialogInterface.OnClickListener
{
  public adft(NotificationActivity paramNotificationActivity, CheckBox paramCheckBox, boolean paramBoolean, SharedPreferences paramSharedPreferences) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked();
      if (this.jdField_a_of_type_Boolean != bool) {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("MemoryAlertAutoClear", bool).commit();
      }
      MemoryManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity, this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.app);
      return;
    }
    catch (Exception paramDialogInterface) {}finally
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adft
 * JD-Core Version:    0.7.0.1
 */