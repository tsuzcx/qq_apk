import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;

public class adfc
  implements TVK_IMediaPlayer.OnInfoListener
{
  public adfc(VideoFilePresenter paramVideoFilePresenter) {}
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    new Handler(Looper.getMainLooper()).post(new adfd(this, paramInt));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adfc
 * JD-Core Version:    0.7.0.1
 */