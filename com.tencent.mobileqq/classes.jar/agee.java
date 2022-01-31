import android.os.Handler;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity.sendPhotoTask;
import com.tencent.mobileqq.app.ThreadManager;

public class agee
  implements MessageQueue.IdleHandler
{
  public agee(SendPhotoActivity paramSendPhotoActivity) {}
  
  public boolean queueIdle()
  {
    atpg.a(SendPhotoActivity.jdField_a_of_type_JavaLangString, "queueIdle", "start");
    this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity$sendPhotoTask = new SendPhotoActivity.sendPhotoTask(this.a, null);
    ThreadManager.post(this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity$sendPhotoTask, 8, null, false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agee
 * JD-Core Version:    0.7.0.1
 */