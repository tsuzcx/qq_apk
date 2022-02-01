import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment;

public class akrz
  implements MediaPlayer.OnCompletionListener
{
  public akrz(RedPacketKSongFragment paramRedPacketKSongFragment) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    RedPacketKSongFragment.a(this.a, false);
    paramMediaPlayer.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akrz
 * JD-Core Version:    0.7.0.1
 */