import android.os.Handler;
import com.tencent.mobileqq.troop.homework.config.BeginnerGuideDownloadManager;
import com.tencent.qphone.base.util.QLog;

public class ajgi
  implements Runnable
{
  public ajgi(BeginnerGuideDownloadManager paramBeginnerGuideDownloadManager, Handler paramHandler, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if ((!BeginnerGuideDownloadManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkConfigBeginnerGuideDownloadManager, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean)) && (QLog.isColorLevel())) {
      QLog.d("BeginnerGuideDownloadManager", 2, "postDownload return false");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgi
 * JD-Core Version:    0.7.0.1
 */