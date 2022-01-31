import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;

public class ahhp
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  public ahhp(SpringHbVideoView paramSpringHbVideoView) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    QLog.i("springHb_SpringHbVideoView", 1, "mVideoPlayer is prepare");
    SpringHbVideoView.a(this.a, true);
    if (SpringHbVideoView.a(this.a) != null) {
      SpringHbVideoView.a(this.a).a();
    }
    if (SpringHbVideoView.a(this.a)) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahhp
 * JD-Core Version:    0.7.0.1
 */