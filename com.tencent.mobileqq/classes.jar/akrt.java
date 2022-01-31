import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

class akrt
  implements Runnable
{
  akrt(akrs paramakrs, TMAssistantDownloadClient paramTMAssistantDownloadClient, int paramInt1, String paramString1, int paramInt2, String paramString2) {}
  
  public void run()
  {
    LogUtility.b(DownloadManager.jdField_a_of_type_JavaLangString, "OnDownloadStateChanged,clientKey:" + this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient + ",state:" + this.jdField_a_of_type_Int + ",url:" + this.jdField_a_of_type_JavaLangString);
    int i = DownloadManager.a(this.jdField_a_of_type_Int);
    LogUtility.a(DownloadManager.jdField_a_of_type_JavaLangString, "onStateChanged url: +++++loacalState=" + i + " +++++downloadInfo=" + this.jdField_a_of_type_Akrs.a.c(this.jdField_a_of_type_JavaLangString));
    DownloadInfo localDownloadInfo = this.jdField_a_of_type_Akrs.a.a(this.jdField_a_of_type_JavaLangString, i);
    if (localDownloadInfo == null)
    {
      LogUtility.d(DownloadManager.jdField_a_of_type_JavaLangString, "OnDownloadSDKTaskStateChanged info == null");
      return;
    }
    if (this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient != null) {}
    for (;;)
    {
      try
      {
        TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.getDownloadTaskState(this.jdField_a_of_type_JavaLangString);
        if (localTMAssistantDownloadTaskInfo == null) {
          break label453;
        }
        l1 = localTMAssistantDownloadTaskInfo.mReceiveDataLen;
        l2 = localTMAssistantDownloadTaskInfo.mTotalDataLen;
        int j = (int)((float)l1 * 100.0F / (float)l2);
        localDownloadInfo.g = j;
        LogUtility.a(DownloadManager.jdField_a_of_type_JavaLangString, "OnDownloadSDKTaskStateChanged info progress = " + j);
        switch (i)
        {
        default: 
          return;
        case -2: 
          this.jdField_a_of_type_Akrs.a.a(localDownloadInfo, l1, l2, this.jdField_b_of_type_Int);
          this.jdField_a_of_type_Akrs.a.a(-2, localDownloadInfo, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaLangString);
          return;
        }
      }
      catch (Exception localException)
      {
        LogUtility.c(DownloadManager.jdField_a_of_type_JavaLangString, "getDownloadTaskState>>>", localException);
        Object localObject = null;
        continue;
        this.jdField_a_of_type_Akrs.a.a(2, localDownloadInfo);
        return;
      }
      this.jdField_a_of_type_Akrs.a.a(localDownloadInfo, l1, l1 - localDownloadInfo.b, "pause");
      this.jdField_a_of_type_Akrs.a.a(3, localDownloadInfo);
      return;
      this.jdField_a_of_type_Akrs.a.a(localDownloadInfo, 0L, l2 - localDownloadInfo.b, "complete");
      this.jdField_a_of_type_Akrs.a.b(localDownloadInfo);
      return;
      this.jdField_a_of_type_Akrs.a.a(20, localDownloadInfo);
      return;
      this.jdField_a_of_type_Akrs.a.a(10, localDownloadInfo);
      return;
      label453:
      long l2 = 0L;
      long l1 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     akrt
 * JD-Core Version:    0.7.0.1
 */