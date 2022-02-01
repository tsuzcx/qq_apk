import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import cooperation.qzone.util.FileUtils;
import cooperation.qzone.util.QZLog;
import java.io.File;

class aamt
  extends bhyn
{
  aamt(aams paramaams, Downloader.DownloadListener paramDownloadListener, String paramString1, aamu paramaamu, String paramString2, String paramString3) {}
  
  public void onCancel(bhyo parambhyo)
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadCanceled(this.jdField_a_of_type_JavaLangString);
    }
    aamu.a(this.jdField_a_of_type_Aamu, 3);
    QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, new Object[] { "onDownloadCanceled" });
  }
  
  public void onDone(bhyo parambhyo)
  {
    if (parambhyo.a == 0)
    {
      boolean bool;
      if (new File(aams.jdField_a_of_type_JavaLangString).exists())
      {
        bool = FileUtils.unzip(new File(this.jdField_a_of_type_JavaLangString), new File(aams.jdField_a_of_type_JavaLangString + "/" + this.b));
        if (!bool) {
          break label158;
        }
        if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener != null) {
          this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadSucceed(this.jdField_a_of_type_JavaLangString, new DownloadResult(this.c));
        }
        new File(this.jdField_a_of_type_JavaLangString).delete();
        aamu.a(this.jdField_a_of_type_Aamu, 0);
      }
      for (;;)
      {
        QZLog.i("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "downLoadByIdsuccess:" + bool);
        return;
        label158:
        aamu.a(this.jdField_a_of_type_Aamu, 2);
      }
    }
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadFailed(this.jdField_a_of_type_JavaLangString, new DownloadResult(this.c));
    }
    aamu.a(this.jdField_a_of_type_Aamu, 2);
    QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, new Object[] { "downLoadByIdonDownloadFailed:" });
  }
  
  public void onProgress(bhyo parambhyo)
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadProgress(this.jdField_a_of_type_JavaLangString, 0L, 0.0F);
    }
    aamu.a(this.jdField_a_of_type_Aamu, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamt
 * JD-Core Version:    0.7.0.1
 */