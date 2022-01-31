import android.media.MediaPlayer;
import com.tencent.mobileqq.shortvideo.util.SimpleAudioPlayer;
import com.tencent.sveffects.Logger;
import com.tencent.sveffects.SdkContext;

public class aiea
  extends Thread
{
  private aiea(SimpleAudioPlayer paramSimpleAudioPlayer) {}
  
  public void run()
  {
    if (SdkContext.a().a().a()) {
      SdkContext.a().a().d("SimpleAudioPlayer", "playSimpleAudio " + SimpleAudioPlayer.a(this.a));
    }
    try
    {
      if (SimpleAudioPlayer.a(this.a) != SimpleAudioPlayer.a) {
        SimpleAudioPlayer.a(this.a).setAudioStreamType(SimpleAudioPlayer.a(this.a));
      }
      SimpleAudioPlayer.a(this.a).prepare();
      SimpleAudioPlayer.a(this.a).start();
      if (SimpleAudioPlayer.b(this.a) > 0) {
        SimpleAudioPlayer.a(this.a).seekTo(SimpleAudioPlayer.b(this.a));
      }
      return;
    }
    catch (Exception localException)
    {
      SdkContext.a().a().a("SimpleAudioPlayer", "playSimpleAudio " + SimpleAudioPlayer.a(this.a) + "error: " + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aiea
 * JD-Core Version:    0.7.0.1
 */