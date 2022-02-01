import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment;

public class akyp
  implements MediaPlayer.OnCompletionListener
{
  public akyp(RedPacketKSongFragment paramRedPacketKSongFragment) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    RedPacketKSongFragment.a(this.a, false);
    paramMediaPlayer.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akyp
 * JD-Core Version:    0.7.0.1
 */