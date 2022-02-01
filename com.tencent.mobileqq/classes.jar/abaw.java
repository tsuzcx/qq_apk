import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import cooperation.qzone.util.QZLog;
import java.io.File;

class abaw
  extends biht
{
  abaw(abav paramabav, Downloader.DownloadListener paramDownloadListener, String paramString1, abax paramabax, String paramString2, String paramString3) {}
  
  public void onCancel(bihu parambihu)
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadCanceled(this.jdField_a_of_type_JavaLangString);
    }
    abax.a(this.jdField_a_of_type_Abax, 3);
    QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, new Object[] { "onDownloadCanceled" });
  }
  
  public void onDone(bihu parambihu)
  {
    if (parambihu.a == 0)
    {
      boolean bool;
      if (new File(abav.jdField_a_of_type_JavaLangString).exists())
      {
        bool = bnjl.b(new File(this.jdField_a_of_type_JavaLangString), new File(abav.jdField_a_of_type_JavaLangString + "/" + this.b));
        if (!bool) {
          break label158;
        }
        if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener != null) {
          this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadSucceed(this.jdField_a_of_type_JavaLangString, new DownloadResult(this.c));
        }
        new File(this.jdField_a_of_type_JavaLangString).delete();
        abax.a(this.jdField_a_of_type_Abax, 0);
      }
      for (;;)
      {
        QZLog.i("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "downLoadByIdsuccess:" + bool);
        return;
        label158:
        abax.a(this.jdField_a_of_type_Abax, 2);
      }
    }
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadFailed(this.jdField_a_of_type_JavaLangString, new DownloadResult(this.c));
    }
    abax.a(this.jdField_a_of_type_Abax, 2);
    QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, new Object[] { "downLoadByIdonDownloadFailed:" });
  }
  
  public void onProgress(bihu parambihu)
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadProgress(this.jdField_a_of_type_JavaLangString, 0L, 0.0F);
    }
    abax.a(this.jdField_a_of_type_Abax, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abaw
 * JD-Core Version:    0.7.0.1
 */