import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mobileqq.vipav.VipFunCallMediaListener;

public final class ajwv
  implements MediaPlayer.OnPreparedListener
{
  public ajwv(VipFunCallMediaListener paramVipFunCallMediaListener) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.start();
    paramMediaPlayer.setLooping(true);
    if (this.a != null) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajwv
 * JD-Core Version:    0.7.0.1
 */