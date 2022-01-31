import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnVideoDataEventListener;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter;

public class acvn
  implements FileBrowserModelBase.OnVideoDataEventListener
{
  public acvn(VideoFilePresenter paramVideoFilePresenter) {}
  
  public void a()
  {
    this.a.a.runOnUiThread(new acvo(this));
  }
  
  public void a(int paramInt, String paramString)
  {
    this.a.a(paramInt, paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.a.runOnUiThread(new acvp(this, paramString1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acvn
 * JD-Core Version:    0.7.0.1
 */