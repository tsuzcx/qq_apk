import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class akrv
  implements Runnable
{
  public akrv(DownloadManager paramDownloadManager, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.c) != null) {
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_k_of_type_JavaLangString = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a().getDownloadTaskState(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.c).mSavePath;
    }
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_k_of_type_Int = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_k_of_type_Int != 0)
    {
      LogUtility.a(DownloadManager.a, "onDownloadError ###重新写码失败..........");
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f = -2;
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.g = 100;
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_k_of_type_Int, null);
      return;
    }
    LogUtility.a(DownloadManager.a, "onDownloadError ###重新写码成功..........");
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f = 4;
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.g = 100;
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     akrv
 * JD-Core Version:    0.7.0.1
 */