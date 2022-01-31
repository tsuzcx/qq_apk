import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ahms
  implements Downloader.DownloadListener
{
  private volatile int jdField_a_of_type_Int;
  private ahmp jdField_a_of_type_Ahmp;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private volatile int b;
  private int c;
  
  public ahms(ahmr paramahmr, QQAppInterface paramQQAppInterface, ahmp paramahmp, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_Ahmp = paramahmp;
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
    ahmr.a(this.jdField_a_of_type_Ahmr, this.jdField_a_of_type_Ahmp, paramString, false);
    if (this.jdField_a_of_type_Ahmp != null) {
      bhku.a().a(2741, this.jdField_a_of_type_Ahmp.c, 101, "qboss download resources fail mErrCode = " + paramDownloadResult.getStatus().httpStatus + " resUrl = " + paramString);
    }
    paramString = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (this.b + this.jdField_a_of_type_Int == this.c) {
      ahmr.a(this.jdField_a_of_type_Ahmr, paramString);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QbossADBannerConfigManager", 2, "banner resources download success url = " + paramString);
    }
    this.jdField_a_of_type_Int += 1;
    ahmr.a(this.jdField_a_of_type_Ahmr, this.jdField_a_of_type_Ahmp, paramString, true);
    paramString = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (this.jdField_a_of_type_Int == this.c) {
      ahmr.b(this.jdField_a_of_type_Ahmr, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahms
 * JD-Core Version:    0.7.0.1
 */