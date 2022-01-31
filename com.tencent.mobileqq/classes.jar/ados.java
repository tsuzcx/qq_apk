import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.settings.FMSettingInterface.MoveFileCallback;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;

class ados
  implements FMSettingInterface.MoveFileCallback
{
  ados(ador paramador) {}
  
  public void a()
  {
    this.a.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new adov(this));
    FMSettings.a(this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings);
    FileManagerReporter.a("0X8005BE2");
    synchronized (BaseApplicationImpl.getContext())
    {
      this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.b = false;
      return;
    }
  }
  
  public void a(int paramInt)
  {
    this.a.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new adou(this));
    FMSettings.a(this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings);
    synchronized (BaseApplicationImpl.getContext())
    {
      this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.b = false;
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.a.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new adot(this, paramLong1, paramLong2));
  }
  
  public void a(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ados
 * JD-Core Version:    0.7.0.1
 */