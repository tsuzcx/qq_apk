import com.tencent.mobileqq.hotpic.VideoBaseItem;
import com.tencent.mobileqq.hotpic.VideoBaseItem.OnInnerStateChangeListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;

public class adsj
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  public adsj(VideoBaseItem paramVideoBaseItem) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.a.jdField_a_of_type_Boolean = false;
    VideoBaseItem.a(this.a, true);
    if (this.a.c == 3) {}
    do
    {
      return;
      this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      this.a.c = 2;
    } while (VideoBaseItem.a(this.a) == null);
    VideoBaseItem.a(this.a).j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adsj
 * JD-Core Version:    0.7.0.1
 */