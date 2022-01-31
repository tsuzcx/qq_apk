import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

class aksp
  implements Runnable
{
  aksp(akso paramakso, DownloadTask paramDownloadTask) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QueueDownloader", 2, "doTask | run() downloadLimitCount=" + this.jdField_a_of_type_Akso.a.get() + ",task=" + this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.c) && (DownloaderFactory.a(this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.jdField_a_of_type_Int = -101;
      this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.a(-1);
      this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.e();
      this.jdField_a_of_type_Akso.a(this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask);
      this.jdField_a_of_type_Akso.a.addAndGet(-1);
      this.jdField_a_of_type_Akso.a();
      if (QLog.isColorLevel()) {
        QLog.d("QueueDownloader", 2, "doTask | run() task is limit of failTime, task=" + this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask);
      }
      return;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    int i = DownloaderFactory.a(this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask, localAppRuntime);
    if (QLog.isColorLevel()) {
      QLog.d("QueueDownloader", 2, "doTask | run() download task result=" + i + ",task=" + this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask);
    }
    this.jdField_a_of_type_Akso.a(this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask);
    this.jdField_a_of_type_Akso.a.addAndGet(-1);
    this.jdField_a_of_type_Akso.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aksp
 * JD-Core Version:    0.7.0.1
 */