import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService.IGetTotalTime;

class acsd
  implements MediaPlayer.OnPreparedListener
{
  acsd(acsc paramacsc, MediaPlayer paramMediaPlayer) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    int i = this.jdField_a_of_type_AndroidMediaMediaPlayer.getDuration();
    this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
    this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
    this.jdField_a_of_type_Acsc.a.a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acsd
 * JD-Core Version:    0.7.0.1
 */