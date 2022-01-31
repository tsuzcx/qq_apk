import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class alpe
  implements Runnable
{
  public alpe(DownloadManager paramDownloadManager, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_c_of_type_JavaLangString);
      if (localTMAssistantDownloadTaskInfo != null)
      {
        LogUtility.c(DownloadManager.a, "onDownloadError taskInfo != null！info.writeCodeState = " + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_k_of_type_Int);
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_k_of_type_JavaLangString = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a().getDownloadTaskState(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_c_of_type_JavaLangString).mSavePath;
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_c_of_type_Long = localTMAssistantDownloadTaskInfo.mTotalDataLen;
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.e(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
        if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_k_of_type_Int != 0) {
          break label201;
        }
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(4, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
        if (!this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.b.equals("1101070898"))
        {
          long l = localTMAssistantDownloadTaskInfo.mTotalDataLen;
          this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo, l);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label201:
        LogUtility.c(DownloadManager.a, "downloadSDKClient>>>", localException);
      }
    }
    StaticAnalyz.a("300", this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.g, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.b, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.m);
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.a) {
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.c(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
    }
    return;
    LogUtility.c(DownloadManager.a, "onDownloadError taskInfo == null");
    DownloadManager.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alpe
 * JD-Core Version:    0.7.0.1
 */