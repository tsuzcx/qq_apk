import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.qboss.QbossReportManager;
import java.lang.ref.WeakReference;

class alfz
  implements Downloader.DownloadListener
{
  private volatile int jdField_a_of_type_Int;
  private alfw jdField_a_of_type_Alfw;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private volatile int b;
  private int c;
  
  public alfz(alfy paramalfy, QQAppInterface paramQQAppInterface, alfw paramalfw, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_Alfw = paramalfw;
    this.c = paramInt;
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
  }
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QbossADBannerConfigManager", 2, "diy data download fail url = " + paramString);
    }
    this.b += 1;
    alfy.a(this.jdField_a_of_type_Alfy, this.jdField_a_of_type_Alfw, paramString, false);
    if (this.jdField_a_of_type_Alfw != null) {
      QbossReportManager.getInstance().sendErrorReport(2741, this.jdField_a_of_type_Alfw.c, 101, "qboss download resources fail mErrCode = " + paramDownloadResult.getStatus().httpStatus + " resUrl = " + paramString);
    }
    paramString = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (this.b + this.jdField_a_of_type_Int == this.c) {
      alfy.a(this.jdField_a_of_type_Alfy, paramString);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QbossADBannerConfigManager", 2, "banner resources download success url = " + paramString);
    }
    this.jdField_a_of_type_Int += 1;
    alfy.a(this.jdField_a_of_type_Alfy, this.jdField_a_of_type_Alfw, paramString, true);
    paramString = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (this.jdField_a_of_type_Int == this.c) {
      alfy.b(this.jdField_a_of_type_Alfy, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alfz
 * JD-Core Version:    0.7.0.1
 */