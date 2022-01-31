import com.tencent.mobileqq.hotpic.VideoBaseItem;
import com.tencent.mobileqq.hotpic.VideoBaseItem.OnInnerStateChangeListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;

public class adij
  implements TVK_IMediaPlayer.OnErrorListener
{
  public adij(VideoBaseItem paramVideoBaseItem) {}
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    this.a.c = 7;
    if (VideoBaseItem.a(this.a) != null) {
      VideoBaseItem.a(this.a).a(this.a.b, paramTVK_IMediaPlayer, paramInt1, paramInt2, paramInt3, paramString, paramObject);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adij
 * JD-Core Version:    0.7.0.1
 */