import android.os.PowerManager.WakeLock;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer;
import com.tencent.qphone.base.util.QLog;

class adfj
  implements Runnable
{
  adfj(adfi paramadfi) {}
  
  public void run()
  {
    VideoFilePresenter.a(this.a.a, true);
    VideoFilePresenter.a(this.a.a, 0);
    VideoFilePresenter.a(this.a.a).release();
    this.a.a.a.b(0);
    this.a.a.a.b(0L);
    if (QLog.isDevelopLevel()) {
      QLog.d("#@#@", 1, "setProgress 187 [0]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adfj
 * JD-Core Version:    0.7.0.1
 */