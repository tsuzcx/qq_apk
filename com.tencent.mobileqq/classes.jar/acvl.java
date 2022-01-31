import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

public class acvl
  implements TVK_IMediaPlayer.OnCompletionListener
{
  public acvl(VideoFilePresenter paramVideoFilePresenter) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    new Handler(Looper.getMainLooper()).post(new acvm(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acvl
 * JD-Core Version:    0.7.0.1
 */