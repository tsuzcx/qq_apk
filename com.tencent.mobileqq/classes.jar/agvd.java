import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;

public class agvd
  implements TVK_IMediaPlayer.OnInfoListener
{
  public agvd(SpringHbVideoView paramSpringHbVideoView) {}
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    QLog.i("springHb_SpringHbVideoView", 1, "onInfo what=" + paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return false;
      QLog.i("springHb_SpringHbVideoView", 1, "onInfo PLAYER_INFO_START_RENDERING");
      SpringHbVideoView.a(this.a).removeMessages(100);
      SpringHbVideoView.a(this.a).sendEmptyMessageDelayed(100, 150L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agvd
 * JD-Core Version:    0.7.0.1
 */