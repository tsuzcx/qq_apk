import com.tencent.mobileqq.hotpic.VideoBaseItem;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;

public class aeat
  implements TVK_IMediaPlayer.OnSeekCompleteListener
{
  public aeat(VideoBaseItem paramVideoBaseItem) {}
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.a.a.start();
    this.a.c = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeat
 * JD-Core Version:    0.7.0.1
 */