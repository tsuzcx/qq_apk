import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicpendant.MusicPendantListener;
import com.tencent.mobileqq.musicpendant.MusicPendantManager;
import com.tencent.mobileqq.widget.MusicPendantView;
import com.tencent.qphone.base.util.QLog;

public class alcn
  implements MusicPendantListener
{
  public alcn(MusicPendantView paramMusicPendantView) {}
  
  public void a()
  {
    try
    {
      MusicPendantManager.a().b(this);
      if (MusicPendantView.a(this.a) != null)
      {
        MusicPendantView.a(this.a).removeCallbacksAndMessages(null);
        MusicPendantView.a(this.a).removeMessages(0);
        MusicPendantView.a(this.a, null);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MusicPendantView", 1, "onDestroy() exception", localException);
    }
  }
  
  public void a(int paramInt)
  {
    if (MusicPendantView.a(this.a) != null)
    {
      Message localMessage = MusicPendantView.a(this.a).obtainMessage(1003);
      localMessage.arg1 = paramInt;
      localMessage.sendToTarget();
    }
  }
  
  public void a(Card paramCard)
  {
    try
    {
      this.a.a(paramCard);
      return;
    }
    catch (Exception paramCard)
    {
      QLog.e("MusicPendantView", 1, "onMusicPendantSongsChanged() exception", paramCard);
    }
  }
  
  public void a(SongInfo paramSongInfo)
  {
    if (MusicPendantView.a(this.a) != null)
    {
      Message localMessage = MusicPendantView.a(this.a).obtainMessage(1004);
      localMessage.obj = paramSongInfo;
      localMessage.sendToTarget();
    }
  }
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void b(Card paramCard)
  {
    try
    {
      this.a.a(paramCard);
      return;
    }
    catch (Exception paramCard)
    {
      QLog.e("MusicPendantView", 1, "onUpdateCard() exception", paramCard);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alcn
 * JD-Core Version:    0.7.0.1
 */