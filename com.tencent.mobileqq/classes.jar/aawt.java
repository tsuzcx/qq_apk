import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import cooperation.qzone.util.QZLog;
import java.io.File;

class aawt
  extends bhhe
{
  aawt(aaws paramaaws, Downloader.DownloadListener paramDownloadListener, String paramString1, aawu paramaawu, String paramString2, String paramString3) {}
  
  public void onCancel(bhhf parambhhf)
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadCanceled(this.jdField_a_of_type_JavaLangString);
    }
    aawu.a(this.jdField_a_of_type_Aawu, 3);
    QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, new Object[] { "onDownloadCanceled" });
  }
  
  public void onDone(bhhf parambhhf)
  {
    if (parambhhf.a == 0)
    {
      boolean bool;
      if (new File(aaws.jdField_a_of_type_JavaLangString).exists())
      {
        bool = bmij.b(new File(this.jdField_a_of_type_JavaLangString), new File(aaws.jdField_a_of_type_JavaLangString + "/" + this.b));
        if (!bool) {
          break label158;
        }
        if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener != null) {
          this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadSucceed(this.jdField_a_of_type_JavaLangString, new DownloadResult(this.c));
        }
        new File(this.jdField_a_of_type_JavaLangString).delete();
        aawu.a(this.jdField_a_of_type_Aawu, 0);
      }
      for (;;)
      {
        QZLog.i("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "downLoadByIdsuccess:" + bool);
        return;
        label158:
        aawu.a(this.jdField_a_of_type_Aawu, 2);
      }
    }
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadFailed(this.jdField_a_of_type_JavaLangString, new DownloadResult(this.c));
    }
    aawu.a(this.jdField_a_of_type_Aawu, 2);
    QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, new Object[] { "downLoadByIdonDownloadFailed:" });
  }
  
  public void onProgress(bhhf parambhhf)
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadProgress(this.jdField_a_of_type_JavaLangString, 0L, 0.0F);
    }
    aawu.a(this.jdField_a_of_type_Aawu, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aawt
 * JD-Core Version:    0.7.0.1
 */