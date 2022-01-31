import com.tencent.mobileqq.video.VipVideoPlayActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;

public class akku
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  public akku(VipVideoPlayActivity paramVipVideoPlayActivity) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipVideoPlayActivity", 2, "video player prepared");
    }
    this.a.runOnUiThread(new akkv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akku
 * JD-Core Version:    0.7.0.1
 */