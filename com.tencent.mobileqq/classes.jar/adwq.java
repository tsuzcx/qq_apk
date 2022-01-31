import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.QQPlayerService.QQPlayerCallback;
import com.tencent.mobileqq.music.SongInfo;

public class adwq
  implements Runnable
{
  public adwq(QQPlayerService paramQQPlayerService, QQPlayerService.QQPlayerCallback paramQQPlayerCallback, SongInfo paramSongInfo) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$QQPlayerCallback.onPlaySongChanged(this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adwq
 * JD-Core Version:    0.7.0.1
 */