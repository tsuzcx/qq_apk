import android.os.Handler;
import android.os.Looper;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener;
import com.tencent.open.downloadnew.MyAppDialog;

public class aktd
  implements Runnable
{
  public aktd(MyAppApi.YYBDownloadListener paramYYBDownloadListener, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener.a.a != null) && (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener.a.a.isShowing())) {
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener.a.a.dismiss();
    }
    DownloadManager.a().c(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
    new Handler(Looper.getMainLooper()).postAtTime(new akte(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aktd
 * JD-Core Version:    0.7.0.1
 */