import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class adex
  implements AudioManager.OnAudioFocusChangeListener
{
  public adex(VideoFilePresenter paramVideoFilePresenter) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (paramInt == -2) {
      if ((this.a.a != null) && (this.a.a.isPlaying())) {
        VideoFilePresenter.a(this.a);
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt != 1) {
          break;
        }
      } while ((this.a.a == null) || (this.a.a.isPlaying()));
      VideoFilePresenter.b(this.a);
      return;
    } while ((paramInt != -1) || (this.a.a == null) || (!this.a.a.isPlaying()));
    VideoFilePresenter.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adex
 * JD-Core Version:    0.7.0.1
 */