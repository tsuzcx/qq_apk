import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.API.ArkAppMusicModule;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.qphone.base.util.BaseApplication;

public class aaji
  implements Runnable
{
  public aaji(ArkAppMusicModule paramArkAppMusicModule, SongInfo paramSongInfo) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity instanceof FragmentActivity))
    {
      QQPlayerService.a(new Intent(BaseApplication.getContext(), MusicPlayerActivity.class));
      QQPlayerService.a(101);
      QQPlayerService.a(localBaseActivity, ArkAppMusicModule.a(), new SongInfo[] { this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaji
 * JD-Core Version:    0.7.0.1
 */