import android.text.TextUtils;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.MD5;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import java.io.File;
import protocol.KQQConfig.UpgradeInfo;

public class akrd
  implements Runnable
{
  public akrd(DownloadManager paramDownloadManager, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_c_of_type_JavaLangString);
      if (localTMAssistantDownloadTaskInfo != null)
      {
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_k_of_type_JavaLangString = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a().getDownloadTaskState(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_c_of_type_JavaLangString).mSavePath;
        if ("com.tencent.mobileqq".equals(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.d))
        {
          File localFile = new File(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_k_of_type_JavaLangString);
          UpgradeDetailWrapper localUpgradeDetailWrapper = UpgradeController.a().a();
          if ((localFile.exists()) && (localUpgradeDetailWrapper != null))
          {
            String str = MD5.a(localFile);
            if (!TextUtils.equals(localUpgradeDetailWrapper.a.strNewSoftwareMD5.toUpperCase(), str.toUpperCase()))
            {
              this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo, -51, "download file md5 check failed(not patche)");
              localFile.delete();
              return;
            }
          }
        }
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_c_of_type_Long = localTMAssistantDownloadTaskInfo.mTotalDataLen;
        LogUtility.b(DownloadManager.a, "onDownload complete, info.filePath = " + this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_k_of_type_JavaLangString);
        if ((!"com.tencent.mobileqq".equals(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.d)) || (!this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.b())) {
          break label409;
        }
        LogUtility.c(DownloadManager.a, "QQ Download complete begin write code ......");
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_k_of_type_Int = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
        if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_k_of_type_Int == 0) {
          break label358;
        }
        LogUtility.c(DownloadManager.a, "QQ apk write code fail......");
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.f = -2;
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.e(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.jdField_k_of_type_Int, null);
      }
    }
    catch (Exception localException)
    {
      LogUtility.c(DownloadManager.a, "downloadSDKClient>>>", localException);
      for (;;)
      {
        StaticAnalyz.a("300", this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.g, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.b, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.m);
        if (!this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.a) {
          break;
        }
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.c(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
        return;
        label358:
        LogUtility.c(DownloadManager.a, "QQ apk code suc......");
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.e(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(4, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
        long l = localException.mTotalDataLen;
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo, l);
      }
      label409:
      LogUtility.c(DownloadManager.a, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo.d + " Download complete begin write code ......");
      DownloadManager.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     akrd
 * JD-Core Version:    0.7.0.1
 */