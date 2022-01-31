import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.photo.PeakService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;

public final class ajho
  implements Runnable
{
  public ajho(Activity paramActivity, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubmitHomeWorkFragment", 2, "start preload peak process");
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, PeakService.class);
    if (VideoEnvironment.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      localIntent.putExtra("ServiceAction", 2);
    }
    try
    {
      this.jdField_a_of_type_AndroidAppActivity.startService(localIntent);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("SubmitHomeWorkFragment", 1, "onShow_otherThings startService ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajho
 * JD-Core Version:    0.7.0.1
 */