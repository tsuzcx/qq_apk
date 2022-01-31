import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;

public class ahhp
  implements TVK_IMediaPlayer.OnErrorListener
{
  public ahhp(SpringHbVideoView paramSpringHbVideoView) {}
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    QLog.i("springHb_SpringHbVideoView", 1, String.format("TVK_IMediaPlayer.onError model=%s what=%s position=%s detailInfo=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString }));
    if (SpringHbVideoView.a(this.a) != null) {
      SpringHbVideoView.a(this.a).a(paramInt2, paramInt3, paramString, paramObject);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahhp
 * JD-Core Version:    0.7.0.1
 */