import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.IQQPlayerCallback.Stub;
import com.tencent.mobileqq.music.IQQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.mobileqq.musicgene.MusicPlayerHandler;
import java.util.HashMap;

public class aeku
  extends IQQPlayerCallback.Stub
{
  public aeku(MusicPlayerActivity paramMusicPlayerActivity) {}
  
  public void a(int paramInt)
  {
    Message.obtain(MusicPlayerActivity.a(this.a), 50, paramInt, 0).sendToTarget();
  }
  
  public void a(SongInfo paramSongInfo)
  {
    if (paramSongInfo != null)
    {
      localObject = MusicPlayerActivity.a(this.a, paramSongInfo);
      if (!MusicPlayerActivity.b().containsKey(localObject)) {
        break label64;
      }
      localObject = (aekz)MusicPlayerActivity.b().get(localObject);
      paramSongInfo = MusicPlayerActivity.a(this.a, MusicPlayerActivity.a(this.a), paramSongInfo, ((aekz)localObject).a);
      MusicPlayerActivity.a(this.a, (aekz)localObject, paramSongInfo);
    }
    label64:
    while (MusicPlayerActivity.a().containsKey(localObject)) {
      return;
    }
    Object localObject = MusicPlayerActivity.a(this.a);
    if (localObject != null) {}
    for (int i = ((IQQPlayerService)localObject).c();; i = 0)
    {
      localObject = MusicPlayerActivity.a(this.a, MusicPlayerActivity.a(this.a), paramSongInfo, -1L);
      MusicPlayerActivity.a(this.a, paramSongInfo.b, paramSongInfo.g, paramSongInfo.d, (String)localObject, false, false);
      MusicPlayerActivity.a(this.a).a(this.a.app.getLongAccountUin(), paramSongInfo.b, paramSongInfo.g, paramSongInfo.f, String.valueOf(paramSongInfo.a), paramSongInfo.c, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeku
 * JD-Core Version:    0.7.0.1
 */