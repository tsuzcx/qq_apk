import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class adhp
  implements Runnable
{
  public adhp(UniformDownloadMgr paramUniformDownloadMgr, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_AndroidOsBundle == null))
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] onDownloadNotificationBeClean. param error!!");
      return;
    }
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("_notify_param_Id");
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>>onDownloadNotificationBeClean. URL:" + this.jdField_a_of_type_JavaLangString + " nofiyid:" + i);
    adic localadic = UniformDownloadMgr.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadMgr, this.jdField_a_of_type_JavaLangString);
    if ((localadic != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadMgr.a != null))
    {
      if (localadic.a != 1) {
        break label175;
      }
      StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadMgr.a.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadMgr.a.getCurrentAccountUin(), "Stop_download_2-1_3-0");
    }
    for (;;)
    {
      UniformDownloadMgr.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadMgr, this.jdField_a_of_type_JavaLangString);
      UniformDownloadMgr.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadMgr, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadMgr.c(this.jdField_a_of_type_JavaLangString);
      UniformDownloadMgr.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadMgr);
      return;
      label175:
      StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadMgr.a.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreUniformDownloadMgr.a.getCurrentAccountUin(), "Stop_download_2-1_3-1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adhp
 * JD-Core Version:    0.7.0.1
 */