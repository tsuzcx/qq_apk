import com.tencent.mobileqq.music.QQPlayerService.QQPlayerCallback;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicpendant.MusicPendantListener;
import com.tencent.mobileqq.musicpendant.MusicPendantManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class aetk
  implements QQPlayerService.QQPlayerCallback
{
  public aetk(MusicPendantManager paramMusicPendantManager) {}
  
  public String getToken()
  {
    return MusicPendantManager.a();
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo)
  {
    try
    {
      Iterator localIterator = MusicPendantManager.a().iterator();
      while (localIterator.hasNext())
      {
        MusicPendantListener localMusicPendantListener = (MusicPendantListener)((WeakReference)localIterator.next()).get();
        if (localMusicPendantListener != null) {
          localMusicPendantListener.a(paramSongInfo);
        }
      }
      return;
    }
    catch (Exception paramSongInfo)
    {
      paramSongInfo.printStackTrace();
    }
  }
  
  public void onPlayStateChanged(int paramInt)
  {
    try
    {
      Iterator localIterator = MusicPendantManager.a().iterator();
      while (localIterator.hasNext())
      {
        MusicPendantListener localMusicPendantListener = (MusicPendantListener)((WeakReference)localIterator.next()).get();
        if (localMusicPendantListener != null) {
          localMusicPendantListener.a(paramInt);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aetk
 * JD-Core Version:    0.7.0.1
 */