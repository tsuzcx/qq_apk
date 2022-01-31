import com.tencent.mobileqq.hotpic.VideoBaseItem;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;

public class adil
  implements TVK_IMediaPlayer.OnSeekCompleteListener
{
  public adil(VideoBaseItem paramVideoBaseItem) {}
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.a.a.start();
    this.a.c = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adil
 * JD-Core Version:    0.7.0.1
 */