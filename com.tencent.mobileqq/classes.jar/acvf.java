import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;

class acvf
  implements Runnable
{
  acvf(acvc paramacvc) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    try
    {
      String str = (String)this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.a.getText();
      if ((str == null) || (str.length() == 0)) {
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.a.clearAnimation();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.a.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acvf
 * JD-Core Version:    0.7.0.1
 */