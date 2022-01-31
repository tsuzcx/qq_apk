import android.os.Handler;
import com.tencent.mobileqq.hotpic.VideoBaseItem;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

public class aeap
  implements TVK_IMediaPlayer.OnCompletionListener
{
  public aeap(VideoBaseItem paramVideoBaseItem) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    VideoBaseItem.a(this.a).post(new aeaq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeap
 * JD-Core Version:    0.7.0.1
 */