import android.os.Handler;
import com.tencent.mobileqq.hotpic.VideoBaseItem;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

public class adih
  implements TVK_IMediaPlayer.OnCompletionListener
{
  public adih(VideoBaseItem paramVideoBaseItem) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    VideoBaseItem.a(this.a).post(new adii(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adih
 * JD-Core Version:    0.7.0.1
 */