import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;

public class adfe
  implements TVK_IMediaPlayer.OnSeekCompleteListener
{
  public adfe(VideoFilePresenter paramVideoFilePresenter) {}
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.a.a.runOnUiThread(new adff(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adfe
 * JD-Core Version:    0.7.0.1
 */