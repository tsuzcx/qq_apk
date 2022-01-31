import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

public class agvb
  implements TVK_IMediaPlayer.OnCompletionListener
{
  public agvb(SpringHbVideoView paramSpringHbVideoView) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    QLog.i("springHb_SpringHbVideoView", 1, "onCompletion");
    if (SpringHbVideoView.a(this.a) != null) {
      SpringHbVideoView.a(this.a).au_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agvb
 * JD-Core Version:    0.7.0.1
 */