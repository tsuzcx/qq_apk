import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnErrorListener;
import com.tencent.mobileqq.ar.config.SplashPopupWin;
import com.tencent.qphone.base.util.QLog;

public class aaqn
  implements IMediaPlayer.OnErrorListener
{
  public aaqn(SplashPopupWin paramSplashPopupWin) {}
  
  public boolean a(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    QLog.w("WorldCupMgr", 1, "SplashPopupWin.onError, what[" + paramInt1 + "], extra[" + paramInt2 + "]");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaqn
 * JD-Core Version:    0.7.0.1
 */