import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.IQQPlayerCallback.Stub;
import com.tencent.mobileqq.music.IQQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.mobileqq.musicgene.MusicPlayerHandler;
import java.util.HashMap;

public class adxo
  extends IQQPlayerCallback.Stub
{
  public adxo(MusicPlayerActivity paramMusicPlayerActivity) {}
  
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
      localObject = (adxt)MusicPlayerActivity.b().get(localObject);
      paramSongInfo = MusicPlayerActivity.a(this.a, MusicPlayerActivity.a(this.a), paramSongInfo, ((adxt)localObject).a);
      MusicPlayerActivity.a(this.a, (adxt)localObject, paramSongInfo);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adxo
 * JD-Core Version:    0.7.0.1
 */