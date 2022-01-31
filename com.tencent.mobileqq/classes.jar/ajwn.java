import com.tencent.mobileqq.video.VipVideoPlayActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;

public class ajwn
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  public ajwn(VipVideoPlayActivity paramVipVideoPlayActivity) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipVideoPlayActivity", 2, "video player prepared");
    }
    this.a.runOnUiThread(new ajwo(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajwn
 * JD-Core Version:    0.7.0.1
 */