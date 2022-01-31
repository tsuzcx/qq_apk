import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.API.ArkAppMusicModule;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.music.QQPlayerService.QQPlayerCallback;
import com.tencent.mobileqq.music.SongInfo;

public final class aaqn
  implements QQPlayerService.QQPlayerCallback
{
  public String getToken()
  {
    return ArkAppMusicModule.a();
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo)
  {
    ArkAppCenter.a().post(new aaqp(this, paramSongInfo));
  }
  
  public void onPlayStateChanged(int paramInt)
  {
    ArkAppCenter.a().post(new aaqo(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaqn
 * JD-Core Version:    0.7.0.1
 */