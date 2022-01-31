import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ajeb
  implements Downloader.DownloadListener
{
  private volatile int jdField_a_of_type_Int;
  private ajdy jdField_a_of_type_Ajdy;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private volatile int b;
  private int c;
  
  public ajeb(ajea paramajea, QQAppInterface paramQQAppInterface, ajdy paramajdy, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_Ajdy = paramajdy;
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
    ajea.a(this.jdField_a_of_type_Ajea, this.jdField_a_of_type_Ajdy, paramString, false);
    if (this.jdField_a_of_type_Ajdy != null) {
      bjmf.a().a(2741, this.jdField_a_of_type_Ajdy.c, 101, "qboss download resources fail mErrCode = " + paramDownloadResult.getStatus().httpStatus + " resUrl = " + paramString);
    }
    paramString = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (this.b + this.jdField_a_of_type_Int == this.c) {
      ajea.a(this.jdField_a_of_type_Ajea, paramString);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QbossADBannerConfigManager", 2, "banner resources download success url = " + paramString);
    }
    this.jdField_a_of_type_Int += 1;
    ajea.a(this.jdField_a_of_type_Ajea, this.jdField_a_of_type_Ajdy, paramString, true);
    paramString = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (this.jdField_a_of_type_Int == this.c) {
      ajea.b(this.jdField_a_of_type_Ajea, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajeb
 * JD-Core Version:    0.7.0.1
 */