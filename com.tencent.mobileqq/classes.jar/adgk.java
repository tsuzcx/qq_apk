import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.lang.reflect.Field;

class adgk
  implements DialogInterface.OnClickListener
{
  adgk(adgj paramadgj, TextView paramTextView, ProgressBar paramProgressBar) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Adgj.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.a().a(this.jdField_a_of_type_Adgj.jdField_a_of_type_AndroidAppActivity);
    try
    {
      Field localField = paramDialogInterface.getClass().getSuperclass().getDeclaredField("mShowing");
      localField.setAccessible(true);
      localField.set(paramDialogInterface, Boolean.valueOf(false));
      this.jdField_a_of_type_AndroidWidgetTextView.setText("默认存储路径更换中，请稍等。");
      paramDialogInterface = this.jdField_a_of_type_Adgj.jdField_a_of_type_AndroidAppActivity.getResources().getColorStateList(2131494240);
      this.jdField_a_of_type_Adgj.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.a.getBtnight().setEnabled(false);
      this.jdField_a_of_type_Adgj.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.a.getBtnight().setTextColor(paramDialogInterface);
      this.jdField_a_of_type_Adgj.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.a.getBtnLeft().setTextColor(paramDialogInterface);
      this.jdField_a_of_type_Adgj.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.a.getBtnLeft().setEnabled(false);
      FMSettings.a(this.jdField_a_of_type_Adgj.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings, this.jdField_a_of_type_Adgj.jdField_a_of_type_JavaUtilList, new adgl(this));
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        paramDialogInterface.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adgk
 * JD-Core Version:    0.7.0.1
 */