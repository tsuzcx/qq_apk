import android.os.Handler;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.ThreadManager;

public class agqc
  implements MessageQueue.IdleHandler
{
  public agqc(SendPhotoActivity paramSendPhotoActivity) {}
  
  public boolean queueIdle()
  {
    aune.a(SendPhotoActivity.jdField_a_of_type_JavaLangString, "queueIdle", "start");
    this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoTask = new SendPhotoTask(this.a, null, this.a.jdField_a_of_type_AndroidOsHandler);
    ThreadManager.post(this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoTask, 8, null, false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agqc
 * JD-Core Version:    0.7.0.1
 */