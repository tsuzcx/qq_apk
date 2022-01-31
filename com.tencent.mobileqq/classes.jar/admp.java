import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter;
import java.util.TimerTask;

public class admp
  extends TimerTask
{
  public admp(MusicFilePresenter paramMusicFilePresenter) {}
  
  public void run()
  {
    this.a.a.runOnUiThread(new admq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     admp
 * JD-Core Version:    0.7.0.1
 */