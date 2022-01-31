import com.tencent.mobileqq.app.NowHandler;
import com.tencent.mobileqq.now.ChannelResponse;
import com.tencent.mobileqq.now.NowAppHelper;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class afzz
  extends DownloadListener
{
  afzz(afzy paramafzy) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    this.a.jdField_a_of_type_ComTencentMobileqqAppNowHandler.a("downloadApk", "", "", "", "", paramDownloadTask.a());
    if (QLog.isColorLevel()) {
      QLog.d(NowAppHelper.a, 2, "doShortCutAction download onDone,task=" + paramDownloadTask);
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d(NowAppHelper.a, 2, "doShortCutAction download onStart,apkUrl=" + this.a.jdField_a_of_type_ComTencentMobileqqNowChannelResponse.downloadLink);
    }
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afzz
 * JD-Core Version:    0.7.0.1
 */