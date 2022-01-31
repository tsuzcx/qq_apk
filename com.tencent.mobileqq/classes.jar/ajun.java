import android.os.Handler;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;

public class ajun
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  public ajun(HealthBusinessPlugin paramHealthBusinessPlugin) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HealthBusinessPlugin", 2, "onVideoPrepared video");
    }
    if (this.a.jdField_a_of_type_Boolean)
    {
      paramTVK_IMediaPlayer.pause();
      this.a.jdField_a_of_type_AndroidOsHandler.post(this.a.b);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 1000L);
      return;
      paramTVK_IMediaPlayer.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajun
 * JD-Core Version:    0.7.0.1
 */