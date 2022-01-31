import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.common.DownloadDBHelper;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.concurrent.ConcurrentHashMap;

public class akrm
  implements Runnable
{
  public akrm(DownloadManager paramDownloadManager) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = ((ConcurrentHashMap)DownloadDBHelper.a().a());
    try
    {
      DownloadInfo localDownloadInfo = this.a.b("com.tencent.mobileqq");
      if ((localDownloadInfo != null) && (localDownloadInfo.jdField_c_of_type_Int == 0))
      {
        String str = "";
        TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1;
        if (localDownloadInfo.a == 0)
        {
          TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2 = this.a.a(localDownloadInfo.jdField_c_of_type_JavaLangString);
          localTMAssistantDownloadTaskInfo1 = localTMAssistantDownloadTaskInfo2;
          if (localTMAssistantDownloadTaskInfo2 != null)
          {
            str = localTMAssistantDownloadTaskInfo2.mSavePath;
            localTMAssistantDownloadTaskInfo1 = localTMAssistantDownloadTaskInfo2;
          }
        }
        while (localTMAssistantDownloadTaskInfo1 == null)
        {
          this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localDownloadInfo.b);
          DownloadDBHelper.a().a(localDownloadInfo.b);
          return;
          localTMAssistantDownloadTaskInfo1 = this.a.a(localDownloadInfo.h);
          str = localDownloadInfo.k;
        }
        if ((localTMAssistantDownloadTaskInfo1.mState == 4) && (AppUtil.c(str) <= CommonDataAdapter.a().a()))
        {
          this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localDownloadInfo.b);
          DownloadDBHelper.a().a(localDownloadInfo.b);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      LogUtility.c(DownloadManager.jdField_a_of_type_JavaLangString, "speical clear>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     akrm
 * JD-Core Version:    0.7.0.1
 */