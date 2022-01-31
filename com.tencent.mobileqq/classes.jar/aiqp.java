import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.os.Handler;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.qphone.base.util.QLog;

class aiqp
  implements MediaPlayer.OnSeekCompleteListener
{
  aiqp(aiqo paramaiqo) {}
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    try
    {
      this.a.a.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      this.a.a.g = true;
      this.a.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.a, 33L);
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VideoSprite", 2, "playVideo: " + QLog.getStackTraceString(paramMediaPlayer));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiqp
 * JD-Core Version:    0.7.0.1
 */