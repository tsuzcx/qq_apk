import com.tencent.mobileqq.intervideo.now.DownloadEngine.IDownloadListener;
import com.tencent.mobileqq.intervideo.now.DownloadEngine.NowDownloadManager;
import com.tencent.mobileqq.intervideo.now.NowPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.txproxy.HostEventListener;

public class adve
  implements IDownloadListener
{
  public adve(NowPlugin paramNowPlugin, HostEventListener paramHostEventListener, String paramString) {}
  
  public void a()
  {
    QLog.i("XProxy|NowProxy", 4, "onDownloadComplete------");
    if (this.jdField_a_of_type_ComTencentTxproxyHostEventListener != null) {
      this.jdField_a_of_type_ComTencentTxproxyHostEventListener.onDownloadResult(0, 0, "Helly Download Success");
    }
    NowPlugin.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin).a(this.jdField_a_of_type_JavaLangString);
    NowPlugin.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin).a();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    QLog.i("XProxy|NowProxy", 4, "onDownloadFailed------");
    if (this.jdField_a_of_type_ComTencentTxproxyHostEventListener != null) {
      this.jdField_a_of_type_ComTencentTxproxyHostEventListener.onDownloadResult(paramInt1, paramInt2, "Helly Download Failed");
    }
    NowPlugin.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin).a(this.jdField_a_of_type_JavaLangString);
    NowPlugin.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin).a();
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentTxproxyHostEventListener != null) {
      this.jdField_a_of_type_ComTencentTxproxyHostEventListener.onDownloadProgress(paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adve
 * JD-Core Version:    0.7.0.1
 */